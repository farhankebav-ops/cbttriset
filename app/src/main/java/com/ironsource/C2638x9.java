package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: renamed from: com.ironsource.x9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2638x9 implements InterfaceC2457mg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Db f10499a;

    /* JADX INFO: renamed from: com.ironsource.x9$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10500a = new a();

        public a() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C2668z5.f10625a.b("Load task config is null");
        }
    }

    public C2638x9(Db db) {
        this.f10499a = db;
    }

    @Override // com.ironsource.InterfaceC2457mg
    public final /* synthetic */ void a(boolean z2, e6.a aVar) {
        ni.a(this, z2, aVar);
    }

    @Override // com.ironsource.InterfaceC2457mg
    public void a() {
        ni.a(this, this.f10499a != null, a.f10500a);
    }
}
