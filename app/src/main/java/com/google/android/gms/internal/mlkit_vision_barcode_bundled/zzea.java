package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzea implements zzfk {
    private static final zzea zza = new zzea();

    private zzea() {
    }

    public static zzea zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfk
    public final zzfj zzb(Class cls) {
        if (!zzeh.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzfj) zzeh.zzJ(cls.asSubclass(zzeh.class)).zzg(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfk
    public final boolean zzc(Class cls) {
        return zzeh.class.isAssignableFrom(cls);
    }
}
