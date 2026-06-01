package com.ironsource;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.ironsource.C2300e4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.k8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2411k8 extends FrameLayout implements K8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8847b = "IronSourceAdContainer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C2502p8 f8848a;

    /* JADX INFO: renamed from: com.ironsource.k8$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8850b;

        public a(String str, String str2) {
            this.f8849a = str;
            this.f8850b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2411k8 c2411k8 = C2411k8.this;
            c2411k8.removeView(c2411k8.f8848a.getPresentingView());
            C2411k8.this.f8848a.a(this.f8849a, this.f8850b);
            C2411k8.this.f8848a = null;
        }
    }

    public C2411k8(Context context) {
        super(context);
    }

    @Override // com.ironsource.K8
    public void c(JSONObject jSONObject, String str, String str2) throws JSONException {
        this.f8848a.c(jSONObject, str, str2);
    }

    @Override // com.ironsource.K8
    public WebView getPresentingView() {
        return this.f8848a.getPresentingView();
    }

    public C2376i8 getSize() {
        C2502p8 c2502p8 = this.f8848a;
        return c2502p8 != null ? c2502p8.c() : new C2376i8();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i2) {
        Logger.i(f8847b, "onVisibilityChanged: " + i2);
        C2502p8 c2502p8 = this.f8848a;
        if (c2502p8 == null) {
            return;
        }
        try {
            c2502p8.b().a(C2393j8.k, i2, isShown());
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Logger.i(f8847b, "onWindowVisibilityChanged: " + i2);
        C2502p8 c2502p8 = this.f8848a;
        if (c2502p8 == null) {
            return;
        }
        try {
            c2502p8.b().a(C2393j8.l, i2, isShown());
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public C2411k8(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void b() throws Exception {
        JSONObject jSONObject;
        try {
            jSONObject = this.f8848a.b().a().getJSONObject(C2393j8.p).getJSONObject(C2393j8.f8785s);
        } catch (Exception e) {
            C2531r4.d().a(e);
            jSONObject = new JSONObject();
        }
        jSONObject.put("adViewId", this.f8848a.a());
        this.f8848a.b().a(C2300e4.g.S, jSONObject);
    }

    public void a() throws Exception {
        C2502p8 c2502p8 = this.f8848a;
        if (c2502p8 == null || c2502p8.b() == null) {
            throw new Exception("mAdPresenter or mAdPresenter.getAdViewLogic() are null");
        }
        b();
    }

    public C2411k8(C2502p8 c2502p8, Context context) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(c2502p8.c().c(), c2502p8.c().a()));
        this.f8848a = c2502p8;
        addView(c2502p8.getPresentingView());
    }

    @Override // com.ironsource.K8
    public void a(JSONObject jSONObject, String str, String str2) {
        this.f8848a.a(jSONObject, str, str2);
    }

    @Override // com.ironsource.K8
    public synchronized void a(String str, String str2) {
        C2502p8 c2502p8 = this.f8848a;
        if (c2502p8 != null && c2502p8.b() != null && this.f8848a.getPresentingView() != null) {
            this.f8848a.b().e();
            V7.f7731a.d(new a(str, str2));
        }
    }

    @Override // com.ironsource.K8
    public void a(String str, String str2, String str3) {
        C2502p8 c2502p8 = this.f8848a;
        if (c2502p8 == null) {
            return;
        }
        c2502p8.a(str, str2, str3);
    }

    @Override // com.ironsource.K8
    public void b(JSONObject jSONObject, String str, String str2) {
        this.f8848a.b(jSONObject, str, str2);
    }
}
