package o0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f13138a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f13139b = FieldDescriptor.of("requestTimeMs");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f13140c = FieldDescriptor.of("requestUptimeMs");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FieldDescriptor f13141d = FieldDescriptor.of("clientInfo");
    public static final FieldDescriptor e = FieldDescriptor.of("logSource");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final FieldDescriptor f13142f = FieldDescriptor.of("logSourceName");
    public static final FieldDescriptor g = FieldDescriptor.of("logEvent");
    public static final FieldDescriptor h = FieldDescriptor.of("qosTier");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        v vVar = (v) ((h0) obj);
        objectEncoderContext2.add(f13139b, vVar.f13176a);
        objectEncoderContext2.add(f13140c, vVar.f13177b);
        objectEncoderContext2.add(f13141d, vVar.f13178c);
        objectEncoderContext2.add(e, vVar.f13179d);
        objectEncoderContext2.add(f13142f, vVar.e);
        objectEncoderContext2.add(g, vVar.f13180f);
        objectEncoderContext2.add(h, l0.f13149a);
    }
}
