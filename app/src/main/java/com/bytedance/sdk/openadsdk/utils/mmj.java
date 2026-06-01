package com.bytedance.sdk.openadsdk.utils;

import android.os.Looper;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.lEW.EO.vCE;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class mmj {
    private static volatile com.bytedance.sdk.component.lEW.EO.vCE Bc;
    private static volatile com.bytedance.sdk.component.lEW.EO.vCE Cc;
    private static volatile com.bytedance.sdk.component.lEW.EO.vCE DmF;
    private static volatile com.bytedance.sdk.component.lEW.EO.vCE EO;
    private static volatile com.bytedance.sdk.component.lEW.EO.vCE EV;
    private static volatile ThreadPoolExecutor IlO;
    private static volatile boolean MY;
    private static volatile com.bytedance.sdk.component.lEW.EO.vCE NV;
    private static volatile com.bytedance.sdk.component.lEW.EO.vCE lEW;
    private static volatile com.bytedance.sdk.component.lEW.EO.vCE tV;
    private static volatile com.bytedance.sdk.component.lEW.EO.vCE vCE;

    static {
        com.bytedance.sdk.component.lEW.EO.EO.IlO(new com.bytedance.sdk.component.lEW.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.utils.mmj.1
            @Override // com.bytedance.sdk.component.lEW.EO.IlO
            public void IlO(com.bytedance.sdk.component.lEW.EO.vCE vce, com.bytedance.sdk.component.lEW.EO.MY my) {
                my.MY();
                new RuntimeException();
            }
        });
        com.bytedance.sdk.component.lEW.EO.EO.IlO(new com.bytedance.sdk.component.lEW.EO.Cc() { // from class: com.bytedance.sdk.openadsdk.utils.mmj.3
            @Override // com.bytedance.sdk.component.lEW.EO.Cc
            public void IlO(final com.bytedance.sdk.component.lEW.EO.vCE vce) {
                if (lMM.IlO || vce == null) {
                    return;
                }
                try {
                    LinkedHashMap<String, com.bytedance.sdk.component.lEW.EO.IlO.IlO> linkedHashMapIlO = vce.IlO();
                    if (linkedHashMapIlO == null || linkedHashMapIlO.size() <= 0) {
                        return;
                    }
                    Iterator<Map.Entry<String, com.bytedance.sdk.component.lEW.EO.IlO.IlO>> it = linkedHashMapIlO.entrySet().iterator();
                    while (it.hasNext()) {
                        final com.bytedance.sdk.component.lEW.EO.IlO.IlO value = it.next().getValue();
                        if (value != null) {
                            com.bytedance.sdk.openadsdk.ea.EO.IlO();
                            com.bytedance.sdk.openadsdk.ea.EO.IlO("pag_thread_pool_state", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.utils.mmj.3.1
                                @Override // com.bytedance.sdk.openadsdk.ea.MY
                                public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("name", value.IlO());
                                        jSONObject.put("times", value.MY());
                                        jSONObject.put("runMaxTime", value.vCE());
                                        jSONObject.put("waitMaxTime", value.Cc());
                                        long jMY = value.MY() == 0 ? 1 : value.MY();
                                        jSONObject.put("avgRunTime", value.tV() / jMY);
                                        jSONObject.put("avgWaitTime", value.EO() / jMY);
                                        jSONObject.put("poolType", vce.MY());
                                    } catch (Exception e) {
                                        com.bytedance.sdk.component.utils.oeT.IlO("ThreadUtils", "run: ", e);
                                    }
                                    return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("pag_thread_pool_state").MY(jSONObject.toString());
                                }
                            });
                        }
                    }
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
        });
        IlO = null;
        MY = false;
    }

    public static boolean Bc() {
        String str = rp() ? "pag_log" : "csj_log";
        String name = Thread.currentThread().getName();
        if (TextUtils.isEmpty(name)) {
            return false;
        }
        return name.startsWith(str);
    }

    public static ExecutorService Cc() {
        return rp() ? DmF() : com.bytedance.sdk.component.lEW.vCE.MY();
    }

    public static com.bytedance.sdk.component.lEW.EO.vCE DmF() {
        com.bytedance.sdk.component.lEW.EO.vCE vce;
        com.bytedance.sdk.component.lEW.EO.vCE vce2 = vCE;
        if (!IlO(vce2)) {
            return vce2;
        }
        synchronized (mmj.class) {
            try {
                if (IlO(vCE)) {
                    try {
                        vCE = IlO("cache", vCE);
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                vce = vCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return vce;
    }

    public static ExecutorService EO() {
        return rp() ? es() : com.bytedance.sdk.component.lEW.vCE.EO();
    }

    public static com.bytedance.sdk.component.lEW.EO.vCE EV() {
        com.bytedance.sdk.component.lEW.EO.vCE vce;
        com.bytedance.sdk.component.lEW.EO.vCE vce2 = NV;
        if (!IlO(vce2)) {
            return vce2;
        }
        synchronized (mmj.class) {
            try {
                if (IlO(NV)) {
                    try {
                        NV = IlO("net", NV);
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                vce = NV;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return vce;
    }

    public static ScheduledExecutorService IlO() {
        return com.bytedance.sdk.component.lEW.vCE.vCE();
    }

    public static ExecutorService MY() {
        return rp() ? cl() : com.bytedance.sdk.component.lEW.vCE.NV();
    }

    public static com.bytedance.sdk.component.lEW.EO.vCE NV() {
        com.bytedance.sdk.component.lEW.EO.vCE vce;
        com.bytedance.sdk.component.lEW.EO.vCE vce2 = DmF;
        if (!IlO(vce2)) {
            return vce2;
        }
        synchronized (mmj.class) {
            try {
                if (IlO(DmF)) {
                    try {
                        DmF = IlO("express", DmF);
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                vce = DmF;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return vce;
    }

    private static ThreadPoolExecutor bWL() {
        com.bytedance.sdk.component.lEW.EO.vCE vce;
        com.bytedance.sdk.component.lEW.EO.vCE vce2 = EO;
        if (!IlO(vce2)) {
            return vce2;
        }
        synchronized (mmj.class) {
            try {
                if (IlO(EO)) {
                    try {
                        EO = IlO("ad", EO);
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                vce = EO;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return vce;
    }

    private static com.bytedance.sdk.component.lEW.EO.vCE cL() {
        com.bytedance.sdk.component.lEW.EO.vCE vce;
        com.bytedance.sdk.component.lEW.EO.vCE vce2 = Bc;
        if (!IlO(vce2)) {
            return vce2;
        }
        synchronized (mmj.class) {
            try {
                if (IlO(Bc)) {
                    try {
                        Bc = IlO("io", Bc);
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                vce = Bc;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return vce;
    }

    private static com.bytedance.sdk.component.lEW.EO.vCE cl() {
        com.bytedance.sdk.component.lEW.EO.vCE vce;
        com.bytedance.sdk.component.lEW.EO.vCE vce2 = lEW;
        if (!IlO(vce2)) {
            return vce2;
        }
        synchronized (mmj.class) {
            try {
                if (IlO(lEW)) {
                    try {
                        lEW = IlO("image", lEW);
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                vce = lEW;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return vce;
    }

    private static com.bytedance.sdk.component.lEW.EO.vCE ea() {
        com.bytedance.sdk.component.lEW.EO.vCE vce;
        com.bytedance.sdk.component.lEW.EO.vCE vce2 = tV;
        if (!IlO(vce2)) {
            return vce2;
        }
        synchronized (mmj.class) {
            try {
                if (IlO(tV)) {
                    try {
                        tV = IlO("log", tV);
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                vce = tV;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return vce;
    }

    private static com.bytedance.sdk.component.lEW.EO.vCE es() {
        com.bytedance.sdk.component.lEW.EO.vCE vce;
        com.bytedance.sdk.component.lEW.EO.vCE vce2 = EV;
        if (!IlO(vce2)) {
            return vce2;
        }
        synchronized (mmj.class) {
            try {
                if (IlO(EV)) {
                    try {
                        EV = IlO("imgdisk", EV);
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                vce = EV;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return vce;
    }

    private static ThreadPoolExecutor hp() {
        int iTs;
        if (IlO == null) {
            synchronized (mmj.class) {
                try {
                    if (IlO == null) {
                        if (com.bytedance.sdk.openadsdk.core.settings.hp.BC()) {
                            iTs = com.bytedance.sdk.openadsdk.core.settings.hp.aP().ts();
                            MY = true;
                        } else {
                            iTs = 4;
                        }
                        IlO = new ThreadPoolExecutor(iTs, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public static ExecutorService lEW() {
        return rp() ? cL() : com.bytedance.sdk.component.lEW.vCE.EO();
    }

    public static boolean rp() {
        if (com.bytedance.sdk.openadsdk.core.settings.hp.BC()) {
            return com.bytedance.sdk.openadsdk.core.settings.hp.aP().gm();
        }
        return true;
    }

    public static ExecutorService tV() {
        return rp() ? ea() : com.bytedance.sdk.component.lEW.vCE.tV();
    }

    public static boolean vCE() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private static com.bytedance.sdk.component.lEW.EO.vCE zPa() {
        com.bytedance.sdk.component.lEW.EO.vCE vce;
        com.bytedance.sdk.component.lEW.EO.vCE vce2 = Cc;
        if (!IlO(vce2)) {
            return vce2;
        }
        synchronized (mmj.class) {
            try {
                if (IlO(Cc)) {
                    try {
                        Cc = IlO("aidl", Cc);
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                vce = Cc;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return vce;
    }

    public static void IlO(Runnable runnable) {
        if (runnable == null || lMM.IlO) {
            return;
        }
        if (vCE()) {
            runnable.run();
        } else {
            com.bytedance.sdk.openadsdk.core.bWL.EO().post(runnable);
        }
    }

    public static void Cc(final com.bytedance.sdk.component.lEW.lEW lew) {
        if (lMM.IlO) {
            return;
        }
        if (rp()) {
            bWL().execute(new com.bytedance.sdk.component.lEW.EO.MY(lew.getName(), lew) { // from class: com.bytedance.sdk.openadsdk.utils.mmj.2
                @Override // java.lang.Runnable
                public void run() {
                    lew.run();
                }
            });
            return;
        }
        ThreadPoolExecutor threadPoolExecutorHp = hp();
        threadPoolExecutorHp.execute(lew);
        if (MY || !com.bytedance.sdk.openadsdk.core.settings.hp.BC()) {
            return;
        }
        MY = true;
        threadPoolExecutorHp.setCorePoolSize(com.bytedance.sdk.openadsdk.core.settings.hp.aP().ts());
    }

    public static void EO(final com.bytedance.sdk.component.lEW.lEW lew) {
        if (lew == null || lMM.IlO) {
            return;
        }
        if (rp()) {
            ea().execute(new com.bytedance.sdk.component.lEW.EO.MY(lew.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.mmj.7
                @Override // java.lang.Runnable
                public void run() {
                    lew.run();
                }
            });
        } else {
            com.bytedance.sdk.component.lEW.vCE.EO(lew);
        }
    }

    public static void MY(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.bWL.EO().removeCallbacks(runnable);
    }

    public static void tV(final com.bytedance.sdk.component.lEW.lEW lew) {
        if (lew == null || lMM.IlO) {
            return;
        }
        if (rp()) {
            bWL().execute(new com.bytedance.sdk.component.lEW.EO.MY(lew.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.mmj.9
                @Override // java.lang.Runnable
                public void run() {
                    lew.run();
                }
            });
        } else {
            com.bytedance.sdk.component.lEW.vCE.Cc(lew);
        }
    }

    public static void MY(final com.bytedance.sdk.component.lEW.lEW lew) {
        if (lMM.IlO) {
            return;
        }
        if (rp()) {
            cL().execute(new com.bytedance.sdk.component.lEW.EO.MY(lew.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.mmj.5
                @Override // java.lang.Runnable
                public void run() {
                    lew.run();
                }
            });
        } else {
            com.bytedance.sdk.component.lEW.vCE.MY(lew);
        }
    }

    public static void IlO(final com.bytedance.sdk.component.lEW.lEW lew) {
        if (lMM.IlO) {
            return;
        }
        if (rp()) {
            DmF().execute(new com.bytedance.sdk.component.lEW.EO.MY(lew.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.mmj.4
                @Override // java.lang.Runnable
                public void run() {
                    lew.run();
                }
            });
        } else {
            com.bytedance.sdk.component.lEW.vCE.IlO(lew);
        }
    }

    public static void EO(final com.bytedance.sdk.component.lEW.lEW lew, int i2) {
        if (lew == null || lMM.IlO) {
            return;
        }
        if (rp()) {
            zPa().execute(new com.bytedance.sdk.component.lEW.EO.MY(lew.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.mmj.10
                @Override // java.lang.Runnable
                public void run() {
                    lew.run();
                }
            });
        } else {
            com.bytedance.sdk.component.lEW.vCE.EO(lew, i2);
        }
    }

    public static void MY(final com.bytedance.sdk.component.lEW.lEW lew, int i2) {
        if (lew == null || lMM.IlO) {
            return;
        }
        if (rp()) {
            com.bytedance.sdk.component.lEW.EO.MY my = new com.bytedance.sdk.component.lEW.EO.MY(lew.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.mmj.8
                @Override // java.lang.Runnable
                public void run() {
                    lew.run();
                }
            };
            my.IlO(i2);
            ea().execute(my);
            return;
        }
        com.bytedance.sdk.component.lEW.vCE.MY(lew, i2);
    }

    public static void IlO(final com.bytedance.sdk.component.lEW.lEW lew, int i2) {
        if (lew == null || lMM.IlO) {
            return;
        }
        if (rp()) {
            com.bytedance.sdk.component.lEW.EO.MY my = new com.bytedance.sdk.component.lEW.EO.MY(lew.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.mmj.6
                @Override // java.lang.Runnable
                public void run() {
                    lew.run();
                }
            };
            my.IlO(i2);
            cL().execute(my);
            return;
        }
        com.bytedance.sdk.component.lEW.vCE.IlO(lew, 5, i2);
    }

    private static vCE.IlO MY(String str) {
        vCE.IlO ilO;
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        ilO = new vCE.IlO();
        str.getClass();
        switch (str) {
            case "express":
                return ilO.IlO(str).IlO(2).MY(4).EO(0).IlO(WorkRequest.MIN_BACKOFF_MILLIS).IlO(true).Cc(-1).tV(10).MY(false);
            case "ad":
                return ilO.IlO(str).IlO(4).MY(4).EO(0).IlO(20000L).IlO(true).Cc(-1).tV(10).MY(false);
            case "io":
                return ilO.IlO(str).IlO(4).MY(10).EO(0).IlO(20000L).IlO(true).Cc(-1).tV(10).MY(false);
            case "log":
                return ilO.IlO(str).IlO(4).MY(6).EO(2).IlO(20000L).IlO(true).Cc(-1).tV(10).MY(false);
            case "net":
                return ilO.IlO(str).IlO(10).MY(10).EO(0).IlO(WorkRequest.MIN_BACKOFF_MILLIS).IlO(true).Cc(-1).tV(10).MY(false);
            case "aidl":
                return ilO.IlO(str).IlO(2).MY(4).EO(0).IlO(WorkRequest.MIN_BACKOFF_MILLIS).IlO(true).Cc(-1).tV(10).MY(false);
            case "cache":
                return ilO.IlO(str).IlO(0).MY(0).EO(0).IlO(5000L).IlO(true).Cc(-1).tV(20).MY(false);
            case "image":
                return ilO.IlO(str).IlO(3).MY(3).EO(0).IlO(20000L).IlO(true).Cc(-1).tV(10).MY(false);
            case "monitor":
                return ilO.IlO(str).IlO(2).MY(2).EO(0).IlO(WorkRequest.MIN_BACKOFF_MILLIS).IlO(true).Cc(-1).tV(10).MY(false);
            case "imgdisk":
                return ilO.IlO(str).IlO(1).MY(2).EO(3).IlO(WorkRequest.MIN_BACKOFF_MILLIS).IlO(true).Cc(-1).tV(10).MY(false);
            default:
                return ilO.IlO(str).IlO(8).MY(16).EO(2).IlO(20000L).IlO(true).Cc(-1).tV(10).MY(false);
        }
    }

    public static void IlO(com.bytedance.sdk.component.lEW.EO.MY my) {
        EV().execute(my);
    }

    private static boolean IlO(com.bytedance.sdk.component.lEW.EO.vCE vce) {
        if (vce != null) {
            return !vce.EO() && com.bytedance.sdk.openadsdk.core.settings.hp.BC();
        }
        return true;
    }

    private static com.bytedance.sdk.component.lEW.EO.vCE IlO(String str, com.bytedance.sdk.component.lEW.EO.vCE vce) {
        vCE.IlO IlO2 = IlO(str);
        if (vce == null) {
            return IlO2.IlO();
        }
        vce.IlO(IlO2);
        return vce;
    }

    private static vCE.IlO IlO(String str) {
        vCE.IlO ilOMY = MY(str);
        try {
            if (com.bytedance.sdk.openadsdk.core.settings.hp.BC()) {
                ilOMY.MY(true);
                JSONObject jSONObjectZTS = com.bytedance.sdk.openadsdk.core.settings.hp.aP().zTS();
                JSONObject jSONObjectOptJSONObject = jSONObjectZTS != null ? jSONObjectZTS.optJSONObject(str) : null;
                if (jSONObjectOptJSONObject != null) {
                    ilOMY.MY(true);
                    if (jSONObjectOptJSONObject.has("coreSize")) {
                        ilOMY.IlO(jSONObjectOptJSONObject.optInt("coreSize"));
                    }
                    if (jSONObjectOptJSONObject.has("maxSize")) {
                        ilOMY.MY(jSONObjectOptJSONObject.optInt("maxSize"));
                    }
                    if (jSONObjectOptJSONObject.has("createSize")) {
                        ilOMY.EO(jSONObjectOptJSONObject.optInt("createSize"));
                    }
                    if (jSONObjectOptJSONObject.has("keepAlive")) {
                        ilOMY.IlO(jSONObjectOptJSONObject.optInt("keepAlive"));
                    }
                    if (jSONObjectOptJSONObject.has("allowCoreTimeOut")) {
                        ilOMY.IlO(jSONObjectOptJSONObject.optBoolean("allowCoreTimeOut"));
                    }
                    if (jSONObjectOptJSONObject.has("reportLogThreshold")) {
                        ilOMY.Cc(jSONObjectOptJSONObject.optInt("reportLogThreshold"));
                    }
                    if (jSONObjectOptJSONObject.has("logTaskCount")) {
                        ilOMY.tV(jSONObjectOptJSONObject.optInt("logTaskCount"));
                    }
                }
            }
            return ilOMY;
        } catch (Throwable th) {
            th.getMessage();
            return ilOMY;
        }
    }
}
