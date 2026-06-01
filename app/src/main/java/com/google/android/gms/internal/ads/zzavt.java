package com.google.android.gms.internal.ads;

import android.util.Base64;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzavt {
    public static String zza(byte[] bArr, boolean z2) {
        return Base64.encodeToString(bArr, true != z2 ? 2 : 11);
    }

    public static byte[] zzb(String str, boolean z2) throws IllegalArgumentException {
        byte[] bArrDecode = Base64.decode(str, 2);
        if (bArrDecode.length != 0 || str.length() <= 0) {
            return bArrDecode;
        }
        throw new IllegalArgumentException("Unable to decode ".concat(str));
    }
}
