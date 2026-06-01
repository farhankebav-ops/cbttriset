package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting
final class zzaqo extends FilterInputStream {
    private final long zza;
    private long zzb;

    public zzaqo(InputStream inputStream, long j) {
        super(inputStream);
        this.zza = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i2 = super.read();
        if (i2 != -1) {
            this.zzb++;
        }
        return i2;
    }

    public final long zza() {
        return this.zza - this.zzb;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i8) throws IOException {
        int i9 = super.read(bArr, i2, i8);
        if (i9 != -1) {
            this.zzb += (long) i9;
        }
        return i9;
    }
}
