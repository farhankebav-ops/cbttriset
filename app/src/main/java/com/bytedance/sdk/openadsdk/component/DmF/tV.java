package com.bytedance.sdk.openadsdk.component.DmF;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.ea;
import com.bytedance.sdk.openadsdk.core.widget.zPa;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.EV;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends EO {
    private final ea bWL;
    private final com.bytedance.sdk.openadsdk.core.Cc.Cc cl;
    private final com.bytedance.sdk.openadsdk.core.Cc.lEW ea;
    private final com.bytedance.sdk.openadsdk.core.Cc.EO hp;
    private final com.bytedance.sdk.openadsdk.core.Cc.tV zPa;

    public tV(Context context, oeT oet) {
        super(context);
        setId(520093753);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(0);
        int iMY = BS.MY(context, 8.0f);
        int iMY2 = BS.MY(context, 9.0f);
        int iMY3 = BS.MY(context, 10.0f);
        int iMY4 = BS.MY(context, 40.0f);
        com.bytedance.sdk.openadsdk.core.widget.EO eo = new com.bytedance.sdk.openadsdk.core.widget.EO(context);
        this.rp = eo;
        eo.setPadding(iMY2, 0, iMY2, 0);
        this.rp.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BS.MY(context, 32.0f), BS.MY(context, 14.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, iMY3, iMY3);
        this.rp.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.Cc.EO eo2 = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        this.hp = eo2;
        eo2.setBackgroundColor(-1);
        eo2.setId(520093758);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, BS.MY(context, 107.0f));
        layoutParams2.addRule(12);
        eo2.setLayoutParams(layoutParams2);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setOrientation(0);
        cc.setGravity(16);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        cc.setLayoutParams(layoutParams3);
        eo2.addView(cc);
        zPa zpa = new zPa(context);
        this.vCE = zpa;
        zpa.setId(520093759);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(iMY4, iMY4);
        layoutParams4.rightMargin = iMY;
        layoutParams4.setMarginEnd(iMY);
        this.vCE.setLayoutParams(layoutParams4);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.Bc = lew;
        lew.setId(520093761);
        this.Bc.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew2 = this.Bc;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        lew2.setEllipsize(truncateAt);
        this.Bc.setMaxLines(2);
        this.Bc.setTextColor(Color.parseColor("#161823"));
        this.Bc.setTextSize(30.0f);
        cc.addView(this.vCE);
        cc.addView(this.Bc);
        com.bytedance.sdk.openadsdk.core.Cc.EO eo3 = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(2, eo2.getId());
        layoutParams5.addRule(10);
        eo3.setLayoutParams(layoutParams5);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        this.IlO = tVVar;
        tVVar.setId(520093754);
        this.IlO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        eo3.addView(this.IlO, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.Cc.EO eo4 = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        this.MY = eo4;
        eo4.setId(520093755);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams6.gravity = 17;
        eo3.addView(this.MY, layoutParams6);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar2 = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        this.EO = tVVar2;
        tVVar2.setId(520093756);
        eo3.addView(this.EO, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew3 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.Cc = lew3;
        lew3.setId(520093717);
        this.Cc.setBackground(EV.IlO(context, Color.parseColor("#b3000000"), 24));
        this.Cc.setEllipsize(truncateAt);
        this.Cc.setGravity(17);
        this.Cc.setSingleLine(true);
        this.Cc.setText(pP.IlO(context, "tt_video_download_apk"));
        this.Cc.setTextColor(-1);
        this.Cc.setTextSize(1, 16.0f);
        this.Cc.setTag("open_ad_click_button_tag");
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(BS.MY(context, 236.0f), BS.MY(context, 48.0f));
        layoutParams7.gravity = 81;
        layoutParams7.bottomMargin = BS.MY(context, 32.0f);
        eo3.addView(this.Cc, layoutParams7);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc2 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        this.cl = cc2;
        cc2.setOrientation(0);
        cc2.setGravity(16);
        cc2.setBackground(new IlO(context));
        cc2.setPadding(BS.MY(context, 16.0f), BS.MY(context, 8.0f), BS.MY(context, 16.0f), BS.MY(context, 8.0f));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(10);
        layoutParams8.topMargin = BS.MY(context, 90.0f);
        cc2.setLayoutParams(layoutParams8);
        zPa zpa2 = new zPa(context);
        this.zPa = zpa2;
        cc2.addView(zpa2, new LinearLayout.LayoutParams(BS.MY(context, 36.0f), BS.MY(context, 36.0f)));
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc3 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.leftMargin = BS.MY(context, 8.0f);
        cc2.addView(cc3, layoutParams9);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew4 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.ea = lew4;
        lew4.setTextColor(-1);
        cc3.addView(lew4, new LinearLayout.LayoutParams(-2, -2));
        ea eaVar = new ea(context, true);
        this.bWL = eaVar;
        cc3.addView(eaVar, new LinearLayout.LayoutParams(-2, -2));
        PAGLogoView pAGLogoViewCreatePAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(context, oet);
        this.tV = pAGLogoViewCreatePAGLogoViewByMaterial;
        pAGLogoViewCreatePAGLogoViewByMaterial.setId(520093757);
        FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(-2, BS.MY(context, 14.0f));
        layoutParams10.gravity = 83;
        eo3.addView(this.tV, layoutParams10);
        addView(eo3);
        addView(this.rp);
        addView(eo2);
        addView(this.lEW);
        addView(cc2);
    }

    @Override // com.bytedance.sdk.openadsdk.component.DmF.EO
    public com.bytedance.sdk.openadsdk.core.Cc.tV getAdIconView() {
        return this.zPa;
    }

    @Override // com.bytedance.sdk.openadsdk.component.DmF.EO
    public com.bytedance.sdk.openadsdk.core.Cc.lEW getAdTitleTextView() {
        return this.ea;
    }

    @Override // com.bytedance.sdk.openadsdk.component.DmF.EO
    public com.bytedance.sdk.openadsdk.core.Cc.Cc getOverlayLayout() {
        return this.cl;
    }

    @Override // com.bytedance.sdk.openadsdk.component.DmF.EO
    public ea getScoreBar() {
        return this.bWL;
    }

    @Override // com.bytedance.sdk.openadsdk.component.DmF.EO
    public View getUserInfo() {
        return this.hp;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class IlO extends Drawable {
        private static final int Cc = Color.parseColor("#b0000000");
        private static final int vCE = Color.parseColor("#40000000");
        private final boolean tV;
        private final RectF IlO = new RectF();
        private final Paint MY = new Paint();
        private final Path EO = new Path();

        public IlO(Context context) {
            this.tV = com.bytedance.sdk.component.adexpress.tV.MY.IlO(context);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            canvas.drawPath(this.EO, this.MY);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(@NonNull Rect rect) {
            float[] fArr;
            super.onBoundsChange(rect);
            this.IlO.set(rect);
            this.EO.reset();
            int iHeight = rect.height() / 2;
            Path path = this.EO;
            RectF rectF = this.IlO;
            if (this.tV) {
                float f4 = iHeight;
                fArr = new float[]{f4, f4, 0.0f, 0.0f, 0.0f, 0.0f, f4, f4};
            } else {
                float f8 = iHeight;
                fArr = new float[]{0.0f, 0.0f, f8, f8, f8, f8, 0.0f, 0.0f};
            }
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            float f9 = rect.right;
            boolean z2 = this.tV;
            this.MY.setShader(new LinearGradient(0.0f, 0.0f, f9, 0.0f, new int[]{z2 ? vCE : Cc, z2 ? Cc : vCE}, (float[]) null, Shader.TileMode.CLAMP));
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
        }
    }
}
