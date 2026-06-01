package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzazl extends zzazr {
    private final zzayk zzh;
    private long zzi;

    public zzazl(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i2, int i8, zzayk zzaykVar) {
        super(zzaydVar, "7i2iPrjrwVOXQymI9kbzBw+Saen0JiBKsL25H084g9vqkkZvrS3PC/gXCAaliMdd", "jjLuguQ1TtUBIYvLkWHGRHLEQB49t1f8VaYjdD5pX6Q=", zzaucVar, i2, 53);
        this.zzh = zzaykVar;
        if (zzaykVar != null) {
            this.zzi = zzaykVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzh != null) {
            this.zzd.zzH(((Long) this.zze.invoke(null, Long.valueOf(this.zzi))).longValue());
        }
    }
}
