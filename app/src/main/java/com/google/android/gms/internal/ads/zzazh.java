package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzazh extends zzazr {
    private List zzh;
    private final Context zzi;

    public zzazh(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i2, int i8, Context context) {
        super(zzaydVar, "JC98YOkW1OV00In88Kxh39aoA4/Lc5LugpNahl16Tw21h78xPzCO3AkqsFSMWF+O", "uHu4aeoXgHtmEAr/p8TbphROLjKobmRTgSnNeTPf/24=", zzaucVar, i2, 31);
        this.zzh = null;
        this.zzi = context;
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzauc zzaucVar = this.zzd;
        zzaucVar.zzq(-1L);
        zzaucVar.zzr(-1L);
        Context contextZzb = this.zzi;
        if (contextZzb == null) {
            contextZzb = this.zza.zzb();
        }
        if (this.zzh == null) {
            this.zzh = (List) this.zze.invoke(null, contextZzb);
        }
        List list = this.zzh;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (zzaucVar) {
            zzaucVar.zzq(((Long) this.zzh.get(0)).longValue());
            zzaucVar.zzr(((Long) this.zzh.get(1)).longValue());
        }
    }
}
