package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcej extends zzccx implements TextureView.SurfaceTextureListener, zzcdh {
    private final zzcdr zzc;
    private final zzcds zzd;
    private final zzcdq zze;

    @Nullable
    private final zzdvi zzf;
    private zzccw zzg;
    private Surface zzh;
    private zzcdi zzi;
    private String zzj;
    private String[] zzk;
    private boolean zzl;
    private int zzm;
    private zzcdp zzn;
    private final boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private int zzr;
    private int zzs;
    private float zzt;

    public zzcej(Context context, zzcds zzcdsVar, zzcdr zzcdrVar, boolean z2, boolean z7, zzcdq zzcdqVar, @Nullable zzdvi zzdviVar) {
        super(context);
        this.zzm = 1;
        this.zzc = zzcdrVar;
        this.zzd = zzcdsVar;
        this.zzo = z2;
        this.zze = zzcdqVar;
        zzcdsVar.zza(this);
        this.zzf = zzdviVar;
    }

    private final boolean zzT() {
        zzcdi zzcdiVar = this.zzi;
        return (zzcdiVar == null || !zzcdiVar.zzB() || this.zzl) ? false : true;
    }

    private final boolean zzU() {
        return zzT() && this.zzm != 1;
    }

    private final void zzV(boolean z2, @Nullable Integer num) {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null && !z2) {
            zzcdiVar.zzn(num);
            return;
        }
        if (this.zzj == null || this.zzh == null) {
            return;
        }
        if (z2) {
            if (!zzT()) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("No valid ExoPlayerAdapter exists when switch source.");
                return;
            } else {
                zzcdiVar.zzw();
                zzW();
            }
        }
        if (this.zzj.startsWith("cache:")) {
            zzcfe zzcfeVarZzr = this.zzc.zzr(this.zzj);
            if (zzcfeVarZzr instanceof zzcfn) {
                zzcdi zzcdiVarZza = ((zzcfn) zzcfeVarZzr).zza();
                this.zzi = zzcdiVarZza;
                zzcdiVarZza.zzn(num);
                if (!this.zzi.zzB()) {
                    int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Precached video player has been released.");
                    return;
                }
            } else {
                if (!(zzcfeVarZzr instanceof zzcfk)) {
                    String strValueOf = String.valueOf(this.zzj);
                    int i9 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Stream cache miss: ".concat(strValueOf));
                    return;
                }
                zzcfk zzcfkVar = (zzcfk) zzcfeVarZzr;
                String strZzF = zzF();
                ByteBuffer byteBufferZzu = zzcfkVar.zzu();
                boolean zZzt = zzcfkVar.zzt();
                String strZzs = zzcfkVar.zzs();
                if (strZzs == null) {
                    int i10 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Stream cache URL is null.");
                    return;
                } else {
                    zzcdi zzcdiVarZzE = zzE(num);
                    this.zzi = zzcdiVarZzE;
                    zzcdiVarZzE.zzr(new Uri[]{Uri.parse(strZzs)}, strZzF, byteBufferZzu, zZzt);
                }
            }
        } else {
            this.zzi = zzE(num);
            String strZzF2 = zzF();
            Uri[] uriArr = new Uri[this.zzk.length];
            int i11 = 0;
            while (true) {
                String[] strArr = this.zzk;
                if (i11 >= strArr.length) {
                    break;
                }
                uriArr[i11] = Uri.parse(strArr[i11]);
                i11++;
            }
            this.zzi.zzq(uriArr, strZzF2);
        }
        this.zzi.zzs(this);
        zzX(this.zzh, false);
        if (this.zzi.zzB()) {
            int iZzC = this.zzi.zzC();
            this.zzm = iZzC;
            if (iZzC == 3) {
                zzY();
            }
        }
    }

    private final void zzW() {
        if (this.zzi != null) {
            zzX(null, true);
            zzcdi zzcdiVar = this.zzi;
            if (zzcdiVar != null) {
                zzcdiVar.zzs(null);
                this.zzi.zzt();
                this.zzi = null;
            }
            this.zzm = 1;
            this.zzl = false;
            this.zzp = false;
            this.zzq = false;
        }
    }

    private final void zzX(Surface surface, boolean z2) {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Trying to set surface before player is initialized.");
            return;
        }
        try {
            zzcdiVar.zzu(surface, z2);
        } catch (IOException e) {
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("", e);
        }
    }

    private final void zzY() {
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzH();
            }
        });
        zzq();
        this.zzd.zzb();
        if (this.zzq) {
            zze();
        }
    }

    private static String zzZ(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        int length = String.valueOf(canonicalName).length();
        StringBuilder sb = new StringBuilder(str.length() + 1 + length + 1 + String.valueOf(message).length());
        androidx.camera.core.processing.util.a.A(sb, str, "/", canonicalName, ":");
        sb.append(message);
        return sb.toString();
    }

    private final void zzaa() {
        zzab(this.zzr, this.zzs);
    }

    private final void zzab(int i2, int i8) {
        float f4 = i8 > 0 ? i2 / i8 : 1.0f;
        if (this.zzt != f4) {
            this.zzt = f4;
            requestLayout();
        }
    }

    private final void zzac() {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            zzcdiVar.zzM(true);
        }
    }

    private final void zzad() {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            zzcdiVar.zzM(false);
        }
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setSurfaceTextureListener(this);
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f4 = this.zzt;
        if (f4 != 0.0f && this.zzn == null) {
            float f8 = measuredWidth;
            float f9 = f8 / measuredHeight;
            if (f4 > f9) {
                measuredHeight = (int) (f8 / f4);
            }
            if (f4 < f9) {
                measuredWidth = (int) (measuredHeight * f4);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzcdp zzcdpVar = this.zzn;
        if (zzcdpVar != null) {
            zzcdpVar.zzc(measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i8) {
        zzdvi zzdviVar;
        if (this.zzo) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzon)).booleanValue() && (zzdviVar = this.zzf) != null) {
                zzdvh zzdvhVarZza = zzdviVar.zza();
                zzdvhVarZza.zzc("action", "svp_aepv");
                zzdvhVarZza.zzd();
            }
            zzcdp zzcdpVar = new zzcdp(getContext());
            this.zzn = zzcdpVar;
            zzcdpVar.zzb(surfaceTexture, i2, i8);
            zzcdp zzcdpVar2 = this.zzn;
            zzcdpVar2.start();
            SurfaceTexture surfaceTextureZze = zzcdpVar2.zze();
            if (surfaceTextureZze != null) {
                surfaceTexture = surfaceTextureZze;
            } else {
                this.zzn.zzd();
                this.zzn = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzh = surface;
        if (this.zzi == null) {
            zzV(false, null);
        } else {
            zzX(surface, true);
            if (!this.zze.zza) {
                zzac();
            }
        }
        if (this.zzr == 0 || this.zzs == 0) {
            zzab(i2, i8);
        } else {
            zzaa();
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzced
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzM();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzf();
        zzcdp zzcdpVar = this.zzn;
        if (zzcdpVar != null) {
            zzcdpVar.zzd();
            this.zzn = null;
        }
        if (this.zzi != null) {
            zzad();
            Surface surface = this.zzh;
            if (surface != null) {
                surface.release();
            }
            this.zzh = null;
            zzX(null, true);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcef
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzO();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i2, final int i8) {
        zzcdp zzcdpVar = this.zzn;
        if (zzcdpVar != null) {
            zzcdpVar.zzc(i2, i8);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcee
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzN(i2, i8);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzd(this);
        this.zza.zzb(surfaceTexture, this.zzg);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(final int i2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 46);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i2);
        com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzceg
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzP(i2);
            }
        });
        super.onWindowVisibilityChanged(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzA(int i2) {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            zzcdiVar.zzy(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzB(int i2) {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            zzcdiVar.zzz(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzC(int i2) {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            zzcdiVar.zzA(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzD() {
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzS();
            }
        });
    }

    public final zzcdi zzE(@Nullable Integer num) {
        zzcdq zzcdqVar = this.zze;
        zzcdr zzcdrVar = this.zzc;
        zzcgg zzcggVar = new zzcgg(zzcdrVar.getContext(), zzcdqVar, zzcdrVar, num);
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("ExoPlayerAdapter initialized.");
        return zzcggVar;
    }

    public final String zzF() {
        zzcdr zzcdrVar = this.zzc;
        return com.google.android.gms.ads.internal.zzt.zzc().zze(zzcdrVar.getContext(), zzcdrVar.zzs().afmaVersion);
    }

    public final /* synthetic */ void zzG() {
        float fZzc = this.zzb.zzc();
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Trying to set volume before player is initialized.");
            return;
        }
        try {
            zzcdiVar.zzv(fZzc, false);
        } catch (IOException e) {
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("", e);
        }
    }

    public final /* synthetic */ void zzH() {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzb();
        }
    }

    public final /* synthetic */ void zzI() {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zze();
        }
    }

    public final /* synthetic */ void zzJ(String str) {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzf("ExoPlayerAdapter error", str);
        }
    }

    public final /* synthetic */ void zzK() {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzc();
        }
    }

    public final /* synthetic */ void zzL() {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzd();
        }
    }

    public final /* synthetic */ void zzM() {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zza();
        }
    }

    public final /* synthetic */ void zzN(int i2, int i8) {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzj(i2, i8);
        }
    }

    public final /* synthetic */ void zzO() {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzh();
        }
    }

    public final /* synthetic */ void zzP(int i2) {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.onWindowVisibilityChanged(i2);
        }
    }

    public final /* synthetic */ void zzQ(boolean z2, long j) {
        this.zzc.zzu(z2, j);
    }

    public final /* synthetic */ void zzR(String str) {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzg("ExoPlayerAdapter exception", str);
        }
    }

    public final /* synthetic */ void zzS() {
        zzccw zzccwVar = this.zzg;
        if (zzccwVar != null) {
            zzccwVar.zzk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final String zza() {
        return "ExoPlayer/2".concat(true != this.zzo ? "" : " spherical");
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzb(zzccw zzccwVar) {
        this.zzg = zzccwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzc(@Nullable String str) {
        if (str != null) {
            zzx(str, null, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzd() {
        if (zzT()) {
            this.zzi.zzw();
            zzW();
        }
        zzcds zzcdsVar = this.zzd;
        zzcdsVar.zzf();
        this.zzb.zze();
        zzcdsVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zze() {
        if (!zzU()) {
            this.zzq = true;
            return;
        }
        if (this.zze.zza) {
            zzac();
        }
        this.zzi.zzE(true);
        this.zzd.zze();
        this.zzb.zzd();
        this.zza.zza();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzceb
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzK();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzf() {
        if (zzU()) {
            if (this.zze.zza) {
                zzad();
            }
            this.zzi.zzE(false);
            this.zzd.zzf();
            this.zzb.zze();
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcec
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzL();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final int zzg() {
        if (zzU()) {
            return (int) this.zzi.zzH();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final int zzh() {
        if (zzU()) {
            return (int) this.zzi.zzD();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzi(int i2) {
        if (zzU()) {
            this.zzi.zzx(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzj(float f4, float f8) {
        zzcdp zzcdpVar = this.zzn;
        if (zzcdpVar != null) {
            zzcdpVar.zzf(f4, f8);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final int zzk() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final int zzl() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final long zzm() {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            return zzcdiVar.zzI();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final long zzn() {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            return zzcdiVar.zzJ();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final long zzo() {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            return zzcdiVar.zzK();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final int zzp() {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            return zzcdiVar.zzL();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzccx, com.google.android.gms.internal.ads.zzcdu
    public final void zzq() {
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcei
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzG();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzr(final boolean z2, final long j) {
        if (this.zzc != null) {
            zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzceh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzQ(z2, j);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzs(int i2) {
        if (this.zzm != i2) {
            this.zzm = i2;
            if (i2 == 3) {
                zzY();
                return;
            }
            if (i2 != 4) {
                return;
            }
            if (this.zze.zza) {
                zzad();
            }
            this.zzd.zzf();
            this.zzb.zze();
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdz
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzI();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzt(int i2, int i8) {
        this.zzr = i2;
        this.zzs = i8;
        zzaa();
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzu(String str, Exception exc) {
        final String strZzZ = zzZ(str, exc);
        String strConcat = "ExoPlayerAdapter error: ".concat(strZzZ);
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi(strConcat);
        this.zzl = true;
        if (this.zze.zza) {
            zzad();
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcea
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzJ(strZzZ);
            }
        });
        com.google.android.gms.ads.internal.zzt.zzh().zzh(exc, "AdExoPlayerView.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzv(String str, Exception exc) {
        final String strZzZ = zzZ("onLoadException", exc);
        String strConcat = "ExoPlayerAdapter exception: ".concat(strZzZ);
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi(strConcat);
        com.google.android.gms.ads.internal.zzt.zzh().zzh(exc, "AdExoPlayerView.onException");
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdx
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzR(strZzZ);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    @Nullable
    public final Integer zzw() {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            return zzcdiVar.zzj();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzx(@Nullable String str, @Nullable String[] strArr, @Nullable Integer num) {
        if (str == null) {
            return;
        }
        if (strArr == null) {
            this.zzk = new String[]{str};
        } else {
            this.zzk = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        String str2 = this.zzj;
        boolean z2 = false;
        if (this.zze.zzk && str2 != null && !str.equals(str2) && this.zzm == 4) {
            z2 = true;
        }
        this.zzj = str;
        zzV(z2, num);
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzy(int i2) {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            zzcdiVar.zzF(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccx
    public final void zzz(int i2) {
        zzcdi zzcdiVar = this.zzi;
        if (zzcdiVar != null) {
            zzcdiVar.zzG(i2);
        }
    }
}
