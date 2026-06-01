package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class DirectedAcyclicGraph<T> {
    private final Pools.Pool<ArrayList<T>> mListPool = new Pools.SimplePool(10);
    private final SimpleArrayMap<T, ArrayList<T>> mGraph = new SimpleArrayMap<>();
    private final ArrayList<T> mSortResult = new ArrayList<>();
    private final HashSet<T> mSortTmpMarked = new HashSet<>();

    private void dfs(T t3, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t3)) {
            return;
        }
        if (hashSet.contains(t3)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t3);
        ArrayList<T> arrayList2 = this.mGraph.get(t3);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                dfs(arrayList2.get(i2), arrayList, hashSet);
            }
        }
        hashSet.remove(t3);
        arrayList.add(t3);
    }

    @NonNull
    private ArrayList<T> getEmptyList() {
        ArrayList<T> arrayListAcquire = this.mListPool.acquire();
        return arrayListAcquire == null ? new ArrayList<>() : arrayListAcquire;
    }

    private void poolList(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.mListPool.release(arrayList);
    }

    public void addEdge(@NonNull T t3, @NonNull T t7) {
        if (!this.mGraph.containsKey(t3) || !this.mGraph.containsKey(t7)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> emptyList = this.mGraph.get(t3);
        if (emptyList == null) {
            emptyList = getEmptyList();
            this.mGraph.put(t3, emptyList);
        }
        emptyList.add(t7);
    }

    public void addNode(@NonNull T t3) {
        if (this.mGraph.containsKey(t3)) {
            return;
        }
        this.mGraph.put(t3, null);
    }

    public void clear() {
        int size = this.mGraph.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> arrayListValueAt = this.mGraph.valueAt(i2);
            if (arrayListValueAt != null) {
                poolList(arrayListValueAt);
            }
        }
        this.mGraph.clear();
    }

    public boolean contains(@NonNull T t3) {
        return this.mGraph.containsKey(t3);
    }

    @Nullable
    public List getIncomingEdges(@NonNull T t3) {
        return this.mGraph.get(t3);
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T t3) {
        int size = this.mGraph.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> arrayListValueAt = this.mGraph.valueAt(i2);
            if (arrayListValueAt != null && arrayListValueAt.contains(t3)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.mGraph.keyAt(i2));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int size = this.mGraph.size();
        for (int i2 = 0; i2 < size; i2++) {
            dfs(this.mGraph.keyAt(i2), this.mSortResult, this.mSortTmpMarked);
        }
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(@NonNull T t3) {
        int size = this.mGraph.size();
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList<T> arrayListValueAt = this.mGraph.valueAt(i2);
            if (arrayListValueAt != null && arrayListValueAt.contains(t3)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.mGraph.size();
    }
}
