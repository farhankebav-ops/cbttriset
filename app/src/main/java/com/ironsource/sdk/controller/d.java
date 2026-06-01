package com.ironsource.sdk.controller;

import com.ironsource.A8;
import com.ironsource.C2300e4;
import com.ironsource.C2328fe;
import com.ironsource.C2390j5;
import com.ironsource.C2531r4;
import com.ironsource.C2603v8;
import com.ironsource.C8;
import com.ironsource.G5;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class d {
    static final String h = "controllerSourceData";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f9886i = "next_";
    private static final String j = "fallback_";
    private static final String k = "controllerSourceCode";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f9889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EnumC0195d f9890d = EnumC0195d.NONE;
    private String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f9891f;
    private C2390j5 g;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends JSONObject {
        public a() throws JSONException {
            putOpt(C2300e4.a.j, Integer.valueOf(d.this.f9888b));
            putOpt(d.k, Integer.valueOf(d.this.f9890d.b()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9893a;

        static {
            int[] iArr = new int[c.values().length];
            f9893a = iArr;
            try {
                iArr[c.FETCH_FROM_SERVER_NO_FALLBACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9893a[c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9893a[c.FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum c {
        FETCH_FROM_SERVER_NO_FALLBACK,
        FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK,
        FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL
    }

    /* JADX INFO: renamed from: com.ironsource.sdk.controller.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum EnumC0195d {
        NONE(0),
        PREPARED_CONTROLLER_LOADED(1),
        CONTROLLER_FROM_SERVER(2),
        MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(3),
        FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(4),
        FALLBACK_CONTROLLER_RECOVERY(5);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9902a;

        EnumC0195d(int i2) {
            this.f9902a = i2;
        }

        public int b() {
            return this.f9902a;
        }
    }

    public d(JSONObject jSONObject, String str, String str2, C2390j5 c2390j5) {
        int iOptInt = jSONObject.optInt(C2300e4.a.j, -1);
        this.f9888b = iOptInt;
        this.f9889c = a(iOptInt);
        this.e = str;
        this.f9891f = str2;
        this.g = c2390j5;
    }

    private void c() {
        try {
            C8 c8G = g();
            if (c8G.exists()) {
                C8 c8H = h();
                if (c8H.exists()) {
                    c8H.delete();
                }
                IronSourceStorageUtils.renameFile(c8G.getPath(), c8H.getPath());
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
        }
    }

    private void d() {
        IronSourceStorageUtils.deleteFile(h());
    }

    private void e() {
        IronSourceStorageUtils.deleteFile(g());
    }

    private C8 h() {
        return new C8(this.e, "fallback_mobileController.html");
    }

    private C8 i() {
        return new C8(this.e, "next_mobileController.html");
    }

    private boolean j() {
        return h().exists();
    }

    private void l() {
        C2603v8 c2603v8A = new C2603v8().a(G5.y, Integer.valueOf(this.f9888b));
        if (this.f9887a > 0) {
            c2603v8A.a(G5.B, Long.valueOf(System.currentTimeMillis() - this.f9887a));
        }
        A8.a(C2328fe.f8548x, c2603v8A.a());
    }

    public JSONObject f() throws JSONException {
        return new a();
    }

    public C8 g() {
        return new C8(this.e, C2300e4.f8280f);
    }

    public boolean k() {
        int i2 = b.f9893a[this.f9889c.ordinal()];
        if (i2 == 1) {
            e();
            a(new C8(this.e, SDKUtils.getFileName(this.f9891f)));
            return false;
        }
        if (i2 == 2) {
            c();
            a(new C8(this.e, SDKUtils.getFileName(this.f9891f)));
            return false;
        }
        if (i2 == 3) {
            try {
                C8 c8G = g();
                C8 c8I = i();
                if (!c8I.exists() && !c8G.exists()) {
                    a(new C8(this.e, SDKUtils.getFileName(this.f9891f)));
                    return false;
                }
                if (!c8I.exists() && c8G.exists()) {
                    EnumC0195d enumC0195d = EnumC0195d.MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                    this.f9890d = enumC0195d;
                    a(enumC0195d);
                    a(new C8(this.e, c8I.getName()));
                    return true;
                }
                c();
                if (b()) {
                    EnumC0195d enumC0195d2 = EnumC0195d.PREPARED_CONTROLLER_LOADED;
                    this.f9890d = enumC0195d2;
                    a(enumC0195d2);
                    d();
                    a(new C8(this.e, c8I.getName()));
                    return true;
                }
                if (!a()) {
                    a(new C8(this.e, SDKUtils.getFileName(this.f9891f)));
                    return false;
                }
                EnumC0195d enumC0195d3 = EnumC0195d.FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                this.f9890d = enumC0195d3;
                a(enumC0195d3);
                a(new C8(this.e, c8I.getName()));
                return true;
            } catch (Exception e) {
                C2531r4.d().a(e);
            }
        }
        return false;
    }

    public boolean m() {
        return this.f9890d != EnumC0195d.NONE;
    }

    private c a(int i2) {
        return i2 != 1 ? i2 != 2 ? c.FETCH_FROM_SERVER_NO_FALLBACK : c.FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL : c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK;
    }

    private boolean b() throws Exception {
        return IronSourceStorageUtils.renameFile(i().getPath(), g().getPath());
    }

    public void a(Runnable runnable) {
        if (m()) {
            return;
        }
        if (this.f9889c == c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK) {
            d();
        }
        EnumC0195d enumC0195d = EnumC0195d.CONTROLLER_FROM_SERVER;
        this.f9890d = enumC0195d;
        a(enumC0195d);
        runnable.run();
    }

    public void a(Runnable runnable, Runnable runnable2) {
        if (m()) {
            return;
        }
        if (this.f9889c == c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK && a()) {
            EnumC0195d enumC0195d = EnumC0195d.FALLBACK_CONTROLLER_RECOVERY;
            this.f9890d = enumC0195d;
            a(enumC0195d);
            runnable.run();
            return;
        }
        l();
        runnable2.run();
    }

    private void a(C8 c8) {
        if (this.g.c()) {
            return;
        }
        this.g.a(c8, this.f9891f);
    }

    public void a(C2603v8 c2603v8) {
        c2603v8.a(G5.y, Integer.valueOf(this.f9888b));
        A8.a(C2328fe.f8546v, c2603v8.a());
        this.f9887a = System.currentTimeMillis();
    }

    private void a(EnumC0195d enumC0195d) {
        C2603v8 c2603v8A = new C2603v8().a(G5.y, Integer.valueOf(this.f9888b)).a(G5.f6818z, Integer.valueOf(enumC0195d.b()));
        if (this.f9887a > 0) {
            c2603v8A.a(G5.B, Long.valueOf(System.currentTimeMillis() - this.f9887a));
        }
        A8.a(C2328fe.f8547w, c2603v8A.a());
    }

    private boolean a() {
        try {
            if (j()) {
                return IronSourceStorageUtils.renameFile(h().getPath(), g().getPath());
            }
            return false;
        } catch (Exception e) {
            C2531r4.d().a(e);
            return false;
        }
    }
}
