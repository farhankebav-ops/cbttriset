package f7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0 f11432c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b7.c eSerializer, int i2) {
        super(eSerializer);
        this.f11431b = i2;
        switch (i2) {
            case 1:
                kotlin.jvm.internal.k.e(eSerializer, "eSerializer");
                super(eSerializer);
                d7.g elementDesc = eSerializer.getDescriptor();
                kotlin.jvm.internal.k.e(elementDesc, "elementDesc");
                this.f11432c = new c(elementDesc, 2);
                break;
            case 2:
                kotlin.jvm.internal.k.e(eSerializer, "eSerializer");
                super(eSerializer);
                d7.g elementDesc2 = eSerializer.getDescriptor();
                kotlin.jvm.internal.k.e(elementDesc2, "elementDesc");
                this.f11432c = new c(elementDesc2, 3);
                break;
            default:
                kotlin.jvm.internal.k.e(eSerializer, "element");
                d7.g elementDesc3 = eSerializer.getDescriptor();
                kotlin.jvm.internal.k.e(elementDesc3, "elementDesc");
                this.f11432c = new c(elementDesc3, 1);
                break;
        }
    }

    @Override // f7.a
    public final Object a() {
        switch (this.f11431b) {
            case 0:
                return new ArrayList();
            case 1:
                return new HashSet();
            default:
                return new LinkedHashSet();
        }
    }

    @Override // f7.a
    public final int b(Object obj) {
        switch (this.f11431b) {
            case 0:
                ArrayList arrayList = (ArrayList) obj;
                kotlin.jvm.internal.k.e(arrayList, "<this>");
                return arrayList.size();
            case 1:
                HashSet hashSet = (HashSet) obj;
                kotlin.jvm.internal.k.e(hashSet, "<this>");
                return hashSet.size();
            default:
                LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
                kotlin.jvm.internal.k.e(linkedHashSet, "<this>");
                return linkedHashSet.size();
        }
    }

    @Override // f7.a
    public final void c(int i2, Object obj) {
        switch (this.f11431b) {
            case 0:
                ArrayList arrayList = (ArrayList) obj;
                kotlin.jvm.internal.k.e(arrayList, "<this>");
                arrayList.ensureCapacity(i2);
                break;
            case 1:
                kotlin.jvm.internal.k.e((HashSet) obj, "<this>");
                break;
            default:
                kotlin.jvm.internal.k.e((LinkedHashSet) obj, "<this>");
                break;
        }
    }

    @Override // f7.a
    public final Iterator d(Object obj) {
        Collection collection = (Collection) obj;
        kotlin.jvm.internal.k.e(collection, "<this>");
        return collection.iterator();
    }

    @Override // f7.a
    public final int e(Object obj) {
        Collection collection = (Collection) obj;
        kotlin.jvm.internal.k.e(collection, "<this>");
        return collection.size();
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        switch (this.f11431b) {
        }
        return (c) this.f11432c;
    }

    @Override // f7.a
    public final Object i(Object obj) {
        switch (this.f11431b) {
            case 0:
                kotlin.jvm.internal.k.e(null, "<this>");
                return new ArrayList((Collection) null);
            case 1:
                kotlin.jvm.internal.k.e(null, "<this>");
                return new HashSet((Collection) null);
            default:
                kotlin.jvm.internal.k.e(null, "<this>");
                return new LinkedHashSet((Collection) null);
        }
    }

    @Override // f7.a
    public final Object j(Object obj) {
        switch (this.f11431b) {
            case 0:
                ArrayList arrayList = (ArrayList) obj;
                kotlin.jvm.internal.k.e(arrayList, "<this>");
                return arrayList;
            case 1:
                HashSet hashSet = (HashSet) obj;
                kotlin.jvm.internal.k.e(hashSet, "<this>");
                return hashSet;
            default:
                LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
                kotlin.jvm.internal.k.e(linkedHashSet, "<this>");
                return linkedHashSet;
        }
    }

    @Override // f7.r
    public final void k(int i2, Object obj, Object obj2) {
        switch (this.f11431b) {
            case 0:
                ArrayList arrayList = (ArrayList) obj;
                kotlin.jvm.internal.k.e(arrayList, "<this>");
                arrayList.add(i2, obj2);
                break;
            case 1:
                HashSet hashSet = (HashSet) obj;
                kotlin.jvm.internal.k.e(hashSet, "<this>");
                hashSet.add(obj2);
                break;
            default:
                LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
                kotlin.jvm.internal.k.e(linkedHashSet, "<this>");
                linkedHashSet.add(obj2);
                break;
        }
    }
}
