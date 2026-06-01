package m7;

import java.util.ArrayList;
import l7.g0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f13021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13024d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f13025f;
    public final int g;
    public final long h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f13026i;
    public final int j;
    public final Long k;
    public final Long l;
    public final Long m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f13027n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f13028o;
    public final Integer p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList f13029q;

    public k(g0 canonicalPath, boolean z2, String comment, long j, long j3, long j8, int i2, long j9, int i8, int i9, Long l, Long l8, Long l9, Integer num, Integer num2, Integer num3) {
        kotlin.jvm.internal.k.e(canonicalPath, "canonicalPath");
        kotlin.jvm.internal.k.e(comment, "comment");
        this.f13021a = canonicalPath;
        this.f13022b = z2;
        this.f13023c = comment;
        this.f13024d = j;
        this.e = j3;
        this.f13025f = j8;
        this.g = i2;
        this.h = j9;
        this.f13026i = i8;
        this.j = i9;
        this.k = l;
        this.l = l8;
        this.m = l9;
        this.f13027n = num;
        this.f13028o = num2;
        this.p = num3;
        this.f13029q = new ArrayList();
    }

    public /* synthetic */ k(g0 g0Var, boolean z2, String str, long j, long j3, long j8, int i2, long j9, int i8, int i9, Long l, Long l8, Long l9, int i10) {
        this(g0Var, z2, (i10 & 4) != 0 ? "" : str, (i10 & 8) != 0 ? -1L : j, (i10 & 16) != 0 ? -1L : j3, (i10 & 32) != 0 ? -1L : j8, (i10 & 64) != 0 ? -1 : i2, (i10 & 128) != 0 ? -1L : j9, (i10 & 256) != 0 ? -1 : i8, (i10 & 512) != 0 ? -1 : i9, (i10 & 1024) != 0 ? null : l, (i10 & 2048) != 0 ? null : l8, (i10 & 4096) != 0 ? null : l9, null, null, null);
    }
}
