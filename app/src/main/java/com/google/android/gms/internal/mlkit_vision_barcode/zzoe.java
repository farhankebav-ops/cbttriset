package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzoe implements ObjectEncoder {
    static final zzoe zza = new zzoe();
    private static final FieldDescriptor zzb = a.y(1, FieldDescriptor.builder("appName"));
    private static final FieldDescriptor zzc = a.y(2, FieldDescriptor.builder(JsonStorageKeyNames.SESSION_ID_KEY));
    private static final FieldDescriptor zzd = a.y(3, FieldDescriptor.builder("startZoomLevel"));
    private static final FieldDescriptor zze = a.y(4, FieldDescriptor.builder("endZoomLevel"));
    private static final FieldDescriptor zzf = a.y(5, FieldDescriptor.builder("durationMs"));
    private static final FieldDescriptor zzg = a.y(6, FieldDescriptor.builder("predictedArea"));

    private zzoe() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzut zzutVar = (zzut) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzutVar.zze());
        objectEncoderContext2.add(zzc, zzutVar.zzf());
        objectEncoderContext2.add(zzd, zzutVar.zzc());
        objectEncoderContext2.add(zze, zzutVar.zzb());
        objectEncoderContext2.add(zzf, zzutVar.zzd());
        objectEncoderContext2.add(zzg, zzutVar.zza());
    }
}
