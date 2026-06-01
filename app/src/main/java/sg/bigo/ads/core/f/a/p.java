package sg.bigo.ads.core.f.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class p {
    public sg.bigo.ads.core.f.a.a.a B;
    public List<sg.bigo.ads.core.c.a> C;

    @Nullable
    public String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public b f17056n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public String f17057o;

    @Nullable
    public String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public String f17058q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    String f17059r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f17060s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    long f17061t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    long f17062u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f17063v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f17064w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f17065x = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ArrayList<n> f17050a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ArrayList<l> f17051b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ArrayList<c> f17052c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ArrayList<n> f17053d = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ArrayList<n> f17054f = new ArrayList<>();

    @NonNull
    public final ArrayList<n> e = new ArrayList<>();

    @NonNull
    public final ArrayList<j> g = new ArrayList<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ArrayList<n> f17055i = new ArrayList<>();

    @NonNull
    public final ArrayList<n> h = new ArrayList<>();

    @NonNull
    public final ArrayList<n> j = new ArrayList<>();

    @NonNull
    public final ArrayList<n> k = new ArrayList<>();

    @NonNull
    private final ArrayList<n> D = new ArrayList<>();

    @NonNull
    public final ArrayList<n> l = new ArrayList<>();
    public final List<n> y = new ArrayList();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final List<n> f17066z = new ArrayList();
    public final List<a> A = new ArrayList();

    public final void a(@NonNull List<n> list) {
        this.f17050a.addAll(list);
    }

    public final void b(@NonNull List<n> list) {
        this.D.addAll(list);
    }

    public final void c(@NonNull List<n> list) {
        this.l.addAll(list);
    }

    public final void d(@NonNull List<n> list) {
        this.f17053d.addAll(list);
    }

    public final void e(@NonNull List<n> list) {
        this.f17054f.addAll(list);
    }

    public final void f(@NonNull List<n> list) {
        this.e.addAll(list);
    }

    public final void g(@NonNull List<j> list) {
        this.g.addAll(list);
    }

    public final void h(@NonNull List<n> list) {
        this.f17055i.addAll(list);
    }

    public final void i(@NonNull List<n> list) {
        this.h.addAll(list);
    }

    public final void j(@NonNull List<n> list) {
        this.j.addAll(list);
    }

    public final void k(@NonNull List<l> list) {
        this.f17051b.addAll(list);
        Collections.sort(this.f17051b);
    }

    public final void l(@NonNull List<c> list) {
        this.f17052c.addAll(list);
        Collections.sort(this.f17052c);
    }
}
