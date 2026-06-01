package h7;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class x extends x5.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q5.b f11779f;
    public com.unity3d.scar.adapter.common.a g;
    public LinkedHashMap h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f11780i;
    public /* synthetic */ Object j;
    public final /* synthetic */ com.unity3d.scar.adapter.common.a k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(com.unity3d.scar.adapter.common.a aVar, x5.a aVar2) {
        super(aVar2);
        this.k = aVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.j = obj;
        this.l |= Integer.MIN_VALUE;
        return com.unity3d.scar.adapter.common.a.a(this.k, null, this);
    }
}
