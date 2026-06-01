package sg.bigo.ads.core.e.a;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import sg.bigo.ads.api.core.r;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.core.e.b;

/* JADX INFO: loaded from: classes6.dex */
public final class f extends sg.bigo.ads.common.g.b.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f16966i;
    public long j;
    public int k;
    public long l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f16967n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f16968o;
    public long p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    final r f16969q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f16970r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CopyOnWriteArrayList<e> f16971s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CopyOnWriteArrayList<e> f16972t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CopyOnWriteArrayList<e> f16973u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CopyOnWriteArrayList<e> f16974v;

    public f(@NonNull r rVar, Cursor cursor) {
        super(cursor);
        this.f16966i = 0;
        this.j = 0L;
        this.k = 0;
        this.l = 0L;
        this.m = 0;
        this.f16967n = 0L;
        this.f16968o = 0;
        this.p = 0L;
        this.f16969q = rVar;
        this.f15724c = 1;
    }

    public final int b(Context context) {
        Iterator<e> it = this.f16972t.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2++;
            a(context, "click_track", it.next());
        }
        return i2;
    }

    public final int c(Context context) {
        Iterator<e> it = this.f16973u.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2++;
            a(context, "nurl_track", it.next());
        }
        return i2;
    }

    public final int d(Context context) {
        Iterator<e> it = this.f16974v.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2++;
            a(context, "lurl_track", it.next());
        }
        return i2;
    }

    @Override // sg.bigo.ads.common.g.b.c
    @NonNull
    public final String e() {
        if (this.f16974v == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<e> it = this.f16974v.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().e);
        }
        return jSONArray.toString();
    }

    @Override // sg.bigo.ads.common.g.b.c
    public final long f() {
        return Math.max(Math.max(this.j, this.l), this.f15725d);
    }

    public final boolean g() {
        return a(this.f16971s) && a(this.f16972t) && a(this.f16973u) && a(this.f16974v);
    }

    public f(@NonNull r rVar, @NonNull Map<String, String> map) {
        super(map);
        this.f16966i = 0;
        this.j = 0L;
        this.k = 0;
        this.l = 0L;
        this.m = 0;
        this.f16967n = 0L;
        this.f16968o = 0;
        this.p = 0L;
        this.f16969q = rVar;
        this.f15724c = 1;
    }

    public final void a(Context context) {
        Iterator<e> it = this.f16971s.iterator();
        while (it.hasNext()) {
            a(context, "impl_track", it.next());
        }
    }

    @Override // sg.bigo.ads.common.g.b.c
    @NonNull
    public final String b() {
        if (this.f16971s == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<e> it = this.f16971s.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().e);
        }
        return jSONArray.toString();
    }

    @Override // sg.bigo.ads.common.g.b.c
    @NonNull
    public final String c() {
        if (this.f16972t == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<e> it = this.f16972t.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().e);
        }
        return jSONArray.toString();
    }

    @Override // sg.bigo.ads.common.g.b.c
    @NonNull
    public final String d() {
        if (this.f16973u == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<e> it = this.f16973u.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().e);
        }
        return jSONArray.toString();
    }

    private void a(Context context, final String str, final e eVar) {
        String str2 = eVar.f16961b;
        if (eVar.b()) {
            if ("impl_track".equals(str)) {
                this.f16971s.remove(eVar);
                return;
            }
            if ("click_track".equals(str)) {
                this.f16972t.remove(eVar);
                return;
            } else if ("nurl_track".equals(str)) {
                this.f16973u.remove(eVar);
                return;
            } else {
                if ("lurl_track".equals(str)) {
                    this.f16974v.remove(eVar);
                    return;
                }
                return;
            }
        }
        int i2 = this.f16966i;
        if ("click_track".equals(str)) {
            i2 = this.k;
        } else if ("nurl_track".equals(str)) {
            i2 = this.m;
        } else if ("lurl_track".equals(str)) {
            i2 = this.f16968o;
        }
        int i8 = i2;
        sg.bigo.ads.common.u.a aVarD = eVar.d();
        int i9 = eVar.f16962c;
        eVar.a();
        sg.bigo.ads.core.e.b.a(context, i9, str, aVarD, str2, this.f16970r, this.f15723b, i8, this.h, new b.a() { // from class: sg.bigo.ads.core.e.a.f.1
            @Override // sg.bigo.ads.core.e.b.a
            public final void a() {
                d.a().b(f.this);
            }

            @Override // sg.bigo.ads.core.e.b.a
            public final void b() {
                CopyOnWriteArrayList<e> copyOnWriteArrayList;
                if ("impl_track".equals(str)) {
                    copyOnWriteArrayList = f.this.f16971s;
                } else if ("click_track".equals(str)) {
                    copyOnWriteArrayList = f.this.f16972t;
                } else {
                    if (!"nurl_track".equals(str)) {
                        if ("lurl_track".equals(str)) {
                            copyOnWriteArrayList = f.this.f16974v;
                        }
                        d.a().b(f.this);
                    }
                    copyOnWriteArrayList = f.this.f16973u;
                }
                copyOnWriteArrayList.remove(eVar);
                d.a().b(f.this);
            }

            @Override // sg.bigo.ads.core.e.b.a
            public final boolean a(int i10) {
                return f.this.f16969q.a(i10);
            }
        });
    }

    @Override // sg.bigo.ads.common.g.b.c
    public final void b(String str) {
        if (q.a((CharSequence) str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            this.f16972t = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.f16972t.add(new e(jSONArray.getJSONObject(i2)));
            }
        } catch (JSONException unused) {
        }
    }

    @Override // sg.bigo.ads.common.g.b.c
    public final void c(String str) {
        if (q.a((CharSequence) str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            this.f16973u = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.f16973u.add(new e(jSONArray.getJSONObject(i2)));
            }
        } catch (JSONException unused) {
        }
    }

    @Override // sg.bigo.ads.common.g.b.c
    public final void d(String str) {
        if (q.a((CharSequence) str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            this.f16974v = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.f16974v.add(new e(jSONArray.getJSONObject(i2)));
            }
        } catch (JSONException unused) {
        }
    }

    @Override // sg.bigo.ads.common.g.b.c
    public final void a(String str) {
        if (q.a((CharSequence) str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            this.f16971s = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.f16971s.add(new e(jSONArray.getJSONObject(i2)));
            }
        } catch (JSONException unused) {
        }
    }

    public final boolean a(int i2) {
        return this.f16969q.b(i2);
    }

    private static boolean a(List<e> list) {
        return list != null && list.size() == 0;
    }

    public final boolean a(List<e> list, int i2) {
        return list == null || list.size() == 0 || !a(i2);
    }
}
