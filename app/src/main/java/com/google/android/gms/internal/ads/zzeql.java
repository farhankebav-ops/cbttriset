package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeql implements zzeya {
    private final zzeya zza;
    private final zzfgn zzb;
    private final Context zzc;
    private final zzcbj zzd;

    public zzeql(zzeso zzesoVar, zzfgn zzfgnVar, Context context, zzcbj zzcbjVar) {
        this.zza = zzesoVar;
        this.zzb = zzfgnVar;
        this.zzc = context;
        this.zzd = zzcbjVar;
    }

    private final Insets zzd(float f4) {
        Window window;
        View decorView;
        WindowInsetsCompat rootWindowInsets;
        if (f4 == 0.0f) {
            return Insets.NONE;
        }
        Insets insets = Insets.NONE;
        if (Build.VERSION.SDK_INT >= 30) {
            WindowManager windowManager = (WindowManager) this.zzc.getSystemService("window");
            if (windowManager != null) {
                insets = Insets.toCompatInsets(windowManager.getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.statusBars() | WindowInsets.Type.displayCutout() | WindowInsets.Type.navigationBars() | WindowInsets.Type.captionBar()));
            }
        } else {
            Activity activityZzd = com.google.android.gms.ads.internal.zzt.zzg().zzd();
            if (activityZzd != null && (window = activityZzd.getWindow()) != null && (decorView = window.getDecorView()) != null && (rootWindowInsets = ViewCompat.getRootWindowInsets(decorView)) != null) {
                insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
            }
        }
        return Insets.of((int) Math.ceil(insets.left / f4), (int) Math.ceil(insets.top / f4), (int) Math.ceil(insets.right / f4), (int) Math.ceil(insets.bottom / f4));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return zzgui.zzk(this.zza.zza(), new zzglu() { // from class: com.google.android.gms.internal.ads.zzeqk
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzc((zzeyj) obj);
            }
        }, zzcbv.zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 7;
    }

    public final /* synthetic */ zzeqm zzc(zzeyj zzeyjVar) {
        String str;
        boolean z2;
        int i2;
        String strZzu;
        float f4;
        int i8;
        int i9;
        int i10;
        WindowManager windowManager;
        int iWidth;
        int iHeight;
        DisplayMetrics displayMetrics;
        zzfgn zzfgnVar = this.zzb;
        com.google.android.gms.ads.internal.client.zzr zzrVar = zzfgnVar.zzf;
        com.google.android.gms.ads.internal.client.zzr[] zzrVarArr = zzrVar.zzg;
        if (zzrVarArr != null) {
            str = null;
            z2 = false;
            boolean z7 = false;
            boolean z8 = false;
            for (com.google.android.gms.ads.internal.client.zzr zzrVar2 : zzrVarArr) {
                boolean z9 = zzrVar2.zzi;
                if (!z9 && !z7) {
                    str = zzrVar2.zza;
                    z7 = true;
                }
                if (z9) {
                    if (!z8) {
                        z2 = true;
                    }
                    z8 = true;
                }
                if (z7 && z8) {
                    break;
                }
            }
        } else {
            str = zzrVar.zza;
            z2 = zzrVar.zzi;
        }
        Context context = this.zzc;
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            i2 = 0;
            strZzu = null;
            f4 = 0.0f;
            i8 = 0;
        } else {
            zzcbj zzcbjVar = this.zzd;
            f4 = displayMetrics.density;
            i8 = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
            strZzu = zzcbjVar.zzo().zzu();
        }
        Insets insetsZzd = (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzop)).booleanValue() || Build.VERSION.SDK_INT < 35) ? null : zzd(f4);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoq)).booleanValue() && (i10 = Build.VERSION.SDK_INT) <= 34 && i10 >= 28 && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
            if (i10 >= 30) {
                WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                iWidth = currentWindowMetrics.getBounds().width();
                iHeight = currentWindowMetrics.getBounds().height();
            } else {
                Point point = new Point();
                windowManager.getDefaultDisplay().getRealSize(point);
                iWidth = point.x;
                iHeight = point.y;
            }
            i2 = iHeight;
            i8 = iWidth;
            insetsZzd = zzd(f4);
        }
        int i11 = i2;
        StringBuilder sb = new StringBuilder();
        if (zzrVarArr != null) {
            boolean z10 = false;
            for (com.google.android.gms.ads.internal.client.zzr zzrVar3 : zzrVarArr) {
                if (zzrVar3.zzi) {
                    z10 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    int i12 = zzrVar3.zze;
                    if (i12 == -1) {
                        i12 = f4 != 0.0f ? (int) (zzrVar3.zzf / f4) : -1;
                    }
                    sb.append(i12);
                    sb.append("x");
                    int i13 = zzrVar3.zzb;
                    if (i13 == -2) {
                        i13 = f4 != 0.0f ? (int) (zzrVar3.zzc / f4) : -2;
                    }
                    sb.append(i13);
                }
            }
            if (z10) {
                if (sb.length() != 0) {
                    i9 = 0;
                    sb.insert(0, "|");
                } else {
                    i9 = 0;
                }
                sb.insert(i9, "320x50");
            }
        }
        return new zzeqm(zzrVar, str, z2, sb.toString(), f4, i8, i11, strZzu, zzfgnVar.zzr, insetsZzd);
    }
}
