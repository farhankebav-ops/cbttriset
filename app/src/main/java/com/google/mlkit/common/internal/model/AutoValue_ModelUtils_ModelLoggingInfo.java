package com.google.mlkit.common.internal.model;

import a1.a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.internal.model.ModelUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class AutoValue_ModelUtils_ModelLoggingInfo extends ModelUtils.ModelLoggingInfo {
    private final long zza;
    private final String zzb;
    private final boolean zzc;

    public AutoValue_ModelUtils_ModelLoggingInfo(long j, String str, boolean z2) {
        this.zza = j;
        this.zzb = str;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ModelUtils.ModelLoggingInfo) {
            ModelUtils.ModelLoggingInfo modelLoggingInfo = (ModelUtils.ModelLoggingInfo) obj;
            if (this.zza == modelLoggingInfo.getSize() && this.zzb.equals(modelLoggingInfo.getHash()) && this.zzc == modelLoggingInfo.isManifestModel()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public String getHash() {
        return this.zzb;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public long getSize() {
        return this.zza;
    }

    public final int hashCode() {
        long j = this.zza;
        return ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ (true != this.zzc ? 1237 : 1231);
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public boolean isManifestModel() {
        return this.zzc;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ModelLoggingInfo{size=");
        sb.append(this.zza);
        sb.append(", hash=");
        sb.append(this.zzb);
        sb.append(", manifestModel=");
        return a.u(sb, this.zzc, "}");
    }
}
