package com.bytedance.sdk.component.adexpress.dynamic.IlO;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.MY.hp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.AXM;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Bc;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DmF;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.EO;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.EV;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.NV;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.OOq;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.bWL;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.cl;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.dY;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ea;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.es;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.kBB;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.lMM;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nvX;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.oc;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.oeT;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.pP;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.rp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.tl;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vAh;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vSq;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.wPn;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.zPa;
import com.bytedance.sdk.component.adexpress.dynamic.tV.lEW;
import com.bytedance.sdk.component.adexpress.tV;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static Cc IlO(Context context, DynamicRootView dynamicRootView, lEW lew) {
        hp renderRequest;
        if (context == null || dynamicRootView == null || lew == null || lew.NV() == null) {
            return null;
        }
        switch (lew.NV().IlO()) {
            case -1:
                return new dY(context, dynamicRootView, lew);
            case 0:
                return new tl(context, dynamicRootView, lew);
            case 1:
                return new EV(context, dynamicRootView, lew);
            case 2:
                return new Bc(context, dynamicRootView, lew);
            case 3:
                return new DmF(context, dynamicRootView, lew);
            case 4:
                return new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.hp(context, dynamicRootView, lew);
            case 5:
                return new bWL(context, dynamicRootView, lew);
            case 6:
            case 9:
            case 17:
                return new vCE(context, dynamicRootView, lew);
            case 7:
                return new nvX(context, dynamicRootView, lew);
            case 8:
                return new es(context, dynamicRootView, lew);
            case 10:
                return new zPa(context, dynamicRootView, lew);
            case 11:
                return new pP(context, dynamicRootView, lew);
            case 12:
                return new NV(context, dynamicRootView, lew);
            case 13:
                return new OOq(context, dynamicRootView, lew);
            case 14:
                return new wPn(context, dynamicRootView, lew);
            case 15:
                return tV.MY() ? new oc(context, dynamicRootView, lew) : new vSq(context, dynamicRootView, lew);
            case 16:
                return new EV(context, dynamicRootView, lew);
            case 18:
                return new kBB(context, dynamicRootView, lew);
            case 19:
                return new vAh(context, dynamicRootView, lew);
            case 20:
                return new AXM(context, dynamicRootView, lew);
            case 21:
                return new oeT(context, dynamicRootView, lew);
            case 22:
                return new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.lEW(context, dynamicRootView, lew);
            case 23:
                return new cl(context, dynamicRootView, lew);
            case 24:
                return new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.tV(context, dynamicRootView, lew);
            case 25:
                return new rp(context, dynamicRootView, lew);
            case 26:
                return "vertical".equals(lew.NV().Cc().KT()) ? new lMM(context, dynamicRootView, lew) : new EO(context, dynamicRootView, lew);
            case 27:
                return new vSq(context, dynamicRootView, lew);
            case 28:
                if (!tV.MY() || (renderRequest = dynamicRootView.getRenderRequest()) == null) {
                    return null;
                }
                return new ea(context, dynamicRootView, lew, renderRequest.kBB());
            default:
                return null;
        }
    }
}
