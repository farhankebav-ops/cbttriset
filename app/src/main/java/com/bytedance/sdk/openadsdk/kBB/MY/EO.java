package com.bytedance.sdk.openadsdk.kBB.MY;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.kBB.MY.Cc;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends MY {
    private int tV;

    public EO(Integer num, View view, oeT oet, Cc.IlO ilO) {
        super(num, view, oet, 1000, ilO);
        this.tV = -1;
        MY(view);
    }

    @Override // com.bytedance.sdk.openadsdk.kBB.MY.MY
    public boolean EO() {
        WeakReference<View> weakReference = this.IlO;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        View view = this.IlO.get();
        if (this.tV == -1) {
            MY(view);
        }
        return vCE.IlO(view, this.tV == 1, this.MY.fHv());
    }

    @Override // com.bytedance.sdk.openadsdk.kBB.MY.MY
    public void MY(int i2) {
    }

    @Override // com.bytedance.sdk.openadsdk.kBB.MY.MY
    public void tV() {
        super.tV();
    }

    @Override // com.bytedance.sdk.openadsdk.kBB.MY.MY
    public int vCE() {
        oeT oet = this.MY;
        return (oet != null && oet.WIv() && this.MY.OyN() == 1) ? 1000 : 100;
    }

    private void MY(View view) {
        if (view != null) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            this.tV = width * height >= 242500 ? 1 : 0;
        }
    }
}
