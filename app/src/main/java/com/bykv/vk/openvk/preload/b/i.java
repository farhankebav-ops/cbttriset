package com.bykv.vk.openvk.preload.b;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected e f4895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<h> f4897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f4898d;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends Exception {
        public a(Throwable th) {
            super(th);
        }
    }

    public i(List<h> list, int i2, e eVar, d dVar) {
        this.f4897c = list;
        this.f4896b = i2;
        this.f4895a = eVar;
        this.f4898d = dVar;
    }

    private d c(Class cls) {
        d dVar = this.f4898d;
        while (dVar != null && dVar.getClass() != cls) {
            dVar = dVar.f4880a;
        }
        return dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bykv.vk.openvk.preload.b.b
    public final Object a(Object obj) throws Exception {
        d dVar = this.f4898d;
        if (dVar != null) {
            dVar.f4882c = obj;
            dVar.e();
        }
        if (this.f4896b >= this.f4897c.size()) {
            return obj;
        }
        h hVar = this.f4897c.get(this.f4896b);
        Class<? extends d> cls = hVar.f4889a;
        d dVar2 = (d) this.f4895a.a(cls);
        if (dVar2 == null) {
            throw new IllegalArgumentException("interceptor == null , index = " + obj + " , class: " + cls);
        }
        com.bykv.vk.openvk.preload.b.b.a aVarA = hVar.a();
        i iVar = new i(this.f4897c, this.f4896b + 1, this.f4895a, dVar2);
        dVar2.a(iVar, this.f4898d, obj, aVarA, hVar.b());
        dVar2.c();
        try {
            Object objA = dVar2.a(iVar, obj);
            dVar2.d();
            return objA;
        } catch (a e) {
            dVar2.c(e.getCause());
            throw e;
        } catch (Throwable th) {
            dVar2.b(th);
            throw new a(th);
        }
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final Object b(Class cls) {
        d dVarC = c(cls);
        if (dVarC != null) {
            return dVarC.f4882c;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:".concat(String.valueOf(cls)));
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final Object a(Class cls) {
        d dVarC = c(cls);
        if (dVarC != null) {
            return dVarC.f4881b;
        }
        throw new IllegalArgumentException("can not find pre Interceptor , class:".concat(String.valueOf(cls)));
    }
}
