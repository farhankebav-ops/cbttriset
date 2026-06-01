package p0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13260a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f13261b = a0.a(1, FieldDescriptor.builder("window"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f13262c = a0.a(2, FieldDescriptor.builder("logSourceMetrics"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FieldDescriptor f13263d = a0.a(3, FieldDescriptor.builder("globalMetrics"));
    public static final FieldDescriptor e = a0.a(4, FieldDescriptor.builder("appNamespace"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        s0.a aVar = (s0.a) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(f13261b, aVar.f13655a);
        objectEncoderContext2.add(f13262c, aVar.f13656b);
        objectEncoderContext2.add(f13263d, aVar.f13657c);
        objectEncoderContext2.add(e, aVar.f13658d);
    }
}
