package i7;

import e6.l;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f12040a;

    public b(l lVar) {
        this.f12040a = lVar;
    }

    @Override // i7.c
    public final b7.c a(List typeArgumentsSerializers) {
        k.e(typeArgumentsSerializers, "typeArgumentsSerializers");
        return (b7.c) this.f12040a.invoke(typeArgumentsSerializers);
    }
}
