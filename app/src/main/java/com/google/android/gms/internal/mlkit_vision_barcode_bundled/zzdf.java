package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import a1.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzdf implements Iterable, Serializable {
    public static final zzdf zzb = new zzde(zzep.zzb);
    private int zza = 0;

    static {
        int i2 = zzct.zza;
    }

    private static zzdf zzc(Iterator it, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException(a.h(i2, "length (", ") must be >= 1"));
        }
        if (i2 == 1) {
            return (zzdf) it.next();
        }
        int i8 = i2 >>> 1;
        zzdf zzdfVarZzc = zzc(it, i8);
        zzdf zzdfVarZzc2 = zzc(it, i2 - i8);
        if (Integer.MAX_VALUE - zzdfVarZzc.zzd() >= zzdfVarZzc2.zzd()) {
            return zzgd.zzy(zzdfVarZzc, zzdfVarZzc2);
        }
        throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("ByteString would be too long: ", zzdfVarZzc.zzd(), "+", zzdfVarZzc2.zzd()));
    }

    public static int zzo(int i2, int i8, int i9) {
        int i10 = i8 - i2;
        if ((i2 | i8 | i10 | (i9 - i8)) >= 0) {
            return i10;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(a.h(i2, "Beginning index: ", " < 0"));
        }
        if (i8 < i2) {
            throw new IndexOutOfBoundsException(androidx.camera.core.processing.util.a.i("Beginning index larger than ending index: ", i2, ", ", i8));
        }
        throw new IndexOutOfBoundsException(androidx.camera.core.processing.util.a.i("End index: ", i8, " >= ", i9));
    }

    public static zzdf zzr(byte[] bArr, int i2, int i8) {
        zzo(i2, i2 + i8, bArr.length);
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, i2, bArr2, 0, i8);
        return new zzde(bArr2);
    }

    public static zzdf zzs(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int iMin = 256;
        while (true) {
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                int i8 = inputStream.read(bArr, i2, iMin - i2);
                if (i8 == -1) {
                    break;
                }
                i2 += i8;
            }
            zzdf zzdfVarZzr = i2 == 0 ? null : zzr(bArr, 0, i2);
            if (zzdfVarZzr == null) {
                break;
            }
            arrayList.add(zzdfVarZzr);
            iMin = Math.min(iMin + iMin, 8192);
        }
        int size = arrayList.size();
        return size == 0 ? zzb : zzc(arrayList.iterator(), size);
    }

    public static void zzu(int i2, int i8) {
        if (((i8 - (i2 + 1)) | i2) < 0) {
            if (i2 >= 0) {
                throw new ArrayIndexOutOfBoundsException(androidx.camera.core.processing.util.a.i("Index > length: ", i2, ", ", i8));
            }
            throw new ArrayIndexOutOfBoundsException(a.g(i2, "Index < 0: "));
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzi = this.zza;
        if (iZzi == 0) {
            int iZzd = zzd();
            iZzi = zzi(iZzd, 0, iZzd);
            if (iZzi == 0) {
                iZzi = 1;
            }
            this.zza = iZzi;
        }
        return iZzi;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        return a.r(androidx.camera.core.processing.util.a.s("<ByteString@", zzd(), hexString, " size=", " contents=\""), zzd() <= 50 ? zzgq.zza(this) : zzgq.zza(zzk(0, 47)).concat("..."), "\">");
    }

    public abstract byte zza(int i2);

    public abstract byte zzb(int i2);

    public abstract int zzd();

    public abstract void zze(byte[] bArr, int i2, int i8, int i9);

    public abstract int zzf();

    public abstract boolean zzh();

    public abstract int zzi(int i2, int i8, int i9);

    public abstract int zzj(int i2, int i8, int i9);

    public abstract zzdf zzk(int i2, int i8);

    public abstract String zzl(Charset charset);

    public abstract void zzm(zzcx zzcxVar) throws IOException;

    public abstract boolean zzn();

    public final int zzp() {
        return this.zza;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public zzdb iterator() {
        return new zzcy(this);
    }

    public final String zzt() {
        return zzd() == 0 ? "" : zzl(zzep.zza);
    }

    @Deprecated
    public final void zzv(byte[] bArr, int i2, int i8, int i9) {
        zzo(0, i9, zzd());
        zzo(i8, i8 + i9, bArr.length);
        if (i9 > 0) {
            zze(bArr, 0, i8, i9);
        }
    }

    public final byte[] zzw() {
        int iZzd = zzd();
        if (iZzd == 0) {
            return zzep.zzb;
        }
        byte[] bArr = new byte[iZzd];
        zze(bArr, 0, 0, iZzd);
        return bArr;
    }
}
