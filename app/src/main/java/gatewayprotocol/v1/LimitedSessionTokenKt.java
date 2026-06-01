package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.ClientInfoOuterClass;
import gatewayprotocol.v1.UniversalRequestOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LimitedSessionTokenKt {
    public static final LimitedSessionTokenKt INSTANCE = new LimitedSessionTokenKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final UniversalRequestOuterClass.LimitedSessionToken.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(UniversalRequestOuterClass.LimitedSessionToken.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(UniversalRequestOuterClass.LimitedSessionToken.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ UniversalRequestOuterClass.LimitedSessionToken _build() {
            UniversalRequestOuterClass.LimitedSessionToken limitedSessionTokenBuild = this._builder.build();
            kotlin.jvm.internal.k.d(limitedSessionTokenBuild, "_builder.build()");
            return limitedSessionTokenBuild;
        }

        public final void clearCustomMediationName() {
            this._builder.clearCustomMediationName();
        }

        public final void clearDeviceMake() {
            this._builder.clearDeviceMake();
        }

        public final void clearDeviceModel() {
            this._builder.clearDeviceModel();
        }

        public final void clearGameId() {
            this._builder.clearGameId();
        }

        public final void clearIdfi() {
            this._builder.clearIdfi();
        }

        public final void clearMediationProvider() {
            this._builder.clearMediationProvider();
        }

        public final void clearMediationVersion() {
            this._builder.clearMediationVersion();
        }

        public final void clearOsVersion() {
            this._builder.clearOsVersion();
        }

        public final void clearPlatform() {
            this._builder.clearPlatform();
        }

        public final void clearSdkVersion() {
            this._builder.clearSdkVersion();
        }

        public final void clearSdkVersionName() {
            this._builder.clearSdkVersionName();
        }

        public final void clearSessionId() {
            this._builder.clearSessionId();
        }

        public final String getCustomMediationName() {
            String customMediationName = this._builder.getCustomMediationName();
            kotlin.jvm.internal.k.d(customMediationName, "_builder.getCustomMediationName()");
            return customMediationName;
        }

        public final String getDeviceMake() {
            String deviceMake = this._builder.getDeviceMake();
            kotlin.jvm.internal.k.d(deviceMake, "_builder.getDeviceMake()");
            return deviceMake;
        }

        public final String getDeviceModel() {
            String deviceModel = this._builder.getDeviceModel();
            kotlin.jvm.internal.k.d(deviceModel, "_builder.getDeviceModel()");
            return deviceModel;
        }

        public final String getGameId() {
            String gameId = this._builder.getGameId();
            kotlin.jvm.internal.k.d(gameId, "_builder.getGameId()");
            return gameId;
        }

        public final String getIdfi() {
            String idfi = this._builder.getIdfi();
            kotlin.jvm.internal.k.d(idfi, "_builder.getIdfi()");
            return idfi;
        }

        public final ClientInfoOuterClass.MediationProvider getMediationProvider() {
            ClientInfoOuterClass.MediationProvider mediationProvider = this._builder.getMediationProvider();
            kotlin.jvm.internal.k.d(mediationProvider, "_builder.getMediationProvider()");
            return mediationProvider;
        }

        public final int getMediationProviderValue() {
            return this._builder.getMediationProviderValue();
        }

        public final String getMediationVersion() {
            String mediationVersion = this._builder.getMediationVersion();
            kotlin.jvm.internal.k.d(mediationVersion, "_builder.getMediationVersion()");
            return mediationVersion;
        }

        public final String getOsVersion() {
            String osVersion = this._builder.getOsVersion();
            kotlin.jvm.internal.k.d(osVersion, "_builder.getOsVersion()");
            return osVersion;
        }

        public final ClientInfoOuterClass.Platform getPlatform() {
            ClientInfoOuterClass.Platform platform = this._builder.getPlatform();
            kotlin.jvm.internal.k.d(platform, "_builder.getPlatform()");
            return platform;
        }

        public final int getPlatformValue() {
            return this._builder.getPlatformValue();
        }

        public final int getSdkVersion() {
            return this._builder.getSdkVersion();
        }

        public final String getSdkVersionName() {
            String sdkVersionName = this._builder.getSdkVersionName();
            kotlin.jvm.internal.k.d(sdkVersionName, "_builder.getSdkVersionName()");
            return sdkVersionName;
        }

        public final ByteString getSessionId() {
            ByteString sessionId = this._builder.getSessionId();
            kotlin.jvm.internal.k.d(sessionId, "_builder.getSessionId()");
            return sessionId;
        }

        public final boolean hasCustomMediationName() {
            return this._builder.hasCustomMediationName();
        }

        public final boolean hasMediationVersion() {
            return this._builder.hasMediationVersion();
        }

        public final boolean hasSessionId() {
            return this._builder.hasSessionId();
        }

        public final void setCustomMediationName(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setCustomMediationName(value);
        }

        public final void setDeviceMake(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setDeviceMake(value);
        }

        public final void setDeviceModel(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setDeviceModel(value);
        }

        public final void setGameId(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setGameId(value);
        }

        public final void setIdfi(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setIdfi(value);
        }

        public final void setMediationProvider(ClientInfoOuterClass.MediationProvider value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setMediationProvider(value);
        }

        public final void setMediationProviderValue(int i2) {
            this._builder.setMediationProviderValue(i2);
        }

        public final void setMediationVersion(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setMediationVersion(value);
        }

        public final void setOsVersion(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setOsVersion(value);
        }

        public final void setPlatform(ClientInfoOuterClass.Platform value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setPlatform(value);
        }

        public final void setPlatformValue(int i2) {
            this._builder.setPlatformValue(i2);
        }

        public final void setSdkVersion(int i2) {
            this._builder.setSdkVersion(i2);
        }

        public final void setSdkVersionName(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setSdkVersionName(value);
        }

        public final void setSessionId(ByteString value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setSessionId(value);
        }

        private Dsl(UniversalRequestOuterClass.LimitedSessionToken.Builder builder) {
            this._builder = builder;
        }
    }

    private LimitedSessionTokenKt() {
    }
}
