package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.video.internal.workaround.DefaultEncoderProfilesProvider;
import java.nio.ByteOrder;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzadn {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final long zzj;

    @Nullable
    public final zzadm zzk;

    @Nullable
    private final zzap zzl;

    @VisibleForTesting
    public zzadn(int i2, int i8, int i9, int i10, int i11, int i12, int i13, long j, @Nullable zzadm zzadmVar, @Nullable zzap zzapVar) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = i9;
        this.zzd = i10;
        this.zze = i11;
        this.zzf = zzf(i11);
        this.zzg = i12;
        this.zzh = i13;
        this.zzi = zzg(i13);
        this.zzj = j;
        this.zzk = zzadmVar;
        this.zzl = zzapVar;
    }

    private static int zzf(int i2) {
        switch (i2) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case DefaultEncoderProfilesProvider.DEFAULT_AUDIO_SAMPLE_RATE /* 44100 */:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case DefaultEncoderProfilesProvider.DEFAULT_AUDIO_BITRATE /* 96000 */:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    private static int zzg(int i2) {
        if (i2 == 8) {
            return 1;
        }
        if (i2 == 12) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 20) {
            return 5;
        }
        if (i2 != 24) {
            return i2 != 32 ? -1 : 7;
        }
        return 6;
    }

    public final long zza() {
        long j = this.zzj;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / ((long) this.zze);
    }

    public final long zzb(long j) {
        String str = zzep.zza;
        return Math.max(0L, Math.min((j * ((long) this.zze)) / 1000000, this.zzj - 1));
    }

    public final zzv zzc(byte[] bArr, @Nullable zzap zzapVar) {
        bArr[4] = -128;
        zzap zzapVarZzd = zzd(zzapVar);
        zzt zztVar = new zzt();
        zztVar.zzm("audio/flac");
        int i2 = this.zzd;
        if (i2 <= 0) {
            i2 = -1;
        }
        zztVar.zzn(i2);
        zztVar.zzE(this.zzg);
        zztVar.zzF(this.zze);
        zztVar.zzG(zzep.zzz(this.zzh, ByteOrder.LITTLE_ENDIAN));
        zztVar.zzp(Collections.singletonList(bArr));
        zztVar.zzk(zzapVarZzd);
        return zztVar.zzM();
    }

    @Nullable
    public final zzap zzd(@Nullable zzap zzapVar) {
        zzap zzapVar2 = this.zzl;
        return zzapVar2 == null ? zzapVar : zzapVar2.zzf(zzapVar);
    }

    public final zzadn zze(@Nullable zzadm zzadmVar) {
        return new zzadn(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, zzadmVar, this.zzl);
    }

    public zzadn(byte[] bArr, int i2) {
        zzef zzefVar = new zzef(bArr, bArr.length);
        zzefVar.zzf(i2 * 8);
        this.zza = zzefVar.zzj(16);
        this.zzb = zzefVar.zzj(16);
        this.zzc = zzefVar.zzj(24);
        this.zzd = zzefVar.zzj(24);
        int iZzj = zzefVar.zzj(20);
        this.zze = iZzj;
        this.zzf = zzf(iZzj);
        this.zzg = zzefVar.zzj(3) + 1;
        int iZzj2 = zzefVar.zzj(5) + 1;
        this.zzh = iZzj2;
        this.zzi = zzg(iZzj2);
        this.zzj = zzefVar.zzk(36);
        this.zzk = null;
        this.zzl = null;
    }
}
