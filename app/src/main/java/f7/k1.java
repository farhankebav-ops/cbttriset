package f7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k1 extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l6.c f11476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f11477c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k1(l6.c cVar, b7.c eSerializer) {
        super(eSerializer);
        kotlin.jvm.internal.k.e(eSerializer, "eSerializer");
        this.f11476b = cVar;
        d7.g elementDesc = eSerializer.getDescriptor();
        kotlin.jvm.internal.k.e(elementDesc, "elementDesc");
        this.f11477c = new c(elementDesc, 0);
    }

    @Override // f7.a
    public final Object a() {
        return new ArrayList();
    }

    @Override // f7.a
    public final int b(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        kotlin.jvm.internal.k.e(arrayList, "<this>");
        return arrayList.size();
    }

    @Override // f7.a
    public final void c(int i2, Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        kotlin.jvm.internal.k.e(arrayList, "<this>");
        arrayList.ensureCapacity(i2);
    }

    @Override // f7.a
    public final Iterator d(Object obj) {
        Object[] objArr = (Object[]) obj;
        kotlin.jvm.internal.k.e(objArr, "<this>");
        return kotlin.jvm.internal.d0.g(objArr);
    }

    @Override // f7.a
    public final int e(Object obj) {
        Object[] objArr = (Object[]) obj;
        kotlin.jvm.internal.k.e(objArr, "<this>");
        return objArr.length;
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return this.f11477c;
    }

    @Override // f7.a
    public final Object i(Object obj) {
        kotlin.jvm.internal.k.e(null, "<this>");
        r5.j.X(null);
        throw null;
    }

    @Override // f7.a
    public final Object j(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        kotlin.jvm.internal.k.e(arrayList, "<this>");
        l6.c eClass = this.f11476b;
        kotlin.jvm.internal.k.e(eClass, "eClass");
        Object objNewInstance = Array.newInstance((Class<?>) a.a.B(eClass), arrayList.size());
        kotlin.jvm.internal.k.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        Object[] array = arrayList.toArray((Object[]) objNewInstance);
        kotlin.jvm.internal.k.d(array, "toArray(...)");
        return array;
    }

    @Override // f7.r
    public final void k(int i2, Object obj, Object obj2) {
        ArrayList arrayList = (ArrayList) obj;
        kotlin.jvm.internal.k.e(arrayList, "<this>");
        arrayList.add(i2, obj2);
    }
}
