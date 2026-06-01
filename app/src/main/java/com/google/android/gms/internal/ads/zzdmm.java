package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdmm implements zzbhv {
    final /* synthetic */ zzdnn zza;
    final /* synthetic */ ViewGroup zzb;

    public zzdmm(zzdnn zzdnnVar, ViewGroup viewGroup) {
        this.zza = zzdnnVar;
        this.zzb = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zza() {
        zzgpe zzgpeVar = zzdml.zza;
        zzdnn zzdnnVar = this.zza;
        Map mapZzk = zzdnnVar.zzk();
        if (mapZzk == null) {
            return;
        }
        int size = zzgpeVar.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = mapZzk.get((String) zzgpeVar.get(i2));
            i2++;
            if (obj != null) {
                zzdnnVar.onClick(this.zzb);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zzb(MotionEvent motionEvent) {
        this.zza.onTouch(null, motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final JSONObject zzc() {
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final JSONObject zzd() {
        return this.zza.zzq();
    }
}
