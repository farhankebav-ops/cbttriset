package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagl extends zzagq {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;

    public zzagl(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagl.class == obj.getClass()) {
            zzagl zzaglVar = (zzagl) obj;
            if (Objects.equals(this.zza, zzaglVar.zza) && Objects.equals(this.zzb, zzaglVar.zzb) && Objects.equals(this.zzc, zzaglVar.zzc) && Arrays.equals(this.zzd, zzaglVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = str != null ? str.hashCode() : 0;
        return Arrays.hashCode(this.zzd) + ((this.zzc.hashCode() + ((this.zzb.hashCode() + ((iHashCode + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31)) * 31)) * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzagq
    public final String toString() {
        String str = this.zzf;
        int length = String.valueOf(str).length();
        String str2 = this.zza;
        int length2 = String.valueOf(str2).length();
        String str3 = this.zzb;
        int length3 = str3.length() + a1.a.b(length, 11, length2, 11);
        String str4 = this.zzc;
        StringBuilder sb = new StringBuilder(str4.length() + length3 + 14);
        androidx.camera.core.processing.util.a.A(sb, str, ": mimeType=", str2, ", filename=");
        return a1.a.s(sb, str3, ", description=", str4);
    }
}
