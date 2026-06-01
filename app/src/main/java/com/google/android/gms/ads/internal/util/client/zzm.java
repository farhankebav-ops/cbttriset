package com.google.android.gms.ads.internal.util.client;

import com.google.android.gms.ads.internal.client.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zzm extends zzw {
    private final int zza;
    private final int zzb;
    private final boolean zzc;

    public zzm(int i2, int i8, boolean z2) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzw) {
            zzw zzwVar = (zzw) obj;
            if (this.zza == zzwVar.zza() && this.zzb == zzwVar.zzb() && this.zzc == zzwVar.zzc()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (true != this.zzc ? 1237 : 1231) ^ ((((this.zza ^ 1000003) * 1000003) ^ this.zzb) * 1000003);
    }

    public final String toString() {
        int i2 = this.zza;
        int length = String.valueOf(i2).length();
        int i8 = this.zzb;
        int length2 = String.valueOf(i8).length();
        boolean z2 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 59 + length2 + 26 + String.valueOf(z2).length() + 1);
        a.k(i2, i8, "OfflineAdConfig{impressionPrerequisite=", ", clickPrerequisite=", sb);
        sb.append(", notificationFlowEnabled=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzw
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzw
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzw
    public final boolean zzc() {
        return this.zzc;
    }
}
