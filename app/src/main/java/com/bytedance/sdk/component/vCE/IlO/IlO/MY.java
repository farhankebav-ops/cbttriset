package com.bytedance.sdk.component.vCE.IlO.IlO;

import com.bytedance.sdk.component.vCE.IlO.lEW;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends IlO {
    private final Queue<String> EO;
    private final tV IlO;
    private final EO MY;

    public MY() {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.EO = concurrentLinkedQueue;
        this.IlO = new vCE(concurrentLinkedQueue);
        this.MY = new EO();
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.tV
    public synchronized void IlO(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO, int i2) {
        tV tVVar;
        if (i2 != 5) {
            try {
                if (lEW.Bc().zPa().IlO(lEW.Bc().vCE()) && (tVVar = this.IlO) != null && ilO != null) {
                    tVVar.IlO(ilO, i2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        EO eo = this.MY;
        if (eo != null && ilO != null) {
            eo.IlO(ilO, i2);
        }
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.tV
    public synchronized void IlO(int i2, List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list) {
        try {
            Iterator<com.bytedance.sdk.component.vCE.IlO.tV.IlO> it = list.iterator();
            while (it.hasNext()) {
                this.EO.remove(it.next().EO());
            }
            tV tVVar = this.IlO;
            if (tVVar != null) {
                tVVar.IlO(i2, list);
            }
            EO eo = this.MY;
            if (eo != null) {
                eo.IlO(i2, list);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0019 A[Catch: all -> 0x0051, TryCatch #0 {all -> 0x0051, blocks: (B:3:0x0001, B:5:0x000a, B:7:0x0010, B:64:0x0148, B:67:0x014f, B:68:0x0153, B:70:0x0159, B:74:0x016b, B:11:0x0019, B:13:0x002b, B:15:0x0031, B:16:0x003d, B:18:0x0043, B:21:0x0054, B:22:0x005f, B:24:0x0065, B:26:0x0072, B:28:0x0084, B:29:0x008c, B:30:0x0090, B:32:0x0096, B:33:0x00a4, B:34:0x00af, B:36:0x00b5, B:37:0x00c3, B:38:0x00c8, B:40:0x00d1, B:42:0x00d7, B:43:0x00da, B:45:0x00e2, B:47:0x00e8, B:48:0x00f1, B:50:0x00f7, B:51:0x0105, B:53:0x010e, B:55:0x0114, B:57:0x0122, B:58:0x0126, B:59:0x0131, B:61:0x0137), top: B:79:0x0001 }] */
    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.tV
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> IlO(int r9, int r10, java.util.List<java.lang.String> r11) {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.vCE.IlO.IlO.MY.IlO(int, int, java.util.List):java.util.List");
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.tV
    public synchronized boolean IlO(int i2, boolean z2) {
        if (this.IlO.IlO(i2, z2)) {
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.dY(), 1);
            return true;
        }
        if ((i2 != 1 && i2 != 2) || !this.MY.IlO(i2, z2)) {
            return false;
        }
        com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.lMM(), 1);
        return true;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.tV
    public void IlO(int i2, long j) {
        this.MY.IlO(i2, j);
        this.IlO.IlO(i2, j);
    }
}
