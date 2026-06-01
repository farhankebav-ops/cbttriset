package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4032b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f4031a = i2;
        this.f4032b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4031a) {
            case 0:
                ComputableLiveData.refreshRunnable$lambda$0((ComputableLiveData) this.f4032b);
                break;
            case 1:
                ComputableLiveData.invalidationRunnable$lambda$1((ComputableLiveData) this.f4032b);
                break;
            default:
                ProcessLifecycleOwner.delayedPauseRunnable$lambda$0((ProcessLifecycleOwner) this.f4032b);
                break;
        }
    }
}
