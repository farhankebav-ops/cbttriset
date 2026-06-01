package com.bytedance.sdk.openadsdk.multipro.EO;

import a1.a;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.vCE.IlO.vCE;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.multipro.tV;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements com.bytedance.sdk.openadsdk.multipro.IlO {
    private static String Cc() {
        return a.r(new StringBuilder(), tV.MY, "/t_frequent/");
    }

    public static String EO() {
        if (cl.IlO() == null) {
            return null;
        }
        try {
            vCE vceTV = tV();
            if (vceTV != null) {
                return vceTV.IlO(Uri.parse(Cc() + "maxRit"));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean MY() {
        if (cl.IlO() == null) {
            return false;
        }
        try {
            vCE vceTV = tV();
            if (vceTV != null) {
                return com.ironsource.mediationsdk.metadata.a.g.equals(vceTV.IlO(Uri.parse(Cc() + "isSilent")));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static vCE tV() {
        try {
            if (cl.IlO() != null) {
                return com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(cl.IlO());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public int IlO(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public int IlO(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public Cursor IlO(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public Uri IlO(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    public static boolean IlO(String str) {
        if (cl.IlO() == null) {
            return false;
        }
        try {
            vCE vceTV = tV();
            if (vceTV != null) {
                return com.ironsource.mediationsdk.metadata.a.g.equals(vceTV.IlO(Uri.parse(Cc() + "checkFrequency?rit=" + str)));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    @NonNull
    public String IlO() {
        return "t_frequent";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.IlO
    public String IlO(@NonNull Uri uri) {
        Objects.toString(uri);
        String str = uri.getPath().split("/")[2];
        if ("checkFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.Bc.IlO.IlO().IlO(uri.getQueryParameter("rit")) ? com.ironsource.mediationsdk.metadata.a.g : "false";
        }
        if ("isSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.Bc.IlO.IlO().MY() ? com.ironsource.mediationsdk.metadata.a.g : "false";
        }
        if ("maxRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.Bc.IlO.IlO().EO();
        }
        return null;
    }
}
