package androidx.customview.widget;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class FocusStrategy {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface BoundsAdapter<T> {
        void obtainBounds(T t3, Rect rect);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface CollectionAdapter<T, V> {
        V get(T t3, int i2);

        int size(T t3);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class SequentialComparator<T> implements Comparator<T> {
        private final BoundsAdapter<T> mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1 = new Rect();
        private final Rect mTemp2 = new Rect();

        public SequentialComparator(boolean z2, BoundsAdapter<T> boundsAdapter) {
            this.mIsLayoutRtl = z2;
            this.mAdapter = boundsAdapter;
        }

        @Override // java.util.Comparator
        public int compare(T t3, T t7) {
            Rect rect = this.mTemp1;
            Rect rect2 = this.mTemp2;
            this.mAdapter.obtainBounds(t3, rect);
            this.mAdapter.obtainBounds(t7, rect2);
            int i2 = rect.top;
            int i8 = rect2.top;
            if (i2 < i8) {
                return -1;
            }
            if (i2 > i8) {
                return 1;
            }
            int i9 = rect.left;
            int i10 = rect2.left;
            if (i9 < i10) {
                return this.mIsLayoutRtl ? 1 : -1;
            }
            if (i9 > i10) {
                return this.mIsLayoutRtl ? -1 : 1;
            }
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            if (i11 < i12) {
                return -1;
            }
            if (i11 > i12) {
                return 1;
            }
            int i13 = rect.right;
            int i14 = rect2.right;
            if (i13 < i14) {
                return this.mIsLayoutRtl ? 1 : -1;
            }
            if (i13 > i14) {
                return this.mIsLayoutRtl ? -1 : 1;
            }
            return 0;
        }
    }

    private FocusStrategy() {
    }

    private static boolean beamBeats(int i2, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        boolean zBeamsOverlap = beamsOverlap(i2, rect, rect2);
        if (beamsOverlap(i2, rect, rect3) || !zBeamsOverlap) {
            return false;
        }
        return !isToDirectionOf(i2, rect, rect3) || i2 == 17 || i2 == 66 || majorAxisDistance(i2, rect, rect2) < majorAxisDistanceToFarEdge(i2, rect, rect3);
    }

    private static boolean beamsOverlap(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L l, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t3, @NonNull Rect rect, int i2) {
        Rect rect2 = new Rect(rect);
        if (i2 == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i2 == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i2 == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else {
            if (i2 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect2.offset(0, -(rect.height() + 1));
        }
        int size = collectionAdapter.size(l);
        Rect rect3 = new Rect();
        T t7 = null;
        for (int i8 = 0; i8 < size; i8++) {
            T t8 = collectionAdapter.get(l, i8);
            if (t8 != t3) {
                boundsAdapter.obtainBounds(t8, rect3);
                if (isBetterCandidate(i2, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t7 = t8;
                }
            }
        }
        return t7;
    }

    public static <L, T> T findNextFocusInRelativeDirection(@NonNull L l, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t3, int i2, boolean z2, boolean z7) {
        int size = collectionAdapter.size(l);
        ArrayList arrayList = new ArrayList(size);
        for (int i8 = 0; i8 < size; i8++) {
            arrayList.add(collectionAdapter.get(l, i8));
        }
        Collections.sort(arrayList, new SequentialComparator(z2, boundsAdapter));
        if (i2 == 1) {
            return (T) getPreviousFocusable(t3, arrayList, z7);
        }
        if (i2 == 2) {
            return (T) getNextFocusable(t3, arrayList, z7);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    private static <T> T getNextFocusable(T t3, ArrayList<T> arrayList, boolean z2) {
        int size = arrayList.size();
        int iLastIndexOf = (t3 == null ? -1 : arrayList.lastIndexOf(t3)) + 1;
        if (iLastIndexOf < size) {
            return arrayList.get(iLastIndexOf);
        }
        if (!z2 || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    private static <T> T getPreviousFocusable(T t3, ArrayList<T> arrayList, boolean z2) {
        int size = arrayList.size();
        int iIndexOf = (t3 == null ? size : arrayList.indexOf(t3)) - 1;
        if (iIndexOf >= 0) {
            return arrayList.get(iIndexOf);
        }
        if (!z2 || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    private static int getWeightedDistanceFor(int i2, int i8) {
        return (i8 * i8) + (i2 * 13 * i2);
    }

    private static boolean isBetterCandidate(int i2, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        if (!isCandidate(rect, rect2, i2)) {
            return false;
        }
        if (isCandidate(rect, rect3, i2) && !beamBeats(i2, rect, rect2, rect3)) {
            return !beamBeats(i2, rect, rect3, rect2) && getWeightedDistanceFor(majorAxisDistance(i2, rect, rect2), minorAxisDistance(i2, rect, rect2)) < getWeightedDistanceFor(majorAxisDistance(i2, rect, rect3), minorAxisDistance(i2, rect, rect3));
        }
        return true;
    }

    private static boolean isCandidate(@NonNull Rect rect, @NonNull Rect rect2, int i2) {
        if (i2 == 17) {
            int i8 = rect.right;
            int i9 = rect2.right;
            return (i8 > i9 || rect.left >= i9) && rect.left > rect2.left;
        }
        if (i2 == 33) {
            int i10 = rect.bottom;
            int i11 = rect2.bottom;
            return (i10 > i11 || rect.top >= i11) && rect.top > rect2.top;
        }
        if (i2 == 66) {
            int i12 = rect.left;
            int i13 = rect2.left;
            return (i12 < i13 || rect.right <= i13) && rect.right < rect2.right;
        }
        if (i2 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i14 = rect.top;
        int i15 = rect2.top;
        return (i14 < i15 || rect.bottom <= i15) && rect.bottom < rect2.bottom;
    }

    private static boolean isToDirectionOf(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i2 == 17) {
            return rect.left >= rect2.right;
        }
        if (i2 == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i2 == 66) {
            return rect.right <= rect2.left;
        }
        if (i2 == 130) {
            return rect.bottom <= rect2.top;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int majorAxisDistance(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(0, majorAxisDistanceRaw(i2, rect, rect2));
    }

    private static int majorAxisDistanceRaw(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        int i8;
        int i9;
        if (i2 == 17) {
            i8 = rect.left;
            i9 = rect2.right;
        } else if (i2 == 33) {
            i8 = rect.top;
            i9 = rect2.bottom;
        } else if (i2 == 66) {
            i8 = rect2.left;
            i9 = rect.right;
        } else {
            if (i2 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i8 = rect2.top;
            i9 = rect.bottom;
        }
        return i8 - i9;
    }

    private static int majorAxisDistanceToFarEdge(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(i2, rect, rect2));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        int i8;
        int i9;
        if (i2 == 17) {
            i8 = rect.left;
            i9 = rect2.left;
        } else if (i2 == 33) {
            i8 = rect.top;
            i9 = rect2.top;
        } else if (i2 == 66) {
            i8 = rect2.right;
            i9 = rect.right;
        } else {
            if (i2 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i8 = rect2.bottom;
            i9 = rect.bottom;
        }
        return i8 - i9;
    }

    private static int minorAxisDistance(int i2, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }
}
