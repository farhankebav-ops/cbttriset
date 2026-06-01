package androidx.appcompat.widget;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Toolbar f3343b;

    public /* synthetic */ b(Toolbar toolbar, int i2) {
        this.f3342a = i2;
        this.f3343b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3342a) {
            case 0:
                this.f3343b.collapseActionView();
                break;
            default:
                this.f3343b.invalidateMenu();
                break;
        }
    }
}
