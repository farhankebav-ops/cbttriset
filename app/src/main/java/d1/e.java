package d1;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.search.SearchBar$ScrollingViewBehavior;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f11037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f11038d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11039f;

    public e() {
        this.f11037c = new Rect();
        this.f11038d = new Rect();
        this.e = 0;
    }

    @Override // d1.f
    public final void b(CoordinatorLayout coordinatorLayout, View view, int i2) {
        AppBarLayout appBarLayoutD = AppBarLayout.ScrollingViewBehavior.d(coordinatorLayout.getDependencies(view));
        if (appBarLayoutD == null) {
            coordinatorLayout.onLayoutChild(view, i2);
            this.e = 0;
            return;
        }
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        int paddingLeft = coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        int bottom = appBarLayoutD.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        int width = (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int bottom2 = ((appBarLayoutD.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        Rect rect = this.f11037c;
        rect.set(paddingLeft, bottom, width, bottom2);
        WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            rect.left = lastWindowInsets.getSystemWindowInsetLeft() + rect.left;
            rect.right -= lastWindowInsets.getSystemWindowInsetRight();
        }
        int i8 = layoutParams.gravity;
        if (i8 == 0) {
            i8 = 8388659;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Rect rect2 = this.f11038d;
        Gravity.apply(i8, measuredWidth, measuredHeight, rect, rect2, i2);
        int iC = c(appBarLayoutD);
        view.layout(rect2.left, rect2.top - iC, rect2.right, rect2.bottom - iC);
        this.e = rect2.top - appBarLayoutD.getBottom();
    }

    public final int c(View view) {
        int i2;
        if (this.f11039f == 0) {
            return 0;
        }
        float f4 = 0.0f;
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            int iC = behavior instanceof AppBarLayout.BaseBehavior ? ((AppBarLayout.BaseBehavior) behavior).c() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + iC > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                f4 = (iC / i2) + 1.0f;
            }
        }
        int i8 = this.f11039f;
        return MathUtils.clamp((int) (f4 * i8), 0, i8);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i2, int i8, int i9, int i10) {
        AppBarLayout appBarLayoutD;
        WindowInsetsCompat lastWindowInsets;
        int i11 = view.getLayoutParams().height;
        if ((i11 != -1 && i11 != -2) || (appBarLayoutD = AppBarLayout.ScrollingViewBehavior.d(coordinatorLayout.getDependencies(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i9);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (appBarLayoutD.getFitsSystemWindows() && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.getSystemWindowInsetBottom() + lastWindowInsets.getSystemWindowInsetTop();
        }
        int totalScrollRange = appBarLayoutD.getTotalScrollRange() + size;
        int measuredHeight = appBarLayoutD.getMeasuredHeight();
        if (this instanceof SearchBar$ScrollingViewBehavior) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            totalScrollRange -= measuredHeight;
        }
        coordinatorLayout.onMeasureChild(view, i2, i8, View.MeasureSpec.makeMeasureSpec(totalScrollRange, i11 == -1 ? BasicMeasure.EXACTLY : Integer.MIN_VALUE), i10);
        return true;
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11037c = new Rect();
        this.f11038d = new Rect();
        this.e = 0;
    }
}
