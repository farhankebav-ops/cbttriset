package okhttp3;

import androidx.core.location.LocationRequestCompat;
import com.ironsource.C2300e4;
import com.ironsource.G5;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.m;
import n6.t;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http.DateFormattingKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final String sameSite;
    private final boolean secure;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private String domain;
        private long expiresAt;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private String path;
        private boolean persistent;
        private String sameSite;
        private boolean secure;
        private String value;

        public Builder() {
            this.expiresAt = DateFormattingKt.MAX_DATE;
            this.path = "/";
        }

        public final Cookie build() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new Cookie(str, str2, j, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, this.sameSite, null);
            }
            throw new NullPointerException("builder.domain == null");
        }

        public final Builder domain(String domain) {
            k.e(domain, "domain");
            return domain(domain, false);
        }

        public final Builder expiresAt(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > DateFormattingKt.MAX_DATE) {
                j = 253402300799999L;
            }
            this.expiresAt = j;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String domain) {
            k.e(domain, "domain");
            return domain(domain, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String name) {
            k.e(name, "name");
            if (!k.a(m.T0(name).toString(), name)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.name = name;
            return this;
        }

        public final Builder path(String path) {
            k.e(path, "path");
            if (!t.n0(path, "/", false)) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.path = path;
            return this;
        }

        public final Builder sameSite(String sameSite) {
            k.e(sameSite, "sameSite");
            if (!k.a(m.T0(sameSite).toString(), sameSite)) {
                throw new IllegalArgumentException("sameSite is not trimmed");
            }
            this.sameSite = sameSite;
            return this;
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String value) {
            k.e(value, "value");
            if (!k.a(m.T0(value).toString(), value)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.value = value;
            return this;
        }

        private final Builder domain(String str, boolean z2) {
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException(a1.a.l("unexpected domain: ", str));
            }
            this.domain = canonicalHost;
            this.hostOnly = z2;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Cookie cookie) {
            this();
            k.e(cookie, "cookie");
            this.name = cookie.name();
            this.value = cookie.value();
            this.expiresAt = cookie.expiresAt();
            this.domain = cookie.domain();
            this.path = cookie.path();
            this.secure = cookie.secure();
            this.httpOnly = cookie.httpOnly();
            this.persistent = cookie.persistent();
            this.hostOnly = cookie.hostOnly();
            this.sameSite = cookie.sameSite();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private final int dateCharacterOffset(String str, int i2, int i8, boolean z2) {
            while (i2 < i8) {
                char cCharAt = str.charAt(i2);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z2)) {
                    return i2;
                }
                i2++;
            }
            return i8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            return k.a(str, str2) || (t.f0(str, str2, false) && str.charAt((str.length() - str2.length()) - 1) == '.' && !_HostnamesCommonKt.canParseAsIpAddress(str));
        }

        private final String parseDomain(String str) {
            if (t.f0(str, ".", false)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(m.F0(str, "."));
            if (canonicalHost != null) {
                return canonicalHost;
            }
            throw new IllegalArgumentException();
        }

        private final long parseExpires(String str, int i2, int i8) {
            int iDateCharacterOffset = dateCharacterOffset(str, i2, i8, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int iY0 = -1;
            int i12 = -1;
            int i13 = -1;
            while (iDateCharacterOffset < i8) {
                int iDateCharacterOffset2 = dateCharacterOffset(str, iDateCharacterOffset + 1, i8, true);
                matcher.region(iDateCharacterOffset, iDateCharacterOffset2);
                if (i10 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String strGroup = matcher.group(1);
                    k.d(strGroup, "group(...)");
                    i10 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    k.d(strGroup2, "group(...)");
                    i12 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    k.d(strGroup3, "group(...)");
                    i13 = Integer.parseInt(strGroup3);
                } else if (i11 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String strGroup4 = matcher.group(1);
                    k.d(strGroup4, "group(...)");
                    i11 = Integer.parseInt(strGroup4);
                } else if (iY0 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String strGroup5 = matcher.group(1);
                    k.d(strGroup5, "group(...)");
                    Locale US = Locale.US;
                    k.d(US, "US");
                    String lowerCase = strGroup5.toLowerCase(US);
                    k.d(lowerCase, "toLowerCase(...)");
                    String strPattern = Cookie.MONTH_PATTERN.pattern();
                    k.d(strPattern, "pattern(...)");
                    iY0 = m.y0(strPattern, lowerCase, 0, false, 6) / 4;
                } else if (i9 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String strGroup6 = matcher.group(1);
                    k.d(strGroup6, "group(...)");
                    i9 = Integer.parseInt(strGroup6);
                }
                iDateCharacterOffset = dateCharacterOffset(str, iDateCharacterOffset2 + 1, i8, false);
            }
            if (70 <= i9 && i9 < 100) {
                i9 += 1900;
            }
            if (i9 >= 0 && i9 < 70) {
                i9 += 2000;
            }
            if (i9 < 1601) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (iY0 == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (1 > i11 || i11 >= 32) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i10 < 0 || i10 >= 24) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i12 < 0 || i12 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i13 < 0 || i13 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(_UtilJvmKt.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i9);
            gregorianCalendar.set(2, iY0 - 1);
            gregorianCalendar.set(5, i11);
            gregorianCalendar.set(11, i10);
            gregorianCalendar.set(12, i12);
            gregorianCalendar.set(13, i13);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long parseMaxAge(String input) {
            try {
                long j = Long.parseLong(input);
                if (j <= 0) {
                    return Long.MIN_VALUE;
                }
                return j;
            } catch (NumberFormatException e) {
                Pattern patternCompile = Pattern.compile("-?\\d+");
                k.d(patternCompile, "compile(...)");
                k.e(input, "input");
                if (!patternCompile.matcher(input).matches()) {
                    throw e;
                }
                if (t.n0(input, "-", false)) {
                    return Long.MIN_VALUE;
                }
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String strEncodedPath = httpUrl.encodedPath();
            if (k.a(strEncodedPath, str)) {
                return true;
            }
            return t.n0(strEncodedPath, str, false) && (t.f0(str, "/", false) || strEncodedPath.charAt(str.length()) == '/');
        }

        public final Cookie parse(HttpUrl url, String setCookie) {
            k.e(url, "url");
            k.e(setCookie, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        public final Cookie parse$okhttp(long j, HttpUrl url, String setCookie) {
            long j3;
            String str;
            k.e(url, "url");
            k.e(setCookie, "setCookie");
            int iDelimiterOffset$default = _UtilCommonKt.delimiterOffset$default(setCookie, ';', 0, 0, 6, (Object) null);
            int iDelimiterOffset$default2 = _UtilCommonKt.delimiterOffset$default(setCookie, G5.T, 0, iDelimiterOffset$default, 2, (Object) null);
            String domain = null;
            if (iDelimiterOffset$default2 != iDelimiterOffset$default) {
                String strTrimSubstring$default = _UtilCommonKt.trimSubstring$default(setCookie, 0, iDelimiterOffset$default2, 1, null);
                if (strTrimSubstring$default.length() != 0 && _UtilCommonKt.indexOfControlOrNonAscii(strTrimSubstring$default) == -1) {
                    String strTrimSubstring = _UtilCommonKt.trimSubstring(setCookie, iDelimiterOffset$default2 + 1, iDelimiterOffset$default);
                    if (_UtilCommonKt.indexOfControlOrNonAscii(strTrimSubstring) == -1) {
                        int i2 = iDelimiterOffset$default + 1;
                        int length = setCookie.length();
                        String str2 = null;
                        boolean z2 = false;
                        boolean z7 = false;
                        boolean z8 = false;
                        boolean z9 = true;
                        long maxAge = -1;
                        long expires = DateFormattingKt.MAX_DATE;
                        String str3 = null;
                        while (i2 < length) {
                            int iDelimiterOffset = _UtilCommonKt.delimiterOffset(setCookie, ';', i2, length);
                            int iDelimiterOffset2 = _UtilCommonKt.delimiterOffset(setCookie, G5.T, i2, iDelimiterOffset);
                            String strTrimSubstring2 = _UtilCommonKt.trimSubstring(setCookie, i2, iDelimiterOffset2);
                            String strTrimSubstring3 = iDelimiterOffset2 < iDelimiterOffset ? _UtilCommonKt.trimSubstring(setCookie, iDelimiterOffset2 + 1, iDelimiterOffset) : "";
                            if (t.g0(strTrimSubstring2, "expires")) {
                                try {
                                    expires = parseExpires(strTrimSubstring3, 0, strTrimSubstring3.length());
                                    z7 = true;
                                } catch (NumberFormatException | IllegalArgumentException unused) {
                                }
                            } else if (t.g0(strTrimSubstring2, "max-age")) {
                                maxAge = parseMaxAge(strTrimSubstring3);
                                z7 = true;
                            } else if (t.g0(strTrimSubstring2, C2300e4.i.D)) {
                                domain = parseDomain(strTrimSubstring3);
                                z9 = false;
                            } else if (t.g0(strTrimSubstring2, "path")) {
                                str3 = strTrimSubstring3;
                            } else if (t.g0(strTrimSubstring2, "secure")) {
                                z8 = true;
                            } else if (t.g0(strTrimSubstring2, "httponly")) {
                                z2 = true;
                            } else if (t.g0(strTrimSubstring2, "samesite")) {
                                str2 = strTrimSubstring3;
                            }
                            i2 = iDelimiterOffset + 1;
                        }
                        if (maxAge == Long.MIN_VALUE) {
                            j3 = Long.MIN_VALUE;
                        } else if (maxAge != -1) {
                            long j8 = j + (maxAge <= 9223372036854775L ? maxAge * ((long) 1000) : LocationRequestCompat.PASSIVE_INTERVAL);
                            j3 = (j8 < j || j8 > DateFormattingKt.MAX_DATE) ? 253402300799999L : j8;
                        } else {
                            j3 = expires;
                        }
                        String strHost = url.host();
                        if (domain == null) {
                            str = strHost;
                        } else {
                            if (!domainMatch(strHost, domain)) {
                                return null;
                            }
                            str = domain;
                        }
                        if (strHost.length() != str.length() && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(str) == null) {
                            return null;
                        }
                        String strSubstring = "/";
                        if (str3 == null || !t.n0(str3, "/", false)) {
                            String strEncodedPath = url.encodedPath();
                            int iB0 = m.B0(strEncodedPath, '/', 0, 6);
                            if (iB0 != 0) {
                                strSubstring = strEncodedPath.substring(0, iB0);
                                k.d(strSubstring, "substring(...)");
                            }
                            str3 = strSubstring;
                        }
                        return new Cookie(strTrimSubstring$default, strTrimSubstring, j3, str, str3, z8, z2, z7, z9, str2, null);
                    }
                }
            }
            return null;
        }

        public final List<Cookie> parseAll(HttpUrl url, Headers headers) {
            k.e(url, "url");
            k.e(headers, "headers");
            List<String> listValues = headers.values("Set-Cookie");
            int size = listValues.size();
            List<Cookie> listUnmodifiableList = null;
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < size; i2++) {
                Cookie cookie = parse(url, listValues.get(i2));
                if (cookie != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(cookie);
                }
            }
            if (arrayList != null) {
                listUnmodifiableList = Collections.unmodifiableList(arrayList);
                k.d(listUnmodifiableList, "unmodifiableList(...)");
            }
            return listUnmodifiableList == null ? r.f13638a : listUnmodifiableList;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Cookie(String str, String str2, long j, String str3, String str4, boolean z2, boolean z7, boolean z8, boolean z9, String str5, f fVar) {
        this(str, str2, j, str3, str4, z2, z7, z8, z9, str5);
    }

    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    /* JADX INFO: renamed from: -deprecated_domain, reason: not valid java name */
    public final String m3490deprecated_domain() {
        return this.domain;
    }

    /* JADX INFO: renamed from: -deprecated_expiresAt, reason: not valid java name */
    public final long m3491deprecated_expiresAt() {
        return this.expiresAt;
    }

    /* JADX INFO: renamed from: -deprecated_hostOnly, reason: not valid java name */
    public final boolean m3492deprecated_hostOnly() {
        return this.hostOnly;
    }

    /* JADX INFO: renamed from: -deprecated_httpOnly, reason: not valid java name */
    public final boolean m3493deprecated_httpOnly() {
        return this.httpOnly;
    }

    /* JADX INFO: renamed from: -deprecated_name, reason: not valid java name */
    public final String m3494deprecated_name() {
        return this.name;
    }

    /* JADX INFO: renamed from: -deprecated_path, reason: not valid java name */
    public final String m3495deprecated_path() {
        return this.path;
    }

    /* JADX INFO: renamed from: -deprecated_persistent, reason: not valid java name */
    public final boolean m3496deprecated_persistent() {
        return this.persistent;
    }

    /* JADX INFO: renamed from: -deprecated_secure, reason: not valid java name */
    public final boolean m3497deprecated_secure() {
        return this.secure;
    }

    /* JADX INFO: renamed from: -deprecated_value, reason: not valid java name */
    public final String m3498deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return k.a(cookie.name, this.name) && k.a(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && k.a(cookie.domain, this.domain) && k.a(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly && k.a(cookie.sameSite, this.sameSite);
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    public int hashCode() {
        int iB = androidx.camera.core.processing.util.a.b(androidx.camera.core.processing.util.a.b(IronSourceError.ERROR_NON_EXISTENT_INSTANCE, 31, this.name), 31, this.value);
        long j = this.expiresAt;
        int iB2 = (((((((androidx.camera.core.processing.util.a.b(androidx.camera.core.processing.util.a.b((iB + ((int) (j ^ (j >>> 32)))) * 31, 31, this.domain), 31, this.path) + (this.secure ? 1231 : 1237)) * 31) + (this.httpOnly ? 1231 : 1237)) * 31) + (this.persistent ? 1231 : 1237)) * 31) + (this.hostOnly ? 1231 : 1237)) * 31;
        String str = this.sameSite;
        return iB2 + (str != null ? str.hashCode() : 0);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl url) {
        k.e(url, "url");
        if ((this.hostOnly ? k.a(url.host(), this.domain) : Companion.domainMatch(url.host(), this.domain)) && Companion.pathMatch(url, this.path)) {
            return !this.secure || url.isHttps();
        }
        return false;
    }

    public final String name() {
        return this.name;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final String sameSite() {
        return this.sameSite;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(G5.T);
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DateFormattingKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z2) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        if (this.sameSite != null) {
            sb.append("; samesite=");
            sb.append(this.sameSite);
        }
        String string = sb.toString();
        k.d(string, "toString(...)");
        return string;
    }

    public final String value() {
        return this.value;
    }

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z2, boolean z7, boolean z8, boolean z9, String str5) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z2;
        this.httpOnly = z7;
        this.persistent = z8;
        this.hostOnly = z9;
        this.sameSite = str5;
    }
}
