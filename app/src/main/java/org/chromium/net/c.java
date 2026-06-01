package org.chromium.net;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends UploadDataProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile FileChannel f13257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a4.a f13258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f13259c = new Object();

    public c(a4.a aVar) {
        this.f13258b = aVar;
    }

    public final FileChannel a() {
        if (this.f13257a == null) {
            synchronized (this.f13259c) {
                try {
                    if (this.f13257a == null) {
                        this.f13257a = this.f13258b.j();
                    }
                } finally {
                }
            }
        }
        return this.f13257a;
    }

    @Override // org.chromium.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        FileChannel fileChannel = this.f13257a;
        if (fileChannel != null) {
            fileChannel.close();
        }
    }

    @Override // org.chromium.net.UploadDataProvider
    public final long getLength() {
        return a().size();
    }

    @Override // org.chromium.net.UploadDataProvider
    public final void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
        }
        FileChannel fileChannelA = a();
        int i2 = 0;
        while (i2 == 0) {
            int i8 = fileChannelA.read(byteBuffer);
            if (i8 == -1) {
                break;
            } else {
                i2 += i8;
            }
        }
        uploadDataSink.onReadSucceeded(false);
    }

    @Override // org.chromium.net.UploadDataProvider
    public final void rewind(UploadDataSink uploadDataSink) throws IOException {
        a().position(0L);
        uploadDataSink.onRewindSucceeded();
    }
}
