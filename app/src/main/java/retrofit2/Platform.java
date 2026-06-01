package retrofit2;

import android.os.Build;
import java.util.concurrent.Executor;
import retrofit2.BuiltInFactories;
import retrofit2.Reflection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class Platform {
    static final BuiltInFactories builtInFactories;
    static final Executor callbackExecutor;
    static final Reflection reflection;

    static {
        String property = System.getProperty("java.vm.name");
        property.getClass();
        if (property.equals("RoboVM")) {
            callbackExecutor = null;
            reflection = new Reflection();
            builtInFactories = new BuiltInFactories();
        } else {
            if (!property.equals("Dalvik")) {
                callbackExecutor = null;
                reflection = new Reflection.Java8();
                builtInFactories = new BuiltInFactories.Java8();
                return;
            }
            callbackExecutor = new AndroidMainExecutor();
            if (Build.VERSION.SDK_INT >= 24) {
                reflection = new Reflection.Android24();
                builtInFactories = new BuiltInFactories.Java8();
            } else {
                reflection = new Reflection();
                builtInFactories = new BuiltInFactories();
            }
        }
    }

    private Platform() {
    }
}
