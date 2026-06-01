package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbqd implements zzbou, zzbqc {
    private final zzbqc zza;
    private final HashSet zzb = new HashSet();

    public zzbqd(zzbqc zzbqcVar) {
        this.zza = zzbqcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbou, com.google.android.gms.internal.ads.zzbpf
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbou, com.google.android.gms.internal.ads.zzbpf
    public final /* synthetic */ void zzb(String str, JSONObject jSONObject) {
        i.a(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbou, com.google.android.gms.internal.ads.zzbpf
    public final /* synthetic */ void zzc(String str, String str2) {
        i.b(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbou, com.google.android.gms.internal.ads.zzbot
    public final /* synthetic */ void zzd(String str, JSONObject jSONObject) {
        i.c(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbou, com.google.android.gms.internal.ads.zzbot
    public final /* synthetic */ void zze(String str, Map map) {
        i.d(this, str, map);
    }

    public final void zzf() {
        HashSet<AbstractMap.SimpleEntry> hashSet = this.zzb;
        for (AbstractMap.SimpleEntry simpleEntry : hashSet) {
            com.google.android.gms.ads.internal.util.zze.zza("Unregistering eventhandler: ".concat(String.valueOf(((zzblx) simpleEntry.getValue()).toString())));
            this.zza.zzn((String) simpleEntry.getKey(), (zzblx) simpleEntry.getValue());
        }
        hashSet.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzbqc
    public final void zzm(String str, zzblx zzblxVar) {
        this.zza.zzm(str, zzblxVar);
        this.zzb.add(new AbstractMap.SimpleEntry(str, zzblxVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbqc
    public final void zzn(String str, zzblx zzblxVar) {
        this.zza.zzn(str, zzblxVar);
        this.zzb.remove(new AbstractMap.SimpleEntry(str, zzblxVar));
    }
}
