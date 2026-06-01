package com.bytedance.sdk.openadsdk.core.lEW;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.adexpress.MY.NV;
import com.bytedance.sdk.component.adexpress.MY.hp;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.EO.Bc;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.MY.IlO;
import com.bytedance.sdk.openadsdk.core.dY;
import com.bytedance.sdk.openadsdk.core.lMM;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.vSq;
import com.bytedance.sdk.openadsdk.kBB.MY.Cc;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.onesignal.session.internal.influence.impl.InfluenceConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class xF extends com.bytedance.sdk.openadsdk.core.Cc.EO implements com.bytedance.sdk.component.adexpress.MY.ea, com.bytedance.sdk.component.adexpress.MY.lEW, com.bytedance.sdk.component.adexpress.dynamic.tV, IlO.InterfaceC0087IlO, bWL {
    public static int vAh = 500;
    private final ViewTreeObserver.OnScrollChangedListener AK;
    protected HashSet<String> AXM;
    private float BO;
    private boolean BS;
    private DmF Bc;
    private PAGExpressAdWrapperListener Cc;
    private String DM;
    protected final Context DmF;
    private kBB Dxv;
    private com.bytedance.sdk.openadsdk.EO.EO EO;
    protected AdSlot EV;
    private ThemeStatusBroadcastReceiver Ea;
    private EO HSR;
    private com.bytedance.sdk.component.adexpress.MY.DmF HTA;
    private final SparseArray<EO.IlO> Hg;
    private boolean IlO;
    private com.bytedance.sdk.component.adexpress.MY.zPa Jz;
    private final Runnable KC;
    private int MY;
    protected String NV;
    public com.bytedance.sdk.openadsdk.tV.Bc OOq;
    private com.bytedance.sdk.component.adexpress.MY.hp Tx;
    private String YA;
    protected boolean bWL;
    boolean cL;
    protected boolean cl;
    private float dY;
    private long dm;
    protected boolean ea;
    protected int es;
    private NV.IlO fdM;
    private final AtomicBoolean gQ;
    private com.bytedance.sdk.openadsdk.core.EO.DmF gm;
    private List<com.bytedance.sdk.component.adexpress.MY.NV> hL;
    public FrameLayout hp;
    private com.bytedance.sdk.openadsdk.core.NV.Cc.EO ii;
    public boolean kBB;
    private String lEW;
    private float lMM;
    private com.bytedance.sdk.openadsdk.core.NV.EO.MY mmj;
    private com.bytedance.sdk.openadsdk.core.NV.MY.Bc nm;
    private com.bytedance.sdk.openadsdk.tV.tV.Cc nvX;
    protected com.bytedance.sdk.component.adexpress.MY.MY oc;
    protected ViewGroup oeT;
    private int pFe;
    int pP;
    private final Runnable quf;
    private float qvT;
    private float qz;
    protected com.bytedance.sdk.openadsdk.core.model.oeT rp;
    private oeT ssS;
    private TTDislikeDialogAbstract tV;
    boolean tl;
    private float ts;
    private final Runnable uvo;
    private lEW vCE;
    public com.bytedance.sdk.component.adexpress.MY.tV<? extends View> vSq;
    private com.bytedance.sdk.component.adexpress.MY.vCE wD;
    long wPn;
    protected String xF;
    private Bc.IlO zLG;
    protected com.bytedance.sdk.component.adexpress.MY.EO zPa;

    public xF(@NonNull Context context, com.bytedance.sdk.openadsdk.core.model.oeT oet, AdSlot adSlot, String str) {
        super(context);
        this.IlO = true;
        this.MY = 0;
        this.NV = "embeded_ad";
        this.lEW = null;
        this.ea = false;
        this.cl = false;
        this.cL = true;
        this.es = -1;
        this.YA = "";
        this.kBB = false;
        this.BS = true;
        this.pP = -1;
        this.OOq = new com.bytedance.sdk.openadsdk.tV.Bc();
        this.wPn = 0L;
        this.gQ = new AtomicBoolean(false);
        this.AK = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.lEW.xF.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                xF xFVar = xF.this;
                if (xFVar.cL) {
                    xFVar.vAh();
                    xF xFVar2 = xF.this;
                    xFVar2.removeCallbacks(xFVar2.quf);
                    xF xFVar3 = xF.this;
                    xFVar3.postDelayed(xFVar3.quf, 500L);
                }
            }
        };
        this.quf = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.xF.2
            @Override // java.lang.Runnable
            public void run() {
                if (!dY.IlO(xF.this, 0, 5, false)) {
                    xF.this.vCE(8);
                } else {
                    xF xFVar = xF.this;
                    xFVar.vCE(xFVar.getVisibility());
                }
            }
        };
        this.uvo = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.xF.3
            @Override // java.lang.Runnable
            public void run() {
                xF.this.vCE(0);
            }
        };
        this.KC = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.xF.4
            @Override // java.lang.Runnable
            public void run() {
                xF.this.vCE(8);
            }
        };
        this.pFe = 8;
        this.Hg = new SparseArray<>();
        this.qz = -1.0f;
        this.qvT = -1.0f;
        this.ts = -1.0f;
        this.BO = -1.0f;
        this.dm = 0L;
        this.NV = str;
        this.DmF = context;
        this.rp = oet;
        this.EV = adSlot;
        this.kBB = false;
        Bc();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void DmF() {
        /*
            Method dump skipped, instruction units count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.lEW.xF.DmF():void");
    }

    private void EV() {
        this.MY = this.rp.nvX();
        try {
            rp();
            oeT();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.IlO("NativeExpressView", "NativeExpressView dynamicRender fail", e);
        }
        boolean z2 = this.rp.YA() == 1;
        this.IlO = z2;
        if (z2) {
            com.bytedance.sdk.component.adexpress.MY.vCE vce = new com.bytedance.sdk.component.adexpress.MY.vCE(this.DmF, this.Tx, new AXM(this, this.Ea, this.Tx));
            this.wD = vce;
            this.hL.add(vce);
        }
        Objects.toString(this.hL);
        this.fdM = new com.bytedance.sdk.component.adexpress.MY.rp(this.hL, this.HTA);
    }

    private void NV() {
        if (this.rp.OyN() == 1 && this.rp.xJ()) {
            com.bytedance.sdk.component.adexpress.MY.vCE vce = new com.bytedance.sdk.component.adexpress.MY.vCE(this.DmF, this.Tx, new AXM(this, this.Ea, this.Tx));
            this.wD = vce;
            this.hL.add(vce);
            this.fdM = new com.bytedance.sdk.component.adexpress.MY.rp(this.hL, this.HTA);
            return;
        }
        if (OOq()) {
            EV();
            return;
        }
        try {
            rp();
            kBB kbb = new kBB(this.DmF, this.Tx, this.Ea, this.nvX, this.rp);
            this.Dxv = kbb;
            com.bytedance.sdk.component.adexpress.MY.zPa zpa = new com.bytedance.sdk.component.adexpress.MY.zPa(this.DmF, this.Tx, kbb, this);
            this.Jz = zpa;
            this.hL.add(zpa);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.IlO("NativeExpressView", "NativeExpressView dynamicRender fail", e);
        }
        com.bytedance.sdk.component.adexpress.MY.vCE vce2 = new com.bytedance.sdk.component.adexpress.MY.vCE(this.DmF, this.Tx, new AXM(this, this.Ea, this.Tx));
        this.wD = vce2;
        this.hL.add(vce2);
        this.fdM = new com.bytedance.sdk.component.adexpress.MY.rp(this.hL, this.HTA);
    }

    private boolean OOq() {
        return TextUtils.equals(this.NV, "fullscreen_interstitial_ad") || TextUtils.equals(this.NV, "rewarded_video") || TextUtils.equals("open_ad", this.NV) || kBB.MY(this.NV) || TextUtils.equals(this.NV, "embeded_ad");
    }

    private int getAdSlotType() {
        String str = this.NV;
        str.getClass();
        switch (str) {
            case "banner_ad":
                return 1;
            case "rewarded_video":
                return 7;
            case "open_ad":
                return 3;
            case "fullscreen_interstitial_ad":
                return 8;
            case "interaction":
                return 2;
            default:
                return 5;
        }
    }

    private boolean kBB() {
        return com.bytedance.sdk.openadsdk.core.model.oeT.Cc(this.rp);
    }

    private void lEW() {
        oeT.IlO ilOUvo = this.rp.uvo();
        if (!TextUtils.equals(this.NV, "embeded_ad") || ilOUvo == null) {
            return;
        }
        String strRp = ilOUvo.rp();
        if (TextUtils.isEmpty(strRp)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strRp);
            int iOptInt = jSONObject.optInt("width");
            int iOptInt2 = jSONObject.optInt("height");
            if (iOptInt == 0 || iOptInt2 == 0) {
                return;
            }
            this.lMM = iOptInt2;
            this.dY = iOptInt;
        } catch (Exception unused) {
        }
    }

    private void oeT() {
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.rp;
        if (oet == null || oet.OyN() != 1 || this.rp.oc() == 2) {
            com.bytedance.sdk.openadsdk.core.vCE.IlO.IlO ilO = new com.bytedance.sdk.openadsdk.core.vCE.IlO.IlO();
            int i2 = this.MY;
            if (i2 != 0) {
                if (i2 == 3) {
                    com.bytedance.sdk.component.adexpress.dynamic.Cc.Bc bc = new com.bytedance.sdk.component.adexpress.dynamic.Cc.Bc();
                    Context applicationContext = this.DmF.getApplicationContext();
                    com.bytedance.sdk.component.adexpress.MY.hp hpVar = this.Tx;
                    ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = this.Ea;
                    boolean z2 = this.kBB;
                    com.bytedance.sdk.component.adexpress.MY.MY my = new com.bytedance.sdk.component.adexpress.MY.MY(applicationContext, hpVar, themeStatusBroadcastReceiver, z2, bc, this, ilO, new vCE(this.DmF, themeStatusBroadcastReceiver, z2, bc, hpVar, ilO));
                    this.oc = my;
                    this.hL.add(my);
                    return;
                }
                if (i2 == 7) {
                    com.bytedance.sdk.openadsdk.core.NV.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.NV.Cc.EO(this.DmF, this.rp, this.kBB, (com.bytedance.sdk.openadsdk.core.NV.Cc.IlO) this.Tx, this);
                    this.ii = eo;
                    com.bytedance.sdk.openadsdk.core.NV.MY.Bc bc2 = new com.bytedance.sdk.openadsdk.core.NV.MY.Bc(this.DmF, eo, this, this.Tx);
                    this.nm = bc2;
                    this.hL.add(bc2);
                    return;
                }
                if (i2 != 9) {
                    if (i2 != 10) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.NV.Cc.vCE vce = new com.bytedance.sdk.openadsdk.core.NV.Cc.vCE(this.DmF, this.rp, this.kBB, (com.bytedance.sdk.openadsdk.core.NV.Cc.IlO) this.Tx, this);
                    this.ii = vce;
                    com.bytedance.sdk.openadsdk.core.NV.MY.Bc bc3 = new com.bytedance.sdk.openadsdk.core.NV.MY.Bc(this.DmF, vce, this, this.Tx);
                    this.nm = bc3;
                    this.hL.add(bc3);
                    return;
                }
            }
            kBB kbb = new kBB(this.DmF, this.Tx, this.Ea, this.nvX, this.rp);
            this.Dxv = kbb;
            com.bytedance.sdk.component.adexpress.MY.zPa zpa = new com.bytedance.sdk.component.adexpress.MY.zPa(this.DmF, this.Tx, kbb, this);
            this.Jz = zpa;
            this.hL.add(zpa);
        }
    }

    private void pP() {
        List<com.bytedance.sdk.component.adexpress.MY.NV> list = this.hL;
        if (list == null) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.MY.NV> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void rp() {
        if (com.bytedance.sdk.openadsdk.core.bWL.Cc()) {
            return;
        }
        rp.IlO();
    }

    private void tl() {
        List<com.bytedance.sdk.component.adexpress.MY.NV> list = this.hL;
        if (list == null) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.MY.NV> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vAh() {
        if (this.gQ.get()) {
            this.OOq.IlO(System.currentTimeMillis(), dY.IlO(this));
        }
    }

    public void AXM() {
        com.bytedance.sdk.openadsdk.core.NV.EO.MY my = new com.bytedance.sdk.openadsdk.core.NV.EO.MY(this.DmF, this.rp);
        this.mmj = my;
        my.IlO(this);
        this.mmj.IlO(new com.bytedance.sdk.openadsdk.core.NV.EO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.lEW.xF.7
        });
    }

    public void Bc() {
        this.AXM = new HashSet<>();
        this.Ea = new ThemeStatusBroadcastReceiver();
        AdSlot adSlot = this.EV;
        if (adSlot != null) {
            this.dY = adSlot.getExpressViewAcceptedWidth();
            this.lMM = this.EV.getExpressViewAcceptedHeight();
            lEW();
            this.lEW = this.EV.getCodeId();
            if (TextUtils.equals(this.NV, "fullscreen_interstitial_ad")) {
                this.pP = this.rp.IlO();
            } else if (TextUtils.equals(this.NV, "rewarded_video")) {
                this.pP = this.rp.MY();
            } else if (TextUtils.equals(this.NV, "open_ad")) {
                com.bytedance.sdk.openadsdk.core.model.oeT oet = this.rp;
                if (oet == null || oet.tV() < 0) {
                    this.pP = com.bytedance.sdk.openadsdk.core.cl.tV().AXM(this.lEW);
                } else {
                    this.pP = this.rp.tV();
                }
                if (this.pP < 0) {
                    this.pP = 5;
                }
            }
        }
        setBackgroundColor(0);
        if (this.rp.Os()) {
            this.HSR = new EO(this.DmF, this, this.rp, this.NV);
            return;
        }
        DmF();
        this.hL = new ArrayList();
        NV();
        com.bytedance.sdk.component.adexpress.MY.zPa zpa = this.Jz;
        if (zpa != null) {
            this.Dxv = (kBB) zpa.MY();
        }
        vSq jsObject = getJsObject();
        if (jsObject != null) {
            jsObject.vCE(this.NV);
        }
    }

    public int Cc() {
        return 0;
    }

    public long EO() {
        return 0L;
    }

    public void IlO() {
    }

    public void MY() {
    }

    @Override // com.bytedance.sdk.component.adexpress.MY.ea
    public void a_(int i2) {
        com.bytedance.sdk.component.adexpress.MY.DmF dmF = this.HTA;
        if (dmF != null) {
            if (!this.IlO) {
                dmF.lEW();
            }
            this.HTA.DmF();
            ((hp) this.HTA).EV();
        }
        PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.Cc;
        if (pAGExpressAdWrapperListener != null) {
            pAGExpressAdWrapperListener.onRenderFail(this, com.bytedance.sdk.openadsdk.core.lEW.IlO(i2), i2);
        }
        oeT oet = this.ssS;
        if (oet != null) {
            oet.IlO(this.rp, this.NV);
        }
    }

    public void bWL() {
        if (this.rp == null) {
            return;
        }
        this.wPn = SystemClock.elapsedRealtime();
        if (this.rp.Os()) {
            EO eo = this.HSR;
            if (eo == null) {
                a_(106);
                return;
            } else {
                eo.IlO((com.bytedance.sdk.component.adexpress.MY.ea) this);
                this.HSR.IlO();
                return;
            }
        }
        this.nvX.IlO();
        NV.IlO ilO = this.fdM;
        if (ilO != null) {
            ilO.IlO(this);
        }
        try {
            this.fdM.IlO();
        } catch (Throwable unused) {
        }
    }

    public boolean cL() {
        com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar = this.vSq;
        return tVVar != null && (tVVar instanceof AXM);
    }

    public void cl() {
        try {
            FrameLayout frameLayout = this.hp;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.hp);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.lEW.xF.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void ea() {
        kBB kbb = this.Dxv;
        if (kbb == null || kbb.Cc() == null) {
            return;
        }
        this.Dxv.vCE();
    }

    public void es() {
        com.bytedance.sdk.openadsdk.core.model.oeT oet = this.rp;
        if (oet == null || oet.QfH() == null || this.rp.QfH().IlO() == null) {
            return;
        }
        this.rp.QfH().IlO().Cc(getVideoProgress());
    }

    public com.bytedance.sdk.openadsdk.tV.Bc getAdShowTime() {
        return this.OOq;
    }

    public EO getBrandBannerController() {
        return this.HSR;
    }

    public lEW getClickCreativeListener() {
        return this.vCE;
    }

    public DmF getClickListener() {
        return this.Bc;
    }

    public String getClosedListenerKey() {
        return this.DM;
    }

    public int getDynamicShowType() {
        com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar = this.vSq;
        if (tVVar != null) {
            return tVVar.EO();
        }
        return 0;
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.lMM).intValue();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.dY).intValue();
    }

    public vSq getJsObject() {
        kBB kbb = this.Dxv;
        if (kbb != null) {
            return kbb.zPa();
        }
        return null;
    }

    public int getRenderEngineCacheType() {
        NV nvEa;
        com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar = this.vSq;
        if (!(tVVar instanceof kBB) || (nvEa = ((kBB) tVVar).ea()) == null) {
            return 0;
        }
        return nvEa.IlO();
    }

    public int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.core.cl.tV().pP();
    }

    public String getUgenTemplateErrorReason() {
        return this.YA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.MY.IlO.InterfaceC0087IlO
    public long getVideoProgress() {
        com.bytedance.sdk.openadsdk.core.EO.DmF dmF = this.gm;
        if (dmF != null) {
            return dmF.getVideoProgress();
        }
        return 0L;
    }

    public com.bytedance.sdk.component.DmF.vCE getWebView() {
        kBB kbb = this.Dxv;
        if (kbb == null) {
            return null;
        }
        return kbb.IlO();
    }

    public void hp() {
        com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar = this.vSq;
        if (tVVar instanceof kBB) {
            if (tVVar == null) {
                return;
            }
            ((kBB) tVVar).lEW();
            com.bytedance.sdk.openadsdk.core.model.oeT oet = this.rp;
            com.bytedance.sdk.component.utils.DmF.MY().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.xF.6
                @Override // java.lang.Runnable
                public void run() {
                    xF.this.Cc(1);
                }
            }, ((long) (oet != null ? oet.zPa().tV() : 5)) * 1000);
        }
        com.bytedance.sdk.openadsdk.core.model.oeT oet2 = this.rp;
        if (oet2 != null && oet2.QfH() != null && this.rp.QfH().IlO() != null) {
            this.rp.QfH().IlO().IlO(0L);
        }
        if ((this.vSq instanceof com.bytedance.sdk.openadsdk.core.NV.Cc.vCE) && com.bytedance.sdk.openadsdk.core.model.ea.IlO(this.rp)) {
            IlO(this.vSq);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        vAh();
        pP();
        getViewTreeObserver().addOnScrollChangedListener(this.AK);
        com.bytedance.sdk.openadsdk.core.DmF.MY().IlO(this.DM, this.zLG);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.AK);
        com.bytedance.sdk.openadsdk.core.DmF.MY().vCE(this.DM);
        tl();
        IlO(8, true, true);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        super.onLayout(z2, i2, i8, i9, i10);
        vAh();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z2 ? getVisibility() : 8);
        }
        vAh();
        com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(this.rp, z2);
        if (z2) {
            com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(this.rp, 4);
        } else {
            com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(this.rp, 8);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        IlO(i2, true, false);
    }

    public void setBackupListener(com.bytedance.sdk.component.adexpress.MY.EO eo) {
        this.zPa = eo;
        com.bytedance.sdk.component.adexpress.MY.vCE vce = this.wD;
        if (vce != null) {
            vce.IlO(eo);
        }
    }

    public void setBannerClickClosedListener(Bc.IlO ilO) {
        this.zLG = ilO;
    }

    public void setClickCreativeListener(lEW lew) {
        this.vCE = lew;
        if (lew != null) {
            lew.IlO((IlO.InterfaceC0087IlO) this);
        }
    }

    public void setClickListener(DmF dmF) {
        this.Bc = dmF;
    }

    public void setClosedListenerKey(String str) {
        this.DM = str;
        EO eo = this.HSR;
        if (eo != null) {
            eo.IlO(str);
        }
    }

    public void setDislike(com.bytedance.sdk.openadsdk.EO.EO eo) {
        IlO ilO;
        com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar = this.vSq;
        if (tVVar != null && (tVVar instanceof AXM) && (ilO = (IlO) tVVar.Cc()) != null) {
            ilO.setDislikeInner(eo);
        }
        EO eo2 = this.HSR;
        if (eo2 != null) {
            eo2.IlO(eo);
        }
        this.EO = eo;
    }

    public void setExpressInteractionListener(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        this.Cc = pAGExpressAdWrapperListener;
        EO eo = this.HSR;
        if (eo != null) {
            eo.IlO(pAGExpressAdWrapperListener);
        }
    }

    public void setJsbLandingPageOpenListener(com.bytedance.sdk.openadsdk.core.widget.Cc cc) {
        if (this.Dxv != null && getJsObject() != null) {
            getJsObject().IlO(cc);
        }
        com.bytedance.sdk.openadsdk.core.NV.Cc.EO eo = this.ii;
        if (eo != null) {
            eo.IlO(cc);
        }
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        IlO ilO;
        com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar = this.vSq;
        if (tVVar != null && (tVVar instanceof AXM) && (ilO = (IlO) tVVar.Cc()) != null) {
            ilO.setDislikeOuter(tTDislikeDialogAbstract);
        }
        EO eo = this.HSR;
        if (eo != null) {
            eo.IlO(tTDislikeDialogAbstract);
        }
        this.tV = tTDislikeDialogAbstract;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.tV
    public void setSoundMute(boolean z2) {
        this.kBB = z2;
        com.bytedance.sdk.component.adexpress.MY.MY my = this.oc;
        if (my != null && my.MY() != null) {
            this.oc.MY().setSoundMute(z2);
        }
        com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar = this.vSq;
        if (tVVar instanceof com.bytedance.sdk.openadsdk.core.NV.Cc.EO) {
            ((com.bytedance.sdk.openadsdk.core.NV.Cc.EO) tVVar).setSoundMute(z2);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.tV
    public void setTime(CharSequence charSequence, int i2, int i8, boolean z2) {
        try {
            int i9 = Integer.parseInt(String.valueOf(charSequence));
            MY(i9, i2);
            com.bytedance.sdk.openadsdk.core.NV.EO.MY my = this.mmj;
            if (my != null) {
                my.IlO(i9);
            }
        } catch (NumberFormatException unused) {
        }
    }

    public void setVastVideoHelper(com.bytedance.sdk.openadsdk.core.EO.DmF dmF) {
        this.gm = dmF;
    }

    public void setVideoBusiness(com.bytedance.sdk.openadsdk.core.rp.tV.MY my) {
        kBB kbb = this.Dxv;
        if (kbb != null) {
            kbb.IlO(my);
        }
    }

    public void setVideoFrameChangeListener(com.bytedance.sdk.openadsdk.rp.Bc bc) {
        if (this.Dxv == null || getJsObject() == null) {
            return;
        }
        getJsObject().IlO(bc);
    }

    public long tV() {
        return 0L;
    }

    public void vCE() {
    }

    public boolean xF() {
        return this.gQ.get();
    }

    public void zPa() {
        try {
            EO eo = this.HSR;
            if (eo != null) {
                eo.MY();
            }
            es();
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            List<com.bytedance.sdk.component.adexpress.MY.NV> list = this.hL;
            if (list != null) {
                Iterator<com.bytedance.sdk.component.adexpress.MY.NV> it = list.iterator();
                while (it.hasNext()) {
                    it.next().IlO();
                }
            }
            com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(this.rp);
            com.bytedance.sdk.openadsdk.kBB.IlO.EO.MY(this.rp);
            this.EO = null;
            this.tV = null;
            this.EV = null;
            this.rp = null;
            this.Cc = null;
            this.vCE = null;
            this.zPa = null;
            this.Bc = null;
            com.bytedance.sdk.openadsdk.core.NV.EO.MY my = this.mmj;
            if (my != null) {
                my.EO();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.IlO("NativeExpressView", "detach error", th);
        }
    }

    public void IlO(int i2) {
    }

    public void MY(int i2) {
    }

    public void vCE(int i2) {
        com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar = this.vSq;
        if (tVVar == null || !(tVVar instanceof kBB)) {
            return;
        }
        ((kBB) tVVar).IlO(i2);
        this.pFe = i2;
    }

    public void Cc(int i2) {
        if (com.bytedance.sdk.openadsdk.core.model.es.EO(this.rp)) {
            com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar = this.vSq;
            if (tVVar instanceof kBB) {
                ((kBB) tVVar).MY(i2);
            }
        }
    }

    public Cc.IlO EO(int i2) {
        return new Cc.IlO(i2);
    }

    public void IlO(int i2, com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
    }

    public void MY(JSONObject jSONObject) {
    }

    public void IlO(int i2, String str) {
    }

    public void IlO(hp.IlO ilO) {
    }

    public void MY(int i2, int i8) {
        int iMin;
        if (TextUtils.equals(this.NV, "banner_ad")) {
            return;
        }
        int i9 = this.pP;
        int i10 = ((i8 < i9 || i9 < 0 || !(this.tl || TextUtils.equals(this.NV, "open_ad"))) && !((i2 == 0 && TextUtils.equals(this.NV, "open_ad")) || Cc() == 5)) ? 0 : 1;
        if (i8 <= this.pP) {
            com.bytedance.sdk.openadsdk.core.model.oeT oet = this.rp;
            if (oet != null && oet.fdM() != null) {
                iMin = (int) (Math.min(this.pP, this.rp.fdM().f4688d * ((double) this.rp.fdM().f4694r)) - ((double) i8));
            } else {
                iMin = this.pP - i8;
            }
        } else {
            iMin = 0;
        }
        com.bytedance.sdk.component.adexpress.MY.MY my = this.oc;
        if (my != null && my.MY() != null) {
            this.oc.MY().setTime(String.valueOf(i2), i10, iMin, false);
        }
        com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar = this.vSq;
        if (tVVar instanceof com.bytedance.sdk.openadsdk.core.NV.Cc.EO) {
            ((com.bytedance.sdk.openadsdk.core.NV.Cc.EO) tVVar).setTime(String.valueOf(i2), i10, iMin, false);
        }
    }

    public void IlO(String str, JSONObject jSONObject) {
    }

    public void IlO(boolean z2, String str) {
    }

    public boolean IlO(com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
        return true;
    }

    public boolean IlO(JSONObject jSONObject) {
        return false;
    }

    public void IlO(int i2, boolean z2, boolean z7) {
        this.cL = z2;
        removeCallbacks(this.KC);
        removeCallbacks(this.uvo);
        if (i2 == 0) {
            if (z7) {
                this.uvo.run();
                return;
            } else {
                postDelayed(this.uvo, 50L);
                return;
            }
        }
        if (z7) {
            this.KC.run();
        } else {
            postDelayed(this.KC, 50L);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.tV
    public void onvideoComplate() {
    }

    public void IlO(View view, int i2, com.bytedance.sdk.component.adexpress.EO eo) {
        View view2;
        JSONObject jSONObject;
        com.bytedance.sdk.component.utils.oeT.IlO("ClickCreativeListener", "trigger Class2 method1", Integer.valueOf(i2));
        if (i2 == -1 || eo == null) {
            return;
        }
        HashMap map = new HashMap();
        if (OOq.EO(this.rp)) {
            map.put("click_scence", 3);
        } else {
            map.put("click_scence", 1);
        }
        com.bytedance.sdk.openadsdk.core.model.bWL bwl = (com.bytedance.sdk.openadsdk.core.model.bWL) eo;
        if (com.bytedance.sdk.openadsdk.core.model.es.EO(this.rp)) {
            try {
                JSONObject jSONObject2 = bwl.cl;
                if (jSONObject2 != null) {
                    int iOptInt = jSONObject2.optInt("click_type", 0);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("click_type", iOptInt);
                    map.put("pag_json_data", jSONObject3.toString());
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO(th.toString(), new Object[0]);
            }
        }
        lEW lew = this.vCE;
        if (lew != null) {
            lew.tV(getDynamicShowType());
            this.vCE.IlO(map);
        }
        DmF dmF = this.Bc;
        if (dmF != null) {
            dmF.tV(getDynamicShowType());
            this.Bc.IlO(map);
        }
        float f4 = bwl.IlO;
        float f8 = bwl.MY;
        float f9 = bwl.EO;
        float f10 = bwl.tV;
        boolean z2 = bwl.ea;
        SparseArray<EO.IlO> sparseArray = bwl.bWL;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.Hg;
        }
        SparseArray<EO.IlO> sparseArray2 = sparseArray;
        String str = bwl.EV;
        if (view == null) {
            view2 = this;
        } else {
            jSONObjectIlO = view != this ? IlO(view) : null;
            view2 = view;
        }
        bwl.rp = i2;
        if (jSONObjectIlO != null && bwl.hp == null) {
            bwl.hp = jSONObjectIlO;
        }
        if (i2 != 13) {
            switch (i2) {
                case 1:
                    FrameLayout frameLayout = this.hp;
                    if (frameLayout != null) {
                        frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                    }
                    com.bytedance.sdk.openadsdk.core.model.oeT oet = this.rp;
                    if (oet == null || oet.pP() != 1 || z2) {
                        DmF dmF2 = this.Bc;
                        if (dmF2 != null) {
                            dmF2.IlO(bwl);
                            this.Bc.IlO(str);
                            this.Bc.IlO(view2, f4, f8, f9, f10, sparseArray2, z2);
                        }
                        PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.Cc;
                        if (pAGExpressAdWrapperListener != null && !bwl.cL) {
                            pAGExpressAdWrapperListener.onAdClicked();
                            break;
                        }
                    }
                    break;
                case 2:
                    if (bwl.zPa > 0) {
                        lMM.IlO(true);
                    }
                    lEW lew2 = this.vCE;
                    if (lew2 != null) {
                        lew2.IlO(bwl);
                        this.vCE.IlO(str);
                        if (com.bytedance.sdk.openadsdk.core.model.es.EO(this.rp) && (jSONObject = bwl.cl) != null) {
                            this.vCE.tV(jSONObject.optBoolean("is_ceiling_page", false));
                        }
                        this.vCE.IlO(view2, f4, f8, f9, f10, sparseArray2, z2);
                    }
                    PAGExpressAdWrapperListener pAGExpressAdWrapperListener2 = this.Cc;
                    if (pAGExpressAdWrapperListener2 != null && !bwl.cL) {
                        pAGExpressAdWrapperListener2.onAdClicked();
                    }
                    lMM.IlO(false);
                    com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(this.rp, 9);
                    break;
                case 3:
                    TTDislikeDialogAbstract tTDislikeDialogAbstract = this.tV;
                    if (tTDislikeDialogAbstract != null) {
                        tTDislikeDialogAbstract.show();
                    } else {
                        com.bytedance.sdk.openadsdk.EO.EO eo2 = this.EO;
                        if (eo2 != null) {
                            eo2.IlO();
                        } else {
                            TTDelegateActivity.IlO(this.rp, this.DM);
                        }
                    }
                    break;
                case 4:
                    FrameLayout frameLayout2 = this.hp;
                    if (frameLayout2 != null) {
                        frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                    }
                    com.bytedance.sdk.openadsdk.core.model.oeT oet2 = this.rp;
                    if (oet2 == null || oet2.pP() != 1 || z2) {
                        zLG.EO(this.rp);
                        if ("embeded_ad".equals(this.NV) && kBB() && !this.bWL && zLG.EO(this.rp)) {
                            lEW lew3 = this.vCE;
                            if (lew3 != null) {
                                lew3.IlO(bwl);
                                this.vCE.IlO(str);
                                this.vCE.IlO(view2, f4, f8, f9, f10, sparseArray2, z2);
                            }
                        } else {
                            DmF dmF3 = this.Bc;
                            if (dmF3 != null) {
                                dmF3.IlO(bwl);
                                this.Bc.IlO(str);
                                this.Bc.IlO(view2, f4, f8, f9, f10, sparseArray2, z2);
                            }
                        }
                        PAGExpressAdWrapperListener pAGExpressAdWrapperListener3 = this.Cc;
                        if (pAGExpressAdWrapperListener3 != null && !bwl.cL) {
                            pAGExpressAdWrapperListener3.onAdClicked();
                            break;
                        }
                    }
                    break;
                case 5:
                    IlO(!this.kBB, "dynamicClick");
                    break;
                case 6:
                    IlO();
                    break;
                case 7:
                    TTWebsiteActivity.IlO(this.DmF, this.rp, this.NV);
                    break;
            }
            return;
        }
        int i8 = bwl.es;
        if (i8 >= 0) {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("switch", i8);
                IlO(jSONObject4);
            } catch (Throwable unused) {
            }
        }
    }

    public void MY(int i2, String str) {
        vSq vsqZPa;
        com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar = this.vSq;
        if (tVVar == null || !(tVVar instanceof kBB) || (vsqZPa = ((kBB) tVVar).zPa()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(InfluenceConstants.TIME, i2);
            jSONObject.put("flag", str);
            vsqZPa.IlO("onVideoPaused", jSONObject);
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.tV
    public void setTimeUpdate(int i2) {
    }

    public xF(@NonNull Context context, com.bytedance.sdk.openadsdk.core.model.oeT oet, AdSlot adSlot, String str, boolean z2, boolean z7) {
        super(context);
        this.IlO = true;
        this.MY = 0;
        this.NV = "embeded_ad";
        this.lEW = null;
        this.ea = false;
        this.cl = false;
        this.cL = true;
        this.es = -1;
        this.YA = "";
        this.kBB = false;
        this.BS = true;
        this.pP = -1;
        this.OOq = new com.bytedance.sdk.openadsdk.tV.Bc();
        this.wPn = 0L;
        this.gQ = new AtomicBoolean(false);
        this.AK = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.lEW.xF.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                xF xFVar = xF.this;
                if (xFVar.cL) {
                    xFVar.vAh();
                    xF xFVar2 = xF.this;
                    xFVar2.removeCallbacks(xFVar2.quf);
                    xF xFVar3 = xF.this;
                    xFVar3.postDelayed(xFVar3.quf, 500L);
                }
            }
        };
        this.quf = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.xF.2
            @Override // java.lang.Runnable
            public void run() {
                if (!dY.IlO(xF.this, 0, 5, false)) {
                    xF.this.vCE(8);
                } else {
                    xF xFVar = xF.this;
                    xFVar.vCE(xFVar.getVisibility());
                }
            }
        };
        this.uvo = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.xF.3
            @Override // java.lang.Runnable
            public void run() {
                xF.this.vCE(0);
            }
        };
        this.KC = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lEW.xF.4
            @Override // java.lang.Runnable
            public void run() {
                xF.this.vCE(8);
            }
        };
        this.pFe = 8;
        this.Hg = new SparseArray<>();
        this.qz = -1.0f;
        this.qvT = -1.0f;
        this.ts = -1.0f;
        this.BO = -1.0f;
        this.dm = 0L;
        this.NV = str;
        this.DmF = context;
        this.rp = oet;
        this.EV = adSlot;
        this.kBB = z2;
        this.BS = z7;
        Bc();
    }

    public static JSONObject IlO(View view) {
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put("left", iArr[0]);
            jSONObject.put("top", iArr[1]);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public void IlO(com.bytedance.sdk.component.adexpress.MY.tV<? extends View> tVVar, com.bytedance.sdk.component.adexpress.MY.bWL bwl) {
        com.bytedance.sdk.openadsdk.core.model.oeT oet;
        this.gQ.set(true);
        this.vSq = tVVar;
        tVVar.EO();
        if (this.pFe != getWindowVisibility()) {
            vCE(getWindowVisibility());
        }
        if (tVVar.EO() == 3 && (oet = this.rp) != null && oet.vAh() == 1) {
            this.rp.Cc(0);
        }
        if (tVVar.EO() != 1) {
            View viewCc = tVVar.Cc();
            if (viewCc.getParent() != null) {
                ((ViewGroup) viewCc.getParent()).removeView(viewCc);
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                arrayList.add(getChildAt(i2));
            }
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                if (arrayList.get(i8) instanceof com.bytedance.sdk.component.DmF.vCE) {
                    removeView((View) arrayList.get(i8));
                }
            }
            if (com.bytedance.sdk.openadsdk.core.model.es.EO(this.rp)) {
                addView(tVVar.Cc(), new FrameLayout.LayoutParams(-1, -1));
            } else {
                addView(tVVar.Cc());
            }
        }
        com.bytedance.sdk.openadsdk.core.model.oeT oet2 = this.rp;
        if (oet2 != null) {
            com.bytedance.sdk.openadsdk.ea.EO.IlO(oet2.Bc(), this.wPn, this.NV, tVVar.EO());
        }
        com.bytedance.sdk.component.adexpress.MY.DmF dmF = this.HTA;
        if (dmF != null) {
            ((hp) dmF).EV();
        }
        PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.Cc;
        if (pAGExpressAdWrapperListener != null) {
            pAGExpressAdWrapperListener.onRenderSuccess(this, (float) bwl.tV(), (float) bwl.Cc());
        }
        if ((this.vSq instanceof com.bytedance.sdk.openadsdk.core.NV.Cc.vCE) && com.bytedance.sdk.openadsdk.core.model.ea.IlO(this.rp)) {
            AXM();
        }
        if (IlO(bwl)) {
            com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(this, this.rp, EO(getDynamicShowType()));
        }
        oeT oet3 = this.ssS;
        if (oet3 != null) {
            oet3.IlO(this.rp, this.NV);
        }
    }

    public JSONObject IlO(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (!(this.vSq instanceof kBB)) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int renderEngineCacheType = getRenderEngineCacheType();
            if (oet != null) {
                if (oet.uvo() != null && oet.uvo().bWL()) {
                    jSONObject.put("engine_version", oet.uvo().hp());
                } else if (oet.Ea() != null) {
                    jSONObject.put("engine_version", "v3");
                } else {
                    jSONObject.put("engine_version", "v1");
                }
            }
            jSONObject.put("engine_type", renderEngineCacheType);
            return jSONObject;
        } catch (Exception e) {
            e.getMessage();
            return jSONObject;
        }
    }

    public void IlO(com.bytedance.sdk.component.adexpress.MY.tV tVVar) {
        if (this.mmj == null) {
            return;
        }
        try {
            if (tVVar instanceof com.bytedance.sdk.openadsdk.core.NV.Cc.vCE) {
                ViewGroup viewGroup = (ViewGroup) ((com.bytedance.sdk.openadsdk.core.NV.Cc.vCE) tVVar).vCE().EV();
                this.oeT = viewGroup;
                if (viewGroup != null) {
                    this.mmj.IlO();
                    View viewMY = this.mmj.MY();
                    if (viewMY != null) {
                        ViewGroup viewGroup2 = (ViewGroup) viewMY.getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(viewMY);
                        }
                        this.oeT.addView(viewMY, new ViewGroup.LayoutParams(-1, -1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
