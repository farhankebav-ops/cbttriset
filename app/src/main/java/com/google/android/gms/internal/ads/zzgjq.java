package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgjq extends zzgkr {
    private final int zza;

    @Nullable
    private final String zzb;
    private final int zzc;

    public /* synthetic */ zzgjq(int i2, String str, int i8, byte[] bArr) {
        this.zza = i2;
        this.zzb = str;
        this.zzc = i8;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgkr) {
            zzgkr zzgkrVar = (zzgkr) obj;
            if (this.zza == zzgkrVar.zza() && ((str = this.zzb) != null ? str.equals(zzgkrVar.zzb()) : zzgkrVar.zzb() == null) && this.zzc == zzgkrVar.zzc()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        return (((str == null ? 0 : str.hashCode()) ^ ((this.zza ^ 1000003) * 1000003)) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        int i2 = this.zza;
        int length = String.valueOf(i2).length();
        String str = this.zzb;
        int length2 = String.valueOf(str).length();
        int i8 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 46 + length2 + 9 + String.valueOf(i8).length() + 1);
        sb.append("OverlayDisplayState{statusCode=");
        sb.append(i2);
        sb.append(", sessionToken=");
        sb.append(str);
        return com.google.android.gms.ads.internal.client.a.j(sb, ", uiMode=", i8, "}");
    }

    @Override // com.google.android.gms.internal.ads.zzgkr
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgkr
    @Nullable
    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgkr
    public final int zzc() {
        return this.zzc;
    }
}
