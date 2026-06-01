package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class xi implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C2623wb f10539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f10540c;

    public /* synthetic */ xi(C2623wb c2623wb, Runnable runnable, int i2) {
        this.f10538a = i2;
        this.f10539b = c2623wb;
        this.f10540c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10538a) {
            case 0:
                C2623wb.a(this.f10539b, this.f10540c);
                break;
            default:
                C2623wb.b(this.f10539b, this.f10540c);
                break;
        }
    }
}
