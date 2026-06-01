package com.bytedance.sdk.component.adexpress.IlO.MY;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.IlO.EO.IlO;
import com.bytedance.sdk.component.utils.vAh;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ironsource.C2300e4;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends EO {
    private static File IlO;
    private static volatile Cc MY;
    private AtomicBoolean EO = new AtomicBoolean(true);
    private AtomicBoolean tV = new AtomicBoolean(false);
    private boolean Cc = false;
    private AtomicBoolean vCE = new AtomicBoolean(false);
    private AtomicInteger Bc = new AtomicInteger(0);
    private AtomicLong lEW = new AtomicLong();

    private Cc() {
        NV();
    }

    private void EV() {
        if (this.Bc.getAndSet(0) <= 0 || System.currentTimeMillis() - this.lEW.get() <= TTAdConstant.AD_MAX_EVENT_TIME) {
            return;
        }
        Bc();
    }

    public static Cc MY() {
        if (MY == null) {
            synchronized (Cc.class) {
                try {
                    if (MY == null) {
                        MY = new Cc();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return MY;
    }

    private void NV() {
        com.bytedance.sdk.component.adexpress.tV.tV.MY(new com.bytedance.sdk.component.lEW.lEW(C2300e4.a.f8295f) { // from class: com.bytedance.sdk.component.adexpress.IlO.MY.Cc.1
            @Override // java.lang.Runnable
            public void run() {
                lEW.IlO();
                Cc.this.EO.set(false);
                Cc.this.tV();
                Cc.this.Bc();
                if (com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO() == null || !vAh.IlO(com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO().MY()) || com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO() == null) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO().tV();
            }
        }, 10);
    }

    public static File lEW() {
        if (IlO == null) {
            try {
                File file = new File(new File(tV.IlO(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                IlO = file;
            } catch (Throwable unused) {
            }
        }
        return IlO;
    }

    public void Bc() {
        IlO(false);
    }

    public boolean Cc() {
        return this.Cc;
    }

    public void DmF() {
        this.vCE.set(true);
        this.Cc = false;
        this.tV.set(false);
    }

    public void EO() {
        NV();
    }

    public void tV() {
        com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilOMY = lEW.MY();
        if (ilOMY == null || !ilOMY.lEW()) {
            return;
        }
        boolean zIlO = IlO(ilOMY);
        if (!zIlO) {
            lEW.tV();
        }
        this.Cc = zIlO;
    }

    public com.bytedance.sdk.component.adexpress.IlO.EO.IlO vCE() {
        return lEW.MY();
    }

    public boolean IlO(com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO) {
        if (ilO == null) {
            return false;
        }
        return IlO(ilO.IlO()) || IlO(ilO.Cc()) || IlO(ilO.vCE());
    }

    @Override // com.bytedance.sdk.component.adexpress.IlO.MY.EO
    public File IlO() {
        return lEW();
    }

    public void IlO(boolean z2) {
        List<IlO.C0049IlO> listIlO;
        boolean z7;
        if (this.EO.get()) {
            return;
        }
        try {
            if (this.tV.get()) {
                if (z2) {
                    this.Bc.getAndIncrement();
                    return;
                }
                return;
            }
            boolean z8 = true;
            this.tV.set(true);
            com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilOCc = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO().Cc();
            com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilOMY = lEW.MY();
            if (ilOCc != null && ilOCc.lEW()) {
                if (!lEW.MY(ilOCc)) {
                    this.tV.set(false);
                    this.lEW.set(System.currentTimeMillis());
                    return;
                }
                if (com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO() != null) {
                    com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO().EO().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.IlO.MY.Cc.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().MY();
                        }
                    });
                }
                lEW.IlO(ilOCc);
                boolean zIlO = (ilOCc.Cc() == null || TextUtils.isEmpty(ilOCc.Cc().IlO())) ? false : IlO(ilOCc.Cc().IlO());
                if (ilOCc.IlO().size() != 0) {
                    listIlO = IlO(ilOCc, ilOMY);
                    z7 = listIlO != null;
                } else {
                    listIlO = null;
                    z7 = zIlO;
                }
                if (!zIlO) {
                    List<IlO.C0049IlO> listMY = MY(ilOCc, ilOMY);
                    if (listIlO == null || listMY == null) {
                        listIlO = listMY;
                    } else {
                        listIlO.addAll(listMY);
                    }
                    if (listMY == null) {
                        z8 = false;
                    }
                    if (listMY == null) {
                        this.tV.set(false);
                    }
                    z7 = z8;
                }
                if (z7 && IlO(ilOCc)) {
                    lEW.IlO(ilOCc);
                    lEW.EO();
                    MY(listIlO);
                }
                tV();
                this.tV.set(false);
                this.lEW.set(System.currentTimeMillis());
                EV();
                return;
            }
            this.tV.set(false);
            IlO(109);
        } catch (Throwable unused) {
        }
    }

    public void MY(boolean z2) {
        this.vCE.set(z2);
    }
}
