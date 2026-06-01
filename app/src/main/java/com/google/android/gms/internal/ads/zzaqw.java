package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaqw extends ByteArrayOutputStream {
    private final zzaql zza;

    public zzaqw(zzaql zzaqlVar, int i2) {
        this.zza = zzaqlVar;
        ((ByteArrayOutputStream) this).buf = zzaqlVar.zza(Math.max(i2, 256));
    }

    private final void zza(int i2) {
        int i8 = ((ByteArrayOutputStream) this).count;
        if (i8 + i2 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        zzaql zzaqlVar = this.zza;
        int i9 = i8 + i2;
        byte[] bArrZza = zzaqlVar.zza(i9 + i9);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArrZza, 0, ((ByteArrayOutputStream) this).count);
        zzaqlVar.zzb(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = bArrZza;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza.zzb(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public final void finalize() {
        this.zza.zzb(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i2) {
        zza(1);
        super.write(i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i2, int i8) {
        zza(i8);
        super.write(bArr, i2, i8);
    }
}
