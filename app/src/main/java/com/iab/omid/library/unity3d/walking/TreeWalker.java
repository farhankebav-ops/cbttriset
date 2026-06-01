package com.iab.omid.library.unity3d.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.unity3d.processor.a;
import com.iab.omid.library.unity3d.utils.f;
import com.iab.omid.library.unity3d.utils.h;
import com.iab.omid.library.unity3d.walking.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TreeWalker implements a.InterfaceC0156a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static TreeWalker f6132i = new TreeWalker();
    private static Handler j = new Handler(Looper.getMainLooper());
    private static Handler k = null;
    private static final Runnable l = new b();
    private static final Runnable m = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6134b;
    private long h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f6133a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6135c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.iab.omid.library.unity3d.weakreference.a> f6136d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.iab.omid.library.unity3d.walking.a f6137f = new com.iab.omid.library.unity3d.walking.a();
    private com.iab.omid.library.unity3d.processor.b e = new com.iab.omid.library.unity3d.processor.b();
    private com.iab.omid.library.unity3d.walking.b g = new com.iab.omid.library.unity3d.walking.b(new com.iab.omid.library.unity3d.walking.async.c());

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i2, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i2, long j);
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.this.g.b();
        }
    }

    public class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.getInstance().l();
        }
    }

    public class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (TreeWalker.k != null) {
                TreeWalker.k.post(TreeWalker.l);
                TreeWalker.k.postDelayed(TreeWalker.m, 200L);
            }
        }
    }

    private void d() {
        a(f.b() - this.h);
    }

    private void e() {
        this.f6134b = 0;
        this.f6136d.clear();
        this.f6135c = false;
        Iterator<com.iab.omid.library.unity3d.adsession.a> it = com.iab.omid.library.unity3d.internal.c.c().a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().e()) {
                this.f6135c = true;
                break;
            }
        }
        this.h = f.b();
    }

    public static TreeWalker getInstance() {
        return f6132i;
    }

    private void i() {
        if (k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            k = handler;
            handler.post(l);
            k.postDelayed(m, 200L);
        }
    }

    private void k() {
        Handler handler = k;
        if (handler != null) {
            handler.removeCallbacks(m);
            k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        e();
        f();
        d();
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f6133a.contains(treeWalkerTimeLogger)) {
            return;
        }
        this.f6133a.add(treeWalkerTimeLogger);
    }

    @VisibleForTesting
    public void f() {
        TreeWalker treeWalker;
        this.f6137f.e();
        long jB = f.b();
        com.iab.omid.library.unity3d.processor.a aVarA = this.e.a();
        if (this.f6137f.b().size() > 0) {
            for (String str : this.f6137f.b()) {
                JSONObject jSONObjectA = aVarA.a(null);
                a(str, this.f6137f.a(str), jSONObjectA);
                com.iab.omid.library.unity3d.utils.c.b(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.g.a(jSONObjectA, hashSet, jB);
            }
        }
        if (this.f6137f.c().size() > 0) {
            JSONObject jSONObjectA2 = aVarA.a(null);
            treeWalker = this;
            treeWalker.a(null, aVarA, jSONObjectA2, com.iab.omid.library.unity3d.walking.c.PARENT_VIEW, false);
            com.iab.omid.library.unity3d.utils.c.b(jSONObjectA2);
            treeWalker.g.b(jSONObjectA2, treeWalker.f6137f.c(), jB);
            if (treeWalker.f6135c) {
                Iterator<com.iab.omid.library.unity3d.adsession.a> it = com.iab.omid.library.unity3d.internal.c.c().a().iterator();
                while (it.hasNext()) {
                    it.next().a(treeWalker.f6136d);
                }
            }
        } else {
            treeWalker = this;
            treeWalker.g.b();
        }
        treeWalker.f6137f.a();
    }

    public void g() {
        k();
    }

    public void h() {
        i();
    }

    public void j() {
        g();
        this.f6133a.clear();
        j.post(new a());
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f6133a.contains(treeWalkerTimeLogger)) {
            this.f6133a.remove(treeWalkerTimeLogger);
        }
    }

    private void a(long j3) {
        if (this.f6133a.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f6133a) {
                treeWalkerTimeLogger.onTreeProcessed(this.f6134b, TimeUnit.NANOSECONDS.toMillis(j3));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.f6134b, j3);
                }
            }
        }
    }

    private boolean b(View view, JSONObject jSONObject) {
        String strD = this.f6137f.d(view);
        if (strD == null) {
            return false;
        }
        com.iab.omid.library.unity3d.utils.c.a(jSONObject, strD);
        com.iab.omid.library.unity3d.utils.c.a(jSONObject, Boolean.valueOf(this.f6137f.f(view)));
        this.f6137f.d();
        return true;
    }

    private void a(View view, com.iab.omid.library.unity3d.processor.a aVar, JSONObject jSONObject, com.iab.omid.library.unity3d.walking.c cVar, boolean z2) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.unity3d.walking.c.PARENT_VIEW, z2);
    }

    @Override // com.iab.omid.library.unity3d.processor.a.InterfaceC0156a
    public void a(View view, com.iab.omid.library.unity3d.processor.a aVar, JSONObject jSONObject, boolean z2) {
        com.iab.omid.library.unity3d.walking.c cVarE;
        TreeWalker treeWalker;
        if (h.d(view) && (cVarE = this.f6137f.e(view)) != com.iab.omid.library.unity3d.walking.c.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = aVar.a(view);
            com.iab.omid.library.unity3d.utils.c.a(jSONObject, jSONObjectA);
            if (b(view, jSONObjectA)) {
                treeWalker = this;
            } else {
                boolean z7 = z2 || a(view, jSONObjectA);
                if (this.f6135c && cVarE == com.iab.omid.library.unity3d.walking.c.OBSTRUCTION_VIEW && !z7) {
                    this.f6136d.add(new com.iab.omid.library.unity3d.weakreference.a(view));
                }
                treeWalker = this;
                treeWalker.a(view, aVar, jSONObjectA, cVarE, z7);
            }
            treeWalker.f6134b++;
        }
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.unity3d.processor.a aVarB = this.e.b();
        String strB = this.f6137f.b(str);
        if (strB != null) {
            JSONObject jSONObjectA = aVarB.a(view);
            com.iab.omid.library.unity3d.utils.c.a(jSONObjectA, str);
            com.iab.omid.library.unity3d.utils.c.b(jSONObjectA, strB);
            com.iab.omid.library.unity3d.utils.c.a(jSONObject, jSONObjectA);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        a.C0158a c0158aC = this.f6137f.c(view);
        if (c0158aC == null) {
            return false;
        }
        com.iab.omid.library.unity3d.utils.c.a(jSONObject, c0158aC);
        return true;
    }
}
