package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.facebook.ads.AdError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzrw implements zzrz {
    @Override // com.google.android.gms.internal.ads.zzrz
    @Nullable
    public final zzrs zza(@Nullable zzru zzruVar, zzv zzvVar) {
        if (zzvVar.zzs == null) {
            return null;
        }
        return new zzsa(new zzrr(new zzsc(1), AdError.MEDIAVIEW_MISSING_ERROR_CODE));
    }

    @Override // com.google.android.gms.internal.ads.zzrz
    public final int zzb(zzv zzvVar) {
        return zzvVar.zzs != null ? 1 : 0;
    }
}
