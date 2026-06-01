package com.bykv.vk.openvk.preload.b;

import com.bykv.vk.openvk.preload.b.i;
import com.bykv.vk.openvk.preload.b.l;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j<IN, OUT> extends l<IN, OUT> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4899d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bykv.vk.openvk.preload.b.d
    public final Object a(b<OUT> bVar, IN in) throws Throwable {
        new m(bVar);
        this.f4899d = a(in);
        l.a aVar = a().get(this.f4899d);
        while (aVar != null) {
            List<h> list = aVar.f4902a;
            try {
                Object objA = c.a(list, bVar.f4895a, this).a(in);
                return !l.a(list) ? objA : bVar.a(objA);
            } catch (i.a e) {
                Throwable cause = e.getCause();
                new m(bVar);
                this.f4899d = a(in, cause, this.f4899d);
                aVar = a().get(this.f4899d);
            } catch (Throwable th) {
                new m(bVar);
                this.f4899d = a(in, th, this.f4899d);
                aVar = a().get(this.f4899d);
            }
        }
        throw new IllegalArgumentException("can not found branch，branch name is：" + this.f4899d);
    }

    public abstract String a(IN in);

    public abstract String a(IN in, Throwable th, String str);
}
