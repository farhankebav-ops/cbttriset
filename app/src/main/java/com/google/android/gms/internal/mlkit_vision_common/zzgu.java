package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgu implements ObjectEncoder {
    static final zzgu zza = new zzgu();
    private static final FieldDescriptor zzb = a.D(1, FieldDescriptor.builder(RemoteConfigConstants.RequestFieldKey.APP_ID));
    private static final FieldDescriptor zzc = a.D(2, FieldDescriptor.builder("appVersion"));
    private static final FieldDescriptor zzd = a.D(3, FieldDescriptor.builder("firebaseProjectId"));
    private static final FieldDescriptor zze = a.D(4, FieldDescriptor.builder("mlSdkVersion"));
    private static final FieldDescriptor zzf = a.D(5, FieldDescriptor.builder("tfliteSchemaVersion"));
    private static final FieldDescriptor zzg = a.D(6, FieldDescriptor.builder("gcmSenderId"));
    private static final FieldDescriptor zzh = a.D(7, FieldDescriptor.builder("apiKey"));
    private static final FieldDescriptor zzi = a.D(8, FieldDescriptor.builder("languages"));
    private static final FieldDescriptor zzj = a.D(9, FieldDescriptor.builder("mlSdkInstanceId"));
    private static final FieldDescriptor zzk = a.D(10, FieldDescriptor.builder("isClearcutClient"));
    private static final FieldDescriptor zzl = a.D(11, FieldDescriptor.builder("isStandaloneMlkit"));
    private static final FieldDescriptor zzm = a.D(12, FieldDescriptor.builder("isJsonLogging"));
    private static final FieldDescriptor zzn = a.D(13, FieldDescriptor.builder("buildLevel"));
    private static final FieldDescriptor zzo = a.D(14, FieldDescriptor.builder("optionalModuleVersion"));

    private zzgu() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzla zzlaVar = (zzla) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzlaVar.zzg());
        objectEncoderContext2.add(zzc, zzlaVar.zzh());
        objectEncoderContext2.add(zzd, (Object) null);
        objectEncoderContext2.add(zze, zzlaVar.zzj());
        objectEncoderContext2.add(zzf, zzlaVar.zzk());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, zzlaVar.zza());
        objectEncoderContext2.add(zzj, zzlaVar.zzi());
        objectEncoderContext2.add(zzk, zzlaVar.zzb());
        objectEncoderContext2.add(zzl, zzlaVar.zzd());
        objectEncoderContext2.add(zzm, zzlaVar.zzc());
        objectEncoderContext2.add(zzn, zzlaVar.zze());
        objectEncoderContext2.add(zzo, zzlaVar.zzf());
    }
}
