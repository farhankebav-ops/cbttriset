package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class zzbt extends zzdh {
    final /* synthetic */ zzbv zza;

    public zzbt(zzbv zzbvVar) {
        this.zza = zzbvVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdh
    public final zzdg zza() {
        return this.zza;
    }
}
