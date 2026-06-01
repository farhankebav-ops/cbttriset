package com.bytedance.sdk.component.Cc.Cc;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.Cc.cl;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV extends IlO {
    private Bitmap EO(com.bytedance.sdk.component.Cc.EO.EO eo) {
        return eo.cL().IlO(eo.es()).IlO(eo.NV());
    }

    private Bitmap MY(com.bytedance.sdk.component.Cc.EO.EO eo) {
        Collection<cl> collectionIlO = eo.cL().IlO();
        Bitmap bitmapIlO = null;
        if (collectionIlO == null) {
            return null;
        }
        Iterator<cl> it = collectionIlO.iterator();
        while (it.hasNext() && (bitmapIlO = it.next().IlO(eo.NV())) == null) {
        }
        return bitmapIlO;
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public void IlO(com.bytedance.sdk.component.Cc.EO.EO eo) {
        int iRp = eo.rp();
        Bitmap bitmapMY = (iRp == 2 || iRp == 1) ? (eo.xF() || eo.es().DmF()) ? MY(eo) : EO(eo) : null;
        if (bitmapMY == null) {
            eo.IlO(new rp());
        } else {
            eo.IlO(new hp(bitmapMY, null, false));
        }
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public String IlO() {
        return "memory_cache";
    }
}
