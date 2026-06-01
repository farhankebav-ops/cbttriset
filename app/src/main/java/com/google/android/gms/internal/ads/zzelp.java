package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzelp implements zzehm {
    private final Map zza = new HashMap();
    private final zzdsy zzb;

    public zzelp(zzdsy zzdsyVar) {
        this.zzb = zzdsyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehm
    @Nullable
    public final zzehn zza(String str, JSONObject jSONObject) throws zzfgu {
        zzehn zzehnVar;
        synchronized (this) {
            try {
                Map map = this.zza;
                zzehnVar = (zzehn) map.get(str);
                if (zzehnVar == null) {
                    zzehnVar = new zzehn(this.zzb.zza(str, jSONObject), new zzeja(), str);
                    map.put(str, zzehnVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzehnVar;
    }
}
