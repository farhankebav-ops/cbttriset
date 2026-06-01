package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgo implements ObjectEncoder {
    static final zzgo zza = new zzgo();
    private static final FieldDescriptor zzb = a.D(1, FieldDescriptor.builder("pipelineNamespace"));
    private static final FieldDescriptor zzc = a.D(2, FieldDescriptor.builder("name"));
    private static final FieldDescriptor zzd = a.D(3, FieldDescriptor.builder("clientLibraryName"));
    private static final FieldDescriptor zze = a.D(4, FieldDescriptor.builder("clientLibraryVersion"));
    private static final FieldDescriptor zzf = a.D(5, FieldDescriptor.builder("minClientLibraryVersion"));
    private static final FieldDescriptor zzg = a.D(6, FieldDescriptor.builder("maxClientLibraryVersion"));
    private static final FieldDescriptor zzh = a.D(7, FieldDescriptor.builder("sourceProduct"));

    private zzgo() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
