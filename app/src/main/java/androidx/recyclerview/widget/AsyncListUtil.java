package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class AsyncListUtil<T> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    final Class<T> mTClass;
    final TileList<T> mTileList;
    final int mTileSize;
    final ViewCallback mViewCallback;
    final int[] mTmpRange = new int[2];
    final int[] mPrevRange = new int[2];
    final int[] mTmpRangeExtended = new int[2];
    private int mScrollHint = 0;
    int mItemCount = 0;
    int mDisplayedGeneration = 0;
    int mRequestedGeneration = 0;
    final SparseIntArray mMissingPositions = new SparseIntArray();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i2) {
            int i8 = iArr[1];
            int i9 = iArr[0];
            int i10 = (i8 - i9) + 1;
            int i11 = i10 / 2;
            iArr2[0] = i9 - (i2 == 1 ? i10 : i11);
            if (i2 != 2) {
                i10 = i11;
            }
            iArr2[1] = i8 + i10;
        }

        @UiThread
        public abstract void getItemRangeInto(@NonNull int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i2);
    }

    public AsyncListUtil(@NonNull Class<T> cls, int i2, @NonNull DataCallback<T> dataCallback, @NonNull ViewCallback viewCallback) {
        ThreadUtil.MainThreadCallback<T> mainThreadCallback = new ThreadUtil.MainThreadCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.1
            private boolean isRequestedGeneration(int i8) {
                return i8 == AsyncListUtil.this.mRequestedGeneration;
            }

            private void recycleAllTiles() {
                for (int i8 = 0; i8 < AsyncListUtil.this.mTileList.size(); i8++) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.mBackgroundProxy.recycleTile(asyncListUtil.mTileList.getAtIndex(i8));
                }
                AsyncListUtil.this.mTileList.clear();
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void addTile(int i8, TileList.Tile<T> tile) {
                if (!isRequestedGeneration(i8)) {
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(tile);
                    return;
                }
                TileList.Tile<T> tileAddOrReplace = AsyncListUtil.this.mTileList.addOrReplace(tile);
                if (tileAddOrReplace != null) {
                    Log.e(AsyncListUtil.TAG, "duplicate tile @" + tileAddOrReplace.mStartPosition);
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(tileAddOrReplace);
                }
                int i9 = tile.mStartPosition + tile.mItemCount;
                int i10 = 0;
                while (i10 < AsyncListUtil.this.mMissingPositions.size()) {
                    int iKeyAt = AsyncListUtil.this.mMissingPositions.keyAt(i10);
                    if (tile.mStartPosition > iKeyAt || iKeyAt >= i9) {
                        i10++;
                    } else {
                        AsyncListUtil.this.mMissingPositions.removeAt(i10);
                        AsyncListUtil.this.mViewCallback.onItemLoaded(iKeyAt);
                    }
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void removeTile(int i8, int i9) {
                if (isRequestedGeneration(i8)) {
                    TileList.Tile<T> tileRemoveAtPos = AsyncListUtil.this.mTileList.removeAtPos(i9);
                    if (tileRemoveAtPos != null) {
                        AsyncListUtil.this.mBackgroundProxy.recycleTile(tileRemoveAtPos);
                        return;
                    }
                    Log.e(AsyncListUtil.TAG, "tile not found @" + i9);
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
            public void updateItemCount(int i8, int i9) {
                if (isRequestedGeneration(i8)) {
                    AsyncListUtil asyncListUtil = AsyncListUtil.this;
                    asyncListUtil.mItemCount = i9;
                    asyncListUtil.mViewCallback.onDataRefresh();
                    AsyncListUtil asyncListUtil2 = AsyncListUtil.this;
                    asyncListUtil2.mDisplayedGeneration = asyncListUtil2.mRequestedGeneration;
                    recycleAllTiles();
                    AsyncListUtil asyncListUtil3 = AsyncListUtil.this;
                    asyncListUtil3.mAllowScrollHints = false;
                    asyncListUtil3.updateRange();
                }
            }
        };
        this.mMainThreadCallback = mainThreadCallback;
        ThreadUtil.BackgroundCallback<T> backgroundCallback = new ThreadUtil.BackgroundCallback<T>() { // from class: androidx.recyclerview.widget.AsyncListUtil.2
            private int mFirstRequiredTileStart;
            private int mGeneration;
            private int mItemCount;
            private int mLastRequiredTileStart;
            final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
            private TileList.Tile<T> mRecycledRoot;

            private TileList.Tile<T> acquireTile() {
                TileList.Tile<T> tile = this.mRecycledRoot;
                if (tile != null) {
                    this.mRecycledRoot = tile.mNext;
                    return tile;
                }
                AsyncListUtil asyncListUtil = AsyncListUtil.this;
                return new TileList.Tile<>(asyncListUtil.mTClass, asyncListUtil.mTileSize);
            }

            private void addTile(TileList.Tile<T> tile) {
                this.mLoadedTiles.put(tile.mStartPosition, true);
                AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, tile);
            }

            private void flushTileCache(int i8) {
                int maxCachedTiles = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
                while (this.mLoadedTiles.size() >= maxCachedTiles) {
                    int iKeyAt = this.mLoadedTiles.keyAt(0);
                    SparseBooleanArray sparseBooleanArray = this.mLoadedTiles;
                    int iKeyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                    int i9 = this.mFirstRequiredTileStart - iKeyAt;
                    int i10 = iKeyAt2 - this.mLastRequiredTileStart;
                    if (i9 > 0 && (i9 >= i10 || i8 == 2)) {
                        removeTile(iKeyAt);
                    } else {
                        if (i10 <= 0) {
                            return;
                        }
                        if (i9 >= i10 && i8 != 1) {
                            return;
                        } else {
                            removeTile(iKeyAt2);
                        }
                    }
                }
            }

            private int getTileStart(int i8) {
                return i8 - (i8 % AsyncListUtil.this.mTileSize);
            }

            private boolean isTileLoaded(int i8) {
                return this.mLoadedTiles.get(i8);
            }

            private void log(String str, Object... objArr) {
                Log.d(AsyncListUtil.TAG, "[BKGR] ".concat(String.format(str, objArr)));
            }

            private void removeTile(int i8) {
                this.mLoadedTiles.delete(i8);
                AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, i8);
            }

            private void requestTiles(int i8, int i9, int i10, boolean z2) {
                int i11 = i8;
                while (i11 <= i9) {
                    AsyncListUtil.this.mBackgroundProxy.loadTile(z2 ? (i9 + i8) - i11 : i11, i10);
                    i11 += AsyncListUtil.this.mTileSize;
                }
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void loadTile(int i8, int i9) {
                if (isTileLoaded(i8)) {
                    return;
                }
                TileList.Tile<T> tileAcquireTile = acquireTile();
                tileAcquireTile.mStartPosition = i8;
                int iMin = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - i8);
                tileAcquireTile.mItemCount = iMin;
                AsyncListUtil.this.mDataCallback.fillData(tileAcquireTile.mItems, tileAcquireTile.mStartPosition, iMin);
                flushTileCache(i9);
                addTile(tileAcquireTile);
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void recycleTile(TileList.Tile<T> tile) {
                AsyncListUtil.this.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
                tile.mNext = this.mRecycledRoot;
                this.mRecycledRoot = tile;
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void refresh(int i8) {
                this.mGeneration = i8;
                this.mLoadedTiles.clear();
                int iRefreshData = AsyncListUtil.this.mDataCallback.refreshData();
                this.mItemCount = iRefreshData;
                AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, iRefreshData);
            }

            @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
            public void updateRange(int i8, int i9, int i10, int i11, int i12) {
                if (i8 > i9) {
                    return;
                }
                int tileStart = getTileStart(i8);
                int tileStart2 = getTileStart(i9);
                this.mFirstRequiredTileStart = getTileStart(i10);
                int tileStart3 = getTileStart(i11);
                this.mLastRequiredTileStart = tileStart3;
                if (i12 == 1) {
                    requestTiles(this.mFirstRequiredTileStart, tileStart2, i12, true);
                    requestTiles(tileStart2 + AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, i12, false);
                } else {
                    requestTiles(tileStart, tileStart3, i12, false);
                    requestTiles(this.mFirstRequiredTileStart, tileStart - AsyncListUtil.this.mTileSize, i12, true);
                }
            }
        };
        this.mBackgroundCallback = backgroundCallback;
        this.mTClass = cls;
        this.mTileSize = i2;
        this.mDataCallback = dataCallback;
        this.mViewCallback = viewCallback;
        this.mTileList = new TileList<>(i2);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.mMainThreadProxy = messageThreadUtil.getMainThreadProxy(mainThreadCallback);
        this.mBackgroundProxy = messageThreadUtil.getBackgroundProxy(backgroundCallback);
        refresh();
    }

    private boolean isRefreshPending() {
        return this.mRequestedGeneration != this.mDisplayedGeneration;
    }

    @Nullable
    public T getItem(int i2) {
        if (i2 < 0 || i2 >= this.mItemCount) {
            throw new IndexOutOfBoundsException(i2 + " is not within 0 and " + this.mItemCount);
        }
        T itemAt = this.mTileList.getItemAt(i2);
        if (itemAt == null && !isRefreshPending()) {
            this.mMissingPositions.put(i2, 0);
        }
        return itemAt;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public void log(String str, Object... objArr) {
        Log.d(TAG, "[MAIN] ".concat(String.format(str, objArr)));
    }

    public void onRangeChanged() {
        if (isRefreshPending()) {
            return;
        }
        updateRange();
        this.mAllowScrollHints = true;
    }

    public void refresh() {
        this.mMissingPositions.clear();
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int i2 = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = i2;
        backgroundCallback.refresh(i2);
    }

    public void updateRange() {
        int i2;
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] iArr = this.mTmpRange;
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (i8 > i9 || i8 < 0 || i9 >= this.mItemCount) {
            return;
        }
        if (this.mAllowScrollHints) {
            int[] iArr2 = this.mPrevRange;
            if (i8 > iArr2[1] || (i2 = iArr2[0]) > i9) {
                this.mScrollHint = 0;
            } else if (i8 < i2) {
                this.mScrollHint = 1;
            } else if (i8 > i2) {
                this.mScrollHint = 2;
            }
        } else {
            this.mScrollHint = 0;
        }
        int[] iArr3 = this.mPrevRange;
        iArr3[0] = i8;
        iArr3[1] = i9;
        this.mViewCallback.extendRangeInto(iArr, this.mTmpRangeExtended, this.mScrollHint);
        int[] iArr4 = this.mTmpRangeExtended;
        iArr4[0] = Math.min(this.mTmpRange[0], Math.max(iArr4[0], 0));
        int[] iArr5 = this.mTmpRangeExtended;
        iArr5[1] = Math.max(this.mTmpRange[1], Math.min(iArr5[1], this.mItemCount - 1));
        ThreadUtil.BackgroundCallback<T> backgroundCallback = this.mBackgroundProxy;
        int[] iArr6 = this.mTmpRange;
        int i10 = iArr6[0];
        int i11 = iArr6[1];
        int[] iArr7 = this.mTmpRangeExtended;
        backgroundCallback.updateRange(i10, i11, iArr7[0], iArr7[1], this.mScrollHint);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(@NonNull T[] tArr, int i2, int i8);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public abstract int refreshData();

        @WorkerThread
        public void recycleData(@NonNull T[] tArr, int i2) {
        }
    }
}
