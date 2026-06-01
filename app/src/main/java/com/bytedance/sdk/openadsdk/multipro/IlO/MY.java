package com.bytedance.sdk.openadsdk.multipro.IlO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.Cc;
import com.bytedance.sdk.openadsdk.core.cl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements com.bytedance.sdk.openadsdk.multipro.IlO {
    private static final Object MY = new Object();
    private Context IlO;

    private boolean MY(Uri uri) {
        return uri == null || TextUtils.isEmpty(uri.getPath());
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    @NonNull
    public String IlO() {
        return "t_db";
    }

    private Context MY() {
        Context context = this.IlO;
        return context == null ? cl.IlO() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public Cursor IlO(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        synchronized (MY) {
            try {
                if (MY(uri)) {
                    return null;
                }
                String[] strArrSplit = uri.getPath().split("/");
                if (strArrSplit != null && strArrSplit.length >= 4) {
                    String str3 = strArrSplit[2];
                    String str4 = strArrSplit[3];
                    if (!"ttopensdk.db".equals(str3)) {
                        return null;
                    }
                    return Cc.IlO(MY()).IlO().IlO(str4, strArr, str, strArr2, null, null, str2);
                }
                return null;
            } finally {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public String IlO(@NonNull Uri uri) {
        synchronized (MY) {
            try {
                if (MY(uri)) {
                    return null;
                }
                String[] strArrSplit = uri.getPath().split("/");
                if (strArrSplit != null && strArrSplit.length >= 5) {
                    String str = strArrSplit[2];
                    String str2 = strArrSplit[4];
                    if ("ttopensdk.db".equals(str)) {
                        if ("execSQL".equals(str2)) {
                            String queryParameter = uri.getQueryParameter("sql");
                            if (!TextUtils.isEmpty(queryParameter)) {
                                Cc.IlO(MY()).IlO().IlO(Uri.decode(queryParameter));
                            }
                        } else if ("transactionBegin".equals(str2)) {
                            Cc.IlO(MY()).IlO().MY();
                        } else if ("transactionSetSuccess".equals(str2)) {
                            Cc.IlO(MY()).IlO().EO();
                        } else if ("transactionEnd".equals(str2)) {
                            Cc.IlO(MY()).IlO().tV();
                        }
                    }
                    return null;
                }
                return null;
            } finally {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public Uri IlO(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        synchronized (MY) {
            try {
                if (MY(uri)) {
                    return null;
                }
                String[] strArrSplit = uri.getPath().split("/");
                if (strArrSplit != null && strArrSplit.length >= 4) {
                    String str = strArrSplit[2];
                    String str2 = strArrSplit[3];
                    if ("ttopensdk.db".equals(str)) {
                        Cc.IlO(MY()).IlO().IlO(str2, (String) null, contentValues);
                    }
                    return null;
                }
                return null;
            } finally {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public int IlO(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        synchronized (MY) {
            try {
                if (MY(uri)) {
                    return 0;
                }
                String[] strArrSplit = uri.getPath().split("/");
                if (strArrSplit != null && strArrSplit.length >= 4) {
                    String str2 = strArrSplit[2];
                    String str3 = strArrSplit[3];
                    if (!"ttopensdk.db".equals(str2)) {
                        return 0;
                    }
                    return Cc.IlO(MY()).IlO().IlO(str3, str, strArr);
                }
                return 0;
            } finally {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public int IlO(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        synchronized (MY) {
            try {
                if (MY(uri)) {
                    return 0;
                }
                String[] strArrSplit = uri.getPath().split("/");
                if (strArrSplit != null && strArrSplit.length >= 4) {
                    String str2 = strArrSplit[2];
                    String str3 = strArrSplit[3];
                    if (!"ttopensdk.db".equals(str2)) {
                        return 0;
                    }
                    return Cc.IlO(MY()).IlO().IlO(str3, contentValues, str, strArr);
                }
                return 0;
            } finally {
            }
        }
    }
}
