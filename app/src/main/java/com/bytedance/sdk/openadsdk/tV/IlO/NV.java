package com.bytedance.sdk.openadsdk.tV.IlO;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.camera.core.processing.util.a;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.xF;
import com.bytedance.sdk.openadsdk.ea.EO.EO;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.pP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV implements com.bytedance.sdk.component.vCE.IlO.MY.EO {
    public xF<com.bytedance.sdk.openadsdk.tV.IlO> IlO;
    private final EO MY = EO.IlO();

    private boolean EO(List<com.bytedance.sdk.openadsdk.tV.IlO> list) {
        JSONObject jSONObjectEO;
        if (list == null || list.size() == 0 || (jSONObjectEO = list.get(0).EO()) == null) {
            return true;
        }
        return TextUtils.isEmpty(jSONObjectEO.optString("app_log_url"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, List<com.bytedance.sdk.component.vCE.IlO.tV.IlO>> tV(List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list) {
        HashMap<String, List<com.bytedance.sdk.component.vCE.IlO.tV.IlO>> map = new HashMap<>();
        new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO = list.get(i2);
            JSONObject jSONObjectBc = ilO.Bc();
            if (jSONObjectBc != null) {
                String strOptString = jSONObjectBc.optString("app_log_url");
                List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> arrayList = map.get(strOptString);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    map.put(strOptString, arrayList);
                }
                arrayList.add(ilO);
            }
        }
        return map;
    }

    public com.bytedance.sdk.openadsdk.tV.Cc MY(List<EO.IlO> list) {
        if (this.IlO == null) {
            this.IlO = cl.EO();
        }
        if (list != null && list.size() != 0 && com.bytedance.sdk.openadsdk.core.settings.DmF.IlO()) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                Iterator<EO.IlO> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().MY);
                }
                jSONObject.put("stats_list", jSONArray);
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = jCurrentTimeMillis / 1000;
                jSONObject.put("ts", j);
                jSONObject.put("ts_ms", jCurrentTimeMillis);
                String strTV = com.bytedance.sdk.openadsdk.core.DmF.MY().tV();
                if (strTV == null) {
                    strTV = "";
                }
                StringBuilder sb = new StringBuilder(pP.IlO());
                sb.append("-");
                sb.append(jCurrentTimeMillis);
                jSONObject.put("req_sign", com.bytedance.sdk.component.utils.Cc.IlO(strTV + j + BuildConfig.VERSION_NAME));
                jSONObject.put("req_uniq", com.bytedance.sdk.component.utils.Cc.IlO(sb.toString()));
                return this.IlO.MY(jSONObject);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.MY.EO
    public void IlO(final List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list, @Nullable final com.bytedance.sdk.component.vCE.IlO.MY.MY my) {
        com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO;
        if (list == null || list.isEmpty() || !cl.tV().Aw() || (ilO = list.get(0)) == null) {
            return;
        }
        byte bTV = ilO.tV();
        final ArrayList arrayList = new ArrayList();
        if (bTV == 0) {
            com.bytedance.sdk.openadsdk.cl.EO.IlO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.tV.IlO.NV.1
                @Override // com.bytedance.sdk.openadsdk.cl.tV
                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                    return a.d("applog");
                }
            });
            mmj.IlO(new com.bytedance.sdk.component.lEW.EO.MY(7, "upload_ad_event") { // from class: com.bytedance.sdk.openadsdk.tV.IlO.NV.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it;
                    try {
                        it = NV.this.tV(list).entrySet().iterator();
                    } catch (Throwable th) {
                        oeT.EO("OverSeaEventUploadImp", th.getMessage());
                        it = null;
                    }
                    Iterator it2 = it;
                    if (it2 == null) {
                        com.bytedance.sdk.component.vCE.IlO.MY.MY my2 = my;
                        if (my2 != null) {
                            my2.IlO(arrayList);
                            return;
                        }
                        return;
                    }
                    while (it2.hasNext()) {
                        try {
                            IlO.IlO(IlO.tV);
                            List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list2 = (List) ((Map.Entry) it2.next()).getValue();
                            ArrayList arrayList2 = new ArrayList();
                            for (com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO2 : list2) {
                                arrayList2.add(new com.bytedance.sdk.openadsdk.tV.IlO(ilO2.EO(), ilO2.Bc()));
                            }
                            com.bytedance.sdk.openadsdk.tV.Cc ccIlO = NV.this.IlO(arrayList2);
                            if (my != null && ccIlO != null) {
                                boolean z2 = NV.this.IlO(arrayList2, ccIlO) ? true : ccIlO.tV;
                                arrayList.add(new com.bytedance.sdk.component.vCE.IlO.MY.EO.IlO(new com.bytedance.sdk.component.vCE.IlO.MY.EO.MY(ccIlO.IlO, ccIlO.MY, ccIlO.EO, z2, ""), list2));
                                if (ccIlO.MY == 200) {
                                    IlO.IlO(IlO.tV, true);
                                    com.bytedance.sdk.openadsdk.cl.EO.MY(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.tV.IlO.NV.2.1
                                        @Override // com.bytedance.sdk.openadsdk.cl.tV
                                        public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                            return a.d("applog");
                                        }
                                    });
                                } else if (z2) {
                                    IlO.IlO(IlO.tV, false);
                                    com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.tV.IlO.NV.2.2
                                        @Override // com.bytedance.sdk.openadsdk.cl.tV
                                        public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                            return a.d("applog");
                                        }
                                    });
                                } else {
                                    com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.tV.IlO.NV.2.3
                                        @Override // com.bytedance.sdk.openadsdk.cl.tV
                                        public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                            return a.d("applog");
                                        }
                                    });
                                }
                            }
                            if (my != null && ccIlO == null) {
                                com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.tV.IlO.NV.2.4
                                    @Override // com.bytedance.sdk.openadsdk.cl.tV
                                    public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                        return a.d("applog");
                                    }
                                });
                            }
                        } catch (Throwable th2) {
                            oeT.EO("OverSeaEventUploadImp", th2.getMessage());
                        }
                    }
                    com.bytedance.sdk.component.vCE.IlO.MY.MY my3 = my;
                    if (my3 != null) {
                        my3.IlO(arrayList);
                    }
                }
            });
            return;
        }
        if (bTV == 1) {
            final ArrayList arrayList2 = new ArrayList();
            for (com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO2 : list) {
                arrayList2.add(new EO.IlO(ilO2.EO(), ilO2.Bc()));
            }
            IlO.IlO(IlO.Cc);
            if (arrayList2.size() > 0) {
                com.bytedance.sdk.openadsdk.cl.EO.IlO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.tV.IlO.NV.3
                    @Override // com.bytedance.sdk.openadsdk.cl.tV
                    public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                        return a.d("stats");
                    }
                });
                mmj.IlO(new com.bytedance.sdk.component.lEW.EO.MY(6, "upload_stats_event") { // from class: com.bytedance.sdk.openadsdk.tV.IlO.NV.4
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.openadsdk.tV.Cc ccMY = NV.this.MY(arrayList2);
                        if (my != null && ccMY != null) {
                            arrayList.add(new com.bytedance.sdk.component.vCE.IlO.MY.EO.IlO(new com.bytedance.sdk.component.vCE.IlO.MY.EO.MY(ccMY.IlO, ccMY.MY, ccMY.EO, ccMY.tV, ""), list));
                            my.IlO(arrayList);
                            if (ccMY.MY == 200) {
                                IlO.IlO(IlO.Cc, true);
                                com.bytedance.sdk.openadsdk.cl.EO.MY(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.tV.IlO.NV.4.1
                                    @Override // com.bytedance.sdk.openadsdk.cl.tV
                                    public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                        return a.d("stats");
                                    }
                                });
                            } else if (ccMY.tV) {
                                IlO.IlO(IlO.Cc, false);
                                com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.tV.IlO.NV.4.2
                                    @Override // com.bytedance.sdk.openadsdk.cl.tV
                                    public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                        return a.d("stats");
                                    }
                                });
                            } else {
                                com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.tV.IlO.NV.4.3
                                    @Override // com.bytedance.sdk.openadsdk.cl.tV
                                    public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                        return a.d("stats");
                                    }
                                });
                            }
                        }
                        if (my == null || ccMY != null) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.tV.IlO.NV.4.4
                            @Override // com.bytedance.sdk.openadsdk.cl.tV
                            public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                return a.d("stats");
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IlO(List<com.bytedance.sdk.openadsdk.tV.IlO> list, com.bytedance.sdk.openadsdk.tV.Cc cc) {
        int i2;
        return !EO(list) && (i2 = cc.MY) >= 400 && i2 < 500;
    }

    public com.bytedance.sdk.openadsdk.tV.Cc IlO(List<com.bytedance.sdk.openadsdk.tV.IlO> list) {
        if (this.IlO == null) {
            this.IlO = cl.EO();
        }
        if (this.IlO == null) {
            return null;
        }
        int iIi = com.bytedance.sdk.openadsdk.core.settings.hp.aP().ii();
        if (3 == iIi) {
            return this.IlO.IlO(this.MY.IlO(this.MY.IlO(list, false), System.currentTimeMillis(), this.MY.MY(), true), this.MY.IlO(list), true);
        }
        if (2 == iIi) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObjectMY = this.MY.MY();
            this.IlO.IlO(this.MY.IlO(this.MY.IlO(list, true), jCurrentTimeMillis, jSONObjectMY, true), this.MY.IlO(list), true);
            return this.IlO.IlO(this.MY.IlO(this.MY.MY(list), jCurrentTimeMillis, jSONObjectMY, false), this.MY.IlO(list), false);
        }
        return this.IlO.IlO(this.MY.IlO(list, System.currentTimeMillis(), this.MY.MY(), false), this.MY.IlO(list), false);
    }
}
