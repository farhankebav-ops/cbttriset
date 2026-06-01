package com.bytedance.sdk.openadsdk.core.MY;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.lMM;
import com.bytedance.sdk.openadsdk.core.model.NV;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.bWL;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.bytedance.sdk.openadsdk.utils.zPa;
import com.ironsource.C2318f4;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import w.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends EO {
    private static int YA = Integer.MIN_VALUE;
    protected final String Bc;
    public bWL Cc;
    protected WeakReference<View> DmF;
    private boolean EO;
    protected NV EV;
    private String IlO;
    private WeakReference<Activity> MY;
    protected WeakReference<View> NV;
    protected e bWL;
    protected com.bytedance.sdk.openadsdk.core.EO.IlO cL;
    protected Map<String, Object> cl;
    protected boolean ea;
    protected com.bytedance.sdk.openadsdk.core.lEW.MY es;
    protected PAGNativeAd hp;
    protected final int lEW;
    protected IlO rp;
    protected Context tV;
    protected final oeT vCE;
    protected int xF;
    protected com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(View view, int i2);
    }

    public MY(@NonNull Context context, @NonNull oeT oet, @NonNull String str, int i2) {
        this.ea = false;
        this.xF = 0;
        this.EO = false;
        this.tV = context;
        this.vCE = oet;
        this.Bc = str;
        this.lEW = i2;
    }

    public void Cc(boolean z2) {
        this.ea = z2;
    }

    public void EO(int i2) {
        this.OOq = i2;
    }

    public boolean IlO(NV nv, Map<String, Object> map) {
        return false;
    }

    public void MY(View view) {
        if (view == null) {
            return;
        }
        this.NV = new WeakReference<>(view);
    }

    public View tV() {
        WeakReference<Activity> weakReference = this.MY;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.MY.get().findViewById(R.id.content);
    }

    public String vCE() {
        return this.IlO;
    }

    public static boolean EO(View view) {
        return 520093705 == view.getId() || 520093707 == view.getId() || 520093703 == view.getId() || IlO(view.getContext()) == view.getId() || zPa.tf == view.getId() || zPa.DYs == view.getId();
    }

    public View Cc() {
        WeakReference<Activity> weakReference = this.MY;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        View viewFindViewById = this.MY.get().findViewById(520093713);
        return viewFindViewById == null ? this.MY.get().findViewById(520093713) : viewFindViewById;
    }

    public void IlO(com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE vce) {
        this.zPa = vce;
    }

    public void MY(int i2) {
        this.wPn = i2;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.lEW.MY my) {
        this.es = my;
    }

    public void tV(int i2) {
        this.xF = i2;
    }

    public void IlO(PAGNativeAd pAGNativeAd) {
        this.hp = pAGNativeAd;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.EO.IlO ilO) {
        this.cL = ilO;
    }

    public void IlO(e eVar) {
        this.bWL = eVar;
    }

    public void IlO(IlO ilO) {
        this.rp = ilO;
    }

    public void IlO(Activity activity) {
        if (activity == null) {
            return;
        }
        this.MY = new WeakReference<>(activity);
    }

    public MY(@NonNull Context context, @NonNull oeT oet, @NonNull String str, int i2, boolean z2) {
        this(context, oet, str, i2);
        this.EO = z2;
    }

    public void IlO(View view) {
        if (view == null) {
            return;
        }
        this.DmF = new WeakReference<>(view);
    }

    public void IlO(Map<String, Object> map) {
        Map<String, Object> map2 = this.cl;
        if (map2 != null) {
            map2.putAll(map);
            map.putAll(this.cl);
        }
        this.cl = map;
    }

    public void IlO(int i2) {
        this.oc = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.MY.EO
    public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
        int i2;
        boolean z7;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        oeT oet;
        if (this.tV == null) {
            this.tV = cl.IlO();
        }
        if ((this.EO || !IlO(view, 1, f4, f8, f9, f10, sparseArray, z2)) && this.tV != null) {
            bWL bwl = this.Cc;
            if (bwl != null) {
                int i8 = bwl.rp;
                JSONObject jSONObject3 = bwl.hp;
                JSONObject jSONObject4 = bwl.cl;
                z7 = bwl.cL;
                i2 = i8;
                jSONObject = jSONObject3;
                jSONObject2 = jSONObject4;
            } else {
                i2 = -1;
                z7 = false;
                jSONObject = null;
                jSONObject2 = null;
            }
            long j = this.pP;
            long j3 = this.tl;
            WeakReference<View> weakReference = this.DmF;
            View view2 = weakReference == null ? null : weakReference.get();
            WeakReference<View> weakReference2 = this.NV;
            NV nvIlO = IlO(f4, f8, f9, f10, sparseArray, j, j3, view2, weakReference2 == null ? null : weakReference2.get(), vCE(), BS.Bc(this.tV), BS.DmF(this.tV), BS.lEW(this.tV), i2, jSONObject, jSONObject2);
            this.EV = nvIlO;
            if (IlO(nvIlO, this.cl)) {
                return;
            }
            if (this.bWL != null) {
                if (this.cl == null) {
                    this.cl = new HashMap();
                }
                this.cl.put("duration", Long.valueOf(this.bWL.Cc()));
            }
            if (!this.EO && !z7) {
                IlO ilO = this.rp;
                if (ilO != null) {
                    ilO.IlO(view, -1);
                }
                if (IlO(view, z2)) {
                    boolean zMY = OOq.MY(this.vCE);
                    String strIlO = zMY ? this.Bc : zLG.IlO(this.lEW);
                    if (view != null) {
                        try {
                            if (((Boolean) view.getTag(520093762)).booleanValue()) {
                                lMM.IlO(true);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    Activity activityIlO = view != null ? com.bytedance.sdk.component.utils.MY.IlO(view) : null;
                    boolean zIlO = lMM.IlO(activityIlO == null ? this.tV : activityIlO, this.vCE, this.lEW, this.hp, this.cL, strIlO, this.zPa, zMY, 0);
                    lMM.IlO(false);
                    if (zIlO || (oet = this.vCE) == null || oet.zTS() == null || this.vCE.zTS().EO() != 2) {
                        oeT oet2 = this.vCE;
                        if (oet2 != null && !zIlO && TextUtils.isEmpty(oet2.pFe()) && com.bytedance.sdk.openadsdk.tV.MY.IlO(this.Bc)) {
                            com.bytedance.sdk.openadsdk.es.IlO.IlO.Bc.IlO(this.tV, this.vCE, this.Bc).tV();
                        }
                        com.bytedance.sdk.openadsdk.tV.EO.IlO(C2318f4.f8523d, this.vCE, this.EV, this.Bc, zIlO, this.cl, z2 ? 1 : 2);
                        return;
                    }
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.tV.EO.IlO(C2318f4.f8523d, this.vCE, this.EV, this.Bc, true, this.cl, z2 ? 1 : 2);
        }
    }

    public boolean IlO(View view, boolean z2) {
        return IlO(view, this.vCE, z2);
    }

    public static boolean IlO(View view, oeT oet, boolean z2) {
        if (view != null && oet != null) {
            try {
                int i2 = com.bytedance.sdk.component.adexpress.dynamic.IlO.xF;
                String strValueOf = String.valueOf(view.getTag(i2));
                if (view.getTag(i2) != null && !TextUtils.isEmpty(strValueOf)) {
                    if (C2318f4.f8523d.equals(strValueOf)) {
                        return z2;
                    }
                    return true;
                }
            } catch (Exception unused) {
            }
            if (EO(view)) {
                return oet.tl() != 1 || z2;
            }
            if (oet.pP() == 1 && !z2) {
                return false;
            }
        }
        return true;
    }

    public NV IlO(float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, long j, long j3, View view, View view2, String str, float f11, int i2, float f12, int i8, JSONObject jSONObject, JSONObject jSONObject2) {
        return new NV.IlO().vCE(f4).Cc(f8).tV(f9).EO(f10).MY(j).IlO(j3).MY(BS.IlO(view)).IlO(BS.IlO(view2)).EO(BS.EO(view)).tV(BS.EO(view2)).tV(this.OOq).Cc(this.wPn).vCE(this.oc).IlO(sparseArray).MY(DmF.MY().IlO() ? 1 : 2).IlO(str).IlO(f11).EO(i2).MY(f12).IlO(i8).IlO(jSONObject).MY(jSONObject2).IlO();
    }

    public boolean IlO(View view, int i2, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
        if (this.es == null) {
            return false;
        }
        int[] iArrIlO = new int[2];
        int[] iArrEO = new int[2];
        WeakReference<View> weakReference = this.NV;
        if (weakReference != null) {
            iArrIlO = BS.IlO(weakReference.get());
            iArrEO = BS.EO(this.NV.get());
        }
        this.es.IlO(view, i2, new bWL.IlO().tV(f4).EO(f8).MY(f9).IlO(f10).MY(this.pP).IlO(this.tl).tV(iArrIlO[0]).Cc(iArrIlO[1]).vCE(iArrEO[0]).Bc(iArrEO[1]).IlO(sparseArray).IlO(z2).IlO());
        return true;
    }

    private static int IlO(Context context) {
        if (YA == Integer.MIN_VALUE) {
            YA = pP.Cc(context, "btn_native_creative");
        }
        return YA;
    }

    public void IlO(String str) {
        this.IlO = str;
    }
}
