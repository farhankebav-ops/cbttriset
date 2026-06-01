package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import androidx.gridlayout.widget.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class FreezableUtils {
    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull ArrayList<E> arrayList) {
        GridLayout.Assoc assoc = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            assoc.add(arrayList.get(i2).freeze());
        }
        return assoc;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(@NonNull Iterable<E> iterable) {
        GridLayout.Assoc assoc = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            assoc.add(it.next().freeze());
        }
        return assoc;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull E[] eArr) {
        GridLayout.Assoc assoc = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            assoc.add(e.freeze());
        }
        return assoc;
    }
}
