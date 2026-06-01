package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
final class ImageWriterCompatApi26Impl {
    private static final String TAG = "ImageWriterCompatApi26";
    private static Method sNewInstanceMethod;

    static {
        try {
            Class cls = Integer.TYPE;
            sNewInstanceMethod = ImageWriter.class.getMethod("newInstance", Surface.class, cls, cls);
        } catch (NoSuchMethodException e) {
            Log.i(TAG, "Unable to initialize via reflection.", e);
        }
    }

    private ImageWriterCompatApi26Impl() {
    }

    public static ImageWriter newInstance(Surface surface, @IntRange(from = 1) int i2, int i8) {
        Throwable th = null;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
            } catch (IllegalAccessException | InvocationTargetException e) {
                e = e;
            }
            try {
                return (ImageWriter) Preconditions.checkNotNull(sNewInstanceMethod.invoke(null, surface, Integer.valueOf(i2), Integer.valueOf(i8)));
            } catch (InvocationTargetException e4) {
                e = e4;
                th = e;
                throw new RuntimeException("Unable to invoke newInstance(Surface, int, int) via reflection.", th);
            }
        }
        throw new RuntimeException("Unable to invoke newInstance(Surface, int, int) via reflection.", th);
    }
}
