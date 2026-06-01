package androidx.activity;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f3296b;

    public /* synthetic */ a(ComponentActivity componentActivity, int i2) {
        this.f3295a = i2;
        this.f3296b = componentActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3295a) {
            case 0:
                this.f3296b.invalidateMenu();
                break;
            default:
                ComponentActivity.onBackPressedDispatcher_delegate$lambda$13$lambda$10(this.f3296b);
                break;
        }
    }
}
