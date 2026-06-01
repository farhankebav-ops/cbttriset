package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class BufferedOutputStream extends OutputStream {
    private ArrayPool arrayPool;
    private byte[] buffer;
    private int index;

    @NonNull
    private final OutputStream out;

    public BufferedOutputStream(@NonNull OutputStream outputStream, @NonNull ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    private void flushBuffer() throws IOException {
        int i2 = this.index;
        if (i2 > 0) {
            this.out.write(this.buffer, 0, i2);
            this.index = 0;
        }
    }

    private void maybeFlushBuffer() throws IOException {
        if (this.index == this.buffer.length) {
            flushBuffer();
        }
    }

    private void release() {
        byte[] bArr = this.buffer;
        if (bArr != null) {
            this.arrayPool.put(bArr);
            this.buffer = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.out.close();
            release();
        } catch (Throwable th) {
            this.out.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flushBuffer();
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.buffer;
        int i8 = this.index;
        this.index = i8 + 1;
        bArr[i8] = (byte) i2;
        maybeFlushBuffer();
    }

    @VisibleForTesting
    public BufferedOutputStream(@NonNull OutputStream outputStream, ArrayPool arrayPool, int i2) {
        this.out = outputStream;
        this.arrayPool = arrayPool;
        this.buffer = (byte[]) arrayPool.get(i2, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i2, int i8) throws IOException {
        int i9 = 0;
        do {
            int i10 = i8 - i9;
            int i11 = i2 + i9;
            int i12 = this.index;
            if (i12 == 0 && i10 >= this.buffer.length) {
                this.out.write(bArr, i11, i10);
                return;
            }
            int iMin = Math.min(i10, this.buffer.length - i12);
            System.arraycopy(bArr, i11, this.buffer, this.index, iMin);
            this.index += iMin;
            i9 += iMin;
            maybeFlushBuffer();
        } while (i9 < i8);
    }
}
