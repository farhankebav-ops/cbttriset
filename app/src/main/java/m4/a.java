package m4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum a {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_STREAM(1),
    /* JADX INFO: Fake field, exist only in values array */
    UNSUPPORTED_VERSION(1),
    /* JADX INFO: Fake field, exist only in values array */
    STREAM_IN_USE(1),
    /* JADX INFO: Fake field, exist only in values array */
    STREAM_ALREADY_CLOSED(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    STREAM_CLOSED(5),
    FRAME_TOO_LARGE(6),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    /* JADX INFO: Fake field, exist only in values array */
    HTTP_1_1_REQUIRED(13),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_CREDENTIALS(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12931a;

    a(int i2) {
        this.f12931a = i2;
    }
}
