package com.ironsource;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class sg extends AbstractC2345gd {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10227f = new a(null);
    private static final String g = "ViewVisibilityTrigger";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f10228d;
    private final ug e;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements Rc {
        public b() {
        }

        @Override // com.ironsource.Rc
        public void a(boolean z2) {
            sg.this.a(!z2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sg(View view) {
        super(false, 1, null);
        kotlin.jvm.internal.k.e(view, "view");
        b bVar = new b();
        this.f10228d = bVar;
        ug ugVar = new ug(bVar);
        this.e = ugVar;
        ugVar.a(view);
        a(!ugVar.c());
    }

    @Override // com.ironsource.AbstractC2345gd
    public String b() {
        return g;
    }

    public final void e() {
        this.e.b();
    }
}
