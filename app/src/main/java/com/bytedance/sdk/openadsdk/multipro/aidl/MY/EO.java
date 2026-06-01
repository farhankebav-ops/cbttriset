package com.bytedance.sdk.openadsdk.multipro.aidl.MY;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.mmj;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends IFullScreenVideoAdInteractionListener.Stub {
    private com.bytedance.sdk.openadsdk.IlO.EO.MY IlO;

    public EO(com.bytedance.sdk.openadsdk.IlO.EO.MY my) {
        this.IlO = my;
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdClose() throws RemoteException {
        if (this.IlO == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.MY.EO.3
            @Override // java.lang.Runnable
            public void run() {
                if (EO.this.IlO != null) {
                    EO.this.IlO.MY();
                }
                EO.this.IlO();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdShow() throws RemoteException {
        if (this.IlO == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.MY.EO.1
            @Override // java.lang.Runnable
            public void run() {
                if (EO.this.IlO != null) {
                    EO.this.IlO.IlO();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        if (this.IlO == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.MY.EO.2
            @Override // java.lang.Runnable
            public void run() {
                if (EO.this.IlO != null) {
                    EO.this.IlO.onAdClicked();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO() {
        this.IlO = null;
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onDestroy() throws RemoteException {
    }
}
