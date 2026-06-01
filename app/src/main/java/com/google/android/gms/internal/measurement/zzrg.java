package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrg implements zzrf {
    public static final zzkm zza;

    static {
        zzkg zzkgVarZzb = new zzkg(zzkb.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzkgVarZzb.zzd("measurement.client.sessions.enable_fix_background_engagement", false);
        zzkgVarZzb.zzd("measurement.client.sessions.enable_pause_engagement_in_background", true);
        zzkgVarZzb.zzc("measurement.id.client.sessions.enable_fix_background_engagement", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzrf
    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
