package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.annotation.NonNull;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfb extends OutputStream {
    private long zza = 0;

    @Override // java.io.OutputStream
    public final void write(int i2) {
        this.zza++;
    }

    public final long zza() {
        return this.zza;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.zza += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(@NonNull byte[] bArr, int i2, int i8) {
        int length;
        int i9;
        if (i2 >= 0 && i2 <= (length = bArr.length) && i8 >= 0 && (i9 = i2 + i8) <= length && i9 >= 0) {
            this.zza += (long) i8;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
