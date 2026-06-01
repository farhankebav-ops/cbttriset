package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzazf extends zzazr {
    public zzazf(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i2, int i8) {
        super(zzaydVar, "8W5EiIZWvw8ca0gdEf2baMelwD0v1LgWFEv6AqIRDGIzRlZJKgzzVYcusXATxgKN", "ZXwHOojdfPkjtU4/T1kRX8Zucxdzz/LL+/XimOcPDrc=", zzaucVar, i2, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdr);
        bool.booleanValue();
        zzaxj zzaxjVar = new zzaxj((String) this.zze.invoke(null, this.zza.zzb(), bool));
        zzauc zzaucVar = this.zzd;
        synchronized (zzaucVar) {
            zzaucVar.zzc(zzaxjVar.zza);
            zzaucVar.zzP(zzaxjVar.zzb);
        }
    }
}
