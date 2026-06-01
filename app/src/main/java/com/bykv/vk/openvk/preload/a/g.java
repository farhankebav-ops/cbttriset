package com.bykv.vk.openvk.preload.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends i implements Iterable<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<i> f4871a = new ArrayList();

    public final void a(i iVar) {
        if (iVar == null) {
            iVar = k.f4872a;
        }
        this.f4871a.add(iVar);
    }

    @Override // com.bykv.vk.openvk.preload.a.i
    public final String b() {
        if (this.f4871a.size() == 1) {
            return this.f4871a.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // com.bykv.vk.openvk.preload.a.i
    public final boolean c() {
        if (this.f4871a.size() == 1) {
            return this.f4871a.get(0).c();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof g) && ((g) obj).f4871a.equals(this.f4871a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f4871a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator<i> iterator() {
        return this.f4871a.iterator();
    }

    @Override // com.bykv.vk.openvk.preload.a.i
    public final Number a() {
        if (this.f4871a.size() == 1) {
            return this.f4871a.get(0).a();
        }
        throw new IllegalStateException();
    }
}
