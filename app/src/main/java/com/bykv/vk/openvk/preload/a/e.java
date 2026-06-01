package com.bykv.vk.openvk.preload.a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private String g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.a.b.c f4865a = com.bykv.vk.openvk.preload.a.b.c.f4799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private q f4866b = q.f4875a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f4867c = b.f4697a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Type, f<?>> f4868d = new HashMap();
    private final List<s> e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<s> f4869f = new ArrayList();
    private int h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4870i = 2;
    private boolean j = true;

    public final e a(Type type, Object obj) {
        com.bykv.vk.openvk.preload.falconx.a.a.a(true);
        this.e.add(com.bykv.vk.openvk.preload.a.b.a.m.a(com.bykv.vk.openvk.preload.a.c.a.a(type), (r) obj));
        return this;
    }

    public final d a() {
        a aVar;
        a aVar2;
        a aVar3;
        ArrayList arrayList = new ArrayList(this.f4869f.size() + this.e.size() + 3);
        arrayList.addAll(this.e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f4869f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        String str = this.g;
        int i2 = this.h;
        int i8 = this.f4870i;
        if (str != null && !"".equals(str.trim())) {
            aVar = new a(Date.class, str);
            aVar2 = new a(Timestamp.class, str);
            aVar3 = new a(java.sql.Date.class, str);
        } else {
            if (i2 != 2 && i8 != 2) {
                a aVar4 = new a(Date.class, i2, i8);
                a aVar5 = new a(Timestamp.class, i2, i8);
                a aVar6 = new a(java.sql.Date.class, i2, i8);
                aVar = aVar4;
                aVar2 = aVar5;
                aVar3 = aVar6;
            }
            return new d(this.f4865a, this.f4867c, this.f4868d, this.j, this.f4866b, arrayList);
        }
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Date.class, aVar));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Timestamp.class, aVar2));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(java.sql.Date.class, aVar3));
        return new d(this.f4865a, this.f4867c, this.f4868d, this.j, this.f4866b, arrayList);
    }
}
