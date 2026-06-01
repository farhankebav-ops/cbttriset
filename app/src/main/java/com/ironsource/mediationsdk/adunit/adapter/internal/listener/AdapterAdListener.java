package com.ironsource.mediationsdk.adunit.adapter.internal.listener;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface AdapterAdListener {
    void onAdClicked();

    void onAdClicked(Map<String, Object> map);

    void onAdLoadFailed(AdapterErrorType adapterErrorType, int i2, String str);

    void onAdLoadFailed(AdapterErrorType adapterErrorType, int i2, String str, Map<String, Object> map);

    void onAdLoadSuccess();

    void onAdLoadSuccess(Map<String, Object> map);

    void onAdOpened();

    void onAdOpened(Map<String, Object> map);

    void onAdShowFailed(int i2, String str);

    void onAdShowFailed(int i2, String str, Map<String, Object> map);
}
