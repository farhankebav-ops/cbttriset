package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkk implements ObjectEncoder {
    static final zzkk zza = new zzkk();
    private static final FieldDescriptor zzb = a.y(1, FieldDescriptor.builder("durationMs"));
    private static final FieldDescriptor zzc = a.y(2, FieldDescriptor.builder(IronSourceConstants.EVENTS_ERROR_CODE));
    private static final FieldDescriptor zzd = a.y(3, FieldDescriptor.builder("isColdCall"));
    private static final FieldDescriptor zze = a.y(4, FieldDescriptor.builder("autoManageModelOnBackground"));
    private static final FieldDescriptor zzf = a.y(5, FieldDescriptor.builder("autoManageModelOnLowMemory"));
    private static final FieldDescriptor zzg = a.y(6, FieldDescriptor.builder("isNnApiEnabled"));
    private static final FieldDescriptor zzh = a.y(7, FieldDescriptor.builder("eventsCount"));
    private static final FieldDescriptor zzi = a.y(8, FieldDescriptor.builder("otherErrors"));
    private static final FieldDescriptor zzj = a.y(9, FieldDescriptor.builder("remoteConfigValueForAcceleration"));
    private static final FieldDescriptor zzk = a.y(10, FieldDescriptor.builder("isAccelerated"));

    private zzkk() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzqq zzqqVar = (zzqq) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzqqVar.zze());
        objectEncoderContext2.add(zzc, zzqqVar.zza());
        objectEncoderContext2.add(zzd, zzqqVar.zzd());
        objectEncoderContext2.add(zze, zzqqVar.zzb());
        objectEncoderContext2.add(zzf, zzqqVar.zzc());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, (Object) null);
        objectEncoderContext2.add(zzj, (Object) null);
        objectEncoderContext2.add(zzk, (Object) null);
    }
}
