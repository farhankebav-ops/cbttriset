package com.vungle.ads.internal.model;

import a1.a;
import androidx.core.location.LocationRequestCompat;
import b7.c;
import b7.h;
import d7.g;
import e7.d;
import f7.l0;
import f7.m1;
import f7.q0;
import f7.q1;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class ConfigPayload {
    public static final Companion Companion = new Companion(null);
    private AutoRedirect autoRedirect;
    private final CleverCache cleverCache;
    private final String configExtension;
    private Long configLastValidatedTimestamp;
    private final ConfigSettings configSettings;
    private final Boolean disableAdId;
    private Boolean enableOT;
    private final Endpoints endpoints;
    private final Boolean fpdEnabled;
    private final Boolean isReportIncentivizedEnabled;
    private final LogMetricsSettings logMetricsSettings;
    private final List<Placement> placements;
    private Boolean retryPriorityTPATs;
    private final Boolean rtaDebugging;
    private final Integer sessionTimeout;
    private final Integer signalSessionTimeout;
    private final Boolean signalsDisabled;
    private final UserPrivacy userPrivacy;
    private final Boolean waitForConnectivityForTPAT;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class AutoRedirect {
        public static final Companion Companion = new Companion(null);
        private final Long afterClickDuration;
        private final Boolean allowAutoRedirect;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return ConfigPayload$AutoRedirect$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public AutoRedirect() {
            this((Boolean) null, (Long) (0 == true ? 1 : 0), 3, (f) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ AutoRedirect copy$default(AutoRedirect autoRedirect, Boolean bool, Long l, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                bool = autoRedirect.allowAutoRedirect;
            }
            if ((i2 & 2) != 0) {
                l = autoRedirect.afterClickDuration;
            }
            return autoRedirect.copy(bool, l);
        }

        public static final void write$Self(AutoRedirect self, d output, g serialDesc) {
            Long l;
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || !k.a(self.allowAutoRedirect, Boolean.FALSE)) {
                output.encodeNullableSerializableElement(serialDesc, 0, f7.g.f11455a, self.allowAutoRedirect);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || (l = self.afterClickDuration) == null || l.longValue() != LocationRequestCompat.PASSIVE_INTERVAL) {
                output.encodeNullableSerializableElement(serialDesc, 1, q0.f11499a, self.afterClickDuration);
            }
        }

        public final Boolean component1() {
            return this.allowAutoRedirect;
        }

        public final Long component2() {
            return this.afterClickDuration;
        }

        public final AutoRedirect copy(Boolean bool, Long l) {
            return new AutoRedirect(bool, l);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AutoRedirect)) {
                return false;
            }
            AutoRedirect autoRedirect = (AutoRedirect) obj;
            return k.a(this.allowAutoRedirect, autoRedirect.allowAutoRedirect) && k.a(this.afterClickDuration, autoRedirect.afterClickDuration);
        }

        public final Long getAfterClickDuration() {
            return this.afterClickDuration;
        }

        public final Boolean getAllowAutoRedirect() {
            return this.allowAutoRedirect;
        }

        public int hashCode() {
            Boolean bool = this.allowAutoRedirect;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Long l = this.afterClickDuration;
            return iHashCode + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "AutoRedirect(allowAutoRedirect=" + this.allowAutoRedirect + ", afterClickDuration=" + this.afterClickDuration + ')';
        }

        public /* synthetic */ AutoRedirect(int i2, Boolean bool, Long l, m1 m1Var) {
            this.allowAutoRedirect = (i2 & 1) == 0 ? Boolean.FALSE : bool;
            if ((i2 & 2) == 0) {
                this.afterClickDuration = Long.valueOf(LocationRequestCompat.PASSIVE_INTERVAL);
            } else {
                this.afterClickDuration = l;
            }
        }

        public AutoRedirect(Boolean bool, Long l) {
            this.allowAutoRedirect = bool;
            this.afterClickDuration = l;
        }

        public /* synthetic */ AutoRedirect(Boolean bool, Long l, int i2, f fVar) {
            this((i2 & 1) != 0 ? Boolean.FALSE : bool, (i2 & 2) != 0 ? Long.valueOf(LocationRequestCompat.PASSIVE_INTERVAL) : l);
        }

        public static /* synthetic */ void getAfterClickDuration$annotations() {
        }

        public static /* synthetic */ void getAllowAutoRedirect$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class CleverCache {
        public static final Companion Companion = new Companion(null);
        private final Integer diskPercentage;
        private final Long diskSize;
        private final Boolean enabled;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return ConfigPayload$CleverCache$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public CleverCache() {
            this((Boolean) null, (Long) null, (Integer) null, 7, (f) null);
        }

        public static /* synthetic */ CleverCache copy$default(CleverCache cleverCache, Boolean bool, Long l, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                bool = cleverCache.enabled;
            }
            if ((i2 & 2) != 0) {
                l = cleverCache.diskSize;
            }
            if ((i2 & 4) != 0) {
                num = cleverCache.diskPercentage;
            }
            return cleverCache.copy(bool, l, num);
        }

        public static final void write$Self(CleverCache self, d output, g serialDesc) {
            Integer num;
            Long l;
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || !k.a(self.enabled, Boolean.FALSE)) {
                output.encodeNullableSerializableElement(serialDesc, 0, f7.g.f11455a, self.enabled);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || (l = self.diskSize) == null || l.longValue() != 1000) {
                output.encodeNullableSerializableElement(serialDesc, 1, q0.f11499a, self.diskSize);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || (num = self.diskPercentage) == null || num.intValue() != 3) {
                output.encodeNullableSerializableElement(serialDesc, 2, l0.f11478a, self.diskPercentage);
            }
        }

        public final Boolean component1() {
            return this.enabled;
        }

        public final Long component2() {
            return this.diskSize;
        }

        public final Integer component3() {
            return this.diskPercentage;
        }

        public final CleverCache copy(Boolean bool, Long l, Integer num) {
            return new CleverCache(bool, l, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CleverCache)) {
                return false;
            }
            CleverCache cleverCache = (CleverCache) obj;
            return k.a(this.enabled, cleverCache.enabled) && k.a(this.diskSize, cleverCache.diskSize) && k.a(this.diskPercentage, cleverCache.diskPercentage);
        }

        public final Integer getDiskPercentage() {
            return this.diskPercentage;
        }

        public final Long getDiskSize() {
            return this.diskSize;
        }

        public final Boolean getEnabled() {
            return this.enabled;
        }

        public int hashCode() {
            Boolean bool = this.enabled;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Long l = this.diskSize;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            Integer num = this.diskPercentage;
            return iHashCode2 + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "CleverCache(enabled=" + this.enabled + ", diskSize=" + this.diskSize + ", diskPercentage=" + this.diskPercentage + ')';
        }

        public /* synthetic */ CleverCache(int i2, Boolean bool, Long l, Integer num, m1 m1Var) {
            this.enabled = (i2 & 1) == 0 ? Boolean.FALSE : bool;
            if ((i2 & 2) == 0) {
                this.diskSize = 1000L;
            } else {
                this.diskSize = l;
            }
            if ((i2 & 4) == 0) {
                this.diskPercentage = 3;
            } else {
                this.diskPercentage = num;
            }
        }

        public CleverCache(Boolean bool, Long l, Integer num) {
            this.enabled = bool;
            this.diskSize = l;
            this.diskPercentage = num;
        }

        public /* synthetic */ CleverCache(Boolean bool, Long l, Integer num, int i2, f fVar) {
            this((i2 & 1) != 0 ? Boolean.FALSE : bool, (i2 & 2) != 0 ? 1000L : l, (i2 & 4) != 0 ? 3 : num);
        }

        public static /* synthetic */ void getDiskPercentage$annotations() {
        }

        public static /* synthetic */ void getDiskSize$annotations() {
        }

        public static /* synthetic */ void getEnabled$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return ConfigPayload$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class ConfigSettings {
        public static final Companion Companion = new Companion(null);
        private final Long refreshTime;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return ConfigPayload$ConfigSettings$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public ConfigSettings() {
            this((Long) null, 1, (f) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ ConfigSettings copy$default(ConfigSettings configSettings, Long l, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                l = configSettings.refreshTime;
            }
            return configSettings.copy(l);
        }

        public static final void write$Self(ConfigSettings self, d output, g serialDesc) {
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.refreshTime == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 0, q0.f11499a, self.refreshTime);
        }

        public final Long component1() {
            return this.refreshTime;
        }

        public final ConfigSettings copy(Long l) {
            return new ConfigSettings(l);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConfigSettings) && k.a(this.refreshTime, ((ConfigSettings) obj).refreshTime);
        }

        public final Long getRefreshTime() {
            return this.refreshTime;
        }

        public int hashCode() {
            Long l = this.refreshTime;
            if (l == null) {
                return 0;
            }
            return l.hashCode();
        }

        public String toString() {
            return "ConfigSettings(refreshTime=" + this.refreshTime + ')';
        }

        public /* synthetic */ ConfigSettings(int i2, Long l, m1 m1Var) {
            if ((i2 & 1) == 0) {
                this.refreshTime = null;
            } else {
                this.refreshTime = l;
            }
        }

        public ConfigSettings(Long l) {
            this.refreshTime = l;
        }

        public /* synthetic */ ConfigSettings(Long l, int i2, f fVar) {
            this((i2 & 1) != 0 ? null : l);
        }

        public static /* synthetic */ void getRefreshTime$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class Endpoints {
        public static final Companion Companion = new Companion(null);
        private final String adsEndpoint;
        private final String errorLogsEndpoint;
        private final String metricsEndpoint;
        private final String riEndpoint;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return ConfigPayload$Endpoints$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public Endpoints() {
            this((String) null, (String) null, (String) null, (String) null, 15, (f) null);
        }

        public static /* synthetic */ Endpoints copy$default(Endpoints endpoints, String str, String str2, String str3, String str4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = endpoints.adsEndpoint;
            }
            if ((i2 & 2) != 0) {
                str2 = endpoints.riEndpoint;
            }
            if ((i2 & 4) != 0) {
                str3 = endpoints.errorLogsEndpoint;
            }
            if ((i2 & 8) != 0) {
                str4 = endpoints.metricsEndpoint;
            }
            return endpoints.copy(str, str2, str3, str4);
        }

        public static final void write$Self(Endpoints self, d output, g serialDesc) {
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.adsEndpoint != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, q1.f11501a, self.adsEndpoint);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.riEndpoint != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, q1.f11501a, self.riEndpoint);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.errorLogsEndpoint != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, q1.f11501a, self.errorLogsEndpoint);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.metricsEndpoint == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 3, q1.f11501a, self.metricsEndpoint);
        }

        public final String component1() {
            return this.adsEndpoint;
        }

        public final String component2() {
            return this.riEndpoint;
        }

        public final String component3() {
            return this.errorLogsEndpoint;
        }

        public final String component4() {
            return this.metricsEndpoint;
        }

        public final Endpoints copy(String str, String str2, String str3, String str4) {
            return new Endpoints(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Endpoints)) {
                return false;
            }
            Endpoints endpoints = (Endpoints) obj;
            return k.a(this.adsEndpoint, endpoints.adsEndpoint) && k.a(this.riEndpoint, endpoints.riEndpoint) && k.a(this.errorLogsEndpoint, endpoints.errorLogsEndpoint) && k.a(this.metricsEndpoint, endpoints.metricsEndpoint);
        }

        public final String getAdsEndpoint() {
            return this.adsEndpoint;
        }

        public final String getErrorLogsEndpoint() {
            return this.errorLogsEndpoint;
        }

        public final String getMetricsEndpoint() {
            return this.metricsEndpoint;
        }

        public final String getRiEndpoint() {
            return this.riEndpoint;
        }

        public int hashCode() {
            String str = this.adsEndpoint;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.riEndpoint;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.errorLogsEndpoint;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.metricsEndpoint;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Endpoints(adsEndpoint=");
            sb.append(this.adsEndpoint);
            sb.append(", riEndpoint=");
            sb.append(this.riEndpoint);
            sb.append(", errorLogsEndpoint=");
            sb.append(this.errorLogsEndpoint);
            sb.append(", metricsEndpoint=");
            return a.e(')', this.metricsEndpoint, sb);
        }

        public /* synthetic */ Endpoints(int i2, String str, String str2, String str3, String str4, m1 m1Var) {
            if ((i2 & 1) == 0) {
                this.adsEndpoint = null;
            } else {
                this.adsEndpoint = str;
            }
            if ((i2 & 2) == 0) {
                this.riEndpoint = null;
            } else {
                this.riEndpoint = str2;
            }
            if ((i2 & 4) == 0) {
                this.errorLogsEndpoint = null;
            } else {
                this.errorLogsEndpoint = str3;
            }
            if ((i2 & 8) == 0) {
                this.metricsEndpoint = null;
            } else {
                this.metricsEndpoint = str4;
            }
        }

        public Endpoints(String str, String str2, String str3, String str4) {
            this.adsEndpoint = str;
            this.riEndpoint = str2;
            this.errorLogsEndpoint = str3;
            this.metricsEndpoint = str4;
        }

        public /* synthetic */ Endpoints(String str, String str2, String str3, String str4, int i2, f fVar) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4);
        }

        public static /* synthetic */ void getAdsEndpoint$annotations() {
        }

        public static /* synthetic */ void getErrorLogsEndpoint$annotations() {
        }

        public static /* synthetic */ void getMetricsEndpoint$annotations() {
        }

        public static /* synthetic */ void getRiEndpoint$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class GDPRSettings {
        public static final Companion Companion = new Companion(null);
        private final String buttonAccept;
        private final String buttonDeny;
        private final String consentMessage;
        private final String consentMessageVersion;
        private final String consentTitle;
        private final Boolean isCountryDataProtected;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return ConfigPayload$GDPRSettings$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public GDPRSettings() {
            this((Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (f) null);
        }

        public static /* synthetic */ GDPRSettings copy$default(GDPRSettings gDPRSettings, Boolean bool, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                bool = gDPRSettings.isCountryDataProtected;
            }
            if ((i2 & 2) != 0) {
                str = gDPRSettings.consentTitle;
            }
            if ((i2 & 4) != 0) {
                str2 = gDPRSettings.consentMessage;
            }
            if ((i2 & 8) != 0) {
                str3 = gDPRSettings.consentMessageVersion;
            }
            if ((i2 & 16) != 0) {
                str4 = gDPRSettings.buttonAccept;
            }
            if ((i2 & 32) != 0) {
                str5 = gDPRSettings.buttonDeny;
            }
            String str6 = str4;
            String str7 = str5;
            return gDPRSettings.copy(bool, str, str2, str3, str6, str7);
        }

        public static final void write$Self(GDPRSettings self, d output, g serialDesc) {
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.isCountryDataProtected != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, f7.g.f11455a, self.isCountryDataProtected);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.consentTitle != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, q1.f11501a, self.consentTitle);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.consentMessage != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, q1.f11501a, self.consentMessage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.consentMessageVersion != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, q1.f11501a, self.consentMessageVersion);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.buttonAccept != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, q1.f11501a, self.buttonAccept);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.buttonDeny == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 5, q1.f11501a, self.buttonDeny);
        }

        public final Boolean component1() {
            return this.isCountryDataProtected;
        }

        public final String component2() {
            return this.consentTitle;
        }

        public final String component3() {
            return this.consentMessage;
        }

        public final String component4() {
            return this.consentMessageVersion;
        }

        public final String component5() {
            return this.buttonAccept;
        }

        public final String component6() {
            return this.buttonDeny;
        }

        public final GDPRSettings copy(Boolean bool, String str, String str2, String str3, String str4, String str5) {
            return new GDPRSettings(bool, str, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GDPRSettings)) {
                return false;
            }
            GDPRSettings gDPRSettings = (GDPRSettings) obj;
            return k.a(this.isCountryDataProtected, gDPRSettings.isCountryDataProtected) && k.a(this.consentTitle, gDPRSettings.consentTitle) && k.a(this.consentMessage, gDPRSettings.consentMessage) && k.a(this.consentMessageVersion, gDPRSettings.consentMessageVersion) && k.a(this.buttonAccept, gDPRSettings.buttonAccept) && k.a(this.buttonDeny, gDPRSettings.buttonDeny);
        }

        public final String getButtonAccept() {
            return this.buttonAccept;
        }

        public final String getButtonDeny() {
            return this.buttonDeny;
        }

        public final String getConsentMessage() {
            return this.consentMessage;
        }

        public final String getConsentMessageVersion() {
            return this.consentMessageVersion;
        }

        public final String getConsentTitle() {
            return this.consentTitle;
        }

        public int hashCode() {
            Boolean bool = this.isCountryDataProtected;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            String str = this.consentTitle;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.consentMessage;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.consentMessageVersion;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.buttonAccept;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.buttonDeny;
            return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
        }

        public final Boolean isCountryDataProtected() {
            return this.isCountryDataProtected;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("GDPRSettings(isCountryDataProtected=");
            sb.append(this.isCountryDataProtected);
            sb.append(", consentTitle=");
            sb.append(this.consentTitle);
            sb.append(", consentMessage=");
            sb.append(this.consentMessage);
            sb.append(", consentMessageVersion=");
            sb.append(this.consentMessageVersion);
            sb.append(", buttonAccept=");
            sb.append(this.buttonAccept);
            sb.append(", buttonDeny=");
            return a.e(')', this.buttonDeny, sb);
        }

        public /* synthetic */ GDPRSettings(int i2, Boolean bool, String str, String str2, String str3, String str4, String str5, m1 m1Var) {
            if ((i2 & 1) == 0) {
                this.isCountryDataProtected = null;
            } else {
                this.isCountryDataProtected = bool;
            }
            if ((i2 & 2) == 0) {
                this.consentTitle = null;
            } else {
                this.consentTitle = str;
            }
            if ((i2 & 4) == 0) {
                this.consentMessage = null;
            } else {
                this.consentMessage = str2;
            }
            if ((i2 & 8) == 0) {
                this.consentMessageVersion = null;
            } else {
                this.consentMessageVersion = str3;
            }
            if ((i2 & 16) == 0) {
                this.buttonAccept = null;
            } else {
                this.buttonAccept = str4;
            }
            if ((i2 & 32) == 0) {
                this.buttonDeny = null;
            } else {
                this.buttonDeny = str5;
            }
        }

        public GDPRSettings(Boolean bool, String str, String str2, String str3, String str4, String str5) {
            this.isCountryDataProtected = bool;
            this.consentTitle = str;
            this.consentMessage = str2;
            this.consentMessageVersion = str3;
            this.buttonAccept = str4;
            this.buttonDeny = str5;
        }

        public /* synthetic */ GDPRSettings(Boolean bool, String str, String str2, String str3, String str4, String str5, int i2, f fVar) {
            this((i2 & 1) != 0 ? null : bool, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5);
        }

        public static /* synthetic */ void getButtonAccept$annotations() {
        }

        public static /* synthetic */ void getButtonDeny$annotations() {
        }

        public static /* synthetic */ void getConsentMessage$annotations() {
        }

        public static /* synthetic */ void getConsentMessageVersion$annotations() {
        }

        public static /* synthetic */ void getConsentTitle$annotations() {
        }

        public static /* synthetic */ void isCountryDataProtected$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class IABSettings {
        public static final Companion Companion = new Companion(null);
        private final Integer tcfStatus;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return ConfigPayload$IABSettings$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public enum TcfStatus {
            ALLOW_ID(0),
            DISABLE_ID(1),
            LEGACY(2);

            public static final Companion Companion = new Companion(null);
            private static final Map<Integer, TcfStatus> rawValueMap;
            private final int rawValue;

            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            public static final class Companion {
                public /* synthetic */ Companion(f fVar) {
                    this();
                }

                public final TcfStatus fromRawValue(Integer num) {
                    return (TcfStatus) TcfStatus.rawValueMap.get(num);
                }

                private Companion() {
                }
            }

            static {
                TcfStatus[] tcfStatusArrValues = values();
                int iD0 = x.d0(tcfStatusArrValues.length);
                LinkedHashMap linkedHashMap = new LinkedHashMap(iD0 < 16 ? 16 : iD0);
                for (TcfStatus tcfStatus : tcfStatusArrValues) {
                    linkedHashMap.put(Integer.valueOf(tcfStatus.rawValue), tcfStatus);
                }
                rawValueMap = linkedHashMap;
            }

            TcfStatus(int i2) {
                this.rawValue = i2;
            }

            public final int getRawValue() {
                return this.rawValue;
            }
        }

        public IABSettings() {
            this((Integer) null, 1, (f) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ IABSettings copy$default(IABSettings iABSettings, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                num = iABSettings.tcfStatus;
            }
            return iABSettings.copy(num);
        }

        public static final void write$Self(IABSettings self, d output, g serialDesc) {
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.tcfStatus == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 0, l0.f11478a, self.tcfStatus);
        }

        public final Integer component1() {
            return this.tcfStatus;
        }

        public final IABSettings copy(Integer num) {
            return new IABSettings(num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IABSettings) && k.a(this.tcfStatus, ((IABSettings) obj).tcfStatus);
        }

        public final Integer getTcfStatus() {
            return this.tcfStatus;
        }

        public int hashCode() {
            Integer num = this.tcfStatus;
            if (num == null) {
                return 0;
            }
            return num.hashCode();
        }

        public String toString() {
            return "IABSettings(tcfStatus=" + this.tcfStatus + ')';
        }

        public /* synthetic */ IABSettings(int i2, Integer num, m1 m1Var) {
            if ((i2 & 1) == 0) {
                this.tcfStatus = null;
            } else {
                this.tcfStatus = num;
            }
        }

        public IABSettings(Integer num) {
            this.tcfStatus = num;
        }

        public /* synthetic */ IABSettings(Integer num, int i2, f fVar) {
            this((i2 & 1) != 0 ? null : num);
        }

        public static /* synthetic */ void getTcfStatus$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class LogMetricsSettings {
        public static final Companion Companion = new Companion(null);
        private final Integer errorLogLevel;
        private final Boolean metricsEnabled;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return ConfigPayload$LogMetricsSettings$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public LogMetricsSettings() {
            this((Integer) null, (Boolean) (0 == true ? 1 : 0), 3, (f) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ LogMetricsSettings copy$default(LogMetricsSettings logMetricsSettings, Integer num, Boolean bool, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                num = logMetricsSettings.errorLogLevel;
            }
            if ((i2 & 2) != 0) {
                bool = logMetricsSettings.metricsEnabled;
            }
            return logMetricsSettings.copy(num, bool);
        }

        public static final void write$Self(LogMetricsSettings self, d output, g serialDesc) {
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.errorLogLevel != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, l0.f11478a, self.errorLogLevel);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.metricsEnabled == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 1, f7.g.f11455a, self.metricsEnabled);
        }

        public final Integer component1() {
            return this.errorLogLevel;
        }

        public final Boolean component2() {
            return this.metricsEnabled;
        }

        public final LogMetricsSettings copy(Integer num, Boolean bool) {
            return new LogMetricsSettings(num, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LogMetricsSettings)) {
                return false;
            }
            LogMetricsSettings logMetricsSettings = (LogMetricsSettings) obj;
            return k.a(this.errorLogLevel, logMetricsSettings.errorLogLevel) && k.a(this.metricsEnabled, logMetricsSettings.metricsEnabled);
        }

        public final Integer getErrorLogLevel() {
            return this.errorLogLevel;
        }

        public final Boolean getMetricsEnabled() {
            return this.metricsEnabled;
        }

        public int hashCode() {
            Integer num = this.errorLogLevel;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Boolean bool = this.metricsEnabled;
            return iHashCode + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "LogMetricsSettings(errorLogLevel=" + this.errorLogLevel + ", metricsEnabled=" + this.metricsEnabled + ')';
        }

        public /* synthetic */ LogMetricsSettings(int i2, Integer num, Boolean bool, m1 m1Var) {
            if ((i2 & 1) == 0) {
                this.errorLogLevel = null;
            } else {
                this.errorLogLevel = num;
            }
            if ((i2 & 2) == 0) {
                this.metricsEnabled = null;
            } else {
                this.metricsEnabled = bool;
            }
        }

        public LogMetricsSettings(Integer num, Boolean bool) {
            this.errorLogLevel = num;
            this.metricsEnabled = bool;
        }

        public /* synthetic */ LogMetricsSettings(Integer num, Boolean bool, int i2, f fVar) {
            this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : bool);
        }

        public static /* synthetic */ void getErrorLogLevel$annotations() {
        }

        public static /* synthetic */ void getMetricsEnabled$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class UserPrivacy {
        public static final Companion Companion = new Companion(null);
        private final GDPRSettings gdpr;
        private final IABSettings iab;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return ConfigPayload$UserPrivacy$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public UserPrivacy() {
            this((GDPRSettings) null, (IABSettings) (0 == true ? 1 : 0), 3, (f) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ UserPrivacy copy$default(UserPrivacy userPrivacy, GDPRSettings gDPRSettings, IABSettings iABSettings, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                gDPRSettings = userPrivacy.gdpr;
            }
            if ((i2 & 2) != 0) {
                iABSettings = userPrivacy.iab;
            }
            return userPrivacy.copy(gDPRSettings, iABSettings);
        }

        public static final void write$Self(UserPrivacy self, d output, g serialDesc) {
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.gdpr != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, ConfigPayload$GDPRSettings$$serializer.INSTANCE, self.gdpr);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.iab == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 1, ConfigPayload$IABSettings$$serializer.INSTANCE, self.iab);
        }

        public final GDPRSettings component1() {
            return this.gdpr;
        }

        public final IABSettings component2() {
            return this.iab;
        }

        public final UserPrivacy copy(GDPRSettings gDPRSettings, IABSettings iABSettings) {
            return new UserPrivacy(gDPRSettings, iABSettings);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserPrivacy)) {
                return false;
            }
            UserPrivacy userPrivacy = (UserPrivacy) obj;
            return k.a(this.gdpr, userPrivacy.gdpr) && k.a(this.iab, userPrivacy.iab);
        }

        public final GDPRSettings getGdpr() {
            return this.gdpr;
        }

        public final IABSettings getIab() {
            return this.iab;
        }

        public int hashCode() {
            GDPRSettings gDPRSettings = this.gdpr;
            int iHashCode = (gDPRSettings == null ? 0 : gDPRSettings.hashCode()) * 31;
            IABSettings iABSettings = this.iab;
            return iHashCode + (iABSettings != null ? iABSettings.hashCode() : 0);
        }

        public String toString() {
            return "UserPrivacy(gdpr=" + this.gdpr + ", iab=" + this.iab + ')';
        }

        public /* synthetic */ UserPrivacy(int i2, GDPRSettings gDPRSettings, IABSettings iABSettings, m1 m1Var) {
            if ((i2 & 1) == 0) {
                this.gdpr = null;
            } else {
                this.gdpr = gDPRSettings;
            }
            if ((i2 & 2) == 0) {
                this.iab = null;
            } else {
                this.iab = iABSettings;
            }
        }

        public UserPrivacy(GDPRSettings gDPRSettings, IABSettings iABSettings) {
            this.gdpr = gDPRSettings;
            this.iab = iABSettings;
        }

        public /* synthetic */ UserPrivacy(GDPRSettings gDPRSettings, IABSettings iABSettings, int i2, f fVar) {
            this((i2 & 1) != 0 ? null : gDPRSettings, (i2 & 2) != 0 ? null : iABSettings);
        }

        public static /* synthetic */ void getGdpr$annotations() {
        }

        public static /* synthetic */ void getIab$annotations() {
        }
    }

    public ConfigPayload() {
        this((CleverCache) null, (ConfigSettings) null, (Endpoints) null, (LogMetricsSettings) null, (List) null, (UserPrivacy) null, (String) null, (Boolean) null, (Boolean) null, (Integer) null, (Boolean) null, (Integer) null, (Boolean) null, (Boolean) null, (Boolean) null, (Long) null, (AutoRedirect) null, (Boolean) null, (Boolean) null, 524287, (f) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConfigPayload copy$default(ConfigPayload configPayload, CleverCache cleverCache, ConfigSettings configSettings, Endpoints endpoints, LogMetricsSettings logMetricsSettings, List list, UserPrivacy userPrivacy, String str, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Boolean bool5, Boolean bool6, Long l, AutoRedirect autoRedirect, Boolean bool7, Boolean bool8, int i2, Object obj) {
        Boolean bool9;
        Boolean bool10;
        CleverCache cleverCache2 = (i2 & 1) != 0 ? configPayload.cleverCache : cleverCache;
        ConfigSettings configSettings2 = (i2 & 2) != 0 ? configPayload.configSettings : configSettings;
        Endpoints endpoints2 = (i2 & 4) != 0 ? configPayload.endpoints : endpoints;
        LogMetricsSettings logMetricsSettings2 = (i2 & 8) != 0 ? configPayload.logMetricsSettings : logMetricsSettings;
        List list2 = (i2 & 16) != 0 ? configPayload.placements : list;
        UserPrivacy userPrivacy2 = (i2 & 32) != 0 ? configPayload.userPrivacy : userPrivacy;
        String str2 = (i2 & 64) != 0 ? configPayload.configExtension : str;
        Boolean bool11 = (i2 & 128) != 0 ? configPayload.disableAdId : bool;
        Boolean bool12 = (i2 & 256) != 0 ? configPayload.isReportIncentivizedEnabled : bool2;
        Integer num3 = (i2 & 512) != 0 ? configPayload.sessionTimeout : num;
        Boolean bool13 = (i2 & 1024) != 0 ? configPayload.waitForConnectivityForTPAT : bool3;
        Integer num4 = (i2 & 2048) != 0 ? configPayload.signalSessionTimeout : num2;
        Boolean bool14 = (i2 & 4096) != 0 ? configPayload.signalsDisabled : bool4;
        Boolean bool15 = (i2 & 8192) != 0 ? configPayload.fpdEnabled : bool5;
        CleverCache cleverCache3 = cleverCache2;
        Boolean bool16 = (i2 & 16384) != 0 ? configPayload.rtaDebugging : bool6;
        Long l8 = (i2 & 32768) != 0 ? configPayload.configLastValidatedTimestamp : l;
        AutoRedirect autoRedirect2 = (i2 & 65536) != 0 ? configPayload.autoRedirect : autoRedirect;
        Boolean bool17 = (i2 & 131072) != 0 ? configPayload.retryPriorityTPATs : bool7;
        if ((i2 & 262144) != 0) {
            bool10 = bool17;
            bool9 = configPayload.enableOT;
        } else {
            bool9 = bool8;
            bool10 = bool17;
        }
        return configPayload.copy(cleverCache3, configSettings2, endpoints2, logMetricsSettings2, list2, userPrivacy2, str2, bool11, bool12, num3, bool13, num4, bool14, bool15, bool16, l8, autoRedirect2, bool10, bool9);
    }

    public static final void write$Self(ConfigPayload self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.cleverCache != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, ConfigPayload$CleverCache$$serializer.INSTANCE, self.cleverCache);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.configSettings != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, ConfigPayload$ConfigSettings$$serializer.INSTANCE, self.configSettings);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.endpoints != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, ConfigPayload$Endpoints$$serializer.INSTANCE, self.endpoints);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.logMetricsSettings != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, ConfigPayload$LogMetricsSettings$$serializer.INSTANCE, self.logMetricsSettings);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.placements != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, new f7.d(Placement$$serializer.INSTANCE, 0), self.placements);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.userPrivacy != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, ConfigPayload$UserPrivacy$$serializer.INSTANCE, self.userPrivacy);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.configExtension != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, q1.f11501a, self.configExtension);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !k.a(self.disableAdId, Boolean.TRUE)) {
            output.encodeNullableSerializableElement(serialDesc, 7, f7.g.f11455a, self.disableAdId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.isReportIncentivizedEnabled != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, f7.g.f11455a, self.isReportIncentivizedEnabled);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.sessionTimeout != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, l0.f11478a, self.sessionTimeout);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.waitForConnectivityForTPAT != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, f7.g.f11455a, self.waitForConnectivityForTPAT);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.signalSessionTimeout != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, l0.f11478a, self.signalSessionTimeout);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.signalsDisabled != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, f7.g.f11455a, self.signalsDisabled);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.fpdEnabled != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, f7.g.f11455a, self.fpdEnabled);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.rtaDebugging != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, f7.g.f11455a, self.rtaDebugging);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.configLastValidatedTimestamp != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, q0.f11499a, self.configLastValidatedTimestamp);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.autoRedirect != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, ConfigPayload$AutoRedirect$$serializer.INSTANCE, self.autoRedirect);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.retryPriorityTPATs != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, f7.g.f11455a, self.retryPriorityTPATs);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 18) && self.enableOT == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 18, f7.g.f11455a, self.enableOT);
    }

    public final CleverCache component1() {
        return this.cleverCache;
    }

    public final Integer component10() {
        return this.sessionTimeout;
    }

    public final Boolean component11() {
        return this.waitForConnectivityForTPAT;
    }

    public final Integer component12() {
        return this.signalSessionTimeout;
    }

    public final Boolean component13() {
        return this.signalsDisabled;
    }

    public final Boolean component14() {
        return this.fpdEnabled;
    }

    public final Boolean component15() {
        return this.rtaDebugging;
    }

    public final Long component16() {
        return this.configLastValidatedTimestamp;
    }

    public final AutoRedirect component17() {
        return this.autoRedirect;
    }

    public final Boolean component18() {
        return this.retryPriorityTPATs;
    }

    public final Boolean component19() {
        return this.enableOT;
    }

    public final ConfigSettings component2() {
        return this.configSettings;
    }

    public final Endpoints component3() {
        return this.endpoints;
    }

    public final LogMetricsSettings component4() {
        return this.logMetricsSettings;
    }

    public final List<Placement> component5() {
        return this.placements;
    }

    public final UserPrivacy component6() {
        return this.userPrivacy;
    }

    public final String component7() {
        return this.configExtension;
    }

    public final Boolean component8() {
        return this.disableAdId;
    }

    public final Boolean component9() {
        return this.isReportIncentivizedEnabled;
    }

    public final ConfigPayload copy(CleverCache cleverCache, ConfigSettings configSettings, Endpoints endpoints, LogMetricsSettings logMetricsSettings, List<Placement> list, UserPrivacy userPrivacy, String str, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Boolean bool5, Boolean bool6, Long l, AutoRedirect autoRedirect, Boolean bool7, Boolean bool8) {
        return new ConfigPayload(cleverCache, configSettings, endpoints, logMetricsSettings, list, userPrivacy, str, bool, bool2, num, bool3, num2, bool4, bool5, bool6, l, autoRedirect, bool7, bool8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigPayload)) {
            return false;
        }
        ConfigPayload configPayload = (ConfigPayload) obj;
        return k.a(this.cleverCache, configPayload.cleverCache) && k.a(this.configSettings, configPayload.configSettings) && k.a(this.endpoints, configPayload.endpoints) && k.a(this.logMetricsSettings, configPayload.logMetricsSettings) && k.a(this.placements, configPayload.placements) && k.a(this.userPrivacy, configPayload.userPrivacy) && k.a(this.configExtension, configPayload.configExtension) && k.a(this.disableAdId, configPayload.disableAdId) && k.a(this.isReportIncentivizedEnabled, configPayload.isReportIncentivizedEnabled) && k.a(this.sessionTimeout, configPayload.sessionTimeout) && k.a(this.waitForConnectivityForTPAT, configPayload.waitForConnectivityForTPAT) && k.a(this.signalSessionTimeout, configPayload.signalSessionTimeout) && k.a(this.signalsDisabled, configPayload.signalsDisabled) && k.a(this.fpdEnabled, configPayload.fpdEnabled) && k.a(this.rtaDebugging, configPayload.rtaDebugging) && k.a(this.configLastValidatedTimestamp, configPayload.configLastValidatedTimestamp) && k.a(this.autoRedirect, configPayload.autoRedirect) && k.a(this.retryPriorityTPATs, configPayload.retryPriorityTPATs) && k.a(this.enableOT, configPayload.enableOT);
    }

    public final AutoRedirect getAutoRedirect() {
        return this.autoRedirect;
    }

    public final CleverCache getCleverCache() {
        return this.cleverCache;
    }

    public final String getConfigExtension() {
        return this.configExtension;
    }

    public final Long getConfigLastValidatedTimestamp() {
        return this.configLastValidatedTimestamp;
    }

    public final ConfigSettings getConfigSettings() {
        return this.configSettings;
    }

    public final Boolean getDisableAdId() {
        return this.disableAdId;
    }

    public final Boolean getEnableOT() {
        return this.enableOT;
    }

    public final Endpoints getEndpoints() {
        return this.endpoints;
    }

    public final Boolean getFpdEnabled() {
        return this.fpdEnabled;
    }

    public final LogMetricsSettings getLogMetricsSettings() {
        return this.logMetricsSettings;
    }

    public final List<Placement> getPlacements() {
        return this.placements;
    }

    public final Boolean getRetryPriorityTPATs() {
        return this.retryPriorityTPATs;
    }

    public final Boolean getRtaDebugging() {
        return this.rtaDebugging;
    }

    public final Integer getSessionTimeout() {
        return this.sessionTimeout;
    }

    public final Integer getSignalSessionTimeout() {
        return this.signalSessionTimeout;
    }

    public final Boolean getSignalsDisabled() {
        return this.signalsDisabled;
    }

    public final UserPrivacy getUserPrivacy() {
        return this.userPrivacy;
    }

    public final Boolean getWaitForConnectivityForTPAT() {
        return this.waitForConnectivityForTPAT;
    }

    public int hashCode() {
        CleverCache cleverCache = this.cleverCache;
        int iHashCode = (cleverCache == null ? 0 : cleverCache.hashCode()) * 31;
        ConfigSettings configSettings = this.configSettings;
        int iHashCode2 = (iHashCode + (configSettings == null ? 0 : configSettings.hashCode())) * 31;
        Endpoints endpoints = this.endpoints;
        int iHashCode3 = (iHashCode2 + (endpoints == null ? 0 : endpoints.hashCode())) * 31;
        LogMetricsSettings logMetricsSettings = this.logMetricsSettings;
        int iHashCode4 = (iHashCode3 + (logMetricsSettings == null ? 0 : logMetricsSettings.hashCode())) * 31;
        List<Placement> list = this.placements;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        UserPrivacy userPrivacy = this.userPrivacy;
        int iHashCode6 = (iHashCode5 + (userPrivacy == null ? 0 : userPrivacy.hashCode())) * 31;
        String str = this.configExtension;
        int iHashCode7 = (iHashCode6 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.disableAdId;
        int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isReportIncentivizedEnabled;
        int iHashCode9 = (iHashCode8 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.sessionTimeout;
        int iHashCode10 = (iHashCode9 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool3 = this.waitForConnectivityForTPAT;
        int iHashCode11 = (iHashCode10 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Integer num2 = this.signalSessionTimeout;
        int iHashCode12 = (iHashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool4 = this.signalsDisabled;
        int iHashCode13 = (iHashCode12 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.fpdEnabled;
        int iHashCode14 = (iHashCode13 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.rtaDebugging;
        int iHashCode15 = (iHashCode14 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Long l = this.configLastValidatedTimestamp;
        int iHashCode16 = (iHashCode15 + (l == null ? 0 : l.hashCode())) * 31;
        AutoRedirect autoRedirect = this.autoRedirect;
        int iHashCode17 = (iHashCode16 + (autoRedirect == null ? 0 : autoRedirect.hashCode())) * 31;
        Boolean bool7 = this.retryPriorityTPATs;
        int iHashCode18 = (iHashCode17 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.enableOT;
        return iHashCode18 + (bool8 != null ? bool8.hashCode() : 0);
    }

    public final Boolean isReportIncentivizedEnabled() {
        return this.isReportIncentivizedEnabled;
    }

    public final void setAutoRedirect(AutoRedirect autoRedirect) {
        this.autoRedirect = autoRedirect;
    }

    public final void setConfigLastValidatedTimestamp(Long l) {
        this.configLastValidatedTimestamp = l;
    }

    public final void setEnableOT(Boolean bool) {
        this.enableOT = bool;
    }

    public final void setRetryPriorityTPATs(Boolean bool) {
        this.retryPriorityTPATs = bool;
    }

    public String toString() {
        return "ConfigPayload(cleverCache=" + this.cleverCache + ", configSettings=" + this.configSettings + ", endpoints=" + this.endpoints + ", logMetricsSettings=" + this.logMetricsSettings + ", placements=" + this.placements + ", userPrivacy=" + this.userPrivacy + ", configExtension=" + this.configExtension + ", disableAdId=" + this.disableAdId + ", isReportIncentivizedEnabled=" + this.isReportIncentivizedEnabled + ", sessionTimeout=" + this.sessionTimeout + ", waitForConnectivityForTPAT=" + this.waitForConnectivityForTPAT + ", signalSessionTimeout=" + this.signalSessionTimeout + ", signalsDisabled=" + this.signalsDisabled + ", fpdEnabled=" + this.fpdEnabled + ", rtaDebugging=" + this.rtaDebugging + ", configLastValidatedTimestamp=" + this.configLastValidatedTimestamp + ", autoRedirect=" + this.autoRedirect + ", retryPriorityTPATs=" + this.retryPriorityTPATs + ", enableOT=" + this.enableOT + ')';
    }

    public /* synthetic */ ConfigPayload(int i2, CleverCache cleverCache, ConfigSettings configSettings, Endpoints endpoints, LogMetricsSettings logMetricsSettings, List list, UserPrivacy userPrivacy, String str, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Boolean bool5, Boolean bool6, Long l, AutoRedirect autoRedirect, Boolean bool7, Boolean bool8, m1 m1Var) {
        if ((i2 & 1) == 0) {
            this.cleverCache = null;
        } else {
            this.cleverCache = cleverCache;
        }
        if ((i2 & 2) == 0) {
            this.configSettings = null;
        } else {
            this.configSettings = configSettings;
        }
        if ((i2 & 4) == 0) {
            this.endpoints = null;
        } else {
            this.endpoints = endpoints;
        }
        if ((i2 & 8) == 0) {
            this.logMetricsSettings = null;
        } else {
            this.logMetricsSettings = logMetricsSettings;
        }
        if ((i2 & 16) == 0) {
            this.placements = null;
        } else {
            this.placements = list;
        }
        if ((i2 & 32) == 0) {
            this.userPrivacy = null;
        } else {
            this.userPrivacy = userPrivacy;
        }
        if ((i2 & 64) == 0) {
            this.configExtension = null;
        } else {
            this.configExtension = str;
        }
        if ((i2 & 128) == 0) {
            this.disableAdId = Boolean.TRUE;
        } else {
            this.disableAdId = bool;
        }
        if ((i2 & 256) == 0) {
            this.isReportIncentivizedEnabled = null;
        } else {
            this.isReportIncentivizedEnabled = bool2;
        }
        if ((i2 & 512) == 0) {
            this.sessionTimeout = null;
        } else {
            this.sessionTimeout = num;
        }
        if ((i2 & 1024) == 0) {
            this.waitForConnectivityForTPAT = null;
        } else {
            this.waitForConnectivityForTPAT = bool3;
        }
        if ((i2 & 2048) == 0) {
            this.signalSessionTimeout = null;
        } else {
            this.signalSessionTimeout = num2;
        }
        if ((i2 & 4096) == 0) {
            this.signalsDisabled = null;
        } else {
            this.signalsDisabled = bool4;
        }
        if ((i2 & 8192) == 0) {
            this.fpdEnabled = null;
        } else {
            this.fpdEnabled = bool5;
        }
        if ((i2 & 16384) == 0) {
            this.rtaDebugging = null;
        } else {
            this.rtaDebugging = bool6;
        }
        if ((32768 & i2) == 0) {
            this.configLastValidatedTimestamp = null;
        } else {
            this.configLastValidatedTimestamp = l;
        }
        if ((65536 & i2) == 0) {
            this.autoRedirect = null;
        } else {
            this.autoRedirect = autoRedirect;
        }
        if ((131072 & i2) == 0) {
            this.retryPriorityTPATs = null;
        } else {
            this.retryPriorityTPATs = bool7;
        }
        if ((i2 & 262144) == 0) {
            this.enableOT = null;
        } else {
            this.enableOT = bool8;
        }
    }

    public ConfigPayload(CleverCache cleverCache, ConfigSettings configSettings, Endpoints endpoints, LogMetricsSettings logMetricsSettings, List<Placement> list, UserPrivacy userPrivacy, String str, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Boolean bool5, Boolean bool6, Long l, AutoRedirect autoRedirect, Boolean bool7, Boolean bool8) {
        this.cleverCache = cleverCache;
        this.configSettings = configSettings;
        this.endpoints = endpoints;
        this.logMetricsSettings = logMetricsSettings;
        this.placements = list;
        this.userPrivacy = userPrivacy;
        this.configExtension = str;
        this.disableAdId = bool;
        this.isReportIncentivizedEnabled = bool2;
        this.sessionTimeout = num;
        this.waitForConnectivityForTPAT = bool3;
        this.signalSessionTimeout = num2;
        this.signalsDisabled = bool4;
        this.fpdEnabled = bool5;
        this.rtaDebugging = bool6;
        this.configLastValidatedTimestamp = l;
        this.autoRedirect = autoRedirect;
        this.retryPriorityTPATs = bool7;
        this.enableOT = bool8;
    }

    public static /* synthetic */ void getAutoRedirect$annotations() {
    }

    public static /* synthetic */ void getCleverCache$annotations() {
    }

    public static /* synthetic */ void getConfigExtension$annotations() {
    }

    public static /* synthetic */ void getConfigLastValidatedTimestamp$annotations() {
    }

    public static /* synthetic */ void getConfigSettings$annotations() {
    }

    public static /* synthetic */ void getDisableAdId$annotations() {
    }

    public static /* synthetic */ void getEnableOT$annotations() {
    }

    public static /* synthetic */ void getEndpoints$annotations() {
    }

    public static /* synthetic */ void getFpdEnabled$annotations() {
    }

    public static /* synthetic */ void getLogMetricsSettings$annotations() {
    }

    public static /* synthetic */ void getPlacements$annotations() {
    }

    public static /* synthetic */ void getRetryPriorityTPATs$annotations() {
    }

    public static /* synthetic */ void getRtaDebugging$annotations() {
    }

    public static /* synthetic */ void getSessionTimeout$annotations() {
    }

    public static /* synthetic */ void getSignalSessionTimeout$annotations() {
    }

    public static /* synthetic */ void getSignalsDisabled$annotations() {
    }

    public static /* synthetic */ void getUserPrivacy$annotations() {
    }

    public static /* synthetic */ void getWaitForConnectivityForTPAT$annotations() {
    }

    public static /* synthetic */ void isReportIncentivizedEnabled$annotations() {
    }

    public /* synthetic */ ConfigPayload(CleverCache cleverCache, ConfigSettings configSettings, Endpoints endpoints, LogMetricsSettings logMetricsSettings, List list, UserPrivacy userPrivacy, String str, Boolean bool, Boolean bool2, Integer num, Boolean bool3, Integer num2, Boolean bool4, Boolean bool5, Boolean bool6, Long l, AutoRedirect autoRedirect, Boolean bool7, Boolean bool8, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : cleverCache, (i2 & 2) != 0 ? null : configSettings, (i2 & 4) != 0 ? null : endpoints, (i2 & 8) != 0 ? null : logMetricsSettings, (i2 & 16) != 0 ? null : list, (i2 & 32) != 0 ? null : userPrivacy, (i2 & 64) != 0 ? null : str, (i2 & 128) != 0 ? Boolean.TRUE : bool, (i2 & 256) != 0 ? null : bool2, (i2 & 512) != 0 ? null : num, (i2 & 1024) != 0 ? null : bool3, (i2 & 2048) != 0 ? null : num2, (i2 & 4096) != 0 ? null : bool4, (i2 & 8192) != 0 ? null : bool5, (i2 & 16384) != 0 ? null : bool6, (i2 & 32768) != 0 ? null : l, (i2 & 65536) != 0 ? null : autoRedirect, (i2 & 131072) != 0 ? null : bool7, (i2 & 262144) != 0 ? null : bool8);
    }
}
