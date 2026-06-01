package com.ironsource;

import com.ironsource.Q8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.sdk.controller.FeaturesManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class We implements Q8, Q8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, C2611w> f7780a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2506pc f7781b = new C2506pc();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReadWriteLock f7782c = new ReentrantReadWriteLock();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7783a;

        static {
            int[] iArr = new int[Ve.values().length];
            try {
                iArr[Ve.CurrentlyLoadedAdsAndFullHistory.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Ve.CurrentlyLoadedAds.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Ve.Off.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f7783a = iArr;
        }
    }

    private final void b() {
        Ue configuration = FeaturesManager.getInstance().getSessionHistoryConfig();
        C2506pc c2506pc = this.f7781b;
        kotlin.jvm.internal.k.d(configuration, "configuration");
        c2506pc.a(a(configuration));
        this.f7781b.a(a());
    }

    @Override // com.ironsource.Q8.a
    public void a(Xe historyRecord) {
        kotlin.jvm.internal.k.e(historyRecord, "historyRecord");
        this.f7782c.writeLock().lock();
        try {
            N nA = historyRecord.a();
            String strValueOf = String.valueOf(nA != null ? nA.b() : null);
            Map<String, C2611w> map = this.f7780a;
            C2611w c2611w = map.get(strValueOf);
            if (c2611w == null) {
                c2611w = new C2611w();
                map.put(strValueOf, c2611w);
            }
            c2611w.a(historyRecord.a(new C2293df()));
            this.f7782c.writeLock().unlock();
            b();
        } catch (Throwable th) {
            this.f7782c.writeLock().unlock();
            throw th;
        }
    }

    @Override // com.ironsource.Q8
    public JSONObject a(EnumC2347gf mode) {
        kotlin.jvm.internal.k.e(mode, "mode");
        this.f7782c.readLock().lock();
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, C2611w> entry : this.f7780a.entrySet()) {
                String key = entry.getKey();
                JSONObject jSONObjectA = entry.getValue().a(mode);
                if (jSONObjectA.length() > 0) {
                    jSONObject.put(key, jSONObjectA);
                }
            }
            return jSONObject;
        } finally {
            this.f7782c.readLock().unlock();
        }
    }

    @Override // com.ironsource.Q8
    public int a(IronSource.a adFormat) {
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        this.f7782c.readLock().lock();
        try {
            C2611w c2611w = this.f7780a.get(adFormat.toString());
            return c2611w != null ? c2611w.a() : 0;
        } finally {
            this.f7782c.readLock().unlock();
        }
    }

    @Override // com.ironsource.Q8
    public List<String> a() {
        this.f7782c.readLock().lock();
        try {
            Map<String, C2611w> map = this.f7780a;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, C2611w> entry : map.entrySet()) {
                if (entry.getValue().b()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            List<String> listN1 = r5.l.n1(linkedHashMap.keySet());
            this.f7782c.readLock().unlock();
            return listN1;
        } catch (Throwable th) {
            this.f7782c.readLock().unlock();
            throw th;
        }
    }

    @Override // com.ironsource.Q8
    public Map<String, JSONObject> a(Ue configuration) {
        Map<String, JSONObject> mapG0;
        kotlin.jvm.internal.k.e(configuration, "configuration");
        this.f7782c.readLock().lock();
        try {
            int i2 = a.f7783a[configuration.a().ordinal()];
            if (i2 == 1) {
                mapG0 = r5.x.g0(new q5.i(Q6.f7483y1, a(EnumC2347gf.FullHistory)), new q5.i(Q6.f7486z1, a(EnumC2347gf.CurrentlyLoadedAds)));
            } else if (i2 == 2) {
                mapG0 = r5.x.g0(new q5.i(Q6.f7486z1, a(EnumC2347gf.CurrentlyLoadedAds)));
            } else if (i2 == 3) {
                mapG0 = r5.s.f13639a;
            } else {
                throw new e2.s(3);
            }
            this.f7782c.readLock().unlock();
            return mapG0;
        } catch (Throwable th) {
            this.f7782c.readLock().unlock();
            throw th;
        }
    }
}
