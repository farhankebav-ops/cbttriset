package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzkg {
    final Uri zza;
    final String zzb;
    final String zzc;
    final boolean zzd;
    final boolean zze;

    private zzkg(String str, Uri uri, String str2, String str3, boolean z2, boolean z7, boolean z8, boolean z9, e2.e eVar) {
        this.zza = uri;
        this.zzb = "";
        this.zzc = "";
        this.zzd = z2;
        this.zze = z8;
    }

    public final zzkg zza() {
        String str = this.zzb;
        if (str.isEmpty()) {
            return new zzkg(null, this.zza, str, this.zzc, true, false, this.zze, false, null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzkg zzb() {
        return new zzkg(null, this.zza, this.zzb, this.zzc, this.zzd, false, true, false, null);
    }

    public final zzkm zzc(String str, long j) {
        Long lValueOf = Long.valueOf(j);
        int i2 = zzkm.zzc;
        return new zzkc(this, str, lValueOf, true);
    }

    public final zzkm zzd(String str, boolean z2) {
        Boolean boolValueOf = Boolean.valueOf(z2);
        int i2 = zzkm.zzc;
        return new zzkd(this, str, boolValueOf, true);
    }

    public final zzkm zze(String str, double d8) {
        Double dValueOf = Double.valueOf(-3.0d);
        int i2 = zzkm.zzc;
        return new zzke(this, "measurement.test.double_flag", dValueOf, true);
    }

    public final zzkm zzf(String str, String str2) {
        int i2 = zzkm.zzc;
        return new zzkf(this, str, str2, true);
    }

    public zzkg(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }
}
