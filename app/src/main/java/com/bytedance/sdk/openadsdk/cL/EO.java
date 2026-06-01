package com.bytedance.sdk.openadsdk.cl;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.lEW;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.cl;
import com.ironsource.mediationsdk.metadata.a;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private static volatile HandlerThread EO = lEW.IlO("pag__bus_monitor", 0);
    private static volatile IlO IlO;
    private static Boolean MY;
    private static volatile Handler tV;

    /* JADX INFO: Access modifiers changed from: private */
    public static Handler Cc() {
        if (EO == null || !EO.isAlive()) {
            synchronized (bWL.class) {
                try {
                    if (EO == null || !EO.isAlive()) {
                        EO = lEW.IlO("csj_init_handle", -1);
                        tV = new Handler(EO.getLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (tV == null) {
            synchronized (bWL.class) {
                try {
                    if (tV == null) {
                        tV = new Handler(EO.getLooper());
                    }
                } finally {
                }
            }
        }
        return tV;
    }

    public static void MY(tV tVVar) {
        IlO().IlO(new Cc(tVVar, 0, 1, 0));
    }

    public static void EO(tV tVVar) {
        IlO().IlO(new Cc(tVVar, 0, 0, 1));
    }

    public static IlO IlO() {
        if (IlO == null) {
            synchronized (EO.class) {
                try {
                    if (IlO == null) {
                        IlO = IlO.IlO(new MY() { // from class: com.bytedance.sdk.openadsdk.cl.EO.1
                            @Override // com.bytedance.sdk.openadsdk.cl.MY
                            public Context getContext() {
                                return cl.IlO();
                            }

                            @Override // com.bytedance.sdk.openadsdk.cl.MY
                            public Handler getHandler() {
                                return EO.Cc();
                            }

                            @Override // com.bytedance.sdk.openadsdk.cl.MY
                            public int getOnceLogCount() {
                                int iIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("bus_monitor_config", "once_count", 10);
                                if (iIlO > 100 || iIlO < 5) {
                                    return 10;
                                }
                                return iIlO;
                            }

                            @Override // com.bytedance.sdk.openadsdk.cl.MY
                            public int getOnceLogInterval() {
                                int iIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("bus_monitor_config", "once_interval", 10000);
                                if (iIlO < 10000) {
                                    return 10000;
                                }
                                return iIlO;
                            }

                            @Override // com.bytedance.sdk.openadsdk.cl.MY
                            public HandlerThread getSafeHandlerThread(String str, int i2) {
                                return lEW.IlO(str, i2);
                            }

                            @Override // com.bytedance.sdk.openadsdk.cl.MY
                            public int getUploadIntervalTime() {
                                int iIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("bus_monitor_config", "interval", 43200000);
                                if (iIlO < 3600000) {
                                    return 86400000;
                                }
                                return iIlO;
                            }

                            @Override // com.bytedance.sdk.openadsdk.cl.MY
                            public boolean isMonitorOpen() {
                                if (EO.MY != null) {
                                    return EO.MY.booleanValue();
                                }
                                Boolean unused = EO.MY = Boolean.valueOf(com.bytedance.sdk.openadsdk.AXM.IlO.IlO("bus_monitor_config", a.j, 0) == 1);
                                return EO.MY.booleanValue();
                            }

                            @Override // com.bytedance.sdk.openadsdk.cl.MY
                            public void onMonitorUpload(List<com.bytedance.sdk.openadsdk.cl.MY.IlO> list) {
                                if (list == null || list.isEmpty()) {
                                    return;
                                }
                                for (final com.bytedance.sdk.openadsdk.cl.MY.IlO ilO : list) {
                                    com.bytedance.sdk.openadsdk.ea.EO.IlO();
                                    com.bytedance.sdk.openadsdk.ea.EO.IlO("bus_monitor", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.cl.EO.1.1
                                        @Override // com.bytedance.sdk.openadsdk.ea.MY
                                        public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                                            JSONObject jSONObject = new JSONObject();
                                            try {
                                                jSONObject.put("sdk_version", ilO.MY());
                                                jSONObject.put("scene", ilO.EO());
                                                jSONObject.put("start_count", ilO.tV());
                                                jSONObject.put("success_count", ilO.Cc());
                                                jSONObject.put("fail_count", ilO.vCE());
                                                jSONObject.put("rit", ilO.Bc());
                                                jSONObject.put("tag", ilO.lEW());
                                                jSONObject.put("label", ilO.DmF());
                                                jSONObject.put("mediation", ilO.EV());
                                                jSONObject.put("is_init", ilO.rp());
                                                jSONObject.put("extra", ilO.hp());
                                                return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("bus_monitor").MY(jSONObject.toString());
                                            } catch (Exception e) {
                                                oeT.IlO("BusMonitorUtils", "onMonitorUpload: ", e);
                                                return null;
                                            }
                                        }
                                    });
                                }
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public static void MY() {
        IlO().IlO(true);
    }

    public static void IlO(tV tVVar) {
        IlO().IlO(new Cc(tVVar, 1, 0, 0));
    }
}
