package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzba {

    @Nullable
    public final Object zza;
    public final int zzb;

    @Nullable
    public final zzak zzc;

    @Nullable
    public final Object zzd;
    public final int zze;
    public final long zzf;
    public final long zzg;
    public final int zzh;
    public final int zzi;

    static {
        String str = zzep.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
    }

    public zzba(@Nullable Object obj, int i2, @Nullable zzak zzakVar, @Nullable Object obj2, int i8, long j, long j3, int i9, int i10) {
        this.zza = obj;
        this.zzb = i2;
        this.zzc = zzakVar;
        this.zzd = obj2;
        this.zze = i8;
        this.zzf = j;
        this.zzg = j3;
        this.zzh = i9;
        this.zzi = i10;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzba.class == obj.getClass()) {
            zzba zzbaVar = (zzba) obj;
            if (this.zzb == zzbaVar.zzb && this.zze == zzbaVar.zze && this.zzf == zzbaVar.zzf && this.zzg == zzbaVar.zzg && this.zzh == zzbaVar.zzh && this.zzi == zzbaVar.zzi && Objects.equals(this.zzc, zzbaVar.zzc) && Objects.equals(this.zza, zzbaVar.zza) && Objects.equals(this.zzd, zzbaVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd, Integer.valueOf(this.zze), Long.valueOf(this.zzf), Long.valueOf(this.zzg), Integer.valueOf(this.zzh), Integer.valueOf(this.zzi));
    }

    public final String toString() {
        int i2 = this.zzb;
        int length = String.valueOf(i2).length();
        int i8 = this.zze;
        int length2 = String.valueOf(i8).length();
        long j = this.zzf;
        StringBuilder sb = new StringBuilder(length + 19 + length2 + 6 + String.valueOf(j).length());
        com.google.android.gms.ads.internal.client.a.k(i2, i8, "mediaItem=", ", period=", sb);
        sb.append(", pos=");
        sb.append(j);
        String string = sb.toString();
        int i9 = this.zzh;
        if (i9 == -1) {
            return string;
        }
        long j3 = this.zzg;
        int i10 = this.zzi;
        int length3 = string.length();
        StringBuilder sb2 = new StringBuilder(String.valueOf(i9).length() + length3 + 13 + String.valueOf(j3).length() + 10 + 5 + String.valueOf(i10).length());
        sb2.append(string);
        sb2.append(", contentPos=");
        sb2.append(j3);
        return a1.a.f(i9, i10, ", adGroup=", ", ad=", sb2);
    }
}
