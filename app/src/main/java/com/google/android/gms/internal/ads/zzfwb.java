package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfwb extends x5.i implements e6.p {
    /* synthetic */ Object zza;
    final /* synthetic */ zzfvg zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfwb(zzfvg zzfvgVar, v5.c cVar) {
        super(2, cVar);
        this.zzb = zzfvgVar;
    }

    @Override // x5.a
    public final v5.c create(Object obj, v5.c cVar) {
        zzfwb zzfwbVar = new zzfwb(this.zzb, cVar);
        zzfwbVar.zza = obj;
        return zzfwbVar;
    }

    @Override // e6.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfwb) create((zzfvk) obj, (v5.c) obj2)).invokeSuspend(q5.x.f13520a);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        r2.q.z0(obj);
        zzfvm zzfvmVarZza = zzfvl.zza((zzfvi) ((zzfvk) this.zza).zzcc());
        zzhzs zzhzsVarZzb = zzfvmVarZza.zzb();
        zzfvg zzfvgVar = this.zzb;
        String strZza = zzfvgVar.zza();
        kotlin.jvm.internal.k.d(strZza, "getGwsQueryId(...)");
        zzfvmVarZza.zzc(zzhzsVarZzb, strZza, zzfvgVar);
        return zzfvmVarZza.zza();
    }
}
