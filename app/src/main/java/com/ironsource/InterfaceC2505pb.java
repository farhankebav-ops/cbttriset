package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: renamed from: com.ironsource.pb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface InterfaceC2505pb<T> {

    /* JADX INFO: renamed from: com.ironsource.pb$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a<T> implements InterfaceC2505pb<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IronSourceError f9657a;

        public a(IronSourceError error) {
            kotlin.jvm.internal.k.e(error, "error");
            this.f9657a = error;
        }

        public final IronSourceError a() {
            return this.f9657a;
        }

        public final IronSourceError b() {
            return this.f9657a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && kotlin.jvm.internal.k.a(this.f9657a, ((a) obj).f9657a);
        }

        public int hashCode() {
            return this.f9657a.hashCode();
        }

        public String toString() {
            return "Failure(error=" + this.f9657a + ")";
        }

        public final a<T> a(IronSourceError error) {
            kotlin.jvm.internal.k.e(error, "error");
            return new a<>(error);
        }

        public static /* synthetic */ a a(a aVar, IronSourceError ironSourceError, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                ironSourceError = aVar.f9657a;
            }
            return aVar.a(ironSourceError);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.pb$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b<T> implements InterfaceC2505pb<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f9658a;

        public b(T t3) {
            this.f9658a = t3;
        }

        public final T a() {
            return this.f9658a;
        }

        public final T b() {
            return this.f9658a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && kotlin.jvm.internal.k.a(this.f9658a, ((b) obj).f9658a);
        }

        public int hashCode() {
            T t3 = this.f9658a;
            if (t3 == null) {
                return 0;
            }
            return t3.hashCode();
        }

        public String toString() {
            return "Success(value=" + this.f9658a + ")";
        }

        public final b<T> a(T t3) {
            return new b<>(t3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ b a(b bVar, Object obj, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                obj = bVar.f9658a;
            }
            return bVar.a(obj);
        }
    }
}
