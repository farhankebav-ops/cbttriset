package okhttp3.internal.tls;

import androidx.camera.core.processing.util.a;
import androidx.webkit.ProxyConfig;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.jvm.internal.k;
import n6.m;
import n6.t;
import okhttp3.internal._HostnamesCommonKt;
import r5.l;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (!isAscii(str)) {
            return str;
        }
        Locale US = Locale.US;
        k.d(US, "US");
        String lowerCase = str.toLowerCase(US);
        k.d(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i2) {
        Object obj;
        r rVar = r.f13638a;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return rVar;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && k.a(list.get(0), Integer.valueOf(i2)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return rVar;
        }
    }

    private final boolean isAscii(String str) {
        int i2;
        int length = str.length();
        int length2 = str.length();
        if (length2 < 0) {
            throw new IllegalArgumentException(a.i("endIndex < beginIndex: ", length2, " < ", 0).toString());
        }
        if (length2 > str.length()) {
            StringBuilder sbV = a1.a.v(length2, "endIndex > string.length: ", " > ");
            sbV.append(str.length());
            throw new IllegalArgumentException(sbV.toString().toString());
        }
        long j = 0;
        int i8 = 0;
        while (i8 < length2) {
            char cCharAt = str.charAt(i8);
            if (cCharAt < 128) {
                j++;
            } else {
                if (cCharAt < 2048) {
                    i2 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i2 = 3;
                } else {
                    int i9 = i8 + 1;
                    char cCharAt2 = i9 < length2 ? str.charAt(i9) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j++;
                        i8 = i9;
                    } else {
                        j += (long) 4;
                        i8 += 2;
                    }
                }
                j += (long) i2;
            }
            i8++;
        }
        return length == ((int) j);
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        String strAsciiToLowercase = asciiToLowercase(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if (subjectAltNames != null && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (INSTANCE.verifyHostname(strAsciiToLowercase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = _HostnamesCommonKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if (subjectAltNames != null && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (k.a(canonicalHost, _HostnamesCommonKt.toCanonicalHost((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> allSubjectAltNames(X509Certificate certificate) {
        k.e(certificate, "certificate");
        return l.f1(getSubjectAltNames(certificate, 2), getSubjectAltNames(certificate, 7));
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String host, SSLSession session) {
        k.e(host, "host");
        k.e(session, "session");
        if (!isAscii(host)) {
            return false;
        }
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            k.c(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return verify(host, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }

    public final boolean verify(String host, X509Certificate certificate) {
        k.e(host, "host");
        k.e(certificate, "certificate");
        return _HostnamesCommonKt.canParseAsIpAddress(host) ? verifyIpAddress(host, certificate) : verifyHostname(host, certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        int length;
        if (str != null && str.length() != 0 && !t.n0(str, ".", false) && !t.f0(str, "..", false) && str2 != null && str2.length() != 0 && !t.n0(str2, ".", false) && !t.f0(str2, "..", false)) {
            if (!t.f0(str, ".", false)) {
                str = str.concat(".");
            }
            if (!t.f0(str2, ".", false)) {
                str2 = str2.concat(".");
            }
            String strAsciiToLowercase = asciiToLowercase(str2);
            if (!m.q0(strAsciiToLowercase, ProxyConfig.MATCH_ALL_SCHEMES, false)) {
                return k.a(str, strAsciiToLowercase);
            }
            if (t.n0(strAsciiToLowercase, "*.", false) && m.x0(strAsciiToLowercase, '*', 1, 4) == -1 && str.length() >= strAsciiToLowercase.length() && !"*.".equals(strAsciiToLowercase)) {
                String strSubstring = strAsciiToLowercase.substring(1);
                k.d(strSubstring, "substring(...)");
                if (t.f0(str, strSubstring, false) && ((length = str.length() - strSubstring.length()) <= 0 || m.B0(str, '.', length - 1, 4) == -1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
