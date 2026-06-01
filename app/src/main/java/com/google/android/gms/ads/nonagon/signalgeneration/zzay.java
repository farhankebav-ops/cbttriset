package com.google.android.gms.ads.nonagon.signalgeneration;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzcaw;
import com.ironsource.mediationsdk.l;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzay {
    private final String zza;

    @Nullable
    private final String zzb;

    @Nullable
    private final zzcaw zzc;

    public /* synthetic */ zzay(zzax zzaxVar, byte[] bArr) {
        this.zza = zzaxVar.zzd();
        this.zzb = zzaxVar.zze();
        this.zzc = zzaxVar.zzf();
    }

    public final Set zza() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.zza.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String zzb() {
        return this.zza.toLowerCase(Locale.ROOT);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final zzbdz.zza.EnumC0130zza zzc() {
        String str = this.zza;
        switch (str.hashCode()) {
            case -1999289321:
                if (str.equals("NATIVE")) {
                    return zzbdz.zza.EnumC0130zza.AD_LOADER;
                }
                break;
            case -1372958932:
                if (str.equals("INTERSTITIAL")) {
                    return zzbdz.zza.EnumC0130zza.INTERSTITIAL;
                }
                break;
            case 543046670:
                if (str.equals("REWARDED")) {
                    return zzbdz.zza.EnumC0130zza.REWARD_BASED_VIDEO_AD;
                }
                break;
            case 1951953708:
                if (str.equals(l.f9204a)) {
                    return zzbdz.zza.EnumC0130zza.BANNER;
                }
                break;
        }
        return zzbdz.zza.EnumC0130zza.AD_INITIATER_UNSPECIFIED;
    }

    @Nullable
    public final String zzd() {
        return this.zzb;
    }

    @Nullable
    public final zzcaw zze() {
        return this.zzc;
    }
}
