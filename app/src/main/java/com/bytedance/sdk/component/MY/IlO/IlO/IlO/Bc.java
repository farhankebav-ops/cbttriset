package com.bytedance.sdk.component.MY.IlO.IlO.IlO;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends InputStream {
    InputStream IlO;
    HttpURLConnection MY;

    public Bc(InputStream inputStream, HttpURLConnection httpURLConnection) {
        this.IlO = inputStream;
        this.MY = httpURLConnection;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.IlO;
        if (inputStream != null) {
            return inputStream.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.IlO;
        if (inputStream != null) {
            inputStream.close();
            this.IlO = null;
        }
        HttpURLConnection httpURLConnection = this.MY;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.MY = null;
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        InputStream inputStream = this.IlO;
        if (inputStream != null) {
            inputStream.mark(i2);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream inputStream = this.IlO;
        if (inputStream != null) {
            return inputStream.markSupported();
        }
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InputStream inputStream = this.IlO;
        if (inputStream != null) {
            return inputStream.read();
        }
        return 0;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        InputStream inputStream = this.IlO;
        if (inputStream != null) {
            inputStream.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InputStream inputStream = this.IlO;
        if (inputStream != null) {
            return inputStream.skip(j);
        }
        return 0L;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InputStream inputStream = this.IlO;
        if (inputStream != null) {
            return inputStream.read(bArr);
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i8) throws IOException {
        InputStream inputStream = this.IlO;
        if (inputStream != null) {
            return inputStream.read(bArr, i2, i8);
        }
        return 0;
    }
}
