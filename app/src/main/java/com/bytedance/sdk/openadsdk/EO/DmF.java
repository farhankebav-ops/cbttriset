package com.bytedance.sdk.openadsdk.EO;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.EO.NV;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.settings.hp;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zPa;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends com.bytedance.sdk.openadsdk.core.Cc.EO implements NV.EO, NV.IlO, NV.MY, NV.tV {
    private EV Bc;
    private com.bytedance.sdk.openadsdk.core.Cc.lEW Cc;
    private View DmF;
    private int EO;
    private com.bytedance.sdk.openadsdk.core.Cc.lEW EV;
    vCE IlO;
    private int MY;
    private com.bytedance.sdk.openadsdk.core.Cc.tV NV;
    private FilterWord bWL;
    private int hp;
    private View lEW;
    private int rp;
    private final NV tV;
    private TextView vCE;

    public DmF(Context context, NV nv) {
        this(context, nv, null);
    }

    private void EO() {
        if (this.rp > 0) {
            return;
        }
        this.rp = BS.EO(getContext());
        int iCc = BS.Cc(getContext());
        this.hp = iCc;
        this.tV.IlO(this.rp, iCc);
    }

    private com.bytedance.sdk.openadsdk.core.Cc.lEW MY(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = tV() ? this.MY : BS.MY(context, 12.0f);
        layoutParams.gravity = 80;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.EO);
        int iRgb = Color.rgb(254, 44, 85);
        gradientDrawable.setColor(iRgb);
        gradientDrawable.setAlpha(102);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(this.EO);
        gradientDrawable2.setColor(iRgb);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        int i2 = this.EO;
        lew.setPadding(0, i2, 0, i2);
        lew.setGravity(17);
        lew.setBackground(stateListDrawable);
        lew.setTextColor(-1);
        lew.setTextSize(16.0f);
        lew.setText(pP.IlO(context, "tt_suggestion_commit"));
        lew.setEnabled(false);
        lew.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.EO.DmF.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DmF.this.tV.tV();
            }
        });
        lew.setLayoutParams(layoutParams);
        return lew;
    }

    private boolean tV() {
        if (this.rp == 0) {
            EO();
        }
        return this.rp < this.hp;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Cc.EO, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams != null) {
            if (this.rp == 0) {
                EO();
            }
            layoutParams.width = Math.min(this.rp, this.hp) - (BS.MY(getContext(), 16.0f) * 2);
        }
    }

    public DmF(Context context, NV nv, List<FilterWord> list) {
        super(context);
        this.tV = nv;
        nv.IlO((NV.EO) this);
        nv.IlO((NV.MY) this);
        nv.IlO((NV.tV) this);
        nv.IlO((NV.IlO) this);
        EO();
        IlO(context);
        if (list == null || list.isEmpty()) {
            return;
        }
        MY(list);
    }

    private void IlO(Context context) {
        this.EO = BS.MY(context, 8.0f);
        this.MY = BS.MY(context, 20.0f);
        int iMY = BS.MY(context, 56.0f);
        int iMY2 = BS.MY(context, 30.0f);
        int iMY3 = BS.MY(context, 12.0f);
        if (tV()) {
            iMY3 = this.MY;
        }
        if (!tV()) {
            iMY = iMY2;
        }
        View view = new View(getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, BS.MY(getContext(), 98.0f));
        view.setBackground(pP.EO(context, "tt_ad_bg_header_gradient"));
        addView(view, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.EO);
        gradientDrawable.setColor(-1);
        setBackground(gradientDrawable);
        setLayoutParams(layoutParams2);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        int iMY4 = BS.MY(context, 24.0f);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iMY4, iMY4);
        layoutParams3.setMargins(0, iMY3, iMY3, 0);
        layoutParams3.gravity = 8388661;
        tVVar.setImageDrawable(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_titlebar_close_seletor"));
        addView(tVVar, layoutParams3);
        tVVar.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.EO.DmF.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DmF.this.tV.Cc();
            }
        });
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar2 = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        this.NV = tVVar2;
        tVVar2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.EO.DmF.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DmF.this.MY();
            }
        });
        this.NV.setVisibility(8);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(iMY4, iMY4);
        layoutParams4.setMargins(iMY3, iMY3, 0, 0);
        layoutParams4.gravity = 8388659;
        Drawable drawableIlO = com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_leftbackicon_selector");
        drawableIlO.setAutoMirrored(true);
        this.NV.setImageDrawable(drawableIlO);
        addView(this.NV, layoutParams4);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams5.setMargins(iMY3, iMY, iMY3, iMY3);
        cc.setOrientation(1);
        addView(cc, layoutParams5);
        View viewEO = EO(context);
        this.lEW = viewEO;
        cc.addView(viewEO);
        View viewTV = tV(context);
        this.DmF = viewTV;
        cc.addView(viewTV);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewMY = MY(context);
        this.Cc = lewMY;
        cc.addView(lewMY);
    }

    private View tV(Context context) {
        int iMY;
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setOrientation(1);
        if (!tV()) {
            iMY = BS.MY(context, 200.0f);
        } else {
            iMY = BS.MY(context, 358.0f);
        }
        cc.setLayoutParams(new LinearLayout.LayoutParams(-1, iMY));
        TextView textView = new TextView(context);
        textView.setText(pP.IlO(context, "tt_select_reason"));
        textView.setTextSize(tV() ? 23 : 16);
        textView.setGravity(1);
        textView.setTextColor(Color.parseColor("#161823"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = BS.MY(context, tV() ? 24.0f : 4.0f);
        cc.addView(textView, layoutParams);
        vCE vce = new vCE(context, this.tV);
        this.IlO = vce;
        cc.addView(vce);
        if (hp.aP().AK()) {
            com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
            this.EV = lew;
            lew.setId(zPa.NLy);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = tV() ? this.MY : BS.MY(context, 6.0f);
            layoutParams2.gravity = 17;
            this.EV.setLayoutParams(layoutParams2);
            this.EV.setFocusable(false);
            this.EV.setHint(pP.IlO(context, "tt_add_bad_reason"));
            this.EV.setHintTextColor(Color.parseColor("#57000000"));
            this.EV.setTextColor(Color.rgb(22, 24, 35));
            this.EV.setTextSize(15.0f);
            this.EV.setGravity(GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK);
            this.EV.setVisibility(0);
            this.EV.setPadding(0, BS.MY(context, 15.0f), 0, BS.MY(context, 14.0f));
            this.EV.setEllipsize(TextUtils.TruncateAt.END);
            this.EV.setSingleLine();
            this.EV.setMaxLines(1);
            this.EV.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.EO.DmF.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DmF.this.tV.vCE();
                }
            });
            cc.addView(this.EV, layoutParams2);
            cc.addView(new EV(context, Color.argb(128, 0, 0, 0)));
        }
        cc.setVisibility(8);
        return cc;
    }

    private View EO(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        cc.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setText(pP.IlO(context, "tt_like_this_ad"));
        textView.setTextSize(tV() ? 23 : 16);
        textView.setGravity(1);
        textView.setTextColor(Color.parseColor("#161823"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        cc.addView(textView, layoutParams);
        TextView textView2 = new TextView(context);
        textView2.setText(pP.IlO(context, "tt_feel_hint"));
        textView2.setTextSize(tV() ? 14 : 10);
        textView2.setAlpha(0.5f);
        textView2.setTextColor(Color.parseColor("#161823"));
        textView2.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        if (tV()) {
            layoutParams2.topMargin = BS.MY(context, 4.0f);
        }
        cc.addView(textView2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc2 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        int iMY = BS.MY(context, 16.0f);
        int iMY2 = BS.MY(context, 12.0f);
        int iMY3 = BS.MY(context, 8.0f);
        if (tV()) {
            layoutParams3.topMargin = iMY;
            layoutParams3.bottomMargin = iMY;
        } else {
            layoutParams3.topMargin = iMY2;
            layoutParams3.bottomMargin = iMY3;
        }
        cc.addView(cc2, layoutParams3);
        cc2.addView(new Cc(context, 1, this.tV));
        Cc cc3 = new Cc(context, 2, this.tV);
        ViewGroup.LayoutParams layoutParams4 = cc3.getLayoutParams();
        boolean z2 = layoutParams4 instanceof LinearLayout.LayoutParams;
        ViewGroup.LayoutParams layoutParams5 = layoutParams4;
        if (!z2) {
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2);
            layoutParams6.weight = 1.0f;
            layoutParams5 = layoutParams6;
        }
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) layoutParams5;
        layoutParams7.leftMargin = iMY;
        layoutParams7.rightMargin = iMY;
        cc2.addView(cc3, layoutParams5);
        cc2.addView(new Cc(context, 3, this.tV));
        EV ev = new EV(context);
        this.Bc = ev;
        cc.addView(ev);
        this.vCE = new TextView(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        if (!tV()) {
            iMY = iMY3;
        }
        layoutParams8.topMargin = iMY;
        this.vCE.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.vCE.setPadding(iMY2, iMY3, iMY2, iMY3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(iMY3);
        gradientDrawable.setColor(Color.parseColor("#F8F8F8"));
        this.vCE.setBackground(gradientDrawable);
        this.vCE.setText(pP.IlO(context, "tt_report_this_ad"));
        this.vCE.setTextSize(tV() ? 14 : 12);
        Drawable drawableEO = pP.EO(context, "tt_report_ad_arrow");
        drawableEO.setBounds(0, 0, iMY2, iMY2);
        this.vCE.setCompoundDrawables(null, null, drawableEO, null);
        this.vCE.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.EO.DmF.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DmF.this.IlO();
            }
        });
        cc.addView(this.vCE, layoutParams8);
        return cc;
    }

    private void MY(List<FilterWord> list) {
        this.IlO.IlO(list);
    }

    public void MY() {
        View view = this.DmF;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.lEW;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = this.NV;
        if (tVVar != null) {
            tVVar.setVisibility(8);
        }
        NV nv = this.tV;
        if (nv != null) {
            FilterWord filterWord = this.bWL;
            if (filterWord != null) {
                nv.IlO(filterWord);
            } else {
                nv.IlO(NV.IlO);
            }
            this.tV.EO(null);
        }
    }

    public void IlO() {
        View view = this.DmF;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.lEW;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = this.NV;
        if (tVVar != null) {
            tVVar.setVisibility(0);
        }
        NV nv = this.tV;
        if (nv == null || !nv.EO()) {
            return;
        }
        this.bWL = this.tV.MY();
    }

    @Override // com.bytedance.sdk.openadsdk.EO.NV.EO
    public void IlO(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.Cc != null && TextUtils.isEmpty(this.tV.Bc())) {
            this.Cc.setEnabled(!NV.IlO.equals(filterWord));
        }
        if (Cc.IlO.equals(filterWord) || Cc.MY.equals(filterWord)) {
            this.vCE.setVisibility(8);
            this.Bc.setVisibility(8);
        }
        if (Cc.EO.equals(filterWord) || NV.IlO.equals(filterWord)) {
            this.vCE.setVisibility(0);
            this.Bc.setVisibility(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.EO.NV.MY
    public void IlO(int i2) {
        if (NV.EO == i2) {
            this.bWL = null;
            MY();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.EO.NV.tV
    public void IlO(String str) {
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew;
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew2 = this.EV;
        if (lew2 != null) {
            lew2.setText(str);
        }
        if (TextUtils.isEmpty(str)) {
            NV nv = this.tV;
            if (nv == null || (lew = this.Cc) == null) {
                return;
            }
            lew.setEnabled(nv.EO());
            return;
        }
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew3 = this.Cc;
        if (lew3 != null) {
            lew3.setEnabled(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.EO.NV.IlO
    public void IlO(List<FilterWord> list) {
        MY(list);
    }
}
