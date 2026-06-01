package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.ironsource.A8;
import com.ironsource.B7;
import com.ironsource.C2300e4;
import com.ironsource.C2328fe;
import com.ironsource.C2402k;
import com.ironsource.C2420l;
import com.ironsource.C2519q8;
import com.ironsource.C2531r4;
import com.ironsource.C2597v2;
import com.ironsource.C2603v8;
import com.ironsource.G5;
import com.ironsource.Mb;
import com.ironsource.Ng;
import com.ironsource.Q9;
import com.ironsource.Sc;
import com.ironsource.Z0;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.og;
import com.ironsource.sdk.controller.v;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ControllerActivity extends Activity implements Sc, og {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f9835n = "ControllerActivity";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f9836o = 1;
    private static String p = "removeWebViewContainerView | mContainer is null";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f9837q = "removeWebViewContainerView | view is null";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private v f9839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RelativeLayout f9840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f9841d;
    private B7 e;
    private String g;
    private Z0 k;
    private boolean l;
    private boolean m;
    public int currentRequestedRotation = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9842f = false;
    private Handler h = new Handler();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Runnable f9843i = new a();
    final RelativeLayout.LayoutParams j = new RelativeLayout.LayoutParams(-1, -1);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControllerActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(ControllerActivity.this.f9842f));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements View.OnSystemUiVisibilityChangeListener {
        public b() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            if ((i2 & InputDeviceCompat.SOURCE_TOUCHSCREEN) == 0) {
                ControllerActivity controllerActivity = ControllerActivity.this;
                controllerActivity.h.removeCallbacks(controllerActivity.f9843i);
                ControllerActivity controllerActivity2 = ControllerActivity.this;
                controllerActivity2.h.postDelayed(controllerActivity2.f9843i, 500L);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControllerActivity.this.getWindow().addFlags(128);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControllerActivity.this.getWindow().clearFlags(128);
        }
    }

    private boolean d() {
        return this.f9838a == null;
    }

    private void e() {
        runOnUiThread(new c());
    }

    private void f() {
        ViewGroup viewGroup;
        try {
            if (this.f9840c == null) {
                throw new Exception(p);
            }
            ViewGroup viewGroup2 = (ViewGroup) this.f9841d.getParent();
            View viewA = a(viewGroup2);
            if (viewA == null) {
                throw new Exception(f9837q);
            }
            if (isFinishing() && (viewGroup = (ViewGroup) viewA.getParent()) != null) {
                viewGroup.removeView(viewA);
            }
            viewGroup2.removeView(this.f9841d);
        } catch (Exception e) {
            C2531r4.d().a(e);
            A8.a(C2328fe.f8543s, new C2603v8().a(G5.A, e.getMessage()).a());
            Logger.i(f9835n, "removeWebViewContainerView fail " + e.getMessage());
        }
    }

    private void g() {
        int iK = this.e.K(this);
        String str = f9835n;
        Logger.i(str, "setInitiateLandscapeOrientation");
        if (iK == 0) {
            Logger.i(str, "ROTATION_0");
            setRequestedOrientation(0);
            return;
        }
        if (iK == 2) {
            Logger.i(str, "ROTATION_180");
            setRequestedOrientation(8);
        } else if (iK == 3) {
            Logger.i(str, "ROTATION_270 Right Landscape");
            setRequestedOrientation(8);
        } else if (iK != 1) {
            Logger.i(str, "No Rotation");
        } else {
            Logger.i(str, "ROTATION_90 Left Landscape");
            setRequestedOrientation(0);
        }
    }

    private void h() {
        int iK = this.e.K(this);
        String str = f9835n;
        Logger.i(str, "setInitiatePortraitOrientation");
        if (iK == 0) {
            Logger.i(str, "ROTATION_0");
            setRequestedOrientation(1);
            return;
        }
        if (iK == 2) {
            Logger.i(str, "ROTATION_180");
            setRequestedOrientation(9);
        } else if (iK == 1) {
            Logger.i(str, "ROTATION_270 Right Landscape");
            setRequestedOrientation(1);
        } else if (iK != 3) {
            Logger.i(str, "No Rotation");
        } else {
            Logger.i(str, "ROTATION_90 Left Landscape");
            setRequestedOrientation(1);
        }
    }

    @Override // com.ironsource.Sc
    public boolean onBackButtonPressed() {
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Logger.i(f9835n, "onBackPressed");
        if (C2597v2.a().a(this)) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.ironsource.Sc
    public void onCloseRequested() {
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = Mb.U().i();
        try {
            new C2420l(this).a();
            new C2402k(this).a();
            v vVar = (v) Q9.b((Context) this).a().k();
            this.f9839b = vVar;
            vVar.r().setId(1);
            this.f9839b.a((Sc) this);
            this.f9839b.a((og) this);
            Intent intent = getIntent();
            this.g = intent.getStringExtra(C2300e4.h.m);
            this.f9842f = intent.getBooleanExtra(C2300e4.h.f8388v, false);
            this.f9838a = intent.getStringExtra("adViewId");
            this.l = false;
            this.m = intent.getBooleanExtra(C2300e4.h.f8396z0, false);
            if (this.f9842f) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new b());
                runOnUiThread(this.f9843i);
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.f9840c = relativeLayout;
            setContentView(relativeLayout, this.j);
            this.f9841d = a(this.f9838a);
            if (this.f9840c.findViewById(1) == null && this.f9841d.getParent() != null) {
                finish();
            }
            c();
            this.f9840c.addView(this.f9841d, this.j);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        String str = f9835n;
        Logger.i(str, "onDestroy");
        f();
        if (this.l) {
            return;
        }
        Logger.i(str, "onDestroy | destroyedFromBackground");
        b();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && this.f9839b.x()) {
            this.f9839b.w();
            return true;
        }
        if (this.f9842f && (i2 == 25 || i2 == 24)) {
            this.h.removeCallbacks(this.f9843i);
            this.h.postDelayed(this.f9843i, 500L);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.ironsource.Sc
    public void onOrientationChanged(String str, int i2) {
        a(str, i2);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        Logger.i(f9835n, "onPause, isFinishing=" + isFinishing());
        t.a(this);
        v vVar = this.f9839b;
        if (vVar != null) {
            vVar.a((Context) this);
            if (!this.m) {
                this.f9839b.A();
            }
            this.f9839b.a(false, C2300e4.h.Z);
            this.f9839b.g(this.g, C2300e4.h.t0);
        }
        if (isFinishing()) {
            this.l = true;
            b();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Logger.i(f9835n, C2300e4.h.f8387u0);
        v vVar = this.f9839b;
        if (vVar != null) {
            vVar.b(this);
            if (!this.m) {
                this.f9839b.E();
            }
            this.f9839b.a(true, C2300e4.h.Z);
            this.f9839b.g(this.g, C2300e4.h.f8387u0);
        }
        t.b(this);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        Logger.i(f9835n, "onStart");
        v vVar = this.f9839b;
        if (vVar != null) {
            vVar.g(this.g, "onStart");
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        Logger.i(f9835n, "onStop");
        v vVar = this.f9839b;
        if (vVar != null) {
            vVar.g(this.g, "onStop");
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Logger.i(f9835n, "onUserLeaveHint");
        v vVar = this.f9839b;
        if (vVar != null) {
            vVar.g(this.g, "onUserLeaveHint");
        }
    }

    @Override // com.ironsource.og
    public void onVideoEnded() {
        toggleKeepScreen(false);
    }

    @Override // com.ironsource.og
    public void onVideoPaused() {
        toggleKeepScreen(false);
    }

    @Override // com.ironsource.og
    public void onVideoResumed() {
        toggleKeepScreen(true);
    }

    @Override // com.ironsource.og
    public void onVideoStarted() {
        toggleKeepScreen(true);
    }

    @Override // com.ironsource.og
    public void onVideoStopped() {
        toggleKeepScreen(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (this.f9842f && z2) {
            runOnUiThread(this.f9843i);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        if (this.currentRequestedRotation != i2) {
            String str = f9835n;
            StringBuilder sbV = a1.a.v(i2, "Rotation: Req = ", " Curr = ");
            sbV.append(this.currentRequestedRotation);
            Logger.i(str, sbV.toString());
            this.currentRequestedRotation = i2;
            super.setRequestedOrientation(i2);
        }
    }

    public void toggleKeepScreen(boolean z2) {
        if (z2) {
            e();
        } else {
            a();
        }
    }

    private FrameLayout a(String str) {
        return !b(str) ? this.f9839b.r() : Ng.a(getApplicationContext(), C2519q8.a().a(str).getPresentingView());
    }

    private boolean b(String str) {
        return (TextUtils.isEmpty(str) || str.equals(Integer.toString(1))) ? false : true;
    }

    private void c() {
        Intent intent = getIntent();
        a(intent.getStringExtra(C2300e4.h.A), intent.getIntExtra(C2300e4.h.B, 0));
    }

    private void b() {
        String str = f9835n;
        Logger.i(str, "clearWebviewController");
        v vVar = this.f9839b;
        if (vVar == null) {
            Logger.i(str, "clearWebviewController, null");
            return;
        }
        vVar.a(v.u.Gone);
        this.f9839b.B();
        this.f9839b.C();
        this.f9839b.g(this.g, "onDestroy");
    }

    private void a(String str, int i2) {
        if (str != null) {
            if (C2300e4.h.C.equalsIgnoreCase(str)) {
                g();
                return;
            }
            if (C2300e4.h.D.equalsIgnoreCase(str)) {
                h();
                return;
            }
            if (C2300e4.h.G.equalsIgnoreCase(str)) {
                if (this.e.w(this)) {
                    setRequestedOrientation(1);
                }
            } else if (getRequestedOrientation() == -1) {
                setRequestedOrientation(4);
            }
        }
    }

    private View a(ViewGroup viewGroup) {
        if (d()) {
            return viewGroup.findViewById(1);
        }
        return C2519q8.a().a(this.f9838a).getPresentingView();
    }

    private void a() {
        runOnUiThread(new d());
    }
}
