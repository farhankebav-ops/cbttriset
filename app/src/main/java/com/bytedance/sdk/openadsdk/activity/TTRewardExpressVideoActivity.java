package com.bytedance.sdk.openadsdk.activity;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.reward.IlO.cl;
import com.bytedance.sdk.openadsdk.component.reward.view.lEW;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.tV.Bc;
import com.bytedance.sdk.openadsdk.utils.dY;
import com.bytedance.sdk.openadsdk.utils.ea;
import com.google.mlkit.common.MlKitException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import w.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTRewardExpressVideoActivity extends TTRewardVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean AXM() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.core.rp.tV.MY
    public boolean IlO(long j, boolean z2) {
        lEW lew = this.MY.tl;
        Bc bc = (lew == null || lew.IlO() == null) ? new Bc() : this.MY.tl.IlO().getAdShowTime();
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        ilO.vAh.IlO(ilO.tl.MY(), bc);
        HashMap map = new HashMap();
        lEW lew2 = this.MY.tl;
        if (lew2 != null) {
            map.put("dynamic_show_type", Integer.valueOf(lew2.DmF()));
            JSONObject jSONObjectIlO = this.MY.tl.IlO((JSONObject) null);
            if (jSONObjectIlO != null) {
                Iterator<String> itKeys = jSONObjectIlO.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        map.put(next, jSONObjectIlO.get(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        this.MY.vAh.IlO(new b() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity.1
            boolean IlO;

            @Override // w.b
            public void IlO(long j3, int i2) {
                if (this.IlO) {
                    return;
                }
                this.IlO = true;
                TTRewardExpressVideoActivity.this.tV.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                TTRewardExpressVideoActivity.this.cL();
                TTRewardExpressVideoActivity.this.MY.vAh.IlO(j3, j3);
                TTRewardExpressVideoActivity.this.MY.tl.MY(true);
                if (TTRewardExpressVideoActivity.this.MY.MY.vAh() == 36) {
                    com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = TTRewardExpressVideoActivity.this.MY;
                    if (ilO2.EO) {
                        ilO2.kBB.EO().tV();
                        ea.MY();
                    }
                }
                if (TTRewardExpressVideoActivity.this.MY.MY.vAh() == 21 && !TTRewardExpressVideoActivity.this.MY.MY.NV()) {
                    TTRewardExpressVideoActivity.this.MY.MY.MY(true);
                    TTRewardExpressVideoActivity.this.MY.DM.cl();
                }
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO3 = TTRewardExpressVideoActivity.this.MY;
                if (ilO3.EO) {
                    if (!ilO3.MY.FNH()) {
                        TTRewardExpressVideoActivity.this.IlO(false, 5);
                        if (!oeT.Cc(TTRewardExpressVideoActivity.this.MY.MY)) {
                            TTRewardExpressVideoActivity.this.MY.vAh.IlO("skip", true);
                        }
                    } else if (TTRewardExpressVideoActivity.this.MY.tl.DmF() == 1) {
                        TTRewardExpressVideoActivity.this.MY.YA.EO();
                    }
                } else if (!ilO3.MY.FNH()) {
                    if (!oeT.Cc(TTRewardExpressVideoActivity.this.MY.MY)) {
                        TTRewardExpressVideoActivity.this.MY.vAh.IlO("skip", true);
                    }
                    TTRewardExpressVideoActivity.this.finish();
                } else if (TTRewardExpressVideoActivity.this.MY.tl.DmF() == 1) {
                    TTRewardExpressVideoActivity.this.MY.YA.EO();
                }
                ((TTRewardVideoActivity) TTRewardExpressVideoActivity.this).hp = (int) (System.currentTimeMillis() / 1000);
                TTRewardExpressVideoActivity.this.vAh();
            }

            @Override // w.b
            public void MY(long j3, int i2) {
                TTRewardExpressVideoActivity.this.tV.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                es esVar = TTRewardExpressVideoActivity.this.MY.DM.ea;
                if (esVar != null) {
                    esVar.NV();
                }
                if (TTRewardExpressVideoActivity.this.MY.vAh.vCE()) {
                    TTRewardExpressVideoActivity.this.cl();
                    return;
                }
                TTRewardExpressVideoActivity.this.vAh();
                TTRewardExpressVideoActivity.this.MY.vAh.cL();
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                if (tTRewardExpressVideoActivity.MY.EO) {
                    tTRewardExpressVideoActivity.IlO(false, 3);
                } else {
                    tTRewardExpressVideoActivity.finish();
                }
                TTRewardExpressVideoActivity.this.MY.tl.IlO(true);
                cl clVar = TTRewardExpressVideoActivity.this.MY.vAh;
                clVar.IlO(1 ^ (clVar.nvX() ? 1 : 0), 2);
            }

            @Override // w.b
            public void IlO() {
                TTRewardExpressVideoActivity.this.tV.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                TTRewardExpressVideoActivity.this.cL();
                TTRewardExpressVideoActivity.this.vAh();
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                if (tTRewardExpressVideoActivity.MY.EO) {
                    tTRewardExpressVideoActivity.IlO(false, 6);
                } else {
                    tTRewardExpressVideoActivity.finish();
                }
                cl clVar = TTRewardExpressVideoActivity.this.MY.vAh;
                clVar.IlO(!clVar.nvX() ? 1 : 0, !TTRewardExpressVideoActivity.this.MY.vAh.nvX() ? 1 : 0);
                TTRewardExpressVideoActivity.this.MY.vAh.cL();
            }

            @Override // w.b
            public void IlO(long j3, long j8) {
                com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = TTRewardExpressVideoActivity.this.MY;
                if (!ilO2.KC && ilO2.vAh.vCE()) {
                    TTRewardExpressVideoActivity.this.MY.vAh.xF();
                }
                if (TTRewardExpressVideoActivity.this.MY.NV.get()) {
                    return;
                }
                TTRewardExpressVideoActivity.this.tV.removeMessages(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
                if (j3 != TTRewardExpressVideoActivity.this.MY.vAh.rp()) {
                    TTRewardExpressVideoActivity.this.cL();
                }
                if (TTRewardExpressVideoActivity.this.MY.vAh.vCE()) {
                    TTRewardExpressVideoActivity.this.MY.vAh.IlO(j3, j8);
                    int iMY = TTRewardExpressVideoActivity.this.MY.MY.MY();
                    boolean z7 = TTRewardExpressVideoActivity.this.MY.tl.lEW() && iMY >= 0;
                    TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                    long j9 = j3 / 1000;
                    tTRewardExpressVideoActivity.vCE = (int) (tTRewardExpressVideoActivity.MY.vAh.YA() - j9);
                    int i2 = (int) j9;
                    if ((TTRewardExpressVideoActivity.this.MY.xF.get() || TTRewardExpressVideoActivity.this.MY.EV.get()) && TTRewardExpressVideoActivity.this.MY.vAh.vCE()) {
                        TTRewardExpressVideoActivity.this.MY.vAh.xF();
                    }
                    TTRewardExpressVideoActivity.this.MY.DM.tV(i2);
                    if (TTRewardExpressVideoActivity.this.MY.vAh.tV()) {
                        dY dYVar = TTRewardExpressVideoActivity.this.DmF;
                        if (dYVar != null) {
                            dYVar.IlO(j3);
                            return;
                        }
                        return;
                    }
                    dY dYVar2 = TTRewardExpressVideoActivity.this.DmF;
                    if (dYVar2 == null || !dYVar2.IlO()) {
                        TTRewardExpressVideoActivity.this.MY(j3, j8);
                        lEW lew3 = TTRewardExpressVideoActivity.this.MY.tl;
                        if (lew3 != null && lew3.IlO() != null) {
                            TTRewardExpressVideoActivity.this.MY.tl.IlO().setTime(String.valueOf(TTRewardExpressVideoActivity.this.vCE), i2, 0, false);
                        }
                        TTRewardExpressVideoActivity tTRewardExpressVideoActivity2 = TTRewardExpressVideoActivity.this;
                        int i8 = tTRewardExpressVideoActivity2.vCE;
                        if (i8 > 0) {
                            if (!z7) {
                                tTRewardExpressVideoActivity2.MY.YA.IlO(String.valueOf(i8), null);
                                return;
                            }
                            if (i2 < iMY) {
                                tTRewardExpressVideoActivity2.MY.YA.IlO(String.valueOf(i8), null);
                                return;
                            }
                            if (tTRewardExpressVideoActivity2.MY.MY.vAh() != 5 && TTRewardExpressVideoActivity.this.MY.MY.vAh() != 33) {
                                TTRewardExpressVideoActivity.this.MY.IlO(true);
                                TTRewardExpressVideoActivity tTRewardExpressVideoActivity3 = TTRewardExpressVideoActivity.this;
                                tTRewardExpressVideoActivity3.MY.YA.IlO(String.valueOf(tTRewardExpressVideoActivity3.vCE), TTAdDislikeToast.getSkipText());
                                TTRewardExpressVideoActivity.this.MY.YA.Cc(true);
                                return;
                            }
                            TTRewardExpressVideoActivity tTRewardExpressVideoActivity4 = TTRewardExpressVideoActivity.this;
                            tTRewardExpressVideoActivity4.MY.YA.IlO(String.valueOf(tTRewardExpressVideoActivity4.vCE), null);
                        }
                    }
                }
            }
        });
        boolean zIlO = this.MY.vAh.IlO(j, z2, map, this.EO);
        if (zIlO && !z2) {
            ((TTRewardVideoActivity) this).rp = (int) (System.currentTimeMillis() / 1000);
        }
        return zIlO;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        oeT();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void Bc() {
    }
}
