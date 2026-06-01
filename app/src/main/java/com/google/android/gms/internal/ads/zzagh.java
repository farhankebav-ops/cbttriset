package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagh extends zzagq {
    public final byte[] zza;

    public zzagh(String str, byte[] bArr) {
        super(str);
        this.zza = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagh.class == obj.getClass()) {
            zzagh zzaghVar = (zzagh) obj;
            if (this.zzf.equals(zzaghVar.zzf) && Arrays.equals(this.zza, zzaghVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        return Arrays.hashCode(this.zza) + (iHashCode * 31);
    }
}
