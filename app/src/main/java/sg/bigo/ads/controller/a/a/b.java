package sg.bigo.ads.controller.a.a;

import android.os.Parcel;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.common.f;
import sg.bigo.ads.common.n;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.controller.a.j;

/* JADX INFO: loaded from: classes6.dex */
public class b implements sg.bigo.ads.common.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0305b f16269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0305b f16270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16272d;
    private final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<a, C0305b> f16273f;
    private Map<a, List<C0305b>> g;
    private int h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<a, C0305b> f16274i = a();
    private Map<a, List<C0305b>> j;

    public static class a implements sg.bigo.ads.common.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final f.a<a> f16276c = new f.a<a>() { // from class: sg.bigo.ads.controller.a.a.b.a.1
            @Override // sg.bigo.ads.common.f.a
            public final /* synthetic */ sg.bigo.ads.common.f a() {
                return new a("", 0);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f16277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f16278b;

        public a(String str, int i2) {
            this.f16277a = TextUtils.isEmpty(str) ? "all" : str.toLowerCase();
            this.f16278b = i2;
        }

        @Override // sg.bigo.ads.common.f
        public final void b(@NonNull Parcel parcel) {
            this.f16277a = n.a(parcel, "");
            this.f16278b = n.a(parcel, 0);
        }

        public final boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (TextUtils.equals(this.f16277a, aVar.f16277a) && this.f16278b == aVar.f16278b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (this.f16277a + "_" + this.f16278b).hashCode();
        }

        @NonNull
        public final String toString() {
            return super.toString();
        }

        @Override // sg.bigo.ads.common.f
        public final void a(@NonNull Parcel parcel) {
            parcel.writeString(this.f16277a);
            parcel.writeInt(this.f16278b);
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.controller.a.a.b$b, reason: collision with other inner class name */
    public static class C0305b extends j implements sg.bigo.ads.common.f {
        private static final f.a<C0305b> e = new f.a<C0305b>() { // from class: sg.bigo.ads.controller.a.a.b.b.1
            @Override // sg.bigo.ads.common.f.a
            public final /* synthetic */ sg.bigo.ads.common.f a() {
                return new C0305b("", "", 0);
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f16279d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f16280f;
        private long g;
        private int h;

        public C0305b(String str, String str2, int i2) {
            super(str, str2, i2);
            this.f16279d = true;
            this.f16280f = 0;
            this.g = 0L;
            this.h = 0;
        }

        public static /* synthetic */ int c(C0305b c0305b) {
            c0305b.h = 0;
            return 0;
        }

        public static /* synthetic */ int e(C0305b c0305b) {
            int i2 = c0305b.f16280f;
            c0305b.f16280f = i2 + 1;
            return i2;
        }

        public static /* synthetic */ int f(C0305b c0305b) {
            c0305b.f16280f = 0;
            return 0;
        }

        public static /* synthetic */ int g(C0305b c0305b) {
            int i2 = c0305b.h;
            c0305b.h = i2 + 1;
            return i2;
        }

        public final boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof j) {
                return TextUtils.equals(this.f16381a, ((j) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            String str = this.f16381a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // sg.bigo.ads.common.f
        public final void a(@NonNull Parcel parcel) {
            parcel.writeString(this.f16381a);
            parcel.writeInt(this.f16383c);
            n.a(parcel, this.f16279d);
            parcel.writeString(this.f16382b);
            parcel.writeInt(this.f16280f);
            parcel.writeLong(this.g);
            parcel.writeInt(this.h);
        }

        @Override // sg.bigo.ads.common.f
        public final void b(@NonNull Parcel parcel) {
            this.f16381a = n.a(parcel, "");
            this.f16383c = n.a(parcel, 1);
            this.f16279d = n.b(parcel, true);
            this.f16382b = n.a(parcel, "");
            this.f16280f = n.a(parcel, 0);
            this.g = n.a(parcel, 0L);
            this.h = n.a(parcel, 0);
        }

        public final void a(String str) {
            this.f16382b = str;
        }
    }

    public b(@NonNull String str, @Nullable String str2) {
        this.f16272d = str;
        this.e = str2;
    }

    @Nullable
    private C0305b b(Map<a, List<C0305b>> map, a aVar) {
        if (!k.a(map) && aVar != null) {
            Iterator<a> it = a(aVar).iterator();
            while (it.hasNext()) {
                C0305b c0305b = (C0305b) k.a(k.a(map.get(it.next()), new Comparable<C0305b>() { // from class: sg.bigo.ads.controller.a.a.b.1
                    @Override // java.lang.Comparable
                    public final /* bridge */ /* synthetic */ int compareTo(C0305b c0305b2) {
                        C0305b c0305b3 = c0305b2;
                        return (c0305b3 == null || !c0305b3.f16279d) ? 0 : 1;
                    }
                }));
                if (a(c0305b)) {
                    return c0305b;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0020 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<java.lang.String, java.lang.Integer> a(sg.bigo.ads.api.a.h r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.util.Map<sg.bigo.ads.controller.a.a.b$a, sg.bigo.ads.controller.a.a.b$b> r0 = r9.f16273f     // Catch: java.lang.Throwable -> Lc
            boolean r0 = sg.bigo.ads.common.utils.k.a(r0)     // Catch: java.lang.Throwable -> Lc
            r1 = 0
            if (r0 == 0) goto Lf
        La:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> Lc
            return r1
        Lc:
            r10 = move-exception
            goto L9f
        Lf:
            if (r10 != 0) goto L12
            goto La
        L12:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lc
            java.util.Map<sg.bigo.ads.controller.a.a.b$a, sg.bigo.ads.controller.a.a.b$b> r0 = r9.f16273f     // Catch: java.lang.Throwable -> Lc
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> Lc
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> Lc
        L20:
            boolean r4 = r0.hasNext()     // Catch: java.lang.Throwable -> Lc
            if (r4 == 0) goto La
            java.lang.Object r4 = r0.next()     // Catch: java.lang.Throwable -> Lc
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch: java.lang.Throwable -> Lc
            java.lang.Object r4 = r4.getValue()     // Catch: java.lang.Throwable -> Lc
            sg.bigo.ads.controller.a.a.b$b r4 = (sg.bigo.ads.controller.a.a.b.C0305b) r4     // Catch: java.lang.Throwable -> Lc
            boolean r5 = r4.f16279d     // Catch: java.lang.Throwable -> Lc
            if (r5 != 0) goto L20
            int r5 = sg.bigo.ads.controller.a.a.b.C0305b.b(r4)     // Catch: java.lang.Throwable -> Lc
            int r6 = r10.y()     // Catch: java.lang.Throwable -> Lc
            int r5 = r5 % r6
            if (r5 != 0) goto L69
            sg.bigo.ads.controller.a.a.b.C0305b.c(r4)     // Catch: java.lang.Throwable -> Lc
            long r5 = sg.bigo.ads.controller.a.a.b.C0305b.d(r4)     // Catch: java.lang.Throwable -> Lc
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L4f
            goto L84
        L4f:
            long r5 = sg.bigo.ads.controller.a.a.b.C0305b.d(r4)     // Catch: java.lang.Throwable -> Lc
            long r5 = r2 - r5
            long r5 = java.lang.Math.abs(r5)     // Catch: java.lang.Throwable -> Lc
            float r5 = (float) r5     // Catch: java.lang.Throwable -> Lc
            r6 = 1285868416(0x4ca4cb80, float:8.64E7)
            float r5 = r5 / r6
            int r5 = java.lang.Math.round(r5)     // Catch: java.lang.Throwable -> Lc
            int r6 = r10.A()     // Catch: java.lang.Throwable -> Lc
            if (r5 <= r6) goto L83
            goto L84
        L69:
            long r5 = sg.bigo.ads.controller.a.a.b.C0305b.d(r4)     // Catch: java.lang.Throwable -> Lc
            long r5 = r2 - r5
            long r5 = java.lang.Math.abs(r5)     // Catch: java.lang.Throwable -> Lc
            float r5 = (float) r5     // Catch: java.lang.Throwable -> Lc
            r6 = 1198153728(0x476a6000, float:60000.0)
            float r5 = r5 / r6
            int r5 = java.lang.Math.round(r5)     // Catch: java.lang.Throwable -> Lc
            int r6 = r10.z()     // Catch: java.lang.Throwable -> Lc
            if (r5 <= r6) goto L83
            goto L84
        L83:
            r4 = r1
        L84:
            if (r4 == 0) goto L20
            sg.bigo.ads.controller.a.a.b.C0305b.a(r4, r2)     // Catch: java.lang.Throwable -> Lc
            sg.bigo.ads.controller.a.a.b.C0305b.e(r4)     // Catch: java.lang.Throwable -> Lc
            android.util.Pair r10 = new android.util.Pair     // Catch: java.lang.Throwable -> Lc
            java.lang.String r0 = r4.a()     // Catch: java.lang.Throwable -> Lc
            int r1 = sg.bigo.ads.controller.a.a.b.C0305b.b(r4)     // Catch: java.lang.Throwable -> Lc
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> Lc
            r10.<init>(r0, r1)     // Catch: java.lang.Throwable -> Lc
            monitor-exit(r9)     // Catch: java.lang.Throwable -> Lc
            return r10
        L9f:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> Lc
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.a.a.b.a(sg.bigo.ads.api.a.h):android.util.Pair");
    }

    @NonNull
    public String toString() {
        return super.toString();
    }

    @NonNull
    private static List<a> a(@NonNull a aVar) {
        ArrayList arrayList = new ArrayList();
        a aVar2 = new a("all", 0);
        if (aVar2.equals(aVar)) {
            arrayList.add(0, aVar);
            return arrayList;
        }
        arrayList.add(0, aVar2);
        a aVar3 = new a("all", aVar.f16278b);
        if (aVar3.equals(aVar)) {
            arrayList.add(0, aVar);
            return arrayList;
        }
        arrayList.add(0, aVar3);
        a aVar4 = new a(aVar.f16277a, 0);
        if (aVar4.equals(aVar)) {
            arrayList.add(0, aVar);
            return arrayList;
        }
        arrayList.add(0, aVar4);
        arrayList.add(0, aVar);
        return arrayList;
    }

    @Override // sg.bigo.ads.common.f
    @CallSuper
    public void b(@NonNull Parcel parcel) {
        synchronized (this) {
            try {
                this.f16273f = n.a(parcel, a.f16276c, C0305b.e);
                this.g = n.b(parcel, a.f16276c, C0305b.e);
                this.h = n.a(parcel, 3);
                Map mapA = n.a(parcel, a.f16276c, C0305b.e);
                this.j = n.b(parcel, a.f16276c, C0305b.e);
                this.f16269a = (C0305b) n.b(parcel, C0305b.e);
                this.f16270b = (C0305b) n.b(parcel, C0305b.e);
                this.f16271c = n.a(parcel, 0);
                this.f16274i = a();
                HashSet hashSet = new HashSet();
                for (C0305b c0305b : this.f16274i.values()) {
                    hashSet.add(c0305b.a());
                    if (!k.a(mapA)) {
                        for (C0305b c0305b2 : mapA.values()) {
                            if (TextUtils.equals(c0305b.a(), c0305b2.a())) {
                                c0305b.f16279d = c0305b2.f16279d;
                            }
                        }
                    }
                }
                C0305b c0305b3 = this.f16270b;
                if (c0305b3 != null && c0305b3.d() == 0 && !hashSet.contains(this.f16270b.a())) {
                    this.f16269a = this.f16270b;
                    this.f16270b = null;
                    this.f16271c = 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    private Map<a, C0305b> a() {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(this.f16272d)) {
            map.put(new a("all", 0), new C0305b(this.f16272d, "", 0));
        }
        if (!TextUtils.isEmpty(this.e)) {
            map.put(new a("ru", 0), new C0305b(this.e, "", 0));
        }
        return map;
    }

    @Nullable
    private static C0305b a(Map<a, C0305b> map, a aVar) {
        if (!k.a(map) && aVar != null) {
            Iterator<a> it = a(aVar).iterator();
            while (it.hasNext()) {
                C0305b c0305b = map.get(it.next());
                if (a(c0305b)) {
                    return c0305b;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034 A[PHI: r0
  0x0034: PHI (r0v2 sg.bigo.ads.controller.a.a.b$b) = 
  (r0v1 sg.bigo.ads.controller.a.a.b$b)
  (r0v5 sg.bigo.ads.controller.a.a.b$b)
  (r0v7 sg.bigo.ads.controller.a.a.b$b)
  (r0v9 sg.bigo.ads.controller.a.a.b$b)
 binds: [B:3:0x000b, B:5:0x0017, B:7:0x0023, B:9:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private sg.bigo.ads.controller.a.a.b.C0305b a(sg.bigo.ads.controller.a.a.b.a r6, boolean r7) {
        /*
            r5 = this;
            java.util.Map<sg.bigo.ads.controller.a.a.b$a, sg.bigo.ads.controller.a.a.b$b> r0 = r5.f16273f
            sg.bigo.ads.controller.a.a.b$b r0 = a(r0, r6)
            boolean r1 = a(r0)
            r2 = 0
            if (r1 != 0) goto L34
            java.util.Map<sg.bigo.ads.controller.a.a.b$a, java.util.List<sg.bigo.ads.controller.a.a.b$b>> r0 = r5.g
            sg.bigo.ads.controller.a.a.b$b r0 = r5.b(r0, r6)
            boolean r1 = a(r0)
            if (r1 != 0) goto L34
            java.util.Map<sg.bigo.ads.controller.a.a.b$a, sg.bigo.ads.controller.a.a.b$b> r0 = r5.f16274i
            sg.bigo.ads.controller.a.a.b$b r0 = a(r0, r6)
            boolean r1 = a(r0)
            if (r1 != 0) goto L34
            java.util.Map<sg.bigo.ads.controller.a.a.b$a, java.util.List<sg.bigo.ads.controller.a.a.b$b>> r0 = r5.j
            sg.bigo.ads.controller.a.a.b$b r0 = r5.b(r0, r6)
            boolean r1 = a(r0)
            if (r1 == 0) goto L32
            goto L34
        L32:
            r1 = r2
            goto L35
        L34:
            r1 = 1
        L35:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "getBestHost "
            r3.<init>(r4)
            if (r1 == 0) goto L41
            java.lang.String r1 = "success"
            goto L43
        L41:
            java.lang.String r1 = "fail"
        L43:
            r3.append(r1)
            if (r7 == 0) goto L4b
            java.lang.String r7 = " after reset"
            goto L4d
        L4b:
            java.lang.String r7 = ""
        L4d:
            r3.append(r7)
            java.lang.String r7 = ", countryKey="
            r3.append(r7)
            r3.append(r6)
            java.lang.String r6 = ", currentHost="
            r3.append(r6)
            sg.bigo.ads.controller.a.a.b$b r6 = r5.f16270b
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            r7 = 3
            java.lang.String r1 = "AntiBanHost"
            sg.bigo.ads.common.t.a.a(r2, r7, r1, r6)
            boolean r6 = a(r0)
            if (r6 == 0) goto L73
            return r0
        L73:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.a.a.b.a(sg.bigo.ads.controller.a.a.b$a, boolean):sg.bigo.ads.controller.a.a.b$b");
    }

    @NonNull
    public final sg.bigo.ads.controller.a.e a(String str, int i2) {
        boolean z2;
        sg.bigo.ads.controller.a.e eVar;
        synchronized (this) {
            try {
                C0305b c0305b = this.f16270b;
                if (c0305b == null || this.f16271c >= this.h) {
                    a aVar = new a(str, i2);
                    C0305b c0305bA = a(aVar, false);
                    if (a(c0305bA)) {
                        z2 = false;
                    } else {
                        Map<a, C0305b> map = this.f16273f;
                        if (map != null) {
                            Iterator<Map.Entry<a, C0305b>> it = map.entrySet().iterator();
                            while (it.hasNext()) {
                                C0305b value = it.next().getValue();
                                if (value != null) {
                                    value.f16279d = true;
                                }
                            }
                        }
                        Map<a, List<C0305b>> map2 = this.g;
                        if (map2 != null) {
                            Iterator<Map.Entry<a, List<C0305b>>> it2 = map2.entrySet().iterator();
                            while (it2.hasNext()) {
                                List<C0305b> value2 = it2.next().getValue();
                                if (!k.a((Collection) value2)) {
                                    Iterator<C0305b> it3 = value2.iterator();
                                    while (it3.hasNext()) {
                                        it3.next().f16279d = true;
                                    }
                                }
                            }
                        }
                        Map<a, List<C0305b>> map3 = this.j;
                        if (map3 != null) {
                            Iterator<Map.Entry<a, List<C0305b>>> it4 = map3.entrySet().iterator();
                            while (it4.hasNext()) {
                                List<C0305b> value3 = it4.next().getValue();
                                if (!k.a((Collection) value3)) {
                                    Iterator<C0305b> it5 = value3.iterator();
                                    while (it5.hasNext()) {
                                        it5.next().f16279d = true;
                                    }
                                }
                            }
                        }
                        Map<a, C0305b> map4 = this.f16274i;
                        if (map4 != null) {
                            Iterator<Map.Entry<a, C0305b>> it6 = map4.entrySet().iterator();
                            while (it6.hasNext()) {
                                C0305b value4 = it6.next().getValue();
                                if (value4 != null) {
                                    value4.f16279d = true;
                                }
                            }
                        }
                        this.f16269a = this.f16270b;
                        this.f16270b = null;
                        this.f16271c = 0;
                        c0305bA = a(aVar, true);
                        z2 = true;
                    }
                    if (a(c0305bA)) {
                        c0305bA.f16279d = false;
                        this.f16269a = this.f16270b;
                        this.f16270b = new C0305b(c0305bA.a(), c0305bA.b(), c0305bA.d());
                        this.f16271c = 0;
                    }
                    if (this.f16270b == null) {
                        this.f16270b = new C0305b(this.f16272d, "", 0);
                    }
                    eVar = new sg.bigo.ads.controller.a.e(this.f16270b, z2, true);
                } else {
                    eVar = new sg.bigo.ads.controller.a.e(c0305b, false, false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    @Override // sg.bigo.ads.common.f
    @CallSuper
    public void a(@NonNull Parcel parcel) {
        synchronized (this) {
            n.a(parcel, this.f16273f);
            n.b(parcel, this.g);
            parcel.writeInt(this.h);
            n.a(parcel, this.f16274i);
            n.b(parcel, this.j);
            n.a(parcel, this.f16269a);
            n.a(parcel, this.f16270b);
            parcel.writeInt(this.f16271c);
        }
    }

    private void a(Map<a, C0305b> map, Map<a, List<C0305b>> map2, String str, int i2) {
        C0305b value;
        C0305b c0305b;
        synchronized (this) {
            try {
                if (!k.a(this.f16273f) && !k.a(map)) {
                    for (Map.Entry<a, C0305b> entry : this.f16273f.entrySet()) {
                        a key = entry.getKey();
                        if (key != null && (value = entry.getValue()) != null && (c0305b = map.get(key)) != null && value.equals(c0305b)) {
                            value.a(c0305b.b());
                        }
                    }
                }
                if (!k.a(this.g) && !k.a(map2)) {
                    for (Map.Entry<a, List<C0305b>> entry2 : this.g.entrySet()) {
                        a key2 = entry2.getKey();
                        if (key2 != null) {
                            List<C0305b> value2 = entry2.getValue();
                            if (!k.a((Collection) value2)) {
                                List<C0305b> list = map2.get(key2);
                                if (!k.a((Collection) list)) {
                                    for (C0305b c0305b2 : value2) {
                                        if (c0305b2 != null) {
                                            Iterator<C0305b> it = list.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    C0305b next = it.next();
                                                    if (c0305b2.equals(next)) {
                                                        c0305b2.a(next.b());
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                C0305b c0305b3 = this.f16270b;
                if (c0305b3 != null) {
                    if (c0305b3.d() == 1) {
                        C0305b c0305b4 = this.f16273f.get(new a(str, i2));
                        if (this.f16270b.equals(c0305b4)) {
                            this.f16270b.a(c0305b4.b());
                        }
                    } else if (this.f16270b.d() == 2) {
                        List<C0305b> list2 = this.g.get(new a(str, i2));
                        if (!k.a((Collection) list2)) {
                            Iterator<C0305b> it2 = list2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                C0305b next2 = it2.next();
                                if (this.f16270b.equals(next2)) {
                                    this.f16270b.a(next2.b());
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(@NonNull JSONObject jSONObject, boolean z2, String str, int i2) {
        synchronized (this) {
            try {
                HashMap map = new HashMap();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("country_hosts");
                if (jSONArrayOptJSONArray != null) {
                    for (int i8 = 0; i8 < jSONArrayOptJSONArray.length(); i8++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i8);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString = jSONObjectOptJSONObject.optString("host", "");
                            if (sg.bigo.ads.controller.a.d.a(strOptString)) {
                                map.put(new a(jSONObjectOptJSONObject.optString("country", "all"), jSONObjectOptJSONObject.optInt("app_flag", 0)), new C0305b(strOptString, jSONObjectOptJSONObject.optString("domain_front", ""), 1));
                            }
                        }
                    }
                }
                HashMap map2 = new HashMap();
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("backup_hosts");
                if (jSONArrayOptJSONArray2 != null) {
                    for (int i9 = 0; i9 < jSONArrayOptJSONArray2.length(); i9++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i9);
                        if (jSONObjectOptJSONObject2 != null) {
                            a aVar = new a(jSONObjectOptJSONObject2.optString("country", "all"), jSONObjectOptJSONObject2.optInt("app_flag", 0));
                            List arrayList = (List) map2.get(aVar);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                map2.put(aVar, arrayList);
                            }
                            String strOptString2 = jSONObjectOptJSONObject2.optString("domain_front", "");
                            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject2.optJSONArray("hosts");
                            if (jSONArrayOptJSONArray3 != null) {
                                for (int i10 = 0; i10 < jSONArrayOptJSONArray3.length(); i10++) {
                                    String strOptString3 = jSONArrayOptJSONArray3.optString(i10, "");
                                    if (sg.bigo.ads.controller.a.d.a(strOptString3)) {
                                        C0305b c0305b = new C0305b(strOptString3, strOptString2, 2);
                                        if (!arrayList.contains(c0305b)) {
                                            arrayList.add(c0305b);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (z2) {
                    a(map, map2, str, i2);
                } else {
                    int iOptInt = jSONObject.optInt("threshold", 3);
                    this.f16273f = map;
                    this.g = map2;
                    this.h = iOptInt;
                    this.j = new HashMap();
                    this.f16274i = a();
                    this.f16269a = this.f16270b;
                    this.f16270b = null;
                    this.f16271c = 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean a(String str, String str2) {
        synchronized (this) {
            try {
                if (sg.bigo.ads.controller.a.d.a(str2)) {
                    a aVar = new a(str, 0);
                    if (this.j == null) {
                        this.j = new HashMap();
                    }
                    List<C0305b> arrayList = this.j.get(aVar);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                        this.j.put(aVar, arrayList);
                    }
                    C0305b c0305b = new C0305b(str2, "", 3);
                    if (!arrayList.contains(c0305b)) {
                        arrayList.add(c0305b);
                        return true;
                    }
                }
                return false;
            } finally {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0184, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        r2 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.lang.String r6, java.lang.String r7, int r8, sg.bigo.ads.api.a.h r9, boolean r10) {
        /*
            Method dump skipped, instruction units count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.a.a.b.a(java.lang.String, java.lang.String, int, sg.bigo.ads.api.a.h, boolean):boolean");
    }

    private static boolean a(C0305b c0305b) {
        return c0305b != null && c0305b.f16279d;
    }
}
