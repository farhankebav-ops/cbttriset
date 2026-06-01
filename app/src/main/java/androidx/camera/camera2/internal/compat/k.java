package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class k {
    public static CameraManagerCompat.CameraManagerCompatImpl a(Context context, Handler handler) {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 30 ? new CameraManagerCompatApi30Impl(context) : i2 >= 29 ? new CameraManagerCompatApi29Impl(context) : i2 >= 28 ? CameraManagerCompatApi28Impl.create(context) : CameraManagerCompatBaseImpl.create(context, handler);
    }
}
