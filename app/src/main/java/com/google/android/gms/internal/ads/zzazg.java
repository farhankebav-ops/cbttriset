package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzazg extends zzazr {
    public zzazg(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i2, int i8) {
        super(zzaydVar, "ExKA4wjDRRYdztAsabUEoV5NOADo4vSkAwQNa4IGw0yLC0NQlDOhDdBTfDT5YHOb", "1Gz3ZRhjJNvXJ0g284S9b/dpVAajMMfg8CE3pBcFNFA=", zzaucVar, i2, 73);
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        try {
            int i2 = 1;
            boolean zBooleanValue = ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue();
            zzauc zzaucVar = this.zzd;
            if (true == zBooleanValue) {
                i2 = 2;
            }
            zzaucVar.zzah(i2);
        } catch (InvocationTargetException unused) {
            this.zzd.zzah(3);
        }
    }
}
