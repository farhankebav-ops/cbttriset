package o0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f13120a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f13121b = FieldDescriptor.of("privacyContext");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f13122c = FieldDescriptor.of("productIdOrigin");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f13121b, ((p) ((c0) obj)).f13159a);
        objectEncoderContext2.add(f13122c, b0.f13113a);
    }
}
