package com.unity3d.services.ads.gmascar.bridges.mobileads;

import android.content.Context;
import com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IMobileAdsBridge {
    ScarAdapterVersion getAdapterVersion(int i2);

    Object getInitializationStatus();

    int getVersionCodeIndex();

    String getVersionMethodName();

    String getVersionString();

    void initialize(Context context, Object obj);

    boolean shouldInitialize();
}
