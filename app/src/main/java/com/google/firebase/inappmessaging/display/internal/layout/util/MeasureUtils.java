package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.firebase.inappmessaging.display.internal.Logging;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class MeasureUtils {
    private static void measure(View view, int i2, int i8, int i9, int i10) {
        Logging.logdPair("\tdesired (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
        if (view.getVisibility() == 8) {
            i2 = 0;
            i8 = 0;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, i9), View.MeasureSpec.makeMeasureSpec(i8, i10));
        Logging.logdPair("\tactual (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public static void measureAtMost(View view, int i2, int i8) {
        measure(view, i2, i8, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public static void measureExactly(View view, int i2, int i8) {
        measure(view, i2, i8, BasicMeasure.EXACTLY, BasicMeasure.EXACTLY);
    }

    public static void measureFullHeight(View view, int i2, int i8) {
        measure(view, i2, i8, Integer.MIN_VALUE, BasicMeasure.EXACTLY);
    }

    public static void measureFullWidth(View view, int i2, int i8) {
        measure(view, i2, i8, BasicMeasure.EXACTLY, Integer.MIN_VALUE);
    }
}
