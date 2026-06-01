package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagb implements zzao {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final byte[] zze;
    private int zzf;

    static {
        zzt zztVar = new zzt();
        zztVar.zzm("application/id3");
        zztVar.zzM();
        zzt zztVar2 = new zzt();
        zztVar2.zzm("application/x-scte35");
        zztVar2.zzM();
    }

    public zzagb(String str, String str2, long j, long j3, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = j3;
        this.zze = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagb.class == obj.getClass()) {
            zzagb zzagbVar = (zzagb) obj;
            if (this.zzc == zzagbVar.zzc && this.zzd == zzagbVar.zzd && Objects.equals(this.zza, zzagbVar.zza) && Objects.equals(this.zzb, zzagbVar.zzb) && Arrays.equals(this.zze, zzagbVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzf;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = this.zza.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        int iHashCode2 = this.zzb.hashCode() + (iHashCode * 31);
        long j = this.zzc;
        long j3 = this.zzd;
        int iHashCode3 = Arrays.hashCode(this.zze) + (((((iHashCode2 * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) j3)) * 31);
        this.zzf = iHashCode3;
        return iHashCode3;
    }

    public final String toString() {
        long j = this.zzd;
        int length = String.valueOf(j).length();
        long j3 = this.zzc;
        int length2 = String.valueOf(j3).length();
        String str = this.zza;
        int length3 = str.length() + 18 + length + 13 + length2;
        String str2 = this.zzb;
        StringBuilder sb = new StringBuilder(str2.length() + length3 + 8);
        androidx.camera.core.processing.util.a.z(sb, "EMSG: scheme=", str, ", id=");
        sb.append(j);
        androidx.camera.core.processing.util.a.y(sb, ", durationMs=", j3, ", value=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final /* synthetic */ void zza(zzam zzamVar) {
        g.a(this, zzamVar);
    }
}
