package com.google.android.gms.ads.nativead;

import android.os.RemoteException;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbis;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class NativeAdViewHolder {

    @NonNull
    public static final WeakHashMap zza = new WeakHashMap();

    @NotOnlyInitialized
    private zzbis zzb;
    private WeakReference zzc;

    public NativeAdViewHolder(@NonNull View view, @NonNull Map<String, View> map, @NonNull Map<String, View> map2) {
        Preconditions.checkNotNull(view, "ContainerView must not be null");
        if (view instanceof NativeAdView) {
            zzo.zzf("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
            return;
        }
        WeakHashMap weakHashMap = zza;
        if (weakHashMap.get(view) != null) {
            zzo.zzf("The provided containerView is already in use with another NativeAdViewHolder.");
            return;
        }
        weakHashMap.put(view, this);
        this.zzc = new WeakReference(view);
        this.zzb = zzbb.zzb().zzf(view, zza(map), zza(map2));
    }

    private static final HashMap zza(Map map) {
        return map == null ? new HashMap() : new HashMap(map);
    }

    public final void setClickConfirmingView(@NonNull View view) {
        try {
            this.zzb.zzd(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzo.zzg("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public void setNativeAd(@NonNull NativeAd nativeAd) {
        IObjectWrapper iObjectWrapper = (IObjectWrapper) nativeAd.zza();
        WeakReference weakReference = this.zzc;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view == null) {
            zzo.zzi("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        WeakHashMap weakHashMap = zza;
        if (!weakHashMap.containsKey(view)) {
            weakHashMap.put(view, this);
        }
        zzbis zzbisVar = this.zzb;
        if (zzbisVar != null) {
            try {
                zzbisVar.zzb(iObjectWrapper);
            } catch (RemoteException e) {
                zzo.zzg("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    public void unregisterNativeAd() {
        zzbis zzbisVar = this.zzb;
        if (zzbisVar != null) {
            try {
                zzbisVar.zzc();
            } catch (RemoteException e) {
                zzo.zzg("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        WeakReference weakReference = this.zzc;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null) {
            zza.remove(view);
        }
    }
}
