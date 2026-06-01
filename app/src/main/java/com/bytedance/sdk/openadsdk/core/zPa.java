package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView;
import com.bytedance.sdk.openadsdk.core.Bc;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.MY.MY;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.ssS;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa {
    private com.bytedance.sdk.openadsdk.IlO.MY.vCE Bc;
    private final Context EO;
    private e EV;
    private final com.bytedance.sdk.openadsdk.core.model.oeT IlO;
    private com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE MY;
    private final com.bytedance.sdk.openadsdk.IlO.MY.IlO NV;
    private com.bytedance.sdk.openadsdk.core.MY.IlO bWL;
    private com.bytedance.sdk.openadsdk.core.MY.MY hp;
    private long lEW;
    private final PAGNativeAd tV;
    private final String vCE;
    private List<View> Cc = new ArrayList();
    private final com.bytedance.sdk.openadsdk.tV.Bc DmF = new com.bytedance.sdk.openadsdk.tV.Bc();
    private final AtomicBoolean rp = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements View.OnLayoutChangeListener {
        private final com.bytedance.sdk.openadsdk.tV.Bc IlO;
        private final ViewGroup MY;

        public IlO(com.bytedance.sdk.openadsdk.tV.Bc bc, ViewGroup viewGroup) {
            this.IlO = bc;
            this.MY = viewGroup;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
            this.IlO.IlO(System.currentTimeMillis(), dY.IlO(this.MY));
        }
    }

    public zPa(Context context, PAGNativeAd pAGNativeAd, com.bytedance.sdk.openadsdk.core.model.oeT oet, String str, com.bytedance.sdk.openadsdk.IlO.MY.IlO ilO) {
        this.tV = pAGNativeAd;
        this.IlO = oet;
        this.EO = context;
        this.vCE = str;
        this.NV = ilO;
        if (oet.Jz() == 4) {
            this.MY = com.bytedance.sdk.openadsdk.es.IlO.IlO.Bc.IlO(context, oet, str);
        }
    }

    private void EO(ViewGroup viewGroup) {
        com.bytedance.sdk.openadsdk.core.model.oeT oet;
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.Cc != null) {
                JSONArray jSONArray = new JSONArray();
                for (View view : this.Cc) {
                    if (view != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("width", view.getWidth());
                            jSONObject2.put("height", view.getHeight());
                            jSONObject2.put("alpha", view.getAlpha());
                        } catch (Throwable unused) {
                        }
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("image_view", jSONArray.toString());
            }
            if (viewGroup != null) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("width", viewGroup.getWidth());
                    jSONObject3.put("height", viewGroup.getHeight());
                    jSONObject3.put("alpha", viewGroup.getAlpha());
                } catch (Throwable unused2) {
                }
                jSONObject.put("root_view", jSONObject3.toString());
            }
            if (this.NV.lEW() != null) {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("width", BS.EO(this.EO, r11.getWidth()) * 1.0f);
                    jSONObject4.put("height", BS.EO(this.EO, r11.getHeight()) * 1.0f);
                } catch (Throwable unused3) {
                }
                jSONObject.put("media_view", jSONObject4.toString());
            }
            com.bytedance.sdk.openadsdk.core.lEW.xF xFVarMY = this.NV.MY();
            if (xFVarMY != null && (oet = this.IlO) != null) {
                jSONObject.put("dynamic_show_type", oet.nvX());
                xFVarMY.IlO(jSONObject, this.IlO);
            }
            com.bytedance.sdk.openadsdk.tV.EO.IlO(this.IlO, this.vCE, jSONObject);
            com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(this.IlO);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.IlO("InteractionManager", "onShowFun json error", e);
        }
    }

    private Bc MY(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, @Nullable List<View> list3, com.bytedance.sdk.openadsdk.IlO.MY.vCE vce) {
        this.Bc = vce;
        viewGroup.addOnLayoutChangeListener(new IlO(this.DmF, viewGroup));
        this.Cc = list;
        Bc bcTV = tV(viewGroup);
        if (bcTV == null) {
            bcTV = new Bc(this.EO, viewGroup, false);
            viewGroup.addView(bcTV);
        }
        bcTV.IlO();
        bcTV.setRefClickViews(list2);
        if (list != null) {
            for (View view : this.Cc) {
                if (view != null) {
                    view.setTag(520093762, Boolean.TRUE);
                }
            }
            if (list3 != null) {
                list3.addAll(list);
            }
        }
        bcTV.setRefCreativeViews(list3);
        return bcTV;
    }

    private Bc tV(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof Bc) {
                return (Bc) childAt;
            }
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.tV.Bc IlO() {
        return this.DmF;
    }

    public void IlO(View view, int i2) {
        com.bytedance.sdk.openadsdk.IlO.MY.vCE vce = this.Bc;
        if (vce != null) {
            vce.onAdClicked();
        }
    }

    public void IlO(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, @Nullable List<View> list3, @Nullable View view, com.bytedance.sdk.openadsdk.IlO.MY.vCE vce) {
        IlO(viewGroup, list, list2, list3, vce);
        IlO(viewGroup, view);
        IlO(viewGroup, list2, list3);
    }

    private void IlO(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, @Nullable List<View> list3, com.bytedance.sdk.openadsdk.IlO.MY.vCE vce) {
        this.Bc = vce;
        viewGroup.addOnLayoutChangeListener(new IlO(this.DmF, viewGroup));
        this.Cc = list;
        IlO(list2, (com.bytedance.sdk.openadsdk.core.MY.EO) null);
        if (list != null) {
            for (View view : this.Cc) {
                if (view != null) {
                    view.setTag(520093762, Boolean.TRUE);
                }
            }
            if (list3 != null) {
                list3.addAll(list);
            }
        }
        IlO(list3, (com.bytedance.sdk.openadsdk.core.MY.EO) null);
    }

    private void MY(com.bytedance.sdk.openadsdk.core.MY.MY my, com.bytedance.sdk.openadsdk.core.MY.IlO ilO) {
        com.bytedance.sdk.openadsdk.IlO.MY.IlO ilO2 = this.NV;
        if (ilO2 != null && ilO2.MY() != null) {
            com.bytedance.sdk.openadsdk.core.lEW.xF xFVarMY = this.NV.MY();
            if ((my instanceof com.bytedance.sdk.openadsdk.core.lEW.DmF) && (ilO instanceof com.bytedance.sdk.openadsdk.core.lEW.lEW)) {
                xFVarMY.setClickListener((com.bytedance.sdk.openadsdk.core.lEW.DmF) my);
                xFVarMY.setClickCreativeListener((com.bytedance.sdk.openadsdk.core.lEW.lEW) ilO);
            }
            xFVarMY.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.Cc() { // from class: com.bytedance.sdk.openadsdk.core.zPa.3
                @Override // com.bytedance.sdk.openadsdk.core.widget.Cc
                public void IlO() {
                    if (zPa.this.Bc != null) {
                        zPa.this.Bc.onAdClicked();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.IlO.MY.IlO ilO3 = this.NV;
        if (ilO3 != null && ilO3.IlO() != null) {
            this.NV.IlO().setOnClickListener(ilO);
            this.NV.IlO().setOnTouchListener(ilO);
        }
        com.bytedance.sdk.openadsdk.IlO.MY.IlO ilO4 = this.NV;
        if (ilO4 != null) {
            ilO4.IlO(ilO);
            this.NV.IlO(my);
        }
    }

    private void IlO(List<View> list, com.bytedance.sdk.openadsdk.core.MY.EO eo) {
        if (com.bytedance.sdk.component.utils.hp.MY(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(eo);
                    view.setOnTouchListener(eo);
                }
            }
        }
    }

    public void IlO(e eVar) {
        this.EV = eVar;
        com.bytedance.sdk.openadsdk.core.MY.MY my = this.hp;
        if (my != null) {
            my.IlO(eVar);
        }
        com.bytedance.sdk.openadsdk.core.MY.IlO ilO = this.bWL;
        if (ilO != null) {
            ilO.IlO(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(ViewGroup viewGroup) {
        this.DmF.IlO(System.currentTimeMillis(), dY.IlO(viewGroup));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY() {
        if (this.lEW > 0) {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(String.valueOf(SystemClock.elapsedRealtime() - this.lEW), this.IlO, this.vCE, this.DmF);
            this.lEW = 0L;
        }
    }

    private void IlO(@NonNull ViewGroup viewGroup, @Nullable View view) {
        HashMap map = new HashMap();
        map.put("click_scence", 1);
        Context contextIlO = viewGroup != null ? com.bytedance.sdk.component.utils.MY.IlO(viewGroup) : null;
        if (contextIlO == null) {
            contextIlO = this.EO;
        }
        if (this.IlO.oc() == 2) {
            com.bytedance.sdk.openadsdk.core.model.oeT oet = this.IlO;
            String str = this.vCE;
            this.hp = new com.bytedance.sdk.openadsdk.core.lEW.DmF(contextIlO, oet, str, zLG.IlO(str));
        } else {
            com.bytedance.sdk.openadsdk.core.model.oeT oet2 = this.IlO;
            String str2 = this.vCE;
            this.hp = new com.bytedance.sdk.openadsdk.core.MY.MY(contextIlO, oet2, str2, zLG.IlO(str2));
        }
        this.hp.IlO(viewGroup);
        this.hp.IlO(this.EV);
        this.hp.MY(view);
        this.hp.IlO(this.MY);
        this.hp.IlO(this.tV);
        this.hp.IlO(map);
        this.hp.IlO(new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.core.zPa.1
            @Override // com.bytedance.sdk.openadsdk.core.MY.MY.IlO
            public void IlO(View view2, int i2) {
                if (zPa.this.Bc != null) {
                    zPa.this.Bc.onAdClicked();
                }
            }
        });
        if (this.IlO.oc() == 2) {
            Context context = this.EO;
            com.bytedance.sdk.openadsdk.core.model.oeT oet3 = this.IlO;
            String str3 = this.vCE;
            this.bWL = new com.bytedance.sdk.openadsdk.core.lEW.lEW(context, oet3, str3, zLG.IlO(str3));
        } else {
            Context context2 = this.EO;
            com.bytedance.sdk.openadsdk.core.model.oeT oet4 = this.IlO;
            String str4 = this.vCE;
            this.bWL = new com.bytedance.sdk.openadsdk.core.MY.IlO(context2, oet4, str4, zLG.IlO(str4));
        }
        this.bWL.IlO(viewGroup);
        this.bWL.IlO(this.EV);
        this.bWL.MY(view);
        this.bWL.IlO(this.MY);
        this.bWL.IlO(this.tV);
        this.bWL.IlO(map);
        this.bWL.IlO(new MY.IlO() { // from class: com.bytedance.sdk.openadsdk.core.zPa.2
            @Override // com.bytedance.sdk.openadsdk.core.MY.MY.IlO
            public void IlO(View view2, int i2) {
                if (zPa.this.Bc != null) {
                    zPa.this.Bc.onAdClicked();
                }
                com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(zPa.this.IlO, 9);
                zPa.this.NV.hp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(ViewGroup viewGroup, View view) {
        if (this.rp.get()) {
            return;
        }
        this.rp.set(true);
        if (this.tV instanceof com.bytedance.sdk.openadsdk.IlO.MY.IlO.EO) {
            com.bytedance.sdk.openadsdk.core.lEW.xF xFVarMY = this.NV.MY();
            if (xFVarMY != null) {
                xFVarMY.hp();
            }
            ((com.bytedance.sdk.openadsdk.IlO.MY.IlO.EO) this.tV).IlO(true);
        }
        this.DmF.IlO(System.currentTimeMillis(), dY.IlO(viewGroup));
        this.lEW = SystemClock.elapsedRealtime();
        EO(viewGroup);
        com.bytedance.sdk.openadsdk.IlO.MY.vCE vce = this.Bc;
        if (vce != null) {
            vce.IlO(this.tV);
        }
        if (this.IlO.tf()) {
            zLG.IlO(this.IlO, view);
        }
        if (this.IlO.QfH() != null) {
            this.IlO.QfH().IlO().IlO(0L);
        }
    }

    private void IlO(@NonNull ViewGroup viewGroup, Bc bc, List<View> list, @Nullable List<View> list2) {
        com.bytedance.sdk.openadsdk.core.MY.MY my = this.hp;
        if (my == null || this.bWL == null) {
            return;
        }
        bc.IlO(list, my);
        bc.IlO(list2, this.bWL);
        IlO(this.hp, this.bWL);
        IlO(bc, viewGroup);
    }

    private void IlO(@NonNull ViewGroup viewGroup, List<View> list, @Nullable List<View> list2) {
        com.bytedance.sdk.openadsdk.core.MY.MY my = this.hp;
        if (my == null || this.bWL == null) {
            return;
        }
        IlO(list, my);
        IlO(list2, this.bWL);
        IlO(this.hp, this.bWL);
        IlO(viewGroup);
    }

    private void IlO(com.bytedance.sdk.openadsdk.core.MY.MY my, com.bytedance.sdk.openadsdk.core.MY.IlO ilO) {
        if (this.IlO.oc() == 2) {
            MY(my, ilO);
        } else {
            IlO(ilO);
        }
    }

    private void IlO(com.bytedance.sdk.openadsdk.core.MY.IlO ilO) {
        if (com.bytedance.sdk.openadsdk.core.settings.hp.aP().EO(String.valueOf(this.IlO.hFV()))) {
            com.bytedance.sdk.openadsdk.IlO.MY.IlO ilO2 = this.NV;
            if (ilO2 != null && ilO2.IlO() != null) {
                this.NV.IlO().setOnClickListener(ilO);
                this.NV.IlO().setOnTouchListener(ilO);
            }
            com.bytedance.sdk.openadsdk.IlO.MY.IlO ilO3 = this.NV;
            if (ilO3 != null) {
                ilO3.IlO(ilO);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.IlO.MY.IlO ilO4 = this.NV;
        if (ilO4 != null && ilO4.IlO() != null) {
            PAGMediaView pAGMediaViewIlO = this.NV.IlO();
            com.bytedance.sdk.openadsdk.core.MY.EO eo = new com.bytedance.sdk.openadsdk.core.MY.EO() { // from class: com.bytedance.sdk.openadsdk.core.zPa.4
                @Override // com.bytedance.sdk.openadsdk.core.MY.EO
                public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
                    if (view instanceof PAGVideoMediaView) {
                        ((PAGVideoMediaView) view).handleInterruptVideo();
                    }
                }
            };
            pAGMediaViewIlO.setOnClickListener(eo);
            pAGMediaViewIlO.setOnTouchListener(eo);
        }
        com.bytedance.sdk.openadsdk.IlO.MY.IlO ilO5 = this.NV;
        if (ilO5 != null) {
            ilO5.IlO((com.bytedance.sdk.openadsdk.core.MY.IlO) null);
        }
    }

    private void IlO(Bc bc, final ViewGroup viewGroup) {
        bc.setCallback(new Bc.IlO() { // from class: com.bytedance.sdk.openadsdk.core.zPa.5
            @Override // com.bytedance.sdk.openadsdk.core.Bc.IlO
            public void IlO(boolean z2) {
                zPa.this.IlO(z2, viewGroup);
            }

            @Override // com.bytedance.sdk.openadsdk.core.Bc.IlO
            public void MY() {
                zPa.this.MY();
            }

            @Override // com.bytedance.sdk.openadsdk.core.Bc.IlO
            public void IlO() {
                zPa.this.MY(viewGroup);
            }

            @Override // com.bytedance.sdk.openadsdk.core.Bc.IlO
            public void IlO(View view) {
                zPa.this.MY(viewGroup, view);
            }
        });
    }

    private void IlO(final ViewGroup viewGroup) {
        ssS.IlO(viewGroup, true, 5, false, new ssS.MY() { // from class: com.bytedance.sdk.openadsdk.core.zPa.6
            @Override // com.bytedance.sdk.openadsdk.utils.ssS.MY
            public void IlO(boolean z2) {
                zPa.this.IlO(z2, viewGroup);
            }

            @Override // com.bytedance.sdk.openadsdk.utils.ssS.MY
            public void MY() {
                zPa.this.MY();
            }

            @Override // com.bytedance.sdk.openadsdk.utils.ssS.MY
            public void IlO() {
                zPa.this.MY(viewGroup);
            }

            @Override // com.bytedance.sdk.openadsdk.utils.ssS.MY
            public void IlO(View view, boolean z2) {
                if (!z2) {
                    com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(zPa.this.IlO, 8);
                } else {
                    com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(zPa.this.IlO, 4);
                    zPa.this.MY(viewGroup, view);
                }
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(boolean z2, ViewGroup viewGroup) {
        if (z2 && this.IlO.NLy() && !this.IlO.TkD()) {
            this.IlO.Bc(true);
            com.bytedance.sdk.openadsdk.core.model.oeT oet = this.IlO;
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, this.vCE, oet.hjY());
        }
        if (!z2 && this.lEW > 0) {
            String strValueOf = String.valueOf(SystemClock.elapsedRealtime() - this.lEW);
            this.DmF.IlO(System.currentTimeMillis(), dY.IlO(viewGroup));
            com.bytedance.sdk.openadsdk.tV.EO.IlO(strValueOf, this.IlO, this.vCE, this.DmF);
            this.lEW = 0L;
            return;
        }
        this.DmF.IlO(System.currentTimeMillis(), dY.IlO(viewGroup));
        this.lEW = SystemClock.elapsedRealtime();
    }
}
