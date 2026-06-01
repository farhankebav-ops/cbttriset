package com.bykv.vk.openvk.preload.geckox.buffer.a;

import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class b implements com.bykv.vk.openvk.preload.geckox.buffer.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RandomAccessFile f4956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f4957b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f4958c;

    public b(File file) throws IOException {
        this.f4958c = file;
        file.getParentFile().mkdirs();
        try {
            this.f4956a = new RandomAccessFile(file, "rw");
        } catch (Exception e) {
            CloseableUtils.close(this.f4956a);
            throw new IOException("create raf mSwap failed! path: " + file.getAbsolutePath() + " caused by: " + e.getMessage(), e);
        }
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void a() throws IOException {
        if (this.f4957b.get()) {
            throw new IOException("released!");
        }
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final long b() throws IOException {
        return this.f4956a.length();
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final long c() throws IOException {
        if (this.f4957b.get()) {
            throw new IOException("released!");
        }
        return this.f4956a.getFilePointer();
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int d() throws IOException {
        byte[] bArr = new byte[1];
        if (b(bArr) <= 0) {
            return -1;
        }
        return bArr[0];
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void e() {
        if (this.f4957b.getAndSet(true)) {
            return;
        }
        CloseableUtils.close(this.f4956a);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final File f() {
        return this.f4958c;
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void b(long j) throws IOException {
        if (this.f4957b.get()) {
            throw new IOException("released!");
        }
        if (j < 0) {
            j = 0;
        }
        this.f4956a.seek(j);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void a(int i2) throws IOException {
        a(new byte[]{(byte) i2});
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void a(byte[] bArr) throws IOException {
        a(bArr, 0, bArr.length);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final synchronized long a(long j) throws IOException {
        if (this.f4957b.get()) {
            throw new IOException("released!");
        }
        if (((int) j) == j) {
        } else {
            throw new IOException("too large:".concat(String.valueOf(j)));
        }
        return this.f4956a.skipBytes(r0);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int b(byte[] bArr) throws IOException {
        return b(bArr, 0, bArr.length);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int b(byte[] bArr, int i2, int i8) throws IOException {
        int i9;
        if (!this.f4957b.get()) {
            if (bArr == null || i8 <= 0 || i2 < 0 || i2 >= bArr.length) {
                return 0;
            }
            if (i2 + i8 > bArr.length) {
                i8 = bArr.length - i2;
            }
            synchronized (this) {
                i9 = this.f4956a.read(bArr, i2, i8);
            }
            return i9;
        }
        throw new IOException("released!");
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int a(byte[] bArr, int i2, int i8) throws IOException {
        if (!this.f4957b.get()) {
            if (bArr == null || bArr.length == 0 || i8 <= 0 || i2 < 0 || i2 >= bArr.length) {
                return 0;
            }
            if (i2 + i8 > bArr.length) {
                i8 = bArr.length - i2;
            }
            synchronized (this) {
                this.f4956a.write(bArr, i2, i8);
            }
            return i8;
        }
        throw new IOException("released!");
    }
}
