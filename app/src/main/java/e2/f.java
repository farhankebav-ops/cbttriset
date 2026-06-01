package e2;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements i7.g, x4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11230b;

    @Override // i7.g
    public void b(l6.c cVar, b7.c serializer) {
        kotlin.jvm.internal.k.e(serializer, "serializer");
    }

    @Override // i7.g
    public void g(l6.c kClass, e6.l lVar) {
        kotlin.jvm.internal.k.e(kClass, "kClass");
    }

    @Override // i7.g
    public void h(l6.c cVar, l6.c cVar2, b7.c cVar3) {
        d7.g descriptor = cVar3.getDescriptor();
        a.a kind = descriptor.getKind();
        if ((kind instanceof d7.d) || kotlin.jvm.internal.k.a(kind, d7.k.f11199b)) {
            throw new IllegalArgumentException("Serializer for " + ((kotlin.jvm.internal.e) cVar2).f() + " can't be registered as a subclass for polymorphic serialization because its kind " + kind + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if (kotlin.jvm.internal.k.a(kind, d7.m.f11202c) || kotlin.jvm.internal.k.a(kind, d7.m.f11203d) || (kind instanceof d7.f) || (kind instanceof d7.l)) {
            throw new IllegalArgumentException("Serializer for " + ((kotlin.jvm.internal.e) cVar2).f() + " of kind " + kind + " cannot be serialized polymorphically with class discriminator.");
        }
        int iD = descriptor.d();
        for (int i2 = 0; i2 < iD; i2++) {
            String strE = descriptor.e(i2);
            if (kotlin.jvm.internal.k.a(strE, this.f11230b)) {
                throw new IllegalArgumentException("Polymorphic serializer for " + cVar2 + " has property '" + strE + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
        }
    }

    @Override // x4.d
    public boolean test(Object obj) {
        String str = this.f11230b;
        if (obj != str) {
            return obj != null && obj.equals(str);
        }
        return true;
    }

    public String toString() {
        switch (this.f11229a) {
            case 3:
                return this.f11230b;
            case 4:
            default:
                return super.toString();
            case 5:
                return a1.a.e('>', this.f11230b, new StringBuilder("<"));
        }
    }

    public /* synthetic */ f(String str, int i2, boolean z2) {
        this.f11229a = i2;
        this.f11230b = str;
    }

    public f(String discriminator, int i2) {
        this.f11229a = i2;
        switch (i2) {
            case 1:
                kotlin.jvm.internal.k.e(discriminator, "discriminator");
                this.f11230b = discriminator;
                break;
            case 4:
                this.f11230b = a1.a.l("UnityScar", discriminator);
                break;
            default:
                discriminator.getClass();
                this.f11230b = discriminator;
                break;
        }
    }

    @Override // i7.g
    public void c(l6.c cVar, e6.l lVar) {
    }

    @Override // i7.g
    public void f(l6.c cVar, e6.l lVar) {
    }
}
