package com.bytedance.sdk.openadsdk.core.MY;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.xF;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.lEW.lEW;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.bytedance.sdk.openadsdk.utils.zPa;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends MY {
    private int DM;
    private boolean EO;
    private boolean IlO;
    private boolean MY;
    private WeakReference<InterfaceC0087IlO> YA;
    private boolean mmj;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.MY.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InterfaceC0087IlO {
        long getVideoProgress();
    }

    public IlO(@NonNull Context context, @NonNull oeT oet, @NonNull String str, int i2) {
        super(context, oet, str, i2);
        this.IlO = true;
        this.MY = false;
        this.EO = false;
        this.mmj = false;
    }

    private boolean DmF() {
        return this instanceof lEW;
    }

    private boolean NV() {
        if (((MY) this).vCE == null || DmF()) {
            return false;
        }
        if (((MY) this).vCE.uI() != 5 && ((MY) this).vCE.uI() != 15) {
            return false;
        }
        if (this.DM == 0) {
            this.DM = ((MY) this).vCE.OyN();
        }
        MY();
        IlO();
        EO();
        if (this.DM == 5 && lEW() && IlO() && !MY() && !EO()) {
            return false;
        }
        int i2 = this.DM;
        return i2 == 1 || i2 == 2 || i2 == 5;
    }

    private boolean lEW() {
        return oeT.Cc(((MY) this).vCE) && ((MY) this).vCE.lMM() == 1;
    }

    private boolean tV(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof com.bytedance.sdk.openadsdk.core.rp.MY.vCE) || view.getId() == zPa.aP || view.getId() == zPa.ssS || view.getId() == zPa.gQ || view.getId() == zPa.HSR || view.getId() == zPa.AK || view.getId() == 520093726 || view.getId() == zPa.xJ) {
            return true;
        }
        if (view instanceof ViewGroup) {
            int i2 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 >= viewGroup.getChildCount()) {
                    break;
                }
                if (tV(viewGroup.getChildAt(i2))) {
                    return true;
                }
                i2++;
            }
        }
        return false;
    }

    public boolean EO() {
        return false;
    }

    public void IlO(boolean z2) {
        this.IlO = z2;
    }

    public boolean MY() {
        return false;
    }

    public void EO(boolean z2) {
        this.EO = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e6  */
    @Override // com.bytedance.sdk.openadsdk.core.MY.MY, com.bytedance.sdk.openadsdk.core.MY.EO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(android.view.View r27, float r28, float r29, float r30, float r31, android.util.SparseArray<com.bytedance.sdk.openadsdk.core.MY.EO.IlO> r32, boolean r33) {
        /*
            Method dump skipped, instruction units count: 1014
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.MY.IlO.IlO(android.view.View, float, float, float, float, android.util.SparseArray, boolean):void");
    }

    public void MY(boolean z2) {
        this.MY = z2;
    }

    private String MY(String str) {
        str.getClass();
        switch (str) {
            case "banner_ad":
                return "banner_call";
            case "open_ad":
                return "open_ad";
            case "embeded_ad":
                return "feed_call";
            case "interaction":
                return "interaction_call";
            case "slide_banner_ad":
                return "banner_call";
            default:
                return "";
        }
    }

    public void tV(boolean z2) {
        this.mmj = z2;
    }

    public boolean IlO() {
        oeT oet = ((MY) this).vCE;
        if (oet == null) {
            return true;
        }
        int iMY = cl.tV().MY(oet.hFV());
        int iEO = xF.EO(cl.IlO());
        if (iMY == 1) {
            return zLG.tV(iEO);
        }
        if (iMY == 2) {
            return zLG.Cc(iEO) || zLG.tV(iEO) || zLG.vCE(iEO);
        }
        if (iMY != 3) {
            return iMY != 5 || zLG.tV(iEO) || zLG.vCE(iEO);
        }
        return false;
    }

    public void IlO(InterfaceC0087IlO interfaceC0087IlO) {
        this.YA = new WeakReference<>(interfaceC0087IlO);
    }
}
