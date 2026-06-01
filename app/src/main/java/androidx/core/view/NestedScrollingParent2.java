package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(@NonNull View view, int i2, int i8, @NonNull int[] iArr, int i9);

    void onNestedScroll(@NonNull View view, int i2, int i8, int i9, int i10, int i11);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2, int i8);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2, int i8);

    void onStopNestedScroll(@NonNull View view, int i2);
}
