package o0;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f13123a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FieldDescriptor f13124b = FieldDescriptor.of("clearBlob");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FieldDescriptor f13125c = FieldDescriptor.of("encryptedBlob");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        q qVar = (q) ((d0) obj);
        objectEncoderContext2.add(f13124b, qVar.f13160a);
        objectEncoderContext2.add(f13125c, qVar.f13161b);
    }
}
