package com.ironsource;

import android.util.Log;
import com.ironsource.InterfaceC2443m4;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.o4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2481o4 implements InterfaceC2636x7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2425l4 f9544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e6.l f9545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C7 f9546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceC2565t4 f9547d;
    private final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private C8 f9548f;
    private long g;
    private final C2309ed h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f9549i;

    /* JADX INFO: renamed from: com.ironsource.o4$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a extends kotlin.jvm.internal.j implements e6.l {
        public a(Object obj) {
            super(1, obj, C2481o4.class, "onHtmlDownloadFinished", "onHtmlDownloadFinished(Ljava/lang/Object;)V", 0);
        }

        public final void a(Object obj) {
            ((C2481o4) this.receiver).b(obj);
        }

        @Override // e6.l
        public /* synthetic */ Object invoke(Object obj) {
            a(((q5.k) obj).f13501a);
            return q5.x.f13520a;
        }
    }

    /* JADX INFO: renamed from: com.ironsource.o4$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class b extends kotlin.jvm.internal.j implements e6.l {
        public b(Object obj) {
            super(1, obj, C2481o4.class, "onAbTestDownloadFinished", "onAbTestDownloadFinished(Ljava/lang/Object;)V", 0);
        }

        public final void a(Object obj) throws JSONException {
            ((C2481o4) this.receiver).a(obj);
        }

        @Override // e6.l
        public /* synthetic */ Object invoke(Object obj) throws JSONException {
            a(((q5.k) obj).f13501a);
            return q5.x.f13520a;
        }
    }

    public C2481o4(C2425l4 config, e6.l onFinish, C7 downloadManager, InterfaceC2565t4 currentTimeProvider) {
        kotlin.jvm.internal.k.e(config, "config");
        kotlin.jvm.internal.k.e(onFinish, "onFinish");
        kotlin.jvm.internal.k.e(downloadManager, "downloadManager");
        kotlin.jvm.internal.k.e(currentTimeProvider, "currentTimeProvider");
        this.f9544a = config;
        this.f9545b = onFinish;
        this.f9546c = downloadManager;
        this.f9547d = currentTimeProvider;
        this.e = "o4";
        this.f9548f = new C8(config.d(), "mobileController_0.html");
        this.g = currentTimeProvider.a();
        this.h = new C2309ed(config.a());
        this.f9549i = "";
    }

    @Override // com.ironsource.InterfaceC2636x7
    public C8 c() {
        return this.f9548f;
    }

    public final e6.l d() {
        return this.f9545b;
    }

    public final InterfaceC2565t4 a() {
        return this.f9547d;
    }

    @Override // com.ironsource.InterfaceC2636x7
    public void b() {
        this.g = this.f9547d.a();
        ji.b(new C2259c(new C2277d(this.h), a1.a.C(this.f9544a.d(), "/temp"), this.f9546c, new b(this)));
    }

    @Override // com.ironsource.InterfaceC2636x7
    public boolean a(C8 file) {
        kotlin.jvm.internal.k.e(file, "file");
        String name = file.getName();
        kotlin.jvm.internal.k.d(name, "file.name");
        Pattern patternCompile = Pattern.compile("mobileController(_\\d+)?\\.html");
        kotlin.jvm.internal.k.d(patternCompile, "compile(...)");
        return patternCompile.matcher(name).matches();
    }

    private final C2463n4 a(String str) {
        return new C2463n4(new C2475ng(this.h, str), androidx.camera.core.processing.util.a.l(this.f9544a.d(), "/mobileController_", str, ".html"), this.f9546c, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Object obj) {
        boolean z2 = obj instanceof q5.j;
        if (!z2) {
            C8 c8 = (C8) (z2 ? null : obj);
            if (!kotlin.jvm.internal.k.a(c8 != null ? c8.getAbsolutePath() : null, this.f9548f.getAbsolutePath())) {
                try {
                    IronSourceStorageUtils.deleteFile(this.f9548f);
                    kotlin.jvm.internal.k.b(c8);
                    c6.k.b0(c8, this.f9548f);
                } catch (Exception e) {
                    C2531r4.d().a(e);
                    Log.e(this.e, "Unable to copy downloaded mobileController.html to cache folder: " + e.getMessage());
                }
                kotlin.jvm.internal.k.b(c8);
                this.f9548f = c8;
            }
            new InterfaceC2443m4.b(this.f9544a.b(), this.g, this.f9547d).a();
        } else {
            new InterfaceC2443m4.a(this.f9544a.b()).a();
        }
        e6.l lVar = this.f9545b;
        if (z2) {
            obj = null;
        }
        lVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Object obj) throws JSONException {
        if (obj instanceof q5.j) {
            obj = null;
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null && !kotlin.jvm.internal.k.a(jSONObject.optString("htmlBuildNumber"), "")) {
            SDKUtils.updateControllerConfig("abTestMap", jSONObject);
            String string = jSONObject.getString("htmlBuildNumber");
            kotlin.jvm.internal.k.d(string, "abTestMapAsJson.getString(\"htmlBuildNumber\")");
            this.f9549i = string;
            C2463n4 c2463n4A = a(string);
            c2463n4A.getClass();
            if (ji.a(c2463n4A)) {
                C8 c8K = c2463n4A.k();
                this.f9548f = c8K;
                this.f9545b.invoke(c8K);
                return;
            }
            ji.b(c2463n4A);
            return;
        }
        C2463n4 c2463n4A2 = a("0");
        c2463n4A2.getClass();
        ji.b(c2463n4A2);
    }
}
