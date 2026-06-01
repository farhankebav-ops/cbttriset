package androidx.core.view;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingChild {
    boolean dispatchNestedFling(float f4, float f8, boolean z2);

    boolean dispatchNestedPreFling(float f4, float f8);

    boolean dispatchNestedPreScroll(int i2, int i8, @Nullable int[] iArr, @Nullable int[] iArr2);

    boolean dispatchNestedScroll(int i2, int i8, int i9, int i10, @Nullable int[] iArr);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean z2);

    boolean startNestedScroll(int i2);

    void stopNestedScroll();
}
