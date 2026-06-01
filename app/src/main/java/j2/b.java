package j2;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends Throwable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12064a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(String str, int i2) {
        super(str);
        this.f12064a = i2;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        int i2 = this.f12064a;
        return this;
    }
}
