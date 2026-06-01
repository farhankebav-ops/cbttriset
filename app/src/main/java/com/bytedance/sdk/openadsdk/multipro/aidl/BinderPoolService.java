package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.DmF;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.settings.hp;
import com.bytedance.sdk.openadsdk.multipro.aidl.IlO.Bc;
import com.bytedance.sdk.openadsdk.multipro.aidl.IlO.Cc;
import com.bytedance.sdk.openadsdk.multipro.aidl.IlO.tV;
import com.bytedance.sdk.openadsdk.multipro.aidl.IlO.vCE;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class BinderPoolService extends Service {
    private static boolean EO;
    public static volatile boolean IlO;
    private final Binder MY = new IlO();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO extends IBinderPool.Stub {
        @Override // com.bytedance.sdk.openadsdk.IBinderPool
        public IBinder queryBinder(int i2) throws RemoteException {
            if (i2 == 0) {
                return Bc.IlO();
            }
            if (i2 == 1) {
                return Cc.IlO();
            }
            if (i2 == 4) {
                return com.bytedance.sdk.openadsdk.multipro.aidl.IlO.EO.IlO();
            }
            if (i2 == 5) {
                return vCE.MY();
            }
            if (i2 == 6) {
                return tV.IlO();
            }
            if (i2 != 7) {
                return null;
            }
            return com.bytedance.sdk.openadsdk.multipro.aidl.IlO.MY.IlO();
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return this.MY;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        cl.MY(getApplicationContext());
        IlO = true;
        if (!EO) {
            DmF.MY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService.1
                @Override // java.lang.Runnable
                public void run() {
                    hp.aP().IlO(BinderPoolService.this.getApplicationContext());
                }
            });
        }
        EO = true;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
