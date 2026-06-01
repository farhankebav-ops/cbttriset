package i7;

import e2.s;
import e6.l;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f12041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f12042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f12043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f12044d;
    public final Map e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12045f;

    public d(Map class2ContextualFactory, Map polyBase2Serializers, Map polyBase2DefaultSerializerProvider, Map polyBase2NamedSerializers, Map polyBase2DefaultDeserializerProvider, boolean z2) {
        k.e(class2ContextualFactory, "class2ContextualFactory");
        k.e(polyBase2Serializers, "polyBase2Serializers");
        k.e(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        k.e(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        k.e(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        this.f12041a = class2ContextualFactory;
        this.f12042b = polyBase2Serializers;
        this.f12043c = polyBase2DefaultSerializerProvider;
        this.f12044d = polyBase2NamedSerializers;
        this.e = polyBase2DefaultDeserializerProvider;
        this.f12045f = z2;
    }

    @Override // i7.f
    public final void a(g gVar) {
        for (Map.Entry entry : this.f12041a.entrySet()) {
            l6.c cVar = (l6.c) entry.getKey();
            c cVar2 = (c) entry.getValue();
            if (cVar2 instanceof a) {
                k.c(cVar, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                b7.c cVar3 = ((a) cVar2).f12039a;
                k.c(cVar3, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                gVar.b(cVar, cVar3);
            } else {
                if (!(cVar2 instanceof b)) {
                    throw new s(3);
                }
                gVar.g(cVar, ((b) cVar2).f12040a);
            }
        }
        for (Map.Entry entry2 : this.f12042b.entrySet()) {
            l6.c cVar4 = (l6.c) entry2.getKey();
            for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                l6.c cVar5 = (l6.c) entry3.getKey();
                b7.c cVar6 = (b7.c) entry3.getValue();
                k.c(cVar4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                k.c(cVar5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                k.c(cVar6, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                gVar.h(cVar4, cVar5, cVar6);
            }
        }
        for (Map.Entry entry4 : this.f12043c.entrySet()) {
            l6.c cVar7 = (l6.c) entry4.getKey();
            l lVar = (l) entry4.getValue();
            k.c(cVar7, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            k.c(lVar, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"value\")] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>");
            d0.d(1, lVar);
            gVar.c(cVar7, lVar);
        }
        for (Map.Entry entry5 : this.e.entrySet()) {
            l6.c cVar8 = (l6.c) entry5.getKey();
            l lVar2 = (l) entry5.getValue();
            k.c(cVar8, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            k.c(lVar2, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"className\")] kotlin.String?, kotlinx.serialization.DeserializationStrategy<kotlin.Any>?>");
            d0.d(1, lVar2);
            gVar.f(cVar8, lVar2);
        }
    }

    @Override // i7.f
    public final b7.c b(l6.c cVar, List typeArgumentsSerializers) {
        k.e(typeArgumentsSerializers, "typeArgumentsSerializers");
        c cVar2 = (c) this.f12041a.get(cVar);
        b7.c cVarA = cVar2 != null ? cVar2.a(typeArgumentsSerializers) : null;
        if (cVarA instanceof b7.c) {
            return cVarA;
        }
        return null;
    }
}
