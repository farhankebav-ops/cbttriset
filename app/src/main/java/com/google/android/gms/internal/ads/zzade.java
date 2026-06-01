package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzade {
    @Pure
    public static void zza(boolean z2, @Nullable String str) throws zzat {
        if (!z2) {
            throw zzat.zzb(str, null);
        }
    }

    public static int zzb(zzadb zzadbVar, byte[] bArr, int i2, int i8) throws IOException {
        int i9 = 0;
        while (i9 < i8) {
            int iZzg = zzadbVar.zzg(bArr, i2 + i9, i8 - i9);
            if (iZzg == -1) {
                break;
            }
            i9 += iZzg;
        }
        return i9;
    }

    public static boolean zzc(zzadb zzadbVar, byte[] bArr, int i2, int i8) throws IOException {
        try {
            zzadbVar.zzc(bArr, i2, i8);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zzd(zzadb zzadbVar, int i2) throws IOException {
        try {
            zzadbVar.zzf(i2);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zze(zzadb zzadbVar, byte[] bArr, int i2, int i8, boolean z2) throws IOException {
        try {
            return zzadbVar.zzh(bArr, 0, i8, z2);
        } catch (EOFException e) {
            if (z2) {
                return false;
            }
            throw e;
        }
    }

    public static int zzf(int i2) {
        if (i2 == 20) {
            return 63750;
        }
        if (i2 == 30) {
            return 2250000;
        }
        switch (i2) {
            case 5:
                return 80000;
            case 6:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            default:
                switch (i2) {
                    case 14:
                        return 3062500;
                    case 15:
                        return 8000;
                    case 16:
                        return 256000;
                    case 17:
                        return 336000;
                    case 18:
                        return 768000;
                    default:
                        return -2147483647;
                }
        }
    }
}
