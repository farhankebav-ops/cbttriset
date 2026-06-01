package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzlh implements Iterable, Serializable {
    public static final zzlh zzb = new zzlg(zzmp.zzb);
    private int zza = 0;

    static {
        int i2 = zzkv.zza;
    }

    public static zzlh zzh(byte[] bArr, int i2, int i8) {
        zzj(i2, i2 + i8, bArr.length);
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, i2, bArr2, 0, i8);
        return new zzlg(bArr2);
    }

    public static int zzj(int i2, int i8, int i9) {
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

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzg = this.zza;
        if (iZzg == 0) {
            int iZzc = zzc();
            iZzg = zzg(iZzc, 0, iZzc);
            if (iZzg == 0) {
                iZzg = 1;
            }
            this.zza = iZzg;
        }
        return iZzg;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzla(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        return a1.a.r(androidx.camera.core.processing.util.a.s("<ByteString@", zzc(), hexString, " size=", " contents=\""), zzc() <= 50 ? zzog.zza(this) : zzog.zza(zze(0, 47)).concat("..."), "\">");
    }

    public abstract byte zza(int i2);

    public abstract byte zzb(int i2);

    public abstract int zzc();

    public abstract zzlh zze(int i2, int i8);

    public abstract void zzf(zzkz zzkzVar) throws IOException;

    public abstract int zzg(int i2, int i8, int i9);

    public final int zzi() {
        return this.zza;
    }
}
