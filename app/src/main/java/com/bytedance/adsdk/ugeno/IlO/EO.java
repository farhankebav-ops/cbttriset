package com.bytedance.adsdk.ugeno.IlO;

import android.text.TextUtils;
import android.util.Pair;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.adsdk.ugeno.IlO.MY;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    public static float[] EO(String str) {
        float[] fArr = {0.0f, 0.0f};
        JSONArray jSONArrayIlO = com.bytedance.adsdk.ugeno.Bc.MY.IlO(str, (JSONArray) null);
        if (jSONArrayIlO != null && jSONArrayIlO.length() == 2) {
            fArr[0] = (float) jSONArrayIlO.optDouble(0);
            fArr[1] = (float) jSONArrayIlO.optDouble(1);
        }
        return fArr;
    }

    public static int IlO(int i2) {
        if (i2 < 0) {
            return -1;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2 - 1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Interpolator MY(String str) {
        switch (str.hashCode()) {
            case -1965072618:
                if (str.equals("ease_in")) {
                    return new AccelerateInterpolator();
                }
                break;
            case -1102672091:
                str.equals("linear");
                break;
            case -787702915:
                if (str.equals("ease_out")) {
                    return new DecelerateInterpolator();
                }
                break;
            case 1065009829:
                if (str.equals("ease_in_out")) {
                    return new AccelerateDecelerateInterpolator();
                }
                break;
        }
        return new LinearInterpolator();
    }

    public static MY.IlO tV(String str) {
        JSONArray jSONArrayIlO;
        if (TextUtils.isEmpty(str) || (jSONArrayIlO = com.bytedance.adsdk.ugeno.Bc.MY.IlO(str, (JSONArray) null)) == null || jSONArrayIlO.length() != 2) {
            return null;
        }
        MY.IlO ilO = new MY.IlO();
        ilO.IlO = jSONArrayIlO.optString(0);
        ilO.MY = jSONArrayIlO.optString(1);
        return ilO;
    }

    public static MY IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        MY my = new MY();
        my.MY(jSONObject.optLong("delay"));
        my.IlO(jSONObject.optLong("duration"));
        my.IlO(jSONObject.optInt("playCount", 1));
        my.IlO(jSONObject.optString("playDirection"));
        my.IlO(tV(jSONObject.optString("transformOrigin")));
        my.MY(jSONObject.optString("timingFunction", "linear"));
        my.IlO(jSONObject.optJSONObject("effect"));
        my.IlO(IlO(jSONObject.optJSONArray("keyframes")));
        return my;
    }

    public static Map<String, TreeMap<Float, String>> IlO(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                float fOptDouble = (float) jSONObjectOptJSONObject.optDouble(TypedValues.CycleType.S_WAVE_OFFSET);
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    TreeMap treeMap = (TreeMap) map.get(next);
                    if (!TextUtils.equals(next, TypedValues.CycleType.S_WAVE_OFFSET)) {
                        if (map.containsKey(next) && treeMap != null) {
                            treeMap.put(Float.valueOf(fOptDouble), jSONObjectOptJSONObject.optString(next));
                        } else {
                            TreeMap treeMap2 = new TreeMap();
                            new Pair(Float.valueOf(fOptDouble), jSONObjectOptJSONObject.optString(next));
                            treeMap2.put(Float.valueOf(fOptDouble), jSONObjectOptJSONObject.optString(next));
                            map.put(next, treeMap2);
                        }
                    }
                }
            }
        }
        return map;
    }

    public static int IlO(String str) {
        int iHashCode = str.hashCode();
        if (iHashCode == -1408024454) {
            return str.equals("alternate") ? 2 : 1;
        }
        if (iHashCode != -1039745817) {
            return 1;
        }
        str.equals("normal");
        return 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int IlO(String str, int i2) {
        int i8 = i2 / 2;
        if (!TextUtils.isEmpty(str)) {
            str.getClass();
            switch (str) {
                case "bottom":
                case "right":
                    return i2;
                case "center":
                    break;
                case "top":
                case "left":
                    return 0;
                default:
                    if (str.endsWith("%")) {
                        try {
                            return (int) ((i2 * Float.parseFloat(str.substring(0, str.length() - 1))) / 100.0f);
                        } catch (NumberFormatException unused) {
                        }
                        break;
                    } else {
                        try {
                            return Integer.parseInt(str);
                        } catch (NumberFormatException unused2) {
                            return i8;
                        }
                    }
                    break;
            }
        }
        return i8;
    }
}
