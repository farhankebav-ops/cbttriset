package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.datasource.LifecycleDataSource;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidSendDiagnosticEvent implements SendDiagnosticEvent {
    private final DiagnosticEventRepository diagnosticEventRepository;
    private final GetDiagnosticEventRequest getDiagnosticEventRequest;
    private final LifecycleDataSource lifecycleDataSource;

    public AndroidSendDiagnosticEvent(DiagnosticEventRepository diagnosticEventRepository, GetDiagnosticEventRequest getDiagnosticEventRequest, LifecycleDataSource lifecycleDataSource) {
        k.e(diagnosticEventRepository, "diagnosticEventRepository");
        k.e(getDiagnosticEventRequest, "getDiagnosticEventRequest");
        k.e(lifecycleDataSource, "lifecycleDataSource");
        this.diagnosticEventRepository = diagnosticEventRepository;
        this.getDiagnosticEventRequest = getDiagnosticEventRequest;
        this.lifecycleDataSource = lifecycleDataSource;
    }

    @Override // com.unity3d.ads.core.domain.SendDiagnosticEvent
    public void invoke(String event, Double d8, Map<String, String> map, Map<String, Integer> map2, AdObject adObject, Integer num) {
        k.e(event, "event");
        Boolean boolValueOf = adObject != null ? Boolean.valueOf(adObject.isHeaderBidding()) : null;
        ByteString opportunityId = adObject != null ? adObject.getOpportunityId() : null;
        String placementId = adObject != null ? adObject.getPlacementId() : null;
        DiagnosticEventRequestOuterClass.DiagnosticAdType adType = adObject != null ? adObject.getAdType() : null;
        LinkedHashMap linkedHashMapO0 = map != null ? x.o0(map) : new LinkedHashMap();
        if (adObject != null && adObject.isScarAd()) {
            linkedHashMapO0.put("scar", com.ironsource.mediationsdk.metadata.a.g);
        }
        if (adObject != null && adObject.isOfferwallAd()) {
            linkedHashMapO0.put("offerwall", com.ironsource.mediationsdk.metadata.a.g);
        }
        linkedHashMapO0.put("app_active", String.valueOf(this.lifecycleDataSource.appIsForeground()));
        this.diagnosticEventRepository.addDiagnosticEvent(this.getDiagnosticEventRequest.invoke(event, linkedHashMapO0, map2, d8, boolValueOf, opportunityId, placementId, adType, num));
    }
}
