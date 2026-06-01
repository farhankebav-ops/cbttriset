package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toolbar;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbel;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzbvb;
import com.google.android.gms.internal.ads.zzbvh;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzczb;
import com.google.android.gms.internal.ads.zzdgv;
import com.google.android.gms.internal.ads.zzdvh;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzegk;
import com.google.android.gms.internal.ads.zzegl;
import com.google.android.gms.internal.ads.zzehd;
import com.google.android.gms.internal.ads.zzehf;
import com.google.android.gms.internal.ads.zzfuz;
import com.google.android.gms.internal.ads.zzgmu;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zzm extends zzbvh implements zzah {

    @VisibleForTesting
    static final int zza = Color.argb(0, 0, 0, 0);
    public static final /* synthetic */ int zzo = 0;
    protected final Activity zzb;

    @Nullable
    @VisibleForTesting
    AdOverlayInfoParcel zzc;

    @VisibleForTesting
    zzcgy zzd;

    @VisibleForTesting
    zzj zze;

    @VisibleForTesting
    zzu zzf;

    @VisibleForTesting
    FrameLayout zzh;

    @VisibleForTesting
    WebChromeClient.CustomViewCallback zzi;

    @VisibleForTesting
    zzi zzl;
    private Runnable zzr;
    private boolean zzs;
    private boolean zzt;
    private Toolbar zzx;

    @VisibleForTesting
    boolean zzg = false;

    @VisibleForTesting
    boolean zzj = false;

    @VisibleForTesting
    boolean zzk = false;

    @VisibleForTesting
    boolean zzm = false;

    @VisibleForTesting
    int zzn = 1;
    private final Object zzp = new Object();
    private final View.OnClickListener zzq = new zzd(this);
    private boolean zzu = false;
    private boolean zzv = false;
    private boolean zzw = true;

    public zzm(Activity activity) {
        this.zzb = activity;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzJ(android.content.res.Configuration r7) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzJ(android.content.res.Configuration):void");
    }

    private final void zzK(View view) {
        zzehf zzehfVarZzU;
        zzehd zzehdVarZzV;
        zzcgy zzcgyVar = this.zzd;
        if (zzcgyVar == null) {
            return;
        }
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzfS)).booleanValue() && (zzehdVarZzV = zzcgyVar.zzV()) != null) {
            zzehdVarZzV.zzf(view);
        } else if (((Boolean) zzbd.zzc().zzd(zzbeu.zzfR)).booleanValue() && (zzehfVarZzU = zzcgyVar.zzU()) != null && zzehfVarZzU.zzb()) {
            com.google.android.gms.ads.internal.zzt.zzu().zzg(zzehfVarZzU.zza(), view);
        }
    }

    private static final void zzL(@Nullable zzehf zzehfVar, @Nullable View view) {
        if (zzehfVar == null || view == null) {
            return;
        }
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzfR)).booleanValue() && zzehfVar.zzb()) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzu().zzh(zzehfVar.zza(), view);
    }

    public final void zzA() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzr zzrVar;
        if (!this.zzb.isFinishing() || this.zzu) {
            return;
        }
        this.zzu = true;
        zzcgy zzcgyVar = this.zzd;
        if (zzcgyVar != null) {
            zzcgyVar.zzH(this.zzn - 1);
            synchronized (this.zzp) {
                try {
                    if (!this.zzs && this.zzd.zzaa()) {
                        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzfD)).booleanValue() && !this.zzv && (adOverlayInfoParcel = this.zzc) != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
                            zzrVar.zzdX();
                        }
                        Runnable runnable = new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzf
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zzB();
                            }
                        };
                        this.zzr = runnable;
                        com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(runnable, ((Long) zzbd.zzc().zzd(zzbeu.zzbp)).longValue());
                        return;
                    }
                } finally {
                }
            }
        }
        zzB();
    }

    @VisibleForTesting
    public final void zzB() {
        zzcgy zzcgyVar;
        zzr zzrVar;
        if (this.zzv) {
            return;
        }
        this.zzv = true;
        zzcgy zzcgyVar2 = this.zzd;
        if (zzcgyVar2 != null) {
            this.zzl.removeView(zzcgyVar2.zzE());
            zzj zzjVar = this.zze;
            if (zzjVar != null) {
                this.zzd.zzai(zzjVar.zzd);
                this.zzd.zzag(false);
                if (((Boolean) zzbd.zzc().zzd(zzbeu.zznI)).booleanValue() && this.zzd.getParent() != null) {
                    ((ViewGroup) this.zzd.getParent()).removeView(this.zzd.zzE());
                }
                ViewGroup viewGroup = this.zze.zzc;
                View viewZzE = this.zzd.zzE();
                zzj zzjVar2 = this.zze;
                viewGroup.addView(viewZzE, zzjVar2.zza, zzjVar2.zzb);
                this.zze = null;
            } else {
                Activity activity = this.zzb;
                if (activity.getApplicationContext() != null) {
                    this.zzd.zzai(activity.getApplicationContext());
                }
            }
            this.zzd = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzdY(this.zzn);
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
        if (adOverlayInfoParcel2 == null || (zzcgyVar = adOverlayInfoParcel2.zzd) == null) {
            return;
        }
        zzL(zzcgyVar.zzU(), this.zzc.zzd.zzE());
    }

    public final void zzC() {
        if (this.zzm) {
            this.zzm = false;
            zzD();
        }
    }

    public final void zzD() {
        this.zzd.zzI();
    }

    public final void zzE() {
        this.zzl.zzb = true;
    }

    public final void zzF() {
        synchronized (this.zzp) {
            try {
                this.zzs = true;
                Runnable runnable = this.zzr;
                if (runnable != null) {
                    zzfuz zzfuzVar = com.google.android.gms.ads.internal.util.zzs.zza;
                    zzfuzVar.removeCallbacks(runnable);
                    zzfuzVar.post(this.zzr);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzG(zzegl zzeglVar) throws RemoteException, zzh {
        zzbvb zzbvbVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzbvbVar = adOverlayInfoParcel.zzv) == null) {
            throw new zzh("noioou");
        }
        zzbvbVar.zzh(ObjectWrapper.wrap(zzeglVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzH(int i2, String[] strArr, int[] iArr) {
        if (i2 == 12345) {
            Activity activity = this.zzb;
            zzegk zzegkVarZze = zzegl.zze();
            zzegkVarZze.zza(activity);
            zzegkVarZze.zzb(this.zzc.zzk == 5 ? this : null);
            try {
                this.zzc.zzv.zzi(strArr, iArr, ObjectWrapper.wrap(zzegkVarZze.zze()));
            } catch (RemoteException unused) {
            }
        }
    }

    public final void zzb() {
        this.zzn = 3;
        Activity activity = this.zzb;
        activity.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || adOverlayInfoParcel.zzk != 5) {
            return;
        }
        activity.overridePendingTransition(0, 0);
        zzcgy zzcgyVar = this.zzd;
        if (zzcgyVar != null) {
            zzcgyVar.zzae(null);
        }
    }

    public final void zzc() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            zzw(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView(this.zzl);
            this.zzt = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzi;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzah
    public final void zzd() {
        this.zzn = 2;
        this.zzb.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zze() {
        this.zzn = 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzf() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzrVar = adOverlayInfoParcel.zzc) == null) {
            return;
        }
        zzrVar.zzdA();
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final boolean zzg() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzjT)).booleanValue() && this.zzd.canGoBack()) {
            this.zzd.goBack();
            return false;
        }
        boolean zZzZ = this.zzd.zzZ();
        if (!zZzZ) {
            this.zzd.zze("onbackblocked", Collections.EMPTY_MAP);
        }
        return zZzZ;
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public void zzh(Bundle bundle) {
        zzr zzrVar;
        if (!this.zzt) {
            this.zzb.requestWindowFeature(1);
        }
        this.zzj = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            Activity activity = this.zzb;
            AdOverlayInfoParcel adOverlayInfoParcelZza = AdOverlayInfoParcel.zza(activity.getIntent());
            this.zzc = adOverlayInfoParcelZza;
            if (adOverlayInfoParcelZza == null) {
                throw new zzh("Could not get info for ad overlay.");
            }
            if (adOverlayInfoParcelZza.zzw) {
                if (Build.VERSION.SDK_INT >= 28) {
                    activity.setShowWhenLocked(true);
                } else {
                    activity.getWindow().addFlags(524288);
                }
            }
            if (this.zzc.zzm.clientJarVersion > 7500000) {
                this.zzn = 4;
            }
            if (activity.getIntent() != null) {
                this.zzw = activity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
            com.google.android.gms.ads.internal.zzl zzlVar = adOverlayInfoParcel.zzo;
            if (zzlVar != null) {
                boolean z2 = zzlVar.zza;
                this.zzk = z2;
                if (z2) {
                    if (adOverlayInfoParcel.zzk != 5 && zzlVar.zzf != -1) {
                        new zzl(this, null).zzb();
                    }
                }
            } else if (adOverlayInfoParcel.zzk == 5) {
                this.zzk = true;
                if (adOverlayInfoParcel.zzk != 5) {
                    new zzl(this, null).zzb();
                }
            } else {
                this.zzk = false;
            }
            if (bundle == null) {
                if (this.zzw) {
                    zzczb zzczbVar = this.zzc.zzt;
                    if (zzczbVar != null) {
                        zzczbVar.zza();
                    }
                    zzr zzrVar2 = this.zzc.zzc;
                    if (zzrVar2 != null) {
                        zzrVar2.zzh();
                    }
                }
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                if (adOverlayInfoParcel2.zzk != 1) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel2.zzb;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                    }
                    zzdgv zzdgvVar = this.zzc.zzu;
                    if (zzdgvVar != null) {
                        zzdgvVar.zzdz();
                    }
                }
            }
            AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
            if (adOverlayInfoParcel3 != null && (zzrVar = adOverlayInfoParcel3.zzc) != null) {
                zzrVar.zzdt();
            }
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.zzc;
            zzi zziVar = new zzi(activity, adOverlayInfoParcel4.zzn, adOverlayInfoParcel4.zzm.afmaVersion, adOverlayInfoParcel4.zzs);
            this.zzl = zziVar;
            zziVar.setId(1000);
            com.google.android.gms.ads.internal.zzt.zzf().zzj(activity);
            AdOverlayInfoParcel adOverlayInfoParcel5 = this.zzc;
            int i2 = adOverlayInfoParcel5.zzk;
            if (i2 == 1) {
                zzy(false);
                return;
            }
            if (i2 == 2) {
                this.zze = new zzj(adOverlayInfoParcel5.zzd);
                zzy(false);
            } else if (i2 == 3) {
                zzy(true);
            } else {
                if (i2 != 5) {
                    throw new zzh("Could not determine ad overlay type.");
                }
                zzy(false);
            }
        } catch (zzh e) {
            String message = e.getMessage();
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(message);
            this.zzn = 4;
            this.zzb.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzi() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzrVar = adOverlayInfoParcel.zzc) == null) {
            return;
        }
        zzrVar.zzdv();
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzj() {
        zzr zzrVar;
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzfF)).booleanValue()) {
            zzcgy zzcgyVar = this.zzd;
            if (zzcgyVar == null || zzcgyVar.zzX()) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzrVar = adOverlayInfoParcel.zzc) == null) {
            return;
        }
        zzrVar.zzdu();
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzk() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzdC();
        }
        zzJ(this.zzb.getResources().getConfiguration());
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzfF)).booleanValue()) {
            return;
        }
        zzcgy zzcgyVar = this.zzd;
        if (zzcgyVar != null && !zzcgyVar.zzX()) {
            this.zzd.onResume();
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("The webview does not exist. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzl() {
        zzr zzrVar;
        zzc();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzdB();
        }
        if (!((Boolean) zzbd.zzc().zzd(zzbeu.zzfF)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzm(int i2, int i8, Intent intent) {
        zzdvi zzdviVarZzI;
        AdOverlayInfoParcel adOverlayInfoParcel;
        if (i2 == 236) {
            zzbel zzbelVar = zzbeu.zzog;
            if (((Boolean) zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
                StringBuilder sb = new StringBuilder(String.valueOf(i8).length() + 66);
                sb.append("Callback from intent launch with requestCode: 236 and resultCode: ");
                sb.append(i8);
                com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
                zzcgy zzcgyVar = this.zzd;
                if (zzcgyVar == null || zzcgyVar.zzP() == null || (zzdviVarZzI = zzcgyVar.zzP().zzI()) == null || (adOverlayInfoParcel = this.zzc) == null || !((Boolean) zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
                    return;
                }
                zzdvh zzdvhVarZza = zzdviVarZzI.zza();
                zzdvhVarZza.zzc("action", "hilca");
                zzdvhVarZza.zzc("gqi", zzgmu.zza(adOverlayInfoParcel.zzq));
                StringBuilder sb2 = new StringBuilder(String.valueOf(i8).length());
                sb2.append(i8);
                zzdvhVarZza.zzc("hilr", sb2.toString());
                if (i8 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("callerPackage");
                    String stringExtra2 = intent.getStringExtra("loadingStage");
                    if (stringExtra != null) {
                        zzdvhVarZza.zzc("hilcp", stringExtra);
                    }
                    if (stringExtra2 != null) {
                        zzdvhVarZza.zzc("hills", stringExtra2);
                    }
                }
                zzdvhVarZza.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzn(IObjectWrapper iObjectWrapper) {
        zzJ((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzo(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzp() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzdD();
        }
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzfF)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzq() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzdE();
        }
        zzcgy zzcgyVar = this.zzd;
        if (zzcgyVar != null) {
            try {
                this.zzl.removeView(zzcgyVar.zzE());
            } catch (NullPointerException unused) {
            }
        }
        zzA();
    }

    public final void zzr(boolean z2) {
        if (this.zzc.zzw) {
            return;
        }
        int iIntValue = ((Integer) zzbd.zzc().zzd(zzbeu.zzfI)).intValue();
        boolean z7 = ((Boolean) zzbd.zzc().zzd(zzbeu.zzbs)).booleanValue() || z2;
        zzt zztVar = new zzt();
        zztVar.zzd = 50;
        zztVar.zza = true != z7 ? 0 : iIntValue;
        zztVar.zzb = true != z7 ? iIntValue : 0;
        zztVar.zzc = iIntValue;
        this.zzf = new zzu(this.zzb, zztVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(true != z7 ? 9 : 11);
        zzt(z2, this.zzc.zzg);
        this.zzl.addView(this.zzf, layoutParams);
        zzK(this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzs() {
        this.zzt = true;
    }

    public final void zzt(boolean z2, boolean z7) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzl zzlVar;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        com.google.android.gms.ads.internal.zzl zzlVar2;
        boolean z8 = true;
        boolean z9 = ((Boolean) zzbd.zzc().zzd(zzbeu.zzbq)).booleanValue() && (adOverlayInfoParcel2 = this.zzc) != null && (zzlVar2 = adOverlayInfoParcel2.zzo) != null && zzlVar2.zzh;
        boolean z10 = ((Boolean) zzbd.zzc().zzd(zzbeu.zzbr)).booleanValue() && (adOverlayInfoParcel = this.zzc) != null && (zzlVar = adOverlayInfoParcel.zzo) != null && zzlVar.zzi;
        if (z2 && z7 && z9 && !z10) {
            new zzbun(this.zzd, "useCustomClose").zzg("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzu zzuVar = this.zzf;
        if (zzuVar != null) {
            if (!z10 && (!z7 || z9)) {
                z8 = false;
            }
            zzuVar.zza(z8);
        }
    }

    public final void zzu(boolean z2) {
        if (z2) {
            this.zzl.setBackgroundColor(0);
        } else {
            this.zzl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    public final void zzv() {
        this.zzl.removeView(this.zzf);
        zzr(true);
    }

    public final void zzw(int i2) {
        Activity activity = this.zzb;
        if (activity.getApplicationInfo().targetSdkVersion >= ((Integer) zzbd.zzc().zzd(zzbeu.zzgA)).intValue()) {
            if (activity.getApplicationInfo().targetSdkVersion <= ((Integer) zzbd.zzc().zzd(zzbeu.zzgB)).intValue()) {
                int i8 = Build.VERSION.SDK_INT;
                if (i8 >= ((Integer) zzbd.zzc().zzd(zzbeu.zzgC)).intValue()) {
                    if (i8 <= ((Integer) zzbd.zzc().zzd(zzbeu.zzgD)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            activity.setRequestedOrientation(i2);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.zzh().zzh(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zzx(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Activity activity = this.zzb;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.zzh = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzh.addView(view, -1, -1);
        activity.setContentView(this.zzh);
        this.zzt = true;
        this.zzi = customViewCallback;
        this.zzg = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzy(boolean r44) throws com.google.android.gms.ads.internal.overlay.zzh {
        /*
            Method dump skipped, instruction units count: 803
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzy(boolean):void");
    }

    public final void zzz(String str) {
        Toolbar toolbar = this.zzx;
        if (toolbar != null) {
            toolbar.setSubtitle(str);
        }
    }
}
