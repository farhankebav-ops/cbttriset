package androidx.camera.core.impl.utils;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ContextUtil {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static Context createAttributionContext(Context context, String str) {
            return context.createAttributionContext(str);
        }

        public static String getAttributionTag(Context context) {
            return context.getAttributionTag();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        public static Context createDeviceContext(Context context, int i2) {
            return context.createDeviceContext(i2);
        }

        public static int getDeviceId(Context context) {
            return context.getDeviceId();
        }
    }

    private ContextUtil() {
    }

    public static Context getApplicationContext(Context context) {
        int deviceId;
        Context applicationContext = context.getApplicationContext();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34 && (deviceId = Api34Impl.getDeviceId(context)) != Api34Impl.getDeviceId(applicationContext)) {
            applicationContext = Api34Impl.createDeviceContext(applicationContext, deviceId);
        }
        if (i2 >= 30) {
            String attributionTag = Api30Impl.getAttributionTag(context);
            if (!Objects.equals(attributionTag, Api30Impl.getAttributionTag(applicationContext))) {
                return Api30Impl.createAttributionContext(applicationContext, attributionTag);
            }
        }
        return applicationContext;
    }

    public static Application getApplicationFromContext(Context context) {
        for (Context applicationContext = getApplicationContext(context); applicationContext instanceof ContextWrapper; applicationContext = ((ContextWrapper) applicationContext).getBaseContext()) {
            if (applicationContext instanceof Application) {
                return (Application) applicationContext;
            }
        }
        return null;
    }
}
