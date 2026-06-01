package com.vungle.ads.internal.model;

import a1.a;
import b7.c;
import b7.h;
import com.ironsource.adqualitysdk.sdk.i.a0;
import com.vungle.ads.fpd.FirstPartyData;
import com.vungle.ads.fpd.FirstPartyData$$serializer;
import d7.g;
import e7.d;
import f7.c1;
import f7.m1;
import f7.q0;
import f7.q1;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class CommonRequestBody {
    public static final Companion Companion = new Companion(null);
    private final AppNode app;
    private final DeviceNode device;
    private RequestExt ext;
    private RequestParam request;
    private final User user;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class CCPA {
        public static final Companion Companion = new Companion(null);
        private final String status;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return CommonRequestBody$CCPA$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ CCPA(int i2, String str, m1 m1Var) {
            if (1 == (i2 & 1)) {
                this.status = str;
            } else {
                c1.j(CommonRequestBody$CCPA$$serializer.INSTANCE.getDescriptor(), i2, 1);
                throw null;
            }
        }

        public static /* synthetic */ CCPA copy$default(CCPA ccpa, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = ccpa.status;
            }
            return ccpa.copy(str);
        }

        public static final void write$Self(CCPA self, d output, g serialDesc) {
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            output.encodeStringElement(serialDesc, 0, self.status);
        }

        public final String component1() {
            return this.status;
        }

        public final CCPA copy(String status) {
            k.e(status, "status");
            return new CCPA(status);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CCPA) && k.a(this.status, ((CCPA) obj).status);
        }

        public final String getStatus() {
            return this.status;
        }

        public int hashCode() {
            return this.status.hashCode();
        }

        public String toString() {
            return a.e(')', this.status, new StringBuilder("CCPA(status="));
        }

        public CCPA(String status) {
            k.e(status, "status");
            this.status = status;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class COPPA {
        public static final Companion Companion = new Companion(null);
        private final Boolean isCoppa;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return CommonRequestBody$COPPA$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ COPPA(int i2, Boolean bool, m1 m1Var) {
            if (1 == (i2 & 1)) {
                this.isCoppa = bool;
            } else {
                c1.j(CommonRequestBody$COPPA$$serializer.INSTANCE.getDescriptor(), i2, 1);
                throw null;
            }
        }

        public static /* synthetic */ COPPA copy$default(COPPA coppa, Boolean bool, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                bool = coppa.isCoppa;
            }
            return coppa.copy(bool);
        }

        public static final void write$Self(COPPA self, d output, g serialDesc) {
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            output.encodeNullableSerializableElement(serialDesc, 0, f7.g.f11455a, self.isCoppa);
        }

        public final Boolean component1() {
            return this.isCoppa;
        }

        public final COPPA copy(Boolean bool) {
            return new COPPA(bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof COPPA) && k.a(this.isCoppa, ((COPPA) obj).isCoppa);
        }

        public int hashCode() {
            Boolean bool = this.isCoppa;
            if (bool == null) {
                return 0;
            }
            return bool.hashCode();
        }

        public final Boolean isCoppa() {
            return this.isCoppa;
        }

        public String toString() {
            return "COPPA(isCoppa=" + this.isCoppa + ')';
        }

        public COPPA(Boolean bool) {
            this.isCoppa = bool;
        }

        public static /* synthetic */ void isCoppa$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return CommonRequestBody$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class GDPR {
        public static final Companion Companion = new Companion(null);
        private final String consentMessageVersion;
        private final String consentSource;
        private final String consentStatus;
        private final long consentTimestamp;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return CommonRequestBody$GDPR$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ GDPR(int i2, String str, String str2, long j, String str3, m1 m1Var) {
            if (15 != (i2 & 15)) {
                c1.j(CommonRequestBody$GDPR$$serializer.INSTANCE.getDescriptor(), i2, 15);
                throw null;
            }
            this.consentStatus = str;
            this.consentSource = str2;
            this.consentTimestamp = j;
            this.consentMessageVersion = str3;
        }

        public static /* synthetic */ GDPR copy$default(GDPR gdpr, String str, String str2, long j, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = gdpr.consentStatus;
            }
            if ((i2 & 2) != 0) {
                str2 = gdpr.consentSource;
            }
            if ((i2 & 4) != 0) {
                j = gdpr.consentTimestamp;
            }
            if ((i2 & 8) != 0) {
                str3 = gdpr.consentMessageVersion;
            }
            String str4 = str3;
            return gdpr.copy(str, str2, j, str4);
        }

        public static final void write$Self(GDPR self, d output, g serialDesc) {
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            output.encodeStringElement(serialDesc, 0, self.consentStatus);
            output.encodeStringElement(serialDesc, 1, self.consentSource);
            output.encodeLongElement(serialDesc, 2, self.consentTimestamp);
            output.encodeStringElement(serialDesc, 3, self.consentMessageVersion);
        }

        public final String component1() {
            return this.consentStatus;
        }

        public final String component2() {
            return this.consentSource;
        }

        public final long component3() {
            return this.consentTimestamp;
        }

        public final String component4() {
            return this.consentMessageVersion;
        }

        public final GDPR copy(String consentStatus, String consentSource, long j, String consentMessageVersion) {
            k.e(consentStatus, "consentStatus");
            k.e(consentSource, "consentSource");
            k.e(consentMessageVersion, "consentMessageVersion");
            return new GDPR(consentStatus, consentSource, j, consentMessageVersion);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GDPR)) {
                return false;
            }
            GDPR gdpr = (GDPR) obj;
            return k.a(this.consentStatus, gdpr.consentStatus) && k.a(this.consentSource, gdpr.consentSource) && this.consentTimestamp == gdpr.consentTimestamp && k.a(this.consentMessageVersion, gdpr.consentMessageVersion);
        }

        public final String getConsentMessageVersion() {
            return this.consentMessageVersion;
        }

        public final String getConsentSource() {
            return this.consentSource;
        }

        public final String getConsentStatus() {
            return this.consentStatus;
        }

        public final long getConsentTimestamp() {
            return this.consentTimestamp;
        }

        public int hashCode() {
            int iB = androidx.camera.core.processing.util.a.b(this.consentStatus.hashCode() * 31, 31, this.consentSource);
            long j = this.consentTimestamp;
            return this.consentMessageVersion.hashCode() + ((iB + ((int) (j ^ (j >>> 32)))) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("GDPR(consentStatus=");
            sb.append(this.consentStatus);
            sb.append(", consentSource=");
            sb.append(this.consentSource);
            sb.append(", consentTimestamp=");
            sb.append(this.consentTimestamp);
            sb.append(", consentMessageVersion=");
            return a.e(')', this.consentMessageVersion, sb);
        }

        public GDPR(String consentStatus, String consentSource, long j, String consentMessageVersion) {
            k.e(consentStatus, "consentStatus");
            k.e(consentSource, "consentSource");
            k.e(consentMessageVersion, "consentMessageVersion");
            this.consentStatus = consentStatus;
            this.consentSource = consentSource;
            this.consentTimestamp = j;
            this.consentMessageVersion = consentMessageVersion;
        }

        public static /* synthetic */ void getConsentMessageVersion$annotations() {
        }

        public static /* synthetic */ void getConsentSource$annotations() {
        }

        public static /* synthetic */ void getConsentStatus$annotations() {
        }

        public static /* synthetic */ void getConsentTimestamp$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class IAB {
        public static final Companion Companion = new Companion(null);
        private final String tcf;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return CommonRequestBody$IAB$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public /* synthetic */ IAB(int i2, String str, m1 m1Var) {
            if (1 == (i2 & 1)) {
                this.tcf = str;
            } else {
                c1.j(CommonRequestBody$IAB$$serializer.INSTANCE.getDescriptor(), i2, 1);
                throw null;
            }
        }

        public static /* synthetic */ IAB copy$default(IAB iab, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = iab.tcf;
            }
            return iab.copy(str);
        }

        public static final void write$Self(IAB self, d output, g serialDesc) {
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            output.encodeStringElement(serialDesc, 0, self.tcf);
        }

        public final String component1() {
            return this.tcf;
        }

        public final IAB copy(String tcf) {
            k.e(tcf, "tcf");
            return new IAB(tcf);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IAB) && k.a(this.tcf, ((IAB) obj).tcf);
        }

        public final String getTcf() {
            return this.tcf;
        }

        public int hashCode() {
            return this.tcf.hashCode();
        }

        public String toString() {
            return a.e(')', this.tcf, new StringBuilder("IAB(tcf="));
        }

        public IAB(String tcf) {
            k.e(tcf, "tcf");
            this.tcf = tcf;
        }

        public static /* synthetic */ void getTcf$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class RequestExt {
        public static final Companion Companion = new Companion(null);
        private final String configExtension;
        private final Long configLastValidatedTimestamp;
        private String signals;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return CommonRequestBody$RequestExt$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public RequestExt() {
            this((String) null, (String) null, (Long) null, 7, (f) null);
        }

        public static /* synthetic */ RequestExt copy$default(RequestExt requestExt, String str, String str2, Long l, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = requestExt.configExtension;
            }
            if ((i2 & 2) != 0) {
                str2 = requestExt.signals;
            }
            if ((i2 & 4) != 0) {
                l = requestExt.configLastValidatedTimestamp;
            }
            return requestExt.copy(str, str2, l);
        }

        public static final void write$Self(RequestExt self, d output, g serialDesc) {
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.configExtension != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, q1.f11501a, self.configExtension);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.signals != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, q1.f11501a, self.signals);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.configLastValidatedTimestamp == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, q0.f11499a, self.configLastValidatedTimestamp);
        }

        public final String component1() {
            return this.configExtension;
        }

        public final String component2() {
            return this.signals;
        }

        public final Long component3() {
            return this.configLastValidatedTimestamp;
        }

        public final RequestExt copy(String str, String str2, Long l) {
            return new RequestExt(str, str2, l);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestExt)) {
                return false;
            }
            RequestExt requestExt = (RequestExt) obj;
            return k.a(this.configExtension, requestExt.configExtension) && k.a(this.signals, requestExt.signals) && k.a(this.configLastValidatedTimestamp, requestExt.configLastValidatedTimestamp);
        }

        public final String getConfigExtension() {
            return this.configExtension;
        }

        public final Long getConfigLastValidatedTimestamp() {
            return this.configLastValidatedTimestamp;
        }

        public final String getSignals() {
            return this.signals;
        }

        public int hashCode() {
            String str = this.configExtension;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.signals;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Long l = this.configLastValidatedTimestamp;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public final void setSignals(String str) {
            this.signals = str;
        }

        public String toString() {
            return "RequestExt(configExtension=" + this.configExtension + ", signals=" + this.signals + ", configLastValidatedTimestamp=" + this.configLastValidatedTimestamp + ')';
        }

        public /* synthetic */ RequestExt(int i2, String str, String str2, Long l, m1 m1Var) {
            if ((i2 & 1) == 0) {
                this.configExtension = null;
            } else {
                this.configExtension = str;
            }
            if ((i2 & 2) == 0) {
                this.signals = null;
            } else {
                this.signals = str2;
            }
            if ((i2 & 4) == 0) {
                this.configLastValidatedTimestamp = null;
            } else {
                this.configLastValidatedTimestamp = l;
            }
        }

        public RequestExt(String str, String str2, Long l) {
            this.configExtension = str;
            this.signals = str2;
            this.configLastValidatedTimestamp = l;
        }

        public /* synthetic */ RequestExt(String str, String str2, Long l, int i2, f fVar) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : l);
        }

        public static /* synthetic */ void getConfigExtension$annotations() {
        }

        public static /* synthetic */ void getConfigLastValidatedTimestamp$annotations() {
        }

        public static /* synthetic */ void getSignals$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class RequestParam {
        public static final Companion Companion = new Companion(null);
        private AdSizeParam adSize;
        private final Long adStartTime;
        private final String advAppId;
        private final String placementReferenceId;
        private final List<String> placements;
        private final String user;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return CommonRequestBody$RequestParam$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public RequestParam() {
            this((List) null, (AdSizeParam) null, (Long) null, (String) null, (String) null, (String) null, 63, (f) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RequestParam copy$default(RequestParam requestParam, List list, AdSizeParam adSizeParam, Long l, String str, String str2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = requestParam.placements;
            }
            if ((i2 & 2) != 0) {
                adSizeParam = requestParam.adSize;
            }
            if ((i2 & 4) != 0) {
                l = requestParam.adStartTime;
            }
            if ((i2 & 8) != 0) {
                str = requestParam.advAppId;
            }
            if ((i2 & 16) != 0) {
                str2 = requestParam.placementReferenceId;
            }
            if ((i2 & 32) != 0) {
                str3 = requestParam.user;
            }
            String str4 = str2;
            String str5 = str3;
            return requestParam.copy(list, adSizeParam, l, str, str4, str5);
        }

        public static final void write$Self(RequestParam self, d output, g serialDesc) {
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.placements != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, new f7.d(q1.f11501a, 0), self.placements);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.adSize != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, CommonRequestBody$AdSizeParam$$serializer.INSTANCE, self.adSize);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.adStartTime != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, q0.f11499a, self.adStartTime);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.advAppId != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, q1.f11501a, self.advAppId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.placementReferenceId != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, q1.f11501a, self.placementReferenceId);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.user == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 5, q1.f11501a, self.user);
        }

        public final List<String> component1() {
            return this.placements;
        }

        public final AdSizeParam component2() {
            return this.adSize;
        }

        public final Long component3() {
            return this.adStartTime;
        }

        public final String component4() {
            return this.advAppId;
        }

        public final String component5() {
            return this.placementReferenceId;
        }

        public final String component6() {
            return this.user;
        }

        public final RequestParam copy(List<String> list, AdSizeParam adSizeParam, Long l, String str, String str2, String str3) {
            return new RequestParam(list, adSizeParam, l, str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestParam)) {
                return false;
            }
            RequestParam requestParam = (RequestParam) obj;
            return k.a(this.placements, requestParam.placements) && k.a(this.adSize, requestParam.adSize) && k.a(this.adStartTime, requestParam.adStartTime) && k.a(this.advAppId, requestParam.advAppId) && k.a(this.placementReferenceId, requestParam.placementReferenceId) && k.a(this.user, requestParam.user);
        }

        public final AdSizeParam getAdSize() {
            return this.adSize;
        }

        public final Long getAdStartTime() {
            return this.adStartTime;
        }

        public final String getAdvAppId() {
            return this.advAppId;
        }

        public final String getPlacementReferenceId() {
            return this.placementReferenceId;
        }

        public final List<String> getPlacements() {
            return this.placements;
        }

        public final String getUser() {
            return this.user;
        }

        public int hashCode() {
            List<String> list = this.placements;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            AdSizeParam adSizeParam = this.adSize;
            int iHashCode2 = (iHashCode + (adSizeParam == null ? 0 : adSizeParam.hashCode())) * 31;
            Long l = this.adStartTime;
            int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
            String str = this.advAppId;
            int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.placementReferenceId;
            int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.user;
            return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
        }

        public final void setAdSize(AdSizeParam adSizeParam) {
            this.adSize = adSizeParam;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("RequestParam(placements=");
            sb.append(this.placements);
            sb.append(", adSize=");
            sb.append(this.adSize);
            sb.append(", adStartTime=");
            sb.append(this.adStartTime);
            sb.append(", advAppId=");
            sb.append(this.advAppId);
            sb.append(", placementReferenceId=");
            sb.append(this.placementReferenceId);
            sb.append(", user=");
            return a.e(')', this.user, sb);
        }

        public /* synthetic */ RequestParam(int i2, List list, AdSizeParam adSizeParam, Long l, String str, String str2, String str3, m1 m1Var) {
            if ((i2 & 1) == 0) {
                this.placements = null;
            } else {
                this.placements = list;
            }
            if ((i2 & 2) == 0) {
                this.adSize = null;
            } else {
                this.adSize = adSizeParam;
            }
            if ((i2 & 4) == 0) {
                this.adStartTime = null;
            } else {
                this.adStartTime = l;
            }
            if ((i2 & 8) == 0) {
                this.advAppId = null;
            } else {
                this.advAppId = str;
            }
            if ((i2 & 16) == 0) {
                this.placementReferenceId = null;
            } else {
                this.placementReferenceId = str2;
            }
            if ((i2 & 32) == 0) {
                this.user = null;
            } else {
                this.user = str3;
            }
        }

        public RequestParam(List<String> list, AdSizeParam adSizeParam, Long l, String str, String str2, String str3) {
            this.placements = list;
            this.adSize = adSizeParam;
            this.adStartTime = l;
            this.advAppId = str;
            this.placementReferenceId = str2;
            this.user = str3;
        }

        public /* synthetic */ RequestParam(List list, AdSizeParam adSizeParam, Long l, String str, String str2, String str3, int i2, f fVar) {
            this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : adSizeParam, (i2 & 4) != 0 ? null : l, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? null : str3);
        }

        public static /* synthetic */ void getAdSize$annotations() {
        }

        public static /* synthetic */ void getAdStartTime$annotations() {
        }

        public static /* synthetic */ void getAdvAppId$annotations() {
        }

        public static /* synthetic */ void getPlacementReferenceId$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class User {
        public static final Companion Companion = new Companion(null);
        private CCPA ccpa;
        private COPPA coppa;
        private FirstPartyData fpd;
        private GDPR gdpr;
        private IAB iab;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return CommonRequestBody$User$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public User() {
            this((GDPR) null, (CCPA) null, (COPPA) null, (FirstPartyData) null, (IAB) null, 31, (f) null);
        }

        public static /* synthetic */ User copy$default(User user, GDPR gdpr, CCPA ccpa, COPPA coppa, FirstPartyData firstPartyData, IAB iab, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                gdpr = user.gdpr;
            }
            if ((i2 & 2) != 0) {
                ccpa = user.ccpa;
            }
            if ((i2 & 4) != 0) {
                coppa = user.coppa;
            }
            if ((i2 & 8) != 0) {
                firstPartyData = user.fpd;
            }
            if ((i2 & 16) != 0) {
                iab = user.iab;
            }
            IAB iab2 = iab;
            COPPA coppa2 = coppa;
            return user.copy(gdpr, ccpa, coppa2, firstPartyData, iab2);
        }

        public static final void write$Self(User self, d output, g serialDesc) {
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.gdpr != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, CommonRequestBody$GDPR$$serializer.INSTANCE, self.gdpr);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.ccpa != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, CommonRequestBody$CCPA$$serializer.INSTANCE, self.ccpa);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.coppa != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, CommonRequestBody$COPPA$$serializer.INSTANCE, self.coppa);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.fpd != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, FirstPartyData$$serializer.INSTANCE, self.fpd);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.iab == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 4, CommonRequestBody$IAB$$serializer.INSTANCE, self.iab);
        }

        public final GDPR component1() {
            return this.gdpr;
        }

        public final CCPA component2() {
            return this.ccpa;
        }

        public final COPPA component3() {
            return this.coppa;
        }

        public final FirstPartyData component4() {
            return this.fpd;
        }

        public final IAB component5() {
            return this.iab;
        }

        public final User copy(GDPR gdpr, CCPA ccpa, COPPA coppa, FirstPartyData firstPartyData, IAB iab) {
            return new User(gdpr, ccpa, coppa, firstPartyData, iab);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof User)) {
                return false;
            }
            User user = (User) obj;
            return k.a(this.gdpr, user.gdpr) && k.a(this.ccpa, user.ccpa) && k.a(this.coppa, user.coppa) && k.a(this.fpd, user.fpd) && k.a(this.iab, user.iab);
        }

        public final CCPA getCcpa() {
            return this.ccpa;
        }

        public final COPPA getCoppa() {
            return this.coppa;
        }

        public final FirstPartyData getFpd() {
            return this.fpd;
        }

        public final GDPR getGdpr() {
            return this.gdpr;
        }

        public final IAB getIab() {
            return this.iab;
        }

        public int hashCode() {
            GDPR gdpr = this.gdpr;
            int iHashCode = (gdpr == null ? 0 : gdpr.hashCode()) * 31;
            CCPA ccpa = this.ccpa;
            int iHashCode2 = (iHashCode + (ccpa == null ? 0 : ccpa.hashCode())) * 31;
            COPPA coppa = this.coppa;
            int iHashCode3 = (iHashCode2 + (coppa == null ? 0 : coppa.hashCode())) * 31;
            FirstPartyData firstPartyData = this.fpd;
            int iHashCode4 = (iHashCode3 + (firstPartyData == null ? 0 : firstPartyData.hashCode())) * 31;
            IAB iab = this.iab;
            return iHashCode4 + (iab != null ? iab.hashCode() : 0);
        }

        public final void setCcpa(CCPA ccpa) {
            this.ccpa = ccpa;
        }

        public final void setCoppa(COPPA coppa) {
            this.coppa = coppa;
        }

        public final void setFpd(FirstPartyData firstPartyData) {
            this.fpd = firstPartyData;
        }

        public final void setGdpr(GDPR gdpr) {
            this.gdpr = gdpr;
        }

        public final void setIab(IAB iab) {
            this.iab = iab;
        }

        public String toString() {
            return "User(gdpr=" + this.gdpr + ", ccpa=" + this.ccpa + ", coppa=" + this.coppa + ", fpd=" + this.fpd + ", iab=" + this.iab + ')';
        }

        public /* synthetic */ User(int i2, GDPR gdpr, CCPA ccpa, COPPA coppa, FirstPartyData firstPartyData, IAB iab, m1 m1Var) {
            if ((i2 & 1) == 0) {
                this.gdpr = null;
            } else {
                this.gdpr = gdpr;
            }
            if ((i2 & 2) == 0) {
                this.ccpa = null;
            } else {
                this.ccpa = ccpa;
            }
            if ((i2 & 4) == 0) {
                this.coppa = null;
            } else {
                this.coppa = coppa;
            }
            if ((i2 & 8) == 0) {
                this.fpd = null;
            } else {
                this.fpd = firstPartyData;
            }
            if ((i2 & 16) == 0) {
                this.iab = null;
            } else {
                this.iab = iab;
            }
        }

        public User(GDPR gdpr, CCPA ccpa, COPPA coppa, FirstPartyData firstPartyData, IAB iab) {
            this.gdpr = gdpr;
            this.ccpa = ccpa;
            this.coppa = coppa;
            this.fpd = firstPartyData;
            this.iab = iab;
        }

        public /* synthetic */ User(GDPR gdpr, CCPA ccpa, COPPA coppa, FirstPartyData firstPartyData, IAB iab, int i2, f fVar) {
            this((i2 & 1) != 0 ? null : gdpr, (i2 & 2) != 0 ? null : ccpa, (i2 & 4) != 0 ? null : coppa, (i2 & 8) != 0 ? null : firstPartyData, (i2 & 16) != 0 ? null : iab);
        }
    }

    public /* synthetic */ CommonRequestBody(int i2, DeviceNode deviceNode, AppNode appNode, User user, RequestExt requestExt, RequestParam requestParam, m1 m1Var) {
        if (1 != (i2 & 1)) {
            c1.j(CommonRequestBody$$serializer.INSTANCE.getDescriptor(), i2, 1);
            throw null;
        }
        this.device = deviceNode;
        if ((i2 & 2) == 0) {
            this.app = null;
        } else {
            this.app = appNode;
        }
        if ((i2 & 4) == 0) {
            this.user = null;
        } else {
            this.user = user;
        }
        if ((i2 & 8) == 0) {
            this.ext = null;
        } else {
            this.ext = requestExt;
        }
        if ((i2 & 16) == 0) {
            this.request = null;
        } else {
            this.request = requestParam;
        }
    }

    public static /* synthetic */ CommonRequestBody copy$default(CommonRequestBody commonRequestBody, DeviceNode deviceNode, AppNode appNode, User user, RequestExt requestExt, RequestParam requestParam, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            deviceNode = commonRequestBody.device;
        }
        if ((i2 & 2) != 0) {
            appNode = commonRequestBody.app;
        }
        if ((i2 & 4) != 0) {
            user = commonRequestBody.user;
        }
        if ((i2 & 8) != 0) {
            requestExt = commonRequestBody.ext;
        }
        if ((i2 & 16) != 0) {
            requestParam = commonRequestBody.request;
        }
        RequestParam requestParam2 = requestParam;
        User user2 = user;
        return commonRequestBody.copy(deviceNode, appNode, user2, requestExt, requestParam2);
    }

    public static final void write$Self(CommonRequestBody self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        output.encodeSerializableElement(serialDesc, 0, DeviceNode$$serializer.INSTANCE, self.device);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.app != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, AppNode$$serializer.INSTANCE, self.app);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.user != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, CommonRequestBody$User$$serializer.INSTANCE, self.user);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.ext != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, CommonRequestBody$RequestExt$$serializer.INSTANCE, self.ext);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.request == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, CommonRequestBody$RequestParam$$serializer.INSTANCE, self.request);
    }

    public final DeviceNode component1() {
        return this.device;
    }

    public final AppNode component2() {
        return this.app;
    }

    public final User component3() {
        return this.user;
    }

    public final RequestExt component4() {
        return this.ext;
    }

    public final RequestParam component5() {
        return this.request;
    }

    public final CommonRequestBody copy(DeviceNode device, AppNode appNode, User user, RequestExt requestExt, RequestParam requestParam) {
        k.e(device, "device");
        return new CommonRequestBody(device, appNode, user, requestExt, requestParam);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommonRequestBody)) {
            return false;
        }
        CommonRequestBody commonRequestBody = (CommonRequestBody) obj;
        return k.a(this.device, commonRequestBody.device) && k.a(this.app, commonRequestBody.app) && k.a(this.user, commonRequestBody.user) && k.a(this.ext, commonRequestBody.ext) && k.a(this.request, commonRequestBody.request);
    }

    public final AppNode getApp() {
        return this.app;
    }

    public final DeviceNode getDevice() {
        return this.device;
    }

    public final RequestExt getExt() {
        return this.ext;
    }

    public final RequestParam getRequest() {
        return this.request;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int iHashCode = this.device.hashCode() * 31;
        AppNode appNode = this.app;
        int iHashCode2 = (iHashCode + (appNode == null ? 0 : appNode.hashCode())) * 31;
        User user = this.user;
        int iHashCode3 = (iHashCode2 + (user == null ? 0 : user.hashCode())) * 31;
        RequestExt requestExt = this.ext;
        int iHashCode4 = (iHashCode3 + (requestExt == null ? 0 : requestExt.hashCode())) * 31;
        RequestParam requestParam = this.request;
        return iHashCode4 + (requestParam != null ? requestParam.hashCode() : 0);
    }

    public final void setExt(RequestExt requestExt) {
        this.ext = requestExt;
    }

    public final void setRequest(RequestParam requestParam) {
        this.request = requestParam;
    }

    public String toString() {
        return "CommonRequestBody(device=" + this.device + ", app=" + this.app + ", user=" + this.user + ", ext=" + this.ext + ", request=" + this.request + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @h
    public static final class AdSizeParam {
        public static final Companion Companion = new Companion(null);
        private final int height;
        private final int width;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final c serializer() {
                return CommonRequestBody$AdSizeParam$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public AdSizeParam(int i2, int i8) {
            this.width = i2;
            this.height = i8;
        }

        public static /* synthetic */ AdSizeParam copy$default(AdSizeParam adSizeParam, int i2, int i8, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                i2 = adSizeParam.width;
            }
            if ((i9 & 2) != 0) {
                i8 = adSizeParam.height;
            }
            return adSizeParam.copy(i2, i8);
        }

        public static final void write$Self(AdSizeParam self, d output, g serialDesc) {
            k.e(self, "self");
            k.e(output, "output");
            k.e(serialDesc, "serialDesc");
            output.encodeIntElement(serialDesc, 0, self.width);
            output.encodeIntElement(serialDesc, 1, self.height);
        }

        public final int component1() {
            return this.width;
        }

        public final int component2() {
            return this.height;
        }

        public final AdSizeParam copy(int i2, int i8) {
            return new AdSizeParam(i2, i8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdSizeParam)) {
                return false;
            }
            AdSizeParam adSizeParam = (AdSizeParam) obj;
            return this.width == adSizeParam.width && this.height == adSizeParam.height;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (this.width * 31) + this.height;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("AdSizeParam(width=");
            sb.append(this.width);
            sb.append(", height=");
            return a0.c(sb, this.height, ')');
        }

        public /* synthetic */ AdSizeParam(int i2, int i8, int i9, m1 m1Var) {
            if (3 != (i2 & 3)) {
                c1.j(CommonRequestBody$AdSizeParam$$serializer.INSTANCE.getDescriptor(), i2, 3);
                throw null;
            }
            this.width = i8;
            this.height = i9;
        }

        public static /* synthetic */ void getHeight$annotations() {
        }

        public static /* synthetic */ void getWidth$annotations() {
        }
    }

    public CommonRequestBody(DeviceNode device, AppNode appNode, User user, RequestExt requestExt, RequestParam requestParam) {
        k.e(device, "device");
        this.device = device;
        this.app = appNode;
        this.user = user;
        this.ext = requestExt;
        this.request = requestParam;
    }

    public /* synthetic */ CommonRequestBody(DeviceNode deviceNode, AppNode appNode, User user, RequestExt requestExt, RequestParam requestParam, int i2, f fVar) {
        this(deviceNode, (i2 & 2) != 0 ? null : appNode, (i2 & 4) != 0 ? null : user, (i2 & 8) != 0 ? null : requestExt, (i2 & 16) != 0 ? null : requestParam);
    }
}
