package com.google.firebase.inappmessaging.display.internal.layout;

import a1.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseModalLayout extends FrameLayout {
    private static final float DEFAULT_MAX_HEIGHT_PCT = -1.0f;
    private static final float DEFAULT_MAX_WIDTH_PCT = -1.0f;
    private DisplayMetrics mDisplay;
    private float mMaxHeightPct;
    private float mMaxWidthPct;
    private List<View> mVisibleChildren;

    public BaseModalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mVisibleChildren = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ModalLayout, 0, 0);
        try {
            this.mMaxWidthPct = typedArrayObtainStyledAttributes.getFloat(R.styleable.ModalLayout_maxWidthPct, -1.0f);
            this.mMaxHeightPct = typedArrayObtainStyledAttributes.getFloat(R.styleable.ModalLayout_maxHeightPct, -1.0f);
            typedArrayObtainStyledAttributes.recycle();
            this.mDisplay = context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public int calculateBaseHeight(int i2) {
        if (getMaxHeightPct() <= 0.0f) {
            Logging.logd("Height: restrict by spec");
            return View.MeasureSpec.getSize(i2);
        }
        Logging.logd("Height: restrict by pct");
        return roundToNearest((int) (getMaxHeightPct() * getDisplayMetrics().heightPixels), 4);
    }

    public int calculateBaseWidth(int i2) {
        if (getMaxWidthPct() <= 0.0f) {
            Logging.logd("Width: restrict by spec");
            return View.MeasureSpec.getSize(i2);
        }
        Logging.logd("Width: restrict by pct");
        return roundToNearest((int) (getMaxWidthPct() * getDisplayMetrics().widthPixels), 4);
    }

    public int dpToPixels(int i2) {
        return (int) Math.floor(TypedValue.applyDimension(1, i2, this.mDisplay));
    }

    @NonNull
    public View findChildById(@IdRes int i2) {
        View viewFindViewById = findViewById(i2);
        if (viewFindViewById != null) {
            return viewFindViewById;
        }
        throw new IllegalStateException(a.g(i2, "No such child: "));
    }

    public int getDesiredHeight(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return view.getMeasuredHeight();
    }

    public int getDesiredWidth(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return view.getMeasuredWidth();
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.mDisplay;
    }

    public int getHeightWithMargins(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        FrameLayout.LayoutParams layoutParams = getLayoutParams(view);
        return getDesiredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public FrameLayout.LayoutParams getLayoutParams(View view) {
        return (FrameLayout.LayoutParams) view.getLayoutParams();
    }

    public int getMarginBottom(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return getLayoutParams(view).bottomMargin;
    }

    public int getMarginTop(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return getLayoutParams(view).topMargin;
    }

    public float getMaxHeightPct() {
        return this.mMaxHeightPct;
    }

    public float getMaxWidthPct() {
        return this.mMaxWidthPct;
    }

    public List<View> getVisibleChildren() {
        return this.mVisibleChildren;
    }

    public int getWidthWithMargins(View view) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        FrameLayout.LayoutParams layoutParams = getLayoutParams(view);
        return getDesiredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
    }

    public void layoutChild(View view, int i2, int i8) {
        layoutChild(view, i2, i8, getDesiredWidth(view) + i2, getDesiredHeight(view) + i8);
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i2, int i8, int i9, int i10) {
        Logging.logdPair("\tdesired (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
        super.measureChildWithMargins(view, i2, i8, i9, i10);
        Logging.logdPair("\tactual  (w,h)", view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        Logging.logdHeader("BEGIN LAYOUT");
        Logging.logd("onLayout: l: " + i2 + ", t: " + i8 + ", r: " + i9 + ", b: " + i10);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        Logging.logdHeader("BEGIN MEASURE");
        Logging.logdPair("Display", getDisplayMetrics().widthPixels, getDisplayMetrics().heightPixels);
        this.mVisibleChildren.clear();
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                this.mVisibleChildren.add(childAt);
            } else {
                Logging.logdNumber("Skipping GONE child", i9);
            }
        }
    }

    public int roundToNearest(int i2, int i8) {
        return Math.round(i2 / i8) * i8;
    }

    public void layoutChild(View view, int i2, int i8, int i9, int i10) {
        Logging.logdPair("\tleft, right", i2, i9);
        Logging.logdPair("\ttop, bottom", i8, i10);
        view.layout(i2, i8, i9, i10);
    }
}
