package com.bytedance.sdk.openadsdk.multipro.aidl.MY;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.mmj;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends IAppOpenAdInteractionListener.Stub {
    private com.bytedance.sdk.openadsdk.IlO.tV.MY IlO;

    public IlO(com.bytedance.sdk.openadsdk.IlO.tV.MY my) {
        this.IlO = my;
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdClicked() throws RemoteException {
        if (this.IlO == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.MY.IlO.2
            @Override // java.lang.Runnable
            public void run() {
                if (IlO.this.IlO != null) {
                    IlO.this.IlO.onAdClicked();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdShow() throws RemoteException {
        if (this.IlO == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.MY.IlO.1
            @Override // java.lang.Runnable
            public void run() {
                if (IlO.this.IlO != null) {
                    IlO.this.IlO.IlO();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdSkip() throws RemoteException {
        if (this.IlO == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.MY.IlO.3
            @Override // java.lang.Runnable
            public void run() {
                if (IlO.this.IlO != null) {
                    IlO.this.IlO.MY();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdTimeOver() throws RemoteException {
        if (this.IlO == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.MY.IlO.4
            @Override // java.lang.Runnable
            public void run() {
                if (IlO.this.IlO != null) {
                    IlO.this.IlO.EO();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onDestroy() throws RemoteException {
        IlO();
    }

    private void IlO() {
        this.IlO = null;
    }
}
