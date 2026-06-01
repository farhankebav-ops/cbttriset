package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfvw extends x5.c {
    Object zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zzfwo zzc;
    int zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfvw(zzfwo zzfwoVar, v5.c cVar) {
        super(cVar);
        this.zzc = zzfwoVar;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.zzb = obj;
        this.zzd |= Integer.MIN_VALUE;
        return this.zzc.zzt(this);
    }
}
