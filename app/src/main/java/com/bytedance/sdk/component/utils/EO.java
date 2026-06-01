package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private static HashMap<String, ArrayList<String>> IlO = new HashMap<>();

    public static ArrayList<String> IlO(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (IlO.get(str) != null) {
                return IlO.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : MY(context, packageName)) {
                    String strIlO = "error!";
                    if ("MD5".equals(str)) {
                        strIlO = IlO(signature, "MD5");
                    } else if ("SHA1".equals(str)) {
                        strIlO = IlO(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        strIlO = IlO(signature, "SHA256");
                    }
                    arrayList.add(strIlO);
                }
            } catch (Exception unused) {
            }
            IlO.put(str, arrayList);
        }
        return arrayList;
    }

    private static Signature[] MY(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String IlO(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayListIlO = IlO(context, "SHA1");
        if (arrayListIlO != null && arrayListIlO.size() != 0) {
            for (int i2 = 0; i2 < arrayListIlO.size(); i2++) {
                sb.append(arrayListIlO.get(i2));
                if (i2 < arrayListIlO.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static String IlO(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest != null) {
                byte[] bArrDigest = messageDigest.digest(byteArray);
                StringBuilder sb = new StringBuilder();
                for (byte b8 : bArrDigest) {
                    sb.append(Integer.toHexString((b8 & 255) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                return sb.substring(0, sb.length() - 1).toString();
            }
            return "error!";
        } catch (Exception unused) {
            return "error!";
        }
    }
}
