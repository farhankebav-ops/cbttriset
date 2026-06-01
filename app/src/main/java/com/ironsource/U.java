package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class U {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f7646q = new a(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f7647r = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IronSource.a f7648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<NetworkSettings> f7650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C2496p2 f7651d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f7652f;
    private boolean g;
    private final int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f7653i;
    private final N0 j;
    private final H0 k;
    private final long l;
    private final boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f7654n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f7655o;
    private boolean p;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public U(IronSource.a adUnit, String str, List<? extends NetworkSettings> list, C2496p2 auctionSettings, int i2, int i8, boolean z2, int i9, int i10, N0 loadingData, H0 interactionData, long j, boolean z7, boolean z8, boolean z9, boolean z10) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        kotlin.jvm.internal.k.e(auctionSettings, "auctionSettings");
        kotlin.jvm.internal.k.e(loadingData, "loadingData");
        kotlin.jvm.internal.k.e(interactionData, "interactionData");
        this.f7648a = adUnit;
        this.f7649b = str;
        this.f7650c = list;
        this.f7651d = auctionSettings;
        this.e = i2;
        this.f7652f = i8;
        this.g = z2;
        this.h = i9;
        this.f7653i = i10;
        this.j = loadingData;
        this.k = interactionData;
        this.l = j;
        this.m = z7;
        this.f7654n = z8;
        this.f7655o = z9;
        this.p = z10;
    }

    public final void a(int i2) {
        this.e = i2;
    }

    public final IronSource.a b() {
        return this.f7648a;
    }

    public final boolean c() {
        return this.g;
    }

    public final C2496p2 d() {
        return this.f7651d;
    }

    public final long e() {
        return this.l;
    }

    public final int f() {
        return this.h;
    }

    public final H0 g() {
        return this.k;
    }

    public final N0 h() {
        return this.j;
    }

    public final int i() {
        return this.e;
    }

    public List<NetworkSettings> j() {
        return this.f7650c;
    }

    public final boolean k() {
        return this.m;
    }

    public final boolean l() {
        return this.f7655o;
    }

    public final boolean m() {
        return this.p;
    }

    public final int n() {
        return this.f7652f;
    }

    public String o() {
        return this.f7649b;
    }

    public final boolean p() {
        return this.f7654n;
    }

    public final boolean q() {
        return this.f7651d.g() > 0;
    }

    public final String r() {
        return String.format(Locale.getDefault(), "%s: %d, %s: %b, %s: %b", com.ironsource.mediationsdk.d.f9048x, Integer.valueOf(this.e), com.ironsource.mediationsdk.d.y, Boolean.valueOf(this.g), com.ironsource.mediationsdk.d.f9049z, Boolean.valueOf(this.p));
    }

    public final void a(boolean z2) {
        this.g = z2;
    }

    public final void b(boolean z2) {
        this.p = z2;
    }

    public final int a() {
        return this.f7653i;
    }

    public final NetworkSettings a(String instanceName) {
        kotlin.jvm.internal.k.e(instanceName, "instanceName");
        List<NetworkSettings> listJ = j();
        Object obj = null;
        if (listJ == null) {
            return null;
        }
        Iterator<T> it = listJ.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((NetworkSettings) next).getProviderInstanceName().equals(instanceName)) {
                obj = next;
                break;
            }
        }
        return (NetworkSettings) obj;
    }

    public /* synthetic */ U(IronSource.a aVar, String str, List list, C2496p2 c2496p2, int i2, int i8, boolean z2, int i9, int i10, N0 n02, H0 h0, long j, boolean z7, boolean z8, boolean z9, boolean z10, int i11, kotlin.jvm.internal.f fVar) {
        this(aVar, str, list, c2496p2, i2, i8, z2, i9, i10, n02, h0, j, z7, z8, z9, (i11 & 32768) != 0 ? false : z10);
    }
}
