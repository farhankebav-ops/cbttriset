package com.ironsource;

import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.lc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2433lc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, JSONObject> f8919a;

    public C2433lc() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final ConcurrentHashMap<String, JSONObject> a() {
        return this.f8919a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2433lc) && kotlin.jvm.internal.k.a(this.f8919a, ((C2433lc) obj).f8919a);
    }

    public int hashCode() {
        return this.f8919a.hashCode();
    }

    public String toString() {
        return "NetworkDataStore(networkDataMap=" + this.f8919a + ")";
    }

    public C2433lc(ConcurrentHashMap<String, JSONObject> networkDataMap) {
        kotlin.jvm.internal.k.e(networkDataMap, "networkDataMap");
        this.f8919a = networkDataMap;
    }

    public final C2433lc a(ConcurrentHashMap<String, JSONObject> networkDataMap) {
        kotlin.jvm.internal.k.e(networkDataMap, "networkDataMap");
        return new C2433lc(networkDataMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C2433lc a(C2433lc c2433lc, ConcurrentHashMap concurrentHashMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            concurrentHashMap = c2433lc.f8919a;
        }
        return c2433lc.a((ConcurrentHashMap<String, JSONObject>) concurrentHashMap);
    }

    public /* synthetic */ C2433lc(ConcurrentHashMap concurrentHashMap, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? new ConcurrentHashMap() : concurrentHashMap);
    }

    public final void a(com.ironsource.mediationsdk.x networkData) {
        kotlin.jvm.internal.k.e(networkData, "networkData");
        if (!this.f8919a.containsKey(networkData.a())) {
            this.f8919a.put(networkData.a(), networkData.allData());
            return;
        }
        try {
            ConcurrentHashMap<String, JSONObject> concurrentHashMap = this.f8919a;
            String strA = networkData.a();
            JSONObject jSONObject = this.f8919a.get(networkData.a());
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObjectA = IronSourceUtils.a(jSONObject, networkData.allData());
            kotlin.jvm.internal.k.d(jSONObjectA, "deepMergeJSONObjects(\n  …), networkData.allData())");
            concurrentHashMap.put(strA, jSONObjectA);
        } catch (Exception e) {
            IronLog.INTERNAL.error("error while merging network data: " + e.getMessage());
        }
    }

    public final void a(AbstractAdapter adapter) {
        kotlin.jvm.internal.k.e(adapter, "adapter");
        Set<Map.Entry<String, JSONObject>> setEntrySet = this.f8919a.entrySet();
        kotlin.jvm.internal.k.d(setEntrySet, "networkDataMap.entries");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            if (com.ironsource.mediationsdk.c.a((String) ((Map.Entry) obj).getKey(), adapter)) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            Map.Entry entry = (Map.Entry) obj2;
            Object key = entry.getKey();
            kotlin.jvm.internal.k.d(key, "it.key");
            Object value = entry.getValue();
            kotlin.jvm.internal.k.d(value, "it.value");
            adapter.setNetworkData(new com.ironsource.mediationsdk.x((String) key, (JSONObject) value));
        }
    }

    public final void a(AdapterBaseWrapper adapterBaseWrapper) {
        Set<Map.Entry<String, JSONObject>> setEntrySet = this.f8919a.entrySet();
        kotlin.jvm.internal.k.d(setEntrySet, "networkDataMap.entries");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            if (com.ironsource.mediationsdk.c.a((String) ((Map.Entry) obj).getKey(), adapterBaseWrapper)) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2 = arrayList.get(i2);
            i2++;
            Map.Entry entry = (Map.Entry) obj2;
            AdapterBaseInterface adapterBaseInterface = adapterBaseWrapper != null ? adapterBaseWrapper.getAdapterBaseInterface() : null;
            kotlin.jvm.internal.k.c(adapterBaseInterface, "null cannot be cast to non-null type com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface");
            Object key = entry.getKey();
            kotlin.jvm.internal.k.d(key, "it.key");
            Object value = entry.getValue();
            kotlin.jvm.internal.k.d(value, "it.value");
            ((AdapterNetworkDataInterface) adapterBaseInterface).setNetworkData(new com.ironsource.mediationsdk.x((String) key, (JSONObject) value));
        }
    }
}
