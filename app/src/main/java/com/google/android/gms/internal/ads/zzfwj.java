package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfwj extends x5.i implements e6.p {
    int zza;
    final /* synthetic */ zzfwo zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfwj(zzfwo zzfwoVar, v5.c cVar) {
        super(2, cVar);
        this.zzb = zzfwoVar;
    }

    @Override // x5.a
    public final v5.c create(Object obj, v5.c cVar) {
        return new zzfwj(this.zzb, cVar);
    }

    @Override // e6.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfwj) create((q6.a0) obj, (v5.c) obj2)).invokeSuspend(q5.x.f13520a);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.zza;
        r2.q.z0(obj);
        if (i2 == 0) {
            zzfwo zzfwoVar = this.zzb;
            this.zza = 1;
            if (zzfwoVar.zzh(this) == aVar) {
                return aVar;
            }
        }
        return q5.x.f13520a;
    }
}
