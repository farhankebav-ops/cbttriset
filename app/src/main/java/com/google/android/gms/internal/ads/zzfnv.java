package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfnv {
    private final zzdvi zza;

    public zzfnv(zzdvi zzdviVar, Context context) {
        this.zza = zzdviVar;
    }

    private final void zzq(String str, long j, @Nullable String str2, @Nullable String str3, AdFormat adFormat, int i2, int i8, int i9, String str4) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc("action", str);
        zzdvhVarZza.zzc("pat", Long.toString(j));
        zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, adFormat.name().toLowerCase(Locale.ENGLISH));
        zzdvhVarZza.zzc("max_ads", Integer.toString(i2));
        zzdvhVarZza.zzc("cache_size", Integer.toString(i8));
        zzdvhVarZza.zzc("pas", Integer.toString(i9));
        zzdvhVarZza.zzc("pv", "2");
        zzdvhVarZza.zzc("ad_unit_id", str3);
        zzdvhVarZza.zzc("pid", str2);
        zzdvhVarZza.zzd();
    }

    private final void zzr(@Nullable String str, String str2, long j, int i2, int i8, @Nullable String str3, @Nullable zzfoc zzfocVar, String str4) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc(str2, Long.toString(j));
        if (zzfocVar != null) {
            zzdvhVarZza.zzc("ad_unit_id", zzfocVar.zza());
            zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, zzfocVar.zzb());
            zzdvhVarZza.zzc("pid", zzfocVar.zzc());
        }
        zzdvhVarZza.zzc("action", str);
        if (str3 != null) {
            zzdvhVarZza.zzc("gqi", str3);
        }
        if (i2 >= 0) {
            zzdvhVarZza.zzc("max_ads", Integer.toString(i2));
        }
        if (i8 >= 0) {
            zzdvhVarZza.zzc("cache_size", Integer.toString(i8));
        }
        zzdvhVarZza.zzc("pv", str4);
        zzdvhVarZza.zzd();
    }

    public final void zza(int i2, long j, zzfoc zzfocVar, String str) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc("action", "start_preload");
        zzdvhVarZza.zzc("sp_ts", Long.toString(j));
        zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, zzfocVar.zzb());
        zzdvhVarZza.zzc("ad_unit_id", zzfocVar.zza());
        zzdvhVarZza.zzc("pid", zzfocVar.zzc());
        zzdvhVarZza.zzc("max_ads", Integer.toString(i2));
        zzdvhVarZza.zzc("pv", str);
        zzdvhVarZza.zzd();
    }

    public final void zzb(Map map, long j, String str) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc("action", "start_preload");
        zzdvhVarZza.zzc("sp_ts", Long.toString(j));
        zzdvhVarZza.zzc("pv", "1");
        for (AdFormat adFormat : map.keySet()) {
            String strValueOf = String.valueOf(adFormat.name().toLowerCase(Locale.ENGLISH));
            zzdvhVarZza.zzc(strValueOf.concat("_count"), Integer.toString(((Integer) map.get(adFormat)).intValue()));
        }
        zzdvhVarZza.zzd();
    }

    public final void zzc(int i2, int i8, long j, zzfoc zzfocVar) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc("action", "cache_resize");
        zzdvhVarZza.zzc("cs_ts", Long.toString(j));
        zzdvhVarZza.zzc("orig_ma", Integer.toString(i2));
        zzdvhVarZza.zzc("max_ads", Integer.toString(i8));
        zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, zzfocVar.zzb());
        zzdvhVarZza.zzc("ad_unit_id", zzfocVar.zza());
        zzdvhVarZza.zzc("pid", zzfocVar.zzc());
        zzdvhVarZza.zzc("pv", "1");
        zzdvhVarZza.zzd();
    }

    public final void zzd(int i2, int i8, long j, @Nullable Long l, @Nullable String str, @Nullable zzfoc zzfocVar, String str2) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc("plaac_ts", Long.toString(j));
        zzdvhVarZza.zzc("max_ads", Integer.toString(i2));
        zzdvhVarZza.zzc("cache_size", Integer.toString(i8));
        zzdvhVarZza.zzc("action", "is_ad_available");
        if (zzfocVar != null) {
            zzdvhVarZza.zzc("ad_unit_id", zzfocVar.zza());
            zzdvhVarZza.zzc("pid", zzfocVar.zzc());
            zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, zzfocVar.zzb());
        }
        if (l != null) {
            zzdvhVarZza.zzc("plaay_ts", Long.toString(l.longValue()));
        }
        if (str != null) {
            zzdvhVarZza.zzc("gqi", str);
        }
        zzdvhVarZza.zzc("pv", str2);
        zzdvhVarZza.zzd();
    }

    public final void zze(long j, String str) {
        zzr("poll_ad", "ppacwe_ts", j, -1, -1, null, null, "2");
    }

    public final void zzf(long j, zzfoc zzfocVar, int i2, int i8, String str) {
        zzr("poll_ad", "ppac_ts", j, i2, i8, null, zzfocVar, str);
    }

    public final void zzg(long j, int i2, int i8, String str, zzfoc zzfocVar, String str2) {
        zzr("poll_ad", "psvroc_ts", j, i2, i8, str, zzfocVar, str2);
    }

    public final void zzh(long j, int i2, int i8, @Nullable String str, zzfoc zzfocVar, String str2) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc("ppla_ts", Long.toString(j));
        zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, zzfocVar.zzb());
        zzdvhVarZza.zzc("ad_unit_id", zzfocVar.zza());
        zzdvhVarZza.zzc("pid", zzfocVar.zzc());
        zzdvhVarZza.zzc("max_ads", Integer.toString(i2));
        zzdvhVarZza.zzc("cache_size", Integer.toString(i8));
        zzdvhVarZza.zzc("action", "poll_ad");
        if (str != null) {
            zzdvhVarZza.zzc("gqi", str);
        }
        zzdvhVarZza.zzc("pv", str2);
        zzdvhVarZza.zzd();
    }

    public final void zzi(long j, @Nullable String str, zzfoc zzfocVar, int i2, int i8, String str2) {
        zzr("paa", "pano_ts", j, i2, i8, str, zzfocVar, str2);
    }

    public final void zzj(long j, zzfoc zzfocVar, int i2, String str) {
        zzr("pae", "paeo_ts", j, i2, 0, null, zzfocVar, str);
    }

    public final void zzk(long j, zzfoc zzfocVar, com.google.android.gms.ads.internal.client.zze zzeVar, int i2, int i8, String str) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc("action", "pftla");
        zzdvhVarZza.zzc("pftlat_ts", Long.toString(j));
        zzdvhVarZza.zzc("pftlaec", Integer.toString(zzeVar.zza));
        zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, zzfocVar.zzb());
        zzdvhVarZza.zzc("max_ads", Integer.toString(i2));
        zzdvhVarZza.zzc("cache_size", Integer.toString(i8));
        zzdvhVarZza.zzc("ad_unit_id", zzfocVar.zza());
        zzdvhVarZza.zzc("pid", zzfocVar.zzc());
        zzdvhVarZza.zzc("pv", str);
        zzdvhVarZza.zzd();
    }

    public final void zzl(long j, AdFormat adFormat, int i2) {
        zzq("pda", j, null, null, adFormat, -1, -1, i2, "2");
    }

    public final void zzm(long j, String str, String str2, AdFormat adFormat, int i2, int i8) {
        zzq("pd", j, str, str2, adFormat, i2, i8, 1, "2");
    }

    public final void zzn(AdFormat adFormat, long j, int i2) {
        zzq("pgcs", j, null, null, adFormat, -1, -1, i2, "2");
    }

    public final void zzo(long j, String str, @Nullable String str2, AdFormat adFormat, int i2, int i8) {
        zzq("pgc", j, str, str2, adFormat, i2, i8, 1, "2");
    }

    public final void zzp(int i2, long j, String str, @Nullable String str2, AdFormat adFormat, int i8) {
        zzq("pnav", j, str, str2, adFormat, i8, i2, 1, "2");
    }
}
