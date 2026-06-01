package com.bykv.vk.openvk.preload.geckox.buffer.a;

import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class c implements com.bykv.vk.openvk.preload.geckox.buffer.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RandomAccessFile f4961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f4962d = new AtomicBoolean(false);
    private File e;

    public c(long j, File file) throws IOException {
        this.f4959a = j;
        this.e = file;
        file.getParentFile().mkdirs();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f4961c = randomAccessFile;
            randomAccessFile.setLength(j);
        } catch (Exception e) {
            CloseableUtils.close(this.f4961c);
            throw new IOException("create raf swap failed! path: " + file.getAbsolutePath() + " caused by: " + e.getMessage(), e);
        }
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void a() throws IOException {
        if (this.f4962d.get()) {
            throw new IOException("released!");
        }
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final long b() {
        return this.f4959a;
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final long c() throws IOException {
        if (this.f4962d.get()) {
            throw new IOException("released!");
        }
        return this.f4960b;
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int d() throws IOException {
        byte[] bArr = new byte[1];
        if (b(bArr) == 0) {
            return -1;
        }
        return bArr[0];
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void e() {
        if (this.f4962d.getAndSet(true)) {
            return;
        }
        CloseableUtils.close(this.f4961c);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final File f() {
        return this.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000e A[PHI: r0
  0x000e: PHI (r0v5 long) = (r0v2 long), (r0v3 long) binds: [B:5:0x000c, B:8:0x0014] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(long r4) throws java.io.IOException {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.f4962d
            boolean r0 = r0.get()
            if (r0 != 0) goto L1f
            r0 = 0
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 >= 0) goto L10
        Le:
            r4 = r0
            goto L17
        L10:
            long r0 = r3.f4959a
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L17
            goto Le
        L17:
            r3.f4960b = r4
            java.io.RandomAccessFile r0 = r3.f4961c
            r0.seek(r4)
            return
        L1f:
            java.io.IOException r4 = new java.io.IOException
            java.lang.String r5 = "released!"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.geckox.buffer.a.c.b(long):void");
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
        int iSkipBytes;
        if (this.f4962d.get()) {
            throw new IOException("released!");
        }
        int i2 = (int) j;
        if (i2 == j) {
            iSkipBytes = this.f4961c.skipBytes(i2);
            this.f4960b = this.f4961c.getFilePointer();
        } else {
            throw new IOException("too large:".concat(String.valueOf(j)));
        }
        return iSkipBytes;
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int b(byte[] bArr) throws IOException {
        return b(bArr, 0, bArr.length);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int b(byte[] bArr, int i2, int i8) throws IOException {
        if (!this.f4962d.get()) {
            if (bArr == null || i8 <= 0 || i2 < 0 || i2 >= bArr.length) {
                return 0;
            }
            if (i2 + i8 > bArr.length) {
                i8 = bArr.length - i2;
            }
            synchronized (this) {
                try {
                    long j = this.f4960b;
                    long j3 = this.f4959a;
                    if (j == j3) {
                        return -1;
                    }
                    if (((long) i8) + j > j3) {
                        i8 = (int) (j3 - j);
                    }
                    int i9 = this.f4961c.read(bArr, i2, i8);
                    if (i9 == -1) {
                        return -1;
                    }
                    this.f4960b += (long) i9;
                    return i9;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new IOException("released!");
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int a(byte[] bArr, int i2, int i8) throws IOException {
        if (!this.f4962d.get()) {
            if (bArr == null || bArr.length == 0 || i8 <= 0 || i2 < 0 || i2 >= bArr.length) {
                return 0;
            }
            if (i2 + i8 > bArr.length) {
                i8 = bArr.length - i2;
            }
            synchronized (this) {
                try {
                    long j = this.f4960b;
                    long j3 = this.f4959a;
                    if (j == j3) {
                        return 0;
                    }
                    if (((long) i8) + j > j3) {
                        i8 = (int) (j3 - j);
                    }
                    this.f4961c.write(bArr, i2, i8);
                    this.f4960b += (long) i8;
                    return i8;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        throw new IOException("released!");
    }
}
