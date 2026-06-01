package com.bytedance.sdk.openadsdk.component.DmF;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.zPa;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private static boolean IlO;
    private static Drawable MY;
    private zPa EO;
    private TextView tV;

    public static Drawable EO() {
        return MY;
    }

    public void IlO(EO eo, oeT oet, float f4, float f8, boolean z2) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        if (eo != null) {
            this.EO = eo.getHostAppIcon();
            this.tV = eo.getHostAppName();
            View userInfo = eo.getUserInfo();
            if (eo instanceof tV) {
                zPa zpa = this.EO;
                if (zpa != null && (layoutParams2 = zpa.getLayoutParams()) != null) {
                    if (oet.BES() == 1) {
                        int iMY = BS.MY(this.EO.getContext(), 40.0f);
                        layoutParams2.width = iMY;
                        layoutParams2.height = iMY;
                    } else {
                        int iMY2 = BS.MY(this.EO.getContext(), 30.0f);
                        layoutParams2.width = iMY2;
                        layoutParams2.height = iMY2;
                    }
                    this.EO.setLayoutParams(layoutParams2);
                }
                if (this.tV != null) {
                    if (oet.BES() == 1) {
                        this.tV.setTextSize(30.0f);
                    } else {
                        this.tV.setTextSize(24.0f);
                    }
                }
                if (userInfo != null && (layoutParams = userInfo.getLayoutParams()) != null) {
                    if (oet.BES() == 1) {
                        layoutParams.height = BS.MY(userInfo.getContext(), 107.0f);
                    } else {
                        layoutParams.height = BS.MY(userInfo.getContext(), 60.0f);
                    }
                    userInfo.setLayoutParams(layoutParams);
                }
            }
            if (userInfo != null) {
                userInfo.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.DmF.lEW.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                });
            }
        }
    }

    public void MY() {
        if (IlO) {
            return;
        }
        try {
            int iDmF = DmF.MY().DmF();
            if (iDmF != 0) {
                MY = cl.IlO().getResources().getDrawable(iDmF);
            }
            IlO = true;
        } catch (Throwable unused) {
            IlO = true;
        }
    }

    public void IlO() {
        String strLEW = DmF.MY().lEW();
        if (TextUtils.isEmpty(strLEW)) {
            this.tV.setVisibility(8);
        } else {
            this.tV.setText(strLEW);
        }
        MY();
        try {
            Drawable drawable = MY;
            if (drawable == null) {
                this.EO.setVisibility(8);
                return;
            }
            this.EO.setImageDrawable(drawable);
            if (this.tV.getVisibility() == 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.EO.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, 0, 0);
                this.EO.setLayoutParams(marginLayoutParams);
            }
        } catch (Throwable unused) {
            this.EO.setVisibility(8);
        }
    }
}
