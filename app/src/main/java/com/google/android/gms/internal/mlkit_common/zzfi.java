package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfi implements ObjectEncoder {
    static final zzfi zza = new zzfi();

    static {
        a.l(5, a.f(4, a.f(3, a.f(2, a.f(1, FieldDescriptor.builder("inferenceCommonLogEvent"), "options"), "inputsFormats"), "outputFormats"), "modelInitializationMs"));
    }

    private zzfi() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
