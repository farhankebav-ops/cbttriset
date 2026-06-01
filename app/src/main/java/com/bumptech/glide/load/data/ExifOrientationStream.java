package com.bumptech.glide.load.data;

import a1.a;
import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class ExifOrientationStream extends FilterInputStream {
    private static final byte[] EXIF_SEGMENT;
    private static final int ORIENTATION_POSITION;
    private static final int SEGMENT_LENGTH;
    private static final int SEGMENT_START_POSITION = 2;
    private final byte orientation;
    private int position;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        EXIF_SEGMENT = bArr;
        int length = bArr.length;
        SEGMENT_LENGTH = length;
        ORIENTATION_POSITION = length + 2;
    }

    public ExifOrientationStream(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 < -1 || i2 > 8) {
            throw new IllegalArgumentException(a.g(i2, "Cannot add invalid orientation: "));
        }
        this.orientation = (byte) i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2;
        int i8 = this.position;
        int i9 = (i8 < 2 || i8 > (i2 = ORIENTATION_POSITION)) ? super.read() : i8 == i2 ? this.orientation : EXIF_SEGMENT[i8 - 2] & 255;
        if (i9 != -1) {
            this.position++;
        }
        return i9;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = super.skip(j);
        if (jSkip > 0) {
            this.position = (int) (((long) this.position) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i8) throws IOException {
        int i9;
        int i10 = this.position;
        int i11 = ORIENTATION_POSITION;
        if (i10 > i11) {
            i9 = super.read(bArr, i2, i8);
        } else if (i10 == i11) {
            bArr[i2] = this.orientation;
            i9 = 1;
        } else if (i10 < 2) {
            i9 = super.read(bArr, i2, 2 - i10);
        } else {
            int iMin = Math.min(i11 - i10, i8);
            System.arraycopy(EXIF_SEGMENT, this.position - 2, bArr, i2, iMin);
            i9 = iMin;
        }
        if (i9 > 0) {
            this.position += i9;
        }
        return i9;
    }
}
