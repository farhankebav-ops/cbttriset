package com.google.android.gms.internal.ads;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzss {
    public final zzsy zza;
    public final MediaFormat zzb;
    public final zzv zzc;

    @Nullable
    public final Surface zzd;

    @Nullable
    public final MediaCrypto zze = null;

    @Nullable
    public final zzsr zzf;

    private zzss(zzsy zzsyVar, MediaFormat mediaFormat, zzv zzvVar, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, @Nullable zzsr zzsrVar) {
        this.zza = zzsyVar;
        this.zzb = mediaFormat;
        this.zzc = zzvVar;
        this.zzd = surface;
        this.zzf = zzsrVar;
    }

    public static zzss zza(zzsy zzsyVar, MediaFormat mediaFormat, zzv zzvVar, @Nullable MediaCrypto mediaCrypto, @Nullable zzsr zzsrVar) {
        return new zzss(zzsyVar, mediaFormat, zzvVar, null, null, zzsrVar);
    }

    public static zzss zzb(zzsy zzsyVar, MediaFormat mediaFormat, zzv zzvVar, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto) {
        return new zzss(zzsyVar, mediaFormat, zzvVar, surface, null, null);
    }
}
