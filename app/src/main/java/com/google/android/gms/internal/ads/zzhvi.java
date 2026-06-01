package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzhvi implements Iterable<Byte>, Serializable {
    public static final zzhvi zzb = new zzhvg(zzhxb.zzb);
    private int zza = 0;

    static {
        int i2 = zzhuv.zza;
    }

    public static int zzA(int i2, int i8, int i9) {
        int i10 = i8 - i2;
        if ((i2 | i8 | i10 | (i9 - i8)) >= 0) {
            return i10;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(com.google.android.gms.ads.internal.client.a.j(new StringBuilder(String.valueOf(i2).length() + 21), "Beginning index: ", i2, " < 0"));
        }
        if (i8 < i2) {
            throw new IndexOutOfBoundsException(a1.a.f(i2, i8, "Beginning index larger than ending index: ", ", ", new StringBuilder(String.valueOf(i2).length() + 44 + String.valueOf(i8).length())));
        }
        throw new IndexOutOfBoundsException(a1.a.f(i8, i9, "End index: ", " >= ", new StringBuilder(String.valueOf(i8).length() + 15 + String.valueOf(i9).length())));
    }

    private static zzhvi zzd(Iterator it, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException(a1.a.h(i2, "length (", ") must be >= 1"));
        }
        if (i2 == 1) {
            return (zzhvi) it.next();
        }
        int i8 = i2 >>> 1;
        zzhvi zzhviVarZzd = zzd(it, i8);
        zzhvi zzhviVarZzd2 = zzd(it, i2 - i8);
        if (Integer.MAX_VALUE - zzhviVarZzd.zzc() >= zzhviVarZzd2.zzc()) {
            return zzhyq.zzd(zzhviVarZzd, zzhviVarZzd2);
        }
        int iZzc = zzhviVarZzd.zzc();
        int iZzc2 = zzhviVarZzd2.zzc();
        throw new IllegalArgumentException(a1.a.f(iZzc, iZzc2, "ByteString would be too long: ", "+", new StringBuilder(String.valueOf(iZzc).length() + 31 + String.valueOf(iZzc2).length())));
    }

    public static zzhvi zzr(byte[] bArr, int i2, int i8) {
        zzA(i2, i2 + i8, bArr.length);
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, i2, bArr2, 0, i8);
        return new zzhvg(bArr2);
    }

    public static zzhvi zzs(String str) {
        return new zzhvg(str.getBytes(zzhxb.zza));
    }

    public static zzhvi zzt(Iterable iterable) {
        int size;
        if (iterable instanceof Collection) {
            size = ((Collection) iterable).size();
        } else {
            Iterator it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        }
        return size == 0 ? zzb : zzd(iterable.iterator(), size);
    }

    public static zzhvh zzx() {
        return new zzhvh(128);
    }

    public static void zzz(int i2, int i8) {
        if (((i8 - (i2 + 1)) | i2) < 0) {
            if (i2 < 0) {
                throw new ArrayIndexOutOfBoundsException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 11), "Index < 0: ", i2));
            }
            throw new ArrayIndexOutOfBoundsException(a1.a.f(i2, i8, "Index > length: ", ", ", new StringBuilder(String.valueOf(i2).length() + 18 + String.valueOf(i8).length())));
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzo = this.zza;
        if (iZzo == 0) {
            int iZzc = zzc();
            iZzo = zzo(iZzc, 0, iZzc);
            if (iZzo == 0) {
                iZzo = 1;
            }
            this.zza = iZzo;
        }
        return iZzo;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        return a1.a.r(androidx.camera.core.processing.util.a.s("<ByteString@", zzc(), hexString, " size=", " contents=\""), zzc() <= 50 ? zzhza.zza(this) : zzhza.zza(zzi(0, 47)).concat("..."), "\">");
    }

    public abstract byte zza(int i2);

    public abstract byte zzb(int i2);

    public abstract int zzc();

    public abstract void zze(byte[] bArr, int i2, int i8, int i9);

    public abstract int zzf();

    public abstract boolean zzg();

    public abstract zzhvi zzi(int i2, int i8);

    public abstract ByteBuffer zzj();

    public abstract void zzk(zzhuz zzhuzVar) throws IOException;

    public abstract String zzl(Charset charset);

    public abstract boolean zzm();

    public abstract int zzn(int i2, int i8, int i9);

    public abstract int zzo(int i2, int i8, int i9);

    public abstract zzhvn zzp();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public zzhvd iterator() {
        return new zzhva(this);
    }

    @Deprecated
    public final void zzu(byte[] bArr, int i2, int i8, int i9) {
        zzA(0, i9, zzc());
        zzA(i8, i8 + i9, bArr.length);
        if (i9 > 0) {
            zze(bArr, 0, i8, i9);
        }
    }

    public final byte[] zzv() {
        int iZzc = zzc();
        if (iZzc == 0) {
            return zzhxb.zzb;
        }
        byte[] bArr = new byte[iZzc];
        zze(bArr, 0, 0, iZzc);
        return bArr;
    }

    public final String zzw() {
        return zzc() == 0 ? "" : zzl(zzhxb.zza);
    }

    public final int zzy() {
        return this.zza;
    }
}
