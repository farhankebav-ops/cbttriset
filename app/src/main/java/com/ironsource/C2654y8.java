package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.y8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2654y8 implements InterfaceC2518q7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Object> f10554a = new HashMap();

    /* JADX INFO: renamed from: com.ironsource.y8$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f10555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f10556b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f10557c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Context f10558d;
        String e;

        public a a(String str) {
            this.f10556b = str;
            return this;
        }

        public a b(String str) {
            this.f10557c = str;
            return this;
        }

        public a c(String str) {
            this.f10555a = str;
            return this;
        }

        public a d(String str) {
            this.e = str;
            return this;
        }

        public a a(Context context) {
            this.f10558d = context;
            return this;
        }

        public C2654y8 a() {
            return new C2654y8(this, 0);
        }
    }

    public /* synthetic */ C2654y8(a aVar, int i2) {
        this(aVar);
    }

    private void a(Context context) {
        f10554a.put(G5.e, C2246b4.b(context));
        f10554a.put(G5.f6806f, C2246b4.d(context));
    }

    public static void b(String str) {
        f10554a.put(G5.f6806f, SDKUtils.encodeString(str));
    }

    private C2654y8(a aVar) {
        a(aVar);
        a(aVar.f10558d);
    }

    private void a(a aVar) {
        Context context = aVar.f10558d;
        C2265c5 c2265c5B = C2265c5.b(context);
        f10554a.put(G5.j, SDKUtils.encodeString(c2265c5B.e()));
        f10554a.put(G5.k, SDKUtils.encodeString(c2265c5B.f()));
        f10554a.put(G5.l, Integer.valueOf(c2265c5B.a()));
        f10554a.put(G5.m, SDKUtils.encodeString(c2265c5B.d()));
        f10554a.put(G5.f6808n, SDKUtils.encodeString(c2265c5B.c()));
        f10554a.put(G5.f6805d, SDKUtils.encodeString(context.getPackageName()));
        f10554a.put(G5.g, SDKUtils.encodeString(aVar.f10556b));
        f10554a.put("sessionid", SDKUtils.encodeString(aVar.f10555a));
        f10554a.put(G5.f6803b, SDKUtils.encodeString(SDKUtils.getSDKVersion()));
        f10554a.put(G5.f6809o, G5.f6813t);
        f10554a.put("origin", "n");
        if (TextUtils.isEmpty(aVar.e)) {
            return;
        }
        f10554a.put(G5.f6807i, SDKUtils.encodeString(aVar.e));
    }

    @Override // com.ironsource.InterfaceC2518q7
    public Map<String, Object> a() {
        return f10554a;
    }

    public static void a(String str) {
        f10554a.put(G5.e, SDKUtils.encodeString(str));
    }
}
