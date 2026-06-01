package com.bytedance.sdk.openadsdk.core.rp.MY;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.lEW.lEW;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.cL.Bc;
import com.bytedance.sdk.openadsdk.core.MY.IlO;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.rp.MY.vCE;
import com.bytedance.sdk.openadsdk.core.settings.hp;
import com.bytedance.sdk.openadsdk.core.widget.cl;
import com.bytedance.sdk.openadsdk.core.widget.es;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.EV;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.bytedance.sdk.openadsdk.utils.zPa;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import w.e;
import w.g;
import x.b;
import x.c;
import x.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc implements g, c, vSq.IlO, IlO.InterfaceC0087IlO, cl.IlO, es.MY {
    boolean AXM;
    View Bc;
    ImageView Cc;
    private long DM;
    View DmF;
    ViewGroup EO;
    ImageView EV;
    protected final int IlO;
    protected final int MY;
    View NV;
    es OOq;
    boolean YA;
    TextView bWL;
    int cL;
    int cl;
    e dY;
    TextView ea;
    int es;
    com.bytedance.sdk.openadsdk.core.widget.IlO hp;
    int kBB;
    ImageView lEW;
    com.bytedance.sdk.openadsdk.core.MY.IlO lMM;
    private vCE.IlO mmj;
    com.bytedance.sdk.openadsdk.core.MY.IlO nvX;
    boolean oc;
    boolean oeT;
    oeT pP;
    View rp;
    x.e tV;
    Context tl;
    int vAh;
    View vCE;
    com.bytedance.sdk.openadsdk.es.IlO.IlO.vCE vSq;
    IlO wPn;
    int xF;
    private final String zLG;
    TextView zPa;

    public Cc(Context context, ViewGroup viewGroup, boolean z2, int i2, oeT oet, e eVar, boolean z7) {
        this.IlO = 228;
        this.MY = 160;
        this.AXM = true;
        this.oc = true;
        this.YA = true;
        this.zLG = Build.MODEL;
        if (this instanceof tV) {
            return;
        }
        this.tl = com.bytedance.sdk.openadsdk.core.cl.IlO().getApplicationContext();
        tV(z7);
        this.EO = viewGroup;
        this.AXM = z2;
        this.kBB = i2;
        this.dY = eVar;
        this.pP = oet;
        tV(8);
        IlO(context, this.EO);
        tV();
        rp();
    }

    private boolean pP() {
        return oeT.Cc(this.pP) && (!com.bytedance.sdk.openadsdk.core.NV.tV.IlO(this.pP.nvX()) ? this.pP.uvo() == null : this.pP.Ea() == null) && this.pP.lMM() == 1;
    }

    public boolean AXM() {
        return this.AXM;
    }

    public void Bc() {
        oeT oet;
        BS.vCE(this.vCE);
        BS.vCE(this.Bc);
        if (this.lEW != null && (oet = this.pP) != null && oet.fdM() != null && this.pP.fdM().f4689f != null) {
            BS.vCE(this.lEW);
            Bc.IlO().IlO(this.pP.fdM().f4689f, this.pP.fdM().f4686b, this.pP.fdM().f4685a, this.lEW, this.pP);
        }
        if (this.Cc.getVisibility() == 0) {
            BS.IlO((View) this.Cc, 8);
        }
    }

    public void Cc() {
    }

    public void DmF() {
        tV(8);
        if (kBB()) {
            this.tV.setVisibility(8);
        }
        ImageView imageView = this.lEW;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        tV(8);
        BS.IlO(this.NV, 8);
        BS.IlO((View) this.EV, 8);
        BS.IlO(this.rp, 8);
        BS.IlO((View) this.hp, 8);
        BS.IlO((View) this.bWL, 8);
        BS.IlO((View) this.ea, 8);
        es esVar = this.OOq;
        if (esVar != null) {
            esVar.IlO(true);
        }
    }

    public void EO(boolean z2) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.es.MY
    public void EV() {
        IlO(true, false);
    }

    public void IlO(int i2) {
    }

    public void MY(ViewGroup viewGroup) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.es.MY
    public boolean NV() {
        return false;
    }

    public void bWL() {
        if (this.wPn == null || this.OOq != null) {
            return;
        }
        System.currentTimeMillis();
        es esVar = new es();
        this.OOq = esVar;
        esVar.IlO(this.tl, this.EO);
        this.OOq.IlO(this.wPn, this);
        System.currentTimeMillis();
    }

    public void cL() {
        BS.IlO((View) this.EO, 0);
        x.e eVar = this.tV;
        if (eVar != null) {
            BS.IlO(eVar.getView(), 0);
        }
    }

    public void cl() {
        BS.vCE(this.vCE);
        BS.vCE(this.Bc);
        if (this.Cc.getVisibility() == 0) {
            BS.IlO((View) this.Cc, 8);
        }
    }

    public void ea() {
        es esVar = this.OOq;
        if (esVar != null) {
            esVar.IlO(false);
        }
    }

    public void es() {
        try {
            BS.IlO(this.NV, 8);
            BS.IlO((View) this.EV, 8);
            BS.IlO(this.rp, 8);
            BS.IlO((View) this.hp, 8);
            BS.IlO((View) this.bWL, 8);
            BS.IlO((View) this.ea, 8);
            BS.IlO((View) this.zPa, 8);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.MY.IlO.InterfaceC0087IlO
    public long getVideoProgress() {
        if (this.DM <= 0) {
            oeT oet = this.pP;
            if (oet != null && oet.fdM() != null) {
                this.DM = (long) (this.pP.fdM().f4688d * 1000.0d);
            }
            e eVar = this.dY;
            if (eVar != null) {
                this.DM = eVar.lEW();
            }
        }
        return this.DM;
    }

    public x.e hp() {
        return this.tV;
    }

    public boolean kBB() {
        return (this.kBB & 4) != 4 || this.AXM;
    }

    public void lEW() {
        BS.Cc(this.vCE);
    }

    public boolean oeT() {
        return this.oeT;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void rp() {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rp.MY.Cc.rp():void");
    }

    public void tV() {
        this.tV.a(this);
        this.Cc.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.Cc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Cc.this.zPa()) {
                    TextView textView = Cc.this.zPa;
                    if (textView == null || textView.getVisibility() != 0) {
                        Cc cc = Cc.this;
                        cc.wPn.IlO(cc, view);
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.cl.IlO
    public boolean vAh() {
        es esVar = this.OOq;
        return esVar != null && esVar.IlO();
    }

    public void vCE() {
    }

    public void xF() {
        ImageView imageView = this.EV;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        com.bytedance.sdk.openadsdk.core.widget.IlO ilO = this.hp;
        if (ilO != null) {
            ilO.setImageBitmap(null);
        }
    }

    public boolean zPa() {
        return this.wPn != null;
    }

    private int Cc(int i2) {
        if (this.es <= 0 || this.xF <= 0) {
            return 0;
        }
        int iMY = BS.MY(this.tl, 228.0f);
        int iMY2 = BS.MY(this.tl, 160.0f);
        int i8 = (int) (this.xF * ((i2 * 1.0f) / this.es));
        return i8 > iMY ? iMY : i8 < iMY2 ? iMY2 : i8;
    }

    private void vCE(int i2) {
        BS.IlO(this.rp, i2);
    }

    public void EO(int i2) {
        BS.IlO((View) this.EO, 0);
        x.e eVar = this.tV;
        if (eVar != null) {
            eVar.setVisibility(i2);
        }
    }

    public void IlO(long j) {
    }

    public void MY(boolean z2) {
    }

    public void IlO(long j, long j3) {
    }

    public boolean MY(int i2) {
        return false;
    }

    public void tV(boolean z2) {
        this.oc = z2;
        if (z2) {
            com.bytedance.sdk.openadsdk.core.MY.IlO ilO = this.lMM;
            if (ilO != null) {
                ilO.IlO(true);
            }
            com.bytedance.sdk.openadsdk.core.MY.IlO ilO2 = this.nvX;
            if (ilO2 != null) {
                ilO2.IlO(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.MY.IlO ilO3 = this.lMM;
        if (ilO3 != null) {
            ilO3.IlO(false);
        }
        com.bytedance.sdk.openadsdk.core.MY.IlO ilO4 = this.nvX;
        if (ilO4 != null) {
            ilO4.IlO(false);
        }
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public void IlO(Message message) {
    }

    public void MY(boolean z2, boolean z7) {
        ImageView imageView = this.Cc;
        if (imageView != null) {
            if (z2) {
                imageView.setImageDrawable(EV.IlO(this.tl, "tt_play_movebar_textpage"));
            } else {
                imageView.setImageDrawable(EV.IlO(this.tl, "tt_stop_movebar_textpage"));
            }
        }
    }

    public void EO(int i2, int i8) {
        this.es = i2;
        this.xF = i8;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.cl.IlO
    public void IlO(View view, boolean z2) {
    }

    public void IlO(ViewGroup viewGroup) {
    }

    public void EO(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.EO.getParent() == null) {
            viewGroup.addView(this.EO);
        }
        tV(0);
    }

    public void IlO(String str) {
    }

    public void MY(int i2, int i8) {
        ViewGroup.LayoutParams layoutParams = this.EO.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.width = i2;
        }
        if (i8 == -1 || i8 == -2 || i8 > 0) {
            layoutParams.height = i8;
        }
        this.EO.setLayoutParams(layoutParams);
    }

    @Override // w.g
    public View EO() {
        return this.EO;
    }

    @Override // w.g
    public /* bridge */ /* synthetic */ void IlO(Object obj, WeakReference weakReference, boolean z2) {
        IlO((oeT) obj, (WeakReference<Context>) weakReference, z2);
    }

    public void IlO(vCE.IlO ilO) {
        this.mmj = ilO;
    }

    @Override // w.g
    public void MY() {
        BS.Cc(this.vCE);
        BS.Cc(this.Bc);
        ImageView imageView = this.lEW;
        if (imageView != null) {
            BS.Cc(imageView);
        }
    }

    public void IlO(PAGNativeAd pAGNativeAd) {
        com.bytedance.sdk.openadsdk.core.MY.IlO ilO = this.lMM;
        if (ilO != null) {
            ilO.IlO(pAGNativeAd);
        }
        com.bytedance.sdk.openadsdk.core.MY.IlO ilO2 = this.nvX;
        if (ilO2 != null) {
            ilO2.IlO(pAGNativeAd);
        }
    }

    public void tV(int i2) {
        this.vAh = i2;
        BS.IlO((View) this.EO, i2);
    }

    @Override // x.c
    public void MY(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.tV.getHolder()) {
            return;
        }
        this.oeT = false;
        if (zPa()) {
            this.wPn.MY(this, surfaceHolder);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.view.ViewGroup, android.widget.RelativeLayout] */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.view.View, x.e] */
    public void IlO(Context context, View view) {
        ?? fVar;
        System.currentTimeMillis();
        oeT oet = this.pP;
        if ((oet == null || ((!oet.fo() && !this.pP.Tgn()) || hp.aP().jM())) && view != null) {
            view.setKeepScreenOn(true);
        }
        e eVar = this.dY;
        if (eVar != null && eVar.bWL()) {
            fVar = new f(this.tl, null);
        } else {
            b bVar = new b(this.tl);
            x.g gVar = new x.g(bVar);
            bVar.f17782b = gVar;
            b.f17780c.add(gVar);
            fVar = bVar;
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(fVar, 0, layoutParams);
        }
        BS.IlO((View) fVar, 8);
        this.tV = fVar;
        this.Cc = (ImageView) view.findViewById(zPa.xJ);
        this.vCE = view.findViewById(zPa.XvI);
        this.Bc = view.findViewById(zPa.BC);
        this.lEW = (ImageView) view.findViewById(zPa.IRy);
        this.DmF = view.findViewById(zPa.NST);
        System.currentTimeMillis();
    }

    public Cc(Context context, ViewGroup viewGroup, boolean z2, int i2, oeT oet, e eVar) {
        this(context, viewGroup, z2, i2, oet, eVar, true);
    }

    public void IlO(View view, Context context) {
        View view2;
        if (view == null || context == null || (view2 = this.DmF) == null || view2.getParent() == null || this.NV != null) {
            return;
        }
        this.NV = this.DmF;
        this.EV = (ImageView) view.findViewById(zPa.ao);
        this.rp = view.findViewById(zPa.aP);
        this.hp = (com.bytedance.sdk.openadsdk.core.widget.IlO) view.findViewById(zPa.ssS);
        this.bWL = (TextView) view.findViewById(zPa.gQ);
        this.ea = (TextView) view.findViewById(zPa.HSR);
        this.zPa = (TextView) view.findViewById(zPa.AK);
    }

    public boolean IlO(int i2, com.bykv.vk.openvk.IlO.IlO.IlO.EO.c cVar, boolean z2) {
        es esVar = this.OOq;
        return esVar == null || esVar.IlO(i2, cVar, z2);
    }

    public void IlO(w.f fVar) {
        if (fVar instanceof IlO) {
            this.wPn = (IlO) fVar;
            bWL();
        }
    }

    public void IlO(int i2, int i8) {
        if (i2 == -1) {
            i2 = BS.EO(this.tl);
        }
        if (i2 <= 0) {
            return;
        }
        this.cl = i2;
        if (!AXM() && !NV() && (this.kBB & 8) != 8) {
            this.cL = Cc(i2);
        } else {
            this.cL = i8;
        }
        MY(this.cl, this.cL);
    }

    @Override // w.g
    public void IlO() {
        IlO(false, this.AXM);
        es();
    }

    @Override // w.g
    public void IlO(boolean z2) {
        this.YA = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x0213  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(com.bytedance.sdk.openadsdk.core.model.oeT r7, java.lang.ref.WeakReference<android.content.Context> r8, boolean r9) {
        /*
            Method dump skipped, instruction units count: 566
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rp.MY.Cc.IlO(com.bytedance.sdk.openadsdk.core.model.oeT, java.lang.ref.WeakReference, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(final int i2, final String str, final oeT oet) {
        com.bytedance.sdk.openadsdk.tV.EO.IlO(new lEW("load_vast_icon_fail") { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.Cc.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("error_code", i2);
                    jSONObject.put("description", i2 + ":" + str);
                    jSONObject.put("url", Cc.this.pP.HTA().IlO());
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.tV.EO.MY(Cc.this.pP, Cc.this.pP != null ? zLG.EO(oet.OyN()) : null, "load_vast_icon_fail", jSONObject);
            }
        });
    }

    @Override // x.c
    public void IlO(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.tV.getHolder()) {
            return;
        }
        this.oeT = true;
        if (zPa()) {
            this.wPn.IlO(this, surfaceHolder);
        }
    }

    @Override // x.c
    public void IlO(SurfaceHolder surfaceHolder, int i2, int i8, int i9) {
        if (surfaceHolder != this.tV.getHolder()) {
            return;
        }
        zPa();
    }

    @Override // x.c
    public void IlO(SurfaceTexture surfaceTexture, int i2, int i8) {
        this.oeT = true;
        if (zPa()) {
            this.wPn.IlO(this, surfaceTexture);
        }
    }

    @Override // x.c
    public boolean IlO(SurfaceTexture surfaceTexture) {
        this.oeT = false;
        if (!zPa()) {
            return true;
        }
        this.wPn.MY(this, surfaceTexture);
        return true;
    }

    public void IlO(boolean z2, boolean z7, boolean z8) {
        BS.IlO((View) this.Cc, (!z2 || this.vCE.getVisibility() == 0) ? 8 : 0);
    }

    public void IlO(boolean z2, boolean z7) {
        BS.IlO((View) this.Cc, 8);
    }

    @Override // w.g
    public void IlO(Drawable drawable) {
        ViewGroup viewGroup = this.EO;
        if (viewGroup != null) {
            viewGroup.setBackgroundDrawable(drawable);
        }
    }
}
