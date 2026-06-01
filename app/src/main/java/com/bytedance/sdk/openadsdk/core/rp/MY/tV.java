package com.bytedance.sdk.openadsdk.core.rp.MY;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.cL.Bc;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.cl;
import com.bytedance.sdk.openadsdk.core.widget.es;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.EV;
import com.bytedance.sdk.openadsdk.utils.zPa;
import e0.a;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import w.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends Cc {
    private View AK;
    private final Rect BO;
    private TextView BS;
    private ImageView DM;
    private TextView Dxv;
    private final cl ED;
    private SeekBar Ea;
    private ImageView HSR;
    private int HTA;
    private int Hg;
    private final vSq Jz;
    private View KC;
    private float KT;
    private float OW;
    private final View.OnTouchListener PTq;
    private int Tx;
    private float VH;
    private final int aa;
    private float cJK;
    private int dm;
    private TextView fdM;
    private TextView gQ;
    private final int gm;
    private ImageView hL;
    private int ii;
    private TextView mmj;
    private boolean nm;
    private int pFe;
    private ImageView quf;
    private ColorStateList qvT;
    private final Rect qz;
    private TextView ssS;
    private final Rect tN;
    private ColorStateList tU;
    private final Rect tf;
    private float ts;
    private final Rect uI;
    private TextView uvo;
    private boolean wD;
    private View zLG;
    private ColorStateList zTS;

    public tV(Context context, ViewGroup viewGroup, boolean z2, int i2, oeT oet, e eVar, boolean z7) {
        super(context, viewGroup, z2, i2, oet, eVar, z7);
        this.Jz = new vSq(this);
        this.wD = false;
        this.nm = false;
        this.ii = 0;
        this.HTA = 0;
        this.Tx = 0;
        this.pFe = 0;
        this.Hg = 0;
        this.qz = new Rect();
        this.BO = new Rect();
        this.dm = 0;
        this.PTq = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.tV.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 2) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                } else if (actionMasked == 3) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        };
        this.uI = new Rect();
        this.tf = new Rect();
        this.tN = new Rect();
        this.tl = com.bytedance.sdk.openadsdk.core.cl.IlO().getApplicationContext();
        tV(z7);
        this.EO = viewGroup;
        this.AXM = z2;
        cl clVar = new cl(this);
        this.ED = clVar;
        clVar.IlO(this.AXM);
        DisplayMetrics displayMetrics = this.tl.getResources().getDisplayMetrics();
        this.gm = displayMetrics.widthPixels;
        this.aa = displayMetrics.heightPixels;
        this.kBB = i2;
        this.dY = eVar;
        this.pP = oet;
        tV(8);
        IlO(context, this.EO);
        tV();
        rp();
    }

    private void pP() {
        DisplayMetrics displayMetrics = this.tl.getResources().getDisplayMetrics();
        TextView textView = this.fdM;
        if (textView != null) {
            this.VH = textView.getTextSize();
            this.fdM.setTextSize(2, 14.0f);
            ColorStateList textColors = this.fdM.getTextColors();
            this.zTS = textColors;
            if (textColors != null) {
                this.fdM.setTextColor(-1);
            }
            this.KT = this.fdM.getAlpha();
            this.fdM.setAlpha(0.85f);
            this.fdM.setShadowLayer(0.0f, BS.MY(this.tl, 0.5f), BS.MY(this.tl, 0.5f), pP.Bc(this.tl, "tt_b2000000"));
            ViewGroup.LayoutParams layoutParams = this.fdM.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.uI.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                BS.IlO(this.fdM, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.uI.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.uI.bottom);
            }
        }
        TextView textView2 = this.Dxv;
        if (textView2 != null) {
            this.cJK = textView2.getTextSize();
            this.Dxv.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.Dxv.getTextColors();
            this.tU = textColors2;
            if (textColors2 != null) {
                this.Dxv.setTextColor(-1);
            }
            this.OW = this.Dxv.getAlpha();
            this.Dxv.setAlpha(0.85f);
            this.Dxv.setShadowLayer(0.0f, BS.MY(this.tl, 0.5f), BS.MY(this.tl, 0.5f), pP.Bc(this.tl, "tt_b2000000"));
            ViewGroup.LayoutParams layoutParams2 = this.Dxv.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.tf.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                TextView textView3 = this.Dxv;
                int iApplyDimension = (int) TypedValue.applyDimension(1, 14.0f, displayMetrics);
                Rect rect = this.tf;
                BS.IlO(textView3, iApplyDimension, rect.top, rect.right, rect.bottom);
            }
        }
        ImageView imageView = this.hL;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.tN.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                ImageView imageView2 = this.hL;
                Rect rect2 = this.tN;
                BS.IlO(imageView2, rect2.left, rect2.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.tN.bottom);
            }
        }
        ImageView imageView3 = this.hL;
        if (imageView3 != null) {
            imageView3.setImageDrawable(pP.EO(this.tl, "tt_shrink_fullscreen"));
        }
        TextView textView4 = this.ssS;
        if (textView4 != null) {
            ColorStateList textColors3 = textView4.getTextColors();
            this.qvT = textColors3;
            if (textColors3 != null) {
                this.ssS.setTextColor(-1);
            }
            this.ts = this.ssS.getAlpha();
            this.ssS.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.ssS.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.BO.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                TextView textView5 = this.ssS;
                int iApplyDimension2 = (int) TypedValue.applyDimension(1, 1.0f, displayMetrics);
                Rect rect3 = this.tf;
                BS.IlO(textView5, iApplyDimension2, rect3.top, rect3.right, rect3.bottom);
            }
        }
        View view = this.zLG;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.dm = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.zLG.setLayoutParams(layoutParams5);
            this.zLG.setBackgroundResource(pP.tV(this.tl, "tt_shadow_fullscreen_top"));
        }
        MY(false, true);
    }

    private void tl() {
        TextView textView = this.fdM;
        if (textView != null) {
            textView.setTextSize(0, this.VH);
            ColorStateList colorStateList = this.zTS;
            if (colorStateList != null) {
                this.fdM.setTextColor(colorStateList);
            }
            this.fdM.setAlpha(this.KT);
            this.fdM.setShadowLayer(BS.MY(this.tl, 1.0f), 0.0f, 0.0f, pP.Bc(this.tl, "tt_72000000"));
            TextView textView2 = this.fdM;
            Rect rect = this.uI;
            BS.IlO(textView2, rect.left, rect.top, rect.right, rect.bottom);
        }
        TextView textView3 = this.Dxv;
        if (textView3 != null) {
            textView3.setTextSize(0, this.cJK);
            ColorStateList colorStateList2 = this.tU;
            if (colorStateList2 != null) {
                this.Dxv.setTextColor(colorStateList2);
            }
            this.Dxv.setAlpha(this.OW);
            this.Dxv.setShadowLayer(BS.MY(this.tl, 1.0f), 0.0f, 0.0f, pP.Bc(this.tl, "tt_72000000"));
            TextView textView4 = this.Dxv;
            Rect rect2 = this.tf;
            BS.IlO(textView4, rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
        ImageView imageView = this.hL;
        if (imageView != null) {
            Rect rect3 = this.tN;
            BS.IlO(imageView, rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
        ImageView imageView2 = this.hL;
        if (imageView2 != null) {
            imageView2.setImageDrawable(pP.EO(this.tl, "tt_enlarge_video"));
        }
        TextView textView5 = this.ssS;
        if (textView5 != null) {
            ColorStateList colorStateList3 = this.qvT;
            if (colorStateList3 != null) {
                textView5.setTextColor(colorStateList3);
            }
            this.ssS.setAlpha(this.ts);
            TextView textView6 = this.ssS;
            Rect rect4 = this.tf;
            BS.IlO(textView6, rect4.left, rect4.top, rect4.right, rect4.bottom);
        }
        View view = this.zLG;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.dm;
            this.zLG.setLayoutParams(layoutParams);
            this.zLG.setBackground(EV.IlO(this.tl, "tt_video_black_desc_gradient"));
        }
        MY(false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void Bc() {
        oeT oet;
        BS.vCE(this.vCE);
        BS.vCE(this.Bc);
        BS.Cc(this.AK);
        if (this.lEW != null && (oet = this.pP) != null && oet.fdM() != null && this.pP.fdM().f4689f != null) {
            BS.vCE(this.lEW);
            Bc.IlO().IlO(this.pP.fdM().f4689f, this.pP.fdM().f4686b, this.pP.fdM().f4685a, this.lEW, this.pP);
        }
        if (this.Cc.getVisibility() == 0) {
            BS.IlO((View) this.Cc, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void Cc() {
        this.Jz.removeMessages(1);
        this.Jz.sendMessageDelayed(this.Jz.obtainMessage(1), 2000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void DmF() {
        this.Ea.setProgress(0);
        this.Ea.setSecondaryProgress(0);
        this.Dxv.setText(pP.IlO(this.tl, "tt_00_00"));
        this.fdM.setText(pP.IlO(this.tl, "tt_00_00"));
        tV(8);
        if (kBB()) {
            this.tV.setVisibility(8);
        }
        ImageView imageView = this.lEW;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        tV(8);
        BS.IlO(this.KC, 8);
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

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void EO(boolean z2) {
        TextView textView = this.BS;
        if (textView != null) {
            BS.IlO((View) textView, (!this.AXM && z2) ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc, com.bytedance.sdk.openadsdk.core.widget.es.MY
    public void EV() {
        IlO(true, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc, w.g
    public /* bridge */ /* synthetic */ void IlO(Object obj, WeakReference weakReference, boolean z2) {
        IlO((oeT) obj, (WeakReference<Context>) weakReference, z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void MY(boolean z2) {
        int i2 = NV() ? this.aa : this.cl;
        int iMY = NV() ? this.gm : this.cL;
        if (this.xF <= 0 || this.es <= 0 || i2 <= 0) {
            return;
        }
        if (!AXM() && !NV() && (this.kBB & 8) != 8) {
            iMY = BS.MY(this.tl, 228.0f);
        }
        float f4 = this.es;
        float f8 = this.xF;
        int i8 = (int) (((i2 * 1.0f) / f4) * f8);
        if (i8 > iMY) {
            i2 = (int) (((iMY * 1.0f) / f8) * f4);
        } else {
            iMY = i8;
        }
        if (!z2 && !NV()) {
            i2 = this.cl;
            iMY = this.cL;
        }
        this.tV.IlO(i2, iMY);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc, com.bytedance.sdk.openadsdk.core.widget.es.MY
    public boolean NV() {
        return this.wD;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void lEW() {
        BS.Cc(this.vCE);
        BS.Cc(this.AK);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void tV() {
        super.tV();
        this.ED.IlO(this.EO);
        BS.IlO((View) this.DM, (this.AXM || (this.kBB & 1) == 1) ? 8 : 0);
        this.DM.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.tV.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tV.this.zPa()) {
                    tV tVVar = tV.this;
                    tVVar.wPn.EO(tVVar, view);
                }
            }
        });
        BS.IlO((View) this.mmj, (!this.AXM || (this.kBB & 2) == 2) ? 0 : 8);
        this.mmj.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.tV.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tV.this.zPa()) {
                    tV tVVar = tV.this;
                    tVVar.wPn.tV(tVVar, view);
                }
            }
        });
        this.HSR.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.tV.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tV.this.zPa()) {
                    tV tVVar = tV.this;
                    tVVar.wPn.Cc(tVVar, view);
                }
            }
        });
        this.quf.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.tV.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tV.this.MY(false, true);
                tV.this.lEW();
                tV.this.Bc();
                tV.this.zPa();
            }
        });
        this.hL.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.tV.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (tV.this.zPa()) {
                    tV tVVar = tV.this;
                    tVVar.wPn.MY(tVVar, view);
                }
            }
        });
        this.Ea.setThumbOffset(0);
        this.Ea.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.rp.MY.tV.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
                if (tV.this.zPa()) {
                    tV tVVar = tV.this;
                    tVVar.wPn.IlO(tVVar, i2, z2);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!tV.this.wD && tV.this.tl != null) {
                    seekBar.setThumb(EV.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), "tt_seek_thumb_press"));
                }
                if (tV.this.zPa()) {
                    seekBar.setThumbOffset(0);
                    tV tVVar = tV.this;
                    tVVar.wPn.MY(tVVar, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!tV.this.wD && tV.this.tl != null) {
                    seekBar.setThumb(EV.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), "tt_seek_thumb_normal"));
                }
                if (tV.this.zPa()) {
                    seekBar.setThumbOffset(0);
                    tV tVVar = tV.this;
                    tVVar.wPn.IlO(tVVar, seekBar.getProgress());
                }
            }
        });
        this.Ea.setOnTouchListener(this.PTq);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void vCE() {
        this.Jz.removeMessages(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void IlO(Context context, View view) {
        super.IlO(context, view);
        this.mmj = (TextView) view.findViewById(zPa.LT);
        this.DM = (ImageView) view.findViewById(zPa.CQo);
        this.zLG = view.findViewById(zPa.Fv);
        this.HSR = (ImageView) view.findViewById(zPa.ct);
        this.BS = (TextView) view.findViewById(zPa.qyG);
        this.ssS = (TextView) view.findViewById(zPa.NI);
        this.gQ = (TextView) view.findViewById(zPa.TU);
        this.AK = view.findViewById(zPa.QfH);
        this.quf = (ImageView) view.findViewById(zPa.Os);
        TextView textView = (TextView) view.findViewById(zPa.KS);
        this.uvo = textView;
        textView.setText(pP.IlO(context, "tt_video_retry_des_txt"));
        this.Ea = (SeekBar) view.findViewById(zPa.IK);
        this.Dxv = (TextView) view.findViewById(zPa.Ct);
        this.fdM = (TextView) view.findViewById(zPa.XfO);
        this.KC = view.findViewById(zPa.BK);
        this.hL = (ImageView) view.findViewById(zPa.hHv);
        this.DmF = view.findViewById(zPa.NST);
    }

    private void Cc(boolean z2) {
        if (z2) {
            pP();
        } else {
            tl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void MY(@Nullable ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = this.EO) == null || !(viewGroup2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.wD = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.EO.getLayoutParams();
        marginLayoutParams.width = this.Tx;
        marginLayoutParams.height = this.pFe;
        marginLayoutParams.leftMargin = this.HTA;
        marginLayoutParams.topMargin = this.ii;
        this.EO.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.Hg);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            Rect rect = this.qz;
            BS.IlO(viewGroup, rect.left, rect.top, rect.right, rect.bottom);
        }
        MY(true);
        this.hL.setImageDrawable(pP.EO(this.tl, "tt_enlarge_video"));
        this.Ea.setThumb(EV.IlO(this.tl, "tt_seek_thumb_normal"));
        this.Ea.setThumbOffset(0);
        a.c(this.EO, true);
        Cc(this.wD);
        BS.IlO(this.zLG, 8);
        if ((this.kBB & 2) == 2) {
            BS.IlO((View) this.mmj, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void IlO(String str) {
        TextView textView = this.BS;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.ssS;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void IlO(int i2) {
        View view = this.KC;
        if (view == null || view.getVisibility() != 0) {
            this.Ea.setProgress(i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void IlO(long j, long j3) {
        this.Dxv.setText(a.b(j3));
        this.fdM.setText(a.b(j));
        this.Ea.setProgress(a.a(j, j3));
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc, w.g
    public void IlO() {
        IlO(false, this.AXM);
        es();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void IlO(long j) {
        this.fdM.setText(a.b(j));
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void IlO(oeT oet, WeakReference<Context> weakReference, boolean z2) {
        String strGm;
        String strIlO;
        oeT oet2;
        if (oet == null) {
            return;
        }
        IlO(this.EO, com.bytedance.sdk.openadsdk.core.cl.IlO());
        IlO(false, this.AXM);
        BS.IlO(this.NV, 0);
        BS.IlO((View) this.EV, 0);
        BS.IlO(this.rp, 0);
        if (this.EV != null && (oet2 = this.pP) != null && oet2.fdM() != null && this.pP.fdM().f4689f != null) {
            Bc.IlO().IlO(this.pP.fdM().f4689f, this.pP.fdM().f4686b, this.pP.fdM().f4685a, this.EV, this.pP);
        }
        if (!TextUtils.isEmpty(oet.hL())) {
            strGm = oet.hL();
        } else if (!TextUtils.isEmpty(oet.dm())) {
            strGm = oet.dm();
        } else if (!TextUtils.isEmpty(oet.gm())) {
            strGm = oet.gm();
        } else {
            strGm = "";
        }
        oeT oet3 = this.pP;
        if (oet3 != null && oet3.HTA() != null && this.pP.HTA().IlO() != null) {
            BS.IlO((View) this.hp, 0);
            BS.IlO((View) this.bWL, 4);
            if (this.hp != null) {
                Bc.IlO().IlO(this.pP.HTA(), this.hp, oet);
                this.hp.setOnClickListener(this.lMM);
                this.hp.setOnTouchListener(this.lMM);
            }
        } else if (!TextUtils.isEmpty(strGm)) {
            BS.IlO((View) this.hp, 4);
            BS.IlO((View) this.bWL, 0);
            TextView textView = this.bWL;
            if (textView != null) {
                textView.setText(strGm.substring(0, 1));
                this.bWL.setOnClickListener(this.lMM);
                this.bWL.setOnTouchListener(this.lMM);
            }
        }
        if (this.ea != null && !TextUtils.isEmpty(strGm)) {
            this.ea.setText(strGm);
        }
        BS.IlO((View) this.ea, 0);
        BS.IlO((View) this.zPa, 0);
        int iJz = oet.Jz();
        if (iJz == 4) {
            strIlO = pP.IlO(this.tl, "tt_video_download_apk");
        } else if (iJz != 5) {
            strIlO = pP.IlO(this.tl, "tt_video_mobile_go_detail");
        } else {
            strIlO = pP.IlO(this.tl, "tt_video_dial_phone");
        }
        TextView textView2 = this.zPa;
        if (textView2 != null) {
            textView2.setText(strIlO);
            this.zPa.setOnClickListener(this.lMM);
            this.zPa.setOnTouchListener(this.lMM);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public boolean MY(int i2) {
        SeekBar seekBar = this.Ea;
        return seekBar != null && i2 > seekBar.getSecondaryProgress();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void IlO(@Nullable ViewGroup viewGroup) {
        if (viewGroup != null && (this.EO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.wD = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.EO.getLayoutParams();
            this.HTA = marginLayoutParams.leftMargin;
            this.ii = marginLayoutParams.topMargin;
            this.Tx = marginLayoutParams.width;
            this.pFe = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.EO.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.Hg = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.qz.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                BS.IlO(viewGroup, 0, 0, 0, 0);
            }
            MY(true);
            this.hL.setImageDrawable(pP.EO(this.tl, "tt_shrink_video"));
            this.Ea.setThumb(EV.IlO(this.tl, "tt_seek_thumb_fullscreen_selector"));
            this.Ea.setThumbOffset(0);
            a.c(this.EO, false);
            Cc(this.wD);
            BS.IlO(this.zLG, 8);
            if (!this.AXM) {
                BS.IlO((View) this.DM, 8);
                BS.IlO((View) this.mmj, 8);
            } else if ((this.kBB & 1) == 1) {
                BS.IlO((View) this.DM, 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc, com.bytedance.sdk.component.utils.vSq.IlO
    public void IlO(Message message) {
        if (message.what != 1) {
            return;
        }
        EV();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void IlO(boolean z2, boolean z7, boolean z8) {
        BS.IlO(this.KC, 0);
        if (this.wD) {
            BS.IlO(this.zLG, 0);
            BS.IlO((View) this.ssS, 0);
        } else if (z8) {
            BS.IlO(this.zLG, 8);
        }
        BS.IlO((View) this.Cc, (!z2 || this.vCE.getVisibility() == 0) ? 8 : 0);
        if (!this.AXM && !this.wD) {
            if ((this.kBB & 1) != 1 && !z8) {
                BS.IlO((View) this.DM, 0);
            }
            BS.IlO((View) this.mmj, z8 ? 8 : 0);
        }
        BS.IlO((View) this.Dxv, 0);
        BS.IlO((View) this.fdM, 0);
        BS.IlO((View) this.Ea, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc
    public void IlO(boolean z2, boolean z7) {
        BS.IlO(this.KC, 8);
        BS.IlO(this.zLG, 8);
        BS.IlO((View) this.Cc, 8);
        if (!this.AXM && !this.wD) {
            BS.IlO((View) this.DM, 8);
            if ((this.kBB & 2) != 2) {
                BS.IlO((View) this.mmj, 8);
            }
        } else if ((this.kBB & 1) == 1) {
            BS.IlO((View) this.DM, 8);
        }
        if (z7) {
            BS.IlO((View) this.DM, 8);
            BS.IlO((View) this.mmj, 8);
        }
        EO(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rp.MY.Cc, com.bytedance.sdk.openadsdk.core.widget.cl.IlO
    public void IlO(View view, boolean z2) {
        if (NV()) {
            String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            oeT oet = this.pP;
            if (oet != null && !TextUtils.isEmpty(oet.dm())) {
                IlO(this.pP.dm());
            }
            this.gQ.setText(str);
        } else {
            IlO("");
            this.gQ.setText("");
        }
        if (this.oc) {
            return;
        }
        EO(this.AXM && !this.wD);
        if (zPa()) {
            this.wPn.IlO(this, view, true, this.vCE.getVisibility() != 0);
        }
    }
}
