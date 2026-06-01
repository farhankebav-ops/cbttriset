package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdll extends zzcto {
    public static final zzgpe zzc = zzgpe.zzn("3010", "3008", "1005", "1009", "2011", "2007");
    private final List zzA;
    private final Executor zzd;
    private final zzdlq zze;
    private final zzdly zzf;
    private final zzdmp zzg;
    private final zzdlv zzh;
    private final zzdma zzi;
    private final zzifb zzj;
    private final zzifb zzk;
    private final zzifb zzl;
    private final zzifb zzm;
    private final zzifb zzn;

    @Nullable
    private zzdnn zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private final zzcac zzt;
    private final zzaxa zzu;
    private final VersionInfoParcel zzv;
    private final Context zzw;
    private final zzdln zzx;
    private final zzeow zzy;
    private final Map zzz;

    public zzdll(zzctn zzctnVar, Executor executor, zzdlq zzdlqVar, zzdly zzdlyVar, zzdmp zzdmpVar, zzdlv zzdlvVar, zzdma zzdmaVar, zzifb zzifbVar, zzifb zzifbVar2, zzifb zzifbVar3, zzifb zzifbVar4, zzifb zzifbVar5, zzcac zzcacVar, zzaxa zzaxaVar, VersionInfoParcel versionInfoParcel, Context context, zzdln zzdlnVar, zzeow zzeowVar, zzbax zzbaxVar) {
        super(zzctnVar);
        this.zzd = executor;
        this.zze = zzdlqVar;
        this.zzf = zzdlyVar;
        this.zzg = zzdmpVar;
        this.zzh = zzdlvVar;
        this.zzi = zzdmaVar;
        this.zzj = zzifbVar;
        this.zzk = zzifbVar2;
        this.zzl = zzifbVar3;
        this.zzm = zzifbVar4;
        this.zzn = zzifbVar5;
        this.zzt = zzcacVar;
        this.zzu = zzaxaVar;
        this.zzv = versionInfoParcel;
        this.zzw = context;
        this.zzx = zzdlnVar;
        this.zzy = zzeowVar;
        this.zzz = new HashMap();
        this.zzA = new ArrayList();
    }

    public static boolean zzI(View view) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlE)).booleanValue()) {
            return view.isShown() && view.getGlobalVisibleRect(new Rect(), new Point());
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        long jZzA = com.google.android.gms.ads.internal.util.zzs.zzA(view);
        if (view.isShown() && view.getGlobalVisibleRect(new Rect(), new Point())) {
            if (jZzA >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlF)).intValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzac, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzU(zzdnn zzdnnVar) {
        Iterator<String> itKeys;
        View view;
        zzawv zzawvVarZzb;
        try {
            if (!this.zzp) {
                this.zzo = zzdnnVar;
                this.zzg.zza(zzdnnVar);
                this.zzf.zza(zzdnnVar.zzdJ(), zzdnnVar.zzk(), zzdnnVar.zzl(), zzdnnVar, zzdnnVar);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcZ)).booleanValue() && (zzawvVarZzb = this.zzu.zzb()) != null) {
                    zzawvVarZzb.zzh(zzdnnVar.zzdJ());
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcb)).booleanValue()) {
                    zzffu zzffuVar = this.zzb;
                    if (zzffuVar.zzak && (itKeys = zzffuVar.zzaj.keys()) != null) {
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            zzdnn zzdnnVar2 = this.zzo;
                            WeakReference weakReference = zzdnnVar2 == null ? null : (WeakReference) zzdnnVar2.zzj().get(next);
                            this.zzz.put(next, Boolean.FALSE);
                            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                                zzbaw zzbawVar = new zzbaw(this.zzw, view);
                                this.zzA.add(zzbawVar);
                                zzbawVar.zza(new zzdla(this, next));
                            }
                        }
                    }
                }
                if (zzdnnVar.zzh() != null) {
                    zzdnnVar.zzh().zza(this.zzt);
                }
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzad, reason: merged with bridge method [inline-methods] */
    public final void zzV(zzdnn zzdnnVar) {
        this.zzf.zzb(zzdnnVar.zzdJ(), zzdnnVar.zzj());
        if (zzdnnVar.zzdF() != null) {
            zzdnnVar.zzdF().setClickable(false);
            zzdnnVar.zzdF().removeAllViews();
        }
        if (zzdnnVar.zzh() != null) {
            zzdnnVar.zzh().zzb(this.zzt);
        }
        this.zzo = null;
    }

    private final synchronized void zzae(View view, Map map, Map map2) {
        this.zzg.zzc(this.zzo);
        this.zzf.zzw(view, map, map2, zzah());
        this.zzq = true;
    }

    private final synchronized void zzaf(View view, Map map, Map map2) {
        View viewZzag;
        if (!this.zzr && (viewZzag = zzag(map)) != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoy)).booleanValue()) {
                Rect rect = new Rect();
                if (viewZzag.getGlobalVisibleRect(rect, new Point()) && viewZzag.getHeight() == rect.height() && viewZzag.getWidth() == rect.width()) {
                    this.zzf.zzx(view, map, map2, zzah());
                    this.zzr = true;
                }
            } else if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoz)).booleanValue()) {
                zzbel zzbelVar = zzbeu.zzoA;
                if (((Float) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).floatValue() > 0.0d) {
                    double dFloatValue = ((Float) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).floatValue();
                    if (viewZzag.getGlobalVisibleRect(new Rect(), new Point())) {
                        if (r1.height() * r1.width() >= ((double) (viewZzag.getHeight() * viewZzag.getWidth())) * (dFloatValue / 100.0d)) {
                            this.zzf.zzx(view, map, map2, zzah());
                            this.zzr = true;
                        }
                    }
                }
            } else if (zzI(viewZzag)) {
                this.zzf.zzx(view, map, map2, zzah());
                this.zzr = true;
            }
        }
    }

    @Nullable
    private final synchronized View zzag(Map map) {
        if (map != null) {
            zzgpe zzgpeVar = zzc;
            int size = zzgpeVar.size();
            int i2 = 0;
            while (i2 < size) {
                WeakReference weakReference = (WeakReference) map.get((String) zzgpeVar.get(i2));
                i2++;
                if (weakReference != null) {
                    return (View) weakReference.get();
                }
            }
        }
        return null;
    }

    @Nullable
    private final synchronized ImageView.ScaleType zzah() {
        zzdnn zzdnnVar = this.zzo;
        if (zzdnnVar == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("Ad should be associated with an ad view before calling getMediaviewScaleType()");
            return null;
        }
        IObjectWrapper iObjectWrapperZzo = zzdnnVar.zzo();
        if (iObjectWrapperZzo != null) {
            return (ImageView.ScaleType) ObjectWrapper.unwrap(iObjectWrapperZzo);
        }
        return zzdmp.zza;
    }

    private final void zzai(String str, boolean z2) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfW)).booleanValue()) {
            zzL("Google", true);
            return;
        }
        j2.q qVarZzX = this.zze.zzX();
        if (qVarZzX == null) {
            return;
        }
        zzgui.zzr(qVarZzX, new zzdlb(this, "Google", true), this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaj, reason: merged with bridge method [inline-methods] */
    public final void zzY(View view, @Nullable zzehf zzehfVar) {
        zzcgy zzcgyVarZzW = this.zze.zzW();
        if (!this.zzh.zzd() || zzehfVar == null || zzcgyVarZzW == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzu().zzh(zzehfVar.zza(), view);
    }

    public final synchronized void zzA(@Nullable com.google.android.gms.ads.internal.client.zzdj zzdjVar) {
        this.zzf.zzr(zzdjVar);
    }

    public final synchronized void zzB(com.google.android.gms.ads.internal.client.zzdf zzdfVar) {
        this.zzf.zzs(zzdfVar);
    }

    public final synchronized void zzC() {
        this.zzf.zzg();
    }

    public final synchronized void zzD() {
        zzdnn zzdnnVar = this.zzo;
        if (zzdnnVar == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            final boolean z2 = zzdnnVar instanceof zzdmj;
            this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdlg
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzW(z2);
                }
            });
        }
    }

    public final synchronized void zzE(@Nullable final View view, final int i2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmA)).booleanValue()) {
            zzdnn zzdnnVar = this.zzo;
            if (zzdnnVar == null) {
                int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzd("Ad should be associated with an ad view before calling performClickForCustomGesture()");
            } else {
                final boolean z2 = zzdnnVar instanceof zzdmj;
                this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdlh
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzX(view, z2, i2);
                    }
                });
            }
        }
    }

    public final synchronized boolean zzF() {
        return this.zzf.zzh();
    }

    public final synchronized int zzG() {
        return this.zzf.zzu();
    }

    public final synchronized boolean zzH() {
        return this.zzf.zzv();
    }

    public final boolean zzJ() {
        return this.zzh.zzc();
    }

    public final String zzK() {
        return this.zzh.zzf();
    }

    @Nullable
    public final zzehf zzL(String str, boolean z2) {
        boolean z7;
        String str2;
        zzehb zzehbVar;
        zzehc zzehcVar;
        zzdlv zzdlvVar = this.zzh;
        if (zzdlvVar.zzd() && !TextUtils.isEmpty(str)) {
            zzdlq zzdlqVar = this.zze;
            zzcgy zzcgyVarZzW = zzdlqVar.zzW();
            zzcgy zzcgyVarZzT = zzdlqVar.zzT();
            if (zzcgyVarZzW == null && zzcgyVarZzT == null) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid display and video webview are null. Skipping initialization.");
                return null;
            }
            zzdlvVar.zzg();
            int iZzc = zzdlvVar.zzg().zzc();
            int i8 = iZzc - 1;
            boolean z8 = false;
            if (i8 != 0) {
                if (i8 != 1) {
                    String str3 = iZzc != 1 ? iZzc != 2 ? "UNKNOWN" : "DISPLAY" : "VIDEO";
                    String strS = a1.a.s(new StringBuilder(str3.length() + 49), "Unknown omid media type: ", str3, ". Not initializing Omid.");
                    int i9 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi(strS);
                    return null;
                }
                if (zzcgyVarZzW == null) {
                    int i10 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid media type was display but there was no display webview.");
                    return null;
                }
                z7 = false;
                z8 = true;
            } else if (zzcgyVarZzT != null) {
                z7 = true;
            } else {
                int i11 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid media type was video but there was no video webview.");
            }
            if (z8) {
                str2 = null;
            } else {
                str2 = "javascript";
                zzcgyVarZzW = zzcgyVarZzT;
            }
            if (zzcgyVarZzW == null) {
                int i12 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Webview is null in InternalNativeAd");
                return null;
            }
            if (!com.google.android.gms.ads.internal.zzt.zzu().zza(this.zzw)) {
                int i13 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Failed to initialize omid in InternalNativeAd");
                return null;
            }
            VersionInfoParcel versionInfoParcel = this.zzv;
            int i14 = versionInfoParcel.buddyApkVersion;
            int i15 = versionInfoParcel.clientJarVersion;
            StringBuilder sb = new StringBuilder(com.google.android.gms.ads.internal.client.a.a(i14, 1) + String.valueOf(i15).length());
            sb.append(i14);
            sb.append(".");
            sb.append(i15);
            String string = sb.toString();
            if (z7) {
                zzehbVar = zzehb.VIDEO;
                zzehcVar = zzehc.DEFINED_BY_JAVASCRIPT;
            } else {
                zzehbVar = zzehb.NATIVE_DISPLAY;
                zzehcVar = zzdlqVar.zzx() == 3 ? zzehc.UNSPECIFIED : zzehc.ONE_PIXEL;
            }
            zzehf zzehfVarZzd = com.google.android.gms.ads.internal.zzt.zzu().zzd(string, zzcgyVarZzW.zzD(), "", "javascript", str2, str, zzehcVar, zzehbVar, this.zzb.zzal);
            if (zzehfVarZzd == null) {
                int i16 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Failed to create omid session in InternalNativeAd");
                return null;
            }
            zzdlqVar.zzq(zzehfVarZzd);
            zzcgyVarZzW.zzak(zzehfVarZzd);
            if (z7) {
                zzfou zzfouVarZza = zzehfVarZzd.zza();
                if (zzcgyVarZzT != null) {
                    com.google.android.gms.ads.internal.zzt.zzu().zzh(zzfouVarZza, zzcgyVarZzT.zzE());
                }
                this.zzs = true;
            }
            if (z2) {
                com.google.android.gms.ads.internal.zzt.zzu().zze(zzehfVarZzd.zza());
                zzcgyVarZzW.zze("onSdkLoaded", new ArrayMap());
            }
            return zzehfVarZzd;
        }
        return null;
    }

    public final boolean zzM() {
        return this.zzh.zzd();
    }

    public final void zzN(View view) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfW)).booleanValue()) {
            zzdlq zzdlqVar = this.zze;
            if (zzdlqVar.zzx() != 3) {
                zzcca zzccaVarZzY = zzdlqVar.zzY();
                if (zzccaVarZzY == null) {
                    return;
                }
                zzgui.zzr(zzccaVarZzY, new zzdlc(this, view), this.zzd);
                return;
            }
        }
        zzY(view, this.zze.zzZ());
    }

    public final void zzO(View view) {
        zzehf zzehfVarZzZ = this.zze.zzZ();
        if (!this.zzh.zzd() || zzehfVarZzZ == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzu().zzg(zzehfVarZzZ.zza(), view);
    }

    public final zzdln zzP() {
        return this.zzx;
    }

    public final synchronized void zzQ(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        this.zzy.zza(zzdtVar);
    }

    public final void zzR(Bundle bundle) {
        final zzcgy zzcgyVarZzT = this.zze.zzT();
        if (zzcgyVarZzT == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Video webview is null");
            return;
        }
        try {
            final JSONObject jSONObject = new JSONObject();
            for (String str : bundle.keySet()) {
                jSONObject.put(str, bundle.get(str));
            }
            this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdli
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzgpe zzgpeVar = zzdll.zzc;
                    zzcgyVarZzT.zzd("onVideoEvent", jSONObject);
                }
            });
        } catch (JSONException e) {
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error reading event signals", e);
        }
    }

    public final /* synthetic */ void zzS() {
        try {
            zzdlq zzdlqVar = this.zze;
            int iZzx = zzdlqVar.zzx();
            if (iZzx == 1) {
                zzbjj zzbjjVarZza = this.zzi.zza();
                if (zzbjjVarZza != null) {
                    zzai("Google", true);
                    zzbjjVarZza.zze((zzbiz) this.zzj.zzb());
                    return;
                }
                return;
            }
            if (iZzx == 2) {
                zzbjg zzbjgVarZzb = this.zzi.zzb();
                if (zzbjgVarZzb != null) {
                    zzai("Google", true);
                    zzbjgVarZzb.zze((zzbix) this.zzk.zzb());
                    return;
                }
                return;
            }
            if (iZzx == 3) {
                zzbjp zzbjpVarZzf = this.zzi.zzf(zzdlqVar.zzS());
                if (zzbjpVarZzf != null) {
                    if (zzdlqVar.zzT() != null) {
                        zzL("Google", true);
                    }
                    zzbjpVarZzf.zze((zzbjc) this.zzn.zzb());
                    return;
                }
                return;
            }
            if (iZzx == 6) {
                zzbjw zzbjwVarZzc = this.zzi.zzc();
                if (zzbjwVarZzc != null) {
                    zzai("Google", true);
                    zzbjwVarZzc.zze((zzbkc) this.zzl.zzb());
                    return;
                }
                return;
            }
            if (iZzx != 7) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzf("Wrong native template id!");
            } else {
                zzbor zzborVarZze = this.zzi.zze();
                if (zzborVarZze != null) {
                    zzborVarZze.zze((zzbol) this.zzm.zzb());
                }
            }
        } catch (RemoteException e) {
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("RemoteException when notifyAdLoad is called", e);
        }
    }

    public final /* synthetic */ void zzT() {
        this.zzf.zzA();
        this.zze.zzae();
    }

    public final /* synthetic */ void zzW(boolean z2) {
        zzdnn zzdnnVar = this.zzo;
        if (zzdnnVar != null) {
            this.zzf.zzf(null, zzdnnVar.zzdJ(), this.zzo.zzj(), this.zzo.zzk(), z2, zzah(), 0);
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        }
    }

    public final /* synthetic */ void zzX(View view, boolean z2, int i2) {
        zzdnn zzdnnVar = this.zzo;
        if (zzdnnVar != null) {
            this.zzf.zzf(view, zzdnnVar.zzdJ(), this.zzo.zzj(), this.zzo.zzk(), z2, zzah(), i2);
        } else {
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("Ad should be associated with an ad view before calling performClickForCustomGesture()");
        }
    }

    public final /* synthetic */ zzdlq zzZ() {
        return this.zze;
    }

    public final synchronized void zza(String str) {
        this.zzf.zzd(str);
    }

    public final /* synthetic */ zzdnn zzaa() {
        return this.zzo;
    }

    public final /* synthetic */ Map zzab() {
        return this.zzz;
    }

    public final synchronized void zzb() {
        if (this.zzq) {
            return;
        }
        this.zzf.zzn();
    }

    public final synchronized void zzc(Bundle bundle) {
        this.zzf.zze(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzcto
    public final synchronized void zzd() {
        this.zzp = true;
        this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdld
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzT();
            }
        });
        super.zzd();
    }

    public final synchronized boolean zze(Bundle bundle) {
        if (this.zzq) {
            return true;
        }
        boolean zZzz = this.zzf.zzz(bundle);
        this.zzq = zZzz;
        return zZzz;
    }

    public final synchronized void zzf(Bundle bundle) {
        this.zzf.zzk(bundle);
    }

    public final synchronized void zzg(final zzdnn zzdnnVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbZ)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdle
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzU(zzdnnVar);
                }
            });
        } else {
            zzU(zzdnnVar);
        }
    }

    public final synchronized void zzh(final zzdnn zzdnnVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbZ)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdlf
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzV(zzdnnVar);
                }
            });
        } else {
            zzV(zzdnnVar);
        }
    }

    public final synchronized void zzi(View view, View view2, Map map, Map map2, boolean z2) {
        zzcgy zzcgyVarZzT;
        this.zzg.zzb(this.zzo);
        this.zzf.zzc(view, view2, map, map2, z2, zzah());
        if (this.zzs) {
            zzdlq zzdlqVar = this.zze;
            if (zzdlqVar.zzT() != null && (zzcgyVarZzT = zzdlqVar.zzT()) != null) {
                zzcgyVarZzT.zze("onSdkAdUserInteractionClick", new ArrayMap());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcto
    @AnyThread
    public final void zzj() {
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzdlj
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzS();
            }
        };
        Executor executor = this.zzd;
        executor.execute(runnable);
        if (this.zze.zzx() != 7) {
            final zzdly zzdlyVar = this.zzf;
            Objects.requireNonNull(zzdlyVar);
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdlk
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzdlyVar.zzy();
                }
            });
        }
        super.zzj();
    }

    public final synchronized void zzk(View view, MotionEvent motionEvent, View view2) {
        this.zzf.zzj(view, motionEvent, view2);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a A[Catch: all -> 0x000a, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x000d, B:12:0x001f, B:14:0x0025, B:15:0x002f, B:17:0x0035, B:21:0x004a, B:24:0x005e, B:25:0x0066, B:27:0x006c, B:29:0x0080, B:31:0x0086, B:36:0x008d), top: B:41:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008d A[Catch: all -> 0x000a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x000d, B:12:0x001f, B:14:0x0025, B:15:0x002f, B:17:0x0035, B:21:0x004a, B:24:0x005e, B:25:0x0066, B:27:0x006c, B:29:0x0080, B:31:0x0086, B:36:0x008d), top: B:41:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzu(android.view.View r4, java.util.Map r5, java.util.Map r6, boolean r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzq     // Catch: java.lang.Throwable -> La
            if (r0 == 0) goto Ld
            r3.zzaf(r4, r5, r6)     // Catch: java.lang.Throwable -> La
            monitor-exit(r3)
            return
        La:
            r4 = move-exception
            goto L95
        Ld:
            com.google.android.gms.internal.ads.zzbel r0 = com.google.android.gms.internal.ads.zzbeu.zzcb     // Catch: java.lang.Throwable -> La
            com.google.android.gms.internal.ads.zzbes r1 = com.google.android.gms.ads.internal.client.zzbd.zzc()     // Catch: java.lang.Throwable -> La
            java.lang.Object r0 = r1.zzd(r0)     // Catch: java.lang.Throwable -> La
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> La
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> La
            if (r0 == 0) goto L48
            com.google.android.gms.internal.ads.zzffu r0 = r3.zzb     // Catch: java.lang.Throwable -> La
            boolean r0 = r0.zzak     // Catch: java.lang.Throwable -> La
            if (r0 == 0) goto L48
            java.util.Map r0 = r3.zzz     // Catch: java.lang.Throwable -> La
            java.util.Set r1 = r0.keySet()     // Catch: java.lang.Throwable -> La
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> La
        L2f:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> La
            if (r2 == 0) goto L48
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> La
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> La
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> La
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> La
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> La
            if (r2 != 0) goto L2f
            goto L8b
        L48:
            if (r7 != 0) goto L8d
            com.google.android.gms.internal.ads.zzbel r7 = com.google.android.gms.internal.ads.zzbeu.zzeu     // Catch: java.lang.Throwable -> La
            com.google.android.gms.internal.ads.zzbes r0 = com.google.android.gms.ads.internal.client.zzbd.zzc()     // Catch: java.lang.Throwable -> La
            java.lang.Object r7 = r0.zzd(r7)     // Catch: java.lang.Throwable -> La
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> La
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> La
            if (r7 == 0) goto L8b
            if (r5 == 0) goto L8b
            java.util.Set r7 = r5.entrySet()     // Catch: java.lang.Throwable -> La
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> La
        L66:
            boolean r0 = r7.hasNext()     // Catch: java.lang.Throwable -> La
            if (r0 == 0) goto L8b
            java.lang.Object r0 = r7.next()     // Catch: java.lang.Throwable -> La
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> La
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> La
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch: java.lang.Throwable -> La
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> La
            android.view.View r0 = (android.view.View) r0     // Catch: java.lang.Throwable -> La
            if (r0 == 0) goto L66
            boolean r0 = zzI(r0)     // Catch: java.lang.Throwable -> La
            if (r0 == 0) goto L66
            r3.zzae(r4, r5, r6)     // Catch: java.lang.Throwable -> La
            monitor-exit(r3)
            return
        L8b:
            monitor-exit(r3)
            return
        L8d:
            r3.zzae(r4, r5, r6)     // Catch: java.lang.Throwable -> La
            r3.zzaf(r4, r5, r6)     // Catch: java.lang.Throwable -> La
            monitor-exit(r3)
            return
        L95:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> La
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdll.zzu(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized JSONObject zzv(View view, Map map, Map map2) {
        return this.zzf.zzl(view, map, map2, zzah());
    }

    public final synchronized JSONObject zzw(View view, Map map, Map map2) {
        return this.zzf.zzm(view, map, map2, zzah());
    }

    public final synchronized void zzx(View view) {
        this.zzf.zzo(view);
    }

    public final synchronized void zzy(zzbjz zzbjzVar) {
        this.zzf.zzp(zzbjzVar);
    }

    public final synchronized void zzz() {
        this.zzf.zzq();
    }
}
