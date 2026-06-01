package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.C2300e4;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcd {
    public static final zzcd zza = new zzcd(-1, -1, -1);
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    public zzcd(int i2, int i8, int i9) {
        this.zzb = i2;
        this.zzc = i8;
        this.zzd = i9;
        this.zze = zzep.zzA(i9) ? zzep.zzE(i9) * i8 : -1;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcd)) {
            return false;
        }
        zzcd zzcdVar = (zzcd) obj;
        return this.zzb == zzcdVar.zzb && this.zzc == zzcdVar.zzc && this.zzd == zzcdVar.zzd;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd));
    }

    public final String toString() {
        int i2 = this.zzb;
        int length = String.valueOf(i2).length();
        int i8 = this.zzc;
        int length2 = String.valueOf(i8).length();
        int i9 = this.zzd;
        StringBuilder sb = new StringBuilder(length + 38 + length2 + 11 + String.valueOf(i9).length() + 1);
        com.google.android.gms.ads.internal.client.a.k(i2, i8, "AudioFormat[sampleRate=", ", channelCount=", sb);
        return com.google.android.gms.ads.internal.client.a.j(sb, ", encoding=", i9, C2300e4.i.e);
    }
}
