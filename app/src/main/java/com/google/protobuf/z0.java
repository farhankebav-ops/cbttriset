package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z0 {
    private static final z0 FULL_INSTANCE;
    private static final z0 LITE_INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends z0 {
        private static final Class<?> UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

        private a() {
            super();
        }

        public static <E> List<E> getList(Object obj, long j) {
            return (List) r2.getObject(obj, j);
        }

        @Override // com.google.protobuf.z0
        public void makeImmutableListAt(Object obj, long j) {
            Object objUnmodifiableList;
            List list = (List) r2.getObject(obj, j);
            if (list instanceof LazyStringList) {
                objUnmodifiableList = ((LazyStringList) list).getUnmodifiableView();
            } else {
                if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof w1) && (list instanceof Internal.ProtobufList)) {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            r2.putObject(obj, j, objUnmodifiableList);
        }

        @Override // com.google.protobuf.z0
        public <E> void mergeListsAt(Object obj, Object obj2, long j) {
            List list = getList(obj2, j);
            List listMutableListAt = mutableListAt(obj, j, list.size());
            int size = listMutableListAt.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                listMutableListAt.addAll(list);
            }
            if (size > 0) {
                list = listMutableListAt;
            }
            r2.putObject(obj, j, list);
        }

        @Override // com.google.protobuf.z0
        public <L> List<L> mutableListAt(Object obj, long j) {
            return mutableListAt(obj, j, 10);
        }

        private static <L> List<L> mutableListAt(Object obj, long j, int i2) {
            List<L> list = getList(obj, j);
            if (list.isEmpty()) {
                List<L> lazyStringArrayList = list instanceof LazyStringList ? new LazyStringArrayList(i2) : ((list instanceof w1) && (list instanceof Internal.ProtobufList)) ? ((Internal.ProtobufList) list).mutableCopyWithCapacity(i2) : new ArrayList<>(i2);
                r2.putObject(obj, j, lazyStringArrayList);
                return lazyStringArrayList;
            }
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                ArrayList arrayList = new ArrayList(list.size() + i2);
                arrayList.addAll(list);
                r2.putObject(obj, j, arrayList);
                return arrayList;
            }
            if (list instanceof UnmodifiableLazyStringList) {
                LazyStringArrayList lazyStringArrayList2 = new LazyStringArrayList(list.size() + i2);
                lazyStringArrayList2.addAll((UnmodifiableLazyStringList) list);
                r2.putObject(obj, j, lazyStringArrayList2);
                return lazyStringArrayList2;
            }
            if ((list instanceof w1) && (list instanceof Internal.ProtobufList)) {
                Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                if (!protobufList.isModifiable()) {
                    Internal.ProtobufList protobufListMutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(list.size() + i2);
                    r2.putObject(obj, j, protobufListMutableCopyWithCapacity);
                    return protobufListMutableCopyWithCapacity;
                }
            }
            return list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b extends z0 {
        private b() {
            super();
        }

        public static <E> Internal.ProtobufList<E> getProtobufList(Object obj, long j) {
            return (Internal.ProtobufList) r2.getObject(obj, j);
        }

        @Override // com.google.protobuf.z0
        public void makeImmutableListAt(Object obj, long j) {
            getProtobufList(obj, j).makeImmutable();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r6v1, types: [com.google.protobuf.Internal$ProtobufList, java.util.Collection, java.util.List] */
        /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v3 */
        @Override // com.google.protobuf.z0
        public <E> void mergeListsAt(Object obj, Object obj2, long j) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j);
            ?? protobufList2 = getProtobufList(obj2, j);
            int size = protobufList.size();
            int size2 = protobufList2.size();
            ?? r02 = protobufList;
            r02 = protobufList;
            if (size > 0 && size2 > 0) {
                boolean zIsModifiable = protobufList.isModifiable();
                ?? MutableCopyWithCapacity = protobufList;
                if (!zIsModifiable) {
                    MutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(size2 + size);
                }
                MutableCopyWithCapacity.addAll(protobufList2);
                r02 = MutableCopyWithCapacity;
            }
            if (size > 0) {
                protobufList2 = r02;
            }
            r2.putObject(obj, j, (Object) protobufList2);
        }

        @Override // com.google.protobuf.z0
        public <L> List<L> mutableListAt(Object obj, long j) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j);
            if (protobufList.isModifiable()) {
                return protobufList;
            }
            int size = protobufList.size();
            Internal.ProtobufList protobufListMutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            r2.putObject(obj, j, protobufListMutableCopyWithCapacity);
            return protobufListMutableCopyWithCapacity;
        }
    }

    static {
        FULL_INSTANCE = new a();
        LITE_INSTANCE = new b();
    }

    public static z0 full() {
        return FULL_INSTANCE;
    }

    public static z0 lite() {
        return LITE_INSTANCE;
    }

    public abstract void makeImmutableListAt(Object obj, long j);

    public abstract <L> void mergeListsAt(Object obj, Object obj2, long j);

    public abstract <L> List<L> mutableListAt(Object obj, long j);

    private z0() {
    }
}
