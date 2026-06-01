package com.bytedance.sdk.openadsdk.core.lEW;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp {
    private static String IlO;
    private static String MY;

    public static String EO() {
        Map<String, com.bytedance.sdk.component.adexpress.IlO.EO.IlO> mapIlO;
        com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilO;
        String strEO;
        if (MY == null) {
            MY = com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("tt_sp", "js_render_v3_ver", "");
        }
        com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilOMY = com.bytedance.sdk.component.adexpress.IlO.MY.lEW.MY();
        if (ilOMY != null && (mapIlO = ilOMY.IlO()) != null && (ilO = mapIlO.get("v3")) != null && (strEO = ilO.EO()) != null && !strEO.equals(MY)) {
            MY = strEO;
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_sp", "js_render_v3_ver", strEO);
        }
        return MY;
    }

    public static void IlO() {
        com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().IlO(new com.bytedance.sdk.component.adexpress.IlO.IlO.MY() { // from class: com.bytedance.sdk.openadsdk.core.lEW.rp.1
            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.MY
            public int IlO(String str, ContentValues contentValues, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), str, contentValues, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.MY
            public Cursor IlO(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
                return new com.bytedance.sdk.openadsdk.multipro.aidl.EO(com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), str, strArr, str2, strArr2, str3, str4, str5));
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.MY
            public int IlO(String str, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), str, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.MY
            public void IlO(String str, ContentValues contentValues) {
                com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), str, contentValues);
            }
        });
        com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().IlO(new com.bytedance.sdk.component.adexpress.IlO.IlO.EO() { // from class: com.bytedance.sdk.openadsdk.core.lEW.rp.2

            /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.lEW.rp$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            public class AnonymousClass1 implements Runnable {
                final /* synthetic */ int EO;
                final /* synthetic */ MessageQueue[] IlO;
                final /* synthetic */ int MY;

                public AnonymousClass1(MessageQueue[] messageQueueArr, int i2, int i8) {
                    this.IlO = messageQueueArr;
                    this.MY = i2;
                    this.EO = i8;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.IlO[0] = Looper.myQueue();
                    IlO(this.IlO[0], this.MY, this.EO);
                }
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public com.bytedance.sdk.component.Bc.MY.MY Bc() {
                com.bytedance.sdk.component.Bc.MY.MY myEO = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().EO();
                myEO.IlO(8);
                myEO.IlO("express_get");
                return myEO;
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public com.bytedance.sdk.component.adexpress.IlO.EO.IlO Cc() {
                return com.bytedance.sdk.openadsdk.core.cl.EO().IlO();
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public int DmF() {
                return 1;
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public Handler EO() {
                return com.bytedance.sdk.openadsdk.core.bWL.EO();
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public int EV() {
                return com.bytedance.sdk.openadsdk.core.cl.tV().fdM();
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public int NV() {
                return com.bytedance.sdk.openadsdk.core.cl.tV().Dxv();
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public ExecutorService bWL() {
                if (mmj.rp()) {
                    return mmj.NV();
                }
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public int cL() {
                return com.bytedance.sdk.openadsdk.AXM.IlO.IlO("gaussian_blur_type", 0);
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public boolean cl() {
                return com.bytedance.sdk.openadsdk.AXM.IlO.IlO("destroy_render_script", true);
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public int ea() {
                return BS.EO(com.bytedance.sdk.openadsdk.core.cl.IlO());
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public ExecutorService hp() {
                if (mmj.rp()) {
                    return mmj.Cc();
                }
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public String lEW() {
                return com.bytedance.sdk.openadsdk.core.DmF.MY().tV();
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public int rp() {
                return 0;
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public void tV() {
                int iDxv = com.bytedance.sdk.openadsdk.core.cl.tV().Dxv();
                int iFdM = com.bytedance.sdk.openadsdk.core.cl.tV().fdM();
                if (iDxv == 0 && iFdM == 0) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().IlO(iDxv);
                com.bytedance.sdk.component.adexpress.Cc.Cc.IlO().MY(iFdM);
                int iVCE = com.bytedance.sdk.openadsdk.AXM.IlO.vCE();
                int iCc = com.bytedance.sdk.openadsdk.AXM.IlO.Cc();
                if (iVCE == 0 && iCc == 0) {
                    return;
                }
                IlO(com.bytedance.sdk.openadsdk.core.bWL.EO().getLooper().getQueue(), iCc, iVCE);
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public com.bytedance.sdk.component.Bc.MY.IlO vCE() {
                com.bytedance.sdk.component.Bc.MY.IlO ilOTV = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().tV();
                ilOTV.IlO(8);
                ilOTV.IlO("express_down");
                return ilOTV;
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public int zPa() {
                return BS.Cc(com.bytedance.sdk.openadsdk.core.cl.IlO());
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public Context MY() {
                return com.bytedance.sdk.openadsdk.core.cl.IlO();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void MY(final MessageQueue messageQueue, final int i2) {
                if (messageQueue == null || i2 <= 0) {
                    return;
                }
                messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.sdk.openadsdk.core.lEW.rp.2.4
                    @Override // android.os.MessageQueue.IdleHandler
                    public boolean queueIdle() {
                        new com.bytedance.sdk.openadsdk.core.widget.IlO.MY(i2, false, messageQueue).MY();
                        return false;
                    }
                });
            }

            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.EO
            public int IlO() {
                if (com.bytedance.sdk.openadsdk.core.cl.tV() == null) {
                    return 0;
                }
                return com.bytedance.sdk.openadsdk.core.cl.tV().tV();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void IlO(final MessageQueue messageQueue, final int i2, final int i8) {
                if (messageQueue != null) {
                    final int iIlO = com.bytedance.sdk.openadsdk.AXM.IlO.IlO("ad_load_and_render_opt", "w_p_delay", 500);
                    Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.rp.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            MY(messageQueue, i2);
                            IlO(messageQueue, i8);
                        }
                    };
                    if (iIlO > 0) {
                        com.bytedance.sdk.openadsdk.core.bWL.EO().postDelayed(runnable, iIlO);
                    } else {
                        runnable.run();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void IlO(final MessageQueue messageQueue, final int i2) {
                if (messageQueue == null || i2 <= 0) {
                    return;
                }
                messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.sdk.openadsdk.core.lEW.rp.2.3
                    @Override // android.os.MessageQueue.IdleHandler
                    public boolean queueIdle() {
                        new com.bytedance.sdk.openadsdk.core.widget.IlO.MY(i2, true, messageQueue).MY();
                        return false;
                    }
                });
            }
        });
        com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().IlO(new com.bytedance.sdk.component.adexpress.IlO.IlO.tV() { // from class: com.bytedance.sdk.openadsdk.core.lEW.rp.3
            @Override // com.bytedance.sdk.component.adexpress.IlO.IlO.tV
            public void IlO(int i2) {
                com.bytedance.sdk.openadsdk.ea.EO.IlO().IlO(com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().MY(i2).vCE(com.bytedance.sdk.openadsdk.core.lEW.IlO(i2)));
            }
        });
        com.bytedance.sdk.component.DmF.IlO.IlO.IlO().IlO(new com.bytedance.sdk.component.DmF.IlO.MY() { // from class: com.bytedance.sdk.openadsdk.core.lEW.rp.4
            @Override // com.bytedance.sdk.component.DmF.IlO.MY
            public void IlO(String str, String str2, JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.tV.EO.EO(com.bytedance.sdk.openadsdk.utils.MY.IlO(), str, str2, jSONObject);
            }

            @Override // com.bytedance.sdk.component.DmF.IlO.MY
            public void IlO(com.bytedance.sdk.component.DmF.MY.IlO ilO, String str, String str2, JSONObject jSONObject, long j) {
                com.bytedance.sdk.openadsdk.core.model.oeT oetLEW = com.bytedance.sdk.openadsdk.core.model.oeT.lEW();
                oetLEW.AXM(ilO.IlO());
                oetLEW.xF(ilO.MY());
                oetLEW.cL(ilO.EO());
                com.bytedance.sdk.openadsdk.tV.EO.MY(oetLEW, str, str2, jSONObject, j);
            }

            @Override // com.bytedance.sdk.component.DmF.IlO.MY
            public void IlO(com.bytedance.sdk.component.DmF.MY.IlO ilO, String str, final String str2, final JSONObject jSONObject) {
                if (ilO != null) {
                    com.bytedance.sdk.openadsdk.core.model.oeT oetLEW = com.bytedance.sdk.openadsdk.core.model.oeT.lEW();
                    oetLEW.AXM(ilO.IlO());
                    oetLEW.xF(ilO.MY());
                    oetLEW.cL(ilO.EO());
                    com.bytedance.sdk.openadsdk.tV.EO.IlO(System.currentTimeMillis(), oetLEW, str, str2, new com.bytedance.sdk.openadsdk.ea.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.lEW.rp.4.1
                        @Override // com.bytedance.sdk.openadsdk.ea.EO.IlO
                        public JSONObject IlO() {
                            return jSONObject;
                        }
                    });
                }
            }
        });
    }

    @NonNull
    public static String MY() {
        String strEO;
        if (IlO == null) {
            IlO = com.bytedance.sdk.openadsdk.multipro.tV.tV.MY("tt_sp", "js_render_ver", "");
        }
        com.bytedance.sdk.component.adexpress.IlO.EO.IlO ilOMY = com.bytedance.sdk.component.adexpress.IlO.MY.lEW.MY();
        if (ilOMY != null && (strEO = ilOMY.EO()) != null && !strEO.equals(IlO)) {
            IlO = strEO;
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO("tt_sp", "js_render_ver", strEO);
        }
        return IlO;
    }
}
