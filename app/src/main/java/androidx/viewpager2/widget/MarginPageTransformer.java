package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {
    private final int mMarginPx;

    public MarginPageTransformer(@Px int i2) {
        Preconditions.checkArgumentNonnegative(i2, "Margin must be non-negative");
        this.mMarginPx = i2;
    }

    private ViewPager2 requireViewPager(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f4) {
        ViewPager2 viewPager2RequireViewPager = requireViewPager(view);
        float f8 = this.mMarginPx * f4;
        if (viewPager2RequireViewPager.getOrientation() != 0) {
            view.setTranslationY(f8);
            return;
        }
        if (viewPager2RequireViewPager.isRtl()) {
            f8 = -f8;
        }
        view.setTranslationX(f8);
    }
}
