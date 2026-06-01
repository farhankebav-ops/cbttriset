package com.bytedance.sdk.component.Cc.EO;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.Cc.EO.EO;
import com.bytedance.sdk.component.Cc.NV;
import com.bytedance.sdk.component.Cc.ea;
import com.bytedance.sdk.component.Cc.es;
import com.bytedance.sdk.component.Cc.hp;
import com.bytedance.sdk.component.utils.zPa;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements ea {
    private volatile vCE IlO;

    private MY() {
    }

    public static ea IlO(Context context, hp hpVar) {
        MY my = new MY();
        my.MY(context, hpVar);
        return my;
    }

    private void MY(Context context, hp hpVar) {
        if (this.IlO != null) {
            Log.w("ImageLoader", "already init!");
        }
        if (hpVar == null) {
            hpVar = Cc.IlO(context);
        }
        this.IlO = new vCE(context, hpVar);
    }

    @Override // com.bytedance.sdk.component.Cc.ea
    public NV IlO(String str) {
        return new EO.MY(this.IlO).EO(str);
    }

    @Override // com.bytedance.sdk.component.Cc.ea
    public InputStream IlO(String str, String str2) {
        if (this.IlO != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = zPa.IlO(str);
            }
            Collection<es> collectionMY = this.IlO.MY();
            if (collectionMY != null) {
                Iterator<es> it = collectionMY.iterator();
                while (it.hasNext()) {
                    byte[] bArrIlO = it.next().IlO(str2);
                    if (bArrIlO != null) {
                        return new ByteArrayInputStream(bArrIlO);
                    }
                }
            }
            Collection<com.bytedance.sdk.component.Cc.EO> collectionEO = this.IlO.EO();
            if (collectionEO != null) {
                Iterator<com.bytedance.sdk.component.Cc.EO> it2 = collectionEO.iterator();
                while (it2.hasNext()) {
                    InputStream inputStreamIlO = it2.next().IlO(str2);
                    if (inputStreamIlO != null) {
                        return inputStreamIlO;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.Cc.ea
    public boolean IlO(String str, String str2, String str3) {
        if (this.IlO == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = zPa.IlO(str);
        }
        com.bytedance.sdk.component.Cc.EO eoIlO = this.IlO.IlO(str3);
        if (eoIlO != null) {
            return eoIlO.MY(str2);
        }
        return false;
    }
}
