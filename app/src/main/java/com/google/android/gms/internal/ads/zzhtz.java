package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhtz implements CharSequence {
    private char[] zza;
    private String zzb;

    private zzhtz() {
        throw null;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i2) {
        return this.zza[i2];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.zza.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i2, int i8) {
        return new String(this.zza, i2, i8 - i2);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        if (this.zzb == null) {
            this.zzb = new String(this.zza);
        }
        return this.zzb;
    }

    public final void zza(char[] cArr) {
        this.zza = cArr;
        this.zzb = null;
    }

    public /* synthetic */ zzhtz(byte[] bArr) {
    }
}
