package androidx.recyclerview.widget;

import a1.a;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new Comparator<Diagonal>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f4061x - diagonal2.f4061x;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i2, int i8);

        public abstract boolean areItemsTheSame(int i2, int i8);

        @Nullable
        public Object getChangePayload(int i2, int i8) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        public CenteredArray(int i2) {
            int[] iArr = new int[i2];
            this.mData = iArr;
            this.mMid = iArr.length / 2;
        }

        public int[] backingData() {
            return this.mData;
        }

        public void fill(int i2) {
            Arrays.fill(this.mData, i2);
        }

        public int get(int i2) {
            return this.mData[i2 + this.mMid];
        }

        public void set(int i2, int i8) {
            this.mData[i2 + this.mMid] = i8;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Diagonal {
        public final int size;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final int f4061x;
        public final int y;

        public Diagonal(int i2, int i8, int i9) {
            this.f4061x = i2;
            this.y = i8;
            this.size = i9;
        }

        public int endX() {
            return this.f4061x + this.size;
        }

        public int endY() {
            return this.y + this.size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final List<Diagonal> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        public DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z2) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z2;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            Diagonal diagonal = this.mDiagonals.isEmpty() ? null : this.mDiagonals.get(0);
            if (diagonal == null || diagonal.f4061x != 0 || diagonal.y != 0) {
                this.mDiagonals.add(0, new Diagonal(0, 0, 0));
            }
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i2) {
            int size = this.mDiagonals.size();
            int iEndY = 0;
            for (int i8 = 0; i8 < size; i8++) {
                Diagonal diagonal = this.mDiagonals.get(i8);
                while (iEndY < diagonal.y) {
                    if (this.mNewItemStatuses[iEndY] == 0 && this.mCallback.areItemsTheSame(i2, iEndY)) {
                        int i9 = this.mCallback.areContentsTheSame(i2, iEndY) ? 8 : 4;
                        this.mOldItemStatuses[i2] = (iEndY << 4) | i9;
                        this.mNewItemStatuses[iEndY] = (i2 << 4) | i9;
                        return;
                    }
                    iEndY++;
                }
                iEndY = diagonal.endY();
            }
        }

        private void findMatchingItems() {
            for (Diagonal diagonal : this.mDiagonals) {
                for (int i2 = 0; i2 < diagonal.size; i2++) {
                    int i8 = diagonal.f4061x + i2;
                    int i9 = diagonal.y + i2;
                    int i10 = this.mCallback.areContentsTheSame(i8, i9) ? 1 : 2;
                    this.mOldItemStatuses[i8] = (i9 << 4) | i10;
                    this.mNewItemStatuses[i9] = (i8 << 4) | i10;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int iEndX = 0;
            for (Diagonal diagonal : this.mDiagonals) {
                while (iEndX < diagonal.f4061x) {
                    if (this.mOldItemStatuses[iEndX] == 0) {
                        findMatchingAddition(iEndX);
                    }
                    iEndX++;
                }
                iEndX = diagonal.endX();
            }
        }

        @Nullable
        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> collection, int i2, boolean z2) {
            PostponedUpdate next;
            Iterator<PostponedUpdate> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.posInOwnerList == i2 && next.removal == z2) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate next2 = it.next();
                if (z2) {
                    next2.currentPos--;
                } else {
                    next2.currentPos++;
                }
            }
            return next;
        }

        public int convertNewPositionToOld(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2) {
            if (i2 < 0 || i2 >= this.mNewListSize) {
                StringBuilder sbV = a.v(i2, "Index out of bounds - passed position = ", ", new list size = ");
                sbV.append(this.mNewListSize);
                throw new IndexOutOfBoundsException(sbV.toString());
            }
            int i8 = this.mNewItemStatuses[i2];
            if ((i8 & 15) == 0) {
                return -1;
            }
            return i8 >> 4;
        }

        public int convertOldPositionToNew(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2) {
            if (i2 < 0 || i2 >= this.mOldListSize) {
                StringBuilder sbV = a.v(i2, "Index out of bounds - passed position = ", ", old list size = ");
                sbV.append(this.mOldListSize);
                throw new IndexOutOfBoundsException(sbV.toString());
            }
            int i8 = this.mOldItemStatuses[i2];
            if ((i8 & 15) == 0) {
                return -1;
            }
            return i8 >> 4;
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            int i2;
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            int i8 = this.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i9 = this.mOldListSize;
            int i10 = this.mNewListSize;
            for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.mDiagonals.get(size);
                int iEndX = diagonal.endX();
                int iEndY = diagonal.endY();
                while (true) {
                    if (i9 <= iEndX) {
                        break;
                    }
                    i9--;
                    int i11 = this.mOldItemStatuses[i9];
                    if ((i11 & 12) != 0) {
                        int i12 = i11 >> 4;
                        PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i12, false);
                        if (postponedUpdate != null) {
                            int i13 = (i8 - postponedUpdate.currentPos) - 1;
                            batchingListUpdateCallback.onMoved(i9, i13);
                            if ((i11 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i13, 1, this.mCallback.getChangePayload(i9, i12));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i9, (i8 - i9) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.onRemoved(i9, 1);
                        i8--;
                    }
                }
                while (i10 > iEndY) {
                    i10--;
                    int i14 = this.mNewItemStatuses[i10];
                    if ((i14 & 12) != 0) {
                        int i15 = i14 >> 4;
                        PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i15, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new PostponedUpdate(i10, i8 - i9, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i8 - postponedUpdate2.currentPos) - 1, i9);
                            if ((i14 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i9, 1, this.mCallback.getChangePayload(i15, i10));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i9, 1);
                        i8++;
                    }
                }
                int i16 = diagonal.f4061x;
                int i17 = diagonal.y;
                for (i2 = 0; i2 < diagonal.size; i2++) {
                    if ((this.mOldItemStatuses[i16] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i16, 1, this.mCallback.getChangePayload(i16, i17));
                    }
                    i16++;
                    i17++;
                }
                i9 = diagonal.f4061x;
                i10 = diagonal.y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t3, @NonNull T t7);

        public abstract boolean areItemsTheSame(@NonNull T t3, @NonNull T t7);

        @Nullable
        public Object getChangePayload(@NonNull T t3, @NonNull T t7) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i2, int i8, boolean z2) {
            this.posInOwnerList = i2;
            this.currentPos = i8;
            this.removal = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public int newSize() {
            return this.newListEnd - this.newListStart;
        }

        public int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        public Range(int i2, int i8, int i9, int i10) {
            this.oldListStart = i2;
            this.oldListEnd = i8;
            this.newListStart = i9;
            this.newListEnd = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        public int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        public boolean hasAdditionOrRemoval() {
            return this.endY - this.startY != this.endX - this.startX;
        }

        public boolean isAddition() {
            return this.endY - this.startY > this.endX - this.startX;
        }

        @NonNull
        public Diagonal toDiagonal() {
            if (hasAdditionOrRemoval()) {
                return this.reverse ? new Diagonal(this.startX, this.startY, diagonalSize()) : isAddition() ? new Diagonal(this.startX, this.startY + 1, diagonalSize()) : new Diagonal(this.startX + 1, this.startY, diagonalSize());
            }
            int i2 = this.startX;
            return new Diagonal(i2, this.startY, this.endX - i2);
        }
    }

    private DiffUtil() {
    }

    @Nullable
    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i2) {
        int i8;
        int i9;
        int i10;
        boolean z2 = (range.oldSize() - range.newSize()) % 2 == 0;
        int iOldSize = range.oldSize() - range.newSize();
        int i11 = -i2;
        for (int i12 = i11; i12 <= i2; i12 += 2) {
            if (i12 == i11 || (i12 != i2 && centeredArray2.get(i12 + 1) < centeredArray2.get(i12 - 1))) {
                i8 = centeredArray2.get(i12 + 1);
                i9 = i8;
            } else {
                i8 = centeredArray2.get(i12 - 1);
                i9 = i8 - 1;
            }
            int i13 = range.newListEnd - ((range.oldListEnd - i9) - i12);
            int i14 = (i2 == 0 || i9 != i8) ? i13 : i13 + 1;
            while (i9 > range.oldListStart && i13 > range.newListStart && callback.areItemsTheSame(i9 - 1, i13 - 1)) {
                i9--;
                i13--;
            }
            centeredArray2.set(i12, i9);
            if (z2 && (i10 = iOldSize - i12) >= i11 && i10 <= i2 && centeredArray.get(i10) >= i9) {
                Snake snake = new Snake();
                snake.startX = i9;
                snake.startY = i13;
                snake.endX = i8;
                snake.endY = i14;
                snake.reverse = true;
                return snake;
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    @Nullable
    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i2) {
        int i8;
        int i9;
        int i10;
        boolean z2 = Math.abs(range.oldSize() - range.newSize()) % 2 == 1;
        int iOldSize = range.oldSize() - range.newSize();
        int i11 = -i2;
        for (int i12 = i11; i12 <= i2; i12 += 2) {
            if (i12 == i11 || (i12 != i2 && centeredArray.get(i12 + 1) > centeredArray.get(i12 - 1))) {
                i8 = centeredArray.get(i12 + 1);
                i9 = i8;
            } else {
                i8 = centeredArray.get(i12 - 1);
                i9 = i8 + 1;
            }
            int i13 = ((i9 - range.oldListStart) + range.newListStart) - i12;
            int i14 = (i2 == 0 || i9 != i8) ? i13 : i13 - 1;
            while (i9 < range.oldListEnd && i13 < range.newListEnd && callback.areItemsTheSame(i9, i13)) {
                i9++;
                i13++;
            }
            centeredArray.set(i12, i9);
            if (z2 && (i10 = iOldSize - i12) >= i11 + 1 && i10 <= i2 - 1 && centeredArray2.get(i10) <= i9) {
                Snake snake = new Snake();
                snake.startX = i8;
                snake.startY = i14;
                snake.endX = i9;
                snake.endY = i13;
                snake.reverse = false;
                return snake;
            }
        }
        return null;
    }

    @Nullable
    private static Snake midPoint(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.oldSize() >= 1 && range.newSize() >= 1) {
            int iOldSize = ((range.oldSize() + range.newSize()) + 1) / 2;
            centeredArray.set(1, range.oldListStart);
            centeredArray2.set(1, range.oldListEnd);
            for (int i2 = 0; i2 < iOldSize; i2++) {
                Snake snakeForward = forward(range, callback, centeredArray, centeredArray2, i2);
                if (snakeForward != null) {
                    return snakeForward;
                }
                Snake snakeBackward = backward(range, callback, centeredArray, centeredArray2, i2);
                if (snakeBackward != null) {
                    return snakeBackward;
                }
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z2) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i2 = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i2);
        CenteredArray centeredArray2 = new CenteredArray(i2);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake snakeMidPoint = midPoint(range, callback, centeredArray, centeredArray2);
            if (snakeMidPoint != null) {
                if (snakeMidPoint.diagonalSize() > 0) {
                    arrayList.add(snakeMidPoint.toDiagonal());
                }
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                range2.oldListEnd = snakeMidPoint.startX;
                range2.newListEnd = snakeMidPoint.startY;
                arrayList2.add(range2);
                range.oldListEnd = range.oldListEnd;
                range.newListEnd = range.newListEnd;
                range.oldListStart = snakeMidPoint.endX;
                range.newListStart = snakeMidPoint.endY;
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z2);
    }
}
