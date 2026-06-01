package sg.bigo.ads.core.b.b;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import androidx.work.PeriodicWorkRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import sg.bigo.ads.common.utils.p;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final sg.bigo.ads.core.b.a.a f16827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set<sg.bigo.ads.common.g.b.a> f16828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<sg.bigo.ads.common.g.b.a> f16829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f16830d = 0;
    a e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f16833b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16834c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16835d;

        private a() {
        }

        public static a a() {
            a aVar = new a();
            String strK = sg.bigo.ads.common.x.a.k();
            if (!q.a((CharSequence) strK)) {
                String[] strArrSplit = strK.split(",");
                if (strArrSplit.length == 4) {
                    try {
                        aVar.f16832a = Integer.parseInt(strArrSplit[0]);
                        aVar.f16833b = Integer.parseInt(strArrSplit[1]);
                        aVar.f16834c = Integer.parseInt(strArrSplit[2]);
                        aVar.f16835d = Integer.parseInt(strArrSplit[3]);
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return aVar;
        }

        public final boolean b() {
            return ((this.f16832a + this.f16833b) + this.f16834c) + this.f16835d == 0;
        }

        public final void c() {
            this.f16832a = 0;
            this.f16833b = 0;
            this.f16834c = 0;
            this.f16835d = 0;
            sg.bigo.ads.common.x.a.d(toString());
        }

        @NonNull
        public final String toString() {
            return this.f16832a + "," + this.f16833b + "," + this.f16834c + "," + this.f16835d;
        }
    }

    public b(@NonNull sg.bigo.ads.core.b.a.a aVar) {
        this.f16827a = aVar;
        this.f16828b = p.a(aVar.f16808a);
        this.f16829c = p.a(aVar.f16808a);
        sg.bigo.ads.core.b.c.b.a(new Runnable() { // from class: sg.bigo.ads.core.b.b.b.1
            @Override // java.lang.Runnable
            public final void run() {
                b bVar = b.this;
                long jCurrentTimeMillis = System.currentTimeMillis() - ((long) bVar.f16827a.f16810c);
                sg.bigo.ads.common.t.a.a(0, 3, "EventDbHelper", "clearEventInfo");
                sg.bigo.ads.common.t.a.a(0, 3, "EventDbHelper", "clearEventInfo count = ".concat(String.valueOf(sg.bigo.ads.common.g.a.a.b("tb_event", "ctime < ".concat(String.valueOf(jCurrentTimeMillis)), null))));
                bVar.f16828b.addAll(bVar.f());
                long j = sg.bigo.ads.common.x.a.j();
                bVar.f16830d = j;
                if (j == 0) {
                    bVar.f16830d = System.currentTimeMillis();
                }
                bVar.e = a.a();
                bVar.a();
            }
        });
    }

    public final void a() {
        a aVar = this.e;
        if (aVar == null || aVar.b()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.f16830d;
        if (jCurrentTimeMillis - j >= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            a aVar2 = this.e;
            sg.bigo.ads.core.d.b.a(j, aVar2.f16832a, aVar2.f16833b, aVar2.f16834c, aVar2.f16835d);
            this.f16830d = jCurrentTimeMillis;
            sg.bigo.ads.common.x.a.d(jCurrentTimeMillis);
            this.e.c();
        }
    }

    public final synchronized List<sg.bigo.ads.common.g.b.a> b() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList(this.f16828b);
            Iterator<sg.bigo.ads.common.g.b.a> it = this.f16829c.iterator();
            while (it.hasNext()) {
                arrayList.remove(it.next());
            }
            this.f16828b.clear();
            this.f16829c.addAll(arrayList);
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public final synchronized int c() {
        return this.f16828b.size();
    }

    public final synchronized boolean d() {
        return this.f16828b.isEmpty();
    }

    public final synchronized void e() {
        try {
            if (this.f16828b.isEmpty()) {
                List<sg.bigo.ads.common.g.b.a> listF = f();
                Iterator<sg.bigo.ads.common.g.b.a> it = this.f16829c.iterator();
                while (it.hasNext()) {
                    listF.remove(it.next());
                }
                this.f16828b.addAll(listF);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final List<sg.bigo.ads.common.g.b.a> f() {
        return sg.bigo.ads.common.g.c.a.a(this.f16827a.a());
    }

    public final synchronized void g() {
        this.f16829c.clear();
        this.f16828b.clear();
    }

    public final synchronized void a(List<sg.bigo.ads.common.g.b.a> list, boolean z2) {
        try {
            this.f16829c.removeAll(list);
            if (!z2) {
                this.f16828b.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<sg.bigo.ads.common.g.b.a> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(it.next().f15712a));
            }
            sg.bigo.ads.common.g.c.a.a(arrayList);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final synchronized void a(sg.bigo.ads.common.g.b.a aVar) {
        try {
            this.f16828b.add(aVar);
            sg.bigo.ads.common.t.a.a(0, 3, "EventDbHelper", "insertEventInfo:" + aVar.toString());
            ContentValues contentValues = new ContentValues();
            contentValues.put("event_action", aVar.f15713b);
            contentValues.put("event_info", aVar.f15714c);
            contentValues.put("states", Integer.valueOf(aVar.f15715d));
            contentValues.put("ext", aVar.e);
            long jCurrentTimeMillis = aVar.f15716f;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            contentValues.put("ctime", Long.valueOf(jCurrentTimeMillis));
            long jCurrentTimeMillis2 = aVar.g;
            if (jCurrentTimeMillis2 == 0) {
                jCurrentTimeMillis2 = System.currentTimeMillis();
            }
            contentValues.put("mtime", Long.valueOf(jCurrentTimeMillis2));
            aVar.f15712a = sg.bigo.ads.common.g.a.a.a("tb_event", contentValues);
            a();
            a aVar2 = this.e;
            String str = aVar.f15713b;
            switch (str.hashCode()) {
                case -1274499742:
                    if (str.equals("filled")) {
                        aVar2.f16833b++;
                    }
                    break;
                case 3327206:
                    if (str.equals("load")) {
                        aVar2.f16832a++;
                    }
                    break;
                case 120623625:
                    if (str.equals("impression")) {
                        aVar2.f16834c++;
                    }
                    break;
                case 860524583:
                    if (str.equals("clicked")) {
                        aVar2.f16835d++;
                    }
                    break;
            }
            sg.bigo.ads.common.x.a.d(aVar2.toString());
        } catch (Throwable th) {
            throw th;
        }
    }
}
