package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {
    private volatile byte[] buf;
    private final ArrayPool byteArrayPool;
    private int count;
    private int marklimit;
    private int markpos;
    private int pos;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) {
        this(inputStream, arrayPool, 65536);
    }

    private int fillbuf(InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = this.markpos;
        if (i2 != -1) {
            int i8 = this.pos - i2;
            int i9 = this.marklimit;
            if (i8 < i9) {
                if (i2 == 0 && i9 > bArr.length && this.count == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i9) {
                        i9 = length;
                    }
                    byte[] bArr2 = (byte[]) this.byteArrayPool.get(i9, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.buf = bArr2;
                    this.byteArrayPool.put(bArr);
                    bArr = bArr2;
                } else if (i2 > 0) {
                    System.arraycopy(bArr, i2, bArr, 0, bArr.length - i2);
                }
                int i10 = this.pos - this.markpos;
                this.pos = i10;
                this.markpos = 0;
                this.count = 0;
                int i11 = inputStream.read(bArr, i10, bArr.length - i10);
                int i12 = this.pos;
                if (i11 > 0) {
                    i12 += i11;
                }
                this.count = i12;
                return i11;
            }
        }
        int i13 = inputStream.read(bArr);
        if (i13 > 0) {
            this.markpos = -1;
            this.pos = 0;
            this.count = i13;
        }
        return i13;
    }

    private static IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.buf == null || inputStream == null) {
            throw streamClosed();
        }
        return (this.count - this.pos) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.buf != null) {
            this.byteArrayPool.put(this.buf);
            this.buf = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void fixMarkLimit() {
        this.marklimit = this.buf.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        this.marklimit = Math.max(this.marklimit, i2);
        this.markpos = this.pos;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.buf;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw streamClosed();
        }
        if (this.pos >= this.count && fillbuf(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.buf && (bArr = this.buf) == null) {
            throw streamClosed();
        }
        int i2 = this.count;
        int i8 = this.pos;
        if (i2 - i8 <= 0) {
            return -1;
        }
        this.pos = i8 + 1;
        return bArr[i8] & 255;
    }

    public synchronized void release() {
        if (this.buf != null) {
            this.byteArrayPool.put(this.buf);
            this.buf = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.buf == null) {
            throw new IOException("Stream is closed");
        }
        int i2 = this.markpos;
        if (-1 == i2) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.pos + " markLimit: " + this.marklimit);
        }
        this.pos = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.buf;
        if (bArr == null) {
            throw streamClosed();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw streamClosed();
        }
        int i2 = this.count;
        int i8 = this.pos;
        if (i2 - i8 >= j) {
            this.pos = (int) (((long) i8) + j);
            return j;
        }
        long j3 = ((long) i2) - ((long) i8);
        this.pos = i2;
        if (this.markpos == -1 || j > this.marklimit) {
            long jSkip = inputStream.skip(j - j3);
            if (jSkip > 0) {
                this.markpos = -1;
            }
            return j3 + jSkip;
        }
        if (fillbuf(inputStream, bArr) == -1) {
            return j3;
        }
        int i9 = this.count;
        int i10 = this.pos;
        if (i9 - i10 >= j - j3) {
            this.pos = (int) ((((long) i10) + j) - j3);
            return j;
        }
        long j8 = (j3 + ((long) i9)) - ((long) i10);
        this.pos = i9;
        return j8;
    }

    @VisibleForTesting
    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool, int i2) {
        super(inputStream);
        this.markpos = -1;
        this.byteArrayPool = arrayPool;
        this.buf = (byte[]) arrayPool.get(i2, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i2, int i8) throws IOException {
        int i9;
        int i10;
        byte[] bArr2 = this.buf;
        if (bArr2 == null) {
            throw streamClosed();
        }
        if (i8 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i11 = this.pos;
            int i12 = this.count;
            if (i11 < i12) {
                int i13 = i12 - i11 >= i8 ? i8 : i12 - i11;
                System.arraycopy(bArr2, i11, bArr, i2, i13);
                this.pos += i13;
                if (i13 == i8 || inputStream.available() == 0) {
                    return i13;
                }
                i2 += i13;
                i9 = i8 - i13;
            } else {
                i9 = i8;
            }
            while (true) {
                if (this.markpos == -1 && i9 >= bArr2.length) {
                    i10 = inputStream.read(bArr, i2, i9);
                    if (i10 == -1) {
                        return i9 != i8 ? i8 - i9 : -1;
                    }
                } else {
                    if (fillbuf(inputStream, bArr2) == -1) {
                        return i9 != i8 ? i8 - i9 : -1;
                    }
                    if (bArr2 != this.buf && (bArr2 = this.buf) == null) {
                        throw streamClosed();
                    }
                    int i14 = this.count;
                    int i15 = this.pos;
                    i10 = i14 - i15 >= i9 ? i9 : i14 - i15;
                    System.arraycopy(bArr2, i15, bArr, i2, i10);
                    this.pos += i10;
                }
                i9 -= i10;
                if (i9 == 0) {
                    return i8;
                }
                if (inputStream.available() == 0) {
                    return i8 - i9;
                }
                i2 += i10;
            }
        } else {
            throw streamClosed();
        }
    }
}
