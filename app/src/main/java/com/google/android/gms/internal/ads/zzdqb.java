package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdqb implements zzbhv {
    final /* synthetic */ String zza = NativeCustomFormatAd.ASSET_NAME_VIDEO;
    final /* synthetic */ zzdqc zzb;

    public zzdqb(zzdqc zzdqcVar, String str) {
        Objects.requireNonNull(zzdqcVar);
        this.zzb = zzdqcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zza() {
        zzdqc zzdqcVar = this.zzb;
        if (zzdqcVar.zzc() != null) {
            zzdqcVar.zzc().zza(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final JSONObject zzc() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final JSONObject zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zzb(MotionEvent motionEvent) {
    }
}
