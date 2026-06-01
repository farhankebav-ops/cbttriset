package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.camera.core.processing.util.a;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Cc extends FrameLayout implements IAnimation, YA, mmj {
    private static final View.OnTouchListener oeT = new View.OnTouchListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private static final View.OnClickListener vAh = new View.OnClickListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };
    private com.bytedance.sdk.component.utils.tl AXM;
    protected int Bc;
    protected float Cc;
    protected int DmF;
    protected float EO;
    protected Context EV;
    private float IlO;
    private float MY;
    protected int NV;
    protected DynamicRootView bWL;
    com.bytedance.sdk.component.adexpress.dynamic.animation.view.EO cL;
    protected com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.MY cl;
    protected View ea;
    private float es;
    protected com.bytedance.sdk.component.adexpress.dynamic.tV.lEW hp;
    protected int lEW;
    protected com.bytedance.sdk.component.adexpress.dynamic.tV.Bc rp;
    protected float tV;
    protected float vCE;
    private float xF;
    protected boolean zPa;

    public Cc(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context);
        this.EV = context;
        this.bWL = dynamicRootView;
        this.hp = lew;
        this.EO = lew.vCE();
        this.tV = lew.Bc();
        this.Cc = lew.lEW();
        this.vCE = lew.DmF();
        this.DmF = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.EO);
        this.NV = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.tV);
        this.Bc = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.Cc);
        this.lEW = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.vCE);
        com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc = new com.bytedance.sdk.component.adexpress.dynamic.tV.Bc(lew.NV());
        this.rp = bc;
        if (bc.cL() > 0) {
            this.Bc = (this.rp.cL() * 2) + this.Bc;
            this.lEW = (this.rp.cL() * 2) + this.lEW;
            this.DmF -= this.rp.cL();
            this.NV -= this.rp.cL();
            List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> listEV = lew.EV();
            if (listEV != null) {
                for (com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew2 : listEV) {
                    lew2.EO(lew2.vCE() + com.bytedance.sdk.component.adexpress.tV.Bc.MY(this.EV, this.rp.cL()));
                    lew2.tV(lew2.Bc() + com.bytedance.sdk.component.adexpress.tV.Bc.MY(this.EV, this.rp.cL()));
                    lew2.IlO(com.bytedance.sdk.component.adexpress.tV.Bc.MY(this.EV, this.rp.cL()));
                    lew2.MY(com.bytedance.sdk.component.adexpress.tV.Bc.MY(this.EV, this.rp.cL()));
                }
            }
        }
        this.zPa = this.rp.bWL() > 0.0d;
        this.cL = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.EO();
    }

    public void Bc() {
        if (lEW()) {
            return;
        }
        View view = this.ea;
        if (view == null) {
            view = this;
        }
        this.cl = new com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.MY(view, this.hp.NV().Cc().uF());
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.MY my = Cc.this.cl;
                if (my != null) {
                    my.IlO();
                }
            }
        });
    }

    public boolean Cc() {
        com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc = this.rp;
        return (bc == null || bc.OOq() == 0) ? false : true;
    }

    public boolean EO() {
        DmF();
        vCE();
        tV();
        return true;
    }

    public void IlO(int i2) {
        com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc = this.rp;
        if (bc != null && bc.IlO(i2)) {
            DmF();
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt != null && (getChildAt(i8) instanceof Cc)) {
                    ((Cc) childAt).IlO(i2);
                }
            }
        }
    }

    public void MY(@NonNull View view) {
        com.bytedance.sdk.component.adexpress.dynamic.tV.vCE vceCc;
        com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew = this.hp;
        if (lew == null || (vceCc = lew.NV().Cc()) == null) {
            return;
        }
        view.setTag(2097610716, Boolean.valueOf(vceCc.KS()));
    }

    public Drawable getBackgroundDrawable() {
        return IlO(false, "");
    }

    public boolean getBeginInvisibleAndShow() {
        return this.zPa;
    }

    public int getClickArea() {
        return this.rp.OOq();
    }

    public GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    public com.bytedance.sdk.component.adexpress.dynamic.vCE.IlO getDynamicClickListener() {
        return this.bWL.getDynamicClickListener();
    }

    public int getDynamicHeight() {
        return this.lEW;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.tV.vCE getDynamicLayoutBrickValue() {
        com.bytedance.sdk.component.adexpress.dynamic.tV.Cc ccNV;
        com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew = this.hp;
        if (lew == null || (ccNV = lew.NV()) == null) {
            return null;
        }
        return ccNV.Cc();
    }

    public int getDynamicWidth() {
        return this.Bc;
    }

    public String getImageObjectFit() {
        return this.rp.hL();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getMarqueeValue() {
        return this.es;
    }

    public Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(IlO(MY(this.rp.mmj().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getRippleValue() {
        return this.IlO;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getShineValue() {
        return this.MY;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public float getStretchValue() {
        return this.xF;
    }

    public boolean lEW() {
        com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew = this.hp;
        return lew == null || lew.NV() == null || this.hp.NV().Cc() == null || this.hp.NV().Cc().uF() == null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Bc();
        IlO();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        MY();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.cL.IlO(canvas, this, this);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        com.bytedance.sdk.component.adexpress.dynamic.animation.view.EO eo = this.cL;
        View view = this.ea;
        if (view == null) {
            view = this;
        }
        eo.IlO(view, i2, i8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setMarqueeValue(float f4) {
        this.es = f4;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setRippleValue(float f4) {
        this.IlO = f4;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setShineValue(float f4) {
        this.MY = f4;
        postInvalidate();
    }

    public void setShouldInvisible(boolean z2) {
        this.zPa = z2;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.IAnimation
    public void setStretchValue(float f4) {
        this.xF = f4;
        this.cL.IlO(this, f4);
    }

    public boolean tV() {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.ea;
        View view2 = view;
        if (view == null) {
            view2 = this;
        }
        if (Cc()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = oeT;
            onClickListener = vAh;
        }
        if (onTouchListener != null && onClickListener != null) {
            view2.setOnTouchListener(onTouchListener);
            view2.setOnClickListener(onClickListener);
            int iIlO = com.bytedance.sdk.component.adexpress.dynamic.MY.IlO.IlO(this.rp);
            if (iIlO == 2 || iIlO == 3) {
                view2.setOnClickListener(vAh);
            } else {
                view2.setOnClickListener(onClickListener);
            }
        }
        IlO(view2);
        MY(view2);
        return true;
    }

    public void vCE() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.Bc, this.lEW);
        layoutParams.topMargin = this.NV;
        int i2 = this.DmF;
        layoutParams.leftMargin = i2;
        layoutParams.setMarginStart(i2);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    private List<String> MY(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        boolean z2 = false;
        int i8 = 0;
        for (int i9 = 0; i9 < str.length(); i9++) {
            if (str.charAt(i9) == '(') {
                i2++;
                z2 = true;
            } else if (str.charAt(i9) == ')' && i2 - 1 == 0 && z2) {
                int i10 = i9 + 1;
                arrayList.add(str.substring(i8, i10));
                i8 = i10;
                z2 = false;
            }
        }
        return arrayList;
    }

    public void IlO(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.hp.lEW());
            jSONObject.put("height", this.hp.DmF());
            if (com.bytedance.sdk.component.adexpress.tV.MY()) {
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.IlO.xF, this.rp.DM());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.IlO.AXM, this.hp.NV().MY());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.IlO.oeT, this.hp.EO());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.IlO.vAh, jSONObject.toString());
                return;
            }
            view.setTag(2097610717, this.rp.DM());
            view.setTag(2097610715, this.hp.NV().MY());
            view.setTag(2097610714, this.hp.EO());
            view.setTag(2097610713, jSONObject.toString());
            int iIlO = com.bytedance.sdk.component.adexpress.dynamic.MY.IlO.IlO(this.rp);
            if (iIlO == 1) {
                view.setTag(2097610707, new Pair(this.rp.pP(), Long.valueOf(this.rp.tl())));
                view.setTag(2097610708, Integer.valueOf(iIlO));
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mmj
    public void MY() {
        com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.MY my = this.cl;
        if (my != null) {
            my.MY();
        }
    }

    public Drawable IlO(boolean z2, String str) {
        String[] strArrSplit;
        int[] iArr;
        int iWPn;
        if (!TextUtils.isEmpty(this.rp.mmj())) {
            try {
                String strMmj = this.rp.mmj();
                String strSubstring = strMmj.substring(strMmj.indexOf("(") + 1, strMmj.length() - 1);
                if (strSubstring.contains("rgba") && strSubstring.contains("%")) {
                    strArrSplit = new String[]{strSubstring.substring(0, strSubstring.indexOf(",")).trim(), strSubstring.substring(strSubstring.indexOf(",") + 1, strSubstring.indexOf("%") + 1).trim(), strSubstring.substring(strSubstring.indexOf("%") + 2).trim()};
                    iArr = new int[]{com.bytedance.sdk.component.adexpress.dynamic.tV.Bc.IlO(strArrSplit[1]), com.bytedance.sdk.component.adexpress.dynamic.tV.Bc.IlO(strArrSplit[2])};
                } else {
                    strArrSplit = strSubstring.split(", ");
                    iArr = new int[]{com.bytedance.sdk.component.adexpress.dynamic.tV.Bc.IlO(strArrSplit[1].substring(0, 7)), com.bytedance.sdk.component.adexpress.dynamic.tV.Bc.IlO(strArrSplit[2].substring(0, 7))};
                }
                try {
                    double d8 = Double.parseDouble(strSubstring.substring(strSubstring.indexOf("linear-gradient(") + 1, strSubstring.indexOf("deg")));
                    if (d8 > 225.0d && d8 < 315.0d) {
                        int i2 = iArr[1];
                        iArr[1] = iArr[0];
                        iArr[0] = i2;
                    }
                } catch (Exception unused) {
                }
                GradientDrawable gradientDrawableIlO = IlO(IlO(strArrSplit[0]), iArr);
                gradientDrawableIlO.setShape(0);
                gradientDrawableIlO.setCornerRadius(com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.ea()));
                return gradientDrawableIlO;
            } catch (Exception unused2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float fIlO = com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.ea());
        drawable.setCornerRadius(fIlO);
        if (fIlO < 1.0f) {
            float fIlO2 = com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.vSq());
            float fIlO3 = com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.dY());
            float fIlO4 = com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.lMM());
            float fIlO5 = com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.nvX());
            float[] fArr = new float[8];
            if (fIlO2 > 0.0f) {
                fArr[0] = fIlO2;
                fArr[1] = fIlO2;
            }
            if (fIlO3 > 0.0f) {
                fArr[2] = fIlO3;
                fArr[3] = fIlO3;
            }
            if (fIlO4 > 0.0f) {
                fArr[4] = fIlO4;
                fArr[5] = fIlO4;
            }
            if (fIlO5 > 0.0f) {
                fArr[6] = fIlO5;
                fArr[7] = fIlO5;
            }
            drawable.setCornerRadii(fArr);
        }
        if (z2) {
            iWPn = Color.parseColor(str);
        } else {
            iWPn = this.rp.wPn();
        }
        drawable.setColor(iWPn);
        if (this.rp.cl() > 0.0f) {
            drawable.setStroke((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.cl()), this.rp.zPa());
        } else if (this.rp.cL() > 0) {
            drawable.setStroke(this.rp.cL(), this.rp.zPa());
            drawable.setAlpha(50);
            if (a.B(this.hp, "video-vd")) {
                setLayerType(1, null);
                return new xF((int) fIlO, this.rp.cL());
            }
        }
        return drawable;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
    }

    public MY IlO(Bitmap bitmap) {
        return new IlO(bitmap, null);
    }

    private Drawable[] IlO(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            if (str.contains("linear-gradient")) {
                String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = strArrSplit.length - 1;
                int[] iArr = new int[length];
                int i8 = 0;
                while (i8 < length) {
                    int i9 = i8 + 1;
                    iArr[i8] = com.bytedance.sdk.component.adexpress.dynamic.tV.Bc.IlO(strArrSplit[i9].substring(0, 7));
                    i8 = i9;
                }
                GradientDrawable gradientDrawableIlO = IlO(IlO(strArrSplit[0]), iArr);
                gradientDrawableIlO.setShape(0);
                gradientDrawableIlO.setCornerRadius(com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.ea()));
                drawableArr[(list.size() - 1) - i2] = gradientDrawableIlO;
            }
        }
        return drawableArr;
    }

    public GradientDrawable IlO(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            if (iArr.length == 1) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(iArr[0]);
                return gradientDrawable;
            }
            return new GradientDrawable(orientation, iArr);
        }
        return new GradientDrawable();
    }

    public GradientDrawable.Orientation IlO(String str) {
        try {
            int i2 = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            if (i2 <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (i2 <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (i2 <= 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    private void IlO() {
        if (isShown()) {
            int iIlO = com.bytedance.sdk.component.adexpress.dynamic.MY.IlO.IlO(this.rp);
            if (iIlO == 2) {
                if (this.AXM == null) {
                    this.AXM = new com.bytedance.sdk.component.utils.tl(getContext().getApplicationContext(), 1);
                }
                new Object() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc.4
                };
                com.bytedance.sdk.component.adexpress.MY.hp renderRequest = this.bWL.getRenderRequest();
                if (renderRequest != null) {
                    renderRequest.ea();
                    renderRequest.AXM();
                    renderRequest.es();
                    return;
                }
                return;
            }
            if (iIlO == 3) {
                if (this.AXM == null) {
                    this.AXM = new com.bytedance.sdk.component.utils.tl(getContext().getApplicationContext(), 2);
                }
                new Object() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc.5
                };
                com.bytedance.sdk.component.adexpress.MY.hp renderRequest2 = this.bWL.getRenderRequest();
                if (renderRequest2 != null) {
                    renderRequest2.cl();
                    renderRequest2.oeT();
                    renderRequest2.cL();
                    renderRequest2.xF();
                }
            }
        }
    }
}
