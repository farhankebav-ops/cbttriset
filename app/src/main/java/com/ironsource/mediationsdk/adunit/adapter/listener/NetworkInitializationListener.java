package com.ironsource.mediationsdk.adunit.adapter.listener;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface NetworkInitializationListener {
    void onInitFailed(int i2, String str);

    void onInitFailed(int i2, String str, Map<String, Object> map);

    void onInitSuccess();

    void onInitSuccess(Map<String, Object> map);
}
