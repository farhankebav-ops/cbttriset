package com.ironsource.mediationsdk.adunit.adapter.internal.listener;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface AdapterAdInteractionListener extends AdapterAdListener {
    void onAdClosed();

    void onAdClosed(Map<String, Object> map);

    void onAdEnded();

    void onAdEnded(Map<String, Object> map);

    void onAdStarted();

    void onAdStarted(Map<String, Object> map);

    void onAdVisible();

    void onAdVisible(Map<String, Object> map);
}
