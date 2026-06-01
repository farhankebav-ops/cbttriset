package gatewayprotocol.v1;

import com.google.protobuf.Internal;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class w implements Internal.ListAdapter.Converter {
    @Override // com.google.protobuf.Internal.ListAdapter.Converter
    public final Object convert(Object obj) {
        DiagnosticEventRequestOuterClass.DiagnosticTagType diagnosticTagTypeForNumber = DiagnosticEventRequestOuterClass.DiagnosticTagType.forNumber(((Integer) obj).intValue());
        return diagnosticTagTypeForNumber == null ? DiagnosticEventRequestOuterClass.DiagnosticTagType.UNRECOGNIZED : diagnosticTagTypeForNumber;
    }
}
