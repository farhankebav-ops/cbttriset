package okhttp3;

import androidx.webkit.ProxyConfig;
import com.ironsource.G5;
import com.vungle.ads.internal.protos.Sdk;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.t;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okhttp3.internal.url._UrlKt;
import r2.q;
import r5.m;
import r5.n;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpUrl {
    public static final Companion Companion = new Companion(null);
    private final String fragment;
    private final String host;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private String encodedFragment;
        private List<String> encodedQueryNamesAndValues;
        private String host;
        private String scheme;
        private String encodedUsername = "";
        private String encodedPassword = "";
        private int port = -1;
        private final List<String> encodedPathSegments = m.I0("");

        private final int effectivePort() {
            int i2 = this.port;
            if (i2 != -1) {
                return i2;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            k.b(str);
            return companion.defaultPort(str);
        }

        private final boolean isDot(String str) {
            return k.a(str, ".") || t.g0(str, "%2e");
        }

        private final boolean isDotDot(String str) {
            return k.a(str, "..") || t.g0(str, "%2e.") || t.g0(str, ".%2e") || t.g0(str, "%2e%2e");
        }

        private final int parsePort(String str, int i2, int i8) {
            int i9;
            try {
                i9 = Integer.parseInt(_UrlKt.canonicalize$default(str, i2, i8, "", false, false, false, false, 120, null));
            } catch (NumberFormatException unused) {
            }
            if (1 > i9 || i9 >= 65536) {
                return -1;
            }
            return i9;
        }

        private final void pop() {
            if (this.encodedPathSegments.remove(r0.size() - 1).length() != 0 || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            } else {
                this.encodedPathSegments.set(r0.size() - 1, "");
            }
        }

        private final int portColonOffset(String str, int i2, int i8) {
            while (i2 < i8) {
                char cCharAt = str.charAt(i2);
                if (cCharAt == ':') {
                    return i2;
                }
                if (cCharAt == '[') {
                    do {
                        i2++;
                        if (i2 < i8) {
                        }
                    } while (str.charAt(i2) != ']');
                }
                i2++;
            }
            return i8;
        }

        private final void push(String str, int i2, int i8, boolean z2, boolean z7) {
            String strCanonicalize$default = _UrlKt.canonicalize$default(str, i2, i8, _UrlKt.PATH_SEGMENT_ENCODE_SET, z7, false, false, false, 112, null);
            if (isDot(strCanonicalize$default)) {
                return;
            }
            if (isDotDot(strCanonicalize$default)) {
                pop();
                return;
            }
            if (this.encodedPathSegments.get(r12.size() - 1).length() == 0) {
                this.encodedPathSegments.set(r12.size() - 1, strCanonicalize$default);
            } else {
                this.encodedPathSegments.add(strCanonicalize$default);
            }
            if (z2) {
                this.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            k.b(list);
            int size = list.size() - 2;
            int iA = z5.b.a(size, 0, -2);
            if (iA > size) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                k.b(list2);
                if (k.a(str, list2.get(size))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    k.b(list3);
                    list3.remove(size + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    k.b(list4);
                    list4.remove(size);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    k.b(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (size == iA) {
                    return;
                } else {
                    size -= 2;
                }
            }
        }

        private final void resolvePath(String str, int i2, int i8) {
            if (i2 == i8) {
                return;
            }
            char cCharAt = str.charAt(i2);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i2++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            int i9 = i2;
            while (i9 < i8) {
                int iDelimiterOffset = _UtilCommonKt.delimiterOffset(str, "/\\", i9, i8);
                boolean z2 = iDelimiterOffset < i8;
                String str2 = str;
                push(str2, i9, iDelimiterOffset, z2, true);
                if (z2) {
                    i9 = iDelimiterOffset + 1;
                    str = str2;
                } else {
                    str = str2;
                    i9 = iDelimiterOffset;
                }
            }
        }

        private final int schemeDelimiterOffset(String str, int i2, int i8) {
            if (i8 - i2 < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i2);
            if ((k.g(cCharAt, 97) >= 0 && k.g(cCharAt, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE) <= 0) || (k.g(cCharAt, 65) >= 0 && k.g(cCharAt, 90) <= 0)) {
                while (true) {
                    i2++;
                    if (i2 >= i8) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i2);
                    if ('a' > cCharAt2 || cCharAt2 >= '{') {
                        if ('A' > cCharAt2 || cCharAt2 >= '[') {
                            if ('0' > cCharAt2 || cCharAt2 >= ':') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private final int slashCount(String str, int i2, int i8) {
            int i9 = 0;
            while (i2 < i8) {
                char cCharAt = str.charAt(i2);
                if (cCharAt != '/' && cCharAt != '\\') {
                    break;
                }
                i9++;
                i2++;
            }
            return i9;
        }

        private final void toPathString(List<String> list, StringBuilder sb) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append('/');
                sb.append(list.get(i2));
            }
        }

        private final List<String> toQueryNamesAndValues(String str) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 <= str.length()) {
                int iX0 = n6.m.x0(str, '&', i2, 4);
                if (iX0 == -1) {
                    iX0 = str.length();
                }
                int iX02 = n6.m.x0(str, G5.T, i2, 4);
                if (iX02 == -1 || iX02 > iX0) {
                    String strSubstring = str.substring(i2, iX0);
                    k.d(strSubstring, "substring(...)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i2, iX02);
                    k.d(strSubstring2, "substring(...)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iX02 + 1, iX0);
                    k.d(strSubstring3, "substring(...)");
                    arrayList.add(strSubstring3);
                }
                i2 = iX0 + 1;
            }
            return arrayList;
        }

        public final Builder addEncodedPathSegment(String encodedPathSegment) {
            k.e(encodedPathSegment, "encodedPathSegment");
            push(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String encodedPathSegments) {
            k.e(encodedPathSegments, "encodedPathSegments");
            return addPathSegments(encodedPathSegments, true);
        }

        public final Builder addEncodedQueryParameter(String encodedName, String str) {
            k.e(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            k.b(list);
            list.add(_UrlKt.canonicalize$default(encodedName, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            k.b(list2);
            list2.add(str != null ? _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null) : null);
            return this;
        }

        public final Builder addPathSegment(String pathSegment) {
            k.e(pathSegment, "pathSegment");
            push(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String pathSegments) {
            k.e(pathSegments, "pathSegments");
            return addPathSegments(pathSegments, false);
        }

        public final Builder addQueryParameter(String name, String str) {
            k.e(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            k.b(list);
            list.add(_UrlKt.canonicalize$default(name, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            k.b(list2);
            list2.add(str != null ? _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null) : null);
            return this;
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            String strPercentDecode$default = _UrlKt.percentDecode$default(this.encodedUsername, 0, 0, false, 7, null);
            String strPercentDecode$default2 = _UrlKt.percentDecode$default(this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iEffectivePort = effectivePort();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(n.L0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(_UrlKt.percentDecode$default((String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                ArrayList arrayList3 = new ArrayList(n.L0(list2, 10));
                for (String str3 : list2) {
                    arrayList3.add(str3 != null ? _UrlKt.percentDecode$default(str3, 0, 0, true, 3, null) : null);
                }
                arrayList = arrayList3;
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, strPercentDecode$default, strPercentDecode$default2, str2, iEffectivePort, arrayList2, arrayList, str4 != null ? _UrlKt.percentDecode$default(str4, 0, 0, false, 7, null) : null, toString(), null);
        }

        public final Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? _UrlKt.canonicalize$default(str, 0, 0, "", true, false, false, true, 51, null) : null;
            return this;
        }

        public final Builder encodedPassword(String encodedPassword) {
            k.e(encodedPassword, "encodedPassword");
            this.encodedPassword = _UrlKt.canonicalize$default(encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 115, null);
            return this;
        }

        public final Builder encodedPath(String encodedPath) {
            k.e(encodedPath, "encodedPath");
            if (!t.n0(encodedPath, "/", false)) {
                throw new IllegalArgumentException("unexpected encodedPath: ".concat(encodedPath).toString());
            }
            resolvePath(encodedPath, 0, encodedPath.length());
            return this;
        }

        public final Builder encodedQuery(String str) {
            String strCanonicalize$default;
            this.encodedQueryNamesAndValues = (str == null || (strCanonicalize$default = _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_ENCODE_SET, true, false, true, false, 83, null)) == null) ? null : toQueryNamesAndValues(strCanonicalize$default);
            return this;
        }

        public final Builder encodedUsername(String encodedUsername) {
            k.e(encodedUsername, "encodedUsername");
            this.encodedUsername = _UrlKt.canonicalize$default(encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 115, null);
            return this;
        }

        public final Builder fragment(String str) {
            this.encodedFragment = str != null ? _UrlKt.canonicalize$default(str, 0, 0, "", false, false, false, true, 59, null) : null;
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String host) {
            k.e(host, "host");
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(host, 0, 0, false, 7, null));
            if (canonicalHost == null) {
                throw new IllegalArgumentException("unexpected host: ".concat(host));
            }
            this.host = canonicalHost;
            return this;
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String str) {
            int iDelimiterOffset;
            boolean z2;
            int i2;
            int i8;
            char c7;
            String input = str;
            k.e(input, "input");
            int iIndexOfFirstNonAsciiWhitespace$default = _UtilCommonKt.indexOfFirstNonAsciiWhitespace$default(input, 0, 0, 3, null);
            int iIndexOfLastNonAsciiWhitespace$default = _UtilCommonKt.indexOfLastNonAsciiWhitespace$default(input, iIndexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            int iSchemeDelimiterOffset = schemeDelimiterOffset(input, iIndexOfFirstNonAsciiWhitespace$default, iIndexOfLastNonAsciiWhitespace$default);
            boolean z7 = true;
            if (iSchemeDelimiterOffset != -1) {
                if (t.m0(input, "https:", iIndexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "https";
                    iIndexOfFirstNonAsciiWhitespace$default += 6;
                } else {
                    if (!t.m0(input, "http:", iIndexOfFirstNonAsciiWhitespace$default, true)) {
                        StringBuilder sb = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = input.substring(0, iSchemeDelimiterOffset);
                        k.d(strSubstring, "substring(...)");
                        sb.append(strSubstring);
                        sb.append('\'');
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.scheme = ProxyConfig.MATCH_HTTP;
                    iIndexOfFirstNonAsciiWhitespace$default += 5;
                }
            } else {
                if (httpUrl == null) {
                    if (input.length() > 6) {
                        input = n6.m.S0(6, input).concat("...");
                    }
                    throw new IllegalArgumentException(a1.a.l("Expected URL scheme 'http' or 'https' but no scheme was found for ", input));
                }
                this.scheme = httpUrl.scheme();
            }
            int iSlashCount = slashCount(input, iIndexOfFirstNonAsciiWhitespace$default, iIndexOfLastNonAsciiWhitespace$default);
            char c8 = '?';
            char c9 = '#';
            if (iSlashCount >= 2 || httpUrl == null || !k.a(httpUrl.scheme(), this.scheme)) {
                boolean z8 = false;
                boolean z9 = false;
                int i9 = iIndexOfFirstNonAsciiWhitespace$default + iSlashCount;
                while (true) {
                    iDelimiterOffset = _UtilCommonKt.delimiterOffset(input, "@/\\?#", i9, iIndexOfLastNonAsciiWhitespace$default);
                    byte bCharAt = iDelimiterOffset != iIndexOfLastNonAsciiWhitespace$default ? input.charAt(iDelimiterOffset) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c9 || bCharAt == 47 || bCharAt == 92 || bCharAt == c8) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z8) {
                            z2 = z7;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            input = str;
                            i2 = iDelimiterOffset;
                            sb2.append(_UrlKt.canonicalize$default(input, i9, iDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null));
                            this.encodedPassword = sb2.toString();
                        } else {
                            int iDelimiterOffset2 = _UtilCommonKt.delimiterOffset(input, ':', i9, iDelimiterOffset);
                            z2 = z7;
                            String strCanonicalize$default = _UrlKt.canonicalize$default(input, i9, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null);
                            if (z9) {
                                strCanonicalize$default = a1.a.s(new StringBuilder(), this.encodedUsername, "%40", strCanonicalize$default);
                            }
                            this.encodedUsername = strCanonicalize$default;
                            if (iDelimiterOffset2 != iDelimiterOffset) {
                                i8 = iDelimiterOffset;
                                this.encodedPassword = _UrlKt.canonicalize$default(str, iDelimiterOffset2 + 1, i8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null);
                                z8 = z2;
                            } else {
                                i8 = iDelimiterOffset;
                            }
                            input = str;
                            i2 = i8;
                            z9 = z2;
                        }
                        i9 = i2 + 1;
                        z7 = z2;
                        c9 = '#';
                        c8 = '?';
                    }
                }
                int iPortColonOffset = portColonOffset(input, i9, iDelimiterOffset);
                int i10 = iPortColonOffset + 1;
                if (i10 < iDelimiterOffset) {
                    this.host = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(input, i9, iPortColonOffset, false, 4, null));
                    int port = parsePort(input, i10, iDelimiterOffset);
                    this.port = port;
                    if (port == -1) {
                        StringBuilder sb3 = new StringBuilder("Invalid URL port: \"");
                        String strSubstring2 = input.substring(i10, iDelimiterOffset);
                        k.d(strSubstring2, "substring(...)");
                        sb3.append(strSubstring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                } else {
                    this.host = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(input, i9, iPortColonOffset, false, 4, null));
                    Companion companion = HttpUrl.Companion;
                    String str2 = this.scheme;
                    k.b(str2);
                    this.port = companion.defaultPort(str2);
                }
                if (this.host == null) {
                    StringBuilder sb4 = new StringBuilder("Invalid URL host: \"");
                    String strSubstring3 = input.substring(i9, iPortColonOffset);
                    k.d(strSubstring3, "substring(...)");
                    sb4.append(strSubstring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                iIndexOfFirstNonAsciiWhitespace$default = iDelimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (iIndexOfFirstNonAsciiWhitespace$default == iIndexOfLastNonAsciiWhitespace$default || input.charAt(iIndexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
            }
            int iDelimiterOffset3 = _UtilCommonKt.delimiterOffset(input, "?#", iIndexOfFirstNonAsciiWhitespace$default, iIndexOfLastNonAsciiWhitespace$default);
            resolvePath(input, iIndexOfFirstNonAsciiWhitespace$default, iDelimiterOffset3);
            if (iDelimiterOffset3 >= iIndexOfLastNonAsciiWhitespace$default || input.charAt(iDelimiterOffset3) != '?') {
                c7 = '#';
            } else {
                c7 = '#';
                int iDelimiterOffset4 = _UtilCommonKt.delimiterOffset(input, '#', iDelimiterOffset3, iIndexOfLastNonAsciiWhitespace$default);
                this.encodedQueryNamesAndValues = toQueryNamesAndValues(_UrlKt.canonicalize$default(input, iDelimiterOffset3 + 1, iDelimiterOffset4, _UrlKt.QUERY_ENCODE_SET, true, false, true, false, 80, null));
                iDelimiterOffset3 = iDelimiterOffset4;
            }
            if (iDelimiterOffset3 < iIndexOfLastNonAsciiWhitespace$default && input.charAt(iDelimiterOffset3) == c7) {
                this.encodedFragment = _UrlKt.canonicalize$default(input, iDelimiterOffset3 + 1, iIndexOfLastNonAsciiWhitespace$default, "", true, false, false, true, 48, null);
            }
            return this;
        }

        public final Builder password(String password) {
            k.e(password, "password");
            this.encodedPassword = _UrlKt.canonicalize$default(password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, null);
            return this;
        }

        public final Builder port(int i2) {
            if (1 > i2 || i2 >= 65536) {
                throw new IllegalArgumentException(a1.a.g(i2, "unexpected port: ").toString());
            }
            this.port = i2;
            return this;
        }

        public final Builder query(String str) {
            String strCanonicalize$default;
            this.encodedQueryNamesAndValues = (str == null || (strCanonicalize$default = _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_ENCODE_SET, false, false, true, false, 91, null)) == null) ? null : toQueryNamesAndValues(strCanonicalize$default);
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String strReplaceAll;
            String str = this.host;
            if (str != null) {
                Pattern patternCompile = Pattern.compile("[\"<>^`{|}]");
                k.d(patternCompile, "compile(...)");
                strReplaceAll = patternCompile.matcher(str).replaceAll("");
                k.d(strReplaceAll, "replaceAll(...)");
            } else {
                strReplaceAll = null;
            }
            this.host = strReplaceAll;
            int size = this.encodedPathSegments.size();
            for (int i2 = 0; i2 < size; i2++) {
                List<String> list = this.encodedPathSegments;
                list.set(i2, _UrlKt.canonicalize$default(list.get(i2), 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, 99, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    String str2 = list2.get(i8);
                    list2.set(i8, str2 != null ? _UrlKt.canonicalize$default(str2, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, 67, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null ? _UrlKt.canonicalize$default(str3, 0, 0, _UrlKt.FRAGMENT_ENCODE_SET_URI, true, true, false, true, 35, null) : null;
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String encodedName) {
            k.e(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(_UrlKt.canonicalize$default(encodedName, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null));
            return this;
        }

        public final Builder removeAllQueryParameters(String name) {
            k.e(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(_UrlKt.canonicalize$default(name, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null));
            return this;
        }

        public final Builder removePathSegment(int i2) {
            this.encodedPathSegments.remove(i2);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public final Builder scheme(String scheme) {
            k.e(scheme, "scheme");
            if (scheme.equalsIgnoreCase(ProxyConfig.MATCH_HTTP)) {
                this.scheme = ProxyConfig.MATCH_HTTP;
                return this;
            }
            if (!scheme.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(scheme));
            }
            this.scheme = "https";
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            k.e(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final Builder setEncodedPathSegment(int i2, String encodedPathSegment) {
            k.e(encodedPathSegment, "encodedPathSegment");
            String strCanonicalize$default = _UrlKt.canonicalize$default(encodedPathSegment, 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET, true, false, false, false, 115, null);
            this.encodedPathSegments.set(i2, strCanonicalize$default);
            if (isDot(strCanonicalize$default) || isDotDot(strCanonicalize$default)) {
                throw new IllegalArgumentException("unexpected path segment: ".concat(encodedPathSegment).toString());
            }
            return this;
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final Builder setEncodedQueryParameter(String encodedName, String str) {
            k.e(encodedName, "encodedName");
            removeAllEncodedQueryParameters(encodedName);
            addEncodedQueryParameter(encodedName, str);
            return this;
        }

        public final void setEncodedUsername$okhttp(String str) {
            k.e(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final Builder setPathSegment(int i2, String pathSegment) {
            k.e(pathSegment, "pathSegment");
            String strCanonicalize$default = _UrlKt.canonicalize$default(pathSegment, 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET, false, false, false, false, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, null);
            if (isDot(strCanonicalize$default) || isDotDot(strCanonicalize$default)) {
                throw new IllegalArgumentException("unexpected path segment: ".concat(pathSegment).toString());
            }
            this.encodedPathSegments.set(i2, strCanonicalize$default);
            return this;
        }

        public final void setPort$okhttp(int i2) {
            this.port = i2;
        }

        public final Builder setQueryParameter(String name, String str) {
            k.e(name, "name");
            removeAllQueryParameters(name);
            addQueryParameter(name, str);
            return this;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                if (n6.m.r0(str2, ':')) {
                    sb.append('[');
                    sb.append(this.host);
                    sb.append(']');
                } else {
                    sb.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int iEffectivePort = effectivePort();
                String str3 = this.scheme;
                if (str3 == null || iEffectivePort != HttpUrl.Companion.defaultPort(str3)) {
                    sb.append(':');
                    sb.append(iEffectivePort);
                }
            }
            toPathString(this.encodedPathSegments, sb);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                Companion companion = HttpUrl.Companion;
                List<String> list = this.encodedQueryNamesAndValues;
                k.b(list);
                companion.toQueryString(list, sb);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }

        public final Builder username(String username) {
            k.e(username, "username");
            this.encodedUsername = _UrlKt.canonicalize$default(username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, null);
            return this;
        }

        private final Builder addPathSegments(String str, boolean z2) {
            boolean z7;
            Builder builder;
            String str2;
            boolean z8;
            int i2 = 0;
            while (true) {
                int iDelimiterOffset = _UtilCommonKt.delimiterOffset(str, "/\\", i2, str.length());
                if (iDelimiterOffset < str.length()) {
                    z7 = true;
                    str2 = str;
                    z8 = z2;
                    builder = this;
                } else {
                    z7 = false;
                    builder = this;
                    str2 = str;
                    z8 = z2;
                }
                builder.push(str2, i2, iDelimiterOffset, z7, z8);
                i2 = iDelimiterOffset + 1;
                if (i2 > str2.length()) {
                    return builder;
                }
                str = str2;
                z2 = z8;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void toQueryString(List<String> list, StringBuilder sb) {
            k6.b bVarW0 = q.w0(q.D0(0, list.size()), 2);
            int i2 = bVarW0.f12709a;
            int i8 = bVarW0.f12710b;
            int i9 = bVarW0.f12711c;
            if ((i9 <= 0 || i2 > i8) && (i9 >= 0 || i8 > i2)) {
                return;
            }
            while (true) {
                String str = list.get(i2);
                String str2 = list.get(i2 + 1);
                if (i2 > 0) {
                    sb.append('&');
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append(G5.T);
                    sb.append(str2);
                }
                if (i2 == i8) {
                    return;
                } else {
                    i2 += i9;
                }
            }
        }

        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m3530deprecated_get(String url) {
            k.e(url, "url");
            return get(url);
        }

        /* JADX INFO: renamed from: -deprecated_parse, reason: not valid java name */
        public final HttpUrl m3533deprecated_parse(String url) {
            k.e(url, "url");
            return parse(url);
        }

        public final int defaultPort(String scheme) {
            k.e(scheme, "scheme");
            if (scheme.equals(ProxyConfig.MATCH_HTTP)) {
                return 80;
            }
            return scheme.equals("https") ? 443 : -1;
        }

        public final HttpUrl get(String str) {
            k.e(str, "<this>");
            return new Builder().parse$okhttp(null, str).build();
        }

        public final HttpUrl parse(String str) {
            k.e(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m3532deprecated_get(URL url) {
            k.e(url, "url");
            return get(url);
        }

        public final HttpUrl get(URL url) {
            k.e(url, "<this>");
            String string = url.toString();
            k.d(string, "toString(...)");
            return parse(string);
        }

        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m3531deprecated_get(URI uri) {
            k.e(uri, "uri");
            return get(uri);
        }

        public final HttpUrl get(URI uri) {
            k.e(uri, "<this>");
            String string = uri.toString();
            k.d(string, "toString(...)");
            return parse(string);
        }
    }

    public /* synthetic */ HttpUrl(String str, String str2, String str3, String str4, int i2, List list, List list2, String str5, String str6, f fVar) {
        this(str, str2, str3, str4, i2, list, list2, str5, str6);
    }

    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    /* JADX INFO: renamed from: -deprecated_encodedFragment, reason: not valid java name */
    public final String m3511deprecated_encodedFragment() {
        return encodedFragment();
    }

    /* JADX INFO: renamed from: -deprecated_encodedPassword, reason: not valid java name */
    public final String m3512deprecated_encodedPassword() {
        return encodedPassword();
    }

    /* JADX INFO: renamed from: -deprecated_encodedPath, reason: not valid java name */
    public final String m3513deprecated_encodedPath() {
        return encodedPath();
    }

    /* JADX INFO: renamed from: -deprecated_encodedPathSegments, reason: not valid java name */
    public final List<String> m3514deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    /* JADX INFO: renamed from: -deprecated_encodedQuery, reason: not valid java name */
    public final String m3515deprecated_encodedQuery() {
        return encodedQuery();
    }

    /* JADX INFO: renamed from: -deprecated_encodedUsername, reason: not valid java name */
    public final String m3516deprecated_encodedUsername() {
        return encodedUsername();
    }

    /* JADX INFO: renamed from: -deprecated_fragment, reason: not valid java name */
    public final String m3517deprecated_fragment() {
        return this.fragment;
    }

    /* JADX INFO: renamed from: -deprecated_host, reason: not valid java name */
    public final String m3518deprecated_host() {
        return this.host;
    }

    /* JADX INFO: renamed from: -deprecated_password, reason: not valid java name */
    public final String m3519deprecated_password() {
        return this.password;
    }

    /* JADX INFO: renamed from: -deprecated_pathSegments, reason: not valid java name */
    public final List<String> m3520deprecated_pathSegments() {
        return this.pathSegments;
    }

    /* JADX INFO: renamed from: -deprecated_pathSize, reason: not valid java name */
    public final int m3521deprecated_pathSize() {
        return pathSize();
    }

    /* JADX INFO: renamed from: -deprecated_port, reason: not valid java name */
    public final int m3522deprecated_port() {
        return this.port;
    }

    /* JADX INFO: renamed from: -deprecated_query, reason: not valid java name */
    public final String m3523deprecated_query() {
        return query();
    }

    /* JADX INFO: renamed from: -deprecated_queryParameterNames, reason: not valid java name */
    public final Set<String> m3524deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    /* JADX INFO: renamed from: -deprecated_querySize, reason: not valid java name */
    public final int m3525deprecated_querySize() {
        return querySize();
    }

    /* JADX INFO: renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m3526deprecated_scheme() {
        return this.scheme;
    }

    /* JADX INFO: renamed from: -deprecated_uri, reason: not valid java name */
    public final URI m3527deprecated_uri() {
        return uri();
    }

    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final URL m3528deprecated_url() {
        return url();
    }

    /* JADX INFO: renamed from: -deprecated_username, reason: not valid java name */
    public final String m3529deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        String strSubstring = this.url.substring(n6.m.x0(this.url, '#', 0, 6) + 1);
        k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        String strSubstring = this.url.substring(n6.m.x0(this.url, ':', this.scheme.length() + 3, 4) + 1, n6.m.x0(this.url, '@', 0, 6));
        k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String encodedPath() {
        int iX0 = n6.m.x0(this.url, '/', this.scheme.length() + 3, 4);
        String str = this.url;
        String strSubstring = this.url.substring(iX0, _UtilCommonKt.delimiterOffset(str, "?#", iX0, str.length()));
        k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final List<String> encodedPathSegments() {
        int iX0 = n6.m.x0(this.url, '/', this.scheme.length() + 3, 4);
        String str = this.url;
        int iDelimiterOffset = _UtilCommonKt.delimiterOffset(str, "?#", iX0, str.length());
        ArrayList arrayList = new ArrayList();
        while (iX0 < iDelimiterOffset) {
            int i2 = iX0 + 1;
            int iDelimiterOffset2 = _UtilCommonKt.delimiterOffset(this.url, '/', i2, iDelimiterOffset);
            String strSubstring = this.url.substring(i2, iDelimiterOffset2);
            k.d(strSubstring, "substring(...)");
            arrayList.add(strSubstring);
            iX0 = iDelimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int iX0 = n6.m.x0(this.url, '?', 0, 6) + 1;
        String str = this.url;
        String strSubstring = this.url.substring(iX0, _UtilCommonKt.delimiterOffset(str, '#', iX0, str.length()));
        k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String strSubstring = this.url.substring(length, _UtilCommonKt.delimiterOffset(str, ":@", length, str.length()));
        k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && k.a(((HttpUrl) obj).url, this.url);
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return k.a(this.scheme, "https");
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    public final String queryParameter(String name) {
        k.e(name, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        k6.b bVarW0 = q.w0(q.D0(0, list.size()), 2);
        int i2 = bVarW0.f12709a;
        int i8 = bVarW0.f12710b;
        int i9 = bVarW0.f12711c;
        if ((i9 <= 0 || i2 > i8) && (i9 >= 0 || i8 > i2)) {
            return null;
        }
        while (!name.equals(this.queryNamesAndValues.get(i2))) {
            if (i2 == i8) {
                return null;
            }
            i2 += i9;
        }
        return this.queryNamesAndValues.get(i2 + 1);
    }

    public final String queryParameterName(int i2) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = list.get(i2 * 2);
        k.b(str);
        return str;
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return r5.t.f13640a;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.queryNamesAndValues.size() / 2, 1.0f);
        k6.b bVarW0 = q.w0(q.D0(0, this.queryNamesAndValues.size()), 2);
        int i2 = bVarW0.f12709a;
        int i8 = bVarW0.f12710b;
        int i9 = bVarW0.f12711c;
        if ((i9 > 0 && i2 <= i8) || (i9 < 0 && i8 <= i2)) {
            while (true) {
                String str = this.queryNamesAndValues.get(i2);
                k.b(str);
                linkedHashSet.add(str);
                if (i2 == i8) {
                    break;
                }
                i2 += i9;
            }
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        k.d(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }

    public final String queryParameterValue(int i2) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i2 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<String> queryParameterValues(String name) {
        k.e(name, "name");
        if (this.queryNamesAndValues == null) {
            return r.f13638a;
        }
        ArrayList arrayList = new ArrayList(4);
        k6.b bVarW0 = q.w0(q.D0(0, this.queryNamesAndValues.size()), 2);
        int i2 = bVarW0.f12709a;
        int i8 = bVarW0.f12710b;
        int i9 = bVarW0.f12711c;
        if ((i9 > 0 && i2 <= i8) || (i9 < 0 && i8 <= i2)) {
            while (true) {
                if (name.equals(this.queryNamesAndValues.get(i2))) {
                    arrayList.add(this.queryNamesAndValues.get(i2 + 1));
                }
                if (i2 == i8) {
                    break;
                }
                i2 += i9;
            }
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        k.d(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String redact() {
        Builder builderNewBuilder = newBuilder("/...");
        k.b(builderNewBuilder);
        return builderNewBuilder.username("").password("").build().toString();
    }

    public final HttpUrl resolve(String link) {
        k.e(link, "link");
        Builder builderNewBuilder = newBuilder(link);
        if (builderNewBuilder != null) {
            return builderNewBuilder.build();
        }
        return null;
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (_HostnamesCommonKt.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    public final URI uri() {
        String input = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(input);
        } catch (URISyntaxException e) {
            try {
                Pattern patternCompile = Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");
                k.d(patternCompile, "compile(...)");
                k.e(input, "input");
                String strReplaceAll = patternCompile.matcher(input).replaceAll("");
                k.d(strReplaceAll, "replaceAll(...)");
                URI uriCreate = URI.create(strReplaceAll);
                k.b(uriCreate);
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public final String username() {
        return this.username;
    }

    private HttpUrl(String str, String str2, String str3, String str4, int i2, List<String> list, List<String> list2, String str5, String str6) {
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i2;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = str5;
        this.url = str6;
    }

    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    public static final HttpUrl get(URL url) {
        return Companion.get(url);
    }

    public final Builder newBuilder(String link) {
        k.e(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
