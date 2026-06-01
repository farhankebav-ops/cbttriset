package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.ironsource.C2543s;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbmq implements zzblx {
    private final zzbmp zza;

    public zzbmq(zzbmp zzbmpVar) {
        this.zza = zzbmpVar;
    }

    public static void zzb(zzcgy zzcgyVar, zzbmp zzbmpVar) {
        zzcgyVar.zzab("/reward", new zzbmq(zzbmpVar));
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("action");
        if (!"grant".equals(str)) {
            if ("video_start".equals(str)) {
                this.zza.zza();
                return;
            } else {
                if ("video_complete".equals(str)) {
                    this.zza.zzc();
                    return;
                }
                return;
            }
        }
        zzbyh zzbyhVar = null;
        try {
            int i2 = Integer.parseInt((String) map.get(C2543s.l));
            String str2 = (String) map.get("type");
            if (!TextUtils.isEmpty(str2)) {
                zzbyhVar = new zzbyh(str2, i2);
            }
        } catch (NumberFormatException e) {
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to parse reward amount.", e);
        }
        this.zza.zzb(zzbyhVar);
    }
}
