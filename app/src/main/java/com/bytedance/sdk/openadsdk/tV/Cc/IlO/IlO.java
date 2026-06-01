package com.bytedance.sdk.openadsdk.tV.Cc.IlO;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import b0.b;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.c;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.ea.EO;
import com.bytedance.sdk.openadsdk.tV.Bc;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.Cc;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.DmF;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.MY;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.NV;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.bWL;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.ea;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.hp;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.lEW;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.tV;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.vCE;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import v.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static final Map<a, ea> IlO = Collections.synchronizedMap(new WeakHashMap());

    public static void Cc(a aVar, ea.IlO ilO) {
        ea eaVar;
        if (aVar == null || ilO == null || ilO.NV() <= 0 || (eaVar = IlO.get(aVar)) == null) {
            return;
        }
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVarTV = eaVar.tV();
        oeT oetCc = eaVar.Cc();
        if (aVarTV == null || oetCc == null) {
            return;
        }
        long jTV = ilO.tV();
        hp hpVar = new hp();
        hpVar.IlO(ilO.EO());
        hpVar.MY(jTV);
        hpVar.IlO(ilO.NV());
        JSONObject jSONObjectIlO = IlO(oetCc, eaVar.MY(), eaVar.EO(), aVarTV);
        int i2 = aVarTV.Cc;
        if (i2 > 0) {
            try {
                jSONObjectIlO.put("play_time", i2);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO ilO2 = new com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO(oetCc, zLG.IlO(oetCc), jSONObjectIlO, hpVar);
        ilO2.IlO(ilO.EV());
        IlO(ilO2, "play_buffer");
    }

    public static void EO(a aVar, ea.IlO ilO) {
        ea eaVar;
        if (aVar == null || ilO == null || (eaVar = IlO.get(aVar)) == null) {
            return;
        }
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVarTV = eaVar.tV();
        oeT oetCc = eaVar.Cc();
        if (aVarTV == null || oetCc == null) {
            return;
        }
        long jMY = ilO.MY();
        long jTV = ilO.tV();
        bWL bwl = new bWL(ilO.hp());
        bwl.IlO(ilO.EO());
        bwl.MY(jTV);
        JSONObject jSONObjectIlO = IlO(oetCc, eaVar.MY(), eaVar.EO(), aVarTV);
        int i2 = aVarTV.Cc;
        if (i2 > 0) {
            try {
                jSONObjectIlO.put("play_time", i2);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO ilO2 = new com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO(oetCc, zLG.IlO(oetCc), jSONObjectIlO, bwl);
        ilO2.IlO(ilO.EV());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jMY);
            jSONObject.put("percent", ilO.Bc());
            IlO(ilO2, "play_error", jSONObject);
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", e4);
        }
        IlO.remove(aVar);
    }

    public static void tV(a aVar, ea.IlO ilO) {
        ea eaVar;
        if (aVar == null || ilO == null || (eaVar = IlO.get(aVar)) == null) {
            return;
        }
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVarTV = eaVar.tV();
        oeT oetCc = eaVar.Cc();
        if (aVarTV == null || oetCc == null) {
            return;
        }
        long jMY = ilO.MY();
        long jTV = ilO.tV();
        MY my = new MY();
        my.IlO(ilO.EO());
        my.MY(jTV);
        my.IlO(ilO.Cc());
        my.MY(ilO.vCE());
        com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO ilO2 = new com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO(oetCc, zLG.IlO(oetCc), IlO(oetCc, eaVar.MY(), eaVar.EO(), aVarTV), my);
        ilO2.IlO(ilO.EV());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jMY);
            jSONObject.put("percent", ilO.Bc());
            IlO(ilO2, "endcard_skip", jSONObject);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", e);
        }
    }

    public static JSONObject IlO(oeT oet, String str, int i2, com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("session_id", str);
            }
            if (i2 > 0) {
                jSONObject.put("play_type", String.valueOf(i2));
            }
            if (oet != null) {
                c cVarFdM = oet.fdM();
                if (cVarFdM != null) {
                    jSONObject.put("video_resolution", cVarFdM.e);
                    jSONObject.put("video_size", Long.valueOf(cVarFdM.f4687c));
                    jSONObject.put("video_url", cVarFdM.g);
                    jSONObject.put("player_type", aVar.cL());
                    jSONObject.put("video_encode_type", aVar.bWL() ? 1 : 0);
                }
                if (aVar.IlO()) {
                    jSONObject.put("pag_json_data", new JSONObject(aVar.EO().toString()).toString());
                }
                jSONObject.put("dp_creative_type", oet.lQ());
            }
            return jSONObject;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", e);
            return jSONObject;
        }
    }

    public static void MY(com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO<DmF> ilO) {
        EO.IlO("load_video_cancel", ilO);
    }

    public static void MY(a aVar, ea.IlO ilO) {
        ea eaVar;
        if (aVar == null || ilO == null || (eaVar = IlO.get(aVar)) == null) {
            return;
        }
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVarTV = eaVar.tV();
        oeT oetCc = eaVar.Cc();
        if (aVarTV == null || oetCc == null) {
            return;
        }
        long jMY = ilO.MY();
        long jTV = ilO.tV();
        if (jTV <= 0 || jMY <= 0) {
            return;
        }
        Cc cc = new Cc();
        cc.IlO(ilO.EO());
        cc.MY(jTV);
        JSONObject jSONObjectIlO = IlO(oetCc, eaVar.MY(), eaVar.EO(), aVarTV);
        int i2 = aVarTV.Cc;
        if (i2 > 0) {
            try {
                jSONObjectIlO.put("play_time", i2);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO ilO2 = new com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO(oetCc, zLG.IlO(oetCc), jSONObjectIlO, cc);
        ilO2.IlO(ilO.EV());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jMY);
            jSONObject.put("percent", ilO.Bc());
            IlO(ilO2, "feed_continue", jSONObject);
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String tV(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        return new File(aVar.Cc(), aVar.cl()).getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long EO(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        if (aVar == null) {
            return 0L;
        }
        c cVarKBB = aVar.bWL() ? aVar.kBB() : aVar.vAh();
        if (cVarKBB != null) {
            return Double.valueOf(cVarKBB.f4688d * 1000.0d).longValue();
        }
        return 0L;
    }

    public static void IlO(com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO<NV> ilO) {
        EO.IlO("load_video_error", ilO);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:6|(1:8)(3:10|(1:16)(1:15)|(10:18|20|35|21|(1:23)|26|29|(1:32)|33|34)(1:19))|9|20|35|21|(0)|26|29|(0)|33|34) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0081, code lost:
    
        com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e A[Catch: JSONException -> 0x0074, TryCatch #0 {JSONException -> 0x0074, blocks: (B:21:0x006a, B:23:0x006e, B:26:0x0077), top: B:35:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void IlO(com.bytedance.sdk.openadsdk.core.model.oeT r9, v.a r10, com.bykv.vk.openvk.IlO.IlO.IlO.EO.a r11) {
        /*
            if (r9 == 0) goto L9f
            if (r10 == 0) goto L9f
            if (r11 != 0) goto L8
            goto L9f
        L8:
            java.lang.String r3 = com.bytedance.sdk.openadsdk.utils.pP.IlO()
            boolean r0 = r11.pP()
            r7 = 1
            r8 = 0
            if (r0 == 0) goto L17
            r0 = 3
        L15:
            r4 = r0
            goto L52
        L17:
            int r0 = r9.hHv()
            u.b r0 = com.bytedance.sdk.openadsdk.CacheDirFactory.getICacheDir(r0)
            b0.b r0 = (b0.b) r0
            r0.getClass()
            java.lang.String r0 = r11.Cc()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L4b
            java.lang.String r0 = r11.cl()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L39
            goto L4b
        L39:
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r11.Cc()
            java.lang.String r2 = r11.cl()
            r0.<init>(r1, r2)
            boolean r0 = r0.exists()
            goto L4c
        L4b:
            r0 = r8
        L4c:
            if (r0 == 0) goto L50
            r4 = r7
            goto L52
        L50:
            r0 = 2
            goto L15
        L52:
            com.bytedance.sdk.openadsdk.tV.Cc.MY.ea r0 = new com.bytedance.sdk.openadsdk.tV.Cc.MY.ea
            long r1 = android.os.SystemClock.elapsedRealtime()
            r6 = r9
            r5 = r11
            r0.<init>(r1, r3, r4, r5, r6)
            java.util.Map<v.a, com.bytedance.sdk.openadsdk.tV.Cc.MY.ea> r9 = com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO
            r9.put(r10, r0)
            org.json.JSONObject r9 = IlO(r6, r3, r4, r5)
            java.lang.String r10 = com.bytedance.sdk.openadsdk.utils.zLG.IlO(r6)
            int r11 = r5.Cc     // Catch: org.json.JSONException -> L74
            if (r11 <= 0) goto L77
            java.lang.String r0 = "play_time"
            r9.put(r0, r11)     // Catch: org.json.JSONException -> L74
            goto L77
        L74:
            r0 = move-exception
            r11 = r0
            goto L81
        L77:
            java.lang.String r11 = "is_mute"
            boolean r0 = r5.EV()     // Catch: org.json.JSONException -> L74
            r9.put(r11, r0)     // Catch: org.json.JSONException -> L74
            goto L88
        L81:
            java.lang.String r0 = "TTAD.VideoEventManager"
            java.lang.String r1 = ""
            com.bytedance.sdk.component.utils.oeT.IlO(r0, r1, r11)
        L88:
            com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO r11 = new com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO
            r0 = 0
            r11.<init>(r6, r10, r9, r0)
            int r9 = r5.cL()
            r10 = -1
            if (r9 != r10) goto L96
            goto L97
        L96:
            r7 = r8
        L97:
            r11.IlO(r7)
            java.lang.String r9 = "play_start"
            IlO(r11, r9)
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO(com.bytedance.sdk.openadsdk.core.model.oeT, v.a, com.bykv.vk.openvk.IlO.IlO.IlO.EO.a):void");
    }

    public static void MY(a aVar, ea.IlO ilO, Bc bc) {
        if (aVar == null || ilO == null) {
            return;
        }
        Cc(aVar, ilO);
        ea eaVar = IlO.get(aVar);
        if (eaVar == null) {
            return;
        }
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVarTV = eaVar.tV();
        oeT oetCc = eaVar.Cc();
        if (aVarTV == null || oetCc == null) {
            return;
        }
        long jMY = ilO.MY();
        long jTV = ilO.tV();
        vCE vce = new vCE();
        vce.MY(ilO.EO());
        vce.IlO(jTV);
        vce.IlO(ilO.DmF());
        JSONObject jSONObjectIlO = IlO(oetCc, eaVar.MY(), eaVar.EO(), aVarTV);
        int i2 = aVarTV.Cc;
        if (i2 > 0) {
            try {
                jSONObjectIlO.put("play_time", i2);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", e);
            }
        }
        IlO(ilO, oetCc, jSONObjectIlO);
        com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO ilO2 = new com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO(oetCc, zLG.IlO(oetCc), jSONObjectIlO, vce);
        ilO2.IlO(ilO.EV());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jMY);
            jSONObject.put("percent", ilO.Bc());
            IlO(ilO2, "feed_over", jSONObject, bc);
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", e4);
        }
        IlO.remove(aVar);
    }

    public static void IlO(Context context, a aVar, ea.IlO ilO, Bc bc) {
        ea eaVar;
        if (context == null || aVar == null || ilO == null || (eaVar = IlO.get(aVar)) == null) {
            return;
        }
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVarTV = eaVar.tV();
        oeT oetCc = eaVar.Cc();
        if (aVarTV == null || oetCc == null) {
            return;
        }
        if (!ilO.EV()) {
            IlO(oetCc, aVarTV, ilO);
        }
        lEW lew = new lEW();
        lew.IlO(ilO.rp() ? 1 : 0);
        ((b) CacheDirFactory.getICacheDir(oetCc.hHv())).getClass();
        long length = 0;
        if (!TextUtils.isEmpty(aVarTV.Cc()) && !TextUtils.isEmpty(aVarTV.cl())) {
            String strCc = aVarTV.Cc();
            String strCl = aVarTV.cl();
            File fileA = n7.b.a(strCc, strCl);
            if (fileA.exists()) {
                length = fileA.length();
            } else {
                File fileC = n7.b.c(strCc, strCl);
                if (fileC.exists()) {
                    length = fileC.length();
                }
            }
        }
        lew.MY(length);
        lew.IlO(SystemClock.elapsedRealtime() - eaVar.IlO());
        JSONObject jSONObjectIlO = IlO(oetCc, eaVar.MY(), eaVar.EO(), aVarTV);
        int i2 = aVarTV.Cc;
        if (i2 > 0) {
            try {
                jSONObjectIlO.put("play_time", i2);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO ilO2 = new com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO(oetCc, zLG.IlO(oetCc), jSONObjectIlO, lew);
        ilO2.IlO(ilO.EV());
        IlO(ilO2, "feed_play", bc);
    }

    public static void IlO(a aVar, ea.IlO ilO) {
        ea eaVar;
        if (aVar == null || ilO == null || (eaVar = IlO.get(aVar)) == null) {
            return;
        }
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVarTV = eaVar.tV();
        oeT oetCc = eaVar.Cc();
        if (aVarTV == null || oetCc == null) {
            return;
        }
        long jMY = ilO.MY();
        long jTV = ilO.tV();
        if (jTV <= 0 || jMY <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.tV.Cc.MY.Bc bc = new com.bytedance.sdk.openadsdk.tV.Cc.MY.Bc();
        bc.IlO(ilO.EO());
        bc.MY(jTV);
        JSONObject jSONObjectIlO = IlO(oetCc, eaVar.MY(), eaVar.EO(), aVarTV);
        int i2 = aVarTV.Cc;
        if (i2 > 0) {
            try {
                jSONObjectIlO.put("play_time", i2);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", th);
            }
        }
        IlO(ilO, oetCc, jSONObjectIlO);
        com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO ilO2 = new com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO(oetCc, zLG.IlO(oetCc), jSONObjectIlO, bc);
        ilO2.IlO(ilO.EV());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jMY);
            jSONObject.put("percent", ilO.Bc());
            IlO(ilO2, "feed_pause", jSONObject);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", e);
        }
    }

    private static void IlO(ea.IlO ilO, oeT oet, JSONObject jSONObject) {
        if (oet != null) {
            try {
                if (oet.eeU() != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("speed_type", oet.eeU().MY());
                    jSONObject2.put("speed", oet.eeU().IlO());
                    jSONObject2.put("speed_duration", ilO.IlO());
                    jSONObject.put("pag_json_data", jSONObject2.toString());
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", th);
            }
        }
    }

    public static void IlO(a aVar, ea.IlO ilO, Bc bc) {
        if (aVar == null || ilO == null) {
            return;
        }
        Cc(aVar, ilO);
        ea eaVar = IlO.get(aVar);
        if (eaVar == null) {
            return;
        }
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVarTV = eaVar.tV();
        oeT oetCc = eaVar.Cc();
        if (aVarTV == null || oetCc == null) {
            return;
        }
        long jMY = ilO.MY();
        long jTV = ilO.tV();
        tV tVVar = new tV();
        tVVar.MY(ilO.EO());
        tVVar.IlO(jTV);
        tVVar.IlO(ilO.lEW());
        tVVar.MY(ilO.DmF());
        JSONObject jSONObjectIlO = IlO(oetCc, eaVar.MY(), eaVar.EO(), aVarTV);
        int i2 = aVarTV.Cc;
        if (i2 > 0) {
            try {
                jSONObjectIlO.put("play_time", i2);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", e);
            }
        }
        IlO(ilO, oetCc, jSONObjectIlO);
        com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO ilO2 = new com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO(oetCc, zLG.IlO(oetCc), jSONObjectIlO, tVVar);
        ilO2.IlO(ilO.EV());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jMY);
            jSONObject.put("percent", ilO.Bc());
            IlO(ilO2, "feed_break", jSONObject, bc);
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", e4);
        }
    }

    public static void IlO(a aVar, boolean z2, String str) {
        ea eaVar;
        if (aVar == null || (eaVar = IlO.get(aVar)) == null) {
            return;
        }
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVarTV = eaVar.tV();
        oeT oetCc = eaVar.Cc();
        if (aVarTV == null || oetCc == null) {
            return;
        }
        JSONObject jSONObjectIlO = IlO(oetCc, eaVar.MY(), eaVar.EO(), aVarTV);
        try {
            int i2 = aVarTV.Cc;
            if (i2 > 0) {
                jSONObjectIlO.put("play_time", i2);
            }
            jSONObjectIlO.put("is_mute", z2 ? 1 : 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("from", str);
            jSONObjectIlO.put("pag_json_data", jSONObject);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.VideoEventManager", "", e);
        }
        IlO(new com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO(oetCc, zLG.IlO(oetCc), jSONObjectIlO, null), "mute_state_change");
    }

    private static void IlO(com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO ilO, String str) {
        IlO(ilO, str, (JSONObject) null, (Bc) null);
    }

    private static void IlO(com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO ilO, String str, JSONObject jSONObject) {
        IlO(ilO, str, jSONObject, (Bc) null);
    }

    private static void IlO(com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO ilO, String str, Bc bc) {
        IlO(ilO, str, (JSONObject) null, bc);
    }

    private static void IlO(final com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO ilO, String str, final JSONObject jSONObject, final Bc bc) {
        if (ilO == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (ilO.Cc() && !TextUtils.isEmpty(ilO.MY())) {
            String strMY = ilO.MY();
            strMY.getClass();
            if (strMY.equals("stream") || strMY.equals("embeded_ad")) {
                str = "customer_".concat(String.valueOf(str));
            }
        }
        final String str2 = str;
        com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), ilO.IlO(), ilO.MY(), str2, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.1
            @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
            public JSONObject IlO() {
                Bc bc2;
                try {
                    JSONObject jSONObjectEO = ilO.EO();
                    if (ilO.tV() != null) {
                        ilO.tV().IlO(jSONObjectEO);
                    }
                    if (("feed_play".equals(str2) || "feed_over".equals(str2) || "feed_break".equals(str2)) && (bc2 = bc) != null) {
                        bc2.IlO(jSONObjectEO);
                    }
                    jSONObject.put("ad_extra_data", jSONObjectEO.toString());
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    private static void IlO(final oeT oet, final com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar, final ea.IlO ilO) {
        EO.IlO();
        EO.IlO("pangle_video_play_state", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.2
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("service_duration", IlO.EO(aVar));
                jSONObject.put("player_duration", ilO.tV());
                jSONObject.put("cache_path_type", CacheDirFactory.getCacheType());
                jSONObject.put("url", aVar.zPa());
                jSONObject.put("path", IlO.tV(aVar));
                jSONObject.put("player_type", aVar.cL());
                com.bytedance.sdk.openadsdk.ea.IlO.tV tVVarIlO = com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("pangle_video_play_state");
                oeT oet2 = oet;
                return tVVarIlO.IlO(oet2 != null ? oet2.OyN() : 0).MY(jSONObject.toString());
            }
        });
    }
}
