package androidx.room;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f4069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4070c;

    public /* synthetic */ d(QueryInterceptorDatabase queryInterceptorDatabase, String str, int i2) {
        this.f4068a = i2;
        this.f4069b = queryInterceptorDatabase;
        this.f4070c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4068a) {
            case 0:
                QueryInterceptorDatabase.query$lambda$6(this.f4069b, this.f4070c);
                break;
            default:
                QueryInterceptorDatabase.execSQL$lambda$10(this.f4069b, this.f4070c);
                break;
        }
    }
}
