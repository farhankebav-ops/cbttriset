package com.ironsource.mediationsdk.testSuite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.ironsource.Cf;
import com.ironsource.Lf;
import com.ironsource.Qf;
import com.ironsource.V8;
import e3.a;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TestSuiteActivity extends Activity implements V8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RelativeLayout f9341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Qf f9342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Lf f9343c;

    private final String a() {
        Bundle extras;
        if (getIntent() == null || getIntent().getExtras() == null || (extras = getIntent().getExtras()) == null) {
            return null;
        }
        return extras.getString("controllerUrl");
    }

    private final JSONObject b() {
        String strB = new Cf().b(this);
        if (strB != null) {
            try {
                if (strB.length() != 0) {
                    return new JSONObject(strB);
                }
            } catch (Exception unused) {
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    public final RelativeLayout getContainer() {
        RelativeLayout relativeLayout = this.f9341a;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        k.l("mContainer");
        throw null;
    }

    @Override // com.ironsource.V8
    public void onClosed() {
        runOnUiThread(new a(this, 0));
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f9341a = relativeLayout;
        setContentView(relativeLayout, c());
        Qf qf = new Qf(this, this, b(), a());
        this.f9342b = qf;
        Lf lf = new Lf(qf);
        this.f9343c = lf;
        lf.d();
        RelativeLayout relativeLayout2 = this.f9341a;
        if (relativeLayout2 == null) {
            k.l("mContainer");
            throw null;
        }
        Qf qf2 = this.f9342b;
        if (qf2 != null) {
            relativeLayout2.addView(qf2.d(), c());
        } else {
            k.l("mWebViewWrapper");
            throw null;
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Lf lf = this.f9343c;
        if (lf == null) {
            k.l("mNativeBridge");
            throw null;
        }
        lf.a();
        RelativeLayout relativeLayout = this.f9341a;
        if (relativeLayout == null) {
            k.l("mContainer");
            throw null;
        }
        relativeLayout.removeAllViews();
        Qf qf = this.f9342b;
        if (qf == null) {
            k.l("mWebViewWrapper");
            throw null;
        }
        qf.a();
        super.onDestroy();
    }

    @Override // com.ironsource.V8
    public void onUIReady() {
        runOnUiThread(new a(this, 1));
    }

    private final RelativeLayout.LayoutParams c() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TestSuiteActivity this$0) {
        k.e(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TestSuiteActivity this$0) {
        k.e(this$0, "this$0");
        Qf qf = this$0.f9342b;
        if (qf == null) {
            k.l("mWebViewWrapper");
            throw null;
        }
        if (qf.c().getParent() == null) {
            RelativeLayout relativeLayout = this$0.f9341a;
            if (relativeLayout == null) {
                k.l("mContainer");
                throw null;
            }
            Qf qf2 = this$0.f9342b;
            if (qf2 != null) {
                relativeLayout.removeView(qf2.d());
                RelativeLayout relativeLayout2 = this$0.f9341a;
                if (relativeLayout2 == null) {
                    k.l("mContainer");
                    throw null;
                }
                Qf qf3 = this$0.f9342b;
                if (qf3 != null) {
                    relativeLayout2.addView(qf3.c(), this$0.c());
                    Qf qf4 = this$0.f9342b;
                    if (qf4 != null) {
                        qf4.b();
                        return;
                    } else {
                        k.l("mWebViewWrapper");
                        throw null;
                    }
                }
                k.l("mWebViewWrapper");
                throw null;
            }
            k.l("mWebViewWrapper");
            throw null;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }
}
