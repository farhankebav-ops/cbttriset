package com.bytedance.sdk.component.adexpress.vCE;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class OOq extends LinearLayout {
    private com.bytedance.sdk.component.adexpress.dynamic.tV.NV Bc;
    private LinearLayout Cc;
    private TextView EO;
    private TextView IlO;
    private com.bytedance.sdk.component.utils.tl MY;
    private IlO tV;
    private com.bytedance.adsdk.MY.vCE vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
    }

    public OOq(@NonNull Context context, View view, com.bytedance.sdk.component.adexpress.dynamic.tV.NV nv) {
        super(context);
        this.Bc = nv;
        IlO(context, view);
    }

    public TextView getTopTextView() {
        return this.IlO;
    }

    public LinearLayout getWriggleLayout() {
        return this.Cc;
    }

    public View getWriggleProgressIv() {
        return this.vCE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.MY == null) {
                this.MY = new com.bytedance.sdk.component.utils.tl(getContext().getApplicationContext(), 2);
            }
            new Object() { // from class: com.bytedance.sdk.component.adexpress.vCE.OOq.2
            };
            com.bytedance.sdk.component.adexpress.dynamic.tV.NV nv = this.Bc;
            if (nv != null) {
                nv.EO();
                this.Bc.Cc();
                this.Bc.vCE();
                this.Bc.lEW();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            com.bytedance.adsdk.MY.vCE vce = this.vCE;
            if (vce != null) {
                vce.Cc();
            }
        } catch (Exception unused) {
        }
    }

    public void setOnShakeViewListener(IlO ilO) {
        this.tV = ilO;
    }

    public void setShakeText(String str) {
        this.EO.setText(str);
    }

    private void IlO(Context context, View view) {
        setClipChildren(false);
        addView(view);
        this.Cc = (LinearLayout) findViewById(2097610722);
        this.IlO = (TextView) findViewById(2097610719);
        this.EO = (TextView) findViewById(2097610718);
        com.bytedance.adsdk.MY.vCE vce = (com.bytedance.adsdk.MY.vCE) findViewById(2097610706);
        this.vCE = vce;
        vce.setAnimation("lottie_json/twist_multi_angle.json");
        this.vCE.setImageAssetsFolder("images/");
        this.vCE.IlO(true);
    }

    public void IlO() {
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.vCE.OOq.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    OOq.this.vCE.IlO();
                } catch (Throwable unused) {
                }
            }
        }, 500L);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
    }
}
