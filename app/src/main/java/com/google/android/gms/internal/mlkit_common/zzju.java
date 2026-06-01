package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzju implements ObjectEncoder {
    static final zzju zza = new zzju();

    static {
        a.l(12, a.f(11, a.f(10, a.f(9, a.f(8, a.f(7, a.f(6, a.f(5, a.f(4, a.f(3, a.f(2, a.f(1, FieldDescriptor.builder("deviceInfo"), "nnapiInfo"), "gpuInfo"), "pipelineIdentifier"), "acceptedConfigurations"), "action"), "status"), "customErrors"), "benchmarkStatus"), "validationTestResult"), "timestampUs"), "elapsedUs"));
    }

    private zzju() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
