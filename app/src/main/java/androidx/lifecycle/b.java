package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements e6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4034b;

    public /* synthetic */ b(Object obj, int i2) {
        this.f4033a = i2;
        this.f4034b = obj;
    }

    @Override // e6.a
    public final Object invoke() {
        switch (this.f4033a) {
            case 0:
                return CoroutineLiveData._init_$lambda$0((CoroutineLiveData) this.f4034b);
            default:
                return SavedStateHandleSupport.getSavedStateHandlesVM((ViewModelStoreOwner) this.f4034b);
        }
    }
}
