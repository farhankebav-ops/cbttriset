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
public final class MutableFloatList extends FloatList {
    public MutableFloatList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableFloatList mutableFloatList, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = mutableFloatList._size;
        }
        mutableFloatList.trim(i2);
    }

    public final boolean add(float f4) {
        ensureCapacity(this._size + 1);
        float[] fArr = this.content;
        int i2 = this._size;
        fArr[i2] = f4;
        this._size = i2 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, float[] elements) {
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
        float[] fArr = this.content;
        int i9 = this._size;
        if (i2 != i9) {
            j.d0(fArr, elements.length + i2, fArr, i2, i9);
        }
        j.d0(elements, i2, fArr, 0, elements.length);
        this._size += elements.length;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i2) {
        float[] fArr = this.content;
        if (fArr.length < i2) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, Math.max(i2, (fArr.length * 3) / 2));
            k.d(fArrCopyOf, "copyOf(this, newSize)");
            this.content = fArrCopyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(float f4) {
        remove(f4);
    }

    public final void plusAssign(FloatList elements) {
        k.e(elements, "elements");
        addAll(this._size, elements);
    }

    public final boolean remove(float f4) {
        int iIndexOf = indexOf(f4);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(float[] elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        for (float f4 : elements) {
            remove(f4);
        }
        return i2 != this._size;
    }

    public final float removeAt(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2) {
        int i8;
        if (i2 < 0 || i2 >= (i8 = this._size)) {
            StringBuilder sbV = a.v(i2, "Index ", " must be in 0..");
            sbV.append(this._size - 1);
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        float[] fArr = this.content;
        float f4 = fArr[i2];
        if (i2 != i8 - 1) {
            j.d0(fArr, i2, fArr, i2 + 1, i8);
        }
        this._size--;
        return f4;
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
                float[] fArr = this.content;
                j.d0(fArr, i2, fArr, i8, i9);
            }
            this._size -= i8 - i2;
        }
    }

    public final boolean retainAll(float[] elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        float[] fArr = this.content;
        int i8 = i2 - 1;
        while (true) {
            int i9 = 0;
            int i10 = -1;
            if (-1 >= i8) {
                break;
            }
            float f4 = fArr[i8];
            int length = elements.length;
            while (true) {
                if (i9 >= length) {
                    break;
                }
                if (elements[i9] == f4) {
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

    public final float set(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, float f4) {
        if (i2 < 0 || i2 >= this._size) {
            StringBuilder sbV = a.v(i2, "set index ", " must be between 0 .. ");
            sbV.append(this._size - 1);
            throw new IndexOutOfBoundsException(sbV.toString());
        }
        float[] fArr = this.content;
        float f8 = fArr[i2];
        fArr[i2] = f4;
        return f8;
    }

    public final void sort() {
        float[] fArr = this.content;
        int i2 = this._size;
        k.e(fArr, "<this>");
        Arrays.sort(fArr, 0, i2);
    }

    public final void sortDescending() {
        float[] fArr = this.content;
        int i2 = this._size;
        k.e(fArr, "<this>");
        Arrays.sort(fArr, 0, i2);
        b bVar = e.Companion;
        int length = fArr.length;
        bVar.getClass();
        b.d(0, i2, length);
        int i8 = i2 / 2;
        if (i8 == 0) {
            return;
        }
        int i9 = i2 - 1;
        for (int i10 = 0; i10 < i8; i10++) {
            float f4 = fArr[i10];
            fArr[i10] = fArr[i9];
            fArr[i9] = f4;
            i9--;
        }
    }

    public final void trim(int i2) {
        int iMax = Math.max(i2, this._size);
        float[] fArr = this.content;
        if (fArr.length > iMax) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, iMax);
            k.d(fArrCopyOf, "copyOf(this, newSize)");
            this.content = fArrCopyOf;
        }
    }

    public /* synthetic */ MutableFloatList(int i2, int i8, f fVar) {
        this((i8 & 1) != 0 ? 16 : i2);
    }

    public final void minusAssign(float[] elements) {
        k.e(elements, "elements");
        for (float f4 : elements) {
            remove(f4);
        }
    }

    public final void plusAssign(float[] elements) {
        k.e(elements, "elements");
        addAll(this._size, elements);
    }

    public MutableFloatList(int i2) {
        super(i2, null);
    }

    public final void plusAssign(float f4) {
        add(f4);
    }

    public final void add(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, float f4) {
        int i8;
        if (i2 >= 0 && i2 <= (i8 = this._size)) {
            ensureCapacity(i8 + 1);
            float[] fArr = this.content;
            int i9 = this._size;
            if (i2 != i9) {
                j.d0(fArr, i2 + 1, fArr, i2, i9);
            }
            fArr[i2] = f4;
            this._size++;
            return;
        }
        StringBuilder sbV = a.v(i2, "Index ", " must be in 0..");
        sbV.append(this._size);
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final void minusAssign(FloatList elements) {
        k.e(elements, "elements");
        float[] fArr = elements.content;
        int i2 = elements._size;
        for (int i8 = 0; i8 < i2; i8++) {
            remove(fArr[i8]);
        }
    }

    public final boolean removeAll(FloatList elements) {
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

    public final boolean retainAll(FloatList elements) {
        k.e(elements, "elements");
        int i2 = this._size;
        float[] fArr = this.content;
        for (int i8 = i2 - 1; -1 < i8; i8--) {
            if (!elements.contains(fArr[i8])) {
                removeAt(i8);
            }
        }
        return i2 != this._size;
    }

    public final boolean addAll(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, FloatList elements) {
        k.e(elements, "elements");
        if (i2 >= 0 && i2 <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            float[] fArr = this.content;
            int i8 = this._size;
            if (i2 != i8) {
                j.d0(fArr, elements._size + i2, fArr, i2, i8);
            }
            j.d0(elements.content, i2, fArr, 0, elements._size);
            this._size += elements._size;
            return true;
        }
        StringBuilder sbV = a.v(i2, "Index ", " must be in 0..");
        sbV.append(this._size);
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final boolean addAll(FloatList elements) {
        k.e(elements, "elements");
        return addAll(this._size, elements);
    }

    public final boolean addAll(float[] elements) {
        k.e(elements, "elements");
        return addAll(this._size, elements);
    }
}
