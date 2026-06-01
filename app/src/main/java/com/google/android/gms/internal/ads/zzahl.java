package com.google.android.gms.internal.ads;

import java.io.IOException;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahl {
    private final zzeg zza = new zzeg(8);
    private int zzb;

    private final long zzb(zzadb zzadbVar) throws IOException {
        int i2;
        zzeg zzegVar = this.zza;
        zzacr zzacrVar = (zzacr) zzadbVar;
        int i8 = 0;
        zzacrVar.zzh(zzegVar.zzi(), 0, 1, false);
        int i9 = zzegVar.zzi()[0] & 255;
        if (i9 == 0) {
            return Long.MIN_VALUE;
        }
        int i10 = 128;
        int i11 = 0;
        while (true) {
            i2 = i11 + 1;
            if ((i9 & i10) != 0) {
                break;
            }
            i10 >>= 1;
            i11 = i2;
        }
        int i12 = i9 & (~i10);
        zzacrVar.zzh(zzegVar.zzi(), 1, i11, false);
        while (i8 < i11) {
            i8++;
            i12 = (zzegVar.zzi()[i8] & 255) + (i12 << 8);
        }
        this.zzb += i2;
        return i12;
    }

    public final boolean zza(zzadb zzadbVar) throws IOException {
        long jZzo = zzadbVar.zzo();
        long j = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        if (jZzo != -1 && jZzo <= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            j = jZzo;
        }
        zzeg zzegVar = this.zza;
        zzacr zzacrVar = (zzacr) zzadbVar;
        zzacrVar.zzh(zzegVar.zzi(), 0, 4, false);
        this.zzb = 4;
        for (long jZzz = zzegVar.zzz(); jZzz != 440786851; jZzz = ((jZzz << 8) & (-256)) | ((long) (zzegVar.zzi()[0] & 255))) {
            int i2 = (int) j;
            int i8 = this.zzb + 1;
            this.zzb = i8;
            if (i8 == i2) {
                return false;
            }
            zzacrVar.zzh(zzegVar.zzi(), 0, 1, false);
        }
        long jZzb = zzb(zzadbVar);
        long j3 = this.zzb;
        if (jZzb != Long.MIN_VALUE) {
            long j8 = j3 + jZzb;
            if (jZzo == -1 || j8 < jZzo) {
                while (true) {
                    long j9 = this.zzb;
                    if (j9 < j8) {
                        if (zzb(zzadbVar) == Long.MIN_VALUE) {
                            return false;
                        }
                        long jZzb2 = zzb(zzadbVar);
                        if (jZzb2 < 0) {
                            return false;
                        }
                        if (jZzb2 != 0) {
                            int i9 = (int) jZzb2;
                            zzacrVar.zzj(i9, false);
                            this.zzb += i9;
                        }
                    } else if (j9 == j8) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
