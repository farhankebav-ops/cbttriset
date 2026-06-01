package com.bytedance.sdk.openadsdk.component.reward.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends com.bytedance.sdk.openadsdk.core.Cc.EO {
    private final com.bytedance.sdk.openadsdk.component.reward.IlO.IlO IlO;

    public Bc(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        super(ilO.gQ);
        this.IlO = ilO;
        if (ilO.ED != null || Build.VERSION.SDK_INT < 35) {
            return;
        }
        setFitsSystemWindows(true);
    }

    public void IlO(com.bytedance.sdk.openadsdk.component.reward.MY.MY my) {
        RFEndCardBackUpLayout rFEndCardBackUpLayoutLEW;
        my.IlO(this);
        if (this.IlO.IlO != 1 && (rFEndCardBackUpLayoutLEW = my.lEW()) != null) {
            addView(rFEndCardBackUpLayoutLEW, new FrameLayout.LayoutParams(-1, -1));
        }
        IlO(my.DmF(), this);
        IlO(my.NV(), this);
    }

    private void IlO(View view, ViewGroup viewGroup) {
        if (view != null) {
            viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }
}
