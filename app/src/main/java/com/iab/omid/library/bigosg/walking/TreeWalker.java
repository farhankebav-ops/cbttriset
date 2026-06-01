package com.iab.omid.library.bigosg.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.bigosg.c.a;
import com.iab.omid.library.bigosg.d.d;
import com.iab.omid.library.bigosg.d.f;
import com.iab.omid.library.bigosg.walking.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TreeWalker implements a.InterfaceC0145a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static TreeWalker f5817a = new TreeWalker();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Handler f5818b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f5819c = null;
    private static final Runnable j = new Runnable() { // from class: com.iab.omid.library.bigosg.walking.TreeWalker.2
        @Override // java.lang.Runnable
        public final void run() {
            TreeWalker.getInstance().h();
        }
    };
    private static final Runnable k = new Runnable() { // from class: com.iab.omid.library.bigosg.walking.TreeWalker.3
        @Override // java.lang.Runnable
        public final void run() {
            if (TreeWalker.f5819c != null) {
                TreeWalker.f5819c.post(TreeWalker.j);
                TreeWalker.f5819c.postDelayed(TreeWalker.k, 200L);
            }
        }
    };
    private int e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f5822i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f5820d = new ArrayList();
    private a g = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.iab.omid.library.bigosg.c.b f5821f = new com.iab.omid.library.bigosg.c.b();
    private b h = new b(new com.iab.omid.library.bigosg.walking.a.c());

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i2, long j);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i2, long j);
    }

    public static TreeWalker getInstance() {
        return f5817a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        i();
        d();
        j();
    }

    private void i() {
        this.e = 0;
        this.f5822i = d.a();
    }

    private void j() {
        a(d.a() - this.f5822i);
    }

    private void k() {
        if (f5819c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f5819c = handler;
            handler.post(j);
            f5819c.postDelayed(k, 200L);
        }
    }

    private void l() {
        Handler handler = f5819c;
        if (handler != null) {
            handler.removeCallbacks(k);
            f5819c = null;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f5820d.contains(treeWalkerTimeLogger)) {
            return;
        }
        this.f5820d.add(treeWalkerTimeLogger);
    }

    public void b() {
        c();
        this.f5820d.clear();
        f5818b.post(new Runnable() { // from class: com.iab.omid.library.bigosg.walking.TreeWalker.1
            @Override // java.lang.Runnable
            public void run() {
                TreeWalker.this.h.a();
            }
        });
    }

    public void c() {
        l();
    }

    @VisibleForTesting
    public void d() {
        this.g.c();
        long jA = d.a();
        com.iab.omid.library.bigosg.c.a aVarA = this.f5821f.a();
        if (this.g.b().size() > 0) {
            for (String str : this.g.b()) {
                JSONObject jSONObjectA = aVarA.a(null);
                a(str, this.g.b(str), jSONObjectA);
                com.iab.omid.library.bigosg.d.b.a(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.h.b(jSONObjectA, hashSet, jA);
            }
        }
        if (this.g.a().size() > 0) {
            JSONObject jSONObjectA2 = aVarA.a(null);
            a(null, aVarA, jSONObjectA2, c.PARENT_VIEW);
            com.iab.omid.library.bigosg.d.b.a(jSONObjectA2);
            this.h.a(jSONObjectA2, this.g.a(), jA);
        } else {
            this.h.a();
        }
        this.g.d();
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f5820d.contains(treeWalkerTimeLogger)) {
            this.f5820d.remove(treeWalkerTimeLogger);
        }
    }

    private void b(View view, JSONObject jSONObject) {
        a.C0146a c0146aB = this.g.b(view);
        if (c0146aB != null) {
            com.iab.omid.library.bigosg.d.b.a(jSONObject, c0146aB);
        }
    }

    public void a() {
        k();
    }

    private void a(long j3) {
        if (this.f5820d.size() > 0) {
            for (TreeWalkerTimeLogger treeWalkerTimeLogger : this.f5820d) {
                treeWalkerTimeLogger.onTreeProcessed(this.e, TimeUnit.NANOSECONDS.toMillis(j3));
                if (treeWalkerTimeLogger instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) treeWalkerTimeLogger).onTreeProcessedNano(this.e, j3);
                }
            }
        }
    }

    @Override // com.iab.omid.library.bigosg.c.a.InterfaceC0145a
    public void a(View view, com.iab.omid.library.bigosg.c.a aVar, JSONObject jSONObject) {
        c cVarC;
        if (f.d(view) && (cVarC = this.g.c(view)) != c.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = aVar.a(view);
            com.iab.omid.library.bigosg.d.b.a(jSONObject, jSONObjectA);
            if (!a(view, jSONObjectA)) {
                b(view, jSONObjectA);
                a(view, aVar, jSONObjectA, cVarC);
            }
            this.e++;
        }
    }

    private void a(View view, com.iab.omid.library.bigosg.c.a aVar, JSONObject jSONObject, c cVar) {
        aVar.a(view, jSONObject, this, cVar == c.PARENT_VIEW);
    }

    private void a(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.bigosg.c.a aVarB = this.f5821f.b();
        String strA = this.g.a(str);
        if (strA != null) {
            JSONObject jSONObjectA = aVarB.a(view);
            com.iab.omid.library.bigosg.d.b.a(jSONObjectA, str);
            com.iab.omid.library.bigosg.d.b.b(jSONObjectA, strA);
            com.iab.omid.library.bigosg.d.b.a(jSONObject, jSONObjectA);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        String strA = this.g.a(view);
        if (strA == null) {
            return false;
        }
        com.iab.omid.library.bigosg.d.b.a(jSONObject, strA);
        this.g.e();
        return true;
    }
}
