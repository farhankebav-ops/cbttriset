package com.vungle.ads.internal;

import g7.c;
import g7.h;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ConfigManager$json$2 extends l implements e6.a {
    public static final ConfigManager$json$2 INSTANCE = new ConfigManager$json$2();

    /* JADX INFO: renamed from: com.vungle.ads.internal.ConfigManager$json$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((h) obj);
            return x.f13520a;
        }

        public final void invoke(h Json) {
            k.e(Json, "$this$Json");
            Json.f11611c = true;
            Json.f11609a = true;
            Json.f11610b = false;
        }
    }

    public ConfigManager$json$2() {
        super(0);
    }

    @Override // e6.a
    public final c invoke() {
        return a.a.b(AnonymousClass1.INSTANCE);
    }
}
