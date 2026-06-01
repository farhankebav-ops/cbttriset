package com.iab.omid.library.bytedance2.walking;

import android.view.View;
import com.iab.omid.library.bytedance2.internal.e;
import com.iab.omid.library.bytedance2.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f5928a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<View, C0150a> f5929b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, View> f5930c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<View> f5931d = new HashSet<>();
    private final HashSet<String> e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<String> f5932f = new HashSet<>();
    private final HashMap<String, String> g = new HashMap<>();
    private final Map<View, Boolean> h = new WeakHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f5933i;

    /* JADX INFO: renamed from: com.iab.omid.library.bytedance2.walking.a$a, reason: collision with other inner class name */
    public static class C0150a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f5934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f5935b = new ArrayList<>();

        public C0150a(e eVar, String str) {
            this.f5934a = eVar;
            a(str);
        }

        public e a() {
            return this.f5934a;
        }

        public ArrayList<String> b() {
            return this.f5935b;
        }

        public void a(String str) {
            this.f5935b.add(str);
        }
    }

    private Boolean b(View view) {
        if (view.hasWindowFocus()) {
            this.h.remove(view);
            return Boolean.FALSE;
        }
        if (this.h.containsKey(view)) {
            return this.h.get(view);
        }
        Map<View, Boolean> map = this.h;
        Boolean bool = Boolean.FALSE;
        map.put(view, bool);
        return bool;
    }

    public View a(String str) {
        return this.f5930c.get(str);
    }

    public C0150a c(View view) {
        C0150a c0150a = this.f5929b.get(view);
        if (c0150a != null) {
            this.f5929b.remove(view);
        }
        return c0150a;
    }

    public String d(View view) {
        if (this.f5928a.size() == 0) {
            return null;
        }
        String str = this.f5928a.get(view);
        if (str != null) {
            this.f5928a.remove(view);
        }
        return str;
    }

    public c e(View view) {
        return this.f5931d.contains(view) ? c.PARENT_VIEW : this.f5933i ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public boolean f(View view) {
        if (!this.h.containsKey(view)) {
            return true;
        }
        this.h.put(view, Boolean.TRUE);
        return false;
    }

    private String a(View view) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (b(view).booleanValue()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String strA = h.a(view);
            if (strA != null) {
                return strA;
            }
            hashSet.add(view);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f5931d.addAll(hashSet);
        return null;
    }

    public String b(String str) {
        return this.g.get(str);
    }

    public HashSet<String> c() {
        return this.e;
    }

    public void d() {
        this.f5933i = true;
    }

    public void e() {
        com.iab.omid.library.bytedance2.internal.c cVarC = com.iab.omid.library.bytedance2.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.bytedance2.adsession.a aVar : cVarC.a()) {
                View viewC = aVar.c();
                if (aVar.f()) {
                    String adSessionId = aVar.getAdSessionId();
                    if (viewC != null) {
                        String strA = a(viewC);
                        if (strA == null) {
                            this.e.add(adSessionId);
                            this.f5928a.put(viewC, adSessionId);
                            a(aVar);
                        } else if (strA != "noWindowFocus") {
                            this.f5932f.add(adSessionId);
                            this.f5930c.put(adSessionId, viewC);
                            this.g.put(adSessionId, strA);
                        }
                    } else {
                        this.f5932f.add(adSessionId);
                        this.g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    public void a() {
        this.f5928a.clear();
        this.f5929b.clear();
        this.f5930c.clear();
        this.f5931d.clear();
        this.e.clear();
        this.f5932f.clear();
        this.g.clear();
        this.f5933i = false;
    }

    public HashSet<String> b() {
        return this.f5932f;
    }

    private void a(com.iab.omid.library.bytedance2.adsession.a aVar) {
        Iterator<e> it = aVar.d().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(e eVar, com.iab.omid.library.bytedance2.adsession.a aVar) {
        View view = eVar.c().get();
        if (view == null) {
            return;
        }
        C0150a c0150a = this.f5929b.get(view);
        if (c0150a != null) {
            c0150a.a(aVar.getAdSessionId());
        } else {
            this.f5929b.put(view, new C0150a(eVar, aVar.getAdSessionId()));
        }
    }
}
