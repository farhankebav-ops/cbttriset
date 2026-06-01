package com.mimikridev.ads.util;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AsyncTaskExecutor f10690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10691c;

    public /* synthetic */ a(AsyncTaskExecutor asyncTaskExecutor, Object obj, int i2) {
        this.f10689a = i2;
        this.f10690b = asyncTaskExecutor;
        this.f10691c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10689a) {
            case 0:
                this.f10690b.lambda$execute$4(this.f10691c);
                break;
            case 1:
                this.f10690b.lambda$execute$2(this.f10691c);
                break;
            case 2:
                this.f10690b.lambda$execute$3(this.f10691c);
                break;
            default:
                this.f10690b.lambda$publishProgress$1(this.f10691c);
                break;
        }
    }
}
