package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaen {
    private final byte[] zza = new byte[10];
    private boolean zzb;
    private int zzc;
    private long zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public final void zza() {
        this.zzb = false;
        this.zzc = 0;
    }

    public final void zzb(zzadb zzadbVar) throws IOException {
        if (this.zzb) {
            return;
        }
        byte[] bArr = this.zza;
        zzadbVar.zzi(bArr, 0, 10);
        zzadbVar.zzl();
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            this.zzb = true;
        }
    }

    public final void zzc(zzaem zzaemVar, long j, int i2, int i8, int i9, @Nullable zzael zzaelVar) {
        zzgmd.zzi(this.zzg <= i8 + i9, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.zzb) {
            int i10 = this.zzc;
            int i11 = i10 + 1;
            this.zzc = i11;
            if (i10 == 0) {
                this.zzd = j;
                this.zze = i2;
                this.zzf = 0;
            }
            this.zzf += i8;
            this.zzg = i9;
            if (i11 >= 16) {
                zzd(zzaemVar, zzaelVar);
            }
        }
    }

    public final void zzd(zzaem zzaemVar, @Nullable zzael zzaelVar) {
        if (this.zzc > 0) {
            zzaemVar.zzx(this.zzd, this.zze, this.zzf, this.zzg, zzaelVar);
            this.zzc = 0;
        }
    }
}
