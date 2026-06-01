package org.chromium.net;

import java.util.Date;
import java.util.Set;
import org.chromium.net.CronetEngine;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ICronetEngineBuilder {
    public abstract ICronetEngineBuilder addPublicKeyPins(String str, Set<byte[]> set, boolean z2, Date date);

    public abstract ICronetEngineBuilder addQuicHint(String str, int i2, int i8);

    public abstract ExperimentalCronetEngine build();

    public abstract ICronetEngineBuilder enableHttp2(boolean z2);

    public abstract ICronetEngineBuilder enableHttpCache(int i2, long j);

    public abstract ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean z2);

    public abstract ICronetEngineBuilder enableQuic(boolean z2);

    public abstract ICronetEngineBuilder enableSdch(boolean z2);

    public abstract String getDefaultUserAgent();

    public abstract ICronetEngineBuilder setExperimentalOptions(String str);

    public abstract ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader libraryLoader);

    public abstract ICronetEngineBuilder setStoragePath(String str);

    public abstract ICronetEngineBuilder setUserAgent(String str);

    public ICronetEngineBuilder enableBrotli(boolean z2) {
        return this;
    }

    public ICronetEngineBuilder enableNetworkQualityEstimator(boolean z2) {
        return this;
    }

    public ICronetEngineBuilder setThreadPriority(int i2) {
        return this;
    }
}
