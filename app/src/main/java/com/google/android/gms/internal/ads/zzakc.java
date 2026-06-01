package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzakc {
    public static void zza(zzakd zzakdVar, zzakh zzakhVar, zzdg zzdgVar) {
        for (int i2 = 0; i2 < zzakdVar.zza(); i2++) {
            long jZzb = zzakdVar.zzb(i2);
            List listZzc = zzakdVar.zzc(jZzb);
            if (!listZzc.isEmpty()) {
                if (i2 == zzakdVar.zza() - 1) {
                    throw new IllegalStateException();
                }
                long jZzb2 = zzakdVar.zzb(i2 + 1) - zzakdVar.zzb(i2);
                if (jZzb2 > 0) {
                    zzdgVar.zza(new zzaka(listZzc, jZzb, jZzb2));
                }
            }
        }
    }
}
