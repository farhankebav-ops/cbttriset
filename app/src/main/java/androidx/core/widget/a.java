package androidx.core.widget;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f3989b;

    public /* synthetic */ a(ContentLoadingProgressBar contentLoadingProgressBar, int i2) {
        this.f3988a = i2;
        this.f3989b = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3988a) {
            case 0:
                this.f3989b.lambda$new$0();
                break;
            case 1:
                this.f3989b.lambda$new$1();
                break;
            case 2:
                this.f3989b.showOnUiThread();
                break;
            default:
                this.f3989b.hideOnUiThread();
                break;
        }
    }
}
