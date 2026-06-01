package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzen;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzbgs;
import com.google.android.gms.internal.ads.zzbwf;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseAdView extends ViewGroup {

    @NotOnlyInitialized
    protected final zzen zza;

    public BaseAdView(@NonNull Context context, int i2) {
        super(context);
        this.zza = new zzen(this, i2);
    }

    public void destroy() {
        zzbeu.zza(getContext());
        if (((Boolean) zzbgs.zze.zze()).booleanValue()) {
            if (((Boolean) zzbd.zzc().zzd(zzbeu.zzmf)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zzg
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        BaseAdView baseAdView = this.zza;
                        try {
                            baseAdView.zza.zza();
                        } catch (IllegalStateException e) {
                            zzbwf.zza(baseAdView.getContext()).zzh(e, "BaseAdView.destroy");
                        }
                    }
                });
                return;
            }
        }
        this.zza.zza();
    }

    @NonNull
    public AdListener getAdListener() {
        return this.zza.zzb();
    }

    @Nullable
    public AdSize getAdSize() {
        return this.zza.zzc();
    }

    @NonNull
    public String getAdUnitId() {
        return this.zza.zze();
    }

    @Nullable
    public OnPaidEventListener getOnPaidEventListener() {
        return this.zza.zzx();
    }

    public long getPlacementId() {
        return this.zza.zzv();
    }

    @Nullable
    public ResponseInfo getResponseInfo() {
        return this.zza.zzt();
    }

    public boolean isCollapsible() {
        return this.zza.zzr();
    }

    public boolean isLoading() {
        return this.zza.zzs();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(@NonNull final AdRequest adRequest) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbeu.zza(getContext());
        if (((Boolean) zzbgs.zzf.zze()).booleanValue()) {
            if (((Boolean) zzbd.zzc().zzd(zzbeu.zzmi)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zzd
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        AdRequest adRequest2 = adRequest;
                        BaseAdView baseAdView = this.zza;
                        try {
                            baseAdView.zza.zzg(adRequest2.zza);
                        } catch (IllegalStateException e) {
                            zzbwf.zza(baseAdView.getContext()).zzh(e, "BaseAdView.loadAd");
                        }
                    }
                });
                return;
            }
        }
        this.zza.zzg(adRequest.zza);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i11 = ((i9 - i2) - measuredWidth) / 2;
        int i12 = ((i10 - i8) - measuredHeight) / 2;
        childAt.layout(i11, i12, measuredWidth + i11, measuredHeight + i12);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i8) {
        AdSize adSize;
        int heightInPixels;
        int measuredWidth = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzo.zzg("Unable to retrieve ad size.", e);
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                heightInPixels = adSize.getHeightInPixels(context);
                measuredWidth = widthInPixels;
            } else {
                heightInPixels = 0;
            }
        } else {
            measureChild(childAt, i2, i8);
            measuredWidth = childAt.getMeasuredWidth();
            heightInPixels = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), i2), View.resolveSize(Math.max(heightInPixels, getSuggestedMinimumHeight()), i8));
    }

    public void pause() {
        zzbeu.zza(getContext());
        if (((Boolean) zzbgs.zzg.zze()).booleanValue()) {
            if (((Boolean) zzbd.zzc().zzd(zzbeu.zzmg)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zze
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        BaseAdView baseAdView = this.zza;
                        try {
                            baseAdView.zza.zzh();
                        } catch (IllegalStateException e) {
                            zzbwf.zza(baseAdView.getContext()).zzh(e, "BaseAdView.pause");
                        }
                    }
                });
                return;
            }
        }
        this.zza.zzh();
    }

    public void resume() {
        zzbeu.zza(getContext());
        if (((Boolean) zzbgs.zzh.zze()).booleanValue()) {
            if (((Boolean) zzbd.zzc().zzd(zzbeu.zzme)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zzf
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        BaseAdView baseAdView = this.zza;
                        try {
                            baseAdView.zza.zzj();
                        } catch (IllegalStateException e) {
                            zzbwf.zza(baseAdView.getContext()).zzh(e, "BaseAdView.resume");
                        }
                    }
                });
                return;
            }
        }
        this.zza.zzj();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(@NonNull AdListener adListener) {
        zzen zzenVar = this.zza;
        zzenVar.zzk(adListener);
        if (adListener == 0) {
            zzenVar.zzl(null);
            return;
        }
        if (adListener instanceof com.google.android.gms.ads.internal.client.zza) {
            zzenVar.zzl((com.google.android.gms.ads.internal.client.zza) adListener);
        }
        if (adListener instanceof AppEventListener) {
            zzenVar.zzp((AppEventListener) adListener);
        }
    }

    public void setAdSize(@NonNull AdSize adSize) {
        this.zza.zzm(adSize);
    }

    public void setAdUnitId(@NonNull String str) {
        this.zza.zzo(str);
    }

    public void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zza.zzu(onPaidEventListener);
    }

    public void setPlacementId(long j) {
        this.zza.zzw(j);
    }

    public BaseAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.zza = new zzen(this, attributeSet, false, i2);
    }

    public BaseAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2, int i8) {
        super(context, attributeSet, i2);
        this.zza = new zzen(this, attributeSet, false, i8);
    }

    public BaseAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2, int i8, boolean z2) {
        super(context, attributeSet, i2);
        this.zza = new zzen(this, attributeSet, z2, i8);
    }

    public BaseAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, boolean z2) {
        super(context, attributeSet);
        this.zza = new zzen(this, attributeSet, z2);
    }
}
