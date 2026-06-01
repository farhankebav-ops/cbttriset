package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzlc extends zzlg {
    private final int zzc;

    public zzlc(byte[] bArr, int i2, int i8) {
        super(bArr);
        zzlh.zzj(0, i8, bArr.length);
        this.zzc = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg, com.google.android.gms.internal.measurement.zzlh
    public final byte zza(int i2) {
        int i8 = this.zzc;
        if (((i8 - (i2 + 1)) | i2) >= 0) {
            return ((zzlg) this).zza[i2];
        }
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 11), "Index < 0: ", i2));
        }
        throw new ArrayIndexOutOfBoundsException(a1.a.f(i2, i8, "Index > length: ", ", ", new StringBuilder(String.valueOf(i2).length() + 18 + String.valueOf(i8).length())));
    }

    @Override // com.google.android.gms.internal.measurement.zzlg, com.google.android.gms.internal.measurement.zzlh
    public final byte zzb(int i2) {
        return ((zzlg) this).zza[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzlg, com.google.android.gms.internal.measurement.zzlh
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final int zzd() {
        return 0;
    }
}
