package com.ironsource;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class vg {
    public static final boolean a(View view, Rect rect) {
        kotlin.jvm.internal.k.e(view, "<this>");
        kotlin.jvm.internal.k.e(rect, "rect");
        return view.isShown() && view.hasWindowFocus() && view.getGlobalVisibleRect(rect);
    }
}
