package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f13650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Callback f13651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f13652d;

    public /* synthetic */ a(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 anonymousClass1, Callback callback, Object obj, int i2) {
        this.f13649a = i2;
        this.f13650b = anonymousClass1;
        this.f13651c = callback;
        this.f13652d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13649a) {
            case 0:
                this.f13650b.lambda$onResponse$0(this.f13651c, (Response) this.f13652d);
                break;
            default:
                this.f13650b.lambda$onFailure$1(this.f13651c, (Throwable) this.f13652d);
                break;
        }
    }
}
