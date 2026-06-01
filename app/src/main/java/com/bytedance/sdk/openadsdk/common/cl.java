package com.bytedance.sdk.openadsdk.common;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zLG;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class cl extends Dialog {
    private static final String[] MY = {"SDK version", "App", "App version", "OS", "Device", "Creative info"};
    private Button Cc;
    private String EO;
    private final Handler IlO;
    private TextView tV;
    private ImageView vCE;

    public cl(@NonNull Context context) {
        super(context, pP.vCE(context, "tt_privacy_dialog_theme_ad_report"));
        this.IlO = new Handler(Looper.getMainLooper());
        this.EO = "";
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(IlO(getContext()), new ViewGroup.LayoutParams(BS.EO(getContext()), (int) (((double) BS.Cc(getContext())) * 0.9d)));
        MY();
        if (getWindow() != null) {
            getWindow().setGravity(80);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.IlO.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.cl.3
                @Override // java.lang.Runnable
                public void run() {
                    cl.this.tV.setText(cl.this.EO);
                }
            }, 1000L);
        } catch (Exception e) {
            ApmHelper.reportCustomError("showPrivacyAdReportDialogError", "showPrivacyAdReportDialogError", e);
        }
    }

    private void MY() {
        final String strCc = zLG.Cc();
        final String strBc = zLG.Bc();
        final String str = "Android " + Build.VERSION.RELEASE;
        final String str2 = Build.BRAND + " " + Build.MODEL;
        this.Cc.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.cl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) cl.this.getContext().getSystemService("clipboard");
                if (clipboardManager != null) {
                    StringBuilder sb = new StringBuilder();
                    String[] strArr = {BuildConfig.VERSION_NAME, strCc, strBc, str, str2, cl.this.EO};
                    for (int i2 = 0; i2 < cl.MY.length; i2++) {
                        sb.append(cl.MY[i2]);
                        sb.append(": ");
                        sb.append(strArr[i2]);
                        sb.append("\n");
                    }
                    try {
                        clipboardManager.setPrimaryClip(ClipData.newPlainText("pangle sdk build info", sb));
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        this.vCE.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.cl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                cl.this.tV.setText("loading ...");
                cl.this.cancel();
            }
        });
    }

    public void IlO(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.EO = com.bytedance.sdk.component.utils.IlO.IlO(new JSONObject(str)).toString();
        } catch (JSONException e) {
            oeT.EO("TTPrivacyAdReportDialog", e.getMessage());
        }
    }

    private View IlO(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        cc.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_ad_report_info_bg"));
        cc.setOrientation(1);
        cc.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.Cc.Bc bc = new com.bytedance.sdk.openadsdk.core.Cc.Bc(context);
        bc.setLayoutParams(new ViewGroup.LayoutParams(-1, IlO(44.0f)));
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(IlO(191.0f), IlO(24.0f));
        layoutParams2.addRule(13);
        lew.setGravity(17);
        lew.setText("Ad Report");
        lew.setTextColor(Color.parseColor("#161823"));
        lew.setTextSize(1, 17.0f);
        lew.setLayoutParams(layoutParams2);
        this.vCE = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(IlO(40.0f), IlO(44.0f));
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.rightMargin = IlO(8.0f);
        this.vCE.setPadding(IlO(12.0f), IlO(14.0f), IlO(12.0f), IlO(14.0f));
        this.vCE.setImageResource(pP.tV(context, "tt_ad_xmark"));
        this.vCE.setLayoutParams(layoutParams3);
        View view = new View(context);
        ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, IlO(0.5f));
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        view.setLayoutParams(layoutParams4);
        ScrollView scrollView = new ScrollView(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams5.leftMargin = IlO(16.0f);
        layoutParams5.rightMargin = IlO(16.0f);
        layoutParams5.weight = 1.0f;
        layoutParams5.setMarginStart(IlO(16.0f));
        layoutParams5.setMarginEnd(IlO(16.0f));
        scrollView.setLayoutParams(layoutParams5);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc2 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        ViewGroup.LayoutParams layoutParams6 = new ViewGroup.LayoutParams(-1, -1);
        cc2.setOrientation(1);
        cc2.setLayoutParams(layoutParams6);
        String strCc = zLG.Cc();
        String strBc = zLG.Bc();
        String str = "Android " + Build.VERSION.RELEASE;
        String str2 = Build.BRAND + " " + Build.MODEL;
        com.bytedance.sdk.openadsdk.core.Cc.Cc ccIlO = IlO(context, "SDK version", BuildConfig.VERSION_NAME);
        com.bytedance.sdk.openadsdk.core.Cc.Cc ccIlO2 = IlO(context, "App", strCc);
        com.bytedance.sdk.openadsdk.core.Cc.Cc ccIlO3 = IlO(context, "App version", strBc);
        com.bytedance.sdk.openadsdk.core.Cc.Cc ccIlO4 = IlO(context, "OS", str);
        com.bytedance.sdk.openadsdk.core.Cc.Cc ccIlO5 = IlO(context, "Device", str2);
        com.bytedance.sdk.openadsdk.core.Cc.Cc ccIlO6 = IlO(context, "Creative info", "loading ...");
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc3 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, IlO(76.0f));
        cc3.setBackgroundColor(-1);
        cc3.setLayoutParams(layoutParams7);
        this.Cc = new Button(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -1);
        int iIlO = IlO(16.0f);
        layoutParams8.setMargins(iIlO, iIlO, iIlO, iIlO);
        this.Cc.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_ad_report_info_button_bg"));
        this.Cc.setText("copy all");
        this.Cc.setTextColor(Color.parseColor("#333333"));
        this.Cc.setTextSize(14.0f);
        this.Cc.setLayoutParams(layoutParams8);
        cc.addView(bc);
        bc.addView(lew);
        bc.addView(this.vCE);
        cc.addView(view);
        cc.addView(scrollView);
        scrollView.addView(cc2);
        cc2.addView(ccIlO);
        cc2.addView(ccIlO2);
        cc2.addView(ccIlO3);
        cc2.addView(ccIlO4);
        cc2.addView(ccIlO5);
        cc2.addView(ccIlO6);
        cc.addView(cc3);
        cc3.addView(this.Cc);
        return cc;
    }

    private com.bytedance.sdk.openadsdk.core.Cc.Cc IlO(Context context, String str, String str2) {
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, str.equals("Creative info") ? -2 : IlO(74.0f));
        cc.setOrientation(1);
        cc.setPadding(0, IlO(16.0f), 0, IlO(16.0f));
        cc.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = IlO(7.0f);
        lew.setIncludeFontPadding(false);
        lew.setText(str);
        lew.setTextColor(Color.parseColor("#333333"));
        lew.setTextSize(16.0f);
        lew.setTypeface(Typeface.defaultFromStyle(1));
        lew.setLayoutParams(layoutParams2);
        cc.addView(lew);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew2 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        if (str.equals("Creative info")) {
            this.tV = lew2;
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        lew2.setIncludeFontPadding(false);
        lew2.setTextColor(Color.parseColor("#666666"));
        lew2.setText(str2);
        lew2.setTextSize(14.0f);
        lew2.setLayoutParams(layoutParams3);
        cc.addView(lew2);
        return cc;
    }

    private int IlO(float f4) {
        return BS.MY(getContext(), f4);
    }
}
