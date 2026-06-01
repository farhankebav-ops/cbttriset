package com.ironsource;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ug {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rc f10409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f10410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f10412d;
    private final ViewTreeObserver.OnWindowFocusChangeListener e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Rect f10413f;

    public ug(Rc onVisibilityChangeListener) {
        kotlin.jvm.internal.k.e(onVisibilityChangeListener, "onVisibilityChangeListener");
        this.f10409a = onVisibilityChangeListener;
        this.f10412d = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.ironsource.vi
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                ug.a(this.f10463a);
            }
        };
        this.e = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.ironsource.wi
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z2) {
                ug.a(this.f10497a, z2);
            }
        };
        this.f10413f = new Rect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ug this$0) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ug this$0, boolean z2) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        this$0.a();
    }

    public final void b() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        View view = this.f10410b;
        if (view != null && (viewTreeObserver2 = view.getViewTreeObserver()) != null) {
            viewTreeObserver2.removeOnGlobalLayoutListener(this.f10412d);
        }
        View view2 = this.f10410b;
        if (view2 != null && (viewTreeObserver = view2.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnWindowFocusChangeListener(this.e);
        }
        this.f10410b = null;
    }

    public final boolean c() {
        View view = this.f10410b;
        if (view != null) {
            return vg.a(view, this.f10413f);
        }
        return false;
    }

    public final void a(View view) {
        kotlin.jvm.internal.k.e(view, "view");
        this.f10410b = view;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.f10412d);
        view.getViewTreeObserver().addOnWindowFocusChangeListener(this.e);
    }

    private final void a() {
        boolean zC = c();
        if (this.f10411c != zC) {
            this.f10411c = zC;
            this.f10409a.a(zC);
        }
    }
}
