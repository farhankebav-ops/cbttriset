package p0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f13273a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f13274b = a0.a(1, FieldDescriptor.builder("currentCacheSizeBytes"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f13275c = a0.a(2, FieldDescriptor.builder("maxCacheSizeBytes"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        s0.f fVar = (s0.f) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f13274b, fVar.f13671a);
        objectEncoderContext2.add(f13275c, fVar.f13672b);
    }
}
