package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagk extends zzagq {
    public final String zza;
    public final String zzb;
    public final String zzc;

    public zzagk(String str, String str2, String str3) {
        super("COMM");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagk.class == obj.getClass()) {
            zzagk zzagkVar = (zzagk) obj;
            if (Objects.equals(this.zzb, zzagkVar.zzb) && Objects.equals(this.zza, zzagkVar.zza) && Objects.equals(this.zzc, zzagkVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() + ((this.zza.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31);
        String str = this.zzc;
        return (iHashCode * 31) + (str != null ? str.hashCode() : 0);
    }

    @Override // com.google.android.gms.internal.ads.zzagq
    public final String toString() {
        String str = this.zzf;
        int length = String.valueOf(str).length();
        String str2 = this.zzc;
        int length2 = String.valueOf(str2).length();
        String str3 = this.zza;
        int length3 = str3.length() + length + 11;
        String str4 = this.zzb;
        StringBuilder sb = new StringBuilder(str4.length() + length3 + 14 + 7 + length2);
        androidx.camera.core.processing.util.a.A(sb, str, ": language=", str3, ", description=");
        return a1.a.s(sb, str4, ", text=", str2);
    }
}
