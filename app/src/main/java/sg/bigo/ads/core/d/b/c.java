package sg.bigo.ads.core.d.b;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import sg.bigo.ads.common.utils.p;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<sg.bigo.ads.common.g.b.b> f16890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set<sg.bigo.ads.common.g.b.b> f16891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final sg.bigo.ads.core.d.a.a f16892c;

    public c(@NonNull sg.bigo.ads.core.d.a.a aVar) {
        this.f16892c = aVar;
        this.f16890a = p.a(aVar.f16866a);
        this.f16891b = p.a(aVar.f16866a);
        sg.bigo.ads.core.d.c.a.a(new Runnable() { // from class: sg.bigo.ads.core.d.b.c.1
            @Override // java.lang.Runnable
            public final void run() {
                c cVar = c.this;
                long jCurrentTimeMillis = System.currentTimeMillis();
                sg.bigo.ads.common.t.a.a(0, 3, "StatsDbHelper", "clearStatInfo");
                sg.bigo.ads.common.t.a.a(0, 3, "StatsDbHelper", "clearStatInfo count = ".concat(String.valueOf(sg.bigo.ads.common.g.a.a.b("tb_stat", "expired_ts < ".concat(String.valueOf(jCurrentTimeMillis)), null))));
                cVar.f16890a.addAll(cVar.e());
            }
        });
    }

    public final synchronized List<sg.bigo.ads.common.g.b.b> a() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList(this.f16890a);
            Iterator<sg.bigo.ads.common.g.b.b> it = this.f16891b.iterator();
            while (it.hasNext()) {
                arrayList.remove(it.next());
            }
            this.f16890a.clear();
            this.f16891b.addAll(arrayList);
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public final synchronized int b() {
        return this.f16890a.size();
    }

    public final synchronized boolean c() {
        return this.f16890a.isEmpty();
    }

    public final synchronized void d() {
        try {
            if (this.f16890a.isEmpty()) {
                List<sg.bigo.ads.common.g.b.b> listE = e();
                Iterator<sg.bigo.ads.common.g.b.b> it = this.f16891b.iterator();
                while (it.hasNext()) {
                    listE.remove(it.next());
                }
                this.f16890a.addAll(listE);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final List<sg.bigo.ads.common.g.b.b> e() {
        return sg.bigo.ads.common.g.c.b.a(this.f16892c.a());
    }

    public final synchronized void f() {
        this.f16891b.clear();
        this.f16890a.clear();
    }

    public final synchronized void a(List<sg.bigo.ads.common.g.b.b> list, boolean z2) {
        try {
            this.f16891b.removeAll(list);
            if (!z2) {
                this.f16890a.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<sg.bigo.ads.common.g.b.b> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(it.next().f15717a));
            }
            sg.bigo.ads.common.g.c.b.a(arrayList);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(sg.bigo.ads.common.g.b.b bVar) {
        try {
            this.f16890a.add(bVar);
            sg.bigo.ads.common.t.a.a(0, 3, "StatsDbHelper", "insertStatInfo:" + bVar.toString());
            ContentValues contentValues = new ContentValues();
            contentValues.put("event_id", bVar.f15718b);
            contentValues.put("event_info", bVar.f15719c);
            contentValues.put("expired_ts", Long.valueOf(bVar.f15720d));
            contentValues.put("ext", bVar.e);
            long jCurrentTimeMillis = bVar.f15721f;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            contentValues.put("ctime", Long.valueOf(jCurrentTimeMillis));
            long jCurrentTimeMillis2 = bVar.g;
            if (jCurrentTimeMillis2 == 0) {
                jCurrentTimeMillis2 = System.currentTimeMillis();
            }
            contentValues.put("mtime", Long.valueOf(jCurrentTimeMillis2));
            bVar.f15717a = sg.bigo.ads.common.g.a.a.a("tb_stat", contentValues);
        } catch (Throwable th) {
            throw th;
        }
    }
}
