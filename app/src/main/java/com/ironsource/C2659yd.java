package com.ironsource;

import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.unity3d.mediation.LevelPlay;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: renamed from: com.ironsource.yd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2659yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final V0 f10573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<C2675zc> f10574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AbstractC2595v0 f10575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final IronSource.a f10576d;

    /* JADX INFO: renamed from: com.ironsource.yd$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10577a;

        static {
            int[] iArr = new int[LevelPlay.AdFormat.values().length];
            try {
                iArr[LevelPlay.AdFormat.REWARDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LevelPlay.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LevelPlay.AdFormat.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LevelPlay.AdFormat.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f10577a = iArr;
        }
    }

    /* JADX INFO: renamed from: com.ironsource.yd$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b extends AbstractRunnableC2382ie {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ NetworkSettings f10579c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AdapterBaseInterface f10580d;
        final /* synthetic */ AdData e;

        public b(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface, AdData adData) {
            this.f10579c = networkSettings;
            this.f10580d = adapterBaseInterface;
            this.e = adData;
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a() {
            C2659yd c2659yd = C2659yd.this;
            NetworkSettings networkSettings = this.f10579c;
            AdapterBaseInterface networkAdapter = this.f10580d;
            kotlin.jvm.internal.k.d(networkAdapter, "networkAdapter");
            c2659yd.a(networkSettings, networkAdapter, this.e);
        }

        @Override // com.ironsource.AbstractRunnableC2382ie
        public void a(Throwable t3) {
            kotlin.jvm.internal.k.e(t3, "t");
            C2659yd.this.f10573a.e().h().g("initProvider - exception while calling networkAdapter.init with " + this.f10579c.getProviderName() + " - " + t3);
        }
    }

    public C2659yd(V0 adUnitTools, LevelPlay.AdFormat adFormat, List<C2675zc> providers, AbstractC2595v0 adUnitData) {
        kotlin.jvm.internal.k.e(adUnitTools, "adUnitTools");
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        kotlin.jvm.internal.k.e(providers, "providers");
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        this.f10573a = adUnitTools;
        this.f10574b = providers;
        this.f10575c = adUnitData;
        this.f10576d = a(adFormat);
    }

    public final void a() {
        IronLog.INTERNAL.verbose(C2459n0.a(this.f10573a, (String) null, (String) null, 3, (Object) null));
        UUID uuidRandomUUID = UUID.randomUUID();
        Iterator<C2675zc> it = this.f10574b.iterator();
        while (it.hasNext()) {
            NetworkSettings networkSettingsF = it.next().f();
            AdapterBaseInterface adapterBaseInterfaceB = com.ironsource.mediationsdk.c.b().b(networkSettingsF, this.f10576d, uuidRandomUUID);
            if (a(networkSettingsF, adapterBaseInterfaceB)) {
                C2644xf.a(C2644xf.f10528a, new b(networkSettingsF, adapterBaseInterfaceB, this.f10575c.a(networkSettingsF)), 0L, 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface, AdData adData) {
        a("Start initializing provider %s on thread %s", networkSettings);
        adapterBaseInterface.init(adData, ContextProvider.getInstance().getApplicationContext(), null);
        a("Done initializing provider %s on thread %s", networkSettings);
    }

    private final void a(String str, NetworkSettings networkSettings) {
        IronLog.INTERNAL.verbose(C2459n0.a(this.f10573a, String.format(str, Arrays.copyOf(new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()}, 2)), (String) null, 2, (Object) null));
    }

    private final boolean a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        if (adapterBaseInterface == null) {
            return false;
        }
        V0 v02 = this.f10573a;
        IronSource.a aVar = this.f10576d;
        String providerInstanceName = networkSettings.getProviderInstanceName();
        kotlin.jvm.internal.k.d(providerInstanceName, "providerSettings.providerInstanceName");
        return !v02.a(adapterBaseInterface, aVar, providerInstanceName) && (networkSettings.shouldEarlyInit() || networkSettings.isIronSource() || networkSettings.isBidder(this.f10576d));
    }

    private final IronSource.a a(LevelPlay.AdFormat adFormat) {
        int i2 = a.f10577a[adFormat.ordinal()];
        if (i2 == 1) {
            return IronSource.a.REWARDED_VIDEO;
        }
        if (i2 == 2) {
            return IronSource.a.INTERSTITIAL;
        }
        if (i2 == 3) {
            return IronSource.a.BANNER;
        }
        if (i2 == 4) {
            return IronSource.a.NATIVE_AD;
        }
        throw new e2.s(3);
    }
}
