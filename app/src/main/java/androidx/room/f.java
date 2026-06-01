package androidx.room;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorStatement f4076b;

    public /* synthetic */ f(QueryInterceptorStatement queryInterceptorStatement, int i2) {
        this.f4075a = i2;
        this.f4076b = queryInterceptorStatement;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4075a) {
            case 0:
                QueryInterceptorStatement.simpleQueryForLong$lambda$3(this.f4076b);
                break;
            case 1:
                QueryInterceptorStatement.executeInsert$lambda$2(this.f4076b);
                break;
            case 2:
                QueryInterceptorStatement.simpleQueryForString$lambda$4(this.f4076b);
                break;
            case 3:
                QueryInterceptorStatement.execute$lambda$0(this.f4076b);
                break;
            default:
                QueryInterceptorStatement.executeUpdateDelete$lambda$1(this.f4076b);
                break;
        }
    }
}
