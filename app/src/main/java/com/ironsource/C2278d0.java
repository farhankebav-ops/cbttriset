package com.ironsource;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.d0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2278d0 implements InterfaceC2296e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8171b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8172c = "ext_";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f8173a = new HashMap();

    /* JADX INFO: renamed from: com.ironsource.d0$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }

    @Override // com.ironsource.InterfaceC2296e0
    public Map<String, String> a() {
        return this.f8173a;
    }

    @Override // com.ironsource.InterfaceC2296e0
    public void b(String key, String value) {
        kotlin.jvm.internal.k.e(key, "key");
        kotlin.jvm.internal.k.e(value, "value");
        this.f8173a.put("ext_".concat(key), value);
    }

    @Override // com.ironsource.InterfaceC2296e0
    public void a(HashMap<String, String> params) {
        kotlin.jvm.internal.k.e(params, "params");
        this.f8173a.putAll(params);
    }

    @Override // com.ironsource.InterfaceC2296e0
    public void a(String key, String value) {
        kotlin.jvm.internal.k.e(key, "key");
        kotlin.jvm.internal.k.e(value, "value");
        this.f8173a.put(key, value);
    }
}
