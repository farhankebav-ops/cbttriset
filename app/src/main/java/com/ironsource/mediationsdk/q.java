package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import com.ironsource.C2580u2;
import com.ironsource.Fa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class q extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ISBannerSize f9266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f9269d;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        void onWindowFocusChanged(boolean z2);
    }

    public q(Activity activity, ISBannerSize iSBannerSize) {
        super(activity);
        this.f9268c = false;
        this.f9266a = iSBannerSize == null ? ISBannerSize.BANNER : iSBannerSize;
    }

    public void a() {
        this.f9268c = true;
        this.f9266a = null;
        this.f9267b = null;
        this.f9269d = null;
        C2580u2.a().a((Fa) null);
    }

    public boolean b() {
        return this.f9268c;
    }

    public q c() {
        q qVar = new q(getContext(), this.f9266a);
        qVar.f9267b = this.f9267b;
        return qVar;
    }

    public ISBannerSize getSize() {
        return this.f9266a;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        a aVar = this.f9269d;
        if (aVar != null) {
            aVar.onWindowFocusChanged(z2);
        }
    }

    public void setBannerSize(ISBannerSize iSBannerSize) {
        this.f9266a = iSBannerSize;
    }

    public q(Context context, ISBannerSize iSBannerSize) {
        super(context);
        this.f9268c = false;
        this.f9266a = iSBannerSize == null ? ISBannerSize.BANNER : iSBannerSize;
    }

    public q(Context context) {
        super(context);
        this.f9268c = false;
    }
}
