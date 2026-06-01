package com.ironsource;

import android.view.View;
import com.ironsource.C2300e4;
import com.ironsource.F8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class J8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private F8 f7002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f7003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f7004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f7005d;
    private View e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f7006f;
    private View g;
    private View h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f7007i;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        void a(b bVar);

        void a(rg rgVar);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum b {
        Title("title"),
        Advertiser(C2300e4.h.F0),
        Body(C2300e4.h.E0),
        Cta(C2300e4.h.G0),
        Icon(C2300e4.h.H0),
        Container("container"),
        PrivacyIcon(C2300e4.h.J0);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7013a;

        b(String str) {
            this.f7013a = str;
        }

        public final String b() {
            return this.f7013a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c implements F8.a {
        public c() {
        }

        @Override // com.ironsource.F8.a
        public void a(rg viewVisibilityParams) {
            kotlin.jvm.internal.k.e(viewVisibilityParams, "viewVisibilityParams");
            a aVarN = J8.this.n();
            if (aVarN != null) {
                aVarN.a(viewVisibilityParams);
            }
        }
    }

    public J8(F8 containerView, View view, View view2, View view3, View view4, View view5, View view6, View privacyIconView) {
        kotlin.jvm.internal.k.e(containerView, "containerView");
        kotlin.jvm.internal.k.e(privacyIconView, "privacyIconView");
        this.f7002a = containerView;
        this.f7003b = view;
        this.f7004c = view2;
        this.f7005d = view3;
        this.e = view4;
        this.f7006f = view5;
        this.g = view6;
        this.h = privacyIconView;
        r();
        s();
    }

    private final void r() {
        a(this, this.f7003b, b.Title);
        a(this, this.f7004c, b.Advertiser);
        a(this, this.e, b.Body);
        a(this, this.g, b.Cta);
        a(this, this.f7005d, b.Icon);
        a(this, this.f7002a, b.Container);
        a(this, this.h, b.PrivacyIcon);
    }

    private final void s() {
        this.f7002a.setListener$mediationsdk_release(new c());
    }

    public final F8 a() {
        return this.f7002a;
    }

    public final View c() {
        return this.f7004c;
    }

    public final View d() {
        return this.f7005d;
    }

    public final View e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof J8)) {
            return false;
        }
        J8 j8 = (J8) obj;
        return kotlin.jvm.internal.k.a(this.f7002a, j8.f7002a) && kotlin.jvm.internal.k.a(this.f7003b, j8.f7003b) && kotlin.jvm.internal.k.a(this.f7004c, j8.f7004c) && kotlin.jvm.internal.k.a(this.f7005d, j8.f7005d) && kotlin.jvm.internal.k.a(this.e, j8.e) && kotlin.jvm.internal.k.a(this.f7006f, j8.f7006f) && kotlin.jvm.internal.k.a(this.g, j8.g) && kotlin.jvm.internal.k.a(this.h, j8.h);
    }

    public final View f() {
        return this.f7006f;
    }

    public final View g() {
        return this.g;
    }

    public final View h() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = this.f7002a.hashCode() * 31;
        View view = this.f7003b;
        int iHashCode2 = (iHashCode + (view == null ? 0 : view.hashCode())) * 31;
        View view2 = this.f7004c;
        int iHashCode3 = (iHashCode2 + (view2 == null ? 0 : view2.hashCode())) * 31;
        View view3 = this.f7005d;
        int iHashCode4 = (iHashCode3 + (view3 == null ? 0 : view3.hashCode())) * 31;
        View view4 = this.e;
        int iHashCode5 = (iHashCode4 + (view4 == null ? 0 : view4.hashCode())) * 31;
        View view5 = this.f7006f;
        int iHashCode6 = (iHashCode5 + (view5 == null ? 0 : view5.hashCode())) * 31;
        View view6 = this.g;
        return this.h.hashCode() + ((iHashCode6 + (view6 != null ? view6.hashCode() : 0)) * 31);
    }

    public final View i() {
        return this.f7004c;
    }

    public final View j() {
        return this.e;
    }

    public final F8 k() {
        return this.f7002a;
    }

    public final View l() {
        return this.g;
    }

    public final View m() {
        return this.f7005d;
    }

    public final a n() {
        return this.f7007i;
    }

    public final View o() {
        return this.f7006f;
    }

    public final View p() {
        return this.h;
    }

    public final View q() {
        return this.f7003b;
    }

    public final JSONObject t() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("title", this.f7003b != null).put(C2300e4.h.F0, this.f7004c != null).put(C2300e4.h.E0, this.e != null).put(C2300e4.h.G0, this.g != null).put(C2300e4.h.I0, this.f7006f != null).put(C2300e4.h.H0, this.f7005d != null);
        kotlin.jvm.internal.k.d(jSONObjectPut, "JSONObject()\n        .pu…\"icon\", iconView != null)");
        return jSONObjectPut;
    }

    public String toString() {
        return "ISNNativeAdViewHolder(containerView=" + this.f7002a + ", titleView=" + this.f7003b + ", advertiserView=" + this.f7004c + ", iconView=" + this.f7005d + ", bodyView=" + this.e + ", mediaView=" + this.f7006f + ", ctaView=" + this.g + ", privacyIconView=" + this.h + ")";
    }

    public final J8 a(F8 containerView, View view, View view2, View view3, View view4, View view5, View view6, View privacyIconView) {
        kotlin.jvm.internal.k.e(containerView, "containerView");
        kotlin.jvm.internal.k.e(privacyIconView, "privacyIconView");
        return new J8(containerView, view, view2, view3, view4, view5, view6, privacyIconView);
    }

    public final View b() {
        return this.f7003b;
    }

    public final void c(View view) {
        this.g = view;
    }

    public final void d(View view) {
        this.f7005d = view;
    }

    public final void e(View view) {
        this.f7006f = view;
    }

    public final void f(View view) {
        kotlin.jvm.internal.k.e(view, "<set-?>");
        this.h = view;
    }

    public final void g(View view) {
        this.f7003b = view;
    }

    public static /* synthetic */ J8 a(J8 j8, F8 f8, View view, View view2, View view3, View view4, View view5, View view6, View view7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f8 = j8.f7002a;
        }
        if ((i2 & 2) != 0) {
            view = j8.f7003b;
        }
        if ((i2 & 4) != 0) {
            view2 = j8.f7004c;
        }
        if ((i2 & 8) != 0) {
            view3 = j8.f7005d;
        }
        if ((i2 & 16) != 0) {
            view4 = j8.e;
        }
        if ((i2 & 32) != 0) {
            view5 = j8.f7006f;
        }
        if ((i2 & 64) != 0) {
            view6 = j8.g;
        }
        if ((i2 & 128) != 0) {
            view7 = j8.h;
        }
        View view8 = view6;
        View view9 = view7;
        View view10 = view4;
        View view11 = view5;
        return j8.a(f8, view, view2, view3, view10, view11, view8, view9);
    }

    public final void b(View view) {
        this.e = view;
    }

    public final void a(F8 f8) {
        kotlin.jvm.internal.k.e(f8, "<set-?>");
        this.f7002a = f8;
    }

    public final void a(View view) {
        this.f7004c = view;
    }

    public final void a(a aVar) {
        this.f7007i = aVar;
    }

    private static final void a(final J8 j8, View view, final b bVar) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.ironsource.kh
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    J8.a(this.f8869a, bVar, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(J8 this$0, b viewName, View view) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(viewName, "$viewName");
        a aVar = this$0.f7007i;
        if (aVar != null) {
            aVar.a(viewName);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ J8(F8 f8, View view, View view2, View view3, View view4, View view5, View view6, View view7, int i2, kotlin.jvm.internal.f fVar) {
        View view8;
        View view9;
        view = (i2 & 2) != 0 ? null : view;
        view2 = (i2 & 4) != 0 ? null : view2;
        view3 = (i2 & 8) != 0 ? null : view3;
        view4 = (i2 & 16) != 0 ? null : view4;
        view5 = (i2 & 32) != 0 ? null : view5;
        if ((i2 & 64) != 0) {
            view8 = view7;
            view9 = null;
        } else {
            view8 = view7;
            view9 = view6;
        }
        this(f8, view, view2, view3, view4, view5, view9, view8);
    }
}
