package com.bytedance.sdk.openadsdk.cL.IlO;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.Cc.EV;
import com.bytedance.sdk.component.Cc.NV;
import com.bytedance.sdk.component.Cc.lEW;
import com.bytedance.sdk.component.Cc.zPa;
import com.bytedance.sdk.openadsdk.cL.vCE;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(int i2, String str, Throwable th);

        void IlO(String str, EO eo);
    }

    public void IlO(vCE vce, final IlO ilO, int i2, int i8, ImageView.ScaleType scaleType, String str, final int i9, oeT oet) {
        NV nvIlO = com.bytedance.sdk.openadsdk.DmF.tV.IlO(vce.IlO).IlO(vce.MY).IlO(i2).MY(i8).Cc(BS.Cc(cl.IlO())).tV(BS.EO(cl.IlO())).MY(str).IlO(scaleType).IlO(!TextUtils.isEmpty(str));
        if (i9 <= 0 || Build.VERSION.SDK_INT < 26) {
            nvIlO.EO(1);
        } else {
            nvIlO.EO(2).IlO(new lEW() { // from class: com.bytedance.sdk.openadsdk.cL.IlO.MY.1
                @Override // com.bytedance.sdk.component.Cc.lEW
                public Bitmap IlO(Bitmap bitmap) {
                    return com.bytedance.sdk.component.adexpress.tV.IlO.IlO(cl.IlO(), bitmap, i9);
                }
            });
        }
        nvIlO.IlO(new com.bytedance.sdk.openadsdk.DmF.MY(oet, vce.IlO, new zPa() { // from class: com.bytedance.sdk.openadsdk.cL.IlO.MY.2
            @Override // com.bytedance.sdk.component.Cc.zPa
            public void IlO(EV ev) {
                MY.this.IlO(ev, ilO);
            }

            @Override // com.bytedance.sdk.component.Cc.zPa
            public void IlO(int i10, String str2, Throwable th) {
                MY.this.IlO(i10, str2, th, ilO);
            }
        }));
    }

    public void IlO(EV ev, IlO ilO) {
        if (ilO != null) {
            Object objMY = ev.MY();
            int iIlO = IlO(ev);
            if (objMY instanceof Drawable) {
                ilO.IlO(ev.IlO(), new EO((Drawable) objMY, iIlO));
                return;
            }
            if (objMY instanceof byte[]) {
                ilO.IlO(ev.IlO(), new EO((byte[]) objMY, iIlO));
                return;
            }
            if (objMY instanceof Bitmap) {
                ilO.IlO(ev.IlO(), new EO((Bitmap) objMY, ev.EO() instanceof Bitmap ? (Bitmap) ev.EO() : null, iIlO));
            } else {
                ilO.IlO(0, "not bitmap or gif result!", null);
            }
        }
    }

    private int IlO(EV ev) {
        Object obj;
        Map<String, String> mapTV = ev.tV();
        if (mapTV == null || (obj = mapTV.get("image_size")) == null || !(obj instanceof Integer)) {
            return 0;
        }
        return ((Integer) obj).intValue();
    }

    public void IlO(int i2, String str, Throwable th, IlO ilO) {
        if (ilO != null) {
            ilO.IlO(i2, str, th);
        }
    }
}
