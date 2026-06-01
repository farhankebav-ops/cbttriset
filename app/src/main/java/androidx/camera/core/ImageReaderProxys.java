package androidx.camera.core;

import android.media.ImageReader;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.ImageReaderProxy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ImageReaderProxys {
    private ImageReaderProxys() {
    }

    public static ImageReaderProxy createIsolatedReader(int i2, int i8, int i9, int i10) {
        return new AndroidImageReaderProxy(ImageReader.newInstance(i2, i8, i9, i10));
    }
}
