package androidx.camera.core.internal.compat;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public final class ImageWriterCompat {
    private ImageWriterCompat() {
    }

    public static void close(ImageWriter imageWriter) {
        ImageWriterCompatApi23Impl.close(imageWriter);
    }

    public static Image dequeueInputImage(ImageWriter imageWriter) {
        return ImageWriterCompatApi23Impl.dequeueInputImage(imageWriter);
    }

    public static ImageWriter newInstance(Surface surface, @IntRange(from = 1) int i2, int i8) {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 29) {
            return ImageWriterCompatApi29Impl.newInstance(surface, i2, i8);
        }
        if (i9 >= 26) {
            return ImageWriterCompatApi26Impl.newInstance(surface, i2, i8);
        }
        throw new RuntimeException(a1.a.h(i9, "Unable to call newInstance(Surface, int, int) on API ", ". Version 26 or higher required."));
    }

    public static void queueInputImage(ImageWriter imageWriter, Image image) {
        ImageWriterCompatApi23Impl.queueInputImage(imageWriter, image);
    }

    public static void setOnImageReleasedListener(ImageWriter imageWriter, ImageWriter.OnImageReleasedListener onImageReleasedListener, Executor executor) {
        ImageWriterCompatApi23Impl.setOnImageReleasedListener(imageWriter, onImageReleasedListener, executor);
    }

    public static ImageWriter newInstance(Surface surface, @IntRange(from = 1) int i2) {
        return ImageWriterCompatApi23Impl.newInstance(surface, i2);
    }
}
