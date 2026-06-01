package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagf implements zzao {
    public final int zza;

    @Nullable
    public final String zzb;

    @Nullable
    public final String zzc;

    @Nullable
    public final String zzd;
    public final boolean zze;
    public final int zzf;

    public zzagf(int i2, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z2, int i8) {
        boolean z7 = true;
        if (i8 != -1 && i8 <= 0) {
            z7 = false;
        }
        zzgmd.zza(z7);
        this.zza = i2;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z2;
        this.zzf = i8;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagf.class == obj.getClass()) {
            zzagf zzagfVar = (zzagf) obj;
            if (this.zza == zzagfVar.zza && Objects.equals(this.zzb, zzagfVar.zzb) && Objects.equals(this.zzc, zzagfVar.zzc) && Objects.equals(this.zzd, zzagfVar.zzd) && this.zze == zzagfVar.zze && this.zzf == zzagfVar.zzf) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        int iHashCode = str != null ? str.hashCode() : 0;
        int i2 = this.zza;
        String str2 = this.zzc;
        int iHashCode2 = str2 != null ? str2.hashCode() : 0;
        int i8 = ((i2 + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + iHashCode;
        String str3 = this.zzd;
        return (((((((i8 * 31) + iHashCode2) * 31) + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.zze ? 1 : 0)) * 31) + this.zzf;
    }

    public final String toString() {
        String str = this.zzc;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        int length2 = String.valueOf(str2).length();
        int i2 = this.zza;
        int length3 = String.valueOf(i2).length();
        int i8 = this.zzf;
        StringBuilder sb = new StringBuilder(length + 28 + length2 + 11 + length3 + 19 + String.valueOf(i8).length());
        androidx.camera.core.processing.util.a.A(sb, "IcyHeaders: name=\"", str, "\", genre=\"", str2);
        return a1.a.f(i2, i8, "\", bitrate=", ", metadataInterval=", sb);
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final void zza(zzam zzamVar) {
        String str = this.zzc;
        if (str != null) {
            zzamVar.zzu(str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            zzamVar.zzt(str2);
        }
    }
}
