package com.bytedance.sdk.openadsdk.core;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class dY {
    private static int EO(View view, int i2) {
        if (i2 == 3) {
            return BS.Cc(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    private static boolean IlO(View view, int i2) {
        float fIlO = IlO(view);
        return fIlO > 0.0f && fIlO >= ((float) i2) / 100.0f;
    }

    private static boolean MY(View view) {
        return view != null && view.isShown();
    }

    public static float IlO(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null) {
                    Rect rect = new Rect();
                    if (!view.getGlobalVisibleRect(rect)) {
                        return -1.0f;
                    }
                    long jHeight = ((long) rect.height()) * ((long) rect.width());
                    long height = ((long) view.getHeight()) * ((long) view.getWidth());
                    if (height <= 0) {
                        return -1.0f;
                    }
                    return jHeight / height;
                }
            } catch (Throwable unused) {
            }
        }
        return -1.0f;
    }

    private static int MY(View view, int i2) {
        if (i2 == 3) {
            return (int) (((double) BS.EO(view.getContext().getApplicationContext())) * 0.7d);
        }
        return 20;
    }

    private static int MY(View view, int i2, int i8, boolean z2) throws Throwable {
        if (view.getWindowVisibility() != 0) {
            return 4;
        }
        if (!MY(view)) {
            return 1;
        }
        if (IlO(view, i8, z2)) {
            return !IlO(view, i2) ? 3 : 0;
        }
        return 6;
    }

    private static boolean IlO(View view, int i2, boolean z2) {
        return (i2 == 1 && z2) ? view.getWidth() > 0 && view.getHeight() > 0 : view.getWidth() >= MY(view, i2) && view.getHeight() >= EO(view, i2);
    }

    public static boolean IlO(View view, int i2, int i8, boolean z2) {
        if (i8 == 1) {
            while (view != null) {
                try {
                    if (view.getVisibility() != 0) {
                        return false;
                    }
                    if ((view instanceof com.bytedance.sdk.openadsdk.core.lEW.xF) || (view instanceof com.bytedance.sdk.openadsdk.core.EO.tV)) {
                        break;
                    }
                    view = (View) view.getParent();
                } catch (Throwable unused) {
                }
            }
            if (z2) {
                i2 = 0;
            }
        }
        return MY(view, i2, i8, z2) == 0;
    }
}
