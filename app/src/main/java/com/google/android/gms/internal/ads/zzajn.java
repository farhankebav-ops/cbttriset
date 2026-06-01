package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzajn extends zzajw {

    @Nullable
    private zzadn zza;

    @Nullable
    private zzajm zzb;

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zza(boolean z2) {
        super.zza(z2);
        if (z2) {
            this.zza = null;
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final long zzb(zzeg zzegVar) {
        if (!zzd(zzegVar.zzi())) {
            return -1L;
        }
        int i2 = (zzegVar.zzi()[2] & 255) >> 4;
        if (i2 == 6) {
            zzegVar.zzk(4);
            zzegVar.zzO();
        } else if (i2 == 7) {
            i2 = 7;
            zzegVar.zzk(4);
            zzegVar.zzO();
        }
        int iZzc = zzadi.zzc(zzegVar, i2);
        zzegVar.zzh(0);
        return iZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzeg zzegVar, long j, zzaju zzajuVar) {
        byte[] bArrZzi = zzegVar.zzi();
        zzadn zzadnVar = this.zza;
        if (zzadnVar == null) {
            zzadn zzadnVar2 = new zzadn(bArrZzi, 17);
            this.zza = zzadnVar2;
            zzt zztVarZza = zzadnVar2.zzc(Arrays.copyOfRange(bArrZzi, 9, zzegVar.zze()), null).zza();
            zztVarZza.zzl("audio/ogg");
            zzajuVar.zza = zztVarZza.zzM();
            return true;
        }
        if ((bArrZzi[0] & 127) == 3) {
            zzadm zzadmVarZzc = zzadk.zzc(zzegVar);
            zzadn zzadnVarZze = zzadnVar.zze(zzadmVarZzc);
            this.zza = zzadnVarZze;
            this.zzb = new zzajm(zzadnVarZze, zzadmVarZzc);
            return true;
        }
        if (!zzd(bArrZzi)) {
            return true;
        }
        zzajm zzajmVar = this.zzb;
        if (zzajmVar != null) {
            zzajmVar.zzd(j);
            zzajuVar.zzb = this.zzb;
        }
        zzajuVar.zza.getClass();
        return false;
    }
}
