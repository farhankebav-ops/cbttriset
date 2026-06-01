package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cbt.exam.browser.R;
import w1.n;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f5508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w1.k f5510c;

    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.android.material.timepicker.g] */
    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        w1.k kVar = new w1.k();
        this.f5510c = kVar;
        w1.l lVar = new w1.l(0.5f);
        n nVarF = kVar.f17716b.f17705a.f();
        nVarF.e = lVar;
        nVarF.f17737f = lVar;
        nVarF.g = lVar;
        nVarF.h = lVar;
        kVar.setShapeAppearanceModel(nVarF.a());
        this.f5510c.p(ColorStateList.valueOf(-1));
        setBackground(this.f5510c);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b1.a.A, R.attr.materialClockStyle, 0);
        this.f5509b = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f5508a = new Runnable() { // from class: com.google.android.material.timepicker.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f5507a.a();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }

    public abstract void a();

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            g gVar = this.f5508a;
            handler.removeCallbacks(gVar);
            handler.post(gVar);
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            g gVar = this.f5508a;
            handler.removeCallbacks(gVar);
            handler.post(gVar);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i2) {
        this.f5510c.p(ColorStateList.valueOf(i2));
    }
}
