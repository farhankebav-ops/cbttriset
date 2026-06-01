package o0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f13130a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f13131b = FieldDescriptor.of("eventTimeMs");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f13132c = FieldDescriptor.of("eventCode");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FieldDescriptor f13133d = FieldDescriptor.of("complianceData");
    public static final FieldDescriptor e = FieldDescriptor.of("eventUptimeMs");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final FieldDescriptor f13134f = FieldDescriptor.of("sourceExtension");
    public static final FieldDescriptor g = FieldDescriptor.of("sourceExtensionJsonProto3");
    public static final FieldDescriptor h = FieldDescriptor.of("timezoneOffsetSeconds");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final FieldDescriptor f13135i = FieldDescriptor.of("networkConnectionInfo");
    public static final FieldDescriptor j = FieldDescriptor.of("experimentIds");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        u uVar = (u) ((g0) obj);
        objectEncoderContext2.add(f13131b, uVar.f13170a);
        objectEncoderContext2.add(f13132c, uVar.f13171b);
        objectEncoderContext2.add(f13133d, uVar.f13172c);
        objectEncoderContext2.add(e, uVar.f13173d);
        objectEncoderContext2.add(f13134f, uVar.e);
        objectEncoderContext2.add(g, uVar.f13174f);
        objectEncoderContext2.add(h, uVar.g);
        objectEncoderContext2.add(f13135i, uVar.h);
        objectEncoderContext2.add(j, uVar.f13175i);
    }
}
