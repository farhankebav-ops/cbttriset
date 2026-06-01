package com.ironsource.mediationsdk.adunit.adapter.internal.listener;

import android.view.View;
import android.widget.FrameLayout;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface AdapterAdViewListener extends AdapterAdListener {
    void onAdLeftApplication();

    void onAdLeftApplication(Map<String, Object> map);

    void onAdLoadSuccess(View view, FrameLayout.LayoutParams layoutParams);

    void onAdLoadSuccess(View view, FrameLayout.LayoutParams layoutParams, Map<String, Object> map);

    void onAdScreenDismissed();

    void onAdScreenDismissed(Map<String, Object> map);

    void onAdScreenPresented();

    void onAdScreenPresented(Map<String, Object> map);
}
