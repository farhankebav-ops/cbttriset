package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class cl {
    private static int EO = -1;
    private static volatile Context IlO;
    private static volatile xF<com.bytedance.sdk.openadsdk.tV.IlO> MY;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private static volatile Application IlO;

        static {
            try {
                Object objMY = MY();
                IlO = (Application) objMY.getClass().getMethod("getApplication", null).invoke(objMY, null);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.IlO("MyApplication", "application get failed", th);
            }
        }

        @Nullable
        public static Application IlO() {
            return IlO;
        }

        private static Object MY() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null);
                method.setAccessible(true);
                return method.invoke(null, null);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.IlO("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static com.bytedance.sdk.openadsdk.ea.EO.MY Cc() {
        return !com.bytedance.sdk.openadsdk.core.settings.DmF.IlO() ? com.bytedance.sdk.openadsdk.ea.EO.EO.IlO() : com.bytedance.sdk.openadsdk.tV.IlO.tV.IlO();
    }

    public static xF<com.bytedance.sdk.openadsdk.tV.IlO> EO() {
        if (MY == null) {
            synchronized (cl.class) {
                try {
                    if (MY == null) {
                        MY = new AXM(IlO);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return MY;
    }

    public static Context IlO() {
        if (IlO == null) {
            MY(null);
        }
        return IlO;
    }

    public static void MY(Context context) {
        if (IlO == null) {
            synchronized (cl.class) {
                try {
                    if (IlO == null) {
                        if (context != null) {
                            IlO = context;
                            Context applicationContext = context.getApplicationContext();
                            if (applicationContext != null) {
                                IlO = applicationContext;
                            }
                            return;
                        }
                        try {
                            Application applicationIlO = IlO.IlO();
                            if (applicationIlO != null) {
                                IlO = applicationIlO;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static com.bytedance.sdk.openadsdk.core.settings.vCE tV() {
        return com.bytedance.sdk.openadsdk.core.settings.hp.aP();
    }

    public static Context IlO(Context context) {
        if (context == null) {
            context = IlO();
        }
        if (context instanceof Application) {
            return context;
        }
        if (context != null) {
            return context.getApplicationContext();
        }
        return null;
    }

    public static int MY() {
        Context contextIlO;
        if (EO < 0 && (contextIlO = IlO()) != null) {
            EO = ViewConfiguration.get(contextIlO).getScaledTouchSlop();
        }
        return EO;
    }
}
