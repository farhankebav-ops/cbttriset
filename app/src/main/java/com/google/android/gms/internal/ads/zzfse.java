package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting
final class zzfse implements zzfsh {
    private static final zzauz zza;

    static {
        zzauc zzaucVarZzj = zzauz.zzj();
        zzaucVarZzj.zzo(ExifInterface.LONGITUDE_EAST);
        zza = (zzauz) zzaucVarZzj.zzbu();
    }

    @Override // com.google.android.gms.internal.ads.zzfsh
    public final zzauz zza() {
        return zza;
    }
}
