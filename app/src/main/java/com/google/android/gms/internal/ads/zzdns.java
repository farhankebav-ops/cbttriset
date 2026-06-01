package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdns implements zzdly, zzddq {

    @Nullable
    private final zzbry zza;
    private final zzczg zzb;
    private final zzdbh zzc;
    private final zzcym zzd;
    private final zzdgt zze;
    private final Context zzf;
    private final zzffu zzg;
    private final VersionInfoParcel zzh;
    private final zzfgn zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private boolean zzl = true;

    @Nullable
    private final zzbru zzm;

    @Nullable
    private final zzbrv zzn;

    public zzdns(@Nullable zzbru zzbruVar, @Nullable zzbrv zzbrvVar, @Nullable zzbry zzbryVar, zzczg zzczgVar, zzdbh zzdbhVar, zzcym zzcymVar, zzdgt zzdgtVar, Context context, zzffu zzffuVar, VersionInfoParcel versionInfoParcel, zzfgn zzfgnVar) {
        this.zzm = zzbruVar;
        this.zzn = zzbrvVar;
        this.zza = zzbryVar;
        this.zzb = zzczgVar;
        this.zzc = zzdbhVar;
        this.zzd = zzcymVar;
        this.zze = zzdgtVar;
        this.zzf = context;
        this.zzg = zzffuVar;
        this.zzh = versionInfoParcel;
        this.zzi = zzfgnVar;
    }

    private static final HashMap zzB(Map map) {
        HashMap map2 = new HashMap();
        if (map == null) {
            return map2;
        }
        synchronized (map) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    View view = (View) ((WeakReference) entry.getValue()).get();
                    if (view != null) {
                        map2.put((String) entry.getKey(), view);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return map2;
    }

    private final void zzi(View view) {
        try {
            zzbry zzbryVar = this.zza;
            if (zzbryVar != null && !zzbryVar.zzu()) {
                zzbryVar.zzw(ObjectWrapper.wrap(view));
                this.zzd.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlM)).booleanValue()) {
                    this.zze.zzdz();
                    return;
                }
                return;
            }
            zzbru zzbruVar = this.zzm;
            if (zzbruVar != null && !zzbruVar.zzq()) {
                zzbruVar.zzn(ObjectWrapper.wrap(view));
                this.zzd.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlM)).booleanValue()) {
                    this.zze.zzdz();
                    return;
                }
                return;
            }
            zzbrv zzbrvVar = this.zzn;
            if (zzbrvVar == null || zzbrvVar.zzo()) {
                return;
            }
            zzbrvVar.zzl(ObjectWrapper.wrap(view));
            this.zzd.onAdClicked();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlM)).booleanValue()) {
                this.zze.zzdz();
            }
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call handleClick", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzA() {
        try {
            zzbry zzbryVar = this.zza;
            if (zzbryVar != null) {
                zzbryVar.zzC();
            }
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call destroy", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00cc A[Catch: RemoteException -> 0x002b, JSONException -> 0x0047, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0047, blocks: (B:49:0x00b4, B:51:0x00cc), top: B:70:0x00b4 }] */
    @Override // com.google.android.gms.internal.ads.zzdly
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(android.view.View r10, @androidx.annotation.Nullable java.util.Map r11, @androidx.annotation.Nullable java.util.Map r12, android.view.View.OnTouchListener r13, android.view.View.OnClickListener r14) {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdns.zza(android.view.View, java.util.Map, java.util.Map, android.view.View$OnTouchListener, android.view.View$OnClickListener):void");
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzb(View view, @Nullable Map map) {
        try {
            IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(view);
            zzbry zzbryVar = this.zza;
            if (zzbryVar != null) {
                zzbryVar.zzy(iObjectWrapperWrap);
                return;
            }
            zzbru zzbruVar = this.zzm;
            if (zzbruVar != null) {
                zzbruVar.zzs(iObjectWrapperWrap);
                return;
            }
            zzbrv zzbrvVar = this.zzn;
            if (zzbrvVar != null) {
                zzbrvVar.zzq(iObjectWrapperWrap);
            }
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call untrackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzc(View view, @Nullable View view2, @Nullable Map map, @Nullable Map map2, boolean z2, @Nullable ImageView.ScaleType scaleType) {
        if (this.zzk && this.zzg.zzL) {
            return;
        }
        zzi(view);
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void zzdL() {
        try {
            zzbry zzbryVar = this.zza;
            if (zzbryVar == null || !zzbryVar.zzt()) {
                return;
            }
            zzffu zzffuVar = this.zzg;
            if (zzffuVar.zze != 4 && !zzffuVar.zzaD) {
                return;
            }
            zzbryVar.zzv();
            this.zzb.zza();
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to report impression from an adapter", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzf(View view, View view2, Map map, Map map2, boolean z2, @Nullable ImageView.ScaleType scaleType, int i2) {
        if (!this.zzk) {
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (this.zzg.zzL) {
            zzi(view2);
        } else {
            int i9 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzg() {
        this.zzk = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final boolean zzh() {
        return this.zzg.zzL;
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    @Nullable
    public final JSONObject zzl(View view, Map map, Map map2, @Nullable ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    @Nullable
    public final JSONObject zzm(View view, Map map, Map map2, @Nullable ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzr(@Nullable com.google.android.gms.ads.internal.client.zzdj zzdjVar) {
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzs(com.google.android.gms.ads.internal.client.zzdf zzdfVar) {
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzt() {
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final int zzu() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final boolean zzv() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzw(@Nullable View view, @Nullable Map map, @Nullable Map map2, @Nullable ImageView.ScaleType scaleType) {
        try {
            if (!this.zzj) {
                this.zzj = com.google.android.gms.ads.internal.zzt.zzo().zzg(this.zzf, this.zzh.afmaVersion, this.zzg.zzC.toString(), this.zzi.zzg);
            }
            if (this.zzl) {
                zzbry zzbryVar = this.zza;
                if (zzbryVar == null) {
                    zzbru zzbruVar = this.zzm;
                    if (zzbruVar != null && !zzbruVar.zzp()) {
                        zzbruVar.zzm();
                        this.zzb.zza();
                        return;
                    }
                    zzbrv zzbrvVar = this.zzn;
                    if (zzbrvVar == null || zzbrvVar.zzn()) {
                        return;
                    }
                    zzbrvVar.zzk();
                    this.zzb.zza();
                    return;
                }
                zzffu zzffuVar = this.zzg;
                if (zzffuVar.zzaD) {
                    if (zzbryVar.zzt()) {
                        return;
                    }
                    zzbryVar.zzv();
                    this.zzb.zza();
                    return;
                }
                if (zzbryVar.zzt() && zzffuVar.zze == 4) {
                    this.zzc.zza();
                } else {
                    zzbryVar.zzv();
                    this.zzb.zza();
                }
            }
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call recordImpression", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final boolean zzz(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void zzdM() {
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzn() {
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzy() {
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzd(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zze(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzk(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzo(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzp(zzbjz zzbjzVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzj(View view, MotionEvent motionEvent, @Nullable View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdly
    public final void zzx(@Nullable View view, @Nullable Map map, @Nullable Map map2, @Nullable ImageView.ScaleType scaleType) {
    }
}
