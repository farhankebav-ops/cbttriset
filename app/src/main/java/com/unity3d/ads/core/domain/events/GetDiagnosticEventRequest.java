package com.unity3d.ads.core.domain.events;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.domain.GetSharedDataTimestamps;
import gatewayprotocol.v1.DiagnosticEventKt;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import java.util.Map;
import kotlin.jvm.internal.k;
import t6.d1;
import t6.q0;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class GetDiagnosticEventRequest {
    private final GetSharedDataTimestamps getSharedDataTimestamps;
    private final q0 uniqueId;

    public GetDiagnosticEventRequest(GetSharedDataTimestamps getSharedDataTimestamps) {
        k.e(getSharedDataTimestamps, "getSharedDataTimestamps");
        this.getSharedDataTimestamps = getSharedDataTimestamps;
        this.uniqueId = x0.c(-1);
    }

    public final DiagnosticEventRequestOuterClass.DiagnosticEvent invoke(String eventName, Map<String, String> map, Map<String, Integer> map2, Double d8, Boolean bool, ByteString byteString, String str, DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType, Integer num) {
        d1 d1Var;
        Object value;
        Integer numValueOf;
        k.e(eventName, "eventName");
        DiagnosticEventKt.Dsl.Companion companion = DiagnosticEventKt.Dsl.Companion;
        DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder builderNewBuilder = DiagnosticEventRequestOuterClass.DiagnosticEvent.newBuilder();
        k.d(builderNewBuilder, "newBuilder()");
        DiagnosticEventKt.Dsl dsl_create = companion._create(builderNewBuilder);
        q0 q0Var = this.uniqueId;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
            numValueOf = Integer.valueOf(((Number) value).intValue() + 1);
        } while (!d1Var.g(value, numValueOf));
        dsl_create.setEventId(numValueOf.intValue());
        dsl_create.setEventType(DiagnosticEventRequestOuterClass.DiagnosticEventType.DIAGNOSTIC_EVENT_TYPE_CUSTOM);
        dsl_create.setTimestamps(this.getSharedDataTimestamps.invoke());
        dsl_create.setCustomEventType(eventName);
        if (map != null) {
            dsl_create.putAllStringTags(dsl_create.getStringTagsMap(), map);
        }
        if (map2 != null) {
            dsl_create.putAllIntTags(dsl_create.getIntTagsMap(), map2);
        }
        if (d8 != null) {
            dsl_create.setTimeValue(d8.doubleValue());
        }
        if (bool != null) {
            dsl_create.setIsHeaderBidding(bool.booleanValue());
        }
        if (byteString != null) {
            dsl_create.setImpressionOpportunityId(byteString);
        }
        if (str != null) {
            dsl_create.setPlacementId(str);
        }
        if (diagnosticAdType != null) {
            dsl_create.setAdType(diagnosticAdType);
        }
        if (num != null) {
            dsl_create.setHeaderBiddingTokenNumber(num.intValue());
        }
        return dsl_create._build();
    }
}
