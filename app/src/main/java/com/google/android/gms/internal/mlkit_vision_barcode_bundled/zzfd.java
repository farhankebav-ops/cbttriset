package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfd implements zzfk {
    private final zzfk[] zza;

    public zzfd(zzfk... zzfkVarArr) {
        this.zza = zzfkVarArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfk
    public final zzfj zzb(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            zzfk zzfkVar = this.zza[i2];
            if (zzfkVar.zzc(cls)) {
                return zzfkVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfk
    public final boolean zzc(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.zza[i2].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
