package com.pgl.ssdk;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class i0 {
    public static String a(String str) {
        String[] strArrB = b(str);
        ArrayList arrayList = new ArrayList();
        if (strArrB != null && strArrB.length > 0) {
            for (String str2 : strArrB) {
                try {
                    Class.forName(str2);
                    arrayList.add(str2);
                } catch (ClassNotFoundException unused) {
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    public static String[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("//");
    }
}
