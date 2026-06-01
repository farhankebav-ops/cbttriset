package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.internal.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV extends vCE {
    private String IlO;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements com.bytedance.sdk.component.Cc.lEW {
        private final WeakReference<Context> IlO;

        public IlO(Context context) {
            this.IlO = new WeakReference<>(context);
        }

        @Override // com.bytedance.sdk.component.Cc.lEW
        public Bitmap IlO(Bitmap bitmap) {
            Context context = this.IlO.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.tV.IlO.IlO(context, bitmap, 25);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY implements com.bytedance.sdk.component.Cc.zPa {
        private WeakReference<View> IlO;
        private Resources MY;

        public MY(View view, Resources resources) {
            this.IlO = new WeakReference<>(view);
            this.MY = resources;
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(int i2, String str, @Nullable Throwable th) {
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(com.bytedance.sdk.component.Cc.EV ev) {
            Object objMY;
            View view = this.IlO.get();
            if (view == null || (objMY = ev.MY()) == null || ev.EO() == null) {
                return;
            }
            if (objMY instanceof Bitmap) {
                view.setBackground(new BitmapDrawable(this.MY, (Bitmap) objMY));
            } else if (objMY instanceof Drawable) {
                if (Build.VERSION.SDK_INT >= 28 && b.y(objMY)) {
                    b.h(objMY).start();
                }
                view.setBackground((Drawable) objMY);
            }
        }
    }

    public EV(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        if (!TextUtils.isEmpty(this.rp.ts()) && lew.es()) {
            com.bytedance.sdk.component.adexpress.vCE.NV nv = new com.bytedance.sdk.component.adexpress.vCE.NV(context);
            nv.setAnimationsLoop(this.rp.BO());
            nv.setImageLottieTosPath(this.rp.ts());
            nv.setLottieAppNameMaxLength(this.rp.aa());
            nv.setLottieAdTitleMaxLength(this.rp.gm());
            nv.setLottieAdDescMaxLength(this.rp.dm());
            nv.setData(lew.xF());
            this.ea = nv;
        } else if (this.rp.ea() > 0.0f) {
            com.bytedance.sdk.component.adexpress.vCE.tl tlVar = new com.bytedance.sdk.component.adexpress.vCE.tl(context);
            this.ea = tlVar;
            tlVar.setXRound((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, this.rp.ea()));
            ((com.bytedance.sdk.component.adexpress.vCE.tl) this.ea).setYRound((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, this.rp.ea()));
        } else if (!lEW() && "arrowButton".equals(lew.NV().MY())) {
            com.bytedance.sdk.component.adexpress.dynamic.animation.view.MY my = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.MY(context);
            my.setBrickNativeValue(this.rp);
            this.ea = my;
        } else if (com.bytedance.sdk.component.adexpress.tV.DmF.MY(this.rp.EV())) {
            this.ea = new com.bytedance.sdk.component.adexpress.vCE.hp(context);
        } else {
            this.ea = new ImageView(context);
        }
        this.IlO = getImageKey();
        this.ea.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(lew.NV().MY())) {
            if (this.rp.MY() > 0 || this.rp.IlO() > 0) {
                int iMin = Math.min(this.Bc, this.lEW);
                this.Bc = iMin;
                this.lEW = Math.min(iMin, this.lEW);
                this.DmF = (int) (com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, (this.rp.IlO() / 2) + this.rp.MY() + 0.5f) + this.DmF);
            } else {
                int iMax = Math.max(this.Bc, this.lEW);
                this.Bc = iMax;
                this.lEW = Math.max(iMax, this.lEW);
            }
            this.rp.IlO(this.Bc / 2);
        }
        addView(this.ea, new FrameLayout.LayoutParams(this.Bc, this.lEW));
    }

    private boolean IlO() {
        String strRp = this.rp.rp();
        if (this.rp.xF()) {
            return true;
        }
        if (TextUtils.isEmpty(strRp)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strRp);
            return Math.abs((((float) this.Bc) / (((float) this.lEW) * 1.0f)) - (((float) jSONObject.optInt("width")) / (((float) jSONObject.optInt("height")) * 1.0f))) > 0.01f;
        } catch (JSONException unused) {
            return false;
        }
    }

    private String getImageKey() {
        Map<String, String> mapEV = this.bWL.getRenderRequest().EV();
        if (mapEV == null || mapEV.size() <= 0) {
            return null;
        }
        return mapEV.get(this.rp.EV());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        int iZPa;
        super.DmF();
        if (!TextUtils.isEmpty(this.rp.ts())) {
            ((ImageView) this.ea).setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        }
        int iEa = 0;
        if ("arrowButton".equals(this.hp.NV().MY())) {
            ((ImageView) this.ea).setImageResource(com.bytedance.sdk.component.utils.pP.tV(this.EV, "tt_white_righterbackicon_titlebar"));
            if (((ImageView) this.ea).getDrawable() != null) {
                ((ImageView) this.ea).getDrawable().setAutoMirrored(true);
            }
            this.ea.setPadding(0, 0, 0, 0);
            ((ImageView) this.ea).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.ea.setBackgroundColor(this.rp.wPn());
        String strEO = this.hp.NV().EO();
        if ("user".equals(strEO)) {
            ((ImageView) this.ea).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.ea).setColorFilter(this.rp.Bc());
            ((ImageView) this.ea).setImageDrawable(com.bytedance.sdk.component.utils.pP.EO(getContext(), "tt_user"));
            ImageView imageView = (ImageView) this.ea;
            int i2 = this.Bc;
            imageView.setPadding(i2 / 10, this.lEW / 5, i2 / 10, 0);
        } else if (strEO != null && strEO.startsWith("@")) {
            try {
                ((ImageView) this.ea).setImageResource(Integer.parseInt(strEO.substring(1)));
            } catch (Exception unused) {
            }
        }
        com.bytedance.sdk.component.Cc.ea eaVarCc = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().Cc();
        String strEV = this.rp.EV();
        if (!TextUtils.isEmpty(strEV) && !strEV.startsWith("http:") && !strEV.startsWith("https:")) {
            DynamicRootView dynamicRootView = this.bWL;
            strEV = com.bytedance.sdk.component.adexpress.dynamic.Cc.DmF.MY(strEV, (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) ? null : this.bWL.getRenderRequest().kBB());
        }
        com.bytedance.sdk.component.adexpress.IlO.IlO.EO EO = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO();
        if (EO != null) {
            iEa = EO.ea();
            iZPa = EO.zPa();
        } else {
            iZPa = 0;
        }
        com.bytedance.sdk.component.Cc.NV nvCc = eaVarCc.IlO(strEV).IlO(this.IlO).IlO(this.Bc).MY(this.lEW).tV(iEa).Cc(iZPa);
        String strBWL = this.bWL.getRenderRequest().bWL();
        if (!TextUtils.isEmpty(strBWL)) {
            nvCc.MY(strBWL);
        }
        if (IlO()) {
            ((ImageView) this.ea).setScaleType(ImageView.ScaleType.FIT_CENTER);
            nvCc.IlO(Bitmap.Config.ARGB_4444).EO(2).IlO(new IlO(this.EV)).IlO(new MY(this.ea, getResources()));
        } else {
            if (com.bytedance.sdk.component.adexpress.tV.MY()) {
                nvCc.EO(1).IlO((ImageView) this.ea);
            }
            ((ImageView) this.ea).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ((this.ea instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.ea).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = ((ImageView) this.ea).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !b.x(drawable)) {
            return;
        }
        b.g(drawable).start();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = ((ImageView) this.ea).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !b.x(drawable)) {
            return;
        }
        b.g(drawable).stop();
    }
}
