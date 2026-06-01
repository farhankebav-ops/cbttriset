package com.bytedance.sdk.openadsdk.kBB.MY;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    private static final Map<Integer, MY> IlO = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public int IlO;
        public int MY = -1;

        public IlO(int i2) {
            this.IlO = i2;
        }
    }

    private static boolean EO(oeT oet) {
        if (oet == null) {
            return false;
        }
        String strIlO = zLG.IlO(oet);
        return ((!"open_ad".equals(strIlO) && !"fullscreen_interstitial_ad".equals(strIlO) && !"rewarded_video".equals(strIlO)) || OOq.MY(oet) || oet.vAh() == 5 || oet.vAh() == 33 || !oeT.Cc(oet) || oet.fdM() == null) ? false : true;
    }

    public static void IlO(View view, oeT oet, IlO ilO) {
        if (view == null || oet == null || oet.dM()) {
            return;
        }
        boolean zEO = EO(oet);
        if (OOq.MY(oet) && ilO != null) {
            ilO.IlO = -1;
        }
        IlO(IlO(view, oet, zEO, ilO));
    }

    public static void MY(Integer num) {
        IlO.remove(num);
    }

    public static Integer MY(oeT oet) {
        return Integer.valueOf((oet.JAC() + oet.ED()).hashCode());
    }

    private static MY IlO(View view, oeT oet, boolean z2, IlO ilO) {
        if (view == null || oet == null || oet.ED() == null) {
            return null;
        }
        Integer numMY = MY(oet);
        Map<Integer, MY> map = IlO;
        if (map.containsKey(numMY)) {
            MY my = map.get(numMY);
            if (my != null) {
                my.IlO(view);
            }
            return my;
        }
        MY myIlO = MY.IlO(z2, numMY, view, oet, ilO);
        map.put(numMY, myIlO);
        return myIlO;
    }

    private static void IlO(MY my) {
        if (my == null) {
            return;
        }
        my.IlO();
    }

    public static void IlO(oeT oet, int i2) {
        if (oet == null || oet.ED() == null) {
            return;
        }
        IlO(IlO.get(MY(oet)), i2);
    }

    public static void IlO(MY my, int i2) {
        if (my == null) {
            return;
        }
        my.IlO(i2);
    }

    public static void IlO(oeT oet) {
        if (oet == null || oet.ED() == null) {
            return;
        }
        Integer numMY = MY(oet);
        Map<Integer, MY> map = IlO;
        MY my = map.get(numMY);
        if (my != null) {
            my.NV();
        }
        MY(numMY);
        if (map.size() <= 0) {
            Bc.IlO();
        }
    }

    public static MY IlO(Integer num) {
        return IlO.get(num);
    }
}
