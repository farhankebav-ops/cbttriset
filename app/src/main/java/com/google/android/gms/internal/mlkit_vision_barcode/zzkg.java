package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkg implements ObjectEncoder {
    static final zzkg zza = new zzkg();
    private static final FieldDescriptor zzb = a.y(1, FieldDescriptor.builder("imageFormat"));
    private static final FieldDescriptor zzc = a.y(2, FieldDescriptor.builder("originalImageSize"));
    private static final FieldDescriptor zzd = a.y(3, FieldDescriptor.builder("compressedImageSize"));
    private static final FieldDescriptor zze = a.y(4, FieldDescriptor.builder("isOdmlImage"));

    private zzkg() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzqk zzqkVar = (zzqk) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzqkVar.zza());
        objectEncoderContext2.add(zzc, zzqkVar.zzb());
        objectEncoderContext2.add(zzd, (Object) null);
        objectEncoderContext2.add(zze, (Object) null);
    }
}
