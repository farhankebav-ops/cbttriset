package com.bytedance.sdk.openadsdk.core.rp.Cc;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.a;
import com.bytedance.sdk.component.MY.IlO.Bc;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.ea.EO;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.DmF;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.EV;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.NV;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.rp;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import org.json.JSONObject;
import r4.c;
import t.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public static final b IlO = new c(1);

    /* JADX INFO: Access modifiers changed from: private */
    public static void EO(a aVar, oeT oet, AdSlot adSlot) {
        if (IlO(aVar)) {
            com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.MY((com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO<DmF>) new com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO(oet, zLG.EO(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO(oet, (String) null, -1, aVar), new DmF(aVar.zPa(), aVar.vCE())));
        }
    }

    private static boolean IlO(a aVar) {
        return true;
    }

    private static void MY(a aVar, oeT oet, AdSlot adSlot) {
        if (IlO(aVar)) {
            EO.IlO("load_video_start", new com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO(oet, zLG.EO(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO(oet, (String) null, -1, aVar), new EV(aVar.zPa(), aVar.hp() ? aVar.rp() : aVar.vCE())));
        }
    }

    public static void IlO(final a aVar, final t.a aVar2) {
        oeT oet;
        AdSlot adSlot;
        if ((aVar.vCE() > 0 || aVar.hp()) && aVar.cL() != -2) {
            if (aVar.cL() != 1) {
                aVar.Cc(6000);
                aVar.vCE(6000);
                aVar.Bc(6000);
                boolean z2 = aVar.Cc("material_meta") != null && (aVar.Cc("material_meta") instanceof oeT);
                boolean z7 = aVar.Cc("ad_slot") != null && (aVar.Cc("ad_slot") instanceof AdSlot);
                if (z2 && z7) {
                    oeT oet2 = (oeT) aVar.Cc("material_meta");
                    AdSlot adSlot2 = (AdSlot) aVar.Cc("ad_slot");
                    MY(aVar, oet2, adSlot2);
                    oet = oet2;
                    adSlot = adSlot2;
                } else {
                    oet = null;
                    adSlot = null;
                }
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                final AdSlot adSlot3 = adSlot;
                final oeT oet3 = oet;
                final t.a aVar3 = new t.a() { // from class: com.bytedance.sdk.openadsdk.core.rp.Cc.IlO.1
                    @Override // t.a
                    public void IlO(a aVar4, int i2) {
                        t.a aVar5 = aVar2;
                        if (aVar5 != null) {
                            aVar5.IlO(aVar4, i2);
                        }
                        if (oet3 == null || adSlot3 == null) {
                            return;
                        }
                        IlO.MY(aVar, oet3, adSlot3, SystemClock.elapsedRealtime() - jElapsedRealtime);
                    }

                    @Override // t.a
                    public void MY(a aVar4, int i2) {
                        AdSlot adSlot4;
                        t.a aVar5 = aVar2;
                        if (aVar5 != null) {
                            aVar5.IlO(aVar4, i2);
                        }
                        oeT oet4 = oet3;
                        if (oet4 != null && (adSlot4 = adSlot3) != null) {
                            IlO.EO(aVar, oet4, adSlot4);
                        }
                        aVar.cl();
                    }

                    @Override // t.a
                    public void IlO(a aVar4, int i2, String str) {
                        t.a aVar5 = aVar2;
                        if (aVar5 != null) {
                            aVar5.IlO(aVar4, i2, str);
                        }
                        if (oet3 == null || adSlot3 == null) {
                            return;
                        }
                        IlO.MY(aVar, oet3, adSlot3, SystemClock.elapsedRealtime() - jElapsedRealtime, i2, str);
                    }
                };
                if (!IlO(aVar.zPa())) {
                    if (aVar2 != null) {
                        aVar2.IlO(aVar, 404, "unexpected url: " + aVar.zPa());
                    }
                    MY(aVar, oet3, adSlot3, SystemClock.elapsedRealtime() - jElapsedRealtime, -1, "video url is invalid");
                    return;
                }
                lEW lew = new lEW("VideoPreload") { // from class: com.bytedance.sdk.openadsdk.core.rp.Cc.IlO.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ((c) IlO.IlO).a(cl.IlO(), aVar, aVar3);
                        } catch (Throwable th) {
                            th.getMessage();
                        }
                    }
                };
                if (mmj.vCE()) {
                    mmj.MY(lew);
                    return;
                } else {
                    lew.run();
                    return;
                }
            }
        }
        if (aVar2 != null) {
            aVar2.IlO(aVar, 100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MY(a aVar, oeT oet, AdSlot adSlot, long j, int i2, String str) {
        if (IlO(aVar)) {
            String strEO = zLG.EO(adSlot.getDurationSlotType());
            JSONObject jSONObjectIlO = com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO(oet, (String) null, -1, aVar);
            NV nv = new NV();
            nv.IlO(aVar.zPa());
            nv.IlO(aVar.vCE());
            nv.MY(j);
            nv.IlO(i2);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            nv.MY(str);
            nv.EO("");
            com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO((com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO<NV>) new com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO(oet, strEO, jSONObjectIlO, nv));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MY(a aVar, oeT oet, AdSlot adSlot, long j) {
        if (IlO(aVar)) {
            String strEO = zLG.EO(adSlot.getDurationSlotType());
            JSONObject jSONObjectIlO = com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.IlO(oet, (String) null, -1, aVar);
            rp rpVar = new rp();
            rpVar.IlO(aVar.zPa());
            rpVar.IlO(aVar.vCE());
            rpVar.MY(j);
            if (aVar.oeT() == 1) {
                rpVar.EO(1L);
            } else {
                rpVar.EO(0L);
            }
            EO.IlO("load_video_success", new com.bytedance.sdk.openadsdk.tV.Cc.MY.IlO(oet, strEO, jSONObjectIlO, rpVar));
        }
    }

    public static boolean IlO(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.regionMatches(true, 0, "ws:", 0, 3)) {
            str2 = "http:" + str.substring(3);
        } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
            str2 = "https:" + str.substring(4);
        } else {
            str2 = str;
        }
        return Bc.EO(str2) != null;
    }
}
