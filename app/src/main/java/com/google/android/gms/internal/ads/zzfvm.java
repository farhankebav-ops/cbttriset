package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfvm {
    private final zzfvi zza;

    public final /* synthetic */ zzfvk zza() {
        zzhwo zzhwoVarZzbu = this.zza.zzbu();
        kotlin.jvm.internal.k.d(zzhwoVarZzbu, "build(...)");
        return (zzfvk) zzhwoVarZzbu;
    }

    public final /* synthetic */ zzhzs zzb() {
        Map mapZzb = this.zza.zzb();
        kotlin.jvm.internal.k.d(mapZzb, "getQueryIdToAdQualityDataMapMap(...)");
        return new zzhzs(mapZzb);
    }

    public final void zzc(zzhzs zzhzsVar, String key, zzfvg value) {
        kotlin.jvm.internal.k.e(zzhzsVar, "<this>");
        kotlin.jvm.internal.k.e(key, "key");
        kotlin.jvm.internal.k.e(value, "value");
        this.zza.zzc(key, value);
    }

    public final /* synthetic */ void zzd(zzhzs zzhzsVar, String key) {
        kotlin.jvm.internal.k.e(zzhzsVar, "<this>");
        kotlin.jvm.internal.k.e(key, "key");
        this.zza.zza(key);
    }
}
