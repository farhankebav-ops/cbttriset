package o0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13107a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f13108b = FieldDescriptor.of("sdkVersion");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f13109c = FieldDescriptor.of(Q6.B);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FieldDescriptor f13110d = FieldDescriptor.of("hardware");
    public static final FieldDescriptor e = FieldDescriptor.of(C2300e4.h.G);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final FieldDescriptor f13111f = FieldDescriptor.of("product");
    public static final FieldDescriptor g = FieldDescriptor.of("osBuild");
    public static final FieldDescriptor h = FieldDescriptor.of("manufacturer");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final FieldDescriptor f13112i = FieldDescriptor.of("fingerprint");
    public static final FieldDescriptor j = FieldDescriptor.of("locale");
    public static final FieldDescriptor k = FieldDescriptor.of("country");
    public static final FieldDescriptor l = FieldDescriptor.of("mccMnc");
    public static final FieldDescriptor m = FieldDescriptor.of("applicationBuild");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        m mVar = (m) ((a) obj);
        objectEncoderContext2.add(f13108b, mVar.f13151a);
        objectEncoderContext2.add(f13109c, mVar.f13152b);
        objectEncoderContext2.add(f13110d, mVar.f13153c);
        objectEncoderContext2.add(e, mVar.f13154d);
        objectEncoderContext2.add(f13111f, mVar.e);
        objectEncoderContext2.add(g, mVar.f13155f);
        objectEncoderContext2.add(h, mVar.g);
        objectEncoderContext2.add(f13112i, mVar.h);
        objectEncoderContext2.add(j, mVar.f13156i);
        objectEncoderContext2.add(k, mVar.j);
        objectEncoderContext2.add(l, mVar.k);
        objectEncoderContext2.add(m, mVar.l);
    }
}
