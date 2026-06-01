package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ironsource.B7;
import com.ironsource.C2300e4;
import com.ironsource.C2531r4;
import com.ironsource.C2597v2;
import com.ironsource.Mb;
import com.ironsource.Sc;
import com.ironsource.sdk.controller.v;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class h extends FrameLayout implements Sc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private v f9979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final B7 f9980c;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup windowDecorViewGroup = h.this.getWindowDecorViewGroup();
            if (windowDecorViewGroup != null) {
                windowDecorViewGroup.addView(h.this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup windowDecorViewGroup = h.this.getWindowDecorViewGroup();
            if (windowDecorViewGroup != null) {
                windowDecorViewGroup.removeView(h.this);
            }
        }
    }

    public h(Context context) {
        super(context);
        this.f9980c = Mb.U().i();
        this.f9978a = context;
        setClickable(true);
    }

    private void b() {
        ((Activity) this.f9978a).runOnUiThread(new b());
    }

    private int getNavigationBarPadding() {
        Activity activity = (Activity) this.f9978a;
        try {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getDrawingRect(rect);
            Rect rect2 = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (this.f9980c.z(activity) == 1) {
                int i2 = rect.bottom - rect2.bottom;
                if (i2 > 0) {
                    return i2;
                }
                return 0;
            }
            int i8 = rect.right - rect2.right;
            if (i8 > 0) {
                return i8;
            }
            return 0;
        } catch (Exception e) {
            C2531r4.d().a(e);
            return 0;
        }
    }

    private int getStatusBarHeight() {
        int identifier;
        try {
            Context context = this.f9978a;
            if (context == null || (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
                return 0;
            }
            return this.f9978a.getResources().getDimensionPixelSize(identifier);
        } catch (Exception e) {
            C2531r4.d().a(e);
            return 0;
        }
    }

    private int getStatusBarPadding() {
        int statusBarHeight;
        if ((((Activity) this.f9978a).getWindow().getAttributes().flags & 1024) == 0 && (statusBarHeight = getStatusBarHeight()) > 0) {
            return statusBarHeight;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup getWindowDecorViewGroup() {
        Activity activity = (Activity) this.f9978a;
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f9979b.E();
        this.f9979b.a(true, C2300e4.h.Z);
    }

    @Override // com.ironsource.Sc
    public boolean onBackButtonPressed() {
        return C2597v2.a().a((Activity) this.f9978a);
    }

    @Override // com.ironsource.Sc
    public void onCloseRequested() {
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f9979b.A();
        this.f9979b.a(false, C2300e4.h.Z);
        v vVar = this.f9979b;
        if (vVar != null) {
            vVar.a(v.u.Gone);
            this.f9979b.B();
            this.f9979b.C();
        }
        removeAllViews();
    }

    public void a(v vVar) {
        this.f9979b = vVar;
        vVar.a(this);
        this.f9979b.D();
        this.f9978a = this.f9979b.p();
        a(getStatusBarPadding(), getNavigationBarPadding());
        a();
    }

    private void a() {
        ((Activity) this.f9978a).runOnUiThread(new a());
    }

    private void a(int i2, int i8) {
        try {
            Context context = this.f9978a;
            if (context != null) {
                int iZ = this.f9980c.z(context);
                if (iZ == 1) {
                    setPadding(0, i2, 0, i8);
                } else if (iZ == 2) {
                    setPadding(0, i2, i8, 0);
                }
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
        }
    }

    @Override // com.ironsource.Sc
    public void onOrientationChanged(String str, int i2) {
    }
}
