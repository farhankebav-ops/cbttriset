package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhtr extends zzhtv {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhtr(zzhts zzhtsVar) {
        super(zzhtsVar.zza);
        Objects.requireNonNull(zzhtsVar);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return zza();
    }
}
