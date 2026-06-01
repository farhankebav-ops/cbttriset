package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzuk implements zzgb {
    private final zzgb zza;
    private final int zzb;
    private final zzuj zzc;
    private final byte[] zzd;
    private int zze;

    public zzuk(zzgb zzgbVar, int i2, zzuj zzujVar) {
        zzgmd.zza(i2 > 0);
        this.zza = zzgbVar;
        this.zzb = i2;
        this.zzc = zzujVar;
        this.zzd = new byte[1];
        this.zze = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i2, int i8) throws IOException {
        int i9 = this.zze;
        if (i9 == 0) {
            zzgb zzgbVar = this.zza;
            byte[] bArr2 = this.zzd;
            int i10 = 0;
            if (zzgbVar.zza(bArr2, 0, 1) != -1) {
                int i11 = (bArr2[0] & 255) << 4;
                if (i11 != 0) {
                    byte[] bArr3 = new byte[i11];
                    int i12 = i11;
                    while (i12 > 0) {
                        int iZza = zzgbVar.zza(bArr3, i10, i12);
                        if (iZza != -1) {
                            i10 += iZza;
                            i12 -= iZza;
                        }
                    }
                    while (i11 > 0) {
                        int i13 = i11 - 1;
                        if (bArr3[i13] != 0) {
                            break;
                        }
                        i11 = i13;
                    }
                    if (i11 > 0) {
                        this.zzc.zza(new zzeg(bArr3, i11));
                    }
                }
                i9 = this.zzb;
                this.zze = i9;
            }
            return -1;
        }
        int iZza2 = this.zza.zza(bArr, i2, Math.min(i9, i8));
        if (iZza2 != -1) {
            this.zze -= iZza2;
        }
        return iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final long zzb(zzgf zzgfVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    @Nullable
    public final Uri zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zzd() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zze(zzgz zzgzVar) {
        zzgzVar.getClass();
        this.zza.zze(zzgzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final Map zzj() {
        return this.zza.zzj();
    }
}
