package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcdg {
    private final Context zza;
    private final zzcdr zzb;
    private final ViewGroup zzc;

    @Nullable
    private final zzdvi zzd;
    private zzcdf zze;

    public zzcdg(Context context, ViewGroup viewGroup, zzcgy zzcgyVar, @Nullable zzdvi zzdviVar) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzcgyVar;
        this.zze = null;
        this.zzd = zzdviVar;
    }

    @Nullable
    public final Integer zza() {
        zzcdf zzcdfVar = this.zze;
        if (zzcdfVar != null) {
            return zzcdfVar.zzl();
        }
        return null;
    }

    public final void zzb(int i2, int i8, int i9, int i10) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzcdf zzcdfVar = this.zze;
        if (zzcdfVar != null) {
            zzcdfVar.zzn(i2, i8, i9, i10);
        }
    }

    public final void zzc(int i2, int i8, int i9, int i10, int i11, boolean z2, zzcdq zzcdqVar) {
        if (this.zze != null) {
            return;
        }
        zzcdr zzcdrVar = this.zzb;
        zzbfb.zza(zzcdrVar.zzq().zzc(), zzcdrVar.zzi(), "vpr2");
        zzcdf zzcdfVar = new zzcdf(this.zza, zzcdrVar, i11, z2, zzcdrVar.zzq().zzc(), zzcdqVar, this.zzd);
        this.zze = zzcdfVar;
        this.zzc.addView(zzcdfVar, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zze.zzn(i2, i8, i9, i10);
        zzcdrVar.zzds(false);
    }

    public final zzcdf zzd() {
        return this.zze;
    }

    public final void zze() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzcdf zzcdfVar = this.zze;
        if (zzcdfVar != null) {
            zzcdfVar.zzr();
        }
    }

    public final void zzf() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzcdf zzcdfVar = this.zze;
        if (zzcdfVar != null) {
            zzcdfVar.zzE();
            this.zzc.removeView(this.zze);
            this.zze = null;
        }
    }

    public final void zzg(int i2) {
        zzcdf zzcdfVar = this.zze;
        if (zzcdfVar != null) {
            zzcdfVar.zzm(i2);
        }
    }
}
