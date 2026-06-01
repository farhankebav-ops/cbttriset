package com.iab.omid.library.unity3d.walking;

import android.view.View;
import com.iab.omid.library.unity3d.internal.e;
import com.iab.omid.library.unity3d.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f6139a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<View, C0158a> f6140b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, View> f6141c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<View> f6142d = new HashSet<>();
    private final HashSet<String> e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<String> f6143f = new HashSet<>();
    private final HashMap<String, String> g = new HashMap<>();
    private final Map<View, Boolean> h = new WeakHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6144i;

    /* JADX INFO: renamed from: com.iab.omid.library.unity3d.walking.a$a, reason: collision with other inner class name */
    public static class C0158a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f6145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f6146b = new ArrayList<>();

        public C0158a(e eVar, String str) {
            this.f6145a = eVar;
            a(str);
        }

        public e a() {
            return this.f6145a;
        }

        public ArrayList<String> b() {
            return this.f6146b;
        }

        public void a(String str) {
            this.f6146b.add(str);
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
        return this.f6141c.get(str);
    }

    public C0158a c(View view) {
        C0158a c0158a = this.f6140b.get(view);
        if (c0158a != null) {
            this.f6140b.remove(view);
        }
        return c0158a;
    }

    public String d(View view) {
        if (this.f6139a.size() == 0) {
            return null;
        }
        String str = this.f6139a.get(view);
        if (str != null) {
            this.f6139a.remove(view);
        }
        return str;
    }

    public c e(View view) {
        return this.f6142d.contains(view) ? c.PARENT_VIEW : this.f6144i ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
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
        this.f6142d.addAll(hashSet);
        return null;
    }

    public String b(String str) {
        return this.g.get(str);
    }

    public HashSet<String> c() {
        return this.e;
    }

    public void d() {
        this.f6144i = true;
    }

    public void e() {
        com.iab.omid.library.unity3d.internal.c cVarC = com.iab.omid.library.unity3d.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.unity3d.adsession.a aVar : cVarC.a()) {
                View viewC = aVar.c();
                if (aVar.f()) {
                    String adSessionId = aVar.getAdSessionId();
                    if (viewC != null) {
                        String strA = a(viewC);
                        if (strA == null) {
                            this.e.add(adSessionId);
                            this.f6139a.put(viewC, adSessionId);
                            a(aVar);
                        } else if (strA != "noWindowFocus") {
                            this.f6143f.add(adSessionId);
                            this.f6141c.put(adSessionId, viewC);
                            this.g.put(adSessionId, strA);
                        }
                    } else {
                        this.f6143f.add(adSessionId);
                        this.g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    public void a() {
        this.f6139a.clear();
        this.f6140b.clear();
        this.f6141c.clear();
        this.f6142d.clear();
        this.e.clear();
        this.f6143f.clear();
        this.g.clear();
        this.f6144i = false;
    }

    public HashSet<String> b() {
        return this.f6143f;
    }

    private void a(com.iab.omid.library.unity3d.adsession.a aVar) {
        Iterator<e> it = aVar.d().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(e eVar, com.iab.omid.library.unity3d.adsession.a aVar) {
        View view = eVar.c().get();
        if (view == null) {
            return;
        }
        C0158a c0158a = this.f6140b.get(view);
        if (c0158a != null) {
            c0158a.a(aVar.getAdSessionId());
        } else {
            this.f6140b.put(view, new C0158a(eVar, aVar.getAdSessionId()));
        }
    }
}
