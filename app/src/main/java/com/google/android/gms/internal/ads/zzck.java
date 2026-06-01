package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzck extends zzch {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    @Override // com.google.android.gms.internal.ads.zzcg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(java.nio.ByteBuffer r12) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzck.zzd(java.nio.ByteBuffer):void");
    }

    @Override // com.google.android.gms.internal.ads.zzch
    public final zzcd zzm(zzcd zzcdVar) throws zzcf {
        int i2 = zzcdVar.zzd;
        if (i2 != 3) {
            if (i2 == 2) {
                return zzcd.zza;
            }
            if (i2 != 268435456 && i2 != 21 && i2 != 1342177280 && i2 != 22 && i2 != 1610612736 && i2 != 4) {
                throw new zzcf("Unhandled input format:", zzcdVar);
            }
        }
        return new zzcd(zzcdVar.zzb, zzcdVar.zzc, 2);
    }
}
