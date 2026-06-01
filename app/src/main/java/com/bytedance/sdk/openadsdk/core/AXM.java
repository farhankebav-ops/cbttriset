package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.xF;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.DM;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.ironsource.C2300e4;
import com.ironsource.C2543s;
import com.ironsource.C2605va;
import com.ironsource.G5;
import com.ironsource.Q6;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.pgl.ssdk.ces.out.DungeonFlag;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class AXM implements xF<com.bytedance.sdk.openadsdk.tV.IlO> {
    private final Context IlO;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        final String Bc;
        final String Cc;
        final String DmF;
        final long EO;
        final int IlO;
        final long MY;
        final ArrayList<Integer> NV;

        @Nullable
        public final com.bytedance.sdk.openadsdk.core.model.IlO lEW;
        final int tV;
        final int vCE;

        private IlO(String str, int i2, int i8, String str2, int i9, String str3, @Nullable com.bytedance.sdk.openadsdk.core.model.IlO ilO, long j, long j3, ArrayList<Integer> arrayList) {
            this.IlO = i2;
            this.tV = i8;
            this.Cc = str2;
            this.Bc = str3;
            this.lEW = ilO;
            this.DmF = str;
            this.vCE = i9;
            this.MY = j;
            this.EO = j3;
            this.NV = arrayList;
        }

        public static IlO IlO(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.pP pPVar, com.bytedance.sdk.openadsdk.core.model.EO eo) {
            Object obj;
            String strOptString = jSONObject.optString("did");
            int iOptInt = jSONObject.optInt("processing_time_ms");
            long jOptLong = jSONObject.optLong("s_receive_ts");
            long jOptLong2 = jSONObject.optLong("s_send_ts");
            int iOptInt2 = jSONObject.optInt("status_code");
            String strOptString2 = jSONObject.optString("desc");
            String strOptString3 = jSONObject.optString("request_id");
            int iOptInt3 = jSONObject.optInt("reason");
            Pair<com.bytedance.sdk.openadsdk.core.model.IlO, ArrayList<Integer>> pairIlO = com.bytedance.sdk.openadsdk.core.MY.IlO(jSONObject, adSlot, pPVar, eo);
            if (pairIlO != null && (obj = pairIlO.first) != null) {
                ((com.bytedance.sdk.openadsdk.core.model.IlO) obj).IlO(jSONObject.optLong("request_after"));
            }
            return pairIlO == null ? new IlO(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, null, jOptLong, jOptLong2, null) : new IlO(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, (com.bytedance.sdk.openadsdk.core.model.IlO) pairIlO.first, jOptLong, jOptLong2, (ArrayList) pairIlO.second);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY {
        public final com.bytedance.sdk.openadsdk.core.model.lMM EO;
        public final int IlO;
        public final boolean MY;

        private MY(int i2, boolean z2, com.bytedance.sdk.openadsdk.core.model.lMM lmm) {
            this.IlO = i2;
            this.MY = z2;
            this.EO = lmm;
        }

        public static MY IlO(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt("code");
            boolean zOptBoolean = jSONObject.optBoolean("verify");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            com.bytedance.sdk.openadsdk.core.model.lMM lmm = new com.bytedance.sdk.openadsdk.core.model.lMM();
            if (jSONObjectOptJSONObject != null) {
                try {
                    lmm.IlO(jSONObjectOptJSONObject.optInt("reason"));
                    lmm.MY(jSONObjectOptJSONObject.optInt("corp_type"));
                    lmm.EO(jSONObjectOptJSONObject.optInt("reward_amount"));
                    lmm.IlO(jSONObjectOptJSONObject.optString("reward_name"));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", th.getMessage());
                }
            }
            return new MY(iOptInt, zOptBoolean, lmm);
        }
    }

    public AXM(Context context) {
        this.IlO = context;
    }

    private boolean Cc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString("message").equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean EO(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.pP pPVar, final int i2, final xF.IlO ilO) {
        if (!cl.tV().Aw()) {
            ilO.IlO(40060, lEW.IlO(40060));
            return;
        }
        boolean zEO = com.bytedance.sdk.openadsdk.AXM.IlO.EO();
        if (!zEO) {
            bWL.vCE();
        }
        final com.bytedance.sdk.openadsdk.core.model.EO eo = new com.bytedance.sdk.openadsdk.core.model.EO();
        eo.IlO(adSlot);
        if (!com.bytedance.sdk.openadsdk.core.settings.DmF.IlO()) {
            if (ilO != null) {
                ilO.IlO(1000, "Ad request is temporarily paused, Please contact your AM");
                eo.IlO(1000);
                com.bytedance.sdk.openadsdk.core.model.EO.IlO(eo);
                return;
            }
            return;
        }
        if (!cl.tV().BS()) {
            if (ilO != null) {
                ilO.IlO(-16, lEW.IlO(-16));
                eo.IlO(1001);
                com.bytedance.sdk.openadsdk.core.model.EO.IlO(eo);
                return;
            }
            return;
        }
        if (ilO == null) {
            return;
        }
        if (tV(adSlot.getCodeId())) {
            ilO.IlO(-8, lEW.IlO(-8));
            return;
        }
        if (!TextUtils.isEmpty(adSlot.getBidAdm()) && !pPVar.vCE) {
            eo.MY(2);
            eo.IlO(adSlot.getBidAdm());
            if (com.bytedance.sdk.component.utils.ea.tV()) {
                a.a(adSlot.getBidAdm());
            }
            if (cl.tV().quf() && wPn.IlO().tV() == 1) {
                zLG.IlO("Pangle_Debug_Mode", adSlot.getBidAdm(), this.IlO);
            }
            try {
                JSONObject jSONObjectIlO = IlO(new JSONObject(adSlot.getBidAdm()));
                if (jSONObjectIlO == null) {
                    IlO(ilO, eo);
                    return;
                }
                IlO IlO2 = IlO.IlO(jSONObjectIlO, adSlot, pPVar, eo);
                eo.IlO(IlO2.NV);
                rp.IlO(this.IlO, IlO2.DmF);
                int i8 = IlO2.tV;
                if (i8 != 20000) {
                    ilO.IlO(i8, IlO2.Cc);
                    eo.IlO(IlO2.tV);
                    com.bytedance.sdk.openadsdk.core.model.EO.IlO(eo);
                    return;
                }
                com.bytedance.sdk.openadsdk.core.model.IlO ilO2 = IlO2.lEW;
                if (ilO2 == null) {
                    IlO(ilO, eo);
                    return;
                }
                if (ilO2.tV() != null && IlO2.lEW.tV().size() > 0) {
                    com.bytedance.sdk.openadsdk.ea.EO.IlO(IlO2.lEW.tV().get(0));
                }
                if (IlO(IlO2.lEW, ilO)) {
                    return;
                }
                ilO.IlO(IlO2.lEW, eo);
                Map<String, com.bytedance.sdk.openadsdk.core.model.oeT> mapIlO = com.bytedance.sdk.openadsdk.core.model.IlO.IlO(IlO2.lEW);
                if (mapIlO != null) {
                    com.bytedance.sdk.openadsdk.Bc.MY.IlO().IlO(mapIlO);
                }
                IlO(IlO2.lEW);
                com.bytedance.sdk.openadsdk.core.tV.IlO.IlO().IlO(IlO2.lEW);
                return;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.IlO("NetApiImpl", "get ad error: ", th);
                IlO(ilO, eo);
                return;
            }
        }
        JSONObject jSONObjectIlO2 = IlO(adSlot, pPVar, i2);
        if (jSONObjectIlO2 == null) {
            ilO.IlO(-9, lEW.IlO(-9));
            eo.IlO(-9);
            com.bytedance.sdk.openadsdk.core.model.EO.IlO(eo);
            return;
        }
        if (cl.tV().quf() && wPn.IlO().tV() == 1) {
            zLG.IlO("Pangle_Debug_Mode", jSONObjectIlO2.toString(), this.IlO);
        }
        String strIlO = zLG.IlO("/api/ad/union/sdk/get_ads/", true, false);
        final com.bytedance.sdk.component.Bc.MY.tV tVVarMY = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().MY();
        try {
            tVVarMY.MY(com.bytedance.sdk.openadsdk.lEW.tV.IlO(tVVarMY, strIlO));
        } catch (Exception unused) {
        }
        tVVarMY.IlO(jSONObjectIlO2.toString(), cl.tV().zPa());
        Map<String, String> mapIlO2 = com.bytedance.sdk.openadsdk.core.DmF.EO.IlO(strIlO, jSONObjectIlO2.toString());
        if (mapIlO2 != null && mapIlO2.size() > 0) {
            for (String str : mapIlO2.keySet()) {
                try {
                    tVVarMY.MY(str, mapIlO2.get(str));
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", e.getMessage());
                }
            }
        }
        try {
            tVVarMY.MY("User-Agent", zLG.EO());
            IlO(tVVarMY, jSONObjectIlO2);
        } catch (Exception unused2) {
        }
        final DM dmMY = DM.MY();
        final Map<String, Object> requestExtraMap = adSlot.getRequestExtraMap();
        boolean z2 = DmF.MY().es() && requestExtraMap != null;
        if (z2) {
            requestExtraMap.put("pgad_start", dmMY);
        }
        tVVarMY.IlO(10);
        tVVarMY.IlO("get_ad");
        com.bytedance.sdk.openadsdk.cl.EO.IlO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.AXM.8
            @Override // com.bytedance.sdk.openadsdk.cl.tV
            public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                com.bytedance.sdk.openadsdk.cl.MY.IlO ilOD = androidx.camera.core.processing.util.a.d("get_ad");
                ilOD.EO(adSlot.getCodeId());
                ilOD.tV(zLG.EO(adSlot.getDurationSlotType()));
                return ilOD;
            }
        });
        if (com.bytedance.sdk.component.utils.ea.tV()) {
            Thread.currentThread().getName();
        }
        if (zEO) {
            Map<String, Object> map = requestExtraMap;
            try {
                com.bytedance.sdk.component.Bc.MY myIlO = tVVarMY.IlO();
                com.bytedance.sdk.component.Bc.MY my = myIlO == null ? new com.bytedance.sdk.component.Bc.MY(false, IronSourceConstants.errorCode_biddingDataException, "response is null, content type is not support!!", null, "REQUEST_BODY_NULL", 1L, 1L) : myIlO;
                if (my.vCE()) {
                    boolean z7 = z2;
                    try {
                        IlO(tVVarMY, my, z7, map, dmMY, adSlot, eo, ilO, pPVar, i2);
                    } catch (Throwable th2) {
                        th = th2;
                        z2 = z7;
                        map = map;
                        eo = eo;
                        IlO(tVVarMY, new IOException(th.getMessage()), new com.bytedance.sdk.component.Bc.MY(false, IronSourceConstants.errorCode_isReadyException, "execute method throw exception", null, "REQUEST_BODY_EXCEPTION", 1L, 1L), adSlot, z2, map, ilO, eo);
                    }
                } else {
                    IlO(tVVarMY, new IOException(my.MY()), my, adSlot, z2, map, ilO, eo);
                    com.bytedance.sdk.openadsdk.utils.oeT.IlO(tVVarMY.tV());
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            final boolean z8 = z2;
            tVVarMY.IlO(new com.bytedance.sdk.component.Bc.IlO.MY() { // from class: com.bytedance.sdk.openadsdk.core.AXM.9
                @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo2, com.bytedance.sdk.component.Bc.MY my2) {
                    AXM.this.IlO(eo2, my2, z8, requestExtraMap, dmMY, adSlot, eo, ilO, pPVar, i2);
                }

                @Override // com.bytedance.sdk.component.Bc.IlO.MY
                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo2, IOException iOException, com.bytedance.sdk.component.Bc.MY my2) {
                    AXM.this.IlO(tVVarMY, iOException, my2, adSlot, z8, requestExtraMap, ilO, eo);
                    if (eo2 != null) {
                        com.bytedance.sdk.openadsdk.utils.oeT.IlO(eo2.tV());
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.es.IlO.MY.IlO.IlO().IlO(false);
    }

    private boolean tV(String str) {
        if (com.bytedance.sdk.openadsdk.core.Bc.MY.IlO()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.Bc.MY.IlO(str)) {
            return false;
        }
        String strMY = com.bytedance.sdk.openadsdk.core.Bc.MY.MY();
        if (!TextUtils.isEmpty(strMY)) {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(strMY, System.currentTimeMillis());
        }
        return true;
    }

    @DungeonFlag
    private void vCE(JSONObject jSONObject) {
        try {
            jSONObject.put(C2300e4.h.V, zLG.Cc());
            jSONObject.put("version_code", zLG.vCE());
            jSONObject.put("version", zLG.Bc());
        } catch (Exception unused) {
        }
    }

    private byte[] Cc(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] byteArray = new byte[0];
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(str.getBytes(G5.N));
                        try {
                            gZIPOutputStream2.close();
                        } catch (IOException e) {
                            com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", e.toString());
                        }
                    } catch (IOException e4) {
                        e = e4;
                        gZIPOutputStream = gZIPOutputStream2;
                        com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", e.toString());
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e8) {
                                com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", e8.toString());
                            }
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        return byteArray;
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e9) {
                                com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", e9.toString());
                            }
                        }
                        if (byteArrayOutputStream == null) {
                            throw th;
                        }
                        byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayOutputStream.close();
                            throw th;
                        } catch (IOException e10) {
                            com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", e10.toString());
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e11) {
                e = e11;
            }
        } catch (IOException e12) {
            e = e12;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
        byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e13) {
            com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", e13.toString());
        }
        return byteArray;
    }

    @DungeonFlag
    private JSONObject EO() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", DmF.MY().tV());
            jSONObject.put("name", DmF.MY().lEW());
            vCE(jSONObject);
            Context contextIlO = cl.IlO();
            String packageResourcePath = "";
            if (contextIlO != null) {
                try {
                    packageResourcePath = contextIlO.getPackageResourcePath();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", "failed to get the application installation package path. error: " + th.getMessage());
                }
            }
            jSONObject.put("package_install_path", packageResourcePath);
            jSONObject.put("is_paid_app", DmF.MY().hp());
            jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.common.MY.Bc());
            jSONObject.put("app_running_time", (System.currentTimeMillis() - bWL.IlO()) / 1000);
            jSONObject.put("fmwname", DeviceUtils.EV(this.IlO));
            jSONObject.put("is_init", bWL.Cc() ? 1 : 0);
            if (contextIlO != null) {
                int rotation = ((WindowManager) contextIlO.getSystemService("window")).getDefaultDisplay().getRotation();
                int i2 = 1;
                if (rotation != 0) {
                    if (rotation != 1) {
                        i2 = 2;
                        if (rotation != 2) {
                            i2 = rotation != 3 ? 0 : 4;
                        }
                    } else {
                        i2 = 3;
                    }
                }
                jSONObject.put("orientation_support", new JSONArray().put(i2));
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @DungeonFlag
    private JSONObject IlO(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.pP pPVar, int i2) {
        int i8;
        int i9;
        int i10;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            String strTV = (pPVar == null || TextUtils.isEmpty(pPVar.IlO)) ? zLG.tV() : pPVar.IlO;
            if (i2 == 7) {
                if (pPVar != null && (i10 = pPVar.MY) > 0) {
                    jSONObject2.put("req_type", i10);
                }
            } else if (i2 == 8) {
                if (pPVar != null && (i9 = pPVar.EO) > 0) {
                    jSONObject2.put("req_type", i9);
                }
            } else if (i2 == 3 && pPVar != null && (i8 = pPVar.tV) > 0) {
                jSONObject2.put("req_type", i8);
            }
            try {
                String strDmF = cl.tV().DmF();
                String strEs = cl.tV().es();
                if (strDmF != null && strEs != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("version", strDmF);
                    jSONObject3.put("param", strEs);
                    jSONObject2.put("abtest", jSONObject3);
                }
            } catch (Throwable unused) {
            }
            jSONObject2.put("request_id", strTV);
            zLG.IlO(jSONObject2);
            jSONObject2.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject2.put("rewardedfull_link", com.bytedance.sdk.openadsdk.core.settings.hp.aP().tU() ? 1 : 0);
            jSONObject2.put("js_render_ver", com.bytedance.sdk.openadsdk.core.lEW.rp.MY());
            jSONObject2.put("js_render_v3_ver", com.bytedance.sdk.openadsdk.core.lEW.rp.EO());
            jSONObject2.put("source_type", "app");
            jSONObject2.put("app", EO());
            jSONObject2.put(C2300e4.h.G, DeviceUtils.IlO(this.IlO, true));
            jSONObject2.put("user", IlO(adSlot));
            jSONObject2.put(Q6.d0, zLG.EO());
            jSONObject2.put("channel", C2300e4.h.Z);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(IlO(adSlot, i2, pPVar));
            jSONObject2.put("adslots", jSONArray);
            IlO(jSONObject2, pPVar);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject2.put("ts", jCurrentTimeMillis);
            String strConcat = "";
            if (adSlot.getCodeId() != null && strTV != null) {
                strConcat = String.valueOf(jCurrentTimeMillis).concat(adSlot.getCodeId()).concat(strTV);
            }
            jSONObject2.put("req_sign", com.bytedance.sdk.component.utils.Cc.IlO(strConcat));
            if (com.bytedance.sdk.openadsdk.core.DmF.EO.Cc() != 0) {
                jSONObject2.put("pglx", String.valueOf(com.bytedance.sdk.openadsdk.core.DmF.EO.Cc()));
            }
            jSONObject2.put("adx_id", DmF.MY().tl());
            com.bytedance.sdk.openadsdk.vCE.MY.IlO().IlO(jSONObject2);
            jSONObject = IlO(PangleEncryptConstant.CryptDataScene.GET_ADS, jSONObject2);
            if (jSONObject != null) {
                jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
                jSONObject.put("oversea_version_type", 1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("body data exception", th);
        }
        return jSONObject;
    }

    @NonNull
    private Map<String, String> tV(JSONObject jSONObject) {
        HashMap mapU = androidx.camera.core.processing.util.a.u("Content-Type", "application/json; charset=utf-8");
        if (EO(jSONObject)) {
            mapU.put("Content-Encoding", "union_sdk_encode");
        }
        return mapU;
    }

    public static JSONArray EO(String str) {
        try {
            Set<com.bytedance.sdk.openadsdk.core.NV.IlO.IlO> setIlO = com.bytedance.sdk.openadsdk.core.NV.IlO.MY.IlO().IlO(str);
            if (setIlO != null && setIlO.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.core.NV.IlO.IlO ilO : setIlO) {
                    if (ilO != null && !TextUtils.isEmpty(ilO.Cc())) {
                        JSONObject jSONObject = new JSONObject();
                        String[] strArrSplit = ilO.IlO().split("_");
                        if (strArrSplit.length == 2) {
                            jSONObject.put("id", strArrSplit[1]);
                            jSONObject.put("md5", ilO.MY());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.IlO("NetApiImpl", "getUgenParentTplIds: ", e);
            return null;
        }
    }

    private void IlO(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.pP pPVar) {
        JSONArray jSONArray;
        if (pPVar == null || (jSONArray = pPVar.Cc) == null) {
            return;
        }
        try {
            jSONObject.put("source_temai_product_ids", jSONArray);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.xF
    public void IlO(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.pP pPVar, final int i2, xF.IlO ilO) {
        final com.bytedance.sdk.openadsdk.core.IlO.IlO ilO2 = new com.bytedance.sdk.openadsdk.core.IlO.IlO(ilO, adSlot);
        if (pPVar != null && (pPVar.MY == 2 || pPVar.EO == 2 || pPVar.tV == 2)) {
            adSlot.setPreload(true);
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            bWL.MY().post(new com.bytedance.sdk.component.lEW.lEW("getAd") { // from class: com.bytedance.sdk.openadsdk.core.AXM.1
                @Override // java.lang.Runnable
                public void run() {
                    AXM.this.MY(adSlot, pPVar, i2, ilO2);
                }
            });
        } else {
            MY(adSlot, pPVar, i2, ilO2);
        }
        if (com.bytedance.sdk.openadsdk.AXM.IlO.EO()) {
            bWL.Bc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(com.bytedance.sdk.component.Bc.MY.tV tVVar, IOException iOException, com.bytedance.sdk.component.Bc.MY my, final AdSlot adSlot, boolean z2, Map<String, Object> map, xF.IlO ilO, com.bytedance.sdk.openadsdk.core.model.EO eo) {
        String message;
        int iIlO;
        com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.AXM.10
            @Override // com.bytedance.sdk.openadsdk.cl.tV
            public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                com.bytedance.sdk.openadsdk.cl.MY.IlO ilOD = androidx.camera.core.processing.util.a.d("get_ad");
                ilOD.EO(adSlot.getCodeId());
                ilOD.tV(zLG.EO(adSlot.getDurationSlotType()));
                ilOD.IlO(BuildConfig.VERSION_NAME);
                return ilOD;
            }
        });
        if (my != null) {
            message = my.MY();
        } else if (iOException != null) {
            message = iOException.getMessage();
        } else {
            message = "";
        }
        DM dmMY = DM.MY();
        if (z2) {
            map.put("pgad_end", Long.valueOf(dmMY.IlO));
        }
        if (cl.tV().quf() && wPn.IlO().tV() == 1) {
            zLG.IlO("Pangle_Debug_Mode", iOException != null ? iOException.getMessage() : null, this.IlO);
        }
        if (my != null) {
            iIlO = my.IlO();
        } else {
            iIlO = (iOException == null || !(iOException instanceof SocketTimeoutException)) ? 601 : 602;
        }
        if (ilO != null) {
            ilO.IlO(iIlO, message);
        }
        eo.IlO(iIlO);
        com.bytedance.sdk.openadsdk.core.model.EO.IlO(eo);
        com.bytedance.sdk.openadsdk.tV.IlO.vCE.EO.incrementAndGet();
        com.bytedance.sdk.openadsdk.tV.IlO.vCE.IlO.incrementAndGet();
        com.bytedance.sdk.openadsdk.tV.IlO.vCE.Bc.incrementAndGet();
        com.bytedance.sdk.openadsdk.tV.IlO.vCE.Cc();
        com.bytedance.sdk.openadsdk.tV.IlO.vCE.IlO(iIlO, message);
        com.bytedance.sdk.openadsdk.tV.IlO.vCE.EO();
        com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("get_ad", tVVar.tV(), iIlO, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c4 A[Catch: all -> 0x01cc, TryCatch #2 {all -> 0x01cc, blocks: (B:78:0x01ab, B:80:0x01c4, B:83:0x01ce, B:85:0x01d6, B:88:0x01e4, B:89:0x0209, B:90:0x020e), top: B:102:0x01ab }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e4 A[Catch: all -> 0x01cc, TryCatch #2 {all -> 0x01cc, blocks: (B:78:0x01ab, B:80:0x01c4, B:83:0x01ce, B:85:0x01d6, B:88:0x01e4, B:89:0x0209, B:90:0x020e), top: B:102:0x01ab }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x022a  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(com.bytedance.sdk.component.Bc.MY.EO r20, com.bytedance.sdk.component.Bc.MY r21, boolean r22, java.util.Map<java.lang.String, java.lang.Object> r23, com.bytedance.sdk.openadsdk.utils.DM r24, final com.bytedance.sdk.openadsdk.AdSlot r25, com.bytedance.sdk.openadsdk.core.model.EO r26, com.bytedance.sdk.openadsdk.core.xF.IlO r27, com.bytedance.sdk.openadsdk.core.model.pP r28, int r29) {
        /*
            Method dump skipped, instruction units count: 630
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.AXM.IlO(com.bytedance.sdk.component.Bc.MY.EO, com.bytedance.sdk.component.Bc.MY, boolean, java.util.Map, com.bytedance.sdk.openadsdk.utils.DM, com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.core.model.EO, com.bytedance.sdk.openadsdk.core.xF$IlO, com.bytedance.sdk.openadsdk.core.model.pP, int):void");
    }

    @DungeonFlag
    private JSONObject MY(@NonNull String str, List<FilterWord> list, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            JSONObject jSONObject3 = new JSONObject(str);
            jSONObject3.put(Q6.U0, com.bytedance.sdk.openadsdk.es.IlO.MY.IlO.IlO().MY());
            jSONObject2.put("extra", jSONObject3.toString());
            jSONObject2.put("filter_words", IlO(list));
            jSONObject2.put("dislike_source", str4);
            if (com.bytedance.sdk.openadsdk.core.settings.hp.aP().AK() && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                jSONObject2.put("creative_info", com.bytedance.sdk.component.utils.IlO.IlO(new JSONObject(str2)).toString());
                jSONObject2.put("feedback_type", 1);
                jSONObject2.put("user_description", str3);
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @NonNull
    private Map<String, String> MY() {
        return androidx.camera.core.processing.util.a.u("Content-Type", "application/octet-stream;tt-data=a");
    }

    private static String MY(AdSlot adSlot) {
        String strEa = DmF.MY().ea();
        if (adSlot == null) {
            if (TextUtils.isEmpty(strEa)) {
                return "";
            }
        } else {
            String userData = adSlot.getUserData();
            if (TextUtils.isEmpty(strEa)) {
                return userData;
            }
            if (!TextUtils.isEmpty(userData)) {
                HashSet hashSet = new HashSet();
                try {
                    JSONArray jSONArray = new JSONArray(userData);
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        if (jSONObject != null) {
                            hashSet.add(jSONObject.optString("name", null));
                        }
                    }
                    try {
                        JSONArray jSONArray2 = new JSONArray(strEa);
                        int length2 = jSONArray2.length();
                        for (int i8 = 0; i8 < length2; i8++) {
                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i8);
                            if (jSONObject2 != null && !hashSet.contains(jSONObject2.optString("name", null))) {
                                jSONArray.put(jSONObject2);
                            }
                        }
                        return jSONArray.toString();
                    } catch (Throwable unused) {
                        return userData;
                    }
                } catch (Throwable unused2) {
                }
            }
        }
        return strEa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String MY(int i2, String str) {
        Object obj;
        if (i2 == 3) {
            return com.bytedance.sdk.component.utils.IlO.EO(str);
        }
        if (i2 == 4) {
            Pair<Integer, String> pairDecryptType4 = PangleEncryptManager.decryptType4(str);
            if (pairDecryptType4 != null && (obj = pairDecryptType4.second) != null) {
                String str2 = (String) obj;
                vAh.IlO(true);
                return str2;
            }
            vAh.IlO(false);
            vAh.IlO(2, PangleEncryptConstant.CryptDataScene.GET_ADS, pairDecryptType4 != null ? ((Integer) pairDecryptType4.first).intValue() : 0);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xF
    public com.bytedance.sdk.openadsdk.tV.Cc MY(JSONObject jSONObject) {
        int i2;
        boolean z2;
        boolean z7;
        String strMY = "error unknown";
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!com.bytedance.sdk.openadsdk.core.settings.DmF.IlO() || !cl.tV().Aw() || jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        com.bytedance.sdk.component.Bc.MY.tV tVVarMY = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().MY();
        boolean z8 = false;
        int iIlO = 0;
        try {
            JSONObject jSONObjectIlO = IlO(PangleEncryptConstant.CryptDataScene.STATS_LOG, jSONObject);
            tVVarMY.IlO(jSONObjectIlO.toString(), cl.tV().zPa());
            tVVarMY.MY(zLG.tV("/api/ad/union/sdk/stats/batch/"));
            IlO(tVVarMY, jSONObjectIlO);
            tVVarMY.MY("User-Agent", zLG.EO());
            if (com.bytedance.sdk.openadsdk.core.settings.hp.aP().qvT()) {
                tVVarMY.MY("_disable_retry", "1");
            }
            com.bytedance.sdk.component.Bc.MY myIlO = tVVarMY.IlO();
            try {
            } catch (Throwable unused) {
                i2 = 0;
                z2 = false;
            }
            if (myIlO == null) {
                return new com.bytedance.sdk.openadsdk.tV.Cc(false, 0, "error unknown", false);
            }
            if (!myIlO.vCE() || TextUtils.isEmpty(myIlO.tV())) {
                z7 = false;
                z2 = false;
            } else {
                JSONObject jSONObject2 = new JSONObject(myIlO.tV());
                int iOptInt = jSONObject2.optInt("code", -1);
                strMY = jSONObject2.optString("data", "");
                z2 = true;
                z7 = iOptInt == 20000;
                if (iOptInt != 60005) {
                    z2 = false;
                }
            }
            try {
                iIlO = myIlO.IlO();
                if (!myIlO.vCE()) {
                    strMY = myIlO.MY();
                    com.bytedance.sdk.openadsdk.utils.oeT.IlO(tVVarMY.tV());
                }
            } catch (Throwable unused2) {
                boolean z9 = z7;
                i2 = iIlO;
                z8 = z9;
                int i8 = i2;
                z7 = z8;
                iIlO = i8;
            }
            if (myIlO == null) {
                com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("stats", tVVarMY.tV(), -1, "response is null");
            } else if (!myIlO.vCE()) {
                com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("stats", tVVarMY.tV(), myIlO.IlO(), myIlO.MY());
            }
            com.bytedance.sdk.openadsdk.tV.IlO.IlO.IlO(com.bytedance.sdk.openadsdk.tV.IlO.IlO.MY, z7, iIlO, System.currentTimeMillis() - jCurrentTimeMillis);
            return new com.bytedance.sdk.openadsdk.tV.Cc(z7, iIlO, strMY, z2);
        } catch (Throwable unused3) {
            com.bytedance.sdk.openadsdk.tV.IlO.IlO.IlO(com.bytedance.sdk.openadsdk.tV.IlO.IlO.MY, false, 0, System.currentTimeMillis() - jCurrentTimeMillis);
            return new com.bytedance.sdk.openadsdk.tV.Cc(false, 0, "error unknown", false);
        }
    }

    public static JSONArray MY(String str) {
        try {
            Set<String> setMY = com.bytedance.sdk.component.adexpress.IlO.MY.MY.MY(str);
            if (setMY != null && setMY.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = setMY.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.IlO.EO.MY myIlO = com.bytedance.sdk.component.adexpress.IlO.MY.MY.IlO(it.next());
                    if (myIlO != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", myIlO.MY());
                        jSONObject.put("md5", myIlO.EO());
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.IlO("NetApiImpl", "getParentTplIds: ", e);
            return null;
        }
    }

    private boolean IlO(com.bytedance.sdk.openadsdk.core.model.IlO ilO, xF.IlO ilO2) {
        if (ilO == null) {
            ilO2.IlO(40053, lEW.IlO(40053));
            return true;
        }
        List<com.bytedance.sdk.openadsdk.core.model.oeT> listTV = ilO.tV();
        if (listTV.isEmpty()) {
            return false;
        }
        for (final com.bytedance.sdk.openadsdk.core.model.oeT oet : listTV) {
            if (TextUtils.isEmpty(oet.Uj().MY()) || TextUtils.isEmpty(oet.Uj().EO())) {
                ilO2.IlO(40053, lEW.IlO(40053));
                com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), oet, zLG.IlO(oet), "material_error", new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.AXM.13
                    @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                    public JSONObject IlO() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("ad_label", oet.Uj().vCE());
                            jSONObject2.put("pag_json_data", jSONObject3.toString());
                            jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                            return jSONObject;
                        } catch (Exception e) {
                            e.getMessage();
                            return jSONObject;
                        }
                    }
                });
                return true;
            }
        }
        return false;
    }

    private void IlO(com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
        List<com.bytedance.sdk.openadsdk.core.model.oeT> listTV = ilO.tV();
        if (listTV == null || listTV.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < listTV.size(); i2++) {
            com.bytedance.sdk.openadsdk.core.model.oeT oet = listTV.get(i2);
            if (oet != null && oet.cL() == null) {
                IlO("", 0, 0, oet.HTA(), oet);
                IlO("", 0, 0, oet.Tx(), oet);
                List<com.bytedance.sdk.openadsdk.core.model.zPa> listHg = oet.Hg();
                if (listHg != null && listHg.size() > 0) {
                    for (int i8 = 0; i8 < listHg.size(); i8++) {
                        IlO(oet, listHg.get(i8));
                    }
                }
                if (oet.fdM() != null) {
                    IlO(oet.fdM().f4689f, oet.fdM().f4686b, oet.fdM().f4685a, (com.bytedance.sdk.openadsdk.core.model.zPa) null, oet);
                }
            }
        }
    }

    private void IlO(String str, int i2, int i8, com.bytedance.sdk.openadsdk.core.model.zPa zpa, com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.DmF.tV.IlO(str).IlO(i2).MY(i8).Cc(BS.Cc(cl.IlO())).tV(BS.EO(cl.IlO())).EO(1).IlO(new com.bytedance.sdk.openadsdk.DmF.MY(oet, str, null), 4);
        } else {
            if (zpa == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.DmF.tV.IlO(zpa).EO(1).IlO(new com.bytedance.sdk.openadsdk.DmF.MY(oet, zpa.IlO(), null), 4);
        }
    }

    private void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, com.bytedance.sdk.openadsdk.core.model.zPa zpa) {
        if (zpa == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.DmF.tV.IlO(zpa).EO(1).IlO(new com.bytedance.sdk.openadsdk.DmF.MY(oet, zpa.IlO(), new com.bytedance.sdk.component.Cc.zPa() { // from class: com.bytedance.sdk.openadsdk.core.AXM.14
            @Override // com.bytedance.sdk.component.Cc.zPa
            public void IlO(int i2, String str, @Nullable Throwable th) {
            }

            @Override // com.bytedance.sdk.component.Cc.zPa
            public void IlO(com.bytedance.sdk.component.Cc.EV ev) {
            }
        }), 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void IlO(com.bytedance.sdk.component.MY.IlO.NV r14, com.bytedance.sdk.openadsdk.core.model.pP r15, com.bytedance.sdk.openadsdk.utils.DM r16, com.bytedance.sdk.openadsdk.utils.DM r17, int r18, com.bytedance.sdk.openadsdk.utils.DM r19, com.bytedance.sdk.openadsdk.core.model.oeT r20, java.lang.String r21, boolean r22) {
        /*
            r13 = this;
            com.bytedance.sdk.openadsdk.core.settings.vCE r0 = com.bytedance.sdk.openadsdk.core.cl.tV()
            boolean r0 = r0.KC()
            if (r0 != 0) goto Lb
            goto L48
        Lb:
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            r2 = 0
            if (r15 == 0) goto L24
            com.bytedance.sdk.openadsdk.utils.DM r0 = r15.DmF     // Catch: java.lang.Exception -> L48
            long r4 = r0.IlO     // Catch: java.lang.Exception -> L48
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 <= 0) goto L24
            r5 = r19
            long r2 = r5.IlO(r0)     // Catch: java.lang.Exception -> L48
        L22:
            r11 = r2
            goto L27
        L24:
            r5 = r19
            goto L22
        L27:
            r10 = 0
            r0 = r14
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r6 = r20
            r7 = r21
            r8 = r22
            IlO(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L48
            java.lang.String r0 = "load_ad_time"
            r14 = r20
            r15 = r21
            r16 = r0
            r19 = r9
            r17 = r11
            com.bytedance.sdk.openadsdk.tV.EO.IlO(r14, r15, r16, r17, r19)     // Catch: java.lang.Exception -> L48
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.AXM.IlO(com.bytedance.sdk.component.MY.IlO.NV, com.bytedance.sdk.openadsdk.core.model.pP, com.bytedance.sdk.openadsdk.utils.DM, com.bytedance.sdk.openadsdk.utils.DM, int, com.bytedance.sdk.openadsdk.utils.DM, com.bytedance.sdk.openadsdk.core.model.oeT, java.lang.String, boolean):void");
    }

    private static void IlO(com.bytedance.sdk.component.MY.IlO.NV nv, com.bytedance.sdk.openadsdk.core.model.pP pPVar, DM dm, DM dm2, int i2, DM dm3, com.bytedance.sdk.openadsdk.core.model.oeT oet, String str, boolean z2, JSONObject jSONObject, boolean z7) throws JSONException {
        if (pPVar != null) {
            DM dm4 = pPVar.DmF;
            if (dm4.IlO > 0) {
                jSONObject.put("client_start_time", dm.IlO(dm4));
            }
        }
        jSONObject.put("network_time", dm2.IlO(dm));
        jSONObject.put("sever_time", i2);
        jSONObject.put("client_end_time", dm3.IlO(dm2));
        if (z2) {
            jSONObject.put("is_choose_ad", true);
        }
        if (str.equals("open_ad")) {
            jSONObject.put("is_icon_only", oet.mV() ? 1 : 0);
        }
        if (oet != null) {
            jSONObject.put("render_control_type", oet.oc());
        }
        jSONObject.put("webview_cache_size", com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().EO());
        jSONObject.put("sync_barrier_open", z7 ? 1 : 0);
        long j = nv.MY;
        if (j > 0) {
            jSONObject.put("enqueue_2_run_ts", nv.EO - j);
            jSONObject.put("run_2_connect_end_ts", nv.Cc - nv.MY);
            jSONObject.put("connect_end_2_response_end_ts", nv.vCE - nv.Cc);
            jSONObject.put("response_end_2_callback_end_ts", SystemClock.elapsedRealtime() - nv.vCE);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.xF
    @WorkerThread
    @DungeonFlag
    public com.bytedance.sdk.openadsdk.tV.Cc IlO(JSONObject jSONObject, String str, boolean z2) {
        Object obj;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            byte[] bArrEncryptV3 = null;
            if (!com.bytedance.sdk.openadsdk.core.settings.DmF.IlO()) {
                return null;
            }
            com.bytedance.sdk.component.Bc.MY.tV tVVarMY = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().MY();
            tVVarMY.MY(str);
            if (com.bytedance.sdk.openadsdk.core.settings.hp.aP().qz()) {
                tVVarMY.MY("_disable_retry", "1");
            }
            boolean z7 = true;
            if (z2) {
                com.bytedance.sdk.openadsdk.core.settings.vCE vceAP = com.bytedance.sdk.openadsdk.core.settings.hp.aP();
                PangleEncryptConstant.CryptDataScene cryptDataScene = PangleEncryptConstant.CryptDataScene.APP_LOG;
                boolean zIlO = vceAP.IlO(cryptDataScene);
                byte[] bArrCc = Cc(jSONObject.toString());
                if (zIlO) {
                    Pair<Integer, byte[]> pairEncryptType4WithoutBase64 = PangleEncryptManager.encryptType4WithoutBase64(bArrCc);
                    if (pairEncryptType4WithoutBase64 != null && (obj = pairEncryptType4WithoutBase64.second) != null && ((byte[]) obj).length > 0) {
                        bArrEncryptV3 = (byte[]) obj;
                        vAh.MY(true);
                    } else {
                        int iIntValue = pairEncryptType4WithoutBase64 != null ? ((Integer) pairEncryptType4WithoutBase64.first).intValue() : 0;
                        vAh.MY(false);
                        vAh.IlO(1, cryptDataScene, iIntValue);
                    }
                }
                if (bArrEncryptV3 != null) {
                    tVVarMY.MY("Content-Encoding", "union_sdk_encode");
                    tVVarMY.MY("x-pgli18n", "4");
                    tVVarMY.IlO("application/octet-stream;tt-data=a", bArrEncryptV3);
                } else {
                    bArrEncryptV3 = PangleEncryptManager.encryptV3(bArrCc);
                    if (bArrEncryptV3 != null) {
                        IlO(MY(), tVVarMY);
                        tVVarMY.IlO("application/octet-stream;tt-data=a", bArrEncryptV3);
                    }
                }
            }
            if (bArrEncryptV3 == null) {
                try {
                    JSONObject jSONObjectIlO = com.bytedance.sdk.component.utils.IlO.IlO(jSONObject);
                    if (!EO(jSONObjectIlO)) {
                        jSONObjectIlO = jSONObject;
                    }
                    IlO(tV(jSONObjectIlO), tVVarMY);
                    tVVarMY.IlO(jSONObjectIlO.toString(), cl.tV().zPa());
                } catch (OutOfMemoryError e) {
                    com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", e.toString());
                    return new com.bytedance.sdk.openadsdk.tV.Cc(false, -2, "encrypt_error", false);
                }
            }
            com.bytedance.sdk.component.Bc.MY myIlO = tVVarMY.IlO();
            boolean zCc = (myIlO == null || !myIlO.vCE() || TextUtils.isEmpty(myIlO.tV())) ? false : Cc(new JSONObject(myIlO.tV()));
            String strMY = "error unknown";
            int iIlO = myIlO != null ? myIlO.IlO() : 0;
            if (!zCc && iIlO == 200) {
                strMY = "server say not success";
            } else {
                if (myIlO != null && myIlO.MY() != null) {
                    strMY = myIlO.MY();
                }
                z7 = false;
            }
            if (myIlO == null) {
                com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("applog", str, -1, "response is null");
            } else if (!myIlO.vCE()) {
                com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("applog", str, iIlO, myIlO.MY());
            }
            IlO(jSONObject, z2);
            com.bytedance.sdk.openadsdk.tV.IlO.IlO.IlO(com.bytedance.sdk.openadsdk.tV.IlO.IlO.IlO, zCc, iIlO, System.currentTimeMillis() - jCurrentTimeMillis);
            return new com.bytedance.sdk.openadsdk.tV.Cc(zCc, iIlO, strMY, z7);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO("NetApiImpl", "uploadEvent error", th);
            return new com.bytedance.sdk.openadsdk.tV.Cc(false, 509, "service_busy", false);
        }
    }

    private void IlO(Map<String, String> map, com.bytedance.sdk.component.Bc.MY.tV tVVar) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    tVVar.MY(entry.getKey(), entry.getValue());
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", "ADD header exceptopn", e.getMessage());
                }
            }
        }
        try {
            tVVar.MY("User-Agent", zLG.EO());
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", "ADD header exceptopn", e4.getMessage());
        }
    }

    private void IlO(JSONObject jSONObject, boolean z2) throws Throwable {
        Object obj;
        if (DmF.MY().xF()) {
            try {
                jSONObject.getJSONObject("header").put(C2605va.f10440b, "4562");
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", "reportETEvent error", e.getMessage());
            }
            com.bytedance.sdk.component.Bc.MY.tV tVVarMY = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().MY();
            tVVarMY.MY(zLG.zPa());
            byte[] bArrEncryptV3 = null;
            if (z2) {
                com.bytedance.sdk.openadsdk.core.settings.vCE vceAP = com.bytedance.sdk.openadsdk.core.settings.hp.aP();
                PangleEncryptConstant.CryptDataScene cryptDataScene = PangleEncryptConstant.CryptDataScene.APP_LOG;
                boolean zIlO = vceAP.IlO(cryptDataScene);
                byte[] bArrCc = Cc(jSONObject.toString());
                if (zIlO) {
                    Pair<Integer, byte[]> pairEncryptType4WithoutBase64 = PangleEncryptManager.encryptType4WithoutBase64(bArrCc);
                    if (pairEncryptType4WithoutBase64 != null && (obj = pairEncryptType4WithoutBase64.second) != null && ((byte[]) obj).length > 0) {
                        bArrEncryptV3 = (byte[]) obj;
                        vAh.MY(true);
                    } else {
                        int iIntValue = pairEncryptType4WithoutBase64 != null ? ((Integer) pairEncryptType4WithoutBase64.first).intValue() : 0;
                        vAh.MY(false);
                        vAh.IlO(1, cryptDataScene, iIntValue);
                    }
                }
                if (bArrEncryptV3 != null) {
                    tVVarMY.MY("Content-Encoding", "union_sdk_encode");
                    tVVarMY.MY("x-pgli18n", "4");
                    tVVarMY.IlO("application/octet-stream;tt-data=a", bArrEncryptV3);
                } else {
                    bArrEncryptV3 = PangleEncryptManager.encryptV3(bArrCc);
                    if (bArrEncryptV3 != null) {
                        IlO(MY(), tVVarMY);
                        tVVarMY.IlO("application/octet-stream;tt-data=a", bArrEncryptV3);
                    }
                }
            }
            if (bArrEncryptV3 == null) {
                JSONObject jSONObjectIlO = com.bytedance.sdk.component.utils.IlO.IlO(jSONObject);
                if (EO(jSONObjectIlO)) {
                    jSONObject = jSONObjectIlO;
                }
                IlO(tV(jSONObject), tVVarMY);
                tVVarMY.IlO(jSONObject.toString(), cl.tV().zPa());
            }
            tVVarMY.IlO(7);
            tVVarMY.IlO("et_applog");
            tVVarMY.IlO(new com.bytedance.sdk.component.Bc.IlO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.AXM.15
                @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, com.bytedance.sdk.component.Bc.MY my) {
                    if (my == null || !my.vCE()) {
                        return;
                    }
                    my.tV();
                }

                @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, IOException iOException) {
                    iOException.getMessage();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.xF
    public void IlO(@NonNull String str, List<FilterWord> list, String str2, String str3, String str4) {
        JSONObject jSONObjectMY;
        if (com.bytedance.sdk.openadsdk.core.settings.DmF.IlO() && (jSONObjectMY = MY(str, list, str2, str3, str4)) != null) {
            com.bytedance.sdk.component.Bc.MY.tV tVVarMY = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().MY();
            final String strTV = zLG.tV("/api/ad/union/dislike_event/");
            JSONObject jSONObjectIlO = IlO(PangleEncryptConstant.CryptDataScene.DISLIKE, jSONObjectMY);
            String string = jSONObjectIlO != null ? jSONObjectIlO.toString() : null;
            IlO(tVVarMY, jSONObjectIlO);
            tVVarMY.MY(strTV);
            tVVarMY.tV(string);
            tVVarMY.IlO(7);
            tVVarMY.IlO("dislike");
            com.bytedance.sdk.openadsdk.cl.EO.IlO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.AXM.2
                @Override // com.bytedance.sdk.openadsdk.cl.tV
                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                    return androidx.camera.core.processing.util.a.d("dislike");
                }
            });
            tVVarMY.IlO(new com.bytedance.sdk.component.Bc.IlO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.AXM.3
                @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, com.bytedance.sdk.component.Bc.MY my) {
                    if (my == null) {
                        com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("dislike", strTV, -1, "response is null");
                        com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.AXM.3.3
                            @Override // com.bytedance.sdk.openadsdk.cl.tV
                            public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                return androidx.camera.core.processing.util.a.d("dislike");
                            }
                        });
                    } else if (my.vCE()) {
                        com.bytedance.sdk.openadsdk.cl.EO.MY(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.AXM.3.1
                            @Override // com.bytedance.sdk.openadsdk.cl.tV
                            public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                return androidx.camera.core.processing.util.a.d("dislike");
                            }
                        });
                    } else {
                        com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.AXM.3.2
                            @Override // com.bytedance.sdk.openadsdk.cl.tV
                            public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                return androidx.camera.core.processing.util.a.d("dislike");
                            }
                        });
                        com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("dislike", strTV, my.IlO(), my.MY());
                    }
                }

                @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, IOException iOException) {
                    com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO("dislike", strTV, -1, iOException != null ? iOException.getMessage() : "null");
                    if (eo != null) {
                        com.bytedance.sdk.openadsdk.utils.oeT.IlO(eo.tV());
                    }
                    com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.AXM.3.4
                        @Override // com.bytedance.sdk.openadsdk.cl.tV
                        public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                            return androidx.camera.core.processing.util.a.d("dislike");
                        }
                    });
                }
            });
            try {
                String strOptString = new JSONObject(str).optString("cid", "");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.vCE.MY.IlO().IlO("dislike", strOptString, (String) null, (String) null);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.EO(e.getMessage(), new Object[0]);
            }
        }
    }

    private static JSONObject IlO(PangleEncryptConstant.CryptDataScene cryptDataScene, JSONObject jSONObject) {
        if (com.bytedance.sdk.openadsdk.core.settings.hp.aP().IlO(cryptDataScene)) {
            JSONObject jSONObjectEncryptType4 = PangleEncryptManager.encryptType4(jSONObject, new oeT(cryptDataScene));
            vAh.IlO(jSONObjectEncryptType4);
            return jSONObjectEncryptType4;
        }
        return com.bytedance.sdk.component.utils.IlO.IlO(jSONObject);
    }

    private JSONArray IlO(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<FilterWord> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getId());
        }
        return jSONArray;
    }

    private void IlO(xF.IlO ilO, com.bytedance.sdk.openadsdk.core.model.EO eo) {
        ilO.IlO(-1, lEW.IlO(-1));
        eo.IlO(-1);
        com.bytedance.sdk.openadsdk.core.model.EO.IlO(eo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(xF.MY my) {
        my.IlO(-1, lEW.IlO(-1));
    }

    public static JSONObject IlO(AdSlot adSlot) {
        kBB kbb;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("personalized_ad", cl.tV().ssS());
            jSONObject.put("lmt", DeviceUtils.EO());
            jSONObject.put("gdpr", DmF.MY().NV());
            jSONObject.put("pa_consent", DmF.MY().EV());
            jSONObject.put("is_gdpr_user", cl.tV().DM());
            if (adSlot != null && kBB.IlO.containsKey(Integer.valueOf(adSlot.getCodeId())) && (kbb = kBB.IlO.get(Integer.valueOf(adSlot.getCodeId()))) != null) {
                jSONObject.put("lastadomain", kbb.MY());
                jSONObject.put("lastbundle", kbb.EO());
                jSONObject.put("lastclick", kbb.tV());
                jSONObject.put("lastskip", kbb.Cc());
            }
            IlO(jSONObject, "keywords", DmF.MY().bWL());
            IlO(jSONObject, "data", MY(adSlot));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void IlO(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private JSONObject IlO(AdSlot adSlot, int i2, com.bytedance.sdk.openadsdk.core.model.pP pPVar) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", adSlot.getCodeId());
            jSONObject.put("adtype", i2);
            if (!TextUtils.isEmpty(adSlot.getAdId()) || !TextUtils.isEmpty(adSlot.getCreativeId()) || !TextUtils.isEmpty(adSlot.getExt())) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(adSlot.getAdId())) {
                    jSONObject2.put("ad_id", adSlot.getAdId());
                }
                if (!TextUtils.isEmpty(adSlot.getCreativeId())) {
                    jSONObject2.put("creative_id", adSlot.getCreativeId());
                }
                if (adSlot.getExt() != null) {
                    jSONObject2.put("ext", adSlot.getExt());
                }
                jSONObject.put("preview_ads", jSONObject2);
            }
            if (pPVar != null) {
                jSONObject.put("render_method", pPVar.lEW);
                int i8 = pPVar.lEW;
                if (i8 == 1) {
                    IlO(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
                } else if (i8 == 2) {
                    IlO(jSONObject, "accepted_size", adSlot.getExpressViewAcceptedWidth(), adSlot.getExpressViewAcceptedHeight());
                }
            } else {
                jSONObject.put("render_method", 1);
                IlO(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            }
            jSONObject.put("ptpl_ids", MY(adSlot.getCodeId()));
            jSONObject.put("ugen_ptpl_ids", EO(adSlot.getCodeId()));
            jSONObject.put("ptpl_ids_v3", EO(adSlot.getCodeId() + "_v3"));
            jSONObject.put("pos", AdSlot.getPosition(i2));
            jSONObject.put("is_support_dpl", adSlot.isSupportDeepLink());
            if (adSlot.getNativeAdType() > 0 || i2 == 5) {
                jSONObject.put("is_origin_ad", true);
            }
            if (pPVar != null && (obj = pPVar.Bc) != null) {
                jSONObject.put("session_params", obj);
            }
            int adCount = adSlot.getAdCount();
            if (adCount <= 0) {
                adCount = 1;
            }
            if (adCount > 3) {
                adCount = 3;
            }
            if (i2 == 7 || i2 == 8) {
                adCount = 1;
            }
            if (pPVar != null && pPVar.Cc != null) {
                adCount = adSlot.getAdCount();
            }
            jSONObject.put("ad_count", adCount);
            if (i2 == 1) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("is_rotate_banner", adSlot.getIsRotateBanner());
                jSONObject3.put("rotate_time", adSlot.getRotateTime());
                jSONObject3.put("rotate_order", adSlot.getRotateOrder());
                jSONObject3.put("type", adSlot.getBannerType());
                jSONObject.put("banner", jSONObject3);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void IlO(JSONObject jSONObject, String str, int i2, int i8) {
        if (i2 <= 0 || i8 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i2);
            jSONObject2.put("height", i8);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void IlO(JSONObject jSONObject, String str, float f4, float f8) {
        if (f4 < 0.0f || f8 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", (int) f4);
            jSONObject2.put("height", (int) f8);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.xF
    public void IlO(JSONObject jSONObject, final xF.MY my) {
        if (!com.bytedance.sdk.openadsdk.core.settings.DmF.IlO()) {
            if (my != null) {
                my.IlO(1000, "Ad request is temporarily paused, Please contact your AM");
            }
        } else {
            if (jSONObject == null || my == null) {
                return;
            }
            JSONObject jSONObjectIlO = IlO(PangleEncryptConstant.CryptDataScene.REWARD_VERIFY, jSONObject);
            com.bytedance.sdk.component.Bc.MY.tV tVVarMY = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().MY();
            try {
                tVVarMY.MY(com.bytedance.sdk.openadsdk.lEW.tV.IlO(tVVarMY, zLG.tV("/api/ad/union/sdk/reward_video/reward/")));
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", e.getMessage());
            }
            IlO(tVVarMY, jSONObjectIlO);
            tVVarMY.tV(jSONObjectIlO != null ? jSONObjectIlO.toString() : "");
            tVVarMY.IlO(10);
            tVVarMY.IlO(C2543s.j);
            com.bytedance.sdk.openadsdk.cl.EO.IlO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.AXM.4
                @Override // com.bytedance.sdk.openadsdk.cl.tV
                public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                    return androidx.camera.core.processing.util.a.d(C2543s.j);
                }
            });
            tVVarMY.IlO(new com.bytedance.sdk.component.Bc.IlO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.AXM.5
                @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, com.bytedance.sdk.component.Bc.MY my2) {
                    MY myIlO;
                    int i2;
                    if (my2 == null) {
                        com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.AXM.5.3
                            @Override // com.bytedance.sdk.openadsdk.cl.tV
                            public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                return androidx.camera.core.processing.util.a.d(C2543s.j);
                            }
                        });
                        com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO(C2543s.j, eo.tV(), -1, "response is null");
                        AXM.this.IlO(my);
                        return;
                    }
                    if (!my2.vCE() || TextUtils.isEmpty(my2.tV())) {
                        String strIlO = lEW.IlO(-2);
                        int iIlO = my2.IlO();
                        if (!my2.vCE() && !TextUtils.isEmpty(my2.MY())) {
                            strIlO = my2.MY();
                        }
                        my.IlO(iIlO, strIlO);
                        com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.AXM.5.2
                            @Override // com.bytedance.sdk.openadsdk.cl.tV
                            public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                return androidx.camera.core.processing.util.a.d(C2543s.j);
                            }
                        });
                        if (my2.vCE()) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO(C2543s.j, eo.tV(), iIlO, strIlO);
                        return;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject(my2.tV());
                        String strMY = AXM.MY(jSONObject2.optInt("cypher", -1), jSONObject2.optString("message"));
                        if (!TextUtils.isEmpty(strMY)) {
                            try {
                                jSONObject2 = new JSONObject(strMY);
                            } catch (Throwable unused) {
                            }
                        }
                        myIlO = MY.IlO(jSONObject2);
                        i2 = myIlO.IlO;
                    } catch (JSONException e4) {
                        com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", e4.getMessage());
                        AXM.this.IlO(my);
                    }
                    if (i2 != 20000) {
                        my.IlO(i2, lEW.IlO(i2));
                    } else if (myIlO.EO == null) {
                        AXM.this.IlO(my);
                    } else {
                        my.IlO(myIlO);
                        com.bytedance.sdk.openadsdk.cl.EO.MY(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.AXM.5.1
                            @Override // com.bytedance.sdk.openadsdk.cl.tV
                            public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                                return androidx.camera.core.processing.util.a.d(C2543s.j);
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.component.Bc.IlO.IlO
                public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, IOException iOException) {
                    String message;
                    if (iOException != null) {
                        message = iOException.getMessage();
                    } else {
                        message = "";
                    }
                    my.IlO(-2, message);
                    if (eo != null) {
                        String strTV = eo.tV();
                        com.bytedance.sdk.openadsdk.utils.oeT.IlO(strTV);
                        com.bytedance.sdk.openadsdk.ea.IlO.Cc.IlO(C2543s.j, strTV, -1, message);
                    }
                    com.bytedance.sdk.openadsdk.cl.EO.EO(new com.bytedance.sdk.openadsdk.cl.tV() { // from class: com.bytedance.sdk.openadsdk.core.AXM.5.4
                        @Override // com.bytedance.sdk.openadsdk.cl.tV
                        public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
                            return androidx.camera.core.processing.util.a.d(C2543s.j);
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.xF
    public JSONObject IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return jSONObject;
        }
        try {
            int iOptInt = jSONObject.optInt("cypher", -1);
            String strOptString = jSONObject.optString("message");
            String strOptString2 = jSONObject.optString("auction_price", "");
            String strMY = MY(iOptInt, strOptString);
            if (TextUtils.isEmpty(strMY)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(strMY);
            try {
                jSONObject2.put("auction_price", strOptString2);
                return jSONObject2;
            } catch (Throwable unused) {
                return jSONObject2;
            }
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    private void IlO(com.bytedance.sdk.component.Bc.MY.tV tVVar, JSONObject jSONObject) {
        try {
            if (EO(jSONObject) && jSONObject.optInt("cypher") == 4) {
                tVVar.MY("x-pgli18n", "4");
                tVVar.MY("Content-Type", "application/json; charset=utf-8");
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.xF
    public com.bytedance.sdk.component.adexpress.IlO.EO.IlO IlO() {
        com.bytedance.sdk.component.adexpress.IlO.EO.IlO IlO2 = null;
        if (!com.bytedance.sdk.openadsdk.core.settings.DmF.IlO()) {
            return null;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tpl_fetch_model", "date", 0L);
        String strYA = cl.tV().YA();
        String strMY = com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("tpl_fetch_model", "last_url", "");
        if (jCurrentTimeMillis <= cl.tV().tl() && jCurrentTimeMillis >= 0 && TextUtils.equals(strYA, strMY)) {
            String strMY2 = com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("tpl_fetch_model", Q6.B, "");
            try {
                if (!TextUtils.isEmpty(strMY2)) {
                    return com.bytedance.sdk.component.adexpress.IlO.EO.IlO.Cc(strMY2);
                }
            } catch (Exception unused) {
            }
        }
        try {
            com.bytedance.sdk.component.Bc.MY.MY myEO = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().EO();
            String strIlO = com.bytedance.sdk.openadsdk.lEW.tV.IlO(myEO, strYA);
            myEO.MY(strIlO);
            com.bytedance.sdk.component.Bc.MY myIlO = myEO.IlO();
            if (myIlO == null || !myIlO.vCE()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(myIlO.tV());
            jSONObject.put("template_fetch_url", strIlO);
            IlO2 = com.bytedance.sdk.component.adexpress.IlO.EO.IlO.IlO(jSONObject);
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tpl_fetch_model", "date", Long.valueOf(System.currentTimeMillis() / 1000));
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tpl_fetch_model", Q6.B, jSONObject.toString());
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tpl_fetch_model", "last_url", strYA);
            return IlO2;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("NetApiImpl", th.getMessage());
            return IlO2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.xF
    public void IlO(String str) {
        com.bytedance.sdk.component.Bc.MY.MY myEO = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().EO();
        myEO.MY(str);
        myEO.IlO("upload_bidding");
        myEO.IlO(7);
        myEO.IlO(new com.bytedance.sdk.component.Bc.IlO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.AXM.6
            @Override // com.bytedance.sdk.component.Bc.IlO.IlO
            public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, IOException iOException) {
            }

            @Override // com.bytedance.sdk.component.Bc.IlO.IlO
            public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, com.bytedance.sdk.component.Bc.MY my) {
                my.tV();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.xF
    public void IlO(JSONObject jSONObject, String str) {
        com.bytedance.sdk.component.Bc.MY.tV tVVarMY = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().MY();
        tVVarMY.MY(str);
        Pair<String, String> pairGenerateRequestHeader = ApmHelper.generateRequestHeader();
        tVVarMY.MY("cypher", (String) pairGenerateRequestHeader.first);
        tVVarMY.MY("transfer-param", (String) pairGenerateRequestHeader.second);
        tVVarMY.MY("x-pangle-target-idc", cl.tV().eDn());
        tVVarMY.IlO(jSONObject);
        tVVarMY.IlO(5);
        tVVarMY.IlO("apm_pv");
        tVVarMY.IlO(new com.bytedance.sdk.component.Bc.IlO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.AXM.7
            @Override // com.bytedance.sdk.component.Bc.IlO.IlO
            public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, IOException iOException) {
            }

            @Override // com.bytedance.sdk.component.Bc.IlO.IlO
            public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, com.bytedance.sdk.component.Bc.MY my) {
                my.tV();
            }
        });
    }
}
