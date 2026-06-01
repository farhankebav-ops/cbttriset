package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhl implements ObjectEncoder {
    static final zzhl zza = new zzhl();
    private static final FieldDescriptor zzb = a.y(1, FieldDescriptor.builder(IronSourceConstants.EVENTS_ERROR_CODE));
    private static final FieldDescriptor zzc = a.y(2, FieldDescriptor.builder("hasResult"));
    private static final FieldDescriptor zzd = a.y(3, FieldDescriptor.builder("isColdCall"));
    private static final FieldDescriptor zze = a.y(4, FieldDescriptor.builder("imageInfo"));
    private static final FieldDescriptor zzf = a.y(5, FieldDescriptor.builder("options"));
    private static final FieldDescriptor zzg = a.y(6, FieldDescriptor.builder("detectedBarcodeFormats"));
    private static final FieldDescriptor zzh = a.y(7, FieldDescriptor.builder("detectedBarcodeValueTypes"));

    private zzhl() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzft zzftVar = (zzft) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzftVar.zzc());
        objectEncoderContext2.add(zzc, (Object) null);
        objectEncoderContext2.add(zzd, zzftVar.zze());
        objectEncoderContext2.add(zze, (Object) null);
        objectEncoderContext2.add(zzf, zzftVar.zzd());
        objectEncoderContext2.add(zzg, zzftVar.zza());
        objectEncoderContext2.add(zzh, zzftVar.zzb());
    }
}
