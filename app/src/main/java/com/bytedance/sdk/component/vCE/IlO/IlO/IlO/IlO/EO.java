package com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.component.vCE.IlO.lEW;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EO {
    private static int EO = 20;
    private final Context IlO;
    private boolean vCE;
    protected final List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> MY = new ArrayList();
    private boolean tV = false;
    private volatile boolean Cc = false;
    private final Runnable Bc = new Runnable() { // from class: com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.EO.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (EO.this) {
                EO.this.Cc = false;
                if (EO.this.MY.isEmpty()) {
                    EO.this.tV = false;
                    return;
                }
                try {
                    ArrayList arrayList = new ArrayList(EO.this.MY);
                    EO.this.MY.clear();
                    EO.this.tV = false;
                    EO.this.tV(arrayList);
                } catch (OutOfMemoryError unused) {
                }
            }
        }
    };

    public EO(Context context) {
        boolean z2 = false;
        this.vCE = true;
        this.IlO = context;
        try {
            if (lEW.Bc().zPa() != null && lEW.Bc().zPa().zPa()) {
                z2 = true;
            }
            this.vCE = z2;
            EO = lEW.Bc().zPa().cl();
            oeT.IlO("DBInsertMemRepo", "enableOpt:" + this.vCE + ",BATCH_SIZE:" + EO);
        } catch (Throwable unused) {
        }
    }

    public Context Cc() {
        return this.IlO;
    }

    public void EO(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<com.bytedance.sdk.component.vCE.IlO.tV.IlO> it = this.MY.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.vCE.IlO.tV.IlO next = it.next();
                if (next != null) {
                    String strEO = next.EO();
                    if (!TextUtils.isEmpty(strEO) && list.contains(strEO)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            MY();
            th.getMessage();
        }
    }

    public abstract String MY();

    public void tV(List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list) {
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.EO.IlO(Cc(), MY(), list);
    }

    private void IlO() {
        if (!this.tV) {
            com.bytedance.sdk.component.vCE.IlO.Bc.IlO.IlO().postDelayed(this.Bc, com.bytedance.sdk.component.vCE.IlO.Bc.IlO.MY());
            this.tV = true;
        }
        if (this.vCE && this.MY.size() >= EO && !this.Cc) {
            com.bytedance.sdk.component.vCE.IlO.Bc.IlO.IlO().removeCallbacks(this.Bc);
            com.bytedance.sdk.component.vCE.IlO.Bc.IlO.IlO().post(this.Bc);
            this.tV = true;
            this.Cc = true;
        }
    }

    public synchronized void IlO(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO) {
        if (ilO.Bc() != null && !TextUtils.isEmpty(ilO.EO())) {
            this.MY.add(ilO);
            IlO();
        }
    }
}
