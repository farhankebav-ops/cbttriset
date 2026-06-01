package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgq implements ObjectEncoder {
    static final zzgq zza = new zzgq();
    private static final FieldDescriptor zzb = a.g(1, FieldDescriptor.builder("options"));
    private static final FieldDescriptor zzc = a.g(2, FieldDescriptor.builder("roughDownloadDurationMs"));
    private static final FieldDescriptor zzd = a.g(3, FieldDescriptor.builder(IronSourceConstants.EVENTS_ERROR_CODE));
    private static final FieldDescriptor zze = a.g(4, FieldDescriptor.builder("exactDownloadDurationMs"));
    private static final FieldDescriptor zzf = a.g(5, FieldDescriptor.builder("downloadStatus"));
    private static final FieldDescriptor zzg = a.g(6, FieldDescriptor.builder("downloadFailureStatus"));
    private static final FieldDescriptor zzh = a.g(7, FieldDescriptor.builder("mddDownloadErrorCodes"));

    private zzgq() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zznc zzncVar = (zznc) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzncVar.zzc());
        objectEncoderContext2.add(zzc, zzncVar.zzf());
        objectEncoderContext2.add(zzd, zzncVar.zza());
        objectEncoderContext2.add(zze, zzncVar.zze());
        objectEncoderContext2.add(zzf, zzncVar.zzb());
        objectEncoderContext2.add(zzg, zzncVar.zzd());
        objectEncoderContext2.add(zzh, (Object) null);
    }
}
