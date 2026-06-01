package androidx.core.util;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class c {
    public static Predicate a(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new a(predicate, predicate2, 1);
    }

    public static Predicate b(Predicate predicate) {
        return new b(predicate, 1);
    }

    public static Predicate c(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new a(predicate, predicate2, 0);
    }

    public static /* synthetic */ boolean d(Predicate predicate, Predicate predicate2, Object obj) {
        return predicate.test(obj) && predicate2.test(obj);
    }

    public static /* synthetic */ boolean e(Predicate predicate, Object obj) {
        return !predicate.test(obj);
    }

    public static /* synthetic */ boolean f(Predicate predicate, Predicate predicate2, Object obj) {
        return predicate.test(obj) || predicate2.test(obj);
    }

    public static Predicate g(Object obj) {
        return obj == null ? new androidx.core.content.c(11) : new b(obj, 0);
    }

    public static /* synthetic */ boolean h(Object obj) {
        return obj == null;
    }

    public static Predicate j(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }
}
