package o0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13115a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f13116b = FieldDescriptor.of("logRequest");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(f13116b, ((n) ((y) obj)).f13157a);
    }
}
