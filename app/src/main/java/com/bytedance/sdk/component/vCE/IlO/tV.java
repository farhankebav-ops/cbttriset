package com.bytedance.sdk.component.vCE.IlO;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vAh;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    public static final tV IlO = new tV();

    private boolean EO() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private void MY(IlO ilO, Context context) {
        EO.IlO(context, "context == null");
        EO.IlO(ilO, "AdLogConfig == null");
        EO.IlO(ilO.tV(), "AdLogDepend ==null");
    }

    public void IlO(IlO ilO, Context context) {
        MY(ilO, context);
        lEW.Bc().IlO(context);
        lEW.Bc().IlO(ilO.NV());
        lEW.Bc().MY(ilO.Bc());
        lEW.Bc().EO(ilO.lEW());
        lEW.Bc().IlO(ilO.MY());
        lEW.Bc().tV(ilO.DmF());
        lEW.Bc().Cc(ilO.vCE());
        lEW.Bc().IlO(ilO.IlO() == null ? com.bytedance.sdk.component.vCE.IlO.IlO.IlO.Cc.IlO : ilO.IlO());
        lEW.Bc().MY(ilO.EV());
        lEW.Bc().IlO(ilO.tV());
        lEW.Bc().IlO(ilO.EO());
        lEW.Bc().IlO(ilO.Cc());
        com.bytedance.sdk.component.vCE.IlO.MY.EO.EO.IlO(ilO.hp());
        com.bytedance.sdk.component.vCE.IlO.MY.EO.EO.MY(ilO.rp());
        IlO(ilO);
    }

    public void MY() {
        final Cc ccZPa = lEW.Bc().zPa();
        if (ccZPa == null || lEW.Bc().vCE() == null || ccZPa.tV() == null) {
            return;
        }
        if (lEW.Bc().MY()) {
            if (IlO(lEW.Bc().vCE(), ccZPa)) {
                lEW.Bc().EV();
                return;
            } else if (EO()) {
                ccZPa.tV().execute(new com.bytedance.sdk.component.vCE.IlO.Cc.Cc("stop") { // from class: com.bytedance.sdk.component.vCE.IlO.tV.3
                    @Override // java.lang.Runnable
                    public void run() {
                        tV.this.MY(ccZPa.vCE());
                    }
                });
                return;
            } else {
                MY(ccZPa.vCE());
                return;
            }
        }
        lEW.Bc().EV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(int i2) {
        if (i2 == 0) {
            com.bytedance.sdk.component.vCE.IlO.MY.MY.IlO.MY();
        } else if (i2 == 1) {
            com.bytedance.sdk.component.vCE.IlO.MY.MY.MY.MY();
        }
    }

    private void MY(final com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO) {
        final Cc ccZPa = lEW.Bc().zPa();
        if (ilO == null || ccZPa == null || lEW.Bc().vCE() == null || ccZPa.tV() == null) {
            return;
        }
        if (lEW.Bc().MY()) {
            if (IlO(lEW.Bc().vCE(), ccZPa)) {
                lEW.Bc().IlO(ilO);
                return;
            }
            EO();
            if (EO()) {
                ccZPa.tV().execute(new com.bytedance.sdk.component.vCE.IlO.Cc.Cc("dispatchEvent") { // from class: com.bytedance.sdk.component.vCE.IlO.tV.4
                    @Override // java.lang.Runnable
                    public void run() {
                        tV.this.IlO(ilO, ccZPa.vCE());
                    }
                });
                return;
            } else {
                IlO(ilO, ccZPa.vCE());
                return;
            }
        }
        lEW.Bc().IlO(ilO);
    }

    private void IlO(IlO ilO) {
        Executor executorCc;
        if (Looper.myLooper() != Looper.getMainLooper() && com.bytedance.sdk.component.vCE.IlO.EO.IlO.MY()) {
            com.bytedance.sdk.component.vCE.IlO.EO.IlO.IlO();
            return;
        }
        Cc ccTV = ilO.tV();
        if (ccTV == null || !com.bytedance.sdk.component.vCE.IlO.EO.IlO.MY() || (executorCc = ccTV.Cc()) == null) {
            return;
        }
        executorCc.execute(new Runnable() { // from class: com.bytedance.sdk.component.vCE.IlO.tV.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.vCE.IlO.EO.IlO.IlO();
            }
        });
    }

    public void IlO(boolean z2) {
        lEW.Bc().IlO(z2);
    }

    private boolean IlO(Context context, Cc cc) {
        if (context == null || cc == null) {
            return false;
        }
        if (cc.vCE() == 2) {
            return true;
        }
        if (cc.vCE() == 1) {
            return cc.bWL();
        }
        try {
            return vAh.IlO(context);
        } catch (Throwable th) {
            th.getMessage();
            return true;
        }
    }

    public void IlO() {
        final Cc ccZPa = lEW.Bc().zPa();
        if (ccZPa == null || lEW.Bc().vCE() == null || ccZPa.tV() == null) {
            return;
        }
        if (lEW.Bc().MY()) {
            if (IlO(lEW.Bc().vCE(), ccZPa)) {
                lEW.Bc().DmF();
                return;
            } else if (EO()) {
                ccZPa.tV().execute(new com.bytedance.sdk.component.vCE.IlO.Cc.Cc("start") { // from class: com.bytedance.sdk.component.vCE.IlO.tV.2
                    @Override // java.lang.Runnable
                    public void run() {
                        tV.this.IlO(ccZPa.vCE());
                    }
                });
                return;
            } else {
                IlO(ccZPa.vCE());
                return;
            }
        }
        lEW.Bc().DmF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(int i2) {
        if (i2 == 0) {
            com.bytedance.sdk.component.vCE.IlO.MY.MY.IlO.IlO();
        } else if (i2 == 1) {
            com.bytedance.sdk.component.vCE.IlO.MY.MY.MY.IlO();
        }
    }

    public void IlO(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO) {
        MY(ilO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO, int i2) {
        if (i2 == 0) {
            com.bytedance.sdk.component.vCE.IlO.MY.MY.IlO.IlO(ilO);
        } else if (i2 == 1) {
            com.bytedance.sdk.component.vCE.IlO.MY.MY.MY.IlO(ilO);
        }
    }

    public void IlO(final String str, final List<String> list, final boolean z2, Map<String, String> map, final int i2, final String str2) {
        final Cc ccZPa = lEW.Bc().zPa();
        if (ccZPa == null || lEW.Bc().vCE() == null || ccZPa.tV() == null || !ccZPa.lEW()) {
            return;
        }
        if (ccZPa.vCE() == 1) {
            if (list == null || list.isEmpty()) {
                return;
            }
        } else if (ccZPa.vCE() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
            return;
        }
        if (lEW.Bc().MY() && !IlO(lEW.Bc().vCE(), ccZPa)) {
            if (EO()) {
                ccZPa.tV().execute(new com.bytedance.sdk.component.vCE.IlO.Cc.Cc("trackFailed") { // from class: com.bytedance.sdk.component.vCE.IlO.tV.5
                    @Override // java.lang.Runnable
                    public void run() {
                        tV.this.IlO(str, (List<String>) list, z2, ccZPa.vCE(), i2, str2);
                    }
                });
                return;
            } else {
                IlO(str, list, z2, ccZPa.vCE(), i2, str2);
                return;
            }
        }
        lEW.Bc().IlO(str, list, z2, map, i2, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(String str, List<String> list, boolean z2, int i2, int i8, String str2) {
        if (i2 == 0) {
            com.bytedance.sdk.component.vCE.IlO.MY.MY.IlO.IlO(str, list, z2);
        } else if (i2 == 1) {
            com.bytedance.sdk.component.vCE.IlO.MY.MY.MY.IlO(str, list, z2, i8, str2);
        }
    }

    public void IlO(final String str, final boolean z2) {
        final Cc ccZPa = lEW.Bc().zPa();
        if (ccZPa == null || lEW.Bc().vCE() == null || ccZPa.tV() == null || !ccZPa.lEW() || (ccZPa.vCE() == 0 && TextUtils.isEmpty(str))) {
            return;
        }
        if (lEW.Bc().MY() && !IlO(lEW.Bc().vCE(), ccZPa)) {
            if (EO()) {
                ccZPa.tV().execute(new com.bytedance.sdk.component.vCE.IlO.Cc.Cc("trackFailed") { // from class: com.bytedance.sdk.component.vCE.IlO.tV.6
                    @Override // java.lang.Runnable
                    public void run() {
                        tV.this.IlO(str, ccZPa.vCE(), z2);
                    }
                });
                return;
            } else {
                IlO(str, ccZPa.vCE(), z2);
                return;
            }
        }
        lEW.Bc().IlO(str, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(String str, int i2, boolean z2) {
        if (i2 == 0) {
            com.bytedance.sdk.component.vCE.IlO.MY.MY.IlO.IlO(str);
        } else if (i2 == 1) {
            com.bytedance.sdk.component.vCE.IlO.MY.MY.MY.IlO(str, z2);
        }
    }
}
