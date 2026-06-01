package com.bytedance.sdk.openadsdk.core.rp.MY;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.component.utils.xF;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.bWL;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.dY;
import com.bytedance.sdk.openadsdk.core.lEW.kBB;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.rp.MY.EO;
import com.bytedance.sdk.openadsdk.tV.Bc;
import com.bytedance.sdk.openadsdk.tV.Cc.MY.ea;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import w.a;
import w.b;
import w.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends com.bytedance.sdk.openadsdk.core.Cc.EO implements b, vSq.IlO, EO.IlO {
    private static final Integer oeT = 0;
    private static final Integer vAh = 1;
    private final ViewTreeObserver.OnScrollChangedListener AK;
    private String AXM;
    private ViewTreeObserver.OnGlobalLayoutListener BS;
    protected RelativeLayout Bc;
    public boolean Cc;
    private View DM;
    protected ImageView DmF;
    protected FrameLayout EO;
    protected boolean EV;
    private final AtomicBoolean HSR;
    protected final oeT IlO;
    protected EO MY;
    protected ImageView NV;
    private boolean OOq;
    private boolean YA;
    boolean bWL;
    private ViewGroup cL;
    private final Context cl;
    private final Handler dY;
    protected boolean ea;
    private boolean es;
    private final Runnable gQ;
    protected int hp;
    private String kBB;
    protected ImageView lEW;
    private boolean lMM;
    private final String mmj;
    private long nvX;
    private long oc;
    private boolean pP;
    protected String rp;
    private final AtomicBoolean ssS;
    protected boolean tV;
    private boolean tl;
    public Bc vCE;
    private final boolean vSq;
    private boolean wPn;
    private boolean xF;
    private a zLG;
    public MY zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(View view, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MY {
        void IlO(boolean z2, long j, long j3, long j8, boolean z7);
    }

    public vCE(@NonNull Context context, @NonNull oeT oet, boolean z2, Bc bc) {
        this(context, oet, z2, "embeded_ad", false, false, bc);
    }

    private void AXM() {
        if (this.MY == null) {
            es();
        } else if (!lMM()) {
            this.MY.ea();
        }
        if (this.MY == null || !this.ssS.get()) {
            return;
        }
        this.ssS.set(false);
        MY();
        if (!lEW()) {
            if (this.MY.rp()) {
                this.MY.rp();
                MY(true);
                return;
            } else {
                Bc();
                BS.IlO((View) this.Bc, 0);
                return;
            }
        }
        BS.IlO((View) this.Bc, 8);
        ImageView imageView = this.DmF;
        if (imageView != null) {
            BS.IlO((View) imageView, 8);
        }
        oeT oet = this.IlO;
        if (oet == null || oet.fdM() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.rp.IlO.MY myIlO = oeT.IlO(((b0.b) CacheDirFactory.getICacheDir(this.IlO.hHv())).b(), this.IlO);
        myIlO.MY(this.IlO.ED());
        myIlO.MY(this.cL.getWidth());
        myIlO.EO(this.cL.getHeight());
        myIlO.EO(this.IlO.KT());
        myIlO.IlO(0L);
        myIlO.IlO(DmF());
        IlO(myIlO);
        this.MY.IlO(myIlO);
        this.MY.MY(false);
    }

    private void Cc() {
        addView(IlO(this.cl));
        es();
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.vCE.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                vCE.this.cL();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                vCE.this.cL();
            }
        });
    }

    private void OOq() {
        if (lMM() || !pP()) {
            return;
        }
        Boolean bool = Boolean.FALSE;
        com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_video_isfromvideodetailpage", bool);
        com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_video_is_from_detail_page", bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Handler handler = this.dY;
        if (handler == null || jElapsedRealtime - this.nvX <= 500) {
            return;
        }
        this.nvX = jElapsedRealtime;
        handler.sendEmptyMessageDelayed(1, 500L);
    }

    private boolean dY() {
        return 5 == cl.tV().MY(this.IlO.hFV());
    }

    private void es() {
        this.MY = new EO(this.cl, this.EO, this.IlO, this.rp, !lMM(), this.tl, this.OOq, this.vCE);
        xF();
        if (this.BS == null) {
            this.BS = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.vCE.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    vCE vce;
                    EO eo;
                    if (vCE.this.cL == null || vCE.this.cL.getViewTreeObserver() == null || (eo = (vce = vCE.this).MY) == null) {
                        return;
                    }
                    eo.IlO(vce.cL.getWidth(), vCE.this.cL.getHeight());
                    vCE.this.cL.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    vCE.this.BS = null;
                }
            };
            this.cL.getViewTreeObserver().addOnGlobalLayoutListener(this.BS);
        }
    }

    private void kBB() {
        this.lMM = rp();
        mmj.IlO(this.gQ);
    }

    private boolean lMM() {
        return this.xF;
    }

    private void nvX() {
        BS.Cc(this.DmF);
        BS.Cc(this.Bc);
    }

    private void oc() {
        if (this.MY == null || lMM()) {
            return;
        }
        if ((!pP() || com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_video_is_update_flag", false)) && pP()) {
            long jLEW = this.MY.lEW();
            long jVCE = this.MY.vCE() + jLEW;
            boolean zIlO = com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_native_video_complete", false);
            long jIlO = com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_video_current_play_position", 0L);
            long jIlO2 = com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_video_total_play_duration", jVCE);
            long jIlO3 = com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_video_duration", jLEW);
            com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.FALSE);
            this.MY.MY(zIlO);
            this.MY.MY(jIlO);
            this.MY.EO(jIlO2);
            this.MY.tV(jIlO3);
        }
    }

    private void oeT() {
        this.zPa = null;
        if (this.MY != null && !lMM()) {
            this.MY.YA();
        }
        EV();
        IlO(false);
        vAh();
    }

    private boolean pP() {
        oeT oet = this.IlO;
        if (oet == null) {
            return false;
        }
        return oet.EeJ();
    }

    private void tV() {
        IlO(0L, 0);
        this.zLG = null;
    }

    private boolean tl() {
        if (lMM() || !pP()) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_video_is_from_detail_page", false) || com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_native_video_data", "key_video_isfromvideodetailpage", false);
    }

    private void vAh() {
        if (!this.ssS.get()) {
            this.ssS.set(true);
            EO eo = this.MY;
            if (eo != null) {
                eo.IlO(true, 3);
            }
        }
        this.HSR.set(false);
    }

    private boolean vSq() {
        return 2 == cl.tV().MY(this.IlO.hFV());
    }

    private void wPn() {
        this.dY.removeMessages(1);
        bWL.EO().removeCallbacks(this.gQ);
    }

    private void xF() {
        EO eo = this.MY;
        if (eo == null) {
            return;
        }
        eo.tV(this.es);
        this.MY.IlO((EO.IlO) this);
        this.MY.IlO((b) this);
    }

    public void Bc() {
        View view;
        if (this.cl == null || (view = this.DM) == null || view.getParent() == null || this.IlO == null || this.Bc != null) {
            return;
        }
        ViewParent parent = this.DM.getParent();
        RelativeLayout relativeLayoutMY = MY(this.cl);
        if (parent != null && (parent instanceof ViewGroup)) {
            IlO(relativeLayoutMY, (ViewGroup) parent, this.DM);
        }
        this.Bc = relativeLayoutMY;
        if (this.EV) {
            BS.IlO((View) this.NV, 0);
        }
        if (this.IlO.fdM() != null && this.IlO.fdM().f4689f != null) {
            com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO(this.IlO.fdM().f4689f, this.IlO.fdM().f4686b, this.IlO.fdM().f4685a, this.lEW, this.IlO);
        }
        ImageView imageView = this.NV;
        if (imageView != null) {
            imageView.setClickable(true);
            this.NV.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.vCE.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    vCE.this.EO();
                }
            });
        }
    }

    public boolean DmF() {
        return this.tV;
    }

    public void EV() {
        Cc ccEV;
        EO eo = this.MY;
        if (eo == null || (ccEV = eo.EV()) == null) {
            return;
        }
        ccEV.IlO();
        View viewEO = ccEV.EO();
        if (viewEO != null) {
            viewEO.setVisibility(8);
            if (viewEO.getParent() != null) {
                ((ViewGroup) viewEO.getParent()).removeView(viewEO);
            }
        }
    }

    @Override // w.b
    public void IlO() {
    }

    @Override // w.b
    public void MY(long j, int i2) {
    }

    public void NV() {
        EO eo = this.MY;
        if (eo != null) {
            Cc ccEV = eo.EV();
            if (ccEV != null) {
                ccEV.IlO();
            }
            nvX();
        }
    }

    public void bWL() {
        if (getNativeVideoController() == null || getNativeVideoController() == null) {
            return;
        }
        EO nativeVideoController = getNativeVideoController();
        nativeVideoController.IlO(nativeVideoController.EV(), this);
    }

    public void ea() {
        if (xF.EO(cl.IlO()) != 0 && rp()) {
            if (this.MY.NV() != null) {
                if (this.MY.NV().Bc()) {
                    IlO(true, vAh.intValue());
                    MY();
                    Handler handler = this.dY;
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(1, 500L);
                        return;
                    }
                    return;
                }
                if (this.MY.NV().MY() && !this.ea) {
                    NV();
                    EO eo = this.MY;
                    if (eo != null) {
                        eo.DM();
                        return;
                    }
                    return;
                }
            }
            if (lEW() || this.HSR.get()) {
                return;
            }
            this.HSR.set(true);
            nvX();
            oeT oet = this.IlO;
            if (oet != null && oet.fdM() != null) {
                nvX();
                this.IlO.fdM();
                com.bytedance.sdk.openadsdk.core.rp.IlO.MY myIlO = oeT.IlO(((b0.b) CacheDirFactory.getICacheDir(this.IlO.hHv())).b(), this.IlO);
                myIlO.MY(this.IlO.ED());
                myIlO.MY(this.cL.getWidth());
                myIlO.EO(this.cL.getHeight());
                myIlO.EO(this.IlO.KT());
                myIlO.IlO(this.oc);
                myIlO.IlO(DmF());
                myIlO.IlO(((b0.b) CacheDirFactory.getICacheDir(this.IlO.hHv())).b());
                IlO(myIlO);
                this.MY.IlO(myIlO);
            }
            Handler handler2 = this.dY;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(1, 500L);
            }
            IlO(false);
        }
    }

    public double getCurrentPlayTime() {
        if (this.MY != null) {
            return (r0.Cc() * 1.0d) / 1000.0d;
        }
        return 0.0d;
    }

    public EO getNativeVideoController() {
        return this.MY;
    }

    public boolean hp() {
        boolean z2 = false;
        if (xF.EO(cl.IlO()) == 0) {
            return false;
        }
        if (this.MY.NV() != null && this.MY.NV().vCE()) {
            IlO(false, oeT.intValue());
            Handler handler = this.dY;
            z2 = true;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
        return z2;
    }

    public boolean lEW() {
        return this.es;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AXM();
        if (this.ea) {
            getViewTreeObserver().addOnScrollChangedListener(this.AK);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        oeT();
        if (this.ea) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnScrollChangedListener(this.AK);
            }
            ViewGroup viewGroup = this.cL;
            if (viewGroup == null || this.BS == null) {
                return;
            }
            ViewTreeObserver viewTreeObserver2 = viewGroup.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnGlobalLayoutListener(this.BS);
                this.BS = null;
            }
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        AXM();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MY my;
        EO eo;
        if (!this.xF && (my = this.zPa) != null && (eo = this.MY) != null) {
            my.IlO(eo.rp(), this.MY.lEW(), this.MY.lMM(), this.MY.Cc(), this.es);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        oeT();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        EO eo;
        EO eo2;
        EO eo3;
        EO eo4;
        if ("open_ad".equals(this.rp)) {
            wPn();
            return;
        }
        this.pP = z2;
        super.onWindowFocusChanged(z2);
        com.bytedance.sdk.openadsdk.kBB.IlO.EO.IlO(this.IlO, z2);
        oc();
        if (this.ea) {
            if (tl() && (eo4 = this.MY) != null && eo4.rp()) {
                OOq();
                BS.IlO((View) this.Bc, 8);
                MY(true);
                tV();
                return;
            }
            MY();
            if (!lMM() && lEW() && (eo2 = this.MY) != null && !eo2.oeT()) {
                if (this.dY != null) {
                    if (z2 && (eo3 = this.MY) != null && !eo3.rp()) {
                        this.dY.obtainMessage(1).sendToTarget();
                        return;
                    } else {
                        wPn();
                        IlO(false, oeT.intValue());
                        return;
                    }
                }
                return;
            }
            if (lEW()) {
                return;
            }
            if (!z2 && (eo = this.MY) != null && eo.NV() != null && this.MY.NV().vCE()) {
                wPn();
                IlO(false, oeT.intValue());
            } else if (z2) {
                this.dY.obtainMessage(1).sendToTarget();
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        EO eo;
        oeT oet;
        EO eo2;
        EO eo3;
        super.onWindowVisibilityChanged(i2);
        oc();
        if (tl() && (eo3 = this.MY) != null && eo3.rp()) {
            OOq();
            BS.IlO((View) this.Bc, 8);
            MY(true);
            tV();
            return;
        }
        MY();
        if (lMM() || !lEW() || (eo = this.MY) == null || eo.oeT() || (oet = this.IlO) == null) {
            return;
        }
        if (this.wPn && oet.fdM() != null) {
            this.IlO.fdM();
            com.bytedance.sdk.openadsdk.core.rp.IlO.MY myIlO = oeT.IlO(((b0.b) CacheDirFactory.getICacheDir(this.IlO.hHv())).b(), this.IlO);
            myIlO.MY(this.IlO.ED());
            myIlO.MY(this.cL.getWidth());
            myIlO.EO(this.cL.getHeight());
            myIlO.EO(this.IlO.KT());
            myIlO.IlO(this.oc);
            myIlO.IlO(DmF());
            IlO(myIlO);
            this.MY.IlO(myIlO);
            this.wPn = false;
            BS.IlO((View) this.Bc, 8);
        }
        if (i2 != 0 || !this.ea || this.dY == null || (eo2 = this.MY) == null || eo2.rp()) {
            return;
        }
        this.dY.obtainMessage(1).sendToTarget();
    }

    public boolean rp() {
        return dY.IlO(this, 50, kBB.MY(this.rp) ? 1 : 5, false);
    }

    public void setAdCreativeClickListener(IlO ilO) {
        EO eo = this.MY;
        if (eo != null) {
            eo.IlO(ilO);
        }
    }

    public void setControllerStatusCallBack(MY my) {
        this.zPa = my;
    }

    public void setIsAutoPlay(boolean z2) {
        if (this.YA) {
            return;
        }
        int iMY = cl.tV().MY(this.IlO.hFV());
        if (z2 && iMY != 4 && (!xF.Cc(this.cl) ? !(!xF.vCE(this.cl) ? xF.tV(this.cl) : vSq() || dY()) : !vSq())) {
            z2 = false;
        }
        this.es = z2;
        EO eo = this.MY;
        if (eo != null) {
            eo.tV(z2);
        }
        if (this.es) {
            BS.IlO((View) this.Bc, 8);
        } else {
            Bc();
            RelativeLayout relativeLayout = this.Bc;
            if (relativeLayout != null) {
                BS.IlO((View) relativeLayout, 0);
                oeT oet = this.IlO;
                if (oet != null && oet.fdM() != null) {
                    com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO(this.IlO.fdM().f4689f, this.IlO.fdM().f4686b, this.IlO.fdM().f4685a, this.lEW, this.IlO);
                }
            }
        }
        this.YA = true;
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z2) {
        this.EV = z2;
    }

    public void setNeedSelfManagerVideo(boolean z2) {
        this.ea = z2;
    }

    public void setVideoAdClickListenerTTNativeAd(PAGNativeAd pAGNativeAd) {
        EO eo = this.MY;
        if (eo != null) {
            eo.IlO(pAGNativeAd);
        }
    }

    public void setVideoAdInteractionListener(a aVar) {
        this.zLG = aVar;
    }

    public void setVideoAdLoadListener(d dVar) {
        EO eo = this.MY;
        if (eo != null) {
            eo.IlO(dVar);
        }
    }

    public void setVideoCacheUrl(String str) {
        this.AXM = str;
    }

    public void setVideoPlayCallback(com.bytedance.sdk.openadsdk.core.rp.MY.MY my) {
        EO eo = this.MY;
        if (eo != null) {
            eo.IlO(my);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 4 || i2 == 8) {
            vAh();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.EO.IlO
    public void vCE() {
        a aVar = this.zLG;
        if (aVar != null) {
            aVar.e_();
        }
    }

    public void zPa() {
        oeT oet = this.IlO;
        if (oet == null || oet.QfH() == null) {
            return;
        }
        this.IlO.QfH().ea();
        this.IlO.QfH().IlO().Cc(this.oc);
    }

    public vCE(@NonNull Context context, @NonNull oeT oet, String str, boolean z2, boolean z7, Bc bc) {
        this(context, oet, false, str, z2, z7, bc);
    }

    public void EO() {
        if (hp()) {
            return;
        }
        ea();
    }

    public vCE(@NonNull Context context, @NonNull oeT oet, Bc bc) {
        this(context, oet, false, bc);
    }

    public void MY() {
        oeT oet = this.IlO;
        if (oet == null) {
            return;
        }
        int iHFV = oet.hFV();
        int iMY = cl.tV().MY(iHFV);
        int iEO = xF.EO(cl.IlO());
        if (iMY == 1) {
            this.es = zLG.tV(iEO);
        } else if (iMY == 2) {
            this.es = zLG.Cc(iEO) || zLG.tV(iEO) || zLG.vCE(iEO);
        } else if (iMY == 3) {
            this.es = false;
        } else if (iMY == 4) {
            this.bWL = true;
        } else if (iMY == 5) {
            this.es = zLG.tV(iEO) || zLG.vCE(iEO);
        }
        if (!this.xF) {
            if (!this.Cc || !kBB.MY(this.rp)) {
                this.tV = cl.tV().MY(String.valueOf(iHFV));
            }
        } else {
            this.tV = false;
        }
        if ("open_ad".equals(this.rp)) {
            this.es = true;
            this.tV = true;
        }
        if (kBB.MY(this.rp)) {
            this.tV = true;
        }
        EO eo = this.MY;
        if (eo != null) {
            eo.tV(this.es);
        }
        this.Cc = true;
    }

    public vCE(@NonNull Context context, @NonNull oeT oet, boolean z2, String str, boolean z7, boolean z8, Bc bc) {
        super(context);
        this.es = true;
        this.tV = true;
        this.xF = false;
        this.Cc = false;
        this.pP = true;
        this.tl = false;
        this.OOq = true;
        this.EV = true;
        this.rp = "embeded_ad";
        this.hp = 50;
        this.wPn = true;
        this.vSq = false;
        this.dY = new vSq(bWL.MY().getLooper(), this);
        this.YA = false;
        this.mmj = Build.MODEL;
        this.bWL = false;
        this.ea = true;
        this.ssS = new AtomicBoolean(false);
        this.gQ = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.vCE.4
            @Override // java.lang.Runnable
            public void run() {
                vCE vce = vCE.this;
                vce.IlO(vce.lMM, vCE.oeT.intValue());
            }
        };
        this.HSR = new AtomicBoolean(false);
        this.AK = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.vCE.6
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                vCE.this.cL();
            }
        };
        try {
            if (oet.Kn()) {
                this.kBB = ((b0.b) CacheDirFactory.getICacheDir(0)).d();
            }
        } catch (Throwable unused) {
        }
        if (bc != null) {
            this.vCE = bc;
        }
        this.rp = str;
        this.cl = context;
        this.IlO = oet;
        this.xF = z2;
        setContentDescription("NativeVideoTsView");
        this.tl = z7;
        this.OOq = z8;
        MY();
        Cc();
    }

    @Override // w.b
    public void IlO(long j, int i2) {
        a aVar = this.zLG;
        if (aVar != null) {
            aVar.h_();
        }
    }

    @Override // w.b
    public void IlO(long j, long j3) {
        a aVar = this.zLG;
        if (aVar != null) {
            aVar.IlO(j, j3);
        }
    }

    private View IlO(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        new FrameLayout.LayoutParams(-1, -1).gravity = 17;
        frameLayout.setVisibility(8);
        this.cL = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams);
        frameLayout.addView(frameLayout2);
        this.EO = frameLayout2;
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(view);
        this.DM = view;
        return frameLayout;
    }

    private RelativeLayout MY(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.Bc bc = new com.bytedance.sdk.openadsdk.core.Cc.Bc(context);
        bc.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        bc.setVisibility(8);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        tVVar.setLayoutParams(layoutParams);
        tVVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lEW = tVVar;
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar2 = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        tVVar2.setLayoutParams(layoutParams2);
        tVVar2.setVisibility(8);
        tVVar2.setBackground(pP.EO(context, "tt_new_play_video"));
        this.NV = tVVar2;
        bc.addView(tVVar);
        bc.addView(tVVar2);
        return bc;
    }

    private void IlO(View view, ViewGroup viewGroup, View view2) {
        int iIndexOfChild = viewGroup.indexOfChild(view2);
        viewGroup.removeViewInLayout(view2);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    public boolean IlO(long j, boolean z2, boolean z7) {
        boolean zIlO = false;
        this.cL.setVisibility(0);
        this.oc = j;
        if (!lMM()) {
            return true;
        }
        this.MY.IlO(false);
        oeT oet = this.IlO;
        if (oet != null && oet.fdM() != null) {
            com.bytedance.sdk.openadsdk.core.rp.IlO.MY myIlO = oeT.IlO(((b0.b) CacheDirFactory.getICacheDir(this.IlO.hHv())).b(), this.IlO);
            myIlO.MY(this.IlO.ED());
            myIlO.MY(this.cL.getWidth());
            myIlO.EO(this.cL.getHeight());
            myIlO.EO(this.IlO.KT());
            myIlO.IlO(j);
            myIlO.IlO(DmF());
            IlO(myIlO);
            if (z7) {
                this.MY.MY(myIlO);
                return true;
            }
            zIlO = this.MY.IlO(myIlO);
        }
        if (((j > 0 && !z2 && !z7) || (j > 0 && z2)) && this.MY != null) {
            ea.IlO ilO = new ea.IlO();
            ilO.MY(this.MY.Cc());
            ilO.tV(this.MY.lEW());
            ilO.EO(this.MY.vCE());
            com.bytedance.sdk.openadsdk.tV.Cc.IlO.IlO.MY(this.MY.EV(), ilO);
        }
        return zIlO;
    }

    public void MY(boolean z2) {
        EO eo = this.MY;
        if (eo != null) {
            eo.MY(z2);
            Cc ccEV = this.MY.EV();
            if (ccEV != null) {
                ccEV.MY();
                View viewEO = ccEV.EO();
                if (viewEO != null) {
                    if (viewEO.getParent() != null) {
                        ((ViewGroup) viewEO.getParent()).removeView(viewEO);
                    }
                    viewEO.setVisibility(0);
                    addView(viewEO);
                    ccEV.IlO((Object) this.IlO, new WeakReference(this.cl), false);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public void IlO(Message message) {
        if (message.what == 1) {
            kBB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(boolean z2, int i2) {
        if (this.IlO == null || this.MY == null) {
            return;
        }
        boolean zTl = tl();
        OOq();
        if (zTl && this.MY.rp()) {
            this.MY.rp();
            MY(true);
            tV();
            return;
        }
        if (z2 && this.pP && !this.MY.rp() && !this.MY.oeT()) {
            if (this.MY.NV() != null && this.MY.NV().Bc()) {
                if (this.es || i2 == 1) {
                    EO eo = this.MY;
                    if (eo != null) {
                        IlO(eo.vAh(), "changeVideoStatus");
                    }
                    if ("ALP-AL00".equals(this.mmj)) {
                        this.MY.MY();
                    } else {
                        if (!DmF.MY().cl()) {
                            zTl = true;
                        }
                        this.MY.Bc(zTl);
                    }
                    IlO(false);
                    a aVar = this.zLG;
                    if (aVar != null) {
                        aVar.g_();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.es && this.MY.NV() == null) {
                if (!this.ssS.get()) {
                    this.ssS.set(true);
                }
                this.HSR.set(false);
                AXM();
                return;
            }
            return;
        }
        if (this.MY.NV() == null || !this.MY.NV().vCE()) {
            return;
        }
        this.MY.IlO();
        IlO(true);
        a aVar2 = this.zLG;
        if (aVar2 != null) {
            aVar2.f_();
        }
    }

    public void IlO(boolean z2, String str) {
        if (kBB.MY(this.rp)) {
            z2 = true;
        }
        this.tV = z2;
        EO eo = this.MY;
        if (eo != null) {
            eo.IlO(z2, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.EO.IlO
    public void IlO(int i2) {
        MY();
    }

    public void IlO(boolean z2) {
        if (this.DmF == null) {
            this.DmF = new ImageView(getContext());
            if (DmF.MY().cL() != null) {
                this.DmF.setImageBitmap(DmF.MY().cL());
            } else {
                this.DmF.setImageResource(pP.tV(cl.IlO(), "tt_new_play_video"));
            }
            this.DmF.setScaleType(ImageView.ScaleType.FIT_XY);
            int iMY = BS.MY(getContext(), this.hp);
            int iMY2 = BS.MY(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iMY, iMY);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = iMY2;
            layoutParams.bottomMargin = iMY2;
            this.cL.addView(this.DmF, layoutParams);
            this.DmF.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.vCE.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    vCE.this.ea();
                }
            });
        }
        if (z2) {
            this.DmF.setVisibility(0);
        } else {
            this.DmF.setVisibility(8);
        }
    }

    public com.bytedance.sdk.openadsdk.core.EV.vCE IlO(List<Pair<View, FriendlyObstructionPurpose>> list) {
        EO eo = this.MY;
        if (eo != null) {
            return eo.IlO(this, list);
        }
        return null;
    }

    private void IlO(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        try {
            if (this.IlO.Kn()) {
                aVar.IlO(this.kBB);
            }
        } catch (Throwable unused) {
        }
    }
}
