package e2;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class s extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11252a;

    @Override // java.lang.Throwable
    public String getMessage() {
        switch (this.f11252a) {
            case 6:
                return "Chain of Causes for CompositeException In Order Received =>";
            default:
                return super.getMessage();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(String str, int i2) {
        super(str);
        this.f11252a = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(String str, Throwable th, int i2) {
        super(str, th);
        this.f11252a = i2;
    }
}
