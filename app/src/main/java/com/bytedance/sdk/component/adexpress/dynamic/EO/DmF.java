package com.bytedance.sdk.component.adexpress.dynamic.EO;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.vCE.OOq;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends FrameLayout implements lEW {
    private com.bytedance.sdk.component.adexpress.vCE.es Bc;
    private Bc Cc;
    private int DmF;
    private com.bytedance.sdk.component.adexpress.dynamic.tV.Bc EO;
    private com.bytedance.sdk.component.adexpress.dynamic.tV.NV EV;
    private Context IlO;
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc MY;
    private boolean NV;
    private View.OnTouchListener lEW;
    private com.bytedance.sdk.component.adexpress.MY.hp rp;
    private View tV;
    private String vCE;

    public DmF(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc) {
        super(context);
        this.IlO = context;
        this.MY = cc;
        this.EO = bc;
        Bc();
    }

    private void Bc() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.vCE = this.EO.gQ();
        this.DmF = this.EO.quf();
        this.NV = this.EO.wD();
        Bc bcIlO = NV.IlO(this.IlO, this.MY, this.EO, this.EV, this.rp);
        this.Cc = bcIlO;
        if (bcIlO != null) {
            this.tV = bcIlO.EO();
            if (this.EO.HSR()) {
                setBackgroundColor(Color.parseColor("#50000000"));
            }
            if (TextUtils.equals(this.vCE, "6")) {
                if (!this.EO.nm() || TextUtils.isEmpty(this.EO.ii())) {
                    this.Bc = new com.bytedance.sdk.component.adexpress.vCE.es(this.IlO, Color.parseColor("#99000000"));
                } else {
                    this.Bc = new com.bytedance.sdk.component.adexpress.vCE.es(this.IlO, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc.IlO(this.EO.ii()));
                }
                FrameLayout frameLayout = new FrameLayout(this.IlO);
                frameLayout.addView(this.Bc, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.EO.DmF.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DmF.this.Bc.MY();
                    }
                });
            }
            if (IlO(this.vCE) && com.bytedance.sdk.component.adexpress.tV.MY()) {
                int color = Color.parseColor("#99000000");
                if (this.EO.nm() && !TextUtils.isEmpty(this.EO.ii())) {
                    try {
                        color = com.bytedance.sdk.component.adexpress.dynamic.tV.Bc.IlO(this.EO.ii());
                    } catch (Exception unused) {
                    }
                }
                View view = new View(this.IlO);
                view.setBackgroundColor(color);
                addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            addView(this.Cc.EO());
            IlO(this.Cc.EO());
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DmF() {
        if (this.lEW != null) {
            setOnClickListener((View.OnClickListener) this.MY.getDynamicClickListener());
            performClick();
            if (this.EO.ED()) {
                return;
            }
            setVisibility(8);
        }
    }

    private boolean lEW() {
        return (this.EO.wD() || TextUtils.equals("9", this.vCE) || TextUtils.equals("16", this.vCE) || TextUtils.equals("17", this.vCE) || TextUtils.equals("18", this.vCE) || TextUtils.equals("20", this.vCE) || TextUtils.equals("29", this.vCE) || TextUtils.equals("10", this.vCE)) ? false : true;
    }

    public void Cc() {
        if (this.tV != null && TextUtils.equals(this.vCE, "2")) {
            View view = this.tV;
            if (view instanceof com.bytedance.sdk.component.adexpress.vCE.EO) {
                ((com.bytedance.sdk.component.adexpress.vCE.EO) view).EO();
            }
        }
    }

    public void EO() {
        Bc bc = this.Cc;
        if (bc != null) {
            bc.IlO();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            Bc bc = this.Cc;
            if (bc != null) {
                bc.MY();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.lEW instanceof com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.EO) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void tV() {
        Bc bc = this.Cc;
        if (bc != null) {
            bc.MY();
        }
    }

    public void vCE() {
        if (this.tV != null && TextUtils.equals(this.vCE, "2")) {
            View view = this.tV;
            if (view instanceof com.bytedance.sdk.component.adexpress.vCE.EO) {
                ((com.bytedance.sdk.component.adexpress.vCE.EO) view).tV();
            }
        }
    }

    private boolean IlO(String str) {
        return TextUtils.equals(str, "24") || TextUtils.equals(str, "23") || TextUtils.equals(str, "25") || TextUtils.equals(str, "22") || TextUtils.equals(str, "1");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.lEW
    public void MY() {
        if (lEW()) {
            setOnClickListener((View.OnClickListener) this.MY.getDynamicClickListener());
            performClick();
            if (this.EO.ED()) {
                return;
            }
            setVisibility(8);
        }
    }

    public DmF(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc, com.bytedance.sdk.component.adexpress.dynamic.tV.NV nv, com.bytedance.sdk.component.adexpress.MY.hp hpVar) {
        super(context);
        this.IlO = context;
        this.MY = cc;
        this.EO = bc;
        this.EV = nv;
        this.rp = hpVar;
        Bc();
    }

    private void IlO(ViewGroup viewGroup) {
        if (this.tV == null) {
            return;
        }
        String str = this.vCE;
        str.getClass();
        switch (str) {
            case "0":
                this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.Cc(this, this.DmF);
                setBackgroundColor(Color.parseColor("#80000000"));
                break;
            case "1":
            case "6":
                if (!this.EO.nm() || TextUtils.isEmpty(this.EO.ii())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.vCE(this);
                break;
            case "2":
            case "7":
                setBackgroundColor(Color.parseColor("#80000000"));
                this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.MY(this, this);
                break;
            case "5":
                if (this.EO.nm() && !TextUtils.isEmpty(this.EO.ii())) {
                    setBackgroundColor(com.bytedance.sdk.component.adexpress.dynamic.tV.Bc.IlO(this.EO.ii()));
                } else {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.EO(this);
                this.tV.setTag(2);
                break;
            case "8":
            case "11":
                this.MY.setClipChildren(false);
                this.MY.setClipChildren(false);
                ViewGroup viewGroup2 = (ViewGroup) this.MY.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.vCE(this);
                break;
            case "9":
            case "17":
                this.tV.setTag(2);
                break;
            case "10":
                this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.tV(this, this.DmF, this.NV);
                break;
            case "12":
                this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.EO(this);
                this.tV.setTag(2);
                break;
            case "13":
            case "24":
                if (this.vCE.equals("24") && com.bytedance.sdk.component.adexpress.tV.MY()) {
                    this.MY.setClipChildren(false);
                    this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.vCE(this);
                    break;
                } else {
                    this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.Cc(this, this.DmF);
                    break;
                }
                break;
            case "14":
                this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.MY(this, this);
                break;
            case "16":
                View view = this.tV;
                if (view != null && (view instanceof com.bytedance.sdk.component.adexpress.vCE.xF) && ((com.bytedance.sdk.component.adexpress.vCE.xF) view).getShakeLayout() != null) {
                    ((com.bytedance.sdk.component.adexpress.vCE.xF) this.tV).getShakeLayout().setTag(2);
                }
                this.tV.setTag(2);
                break;
            case "18":
                View view2 = this.tV;
                if (view2 != null && (view2 instanceof OOq) && ((OOq) view2).getWriggleLayout() != null) {
                    ((OOq) this.tV).getWriggleLayout().setTag(2);
                }
                this.tV.setTag(2);
                break;
            case "20":
                this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.IlO(this, this.DmF, viewGroup);
                break;
            case "22":
                if (com.bytedance.sdk.component.adexpress.tV.MY()) {
                    this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.lEW(this, this.NV);
                    break;
                } else {
                    this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.Bc(this, this.DmF, viewGroup);
                    break;
                }
                break;
            case "23":
                if (com.bytedance.sdk.component.adexpress.tV.MY()) {
                    this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.vCE(this);
                    break;
                }
                break;
            case "25":
                if (com.bytedance.sdk.component.adexpress.tV.MY()) {
                    this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.lEW(this, this.NV);
                    break;
                }
                break;
            case "29":
                View view3 = this.tV;
                if (view3 != null && (view3 instanceof com.bytedance.sdk.component.adexpress.vCE.vCE) && ((com.bytedance.sdk.component.adexpress.vCE.vCE) view3).getShakeView() != null) {
                    ((com.bytedance.sdk.component.adexpress.vCE.vCE) this.tV).getShakeView().setTag(2);
                }
                this.lEW = new com.bytedance.sdk.component.adexpress.dynamic.EO.IlO.Cc(this, this.DmF);
                break;
        }
        View.OnTouchListener onTouchListener = this.lEW;
        if (onTouchListener != null) {
            setOnTouchListener(onTouchListener);
        }
        if (lEW()) {
            this.tV.setTag(2);
            setOnClickListener((View.OnClickListener) this.MY.getDynamicClickListener());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.lEW
    public void IlO() {
        if (TextUtils.equals(this.vCE, "6")) {
            com.bytedance.sdk.component.adexpress.vCE.es esVar = this.Bc;
            if (esVar != null) {
                esVar.EO();
                postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.EO.DmF.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DmF.this.DmF();
                    }
                }, 300L);
                return;
            }
            return;
        }
        if (TextUtils.equals(this.vCE, "20")) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.EO.DmF.3
                @Override // java.lang.Runnable
                public void run() {
                    DmF.this.DmF();
                }
            }, 400L);
        } else {
            DmF();
        }
    }
}
