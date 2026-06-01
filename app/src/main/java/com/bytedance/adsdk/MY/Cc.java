package com.bytedance.adsdk.MY;

import a1.a;
import android.content.Context;
import android.os.Trace;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    private static int Bc = 0;
    private static String[] Cc = null;
    private static com.bytedance.adsdk.MY.tV.vCE DmF = null;
    private static boolean EO = true;
    private static volatile com.bytedance.adsdk.MY.tV.lEW EV = null;
    public static boolean IlO = false;
    private static boolean MY = false;
    private static com.bytedance.adsdk.MY.tV.Cc NV = null;
    private static int lEW = 0;
    private static volatile com.bytedance.adsdk.MY.tV.Bc rp = null;
    private static boolean tV = true;
    private static long[] vCE;

    public static void IlO(String str) {
        if (MY) {
            int i2 = Bc;
            if (i2 == 20) {
                lEW++;
                return;
            }
            Cc[i2] = str;
            vCE[i2] = System.nanoTime();
            Trace.beginSection(str);
            Bc++;
        }
    }

    public static float MY(String str) {
        int i2 = lEW;
        if (i2 > 0) {
            lEW = i2 - 1;
            return 0.0f;
        }
        if (!MY) {
            return 0.0f;
        }
        int i8 = Bc - 1;
        Bc = i8;
        if (i8 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(Cc[i8])) {
            throw new IllegalStateException(a.r(a.y("Unbalanced trace call ", str, ". Expected "), Cc[Bc], "."));
        }
        Trace.endSection();
        return (System.nanoTime() - vCE[Bc]) / 1000000.0f;
    }

    public static com.bytedance.adsdk.MY.tV.lEW IlO(Context context) {
        com.bytedance.adsdk.MY.tV.lEW lew;
        com.bytedance.adsdk.MY.tV.lEW lew2 = EV;
        if (lew2 != null) {
            return lew2;
        }
        synchronized (com.bytedance.adsdk.MY.tV.lEW.class) {
            try {
                lew = EV;
                if (lew == null) {
                    com.bytedance.adsdk.MY.tV.Bc bcMY = MY(context);
                    com.bytedance.adsdk.MY.tV.vCE my = DmF;
                    if (my == null) {
                        my = new com.bytedance.adsdk.MY.tV.MY();
                    }
                    lew = new com.bytedance.adsdk.MY.tV.lEW(bcMY, my);
                    EV = lew;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return lew;
    }

    public static boolean IlO() {
        return tV;
    }

    public static com.bytedance.adsdk.MY.tV.Bc MY(Context context) {
        com.bytedance.adsdk.MY.tV.Bc bc;
        if (!EO) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        com.bytedance.adsdk.MY.tV.Bc bc2 = rp;
        if (bc2 != null) {
            return bc2;
        }
        synchronized (com.bytedance.adsdk.MY.tV.Bc.class) {
            try {
                bc = rp;
                if (bc == null) {
                    com.bytedance.adsdk.MY.tV.Cc cc = NV;
                    if (cc == null) {
                        cc = new com.bytedance.adsdk.MY.tV.Cc() { // from class: com.bytedance.adsdk.MY.Cc.1
                            @Override // com.bytedance.adsdk.MY.tV.Cc
                            public File IlO() {
                                return new File(applicationContext.getCacheDir(), "lottie_network_cache");
                            }
                        };
                    }
                    bc = new com.bytedance.adsdk.MY.tV.Bc(cc);
                    rp = bc;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bc;
    }
}
