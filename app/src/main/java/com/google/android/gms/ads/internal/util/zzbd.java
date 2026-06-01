package com.google.android.gms.ads.internal.util;

import com.google.android.gms.common.internal.Objects;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.NewHtcHomeBadger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbd {
    public final String zza;
    public final double zzb;
    public final double zzc;
    public final double zzd;
    public final int zze;

    public zzbd(String str, double d8, double d9, double d10, int i2) {
        this.zza = str;
        this.zzc = d8;
        this.zzb = d9;
        this.zzd = d10;
        this.zze = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbd)) {
            return false;
        }
        zzbd zzbdVar = (zzbd) obj;
        return Objects.equal(this.zza, zzbdVar.zza) && this.zzb == zzbdVar.zzb && this.zzc == zzbdVar.zzc && this.zze == zzbdVar.zze && Double.compare(this.zzd, zzbdVar.zzd) == 0;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Double.valueOf(this.zzb), Double.valueOf(this.zzc), Double.valueOf(this.zzd), Integer.valueOf(this.zze));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("name", this.zza).add("minBound", Double.valueOf(this.zzc)).add("maxBound", Double.valueOf(this.zzb)).add("percent", Double.valueOf(this.zzd)).add(NewHtcHomeBadger.COUNT, Integer.valueOf(this.zze)).toString();
    }
}
