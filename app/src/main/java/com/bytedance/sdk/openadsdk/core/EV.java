package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import androidx.camera.core.processing.util.a;
import androidx.work.WorkRequest;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.component.utils.wPn;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.pgl.ssdk.ces.out.PglSSConfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV {
    private static final AtomicInteger IlO = new AtomicInteger(0);
    private static final AtomicBoolean MY = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public static void EO() {
        IlO.set(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tV() {
        if (IlO.getAndIncrement() <= 0) {
            mmj.IlO().schedule(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.EV.2
                @Override // java.lang.Runnable
                public void run() {
                    EV.MY(rp.IlO(cl.IlO()));
                }
            }, WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
        }
    }

    public static void MY(final String str) {
        mmj.EO(new com.bytedance.sdk.component.lEW.lEW("ipv6") { // from class: com.bytedance.sdk.openadsdk.core.EV.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectIlO;
                final String strBWL = zLG.bWL();
                com.bytedance.sdk.openadsdk.ea.EO.IlO(0, strBWL);
                com.bytedance.sdk.openadsdk.cl.EO.IlO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.EV.1.1
                    @Override // com.bytedance.sdk.openadsdk.cl.tV
                    public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                        return a.d("ipv6");
                    }
                });
                if (TextUtils.isEmpty(strBWL)) {
                    com.bytedance.sdk.openadsdk.ea.EO.IlO(-1, strBWL, -1, "url is null");
                    com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("ipv6", "", -2, "url is null");
                    com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.EV.1.2
                        @Override // com.bytedance.sdk.openadsdk.cl.tV
                        public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                            return a.d("ipv6");
                        }
                    });
                    return;
                }
                com.bytedance.sdk.component.Bc.MY.tV tVVarMY = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().MY();
                try {
                    tVVarMY.MY(strBWL);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("connect_type", com.bytedance.sdk.component.utils.wPn.IlO(cl.IlO(), 0L));
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("device_id", Long.parseLong(str));
                    }
                    jSONObject.put("header", com.bytedance.sdk.openadsdk.tV.IlO.EO.IlO().MY());
                    if (com.bytedance.sdk.openadsdk.core.settings.hp.aP().IlO(PangleEncryptConstant.CryptDataScene.APP_LOG)) {
                        jSONObjectIlO = PangleEncryptManager.encryptType4(jSONObject, new oeT(PangleEncryptConstant.CryptDataScene.DUAL_EVENT));
                        if (jSONObjectIlO == null || jSONObjectIlO.optInt("cypher") != 4) {
                            vAh.MY(false);
                        } else {
                            vAh.MY(true);
                            tVVarMY.MY("x-pgli18n", "4");
                            tVVarMY.MY("Content-Type", "application/json; charset=utf-8");
                        }
                    } else {
                        jSONObjectIlO = com.bytedance.sdk.component.utils.IlO.IlO(jSONObject);
                        if (EV.MY(jSONObjectIlO)) {
                            tVVarMY.MY("Content-Encoding", "union_sdk_encode");
                        }
                    }
                    if (EV.MY(jSONObjectIlO)) {
                        jSONObject = jSONObjectIlO;
                    }
                    tVVarMY.MY("Content-Type", "application/json; charset=utf-8");
                    tVVarMY.MY("User-Agent", zLG.EO());
                    tVVarMY.IlO(jSONObject);
                    tVVarMY.IlO(6);
                    tVVarMY.IlO("send_i_p_v6");
                    tVVarMY.IlO(new com.bytedance.sdk.component.Bc.IlO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.EV.1.3
                        @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                        public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, com.bytedance.sdk.component.Bc.MY my) {
                            if (my.vCE()) {
                                EV.MY(my.tV(), strBWL);
                                return;
                            }
                            com.bytedance.sdk.openadsdk.ea.EO.IlO(-1, strBWL, my.IlO(), my.MY());
                            com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("ipv6", strBWL, my.IlO(), my.MY());
                            com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.EV.1.3.1
                                @Override // com.bytedance.sdk.openadsdk.cl.tV
                                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                    return a.d("ipv6");
                                }
                            });
                            EV.tV();
                        }

                        @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                        public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, IOException iOException) {
                            if (iOException != null) {
                                com.bytedance.sdk.openadsdk.ea.EO.IlO(-1, strBWL, 1, iOException.getMessage());
                                com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("ipv6", strBWL, -1, iOException.getMessage());
                                com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.EV.1.3.2
                                    @Override // com.bytedance.sdk.openadsdk.cl.tV
                                    public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                        return a.d("ipv6");
                                    }
                                });
                            }
                            EV.tV();
                        }
                    });
                } catch (Exception e) {
                    com.bytedance.sdk.openadsdk.ea.EO.IlO(-1, strBWL, -2, e.getMessage());
                    com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("ipv6", strBWL, -3, e.getMessage());
                    com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.EV.1.4
                        @Override // com.bytedance.sdk.openadsdk.cl.tV
                        public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                            return a.d("ipv6");
                        }
                    });
                    com.bytedance.sdk.component.utils.oeT.EO(a1.a.j(e, new StringBuilder("build ipv6 request failed:")), new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements wPn.IlO {
        private static final AtomicBoolean IlO = new AtomicBoolean(false);
        private static volatile long MY = -1;

        private IlO() {
        }

        public static void IlO() {
            if (IlO.compareAndSet(false, true)) {
                MY = System.currentTimeMillis();
                com.bytedance.sdk.component.utils.wPn.IlO(new IlO(), cl.IlO());
            }
        }

        public void MY() {
            com.bytedance.sdk.component.utils.wPn.IlO(this);
        }

        @Override // com.bytedance.sdk.component.utils.wPn.IlO
        public void IlO(Context context, Intent intent, boolean z2, int i2) {
            if (System.currentTimeMillis() - MY >= 2000 && i2 != 0) {
                EV.EO();
                EV.MY(rp.IlO(cl.IlO()));
                MY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MY(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("cypher") != 4) {
                com.bytedance.sdk.openadsdk.ea.EO.IlO(-1, str2, 1, "cypher type error");
                com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("ipv6", str2, -4, "cypher type error");
                com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.EV.3
                    @Override // com.bytedance.sdk.openadsdk.cl.tV
                    public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                        return a.d("ipv6");
                    }
                });
                return;
            }
            Pair<Integer, String> pairDecryptType4 = PangleEncryptManager.decryptType4(jSONObject.optString("message"));
            if (pairDecryptType4.second != null) {
                JSONObject jSONObject2 = new JSONObject((String) pairDecryptType4.second);
                String strOptString = jSONObject2.optString("ip_type");
                int iHashCode = strOptString.hashCode();
                if (iHashCode != 3239397) {
                    if (iHashCode != 3239399) {
                        if (iHashCode == 1959784951 && strOptString.equals("invalid")) {
                            return;
                        }
                    } else if (strOptString.equals("ipv6")) {
                        if (jSONObject2.has("ip")) {
                            String strOptString2 = jSONObject2.optString("ip");
                            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, strOptString2);
                            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("ttopenadsdk", "key_ipv4");
                            HashMap map = new HashMap();
                            map.put(PglSSConfig.CUSTOMINFO_KEY_IPV6, strOptString2);
                            com.bytedance.sdk.openadsdk.core.DmF.MY.MY().IlO(map);
                            com.bytedance.sdk.openadsdk.ea.EO.IlO(1, str2);
                            com.bytedance.sdk.openadsdk.cl.EO.MY(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.EV.5
                                @Override // com.bytedance.sdk.openadsdk.cl.tV
                                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                    return a.d("ipv6");
                                }
                            });
                            return;
                        }
                        com.bytedance.sdk.openadsdk.ea.EO.IlO(-1, str2, 4, "no ip");
                        com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("ipv6", str2, -6, "no ip");
                        com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.EV.6
                            @Override // com.bytedance.sdk.openadsdk.cl.tV
                            public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                return a.d("ipv6");
                            }
                        });
                        return;
                    }
                } else if (strOptString.equals("ipv4")) {
                    if (jSONObject2.has("ip")) {
                        com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("ttopenadsdk", "key_ipv4", jSONObject2.optString("ip"));
                        com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6);
                        com.bytedance.sdk.openadsdk.ea.EO.IlO(1, str2);
                        com.bytedance.sdk.openadsdk.cl.EO.MY(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.EV.7
                            @Override // com.bytedance.sdk.openadsdk.cl.tV
                            public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                return a.d("ipv6");
                            }
                        });
                        return;
                    }
                    com.bytedance.sdk.openadsdk.ea.EO.IlO(-1, str2, 4, "no ip");
                    com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("ipv6", str2, -6, "no ip");
                    com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.EV.8
                        @Override // com.bytedance.sdk.openadsdk.cl.tV
                        public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                            return a.d("ipv6");
                        }
                    });
                    return;
                }
                com.bytedance.sdk.openadsdk.ea.EO.IlO(-1, str2, 3, "no ip type ");
                com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("ipv6", str2, -7, "no ip type ");
                com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.EV.9
                    @Override // com.bytedance.sdk.openadsdk.cl.tV
                    public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                        return a.d("ipv6");
                    }
                });
                return;
            }
            int iIntValue = ((Integer) pairDecryptType4.first).intValue();
            com.bytedance.sdk.openadsdk.ea.EO.IlO(-1, str2, 2, "decrypt failed ".concat(String.valueOf(iIntValue)));
            com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("ipv6", str2, -5, "decrypt failed ".concat(String.valueOf(iIntValue)));
            com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.EV.4
                @Override // com.bytedance.sdk.openadsdk.cl.tV
                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                    return a.d("ipv6");
                }
            });
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.ea.EO.IlO(-1, str2, 2, "decrypt failed, wrong data ");
            com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("ipv6", str2, -8, "decrypt failed, wrong data ");
            com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.EV.10
                @Override // com.bytedance.sdk.openadsdk.cl.tV
                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                    return a.d("ipv6");
                }
            });
        }
    }

    public static void IlO(String str) {
        AtomicBoolean atomicBoolean = MY;
        if (atomicBoolean.compareAndSet(false, true)) {
            if (!com.bytedance.sdk.component.utils.xF.lEW(cl.IlO())) {
                atomicBoolean.set(false);
            } else {
                IlO.IlO();
                MY(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean MY(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }
}
