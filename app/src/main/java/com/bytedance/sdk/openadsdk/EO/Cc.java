package com.bytedance.sdk.openadsdk.EO;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.EO.NV;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends com.bytedance.sdk.openadsdk.core.Cc.Cc implements View.OnClickListener, NV.EO {
    private final int Bc;
    private FilterWord Cc;
    private final NV tV;
    private StateListDrawable vCE;
    public static FilterWord IlO = new FilterWord("100:1", "GOOD");
    public static FilterWord MY = new FilterWord("100:2", "NOT_BAD");
    public static FilterWord EO = new FilterWord("100:3", "BAD");

    public Cc(@NonNull Context context, int i2, NV nv) {
        super(context);
        this.Bc = i2;
        this.tV = nv;
        if (nv != null) {
            nv.IlO(this);
        }
        IlO(i2);
        IlO();
        MY();
    }

    private void IlO(int i2) {
        if (i2 == 1) {
            this.Cc = IlO;
        } else if (i2 == 2) {
            this.Cc = MY;
        } else {
            if (i2 != 3) {
                return;
            }
            this.Cc = EO;
        }
    }

    private void MY() {
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(getContext());
        lew.setTextSize(this.tV.DmF() ? 40 : 30);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.setMargins(0, BS.MY(getContext(), 12.0f), 0, BS.MY(getContext(), this.tV.DmF() ? 8.0f : 4.0f));
        addView(lew, layoutParams);
        IlO ilO = new IlO(getContext());
        ilO.setTextSize(this.tV.DmF() ? 17 : 12);
        ilO.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        ilO.setMaxLines(1);
        ilO.setSingleLine();
        ilO.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.setMargins(0, 0, 0, BS.MY(getContext(), 12.0f));
        addView(ilO, layoutParams2);
        int i2 = this.Bc;
        if (i2 == 1) {
            lew.setText("😍");
            ilO.setText(pP.IlO(getContext(), "tt_good"));
        } else if (i2 == 2) {
            ilO.setText(pP.IlO(getContext(), "tt_not_bad"));
            lew.setText("😐");
        } else {
            if (i2 != 3) {
                return;
            }
            ilO.setText(pP.IlO(getContext(), "tt_bad"));
            lew.setText("😡");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (isSelected()) {
            this.tV.IlO(NV.IlO);
        } else {
            this.tV.IlO(this.Cc);
        }
    }

    private void IlO() {
        if (this.vCE == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(BS.MY(getContext(), 12.0f));
            gradientDrawable.setColor(Color.parseColor("#F8F8F8"));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setStroke(BS.MY(getContext(), 2.0f), Color.parseColor("#FE2C55"));
            gradientDrawable2.setCornerRadius(BS.MY(getContext(), 12.0f));
            gradientDrawable2.setColor(Color.parseColor("#12FE2C55"));
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.vCE = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_selected}, gradientDrawable2);
            this.vCE.addState(new int[0], gradientDrawable);
        }
        setBackground(this.vCE);
        setSelected(false);
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        setLayoutParams(layoutParams);
        setOnClickListener(this);
    }

    @Override // com.bytedance.sdk.openadsdk.EO.NV.EO
    public void IlO(FilterWord filterWord) {
        FilterWord filterWord2;
        if (filterWord == null || (filterWord2 = this.Cc) == null) {
            return;
        }
        setSelected(filterWord.equals(filterWord2));
    }
}
