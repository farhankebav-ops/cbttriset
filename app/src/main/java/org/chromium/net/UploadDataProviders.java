package org.chromium.net;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class UploadDataProviders {
    private UploadDataProviders() {
    }

    public static UploadDataProvider create(File file) {
        return new c(new a4.a(file, 22));
    }

    public static UploadDataProvider create(ParcelFileDescriptor parcelFileDescriptor) {
        return new c(new a4.a(parcelFileDescriptor, 23));
    }

    public static UploadDataProvider create(ByteBuffer byteBuffer) {
        return new b(byteBuffer.slice());
    }

    public static UploadDataProvider create(byte[] bArr, int i2, int i8) {
        return new b(ByteBuffer.wrap(bArr, i2, i8).slice());
    }

    public static UploadDataProvider create(byte[] bArr) {
        return create(bArr, 0, bArr.length);
    }
}
