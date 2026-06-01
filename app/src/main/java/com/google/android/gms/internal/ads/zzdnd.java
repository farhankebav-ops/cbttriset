package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.view.View;
import com.bumptech.glide.load.Key;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdnd {
    private final zzdse zza;
    private final zzdqt zzb;
    private final zzcql zzc;
    private final zzdly zzd;

    public zzdnd(zzdse zzdseVar, zzdqt zzdqtVar, zzcql zzcqlVar, zzdly zzdlyVar) {
        this.zza = zzdseVar;
        this.zzb = zzdqtVar;
        this.zzc = zzcqlVar;
        this.zzd = zzdlyVar;
    }

    public final View zza() throws zzchn {
        zzcgy zzcgyVarZza = this.zza.zza(com.google.android.gms.ads.internal.client.zzr.zzb(), null, null);
        zzcgyVarZza.zzE().setVisibility(8);
        zzcgyVarZza.zzab("/sendMessageToSdk", new zzblx() { // from class: com.google.android.gms.internal.ads.zzdnc
            @Override // com.google.android.gms.internal.ads.zzblx
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzb((zzcgy) obj, map);
            }
        });
        zzcgyVarZza.zzab("/adMuted", new zzblx() { // from class: com.google.android.gms.internal.ads.zzdmx
            @Override // com.google.android.gms.internal.ads.zzblx
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzc((zzcgy) obj, map);
            }
        });
        WeakReference weakReference = new WeakReference(zzcgyVarZza);
        zzblx zzblxVar = new zzblx() { // from class: com.google.android.gms.internal.ads.zzdmy
            @Override // com.google.android.gms.internal.ads.zzblx
            public final /* synthetic */ void zza(Object obj, final Map map) {
                zzcgy zzcgyVar = (zzcgy) obj;
                zzciw zzciwVarZzP = zzcgyVar.zzP();
                final zzdnd zzdndVar = this.zza;
                zzciwVarZzP.zzG(new zzciu() { // from class: com.google.android.gms.internal.ads.zzdnb
                    @Override // com.google.android.gms.internal.ads.zzciu
                    public final /* synthetic */ void zza(boolean z2, int i2, String str, String str2) {
                        zzdndVar.zzf(map, z2, i2, str, str2);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzcgyVar.loadData(str, "text/html", Key.STRING_CHARSET_NAME);
                } else {
                    zzcgyVar.loadDataWithBaseURL(str2, str, "text/html", Key.STRING_CHARSET_NAME, null);
                }
            }
        };
        zzdqt zzdqtVar = this.zzb;
        zzdqtVar.zzh(weakReference, "/loadHtml", zzblxVar);
        zzdqtVar.zzh(new WeakReference(zzcgyVarZza), "/showOverlay", new zzblx() { // from class: com.google.android.gms.internal.ads.zzdmz
            @Override // com.google.android.gms.internal.ads.zzblx
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzd((zzcgy) obj, map);
            }
        });
        zzdqtVar.zzh(new WeakReference(zzcgyVarZza), "/hideOverlay", new zzblx() { // from class: com.google.android.gms.internal.ads.zzdna
            @Override // com.google.android.gms.internal.ads.zzblx
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zze((zzcgy) obj, map);
            }
        });
        return zzcgyVarZza.zzE();
    }

    public final /* synthetic */ void zzb(zzcgy zzcgyVar, Map map) {
        this.zzb.zzf("sendMessageToNativeJs", map);
    }

    public final /* synthetic */ void zzc(zzcgy zzcgyVar, Map map) {
        this.zzd.zzt();
    }

    public final /* synthetic */ void zzd(zzcgy zzcgyVar, Map map) {
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("Showing native ads overlay.");
        zzcgyVar.zzE().setVisibility(0);
        this.zzc.zze(true);
    }

    public final /* synthetic */ void zze(zzcgy zzcgyVar, Map map) {
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("Hiding native ads overlay.");
        zzcgyVar.zzE().setVisibility(8);
        this.zzc.zze(false);
    }

    public final /* synthetic */ void zzf(Map map, boolean z2, int i2, String str, String str2) {
        HashMap mapU = androidx.camera.core.processing.util.a.u("messageType", "htmlLoaded");
        mapU.put("id", (String) map.get("id"));
        this.zzb.zzf("sendMessageToNativeJs", mapU);
    }
}
