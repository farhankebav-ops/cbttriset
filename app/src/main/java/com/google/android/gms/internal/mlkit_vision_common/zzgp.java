package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgp implements ObjectEncoder {
    static final zzgp zza = new zzgp();
    private static final FieldDescriptor zzb = a.D(1, FieldDescriptor.builder("deviceInfo"));
    private static final FieldDescriptor zzc = a.D(2, FieldDescriptor.builder("nnapiInfo"));
    private static final FieldDescriptor zzd = a.D(3, FieldDescriptor.builder("gpuInfo"));
    private static final FieldDescriptor zze = a.D(4, FieldDescriptor.builder("pipelineIdentifier"));
    private static final FieldDescriptor zzf = a.D(5, FieldDescriptor.builder("acceptedConfigurations"));
    private static final FieldDescriptor zzg = a.D(6, FieldDescriptor.builder("action"));
    private static final FieldDescriptor zzh = a.D(7, FieldDescriptor.builder("status"));
    private static final FieldDescriptor zzi = a.D(8, FieldDescriptor.builder("customErrors"));
    private static final FieldDescriptor zzj = a.D(9, FieldDescriptor.builder("benchmarkStatus"));
    private static final FieldDescriptor zzk = a.D(10, FieldDescriptor.builder("validationTestResult"));
    private static final FieldDescriptor zzl = a.D(11, FieldDescriptor.builder("timestampUs"));
    private static final FieldDescriptor zzm = a.D(12, FieldDescriptor.builder("elapsedUs"));

    private zzgp() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
