package com.bytedance.sdk.openadsdk.multipro.aidl.MY;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.EO.NV;
import com.bytedance.sdk.openadsdk.IDislikeClosedListener;
import com.bytedance.sdk.openadsdk.core.EO.Bc;
import com.bytedance.sdk.openadsdk.utils.mmj;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends IDislikeClosedListener.Stub {
    private final Bc.IlO IlO;
    private final String MY;

    public MY(String str, Bc.IlO ilO) {
        this.MY = str;
        this.IlO = ilO;
    }

    @Override // com.bytedance.sdk.openadsdk.IDislikeClosedListener
    public void onItemClickClosed() throws RemoteException {
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.MY.MY.1
            @Override // java.lang.Runnable
            public void run() {
                if (MY.this.IlO != null) {
                    MY.this.IlO.IlO();
                    NV.IlO(6, MY.this.MY);
                }
            }
        });
    }
}
