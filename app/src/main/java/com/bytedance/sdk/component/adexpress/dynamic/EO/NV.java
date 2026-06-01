package com.bytedance.sdk.component.adexpress.dynamic.EO;

import a1.a;
import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV {
    public static Bc IlO(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc, com.bytedance.sdk.component.adexpress.dynamic.tV.NV nv, com.bytedance.sdk.component.adexpress.MY.hp hpVar) {
        String strGQ;
        String strKBB;
        if (context == null || cc == null || bc == null) {
            return null;
        }
        strGQ = bc.gQ();
        strKBB = hpVar.kBB();
        strGQ.getClass();
        switch (strGQ) {
            case "0":
                return new Cc(context, cc, bc);
            case "1":
                return new EO(context, cc, bc);
            case "2":
                return new MY(context, cc, bc);
            case "5":
                return bc.AK() == 1 ? new cl(context, cc, bc, bc.HTA()) : new zPa(context, cc, bc);
            case "6":
            case "11":
                return new bWL(context, cc, bc);
            case "7":
            case "14":
                return new rp(context, cc, bc);
            case "8":
                return new hp(context, cc, bc);
            case "9":
            case "16":
                return new ea(context, cc, bc, strGQ, nv.IlO(), nv.MY(), nv.tV(), nv.Bc());
            case "10":
                return new tV(context, cc, bc);
            case "12":
                return new zPa(context, cc, bc);
            case "13":
                return new cl(context, cc, bc);
            case "17":
            case "18":
                return new xF(context, cc, bc, strGQ, nv);
            case "20":
                if (com.bytedance.sdk.component.adexpress.tV.MY()) {
                    return new EV(context, cc, bc, a.C(strKBB, "static/lotties/glass-swipe/glass-swipe.json"), "20");
                }
                return new EV(context, cc, bc, TextUtils.isEmpty(strKBB) ? null : a.C(strKBB, "brush_mask.json"), "20");
            case "22":
                return com.bytedance.sdk.component.adexpress.tV.MY() ? new EV(context, cc, bc, a.C(strKBB, "static/lotties/202327swiper-up-star/index.json"), "22") : new es(context, cc, bc);
            case "23":
                if (com.bytedance.sdk.component.adexpress.tV.MY()) {
                    return new EV(context, cc, bc, a.C(strKBB, "static/lotties/202327swiper-up-star/click.json"), "23");
                }
                return null;
            case "24":
                if (com.bytedance.sdk.component.adexpress.tV.MY()) {
                    return new IlO(context, cc, bc);
                }
                return new EV(context, cc, bc, TextUtils.isEmpty(strKBB) ? null : a.C(strKBB, "swiper_up_star.json"), "24");
            case "25":
                if (com.bytedance.sdk.component.adexpress.tV.MY()) {
                    return new EV(context, cc, bc, a.C(strKBB, "static/lotties/gesture-slide.json"), "25");
                }
                return null;
            case "29":
                return new vCE(context, cc, bc, nv.IlO(), nv.MY(), nv.tV(), nv.Bc());
            default:
                return null;
        }
    }
}
