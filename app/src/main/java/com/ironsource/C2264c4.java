package com.ironsource;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterConsentInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.c4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2264c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Boolean f8105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B7 f8106b = Mb.f7131s.d().i();

    public final Boolean a() {
        return this.f8105a;
    }

    public final B7 b() {
        return this.f8106b;
    }

    public final void a(boolean z2) {
        this.f8105a = Boolean.valueOf(z2);
    }

    public final void a(ConcurrentHashMap<String, AbstractAdapter> adapters, ConcurrentHashMap<String, AdapterBaseWrapper> networkAdapters) {
        q5.x xVar;
        kotlin.jvm.internal.k.e(adapters, "adapters");
        kotlin.jvm.internal.k.e(networkAdapters, "networkAdapters");
        for (AbstractAdapter adapter : adapters.values()) {
            kotlin.jvm.internal.k.d(adapter, "adapter");
            a(adapter, (NetworkSettings) null);
        }
        for (AdapterBaseWrapper adapterBaseWrapper : networkAdapters.values()) {
            AdapterBaseInterface adapterBaseInterface = adapterBaseWrapper.getAdapterBaseInterface();
            if (adapterBaseInterface != null) {
                a(adapterBaseInterface, adapterBaseWrapper.getSettings());
                xVar = q5.x.f13520a;
            } else {
                xVar = null;
            }
            if (xVar == null) {
                IronLog.INTERNAL.error("adapter is null");
            }
        }
    }

    public final void a(AdapterBaseInterface adapter, NetworkSettings networkSettings) {
        kotlin.jvm.internal.k.e(adapter, "adapter");
        try {
            Boolean boolA = a(networkSettings);
            if (boolA == null || !(adapter instanceof AdapterConsentInterface)) {
                return;
            }
            ((AdapterConsentInterface) adapter).setConsent(boolA.booleanValue());
        } catch (Throwable th) {
            C2531r4.d().a(th);
            String strN = a1.a.n("error while setting consent of ", networkSettings != null ? networkSettings.getProviderName() : null, ": ", th.getLocalizedMessage());
            a(strN);
            IronLog.INTERNAL.error(strN);
        }
    }

    public final void a(AbstractAdapter adapter, NetworkSettings networkSettings) {
        kotlin.jvm.internal.k.e(adapter, "adapter");
        try {
            Boolean boolA = a(networkSettings);
            if (boolA != null) {
                adapter.setNewConsent(boolA.booleanValue());
            }
        } catch (Throwable th) {
            C2531r4.d().a(th);
            String strN = a1.a.n("error while setting consent of ", adapter.getProviderName(), ": ", th.getLocalizedMessage());
            a(strN);
            IronLog.INTERNAL.error(strN);
        }
    }

    private final Boolean a(NetworkSettings networkSettings) {
        if (networkSettings != null && !networkSettings.isCustomNetwork()) {
            if (networkSettings.getApplicationSettings().has(C2282d4.f8185a)) {
                return Boolean.valueOf(networkSettings.getApplicationSettings().optBoolean(C2282d4.f8185a));
            }
            return this.f8105a;
        }
        return this.f8105a;
    }

    private final void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("reason", str);
            }
            H9.i().a(new C5(D5.TROUBLESHOOTING_CONSENT_INTERNAL_ERROR, jSONObject));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public final void a(int i2) {
        JSONObject jSONObjectB = IronSourceUtils.b(false);
        try {
            jSONObjectB.put(IronSourceConstants.EVENTS_EXT1, i2 + ";" + this.f8106b.F(ContextProvider.getInstance().getApplicationContext()));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog ironLog = IronLog.INTERNAL;
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            printWriter.flush();
            String string = stringWriter.toString();
            kotlin.jvm.internal.k.d(string, "toString(...)");
            ironLog.error(string);
        }
        Mb.f7131s.d().q().a(new C5(D5.CONSENT_TCF_CODE, jSONObjectB));
    }

    public final void a(int i2, ConcurrentHashMap<String, NetworkSettings> providerSettings) {
        JSONObject applicationSettings;
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        String strF = this.f8106b.F(ContextProvider.getInstance().getApplicationContext());
        IronLog ironLog = IronLog.API;
        ironLog.general("TCF Additional Consent: " + strF);
        ironLog.general("CMP ID: " + i2);
        ironLog.general("Network Consent Reporting:");
        ironLog.general("----------------------------");
        Collection<NetworkSettings> collectionValues = providerSettings.values();
        kotlin.jvm.internal.k.d(collectionValues, "providerSettings.values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            NetworkSettings networkSettings = (NetworkSettings) obj;
            if (networkSettings.getProviderDefaultInstance() != null && !kotlin.jvm.internal.k.a(networkSettings.getProviderDefaultInstance(), IronSourceConstants.SUPERSONIC_CONFIG_NAME) && (applicationSettings = networkSettings.getApplicationSettings()) != null && applicationSettings.has(C2282d4.f8185a)) {
                arrayList.add(obj);
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i8 = 0;
        int i9 = 0;
        while (i9 < size) {
            Object obj2 = arrayList.get(i9);
            i9++;
            if (hashSet.add(((NetworkSettings) obj2).getProviderDefaultInstance())) {
                arrayList2.add(obj2);
            }
        }
        int size2 = arrayList2.size();
        while (i8 < size2) {
            Object obj3 = arrayList2.get(i8);
            i8++;
            NetworkSettings networkSettings2 = (NetworkSettings) obj3;
            IronLog ironLog2 = IronLog.API;
            String providerDefaultInstance = networkSettings2.getProviderDefaultInstance();
            JSONObject applicationSettings2 = networkSettings2.getApplicationSettings();
            ironLog2.general(providerDefaultInstance + ": " + (applicationSettings2 != null ? Boolean.valueOf(applicationSettings2.optBoolean(C2282d4.f8185a)) : null));
        }
    }
}
