package com.google.android.gms.internal.mlkit_vision_common;

import a1.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzma extends zzme {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    public /* synthetic */ zzma(String str, boolean z2, int i2, zzlz zzlzVar) {
        this.zza = str;
        this.zzb = z2;
        this.zzc = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzme) {
            zzme zzmeVar = (zzme) obj;
            if (this.zza.equals(zzmeVar.zzb()) && this.zzb == zzmeVar.zzc() && this.zzc == zzmeVar.zza()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        String str = this.zza;
        boolean z2 = this.zzb;
        int i2 = this.zzc;
        StringBuilder sb = new StringBuilder("MLKitLoggingOptions{libraryName=");
        sb.append(str);
        sb.append(", enableFirelog=");
        sb.append(z2);
        sb.append(", firelogEventType=");
        return a.q(sb, "}", i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzme
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzme
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzme
    public final boolean zzc() {
        return this.zzb;
    }
}
