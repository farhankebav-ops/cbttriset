package com.bytedance.sdk.openadsdk.EO;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.utils.BS;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp extends Dialog {
    private String Bc;
    private com.bytedance.sdk.openadsdk.core.Cc.lEW Cc;
    private String DmF;
    private com.bytedance.sdk.openadsdk.core.Cc.MY EO;
    private com.bytedance.sdk.openadsdk.core.Cc.Cc IlO;
    private IlO MY;
    private final NV NV;
    private String lEW;
    private com.bytedance.sdk.openadsdk.core.Cc.lEW tV;
    private com.bytedance.sdk.openadsdk.core.Cc.tV vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void EO();

        void IlO();

        void IlO(int i2, FilterWord filterWord, String str);

        void MY();
    }

    public rp(@NonNull Context context, NV nv) {
        super(context, pP.vCE(context, "tt_quick_option_dialog"));
        setCanceledOnTouchOutside(false);
        this.NV = nv;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        MY();
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.bytedance.sdk.openadsdk.core.Cc.Cc ccIlO = IlO(cl.IlO());
        this.IlO = ccIlO;
        setContentView(ccIlO);
        IlO(this.IlO);
        EO();
        IlO();
        tV();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        IlO ilO = this.MY;
        if (ilO != null) {
            ilO.IlO();
        }
    }

    private void EO() {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        if (window != null) {
            if (window.getDecorView() != null) {
                window.getDecorView().setPadding(0, 0, 0, 0);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setGravity(80);
        }
    }

    private void IlO(View view) {
        IlO((EditText) this.EO);
        NV nv = this.NV;
        if (nv != null) {
            String strBc = nv.Bc();
            if (!TextUtils.isEmpty(strBc)) {
                this.EO.setText(strBc);
                this.tV.setText(String.format(Locale.getDefault(), "%d%s", Integer.valueOf(strBc.length()), "/200"));
            }
            this.Cc.setEnabled(!TextUtils.isEmpty(strBc));
        }
        this.Cc.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.EO.rp.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String string = rp.this.EO.getText().toString();
                if (rp.this.MY != null) {
                    rp.this.MY.IlO(4, NV.IlO, string);
                }
                rp.this.dismiss();
            }
        });
        this.vCE.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.EO.rp.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (rp.this.MY != null) {
                    rp.this.MY.MY();
                }
                rp.this.dismiss();
            }
        });
        this.EO.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.sdk.openadsdk.EO.rp.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i8, int i9) {
                com.bytedance.sdk.openadsdk.core.Cc.lEW lew;
                int iRound = Math.round(charSequence.length());
                rp.this.tV.setText(iRound + "/200");
                boolean z2 = true;
                if (iRound <= 0) {
                    lew = rp.this.Cc;
                    if (rp.this.NV == null || TextUtils.isEmpty(rp.this.NV.Bc())) {
                        z2 = false;
                    }
                } else if (rp.this.Cc.isEnabled()) {
                    return;
                } else {
                    lew = rp.this.Cc;
                }
                lew.setEnabled(z2);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i8, int i9) {
            }
        });
    }

    private void tV() {
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.EO.rp.5
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (rp.this.MY != null) {
                    rp.this.MY.EO();
                }
            }
        });
    }

    public void MY() {
        InputMethodManager inputMethodManager;
        com.bytedance.sdk.openadsdk.core.Cc.MY my = this.EO;
        if (my == null || (inputMethodManager = (InputMethodManager) my.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.IlO.getWindowToken(), 0);
    }

    public static void IlO(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.sdk.openadsdk.EO.rp.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i2, int i8, Spanned spanned, int i9, int i10) {
                while (i2 < i8) {
                    int type = Character.getType(charSequence.charAt(i2));
                    if (type == 19 || type == 28) {
                        return "";
                    }
                    i2++;
                }
                return null;
            }
        }, new InputFilter.LengthFilter(200)});
    }

    public void IlO(IlO ilO) {
        this.MY = ilO;
    }

    public void IlO() {
        com.bytedance.sdk.openadsdk.core.Cc.MY my = this.EO;
        if (my == null) {
            return;
        }
        my.requestFocus();
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(5);
        }
    }

    public void IlO(String str, String str2) {
        this.Bc = str;
        this.lEW = str2;
        NV nv = this.NV;
        if (nv != null) {
            nv.tV(str2);
        }
    }

    public void IlO(String str) {
        this.DmF = str;
    }

    private com.bytedance.sdk.openadsdk.core.Cc.Cc IlO(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        cc.setOrientation(1);
        cc.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_dislike_dialog_bg"));
        com.bytedance.sdk.openadsdk.core.Cc.Bc bc = new com.bytedance.sdk.openadsdk.core.Cc.Bc(context);
        bc.setLayoutParams(new LinearLayout.LayoutParams(-1, BS.MY(context, 48.0f)));
        this.vCE = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        int iMY = BS.MY(context, 24.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iMY, iMY);
        layoutParams.addRule(16);
        layoutParams.addRule(11);
        int iMY2 = BS.MY(context, 10.0f);
        layoutParams.topMargin = iMY2;
        layoutParams.rightMargin = iMY2;
        this.vCE.setLayoutParams(layoutParams);
        this.vCE.setClickable(true);
        this.vCE.setFocusable(true);
        this.vCE.setImageDrawable(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_titlebar_close_seletor"));
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(16);
        layoutParams2.topMargin = BS.MY(context, 12.0f);
        lew.setLayoutParams(layoutParams2);
        lew.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        lew.setGravity(17);
        lew.setSingleLine(true);
        lew.setText(pP.IlO(context, "tt_other_reason"));
        lew.setTextColor(Color.parseColor("#161823"));
        lew.setTextSize(15.0f);
        lew.setTypeface(Typeface.defaultFromStyle(0));
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, BS.MY(context, 0.5f)));
        view.setBackgroundColor(Color.argb(51, 22, 24, 35));
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc2 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        cc2.setOrientation(1);
        com.bytedance.sdk.openadsdk.core.Cc.MY my = new com.bytedance.sdk.openadsdk.core.Cc.MY(context);
        this.EO = my;
        my.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200), new InputFilter.AllCaps()});
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = BS.MY(context, 16.0f);
        layoutParams3.rightMargin = BS.MY(context, 16.0f);
        layoutParams3.topMargin = BS.MY(context, 11.5f);
        this.EO.setLayoutParams(layoutParams3);
        this.EO.setLines(4);
        this.EO.setGravity(48);
        this.EO.setTextSize(15.0f);
        this.EO.setTextColor(Color.rgb(22, 24, 35));
        this.EO.setHintTextColor(Color.parseColor("#57161823"));
        this.EO.setBackground(null);
        this.EO.setImeOptions(268435456);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc3 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        int iMY3 = BS.MY(context, 16.0f);
        int iMY4 = BS.MY(context, 17.0f);
        cc3.setPadding(iMY3, iMY4, iMY3, iMY4);
        cc3.setLayoutParams(layoutParams4);
        cc3.setOrientation(0);
        this.tV = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -2);
        layoutParams5.weight = 1.0f;
        layoutParams5.gravity = GravityCompat.START;
        this.tV.setLayoutParams(layoutParams5);
        this.tV.setText("0/200");
        this.tV.setGravity(GravityCompat.START);
        this.tV.setTextColor(Color.parseColor("#57161823"));
        this.tV.setTextSize(15.0f);
        this.Cc = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = GravityCompat.END;
        this.Cc.setLayoutParams(layoutParams6);
        this.Cc.setTextSize(14.0f);
        this.Cc.setTextColor(-1);
        this.Cc.setVisibility(0);
        this.Cc.setSingleLine(true);
        int iMY5 = BS.MY(context, 27.0f);
        int iMY6 = BS.MY(context, 5.0f);
        this.Cc.setPadding(iMY5, iMY6, iMY5, iMY6);
        int iMY7 = BS.MY(context, 6.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f4 = iMY7;
        gradientDrawable.setCornerRadius(f4);
        int iRgb = Color.rgb(254, 44, 85);
        gradientDrawable.setColor(iRgb);
        gradientDrawable.setAlpha(102);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(f4);
        gradientDrawable2.setColor(iRgb);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        this.Cc.setBackground(stateListDrawable);
        this.Cc.setText(pP.IlO(context, "tt_done"));
        this.Cc.setEnabled(false);
        cc.addView(bc);
        cc.addView(view);
        cc.addView(cc2);
        bc.addView(this.vCE);
        bc.addView(lew);
        cc2.addView(this.EO);
        cc2.addView(cc3);
        cc3.addView(this.tV);
        cc3.addView(this.Cc);
        return cc;
    }
}
