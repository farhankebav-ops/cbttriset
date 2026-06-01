package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcra extends zzcto {

    @Nullable
    private final zzcgy zzc;
    private final int zzd;
    private final Context zze;
    private final zzcqo zzf;
    private final zzdjl zzg;
    private final zzdfz zzh;
    private final zzczb zzi;
    private final boolean zzj;
    private final zzcbn zzk;
    private final zzdvi zzl;
    private boolean zzm;

    public zzcra(zzctn zzctnVar, Context context, @Nullable zzcgy zzcgyVar, int i2, zzcqo zzcqoVar, zzdjl zzdjlVar, zzdfz zzdfzVar, zzczb zzczbVar, zzcbn zzcbnVar, zzdvi zzdviVar) {
        super(zzctnVar);
        this.zzm = false;
        this.zzc = zzcgyVar;
        this.zze = context;
        this.zzd = i2;
        this.zzf = zzcqoVar;
        this.zzg = zzdjlVar;
        this.zzh = zzdfzVar;
        this.zzi = zzczbVar;
        this.zzj = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzga)).booleanValue();
        this.zzk = zzcbnVar;
        this.zzl = zzdviVar;
    }

    public final void zza(zzbch zzbchVar) {
        zzcgy zzcgyVar = this.zzc;
        if (zzcgyVar != null) {
            zzcgyVar.zzay(zzbchVar);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void zzb(Activity activity, zzbcu zzbcuVar, boolean z2) throws RemoteException {
        zzcgy zzcgyVar;
        zzffu zzffuVarZzC;
        Context context = activity;
        if (activity == null) {
            context = this.zze;
        }
        boolean z7 = this.zzj;
        if (z7) {
            this.zzh.zza();
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        zzdjl zzdjlVar = this.zzg;
        if (!com.google.android.gms.ads.internal.util.zzs.zzS(zzdjlVar.zzb())) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzox)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzc();
                com.google.android.gms.ads.internal.util.zzs.zzR(context, this.zzb, this.zzl);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaT)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzc();
                if (com.google.android.gms.ads.internal.util.zzs.zzK(context)) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://goo.gle/admob-interstitial-policies");
                    this.zzi.zze();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaU)).booleanValue()) {
                        new zzfsc(context.getApplicationContext(), com.google.android.gms.ads.internal.zzt.zzs().zza()).zza(this.zza.zzb.zzb.zzb);
                        return;
                    }
                    return;
                }
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmT)).booleanValue() && (zzcgyVar = this.zzc) != null && (zzffuVarZzC = zzcgyVar.zzC()) != null && zzffuVarZzC.zzar && zzffuVarZzC.zzas != this.zzk.zzj()) {
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("The app open consent form has been shown.");
            this.zzi.zzc(zzfhp.zzd(12, "The consent form has already been shown.", null));
            return;
        }
        if (this.zzm) {
            int i9 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("App open interstitial ad is already visible.");
            this.zzi.zzc(zzfhp.zzd(10, null, null));
        }
        if (this.zzm) {
            return;
        }
        try {
            zzdjlVar.zza(z2, context, this.zzi);
            if (z7) {
                this.zzh.zzb();
            }
            this.zzm = true;
        } catch (zzdjk e) {
            this.zzi.zzd(e);
        }
    }

    public final int zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcto
    public final void zzd() {
        super.zzd();
        zzcgy zzcgyVar = this.zzc;
        if (zzcgyVar != null) {
            zzcgyVar.destroy();
        }
    }

    public final void zze(long j, int i2) {
        this.zzf.zza(j, i2);
    }
}
