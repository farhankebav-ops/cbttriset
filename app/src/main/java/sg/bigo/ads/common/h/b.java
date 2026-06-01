package sg.bigo.ads.common.h;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ironsource.C2300e4;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import sg.bigo.ads.common.h.b.e;
import sg.bigo.ads.common.utils.f;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.p;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<sg.bigo.ads.common.h.a> f15744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<sg.bigo.ads.common.h.a> f15745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<sg.bigo.ads.common.h.a> f15746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<sg.bigo.ads.common.h.a> f15747d;
    final a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final sg.bigo.ads.common.h.a.a f15748f;
    private final Context g;

    public interface a {
        void a(sg.bigo.ads.common.h.a aVar);

        void a(sg.bigo.ads.common.h.a aVar, int i2, long j);

        void a(sg.bigo.ads.common.h.a aVar, String str, long j, long j3);
    }

    public b(@NonNull Context context, sg.bigo.ads.common.h.a.a aVar, boolean z2, @NonNull a aVar2) {
        this.g = context;
        this.e = aVar2;
        sg.bigo.ads.common.h.b.b.a(z2);
        this.f15748f = aVar;
        this.f15744a = new CopyOnWriteArrayList<>();
        this.f15745b = new CopyOnWriteArrayList<>();
        this.f15746c = new CopyOnWriteArrayList<>();
        this.f15747d = new CopyOnWriteArrayList<>();
    }

    public final sg.bigo.ads.common.h.a a(String str, String str2) {
        if (q.a((CharSequence) str) || q.a((CharSequence) str2)) {
            return null;
        }
        sg.bigo.ads.common.h.a aVarA = a(this.f15744a, str, str2);
        if (aVarA == null) {
            aVarA = a(this.f15745b, str, str2);
        }
        if (aVarA == null) {
            aVarA = a(this.f15746c, str, str2);
        }
        return aVarA == null ? a(this.f15747d, str, str2) : aVarA;
    }

    @Override // sg.bigo.ads.common.h.b.e
    public final void b(String str) {
        final sg.bigo.ads.common.h.a aVarA = sg.bigo.ads.common.h.b.b.a(str);
        if (aVarA == null) {
            a("onLoading info is null.", (sg.bigo.ads.common.h.a) null);
            return;
        }
        if (aVarA.j != 1) {
            a("onLoading", aVarA);
            aVarA.j = 1;
        }
        long j = aVarA.f15732i;
        if (j > 0) {
            long j3 = aVarA.g;
            if ((j3 - aVarA.h) * 100 > j * 10) {
                aVarA.h = j3;
                if (aVarA.h()) {
                    int iA = sg.bigo.ads.common.aa.c.a(this.g);
                    if (iA == 3 || iA == 4 || iA == 5) {
                        final long jElapsedRealtime = SystemClock.elapsedRealtime() - aVarA.m;
                        a("partial download callback", aVarA);
                        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.common.h.b.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                b.this.e.a(aVarA, 2, jElapsedRealtime);
                            }
                        });
                    }
                }
            }
        }
    }

    @Override // sg.bigo.ads.common.h.b.e
    public final void c(String str) {
        sg.bigo.ads.common.h.a aVarA = sg.bigo.ads.common.h.b.b.a(str);
        if (aVarA != null) {
            aVarA.j = 2;
        }
    }

    @Override // sg.bigo.ads.common.h.b.e
    public final void d(final String str) {
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.common.h.b.3
            @Override // java.lang.Runnable
            public final void run() {
                sg.bigo.ads.common.h.a aVarA = sg.bigo.ads.common.h.b.b.a(str);
                if (aVarA == null) {
                    return;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                b.a("download succeed", aVarA);
                aVarA.j = 3;
                b.this.f15744a.remove(aVarA);
                b.this.f15745b.add(aVarA);
                b.this.e.a(aVarA, 1, jElapsedRealtime - aVarA.m);
                b.a("downloading to downloaded", aVarA);
                sg.bigo.ads.common.h.b.b.a(aVarA.f15727a);
                b.this.a();
            }
        });
    }

    private static sg.bigo.ads.common.h.a a(List<sg.bigo.ads.common.h.a> list, String str, String str2) {
        if (!q.a((CharSequence) str) && !q.a((CharSequence) str2)) {
            for (sg.bigo.ads.common.h.a aVar : list) {
                if (TextUtils.equals(str, aVar.f15729c) && TextUtils.equals(str2, aVar.f15730d)) {
                    return aVar;
                }
            }
        }
        return null;
    }

    private boolean b() {
        return this.f15744a.size() < this.f15748f.f15740a;
    }

    private static sg.bigo.ads.common.h.a a(List<sg.bigo.ads.common.h.a> list, sg.bigo.ads.common.h.a aVar) {
        int iIndexOf = list.indexOf(aVar);
        if (iIndexOf >= 0) {
            try {
                return list.get(iIndexOf);
            } catch (Exception e) {
                a("getExistDownloadInfo e=" + e.getMessage(), (sg.bigo.ads.common.h.a) null);
            }
        }
        return null;
    }

    private static sg.bigo.ads.common.h.a a(List<sg.bigo.ads.common.h.a> list, boolean z2) {
        for (sg.bigo.ads.common.h.a aVar : list) {
            if (!z2) {
                return aVar;
            }
            int i2 = aVar.k >= 3 ? 1800000 : 300000;
            if (aVar.l > 0 && System.currentTimeMillis() - aVar.l > i2) {
                return aVar;
            }
            a("no download info execute.", aVar);
        }
        return null;
    }

    public final void a() {
        if (sg.bigo.ads.common.x.a.q()) {
            return;
        }
        a("continue to execute download task", (sg.bigo.ads.common.h.a) null);
        if (!b()) {
            a("no idle download thread", (sg.bigo.ads.common.h.a) null);
            return;
        }
        sg.bigo.ads.common.h.a aVarA = a((List<sg.bigo.ads.common.h.a>) this.f15746c, false);
        if (aVarA != null) {
            a("waiting to downloading", aVarA);
            this.f15746c.remove(aVarA);
        }
        if (aVarA == null && (aVarA = a((List<sg.bigo.ads.common.h.a>) this.f15747d, true)) != null) {
            a("failed to downloading", aVarA);
            this.f15747d.remove(aVarA);
        }
        if (aVarA == null) {
            a("no download info execute.", (sg.bigo.ads.common.h.a) null);
        } else {
            this.f15744a.add(aVarA);
            a(this.g, aVarA);
        }
    }

    private void a(Context context, sg.bigo.ads.common.h.a aVar) {
        aVar.m = SystemClock.elapsedRealtime();
        a("execute download start", aVar);
        if (f.b(aVar.f15729c, aVar.f15730d)) {
            a("executeDownload use local file", aVar);
            f.c(aVar.f15729c, aVar.f15730d);
            aVar.j = 3;
            aVar.f15732i = f.a(aVar.a(), 1);
            this.f15744a.remove(aVar);
            this.f15745b.add(aVar);
            this.e.a(aVar, 0, 0L);
            a();
            return;
        }
        if (!p.b()) {
            this.f15744a.remove(aVar);
            this.e.a(aVar, "internal storage is not enough", SystemClock.elapsedRealtime() - aVar.m, 0L);
            a();
        } else {
            sg.bigo.ads.common.h.b.b.a(context, aVar);
            sg.bigo.ads.common.h.b.b.a(aVar.f15727a, this);
            a("execute downloader", aVar);
            sg.bigo.ads.common.h.b.b.b(aVar.f15727a);
        }
    }

    @Override // sg.bigo.ads.common.h.b.e
    public final void a(String str) {
        final sg.bigo.ads.common.h.a aVarA = sg.bigo.ads.common.h.b.b.a(str);
        if (aVarA == null) {
            a("onStart info is null.", (sg.bigo.ads.common.h.a) null);
        } else {
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.common.h.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.e.a(aVarA);
                }
            });
        }
    }

    @Override // sg.bigo.ads.common.h.b.e
    public final void a(final String str, final String str2, final long j) {
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.common.h.b.4
            @Override // java.lang.Runnable
            public final void run() {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                sg.bigo.ads.common.h.a aVarA = sg.bigo.ads.common.h.b.b.a(str);
                if (aVarA == null) {
                    return;
                }
                b.a("download failed", aVarA);
                aVarA.j = 4;
                if (!aVarA.f15733n) {
                    aVarA.k++;
                }
                aVarA.l = System.currentTimeMillis();
                b.this.e.a(aVarA, str2, jElapsedRealtime - aVarA.m, j);
                b.a("download failed update fail count", aVarA);
                b.this.f15744a.remove(aVarA);
                b.this.f15747d.add(aVarA);
                b.a("downloading to failed", aVarA);
                b.this.a();
            }
        });
    }

    public static void a(String str, sg.bigo.ads.common.h.a aVar) {
        sg.bigo.ads.common.t.a.a(0, 3, "DownloadManager", a1.a.D(str, ", download info = ", aVar != null ? aVar.toString() : null));
    }

    public final void a(sg.bigo.ads.common.h.a aVar, boolean z2) {
        a("start the download, force=".concat(String.valueOf(z2)), aVar);
        if (f.b(aVar.a())) {
            a("downloaded and exist local file", aVar);
            f.c(aVar.f15729c, aVar.f15730d);
            this.e.a(aVar, 0, 0L);
            return;
        }
        if (a(this.f15744a, aVar) != null) {
            a("downloading", aVar);
            return;
        }
        if (this.f15748f.b()) {
            this.e.a(aVar, "Unable to download media file.", 0L, 0L);
            return;
        }
        sg.bigo.ads.common.h.a aVarA = a(this.f15746c, aVar);
        if (aVarA != null) {
            a("waiting", aVar);
            aVarA.f15728b = aVar.f15728b;
            if (!z2 && !b()) {
                a("waiting not executing", aVar);
                return;
            }
        }
        sg.bigo.ads.common.h.a aVarA2 = a(this.f15747d, aVar);
        if (aVarA2 != null) {
            a(C2300e4.h.f8385t, aVar);
            this.f15747d.remove(aVarA2);
            aVarA2.f15728b = aVar.f15728b;
            aVarA2.j = 0;
        } else {
            aVarA2 = aVar;
        }
        if (!b() && !z2) {
            a("join download waiting queue", aVarA2);
            this.f15746c.add(aVarA2);
        } else {
            a("execute download", aVarA2);
            aVarA2.f15733n = z2;
            this.f15744a.add(aVarA2);
            a(this.g, aVarA2);
        }
    }

    public static boolean a(List<sg.bigo.ads.common.h.a> list, String str) {
        if (!q.a((CharSequence) str) && !k.a((Collection) list)) {
            Iterator<sg.bigo.ads.common.h.a> it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(str, it.next().f15728b)) {
                    return true;
                }
            }
        }
        return false;
    }
}
