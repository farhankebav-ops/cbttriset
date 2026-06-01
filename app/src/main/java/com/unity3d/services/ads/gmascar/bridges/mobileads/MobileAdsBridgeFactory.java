package com.unity3d.services.ads.gmascar.bridges.mobileads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class MobileAdsBridgeFactory {
    public MobileAdsBridgeBase createMobileAdsBridge() {
        MobileAdsBridge mobileAdsBridge = new MobileAdsBridge();
        if (mobileAdsBridge.exists()) {
            return mobileAdsBridge;
        }
        return null;
    }
}
