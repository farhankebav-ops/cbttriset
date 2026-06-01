package com.iab.omid.library.ironsrc.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.ironsrc.internal.j;
import com.iab.omid.library.ironsrc.processor.a;
import com.iab.omid.library.ironsrc.utils.f;
import com.iab.omid.library.ironsrc.utils.h;
import com.iab.omid.library.ironsrc.walking.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TreeWalker implements a.InterfaceC0152a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static TreeWalker f6030i = new TreeWalker();
    private static Handler j = new Handler(Looper.getMainLooper());
    private static Handler k = null;
    private static final Runnable l = new b();
    private static final Runnable m = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6032b;
    private long h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f6031a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6033c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.iab.omid.library.ironsrc.weakreference.a> f6034d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.iab.omid.library.ironsrc.walking.a f6035f = new com.iab.omid.library.ironsrc.walking.a();
    private com.iab.omid.library.ironsrc.processor.b e = new com.iab.omid.library.ironsrc.processor.b();
    private com.iab.omid.library.ironsrc.walking.b g = new com.iab.omid.library.ironsrc.walking.b(new com.iab.omid.library.ironsrc.walking.async.c());

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
        this.f6032b = 0;
        this.f6034d.clear();
        this.f6033c = false;
        Iterator<com.iab.omid.library.ironsrc.adsession.a> it = com.iab.omid.library.ironsrc.internal.c.c().a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().e()) {
                this.f6033c = true;
                break;
            }
        }
        this.h = f.b();
    }

    public static TreeWalker getInstance() {
        return f6030i;
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
        j.b().a();
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f6031a.contains(treeWalkerTimeLogger)) {
            return;
        }
        this.f6031a.add(treeWalkerTimeLogger);
    }

    @VisibleForTesting
    public void f() {
        TreeWalker treeWalker;
        this.f6035f.e();
        long jB = f.b();
        com.iab.omid.library.ironsrc.processor.a aVarA = this.e.a();
        if (this.f6035f.b().size() > 0) {
            for (String str : this.f6035f.b()) {
                JSONObject jSONObjectA = aVarA.a(null);
                a(str, this.f6035f.a(str), jSONObjectA);
                com.iab.omid.library.ironsrc.utils.c.b(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.g.a(jSONObjectA, hashSet, jB);
            }
        }
        if (this.f6035f.c().size() > 0) {
            JSONObject jSONObjectA2 = aVarA.a(null);
            treeWalker = this;
            treeWalker.a(null, aVarA, jSONObjectA2, com.iab.omid.library.ironsrc.walking.c.PARENT_VIEW, false);
            com.iab.omid.library.ironsrc.utils.c.b(jSONObjectA2);
            treeWalker.g.b(jSONObjectA2, treeWalker.f6035f.c(), jB);
            if (treeWalker.f6033c) {
                Iterator<com.iab.omid.library.ironsrc.adsession.a> it = com.iab.omid.library.ironsrc.internal.c.c().a().iterator();
                while (it.hasNext()) {
                    it.next().a(treeWalker.f6034d);
                }
            }
        } else {
            treeWalker = this;
            treeWalker.g.b();
        }
        treeWalker.f6035f.a();
    }

    public void g() {
        k();
    }

    public void h() {
        i();
    }

    public void j() {
        g();
        this.f6031a.clear();
        j.post(new a());
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f6031a.contains(treeWalkerTimeLogger)) {
            this.f6031a.remove(treeWalkerTimeLogger);
        }
    }

    private void a(long j3) {
        if (this.f6031a.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f6031a) {
                treeWalkerTimeLogger.onTreeProcessed(this.f6032b, TimeUnit.NANOSECONDS.toMillis(j3));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.f6032b, j3);
                }
            }
        }
    }

    private boolean b(View view, JSONObject jSONObject) {
        String strC = this.f6035f.c(view);
        if (strC == null) {
            return false;
        }
        com.iab.omid.library.ironsrc.utils.c.a(jSONObject, strC);
        com.iab.omid.library.ironsrc.utils.c.a(jSONObject, Boolean.valueOf(this.f6035f.e(view)));
        com.iab.omid.library.ironsrc.utils.c.b(jSONObject, Boolean.valueOf(this.f6035f.c(strC)));
        this.f6035f.d();
        return true;
    }

    private void a(View view, com.iab.omid.library.ironsrc.processor.a aVar, JSONObject jSONObject, com.iab.omid.library.ironsrc.walking.c cVar, boolean z2) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.ironsrc.walking.c.PARENT_VIEW, z2);
    }

    @Override // com.iab.omid.library.ironsrc.processor.a.InterfaceC0152a
    public void a(View view, com.iab.omid.library.ironsrc.processor.a aVar, JSONObject jSONObject, boolean z2) {
        com.iab.omid.library.ironsrc.walking.c cVarD;
        TreeWalker treeWalker;
        if (h.f(view) && (cVarD = this.f6035f.d(view)) != com.iab.omid.library.ironsrc.walking.c.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = aVar.a(view);
            com.iab.omid.library.ironsrc.utils.c.a(jSONObject, jSONObjectA);
            if (b(view, jSONObjectA)) {
                treeWalker = this;
            } else {
                boolean z7 = z2 || a(view, jSONObjectA);
                if (this.f6033c && cVarD == com.iab.omid.library.ironsrc.walking.c.OBSTRUCTION_VIEW && !z7) {
                    this.f6034d.add(new com.iab.omid.library.ironsrc.weakreference.a(view));
                }
                treeWalker = this;
                treeWalker.a(view, aVar, jSONObjectA, cVarD, z7);
            }
            treeWalker.f6032b++;
        }
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.ironsrc.processor.a aVarB = this.e.b();
        String strB = this.f6035f.b(str);
        if (strB != null) {
            JSONObject jSONObjectA = aVarB.a(view);
            com.iab.omid.library.ironsrc.utils.c.a(jSONObjectA, str);
            com.iab.omid.library.ironsrc.utils.c.b(jSONObjectA, strB);
            com.iab.omid.library.ironsrc.utils.c.a(jSONObject, jSONObjectA);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        a.C0154a c0154aB = this.f6035f.b(view);
        if (c0154aB == null) {
            return false;
        }
        com.iab.omid.library.ironsrc.utils.c.a(jSONObject, c0154aB);
        return true;
    }
}
