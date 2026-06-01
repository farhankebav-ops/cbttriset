package gatewayprotocol.v1;

import com.google.protobuf.Internal;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class p implements Internal.EnumVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f11650a = new p();

    @Override // com.google.protobuf.Internal.EnumVerifier
    public final boolean isInRange(int i2) {
        return DiagnosticEventRequestOuterClass.DiagnosticAdType.forNumber(i2) != null;
    }
}
