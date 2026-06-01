package com.bytedance.sdk.openadsdk.multipro.aidl.IlO;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener;
import com.ironsource.Mf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends IlO {
    private static final Map<String, RemoteCallbackList<IAppOpenAdInteractionListener>> IlO = Collections.synchronizedMap(new HashMap());
    private static volatile MY MY;

    public static MY IlO() {
        if (MY == null) {
            synchronized (MY.class) {
                try {
                    if (MY == null) {
                        MY = new MY();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return MY;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeAppOpenAdCallback(String str, String str2) throws RemoteException {
        IlO(str, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerAppOpenAdListener(String str, IAppOpenAdInteractionListener iAppOpenAdInteractionListener) throws RemoteException {
        RemoteCallbackList<IAppOpenAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iAppOpenAdInteractionListener);
        IlO.put(str, remoteCallbackList);
    }

    private synchronized void IlO(String str, String str2) {
        RemoteCallbackList<IAppOpenAdInteractionListener> remoteCallbackListRemove;
        try {
            Map<String, RemoteCallbackList<IAppOpenAdInteractionListener>> map = IlO;
            if (map != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = map.remove(str);
                } else {
                    remoteCallbackListRemove = map.get(str);
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
                        try {
                            IAppOpenAdInteractionListener iAppOpenAdInteractionListener = (IAppOpenAdInteractionListener) remoteCallbackListRemove.getBroadcastItem(i2);
                            if (iAppOpenAdInteractionListener != null) {
                                if ("onAdShow".equals(str2)) {
                                    iAppOpenAdInteractionListener.onAdShow();
                                } else if (Mf.f7244f.equals(str2)) {
                                    iAppOpenAdInteractionListener.onAdClicked();
                                } else if ("onAdSkip".equals(str2)) {
                                    iAppOpenAdInteractionListener.onAdSkip();
                                } else if ("onAdTimeOver".equals(str2)) {
                                    iAppOpenAdInteractionListener.onAdTimeOver();
                                } else if ("recycleRes".equals(str2)) {
                                    iAppOpenAdInteractionListener.onDestroy();
                                }
                            }
                        } catch (Throwable th) {
                            oeT.IlO("MultiProcess", "appOpenAd2 method " + str2 + " throws Exception :", th);
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            oeT.IlO("MultiProcess", "appOpenAd1 method " + str2 + " throws Exception :", th2);
        }
    }
}
