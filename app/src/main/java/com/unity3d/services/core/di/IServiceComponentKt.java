package com.unity3d.services.core.di;

import e6.a;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.f;
import q5.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class IServiceComponentKt {

    /* JADX INFO: renamed from: com.unity3d.services.core.di.IServiceComponentKt$inject$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements a {
        final /* synthetic */ String $named;
        final /* synthetic */ IServiceComponent $this_inject;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(IServiceComponent iServiceComponent, String str) {
            super(0);
            this.$this_inject = iServiceComponent;
            this.$named = str;
        }

        @Override // e6.a
        public final T invoke() {
            this.$this_inject.getServiceProvider().getRegistry();
            k.k();
            throw null;
        }
    }

    public static final <T> T get(IServiceComponent iServiceComponent, String named) {
        k.e(iServiceComponent, "<this>");
        k.e(named, "named");
        iServiceComponent.getServiceProvider().getRegistry();
        k.k();
        throw null;
    }

    public static Object get$default(IServiceComponent iServiceComponent, String named, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            named = "";
        }
        k.e(iServiceComponent, "<this>");
        k.e(named, "named");
        iServiceComponent.getServiceProvider().getRegistry();
        k.k();
        throw null;
    }

    public static final <T> f inject(IServiceComponent iServiceComponent, String named, g mode) {
        k.e(iServiceComponent, "<this>");
        k.e(named, "named");
        k.e(mode, "mode");
        k.k();
        throw null;
    }

    public static f inject$default(IServiceComponent iServiceComponent, String named, g mode, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            named = "";
        }
        if ((i2 & 2) != 0) {
            mode = g.f13496c;
        }
        k.e(iServiceComponent, "<this>");
        k.e(named, "named");
        k.e(mode, "mode");
        k.k();
        throw null;
    }
}
