package com.google.android.gms.internal.ads;

import com.vungle.ads.internal.protos.Sdk;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaoj implements zzaok {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, 143, 157, 173, 190, Sdk.SDKError.Reason.INVALID_JSON_BID_PAYLOAD_VALUE, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    private final zzadd zzc;
    private final zzaem zzd;
    private final zzaoo zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzeg zzh;
    private final int zzi;
    private final zzv zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzaoj(zzadd zzaddVar, zzaem zzaemVar, zzaoo zzaooVar) throws zzat {
        this.zzc = zzaddVar;
        this.zzd = zzaemVar;
        this.zze = zzaooVar;
        int iMax = Math.max(1, zzaooVar.zzc / 10);
        this.zzi = iMax;
        zzeg zzegVar = new zzeg(zzaooVar.zzf);
        zzegVar.zzu();
        int iZzu = zzegVar.zzu();
        this.zzf = iZzu;
        int i2 = zzaooVar.zzb;
        int i8 = zzaooVar.zzd;
        int iA = androidx.camera.core.processing.util.a.a(i8 - (i2 * 4), 8, zzaooVar.zze * i2, 1);
        if (iZzu != iA) {
            throw zzat.zzb(a1.a.f(iA, iZzu, "Expected frames per block: ", "; got: ", new StringBuilder(String.valueOf(iA).length() + 34 + String.valueOf(iZzu).length())), null);
        }
        String str = zzep.zza;
        int i9 = ((iMax + iZzu) - 1) / iZzu;
        this.zzg = new byte[i8 * i9];
        this.zzh = new zzeg((iZzu + iZzu) * i2 * i9);
        int i10 = ((zzaooVar.zzc * zzaooVar.zzd) * 8) / iZzu;
        zzt zztVar = new zzt();
        zztVar.zzm("audio/raw");
        zztVar.zzh(i10);
        zztVar.zzi(i10);
        zztVar.zzn((iMax + iMax) * i2);
        zztVar.zzE(zzaooVar.zzb);
        zztVar.zzF(zzaooVar.zzc);
        zztVar.zzG(2);
        this.zzj = zztVar.zzM();
    }

    private final void zzd(int i2) {
        long jZzt = this.zzl + zzep.zzt(this.zzn, 1000000L, this.zze.zzc, RoundingMode.DOWN);
        int iZzf = zzf(i2);
        this.zzd.zzx(jZzt, 1, iZzf, this.zzm - iZzf, null);
        this.zzn += (long) i2;
        this.zzm -= iZzf;
    }

    private final int zze(int i2) {
        int i8 = this.zze.zzb;
        return i2 / (i8 + i8);
    }

    private final int zzf(int i2) {
        return (i2 + i2) * this.zze.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaok
    public final void zza(long j) {
        this.zzk = 0;
        this.zzl = j;
        this.zzm = 0;
        this.zzn = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzaok
    public final void zzb(int i2, long j) {
        this.zzc.zzw(new zzaor(this.zze, this.zzf, i2, j));
        this.zzd.zzu(this.zzj);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003c -> B:4:0x0021). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzaok
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzc(com.google.android.gms.internal.ads.zzadb r25, long r26) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoj.zzc(com.google.android.gms.internal.ads.zzadb, long):boolean");
    }
}
