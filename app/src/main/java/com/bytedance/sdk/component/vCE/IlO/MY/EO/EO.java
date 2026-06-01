package com.bytedance.sdk.component.vCE.IlO.MY.EO;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.sdk.component.vCE.IlO.Cc;
import com.bytedance.sdk.component.vCE.IlO.IlO.tV;
import com.bytedance.sdk.component.vCE.IlO.lEW;
import com.ironsource.Y1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends HandlerThread implements Handler.Callback {
    private static int cl = 10;
    private static int es = 200;
    private final int AXM;
    private volatile long Bc;
    private final PriorityBlockingQueue<com.bytedance.sdk.component.vCE.IlO.tV.IlO> Cc;
    private final AtomicInteger DmF;
    private final Object EO;
    private final long EV;
    protected tV IlO;
    private volatile boolean MY;
    private final long NV;
    private final List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> bWL;
    private long cL;
    private final AtomicInteger ea;
    private volatile Handler hp;
    private volatile long lEW;
    private final int oeT;
    private final AtomicInteger rp;
    private com.bytedance.sdk.component.vCE.IlO.MY.EO tV;
    private volatile int vCE;
    private final int xF;
    private final AtomicInteger zPa;

    public EO(PriorityBlockingQueue<com.bytedance.sdk.component.vCE.IlO.tV.IlO> priorityBlockingQueue) {
        super("csj_log");
        this.MY = true;
        this.EO = new Object();
        this.Bc = 0L;
        this.lEW = 0L;
        this.DmF = new AtomicInteger(0);
        this.NV = 5000L;
        this.EV = 5000000000L;
        this.rp = new AtomicInteger(0);
        this.bWL = new ArrayList();
        this.ea = new AtomicInteger(0);
        this.zPa = new AtomicInteger(0);
        this.cL = RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS;
        this.xF = 1;
        this.AXM = 2;
        this.oeT = 3;
        this.Cc = priorityBlockingQueue;
        this.IlO = new com.bytedance.sdk.component.vCE.IlO.IlO.MY();
        if (com.bytedance.sdk.component.vCE.IlO.MY.MY()) {
            return;
        }
        long jEa = lEW.Bc().zPa().ea();
        if (jEa > 0) {
            this.cL = jEa;
        }
    }

    private void Bc() {
        if (this.Cc.size() >= 100) {
            for (int i2 = 0; i2 < 100; i2++) {
                com.bytedance.sdk.component.vCE.IlO.tV.IlO ilOPoll = this.Cc.poll();
                if (!(ilOPoll instanceof com.bytedance.sdk.component.vCE.IlO.tV.MY) && ilOPoll != null) {
                    IlO(ilOPoll);
                }
            }
        }
    }

    private void Cc() {
        while (IlO()) {
            try {
                com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO ilO = com.bytedance.sdk.component.vCE.IlO.MY.tV.tV;
                com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(ilO.lEW(), 1);
                com.bytedance.sdk.component.vCE.IlO.tV.IlO ilOPoll = this.Cc.poll(this.cL, TimeUnit.MILLISECONDS);
                int size = this.Cc.size();
                if (ilOPoll instanceof com.bytedance.sdk.component.vCE.IlO.tV.MY) {
                    IlO(ilOPoll, size);
                } else if (ilOPoll == null) {
                    int iIncrementAndGet = this.DmF.incrementAndGet();
                    com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(ilO.HSR(), 1);
                    if (tV(iIncrementAndGet)) {
                        vCE();
                        return;
                    } else if (iIncrementAndGet < 4) {
                        this.vCE = 1;
                        MY((com.bytedance.sdk.component.vCE.IlO.tV.IlO) null);
                    }
                } else {
                    IlO(ilOPoll);
                    MY(ilOPoll);
                }
            } catch (Throwable th) {
                th.getMessage();
                com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.zLG(), 1);
            }
        }
    }

    private void DmF() {
        try {
            if (this.Cc.size() == 0 && this.hp.hasMessages(11) && IlO()) {
                IlO(false);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void EO() {
        tV();
        com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.mmj(), 1);
        EO(1);
    }

    private void NV() {
        long jNanoTime;
        com.bytedance.sdk.component.vCE.IlO.MY.tV tVVar;
        if (this.hp.hasMessages(11)) {
            DmF();
        } else {
            Cc(1);
        }
        com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO ilO = com.bytedance.sdk.component.vCE.IlO.MY.tV.tV;
        com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(ilO.MY(), 1);
        if (this.vCE == 2) {
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(ilO.Bc(), 1);
            synchronized (this.EO) {
                try {
                    try {
                        long jNanoTime2 = System.nanoTime();
                        this.EO.wait(5000L);
                        jNanoTime = System.nanoTime() - jNanoTime2;
                        tVVar = com.bytedance.sdk.component.vCE.IlO.MY.tV.IlO;
                        if (!tVVar.MY) {
                            boolean z2 = tVVar.EO;
                        }
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }
                    if (jNanoTime < 5000000000L && 5000000000L - jNanoTime >= 50000000) {
                        if (!tVVar.MY && !tVVar.EO) {
                            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(ilO.DM(), 1);
                            EO(2);
                            return;
                        }
                        com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(ilO.EV(), 1);
                        return;
                    }
                    com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(ilO.NV(), 1);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private boolean lEW() {
        if (com.bytedance.sdk.component.vCE.IlO.MY.tV.IlO.MY) {
            return this.vCE == 4 || this.vCE == 7 || this.vCE == 6 || this.vCE == 5 || this.vCE == 2;
        }
        return false;
    }

    private void tV() {
        if (!isAlive()) {
            com.bytedance.sdk.component.vCE.IlO.MY.tV.IlO.tV();
        } else {
            if (IlO()) {
                return;
            }
            EO(6);
        }
    }

    private void vCE() {
        com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.oeT(), 1);
        IlO(false);
        com.bytedance.sdk.component.vCE.IlO.MY.tV.IlO.EO();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        try {
        } catch (Throwable th) {
            th.getMessage();
        }
        if (i2 == 1) {
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.DmF(), 1);
            MY();
            IlO(true);
            Cc();
        } else {
            if (i2 != 2 && i2 != 3) {
                if (i2 == 11) {
                    ArrayList arrayList = new ArrayList(this.bWL);
                    this.bWL.clear();
                    IlO((List<com.bytedance.sdk.component.vCE.IlO.tV.IlO>) arrayList, false, "timeout_dispatch");
                    NV();
                }
                return true;
            }
            EO();
        }
        return true;
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        this.hp = new Handler(getLooper(), this);
        com.bytedance.sdk.component.vCE.IlO.MY.tV.IlO.IlO(this.hp);
        this.hp.sendEmptyMessage(1);
    }

    public static void MY(int i2) {
        es = i2;
    }

    private void MY() {
        long jCl = lEW.Bc().cl();
        if (jCl <= 0) {
            return;
        }
        this.IlO.IlO(Integer.MAX_VALUE, jCl);
    }

    public static void IlO(int i2) {
        cl = i2;
    }

    public void EO(int i2) {
        try {
            boolean zIlO = IlO(i2, com.bytedance.sdk.component.vCE.IlO.MY.tV.IlO.MY);
            if (i2 != 6 && !zIlO) {
                return;
            }
            com.bytedance.sdk.component.vCE.IlO.tV.MY my = new com.bytedance.sdk.component.vCE.IlO.tV.MY();
            my.MY(i2);
            this.Cc.add(my);
            Cc(3);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private void MY(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO) {
        List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> listIlO;
        if (com.bytedance.sdk.component.vCE.IlO.EO.IlO.MY() && lEW.Bc().IlO()) {
            return;
        }
        int i2 = 0;
        if (lEW()) {
            com.bytedance.sdk.component.vCE.IlO.EO.IlO.IlO(this.vCE);
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.rp(), 1);
            if (this.Cc.size() != 0) {
                return;
            }
            if (!this.hp.hasMessages(2)) {
                com.bytedance.sdk.component.vCE.IlO.MY.tV.IlO.MY = false;
                this.lEW = 0L;
                this.Bc = 0L;
                this.ea.set(0);
                this.zPa.set(0);
            } else {
                IlO(false);
                return;
            }
        }
        do {
            boolean zIlO = IlO(this.vCE, com.bytedance.sdk.component.vCE.IlO.MY.tV.IlO.MY);
            com.bytedance.sdk.component.vCE.IlO.EO.IlO.IlO(zIlO, this.vCE, ilO);
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.hp(), 1);
            if (zIlO && (listIlO = this.IlO.IlO(this.vCE, -1, null)) != null) {
                listIlO.size();
                IlO(listIlO);
            } else {
                DmF();
            }
            i2++;
            if (!zIlO) {
                return;
            }
        } while (i2 <= 6);
    }

    private boolean tV(int i2) {
        if (i2 < 4 || this.rp.get() != 0) {
            return false;
        }
        com.bytedance.sdk.component.vCE.IlO.MY.tV tVVar = com.bytedance.sdk.component.vCE.IlO.MY.tV.IlO;
        return (tVVar.MY || tVVar.EO) ? false : true;
    }

    public void IlO(boolean z2) {
        this.MY = z2;
    }

    public boolean IlO() {
        return this.MY;
    }

    public boolean IlO(int i2, boolean z2) {
        Cc ccZPa = lEW.Bc().zPa();
        if (ccZPa == null || !ccZPa.IlO(lEW.Bc().vCE())) {
            return false;
        }
        return this.IlO.IlO(i2, z2);
    }

    public void IlO(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO, boolean z2) {
        if (ilO == null) {
            return;
        }
        ilO.tV();
        if (z2) {
            if (this.hp != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(ilO);
                IlO((List<com.bytedance.sdk.component.vCE.IlO.tV.IlO>) arrayList, true, "ignore_result_dispatch");
                return;
            }
            return;
        }
        this.Cc.add(ilO);
        Cc(2);
    }

    private void Cc(int i2) {
        if (!IlO()) {
            if (this.hp == null) {
                return;
            }
            com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO ilO = com.bytedance.sdk.component.vCE.IlO.MY.tV.tV;
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(ilO.EO(), 1);
            if (this.hp.hasMessages(1)) {
                return;
            }
            if (i2 == 1) {
                com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(ilO.vCE(), 1);
            } else if (i2 == 2) {
                com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(ilO.tV(), 1);
            } else if (i2 == 3) {
                com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(ilO.Cc(), 1);
            }
            this.hp.sendEmptyMessage(1);
            return;
        }
        com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.IlO(), 1);
    }

    private void IlO(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO, int i2) {
        this.DmF.set(0);
        if (i2 == 0) {
            this.vCE = ((com.bytedance.sdk.component.vCE.IlO.tV.MY) ilO).EV();
            if (this.vCE != 6) {
                com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.gQ(), 1);
                MY(ilO);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.vCE.IlO.tV.MY my = (com.bytedance.sdk.component.vCE.IlO.tV.MY) ilO;
        if (my.EV() == 1) {
            this.vCE = 1;
            MY(ilO);
        } else if (my.EV() == 2) {
            Bc();
            this.vCE = 2;
            MY(ilO);
        }
    }

    private void MY(List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list) {
        this.bWL.addAll(list);
        this.bWL.size();
        Cc ccZPa = lEW.Bc().zPa();
        if (ccZPa != null && ccZPa.rp() != null) {
            cl = ccZPa.rp().MY();
        }
        if (this.bWL.size() >= cl) {
            if (this.hp.hasMessages(11)) {
                this.hp.removeMessages(11);
            }
            ArrayList arrayList = new ArrayList(this.bWL);
            this.bWL.clear();
            IlO((List<com.bytedance.sdk.component.vCE.IlO.tV.IlO>) arrayList, false, "max_size_dispatch");
            NV();
            return;
        }
        if (this.Cc.size() == 0) {
            IlO(false);
            if (this.hp.hasMessages(11)) {
                this.hp.removeMessages(11);
            }
            if (this.hp.hasMessages(1)) {
                this.hp.removeMessages(1);
            }
            long jIlO = es;
            if (ccZPa != null && ccZPa.rp() != null) {
                jIlO = ccZPa.rp().IlO();
            }
            this.hp.sendEmptyMessageDelayed(11, jIlO);
            return;
        }
        this.bWL.size();
    }

    private void IlO(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO) {
        this.DmF.set(0);
        com.bytedance.sdk.component.vCE.IlO.MY.tV tVVar = com.bytedance.sdk.component.vCE.IlO.MY.tV.IlO;
        if (tVVar.MY) {
            this.vCE = 5;
        } else if (tVVar.EO) {
            this.vCE = 7;
        } else {
            this.vCE = 4;
        }
        com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.Dxv(), 1);
        this.IlO.IlO(ilO, this.vCE);
        com.bytedance.sdk.component.vCE.IlO.EO.IlO.Bc(ilO);
    }

    private void IlO(List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list, String str) {
        IlO(str);
        IlO(list, false, str);
        NV();
    }

    private void IlO(List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list) {
        if (list.size() != 0) {
            com.bytedance.sdk.component.vCE.IlO.EO.IlO.IlO(list, this.Cc.size());
            if (list.size() <= 1 && !com.bytedance.sdk.component.vCE.IlO.EO.IlO.EO()) {
                com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO = list.get(0);
                if (ilO != null) {
                    if (ilO.Cc() == 1) {
                        IlO(list, "highPriority");
                        return;
                    }
                    if (ilO.tV() == 0 && ilO.Cc() == 2) {
                        if (ilO.MY() == 3) {
                            IlO(list, "version_v3");
                            return;
                        } else {
                            MY(list);
                            return;
                        }
                    }
                    if (ilO.tV() == 1) {
                        IlO(list, "stats");
                        return;
                    } else if (ilO.tV() == 3) {
                        IlO(list, "adType_v3");
                        return;
                    } else {
                        if (ilO.tV() == 2) {
                            IlO(list, Y1.f7807d);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            IlO(list, "batchRead");
            return;
        }
        DmF();
    }

    private void MY(List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list, final boolean z2, final long j) {
        this.rp.incrementAndGet();
        com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.pFe(), 1);
        try {
            HashMap map = new HashMap();
            Iterator<com.bytedance.sdk.component.vCE.IlO.tV.IlO> it = list.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.vCE.IlO.tV.IlO next = it.next();
                int iNV = next == null ? 0 : next.NV();
                if (map.get(Integer.valueOf(iNV)) == null) {
                    map.put(Integer.valueOf(iNV), new ArrayList());
                }
                ((List) map.get(Integer.valueOf(iNV))).add(next);
            }
            for (Integer num : map.keySet()) {
                if (num.intValue() != 0 && lEW.Bc().EO() != null && lEW.Bc().EO().get(num) != null) {
                    lEW.Bc().EO().get(num).IlO(list, new com.bytedance.sdk.component.vCE.IlO.MY.MY() { // from class: com.bytedance.sdk.component.vCE.IlO.MY.EO.EO.3
                        @Override // com.bytedance.sdk.component.vCE.IlO.MY.MY
                        public void IlO(List<IlO> list2) {
                            try {
                                EO.this.rp.decrementAndGet();
                                if (list2 == null || list2.size() == 0) {
                                    return;
                                }
                                int size = list2.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    IlO ilO = list2.get(i2);
                                    if (ilO != null) {
                                        EO.this.IlO(z2, ilO.IlO(), ilO.MY(), j);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                } else {
                    this.tV.IlO(list, new com.bytedance.sdk.component.vCE.IlO.MY.MY() { // from class: com.bytedance.sdk.component.vCE.IlO.MY.EO.EO.2
                        @Override // com.bytedance.sdk.component.vCE.IlO.MY.MY
                        public void IlO(List<IlO> list2) {
                            try {
                                EO.this.rp.decrementAndGet();
                                if (list2 == null || list2.size() == 0) {
                                    return;
                                }
                                int size = list2.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    IlO ilO = list2.get(i2);
                                    if (ilO != null) {
                                        EO.this.IlO(z2, ilO.IlO(), ilO.MY(), j);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.getMessage();
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.zLG(), 1);
            this.rp.decrementAndGet();
        }
    }

    private void IlO(String str) {
        if (this.hp.hasMessages(11)) {
            this.hp.removeMessages(11);
        }
        if (this.bWL.size() != 0) {
            ArrayList arrayList = new ArrayList(this.bWL);
            this.bWL.clear();
            IlO((List<com.bytedance.sdk.component.vCE.IlO.tV.IlO>) arrayList, false, "before_".concat(String.valueOf(str)));
            NV();
            arrayList.size();
        }
    }

    private void IlO(List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list, boolean z2, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.vCE.IlO.EO.IlO.IlO(list, this.vCE, str);
        com.bytedance.sdk.component.vCE.IlO.MY.EO eoLEW = lEW.Bc().lEW();
        this.tV = eoLEW;
        if (eoLEW != null) {
            MY(list, z2, jCurrentTimeMillis);
        } else {
            IlO(list, z2, jCurrentTimeMillis);
        }
    }

    private void IlO(final List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list, final boolean z2, final long j) {
        Cc ccZPa = lEW.Bc().zPa();
        if (ccZPa != null) {
            Executor executorCc = ccZPa.Cc();
            if (list.get(0).Cc() == 1) {
                executorCc = ccZPa.tV();
            }
            if (executorCc == null) {
                return;
            }
            this.rp.incrementAndGet();
            executorCc.execute(new com.bytedance.sdk.component.vCE.IlO.Cc.Cc("csj_log_upload") { // from class: com.bytedance.sdk.component.vCE.IlO.MY.EO.EO.1
                @Override // java.lang.Runnable
                public void run() {
                    EO eo = EO.this;
                    eo.IlO((List<com.bytedance.sdk.component.vCE.IlO.tV.IlO>) list, z2, j, eo.vCE);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list, boolean z2, long j, int i2) {
        EO eo;
        Throwable th;
        MY myIlO;
        MY my;
        try {
            com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO = list.get(0);
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.pFe(), 1);
            try {
                if (ilO.tV() == 0) {
                    myIlO = lEW.Cc().IlO(list);
                    IlO(myIlO, list);
                    if (myIlO != null) {
                        com.bytedance.sdk.component.vCE.IlO.EO.IlO.IlO(list, myIlO.tV);
                    }
                } else {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONArray jSONArray = new JSONArray();
                        Iterator<com.bytedance.sdk.component.vCE.IlO.tV.IlO> it = list.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(it.next().Bc());
                        }
                        jSONObject.put("stats_list", jSONArray);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    myIlO = lEW.Cc().IlO(jSONObject);
                }
                my = myIlO;
                this.rp.decrementAndGet();
                eo = this;
            } catch (Throwable th2) {
                th = th2;
                eo = this;
                th.getMessage();
                com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.zLG(), 1);
                eo.rp.decrementAndGet();
            }
        } catch (Throwable th3) {
            th = th3;
            eo = this;
        }
        try {
            eo.IlO(z2, my, list, j);
        } catch (Throwable th4) {
            th = th4;
            th = th;
            th.getMessage();
            com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.zLG(), 1);
            eo.rp.decrementAndGet();
        }
    }

    private void IlO(MY my, List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list) {
        if (my == null || !my.IlO) {
            return;
        }
        List<Object> listIlO = com.bytedance.sdk.component.vCE.IlO.MY.IlO();
        if (list == null || listIlO == null || listIlO.size() == 0) {
            return;
        }
        for (com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO : list) {
            if (ilO.Cc() == 1) {
                com.bytedance.sdk.component.vCE.IlO.EO.IlO.IlO(ilO);
                com.bytedance.sdk.component.vCE.IlO.EO.IlO.Cc(ilO);
                Iterator<Object> it = listIlO.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(boolean z2, MY my, List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list, long j) {
        if (z2 || my == null) {
            return;
        }
        int i2 = my.MY;
        int i8 = -2;
        if (my.Cc) {
            i2 = -1;
        } else if (i2 < 0) {
            i2 = -2;
        }
        if (i2 == 510 || i2 == 511) {
            i2 = -2;
        }
        if (my.IlO || ((i2 < 500 || i2 >= 509) && i2 <= 513)) {
            i8 = i2;
        }
        if (list != null) {
            list.size();
            this.rp.get();
        }
        IlO(i8, list, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006a A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:5:0x0005, B:8:0x000b, B:55:0x00e4, B:57:0x00e8, B:58:0x00ed, B:18:0x0030, B:20:0x003e, B:24:0x0043, B:26:0x0050, B:28:0x0052, B:30:0x0060, B:31:0x0065, B:32:0x006a, B:34:0x0070, B:36:0x0074, B:38:0x0080, B:39:0x0085, B:41:0x008d, B:42:0x0092, B:43:0x00af, B:45:0x00bd, B:47:0x00bf, B:49:0x00cc, B:51:0x00ce, B:53:0x00dc, B:54:0x00e1, B:61:0x00f4), top: B:65:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:5:0x0005, B:8:0x000b, B:55:0x00e4, B:57:0x00e8, B:58:0x00ed, B:18:0x0030, B:20:0x003e, B:24:0x0043, B:26:0x0050, B:28:0x0052, B:30:0x0060, B:31:0x0065, B:32:0x006a, B:34:0x0070, B:36:0x0074, B:38:0x0080, B:39:0x0085, B:41:0x008d, B:42:0x0092, B:43:0x00af, B:45:0x00bd, B:47:0x00bf, B:49:0x00cc, B:51:0x00ce, B:53:0x00dc, B:54:0x00e1, B:61:0x00f4), top: B:65:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void IlO(int r6, java.util.List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> r7, long r8) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.vCE.IlO.MY.EO.EO.IlO(int, java.util.List, long):void");
    }

    public void IlO(int i2, long j) {
        if (this.hp == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = i2;
        if (i2 == 2) {
            this.hp.sendMessageDelayed(messageObtain, ((long) (((this.ea.incrementAndGet() - 1) % 4) + 1)) * j);
        } else if (i2 == 3) {
            this.hp.sendMessageDelayed(messageObtain, ((long) (((this.zPa.incrementAndGet() - 1) % 4) + 1)) * j);
        }
    }
}
