package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzfbe implements zzepj {
    protected final zzcjn zza;
    private final Context zzb;
    private final Executor zzc;
    private final zzfbu zzd;
    private final zzfdm zze;
    private final VersionInfoParcel zzf;
    private final ViewGroup zzg;
    private final zzflp zzh;
    private final zzfgm zzi;
    private j2.q zzj;

    public zzfbe(Context context, Executor executor, zzcjn zzcjnVar, zzfdm zzfdmVar, zzfbu zzfbuVar, zzfgm zzfgmVar, VersionInfoParcel versionInfoParcel) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzcjnVar;
        this.zze = zzfdmVar;
        this.zzd = zzfbuVar;
        this.zzi = zzfgmVar;
        this.zzf = versionInfoParcel;
        this.zzg = new FrameLayout(context);
        this.zzh = zzcjnVar.zzx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final synchronized zzcxu zzg(zzfdk zzfdkVar) {
        zzfbb zzfbbVar = (zzfbb) zzfdkVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzja)).booleanValue()) {
            zzcrd zzcrdVar = new zzcrd(this.zzg);
            zzcxw zzcxwVar = new zzcxw();
            zzcxwVar.zza(this.zzb);
            zzcxwVar.zzb(zzfbbVar.zza);
            zzcxx zzcxxVarZze = zzcxwVar.zze();
            zzden zzdenVar = new zzden();
            zzfbu zzfbuVar = this.zzd;
            Executor executor = this.zzc;
            zzdenVar.zzd(zzfbuVar, executor);
            zzdenVar.zzg(zzfbuVar, executor);
            return zzc(zzcrdVar, zzcxxVarZze, zzdenVar.zzn());
        }
        zzfbu zzfbuVarZzn = zzfbu.zzn(this.zzd);
        zzden zzdenVar2 = new zzden();
        Executor executor2 = this.zzc;
        zzdenVar2.zzc(zzfbuVarZzn, executor2);
        zzdenVar2.zzi(zzfbuVarZzn, executor2);
        zzdenVar2.zzj(zzfbuVarZzn, executor2);
        zzdenVar2.zzk(zzfbuVarZzn, executor2);
        zzdenVar2.zzd(zzfbuVarZzn, executor2);
        zzdenVar2.zzg(zzfbuVarZzn, executor2);
        zzdenVar2.zzl(zzfbuVarZzn);
        zzcrd zzcrdVar2 = new zzcrd(this.zzg);
        zzcxw zzcxwVar2 = new zzcxw();
        zzcxwVar2.zza(this.zzb);
        zzcxwVar2.zzb(zzfbbVar.zza);
        return zzc(zzcrdVar2, zzcxwVar2.zze(), zzdenVar2.zzn());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    @Override // com.google.android.gms.internal.ads.zzepj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean zza(com.google.android.gms.ads.internal.client.zzm r11, java.lang.String r12, com.google.android.gms.internal.ads.zzeph r13, com.google.android.gms.internal.ads.zzepi r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfbe.zza(com.google.android.gms.ads.internal.client.zzm, java.lang.String, com.google.android.gms.internal.ads.zzeph, com.google.android.gms.internal.ads.zzepi):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzepj
    public final boolean zzb() {
        j2.q qVar = this.zzj;
        return (qVar == null || qVar.isDone()) ? false : true;
    }

    public abstract zzcxu zzc(zzcrd zzcrdVar, zzcxx zzcxxVar, zzdeo zzdeoVar);

    public final void zzd(com.google.android.gms.ads.internal.client.zzx zzxVar) {
        this.zzi.zzp(zzxVar);
    }

    public final /* synthetic */ void zze() {
        this.zzd.zzdN(zzfhp.zzd(6, null, null));
    }

    public final /* synthetic */ Executor zzh() {
        return this.zzc;
    }

    public final /* synthetic */ zzfbu zzi() {
        return this.zzd;
    }

    public final /* synthetic */ zzfdm zzj() {
        return this.zze;
    }

    public final /* synthetic */ zzflp zzk() {
        return this.zzh;
    }

    public final /* synthetic */ void zzl(j2.q qVar) {
        this.zzj = null;
    }
}
