package androidx.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.activity.SystemBarStyle;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class EdgeToEdge {
    private static EdgeToEdgeImpl Impl;
    private static final int DefaultLightScrim = Color.argb(230, 255, 255, 255);
    private static final int DefaultDarkScrim = Color.argb(128, 27, 27, 27);

    public static final void enable(ComponentActivity componentActivity) {
        kotlin.jvm.internal.k.e(componentActivity, "<this>");
        enable$default(componentActivity, null, null, 3, null);
    }

    public static /* synthetic */ void enable$default(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            systemBarStyle = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, 0, 0, null, 4, null);
        }
        if ((i2 & 2) != 0) {
            systemBarStyle2 = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, DefaultLightScrim, DefaultDarkScrim, null, 4, null);
        }
        enable(componentActivity, systemBarStyle, systemBarStyle2);
    }

    public static final int getDefaultDarkScrim() {
        return DefaultDarkScrim;
    }

    public static final int getDefaultLightScrim() {
        return DefaultLightScrim;
    }

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle statusBarStyle) {
        kotlin.jvm.internal.k.e(componentActivity, "<this>");
        kotlin.jvm.internal.k.e(statusBarStyle, "statusBarStyle");
        enable$default(componentActivity, statusBarStyle, null, 2, null);
    }

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle statusBarStyle, SystemBarStyle navigationBarStyle) {
        kotlin.jvm.internal.k.e(componentActivity, "<this>");
        kotlin.jvm.internal.k.e(statusBarStyle, "statusBarStyle");
        kotlin.jvm.internal.k.e(navigationBarStyle, "navigationBarStyle");
        View decorView = componentActivity.getWindow().getDecorView();
        kotlin.jvm.internal.k.d(decorView, "getDecorView(...)");
        e6.l detectDarkMode$activity_release = statusBarStyle.getDetectDarkMode$activity_release();
        Resources resources = decorView.getResources();
        kotlin.jvm.internal.k.d(resources, "getResources(...)");
        boolean zBooleanValue = ((Boolean) detectDarkMode$activity_release.invoke(resources)).booleanValue();
        e6.l detectDarkMode$activity_release2 = navigationBarStyle.getDetectDarkMode$activity_release();
        Resources resources2 = decorView.getResources();
        kotlin.jvm.internal.k.d(resources2, "getResources(...)");
        boolean zBooleanValue2 = ((Boolean) detectDarkMode$activity_release2.invoke(resources2)).booleanValue();
        EdgeToEdgeImpl edgeToEdgeApi23 = Impl;
        if (edgeToEdgeApi23 == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                edgeToEdgeApi23 = new EdgeToEdgeApi30();
            } else if (i2 >= 29) {
                edgeToEdgeApi23 = new EdgeToEdgeApi29();
            } else if (i2 >= 28) {
                edgeToEdgeApi23 = new EdgeToEdgeApi28();
            } else if (i2 >= 26) {
                edgeToEdgeApi23 = new EdgeToEdgeApi26();
            } else {
                edgeToEdgeApi23 = new EdgeToEdgeApi23();
            }
        }
        EdgeToEdgeImpl edgeToEdgeImpl = edgeToEdgeApi23;
        Window window = componentActivity.getWindow();
        kotlin.jvm.internal.k.d(window, "getWindow(...)");
        edgeToEdgeImpl.setUp(statusBarStyle, navigationBarStyle, window, decorView, zBooleanValue, zBooleanValue2);
        Window window2 = componentActivity.getWindow();
        kotlin.jvm.internal.k.d(window2, "getWindow(...)");
        edgeToEdgeImpl.adjustLayoutInDisplayCutoutMode(window2);
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultDarkScrim$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultLightScrim$annotations() {
    }
}
