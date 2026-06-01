package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc implements IlO {
    private static final List<IlO> EO;
    private static volatile Cc IlO;
    private static WeakReference<Context> MY;

    static {
        List<IlO> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        EO = listSynchronizedList;
        listSynchronizedList.add(new com.bytedance.sdk.openadsdk.multipro.tV.EO());
        listSynchronizedList.add(new com.bytedance.sdk.openadsdk.multipro.IlO.MY());
        listSynchronizedList.add(new com.bytedance.sdk.openadsdk.multipro.EO.IlO());
        listSynchronizedList.add(new com.bytedance.sdk.openadsdk.tV.IlO.Cc(new com.bytedance.sdk.component.vCE.IlO.MY.MY.MY()));
        Iterator<IlO> it = listSynchronizedList.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private Cc() {
    }

    private boolean EO(Uri uri) {
        return true;
    }

    public static Cc IlO(Context context) {
        if (context != null) {
            MY = new WeakReference<>(context.getApplicationContext());
        }
        if (IlO == null) {
            synchronized (Cc.class) {
                try {
                    if (IlO == null) {
                        IlO = new Cc();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    private IlO MY(Uri uri) {
        if (uri == null || !EO(uri)) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split("/");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (IlO ilO : EO) {
            if (str.equals(ilO.IlO())) {
                return ilO;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    @NonNull
    public String IlO() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public Cursor IlO(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        try {
            IlO ilOMY = MY(uri);
            if (ilOMY != null) {
                return ilOMY.IlO(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public String IlO(@NonNull Uri uri) {
        try {
            IlO ilOMY = MY(uri);
            if (ilOMY != null) {
                return ilOMY.IlO(uri);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public Uri IlO(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        try {
            IlO ilOMY = MY(uri);
            if (ilOMY != null) {
                return ilOMY.IlO(uri, contentValues);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public int IlO(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        try {
            IlO ilOMY = MY(uri);
            if (ilOMY != null) {
                return ilOMY.IlO(uri, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public int IlO(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        try {
            IlO ilOMY = MY(uri);
            if (ilOMY != null) {
                return ilOMY.IlO(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
