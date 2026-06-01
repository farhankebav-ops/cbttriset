package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceCompat {
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_Q = 255;
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U = 1073745919;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void stopForeground(Service service, int i2) {
            service.stopForeground(i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void startForeground(Service service, int i2, Notification notification, int i8) {
            if (i8 == 0 || i8 == -1) {
                service.startForeground(i2, notification, i8);
            } else {
                service.startForeground(i2, notification, i8 & 255);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static void startForeground(Service service, int i2, Notification notification, int i8) {
            if (i8 == 0 || i8 == -1) {
                service.startForeground(i2, notification, i8);
            } else {
                service.startForeground(i2, notification, i8 & ServiceCompat.FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface StopForegroundFlags {
    }

    private ServiceCompat() {
    }

    public static void startForeground(@NonNull Service service, int i2, @NonNull Notification notification, int i8) {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 34) {
            Api34Impl.startForeground(service, i2, notification, i8);
        } else if (i9 >= 29) {
            Api29Impl.startForeground(service, i2, notification, i8);
        } else {
            service.startForeground(i2, notification);
        }
    }

    public static void stopForeground(@NonNull Service service, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.stopForeground(service, i2);
        } else {
            service.stopForeground((i2 & 1) != 0);
        }
    }
}
