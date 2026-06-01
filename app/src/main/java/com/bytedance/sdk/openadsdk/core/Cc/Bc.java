package com.bytedance.sdk.openadsdk.core.Cc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends RelativeLayout {
    public Bc(@NonNull Context context) {
        super(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
    }

    @Override // android.widget.RelativeLayout
    public void setGravity(int i2) {
        super.setGravity(DmF.IlO(i2));
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(DmF.IlO(this, layoutParams));
    }

    @Override // android.view.View
    public void setPadding(int i2, int i8, int i9, int i10) {
        super.setPaddingRelative(i2, i8, i9, i10);
    }

    public Bc(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
