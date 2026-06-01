package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.AdSize;

/* JADX INFO: renamed from: com.ironsource.e3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2299e3 implements InterfaceC2457mg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Db f8272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdSize f8273b;

    /* JADX INFO: renamed from: com.ironsource.e3$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8274a = new a();

        public a() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C2668z5.f10625a.a("Load task config is null");
        }
    }

    /* JADX INFO: renamed from: com.ironsource.e3$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8275a = new b();

        public b() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IronSourceError invoke() {
            return C2668z5.f10625a.l();
        }
    }

    public C2299e3(Db db, AdSize adSize) {
        this.f8272a = db;
        this.f8273b = adSize;
    }

    @Override // com.ironsource.InterfaceC2457mg
    public final /* synthetic */ void a(boolean z2, e6.a aVar) {
        ni.a(this, z2, aVar);
    }

    @Override // com.ironsource.InterfaceC2457mg
    public void a() {
        ni.a(this, this.f8272a != null, a.f8274a);
        ni.a(this, this.f8273b != null, b.f8275a);
    }
}
