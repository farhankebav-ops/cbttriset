package okhttp3;

import androidx.webkit.ProxyConfig;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.m;
import n6.t;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import r5.j;
import r5.l;
import r5.n;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public final Builder add(String pattern, String... pins) {
            k.e(pattern, "pattern");
            k.e(pins, "pins");
            for (String str : pins) {
                this.pins.add(new Pin(pattern, str));
            }
            return this;
        }

        public final CertificatePinner build() {
            return new CertificatePinner(l.r1(this.pins), null, 2, 0 == true ? 1 : 0);
        }

        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final String pin(Certificate certificate) {
            k.e(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
            }
            return "sha256/" + sha256Hash((X509Certificate) certificate).a();
        }

        public final m sha1Hash(X509Certificate x509Certificate) {
            k.e(x509Certificate, "<this>");
            m mVar = m.f12880d;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            k.d(encoded, "getEncoded(...)");
            return r4.c.g(encoded).c(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1);
        }

        public final m sha256Hash(X509Certificate x509Certificate) {
            k.e(x509Certificate, "<this>");
            m mVar = m.f12880d;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            k.d(encoded, "getEncoded(...)");
            return r4.c.g(encoded).c("SHA-256");
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Pin {
        private final m hash;
        private final String hashAlgorithm;
        private final String pattern;

        public Pin(String pattern, String pin) {
            k.e(pattern, "pattern");
            k.e(pin, "pin");
            if ((!t.n0(pattern, "*.", false) || n6.m.y0(pattern, ProxyConfig.MATCH_ALL_SCHEMES, 1, false, 4) != -1) && ((!t.n0(pattern, "**.", false) || n6.m.y0(pattern, ProxyConfig.MATCH_ALL_SCHEMES, 2, false, 4) != -1) && n6.m.y0(pattern, ProxyConfig.MATCH_ALL_SCHEMES, 0, false, 6) != -1)) {
                throw new IllegalArgumentException("Unexpected pattern: ".concat(pattern).toString());
            }
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(pattern);
            if (canonicalHost == null) {
                throw new IllegalArgumentException("Invalid pattern: ".concat(pattern));
            }
            this.pattern = canonicalHost;
            if (t.n0(pin, "sha1/", false)) {
                this.hashAlgorithm = "sha1";
                m mVar = m.f12880d;
                String strSubstring = pin.substring(5);
                k.d(strSubstring, "substring(...)");
                m mVarC = r4.c.c(strSubstring);
                if (mVarC == null) {
                    throw new IllegalArgumentException("Invalid pin hash: ".concat(pin));
                }
                this.hash = mVarC;
                return;
            }
            if (!t.n0(pin, "sha256/", false)) {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': ".concat(pin));
            }
            this.hashAlgorithm = "sha256";
            m mVar2 = m.f12880d;
            String strSubstring2 = pin.substring(7);
            k.d(strSubstring2, "substring(...)");
            m mVarC2 = r4.c.c(strSubstring2);
            if (mVarC2 == null) {
                throw new IllegalArgumentException("Invalid pin hash: ".concat(pin));
            }
            this.hash = mVarC2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return k.a(this.pattern, pin.pattern) && k.a(this.hashAlgorithm, pin.hashAlgorithm) && k.a(this.hash, pin.hash);
        }

        public final m getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return this.hash.hashCode() + androidx.camera.core.processing.util.a.b(this.pattern.hashCode() * 31, 31, this.hashAlgorithm);
        }

        public final boolean matchesCertificate(X509Certificate certificate) {
            k.e(certificate, "certificate");
            String str = this.hashAlgorithm;
            if (k.a(str, "sha256")) {
                return k.a(this.hash, CertificatePinner.Companion.sha256Hash(certificate));
            }
            if (k.a(str, "sha1")) {
                return k.a(this.hash, CertificatePinner.Companion.sha1Hash(certificate));
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x006c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x006d A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean matchesHostname(java.lang.String r11) {
            /*
                r10 = this;
                java.lang.String r0 = "hostname"
                kotlin.jvm.internal.k.e(r11, r0)
                java.lang.String r0 = r10.pattern
                java.lang.String r1 = "**."
                r2 = 0
                boolean r0 = n6.t.n0(r0, r1, r2)
                r1 = 46
                r3 = 1
                if (r0 == 0) goto L3b
                java.lang.String r0 = r10.pattern
                int r0 = r0.length()
                int r9 = r0 + (-3)
                int r0 = r11.length()
                int r0 = r0 - r9
                int r4 = r11.length()
                int r5 = r4 - r9
                java.lang.String r7 = r10.pattern
                r8 = 3
                r6 = 0
                r4 = r11
                boolean r11 = n6.t.j0(r4, r5, r6, r7, r8, r9)
                if (r11 == 0) goto L6d
                if (r0 == 0) goto L6c
                int r0 = r0 - r3
                char r11 = r4.charAt(r0)
                if (r11 != r1) goto L6d
                goto L6c
            L3b:
                r4 = r11
                java.lang.String r11 = r10.pattern
                java.lang.String r0 = "*."
                boolean r11 = n6.t.n0(r11, r0, r2)
                if (r11 == 0) goto L6e
                java.lang.String r11 = r10.pattern
                int r11 = r11.length()
                int r9 = r11 + (-1)
                int r11 = r4.length()
                int r11 = r11 - r9
                int r0 = r4.length()
                int r5 = r0 - r9
                java.lang.String r7 = r10.pattern
                r8 = 1
                r6 = 0
                boolean r0 = n6.t.j0(r4, r5, r6, r7, r8, r9)
                if (r0 == 0) goto L6d
                int r11 = r11 - r3
                r0 = 4
                int r11 = n6.m.B0(r4, r1, r11, r0)
                r0 = -1
                if (r11 != r0) goto L6d
            L6c:
                return r3
            L6d:
                return r2
            L6e:
                java.lang.String r11 = r10.pattern
                boolean r11 = r4.equals(r11)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CertificatePinner.Pin.matchesHostname(java.lang.String):boolean");
        }

        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.a();
        }
    }

    public CertificatePinner(Set<Pin> pins, CertificateChainCleaner certificateChainCleaner) {
        k.e(pins, "pins");
        this.pins = pins;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List check$lambda$1(CertificatePinner certificatePinner, List list, String str) {
        List<Certificate> listClean;
        CertificateChainCleaner certificateChainCleaner = certificatePinner.certificateChainCleaner;
        if (certificateChainCleaner != null && (listClean = certificateChainCleaner.clean(list, str)) != null) {
            list = listClean;
        }
        ArrayList arrayList = new ArrayList(n.L0(list, 10));
        for (Certificate certificate : list) {
            k.c(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }

    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }

    public static final m sha1Hash(X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    public static final m sha256Hash(X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(String hostname, List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        k.e(hostname, "hostname");
        k.e(peerCertificates, "peerCertificates");
        check$okhttp(hostname, new a(this, peerCertificates, hostname, 0));
    }

    public final void check$okhttp(String hostname, e6.a cleanedPeerCertificatesFn) throws SSLPeerUnverifiedException {
        k.e(hostname, "hostname");
        k.e(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<Pin> listFindMatchingPins = findMatchingPins(hostname);
        if (listFindMatchingPins.isEmpty()) {
            return;
        }
        List<X509Certificate> list = (List) cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : list) {
            m mVarSha256Hash = null;
            m mVarSha1Hash = null;
            for (Pin pin : listFindMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                if (k.a(hashAlgorithm, "sha256")) {
                    if (mVarSha256Hash == null) {
                        mVarSha256Hash = Companion.sha256Hash(x509Certificate);
                    }
                    if (k.a(pin.getHash(), mVarSha256Hash)) {
                        return;
                    }
                } else {
                    if (!k.a(hashAlgorithm, "sha1")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                    }
                    if (mVarSha1Hash == null) {
                        mVarSha1Hash = Companion.sha1Hash(x509Certificate);
                    }
                    if (k.a(pin.getHash(), mVarSha1Hash)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : list) {
            sb.append("\n    ");
            sb.append(Companion.pin(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(hostname);
        sb.append(":");
        for (Pin pin2 : listFindMatchingPins) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        return k.a(certificatePinner.pins, this.pins) && k.a(certificatePinner.certificateChainCleaner, this.certificateChainCleaner);
    }

    public final List<Pin> findMatchingPins(String hostname) {
        k.e(hostname, "hostname");
        List arrayList = r.f13638a;
        for (Object obj : this.pins) {
            if (((Pin) obj).matchesHostname(hostname)) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList();
                }
                d0.b(arrayList);
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int iHashCode = (this.pins.hashCode() + 1517) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return iHashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        k.e(certificateChainCleaner, "certificateChainCleaner");
        return k.a(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public final void check(String hostname, Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        k.e(hostname, "hostname");
        k.e(peerCertificates, "peerCertificates");
        check(hostname, j.s0(peerCertificates));
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i2, f fVar) {
        this(set, (i2 & 2) != 0 ? null : certificateChainCleaner);
    }
}
