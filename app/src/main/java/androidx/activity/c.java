package androidx.activity;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements e6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f3300b;

    public /* synthetic */ c(ComponentActivity componentActivity, int i2) {
        this.f3299a = i2;
        this.f3300b = componentActivity;
    }

    @Override // e6.a
    public final Object invoke() {
        switch (this.f3299a) {
            case 0:
                return ComponentActivity.fullyDrawnReporter_delegate$lambda$2$lambda$1(this.f3300b);
            case 1:
                return ComponentActivity.fullyDrawnReporter_delegate$lambda$2(this.f3300b);
            case 2:
                return ComponentActivity.defaultViewModelProviderFactory_delegate$lambda$9(this.f3300b);
            default:
                return ComponentActivity.onBackPressedDispatcher_delegate$lambda$13(this.f3300b);
        }
    }
}
