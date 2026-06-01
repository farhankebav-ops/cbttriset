package com.bytedance.sdk.openadsdk.multipro.aidl.MY;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.mmj;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends IRewardAdInteractionListener.Stub {
    private com.bytedance.sdk.openadsdk.IlO.Cc.IlO IlO;

    public tV(com.bytedance.sdk.openadsdk.IlO.Cc.IlO ilO) {
        this.IlO = ilO;
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdClose() throws RemoteException {
        if (this.IlO == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.MY.tV.3
            @Override // java.lang.Runnable
            public void run() {
                if (tV.this.IlO != null) {
                    tV.this.IlO.MY();
                }
                tV.this.IlO();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdShow() throws RemoteException {
        if (this.IlO == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.MY.tV.1
            @Override // java.lang.Runnable
            public void run() {
                if (tV.this.IlO != null) {
                    tV.this.IlO.IlO();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        if (this.IlO == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.MY.tV.2
            @Override // java.lang.Runnable
            public void run() {
                if (tV.this.IlO != null) {
                    tV.this.IlO.onAdClicked();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onRewardVerify(final boolean z2, final int i2, final String str, final int i8, final String str2) throws RemoteException {
        if (this.IlO == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.MY.tV.4
            @Override // java.lang.Runnable
            public void run() {
                if (tV.this.IlO != null) {
                    tV.this.IlO.IlO(z2, i2, str, i8, str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO() {
        this.IlO = null;
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onDestroy() throws RemoteException {
    }
}
