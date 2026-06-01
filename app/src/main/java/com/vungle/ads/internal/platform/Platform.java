package com.vungle.ads.internal.platform;

import androidx.core.util.Consumer;
import com.vungle.ads.internal.model.AdvertisingInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface Platform {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String MANUFACTURER_AMAZON = "Amazon";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String MANUFACTURER_AMAZON = "Amazon";

        private Companion() {
        }
    }

    AdvertisingInfo getAdvertisingInfo();

    String getAppSetId();

    Integer getAppSetIdScope();

    long getBuildTime();

    String getCarrierName();

    long getLastBootTime();

    long getOSInstallationTime();

    long getSDKInstallationTime();

    String getUserAgent();

    void getUserAgentLazy(Consumer<String> consumer);

    float getVolumeLevel();

    boolean isBatterySaverEnabled();

    boolean isProblematicMaliDevice();

    boolean isSdCardPresent();

    boolean isSideLoaded();

    boolean isSilentModeEnabled();

    boolean isSoundEnabled();
}
