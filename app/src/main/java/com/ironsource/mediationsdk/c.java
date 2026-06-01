package com.ironsource.mediationsdk;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ironsource.C2264c4;
import com.ironsource.C2433lc;
import com.ironsource.C2531r4;
import com.ironsource.C2627wf;
import com.ironsource.C5;
import com.ironsource.D5;
import com.ironsource.H9;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.AdapterDebugInterface;
import com.ironsource.mediationsdk.adunit.adapter.BaseAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAPSDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterMetaDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.adapters.levelplay.LevelPlayBaseAdapter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class c {
    private static final String k = "IronSource";
    private static final String l = "com.ironsource.adapters";
    private static final String m = "aps";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final c f9026n = new c();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Object f9027o = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9031d;
    private Boolean e;
    private final AtomicBoolean h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private C2264c4 f9033i = new C2264c4();
    private final C2433lc j = new C2433lc();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, AbstractAdapter> f9028a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, AdapterBaseWrapper> f9029b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConcurrentHashMap<String, List<String>> f9032f = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<IronSource.a, JSONObject> g = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9034a;

        static {
            int[] iArr = new int[IronSource.a.values().length];
            f9034a = iArr;
            try {
                iArr[IronSource.a.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9034a[IronSource.a.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9034a[IronSource.a.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9034a[IronSource.a.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static c b() {
        return f9026n;
    }

    public AbstractAdapter a(NetworkSettings networkSettings) {
        return a(b(networkSettings), networkSettings.getProviderTypeForReflection());
    }

    public void b(String str, String str2) {
        this.f9030c = str;
        this.f9031d = str2;
    }

    public void c(String str, List<String> list) {
        synchronized (f9027o) {
            try {
                this.f9032f.put(str, list);
                if (!this.f9028a.isEmpty()) {
                    IronSourceUtils.i("setMetaData key = " + str + ", values = " + list);
                    b(str, list);
                }
                a(str, list);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ConcurrentHashMap<String, List<String>> d() {
        return this.f9032f;
    }

    public ConcurrentHashMap<String, AdapterBaseWrapper> e() {
        return this.f9029b;
    }

    public void f() {
        this.f9028a.clear();
        this.f9029b.clear();
    }

    public AbstractAdapter a(NetworkSettings networkSettings, JSONObject jSONObject, boolean z2) {
        String coreSDKVersion;
        String strB = b(networkSettings);
        String providerTypeForReflection = z2 ? "IronSource" : networkSettings.getProviderTypeForReflection();
        synchronized (f9027o) {
            try {
                if (this.f9028a.containsKey(strB)) {
                    return this.f9028a.get(strB);
                }
                AbstractAdapter abstractAdapterA = a(strB, providerTypeForReflection);
                if (abstractAdapterA == null) {
                    b(strB + " adapter was not loaded");
                    return null;
                }
                abstractAdapterA.setProviderNetworkKey(networkSettings.getProviderNetworkKey());
                try {
                    coreSDKVersion = abstractAdapterA.getCoreSDKVersion();
                } catch (Throwable th) {
                    C2531r4.d().a(th);
                    String str = "error while retrieving coreSDKVersion " + abstractAdapterA.getProviderName() + ": " + th.getLocalizedMessage();
                    a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                    IronLog.INTERNAL.error(str);
                    coreSDKVersion = "Unknown";
                }
                c(strB + " was allocated (adapter version: " + abstractAdapterA.getVersion() + ", sdk version: " + coreSDKVersion + ")");
                c(abstractAdapterA);
                this.j.a(abstractAdapterA);
                a(abstractAdapterA);
                this.f9033i.a(abstractAdapterA, networkSettings);
                b(abstractAdapterA);
                a(jSONObject, abstractAdapterA, providerTypeForReflection);
                this.f9028a.put(strB, abstractAdapterA);
                return abstractAdapterA;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b(boolean z2) {
        synchronized (f9027o) {
            this.f9033i.a(z2);
            this.f9033i.a(this.f9028a, this.f9029b);
        }
    }

    private void b(AdapterBaseInterface adapterBaseInterface) {
        Boolean bool = this.e;
        if (bool == null || !(adapterBaseInterface instanceof AdapterDebugInterface)) {
            return;
        }
        try {
            ((AdapterDebugInterface) adapterBaseInterface).setAdapterDebug(bool.booleanValue());
        } catch (Exception e) {
            C2531r4.d().a(e);
            String str = "error while setting adapterDebug of " + adapterBaseInterface.getClass().getSimpleName() + ": " + e.getLocalizedMessage();
            a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
            c(str);
        }
    }

    private void c(AdapterBaseInterface adapterBaseInterface) {
        if (adapterBaseInterface == null) {
            return;
        }
        for (String str : this.f9032f.keySet()) {
            List<String> list = this.f9032f.get(str);
            if (list != null && (adapterBaseInterface instanceof AdapterMetaDataInterface)) {
                a(new b0(adapterBaseInterface, str, list, 1), adapterBaseInterface.getClass().getSimpleName());
            }
        }
    }

    private void c(AbstractAdapter abstractAdapter) {
        if (abstractAdapter == null) {
            return;
        }
        for (String str : this.f9032f.keySet()) {
            List<String> list = this.f9032f.get(str);
            if (list != null) {
                a(new a0(abstractAdapter, str, list, 1), abstractAdapter.getProviderName());
            }
        }
    }

    private void b(AbstractAdapter abstractAdapter) {
        Boolean bool = this.e;
        if (bool != null) {
            try {
                abstractAdapter.setAdapterDebug(bool);
            } catch (Throwable th) {
                C2531r4.d().a(th);
                String str = "error while setting adapterDebug of " + abstractAdapter.getProviderName() + ": " + th.getLocalizedMessage();
                a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
                c(str);
            }
        }
    }

    private String c(NetworkSettings networkSettings, IronSource.a aVar, UUID uuid) {
        StringBuilder sbX = a1.a.x(uuid != null ? uuid.toString() : "", "-");
        sbX.append(aVar.toString());
        sbX.append("-");
        sbX.append(networkSettings.getProviderName());
        return sbX.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AdapterBaseInterface adapterBaseInterface, String str, List list) {
        ((AdapterMetaDataInterface) adapterBaseInterface).setMetaData(str, list);
        IronSourceUtils.i(adapterBaseInterface.getClass().getSimpleName() + "Adapter setMetaData key = " + str + ", values = " + list);
    }

    private void c(NetworkSettings networkSettings) {
        IronLog.INTERNAL.error(a1.a.l("Missing package definition for ", networkSettings.getProviderTypeForReflection()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AbstractAdapter abstractAdapter, String str, List list) {
        abstractAdapter.setMetaData(str, list);
        IronSourceUtils.i(abstractAdapter.getProviderName() + "Adapter setMetaData key = " + str + ", values = " + list);
    }

    private void a(JSONObject jSONObject, AbstractAdapter abstractAdapter, String str) {
        if (str.equalsIgnoreCase("IronSource") && this.h.compareAndSet(false, true)) {
            c(a1.a.m("SDK5 earlyInit  <", str, ">"));
            try {
                abstractAdapter.earlyInit(this.f9030c, this.f9031d, jSONObject);
            } catch (Exception e) {
                C2531r4.d().a(e);
                String str2 = "error while calling early init for " + abstractAdapter.getProviderName() + ": " + e.getLocalizedMessage();
                a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
                IronLog.INTERNAL.error(str2);
            }
        }
    }

    private void b(String str, List<String> list) {
        for (AbstractAdapter abstractAdapter : this.f9028a.values()) {
            a(new a0(abstractAdapter, str, list, 0), abstractAdapter.getProviderName());
        }
    }

    private void c(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "AdapterRepository: " + str, 0);
    }

    private String b(NetworkSettings networkSettings) {
        if (networkSettings.isMultipleInstances()) {
            return networkSettings.getProviderDefaultInstance();
        }
        return networkSettings.getProviderName();
    }

    public ConcurrentHashMap<String, LevelPlayBaseAdapter> c() {
        ConcurrentHashMap<String, LevelPlayBaseAdapter> concurrentHashMap = new ConcurrentHashMap<>();
        for (String str : this.f9029b.keySet()) {
            AdapterBaseWrapper adapterBaseWrapper = this.f9029b.get(str);
            if (adapterBaseWrapper != null && (adapterBaseWrapper.getAdapterBaseInterface() instanceof LevelPlayBaseAdapter)) {
                concurrentHashMap.put(str, (LevelPlayBaseAdapter) adapterBaseWrapper.getAdapterBaseInterface());
            }
        }
        return concurrentHashMap;
    }

    public AdapterBaseInterface b(NetworkSettings networkSettings, IronSource.a aVar, UUID uuid) {
        String strC;
        String providerTypeForReflection;
        if (networkSettings.isCustomNetwork()) {
            strC = b(networkSettings);
        } else {
            strC = c(networkSettings, aVar, uuid);
        }
        if (this.f9029b.containsKey(strC)) {
            return this.f9029b.get(strC).getAdapterBaseInterface();
        }
        if (networkSettings.isCustomNetwork()) {
            providerTypeForReflection = networkSettings.getCustomNetworkAdapterName(null);
        } else {
            providerTypeForReflection = networkSettings.getProviderTypeForReflection();
        }
        AdapterBaseInterface adapterBaseInterfaceA = a(strC, providerTypeForReflection, networkSettings);
        return (adapterBaseInterfaceA != null || networkSettings.isCustomNetwork()) ? adapterBaseInterfaceA : a(networkSettings, aVar, strC);
    }

    private AbstractAdapter a(String str, String str2) {
        try {
            Class<?> cls = Class.forName(a(str2));
            return (AbstractAdapter) cls.getMethod(IronSourceConstants.START_ADAPTER, String.class).invoke(cls, str);
        } catch (Exception e) {
            String str3 = "Error while loading adapter - exception = " + e.getLocalizedMessage();
            a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str3);
            b(str3);
            return null;
        }
    }

    private JSONObject b(NetworkSettings networkSettings, IronSource.a aVar) {
        int i2 = a.f9034a[aVar.ordinal()];
        if (i2 == 1) {
            return networkSettings.getRewardedVideoSettings();
        }
        if (i2 == 2) {
            return networkSettings.getInterstitialSettings();
        }
        if (i2 == 3) {
            return networkSettings.getBannerSettings();
        }
        if (i2 != 4) {
            return null;
        }
        return networkSettings.getNativeAdSettings();
    }

    private static String a(String str) {
        return "com.ironsource.adapters." + StringUtils.toLowerCase(str) + "." + str + "Adapter";
    }

    public void b(x xVar) {
        if (a(xVar)) {
            this.j.a(xVar);
            xVar.a(this.f9028a.values(), this.f9029b.values());
            xVar.b();
            if (StringUtils.toLowerCase(xVar.a()).equals(m)) {
                a(xVar.allData());
            }
        }
    }

    private String a(String str, IronSource.a aVar) {
        StringBuilder sb = new StringBuilder("com.ironsource.adapters.");
        sb.append(StringUtils.toLowerCase(str));
        sb.append(".");
        sb.append(StringUtils.toLowerCase(a(aVar)));
        sb.append(".");
        sb.append(str);
        return a1.a.r(sb, a(aVar), "Adapter");
    }

    private void b(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "AdapterRepository: " + str, 3);
    }

    private String a(IronSource.a aVar) {
        if (aVar == null) {
            return null;
        }
        int i2 = a.f9034a[aVar.ordinal()];
        if (i2 == 1) {
            return "Rewarded";
        }
        if (i2 == 2) {
            return "Interstitial";
        }
        if (i2 == 3) {
            return "Banner";
        }
        if (i2 != 4) {
            return null;
        }
        return "NativeAd";
    }

    public void a(boolean z2) {
        synchronized (f9027o) {
            try {
                this.e = Boolean.valueOf(z2);
                Iterator<AbstractAdapter> it = this.f9028a.values().iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
                Iterator<AdapterBaseWrapper> it2 = this.f9029b.values().iterator();
                while (it2.hasNext()) {
                    b(it2.next().getAdapterBaseInterface());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AbstractAdapter abstractAdapter, String str, List list) {
        abstractAdapter.setMetaData(str, list);
        IronSourceUtils.i(abstractAdapter.getProviderName() + "Adapter setMetaData key = " + str + ", values = " + list);
    }

    private void a(String str, List<String> list) {
        for (AdapterBaseWrapper adapterBaseWrapper : this.f9029b.values()) {
            AdapterBaseInterface adapterBaseInterface = adapterBaseWrapper.getAdapterBaseInterface();
            if (!adapterBaseWrapper.getSettings().isCustomNetwork() && (adapterBaseInterface instanceof AdapterMetaDataInterface)) {
                a(new b0(adapterBaseInterface, str, list, 0), adapterBaseInterface.getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AdapterBaseInterface adapterBaseInterface, String str, List list) {
        ((AdapterMetaDataInterface) adapterBaseInterface).setMetaData(str, list);
        IronSourceUtils.i(adapterBaseInterface.getClass().getSimpleName() + "Adapter setMetaData key = " + str + ", values = " + list);
    }

    private void a(Runnable runnable, String str) {
        try {
            runnable.run();
        } catch (Throwable th) {
            C2531r4.d().a(th);
            String str2 = "Error while setting meta-data for adapter " + str + ": " + th.getLocalizedMessage();
            a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
            c(str2);
        }
    }

    private void a(AdapterBaseInterface adapterBaseInterface) {
        if (!(adapterBaseInterface instanceof SetAPSInterface) || this.g.size() == 0) {
            return;
        }
        for (IronSource.a aVar : this.g.keySet()) {
            try {
                JSONObject jSONObject = this.g.get(aVar);
                if (jSONObject != null && jSONObject.length() > 0) {
                    ((SetAPSInterface) adapterBaseInterface).setAPSData(C2627wf.a(aVar), jSONObject);
                }
            } catch (Exception e) {
                C2531r4.d().a(e);
                String str = "error while setting aps data: " + e.getLocalizedMessage();
                a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, str);
                c(str);
            }
        }
        this.g.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(AbstractAdapter abstractAdapter) {
        if (!StringUtils.toLowerCase(abstractAdapter.getProviderName()).equals(m) || this.g.size() == 0) {
            return;
        }
        for (IronSource.a aVar : this.g.keySet()) {
            try {
                JSONObject jSONObject = this.g.get(aVar);
                if (jSONObject != null && jSONObject.length() > 0 && (abstractAdapter instanceof SetAPSInterface)) {
                    ((SetAPSInterface) abstractAdapter).setAPSData(C2627wf.a(aVar), jSONObject);
                }
            } catch (Exception e) {
                C2531r4.d().a(e);
                String str = "error while setting aps data: " + e.getLocalizedMessage();
                a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, str);
                c(str);
            }
        }
        this.g.clear();
    }

    @Nullable
    private w a(NetworkSettings networkSettings, IronSource.a aVar, String str) {
        AbstractAdapter abstractAdapterA = a(networkSettings, b(networkSettings, aVar), false);
        if (abstractAdapterA != null) {
            w wVar = new w(abstractAdapterA);
            this.f9029b.put(str, new AdapterBaseWrapper(wVar, networkSettings));
            return wVar;
        }
        String str2 = "error creating network adapter " + networkSettings.getProviderName();
        a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str2);
        IronLog.INTERNAL.error(str2);
        return null;
    }

    private void a(String str, AdapterBaseInterface adapterBaseInterface, NetworkSettings networkSettings) {
        if (!networkSettings.isCustomNetwork()) {
            c(adapterBaseInterface);
            a(adapterBaseInterface);
        }
        this.f9033i.a(adapterBaseInterface, networkSettings);
        b(adapterBaseInterface);
        this.j.a(new AdapterBaseWrapper(adapterBaseInterface, networkSettings));
        this.f9029b.put(str, new AdapterBaseWrapper(adapterBaseInterface, networkSettings));
    }

    private AdapterBaseInterface a(String str, String str2, NetworkSettings networkSettings) {
        String strA;
        if (networkSettings.isCustomNetwork() && TextUtils.isEmpty(networkSettings.getCustomNetworkPackage())) {
            IronLog.INTERNAL.error("missing package definition for " + str);
            return null;
        }
        if (networkSettings.isCustomNetwork()) {
            strA = networkSettings.getCustomNetworkPackage() + "." + str2;
        } else {
            strA = a(str2);
        }
        try {
            BaseAdapter baseAdapter = (BaseAdapter) Class.forName(strA).newInstance();
            IronLog.INTERNAL.info(strA + " was allocated (adapter version: " + baseAdapter.getAdapterVersion() + ", sdk version: " + baseAdapter.getNetworkSDKVersion() + ")");
            a(str, baseAdapter, networkSettings);
            return baseAdapter;
        } catch (Exception unused) {
            if (networkSettings.isCustomNetwork()) {
                String strL = a1.a.l("failed to load ", strA);
                IronLog.INTERNAL.error(strL);
                a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, strL);
            }
            return null;
        }
    }

    public BaseAdAdapter<?, ?> a(NetworkSettings networkSettings, IronSource.a aVar, UUID uuid) {
        BaseAdAdapter<?, ?> baseAdAdapterA = a(networkSettings, aVar);
        if (baseAdAdapterA != null || networkSettings.isCustomNetwork()) {
            return baseAdAdapterA;
        }
        AbstractAdapter abstractAdapterA = a(networkSettings);
        if (abstractAdapterA != null) {
            return AbstractC2454a.a(abstractAdapterA, networkSettings, aVar, uuid);
        }
        String str = "error creating ad adapter " + networkSettings.getProviderName();
        a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, str);
        IronLog.INTERNAL.error(str);
        return null;
    }

    private BaseAdAdapter<?, ?> a(NetworkSettings networkSettings, IronSource.a aVar) {
        boolean zIsCustomNetwork = networkSettings.isCustomNetwork();
        if (zIsCustomNetwork && TextUtils.isEmpty(networkSettings.getCustomNetworkPackage())) {
            c(networkSettings);
            return null;
        }
        String strA = a(networkSettings, aVar, zIsCustomNetwork, a(networkSettings, aVar, zIsCustomNetwork));
        try {
            return a(strA, networkSettings);
        } catch (Exception e) {
            if (zIsCustomNetwork) {
                a(e, strA);
            }
            return null;
        }
    }

    private String a(NetworkSettings networkSettings, IronSource.a aVar, boolean z2) {
        if (z2) {
            return networkSettings.getCustomNetworkAdapterName(aVar);
        }
        return networkSettings.getProviderTypeForReflection();
    }

    private String a(NetworkSettings networkSettings, IronSource.a aVar, boolean z2, String str) {
        if (z2) {
            return networkSettings.getCustomNetworkPackage() + "." + str;
        }
        return a(str, aVar);
    }

    private BaseAdAdapter<?, ?> a(String str, NetworkSettings networkSettings) throws Exception {
        return (BaseAdAdapter) Class.forName(str).getConstructor(NetworkSettings.class).newInstance(networkSettings);
    }

    private void a(Exception exc, String str) {
        String strL = a1.a.l("Failed to load adapter class: ", str);
        IronLog.INTERNAL.error(strL);
        a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, a1.a.j(exc, a1.a.x(strL, " - ")));
    }

    private void a(D5 d52, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("reason", str);
            }
            H9.i().a(new C5(d52, jSONObject));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private boolean a(x xVar) {
        if (xVar.allData().length() == 0) {
            a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, "empty network data");
            b("empty network data");
            return false;
        }
        if (!TextUtils.isEmpty(xVar.a())) {
            return true;
        }
        a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, "empty network key");
        b("empty network key");
        return false;
    }

    private void a(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            if (next.equalsIgnoreCase(IronSource.a.BANNER.toString())) {
                a(LevelPlay.AdFormat.BANNER, jSONObjectOptJSONObject);
            } else if (next.equalsIgnoreCase(IronSource.a.INTERSTITIAL.toString())) {
                a(LevelPlay.AdFormat.INTERSTITIAL, jSONObjectOptJSONObject);
            } else if (next.equalsIgnoreCase(IronSource.a.REWARDED_VIDEO.toString())) {
                a(LevelPlay.AdFormat.REWARDED, jSONObjectOptJSONObject);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(LevelPlay.AdFormat adFormat, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                if (!this.f9028a.isEmpty()) {
                    for (AbstractAdapter abstractAdapter : this.f9028a.values()) {
                        if (StringUtils.toLowerCase(abstractAdapter.getProviderName()).equals(m) && (abstractAdapter instanceof SetAPSInterface)) {
                            ((SetAPSInterface) abstractAdapter).setAPSData(adFormat, jSONObject2);
                            return;
                        }
                    }
                }
                for (AdapterBaseWrapper adapterBaseWrapper : this.f9029b.values()) {
                    if (StringUtils.toLowerCase(adapterBaseWrapper.getSettings().getProviderTypeForReflection()).equals(m)) {
                        AdapterBaseInterface adapterBaseInterface = adapterBaseWrapper.getAdapterBaseInterface();
                        if (adapterBaseInterface != null) {
                            ((AdapterAPSDataInterface) adapterBaseInterface).setAPSData(adFormat, jSONObject2);
                            return;
                        }
                        return;
                    }
                }
                synchronized (f9027o) {
                    this.g.put(C2627wf.b(adFormat), jSONObject2);
                }
                return;
            } catch (Exception e) {
                C2531r4.d().a(e);
                String str = "error while setting APSData: " + e.getLocalizedMessage();
                a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, str);
                b(str);
                return;
            }
        }
        a(D5.TROUBLESHOOTING_ADAPTER_REPOSITORY_SET_NETWORK_DATA_INTERNAL_ERROR, "APSData is empty");
        b("APSData is empty");
    }

    public ConcurrentHashMap<String, AbstractAdapter> a() {
        return this.f9028a;
    }

    public static boolean a(String str, AdapterBaseWrapper adapterBaseWrapper) {
        return (adapterBaseWrapper == null || adapterBaseWrapper.getSettings().getProviderNetworkKey() == null || !adapterBaseWrapper.getSettings().getProviderNetworkKey().equalsIgnoreCase(str)) ? false : true;
    }

    public static boolean a(String str, AbstractAdapter abstractAdapter) {
        return (abstractAdapter == null || abstractAdapter.getProviderNetworkKey() == null || !abstractAdapter.getProviderNetworkKey().equalsIgnoreCase(str)) ? false : true;
    }
}
