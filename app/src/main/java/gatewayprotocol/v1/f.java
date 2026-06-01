package gatewayprotocol.v1;

import com.google.protobuf.Internal;
import gatewayprotocol.v1.AdRequestOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f implements Internal.EnumVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f11641a = new f();

    @Override // com.google.protobuf.Internal.EnumVerifier
    public final boolean isInRange(int i2) {
        return AdRequestOuterClass.AdRequestType.forNumber(i2) != null;
    }
}
