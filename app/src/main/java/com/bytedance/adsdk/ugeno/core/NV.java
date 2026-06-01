package com.bytedance.adsdk.ugeno.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.bytedance.adsdk.ugeno.MY.IlO;
import com.bytedance.adsdk.ugeno.core.vCE;
import com.ironsource.C2461n2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV {
    private bWL Bc;
    private hp Cc;
    private String DmF;
    private com.bytedance.adsdk.ugeno.MY.EO<View> EO;
    private Context IlO;
    private JSONObject MY;
    private DmF NV;
    private boolean bWL;
    private List<String> ea;
    private com.bytedance.adsdk.ugeno.tV.IlO.IlO hp;
    private vCE lEW;
    private Bc tV;
    private zPa vCE;
    private Cc zPa;
    private boolean EV = true;
    private boolean rp = false;

    public NV(Context context) {
        this.IlO = context;
    }

    public void IlO(String str, DmF dmF) {
        this.NV = dmF;
        this.DmF = str;
        if (dmF != null) {
            this.MY = dmF.IlO();
        }
    }

    public com.bytedance.adsdk.ugeno.MY.EO<View> MY(vCE.IlO ilO, com.bytedance.adsdk.ugeno.MY.EO<View> eo) {
        List<vCE.IlO> listEO;
        IlO.C0032IlO c0032IlONV = null;
        if (!vCE.tV(ilO)) {
            return null;
        }
        String strEO = ilO.EO();
        MY myIlO = tV.IlO(strEO);
        if (myIlO == null) {
            Log.d("UGTemplateEngine", "not found component ".concat(String.valueOf(strEO)));
            this.bWL = true;
            if (this.ea == null) {
                this.ea = new ArrayList();
            }
            this.ea.add(strEO);
            return null;
        }
        com.bytedance.adsdk.ugeno.MY.EO eoIlO = myIlO.IlO(this.IlO);
        if (eoIlO == null) {
            return null;
        }
        eoIlO.Cc(com.bytedance.adsdk.ugeno.EO.MY.IlO(ilO.IlO(), this.MY));
        eoIlO.vCE(strEO);
        eoIlO.EO(ilO.tV());
        eoIlO.IlO(ilO);
        eoIlO.IlO(this.NV);
        if (eo instanceof com.bytedance.adsdk.ugeno.MY.IlO) {
            com.bytedance.adsdk.ugeno.MY.IlO ilO2 = (com.bytedance.adsdk.ugeno.MY.IlO) eo;
            eoIlO.IlO(ilO2);
            c0032IlONV = ilO2.NV();
        }
        Iterator<String> itKeys = ilO.tV().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strIlO = com.bytedance.adsdk.ugeno.EO.MY.IlO(ilO.tV().optString(next), this.MY);
            eoIlO.IlO(next, strIlO);
            if (c0032IlONV != null) {
                c0032IlONV.IlO(this.IlO, next, strIlO);
            }
        }
        if (eoIlO instanceof com.bytedance.adsdk.ugeno.MY.IlO) {
            List<vCE.IlO> listCc = ilO.Cc();
            if (listCc == null || listCc.size() <= 0) {
                if (TextUtils.equals(eoIlO.lMM(), "RecyclerLayout") && (listEO = this.lEW.EO()) != null && listEO.size() > 0) {
                    Iterator<vCE.IlO> it = listEO.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.MY.EO<View> eoMY = MY(it.next(), eoIlO);
                        if (eoMY != null && eoMY.mmj()) {
                            ((com.bytedance.adsdk.ugeno.MY.IlO) eoIlO).IlO(eoMY);
                        }
                    }
                }
                return eoIlO;
            }
            if (TextUtils.equals(eoIlO.lMM(), "Swiper") && listCc.size() != 1) {
                Log.e("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<vCE.IlO> it2 = listCc.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.MY.EO<View> eoMY2 = MY(it2.next(), eoIlO);
                if (eoMY2 != null && eoMY2.mmj()) {
                    ((com.bytedance.adsdk.ugeno.MY.IlO) eoIlO).IlO(eoMY2);
                }
            }
        }
        if (c0032IlONV != null) {
            eoIlO.IlO(c0032IlONV.IlO());
        }
        this.EO = eoIlO;
        return eoIlO;
    }

    public com.bytedance.adsdk.ugeno.MY.EO<View> IlO(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.MY = jSONObject2;
        zPa zpa = this.vCE;
        if (zpa != null) {
            zpa.IlO();
        }
        this.lEW = new vCE(jSONObject, jSONObject2, jSONObject3);
        this.hp = new com.bytedance.adsdk.ugeno.tV.IlO.IlO();
        if (!(this.Cc instanceof com.bytedance.adsdk.ugeno.core.IlO.MY)) {
            this.EO = IlO(this.lEW.IlO(), (com.bytedance.adsdk.ugeno.MY.EO<View>) null);
            zPa zpa2 = this.vCE;
            if (zpa2 != null) {
                zpa2.MY();
                this.EO.IlO(this.vCE);
            }
            IlO(this.EO);
            return this.EO;
        }
        this.lEW.MY();
        throw null;
    }

    public com.bytedance.adsdk.ugeno.MY.EO<View> IlO(vCE.IlO ilO, JSONObject jSONObject, JSONObject jSONObject2) {
        this.MY = jSONObject;
        zPa zpa = this.vCE;
        if (zpa != null) {
            zpa.IlO();
        }
        this.hp = new com.bytedance.adsdk.ugeno.tV.IlO.IlO();
        if (!(this.Cc instanceof com.bytedance.adsdk.ugeno.core.IlO.MY)) {
            this.EO = IlO(ilO, (com.bytedance.adsdk.ugeno.MY.EO<View>) null);
            zPa zpa2 = this.vCE;
            if (zpa2 != null) {
                zpa2.MY();
                this.EO.IlO(this.vCE);
            }
            IlO(this.EO);
            return this.EO;
        }
        throw null;
    }

    public com.bytedance.adsdk.ugeno.MY.EO<View> IlO(vCE.IlO ilO, com.bytedance.adsdk.ugeno.MY.EO<View> eo) {
        List<vCE.IlO> listEO;
        IlO.C0032IlO c0032IlONV = null;
        if (!vCE.tV(ilO)) {
            return null;
        }
        String strEO = ilO.EO();
        MY myIlO = tV.IlO(strEO);
        MY my = myIlO;
        if (myIlO == null) {
            this.bWL = true;
            if (this.ea == null) {
                this.ea = new ArrayList();
            }
            this.ea.add(strEO);
            strEO = "View";
            ilO.IlO("View");
            MY myIlO2 = tV.IlO("View");
            Log.d("UGTemplateEngine", "unknown component; use view widget");
            my = myIlO2;
            if (myIlO2 == null) {
                Log.d("UGTemplateEngine", "not found component ".concat("View"));
                return null;
            }
        }
        com.bytedance.adsdk.ugeno.MY.EO eoIlO = my.IlO(this.IlO);
        if (eoIlO == null) {
            return null;
        }
        JSONObject jSONObjectTV = ilO.tV();
        eoIlO.Cc(com.bytedance.adsdk.ugeno.EO.MY.IlO(ilO.IlO(), this.MY));
        eoIlO.vCE(strEO);
        eoIlO.EO(jSONObjectTV);
        eoIlO.IlO(ilO);
        eoIlO.MY(this.MY);
        vCE vce = this.lEW;
        if (vce == null) {
            eoIlO.IlO(true);
        } else {
            eoIlO.IlO(vce.tV());
        }
        eoIlO.IlO(this.NV);
        eoIlO.IlO(this.hp);
        Iterator<String> itKeys = jSONObjectTV.keys();
        if (eo instanceof com.bytedance.adsdk.ugeno.MY.IlO) {
            com.bytedance.adsdk.ugeno.MY.IlO ilO2 = (com.bytedance.adsdk.ugeno.MY.IlO) eo;
            c0032IlONV = ilO2.NV();
            eoIlO.IlO(ilO2);
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strIlO = com.bytedance.adsdk.ugeno.EO.MY.IlO(jSONObjectTV.optString(next), this.MY);
            eoIlO.IlO(next, strIlO);
            if (c0032IlONV != null) {
                c0032IlONV.IlO(this.IlO, next, strIlO);
            }
        }
        if (c0032IlONV != null) {
            eoIlO.IlO(c0032IlONV.IlO());
        }
        if (eoIlO instanceof com.bytedance.adsdk.ugeno.MY.IlO) {
            List<vCE.IlO> listCc = ilO.Cc();
            if (listCc != null && listCc.size() > 0) {
                if (TextUtils.equals(eoIlO.lMM(), "Swiper") && listCc.size() != 1) {
                    Log.e("UGTemplateEngine", "Swiper must be only one widget");
                }
                try {
                    Collections.sort(listCc, new Comparator<vCE.IlO>() { // from class: com.bytedance.adsdk.ugeno.core.NV.1
                        @Override // java.util.Comparator
                        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
                        public int compare(vCE.IlO ilO3, vCE.IlO ilO4) {
                            return ilO3.tV().optInt(C2461n2.f9470u, 0) - ilO4.tV().optInt(C2461n2.f9470u, 0);
                        }
                    });
                } catch (Throwable unused) {
                }
                Iterator<vCE.IlO> it = listCc.iterator();
                while (it.hasNext()) {
                    com.bytedance.adsdk.ugeno.MY.EO<View> eoIlO2 = IlO(it.next(), (com.bytedance.adsdk.ugeno.MY.EO<View>) eoIlO);
                    if (eoIlO2 != null && !eoIlO2.KC()) {
                        ((com.bytedance.adsdk.ugeno.MY.IlO) eoIlO).IlO(eoIlO2, eoIlO2.OOq());
                    }
                }
            } else {
                if (TextUtils.equals(eoIlO.lMM(), "RecyclerLayout") && (listEO = this.lEW.EO()) != null && listEO.size() > 0) {
                    Iterator<vCE.IlO> it2 = listEO.iterator();
                    while (it2.hasNext()) {
                        com.bytedance.adsdk.ugeno.MY.EO<View> eoIlO3 = IlO(it2.next(), (com.bytedance.adsdk.ugeno.MY.EO<View>) eoIlO);
                        if (eoIlO3 != null && eoIlO3.mmj()) {
                            ((com.bytedance.adsdk.ugeno.MY.IlO) eoIlO).IlO(eoIlO3);
                        }
                    }
                }
                return eoIlO;
            }
        }
        this.EO = eoIlO;
        return eoIlO;
    }

    public void MY(JSONObject jSONObject) {
        zPa zpa = this.vCE;
        if (zpa != null) {
            zpa.EO();
        }
        this.MY = jSONObject;
        IlO(this.EO, jSONObject);
        IlO(this.EO);
        if (this.vCE != null) {
            ea eaVar = new ea();
            eaVar.IlO(0);
            eaVar.IlO(this.EO);
            this.vCE.IlO(eaVar);
        }
    }

    private void MY(com.bytedance.adsdk.ugeno.MY.EO eo) {
        try {
            if (!eo.oc() || eo.wPn() == null || eo.wPn().vCE() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i18n", eo.wPn().vCE());
            this.MY.put("xNode", jSONObject);
        } catch (Exception unused) {
        }
    }

    public List<String> MY() {
        return this.ea;
    }

    public com.bytedance.adsdk.ugeno.MY.EO<View> IlO(JSONObject jSONObject) {
        zPa zpa = this.vCE;
        if (zpa != null) {
            zpa.IlO();
        }
        vCE vce = new vCE(jSONObject, this.MY);
        this.lEW = vce;
        if (!(this.Cc instanceof com.bytedance.adsdk.ugeno.core.IlO.MY)) {
            this.EO = MY(vce.IlO(), null);
            zPa zpa2 = this.vCE;
            if (zpa2 != null) {
                zpa2.MY();
                this.EO.IlO(this.vCE);
            }
            return this.EO;
        }
        vce.MY();
        throw null;
    }

    public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo, JSONObject jSONObject) {
        if (eo == null) {
            return;
        }
        if (eo instanceof com.bytedance.adsdk.ugeno.MY.IlO) {
            eo.IlO(jSONObject);
            List<com.bytedance.adsdk.ugeno.MY.EO<View>> listDmF = ((com.bytedance.adsdk.ugeno.MY.IlO) eo).DmF();
            if (listDmF == null || listDmF.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.MY.EO<View>> it = listDmF.iterator();
            while (it.hasNext()) {
                IlO(it.next(), jSONObject);
            }
            return;
        }
        eo.IlO(jSONObject);
    }

    private void IlO(com.bytedance.adsdk.ugeno.MY.EO<View> eo) {
        List<com.bytedance.adsdk.ugeno.MY.EO<View>> listDmF;
        if (eo == null) {
            return;
        }
        JSONObject jSONObjectKBB = eo.kBB();
        Iterator<String> itKeys = jSONObjectKBB.keys();
        com.bytedance.adsdk.ugeno.MY.IlO ilOVSq = eo.vSq();
        IlO.C0032IlO c0032IlONV = ilOVSq != null ? ilOVSq.NV() : null;
        MY(eo);
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strIlO = com.bytedance.adsdk.ugeno.EO.MY.IlO(jSONObjectKBB.optString(next), this.MY);
            eo.IlO(next, strIlO);
            if (c0032IlONV != null) {
                c0032IlONV.IlO(this.IlO, next, strIlO);
            }
        }
        eo.IlO(this.tV);
        eo.IlO(this.Cc);
        eo.IlO(this.Bc);
        Cc cc = this.zPa;
        if (cc != null) {
            eo.IlO(cc);
        }
        if ((eo instanceof com.bytedance.adsdk.ugeno.MY.IlO) && (listDmF = ((com.bytedance.adsdk.ugeno.MY.IlO) eo).DmF()) != null && listDmF.size() > 0) {
            Iterator<com.bytedance.adsdk.ugeno.MY.EO<View>> it = listDmF.iterator();
            while (it.hasNext()) {
                IlO(it.next());
            }
        }
        if (c0032IlONV != null) {
            eo.IlO(c0032IlONV.IlO());
        }
        eo.MY();
    }

    public void IlO(hp hpVar) {
        com.bytedance.adsdk.ugeno.core.IlO.IlO ilOCc = com.bytedance.adsdk.ugeno.Cc.IlO().Cc();
        if (ilOCc == null) {
            this.Cc = hpVar;
        } else {
            if (ilOCc.IlO(hpVar) == null) {
                this.Cc = hpVar;
                return;
            }
            throw null;
        }
    }

    public void IlO(bWL bwl) {
        this.Bc = bwl;
    }

    public boolean IlO() {
        return this.bWL;
    }

    public void IlO(Cc cc) {
        this.zPa = cc;
    }
}
