package com.iab.omid.library.bigosg.walking;

import android.view.View;
import com.iab.omid.library.bigosg.d.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f5824a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<View, C0146a> f5825b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, View> f5826c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<View> f5827d = new HashSet<>();
    private final HashSet<String> e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<String> f5828f = new HashSet<>();
    private final HashMap<String, String> g = new HashMap<>();
    private boolean h;

    /* JADX INFO: renamed from: com.iab.omid.library.bigosg.walking.a$a, reason: collision with other inner class name */
    public static class C0146a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.iab.omid.library.bigosg.b.c f5829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f5830b = new ArrayList<>();

        public C0146a(com.iab.omid.library.bigosg.b.c cVar, String str) {
            this.f5829a = cVar;
            a(str);
        }

        public com.iab.omid.library.bigosg.b.c a() {
            return this.f5829a;
        }

        public ArrayList<String> b() {
            return this.f5830b;
        }

        public void a(String str) {
            this.f5830b.add(str);
        }
    }

    private String d(View view) {
        if (!view.hasWindowFocus()) {
            return "noWindowFocus";
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            String strE = f.e(view);
            if (strE != null) {
                return strE;
            }
            hashSet.add(view);
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f5827d.addAll(hashSet);
        return null;
    }

    public String a(View view) {
        if (this.f5824a.size() == 0) {
            return null;
        }
        String str = this.f5824a.get(view);
        if (str != null) {
            this.f5824a.remove(view);
        }
        return str;
    }

    public View b(String str) {
        return this.f5826c.get(str);
    }

    public c c(View view) {
        return this.f5827d.contains(view) ? c.PARENT_VIEW : this.h ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void e() {
        this.h = true;
    }

    public String a(String str) {
        return this.g.get(str);
    }

    public C0146a b(View view) {
        C0146a c0146a = this.f5825b.get(view);
        if (c0146a != null) {
            this.f5825b.remove(view);
        }
        return c0146a;
    }

    public void c() {
        com.iab.omid.library.bigosg.b.a aVarA = com.iab.omid.library.bigosg.b.a.a();
        if (aVarA != null) {
            for (com.iab.omid.library.bigosg.adsession.a aVar : aVarA.c()) {
                View viewD = aVar.d();
                if (aVar.e()) {
                    String adSessionId = aVar.getAdSessionId();
                    if (viewD != null) {
                        String strD = d(viewD);
                        if (strD == null) {
                            this.e.add(adSessionId);
                            this.f5824a.put(viewD, adSessionId);
                            a(aVar);
                        } else {
                            this.f5828f.add(adSessionId);
                            this.f5826c.put(adSessionId, viewD);
                            this.g.put(adSessionId, strD);
                        }
                    } else {
                        this.f5828f.add(adSessionId);
                        this.g.put(adSessionId, "noAdView");
                    }
                }
            }
        }
    }

    public void d() {
        this.f5824a.clear();
        this.f5825b.clear();
        this.f5826c.clear();
        this.f5827d.clear();
        this.e.clear();
        this.f5828f.clear();
        this.g.clear();
        this.h = false;
    }

    public HashSet<String> a() {
        return this.e;
    }

    public HashSet<String> b() {
        return this.f5828f;
    }

    private void a(com.iab.omid.library.bigosg.adsession.a aVar) {
        Iterator<com.iab.omid.library.bigosg.b.c> it = aVar.a().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(com.iab.omid.library.bigosg.b.c cVar, com.iab.omid.library.bigosg.adsession.a aVar) {
        View view = cVar.a().get();
        if (view == null) {
            return;
        }
        C0146a c0146a = this.f5825b.get(view);
        if (c0146a != null) {
            c0146a.a(aVar.getAdSessionId());
        } else {
            this.f5825b.put(view, new C0146a(cVar, aVar.getAdSessionId()));
        }
    }
}
