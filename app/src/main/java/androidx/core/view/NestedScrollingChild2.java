package androidx.core.view;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i2, int i8, @Nullable int[] iArr, @Nullable int[] iArr2, int i9);

    boolean dispatchNestedScroll(int i2, int i8, int i9, int i10, @Nullable int[] iArr, int i11);

    boolean hasNestedScrollingParent(int i2);

    boolean startNestedScroll(int i2, int i8);

    void stopNestedScroll(int i2);
}
