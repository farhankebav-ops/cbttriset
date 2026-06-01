package com.unity3d.services.core.extensions;

import a1.a;
import com.unity3d.services.UnityAdsConstants;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class StringExtensionsKt {
    public static final String toUnityMessage(String str) {
        return (str == null || str.length() == 0) ? "[Unity Ads] Internal error" : a.l(UnityAdsConstants.Messages.MSG_UNITY_BASE, str);
    }
}
