package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdyz implements com.google.android.gms.ads.internal.overlay.zzr, zzciu {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private zzdyo zzc;
    private zzcgy zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;

    @Nullable
    private com.google.android.gms.ads.internal.client.zzdn zzh;
    private boolean zzi;

    public zzdyz(Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = versionInfoParcel;
    }

    private final synchronized boolean zzq(com.google.android.gms.ads.internal.client.zzdn zzdnVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjT)).booleanValue()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Ad inspector had an internal error.");
            try {
                zzdnVar.zze(zzfhp.zzd(16, null, null));
            } catch (RemoteException unused) {
            }
            return false;
        }
        if (this.zzc == null) {
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Ad inspector had an internal error.");
            try {
                com.google.android.gms.ads.internal.zzt.zzh().zzg(new NullPointerException("InspectorManager null"), "InspectorUi.shouldOpenUi");
                zzdnVar.zze(zzfhp.zzd(16, null, null));
            } catch (RemoteException unused2) {
            }
            return false;
        }
        if (!this.zze && !this.zzf) {
            if (com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() >= this.zzg + ((long) ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjW)).intValue())) {
                return true;
            }
        }
        int i9 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Ad inspector cannot be opened because it is already open.");
        try {
            zzdnVar.zze(zzfhp.zzd(19, null, null));
        } catch (RemoteException unused3) {
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzciu
    public final synchronized void zza(boolean z2, int i2, String str, String str2) {
        if (z2) {
            com.google.android.gms.ads.internal.util.zze.zza("Ad inspector loaded.");
            this.zze = true;
            zzn();
            return;
        }
        int i8 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Ad inspector failed to load.");
        try {
            zzcbj zzcbjVarZzh = com.google.android.gms.ads.internal.zzt.zzh();
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 46 + String.valueOf(str).length() + 15 + String.valueOf(str2).length());
            sb.append("Failed to load UI. Error code: ");
            sb.append(i2);
            sb.append(", Description: ");
            sb.append(str);
            sb.append(", Failing URL: ");
            sb.append(str2);
            zzcbjVarZzh.zzg(new Exception(sb.toString()), "InspectorUi.onAdWebViewFinishedLoading 0");
            com.google.android.gms.ads.internal.client.zzdn zzdnVar = this.zzh;
            if (zzdnVar != null) {
                zzdnVar.zze(zzfhp.zzd(17, null, null));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "InspectorUi.onAdWebViewFinishedLoading 1");
        }
        this.zzi = true;
        this.zzd.destroy();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdY(int i2) {
        this.zzd.destroy();
        if (!this.zzi) {
            com.google.android.gms.ads.internal.util.zze.zza("Inspector closed.");
            com.google.android.gms.ads.internal.client.zzdn zzdnVar = this.zzh;
            if (zzdnVar != null) {
                try {
                    zzdnVar.zze(null);
                } catch (RemoteException unused) {
                }
            }
        }
        this.zzf = false;
        this.zze = false;
        this.zzg = 0L;
        this.zzi = false;
        this.zzh = null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzh() {
        this.zzf = true;
        zzn();
    }

    public final void zzl(zzdyo zzdyoVar) {
        this.zzc = zzdyoVar;
    }

    public final synchronized void zzm(com.google.android.gms.ads.internal.client.zzdn zzdnVar, zzbms zzbmsVar, zzbml zzbmlVar, zzbly zzblyVar) {
        if (zzq(zzdnVar)) {
            try {
                com.google.android.gms.ads.internal.zzt.zzd();
                zzcgy zzcgyVarZza = zzcho.zza(this.zza, zzcji.zzb(), "", false, false, null, null, this.zzb, null, null, null, zzbdt.zza(), null, null, null, null, null);
                this.zzd = zzcgyVarZza;
                zzciw zzciwVarZzP = zzcgyVarZza.zzP();
                if (zzciwVarZzP == null) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Failed to obtain a web view for the ad inspector");
                    try {
                        com.google.android.gms.ads.internal.zzt.zzh().zzg(new NullPointerException("Failed to obtain a web view for the ad inspector"), "InspectorUi.openInspector 2");
                        zzdnVar.zze(zzfhp.zzd(17, "Failed to obtain a web view for the ad inspector", null));
                        return;
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "InspectorUi.openInspector 3");
                        return;
                    }
                }
                this.zzh = zzdnVar;
                Context context = this.zza;
                zzciwVarZzP.zzZ(null, null, null, null, null, false, null, null, null, null, null, null, null, zzbmsVar, null, new zzbmr(context), zzbmlVar, zzblyVar, null, null, null);
                zzciwVarZzP.zzG(this);
                this.zzd.loadUrl((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjU));
                com.google.android.gms.ads.internal.zzt.zzb();
                com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel(this, this.zzd, 1, this.zzb), true, null);
                this.zzg = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
            } catch (zzchn e4) {
                int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to obtain a web view for the ad inspector", e4);
                try {
                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e4, "InspectorUi.openInspector 0");
                    zzdnVar.zze(zzfhp.zzd(17, "Failed to obtain a web view for the ad inspector", null));
                } catch (RemoteException e8) {
                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e8, "InspectorUi.openInspector 1");
                }
            }
        }
    }

    public final synchronized void zzn() {
        if (this.zze && this.zzf) {
            zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdyy
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzp();
                }
            });
        }
    }

    @Nullable
    public final Activity zzo() {
        zzcgy zzcgyVar = this.zzd;
        if (zzcgyVar == null || zzcgyVar.zzX()) {
            return null;
        }
        return this.zzd.zzj();
    }

    public final /* synthetic */ void zzp() {
        this.zzd.zzc("window.inspectorInfo", this.zzc.zzr().toString());
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdA() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdB() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdC() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdD() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdE() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdX() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdt() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdu() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
    }
}
