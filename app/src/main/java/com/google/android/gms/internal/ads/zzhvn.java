package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzhvn {
    private static volatile int zza = 100;
    public static final /* synthetic */ int zzf = 0;
    int zzb;
    int zzc;
    final int zzd = zza;
    Object zze;

    private zzhvn() {
    }

    public static zzhvn zzF(InputStream inputStream, int i2) {
        if (inputStream != null) {
            return new zzhvl(inputStream, 4096, null);
        }
        byte[] bArr = zzhxb.zzb;
        int length = bArr.length;
        return zzG(bArr, 0, 0, false);
    }

    public static zzhvn zzG(byte[] bArr, int i2, int i8, boolean z2) {
        zzhvj zzhvjVar = new zzhvj(bArr, i2, i8, z2, null);
        try {
            zzhvjVar.zzz(i8);
            return zzhvjVar;
        } catch (zzhxd e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zzK(int i2) {
        return (i2 >>> 1) ^ (-(i2 & 1));
    }

    public static long zzL(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static int zzM(int i2, InputStream inputStream) throws IOException {
        if ((i2 & 128) == 0) {
            return i2;
        }
        int i8 = i2 & 127;
        int i9 = 7;
        while (i9 < 32) {
            int i10 = inputStream.read();
            if (i10 == -1) {
                throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            i8 |= (i10 & 127) << i9;
            if ((i10 & 128) == 0) {
                return i8;
            }
            i9 += 7;
        }
        while (i9 < 64) {
            int i11 = inputStream.read();
            if (i11 == -1) {
                throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if ((i11 & 128) == 0) {
                return i8;
            }
            i9 += 7;
        }
        throw new zzhxd("CodedInputStream encountered a malformed varint.");
    }

    public abstract void zzA(int i2);

    public abstract boolean zzB() throws IOException;

    public abstract int zzC();

    public final void zzH() throws zzhxd {
        if (this.zzb + this.zzc >= this.zzd) {
            throw new zzhxd("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }

    public final void zzI() throws zzhxd {
        if (this.zzc == 0) {
            zzb(0);
        }
    }

    public final void zzJ() throws IOException {
        int iZza;
        do {
            iZza = zza();
            if (iZza == 0) {
                return;
            }
            zzH();
            this.zzc++;
            this.zzc--;
        } while (zzc(iZza));
    }

    public abstract int zza() throws IOException;

    public abstract void zzb(int i2) throws zzhxd;

    public abstract boolean zzc(int i2) throws IOException;

    public abstract double zzd() throws IOException;

    public abstract float zze() throws IOException;

    public abstract long zzf() throws IOException;

    public abstract long zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract long zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract boolean zzk() throws IOException;

    public abstract String zzl() throws IOException;

    public abstract String zzm() throws IOException;

    public abstract zzhvi zzn() throws IOException;

    public abstract int zzo() throws IOException;

    public abstract int zzp() throws IOException;

    public abstract int zzq() throws IOException;

    public abstract long zzr() throws IOException;

    public abstract int zzs() throws IOException;

    public abstract long zzt() throws IOException;

    public abstract int zzz(int i2) throws zzhxd;

    public /* synthetic */ zzhvn(byte[] bArr) {
    }
}
