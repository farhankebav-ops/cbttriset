package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgr implements ObjectEncoder {
    static final zzgr zza = new zzgr();
    private static final FieldDescriptor zzb = a.g(1, FieldDescriptor.builder("name"));
    private static final FieldDescriptor zzc = a.g(2, FieldDescriptor.builder("version"));
    private static final FieldDescriptor zzd = a.g(3, FieldDescriptor.builder("source"));
    private static final FieldDescriptor zze = a.g(4, FieldDescriptor.builder("uri"));
    private static final FieldDescriptor zzf = a.g(5, FieldDescriptor.builder("hash"));
    private static final FieldDescriptor zzg = a.g(6, FieldDescriptor.builder("modelType"));
    private static final FieldDescriptor zzh = a.g(7, FieldDescriptor.builder("size"));
    private static final FieldDescriptor zzi = a.g(8, FieldDescriptor.builder("hasLabelMap"));
    private static final FieldDescriptor zzj = a.g(9, FieldDescriptor.builder("isManifestModel"));

    private zzgr() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zznh zznhVar = (zznh) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zznhVar.zzd());
        objectEncoderContext2.add(zzc, (Object) null);
        objectEncoderContext2.add(zzd, zznhVar.zzb());
        objectEncoderContext2.add(zze, (Object) null);
        objectEncoderContext2.add(zzf, zznhVar.zzc());
        objectEncoderContext2.add(zzg, zznhVar.zza());
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, (Object) null);
        objectEncoderContext2.add(zzj, (Object) null);
    }
}
