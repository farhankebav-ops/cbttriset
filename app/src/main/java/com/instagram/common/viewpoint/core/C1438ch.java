package com.instagram.common.viewpoint.core;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ch, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1438ch {
    public final int[] A00(View view, int i2, int i8) {
        QP qp = (QP) view.getLayoutParams();
        int childHeightSpec = ViewGroup.getChildMeasureSpec(i2, view.getPaddingLeft() + view.getPaddingRight(), qp.width);
        int childWidthSpec = view.getPaddingTop();
        view.measure(childHeightSpec, ViewGroup.getChildMeasureSpec(i8, childWidthSpec + view.getPaddingBottom(), qp.height));
        int childWidthSpec2 = view.getMeasuredWidth();
        int childWidthSpec3 = view.getMeasuredHeight();
        return new int[]{childWidthSpec2 + qp.leftMargin + qp.rightMargin, childWidthSpec3 + qp.bottomMargin + qp.topMargin};
    }
}
