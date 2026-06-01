package com.vungle.ads.internal.presenter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MRAIDPresenter f11013b;

    public /* synthetic */ a(MRAIDPresenter mRAIDPresenter, int i2) {
        this.f11012a = i2;
        this.f11013b = mRAIDPresenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11012a) {
            case 0:
                MRAIDPresenter.m3339processCommand$lambda5(this.f11013b);
                break;
            case 1:
                MRAIDPresenter.m3340processCommand$lambda9(this.f11013b);
                break;
            case 2:
                MRAIDPresenter.m3337processCommand$lambda10(this.f11013b);
                break;
            default:
                MRAIDPresenter.m3336prepare$lambda14(this.f11013b);
                break;
        }
    }
}
