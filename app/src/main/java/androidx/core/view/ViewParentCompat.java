package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static boolean onNestedFling(ViewParent viewParent, View view, float f4, float f8, boolean z2) {
            return viewParent.onNestedFling(view, f4, f8, z2);
        }

        @DoNotInline
        public static boolean onNestedPreFling(ViewParent viewParent, View view, float f4, float f8) {
            return viewParent.onNestedPreFling(view, f4, f8);
        }

        @DoNotInline
        public static void onNestedPreScroll(ViewParent viewParent, View view, int i2, int i8, int[] iArr) {
            viewParent.onNestedPreScroll(view, i2, i8, iArr);
        }

        @DoNotInline
        public static void onNestedScroll(ViewParent viewParent, View view, int i2, int i8, int i9, int i10) {
            viewParent.onNestedScroll(view, i2, i8, i9, i10);
        }

        @DoNotInline
        public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i2) {
            viewParent.onNestedScrollAccepted(view, view2, i2);
        }

        @DoNotInline
        public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i2) {
            return viewParent.onStartNestedScroll(view, view2, i2);
        }

        @DoNotInline
        public static void onStopNestedScroll(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    private ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] iArr = sTempNestedScrollConsumed;
        if (iArr == null) {
            sTempNestedScrollConsumed = new int[2];
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return sTempNestedScrollConsumed;
    }

    public static void notifySubtreeAccessibilityStateChanged(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i2) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i2);
    }

    public static boolean onNestedFling(@NonNull ViewParent viewParent, @NonNull View view, float f4, float f8, boolean z2) {
        try {
            return Api21Impl.onNestedFling(viewParent, view, f4, f8, z2);
        } catch (AbstractMethodError e) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
            return false;
        }
    }

    public static boolean onNestedPreFling(@NonNull ViewParent viewParent, @NonNull View view, float f4, float f8) {
        try {
            return Api21Impl.onNestedPreFling(viewParent, view, f4, f8);
        } catch (AbstractMethodError e) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
            return false;
        }
    }

    public static void onNestedPreScroll(@NonNull ViewParent viewParent, @NonNull View view, int i2, int i8, @NonNull int[] iArr) {
        onNestedPreScroll(viewParent, view, i2, i8, iArr, 0);
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i2, int i8, int i9, int i10) {
        onNestedScroll(viewParent, view, i2, i8, i9, i10, 0, getTempNestedScrollConsumed());
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i2) {
        onNestedScrollAccepted(viewParent, view, view2, i2, 0);
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i2) {
        return onStartNestedScroll(viewParent, view, view2, i2, 0);
    }

    public static void onStopNestedScroll(@NonNull ViewParent viewParent, @NonNull View view) {
        onStopNestedScroll(viewParent, view, 0);
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onNestedPreScroll(@NonNull ViewParent viewParent, @NonNull View view, int i2, int i8, @NonNull int[] iArr, int i9) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i2, i8, iArr, i9);
            return;
        }
        if (i9 == 0) {
            try {
                Api21Impl.onNestedPreScroll(viewParent, view, i2, i8, iArr);
            } catch (AbstractMethodError e) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
            }
        }
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i2, int i8) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i2, i8);
            return;
        }
        if (i8 == 0) {
            try {
                Api21Impl.onNestedScrollAccepted(viewParent, view, view2, i2);
            } catch (AbstractMethodError e) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e);
            }
        }
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i2, int i8) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i2, i8);
        }
        if (i8 != 0) {
            return false;
        }
        try {
            return Api21Impl.onStartNestedScroll(viewParent, view, view2, i2);
        } catch (AbstractMethodError e) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e);
            return false;
        }
    }

    public static void onStopNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i2) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onStopNestedScroll(view, i2);
            return;
        }
        if (i2 == 0) {
            try {
                Api21Impl.onStopNestedScroll(viewParent, view);
            } catch (AbstractMethodError e) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e);
            }
        }
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i2, int i8, int i9, int i10, int i11) {
        onNestedScroll(viewParent, view, i2, i8, i9, i10, i11, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i2, int i8, int i9, int i10, int i11, @NonNull int[] iArr) {
        if (viewParent instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent).onNestedScroll(view, i2, i8, i9, i10, i11, iArr);
            return;
        }
        iArr[0] = iArr[0] + i9;
        iArr[1] = iArr[1] + i10;
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScroll(view, i2, i8, i9, i10, i11);
            return;
        }
        if (i11 == 0) {
            try {
                Api21Impl.onNestedScroll(viewParent, view, i2, i8, i9, i10);
            } catch (AbstractMethodError e) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
            }
        }
    }
}
