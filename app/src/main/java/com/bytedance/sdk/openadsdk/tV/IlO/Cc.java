package com.bytedance.sdk.openadsdk.tV.IlO;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc implements com.bytedance.sdk.openadsdk.multipro.IlO {
    private final com.bytedance.sdk.component.vCE.IlO.MY.MY.MY IlO;

    public Cc(com.bytedance.sdk.component.vCE.IlO.MY.MY.MY my) {
        this.IlO = my;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public String IlO() {
        com.bytedance.sdk.component.vCE.IlO.MY.MY.MY my = this.IlO;
        if (my != null) {
            return my.EO();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public String IlO(Uri uri) {
        com.bytedance.sdk.component.vCE.IlO.MY.MY.MY my = this.IlO;
        if (my != null) {
            return my.IlO(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public Cursor IlO(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.bytedance.sdk.component.vCE.IlO.MY.MY.MY my = this.IlO;
        if (my != null) {
            return my.IlO(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public Uri IlO(Uri uri, ContentValues contentValues) {
        com.bytedance.sdk.component.vCE.IlO.MY.MY.MY my = this.IlO;
        if (my != null) {
            return my.IlO(uri, contentValues);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public int IlO(Uri uri, String str, String[] strArr) {
        com.bytedance.sdk.component.vCE.IlO.MY.MY.MY my = this.IlO;
        if (my != null) {
            return my.IlO(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public int IlO(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        com.bytedance.sdk.component.vCE.IlO.MY.MY.MY my = this.IlO;
        if (my != null) {
            return my.IlO(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
