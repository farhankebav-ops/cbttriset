package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfyo {
    public static String zza(byte[] bArr, boolean z2) {
        return zzc(true).zzj(bArr, 0, bArr.length);
    }

    public static byte[] zzb(String str, boolean z2) throws IllegalArgumentException {
        byte[] bArrZzk = zzc(z2).zzk(str);
        if (bArrZzk.length != 0 || str.length() <= 0) {
            return bArrZzk;
        }
        throw new IllegalArgumentException("Unable to decode ".concat(str));
    }

    private static zzgrz zzc(boolean z2) {
        return z2 ? zzgrz.zzm().zzh() : zzgrz.zzl();
    }
}
