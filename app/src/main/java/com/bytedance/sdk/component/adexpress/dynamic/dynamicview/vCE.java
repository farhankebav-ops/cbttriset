package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.webkit.internal.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends Cc {
    private static String xF = "";
    private volatile boolean AXM;
    private Runnable IlO;
    private Runnable MY;
    protected com.bytedance.sdk.component.adexpress.dynamic.EO.DmF es;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class EO implements com.bytedance.sdk.component.Cc.lEW {
        private final WeakReference<Context> IlO;
        private final int MY;

        public EO(Context context, int i2) {
            this.IlO = new WeakReference<>(context);
            this.MY = i2;
        }

        @Override // com.bytedance.sdk.component.Cc.lEW
        public Bitmap IlO(Bitmap bitmap) {
            Context context = this.IlO.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.tV.IlO.IlO(context, bitmap, this.MY);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements com.bytedance.sdk.component.Cc.zPa {
        private final com.bytedance.sdk.component.adexpress.dynamic.tV.lEW EO;
        private final WeakReference<View> IlO;
        private final WeakReference<DynamicRootView> MY;

        public IlO(View view, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
            this.IlO = new WeakReference<>(view);
            this.MY = new WeakReference<>(dynamicRootView);
            this.EO = lew;
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(int i2, String str, @Nullable Throwable th) {
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(com.bytedance.sdk.component.Cc.EV ev) {
            Drawable bitmapDrawable;
            View view = this.IlO.get();
            Object objMY = ev.MY();
            if (objMY instanceof Bitmap) {
                bitmapDrawable = new BitmapDrawable((Bitmap) objMY);
            } else if (objMY instanceof Drawable) {
                if (Build.VERSION.SDK_INT >= 28) {
                    Drawable drawable = (Drawable) objMY;
                    if (b.x(drawable)) {
                        b.g(drawable).start();
                    }
                }
                bitmapDrawable = (Drawable) objMY;
            } else {
                bitmapDrawable = null;
            }
            if (!com.bytedance.sdk.component.adexpress.tV.MY()) {
                DynamicRootView dynamicRootView = this.MY.get();
                if (dynamicRootView == null) {
                    return;
                }
                if ("open_ad".equals(dynamicRootView.getRenderRequest().tV()) || "splash_ad".equals(dynamicRootView.getRenderRequest().tV())) {
                    view.setBackground(bitmapDrawable);
                    return;
                } else {
                    view.setBackground(bitmapDrawable);
                    return;
                }
            }
            if (view == null) {
                return;
            }
            view.setBackground(bitmapDrawable);
            com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew = this.EO;
            if (lew == null || lew.NV() == null || 6 != this.EO.NV().IlO() || view.getBackground() == null) {
                return;
            }
            view.getBackground().setAutoMirrored(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY implements com.bytedance.sdk.component.Cc.zPa {
        private final WeakReference<View> IlO;
        private final WeakReference<Cc> MY;

        public MY(View view, Cc cc) {
            this.IlO = new WeakReference<>(view);
            this.MY = new WeakReference<>(cc);
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(int i2, String str, @Nullable Throwable th) {
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(com.bytedance.sdk.component.Cc.EV ev) {
            Object objMY;
            Cc cc;
            View view = this.IlO.get();
            if (view == null || (objMY = ev.MY()) == null || ev.EO() == null || (cc = this.MY.get()) == null || !(objMY instanceof Bitmap)) {
                return;
            }
            view.setBackground(cc.IlO((Bitmap) objMY));
        }
    }

    public vCE(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        this.AXM = true;
        setTag(Integer.valueOf(getClickArea()));
        String strMY = lew.NV().MY();
        if ("logo-union".equals(strMY)) {
            dynamicRootView.setLogoUnionHeight(this.lEW - ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, this.rp.IlO() + this.rp.MY())));
        } else if ("scoreCountWithIcon".equals(strMY)) {
            dynamicRootView.setScoreCountWithIcon(this.lEW - ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, this.rp.IlO() + this.rp.MY())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable EO(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String string = "";
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (jSONArray.getString(i2).startsWith("#")) {
                    arrayList.add(jSONArray.getString(i2));
                } else if (jSONArray.getString(i2).endsWith("deg")) {
                    string = jSONArray.getString(i2);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                iArr[i8] = com.bytedance.sdk.component.adexpress.dynamic.tV.Bc.IlO(((String) arrayList.get(i8)).substring(0, 7));
            }
            GradientDrawable gradientDrawableIlO = IlO(IlO(string), iArr);
            gradientDrawableIlO.setShape(0);
            gradientDrawableIlO.setCornerRadius(com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.ea()));
            return gradientDrawableIlO;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String MY(String str) {
        try {
            Map<String, String> mapEV = this.bWL.getRenderRequest().EV();
            if (mapEV != null && mapEV.size() > 0) {
                return mapEV.get(str);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String getBuildModel() {
        try {
            xF = com.bytedance.sdk.component.utils.OOq.IlO();
        } catch (Throwable unused) {
            xF = Build.MODEL;
        }
        if (TextUtils.isEmpty(xF)) {
            xF = Build.MODEL;
        }
        return xF;
    }

    public boolean DmF() {
        int iEa;
        int iZPa;
        Drawable backgroundDrawable;
        DynamicRootView dynamicRootView;
        JSONObject jSONObjectOptJSONObject;
        final View view = this.ea;
        if (view == null) {
            view = this;
        }
        setContentDescription(this.hp.IlO(this.rp.OOq()));
        String strPTq = this.rp.PTq();
        String strKBB = null;
        String strIlO = (TextUtils.isEmpty(strPTq) || (dynamicRootView = this.bWL) == null || dynamicRootView.getRenderRequest() == null || this.bWL.getRenderRequest().EO() == null || (jSONObjectOptJSONObject = this.bWL.getRenderRequest().EO().optJSONObject("creative")) == null) ? null : IlO(jSONObjectOptJSONObject.opt(strPTq));
        if (TextUtils.isEmpty(strIlO)) {
            strIlO = this.rp.AXM();
        }
        com.bytedance.sdk.component.adexpress.IlO.IlO.EO EO2 = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO();
        if (EO2 != null) {
            iEa = EO2.ea();
            iZPa = EO2.zPa();
        } else {
            iEa = 0;
            iZPa = 0;
        }
        if (this.rp.xF()) {
            int iEs = this.rp.es();
            String str = this.rp.MY;
            com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().Cc().IlO(str).IlO(this.Bc).MY(this.lEW).tV(iEa).Cc(iZPa).IlO(MY(str)).EO(2).IlO(new EO(this.EV, iEs)).IlO(new MY(view, this));
        } else if (!TextUtils.isEmpty(strIlO)) {
            if (!strIlO.startsWith("http:") && !strIlO.startsWith("https:")) {
                DynamicRootView dynamicRootView2 = this.bWL;
                if (dynamicRootView2 != null && dynamicRootView2.getRenderRequest() != null) {
                    strKBB = this.bWL.getRenderRequest().kBB();
                }
                strIlO = com.bytedance.sdk.component.adexpress.dynamic.Cc.DmF.MY(strIlO, strKBB);
            }
            com.bytedance.sdk.component.Cc.NV nvEO = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().Cc().IlO(strIlO).IlO(this.Bc).MY(this.lEW).tV(iEa).Cc(iZPa).IlO(MY(strIlO)).EO(1);
            IlO(nvEO);
            nvEO.IlO(new IlO(view, this.bWL, this.hp));
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.rp.oc() > 0.0d) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (vCE.this.rp.YA() > 0) {
                            vCE vce = vCE.this;
                            Drawable drawableEO = vce.EO(vce.bWL.getBgMaterialCenterCalcColor().get(Integer.valueOf(vCE.this.rp.YA())));
                            if (drawableEO == null) {
                                vCE vce2 = vCE.this;
                                drawableEO = vce2.IlO(true, vce2.bWL.getBgMaterialCenterCalcColor().get(Integer.valueOf(vCE.this.rp.YA())));
                            }
                            if (drawableEO != null) {
                                view.setBackground(drawableEO);
                                return;
                            }
                            View view2 = view;
                            vCE vce3 = vCE.this;
                            view2.setBackground(vce3.IlO(true, vce3.bWL.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.rp.oc() * 1000.0d));
        }
        View view2 = this.ea;
        if (view2 != null) {
            view2.setPadding((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.EO()), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.MY()), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.tV()), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.IlO()));
        }
        if (this.zPa || this.rp.bWL() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.Bc, this.lEW);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View view = this.ea;
        View view2 = view;
        if (view == null) {
            view2 = this;
        }
        double dXF = this.hp.NV().Cc().xF();
        if (dXF < 90.0d && dXF > 0.0d) {
            com.bytedance.sdk.component.utils.DmF.MY().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE.2
                @Override // java.lang.Runnable
                public void run() {
                    vCE.this.setVisibility(8);
                }
            }, (long) (dXF * 1000.0d));
        }
        IlO(this.hp.NV().Cc().es(), view2);
        if (!TextUtils.isEmpty(this.rp.gQ())) {
            IlO();
        }
        super.onAttachedToWindow();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.IlO);
            removeCallbacks(this.MY);
        } catch (Exception unused) {
        }
    }

    private String IlO(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return IlO(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return IlO((Object) ((JSONObject) obj).optString("url"));
        }
        return null;
    }

    private static void IlO(com.bytedance.sdk.component.Cc.NV nv) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            nv.IlO(Bitmap.Config.ARGB_8888);
        }
    }

    private void IlO(double d8, final View view) {
        if (d8 > 0.0d) {
            com.bytedance.sdk.component.utils.DmF.MY().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE.3
                @Override // java.lang.Runnable
                public void run() {
                    if (vCE.this.hp.NV().Cc().uF() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    vCE.this.setVisibility(0);
                }
            }, (long) (d8 * 1000.0d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            if (viewGroup.getChildAt(i2) instanceof com.bytedance.sdk.component.adexpress.dynamic.EO.DmF) {
                viewGroup.removeViewAt(i2);
            }
        }
    }

    private void IlO() {
        if (this.AXM) {
            int iKC = this.rp.KC();
            int iEa = this.rp.Ea();
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE.4
                @Override // java.lang.Runnable
                public void run() {
                    DynamicRootView dynamicRootView = vCE.this.bWL;
                    if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                        vCE vce = vCE.this;
                        vCE vce2 = vCE.this;
                        vce.es = new com.bytedance.sdk.component.adexpress.dynamic.EO.DmF(vce2.EV, vce2, vce2.rp);
                    } else {
                        com.bytedance.sdk.component.adexpress.MY.hp renderRequest = vCE.this.bWL.getRenderRequest();
                        com.bytedance.sdk.component.adexpress.dynamic.tV.NV nv = new com.bytedance.sdk.component.adexpress.dynamic.tV.NV();
                        nv.IlO(renderRequest.ea());
                        nv.MY(renderRequest.zPa());
                        nv.EO(renderRequest.cl());
                        nv.IlO(renderRequest.cL());
                        nv.MY(renderRequest.es());
                        nv.EO(renderRequest.xF());
                        nv.tV(renderRequest.AXM());
                        nv.Cc(renderRequest.oeT());
                        vCE vce3 = vCE.this;
                        vCE vce4 = vCE.this;
                        vce3.es = new com.bytedance.sdk.component.adexpress.dynamic.EO.DmF(vce4.EV, vce4, vce4.rp, nv, renderRequest);
                    }
                    vCE vce5 = vCE.this;
                    vce5.MY(vce5.es);
                    if (vCE.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) vCE.this.getParent()).setClipChildren(false);
                    }
                    vCE.this.setClipChildren(false);
                    vCE.this.es.setTag(2);
                    vCE vce6 = vCE.this;
                    vce6.IlO((ViewGroup) vce6);
                    vCE vce7 = vCE.this;
                    vce7.addView(vce7.es, new FrameLayout.LayoutParams(-1, -1));
                    vCE.this.es.EO();
                }
            };
            this.IlO = runnable;
            postDelayed(runnable, ((long) iKC) * 1000);
            if (this.rp.Dxv() || iEa >= Integer.MAX_VALUE || iKC >= iEa) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE.5
                @Override // java.lang.Runnable
                public void run() {
                    vCE vce = vCE.this;
                    if (vce.es != null) {
                        vce.AXM = false;
                        vCE.this.es.tV();
                        vCE.this.es.setVisibility(4);
                        vCE vce2 = vCE.this;
                        vce2.removeView(vce2.es);
                    }
                }
            };
            this.MY = runnable2;
            postDelayed(runnable2, ((long) iEa) * 1000);
        }
    }
}
