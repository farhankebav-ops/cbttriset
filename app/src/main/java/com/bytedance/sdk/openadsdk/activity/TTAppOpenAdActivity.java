package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.common.ea;
import com.bytedance.sdk.openadsdk.component.DmF.lEW;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.kBB;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.pP;
import com.bytedance.sdk.openadsdk.core.rp.tV.IlO;
import com.bytedance.sdk.openadsdk.core.settings.hp;
import com.bytedance.sdk.openadsdk.kBB.MY.Cc;
import com.bytedance.sdk.openadsdk.tV.Bc;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.DM;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C2300e4;
import com.ironsource.Mf;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTAppOpenAdActivity extends TTBaseActivity implements vSq.IlO, IlO.InterfaceC0108IlO {
    private static com.bytedance.sdk.openadsdk.IlO.tV.MY lEW;
    private oeT AXM;
    private ea EV;
    private com.bytedance.sdk.openadsdk.component.vCE.MY NV;
    private FrameLayout OOq;
    private boolean cL;
    private float cl;
    private Bc ea;
    private int es;
    private com.bytedance.sdk.openadsdk.component.EO oc;
    private IListenerManager oeT;
    private int pP;
    private TTAdDislikeToast rp;
    private int tl;
    private com.bytedance.sdk.openadsdk.IlO.tV.MY vAh;
    private AdSlot vSq;
    private boolean wPn;
    private String xF;
    private float zPa;
    protected final AtomicBoolean IlO = new AtomicBoolean(false);
    protected final vSq MY = new vSq(Looper.getMainLooper(), this);
    final AtomicBoolean EO = new AtomicBoolean(false);
    final AtomicBoolean tV = new AtomicBoolean(false);
    private final com.bytedance.sdk.openadsdk.component.lEW.IlO DmF = new com.bytedance.sdk.openadsdk.component.lEW.IlO();
    protected boolean Cc = false;
    private final AtomicBoolean hp = new AtomicBoolean(false);
    private DM bWL = DM.EO();
    private final AtomicBoolean kBB = new AtomicBoolean(false);
    long vCE = 0;
    private volatile boolean dY = false;
    private final com.bytedance.sdk.openadsdk.component.IlO lMM = new com.bytedance.sdk.openadsdk.component.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.1
        @Override // com.bytedance.sdk.openadsdk.component.IlO
        public void Cc() {
            TTAppOpenAdActivity.this.es();
        }

        @Override // com.bytedance.sdk.openadsdk.component.IlO
        public void EO() {
            TTAppOpenAdActivity.this.vCE();
            TTAppOpenAdActivity.this.bWL.Cc();
            TTAppOpenAdActivity.this.cl();
            if (TTAppOpenAdActivity.this.cL) {
                TTAppOpenAdActivity.this.rp();
            }
            if (TTAppOpenAdActivity.this.oc.Bc() == null || TTAppOpenAdActivity.this.oc.Bc().MY() == null) {
                return;
            }
            TTAppOpenAdActivity.this.oc.Bc().MY().IlO(TTAppOpenAdActivity.this);
        }

        @Override // com.bytedance.sdk.openadsdk.component.IlO, w.b
        public void IlO() {
            TTAppOpenAdActivity.this.oeT();
            TTAppOpenAdActivity.this.xF();
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.component.IlO, w.b
        public void MY(long j, int i2) {
            com.bytedance.sdk.openadsdk.component.lEW.EO eoBc;
            StringBuilder sb = new StringBuilder("onError() called with: totalPlayTime = [");
            sb.append(j);
            sb.append("], percent = [");
            sb.append(i2);
            sb.append(C2300e4.i.e);
            if (TTAppOpenAdActivity.this.oc != null && (eoBc = TTAppOpenAdActivity.this.oc.Bc()) != null) {
                TTAppOpenAdActivity.this.oeT();
                eoBc.IlO(true);
            }
            TTAppOpenAdActivity.this.xF();
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.component.IlO
        public void tV() {
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.component.IlO, w.b
        public void IlO(long j, long j3) {
            TTAppOpenAdActivity.this.DmF.MY(j);
            TTAppOpenAdActivity tTAppOpenAdActivity = TTAppOpenAdActivity.this;
            if (!tTAppOpenAdActivity.Cc && tTAppOpenAdActivity.oc != null && TTAppOpenAdActivity.this.oc.Bc() != null && TTAppOpenAdActivity.this.oc.Bc().Cc()) {
                TTAppOpenAdActivity.this.oc.Bc().lEW();
            }
            TTAppOpenAdActivity.this.hp();
        }

        @Override // com.bytedance.sdk.openadsdk.component.IlO, com.bytedance.sdk.openadsdk.component.vCE.IlO
        public void MY(View view) {
            TTAppOpenAdActivity.this.IlO();
        }

        @Override // com.bytedance.sdk.openadsdk.component.IlO, com.bytedance.sdk.openadsdk.component.vCE.IlO
        public void MY() {
            TTAppOpenAdActivity.this.dY = true;
            if (com.bytedance.sdk.openadsdk.AXM.IlO.IlO("splash_auto_close_switch", 0) == 0) {
                TTAppOpenAdActivity.this.Bc();
                TTAppOpenAdActivity.this.finish();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.component.IlO, com.bytedance.sdk.openadsdk.component.vCE.IlO
        public void IlO(View view) {
            TTAppOpenAdActivity.this.AXM();
        }

        @Override // com.bytedance.sdk.openadsdk.component.IlO, com.bytedance.sdk.openadsdk.component.vCE.IlO
        public void IlO(int i2, boolean z2) {
            if (TTAppOpenAdActivity.this.oc != null) {
                TTAppOpenAdActivity.this.oc.IlO(i2, z2);
            }
        }
    };
    private final Runnable nvX = new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (TTAppOpenAdActivity.this.hp.get()) {
                return;
            }
            if (TTAppOpenAdActivity.this.AXM != null && TTAppOpenAdActivity.this.AXM.xJ() && TTAppOpenAdActivity.this.AXM.QfH() != null && TTAppOpenAdActivity.this.AXM.QfH().IlO() != null) {
                TTAppOpenAdActivity.this.AXM.QfH().IlO().IlO(0L);
            }
            TTAppOpenAdActivity.this.ea = new Bc();
            TTAppOpenAdActivity.this.ea.IlO(System.currentTimeMillis(), 1.0f);
            TTAppOpenAdActivity.this.bWL.Cc();
            if (TTAppOpenAdActivity.this.NV != null) {
                TTAppOpenAdActivity.this.NV.MY();
            }
            if (TTAppOpenAdActivity.this.oc != null) {
                TTAppOpenAdActivity.this.oc.Cc();
            }
            TTAppOpenAdActivity.this.cL();
            View viewFindViewById = TTAppOpenAdActivity.this.findViewById(R.id.content);
            JSONObject jSONObject = new JSONObject();
            if (viewFindViewById != null) {
                try {
                    jSONObject.put("width", viewFindViewById.getWidth());
                    jSONObject.put("height", viewFindViewById.getHeight());
                    jSONObject.put("alpha", viewFindViewById.getAlpha());
                } catch (JSONException e) {
                    Log.e("TTAppOpenAdActivity", "run: ", e);
                    TTAppOpenAdActivity.this.finish();
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("root_view", jSONObject.toString());
            jSONObject2.put("ad_root", TTAppOpenAdActivity.this.pP);
            jSONObject2.put("openad_creative_type", TTAppOpenAdActivity.this.cL ? "video_normal_ad" : "image_normal_ad");
            if (lEW.EO() == null) {
                jSONObject2.put("appicon_acquirefail", "1");
            }
            if (TTAppOpenAdActivity.this.wPn || TTAppOpenAdActivity.this.AXM.Os()) {
                jSONObject2.put("dynamic_show_type", TTAppOpenAdActivity.this.zPa());
                TTAppOpenAdActivity.this.IlO(jSONObject2);
            }
            jSONObject2.put("is_icon_only", TTAppOpenAdActivity.this.AXM.mV() ? 1 : 0);
            com.bytedance.sdk.openadsdk.tV.EO.IlO(TTAppOpenAdActivity.this.AXM, "open_ad", jSONObject2);
            com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(TTAppOpenAdActivity.this.findViewById(R.id.content), TTAppOpenAdActivity.this.AXM, new Cc.IlO(TTAppOpenAdActivity.this.zPa()));
            com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(TTAppOpenAdActivity.this.AXM);
            TTAppOpenAdActivity.this.hp.set(true);
        }
    };

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        BS.IlO((Activity) this);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.7
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i2) {
                if (i2 == 0) {
                    try {
                        if (TTAppOpenAdActivity.this.isFinishing()) {
                            return;
                        }
                        TTAppOpenAdActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BS.IlO((Activity) TTAppOpenAdActivity.this);
                            }
                        }, 2500L);
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenAdActivity", e.getMessage());
                    }
                }
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (cl.tV().xF(String.valueOf(this.es)) == 1) {
            if (this.DmF.EO() >= ((long) cl.tV().AXM(String.valueOf(this.es))) * 1000) {
                AXM();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cl.MY(getApplicationContext());
        if (!MY(bundle)) {
            finish();
            return;
        }
        if (!bWL.Cc()) {
            finish();
            return;
        }
        if (bundle != null) {
            com.bytedance.sdk.openadsdk.tV.EO.Cc(this.AXM, "open_ad", (JSONObject) null);
        }
        this.cL = oeT.Cc(this.AXM);
        new StringBuilder("onCreate: isVideo is ").append(this.cL);
        if (this.cL) {
            this.DmF.IlO((float) this.AXM.fdM().f4688d);
        } else {
            this.DmF.IlO(cl.tV().oeT(String.valueOf(this.es)));
        }
        com.bytedance.sdk.openadsdk.component.vCE.MY my = new com.bytedance.sdk.openadsdk.component.vCE.MY(this.DmF);
        this.NV = my;
        my.IlO(this.lMM);
        lEW();
        FrameLayout frameLayout = new FrameLayout(this);
        this.OOq = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        try {
            setContentView(this.OOq);
            this.OOq.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.2
                /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instruction units count: 215
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.AnonymousClass2.run():void");
                }
            });
            try {
                final View decorView = getWindow().getDecorView();
                if (Build.VERSION.SDK_INT >= 35) {
                    decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.3
                        @Override // android.view.View.OnApplyWindowInsetsListener
                        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                            List boundingRects;
                            try {
                                DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                                if (displayCutout != null && (boundingRects = displayCutout.getBoundingRects()) != null && !boundingRects.isEmpty()) {
                                    decorView.setPadding(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom());
                                }
                            } catch (Throwable unused) {
                            }
                            return windowInsets;
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            com.bytedance.sdk.openadsdk.ea.EO.MY();
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.AXM != null) {
            com.bytedance.sdk.openadsdk.vCE.MY.IlO().IlO("videoForceBreak", this.AXM);
        }
        this.MY.removeCallbacksAndMessages(null);
        com.bytedance.sdk.openadsdk.component.vCE.MY my = this.NV;
        if (my != null) {
            my.Cc();
        }
        com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(this.AXM);
        com.bytedance.sdk.openadsdk.kBB.IlO.EO.MY(this.AXM);
        if (this.cL) {
            com.bytedance.sdk.openadsdk.component.tV.IlO.IlO(this.AXM, this.DmF.EO(), this.DmF.MY(), true);
        } else {
            com.bytedance.sdk.openadsdk.component.tV.IlO.IlO(this.AXM, -1L, this.DmF.MY(), false);
        }
        if (this.bWL.vCE() && this.hp.get()) {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(String.valueOf(this.bWL.tV()), this.AXM, "open_ad", this.ea);
            this.bWL = DM.EO();
        }
        com.bytedance.sdk.openadsdk.component.EO eo = this.oc;
        if (eo != null) {
            eo.EO();
        }
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("recycleRes");
        }
        Bc();
        lEW = null;
        this.vAh = null;
        ea eaVar = this.EV;
        if (eaVar != null) {
            eaVar.setCallback(null);
        }
        if (hp.aP().kBB(String.valueOf(this.es)) != 1 || oeT.Bc(this.AXM) || this.AXM.uAj()) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.vCE.IlO(cl.IlO()).IlO(this.vSq);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.Cc = false;
        EO();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        com.bytedance.sdk.openadsdk.component.EO eo;
        super.onResume();
        this.Cc = true;
        if (this.IlO.getAndSet(true)) {
            if (!this.kBB.get()) {
                MY();
                return;
            }
            xF();
            if (this.cL && (eo = this.oc) != null && eo.Bc() != null) {
                oeT();
                this.oc.Bc().IlO(3);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            oeT oet = this.AXM;
            bundle.putString("material_meta", oet != null ? oet.eDn().toString() : null);
            bundle.putString(TTAdConstant.MULTI_PROCESS_META_MD5, this.xF);
            bundle.putInt(FirebaseAnalytics.Param.AD_SOURCE, this.pP);
            bundle.putLong("start_show_time", this.vCE);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenAdActivity", th.getMessage());
        }
        lEW = this.vAh;
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.utils.tV.IlO(this, this.AXM);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            if (!this.wPn) {
                this.bWL.Cc();
            }
            oeT oet = this.AXM;
            if (oet != null && oet.NLy() && !this.AXM.TkD()) {
                this.AXM.Bc(true);
                oeT oet2 = this.AXM;
                com.bytedance.sdk.openadsdk.tV.EO.IlO(oet2, "open_ad", oet2.hjY());
            }
        } else if (this.hp.get()) {
            if (this.bWL.vCE()) {
                com.bytedance.sdk.openadsdk.tV.EO.IlO(String.valueOf(this.bWL.tV()), this.AXM, "open_ad", this.ea);
            }
            this.bWL = DM.EO();
        }
        com.bytedance.sdk.openadsdk.kBB.MY.Cc.IlO(this.AXM, z2 ? 4 : 8);
        com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(this.AXM, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AXM() {
        com.bytedance.sdk.openadsdk.component.EO eo;
        kBB.EO(this.es);
        xF();
        if (this.cL && (eo = this.oc) != null && eo.Bc() != null) {
            oeT();
            this.oc.Bc().IlO(4);
        }
        com.bytedance.sdk.openadsdk.component.tV.IlO.IlO(this.AXM, (int) this.DmF.EO(), this.NV.IlO(), this.DmF.MY());
        oeT oet = this.AXM;
        if (oet != null && oet.xJ() && this.AXM.QfH() != null && this.AXM.QfH().IlO() != null) {
            com.bytedance.sdk.openadsdk.core.EV.tV tVVarIlO = this.AXM.QfH().IlO();
            com.bytedance.sdk.openadsdk.component.EO eo2 = this.oc;
            long jHp = (eo2 == null || eo2.Bc() == null) ? 0L : this.oc.Bc().hp();
            tVVarIlO.vCE(jHp);
            tVVarIlO.Cc(jHp);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bc() {
        com.bytedance.sdk.component.utils.oeT.IlO("TTAppOpenAdActivity", "invoke callback onAdDismiss, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("onAdTimeOver");
            return;
        }
        com.bytedance.sdk.openadsdk.IlO.tV.MY my = this.vAh;
        if (my != null) {
            my.EO();
        }
    }

    private void DmF() {
        int iMin;
        int iMax;
        new StringBuilder("changeScreenOrientation: mOrientation=").append(this.tl);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 != 26) {
            if (i2 == 27) {
                try {
                    NV();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenAdActivity", th.getMessage());
                    return;
                }
            } else {
                NV();
            }
        }
        Pair<Integer, Integer> pairNV = BS.NV(getApplicationContext());
        if (this.tl == 2) {
            iMin = Math.max(((Integer) pairNV.first).intValue(), ((Integer) pairNV.second).intValue());
            iMax = Math.min(((Integer) pairNV.first).intValue(), ((Integer) pairNV.second).intValue());
        } else {
            iMin = Math.min(((Integer) pairNV.first).intValue(), ((Integer) pairNV.second).intValue());
            iMax = Math.max(((Integer) pairNV.first).intValue(), ((Integer) pairNV.second).intValue());
        }
        this.zPa = iMax;
        this.cl = iMin;
        float fIlO = BS.IlO();
        if (BS.EO((Activity) this)) {
            int i8 = this.tl;
            if (i8 == 1) {
                this.zPa -= fIlO;
            } else if (i8 == 2) {
                this.cl -= fIlO;
            }
        }
        com.bytedance.sdk.openadsdk.component.EO eo = this.oc;
        if (eo != null) {
            eo.IlO(this.cl, this.zPa);
        }
    }

    private void EV() {
        if (this.EV == null) {
            ea eaVar = new ea(this, this.AXM);
            this.EV = eaVar;
            eaVar.setDislikeSource("video_player");
            this.EV.setCallback(new ea.IlO() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.4
                @Override // com.bytedance.sdk.openadsdk.common.ea.IlO
                public void IlO(View view) {
                    TTAppOpenAdActivity.this.EO.set(true);
                    TTAppOpenAdActivity.this.EO();
                    com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(TTAppOpenAdActivity.this.AXM, 8);
                }

                @Override // com.bytedance.sdk.openadsdk.common.ea.IlO
                public void MY(View view) {
                    TTAppOpenAdActivity.this.EO.set(false);
                    TTAppOpenAdActivity.this.MY();
                    com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(TTAppOpenAdActivity.this.AXM, 4);
                }

                @Override // com.bytedance.sdk.openadsdk.common.ea.IlO
                public void IlO(FilterWord filterWord) {
                    if (TTAppOpenAdActivity.this.tV.get() || filterWord == null || filterWord.hasSecondOptions()) {
                        return;
                    }
                    TTAppOpenAdActivity.this.tV.set(true);
                    TTAppOpenAdActivity.this.ea();
                }
            });
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
        frameLayout.addView(this.EV);
        if (this.rp == null) {
            TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this);
            this.rp = tTAdDislikeToast;
            frameLayout.addView(tTAdDislikeToast);
        }
    }

    private void NV() {
        if (this.tl != 2) {
            setRequestedOrientation(1);
        } else if (Cc()) {
            setRequestedOrientation(8);
        } else {
            setRequestedOrientation(0);
        }
        if (this.tl == 2 || !BS.EO((Activity) this)) {
            getWindow().addFlags(1024);
        }
    }

    private void bWL() {
        this.rp.show(TTAdDislikeToast.getDislikeTip());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL() {
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("onAdShow");
            return;
        }
        com.bytedance.sdk.openadsdk.IlO.tV.MY my = this.vAh;
        if (my != null) {
            my.IlO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl() {
        if (this.hp.get()) {
            return;
        }
        try {
            getWindow().getDecorView().post(this.nvX);
        } catch (Throwable unused) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea() {
        this.rp.show(TTAdDislikeToast.getDislikeSendTip());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es() {
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO(Mf.f7244f);
        } else {
            com.bytedance.sdk.openadsdk.IlO.tV.MY my = this.vAh;
            if (my != null) {
                my.onAdClicked();
            }
        }
        if (hp.aP().vAh(String.valueOf(this.es))) {
            this.kBB.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hp() {
        if (!this.cL || this.AXM.mV()) {
            return;
        }
        this.MY.removeMessages(100);
    }

    private void lEW() {
        if (26 != Build.VERSION.SDK_INT) {
            this.tl = this.AXM.BES();
        } else if (getResources().getConfiguration().orientation == 1) {
            this.tl = 1;
        } else {
            this.tl = 2;
        }
        DmF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oeT() {
        oeT oet;
        try {
            if (this.NV == null || (oet = this.AXM) == null || oet.eeU() == null) {
                return;
            }
            int iMY = this.AXM.eeU().MY();
            if (iMY == 1 || iMY == 2) {
                this.NV.IlO(iMY, this.AXM.eeU().IlO(), false);
                com.bytedance.sdk.openadsdk.component.EO eo = this.oc;
                if (eo == null || eo.Bc() == null) {
                    return;
                }
                this.oc.Bc().MY().IlO(this.DmF.IlO());
                this.oc.Bc().MY().IlO(1.0f);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenAdActivity", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rp() {
        if (!this.cL || this.AXM.mV() || this.dY) {
            return;
        }
        this.MY.sendEmptyMessageDelayed(100, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vCE() {
        Log.d("TTAppOpenAdActivity", "startCountDownTimer() called");
        oeT oet = this.AXM;
        int iAXM = (oet == null || oet.tV() < 0) ? cl.tV().AXM(String.valueOf(this.es)) : this.AXM.tV();
        this.NV.IlO(this.DmF.MY());
        this.NV.MY(iAXM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xF() {
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO("onAdSkip");
            return;
        }
        com.bytedance.sdk.openadsdk.IlO.tV.MY my = this.vAh;
        if (my != null) {
            my.MY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zPa() {
        if (this.AXM.Os()) {
            return 5;
        }
        if (this.wPn) {
            return this.oc.tV();
        }
        return -1;
    }

    public boolean Cc() {
        try {
            return getIntent().getIntExtra("orientation_angle", 0) == 3;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenAdActivity", e.getMessage());
            return false;
        }
    }

    public void EO() {
        if (this.cL) {
            com.bytedance.sdk.openadsdk.component.EO eo = this.oc;
            if (eo != null && eo.Bc() != null && this.oc.Bc().Cc()) {
                this.oc.Bc().lEW();
            }
            hp();
        }
        com.bytedance.sdk.openadsdk.component.vCE.MY my = this.NV;
        if (my != null) {
            my.tV();
        }
    }

    public IListenerManager tV() {
        if (this.oeT == null) {
            this.oeT = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO().IlO(7));
        }
        return this.oeT;
    }

    public void MY() {
        if (this.EO.get()) {
            return;
        }
        if (this.cL) {
            com.bytedance.sdk.openadsdk.component.EO eo = this.oc;
            if (eo != null && eo.Bc() != null && this.oc.Bc().vCE()) {
                this.oc.Bc().EV();
            }
            rp();
        }
        com.bytedance.sdk.openadsdk.component.vCE.MY my = this.NV;
        if (my != null) {
            my.EO();
        }
    }

    public void IlO() {
        if (isFinishing()) {
            return;
        }
        if (this.tV.get()) {
            bWL();
            return;
        }
        if (this.EV == null) {
            try {
                EV();
            } catch (Throwable th) {
                ApmHelper.reportCustomError("initDislike error", "TTAppOpenAdActivity", th);
            }
        }
        ea eaVar = this.EV;
        if (eaVar != null) {
            eaVar.IlO();
        }
    }

    private boolean MY(Bundle bundle) {
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            Intent intent = getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.AXM = com.bytedance.sdk.openadsdk.core.MY.IlO(new JSONObject(stringExtra));
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenAdActivity", "open_ad", "initData MultiGlobalInfo throws ", e);
                    }
                }
                this.xF = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_META_MD5);
            }
        } else {
            this.AXM = pP.IlO().MY();
            this.vAh = pP.IlO().Cc();
            pP.IlO().vCE();
        }
        IlO(getIntent());
        IlO(bundle);
        oeT oet = this.AXM;
        if (oet == null) {
            finish();
            return false;
        }
        this.vSq = oet.ssS();
        this.AXM.IlO(this.vCE);
        this.es = this.AXM.hFV();
        com.bytedance.sdk.openadsdk.utils.MY.IlO(this.AXM);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject IlO(JSONObject jSONObject) {
        if (zPa() == 0) {
            return this.oc.IlO(jSONObject);
        }
        return null;
    }

    private void IlO(final String str) {
        mmj.EO(new com.bytedance.sdk.component.lEW.lEW("AppOpenAd_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTAppOpenAdActivity.this.tV().executeAppOpenAdCallback(TTAppOpenAdActivity.this.xF, str);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenAdActivity", "open_ad", "executeAppOpenAdCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    public void IlO(Intent intent) {
        if (intent != null) {
            this.pP = intent.getIntExtra(FirebaseAnalytics.Param.AD_SOURCE, 0);
            this.vCE = intent.getLongExtra("start_show_time", 0L);
        }
    }

    public void IlO(Bundle bundle) {
        if (bundle != null) {
            if (this.vAh == null) {
                this.vAh = lEW;
                lEW = null;
            }
            try {
                String string = bundle.getString("material_meta");
                this.xF = bundle.getString(TTAdConstant.MULTI_PROCESS_META_MD5);
                this.pP = bundle.getInt(FirebaseAnalytics.Param.AD_SOURCE, 0);
                this.vCE = bundle.getLong("start_show_time", 0L);
                this.AXM = com.bytedance.sdk.openadsdk.core.MY.IlO(new JSONObject(string));
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("TTAppOpenAdActivity", th.getMessage());
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public void IlO(Message message) {
        com.bytedance.sdk.openadsdk.component.EO eo;
        if (message.what == 100) {
            if (this.cL && (eo = this.oc) != null && eo.Bc() != null) {
                oeT();
                this.oc.Bc().IlO(1);
            }
            xF();
            finish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.tV.IlO.InterfaceC0108IlO
    public void IlO(int i2) {
        if (i2 == 2 || i2 == 3 || i2 == 4) {
            oeT();
        }
    }
}
