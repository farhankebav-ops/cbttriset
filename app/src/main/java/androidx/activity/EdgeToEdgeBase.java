package androidx.activity;

import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class EdgeToEdgeBase implements EdgeToEdgeImpl {
    @Override // androidx.activity.EdgeToEdgeImpl
    public void adjustLayoutInDisplayCutoutMode(Window window) {
        kotlin.jvm.internal.k.e(window, "window");
    }

    @Override // androidx.activity.EdgeToEdgeImpl
    public void setUp(SystemBarStyle statusBarStyle, SystemBarStyle navigationBarStyle, Window window, View view, boolean z2, boolean z7) {
        kotlin.jvm.internal.k.e(statusBarStyle, "statusBarStyle");
        kotlin.jvm.internal.k.e(navigationBarStyle, "navigationBarStyle");
        kotlin.jvm.internal.k.e(window, "window");
        kotlin.jvm.internal.k.e(view, "view");
    }
}
