package com.iab.omid.library.vungle.walking;

import android.view.View;
import com.iab.omid.library.vungle.internal.e;
import com.iab.omid.library.vungle.utils.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<View, String> f6248a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<View, C0162a> f6249b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, View> f6250c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<View> f6251d = new HashSet<>();
    private final HashSet<String> e = new HashSet<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<String> f6252f = new HashSet<>();
    private final HashMap<String, String> g = new HashMap<>();
    private final HashSet<String> h = new HashSet<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<View, Boolean> f6253i = new WeakHashMap();
    private boolean j;

    /* JADX INFO: renamed from: com.iab.omid.library.vungle.walking.a$a, reason: collision with other inner class name */
    public static class C0162a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f6254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f6255b = new ArrayList<>();

        public C0162a(e eVar, String str) {
            this.f6254a = eVar;
            a(str);
        }

        public e a() {
            return this.f6254a;
        }

        public ArrayList<String> b() {
            return this.f6255b;
        }

        public void a(String str) {
            this.f6255b.add(str);
        }
    }

    public View a(String str) {
        return this.f6250c.get(str);
    }

    public C0162a b(View view) {
        C0162a c0162a = this.f6249b.get(view);
        if (c0162a != null) {
            this.f6249b.remove(view);
        }
        return c0162a;
    }

    public String c(View view) {
        if (this.f6248a.size() == 0) {
            return null;
        }
        String str = this.f6248a.get(view);
        if (str != null) {
            this.f6248a.remove(view);
        }
        return str;
    }

    public c d(View view) {
        return this.f6251d.contains(view) ? c.PARENT_VIEW : this.j ? c.OBSTRUCTION_VIEW : c.UNDERLYING_VIEW;
    }

    public void e() {
        com.iab.omid.library.vungle.internal.c cVarC = com.iab.omid.library.vungle.internal.c.c();
        if (cVarC != null) {
            for (com.iab.omid.library.vungle.adsession.a aVar : cVarC.a()) {
                View viewE = aVar.e();
                if (aVar.h()) {
                    String strC = aVar.c();
                    if (viewE != null) {
                        boolean zE = h.e(viewE);
                        if (zE) {
                            this.h.add(strC);
                        }
                        String strA = a(viewE, zE);
                        if (strA == null) {
                            this.e.add(strC);
                            this.f6248a.put(viewE, strC);
                            a(aVar);
                        } else if (strA != "noWindowFocus") {
                            this.f6252f.add(strC);
                            this.f6250c.put(strC, viewE);
                            this.g.put(strC, strA);
                        }
                    } else {
                        this.f6252f.add(strC);
                        this.g.put(strC, "noAdView");
                    }
                }
            }
        }
    }

    private Boolean a(View view) {
        if (view.hasWindowFocus()) {
            this.f6253i.remove(view);
            return Boolean.FALSE;
        }
        if (this.f6253i.containsKey(view)) {
            return this.f6253i.get(view);
        }
        Map<View, Boolean> map = this.f6253i;
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
        if (!this.f6253i.containsKey(view)) {
            return true;
        }
        this.f6253i.put(view, Boolean.TRUE);
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
        this.f6251d.addAll(hashSet);
        return null;
    }

    public HashSet<String> b() {
        return this.f6252f;
    }

    public boolean c(String str) {
        return this.h.contains(str);
    }

    public void a() {
        this.f6248a.clear();
        this.f6249b.clear();
        this.f6250c.clear();
        this.f6251d.clear();
        this.e.clear();
        this.f6252f.clear();
        this.g.clear();
        this.j = false;
        this.h.clear();
    }

    private void a(com.iab.omid.library.vungle.adsession.a aVar) {
        Iterator<e> it = aVar.f().iterator();
        while (it.hasNext()) {
            a(it.next(), aVar);
        }
    }

    private void a(e eVar, com.iab.omid.library.vungle.adsession.a aVar) {
        View view = eVar.c().get();
        if (view == null) {
            return;
        }
        C0162a c0162a = this.f6249b.get(view);
        if (c0162a != null) {
            c0162a.a(aVar.c());
        } else {
            this.f6249b.put(view, new C0162a(eVar, aVar.c()));
        }
    }
}
