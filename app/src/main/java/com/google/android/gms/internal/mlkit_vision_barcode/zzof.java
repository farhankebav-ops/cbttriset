package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzof implements ObjectEncoder {
    static final zzof zza = new zzof();
    private static final FieldDescriptor zzb = a.y(1, FieldDescriptor.builder("xMin"));
    private static final FieldDescriptor zzc = a.y(2, FieldDescriptor.builder("yMin"));
    private static final FieldDescriptor zzd = a.y(3, FieldDescriptor.builder("xMax"));
    private static final FieldDescriptor zze = a.y(4, FieldDescriptor.builder("yMax"));
    private static final FieldDescriptor zzf = a.y(5, FieldDescriptor.builder("confidenceScore"));

    private zzof() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzur zzurVar = (zzur) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzurVar.zzc());
        objectEncoderContext2.add(zzc, zzurVar.zze());
        objectEncoderContext2.add(zzd, zzurVar.zzb());
        objectEncoderContext2.add(zze, zzurVar.zzd());
        objectEncoderContext2.add(zzf, zzurVar.zza());
    }
}
