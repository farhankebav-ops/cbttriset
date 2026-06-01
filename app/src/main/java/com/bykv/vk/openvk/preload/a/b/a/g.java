package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.r;
import com.bykv.vk.openvk.preload.a.s;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends r<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f4724a = new s() { // from class: com.bykv.vk.openvk.preload.a.b.a.g.1
        @Override // com.bykv.vk.openvk.preload.a.s
        public final <T> r<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
            if (aVar.a() == Object.class) {
                return new g(dVar);
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.d f4725b;

    /* JADX INFO: renamed from: com.bykv.vk.openvk.preload.a.b.a.g$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4726a;

        static {
            int[] iArr = new int[com.bykv.vk.openvk.preload.a.d.b.values().length];
            f4726a = iArr;
            try {
                iArr[com.bykv.vk.openvk.preload.a.d.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4726a[com.bykv.vk.openvk.preload.a.d.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4726a[com.bykv.vk.openvk.preload.a.d.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4726a[com.bykv.vk.openvk.preload.a.d.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4726a[com.bykv.vk.openvk.preload.a.d.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4726a[com.bykv.vk.openvk.preload.a.d.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public g(com.bykv.vk.openvk.preload.a.d dVar) {
        this.f4725b = dVar;
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        switch (AnonymousClass2.f4726a[aVar.f().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(a(aVar));
                }
                aVar.b();
                return arrayList;
            case 2:
                com.bykv.vk.openvk.preload.a.b.g gVar = new com.bykv.vk.openvk.preload.a.b.g();
                aVar.c();
                while (aVar.e()) {
                    gVar.put(aVar.g(), a(aVar));
                }
                aVar.d();
                return gVar;
            case 3:
                return aVar.h();
            case 4:
                return Double.valueOf(aVar.k());
            case 5:
                return Boolean.valueOf(aVar.i());
            case 6:
                aVar.j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.h();
            return;
        }
        r rVarA = this.f4725b.a((Class) obj.getClass());
        if (rVarA instanceof g) {
            cVar.f();
            cVar.g();
        } else {
            rVarA.a(cVar, obj);
        }
    }
}
