package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(@NonNull View view, float f4, float f8, boolean z2);

    boolean onNestedPreFling(@NonNull View view, float f4, float f8);

    void onNestedPreScroll(@NonNull View view, int i2, int i8, @NonNull int[] iArr);

    void onNestedScroll(@NonNull View view, int i2, int i8, int i9, int i10);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2);

    void onStopNestedScroll(@NonNull View view);
}
