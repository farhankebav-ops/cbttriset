package com.google.mlkit.common.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.mlkit_common.zzq;
import com.google.android.gms.internal.mlkit_common.zzr;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RemoteModelSource {

    @Nullable
    private final String zza;

    @KeepForSdk
    public RemoteModelSource(@Nullable String str) {
        this.zza = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(getClass())) {
            return Objects.equal(this.zza, ((RemoteModelSource) obj).zza);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
    }

    @NonNull
    public String toString() {
        zzq zzqVarZzb = zzr.zzb("RemoteModelSource");
        zzqVarZzb.zza("firebaseModelName", this.zza);
        return zzqVarZzb.toString();
    }

    @Nullable
    public final String zza() {
        return this.zza;
    }
}
