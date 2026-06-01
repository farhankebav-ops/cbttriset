package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzays extends zzazr {
    public zzays(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i2, int i8) {
        super(zzaydVar, "0k0HoJtCvAtrnTz0UbiSqrs0BGKzSTMoo+ZxCfyJrLcMn8tbsvf/NG2/ui2bKbWP", "z6GzXqyR8kvBYJKVLhMc9mqmsbq6ZkNeWqgTkONnpqg=", zzaucVar, i2, 5);
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzauc zzaucVar = this.zzd;
        zzaucVar.zzd(-1L);
        zzaucVar.zze(-1L);
        int[] iArr = (int[]) this.zze.invoke(null, this.zza.zzb());
        synchronized (zzaucVar) {
            try {
                zzaucVar.zzd(iArr[0]);
                zzaucVar.zze(iArr[1]);
                int i2 = iArr[2];
                if (i2 != Integer.MIN_VALUE) {
                    zzaucVar.zzO(i2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
