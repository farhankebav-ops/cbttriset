package androidx.collection;

import a1.a;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ObjectListKt {
    private static final Object[] EmptyArray = new Object[0];
    private static final ObjectList<Object> EmptyObjectList = new MutableObjectList(0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIndex(List<?> list, int i2) {
        int size = list.size();
        if (i2 < 0 || i2 >= size) {
            throw new IndexOutOfBoundsException("Index " + i2 + " is out of bounds. The list has " + size + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSubIndex(List<?> list, int i2, int i8) {
        int size = list.size();
        if (i2 > i8) {
            throw new IllegalArgumentException("Indices are out of order. fromIndex (" + i2 + ") is greater than toIndex (" + i8 + ").");
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(a.h(i2, "fromIndex (", ") is less than 0."));
        }
        if (i8 <= size) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i8 + ") is more than than the list size (" + size + ')');
    }

    public static final <E> ObjectList<E> emptyObjectList() {
        ObjectList<E> objectList = (ObjectList<E>) EmptyObjectList;
        k.c(objectList, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.emptyObjectList>");
        return objectList;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf() {
        return new MutableObjectList<>(0, 1, null);
    }

    public static final <E> ObjectList<E> objectListOf() {
        ObjectList<E> objectList = (ObjectList<E>) EmptyObjectList;
        k.c(objectList, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.objectListOf>");
        return objectList;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E e) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(1);
        mutableObjectList.add(e);
        return mutableObjectList;
    }

    public static final <E> ObjectList<E> objectListOf(E e) {
        return mutableObjectListOf(e);
    }

    public static final <E> ObjectList<E> objectListOf(E e, E e4) {
        return mutableObjectListOf(e, e4);
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E e, E e4) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(2);
        mutableObjectList.add(e);
        mutableObjectList.add(e4);
        return mutableObjectList;
    }

    public static final <E> ObjectList<E> objectListOf(E e, E e4, E e8) {
        return mutableObjectListOf(e, e4, e8);
    }

    public static final <E> ObjectList<E> objectListOf(E... elements) {
        k.e(elements, "elements");
        MutableObjectList mutableObjectList = new MutableObjectList(elements.length);
        mutableObjectList.plusAssign((Object[]) elements);
        return mutableObjectList;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E e, E e4, E e8) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(3);
        mutableObjectList.add(e);
        mutableObjectList.add(e4);
        mutableObjectList.add(e8);
        return mutableObjectList;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E... elements) {
        k.e(elements, "elements");
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(elements.length);
        mutableObjectList.plusAssign((Object[]) elements);
        return mutableObjectList;
    }
}
