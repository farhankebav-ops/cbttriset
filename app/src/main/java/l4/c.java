package l4;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c {
    public static final c e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f12785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f12786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f12787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f12788d;

    static {
        a[] aVarArr = {a.TLS_AES_128_GCM_SHA256, a.TLS_AES_256_GCM_SHA384, a.TLS_CHACHA20_POLY1305_SHA256, a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, a.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, a.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, a.TLS_RSA_WITH_AES_128_GCM_SHA256, a.TLS_RSA_WITH_AES_256_GCM_SHA384, a.TLS_RSA_WITH_AES_128_CBC_SHA, a.TLS_RSA_WITH_AES_256_CBC_SHA, a.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        b bVar = new b(true);
        bVar.a(aVarArr);
        m mVar = m.TLS_1_3;
        m mVar2 = m.TLS_1_2;
        bVar.b(mVar, mVar2);
        bVar.f12784d = true;
        c cVar = new c(bVar);
        e = cVar;
        m[] mVarArr = {mVar, mVar2, m.TLS_1_1, m.TLS_1_0};
        boolean z2 = cVar.f12785a;
        if (!z2) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        if (mVarArr.length == 0) {
            throw new IllegalArgumentException("At least one TlsVersion is required");
        }
        String[] strArr = new String[mVarArr.length];
        for (int i2 = 0; i2 < mVarArr.length; i2++) {
            strArr[i2] = mVarArr[i2].f12818a;
        }
        if (!z2) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
    }

    public c(b bVar) {
        this.f12785a = bVar.f12781a;
        this.f12786b = bVar.f12782b;
        this.f12787c = bVar.f12783c;
        this.f12788d = bVar.f12784d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        c cVar = (c) obj;
        boolean z2 = cVar.f12785a;
        boolean z7 = this.f12785a;
        if (z7 != z2) {
            return false;
        }
        if (z7) {
            return Arrays.equals(this.f12786b, cVar.f12786b) && Arrays.equals(this.f12787c, cVar.f12787c) && this.f12788d == cVar.f12788d;
        }
        return true;
    }

    public final int hashCode() {
        if (this.f12785a) {
            return ((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + Arrays.hashCode(this.f12786b)) * 31) + Arrays.hashCode(this.f12787c)) * 31) + (!this.f12788d ? 1 : 0);
        }
        return 17;
    }

    public final String toString() {
        List listUnmodifiableList;
        m mVar;
        if (!this.f12785a) {
            return "ConnectionSpec()";
        }
        String[] strArr = this.f12786b;
        if (strArr == null) {
            listUnmodifiableList = null;
        } else {
            a[] aVarArr = new a[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                aVarArr[i2] = str.startsWith("SSL_") ? a.valueOf("TLS_" + str.substring(4)) : a.valueOf(str);
            }
            String[] strArr2 = n.f12819a;
            listUnmodifiableList = Collections.unmodifiableList(Arrays.asList((Object[]) aVarArr.clone()));
        }
        StringBuilder sbY = a1.a.y("ConnectionSpec(cipherSuites=", listUnmodifiableList == null ? "[use default]" : listUnmodifiableList.toString(), ", tlsVersions=");
        String[] strArr3 = this.f12787c;
        m[] mVarArr = new m[strArr3.length];
        for (int i8 = 0; i8 < strArr3.length; i8++) {
            String str2 = strArr3[i8];
            if ("TLSv1.3".equals(str2)) {
                mVar = m.TLS_1_3;
            } else if ("TLSv1.2".equals(str2)) {
                mVar = m.TLS_1_2;
            } else if ("TLSv1.1".equals(str2)) {
                mVar = m.TLS_1_1;
            } else if ("TLSv1".equals(str2)) {
                mVar = m.TLS_1_0;
            } else {
                if (!"SSLv3".equals(str2)) {
                    throw new IllegalArgumentException(a1.a.l("Unexpected TLS version: ", str2));
                }
                mVar = m.SSL_3_0;
            }
            mVarArr[i8] = mVar;
        }
        String[] strArr4 = n.f12819a;
        sbY.append(Collections.unmodifiableList(Arrays.asList((Object[]) mVarArr.clone())));
        sbY.append(", supportsTlsExtensions=");
        return a1.a.u(sbY, this.f12788d, ")");
    }
}
