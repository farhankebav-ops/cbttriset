package com.bytedance.adsdk.MY.EO.EO;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.bytedance.adsdk.MY.AXM;
import com.bytedance.adsdk.MY.NV;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends tV {
    private final LinearLayout.LayoutParams DmF;
    private final List<TextView> EV;
    private final List<String> NV;
    private LinearLayout lEW;
    private String rp;

    public EO(com.bytedance.adsdk.MY.DmF dmF, Cc cc, Context context) {
        List<NV.IlO> listEO;
        super(dmF, cc);
        this.DmF = new LinearLayout.LayoutParams(-2, -2);
        this.NV = new ArrayList();
        this.EV = new ArrayList();
        com.bytedance.adsdk.MY.NV nv = ((tV) this).Bc;
        if (nv == null || (listEO = nv.EO()) == null || listEO.size() <= 0) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.lEW = linearLayout;
        int i2 = 0;
        linearLayout.setOrientation(0);
        MY(listEO.get(0).Bc);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(80);
        this.lEW.addView(linearLayout2);
        List<String> listRp = rp();
        while (i2 < listEO.size()) {
            NV.IlO ilO = listEO.get(i2);
            TextView textView = new TextView(context);
            IlO(textView, ilO, (listRp == null || i2 >= listRp.size()) ? "" : listRp.get(i2));
            int i8 = ilO.vCE;
            if (i8 != 0) {
                this.DmF.bottomMargin = (int) (com.bytedance.adsdk.MY.vCE.vCE.IlO() * i8);
                linearLayout2.addView(textView, this.DmF);
            } else {
                linearLayout2.addView(textView);
            }
            i2++;
        }
        float fIlO = com.bytedance.adsdk.MY.vCE.vCE.IlO();
        IlO(this.lEW, (int) (((tV) this).Bc.IlO() * fIlO), (int) (((tV) this).Bc.MY() * fIlO));
    }

    private void EO(float f4) {
        List<NV.IlO> listEO;
        com.bytedance.adsdk.MY.NV nv = ((tV) this).Bc;
        if (nv == null || (listEO = nv.EO()) == null || listEO.size() <= 0) {
            return;
        }
        this.lEW.setOrientation(0);
        this.lEW.setGravity(17);
        if (this.lEW.getChildCount() <= 0) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.lEW.getChildAt(0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        this.lEW.removeAllViews();
        if (linearLayout.getChildCount() != listEO.size()) {
            return;
        }
        List<String> listRp = rp();
        this.EV.clear();
        int i2 = 0;
        while (i2 < listEO.size()) {
            NV.IlO ilO = listEO.get(i2);
            TextView textView = (TextView) linearLayout.getChildAt(i2);
            this.EV.add(textView);
            IlO(textView, ilO, (listRp == null || i2 >= listRp.size()) ? "" : listRp.get(i2));
            i2++;
        }
        linearLayout.removeAllViews();
        for (int i8 = 0; i8 < listEO.size(); i8++) {
            NV.IlO ilO2 = listEO.get(i8);
            TextView textView2 = this.EV.get(i8);
            textView2.setAlpha(f4);
            linearLayout.setAlpha(f4);
            int i9 = ilO2.vCE;
            if (i9 != 0) {
                this.DmF.bottomMargin = (int) (com.bytedance.adsdk.MY.vCE.vCE.IlO() * i9);
                linearLayout.addView(textView2, this.DmF);
            } else {
                linearLayout.addView(textView2);
            }
        }
        this.lEW.setAlpha(f4);
        this.lEW.addView(linearLayout);
        float fIlO = com.bytedance.adsdk.MY.vCE.vCE.IlO();
        IlO(this.lEW, (int) (((tV) this).Bc.IlO() * fIlO), (int) (((tV) this).Bc.MY() * fIlO));
    }

    private void IlO(TextView textView, NV.IlO ilO, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setText("");
        } else {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(ilO.EO)) {
            textView.setTextColor(Color.parseColor(ilO.EO));
        }
        if (!TextUtils.isEmpty(ilO.tV)) {
            textView.setBackgroundColor(Color.parseColor(ilO.tV));
        }
        textView.setGravity(17);
        textView.setTextSize(ilO.Cc);
    }

    private void MY(String str) {
        if (TextUtils.isEmpty(str)) {
            this.lEW.setGravity(17);
            return;
        }
        str.getClass();
        if (str.equals("left")) {
            this.lEW.setGravity(3);
        } else if (str.equals("right")) {
            this.lEW.setGravity(5);
        } else {
            this.lEW.setGravity(17);
        }
    }

    private List<String> rp() {
        com.bytedance.adsdk.MY.DmF dmF;
        AXM axmKBB;
        List<NV.IlO> listEO;
        if (((tV) this).Bc == null || (dmF = this.MY) == null || (axmKBB = dmF.kBB()) == null) {
            return null;
        }
        String strTV = ((tV) this).Bc.tV();
        if ((!TextUtils.isEmpty(strTV) || !TextUtils.isEmpty(this.rp)) && (listEO = ((tV) this).Bc.EO()) != null) {
            String strIlO = this.rp;
            if (TextUtils.isEmpty(strIlO)) {
                strIlO = axmKBB.IlO(strTV);
            }
            if (!TextUtils.isEmpty(strIlO)) {
                int length = strIlO.length();
                this.NV.clear();
                for (int i2 = 0; i2 < listEO.size(); i2++) {
                    NV.IlO ilO = listEO.get(i2);
                    int iMax = ilO.IlO;
                    int iMax2 = ilO.MY;
                    if (iMax < 0) {
                        iMax = Math.max(iMax + length, 0);
                    }
                    if (iMax2 < 0) {
                        iMax2 = Math.max(iMax2 + length, 0);
                    }
                    if (iMax + iMax2 > length) {
                        this.NV.add("");
                    } else {
                        if (listEO.size() == 1 && iMax == 0 && iMax2 == 0) {
                            iMax2 = length;
                        }
                        this.NV.add(strIlO.substring(iMax, iMax2 + iMax));
                    }
                }
                return this.NV;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.tV, com.bytedance.adsdk.MY.EO.EO.IlO
    public void MY(Canvas canvas, Matrix matrix, int i2) {
        if (this.lEW != null) {
            canvas.save();
            canvas.concat(matrix);
            IlO(i2);
            EO(vCE());
            this.lEW.draw(canvas);
            canvas.restore();
            return;
        }
        super.MY(canvas, matrix, i2);
    }

    private static void IlO(View view, int i2, int i8) {
        view.layout(0, 0, i2, i8);
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(i8, BasicMeasure.EXACTLY));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void IlO(String str) {
        this.rp = str;
    }
}
