package com.iab.omid.library.ironsrc.walking;

import android.view.View;
import com.iab.omid.library.ironsrc.internal.e;
import com.iab.omid.library.ironsrc.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f6037a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<View, C0154a> f6038b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, View> f6039c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<View> f6040d = new HashSet<>();
    private final HashSet<String> e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<String> f6041f = new HashSet<>();
    private final HashMap<String, String> g = new HashMap<>();
    private final HashSet<String> h = new HashSet<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<View, Boolean> f6042i = new WeakHashMap();
    private boolean j;

    /* JADX INFO: renamed from: com.iab.omid.library.ironsrc.walking.a$a, reason: collision with other inner class name */
    public static class C0154a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f6043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f6044b = new ArrayList<>();

        public C0154a(e eVar, String str) {
            this.f6043a = eVar;
            a(str);
        }

        public e a() {
            return this.f6043a;
        }

        public ArrayList<String> b() {
            return this.f6044b;
        }

        public void a(String str) {
            this.f6044b.add(str);
        }
    }

    public View a(String str) {
        return this.f6039c.get(str);
    }

    public C0154a b(View view) {
        C0154a c0154a = this.f6038b.get(view);
        if (c0154a != null) {
            this.f6038b.remove(view);
        }
        return c0154a;
    }

    public String c(View view) {
        if (this.f6037a.size() == 0) {
            return null;
        }
        String str = this.f6037a.get(view);
        if (str != null) {
            this.f6037a.remove(view);
        }
        return str;
    }

    public c d(View view) {
        return this.f6040d.contains(view) ? c.PARENT_VIEW : this.j ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void e() {
        com.iab.omid.library.ironsrc.internal.c cVarC = com.iab.omid.library.ironsrc.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.ironsrc.adsession.a aVar : cVarC.a()) {
                View viewC = aVar.c();
                if (aVar.f()) {
                    String adSessionId = aVar.getAdSessionId();
                    if (viewC != null) {
                        boolean zE = h.e(viewC);
                        if (zE) {
                            this.h.add(adSessionId);
                        }
                        String strA = a(viewC, zE);
                        if (strA == null) {
                            this.e.add(adSessionId);
                            this.f6037a.put(viewC, adSessionId);
                            a(aVar);
                        } else if (strA != "noWindowFocus") {
                            this.f6041f.add(adSessionId);
                            this.f6039c.put(adSessionId, viewC);
                            this.g.put(adSessionId, strA);
                        }
                    } else {
                        this.f6041f.add(adSessionId);
                        this.g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    private Boolean a(View view) {
        if (view.hasWindowFocus()) {
            this.f6042i.remove(view);
            return Boolean.FALSE;
        }
        if (this.f6042i.containsKey(view)) {
            return this.f6042i.get(view);
        }
        Map<View, Boolean> map = this.f6042i;
        Boolean bool = Boolean.FALSE;
        map.put(view, bool);
        return bool;
    }

    public String b(String str) {
        return this.g.get(str);
    }

    public HashSet<String> c() {
        return this.e;
    }

    public void d() {
        this.j = true;
    }

    public boolean e(View view) {
        if (!this.f6042i.containsKey(view)) {
            return true;
        }
        this.f6042i.put(view, Boolean.TRUE);
        return false;
    }

    private String a(View view, boolean z2) {
        if (!view.isAttachedToWindow()) {
            return "notAttached";
        }
        if (a(view).booleanValue() && !z2) {
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
        this.f6040d.addAll(hashSet);
        return null;
    }

    public HashSet<String> b() {
        return this.f6041f;
    }

    public boolean c(String str) {
        return this.h.contains(str);
    }

    public void a() {
        this.f6037a.clear();
        this.f6038b.clear();
        this.f6039c.clear();
        this.f6040d.clear();
        this.e.clear();
        this.f6041f.clear();
        this.g.clear();
        this.j = false;
        this.h.clear();
    }

    private void a(com.iab.omid.library.ironsrc.adsession.a aVar) {
        Iterator<e> it = aVar.d().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(e eVar, com.iab.omid.library.ironsrc.adsession.a aVar) {
        View view = eVar.c().get();
        if (view == null) {
            return;
        }
        C0154a c0154a = this.f6038b.get(view);
        if (c0154a != null) {
            c0154a.a(aVar.getAdSessionId());
        } else {
            this.f6038b.put(view, new C0154a(eVar, aVar.getAdSessionId()));
        }
    }
}
