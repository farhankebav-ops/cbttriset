package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhwh implements zzhxx {
    private static final zzhwh zza = new zzhwh();

    private zzhwh() {
    }

    public static zzhwh zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhxx
    public final boolean zzb(Class cls) {
        return zzhwo.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzhxx
    public final zzhxw zzc(Class cls) {
        if (!zzhwo.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzhxw) zzhwo.zzbt(cls.asSubclass(zzhwo.class)).zzbs();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }
}
