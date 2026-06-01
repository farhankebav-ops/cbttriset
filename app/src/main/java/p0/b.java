package p0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13264a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f13265b = a0.a(1, FieldDescriptor.builder("storageMetrics"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(f13265b, ((s0.b) obj).f13659a);
    }
}
