package com.bytedance.sdk.openadsdk.core.NV.Cc;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.core.EV;
import com.bytedance.adsdk.ugeno.core.NV;
import com.bytedance.adsdk.ugeno.core.bWL;
import com.bytedance.adsdk.ugeno.core.hp;
import com.bytedance.adsdk.ugeno.tV.vCE;
import com.bytedance.sdk.component.adexpress.MY.lEW;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.lEW.xF;
import com.bytedance.sdk.openadsdk.core.model.bWL;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.unity3d.services.core.device.MimeTypes;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements bWL, hp, com.bytedance.sdk.component.adexpress.MY.tV<View>, com.bytedance.sdk.component.adexpress.dynamic.tV {
    private static long OOq = 0;
    private static float dY = 0.0f;
    private static float oc = 0.0f;
    private static float vSq = 0.0f;
    private static float wPn = 0.0f;
    protected static int xF = 24;
    protected WeakReference<View> AXM;
    protected FrameLayout Bc;
    protected oeT Cc;
    protected com.bytedance.sdk.component.adexpress.MY.bWL DmF;
    protected com.bytedance.adsdk.ugeno.MY.EO<View> EO;
    protected com.bytedance.adsdk.ugeno.MY.EO EV;
    protected NV IlO;
    protected Context MY;
    protected float bWL;
    protected long cL;
    protected long cl;
    protected float ea;
    protected float hp;
    protected JSONObject kBB;
    protected lEW lEW;
    private tV lMM;
    private xF nvX;
    protected String oeT;
    private com.bytedance.sdk.component.adexpress.MY.Bc pP;
    protected com.bytedance.adsdk.ugeno.MY.EO rp;
    protected JSONObject tV;
    private final boolean tl;
    protected IlO vCE;
    protected float zPa;
    protected boolean es = true;
    public SparseArray<EO.IlO> vAh = new SparseArray<>();
    private String YA = "";
    private final com.bytedance.sdk.component.lEW.lEW mmj = new com.bytedance.sdk.component.lEW.lEW("ugen_render_template") { // from class: com.bytedance.sdk.openadsdk.core.NV.Cc.EO.1
        @Override // java.lang.Runnable
        public void run() {
            EO eo = EO.this;
            eo.tV = eo.IlO();
            if (EO.this.nvX != null) {
                EO eo2 = EO.this;
                eo2.YA = eo2.nvX.getUgenTemplateErrorReason();
            } else {
                EO.this.YA = "expressView is null";
            }
            com.bytedance.sdk.openadsdk.core.bWL.EO().post(EO.this.DM);
        }
    };
    private final Runnable DM = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.NV.Cc.EO.2
        @Override // java.lang.Runnable
        public void run() {
            if (EO.this.pP != null) {
                EO eo = EO.this;
                eo.MY(eo.pP);
            }
        }
    };
    private boolean zLG = false;
    protected AtomicBoolean NV = new AtomicBoolean(false);

    static {
        if (cl.IlO() != null) {
            xF = cl.MY();
        }
    }

    public EO(Context context, oeT oet, boolean z2, IlO ilO, ViewGroup viewGroup) {
        this.MY = context;
        this.tl = z2;
        this.IlO = new NV(context);
        this.Cc = oet;
        this.vCE = ilO;
        this.Bc = new FrameLayout(context);
        if (viewGroup instanceof xF) {
            this.nvX = (xF) viewGroup;
        }
        this.oeT = ilO.tV();
        JSONObject jSONObjectMY = MY();
        this.kBB = jSONObjectMY;
        this.lMM = new tV(this.MY, this.Cc, this.oeT, jSONObjectMY);
    }

    private void DmF() {
        com.bytedance.adsdk.ugeno.MY.EO<T> EO;
        if (this.EO == null) {
            return;
        }
        if (this.Cc.Kn() && (EO = this.EO.EO("tvskip")) != 0) {
            EO.EO(8);
        }
        com.bytedance.adsdk.ugeno.MY.EO<T> EO2 = this.EO.EO("skip");
        if (EO2 != 0 && (EO2 instanceof com.bytedance.adsdk.ugeno.DmF.tV.EO)) {
            if (!com.bytedance.sdk.openadsdk.core.settings.hp.aP().hp(String.valueOf(this.Cc.hFV())) || this.Cc.vAh() == 5 || this.Cc.vAh() == 6 || this.Cc.fHv() == 3) {
                ((com.bytedance.adsdk.ugeno.DmF.tV.EO) EO2).lEW("local://tt_close_btn");
                EO2.MY();
            }
        }
    }

    public com.bytedance.adsdk.ugeno.MY.EO Bc() {
        com.bytedance.adsdk.ugeno.MY.EO<View> eo = this.EO;
        if (eo == null) {
            return null;
        }
        return eo.EO(MimeTypes.BASE_TYPE_VIDEO);
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.tV
    public View Cc() {
        return this.Bc;
    }

    @Override // com.bytedance.adsdk.ugeno.core.hp
    public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo, String str, vCE.IlO ilO) {
    }

    public com.bytedance.adsdk.ugeno.MY.EO lEW() {
        com.bytedance.adsdk.ugeno.MY.EO<View> eo = this.EO;
        if (eo == null) {
            return null;
        }
        return eo.EO("feedback");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.tV
    public void setSoundMute(boolean z2) {
        com.bytedance.adsdk.ugeno.MY.EO<T> EO;
        com.bytedance.adsdk.ugeno.MY.EO<View> eo = this.EO;
        if (eo == null || (EO = eo.EO("mute")) == 0) {
            return;
        }
        if (z2) {
            ((com.bytedance.adsdk.ugeno.DmF.tV.EO) EO).lEW("local://tt_reward_full_mute");
        } else {
            ((com.bytedance.adsdk.ugeno.DmF.tV.EO) EO).lEW("local://tt_reward_full_unmute");
        }
        EO.MY();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.tV
    public void setTime(CharSequence charSequence, int i2, int i8, boolean z2) {
        if (this.EO == null) {
            return;
        }
        boolean z7 = i2 == 1;
        IlO(charSequence, z7, i8, z2);
        MY(charSequence, z7, i8, z2);
    }

    public int tV() {
        this.IlO.IlO((hp) this);
        this.IlO.IlO((bWL) this);
        com.bytedance.adsdk.ugeno.MY.EO<View> eoIlO = this.IlO.IlO(this.tV);
        this.EO = eoIlO;
        tV tVVar = this.lMM;
        if (tVVar != null && eoIlO != null) {
            tVVar.IlO(eoIlO);
        }
        this.vCE.dY().MY();
        this.vCE.dY().EO();
        this.IlO.MY(this.kBB);
        return 0;
    }

    public com.bytedance.adsdk.ugeno.MY.EO vCE() {
        com.bytedance.adsdk.ugeno.MY.EO<View> eo = this.EO;
        if (eo == null) {
            return null;
        }
        return eo.tV("PlayableComponent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(com.bytedance.sdk.component.adexpress.MY.Bc bc) {
        this.vCE.dY().IlO();
        if (this.tV == null) {
            bc.IlO(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, "ugen template is null real reason is " + this.YA);
            return;
        }
        if (this.kBB == null) {
            bc.IlO(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, "ugen data is null");
            return;
        }
        int iTV = tV();
        if (this.IlO.IlO()) {
            List<String> listMY = this.IlO.MY();
            if (listMY == null) {
                bc.IlO(Sdk.SDKError.Reason.CONFIG_REFRESH_FAILED_VALUE, "unknow widget");
                return;
            }
            bc.IlO(Sdk.SDKError.Reason.CONFIG_REFRESH_FAILED_VALUE, "unknow widget;" + listMY.toString());
            return;
        }
        if (iTV != 0) {
            bc.IlO(iTV, "ugen render fail");
            return;
        }
        if (this.EO == null) {
            bc.IlO(Sdk.SDKError.Reason.CONFIG_REFRESH_FAILED_VALUE, "ugen render error");
            return;
        }
        MY my = new MY();
        this.DmF = my;
        my.IlO(true);
        this.DmF.IlO(EO());
        setSoundMute(this.tl);
        DmF();
        com.bytedance.adsdk.ugeno.MY.EO eoBc = Bc();
        this.EV = eoBc;
        if (eoBc != null && (eoBc instanceof com.bytedance.sdk.openadsdk.core.NV.MY.EO.MY)) {
            ((MY) this.DmF).IlO((FrameLayout) ((com.bytedance.sdk.openadsdk.core.NV.MY.EO.MY) eoBc).tV());
        }
        com.bytedance.adsdk.ugeno.MY.EO eoLEW = lEW();
        tV tVVar = this.lMM;
        if (tVVar != null) {
            tVVar.IlO();
        }
        if (eoLEW != null && eoLEW.EV() != null) {
            this.AXM = new WeakReference<>(eoLEW.EV());
        }
        com.bytedance.adsdk.ugeno.MY.EO eoVCE = vCE();
        this.rp = eoVCE;
        if (eoVCE != null && (eoVCE instanceof com.bytedance.adsdk.ugeno.DmF.MY.MY)) {
            ((MY) this.DmF).MY((FrameLayout) eoVCE.EV());
        }
        int iNvX = this.EO.nvX();
        int iYA = this.EO.YA();
        this.Bc.removeAllViews();
        this.Bc.addView(this.EO.EV(), new FrameLayout.LayoutParams(iNvX, iYA));
        float fWPn = this.vCE.wPn();
        float fOc = this.vCE.oc();
        float fMY = BS.MY(this.MY, fWPn);
        float fMY2 = BS.MY(this.MY, fOc);
        if (EO() != 7) {
            this.Bc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        } else if (fOc <= 0.0f) {
            this.Bc.setLayoutParams(new FrameLayout.LayoutParams((int) fMY, -2));
        } else {
            this.Bc.setLayoutParams(new FrameLayout.LayoutParams((int) fMY, (int) fMY2));
        }
        if (fOc <= 0.0f || fWPn <= 0.0f) {
            this.Bc.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int iEO = BS.EO(this.MY, this.Bc.getMeasuredWidth());
            int iEO2 = BS.EO(this.MY, this.Bc.getMeasuredHeight());
            this.DmF.IlO(iEO);
            this.DmF.MY(iEO2);
        } else {
            this.DmF.IlO(fWPn);
            this.DmF.MY(fOc);
        }
        if (this.NV.get()) {
            bc.IlO(Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, "ugen render timeout");
        } else {
            bc.IlO(this.Bc, this.DmF);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.tV
    public int EO() {
        return this.Cc.nvX();
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.tV
    public void IlO(com.bytedance.sdk.component.adexpress.MY.Bc bc) {
        this.pP = bc;
        mmj.MY(this.mmj);
    }

    public JSONObject IlO() {
        return this.vCE.EO();
    }

    public void IlO(boolean z2) {
        this.NV.set(z2);
    }

    public void IlO(lEW lew) {
        this.lEW = lew;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.widget.Cc cc) {
        tV tVVar = this.lMM;
        if (tVVar != null) {
            tVVar.IlO(cc);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.hp
    public void IlO(EV ev, hp.MY my, hp.IlO ilO) {
        if (ev == null) {
            return;
        }
        if (ev.MY() == 1 || ev.MY() == 4) {
            IlO(ev);
        }
        if (ev.MY() == 10) {
            IlO(ev.EO());
        }
        if (my == null || ev.tV() == null) {
            return;
        }
        my.IlO(ev.tV());
    }

    private void IlO(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.MY.EO<T> EO;
        if (this.EO == null || jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("type");
        String strOptString2 = jSONObject.optString("nodeId");
        if (TextUtils.isEmpty(strOptString2) || (EO = this.EO.EO(strOptString2)) == 0) {
            return;
        }
        if (TextUtils.equals(strOptString, "onShow")) {
            EO.EO(0);
        } else if (TextUtils.equals(strOptString, "onDismiss")) {
            EO.EO(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.tV
    public void onvideoComplate() {
    }

    private void IlO(EV ev) {
        JSONObject jSONObjectTV;
        boolean zIlO;
        int i2;
        String str;
        tV tVVar;
        tV tVVar2;
        tV tVVar3;
        if (this.lEW == null) {
            return;
        }
        String strOptString = ev.EO().optString("type");
        if ("swiperLeft".equals(strOptString) && (tVVar3 = this.lMM) != null) {
            tVVar3.MY();
            return;
        }
        if ("swiperRight".equals(strOptString) && (tVVar2 = this.lMM) != null) {
            tVVar2.EO();
            return;
        }
        if (!"swiperClick".equals(strOptString) || (tVVar = this.lMM) == null) {
            jSONObjectTV = null;
            zIlO = false;
            i2 = 0;
        } else {
            zIlO = tVVar.IlO(ev);
            jSONObjectTV = this.lMM.tV();
            i2 = 2;
        }
        strOptString.getClass();
        switch (strOptString) {
            case "privacy":
                i2 = 7;
                break;
            case "feedback":
                i2 = 3;
                break;
            case "mute":
                i2 = 5;
                break;
            case "skip":
                i2 = 6;
                break;
            case "video":
                i2 = 4;
                break;
            case "creative":
                i2 = 2;
                break;
        }
        com.bytedance.adsdk.ugeno.MY.EO eoIlO = ev.IlO();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        WeakReference<View> weakReference = this.AXM;
        if (weakReference != null) {
            int[] iArrIlO = BS.IlO(weakReference.get());
            if (iArrIlO != null) {
                iArr = iArrIlO;
            }
            int[] iArrEO = BS.EO(this.AXM.get());
            if (iArrEO != null) {
                iArr2 = iArrEO;
            }
        }
        bWL.IlO IlO = new bWL.IlO().tV(this.hp).EO(this.bWL).MY(this.ea).IlO(this.zPa).MY(this.cl).IlO(this.cL).tV(iArr[0]).Cc(iArr[1]).vCE(iArr2[0]).Bc(iArr2[1]).IlO(this.vAh).IlO(ev.MY() != 1 || this.es);
        if (eoIlO == null) {
            str = "";
        } else {
            str = eoIlO.lMM() + "_" + eoIlO.dY();
        }
        this.lEW.IlO(ev.IlO().EV(), i2, IlO.IlO(str).MY(zIlO).MY(jSONObjectTV).IlO());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.tV
    public void setTimeUpdate(int i2) {
    }

    public JSONObject MY() {
        return this.vCE.vSq();
    }

    private void MY(CharSequence charSequence, boolean z2, int i2, boolean z7) {
        com.bytedance.adsdk.ugeno.MY.EO<T> EO;
        View viewEV;
        com.bytedance.adsdk.ugeno.MY.EO<View> eo = this.EO;
        if (eo == null || (EO = eo.EO("skip")) == 0 || (viewEV = EO.EV()) == null) {
            return;
        }
        int i8 = 0;
        if (!z2 && !z7) {
            i8 = 8;
        }
        viewEV.setVisibility(i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    @Override // com.bytedance.adsdk.ugeno.core.bWL
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(com.bytedance.adsdk.ugeno.MY.EO r12, android.view.MotionEvent r13) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.NV.Cc.EO.IlO(com.bytedance.adsdk.ugeno.MY.EO, android.view.MotionEvent):void");
    }

    private void IlO(CharSequence charSequence, boolean z2, int i2, boolean z7) {
        com.bytedance.adsdk.ugeno.MY.EO<T> EO;
        int i8;
        com.bytedance.adsdk.ugeno.MY.EO<View> eo = this.EO;
        if (eo == null || (EO = eo.EO("countdown")) == 0) {
            return;
        }
        View viewEV = EO.EV();
        if (viewEV instanceof TextView) {
            try {
                i8 = Integer.parseInt((String) charSequence);
            } catch (Exception unused) {
                com.bytedance.sdk.component.utils.oeT.EO("UGenRender", "parse duration exception", charSequence);
                i8 = 0;
            }
            if (!z7 && i8 > 0 && !this.zLG) {
                viewEV.setVisibility(0);
                if (!z2 && this.vCE.IlO() && com.bytedance.sdk.component.adexpress.tV.vCE.MY(this.vCE.tV())) {
                    ((TextView) viewEV).setText(String.format(pP.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), "tt_reward_full_skip"), Integer.valueOf(i2)));
                    return;
                }
                if (!"open_ad".equals(this.vCE.tV()) && this.vCE.IlO()) {
                    this.zLG = true;
                    viewEV.setVisibility(8);
                    return;
                } else {
                    ((TextView) viewEV).setText(((Object) charSequence) + "s");
                    return;
                }
            }
            viewEV.setVisibility(8);
        }
    }
}
