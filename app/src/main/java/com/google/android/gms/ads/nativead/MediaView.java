package com.google.android.gms.ads.nativead;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbhu;
import com.google.android.gms.internal.ads.zzbhw;
import com.google.android.gms.internal.ads.zzbjc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MediaView extends FrameLayout {

    @Nullable
    private MediaContent zza;
    private boolean zzb;
    private zzbhu zzc;
    private ImageView.ScaleType zzd;
    private boolean zze;
    private zzbhw zzf;

    public MediaView(@NonNull Context context) {
        super(context);
    }

    @Nullable
    public MediaContent getMediaContent() {
        return this.zza;
    }

    public void setImageScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.zze = true;
        this.zzd = scaleType;
        zzbhw zzbhwVar = this.zzf;
        if (zzbhwVar != null) {
            zzbhwVar.zza(scaleType);
        }
    }

    public void setMediaContent(@Nullable MediaContent mediaContent) {
        boolean zZzt;
        this.zzb = true;
        this.zza = mediaContent;
        zzbhu zzbhuVar = this.zzc;
        if (zzbhuVar != null) {
            zzbhuVar.zza(mediaContent);
        }
        if (mediaContent == null) {
            return;
        }
        try {
            zzbjc zzbjcVarZzb = mediaContent.zzb();
            if (zzbjcVarZzb != null) {
                if (!mediaContent.hasVideoContent()) {
                    if (mediaContent.zza()) {
                        zZzt = zzbjcVarZzb.zzt(ObjectWrapper.wrap(this));
                    }
                    removeAllViews();
                }
                zZzt = zzbjcVarZzb.zzn(ObjectWrapper.wrap(this));
                if (zZzt) {
                    return;
                }
                removeAllViews();
            }
        } catch (RemoteException e) {
            removeAllViews();
            zzo.zzg("", e);
        }
    }

    public final synchronized void zza(zzbhu zzbhuVar) {
        this.zzc = zzbhuVar;
        if (this.zzb) {
            zzbhuVar.zza(this.zza);
        }
    }

    public final synchronized void zzb(zzbhw zzbhwVar) {
        this.zzf = zzbhwVar;
        if (this.zze) {
            zzbhwVar.zza(this.zzd);
        }
    }

    public MediaView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public MediaView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2, int i8) {
        super(context, attributeSet, i2, i8);
    }
}
