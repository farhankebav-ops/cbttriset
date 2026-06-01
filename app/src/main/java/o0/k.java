package o0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f13145a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f13146b = FieldDescriptor.of("networkType");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f13147c = FieldDescriptor.of("mobileSubtype");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        x xVar = (x) ((k0) obj);
        objectEncoderContext2.add(f13146b, xVar.f13182a);
        objectEncoderContext2.add(f13147c, xVar.f13183b);
    }
}
