package com.bytedance.sdk.openadsdk.core.Cc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.oeT;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends TextView {
    public lEW(Context context) {
        super(context);
        IlO();
    }

    private void IlO() {
        setTextDirection(5);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i8) {
        try {
            super.onMeasure(i2, i8);
        } catch (Throwable th) {
            oeT.EO("PAGTextView", th.toString());
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i8, int i9, int i10) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i8, i9, i10);
    }

    @Override // android.widget.TextView
    public void setGravity(int i2) {
        super.setGravity(DmF.IlO(i2));
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(DmF.IlO(this, layoutParams));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i8, int i9, int i10) {
        super.setPaddingRelative(i2, i8, i9, i10);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public lEW(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        IlO();
    }
}
