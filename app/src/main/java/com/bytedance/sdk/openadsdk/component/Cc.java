package com.bytedance.sdk.openadsdk.component;

import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc implements com.bytedance.sdk.openadsdk.IlO.tV.MY {
    private final PAGAppOpenAdInteractionListener IlO;
    private final AtomicBoolean MY = new AtomicBoolean(false);

    public Cc(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener) {
        this.IlO = pAGAppOpenAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.IlO.tV.MY
    public void EO() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener;
        if (this.MY.getAndSet(true) || (pAGAppOpenAdInteractionListener = this.IlO) == null) {
            return;
        }
        pAGAppOpenAdInteractionListener.onAdDismissed();
    }

    @Override // com.bytedance.sdk.openadsdk.IlO.tV.MY
    public void IlO() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.IlO;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdShowed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.IlO.tV.MY
    public void MY() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener;
        if (this.MY.getAndSet(true) || (pAGAppOpenAdInteractionListener = this.IlO) == null) {
            return;
        }
        pAGAppOpenAdInteractionListener.onAdDismissed();
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
    public void onAdClicked() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.IlO;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdClicked();
        }
    }
}
