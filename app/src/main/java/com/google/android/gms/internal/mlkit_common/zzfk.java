package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfk implements ObjectEncoder {
    static final zzfk zza = new zzfk();
    private static final FieldDescriptor zzb = a.g(1, FieldDescriptor.builder("modelType"));
    private static final FieldDescriptor zzc = a.g(2, FieldDescriptor.builder("isSuccessful"));
    private static final FieldDescriptor zzd = a.g(3, FieldDescriptor.builder("modelName"));

    private zzfk() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzlo zzloVar = (zzlo) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzloVar.zza());
        objectEncoderContext2.add(zzc, zzloVar.zzb());
        objectEncoderContext2.add(zzd, (Object) null);
    }
}
