package com.google.android.gms.internal.ads;

import java.security.Provider;
import java.security.Security;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhdc {
    private static final String[] zza = {"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"};

    public static Provider zza() {
        String[] strArr = zza;
        for (int i2 = 0; i2 < 3; i2++) {
            Provider provider = Security.getProvider(strArr[i2]);
            if (provider != null) {
                return provider;
            }
        }
        return null;
    }
}
