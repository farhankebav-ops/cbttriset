package com.bytedance.sdk.component.vCE.IlO.MY.MY;

import a1.a;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.vCE.IlO.IlO.IlO.Bc;
import com.bytedance.sdk.component.vCE.IlO.lEW;
import com.bytedance.sdk.component.vCE.IlO.tV;
import com.bytedance.sdk.component.vCE.IlO.vCE;
import com.ironsource.sdk.controller.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static vCE IlO;

    public static void MY() {
        if (lEW.Bc().vCE() == null) {
            return;
        }
        try {
            vCE vceIlO = IlO(lEW.Bc().vCE());
            if (vceIlO != null) {
                vceIlO.IlO(Uri.parse(tV() + "adLogStop"));
            }
        } catch (Throwable unused) {
        }
    }

    private static String tV() {
        return a.r(new StringBuilder(), Bc.MY, "/ad_log_event/");
    }

    public String EO() {
        return "ad_log_event";
    }

    public int IlO(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public int IlO(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Cursor IlO(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public Uri IlO(Uri uri, ContentValues contentValues) {
        return null;
    }

    public static vCE IlO(Context context) {
        try {
            if (IlO == null) {
                IlO = lEW.Bc().zPa().EV();
            }
        } catch (Exception unused) {
        }
        return IlO;
    }

    public static void IlO() {
        if (lEW.Bc().vCE() == null) {
            return;
        }
        try {
            vCE vceIlO = IlO(lEW.Bc().vCE());
            if (vceIlO != null) {
                vceIlO.IlO(Uri.parse(tV() + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void IlO(com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO) {
        if (ilO == null) {
            return;
        }
        try {
            vCE vceIlO = IlO(lEW.Bc().vCE());
            if (vceIlO != null) {
                vceIlO.IlO(Uri.parse(tV() + "adLogDispatch?event=" + com.bytedance.sdk.component.vCE.IlO.IlO.IlO.vCE.IlO(ilO.vCE())));
            }
        } catch (Throwable th) {
            th.toString();
        }
    }

    public static void IlO(String str, List<String> list, boolean z2, int i2, String str2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(com.bytedance.sdk.component.vCE.IlO.IlO.IlO.vCE.IlO(it.next()));
                sb.append(",");
            }
            String str3 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(com.bytedance.sdk.component.vCE.IlO.IlO.IlO.vCE.IlO(sb.toString())) + "&replace=" + String.valueOf(z2) + "&urlType=" + String.valueOf(i2) + "&adId=" + str2;
            vCE vceIlO = IlO(lEW.Bc().vCE());
            if (vceIlO != null) {
                vceIlO.IlO(Uri.parse(tV() + "trackAdUrl" + str3));
            }
        } catch (Throwable unused) {
        }
    }

    public static void IlO(String str, boolean z2) {
        if (lEW.Bc().zPa().vCE() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        try {
            vCE vceIlO = IlO(lEW.Bc().vCE());
            if (vceIlO != null) {
                vceIlO.IlO(Uri.parse(tV() + "trackAdFailed?did=" + String.valueOf(str) + "&triggerOnInit=" + z2));
            }
        } catch (Throwable unused) {
        }
    }

    public String IlO(Uri uri) {
        int i2;
        com.bytedance.sdk.component.vCE.IlO.tV.IlO ilOEO;
        String str = uri.getPath().split("/")[2];
        str.getClass();
        i2 = 0;
        switch (str) {
            case "trackAdFailed":
                com.bytedance.sdk.component.vCE.IlO.vCE.IlO.IlO().IlO(uri.getQueryParameter("did"), uri.getBooleanQueryParameter("triggerOnInit", false));
                break;
            case "adLogStart":
                lEW.Bc().DmF();
                break;
            case "adLogStop":
                lEW.Bc().EV();
                break;
            case "adLogDispatch":
                String queryParameter = uri.getQueryParameter(NotificationCompat.CATEGORY_EVENT);
                if (!TextUtils.isEmpty(queryParameter) && (ilOEO = com.bytedance.sdk.component.vCE.IlO.tV.IlO.IlO.EO(com.bytedance.sdk.component.vCE.IlO.IlO.IlO.vCE.MY(queryParameter))) != null) {
                    tV.IlO.IlO(ilOEO);
                    break;
                }
                break;
            case "trackAdUrl":
                try {
                    String queryParameter2 = uri.getQueryParameter("did");
                    boolean zBooleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                    String queryParameter3 = uri.getQueryParameter("track");
                    String queryParameter4 = uri.getQueryParameter("urlType");
                    String queryParameter5 = uri.getQueryParameter(f.b.f9966c);
                    String[] strArrSplit = com.bytedance.sdk.component.vCE.IlO.IlO.IlO.vCE.MY(queryParameter3).split(",");
                    if (strArrSplit.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : strArrSplit) {
                            String strMY = com.bytedance.sdk.component.vCE.IlO.IlO.IlO.vCE.MY(str2);
                            if (!TextUtils.isEmpty(strMY)) {
                                arrayList.add(strMY);
                            }
                        }
                        try {
                            if (!TextUtils.isEmpty(queryParameter4)) {
                                i2 = Integer.parseInt(queryParameter4);
                            }
                            break;
                        } catch (Exception unused) {
                        }
                        com.bytedance.sdk.component.vCE.IlO.vCE.IlO.IlO().IlO(queryParameter2, arrayList, zBooleanValue, null, i2, queryParameter5);
                    }
                    break;
                } catch (Throwable unused2) {
                    return null;
                }
                break;
        }
        return null;
    }
}
