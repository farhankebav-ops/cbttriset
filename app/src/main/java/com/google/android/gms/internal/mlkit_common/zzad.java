package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzad extends zzv {
    private final zzaf zza;

    public zzad(zzaf zzafVar, int i2) {
        super(zzafVar.size(), i2);
        this.zza = zzafVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzv
    public final Object zza(int i2) {
        return this.zza.get(i2);
    }
}
