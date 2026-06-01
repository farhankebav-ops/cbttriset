package com.bytedance.adsdk.ugeno.Bc;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.ViewCompat;
import com.ironsource.C2300e4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.Bc.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0026IlO {
        public float[] EO;
        public GradientDrawable.Orientation IlO;
        public int[] MY;
    }

    public static boolean EO(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("linear-gradient");
    }

    public static int IlO(String str) {
        return IlO(str, ViewCompat.MEASURED_STATE_MASK);
    }

    public static C0026IlO MY(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String strSubstring = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")"));
            if (TextUtils.isEmpty(strSubstring)) {
                return null;
            }
            int iIlO = IlO(strSubstring, '%');
            int iIndexOf = strSubstring.indexOf(",");
            String strSubstring2 = strSubstring.substring(0, iIndexOf);
            C0026IlO c0026IlO = new C0026IlO();
            c0026IlO.IlO = tV(strSubstring2);
            String strSubstring3 = strSubstring.substring(iIndexOf + 1);
            int[] iArr = new int[iIlO];
            float[] fArr = new float[iIlO];
            for (int i2 = 0; i2 < iIlO; i2++) {
                int iIndexOf2 = strSubstring3.indexOf("%");
                String strTrim = strSubstring3.substring(0, iIndexOf2 + 1).trim();
                int iIndexOf3 = (strTrim.contains("rgba") ? strTrim.indexOf(")") : strTrim.indexOf(" ")) + 1;
                iArr[i2] = IlO(strTrim.substring(0, iIndexOf3).trim());
                fArr[i2] = EO.IlO(strTrim.substring(iIndexOf3, strTrim.indexOf("%")).trim(), 0.0f) / 100.0f;
                int i8 = iIndexOf2 + 2;
                if (strSubstring3.length() <= i8) {
                    break;
                }
                strSubstring3 = strSubstring3.substring(i8);
            }
            if (iIlO < 2) {
                return null;
            }
            c0026IlO.MY = iArr;
            c0026IlO.EO = fArr;
            return c0026IlO;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static GradientDrawable.Orientation tV(String str) {
        try {
            int i2 = str.contains("deg") ? Integer.parseInt(str.substring(0, str.length() - 3).trim()) : Integer.parseInt(str);
            return i2 == 90 ? GradientDrawable.Orientation.LEFT_RIGHT : i2 == 180 ? GradientDrawable.Orientation.TOP_BOTTOM : i2 == 270 ? GradientDrawable.Orientation.RIGHT_LEFT : i2 == 135 ? GradientDrawable.Orientation.TL_BR : i2 == 45 ? GradientDrawable.Orientation.BL_TR : GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    public static int IlO(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(C2300e4.h.T)) {
                return 0;
            }
            if (str.charAt(0) == '#' && str.length() == 4) {
                StringBuilder sb = new StringBuilder("#");
                char[] charArray = str.toCharArray();
                for (int i8 = 1; i8 < charArray.length; i8++) {
                    sb.append(charArray[i8]);
                    sb.append(charArray[i8]);
                }
                return Color.parseColor(sb.toString());
            }
            if (str.charAt(0) == '#' && str.length() == 7) {
                return Color.parseColor(str);
            }
            if (str.charAt(0) == '#' && str.length() == 9) {
                return Color.parseColor(str);
            }
            if (!str.startsWith("rgba")) {
                return ViewCompat.MEASURED_STATE_MASK;
            }
            String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
            if (strArrSplit != null && strArrSplit.length == 4) {
                return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2]));
            }
        }
        return i2;
    }

    public static int IlO(String str, char c7) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i2 = 0;
        for (int i8 = 0; i8 < str.length(); i8++) {
            if (str.charAt(i8) == c7) {
                i2++;
            }
        }
        return i2;
    }

    public static int IlO(int i2, int i8) {
        if (i8 < 0 || i8 > 255) {
            Log.e("ColorUtils", "alpha must be between 0 and 255. ");
            i8 = 255;
        }
        return (i2 & ViewCompat.MEASURED_SIZE_MASK) | (i8 << 24);
    }
}
