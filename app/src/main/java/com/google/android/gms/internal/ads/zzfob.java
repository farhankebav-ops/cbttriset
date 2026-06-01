package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfob {
    private final String zza;

    @Nullable
    private final AdFormat zzb;

    @Nullable
    private String zzc;

    public zzfob(String str, @Nullable AdFormat adFormat) {
        this.zza = str;
        this.zzb = adFormat;
    }

    public final zzfob zza(String str) {
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ String zzb() {
        return this.zza;
    }

    public final /* synthetic */ AdFormat zzc() {
        return this.zzb;
    }

    public final /* synthetic */ String zzd() {
        return this.zzc;
    }
}
