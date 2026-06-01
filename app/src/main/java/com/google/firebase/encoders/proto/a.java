package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5602a;

    public /* synthetic */ a(int i2) {
        this.f5602a = i2;
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        switch (this.f5602a) {
            case 0:
                ProtobufDataEncoderContext.lambda$static$0((Map.Entry) obj, objectEncoderContext);
                break;
            default:
                ProtobufEncoder.Builder.lambda$static$0(obj, objectEncoderContext);
                break;
        }
    }
}
