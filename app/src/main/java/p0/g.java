package p0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f13276a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f13277b = a0.a(1, FieldDescriptor.builder("startMs"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f13278c = a0.a(2, FieldDescriptor.builder("endMs"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        s0.g gVar = (s0.g) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f13277b, gVar.f13673a);
        objectEncoderContext2.add(f13278c, gVar.f13674b);
    }
}
