package com.ironsource.mediationsdk;

import com.ironsource.C5;
import com.ironsource.D5;
import com.ironsource.H9;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class x implements AdapterNetworkData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f9402b;

    public x(String networkName, JSONObject data) {
        kotlin.jvm.internal.k.e(networkName, "networkName");
        kotlin.jvm.internal.k.e(data, "data");
        this.f9401a = networkName;
        this.f9402b = new JSONObject(data.toString());
    }

    private final void b(Collection<? extends AdapterBaseWrapper> collection) {
        ArrayList arrayListW0 = r5.l.W0(collection);
        ArrayList arrayList = new ArrayList();
        int size = arrayListW0.size();
        int i2 = 0;
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayListW0.get(i8);
            i8++;
            if (c.a(this.f9401a, (AdapterBaseWrapper) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(r5.n.L0(arrayList, 10));
        int size2 = arrayList.size();
        int i9 = 0;
        while (i9 < size2) {
            Object obj2 = arrayList.get(i9);
            i9++;
            arrayList2.add(((AdapterBaseWrapper) obj2).getAdapterBaseInterface());
        }
        ArrayList arrayList3 = new ArrayList();
        int size3 = arrayList2.size();
        int i10 = 0;
        while (i10 < size3) {
            Object obj3 = arrayList2.get(i10);
            i10++;
            if (obj3 instanceof AdapterNetworkDataInterface) {
                arrayList3.add(obj3);
            }
        }
        int size4 = arrayList3.size();
        while (i2 < size4) {
            Object obj4 = arrayList3.get(i2);
            i2++;
            ((AdapterNetworkDataInterface) obj4).setNetworkData(this);
        }
    }

    public final String a() {
        return this.f9401a;
    }

    @Override // com.ironsource.mediationsdk.AdapterNetworkData
    public JSONObject allData() {
        return this.f9402b;
    }

    @Override // com.ironsource.mediationsdk.AdapterNetworkData
    public <T> T dataByKeyIgnoreCase(String desiredKey, Class<T> valueType) {
        Object next;
        kotlin.jvm.internal.k.e(desiredKey, "desiredKey");
        kotlin.jvm.internal.k.e(valueType, "valueType");
        Iterator<String> itKeys = allData().keys();
        kotlin.jvm.internal.k.d(itKeys, "allData()\n          .keys()");
        Iterator it = ((m6.a) m6.k.G0(itKeys)).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (n6.t.g0((String) next, desiredKey)) {
                break;
            }
        }
        String str = (String) next;
        if (str != null) {
            Object objOpt = allData().opt(str);
            if (!valueType.isInstance(objOpt)) {
                objOpt = null;
            }
            if (objOpt != null) {
                return valueType.cast(objOpt);
            }
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.AdapterNetworkData
    public JSONObject networkDataByAdUnit(IronSource.a adUnit) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        JSONObject jSONObjectOptJSONObject = this.f9402b.optJSONObject(adUnit.toString());
        return jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
    }

    public String toString() {
        return "NetworkData(networkName=" + this.f9401a + ", networkData=" + this.f9402b + ")";
    }

    public final void a(Collection<? extends AbstractAdapter> adapters, Collection<? extends AdapterBaseWrapper> networkAdapters) {
        kotlin.jvm.internal.k.e(adapters, "adapters");
        kotlin.jvm.internal.k.e(networkAdapters, "networkAdapters");
        try {
            a(adapters);
            b(networkAdapters);
        } catch (Exception e) {
            IronLog.INTERNAL.error("error while setting network data: " + e.getMessage());
        }
    }

    private final void a(Collection<? extends AbstractAdapter> collection) {
        ArrayList arrayListW0 = r5.l.W0(collection);
        ArrayList arrayList = new ArrayList();
        int size = arrayListW0.size();
        int i2 = 0;
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayListW0.get(i8);
            i8++;
            if (c.a(this.f9401a, (AbstractAdapter) obj)) {
                arrayList.add(obj);
            }
        }
        int size2 = arrayList.size();
        while (i2 < size2) {
            Object obj2 = arrayList.get(i2);
            i2++;
            ((AbstractAdapter) obj2).setNetworkData(this);
        }
    }

    public final void b() {
        Iterator<String> itKeys = this.f9402b.keys();
        kotlin.jvm.internal.k.d(itKeys, "networkData.keys()");
        String strC1 = r5.l.c1(m6.k.K0(m6.k.G0(itKeys)), ",", null, null, null, 62);
        H9.i().a(new C5(D5.SET_NETWORK_DATA, IronSourceUtils.b(false).put(IronSourceConstants.EVENTS_EXT1, this.f9401a + " - " + strC1)));
    }
}
