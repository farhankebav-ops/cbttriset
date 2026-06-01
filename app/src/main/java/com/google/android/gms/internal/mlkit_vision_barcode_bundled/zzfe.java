package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfe implements zzgf {
    private static final zzfk zza = new zzfc();
    private final zzfk zzb;

    public zzfe() {
        zzea zzeaVarZza = zzea.zza();
        int i2 = zzfu.zza;
        zzfd zzfdVar = new zzfd(zzeaVarZza, zza);
        byte[] bArr = zzep.zzb;
        this.zzb = zzfdVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgf
    public final zzge zza(Class cls) {
        int i2 = zzgg.zza;
        if (!zzeh.class.isAssignableFrom(cls)) {
            int i8 = zzfu.zza;
        }
        zzfj zzfjVarZzb = this.zzb.zzb(cls);
        if (zzfjVarZzb.zzb()) {
            int i9 = zzfu.zza;
            return zzfq.zzc(zzgg.zzm(), zzdv.zza(), zzfjVarZzb.zza());
        }
        int i10 = zzfu.zza;
        return zzfp.zzl(cls, zzfjVarZzb, zzft.zza(), zzfa.zza(), zzgg.zzm(), zzfjVarZzb.zzc() + (-1) != 1 ? zzdv.zza() : null, zzfi.zza());
    }
}
