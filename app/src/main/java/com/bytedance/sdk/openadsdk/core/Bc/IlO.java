package com.bytedance.sdk.openadsdk.core.Bc;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.settings.vCE;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static volatile long EO;
    private static volatile IlO IlO;
    private static volatile boolean MY;
    private Handler Cc;
    private final Queue<C0079IlO> tV = new LinkedList();
    private final vCE vCE = cl.tV();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.Bc.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0079IlO {
        private final long IlO;
        private final String MY;

        private C0079IlO(long j, String str) {
            this.IlO = j;
            this.MY = str;
        }
    }

    private IlO() {
    }

    private synchronized boolean MY(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iOeT = this.vCE.oeT();
        long jAXM = this.vCE.AXM();
        if (this.tV.size() <= 0 || this.tV.size() < iOeT) {
            this.tV.offer(new C0079IlO(jCurrentTimeMillis, str));
        } else {
            long jAbs = Math.abs(jCurrentTimeMillis - this.tV.peek().IlO);
            if (jAbs <= jAXM) {
                MY(jAXM - jAbs);
                return true;
            }
            this.tV.poll();
            this.tV.offer(new C0079IlO(jCurrentTimeMillis, str));
        }
        return false;
    }

    public synchronized String EO() {
        String str;
        try {
            HashMap map = new HashMap();
            for (C0079IlO c0079IlO : this.tV) {
                if (map.containsKey(c0079IlO.MY)) {
                    map.put(c0079IlO.MY, Integer.valueOf(((Integer) map.get(c0079IlO.MY)).intValue() + 1));
                } else {
                    map.put(c0079IlO.MY, 1);
                }
            }
            str = "";
            int i2 = Integer.MIN_VALUE;
            for (String str2 : map.keySet()) {
                int iIntValue = ((Integer) map.get(str2)).intValue();
                if (i2 < iIntValue) {
                    str = str2;
                    i2 = iIntValue;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return str;
    }

    public static IlO IlO() {
        if (IlO == null) {
            synchronized (IlO.class) {
                try {
                    if (IlO == null) {
                        IlO = new IlO();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public synchronized boolean IlO(String str) {
        try {
            if (MY(str)) {
                IlO(true);
                IlO(EO);
            } else {
                IlO(false);
            }
        } catch (Throwable th) {
            throw th;
        }
        return MY;
    }

    private synchronized void IlO(long j) {
        try {
            if (this.Cc == null) {
                this.Cc = new Handler(Looper.getMainLooper());
            }
            this.Cc.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Bc.IlO.1
                @Override // java.lang.Runnable
                public void run() {
                    IlO.this.IlO(false);
                }
            }, j);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean MY() {
        return MY;
    }

    private synchronized void MY(long j) {
        EO = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void IlO(boolean z2) {
        MY = z2;
    }
}
