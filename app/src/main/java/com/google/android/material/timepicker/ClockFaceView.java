package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.cbt.exam.browser.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class ClockFaceView extends h implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ClockHandView f5487d;
    public final Rect e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f5488f;
    public final Rect g;
    public final SparseArray h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f5489i;
    public final int[] j;
    public final float[] k;
    public final int l;
    public final int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f5490n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f5491o;
    public final String[] p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f5492q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ColorStateList f5493r;

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new Rect();
        this.f5488f = new RectF();
        this.g = new Rect();
        SparseArray sparseArray = new SparseArray();
        this.h = sparseArray;
        this.k = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b1.a.f4130f, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListA = t1.c.a(context, typedArrayObtainStyledAttributes, 1);
        this.f5493r = colorStateListA;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.f5487d = clockHandView;
        this.l = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateListA.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListA.getDefaultColor());
        this.j = new int[]{colorForState, colorForState, colorStateListA.getDefaultColor()};
        clockHandView.f5497c.add(this);
        int defaultColor = AppCompatResources.getColorStateList(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListA2 = t1.c.a(context, typedArrayObtainStyledAttributes, 0);
        setBackgroundColor(colorStateListA2 != null ? colorStateListA2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(false);
        typedArrayObtainStyledAttributes.recycle();
        this.f5489i = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.p = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < Math.max(this.p.length, size); i2++) {
            TextView textView = (TextView) sparseArray.get(i2);
            if (i2 >= this.p.length) {
                removeView(textView);
                sparseArray.remove(i2);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i2, textView);
                    addView(textView);
                }
                textView.setText(this.p[i2]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i2));
                int i8 = (i2 / 12) + 1;
                textView.setTag(R.id.material_clock_level, Integer.valueOf(i8));
                z2 = i8 > 1 ? true : z2;
                ViewCompat.setAccessibilityDelegate(textView, this.f5489i);
                textView.setTextColor(this.f5493r);
            }
        }
        ClockHandView clockHandView2 = this.f5487d;
        if (clockHandView2.f5496b && !z2) {
            clockHandView2.m = 1;
        }
        clockHandView2.f5496b = z2;
        clockHandView2.invalidate();
        this.m = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.f5490n = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.f5491o = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    @Override // com.google.android.material.timepicker.h
    public final void a() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int i8 = (Integer) childAt.getTag(R.id.material_clock_level);
                if (i8 == null) {
                    i8 = 1;
                }
                if (!map.containsKey(i8)) {
                    map.put(i8, new ArrayList());
                }
                ((List) map.get(i8)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            int iRound = ((Integer) entry.getKey()).intValue() == 2 ? Math.round(this.f5509b * 0.66f) : this.f5509b;
            Iterator it = list.iterator();
            float size = 0.0f;
            while (it.hasNext()) {
                constraintSet.constrainCircle(((View) it.next()).getId(), R.id.circle_center, iRound, size);
                size += 360.0f / list.size();
            }
        }
        constraintSet.applyTo(this);
        int i9 = 0;
        while (true) {
            SparseArray sparseArray = this.h;
            if (i9 >= sparseArray.size()) {
                return;
            }
            ((TextView) sparseArray.get(i9)).setVisibility(0);
            i9++;
        }
    }

    public final void b() {
        SparseArray sparseArray;
        Rect rect;
        RectF rectF;
        RectF rectF2 = this.f5487d.g;
        float f4 = Float.MAX_VALUE;
        TextView textView = null;
        int i2 = 0;
        while (true) {
            sparseArray = this.h;
            int size = sparseArray.size();
            rect = this.e;
            rectF = this.f5488f;
            if (i2 >= size) {
                break;
            }
            TextView textView2 = (TextView) sparseArray.get(i2);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float fHeight = rectF.height() * rectF.width();
                if (fHeight < f4) {
                    textView = textView2;
                    f4 = fHeight;
                }
            }
            i2++;
        }
        for (int i8 = 0; i8 < sparseArray.size(); i8++) {
            TextView textView3 = (TextView) sparseArray.get(i8);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.g);
                rectF.inset(r8.left, r8.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF2, rectF) ? null : new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.j, this.k, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.p.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        super.onLayout(z2, i2, i8, i9, i10);
        b();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i2, int i8) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = (int) (this.f5491o / Math.max(Math.max(this.m / displayMetrics.heightPixels, this.f5490n / displayMetrics.widthPixels), 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, BasicMeasure.EXACTLY);
        setMeasuredDimension(iMax, iMax);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }
}
