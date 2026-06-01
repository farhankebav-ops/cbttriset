package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfng {
    private final Context zza;
    private final Executor zzb;
    private final zzgut zzc;
    private final com.google.android.gms.ads.internal.util.client.zzu zzd;
    private final zzfmy zze;
    private final zzflp zzf;
    private final zzcjk zzg;

    public zzfng(Context context, Executor executor, zzgut zzgutVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, zzfmy zzfmyVar, zzflp zzflpVar, zzcjk zzcjkVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzgutVar;
        this.zzd = zzuVar;
        this.zze = zzfmyVar;
        this.zzf = zzflpVar;
        this.zzg = zzcjkVar;
    }

    public final void zza(List list, @Nullable com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzb((String) it.next(), zzvVar, null, null);
        }
    }

    public final void zzb(final String str, @Nullable com.google.android.gms.ads.internal.util.client.zzv zzvVar, @Nullable zzflm zzflmVar, @Nullable zzdbd zzdbdVar) {
        j2.q qVarZzc;
        zzflc zzflcVarA = null;
        if (zzflp.zza() && ((Boolean) zzbgn.zzd.zze()).booleanValue()) {
            zzflcVarA = r.a(this.zza, 14);
            zzflcVarA.zza();
        }
        if (zzvVar != null) {
            qVarZzc = new zzfmx(zzvVar.zza(), this.zzd, this.zzc, this.zze, this.zzg).zza(str);
        } else {
            qVarZzc = this.zzc.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzfnf
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.zza.zzc(str);
                }
            });
        }
        zzgui.zzr(qVarZzc, new zzfne(this, zzflcVarA, zzflmVar, zzdbdVar), this.zzb);
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.util.client.zzt zzc(String str) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjN)).booleanValue() || (!com.google.android.gms.ads.internal.zzt.zzc().zzi(str) && !com.google.android.gms.ads.internal.zzt.zzc().zzj(str))) {
            return this.zzd.zzc(str, null);
        }
        String strZzb = this.zzg.zzb();
        HashMap map = new HashMap();
        if (strZzb != null) {
            map.put((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjO), strZzb);
        }
        return this.zzd.zzc(str, map);
    }

    public final /* synthetic */ com.google.android.gms.ads.internal.util.client.zzu zzd() {
        return this.zzd;
    }

    public final /* synthetic */ zzflp zze() {
        return this.zzf;
    }
}
