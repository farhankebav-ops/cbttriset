package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzazk extends zzazr {
    public zzazk(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i2, int i8) {
        super(zzaydVar, "cOth2BAAthu6X8KDmzC58653OwqftcurhEiV9l+3uxMh7KBnOgbdhGM0zSnSPufi", "2EDSTVCwfkpT+1duJ+umEyNIZ3jEP0NWyK78oeLPLhI=", zzaucVar, i2, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzauc zzaucVar = this.zzd;
        synchronized (zzaucVar) {
            zzaxy zzaxyVar = new zzaxy((String) this.zze.invoke(null, null));
            zzaucVar.zzF(zzaxyVar.zza.longValue());
            zzaucVar.zzG(zzaxyVar.zzb.longValue());
        }
    }
}
