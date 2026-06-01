package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.ironsource.G7;
import com.ironsource.H5;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.u3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2581u3 implements F7 {
    private int[] A;
    private int[] B;
    private int[] C;
    int G;
    String H;
    String I;
    Set<Integer> J;
    private F5 K;
    private C2270ca L;
    private Ne M;
    private boolean l;
    private G4 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AbstractC2295e f10362q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ArrayList<C5> f10363r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f10365t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private M8 f10366u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Context f10367v;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int[] f10370z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f10354a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f10355b = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f10356c = 5000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f10357d = 90000;
    final int e = 1024;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f10358f = 5;
    final String g = "supersonic_sdk.db";
    final String h = IronSourceConstants.EVENTS_PROVIDER;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final String f10359i = "placement";
    private final String j = "abt";
    private final String k = Q6.Z0;
    private boolean m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f10360n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f10361o = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f10364s = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f10368w = 100;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f10369x = 5000;
    private int y = 1;
    private Map<String, String> D = new HashMap();
    private Map<String, String> E = new HashMap();
    private String F = "";
    private final Object N = new Object();

    /* JADX INFO: renamed from: com.ironsource.u3$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2581u3.this.a();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.u3$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C5 f10372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IronSource.a f10373b;

        public b(C5 c52, IronSource.a aVar) {
            this.f10372a = c52;
            this.f10373b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10372a.a("eventSessionId", AbstractC2581u3.this.f10366u.b());
            this.f10372a.a("essn", Integer.valueOf(AbstractC2581u3.this.f10366u.c()));
            String strA = IronSourceUtils.a(AbstractC2581u3.this.f10367v);
            if (AbstractC2581u3.this.g(this.f10372a)) {
                this.f10372a.a("connectionType", strA);
            }
            if (AbstractC2581u3.p(this.f10372a, AbstractC2581u3.this, strA)) {
                C5 c52 = this.f10372a;
                c52.a(AbstractC2581u3.this.b(c52));
            }
            String strD = C2246b4.d(AbstractC2581u3.this.f10367v);
            if (strD != null) {
                this.f10372a.a("rawConnectionType", strD);
            }
            int iA = AbstractC2581u3.this.a(this.f10372a.c(), this.f10373b);
            if (iA != e.NOT_SUPPORTED.b()) {
                this.f10372a.a("adUnit", Integer.valueOf(iA));
            }
            AbstractC2581u3.this.a(this.f10372a, "reason");
            AbstractC2581u3.this.a(this.f10372a, IronSourceConstants.EVENTS_EXT1);
            if (!AbstractC2581u3.this.E.isEmpty()) {
                for (Map.Entry entry : AbstractC2581u3.this.E.entrySet()) {
                    if (!this.f10372a.b().has((String) entry.getKey()) && entry.getKey() != "eventId" && entry.getKey() != "timestamp") {
                        this.f10372a.a((String) entry.getKey(), entry.getValue());
                    }
                }
            }
            if (AbstractC2581u3.this.i(this.f10372a)) {
                if (AbstractC2581u3.this.h(this.f10372a) && !AbstractC2581u3.this.e(this.f10372a)) {
                    this.f10372a.a("sessionDepth", Integer.valueOf(AbstractC2581u3.this.c(this.f10372a)));
                }
                if (AbstractC2581u3.this.j(this.f10372a)) {
                    AbstractC2581u3.this.f(this.f10372a);
                }
                long jA = AbstractC2581u3.this.f10366u.a();
                if (jA > 0) {
                    this.f10372a.a("firstSessionTimestamp", Long.valueOf(jA));
                }
                IronLog.EVENT.verbose(this.f10372a.toString());
                AbstractC2581u3.this.f10363r.add(this.f10372a);
                AbstractC2581u3.this.f10365t++;
            }
            AbstractC2581u3 abstractC2581u3 = AbstractC2581u3.this;
            boolean zA = abstractC2581u3.a(abstractC2581u3.B) ? AbstractC2581u3.this.a(this.f10372a.c(), AbstractC2581u3.this.B) : AbstractC2581u3.this.d(this.f10372a);
            AbstractC2581u3 abstractC2581u32 = AbstractC2581u3.this;
            if (!abstractC2581u32.m && zA) {
                abstractC2581u32.m = true;
            }
            if (abstractC2581u32.p != null) {
                if (abstractC2581u32.g()) {
                    AbstractC2581u3.this.f();
                    return;
                }
                AbstractC2581u3 abstractC2581u33 = AbstractC2581u3.this;
                if (abstractC2581u33.b((ArrayList<C5>) abstractC2581u33.f10363r) || zA) {
                    AbstractC2581u3.this.a();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.u3$c */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c implements G7 {
        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(G7.a aVar) {
            try {
                if (aVar.c()) {
                    AbstractC2581u3 abstractC2581u3 = AbstractC2581u3.this;
                    ArrayList<C5> arrayListA = abstractC2581u3.p.a(abstractC2581u3.I);
                    AbstractC2581u3.this.f10365t = arrayListA.size() + AbstractC2581u3.this.f10363r.size();
                } else {
                    IronLog.INTERNAL.error("Failed to send events. Saving them back to storage.");
                    AbstractC2581u3.this.a(AbstractC2581u3.this.a(aVar.b(), aVar.a()));
                }
            } catch (Exception e) {
                C2531r4.d().a(e);
            }
            a(aVar.b());
        }

        public void a(ArrayList<C5> arrayList) {
            if (arrayList != null) {
                try {
                    arrayList.clear();
                } catch (Exception e) {
                    C2531r4.d().a(e);
                    IronLog.INTERNAL.error("clearData exception: " + e.getMessage());
                }
            }
        }

        @Override // com.ironsource.G7
        public synchronized void a(G7.a aVar) {
            AbstractC2581u3.this.K.a(new ti(1, this, aVar));
        }
    }

    /* JADX INFO: renamed from: com.ironsource.u3$d */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2581u3.this.f();
        }
    }

    /* JADX INFO: renamed from: com.ironsource.u3$e */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum e {
        NOT_SUPPORTED(-1),
        INTERSTITIAL(2),
        REWARDED_VIDEO(3),
        NATIVE_AD(4),
        BANNER(8);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f10381a;

        e(int i2) {
            this.f10381a = i2;
        }

        public int b() {
            return this.f10381a;
        }
    }

    public static /* bridge */ /* synthetic */ boolean p(C5 c52, AbstractC2581u3 abstractC2581u3, String str) {
        return abstractC2581u3.a(str, c52);
    }

    public abstract int c(C5 c52);

    public abstract void d();

    public abstract boolean d(C5 c52);

    public abstract String e(int i2);

    public abstract void f(C5 c52);

    public abstract boolean j(C5 c52);

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int b(C5 c52) {
        return c52.c() + 90000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void f() {
        ArrayList<C5> arrayListA;
        try {
            this.m = false;
            ArrayList<C5> arrayList = new ArrayList<>();
            try {
                synchronized (this.N) {
                    arrayListA = this.p.a(this.I);
                    this.p.b(this.I);
                }
                H5.c cVar = new H5.c(new H5.a(arrayListA, this.f10363r), this.f10369x);
                this.p.a(cVar.a(), this.I);
                arrayList.addAll(cVar.b());
            } catch (Throwable th) {
                C2531r4.d().a(th);
                IronLog.INTERNAL.error("CombinedEventList exception: " + th.getMessage());
                arrayList.clear();
                arrayList.addAll(this.f10363r);
            }
            if (arrayList.size() > 0) {
                this.f10363r.clear();
                this.f10365t = 0;
                JSONObject jSONObjectB = N6.a().b();
                try {
                    a(jSONObjectB);
                    String strB = b();
                    if (!TextUtils.isEmpty(strB)) {
                        jSONObjectB.put("abt", strB);
                    }
                    String strP = com.ironsource.mediationsdk.r.m().p();
                    if (!TextUtils.isEmpty(strP)) {
                        jSONObjectB.put(Q6.Z0, strP);
                    }
                    Map<String, String> mapC = c();
                    if (!mapC.isEmpty()) {
                        for (Map.Entry<String, String> entry : mapC.entrySet()) {
                            if (!jSONObjectB.has(entry.getKey())) {
                                jSONObjectB.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    JSONObject jSONObjectA = new M5().a();
                    Iterator<String> itKeys = jSONObjectA.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObjectB.put(next, jSONObjectA.get(next));
                    }
                } catch (Throwable th2) {
                    C2531r4.d().a(th2);
                    IronLog.INTERNAL.error("Exception while building the event general properties: " + th2.getMessage());
                }
                String strA = this.f10362q.a(arrayList, jSONObjectB);
                if (TextUtils.isEmpty(strA)) {
                    IronLog.INTERNAL.error("Failed to parse events.");
                    return;
                }
                if (this.f10360n) {
                    try {
                        strA = Base64.encodeToString(S9.a(strA, this.f10361o), 0);
                    } catch (Exception e4) {
                        C2531r4.d().a(e4);
                    }
                }
                C2644xf.f10528a.a(new N5(new c(), strA, this.f10362q.b(), arrayList));
            }
        } catch (Throwable th3) {
            C2531r4.d().a(th3);
            IronLog.INTERNAL.error("Send event exception: " + th3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return (this.f10365t >= this.f10368w || this.m) && this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(C5 c52) {
        if (c52 == null) {
            return false;
        }
        if (a(this.f10370z)) {
            return !a(c52.c(), this.f10370z);
        }
        if (a(this.A)) {
            return a(c52.c(), this.A);
        }
        return true;
    }

    public synchronized void a(Context context, C2270ca c2270ca) {
        String strA = IronSourceUtils.a(context, this.I, this.H);
        this.H = strA;
        b(strA);
        this.f10362q.a(IronSourceUtils.b(context, this.I, (String) null));
        this.p = G4.a(context, "supersonic_sdk.db", 5);
        this.K.a(new a());
        this.f10370z = IronSourceUtils.c(context, this.I);
        this.A = IronSourceUtils.b(context, this.I);
        this.B = IronSourceUtils.d(context, this.I);
        this.C = IronSourceUtils.a(context, this.I);
        this.L = c2270ca;
        this.f10367v = context;
    }

    @Override // com.ironsource.F7
    public void c(int[] iArr, Context context) {
        this.A = iArr;
        IronSourceUtils.b(context, this.I, iArr);
    }

    @Override // com.ironsource.F7
    public void d(int i2) {
        if (i2 > 0) {
            this.f10369x = i2;
        }
    }

    public void e() {
        this.f10363r = new ArrayList<>();
        this.f10365t = 0;
        this.f10362q = K5.a(this.H, this.G);
        F5 f52 = new F5(a1.a.r(new StringBuilder(), this.I, "EventThread"));
        this.K = f52;
        f52.start();
        this.K.a();
        this.f10366u = Mb.U().m();
        this.J = new HashSet();
        d();
    }

    public void h() {
        this.K.a(new d());
    }

    private void b(String str) {
        AbstractC2295e abstractC2295e = this.f10362q;
        if (abstractC2295e == null || !abstractC2295e.c().equals(str)) {
            this.f10362q = K5.a(str, this.G);
        }
    }

    @Override // com.ironsource.F7
    public void d(int[] iArr, Context context) {
        this.C = iArr;
        IronSourceUtils.a(context, this.I, iArr);
    }

    public boolean g(C5 c52) {
        return (c52.c() == D5.CONSENT_TRUE_CODE.b() || c52.c() == D5.CONSENT_FALSE_CODE.b() || c52.c() == D5.SET_META_DATA.b() || c52.c() == D5.SET_META_DATA_AFTER_INIT.b() || c52.c() == D5.SET_USER_ID.b()) ? false : true;
    }

    public boolean h(C5 c52) {
        return (c52.c() == D5.FIRST_INSTANCE.b() || c52.c() == D5.FIRST_INSTANCE_RESULT.b() || c52.c() == D5.INIT_COMPLETE.b() || c52.c() == D5.SDK_INIT_FAILED.b() || c52.c() == D5.SDK_INIT_SUCCESS.b() || c52.c() == D5.USING_CACHE_FOR_INIT_EVENT.b() || c52.c() == D5.CONSENT_TRUE_CODE.b() || c52.c() == D5.CONSENT_FALSE_CODE.b() || c52.c() == D5.SET_META_DATA.b() || c52.c() == D5.SET_META_DATA_AFTER_INIT.b() || c52.c() == D5.SET_USER_ID.b()) ? false : true;
    }

    @Override // com.ironsource.F7
    public void c(int i2) {
        this.f10361o = i2;
    }

    @Override // com.ironsource.F7
    public void b(int i2) {
        if (i2 > 0) {
            this.y = i2;
        }
    }

    public void c(boolean z2) {
        this.l = z2;
    }

    @Override // com.ironsource.F7
    public void b(int[] iArr, Context context) {
        this.f10370z = iArr;
        IronSourceUtils.c(context, this.I, iArr);
    }

    public Map<String, String> c() {
        return this.D;
    }

    @Override // com.ironsource.F7
    public void b(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AbstractC2295e abstractC2295e = this.f10362q;
        if (abstractC2295e != null) {
            abstractC2295e.a(str);
        }
        IronSourceUtils.e(context, this.I, str);
    }

    @Override // com.ironsource.F7
    public void b(boolean z2) {
        this.f10360n = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ArrayList<C5> arrayList) {
        return arrayList != null && arrayList.size() >= this.y;
    }

    public synchronized void a(Ne ne) {
        this.M = ne;
    }

    public String b() {
        return this.F;
    }

    private synchronized boolean a(String str, C5 c52) {
        boolean zContains;
        try {
            if (!str.equalsIgnoreCase("none")) {
                return false;
            }
            if (a(this.C)) {
                zContains = a(c52.c(), this.C);
            } else {
                zContains = this.J.contains(Integer.valueOf(c52.c()));
            }
            return zContains;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void b(Map<String, String> map) {
        this.E.putAll(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(C5 c52) {
        JSONObject jSONObjectB = c52.b();
        if (jSONObjectB == null) {
            return false;
        }
        return jSONObjectB.has("sessionDepth");
    }

    @Override // com.ironsource.F7
    public synchronized void a(C5 c52) {
        a(c52, (IronSource.a) null);
    }

    public synchronized void a(C5 c52, IronSource.a aVar) {
        if (c52 != null) {
            if (this.f10364s) {
                this.K.a(new b(c52, aVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<C5> a(ArrayList<C5> arrayList, String str) {
        String strA = a(str, 1024);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            C5 c52 = arrayList.get(i2);
            i2++;
            c52.a(strA);
        }
        return arrayList;
    }

    public void a(ArrayList<C5> arrayList) {
        if (arrayList != null) {
            synchronized (this.N) {
                this.p.a(arrayList, this.I);
                this.f10365t = this.p.a(this.I).size() + this.f10363r.size();
            }
        }
    }

    @Override // com.ironsource.F7
    public void a(int i2) {
        if (i2 > 0) {
            this.f10368w = i2;
        }
    }

    @Override // com.ironsource.F7
    public void a(int[] iArr, Context context) {
        this.B = iArr;
        IronSourceUtils.d(context, this.I, iArr);
    }

    @Override // com.ironsource.F7
    public void a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.H = str;
        IronSourceUtils.d(context, this.I, str);
        b(str);
    }

    @Override // com.ironsource.F7
    public void a(boolean z2) {
        this.f10364s = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        synchronized (this.N) {
            this.p.a(this.f10363r, this.I);
            this.f10363r.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int[] iArr) {
        return iArr != null && iArr.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2, int[] iArr) {
        if (a(iArr)) {
            for (int i8 : iArr) {
                if (i2 == i8) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(JSONObject jSONObject) {
        try {
            C2270ca c2270ca = this.L;
            if (c2270ca != null) {
                if (c2270ca.a() > 0) {
                    jSONObject.put(C2270ca.m, this.L.a());
                }
                if (!TextUtils.isEmpty(this.L.b())) {
                    jSONObject.put(C2270ca.f8129n, this.L.b());
                }
                if (this.L.e() > 0) {
                    jSONObject.put("lvl", this.L.e());
                }
                if (this.L.d() != null) {
                    jSONObject.put("pay", this.L.d().get());
                }
                if (this.L.c() > 0.0d) {
                    jSONObject.put("iapt", this.L.c());
                }
                if (this.L.h() > 0) {
                    jSONObject.put("ucd", this.L.h());
                }
            }
            Ne ne = this.M;
            if (ne != null) {
                String strB = ne.b();
                if (!TextUtils.isEmpty(strB)) {
                    jSONObject.put("segmentId", strB);
                }
                JSONObject jSONObjectA = this.M.a();
                Iterator<String> itKeys = jSONObjectA.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject.put(next, jSONObjectA.get(next));
                }
            }
        } catch (JSONException e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
        }
    }

    public int f(int i2) {
        return a(i2, (IronSource.a) null);
    }

    public void a(String str) {
        this.F = str;
    }

    public void a(Map<String, String> map) {
        this.D.putAll(map);
    }

    public void a(Map<String, Object> map, int i2, String str) {
        map.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        map.put(IronSourceConstants.AUCTION_FALLBACK, str);
    }

    private void a(C5 c52, String str, int i2) {
        JSONObject jSONObjectB = c52.b();
        if (jSONObjectB == null || !jSONObjectB.has(str)) {
            return;
        }
        try {
            c52.a(str, a(jSONObjectB.optString(str, null), i2));
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
        }
    }

    public String a(String str, int i2) {
        return (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C5 c52, String str) {
        a(c52, str, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i2, IronSource.a aVar) {
        int iB = e.NOT_SUPPORTED.b();
        if (aVar != IronSource.a.REWARDED_VIDEO && ((i2 < 1000 || i2 >= 2000) && (i2 < 91000 || i2 >= 92000))) {
            if (aVar != IronSource.a.INTERSTITIAL && ((i2 < 2000 || i2 >= 3000) && (i2 < 92000 || i2 >= 93000))) {
                if (aVar == IronSource.a.BANNER || ((i2 >= 3000 && i2 < 4000) || (i2 >= 93000 && i2 < 94000))) {
                    return e.BANNER.b();
                }
                return (aVar == IronSource.a.NATIVE_AD || (i2 >= 4000 && i2 < 5000) || (i2 >= 94000 && i2 < 95000)) ? e.NATIVE_AD.b() : iB;
            }
            return e.INTERSTITIAL.b();
        }
        return e.REWARDED_VIDEO.b();
    }

    public void a(C2270ca c2270ca) {
        this.L = c2270ca;
    }

    public void a(Runnable runnable) {
        this.K.a(runnable);
    }
}
