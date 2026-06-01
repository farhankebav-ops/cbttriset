package androidx.collection;

import a1.a;
import androidx.annotation.IntRange;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.ironsource.C2300e4;
import e6.p;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import k6.d;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ObjectList<E> {
    public int _size;
    public Object[] content;

    /* JADX INFO: renamed from: androidx.collection.ObjectList$toString$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        final /* synthetic */ ObjectList<E> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ObjectList<E> objectList) {
            super(1);
            this.this$0 = objectList;
        }

        @Override // e6.l
        public final CharSequence invoke(E e) {
            return e == this.this$0 ? "(this)" : String.valueOf(e);
        }
    }

    public /* synthetic */ ObjectList(int i2, f fVar) {
        this(i2);
    }

    public static /* synthetic */ String joinToString$default(ObjectList objectList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, e6.l lVar, int i8, Object obj) {
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
        if ((i8 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        e6.l lVar2 = lVar;
        return objectList.joinToString(charSequence, charSequence2, charSequence3, i2, charSequence5, lVar2);
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public abstract List<E> asList();

    public final boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    public final boolean containsAll(E[] elements) {
        k.e(elements, "elements");
        for (E e : elements) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    public final int count() {
        return this._size;
    }

    public final E elementAt(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2) {
        if (i2 >= 0 && i2 < this._size) {
            return (E) this.content[i2];
        }
        StringBuilder sbV = a.v(i2, "Index ", " must be in 0..");
        sbV.append(this._size - 1);
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final E elementAtOrElse(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2, e6.l defaultValue) {
        k.e(defaultValue, "defaultValue");
        return (i2 < 0 || i2 >= this._size) ? (E) defaultValue.invoke(Integer.valueOf(i2)) : (E) this.content[i2];
    }

    public boolean equals(Object obj) {
        if (obj instanceof ObjectList) {
            ObjectList objectList = (ObjectList) obj;
            int i2 = objectList._size;
            int i8 = this._size;
            if (i2 == i8) {
                Object[] objArr = this.content;
                Object[] objArr2 = objectList.content;
                d dVarD0 = q.D0(0, i8);
                int i9 = dVarD0.f12709a;
                int i10 = dVarD0.f12710b;
                if (i9 > i10) {
                    return true;
                }
                while (k.a(objArr[i9], objArr2[i9])) {
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

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ObjectList is empty.");
        }
        return (E) this.content[0];
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    public final <R> R fold(R r7, p operation) {
        k.e(operation, "operation");
        Object[] objArr = this.content;
        int i2 = this._size;
        for (int i8 = 0; i8 < i2; i8++) {
            r7 = (R) operation.invoke(r7, objArr[i8]);
        }
        return r7;
    }

    public final <R> R foldIndexed(R r7, e6.q operation) {
        k.e(operation, "operation");
        Object[] objArr = this.content;
        int i2 = this._size;
        for (int i8 = 0; i8 < i2; i8++) {
            r7 = (R) operation.invoke(Integer.valueOf(i8), r7, objArr[i8]);
        }
        return r7;
    }

    public final <R> R foldRight(R r7, p operation) {
        k.e(operation, "operation");
        Object[] objArr = this.content;
        int i2 = this._size;
        while (true) {
            i2--;
            if (-1 >= i2) {
                return r7;
            }
            r7 = (R) operation.invoke(objArr[i2], r7);
        }
    }

    public final <R> R foldRightIndexed(R r7, e6.q operation) {
        k.e(operation, "operation");
        Object[] objArr = this.content;
        int i2 = this._size;
        while (true) {
            i2--;
            if (-1 >= i2) {
                return r7;
            }
            r7 = (R) operation.invoke(Integer.valueOf(i2), objArr[i2], r7);
        }
    }

    public final void forEach(e6.l block) {
        k.e(block, "block");
        Object[] objArr = this.content;
        int i2 = this._size;
        for (int i8 = 0; i8 < i2; i8++) {
            block.invoke(objArr[i8]);
        }
    }

    public final void forEachIndexed(p block) {
        k.e(block, "block");
        Object[] objArr = this.content;
        int i2 = this._size;
        for (int i8 = 0; i8 < i2; i8++) {
            block.invoke(Integer.valueOf(i8), objArr[i8]);
        }
    }

    public final void forEachReversed(e6.l block) {
        k.e(block, "block");
        Object[] objArr = this.content;
        int i2 = this._size;
        while (true) {
            i2--;
            if (-1 >= i2) {
                return;
            } else {
                block.invoke(objArr[i2]);
            }
        }
    }

    public final void forEachReversedIndexed(p block) {
        k.e(block, "block");
        Object[] objArr = this.content;
        int i2 = this._size;
        while (true) {
            i2--;
            if (-1 >= i2) {
                return;
            } else {
                block.invoke(Integer.valueOf(i2), objArr[i2]);
            }
        }
    }

    public final E get(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2) {
        if (i2 >= 0 && i2 < this._size) {
            return (E) this.content[i2];
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
        Object[] objArr = this.content;
        int i2 = this._size;
        int iHashCode = 0;
        for (int i8 = 0; i8 < i2; i8++) {
            Object obj = objArr[i8];
            iHashCode += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return iHashCode;
    }

    public final int indexOf(E e) {
        int i2 = 0;
        if (e == null) {
            Object[] objArr = this.content;
            int i8 = this._size;
            while (i2 < i8) {
                if (objArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        Object[] objArr2 = this.content;
        int i9 = this._size;
        while (i2 < i9) {
            if (e.equals(objArr2[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public final int indexOfFirst(e6.l predicate) {
        k.e(predicate, "predicate");
        Object[] objArr = this.content;
        int i2 = this._size;
        for (int i8 = 0; i8 < i2; i8++) {
            if (((Boolean) predicate.invoke(objArr[i8])).booleanValue()) {
                return i8;
            }
        }
        return -1;
    }

    public final int indexOfLast(e6.l predicate) {
        k.e(predicate, "predicate");
        Object[] objArr = this.content;
        int i2 = this._size;
        do {
            i2--;
            if (-1 >= i2) {
                return -1;
            }
        } while (!((Boolean) predicate.invoke(objArr[i2])).booleanValue());
        return i2;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ObjectList is empty.");
        }
        return (E) this.content[this._size - 1];
    }

    public final int lastIndexOf(E e) {
        if (e == null) {
            Object[] objArr = this.content;
            for (int i2 = this._size - 1; -1 < i2; i2--) {
                if (objArr[i2] == null) {
                    return i2;
                }
            }
        } else {
            Object[] objArr2 = this.content;
            for (int i8 = this._size - 1; -1 < i8; i8--) {
                if (e.equals(objArr2[i8])) {
                    return i8;
                }
            }
        }
        return -1;
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.content[this._size - 1];
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(e6.l predicate) {
        k.e(predicate, "predicate");
        Object[] objArr = this.content;
        for (int i2 = this._size - 1; -1 < i2; i2--) {
            if (((Boolean) predicate.invoke(objArr[i2])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, C2300e4.i.f8403d, C2300e4.i.e, 0, null, new AnonymousClass1(this), 25, null);
    }

    private ObjectList(int i2) {
        this.content = i2 == 0 ? ObjectListKt.EmptyArray : new Object[i2];
    }

    public final boolean any(e6.l predicate) {
        k.e(predicate, "predicate");
        Object[] objArr = this.content;
        int i2 = this._size;
        for (int i8 = 0; i8 < i2; i8++) {
            if (((Boolean) predicate.invoke(objArr[i8])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int count(e6.l predicate) {
        k.e(predicate, "predicate");
        Object[] objArr = this.content;
        int i2 = this._size;
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            if (((Boolean) predicate.invoke(objArr[i9])).booleanValue()) {
                i8++;
            }
        }
        return i8;
    }

    public final E firstOrNull(e6.l predicate) {
        k.e(predicate, "predicate");
        Object[] objArr = this.content;
        int i2 = this._size;
        for (int i8 = 0; i8 < i2; i8++) {
            E e = (E) objArr[i8];
            if (((Boolean) predicate.invoke(e)).booleanValue()) {
                return e;
            }
        }
        return null;
    }

    public final String joinToString(CharSequence separator) {
        k.e(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, null, 62, null);
    }

    public final boolean containsAll(List<? extends E> elements) {
        k.e(elements, "elements");
        int size = elements.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!contains(elements.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, null, 60, null);
    }

    public final E lastOrNull(e6.l predicate) {
        E e;
        k.e(predicate, "predicate");
        Object[] objArr = this.content;
        int i2 = this._size;
        do {
            i2--;
            if (-1 >= i2) {
                return null;
            }
            e = (E) objArr[i2];
        } while (!((Boolean) predicate.invoke(e)).booleanValue());
        return e;
    }

    public final E first(e6.l predicate) {
        k.e(predicate, "predicate");
        Object[] objArr = this.content;
        int i2 = this._size;
        for (int i8 = 0; i8 < i2; i8++) {
            E e = (E) objArr[i8];
            if (((Boolean) predicate.invoke(e)).booleanValue()) {
                return e;
            }
        }
        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        k.e(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, null, 56, null);
    }

    public final boolean containsAll(Iterable<? extends E> elements) {
        k.e(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i2) {
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        k.e(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i2, null, null, 48, null);
    }

    public final E last(e6.l predicate) {
        E e;
        k.e(predicate, "predicate");
        Object[] objArr = this.content;
        int i2 = this._size;
        do {
            i2--;
            if (-1 < i2) {
                e = (E) objArr[i2];
            } else {
                throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
            }
        } while (!((Boolean) predicate.invoke(e)).booleanValue());
        return e;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated) {
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        k.e(postfix, "postfix");
        k.e(truncated, "truncated");
        return joinToString$default(this, separator, prefix, postfix, i2, truncated, null, 32, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(ObjectList<E> elements) {
        k.e(elements, "elements");
        Object[] objArr = elements.content;
        int i2 = elements._size;
        for (int i8 = 0; i8 < i2; i8++) {
            if (!contains(objArr[i8])) {
                return false;
            }
        }
        return true;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i2, CharSequence charSequence2, e6.l lVar) {
        k.e(separator, "separator");
        k.e(prefix, "prefix");
        StringBuilder sbQ = androidx.camera.core.processing.util.a.q(charSequence, "postfix", charSequence2, "truncated", prefix);
        Object[] objArr = this.content;
        int i8 = this._size;
        int i9 = 0;
        while (true) {
            if (i9 < i8) {
                Object obj = objArr[i9];
                if (i9 == i2) {
                    sbQ.append(charSequence2);
                    break;
                }
                if (i9 != 0) {
                    sbQ.append(separator);
                }
                if (lVar == null) {
                    sbQ.append(obj);
                } else {
                    sbQ.append((CharSequence) lVar.invoke(obj));
                }
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

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }
}
