package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.model.xF;
import com.bytedance.sdk.openadsdk.utils.wPn;
import n7.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp extends com.bytedance.sdk.openadsdk.core.Cc.EO {
    private int Bc;
    private Runnable Cc;
    private int EO;
    protected EV IlO;
    protected boolean MY;
    private long tV;
    private Runnable vCE;

    public rp(@NonNull Context context) {
        super(context);
        this.tV = 10L;
        this.MY = true;
        this.Bc = 1;
        EO();
    }

    private void EO() {
        setBackgroundColor(Color.parseColor("#2E2E2E"));
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(int i2) {
        EV ev = this.IlO;
        if (ev != null) {
            ev.IlO(i2);
        }
        if (i2 == 100 && this.MY) {
            MY();
        }
    }

    public EV getLoadingStyle() {
        return this.IlO;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EO(configuration.orientation);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.Cc;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.Cc = null;
        }
    }

    private void EO(int i2) {
        if (this.Bc != i2) {
            this.Bc = i2;
        }
    }

    public void IlO(oeT oet) {
        xF xFVarEa;
        if (oet != null && (xFVarEa = oet.ea()) != null) {
            this.tV = xFVarEa.IlO();
        }
        EV ev = new EV(getContext());
        this.IlO = ev;
        View viewIlO = ev.IlO();
        if (viewIlO.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewIlO.getParent()).removeView(viewIlO);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        viewIlO.setLayoutParams(layoutParams);
        if (oet != null) {
            boolean zNm = oet.nm();
            com.bytedance.sdk.openadsdk.core.widget.zPa zpaMY = this.IlO.MY();
            if (zpaMY != null) {
                if (zNm) {
                    zpaMY.setVisibility(8);
                } else {
                    com.bytedance.sdk.openadsdk.core.model.zPa zpaHTA = (oet.HTA() == null || TextUtils.isEmpty(oet.HTA().IlO())) ? null : oet.HTA();
                    if (zpaHTA != null && !TextUtils.isEmpty(zpaHTA.IlO())) {
                        try {
                            com.bytedance.sdk.openadsdk.DmF.tV.IlO(zpaHTA).EO(1).IlO(new com.bytedance.sdk.openadsdk.DmF.MY(oet, zpaHTA.IlO(), new wPn(zpaMY)));
                        } catch (Throwable unused) {
                            zpaMY.setVisibility(8);
                        }
                    } else {
                        zpaMY.setVisibility(8);
                    }
                }
            }
            com.bytedance.sdk.openadsdk.core.Cc.lEW lewEO = this.IlO.EO();
            if (lewEO != null) {
                if (zNm) {
                    lewEO.setText("Loading");
                } else if (!TextUtils.isEmpty(oet.dm())) {
                    lewEO.setText(oet.dm());
                } else {
                    lewEO.setVisibility(8);
                }
            }
        }
        addView(viewIlO);
        EO(getResources().getConfiguration().orientation);
    }

    public void MY() {
        this.EO = 0;
        EV ev = this.IlO;
        if (ev != null) {
            removeView(ev.IlO);
            this.IlO.tV();
        }
        setVisibility(8);
        this.IlO = null;
        Runnable runnable = this.Cc;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = this.vCE;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
        }
        this.vCE = null;
        this.Cc = null;
    }

    public void IlO() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.rp.1
            @Override // java.lang.Runnable
            public void run() {
                rp rpVar = rp.this;
                if (rpVar.IlO != null) {
                    rpVar.setVisibility(0);
                }
            }
        });
        if (this.Cc == null) {
            this.Cc = new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.rp.2
                @Override // java.lang.Runnable
                public void run() {
                    rp.this.MY();
                }
            };
        }
        postDelayed(this.Cc, this.tV * 1000);
    }

    public void IlO(int i2) {
        if (i2 == 100 || Math.abs(i2 - this.EO) >= 7) {
            this.EO = i2;
            if (b.b()) {
                MY(this.EO);
                return;
            }
            if (this.vCE == null) {
                this.vCE = new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.rp.3
                    @Override // java.lang.Runnable
                    public void run() {
                        rp rpVar = rp.this;
                        rpVar.MY(rpVar.EO);
                    }
                };
            }
            post(this.vCE);
        }
    }
}
