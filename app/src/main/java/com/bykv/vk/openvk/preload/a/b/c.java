package com.bykv.vk.openvk.preload.a.b;

import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements s, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f4799a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f4800b = -1.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4801c = Sdk.SDKError.Reason.PRIVACY_URL_ERROR_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4802d = true;
    private List<com.bykv.vk.openvk.preload.geckox.a.a.c> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.bykv.vk.openvk.preload.geckox.a.a.c> f4803f;

    public c() {
        List<com.bykv.vk.openvk.preload.geckox.a.a.c> list = Collections.EMPTY_LIST;
        this.e = list;
        this.f4803f = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    private static boolean b(Class<?> cls) {
        if (Enum.class.isAssignableFrom(cls)) {
            return false;
        }
        return cls.isAnonymousClass() || cls.isLocalClass();
    }

    private static boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    private static boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    @Override // com.bykv.vk.openvk.preload.a.s
    public final <T> r<T> a(final com.bykv.vk.openvk.preload.a.d dVar, final com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        boolean zA = a(aVar.a());
        final boolean z2 = zA || a(true);
        final boolean z7 = zA || a(false);
        if (z2 || z7) {
            return new r<T>() { // from class: com.bykv.vk.openvk.preload.a.b.c.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private r<T> f4804a;

                private r<T> b() {
                    r<T> rVar = this.f4804a;
                    if (rVar != null) {
                        return rVar;
                    }
                    r<T> rVarA = dVar.a(c.this, aVar);
                    this.f4804a = rVarA;
                    return rVarA;
                }

                @Override // com.bykv.vk.openvk.preload.a.r
                public final T a(com.bykv.vk.openvk.preload.a.d.a aVar2) throws IOException {
                    if (!z7) {
                        return b().a(aVar2);
                    }
                    aVar2.n();
                    return null;
                }

                @Override // com.bykv.vk.openvk.preload.a.r
                public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t3) throws IOException {
                    if (z2) {
                        cVar.h();
                    } else {
                        b().a(cVar, t3);
                    }
                }
            };
        }
        return null;
    }

    public final boolean a(Field field, boolean z2) {
        if ((this.f4801c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f4800b != -1.0d && !a((com.bykv.vk.openvk.preload.a.a.c) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.c.class), (com.bykv.vk.openvk.preload.a.a.d) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.d.class))) || field.isSynthetic()) {
            return true;
        }
        if ((!this.f4802d && c(field.getType())) || b(field.getType())) {
            return true;
        }
        List<com.bykv.vk.openvk.preload.geckox.a.a.c> list = z2 ? this.e : this.f4803f;
        if (list.isEmpty()) {
            return false;
        }
        new com.bykv.vk.openvk.preload.geckox.a.c(field);
        Iterator<com.bykv.vk.openvk.preload.geckox.a.a.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().b()) {
                return true;
            }
        }
        return false;
    }

    private boolean a(Class<?> cls) {
        if (this.f4800b == -1.0d || a((com.bykv.vk.openvk.preload.a.a.c) cls.getAnnotation(com.bykv.vk.openvk.preload.a.a.c.class), (com.bykv.vk.openvk.preload.a.a.d) cls.getAnnotation(com.bykv.vk.openvk.preload.a.a.d.class))) {
            return (!this.f4802d && c(cls)) || b(cls);
        }
        return true;
    }

    public final boolean a(Class<?> cls, boolean z2) {
        return a(cls) || a(z2);
    }

    private boolean a(boolean z2) {
        Iterator<com.bykv.vk.openvk.preload.geckox.a.a.c> it = (z2 ? this.e : this.f4803f).iterator();
        while (it.hasNext()) {
            if (it.next().c()) {
                return true;
            }
        }
        return false;
    }

    private boolean a(com.bykv.vk.openvk.preload.a.a.c cVar, com.bykv.vk.openvk.preload.a.a.d dVar) {
        return a(cVar) && a(dVar);
    }

    private boolean a(com.bykv.vk.openvk.preload.a.a.c cVar) {
        return cVar == null || cVar.a() <= this.f4800b;
    }

    private boolean a(com.bykv.vk.openvk.preload.a.a.d dVar) {
        return dVar == null || dVar.a() > this.f4800b;
    }
}
