package androidx.room;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f4067b;

    public /* synthetic */ c(QueryInterceptorDatabase queryInterceptorDatabase, int i2) {
        this.f4066a = i2;
        this.f4067b = queryInterceptorDatabase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4066a) {
            case 0:
                QueryInterceptorDatabase.endTransaction$lambda$4(this.f4067b);
                break;
            case 1:
                QueryInterceptorDatabase.beginTransactionWithListenerNonExclusive$lambda$3(this.f4067b);
                break;
            case 2:
                QueryInterceptorDatabase.beginTransaction$lambda$0(this.f4067b);
                break;
            case 3:
                QueryInterceptorDatabase.setTransactionSuccessful$lambda$5(this.f4067b);
                break;
            case 4:
                QueryInterceptorDatabase.beginTransactionNonExclusive$lambda$1(this.f4067b);
                break;
            default:
                QueryInterceptorDatabase.beginTransactionWithListener$lambda$2(this.f4067b);
                break;
        }
    }
}
