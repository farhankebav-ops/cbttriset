package com.bykv.vk.openvk.preload.geckox.buffer.stream;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.geckox.buffer.a f4963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4964b;

    public a(com.bykv.vk.openvk.preload.geckox.buffer.a aVar) {
        this.f4963a = aVar;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        long jB = this.f4963a.b() - this.f4963a.c();
        if (jB > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jB;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i2) {
        this.f4964b = i2;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return this.f4963a.b(bArr);
    }

    @Override // java.io.InputStream
    public final synchronized void reset() throws IOException {
        this.f4963a.b(this.f4964b);
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        return this.f4963a.a(j);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i8) throws IOException {
        return this.f4963a.b(bArr, i2, i8);
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return this.f4963a.d();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }
}
