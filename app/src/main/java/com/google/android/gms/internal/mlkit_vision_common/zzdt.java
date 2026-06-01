package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdt implements ObjectEncoder {
    static final zzdt zza = new zzdt();
    private static final FieldDescriptor zzb = a.D(1, FieldDescriptor.builder("sdkVersion"));
    private static final FieldDescriptor zzc = a.D(2, FieldDescriptor.builder("osBuild"));
    private static final FieldDescriptor zzd = a.D(3, FieldDescriptor.builder("brand"));
    private static final FieldDescriptor zze = a.D(4, FieldDescriptor.builder(C2300e4.h.G));
    private static final FieldDescriptor zzf = a.D(5, FieldDescriptor.builder("hardware"));
    private static final FieldDescriptor zzg = a.D(6, FieldDescriptor.builder("manufacturer"));
    private static final FieldDescriptor zzh = a.D(7, FieldDescriptor.builder(Q6.B));
    private static final FieldDescriptor zzi = a.D(8, FieldDescriptor.builder("product"));
    private static final FieldDescriptor zzj = a.D(9, FieldDescriptor.builder("soc"));
    private static final FieldDescriptor zzk = a.D(10, FieldDescriptor.builder("socMetaBuildId"));

    private zzdt() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
