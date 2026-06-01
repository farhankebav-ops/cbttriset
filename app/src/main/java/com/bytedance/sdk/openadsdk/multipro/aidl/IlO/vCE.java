package com.bytedance.sdk.openadsdk.multipro.aidl.IlO;

import android.content.ContentValues;
import android.net.Uri;
import com.bytedance.sdk.component.vCE.IlO.vCE;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.settings.DmF;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends vCE.IlO {
    private static volatile vCE IlO;

    public static vCE MY() {
        if (IlO == null) {
            synchronized (vCE.class) {
                try {
                    if (IlO == null) {
                        IlO = new vCE();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.vCE
    public Map IlO(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!DmF.IlO()) {
            return null;
        }
        try {
            return com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(com.bytedance.sdk.openadsdk.multipro.Cc.IlO(cl.IlO()).IlO(uri, strArr, str, strArr2, str2));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.vCE
    public String IlO(Uri uri) {
        if (DmF.IlO()) {
            return com.bytedance.sdk.openadsdk.multipro.Cc.IlO(cl.IlO()).IlO(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.vCE
    public String IlO(Uri uri, ContentValues contentValues) {
        Uri uriIlO;
        if (DmF.IlO() && (uriIlO = com.bytedance.sdk.openadsdk.multipro.Cc.IlO(cl.IlO()).IlO(uri, contentValues)) != null) {
            return uriIlO.toString();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.vCE
    public int IlO(Uri uri, String str, String[] strArr) {
        if (DmF.IlO()) {
            return com.bytedance.sdk.openadsdk.multipro.Cc.IlO(cl.IlO()).IlO(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.vCE
    public int IlO(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (DmF.IlO()) {
            return com.bytedance.sdk.openadsdk.multipro.Cc.IlO(cl.IlO()).IlO(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
