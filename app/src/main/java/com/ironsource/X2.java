package com.ironsource;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class X2 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pg f7793a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements pg {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(V0 adTools, long j) {
            kotlin.jvm.internal.k.e(adTools, "$adTools");
            adTools.d(new wh(adTools, j, 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(V0 adTools, long j) {
            kotlin.jvm.internal.k.e(adTools, "$adTools");
            adTools.e().h().a(j);
        }

        @Override // com.ironsource.pg
        public void a(View view, FrameLayout.LayoutParams layoutParams, V0 adTools) {
            kotlin.jvm.internal.k.e(view, "view");
            kotlin.jvm.internal.k.e(layoutParams, "layoutParams");
            kotlin.jvm.internal.k.e(adTools, "adTools");
            View childAt = X2.this.getChildAt(0);
            long jB = Mb.f7131s.d().g().b();
            if (jB <= 0) {
                X2.this.removeView(childAt);
                X2.this.addView(view, layoutParams);
                adTools.d(new wh(adTools, jB, 1));
                return;
            }
            adTools.d(new wh(adTools, jB, 2));
            view.setAlpha(0.0f);
            X2.this.addView(view, layoutParams);
            if (childAt != null) {
                childAt.animate().alpha(0.0f).setDuration(jB).withStartAction(new ch(childAt, 8)).withEndAction(new androidx.camera.core.processing.c(X2.this, childAt, childAt, 14)).start();
            }
            view.animate().alpha(1.0f).setDuration(jB).withEndAction(new wh(adTools, jB, 3)).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(V0 adTools, long j) {
            kotlin.jvm.internal.k.e(adTools, "$adTools");
            adTools.e().h().a(true, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(V0 adTools, long j) {
            kotlin.jvm.internal.k.e(adTools, "$adTools");
            adTools.e().h().a(false, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(View this_apply) {
            kotlin.jvm.internal.k.e(this_apply, "$this_apply");
            this_apply.setEnabled(false);
            this_apply.setClickable(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(X2 this$0, View view, View this_apply) {
            kotlin.jvm.internal.k.e(this$0, "this$0");
            kotlin.jvm.internal.k.e(this_apply, "$this_apply");
            this$0.removeView(view);
            this_apply.setEnabled(true);
            this_apply.setClickable(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X2(Context context) {
        super(context);
        kotlin.jvm.internal.k.e(context, "context");
        this.f7793a = new a();
    }

    public final pg getViewBinder() {
        return this.f7793a;
    }
}
