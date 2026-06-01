package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.ironsource.C2300e4;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzpd {
    public static final zzpd zza;
    public final int zzb;
    public final int zzc;

    @Nullable
    private final zzgpo zzd;

    static {
        zzpd zzpdVar;
        if (Build.VERSION.SDK_INT >= 33) {
            zzgpn zzgpnVar = new zzgpn();
            for (int i2 = 1; i2 <= 10; i2++) {
                zzgpnVar.zzf(Integer.valueOf(zzep.zzB(i2)));
            }
            zzpdVar = new zzpd(2, zzgpnVar.zzi());
        } else {
            zzpdVar = new zzpd(2, 10);
        }
        zza = zzpdVar;
    }

    public zzpd(int i2, int i8) {
        this.zzb = i2;
        this.zzc = i8;
        this.zzd = null;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpd)) {
            return false;
        }
        zzpd zzpdVar = (zzpd) obj;
        return this.zzb == zzpdVar.zzb && this.zzc == zzpdVar.zzc && Objects.equals(this.zzd, zzpdVar.zzd);
    }

    public final int hashCode() {
        zzgpo zzgpoVar = this.zzd;
        return (((this.zzb * 31) + this.zzc) * 31) + (zzgpoVar == null ? 0 : zzgpoVar.hashCode());
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzd);
        int i2 = this.zzb;
        int length = String.valueOf(i2).length();
        int i8 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 38 + String.valueOf(i8).length() + 15 + strValueOf.length() + 1);
        com.google.android.gms.ads.internal.client.a.k(i2, i8, "AudioProfile[format=", ", maxChannelCount=", sb);
        return a1.a.s(sb, ", channelMasks=", strValueOf, C2300e4.i.e);
    }

    public final boolean zza(int i2) {
        zzgpo zzgpoVar = this.zzd;
        if (zzgpoVar == null) {
            return i2 <= this.zzc;
        }
        int iZzB = zzep.zzB(i2);
        if (iZzB == 0) {
            return false;
        }
        return zzgpoVar.contains(Integer.valueOf(iZzB));
    }

    public final int zzb(int i2, zzd zzdVar) {
        if (this.zzd != null) {
            return this.zzc;
        }
        if (Build.VERSION.SDK_INT < 29) {
            Integer num = (Integer) zzpe.zzb.getOrDefault(Integer.valueOf(this.zzb), 0);
            num.getClass();
            return num.intValue();
        }
        int i8 = this.zzb;
        for (int i9 = 10; i9 > 0; i9--) {
            int iZzB = zzep.zzB(i9);
            if (iZzB != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i8).setSampleRate(i2).setChannelMask(iZzB).build(), zzdVar.zza())) {
                return i9;
            }
        }
        return 0;
    }

    @RequiresApi(33)
    public zzpd(int i2, Set set) {
        this.zzb = i2;
        zzgpo zzgpoVarZzo = zzgpo.zzo(set);
        this.zzd = zzgpoVarZzo;
        zzgrs it = zzgpoVarZzo.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, Integer.bitCount(((Integer) it.next()).intValue()));
        }
        this.zzc = iMax;
    }
}
