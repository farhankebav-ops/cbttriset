package androidx.room;

import androidx.sqlite.db.SupportSQLiteQuery;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f4072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteQuery f4073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorProgram f4074d;

    public /* synthetic */ e(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram, int i2) {
        this.f4071a = i2;
        this.f4072b = queryInterceptorDatabase;
        this.f4073c = supportSQLiteQuery;
        this.f4074d = queryInterceptorProgram;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4071a) {
            case 0:
                QueryInterceptorDatabase.query$lambda$8(this.f4072b, this.f4073c, this.f4074d);
                break;
            default:
                QueryInterceptorDatabase.query$lambda$9(this.f4072b, this.f4073c, this.f4074d);
                break;
        }
    }
}
