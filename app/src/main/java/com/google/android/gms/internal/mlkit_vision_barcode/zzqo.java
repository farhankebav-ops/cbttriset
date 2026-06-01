package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqo {
    private Long zza;
    private zzrb zzb;
    private Boolean zzc;
    private Boolean zzd;
    private Boolean zze;

    public final zzqo zza(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zzqo zzb(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zzqo zzc(Long l) {
        this.zza = Long.valueOf(l.longValue() & LocationRequestCompat.PASSIVE_INTERVAL);
        return this;
    }

    public final zzqo zzd(zzrb zzrbVar) {
        this.zzb = zzrbVar;
        return this;
    }

    public final zzqo zze(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzqq zzf() {
        return new zzqq(this, null);
    }
}
