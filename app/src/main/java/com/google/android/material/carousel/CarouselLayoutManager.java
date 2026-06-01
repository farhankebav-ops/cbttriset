package com.google.android.material.carousel;

import a1.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.cbt.exam.browser.R;
import j1.b;
import j1.c;
import j1.d;
import j1.e;
import j1.f;
import j1.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f5317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f5318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View.OnLayoutChangeListener f5319c;

    public CarouselLayoutManager() {
        i iVar = new i();
        new c();
        this.f5319c = new View.OnLayoutChangeListener() { // from class: j1.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
                if (i9 - i2 == i13 - i11 && i10 - i8 == i14 - i12) {
                    return;
                }
                view.post(new com.vungle.ads.internal.omsdk.a(this.f12053a, 4));
            }
        };
        this.f5317a = iVar;
        requestLayout();
        setOrientation(0);
    }

    public final float a(float f4, float f8) {
        return c() ? f4 - f8 : f4 + f8;
    }

    public final boolean b() {
        return this.f5318b.f12058a == 0;
    }

    public final boolean c() {
        return b() && getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        return !b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollExtent(RecyclerView.State state) {
        getChildCount();
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollOffset(RecyclerView.State state) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollRange(RecyclerView.State state) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public final PointF computeScrollVectorForPosition(int i2) {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollExtent(RecyclerView.State state) {
        getChildCount();
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollOffset(RecyclerView.State state) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollRange(RecyclerView.State state) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        rect.centerY();
        if (b()) {
            rect.centerX();
        }
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void measureChildWithMargins(View view, int i2, int i8) {
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        Context context = recyclerView.getContext();
        i iVar = this.f5317a;
        float dimension = iVar.f12059a;
        if (dimension <= 0.0f) {
            dimension = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
        }
        iVar.f12059a = dimension;
        float dimension2 = iVar.f12060b;
        if (dimension2 <= 0.0f) {
            dimension2 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
        }
        iVar.f12060b = dimension2;
        requestLayout();
        recyclerView.addOnLayoutChangeListener(this.f5319c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        recyclerView.removeOnLayoutChangeListener(this.f5319c);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View onFocusSearchFailed(android.view.View r4, int r5, androidx.recyclerview.widget.RecyclerView.Recycler r6, androidx.recyclerview.widget.RecyclerView.State r7) {
        /*
            r3 = this;
            int r6 = r3.getChildCount()
            if (r6 != 0) goto L8
            goto L96
        L8:
            j1.f r6 = r3.f5318b
            int r6 = r6.f12058a
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = -1
            r1 = 1
            if (r5 == r1) goto L46
            r2 = 2
            if (r5 == r2) goto L3c
            r2 = 17
            if (r5 == r2) goto L4b
            r2 = 33
            if (r5 == r2) goto L48
            r2 = 66
            if (r5 == r2) goto L3e
            r2 = 130(0x82, float:1.82E-43)
            if (r5 == r2) goto L3a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown focus request:"
            r6.<init>(r2)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "CarouselLayoutManager"
            android.util.Log.d(r6, r5)
        L38:
            r5 = r7
            goto L54
        L3a:
            if (r6 != r1) goto L38
        L3c:
            r5 = r1
            goto L54
        L3e:
            if (r6 != 0) goto L38
            boolean r5 = r3.c()
            if (r5 == 0) goto L3c
        L46:
            r5 = r0
            goto L54
        L48:
            if (r6 != r1) goto L38
            goto L46
        L4b:
            if (r6 != 0) goto L38
            boolean r5 = r3.c()
            if (r5 == 0) goto L46
            goto L3c
        L54:
            if (r5 != r7) goto L57
            goto L96
        L57:
            r6 = 0
            if (r5 != r0) goto L8b
            int r4 = r3.getPosition(r4)
            if (r4 != 0) goto L61
            goto L96
        L61:
            android.view.View r4 = r3.getChildAt(r6)
            int r4 = r3.getPosition(r4)
            int r4 = r4 - r1
            if (r4 < 0) goto L7a
            int r5 = r3.getItemCount()
            if (r4 < r5) goto L73
            goto L7a
        L73:
            j1.f r4 = r3.f5318b
            r4.d()
            r4 = 0
            throw r4
        L7a:
            boolean r4 = r3.c()
            if (r4 == 0) goto L86
            int r4 = r3.getChildCount()
            int r6 = r4 + (-1)
        L86:
            android.view.View r4 = r3.getChildAt(r6)
            return r4
        L8b:
            int r4 = r3.getPosition(r4)
            int r5 = r3.getItemCount()
            int r5 = r5 - r1
            if (r4 != r5) goto L98
        L96:
            r4 = 0
            return r4
        L98:
            int r4 = r3.getChildCount()
            int r4 = r4 - r1
            android.view.View r4 = r3.getChildAt(r4)
            int r4 = r3.getPosition(r4)
            int r4 = r4 + r1
            if (r4 < 0) goto Lb6
            int r5 = r3.getItemCount()
            if (r4 < r5) goto Laf
            goto Lb6
        Laf:
            j1.f r4 = r3.f5318b
            r4.d()
            r4 = 0
            throw r4
        Lb6:
            boolean r4 = r3.c()
            if (r4 == 0) goto Lbd
            goto Lc3
        Lbd:
            int r4 = r3.getChildCount()
            int r6 = r4 + (-1)
        Lc3:
            android.view.View r4 = r3.getChildAt(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsAdded(RecyclerView recyclerView, int i2, int i8) {
        super.onItemsAdded(recyclerView, i2, i8);
        getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsChanged(RecyclerView recyclerView) {
        super.onItemsChanged(recyclerView);
        getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(RecyclerView recyclerView, int i2, int i8) {
        super.onItemsRemoved(recyclerView, i2, i8);
        getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() > 0) {
            if ((b() ? getWidth() : getHeight()) > 0.0f) {
                c();
                measureChildWithMargins(recycler.getViewForPosition(0), 0, 0);
                throw null;
            }
        }
        removeAndRecycleAllViews(recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (getChildCount() == 0) {
            return;
        }
        getPosition(getChildAt(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z2, boolean z7) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!b() || getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        measureChildWithMargins(recycler.getViewForPosition(0), 0, 0);
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!canScrollVertically() || getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        measureChildWithMargins(recycler.getViewForPosition(0), 0, 0);
        throw null;
    }

    public final void setOrientation(int i2) {
        f eVar;
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException(a.g(i2, "invalid orientation:"));
        }
        assertNotInLayoutOrScroll(null);
        f fVar = this.f5318b;
        if (fVar == null || i2 != fVar.f12058a) {
            if (i2 == 0) {
                eVar = new e(this);
            } else {
                if (i2 != 1) {
                    throw new IllegalArgumentException("invalid orientation");
                }
                eVar = new d(this);
            }
            this.f5318b = eVar;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        b bVar = new b(recyclerView.getContext());
        bVar.setTargetPosition(i2);
        startSmoothScroll(bVar);
    }

    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i2, int i8) {
        new c();
        this.f5319c = new View.OnLayoutChangeListener() { // from class: j1.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i22, int i82, int i9, int i10, int i11, int i12, int i13, int i14) {
                if (i9 - i22 == i13 - i11 && i10 - i82 == i14 - i12) {
                    return;
                }
                view.post(new com.vungle.ads.internal.omsdk.a(this.f12053a, 4));
            }
        };
        this.f5317a = new i();
        requestLayout();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b1.a.f4129d);
            typedArrayObtainStyledAttributes.getInt(0, 0);
            requestLayout();
            setOrientation(typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int i2) {
    }
}
