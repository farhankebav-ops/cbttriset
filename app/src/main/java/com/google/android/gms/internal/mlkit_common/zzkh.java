package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkh implements ObjectEncoder {
    static final zzkh zza = new zzkh();
    private static final FieldDescriptor zzb = a.g(1, FieldDescriptor.builder(RemoteConfigConstants.RequestFieldKey.APP_ID));
    private static final FieldDescriptor zzc = a.g(2, FieldDescriptor.builder("appVersion"));
    private static final FieldDescriptor zzd = a.g(3, FieldDescriptor.builder("firebaseProjectId"));
    private static final FieldDescriptor zze = a.g(4, FieldDescriptor.builder("mlSdkVersion"));
    private static final FieldDescriptor zzf = a.g(5, FieldDescriptor.builder("tfliteSchemaVersion"));
    private static final FieldDescriptor zzg = a.g(6, FieldDescriptor.builder("gcmSenderId"));
    private static final FieldDescriptor zzh = a.g(7, FieldDescriptor.builder("apiKey"));
    private static final FieldDescriptor zzi = a.g(8, FieldDescriptor.builder("languages"));
    private static final FieldDescriptor zzj = a.g(9, FieldDescriptor.builder("mlSdkInstanceId"));
    private static final FieldDescriptor zzk = a.g(10, FieldDescriptor.builder("isClearcutClient"));
    private static final FieldDescriptor zzl = a.g(11, FieldDescriptor.builder("isStandaloneMlkit"));
    private static final FieldDescriptor zzm = a.g(12, FieldDescriptor.builder("isJsonLogging"));
    private static final FieldDescriptor zzn = a.g(13, FieldDescriptor.builder("buildLevel"));
    private static final FieldDescriptor zzo = a.g(14, FieldDescriptor.builder("optionalModuleVersion"));

    private zzkh() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzqv zzqvVar = (zzqv) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzqvVar.zzg());
        objectEncoderContext2.add(zzc, zzqvVar.zzh());
        objectEncoderContext2.add(zzd, (Object) null);
        objectEncoderContext2.add(zze, zzqvVar.zzj());
        objectEncoderContext2.add(zzf, zzqvVar.zzk());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, zzqvVar.zza());
        objectEncoderContext2.add(zzj, zzqvVar.zzi());
        objectEncoderContext2.add(zzk, zzqvVar.zzb());
        objectEncoderContext2.add(zzl, zzqvVar.zzd());
        objectEncoderContext2.add(zzm, zzqvVar.zzc());
        objectEncoderContext2.add(zzn, zzqvVar.zze());
        objectEncoderContext2.add(zzo, zzqvVar.zzf());
    }
}
