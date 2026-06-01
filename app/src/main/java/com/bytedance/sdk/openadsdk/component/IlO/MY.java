package com.bytedance.sdk.openadsdk.component.IlO;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.MY.EO;
import com.bytedance.sdk.openadsdk.core.lEW.DmF;
import com.bytedance.sdk.openadsdk.core.lEW.lEW;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.es.IlO.IlO.Bc;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static IlO IlO(oeT oet, Activity activity, com.bytedance.sdk.openadsdk.component.lEW.IlO ilO) {
        IlO ilO2 = new IlO(activity.getApplicationContext(), oet, "open_ad", 4, ilO);
        ilO2.IlO(activity.findViewById(R.id.content));
        ilO2.MY(activity.findViewById(520093713));
        IlO(activity.getApplicationContext(), oet, ilO2);
        IlO(ilO2, oet);
        return ilO2;
    }

    public static lEW MY(oeT oet, Activity activity, final com.bytedance.sdk.openadsdk.component.lEW.IlO ilO, com.bytedance.sdk.openadsdk.component.DmF.MY my) {
        lEW lew = new lEW(activity.getApplicationContext(), oet, "open_ad", 4) { // from class: com.bytedance.sdk.openadsdk.component.IlO.MY.2
            @Override // com.bytedance.sdk.openadsdk.core.MY.IlO, com.bytedance.sdk.openadsdk.core.MY.MY, com.bytedance.sdk.openadsdk.core.MY.EO
            public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
                HashMap map = new HashMap();
                map.put("duration", Long.valueOf(ilO.EO()));
                IlO(map);
                super.IlO(view, f4, f8, f9, f10, sparseArray, z2);
            }
        };
        lew.IlO((View) my);
        IlO(activity.getApplicationContext(), oet, lew);
        IlO(lew, oet);
        return lew;
    }

    public static DmF IlO(oeT oet, Activity activity, final com.bytedance.sdk.openadsdk.component.lEW.IlO ilO, com.bytedance.sdk.openadsdk.component.DmF.MY my) {
        DmF dmF = new DmF(activity, oet, "open_ad", 4) { // from class: com.bytedance.sdk.openadsdk.component.IlO.MY.1
            @Override // com.bytedance.sdk.openadsdk.core.MY.MY, com.bytedance.sdk.openadsdk.core.MY.EO
            public void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<EO.IlO> sparseArray, boolean z2) {
                HashMap map = new HashMap();
                map.put("duration", Long.valueOf(ilO.EO()));
                IlO(map);
                super.IlO(view, f4, f8, f9, f10, sparseArray, z2);
            }
        };
        dmF.IlO(my);
        IlO(activity.getApplicationContext(), oet, dmF);
        IlO(dmF, oet);
        return dmF;
    }

    public static void IlO(com.bytedance.sdk.openadsdk.core.MY.MY my, oeT oet) {
        HashMap map = new HashMap();
        map.put("click_area", Integer.valueOf(oet.es()));
        map.put("openad_creative_type", oeT.Cc(oet) ? "video_normal_ad" : "image_normal_ad");
        map.put("click_scence", Integer.valueOf(OOq.EO(oet) ? 3 : 1));
        my.IlO(map);
    }

    private static void IlO(Context context, oeT oet, com.bytedance.sdk.openadsdk.core.MY.MY my) {
        if (oet == null || oet.Jz() != 4) {
            return;
        }
        my.IlO(Bc.IlO(context, oet, "open_ad"));
    }
}
