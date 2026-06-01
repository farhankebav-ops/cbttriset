package i7;

import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b7.c f12039a;

    public a(b7.c serializer) {
        k.e(serializer, "serializer");
        this.f12039a = serializer;
    }

    @Override // i7.c
    public final b7.c a(List typeArgumentsSerializers) {
        k.e(typeArgumentsSerializers, "typeArgumentsSerializers");
        return this.f12039a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && k.a(((a) obj).f12039a, this.f12039a);
    }

    public final int hashCode() {
        return this.f12039a.hashCode();
    }
}
