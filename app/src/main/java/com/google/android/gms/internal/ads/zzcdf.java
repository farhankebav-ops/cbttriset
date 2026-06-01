package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.internal.Preconditions;
import com.ironsource.C2300e4;
import com.onesignal.session.internal.influence.impl.InfluenceConstants;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcdf extends FrameLayout implements zzccw {

    @VisibleForTesting
    final zzcdt zza;
    private final zzcdr zzb;
    private final FrameLayout zzc;
    private final View zzd;
    private final zzbfj zze;
    private final long zzf;

    @Nullable
    private final zzccx zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private String zzn;
    private String[] zzo;
    private Bitmap zzp;
    private final ImageView zzq;
    private boolean zzr;

    public zzcdf(Context context, zzcdr zzcdrVar, int i2, boolean z2, zzbfj zzbfjVar, zzcdq zzcdqVar, @Nullable zzdvi zzdviVar) {
        zzccx zzccvVar;
        zzbfj zzbfjVar2;
        zzccx zzcgnVar;
        super(context);
        this.zzb = zzcdrVar;
        this.zze = zzbfjVar;
        FrameLayout frameLayout = new FrameLayout(context);
        this.zzc = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzcdrVar.zzk());
        zzccy zzccyVar = zzcdrVar.zzk().zza;
        zzcds zzcdsVar = new zzcds(context, zzcdrVar.zzs(), zzcdrVar.zzm(), zzbfjVar, zzcdrVar.zzi());
        if (i2 == 3) {
            zzcgnVar = new zzcgn(context, zzcdsVar);
            zzbfjVar2 = zzbfjVar;
        } else {
            if (i2 == 2) {
                zzccvVar = new zzcej(context, zzcdsVar, zzcdrVar, z2, zzccy.zza(zzcdrVar), zzcdqVar, zzdviVar);
                zzbfjVar2 = zzbfjVar;
            } else {
                zzbfjVar2 = zzbfjVar;
                zzccvVar = new zzccv(context, zzcdrVar, z2, zzccy.zza(zzcdrVar), zzcdqVar, new zzcds(context, zzcdrVar.zzs(), zzcdrVar.zzm(), zzbfjVar, zzcdrVar.zzi()), zzdviVar);
            }
            zzcgnVar = zzccvVar;
        }
        this.zzg = zzcgnVar;
        View view = new View(context);
        this.zzd = view;
        view.setBackgroundColor(0);
        frameLayout.addView(zzcgnVar, new FrameLayout.LayoutParams(-1, -1, 17));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaa)).booleanValue()) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(view);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzX)).booleanValue()) {
            zzD();
        }
        this.zzq = new ImageView(context);
        this.zzf = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzac)).longValue();
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzZ)).booleanValue();
        this.zzk = zBooleanValue;
        if (zzbfjVar2 != null) {
            zzbfjVar2.zzd("spinner_used", true != zBooleanValue ? "0" : "1");
        }
        this.zza = new zzcdt(this);
        zzcgnVar.zzb(this);
    }

    private final boolean zzJ() {
        return this.zzq.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzK, reason: merged with bridge method [inline-methods] */
    public final void zzI(String str, String... strArr) {
        HashMap map = new HashMap();
        Integer numZzl = zzl();
        if (numZzl != null) {
            map.put("playerId", numZzl.toString());
        }
        map.put(NotificationCompat.CATEGORY_EVENT, str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                map.put(str2, str3);
                str2 = null;
            }
        }
        this.zzb.zze("onVideoEvent", map);
    }

    private final void zzL() {
        zzcdr zzcdrVar = this.zzb;
        if (zzcdrVar.zzj() == null || !this.zzi || this.zzj) {
            return;
        }
        zzcdrVar.zzj().getWindow().clearFlags(128);
        this.zzi = false;
    }

    public final void finalize() throws Throwable {
        try {
            this.zza.zza();
            final zzccx zzccxVar = this.zzg;
            if (zzccxVar != null) {
                zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdc
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzccxVar.zzd();
                    }
                });
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            this.zza.zzb();
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcde
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzG(z2);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzccw
    public final void onWindowVisibilityChanged(int i2) {
        boolean z2;
        super.onWindowVisibilityChanged(i2);
        if (i2 == 0) {
            this.zza.zzb();
            z2 = true;
        } else {
            this.zza.zza();
            this.zzm = this.zzl;
            z2 = false;
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcdb(this, z2));
    }

    public final void zzA(int i2) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzB(i2);
    }

    public final void zzB(int i2) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzC(i2);
    }

    public final void zzC(MotionEvent motionEvent) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.dispatchTouchEvent(motionEvent);
    }

    public final void zzD() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        TextView textView = new TextView(zzccxVar.getContext());
        Resources resourcesZzf = com.google.android.gms.ads.internal.zzt.zzh().zzf();
        textView.setText(String.valueOf(resourcesZzf == null ? "AdMob - " : resourcesZzf.getString(R.string.watermark_label_prefix)).concat(zzccxVar.zza()));
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
        FrameLayout frameLayout = this.zzc;
        frameLayout.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        frameLayout.bringChildToFront(textView);
    }

    public final void zzE() {
        this.zza.zza();
        zzccx zzccxVar = this.zzg;
        if (zzccxVar != null) {
            zzccxVar.zzd();
        }
        zzL();
    }

    public final void zzF() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        long jZzh = zzccxVar.zzh();
        if (this.zzl == jZzh || jZzh <= 0) {
            return;
        }
        float f4 = jZzh / 1000.0f;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzch)).booleanValue()) {
            zzI("timeupdate", InfluenceConstants.TIME, String.valueOf(f4), "totalBytes", String.valueOf(zzccxVar.zzo()), "qoeCachedBytes", String.valueOf(zzccxVar.zzn()), "qoeLoadedBytes", String.valueOf(zzccxVar.zzm()), "droppedFrames", String.valueOf(zzccxVar.zzp()), "reportTime", String.valueOf(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis()));
        } else {
            zzI("timeupdate", InfluenceConstants.TIME, String.valueOf(f4));
        }
        this.zzl = jZzh;
    }

    public final /* synthetic */ void zzG(boolean z2) {
        zzI("windowFocusChanged", "hasWindowFocus", String.valueOf(z2));
    }

    public final /* synthetic */ void zzH() {
        zzI("firstFrameRendered", new String[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zza() {
        this.zza.zzb();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzccz(this));
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzb() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar != null && this.zzm == 0) {
            zzI("canplaythrough", "duration", String.valueOf(zzccxVar.zzg() / 1000.0f), "videoWidth", String.valueOf(zzccxVar.zzk()), "videoHeight", String.valueOf(zzccxVar.zzl()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcj)).booleanValue()) {
            this.zza.zzb();
        }
        zzcdr zzcdrVar = this.zzb;
        if (zzcdrVar.zzj() != null && !this.zzi) {
            boolean z2 = (zzcdrVar.zzj().getWindow().getAttributes().flags & 128) != 0;
            this.zzj = z2;
            if (!z2) {
                zzcdrVar.zzj().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzd() {
        zzI("pause", new String[0]);
        zzL();
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcj)).booleanValue()) {
            this.zza.zza();
        }
        zzI(C2300e4.h.g0, new String[0]);
        zzL();
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzf(String str, @Nullable String str2) {
        zzI("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzg(String str, @Nullable String str2) {
        zzI("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzh() {
        if (this.zzr && this.zzp != null && !zzJ()) {
            ImageView imageView = this.zzq;
            imageView.setImageBitmap(this.zzp);
            imageView.invalidate();
            FrameLayout frameLayout = this.zzc;
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(imageView);
        }
        this.zza.zza();
        this.zzm = this.zzl;
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcda(this));
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzi() {
        if (this.zzh && zzJ()) {
            this.zzc.removeView(this.zzq);
        }
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null || this.zzp == null) {
            return;
        }
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
        if (zzccxVar.getBitmap(this.zzp) != null) {
            this.zzr = true;
        }
        long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            StringBuilder sb = new StringBuilder(String.valueOf(jElapsedRealtime2).length() + 26);
            sb.append("Spinner frame grab took ");
            sb.append(jElapsedRealtime2);
            sb.append("ms");
            com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
        }
        if (jElapsedRealtime2 > this.zzf) {
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Spinner frame grab crossed jank threshold! Suspending spinner.");
            this.zzk = false;
            this.zzp = null;
            zzbfj zzbfjVar = this.zze;
            if (zzbfjVar != null) {
                zzbfjVar.zzd("spinner_jank", Long.toString(jElapsedRealtime2));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzj(int i2, int i8) {
        if (this.zzk) {
            zzbel zzbelVar = zzbeu.zzab;
            int iMax = Math.max(i2 / ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).intValue(), 1);
            int iMax2 = Math.max(i8 / ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap != null && bitmap.getWidth() == iMax && this.zzp.getHeight() == iMax2) {
                return;
            }
            this.zzp = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
            this.zzr = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final void zzk() {
        this.zzd.setVisibility(4);
        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdd
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzH();
            }
        });
    }

    @Nullable
    public final Integer zzl() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar != null) {
            return zzccxVar.zzw();
        }
        return null;
    }

    public final void zzm(int i2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaa)).booleanValue()) {
            this.zzc.setBackgroundColor(i2);
            this.zzd.setBackgroundColor(i2);
        }
    }

    public final void zzn(int i2, int i8, int i9, int i10) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            int length = String.valueOf(i2).length();
            StringBuilder sb = new StringBuilder(length + 25 + String.valueOf(i8).length() + 3 + String.valueOf(i9).length() + 3 + String.valueOf(i10).length());
            com.google.android.gms.ads.internal.client.a.k(i2, i8, "Set video bounds to x:", ";y:", sb);
            sb.append(";w:");
            sb.append(i9);
            sb.append(";h:");
            sb.append(i10);
            com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
        }
        if (i9 == 0 || i10 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i9, i10);
        layoutParams.setMargins(i2, i8, 0, 0);
        this.zzc.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void zzo(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzp(float f4, float f8) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar != null) {
            zzccxVar.zzj(f4, f8);
        }
    }

    public final void zzq(Integer num) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        if (TextUtils.isEmpty(this.zzn)) {
            zzI("no_src", new String[0]);
        } else {
            zzccxVar.zzx(this.zzn, this.zzo, num);
        }
    }

    public final void zzr() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzf();
    }

    public final void zzs() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zze();
    }

    public final void zzt(int i2) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzi(i2);
    }

    public final void zzu() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzb.zza(true);
        zzccxVar.zzq();
    }

    public final void zzv() {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzb.zza(false);
        zzccxVar.zzq();
    }

    public final void zzw(float f4) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzb.zzb(f4);
        zzccxVar.zzq();
    }

    public final void zzx(int i2) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzy(i2);
    }

    public final void zzy(int i2) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzz(i2);
    }

    public final void zzz(int i2) {
        zzccx zzccxVar = this.zzg;
        if (zzccxVar == null) {
            return;
        }
        zzccxVar.zzA(i2);
    }
}
