package p0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13266a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f13267b = a0.a(1, FieldDescriptor.builder("eventsDroppedCount"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f13268c = a0.a(3, FieldDescriptor.builder("reason"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        s0.d dVar = (s0.d) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f13267b, dVar.f13666a);
        objectEncoderContext2.add(f13268c, dVar.f13667b);
    }
}
