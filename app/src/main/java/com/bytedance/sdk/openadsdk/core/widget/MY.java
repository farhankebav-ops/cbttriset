package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends Dialog {
    private View Bc;
    private com.bytedance.sdk.openadsdk.core.Cc.IlO Cc;
    private String DmF;
    private com.bytedance.sdk.openadsdk.core.Cc.lEW EO;
    private String EV;
    public IlO IlO;
    private com.bytedance.sdk.openadsdk.core.Cc.tV MY;
    private String NV;
    private boolean bWL;
    private int hp;
    private final Context lEW;
    private String rp;
    private com.bytedance.sdk.openadsdk.core.Cc.lEW tV;
    private com.bytedance.sdk.openadsdk.core.Cc.IlO vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO();

        void MY();
    }

    public MY(Context context) {
        super(context, pP.vCE(context, "tt_custom_dialog"));
        this.hp = -1;
        this.bWL = false;
        this.lEW = context;
    }

    private void IlO() {
        this.vCE.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.MY.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IlO ilO = MY.this.IlO;
                if (ilO != null) {
                    ilO.IlO();
                }
            }
        });
        this.Cc.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.MY.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IlO ilO = MY.this.IlO;
                if (ilO != null) {
                    ilO.MY();
                }
            }
        });
    }

    private void MY() {
        if (TextUtils.isEmpty(this.NV)) {
            this.EO.setVisibility(8);
        } else {
            this.EO.setText(this.NV);
            this.EO.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.DmF)) {
            this.tV.setText(this.DmF);
        }
        if (TextUtils.isEmpty(this.EV)) {
            this.vCE.setText(pP.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), "tt_postive_txt"));
        } else {
            this.vCE.setText(this.EV);
        }
        if (TextUtils.isEmpty(this.rp)) {
            this.Cc.setText(pP.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), "tt_negtive_txt"));
        } else {
            this.Cc.setText(this.rp);
        }
        int i2 = this.hp;
        if (i2 != -1) {
            this.MY.setImageResource(i2);
            this.MY.setVisibility(0);
        } else {
            this.MY.setVisibility(8);
        }
        if (this.bWL) {
            this.Bc.setVisibility(8);
            this.Cc.setVisibility(8);
        } else {
            this.Cc.setVisibility(0);
            this.Bc.setVisibility(0);
        }
    }

    public MY EO(String str) {
        this.rp = str;
        return this;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(IlO(this.lEW));
        setCanceledOnTouchOutside(false);
        MY();
        IlO();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        MY();
    }

    private View IlO(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.Bc bc = new com.bytedance.sdk.openadsdk.core.Cc.Bc(context);
        bc.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        cc.setMinimumWidth(IlO(260.0f));
        cc.setPadding(0, IlO(32.0f), 0, 0);
        cc.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_custom_dialog_bg"));
        cc.setOrientation(1);
        cc.setLayoutParams(layoutParams);
        this.EO = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.leftMargin = IlO(16.0f);
        layoutParams2.rightMargin = IlO(16.0f);
        layoutParams2.bottomMargin = IlO(16.0f);
        this.EO.setGravity(17);
        this.EO.setVisibility(0);
        this.EO.setTextColor(Color.parseColor("#333333"));
        this.EO.setTextSize(18.0f);
        this.EO.setLayoutParams(layoutParams2);
        this.MY = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        layoutParams3.leftMargin = IlO(16.0f);
        layoutParams3.rightMargin = IlO(16.0f);
        layoutParams3.bottomMargin = IlO(10.0f);
        this.MY.setMaxHeight(IlO(150.0f));
        this.MY.setMaxWidth(IlO(150.0f));
        this.MY.setVisibility(0);
        this.MY.setLayoutParams(layoutParams3);
        this.tV = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.leftMargin = IlO(20.0f);
        layoutParams4.rightMargin = IlO(20.0f);
        this.tV.setGravity(17);
        this.tV.setLineSpacing(IlO(3.0f), 1.2f);
        this.tV.setTextSize(18.0f);
        this.tV.setTextColor(Color.parseColor("#000000"));
        this.tV.setLayoutParams(layoutParams4);
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams5.topMargin = IlO(32.0f);
        view.setBackgroundColor(Color.parseColor("#E4E4E4"));
        view.setLayoutParams(layoutParams5);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc2 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        cc2.setOrientation(0);
        cc2.setLayoutParams(layoutParams6);
        com.bytedance.sdk.openadsdk.core.Cc.IlO ilO = new com.bytedance.sdk.openadsdk.core.Cc.IlO(context);
        this.Cc = ilO;
        ilO.setId(520093718);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        layoutParams7.leftMargin = IlO(10.0f);
        layoutParams7.weight = 1.0f;
        this.Cc.setPadding(0, IlO(16.0f), 0, IlO(16.0f));
        this.Cc.setBackground(null);
        this.Cc.setGravity(17);
        this.Cc.setSingleLine(true);
        this.Cc.setTextColor(Color.parseColor("#999999"));
        this.Cc.setTextSize(16.0f);
        this.Cc.setLayoutParams(layoutParams7);
        this.Bc = new View(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(1, -1);
        this.Bc.setBackgroundColor(Color.parseColor("#E4E4E4"));
        this.Bc.setLayoutParams(layoutParams8);
        this.vCE = new com.bytedance.sdk.openadsdk.core.Cc.IlO(context);
        this.Cc.setId(520093719);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, -2);
        layoutParams9.rightMargin = IlO(10.0f);
        layoutParams9.weight = 1.0f;
        this.vCE.setPadding(0, IlO(16.0f), 0, IlO(16.0f));
        this.vCE.setBackground(null);
        this.vCE.setGravity(17);
        this.vCE.setSingleLine(true);
        this.vCE.setTextColor(Color.parseColor("#38ADFF"));
        this.vCE.setTextSize(16.0f);
        this.vCE.setLayoutParams(layoutParams9);
        bc.addView(cc);
        cc.addView(this.EO);
        cc.addView(this.MY);
        cc.addView(this.tV);
        cc.addView(view);
        cc.addView(cc2);
        cc2.addView(this.Cc);
        cc2.addView(this.Bc);
        cc2.addView(this.vCE);
        return bc;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    public MY MY(String str) {
        this.EV = str;
        return this;
    }

    private int IlO(float f4) {
        return BS.MY(getContext(), f4);
    }

    public MY IlO(IlO ilO) {
        this.IlO = ilO;
        return this;
    }

    public MY IlO(String str) {
        this.DmF = str;
        return this;
    }
}
