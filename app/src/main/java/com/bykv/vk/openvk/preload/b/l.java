package com.bykv.vk.openvk.preload.b;

import com.bykv.vk.openvk.preload.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l<IN, OUT> extends d<IN, OUT> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, a> f4901d;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<h> f4902a = new ArrayList();

        public final a a(h hVar) {
            this.f4902a.add(hVar);
            return this;
        }

        public final a a(List<h> list) {
            this.f4902a.addAll(list);
            return this;
        }
    }

    public final Map<String, a> a() {
        return this.f4901d;
    }

    public static boolean a(List<h> list) {
        return !list.isEmpty() && list.get(list.size() - 1).f4889a == f.class;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, a> f4903a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bykv.vk.openvk.preload.b.b.a f4904b;

        public final a a(String str) {
            if (this.f4903a.containsKey(str)) {
                throw new IllegalArgumentException("duplicated branch name");
            }
            a aVar = new a();
            this.f4903a.put(str, aVar);
            return aVar;
        }

        public final h a(Class<? extends l> cls) {
            return h.a.a().a(cls).a(this.f4903a).a(this.f4904b).b();
        }
    }

    @Override // com.bykv.vk.openvk.preload.b.d
    public final void a(Object... objArr) {
        Object obj;
        super.a(objArr);
        if (objArr != null && objArr.length == 1 && (obj = objArr[0]) != null) {
            try {
                this.f4901d = (Map) obj;
                return;
            } catch (ClassCastException e) {
                throw new IllegalArgumentException(e);
            }
        }
        throw new IllegalStateException("args error");
    }
}
