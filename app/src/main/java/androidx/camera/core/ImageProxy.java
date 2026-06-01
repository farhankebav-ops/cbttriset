package androidx.camera.core;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface ImageProxy extends AutoCloseable {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface PlaneProxy {
        ByteBuffer getBuffer();

        int getPixelStride();

        int getRowStride();
    }

    @Override // java.lang.AutoCloseable
    void close();

    Rect getCropRect();

    int getFormat();

    int getHeight();

    @ExperimentalGetImage
    Image getImage();

    ImageInfo getImageInfo();

    PlaneProxy[] getPlanes();

    int getWidth();

    void setCropRect(Rect rect);

    Bitmap toBitmap();
}
