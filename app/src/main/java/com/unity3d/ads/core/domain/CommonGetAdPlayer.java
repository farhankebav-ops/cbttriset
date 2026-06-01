package com.unity3d.ads.core.domain;

import android.content.Context;
import com.google.protobuf.ByteString;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer;
import com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer;
import com.unity3d.ads.adplayer.AndroidWebViewContainer;
import com.unity3d.ads.adplayer.WebViewAdPlayer;
import com.unity3d.ads.adplayer.WebViewBridge;
import com.unity3d.ads.core.data.datasource.LifecycleDataSource;
import com.unity3d.ads.core.data.manager.OfferwallManager;
import com.unity3d.ads.core.data.manager.ScarManager;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import com.unity3d.ads.core.data.repository.OrientationRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.services.banners.BannerViewCache;
import kotlin.jvm.internal.k;
import q6.a0;
import q6.w;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonGetAdPlayer implements GetAdPlayer {
    private final a0 adPlayerScope;
    private final AdRepository adRepository;
    private final Context context;
    private final w defaultDispatcher;
    private final DeviceInfoRepository deviceInfoRepository;
    private final LifecycleDataSource lifecycleDataSource;
    private final OfferwallManager offerwallManager;
    private final OpenMeasurementRepository openMeasurementRepository;
    private final OrientationRepository orientationRepository;
    private final ScarManager scarManager;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;

    public CommonGetAdPlayer(DeviceInfoRepository deviceInfoRepository, SessionRepository sessionRepository, SendDiagnosticEvent sendDiagnosticEvent, w defaultDispatcher, a0 adPlayerScope, OpenMeasurementRepository openMeasurementRepository, ScarManager scarManager, OfferwallManager offerwallManager, AdRepository adRepository, LifecycleDataSource lifecycleDataSource, OrientationRepository orientationRepository, Context context) {
        k.e(deviceInfoRepository, "deviceInfoRepository");
        k.e(sessionRepository, "sessionRepository");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        k.e(defaultDispatcher, "defaultDispatcher");
        k.e(adPlayerScope, "adPlayerScope");
        k.e(openMeasurementRepository, "openMeasurementRepository");
        k.e(scarManager, "scarManager");
        k.e(offerwallManager, "offerwallManager");
        k.e(adRepository, "adRepository");
        k.e(lifecycleDataSource, "lifecycleDataSource");
        k.e(orientationRepository, "orientationRepository");
        k.e(context, "context");
        this.deviceInfoRepository = deviceInfoRepository;
        this.sessionRepository = sessionRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.defaultDispatcher = defaultDispatcher;
        this.adPlayerScope = adPlayerScope;
        this.openMeasurementRepository = openMeasurementRepository;
        this.scarManager = scarManager;
        this.offerwallManager = offerwallManager;
        this.adRepository = adRepository;
        this.lifecycleDataSource = lifecycleDataSource;
        this.orientationRepository = orientationRepository;
        this.context = context;
    }

    @Override // com.unity3d.ads.core.domain.GetAdPlayer
    public AdPlayer invoke(WebViewBridge webviewBridge, AndroidWebViewContainer webviewContainer, ByteString opportunityId) {
        k.e(webviewBridge, "webviewBridge");
        k.e(webviewContainer, "webviewContainer");
        k.e(opportunityId, "opportunityId");
        WebViewAdPlayer webViewAdPlayer = new WebViewAdPlayer(webviewBridge, this.deviceInfoRepository, this.sessionRepository, this.defaultDispatcher, this.sendDiagnosticEvent, webviewContainer, this.adPlayerScope);
        if (BannerViewCache.getInstance().getBannerView(ProtobufExtensionsKt.toUUID(opportunityId).toString()) != null) {
            String string = ProtobufExtensionsKt.toUUID(opportunityId).toString();
            OpenMeasurementRepository openMeasurementRepository = this.openMeasurementRepository;
            ScarManager scarManager = this.scarManager;
            LifecycleDataSource lifecycleDataSource = this.lifecycleDataSource;
            Context context = this.context;
            k.d(string, "toString()");
            return new AndroidEmbeddableWebViewAdPlayer(webViewAdPlayer, string, webviewContainer, openMeasurementRepository, scarManager, lifecycleDataSource, context);
        }
        String string2 = ProtobufExtensionsKt.toUUID(opportunityId).toString();
        DeviceInfoRepository deviceInfoRepository = this.deviceInfoRepository;
        SessionRepository sessionRepository = this.sessionRepository;
        OpenMeasurementRepository openMeasurementRepository2 = this.openMeasurementRepository;
        ScarManager scarManager2 = this.scarManager;
        OfferwallManager offerwallManager = this.offerwallManager;
        SendDiagnosticEvent sendDiagnosticEvent = this.sendDiagnosticEvent;
        AdRepository adRepository = this.adRepository;
        OrientationRepository orientationRepository = this.orientationRepository;
        Context context2 = this.context;
        k.d(string2, "toString()");
        return new AndroidFullscreenWebViewAdPlayer(webViewAdPlayer, string2, webviewContainer, deviceInfoRepository, sessionRepository, openMeasurementRepository2, scarManager2, offerwallManager, sendDiagnosticEvent, adRepository, orientationRepository, context2);
    }
}
