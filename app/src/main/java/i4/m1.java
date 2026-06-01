package i4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum m1 {
    OK(0),
    CANCELLED(1),
    UNKNOWN(2),
    INVALID_ARGUMENT(3),
    DEADLINE_EXCEEDED(4),
    NOT_FOUND(5),
    ALREADY_EXISTS(6),
    PERMISSION_DENIED(7),
    RESOURCE_EXHAUSTED(8),
    FAILED_PRECONDITION(9),
    ABORTED(10),
    OUT_OF_RANGE(11),
    UNIMPLEMENTED(12),
    INTERNAL(13),
    UNAVAILABLE(14),
    DATA_LOSS(15),
    UNAUTHENTICATED(16);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f11910b;

    m1(int i2) {
        this.f11909a = i2;
        this.f11910b = Integer.toString(i2).getBytes(e2.d.f11227a);
    }

    public final n1 a() {
        return (n1) n1.f11913d.get(this.f11909a);
    }
}
