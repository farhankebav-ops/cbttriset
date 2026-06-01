package com.bytedance.sdk.openadsdk.multipro.aidl.IlO;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends IlO {
    private static final Map<String, RemoteCallbackList<IRewardAdInteractionListener>> IlO = Collections.synchronizedMap(new HashMap());
    private static volatile Bc MY;

    public static Bc IlO() {
        if (MY == null) {
            synchronized (Bc.class) {
                try {
                    if (MY == null) {
                        MY = new Bc();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return MY;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeRewardVideoCallback(String str, String str2, boolean z2, int i2, String str3, int i8, String str4) throws RemoteException {
        IlO(str, str2, z2, i2, str3, i8, str4);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iRewardAdInteractionListener);
        IlO.put(str, remoteCallbackList);
    }

    private synchronized void IlO(String str, String str2, boolean z2, int i2, String str3, int i8, String str4) {
        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackListRemove;
        try {
            Map<String, RemoteCallbackList<IRewardAdInteractionListener>> map = IlO;
            if (map != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = map.remove(str);
                } else {
                    remoteCallbackListRemove = map.get(str);
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i9 = 0; i9 < iBeginBroadcast; i9++) {
                        try {
                            IRewardAdInteractionListener iRewardAdInteractionListener = (IRewardAdInteractionListener) remoteCallbackListRemove.getBroadcastItem(i9);
                            if (iRewardAdInteractionListener != null) {
                                if ("onAdShow".equals(str2)) {
                                    iRewardAdInteractionListener.onAdShow();
                                } else if ("onAdClose".equals(str2)) {
                                    iRewardAdInteractionListener.onAdClose();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    iRewardAdInteractionListener.onAdVideoBarClick();
                                } else if ("onRewardVerify".equals(str2)) {
                                    iRewardAdInteractionListener.onRewardVerify(z2, i2, str3, i8, str4);
                                } else if ("recycleRes".equals(str2)) {
                                    iRewardAdInteractionListener.onDestroy();
                                }
                            }
                        } catch (Throwable th) {
                            oeT.IlO("MultiProcess", "reward1 '" + str2 + "'  throws Exception :", th);
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            oeT.IlO("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th2);
        }
    }
}
