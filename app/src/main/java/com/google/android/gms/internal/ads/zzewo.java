package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzewo implements zzexy {

    @Nullable
    private final String zza;

    @Nullable
    private final Integer zzb;

    @Nullable
    private final String zzc;

    @Nullable
    private final String zzd;

    @Nullable
    private final String zze;

    @Nullable
    private final String zzf;

    public zzewo(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.zza = str;
        this.zzb = num;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = str5;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzcxq) obj).zza;
        zzfhc.zze(bundle, "pn", this.zza);
        zzfhc.zzh(bundle, "vc", this.zzb);
        zzfhc.zze(bundle, "vnm", this.zzc);
        zzfhc.zze(bundle, "dl", this.zzd);
        zzfhc.zze(bundle, "ins_pn", this.zze);
        zzfhc.zze(bundle, "ini_pn", this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcxq) obj).zzb;
        zzfhc.zze(bundle, "pn", this.zza);
        zzfhc.zze(bundle, "dl", this.zzd);
    }
}
