package com.ironsource;

import com.ironsource.C2422l1;
import com.ironsource.mediationsdk.IronSource;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.ironsource.j1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2386j1 implements InterfaceC2404k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IronSource.a f8743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f8744d;
    private final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f8745f;

    /* JADX INFO: renamed from: com.ironsource.j1$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8746a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f8747b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f8748c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f8749d = 1;

        private a() {
        }
    }

    public C2386j1(String version, String instanceId, IronSource.a adFormat, boolean z2, boolean z7, boolean z8) {
        kotlin.jvm.internal.k.e(version, "version");
        kotlin.jvm.internal.k.e(instanceId, "instanceId");
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        this.f8741a = version;
        this.f8742b = instanceId;
        this.f8743c = adFormat;
        this.f8744d = z2;
        this.e = z7;
        this.f8745f = z8;
    }

    @Override // com.ironsource.InterfaceC2404k1
    public ArrayList<InterfaceC2440m1> a() {
        ArrayList<InterfaceC2440m1> arrayList = new ArrayList<>();
        arrayList.add(new C2422l1.v(this.f8741a));
        arrayList.add(new C2422l1.x(this.f8742b));
        arrayList.add(new C2422l1.a(this.f8743c));
        if (this.f8744d) {
            arrayList.add(new C2422l1.p(1));
        }
        if (this.e) {
            arrayList.add(new C2422l1.e(1));
        }
        if (this.f8745f) {
            arrayList.add(new C2422l1.o(1));
        }
        return arrayList;
    }

    public /* synthetic */ C2386j1(String str, String str2, IronSource.a aVar, boolean z2, boolean z7, boolean z8, int i2, kotlin.jvm.internal.f fVar) {
        this(str, str2, aVar, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? true : z7, (i2 & 32) != 0 ? true : z8);
    }
}
