package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import com.ironsource.C2569t8;
import com.ironsource.InterfaceC2616w4;
import com.ironsource.InterfaceC2633x4;
import com.ironsource.InterfaceC2650y4;
import com.ironsource.Ob;
import com.ironsource.Y4;
import com.ironsource.sdk.controller.f;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface l {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        void a(f.a aVar);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface b {
        void a(Ob ob);
    }

    void a();

    void a(Activity activity);

    void a(Context context);

    void a(Y4 y42);

    void a(Y4 y42, Map<String, String> map, InterfaceC2616w4 interfaceC2616w4);

    void a(Y4 y42, Map<String, String> map, InterfaceC2633x4 interfaceC2633x4);

    void a(f.c cVar, a aVar);

    void a(String str, InterfaceC2633x4 interfaceC2633x4);

    void a(String str, String str2, Y4 y42, InterfaceC2616w4 interfaceC2616w4);

    void a(String str, String str2, Y4 y42, InterfaceC2633x4 interfaceC2633x4);

    void a(String str, String str2, Y4 y42, InterfaceC2650y4 interfaceC2650y4);

    void a(JSONObject jSONObject);

    void a(JSONObject jSONObject, InterfaceC2616w4 interfaceC2616w4);

    void a(JSONObject jSONObject, InterfaceC2633x4 interfaceC2633x4);

    void a(JSONObject jSONObject, InterfaceC2650y4 interfaceC2650y4);

    boolean a(String str);

    void b();

    void b(Context context);

    void b(Y4 y42);

    void b(Y4 y42, Map<String, String> map, InterfaceC2633x4 interfaceC2633x4);

    void b(JSONObject jSONObject);

    void e();

    @Deprecated
    void f();

    void g();

    C2569t8.c h();
}
