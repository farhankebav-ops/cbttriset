package androidx.collection;

import a1.a;
import androidx.annotation.IntRange;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.ironsource.C2300e4;
import e6.l;
import e6.p;
import java.util.NoSuchElementException;
import k6.d;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IntList {
    public int _size;
    public int[] content;

    public /* synthetic */ IntList(int i2, f fVar) {
        this(i2);
    }

    public static /* synthetic */ String joinToString$default(IntList intList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i8 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i8 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i8 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i8 & 8) != 0) {
            i2 = -1;
        }
        if ((i8 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return intList.joinToString(charSequence, charSequence2, charSequence6, i2, charSequence5);
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public final boolean contains(int i2) {
        int[] iArr = this.content;
        int i8 = this._size;
        for (int i9 = 0; i9 < i8; i9++) {
            if (iArr[i9] == i2) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(IntList elements) {
        k.e(elements, "elements");
        d dVarD0 = q.D0(0, elements._size);
        int i2 = dVarD0.f12709a;
        int i8 = dVarD0.f12710b;
        if (i2 > i8) {
            return true;
        }
        while (contains(elements.get(i2))) {
            if (i2 == i8) {
                return true;
            }
            i2++;
        }
        return false;
    }

    public final int count() {
        return this._size;
    }

    public final int elementAt(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2) {
        if (i2 >= 0 && i2 < this._size) {
            return this.content[i2];
        }
        StringBuilder sbV = a.v(i2, "Index ", " must be in 0..");
        sbV.append(this._size - 1);
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final int elementAtOrElse(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, l defaultValue) {
        k.e(defaultValue, "defaultValue");
        return (i2 < 0 || i2 >= this._size) ? ((Number) defaultValue.invoke(Integer.valueOf(i2))).intValue() : this.content[i2];
    }

    public boolean equals(Object obj) {
        if (obj instanceof IntList) {
            IntList intList = (IntList) obj;
            int i2 = intList._size;
            int i8 = this._size;
            if (i2 == i8) {
                int[] iArr = this.content;
                int[] iArr2 = intList.content;
                d dVarD0 = q.D0(0, i8);
                int i9 = dVarD0.f12709a;
                int i10 = dVarD0.f12710b;
                if (i9 > i10) {
                    return true;
                }
                while (iArr[i9] == iArr2[i9]) {
                    if (i9 == i10) {
                        return true;
                    }
                    i9++;
                }
                return false;
            }
        }
        return false;
    }

    public final int first() {
        if (isEmpty()) {
            throw new NoSuchElementException("IntList is empty.");
        }
        return this.content[0];
    }

    public final <R> R fold(R r7, p operation) {
        k.e(operation, "operation");
        int[] iArr = this.content;
        int i2 = this._size;
        for (int i8 = 0; i8 < i2; i8++) {
            r7 = (R) operation.invoke(r7, Integer.valueOf(iArr[i8]));
        }
        return r7;
    }

    public final <R> R foldIndexed(R r7, e6.q operation) {
        k.e(operation, "operation");
        int[] iArr = this.content;
        int i2 = this._size;
        for (int i8 = 0; i8 < i2; i8++) {
            R r8 = r7;
            r7 = (R) operation.invoke(Integer.valueOf(i8), r8, Integer.valueOf(iArr[i8]));
        }
        return r7;
    }

    public final <R> R foldRight(R r7, p operation) {
        k.e(operation, "operation");
        int[] iArr = this.content;
        int i2 = this._size;
        while (true) {
            i2--;
            if (-1 >= i2) {
                return r7;
            }
            r7 = (R) operation.invoke(Integer.valueOf(iArr[i2]), r7);
        }
    }

    public final <R> R foldRightIndexed(R r7, e6.q operation) {
        k.e(operation, "operation");
        int[] iArr = this.content;
        int i2 = this._size;
        while (true) {
            i2--;
            if (-1 >= i2) {
                return r7;
            }
            r7 = (R) operation.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i2]), r7);
        }
    }

    public final void forEach(l block) {
        k.e(block, "block");
        int[] iArr = this.content;
        int i2 = this._size;
        for (int i8 = 0; i8 < i2; i8++) {
            block.invoke(Integer.valueOf(iArr[i8]));
        }
    }

    public final void forEachIndexed(p block) {
        k.e(block, "block");
        int[] iArr = this.content;
        int i2 = this._size;
        for (int i8 = 0; i8 < i2; i8++) {
            block.invoke(Integer.valueOf(i8), Integer.valueOf(iArr[i8]));
        }
    }

    public final void forEachReversed(l block) {
        k.e(block, "block");
        int[] iArr = this.content;
        int i2 = this._size;
        while (true) {
            i2--;
            if (-1 >= i2) {
                return;
            } else {
                block.invoke(Integer.valueOf(iArr[i2]));
            }
        }
    }

    public final void forEachReversedIndexed(p block) {
        k.e(block, "block");
        int[] iArr = this.content;
        int i2 = this._size;
        while (true) {
            i2--;
            if (-1 >= i2) {
                return;
            } else {
                block.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i2]));
            }
        }
    }

    public final int get(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2) {
        if (i2 >= 0 && i2 < this._size) {
            return this.content[i2];
        }
        StringBuilder sbV = a.v(i2, "Index ", " must be in 0..");
        sbV.append(this._size - 1);
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final d getIndices() {
        return q.D0(0, this._size);
    }

    @IntRange(from = -1)
    public final int getLastIndex() {
        return this._size - 1;
    }

    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int[] iArr = this.content;
        int i2 = this._size;
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            i8 += iArr[i9] * 31;
        }
        return i8;
    }

    public final int indexOf(int i2) {
        int[] iArr = this.content;
        int i8 = this._size;
        for (int i9 = 0; i9 < i8; i9++) {
            if (i2 == iArr[i9]) {
                return i9;
            }
        }
        return -1;
    }

    public final int indexOfFirst(l predicate) {
        k.e(predicate, "predicate");
        int[] iArr = this.content;
        int i2 = this._size;
        for (int i8 = 0; i8 < i2; i8++) {
            if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i8]))).booleanValue()) {
                return i8;
            }
        }
        return -1;
    }

    public final int indexOfLast(l predicate) {
        k.e(predicate, "predicate");
        int[] iArr = this.content;
        int i2 = this._size;
        do {
            i2--;
            if (-1 >= i2) {
                return -1;
            }
        } while (!((Boolean) predicate.invoke(Integer.valueOf(iArr[i2]))).booleanValue());
        return i2;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final int last() {
        if (isEmpty()) {
            throw new NoSuchElementException("IntList is empty.");
        }
        return this.content[this._size - 1];
    }

    public final int lastIndexOf(int i2) {
        int[] iArr = this.content;
        int i8 = this._size;
        do {
            i8--;
            if (-1 >= i8) {
                return -1;
            }
        } while (iArr[i8] != i2);
        return i8;
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(l predicate) {
        k.e(predicate, "predicate");
        int[] iArr = this.content;
        for (int i2 = this._size - 1; -1 < i2; i2--) {
            if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i2]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, C2300e4.i.f8403d, C2300e4.i.e, 0, null, 25, null);
    }

    private IntList(int i2) {
        this.content = i2 == 0 ? IntSetKt.getEmptyIntArray() : new int[i2];
    }

    public final boolean any(l predicate) {
        k.e(predicate, "predicate");
        int[] iArr = this.content;
        int i2 = this._size;
        for (int i8 = 0; i8 < i2; i8++) {
            if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i8]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int count(l predicate) {
        k.e(predicate, "predicate");
        int[] iArr = this.content;
        int i2 = this._size;
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i9]))).booleanValue()) {
                i8++;
            }
        }
        return i8;
    }

    public final String joinToString(CharSequence separator) {
        k.e(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    public final int first(l predicate) {
        k.e(predicate, "predicate");
        int[] iArr = this.content;
        int i2 = this._size;
        for (int i8 = 0; i8 < i2; i8++) {
            int i9 = iArr[i8];
            if (((Boolean) predicate.invoke(Integer.valueOf(i9))).booleanValue()) {
                return i9;
            }
        }
        throw new NoSuchElementException("IntList contains no element matching the predicate.");
    }

    public final String joinToString(CharSequence separator, CharSequence charSequence, l lVar) {
        k.e(separator, "separator");
        StringBuilder sbO = androidx.camera.core.processing.util.a.o(charSequence, "prefix", lVar, "transform", charSequence);
        int[] iArr = this.content;
        int i2 = this._size;
        int i8 = 0;
        while (true) {
            if (i8 < i2) {
                int i9 = iArr[i8];
                if (i8 == -1) {
                    sbO.append((CharSequence) "...");
                    break;
                }
                if (i8 != 0) {
                    sbO.append(separator);
                }
                sbO.append((CharSequence) lVar.invoke(Integer.valueOf(i9)));
                i8++;
            } else {
                sbO.append((CharSequence) "");
                break;
            }
        }
        String string = sbO.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(IntList intList, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence charSequence, l lVar, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 1) != 0) {
                separator = ", ";
            }
            if ((i8 & 2) != 0) {
                prefix = "";
            }
            if ((i8 & 4) != 0) {
                postfix = "";
            }
            if ((i8 & 8) != 0) {
                i2 = -1;
            }
            if ((i8 & 16) != 0) {
                charSequence = "...";
            }
            k.e(separator, "separator");
            k.e(prefix, "prefix");
            k.e(postfix, "postfix");
            StringBuilder sbO = androidx.camera.core.processing.util.a.o(charSequence, "truncated", lVar, "transform", prefix);
            int[] iArr = intList.content;
            int i9 = intList._size;
            int i10 = 0;
            while (true) {
                if (i10 < i9) {
                    int i11 = iArr[i10];
                    if (i10 == i2) {
                        sbO.append(charSequence);
                        break;
                    }
                    if (i10 != 0) {
                        sbO.append(separator);
                    }
                    sbO.append((CharSequence) lVar.invoke(Integer.valueOf(i11)));
                    i10++;
                } else {
                    sbO.append(postfix);
                    break;
                }
            }
            String string = sbO.toString();
            k.d(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final int last(l predicate) {
        int i2;
        k.e(predicate, "predicate");
        int[] iArr = this.content;
        int i8 = this._size;
        do {
            i8--;
            if (-1 < i8) {
                i2 = iArr[i8];
            } else {
                throw new NoSuchElementException("IntList contains no element matching the predicate.");
            }
        } while (!((Boolean) predicate.invoke(Integer.valueOf(i2))).booleanValue());
        return i2;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        k.e(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i2) {
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        k.e(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i2, null, 16, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i2, l lVar) {
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        StringBuilder sbO = androidx.camera.core.processing.util.a.o(charSequence, "postfix", lVar, "transform", prefix);
        int[] iArr = this.content;
        int i8 = this._size;
        int i9 = 0;
        while (true) {
            if (i9 < i8) {
                int i10 = iArr[i9];
                if (i9 == i2) {
                    sbO.append((CharSequence) "...");
                    break;
                }
                if (i9 != 0) {
                    sbO.append(separator);
                }
                sbO.append((CharSequence) lVar.invoke(Integer.valueOf(i10)));
                i9++;
            } else {
                sbO.append(charSequence);
                break;
            }
        }
        String string = sbO.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i2, CharSequence charSequence2) {
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        StringBuilder sbQ = androidx.camera.core.processing.util.a.q(charSequence, "postfix", charSequence2, "truncated", prefix);
        int[] iArr = this.content;
        int i8 = this._size;
        int i9 = 0;
        while (true) {
            if (i9 < i8) {
                int i10 = iArr[i9];
                if (i9 == i2) {
                    sbQ.append(charSequence2);
                    break;
                }
                if (i9 != 0) {
                    sbQ.append(separator);
                }
                sbQ.append(i10);
                i9++;
            } else {
                sbQ.append(charSequence);
                break;
            }
        }
        String string = sbQ.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence charSequence, l lVar) {
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        k.e(postfix, "postfix");
        StringBuilder sbO = androidx.camera.core.processing.util.a.o(charSequence, "truncated", lVar, "transform", prefix);
        int[] iArr = this.content;
        int i8 = this._size;
        int i9 = 0;
        while (true) {
            if (i9 < i8) {
                int i10 = iArr[i9];
                if (i9 == i2) {
                    sbO.append(charSequence);
                    break;
                }
                if (i9 != 0) {
                    sbO.append(separator);
                }
                sbO.append((CharSequence) lVar.invoke(Integer.valueOf(i10)));
                i9++;
            } else {
                sbO.append(postfix);
                break;
            }
        }
        String string = sbO.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, l lVar) {
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        StringBuilder sbO = androidx.camera.core.processing.util.a.o(charSequence, "postfix", lVar, "transform", prefix);
        int[] iArr = this.content;
        int i2 = this._size;
        int i8 = 0;
        while (true) {
            if (i8 < i2) {
                int i9 = iArr[i8];
                if (i8 == -1) {
                    sbO.append((CharSequence) "...");
                    break;
                }
                if (i8 != 0) {
                    sbO.append(separator);
                }
                sbO.append((CharSequence) lVar.invoke(Integer.valueOf(i9)));
                i8++;
            } else {
                sbO.append(charSequence);
                break;
            }
        }
        String string = sbO.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, l transform) {
        k.e(separator, "separator");
        k.e(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.content;
        int i2 = this._size;
        int i8 = 0;
        while (true) {
            if (i8 < i2) {
                int i9 = iArr[i8];
                if (i8 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i8 != 0) {
                    sb.append(separator);
                }
                sb.append((CharSequence) transform.invoke(Integer.valueOf(i9)));
                i8++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        String string = sb.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(l transform) {
        k.e(transform, "transform");
        StringBuilder sb = new StringBuilder("");
        int[] iArr = this.content;
        int i2 = this._size;
        int i8 = 0;
        while (true) {
            if (i8 < i2) {
                int i9 = iArr[i8];
                if (i8 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i8 != 0) {
                    sb.append((CharSequence) ", ");
                }
                sb.append((CharSequence) transform.invoke(Integer.valueOf(i9)));
                i8++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        String string = sb.toString();
        k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
