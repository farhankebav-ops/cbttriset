package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzon implements ObjectEncoder {
    static final zzon zza = new zzon();
    private static final FieldDescriptor zzb = a.y(1, FieldDescriptor.builder(RemoteConfigConstants.RequestFieldKey.APP_ID));
    private static final FieldDescriptor zzc = a.y(2, FieldDescriptor.builder("appVersion"));
    private static final FieldDescriptor zzd = a.y(3, FieldDescriptor.builder("firebaseProjectId"));
    private static final FieldDescriptor zze = a.y(4, FieldDescriptor.builder("mlSdkVersion"));
    private static final FieldDescriptor zzf = a.y(5, FieldDescriptor.builder("tfliteSchemaVersion"));
    private static final FieldDescriptor zzg = a.y(6, FieldDescriptor.builder("gcmSenderId"));
    private static final FieldDescriptor zzh = a.y(7, FieldDescriptor.builder("apiKey"));
    private static final FieldDescriptor zzi = a.y(8, FieldDescriptor.builder("languages"));
    private static final FieldDescriptor zzj = a.y(9, FieldDescriptor.builder("mlSdkInstanceId"));
    private static final FieldDescriptor zzk = a.y(10, FieldDescriptor.builder("isClearcutClient"));
    private static final FieldDescriptor zzl = a.y(11, FieldDescriptor.builder("isStandaloneMlkit"));
    private static final FieldDescriptor zzm = a.y(12, FieldDescriptor.builder("isJsonLogging"));
    private static final FieldDescriptor zzn = a.y(13, FieldDescriptor.builder("buildLevel"));
    private static final FieldDescriptor zzo = a.y(14, FieldDescriptor.builder("optionalModuleVersion"));

    private zzon() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzvd zzvdVar = (zzvd) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzvdVar.zzg());
        objectEncoderContext2.add(zzc, zzvdVar.zzh());
        objectEncoderContext2.add(zzd, (Object) null);
        objectEncoderContext2.add(zze, zzvdVar.zzj());
        objectEncoderContext2.add(zzf, zzvdVar.zzk());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, zzvdVar.zza());
        objectEncoderContext2.add(zzj, zzvdVar.zzi());
        objectEncoderContext2.add(zzk, zzvdVar.zzb());
        objectEncoderContext2.add(zzl, zzvdVar.zzd());
        objectEncoderContext2.add(zzm, zzvdVar.zzc());
        objectEncoderContext2.add(zzn, zzvdVar.zze());
        objectEncoderContext2.add(zzo, zzvdVar.zzf());
    }
}
