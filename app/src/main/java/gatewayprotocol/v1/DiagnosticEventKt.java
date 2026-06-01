package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.DslMap;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.AdFormatOuterClass;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.TimestampsOuterClass;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DiagnosticEventKt {
    public static final DiagnosticEventKt INSTANCE = new DiagnosticEventKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class IntTagsProxy extends DslProxy {
            private IntTagsProxy() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class StringTagsProxy extends DslProxy {
            private StringTagsProxy() {
            }
        }

        public /* synthetic */ Dsl(DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ DiagnosticEventRequestOuterClass.DiagnosticEvent _build() {
            DiagnosticEventRequestOuterClass.DiagnosticEvent diagnosticEventBuild = this._builder.build();
            kotlin.jvm.internal.k.d(diagnosticEventBuild, "_builder.build()");
            return diagnosticEventBuild;
        }

        public final void clearAdFormat() {
            this._builder.clearAdFormat();
        }

        public final void clearAdType() {
            this._builder.clearAdType();
        }

        public final void clearCustomEventType() {
            this._builder.clearCustomEventType();
        }

        public final void clearEventId() {
            this._builder.clearEventId();
        }

        public final void clearEventType() {
            this._builder.clearEventType();
        }

        public final void clearHeaderBiddingTokenNumber() {
            this._builder.clearHeaderBiddingTokenNumber();
        }

        public final void clearImpressionOpportunityId() {
            this._builder.clearImpressionOpportunityId();
        }

        public final /* synthetic */ void clearIntTags(DslMap dslMap) {
            kotlin.jvm.internal.k.e(dslMap, "<this>");
            this._builder.clearIntTags();
        }

        public final void clearIsHeaderBidding() {
            this._builder.clearIsHeaderBidding();
        }

        public final void clearPlacementId() {
            this._builder.clearPlacementId();
        }

        public final void clearReason() {
            this._builder.clearReason();
        }

        public final void clearReasonDebug() {
            this._builder.clearReasonDebug();
        }

        public final /* synthetic */ void clearStringTags(DslMap dslMap) {
            kotlin.jvm.internal.k.e(dslMap, "<this>");
            this._builder.clearStringTags();
        }

        public final void clearTimeValue() {
            this._builder.clearTimeValue();
        }

        public final void clearTimestamps() {
            this._builder.clearTimestamps();
        }

        public final AdFormatOuterClass.AdFormat getAdFormat() {
            AdFormatOuterClass.AdFormat adFormat = this._builder.getAdFormat();
            kotlin.jvm.internal.k.d(adFormat, "_builder.getAdFormat()");
            return adFormat;
        }

        public final int getAdFormatValue() {
            return this._builder.getAdFormatValue();
        }

        public final DiagnosticEventRequestOuterClass.DiagnosticAdType getAdType() {
            DiagnosticEventRequestOuterClass.DiagnosticAdType adType = this._builder.getAdType();
            kotlin.jvm.internal.k.d(adType, "_builder.getAdType()");
            return adType;
        }

        public final int getAdTypeValue() {
            return this._builder.getAdTypeValue();
        }

        public final String getCustomEventType() {
            String customEventType = this._builder.getCustomEventType();
            kotlin.jvm.internal.k.d(customEventType, "_builder.getCustomEventType()");
            return customEventType;
        }

        public final int getEventId() {
            return this._builder.getEventId();
        }

        public final DiagnosticEventRequestOuterClass.DiagnosticEventType getEventType() {
            DiagnosticEventRequestOuterClass.DiagnosticEventType eventType = this._builder.getEventType();
            kotlin.jvm.internal.k.d(eventType, "_builder.getEventType()");
            return eventType;
        }

        public final int getEventTypeValue() {
            return this._builder.getEventTypeValue();
        }

        public final int getHeaderBiddingTokenNumber() {
            return this._builder.getHeaderBiddingTokenNumber();
        }

        public final ByteString getImpressionOpportunityId() {
            ByteString impressionOpportunityId = this._builder.getImpressionOpportunityId();
            kotlin.jvm.internal.k.d(impressionOpportunityId, "_builder.getImpressionOpportunityId()");
            return impressionOpportunityId;
        }

        public final /* synthetic */ DslMap getIntTagsMap() {
            Map<String, Integer> intTagsMap = this._builder.getIntTagsMap();
            kotlin.jvm.internal.k.d(intTagsMap, "_builder.getIntTagsMap()");
            return new DslMap(intTagsMap);
        }

        public final boolean getIsHeaderBidding() {
            return this._builder.getIsHeaderBidding();
        }

        public final String getPlacementId() {
            String placementId = this._builder.getPlacementId();
            kotlin.jvm.internal.k.d(placementId, "_builder.getPlacementId()");
            return placementId;
        }

        public final String getReason() {
            String reason = this._builder.getReason();
            kotlin.jvm.internal.k.d(reason, "_builder.getReason()");
            return reason;
        }

        public final String getReasonDebug() {
            String reasonDebug = this._builder.getReasonDebug();
            kotlin.jvm.internal.k.d(reasonDebug, "_builder.getReasonDebug()");
            return reasonDebug;
        }

        public final /* synthetic */ DslMap getStringTagsMap() {
            Map<String, String> stringTagsMap = this._builder.getStringTagsMap();
            kotlin.jvm.internal.k.d(stringTagsMap, "_builder.getStringTagsMap()");
            return new DslMap(stringTagsMap);
        }

        public final double getTimeValue() {
            return this._builder.getTimeValue();
        }

        public final TimestampsOuterClass.Timestamps getTimestamps() {
            TimestampsOuterClass.Timestamps timestamps = this._builder.getTimestamps();
            kotlin.jvm.internal.k.d(timestamps, "_builder.getTimestamps()");
            return timestamps;
        }

        public final boolean hasAdFormat() {
            return this._builder.hasAdFormat();
        }

        public final boolean hasAdType() {
            return this._builder.hasAdType();
        }

        public final boolean hasCustomEventType() {
            return this._builder.hasCustomEventType();
        }

        public final boolean hasHeaderBiddingTokenNumber() {
            return this._builder.hasHeaderBiddingTokenNumber();
        }

        public final boolean hasImpressionOpportunityId() {
            return this._builder.hasImpressionOpportunityId();
        }

        public final boolean hasIsHeaderBidding() {
            return this._builder.hasIsHeaderBidding();
        }

        public final boolean hasPlacementId() {
            return this._builder.hasPlacementId();
        }

        public final boolean hasReason() {
            return this._builder.hasReason();
        }

        public final boolean hasReasonDebug() {
            return this._builder.hasReasonDebug();
        }

        public final boolean hasTimeValue() {
            return this._builder.hasTimeValue();
        }

        public final boolean hasTimestamps() {
            return this._builder.hasTimestamps();
        }

        public final /* synthetic */ void putAllIntTags(DslMap dslMap, Map map) {
            kotlin.jvm.internal.k.e(dslMap, "<this>");
            kotlin.jvm.internal.k.e(map, "map");
            this._builder.putAllIntTags(map);
        }

        public final /* synthetic */ void putAllStringTags(DslMap dslMap, Map map) {
            kotlin.jvm.internal.k.e(dslMap, "<this>");
            kotlin.jvm.internal.k.e(map, "map");
            this._builder.putAllStringTags(map);
        }

        public final void putIntTags(DslMap<String, Integer, IntTagsProxy> dslMap, String key, int i2) {
            kotlin.jvm.internal.k.e(dslMap, "<this>");
            kotlin.jvm.internal.k.e(key, "key");
            this._builder.putIntTags(key, i2);
        }

        public final void putStringTags(DslMap<String, String, StringTagsProxy> dslMap, String key, String value) {
            kotlin.jvm.internal.k.e(dslMap, "<this>");
            kotlin.jvm.internal.k.e(key, "key");
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.putStringTags(key, value);
        }

        public final /* synthetic */ void removeIntTags(DslMap dslMap, String key) {
            kotlin.jvm.internal.k.e(dslMap, "<this>");
            kotlin.jvm.internal.k.e(key, "key");
            this._builder.removeIntTags(key);
        }

        public final /* synthetic */ void removeStringTags(DslMap dslMap, String key) {
            kotlin.jvm.internal.k.e(dslMap, "<this>");
            kotlin.jvm.internal.k.e(key, "key");
            this._builder.removeStringTags(key);
        }

        public final void setAdFormat(AdFormatOuterClass.AdFormat value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setAdFormat(value);
        }

        public final void setAdFormatValue(int i2) {
            this._builder.setAdFormatValue(i2);
        }

        public final void setAdType(DiagnosticEventRequestOuterClass.DiagnosticAdType value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setAdType(value);
        }

        public final void setAdTypeValue(int i2) {
            this._builder.setAdTypeValue(i2);
        }

        public final void setCustomEventType(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setCustomEventType(value);
        }

        public final void setEventId(int i2) {
            this._builder.setEventId(i2);
        }

        public final void setEventType(DiagnosticEventRequestOuterClass.DiagnosticEventType value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setEventType(value);
        }

        public final void setEventTypeValue(int i2) {
            this._builder.setEventTypeValue(i2);
        }

        public final void setHeaderBiddingTokenNumber(int i2) {
            this._builder.setHeaderBiddingTokenNumber(i2);
        }

        public final void setImpressionOpportunityId(ByteString value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setImpressionOpportunityId(value);
        }

        public final /* synthetic */ void setIntTags(DslMap<String, Integer, IntTagsProxy> dslMap, String key, int i2) {
            kotlin.jvm.internal.k.e(dslMap, "<this>");
            kotlin.jvm.internal.k.e(key, "key");
            putIntTags(dslMap, key, i2);
        }

        public final void setIsHeaderBidding(boolean z2) {
            this._builder.setIsHeaderBidding(z2);
        }

        public final void setPlacementId(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setPlacementId(value);
        }

        public final void setReason(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setReason(value);
        }

        public final void setReasonDebug(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setReasonDebug(value);
        }

        public final /* synthetic */ void setStringTags(DslMap<String, String, StringTagsProxy> dslMap, String key, String value) {
            kotlin.jvm.internal.k.e(dslMap, "<this>");
            kotlin.jvm.internal.k.e(key, "key");
            kotlin.jvm.internal.k.e(value, "value");
            putStringTags(dslMap, key, value);
        }

        public final void setTimeValue(double d8) {
            this._builder.setTimeValue(d8);
        }

        public final void setTimestamps(TimestampsOuterClass.Timestamps value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setTimestamps(value);
        }

        private Dsl(DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder builder) {
            this._builder = builder;
        }
    }

    private DiagnosticEventKt() {
    }
}
