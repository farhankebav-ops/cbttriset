package com.unity3d.ads.beta;

import android.content.Context;
import com.unity3d.services.core.log.DeviceLog;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InitializationConfiguration {
    private final Context context;
    private final Map<String, String> extras;
    private final String gameID;
    private final boolean isTestModeEnabled;
    private final DeviceLog.UnityAdsLogLevel logLevel;
    private final MediationInfo mediationInfo;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private final Context context;
        private Map<String, String> extras;
        private final String gameID;
        private final boolean isTestModeEnabled;
        private DeviceLog.UnityAdsLogLevel logLevel;
        private MediationInfo mediationInfo;

        public Builder(Context context, String gameID, boolean z2) {
            k.e(context, "context");
            k.e(gameID, "gameID");
            this.context = context;
            this.gameID = gameID;
            this.isTestModeEnabled = z2;
            this.logLevel = DeviceLog.UnityAdsLogLevel.INFO;
            this.extras = s.f13639a;
        }

        public final InitializationConfiguration build() {
            return new InitializationConfiguration(this.context, this.gameID, this.isTestModeEnabled, this.logLevel, this.extras, this.mediationInfo);
        }

        public final Builder withExtras(Map<String, String> extras) {
            k.e(extras, "extras");
            this.extras = extras;
            return this;
        }

        public final Builder withLogLevel(DeviceLog.UnityAdsLogLevel logLevel) {
            k.e(logLevel, "logLevel");
            this.logLevel = logLevel;
            return this;
        }

        public final Builder withMediationInfo(MediationInfo mediationInfo) {
            this.mediationInfo = mediationInfo;
            return this;
        }
    }

    public InitializationConfiguration(Context context, String gameID, boolean z2, DeviceLog.UnityAdsLogLevel logLevel, Map<String, String> extras, MediationInfo mediationInfo) {
        k.e(context, "context");
        k.e(gameID, "gameID");
        k.e(logLevel, "logLevel");
        k.e(extras, "extras");
        this.context = context;
        this.gameID = gameID;
        this.isTestModeEnabled = z2;
        this.logLevel = logLevel;
        this.extras = extras;
        this.mediationInfo = mediationInfo;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public final String getGameID() {
        return this.gameID;
    }

    public final DeviceLog.UnityAdsLogLevel getLogLevel() {
        return this.logLevel;
    }

    public final MediationInfo getMediationInfo() {
        return this.mediationInfo;
    }

    public final boolean isTestModeEnabled() {
        return this.isTestModeEnabled;
    }

    public /* synthetic */ InitializationConfiguration(Context context, String str, boolean z2, DeviceLog.UnityAdsLogLevel unityAdsLogLevel, Map map, MediationInfo mediationInfo, int i2, f fVar) {
        this(context, str, z2, (i2 & 8) != 0 ? DeviceLog.UnityAdsLogLevel.INFO : unityAdsLogLevel, (i2 & 16) != 0 ? s.f13639a : map, (i2 & 32) != 0 ? null : mediationInfo);
    }
}
