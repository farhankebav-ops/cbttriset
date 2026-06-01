package com.bytedance.sdk.openadsdk.tV;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.google.mlkit.common.MlKitException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp {
    private static volatile rp IlO;
    private final Handler EO;
    private HandlerThread MY;
    private Map<String, Object> vCE;
    private final Executor tV = Executors.newCachedThreadPool();
    private MY Cc = MY.IlO();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements Serializable, Runnable {
        public Map<String, Object> Cc;
        public oeT EO;
        public String tV;
        public final AtomicInteger IlO = new AtomicInteger(0);
        public final AtomicBoolean MY = new AtomicBoolean(false);
        private final long vCE = SystemClock.elapsedRealtime();

        public IlO(oeT oet, String str, Map<String, Object> map) {
            this.EO = oet;
            this.tV = str;
            this.Cc = map;
        }

        public static IlO IlO(oeT oet, String str, Map<String, Object> map) {
            return new IlO(oet, str, map);
        }

        public void MY() {
            this.IlO.incrementAndGet();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.EO == null || TextUtils.isEmpty(this.tV)) {
                return;
            }
            String str = this.MY.get() ? "dpl_success" : "dpl_failed";
            if (this.Cc == null) {
                this.Cc = new HashMap();
            }
            oeT oet = this.EO;
            if (oet != null && oet.lQ() == 0) {
                Map<String, Object> map = this.Cc;
                oeT oet2 = this.EO;
                map.put("auto_click", Boolean.valueOf((oet2 == null || oet2.NV()) ? false : true));
            }
            this.Cc.put("lifeCycleInit", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.ea.IlO().EO()));
            this.Cc.put("duration", Long.valueOf(SystemClock.elapsedRealtime() - this.vCE));
            EO.IlO(this.EO, this.tV, str, this.Cc);
        }

        public IlO IlO(boolean z2) {
            this.MY.set(z2);
            return this;
        }

        public int IlO() {
            return this.IlO.get();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY {
        public int IlO = MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE;
        public int MY = 6000;

        private MY() {
        }

        public static MY IlO() {
            return new MY();
        }
    }

    private rp() {
        if (this.MY == null) {
            this.MY = com.bytedance.sdk.component.utils.lEW.IlO("OpenAppSuccEvent_HandlerThread", 10);
        }
        this.EO = new Handler(this.MY.getLooper(), new Handler.Callback() { // from class: com.bytedance.sdk.openadsdk.tV.rp.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what != 100) {
                    return true;
                }
                Object obj = message.obj;
                IlO ilO = (obj == null || !(obj instanceof IlO)) ? null : (IlO) obj;
                if (ilO == null) {
                    return true;
                }
                rp.this.MY(ilO);
                return true;
            }
        });
    }

    private void EO(IlO ilO) {
        if (ilO == null) {
            return;
        }
        this.tV.execute(ilO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(IlO ilO) {
        if (ilO == null) {
            return;
        }
        boolean zTV = com.bytedance.sdk.openadsdk.core.ea.IlO().tV();
        boolean zIlO = com.bytedance.sdk.openadsdk.core.ea.IlO().IlO(true);
        if (!zTV && zIlO) {
            IlO(ilO);
            return;
        }
        if (ilO.Cc == null) {
            ilO.Cc = new HashMap();
        }
        ilO.Cc.put("is_background", Boolean.valueOf(zTV));
        ilO.Cc.put("has_focus", Boolean.valueOf(zIlO));
        EO(ilO.IlO(true));
    }

    public static rp IlO() {
        if (IlO == null) {
            synchronized (rp.class) {
                try {
                    if (IlO == null) {
                        IlO = new rp();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public rp IlO(Map<String, Object> map) {
        this.vCE = map;
        return IlO();
    }

    public void IlO(oeT oet, String str) {
        Message messageObtainMessage = this.EO.obtainMessage();
        messageObtainMessage.what = 100;
        messageObtainMessage.obj = IlO.IlO(oet, str, this.vCE);
        messageObtainMessage.sendToTarget();
    }

    private void IlO(IlO ilO) {
        if (ilO == null) {
            return;
        }
        ilO.MY();
        int iIlO = ilO.IlO();
        MY my = this.Cc;
        if (iIlO * my.IlO > my.MY) {
            EO(ilO.IlO(false));
            return;
        }
        Message messageObtainMessage = this.EO.obtainMessage();
        messageObtainMessage.what = 100;
        messageObtainMessage.obj = ilO;
        this.EO.sendMessageDelayed(messageObtainMessage, this.Cc.IlO);
    }
}
