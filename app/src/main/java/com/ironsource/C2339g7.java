package com.ironsource;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.ironsource.g7, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2339g7 {

    /* JADX INFO: renamed from: com.ironsource.g7$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements h6.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<T> f8593a;

        public a(T t3) {
            this.f8593a = new WeakReference<>(t3);
        }

        public final WeakReference<T> a() {
            return this.f8593a;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [T, java.lang.Object] */
        @Override // h6.a
        public T getValue(Object thisRef, l6.q property) {
            kotlin.jvm.internal.k.e(thisRef, "thisRef");
            kotlin.jvm.internal.k.e(property, "property");
            return this.f8593a.get();
        }

        public void setValue(Object thisRef, l6.q property, T t3) {
            kotlin.jvm.internal.k.e(thisRef, "thisRef");
            kotlin.jvm.internal.k.e(property, "property");
            this.f8593a = new WeakReference<>(t3);
        }

        public final void a(WeakReference<T> weakReference) {
            kotlin.jvm.internal.k.e(weakReference, "<set-?>");
            this.f8593a = weakReference;
        }
    }

    public static /* synthetic */ h6.b a(Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }

    public static final <T> h6.b a(T t3) {
        return new a(t3);
    }
}
