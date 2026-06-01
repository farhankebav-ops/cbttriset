package com.ironsource.mediationsdk.demandOnly;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ironsource.C2563t2;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ISDemandOnlyBannerLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f9064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ISBannerSize f9065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Activity f9067d;
    private boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private C2563t2 f9068f;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f9069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrameLayout.LayoutParams f9070b;

        public a(View view, FrameLayout.LayoutParams layoutParams) {
            this.f9069a = view;
            this.f9070b = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            ISDemandOnlyBannerLayout.this.removeAllViews();
            ViewParent parent = this.f9069a.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f9069a);
            }
            ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout = ISDemandOnlyBannerLayout.this;
            View view = this.f9069a;
            iSDemandOnlyBannerLayout.f9064a = view;
            iSDemandOnlyBannerLayout.addView(view, 0, this.f9070b);
        }
    }

    public ISDemandOnlyBannerLayout(Activity activity, ISBannerSize iSBannerSize) {
        super(activity);
        this.e = false;
        this.f9067d = activity;
        this.f9065b = iSBannerSize == null ? ISBannerSize.BANNER : iSBannerSize;
        this.f9068f = new C2563t2();
    }

    public Activity getActivity() {
        return this.f9067d;
    }

    public ISDemandOnlyBannerListener getBannerDemandOnlyListener() {
        return this.f9068f.a();
    }

    public View getBannerView() {
        return this.f9064a;
    }

    public C2563t2 getListener() {
        return this.f9068f;
    }

    public String getPlacementName() {
        return this.f9066c;
    }

    public ISBannerSize getSize() {
        return this.f9065b;
    }

    public boolean isDestroyed() {
        return this.e;
    }

    public void removeBannerListener() {
        IronLog.API.info();
        this.f9068f.b((Object) null);
    }

    public void setBannerDemandOnlyListener(ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
        IronLog.API.info();
        this.f9068f.b(iSDemandOnlyBannerListener);
    }

    public void setPlacementName(String str) {
        this.f9066c = str;
    }

    public void a() {
        this.e = true;
        this.f9067d = null;
        this.f9065b = null;
        this.f9066c = null;
        this.f9064a = null;
        removeBannerListener();
    }

    private ISDemandOnlyBannerLayout(Context context) {
        super(context);
        this.e = false;
    }

    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(view, layoutParams));
    }
}
