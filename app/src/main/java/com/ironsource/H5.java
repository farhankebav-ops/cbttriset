package com.ironsource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface H5<T> {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a<T> implements H5<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList<T> f6908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<T> f6909b;

        public a(ArrayList<T> a8, ArrayList<T> b8) {
            kotlin.jvm.internal.k.e(a8, "a");
            kotlin.jvm.internal.k.e(b8, "b");
            this.f6908a = a8;
            this.f6909b = b8;
        }

        @Override // com.ironsource.H5
        public boolean contains(T t3) {
            return this.f6908a.contains(t3) || this.f6909b.contains(t3);
        }

        @Override // com.ironsource.H5
        public int size() {
            return this.f6909b.size() + this.f6908a.size();
        }

        @Override // com.ironsource.H5
        public List<T> value() {
            return r5.l.f1(this.f6909b, this.f6908a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b<T> implements H5<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final H5<T> f6910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Comparator<T> f6911b;

        public b(H5<T> collection, Comparator<T> comparator) {
            kotlin.jvm.internal.k.e(collection, "collection");
            kotlin.jvm.internal.k.e(comparator, "comparator");
            this.f6910a = collection;
            this.f6911b = comparator;
        }

        @Override // com.ironsource.H5
        public boolean contains(T t3) {
            return this.f6910a.contains(t3);
        }

        @Override // com.ironsource.H5
        public int size() {
            return this.f6910a.size();
        }

        @Override // com.ironsource.H5
        public List<T> value() {
            return r5.l.j1(this.f6910a.value(), this.f6911b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c<T> implements H5<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<T> f6913b;

        public c(H5<T> collection, int i2) {
            kotlin.jvm.internal.k.e(collection, "collection");
            this.f6912a = i2;
            this.f6913b = collection.value();
        }

        public final List<T> a() {
            int size = this.f6913b.size();
            int i2 = this.f6912a;
            if (size <= i2) {
                return r5.r.f13638a;
            }
            List<T> list = this.f6913b;
            return list.subList(i2, list.size());
        }

        public final List<T> b() {
            List<T> list = this.f6913b;
            int size = list.size();
            int i2 = this.f6912a;
            if (size > i2) {
                size = i2;
            }
            return list.subList(0, size);
        }

        @Override // com.ironsource.H5
        public boolean contains(T t3) {
            return this.f6913b.contains(t3);
        }

        @Override // com.ironsource.H5
        public int size() {
            return this.f6913b.size();
        }

        @Override // com.ironsource.H5
        public List<T> value() {
            return this.f6913b;
        }
    }

    boolean contains(T t3);

    int size();

    List<T> value();
}
