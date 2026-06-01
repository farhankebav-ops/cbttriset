package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.ironsource.C2300e4;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzeb implements ObjectEncoder {
    static final zzeb zza = new zzeb();
    private static final FieldDescriptor zzb = a.D(1, FieldDescriptor.builder(C2300e4.a.f8302t));
    private static final FieldDescriptor zzc = a.D(2, FieldDescriptor.builder("landmark"));
    private static final FieldDescriptor zzd = a.D(3, FieldDescriptor.builder("classification"));
    private static final FieldDescriptor zze = a.D(4, FieldDescriptor.builder("prominentFaceOnly"));
    private static final FieldDescriptor zzf = a.D(5, FieldDescriptor.builder("tracking"));
    private static final FieldDescriptor zzg = a.D(6, FieldDescriptor.builder("minFaceSize"));

    private zzeb() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
