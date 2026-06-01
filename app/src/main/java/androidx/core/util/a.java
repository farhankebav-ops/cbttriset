package androidx.core.util;

import androidx.core.content.IntentSanitizer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Predicate f3966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3967c;

    public /* synthetic */ a(Predicate predicate, Predicate predicate2, int i2) {
        this.f3965a = i2;
        this.f3966b = predicate;
        this.f3967c = predicate2;
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i2 = this.f3965a;
        return c.a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate negate() {
        switch (this.f3965a) {
        }
        return c.b(this);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        int i2 = this.f3965a;
        return c.c(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f3965a) {
            case 0:
                return c.f(this.f3966b, (Predicate) this.f3967c, obj);
            case 1:
                return c.d(this.f3966b, (Predicate) this.f3967c, obj);
            default:
                return IntentSanitizer.Builder.lambda$allowExtra$13((Class) this.f3967c, this.f3966b, obj);
        }
    }

    public /* synthetic */ a(Class cls, Predicate predicate) {
        this.f3965a = 2;
        this.f3967c = cls;
        this.f3966b = predicate;
    }
}
