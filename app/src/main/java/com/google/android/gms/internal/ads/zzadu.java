package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzadu {
    private final zzeg zza = new zzeg(10);

    private final boolean zzb(zzadb zzadbVar, int i2) throws IOException {
        int i8;
        int i9 = 0;
        do {
            int i10 = i9 % 10;
            if (i10 == 0) {
                if (i9 != 0) {
                    zzeg zzegVar = this.zza;
                    System.arraycopy(zzegVar.zzi(), 10, zzegVar.zzi(), 0, 9);
                }
                i8 = 0;
            } else {
                i8 = i10;
            }
            int i11 = i9 != 0 ? 1 : 10;
            try {
                zzeg zzegVar2 = this.zza;
                int i12 = i10 + 10;
                zzadbVar.zzi(zzegVar2.zzi(), i12 - i11, i11);
                zzegVar2.zzh(i8);
                zzegVar2.zzf(i12);
                if (zzegVar2.zzq() == 4801587) {
                    return true;
                }
                if (zzadx.zza(zzegVar2.zzr()) != -1) {
                    return false;
                }
                if (i9 == 0) {
                    zzegVar2.zzc(20);
                }
                i9++;
            } catch (EOFException unused) {
            }
        } while (i9 <= i2);
        return false;
    }

    @Nullable
    public final zzap zza(zzadb zzadbVar, @Nullable zzagm zzagmVar, int i2) throws IOException {
        zzap zzapVarZza = null;
        int i8 = 0;
        while (zzb(zzadbVar, i2)) {
            zzeg zzegVar = this.zza;
            int iZzg = zzegVar.zzg();
            zzegVar.zzk(6);
            int iZzG = zzegVar.zzG();
            int i9 = iZzG + 10;
            if (zzapVarZza == null) {
                byte[] bArr = new byte[i9];
                System.arraycopy(zzegVar.zzi(), iZzg, bArr, 0, 10);
                zzadbVar.zzi(bArr, 10, iZzG);
                zzapVarZza = zzagp.zza(bArr, i9, zzagmVar, new zzaga());
            } else {
                zzadbVar.zzk(iZzG);
            }
            i8 += i9;
        }
        zzadbVar.zzl();
        zzadbVar.zzk(i8);
        return zzapVarZza;
    }
}
