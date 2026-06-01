package o0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f13117a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f13118b = FieldDescriptor.of("clientType");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f13119c = FieldDescriptor.of("androidClientInfo");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        o oVar = (o) ((a0) obj);
        oVar.getClass();
        objectEncoderContext2.add(f13118b, z.f13184a);
        objectEncoderContext2.add(f13119c, oVar.f13158a);
    }
}
