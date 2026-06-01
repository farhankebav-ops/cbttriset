package com.unity3d.ads.core.data.manager;

import com.unity3d.services.core.properties.SdkProperties;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface SDKPropertiesManager {
    SdkProperties.InitializationState getCurrentInitializationState();

    void setInitializationTime();

    void setInitializationTimeSinceEpoch();

    void setInitializeState(SdkProperties.InitializationState initializationState);

    void setInitialized(boolean z2);
}
