package androidx.collection;

import a1.a;
import androidx.annotation.IntRange;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.b;
import r5.e;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableLongList extends LongList {
    public MutableLongList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableLongList mutableLongList, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = mutableLongList._size;
        }
        mutableLongList.trim(i2);
    }

    public final boolean add(long j) {
        ensureCapacity(this._size + 1);
        long[] jArr = this.content;
        int i2 = this._size;
        jArr[i2] = j;
        this._size = i2 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, long[] elements) {
        int i8;
        k.e(elements, "elements");
        if (i2 < 0 || i2 > (i8 = this._size)) {
            StringBuilder sbV = a.v(i2, "Index ", " must be in 0..");
            sbV.append(this._size);
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        if (elements.length == 0) {
            return false;
        }
        ensureCapacity(i8 + elements.length);
        long[] jArr = this.content;
        int i9 = this._size;
        if (i2 != i9) {
            j.e0(jArr, jArr, elements.length + i2, i2, i9);
        }
        j.e0(elements, jArr, i2, 0, elements.length);
        this._size += elements.length;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i2) {
        long[] jArr = this.content;
        if (jArr.length < i2) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, Math.max(i2, (jArr.length * 3) / 2));
            k.d(jArrCopyOf, "copyOf(this, newSize)");
            this.content = jArrCopyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(long j) {
        remove(j);
    }

    public final void plusAssign(LongList elements) {
        k.e(elements, "elements");
        addAll(this._size, elements);
    }

    public final boolean remove(long j) {
        int iIndexOf = indexOf(j);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(long[] elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        for (long j : elements) {
            remove(j);
        }
        return i2 != this._size;
    }

    public final long removeAt(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2) {
        int i8;
        if (i2 < 0 || i2 >= (i8 = this._size)) {
            StringBuilder sbV = a.v(i2, "Index ", " must be in 0..");
            sbV.append(this._size - 1);
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        long[] jArr = this.content;
        long j = jArr[i2];
        if (i2 != i8 - 1) {
            j.e0(jArr, jArr, i2, i2 + 1, i8);
        }
        this._size--;
        return j;
    }

    public final void removeRange(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i8) {
        int i9;
        if (i2 < 0 || i2 > (i9 = this._size) || i8 < 0 || i8 > i9) {
            StringBuilder sbW = a.w(i2, "Start (", ") and end (", i8, ") must be in 0..");
            sbW.append(this._size);
            throw new IndexOutOfBoundsException(sbW.toString());
        }
        if (i8 < i2) {
            throw new IllegalArgumentException("Start (" + i2 + ") is more than end (" + i8 + ')');
        }
        if (i8 != i2) {
            if (i8 < i9) {
                long[] jArr = this.content;
                j.e0(jArr, jArr, i2, i8, i9);
            }
            this._size -= i8 - i2;
        }
    }

    public final boolean retainAll(long[] elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        long[] jArr = this.content;
        int i8 = i2 - 1;
        while (true) {
            int i9 = 0;
            int i10 = -1;
            if (-1 >= i8) {
                break;
            }
            long j = jArr[i8];
            int length = elements.length;
            while (true) {
                if (i9 >= length) {
                    break;
                }
                if (elements[i9] == j) {
                    i10 = i9;
                    break;
                }
                i9++;
            }
            if (i10 < 0) {
                removeAt(i8);
            }
            i8--;
        }
        return i2 != this._size;
    }

    public final long set(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, long j) {
        if (i2 < 0 || i2 >= this._size) {
            StringBuilder sbV = a.v(i2, "set index ", " must be between 0 .. ");
            sbV.append(this._size - 1);
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        long[] jArr = this.content;
        long j3 = jArr[i2];
        jArr[i2] = j;
        return j3;
    }

    public final void sort() {
        long[] jArr = this.content;
        int i2 = this._size;
        k.e(jArr, "<this>");
        Arrays.sort(jArr, 0, i2);
    }

    public final void sortDescending() {
        long[] jArr = this.content;
        int i2 = this._size;
        k.e(jArr, "<this>");
        Arrays.sort(jArr, 0, i2);
        b bVar = e.Companion;
        int length = jArr.length;
        bVar.getClass();
        b.d(0, i2, length);
        int i8 = i2 / 2;
        if (i8 == 0) {
            return;
        }
        int i9 = i2 - 1;
        for (int i10 = 0; i10 < i8; i10++) {
            long j = jArr[i10];
            jArr[i10] = jArr[i9];
            jArr[i9] = j;
            i9--;
        }
    }

    public final void trim(int i2) {
        int iMax = Math.max(i2, this._size);
        long[] jArr = this.content;
        if (jArr.length > iMax) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            k.d(jArrCopyOf, "copyOf(this, newSize)");
            this.content = jArrCopyOf;
        }
    }

    public /* synthetic */ MutableLongList(int i2, int i8, f fVar) {
        this((i8 & 1) != 0 ? 16 : i2);
    }

    public final void minusAssign(long[] elements) {
        k.e(elements, "elements");
        for (long j : elements) {
            remove(j);
        }
    }

    public final void plusAssign(long[] elements) {
        k.e(elements, "elements");
        addAll(this._size, elements);
    }

    public MutableLongList(int i2) {
        super(i2, null);
    }

    public final void plusAssign(long j) {
        add(j);
    }

    public final void add(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, long j) {
        int i8;
        if (i2 >= 0 && i2 <= (i8 = this._size)) {
            ensureCapacity(i8 + 1);
            long[] jArr = this.content;
            int i9 = this._size;
            if (i2 != i9) {
                j.e0(jArr, jArr, i2 + 1, i2, i9);
            }
            jArr[i2] = j;
            this._size++;
            return;
        }
        StringBuilder sbV = a.v(i2, "Index ", " must be in 0..");
        sbV.append(this._size);
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final void minusAssign(LongList elements) {
        k.e(elements, "elements");
        long[] jArr = elements.content;
        int i2 = elements._size;
        for (int i8 = 0; i8 < i2; i8++) {
            remove(jArr[i8]);
        }
    }

    public final boolean removeAll(LongList elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        int i8 = elements._size - 1;
        if (i8 >= 0) {
            int i9 = 0;
            while (true) {
                remove(elements.get(i9));
                if (i9 == i8) {
                    break;
                }
                i9++;
            }
        }
        return i2 != this._size;
    }

    public final boolean retainAll(LongList elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        long[] jArr = this.content;
        for (int i8 = i2 - 1; -1 < i8; i8--) {
            if (!elements.contains(jArr[i8])) {
                removeAt(i8);
            }
        }
        return i2 != this._size;
    }

    public final boolean addAll(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, LongList elements) {
        k.e(elements, "elements");
        if (i2 >= 0 && i2 <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            long[] jArr = this.content;
            int i8 = this._size;
            if (i2 != i8) {
                j.e0(jArr, jArr, elements._size + i2, i2, i8);
            }
            j.e0(elements.content, jArr, i2, 0, elements._size);
            this._size += elements._size;
            return true;
        }
        StringBuilder sbV = a.v(i2, "Index ", " must be in 0..");
        sbV.append(this._size);
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final boolean addAll(LongList elements) {
        k.e(elements, "elements");
        return addAll(this._size, elements);
    }

    public final boolean addAll(long[] elements) {
        k.e(elements, "elements");
        return addAll(this._size, elements);
    }
}
