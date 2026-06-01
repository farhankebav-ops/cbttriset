package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.ironsourceads.AdSize;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.l1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2422l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2422l1 f8880a = new C2422l1();

    /* JADX INFO: renamed from: com.ironsource.l1$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IronSource.a f8881a;

        public a(IronSource.a value) {
            kotlin.jvm.internal.k.e(value, "value");
            this.f8881a = value;
        }

        private final IronSource.a a() {
            return this.f8881a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f8881a == ((a) obj).f8881a;
        }

        public int hashCode() {
            return this.f8881a.hashCode();
        }

        public String toString() {
            return "AdFormatEntity(value=" + this.f8881a + ")";
        }

        public final a a(IronSource.a value) {
            kotlin.jvm.internal.k.e(value, "value");
            return new a(value);
        }

        public static /* synthetic */ a a(a aVar, IronSource.a aVar2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                aVar2 = aVar.f8881a;
            }
            return aVar.a(aVar2);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put("adUnit", Integer.valueOf(C2627wf.c(this.f8881a)));
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8882a;

        public b(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this.f8882a = value;
        }

        private final String a() {
            return this.f8882a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && kotlin.jvm.internal.k.a(this.f8882a, ((b) obj).f8882a);
        }

        public int hashCode() {
            return this.f8882a.hashCode();
        }

        public String toString() {
            return a1.a.m("AdIdentifier(value=", this.f8882a, ")");
        }

        public final b a(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            return new b(value);
        }

        public static /* synthetic */ b a(b bVar, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = bVar.f8882a;
            }
            return bVar.a(str);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_IRONSOURCE_AD_OBJECT_ID, this.f8882a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AdSize f8883a;

        public c(AdSize size) {
            kotlin.jvm.internal.k.e(size, "size");
            this.f8883a = size;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
        @Override // com.ironsource.InterfaceC2440m1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(java.util.Map<java.lang.String, java.lang.Object> r4) {
            /*
                r3 = this;
                java.lang.String r0 = "bundle"
                kotlin.jvm.internal.k.e(r4, r0)
                com.unity3d.ironsourceads.AdSize r0 = r3.f8883a
                java.lang.String r0 = r0.getSizeDescription()
                int r1 = r0.hashCode()
                r2 = -96588539(0xfffffffffa3e2d05, float:-2.4686238E35)
                if (r1 == r2) goto L45
                r2 = 72205083(0x44dc31b, float:2.4187222E-36)
                if (r1 == r2) goto L3a
                r2 = 446888797(0x1aa2fb5d, float:6.740773E-23)
                if (r1 == r2) goto L2f
                r2 = 1951953708(0x7458732c, float:6.859571E31)
                if (r1 == r2) goto L24
                goto L4d
            L24:
                java.lang.String r1 = "BANNER"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L2d
                goto L4d
            L2d:
                r0 = 1
                goto L50
            L2f:
                java.lang.String r1 = "LEADERBOARD"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L38
                goto L4d
            L38:
                r0 = 4
                goto L50
            L3a:
                java.lang.String r1 = "LARGE"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L43
                goto L4d
            L43:
                r0 = 2
                goto L50
            L45:
                java.lang.String r1 = "MEDIUM_RECTANGLE"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L4f
            L4d:
                r0 = 0
                goto L50
            L4f:
                r0 = 3
            L50:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                java.lang.String r1 = "bannerAdSize"
                r4.put(r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.C2422l1.c.a(java.util.Map):void");
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class d implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8884a;

        public d(String auctionId) {
            kotlin.jvm.internal.k.e(auctionId, "auctionId");
            this.f8884a = auctionId;
        }

        private final String a() {
            return this.f8884a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && kotlin.jvm.internal.k.a(this.f8884a, ((d) obj).f8884a);
        }

        public int hashCode() {
            return this.f8884a.hashCode();
        }

        public String toString() {
            return a1.a.m("AuctionId(auctionId=", this.f8884a, ")");
        }

        public final d a(String auctionId) {
            kotlin.jvm.internal.k.e(auctionId, "auctionId");
            return new d(auctionId);
        }

        public static /* synthetic */ d a(d dVar, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = dVar.f8884a;
            }
            return dVar.a(str);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put("auctionId", this.f8884a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$e */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class e implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8885a;

        public e(int i2) {
            this.f8885a = i2;
        }

        private final int a() {
            return this.f8885a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && this.f8885a == ((e) obj).f8885a;
        }

        public int hashCode() {
            return this.f8885a;
        }

        public String toString() {
            return a1.a.h(this.f8885a, "DemandOnly(value=", ")");
        }

        public final e a(int i2) {
            return new e(i2);
        }

        public static /* synthetic */ e a(e eVar, int i2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i2 = eVar.f8885a;
            }
            return eVar.a(i2);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_DEMAND_ONLY, Integer.valueOf(this.f8885a));
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$f */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class f implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f8886a;

        public f(long j) {
            this.f8886a = j;
        }

        private final long a() {
            return this.f8886a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && this.f8886a == ((f) obj).f8886a;
        }

        public int hashCode() {
            long j = this.f8886a;
            return (int) (j ^ (j >>> 32));
        }

        public String toString() {
            return "Duration(duration=" + this.f8886a + ")";
        }

        public final f a(long j) {
            return new f(j);
        }

        public static /* synthetic */ f a(f fVar, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = fVar.f8886a;
            }
            return fVar.a(j);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put("duration", Long.valueOf(this.f8886a));
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$g */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class g implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8887a;

        public g(String dynamicSourceId) {
            kotlin.jvm.internal.k.e(dynamicSourceId, "dynamicSourceId");
            this.f8887a = dynamicSourceId;
        }

        private final String a() {
            return this.f8887a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof g) && kotlin.jvm.internal.k.a(this.f8887a, ((g) obj).f8887a);
        }

        public int hashCode() {
            return this.f8887a.hashCode();
        }

        public String toString() {
            return a1.a.m("DynamicDemandSourceId(dynamicSourceId=", this.f8887a, ")");
        }

        public final g a(String dynamicSourceId) {
            kotlin.jvm.internal.k.e(dynamicSourceId, "dynamicSourceId");
            return new g(dynamicSourceId);
        }

        public static /* synthetic */ g a(g gVar, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = gVar.f8887a;
            }
            return gVar.a(str);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put("dynamicDemandSource", this.f8887a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$h */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class h implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8888a;

        public h(String sourceId) {
            kotlin.jvm.internal.k.e(sourceId, "sourceId");
            this.f8888a = sourceId;
        }

        private final String a() {
            return this.f8888a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof h) && kotlin.jvm.internal.k.a(this.f8888a, ((h) obj).f8888a);
        }

        public int hashCode() {
            return this.f8888a.hashCode();
        }

        public String toString() {
            return a1.a.m("DynamicSourceId(sourceId=", this.f8888a, ")");
        }

        public final h a(String sourceId) {
            kotlin.jvm.internal.k.e(sourceId, "sourceId");
            return new h(sourceId);
        }

        public static /* synthetic */ h a(h hVar, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = hVar.f8888a;
            }
            return hVar.a(str);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put("dynamicDemandSource", this.f8888a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$i */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class i implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f8889a = new i();

        private i() {
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$j */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class j implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8890a;

        public j(int i2) {
            this.f8890a = i2;
        }

        private final int a() {
            return this.f8890a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof j) && this.f8890a == ((j) obj).f8890a;
        }

        public int hashCode() {
            return this.f8890a;
        }

        public String toString() {
            return a1.a.h(this.f8890a, "ErrorCode(code=", ")");
        }

        public final j a(int i2) {
            return new j(i2);
        }

        public static /* synthetic */ j a(j jVar, int i2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i2 = jVar.f8890a;
            }
            return jVar.a(i2);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(this.f8890a));
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$k */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class k implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8891a;

        public k(String str) {
            this.f8891a = str;
        }

        private final String a() {
            return this.f8891a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof k) && kotlin.jvm.internal.k.a(this.f8891a, ((k) obj).f8891a);
        }

        public int hashCode() {
            String str = this.f8891a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return a1.a.m("ErrorReason(reason=", this.f8891a, ")");
        }

        public final k a(String str) {
            return new k(str);
        }

        public static /* synthetic */ k a(k kVar, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = kVar.f8891a;
            }
            return kVar.a(str);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            String str = this.f8891a;
            if (str == null || str.length() == 0) {
                return;
            }
            bundle.put("reason", this.f8891a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$l */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class l implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8892a;

        public l(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this.f8892a = value;
        }

        private final String a() {
            return this.f8892a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof l) && kotlin.jvm.internal.k.a(this.f8892a, ((l) obj).f8892a);
        }

        public int hashCode() {
            return this.f8892a.hashCode();
        }

        public String toString() {
            return a1.a.m("Ext1(value=", this.f8892a, ")");
        }

        public final l a(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            return new l(value);
        }

        public static /* synthetic */ l a(l lVar, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = lVar.f8892a;
            }
            return lVar.a(str);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_EXT1, this.f8892a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$m */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class m implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JSONObject f8893a;

        public m(JSONObject jSONObject) {
            this.f8893a = jSONObject;
        }

        private final JSONObject a() {
            return this.f8893a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof m) && kotlin.jvm.internal.k.a(this.f8893a, ((m) obj).f8893a);
        }

        public int hashCode() {
            JSONObject jSONObject = this.f8893a;
            if (jSONObject == null) {
                return 0;
            }
            return jSONObject.hashCode();
        }

        public String toString() {
            return "GenericParams(genericParams=" + this.f8893a + ")";
        }

        public final m a(JSONObject jSONObject) {
            return new m(jSONObject);
        }

        public static /* synthetic */ m a(m mVar, JSONObject jSONObject, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                jSONObject = mVar.f8893a;
            }
            return mVar.a(jSONObject);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            JSONObject jSONObject = this.f8893a;
            if (jSONObject == null) {
                return;
            }
            bundle.put("genericParams", jSONObject);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$n */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class n implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8894a;

        public n(int i2) {
            this.f8894a = i2;
        }

        private final int a() {
            return this.f8894a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof n) && this.f8894a == ((n) obj).f8894a;
        }

        public int hashCode() {
            return this.f8894a;
        }

        public String toString() {
            return a1.a.h(this.f8894a, "InstanceType(instanceType=", ")");
        }

        public final n a(int i2) {
            return new n(i2);
        }

        public static /* synthetic */ n a(n nVar, int i2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i2 = nVar.f8894a;
            }
            return nVar.a(i2);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put("instanceType", Integer.valueOf(this.f8894a));
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$o */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class o implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8895a;

        public o(int i2) {
            this.f8895a = i2;
        }

        private final int a() {
            return this.f8895a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof o) && this.f8895a == ((o) obj).f8895a;
        }

        public int hashCode() {
            return this.f8895a;
        }

        public String toString() {
            return a1.a.h(this.f8895a, "MultipleAdObjects(value=", ")");
        }

        public final o a(int i2) {
            return new o(i2);
        }

        public static /* synthetic */ o a(o oVar, int i2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i2 = oVar.f8895a;
            }
            return oVar.a(i2);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put("isMultipleAdObjects", Integer.valueOf(this.f8895a));
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$p */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class p implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8896a;

        public p(int i2) {
            this.f8896a = i2;
        }

        private final int a() {
            return this.f8896a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof p) && this.f8896a == ((p) obj).f8896a;
        }

        public int hashCode() {
            return this.f8896a;
        }

        public String toString() {
            return a1.a.h(this.f8896a, "OneFlow(value=", ")");
        }

        public final p a(int i2) {
            return new p(i2);
        }

        public static /* synthetic */ p a(p pVar, int i2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i2 = pVar.f8896a;
            }
            return pVar.a(i2);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put("isOneFlow", Integer.valueOf(this.f8896a));
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$q */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class q implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8897a;

        public q(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this.f8897a = value;
        }

        private final String a() {
            return this.f8897a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof q) && kotlin.jvm.internal.k.a(this.f8897a, ((q) obj).f8897a);
        }

        public int hashCode() {
            return this.f8897a.hashCode();
        }

        public String toString() {
            return a1.a.m("Placement(value=", this.f8897a, ")");
        }

        public final q a(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            return new q(value);
        }

        public static /* synthetic */ q a(q qVar, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = qVar.f8897a;
            }
            return qVar.a(str);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put("placement", this.f8897a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$r */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class r implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8898a;

        public r(int i2) {
            this.f8898a = i2;
        }

        private final int a() {
            return this.f8898a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof r) && this.f8898a == ((r) obj).f8898a;
        }

        public int hashCode() {
            return this.f8898a;
        }

        public String toString() {
            return a1.a.h(this.f8898a, "Programmatic(programmatic=", ")");
        }

        public final r a(int i2) {
            return new r(i2);
        }

        public static /* synthetic */ r a(r rVar, int i2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i2 = rVar.f8898a;
            }
            return rVar.a(i2);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(this.f8898a));
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$s */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class s implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8899a;

        public s(String sourceName) {
            kotlin.jvm.internal.k.e(sourceName, "sourceName");
            this.f8899a = sourceName;
        }

        private final String a() {
            return this.f8899a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof s) && kotlin.jvm.internal.k.a(this.f8899a, ((s) obj).f8899a);
        }

        public int hashCode() {
            return this.f8899a.hashCode();
        }

        public String toString() {
            return a1.a.m("Provider(sourceName=", this.f8899a, ")");
        }

        public final s a(String sourceName) {
            kotlin.jvm.internal.k.e(sourceName, "sourceName");
            return new s(sourceName);
        }

        public static /* synthetic */ s a(s sVar, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = sVar.f8899a;
            }
            return sVar.a(str);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_PROVIDER, this.f8899a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$t */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class t implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8900a;

        public t(int i2) {
            this.f8900a = i2;
        }

        private final int a() {
            return this.f8900a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof t) && this.f8900a == ((t) obj).f8900a;
        }

        public int hashCode() {
            return this.f8900a;
        }

        public String toString() {
            return a1.a.h(this.f8900a, "RewardAmount(value=", ")");
        }

        public final t a(int i2) {
            return new t(i2);
        }

        public static /* synthetic */ t a(t tVar, int i2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i2 = tVar.f8900a;
            }
            return tVar.a(i2);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(this.f8900a));
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$u */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class u implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8901a;

        public u(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this.f8901a = value;
        }

        private final String a() {
            return this.f8901a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof u) && kotlin.jvm.internal.k.a(this.f8901a, ((u) obj).f8901a);
        }

        public int hashCode() {
            return this.f8901a.hashCode();
        }

        public String toString() {
            return a1.a.m("RewardName(value=", this.f8901a, ")");
        }

        public final u a(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            return new u(value);
        }

        public static /* synthetic */ u a(u uVar, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = uVar.f8901a;
            }
            return uVar.a(str);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_REWARD_NAME, this.f8901a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$v */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class v implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8902a;

        public v(String version) {
            kotlin.jvm.internal.k.e(version, "version");
            this.f8902a = version;
        }

        private final String a() {
            return this.f8902a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof v) && kotlin.jvm.internal.k.a(this.f8902a, ((v) obj).f8902a);
        }

        public int hashCode() {
            return this.f8902a.hashCode();
        }

        public String toString() {
            return a1.a.m("SdkVersion(version=", this.f8902a, ")");
        }

        public final v a(String version) {
            kotlin.jvm.internal.k.e(version, "version");
            return new v(version);
        }

        public static /* synthetic */ v a(v vVar, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = vVar.f8902a;
            }
            return vVar.a(str);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, this.f8902a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$w */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class w implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8903a;

        public w(int i2) {
            this.f8903a = i2;
        }

        private final int a() {
            return this.f8903a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof w) && this.f8903a == ((w) obj).f8903a;
        }

        public int hashCode() {
            return this.f8903a;
        }

        public String toString() {
            return a1.a.h(this.f8903a, "SessionDepth(sessionDepth=", ")");
        }

        public final w a(int i2) {
            return new w(i2);
        }

        public static /* synthetic */ w a(w wVar, int i2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i2 = wVar.f8903a;
            }
            return wVar.a(i2);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put("sessionDepth", Integer.valueOf(this.f8903a));
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$x */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class x implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8904a;

        public x(String subProviderId) {
            kotlin.jvm.internal.k.e(subProviderId, "subProviderId");
            this.f8904a = subProviderId;
        }

        private final String a() {
            return this.f8904a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof x) && kotlin.jvm.internal.k.a(this.f8904a, ((x) obj).f8904a);
        }

        public int hashCode() {
            return this.f8904a.hashCode();
        }

        public String toString() {
            return a1.a.m("SubProviderId(subProviderId=", this.f8904a, ")");
        }

        public final x a(String subProviderId) {
            kotlin.jvm.internal.k.e(subProviderId, "subProviderId");
            return new x(subProviderId);
        }

        public static /* synthetic */ x a(x xVar, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = xVar.f8904a;
            }
            return xVar.a(str);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put("spId", this.f8904a);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.l1$y */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class y implements InterfaceC2440m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8905a;

        public y(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this.f8905a = value;
        }

        private final String a() {
            return this.f8905a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof y) && kotlin.jvm.internal.k.a(this.f8905a, ((y) obj).f8905a);
        }

        public int hashCode() {
            return this.f8905a.hashCode();
        }

        public String toString() {
            return a1.a.m("TransId(value=", this.f8905a, ")");
        }

        public final y a(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            return new y(value);
        }

        public static /* synthetic */ y a(y yVar, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = yVar.f8905a;
            }
            return yVar.a(str);
        }

        @Override // com.ironsource.InterfaceC2440m1
        public void a(Map<String, Object> bundle) {
            kotlin.jvm.internal.k.e(bundle, "bundle");
            bundle.put(IronSourceConstants.EVENTS_TRANS_ID, this.f8905a);
        }
    }

    private C2422l1() {
    }
}
