package com.unity3d.services.ads.gmascar;

import a.a;
import android.app.Activity;
import android.content.Context;
import android.support.v4.media.g;
import com.unity3d.scar.adapter.common.b;
import com.unity3d.scar.adapter.common.c;
import com.unity3d.scar.adapter.common.f;
import com.unity3d.scar.adapter.common.i;
import com.unity3d.scar.adapter.common.j;
import com.unity3d.services.ads.gmascar.adapters.ScarAdapterFactory;
import com.unity3d.services.ads.gmascar.bridges.AdapterStatusBridge;
import com.unity3d.services.ads.gmascar.bridges.InitializationStatusBridge;
import com.unity3d.services.ads.gmascar.bridges.InitializeListenerBridge;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.ads.gmascar.finder.GMAInitializer;
import com.unity3d.services.ads.gmascar.finder.PresenceDetector;
import com.unity3d.services.ads.gmascar.finder.ScarVersionFinder;
import com.unity3d.services.ads.gmascar.handlers.BiddingSignalsHandler;
import com.unity3d.services.ads.gmascar.handlers.ScarBannerAdHandler;
import com.unity3d.services.ads.gmascar.handlers.ScarInterstitialAdHandler;
import com.unity3d.services.ads.gmascar.handlers.ScarRewardedAdHandler;
import com.unity3d.services.ads.gmascar.handlers.SignalsHandler;
import com.unity3d.services.ads.gmascar.handlers.WebViewErrorHandler;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.banners.bridge.BannerBridge;
import com.unity3d.services.core.misc.EventSubject;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.timer.DefaultIntervalTimerFactory;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import u3.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class GMAScarAdapterBridge {
    private final AdapterStatusBridge _adapterStatusBridge;
    private final GMAEventSender _gmaEventSender;
    private final GMAInitializer _gmaInitializer;
    private final InitializeListenerBridge _initializationListenerBridge;
    private final InitializationStatusBridge _initializationStatusBridge;
    private final MobileAdsBridgeBase _mobileAdsBridge;
    private final PresenceDetector _presenceDetector;
    private f _scarAdapter;
    private final ScarAdapterFactory _scarAdapterFactory;
    private final ScarVersionFinder _scarVersionFinder;
    private final WebViewErrorHandler _webViewErrorHandler;

    public GMAScarAdapterBridge(MobileAdsBridgeBase mobileAdsBridgeBase, InitializeListenerBridge initializeListenerBridge, InitializationStatusBridge initializationStatusBridge, AdapterStatusBridge adapterStatusBridge, WebViewErrorHandler webViewErrorHandler, ScarAdapterFactory scarAdapterFactory, GMAEventSender gMAEventSender) {
        this._initializationStatusBridge = initializationStatusBridge;
        this._initializationListenerBridge = initializeListenerBridge;
        this._adapterStatusBridge = adapterStatusBridge;
        this._webViewErrorHandler = webViewErrorHandler;
        this._scarAdapterFactory = scarAdapterFactory;
        this._mobileAdsBridge = mobileAdsBridgeBase;
        this._gmaEventSender = gMAEventSender;
        PresenceDetector presenceDetector = new PresenceDetector(mobileAdsBridgeBase, initializeListenerBridge, initializationStatusBridge, adapterStatusBridge);
        this._presenceDetector = presenceDetector;
        GMAInitializer gMAInitializer = new GMAInitializer(mobileAdsBridgeBase, initializeListenerBridge, initializationStatusBridge, adapterStatusBridge, gMAEventSender);
        this._gmaInitializer = gMAInitializer;
        this._scarVersionFinder = new ScarVersionFinder(mobileAdsBridgeBase, presenceDetector, gMAInitializer, gMAEventSender);
    }

    private f getScarAdapterObject() {
        MobileAdsBridgeBase mobileAdsBridgeBase;
        if (this._scarAdapter == null && (mobileAdsBridgeBase = this._mobileAdsBridge) != null) {
            this._scarAdapter = this._scarAdapterFactory.createScarAdapter(mobileAdsBridgeBase.getAdapterVersion(this._scarVersionFinder.getVersionCode()), this._webViewErrorHandler);
        }
        return this._scarAdapter;
    }

    private EventSubject getScarEventSubject(Integer num) {
        return new EventSubject(new ArrayDeque(Arrays.asList(c.f10973v, c.f10974w, c.f10975x, c.y)), num, new DefaultIntervalTimerFactory());
    }

    private void loadInterstitialAd(u3.c cVar) {
        this._scarAdapter.b(ClientProperties.getApplicationContext(), cVar, new ScarInterstitialAdHandler(cVar, getScarEventSubject(cVar.e), this._gmaEventSender));
    }

    private void loadRewardedAd(u3.c cVar) {
        this._scarAdapter.c(ClientProperties.getApplicationContext(), cVar, new ScarRewardedAdHandler(cVar, getScarEventSubject(cVar.e), this._gmaEventSender));
    }

    public void getSCARBiddingSignals(List<d> list, BiddingSignalsHandler biddingSignalsHandler) {
        MobileAdsBridgeBase mobileAdsBridgeBase = this._mobileAdsBridge;
        if (mobileAdsBridgeBase == null || !mobileAdsBridgeBase.hasSCARBiddingSupport()) {
            biddingSignalsHandler.onSignalsCollectionFailed("SCAR bidding unsupported.");
            return;
        }
        f scarAdapterObject = getScarAdapterObject();
        this._scarAdapter = scarAdapterObject;
        if (scarAdapterObject == null) {
            biddingSignalsHandler.onSignalsCollectionFailed("Could not create SCAR adapter object.");
            return;
        }
        Context applicationContext = ClientProperties.getApplicationContext();
        a aVar = ((a4.d) scarAdapterObject).f3223a;
        aVar.getClass();
        com.unity3d.scar.adapter.common.a aVar2 = new com.unity3d.scar.adapter.common.a(0);
        g gVar = new g(27);
        for (d dVar : list) {
            aVar2.c();
            aVar.F(applicationContext, dVar, aVar2, gVar);
        }
        i iVar = new i(5, biddingSignalsHandler, gVar, false);
        aVar2.f10959c = iVar;
        if (aVar2.f10958b <= 0) {
            iVar.run();
        }
    }

    public void getSCARSignal(String str, d dVar) {
        this._scarAdapter = getScarAdapterObject();
        SignalsHandler signalsHandler = new SignalsHandler(this._gmaEventSender);
        f fVar = this._scarAdapter;
        boolean z2 = false;
        if (fVar == null) {
            this._webViewErrorHandler.handleError((j) new b(c.j, "Could not create SCAR adapter object", "Could not create SCAR adapter object"));
            return;
        }
        Context applicationContext = ClientProperties.getApplicationContext();
        a aVar = ((a4.d) fVar).f3223a;
        aVar.getClass();
        com.unity3d.scar.adapter.common.a aVar2 = new com.unity3d.scar.adapter.common.a(0);
        g gVar = new g(27);
        aVar2.c();
        aVar.E(applicationContext, str, dVar, aVar2, gVar);
        i iVar = new i(5, signalsHandler, gVar, z2);
        aVar2.f10959c = iVar;
        if (aVar2.f10958b <= 0) {
            iVar.run();
        }
    }

    public void getVersion() {
        this._scarVersionFinder.getVersion();
    }

    public boolean hasSCARBiddingSupport() {
        MobileAdsBridgeBase mobileAdsBridgeBase = this._mobileAdsBridge;
        if (mobileAdsBridgeBase != null && mobileAdsBridgeBase.hasSCARBiddingSupport()) {
            f scarAdapterObject = getScarAdapterObject();
            this._scarAdapter = scarAdapterObject;
            if (scarAdapterObject != null) {
                return true;
            }
        }
        return false;
    }

    public void initializeScar() {
        if (this._presenceDetector.areGMAClassesPresent()) {
            this._gmaEventSender.send(c.f10960a, new Object[0]);
            this._gmaInitializer.initializeGMA();
        } else {
            this._webViewErrorHandler.handleError((j) new b(c.f10961b, null, new Object[0]));
        }
    }

    public boolean isInitialized() {
        return this._gmaInitializer.isInitialized();
    }

    public void load(boolean z2, String str, String str2, String str3, String str4, int i2) {
        u3.c cVar = new u3.c(str, str2, str4, str3, Integer.valueOf(i2));
        f scarAdapterObject = getScarAdapterObject();
        this._scarAdapter = scarAdapterObject;
        if (scarAdapterObject == null) {
            this._webViewErrorHandler.handleError((j) new b(c.f10966n, "Scar Adapter object is null", str, str2, "Scar Adapter object is null"));
        } else if (z2) {
            loadInterstitialAd(cVar);
        } else {
            loadRewardedAd(cVar);
        }
    }

    public void loadBanner(Context context, BannerView bannerView, String str, u3.c cVar, UnityBannerSize unityBannerSize) {
        this._scarAdapter = getScarAdapterObject();
        ScarBannerAdHandler scarBannerAdHandler = new ScarBannerAdHandler(this._gmaEventSender, str);
        f fVar = this._scarAdapter;
        if (fVar != null) {
            fVar.a(context, bannerView, cVar, unityBannerSize.getWidth(), unityBannerSize.getHeight(), scarBannerAdHandler);
        } else {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerBridge.BannerEvent.SCAR_BANNER_LOAD_FAILED, str);
        }
    }

    public void show(String str, String str2) {
        f scarAdapterObject = getScarAdapterObject();
        this._scarAdapter = scarAdapterObject;
        int i2 = 0;
        if (scarAdapterObject == null) {
            this._webViewErrorHandler.handleError((j) new b(c.f10969r, "Scar Adapter object is null", str, str2, "Scar Adapter object is null"));
            return;
        }
        Activity activity = ClientProperties.getActivity();
        a4.d dVar = (a4.d) scarAdapterObject;
        u3.a aVar = (u3.a) dVar.f3224b.get(str);
        if (aVar != null) {
            dVar.f3225c = aVar;
            a.V(new i(i2, dVar, activity));
        } else {
            com.unity3d.scar.adapter.common.d dVar2 = dVar.f3226d;
            String strM = a1.a.m("Could not find ad for placement '", str, "'.");
            dVar2.handleError(new b(c.p, strM, str, str2, strM));
        }
    }

    public void getSCARBiddingSignals(boolean z2, BiddingSignalsHandler biddingSignalsHandler) {
        MobileAdsBridgeBase mobileAdsBridgeBase = this._mobileAdsBridge;
        if (mobileAdsBridgeBase != null && mobileAdsBridgeBase.hasSCARBiddingSupport()) {
            f scarAdapterObject = getScarAdapterObject();
            this._scarAdapter = scarAdapterObject;
            if (scarAdapterObject != null) {
                Context applicationContext = ClientProperties.getApplicationContext();
                a aVar = ((a4.d) scarAdapterObject).f3223a;
                aVar.getClass();
                com.unity3d.scar.adapter.common.a aVar2 = new com.unity3d.scar.adapter.common.a(0);
                g gVar = new g(27);
                aVar2.c();
                aVar.F(applicationContext, d.f17532b, aVar2, gVar);
                aVar2.c();
                aVar.F(applicationContext, d.f17533c, aVar2, gVar);
                if (z2) {
                    aVar2.c();
                    aVar.F(applicationContext, d.f17534d, aVar2, gVar);
                }
                i iVar = new i(5, biddingSignalsHandler, gVar, false);
                aVar2.f10959c = iVar;
                if (aVar2.f10958b <= 0) {
                    iVar.run();
                    return;
                }
                return;
            }
            biddingSignalsHandler.onSignalsCollectionFailed("Could not create SCAR adapter object.");
            return;
        }
        biddingSignalsHandler.onSignalsCollectionFailed("SCAR bidding unsupported.");
    }
}
