package com.google.android.gms.internal.common;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzae extends zzz {
    private final zzah zza;

    public zzae(zzah zzahVar, int i2) {
        super(zzahVar.size(), i2);
        this.zza = zzahVar;
    }

    @Override // com.google.android.gms.internal.common.zzz
    public final Object zza(int i2) {
        return this.zza.get(i2);
    }
}
