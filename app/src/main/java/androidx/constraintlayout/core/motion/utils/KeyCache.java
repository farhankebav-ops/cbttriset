package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class KeyCache {
    HashMap<Object, HashMap<String, float[]>> mMap = new HashMap<>();

    public float getFloatValue(Object obj, String str, int i2) {
        HashMap<String, float[]> map;
        float[] fArr;
        if (this.mMap.containsKey(obj) && (map = this.mMap.get(obj)) != null && map.containsKey(str) && (fArr = map.get(str)) != null && fArr.length > i2) {
            return fArr[i2];
        }
        return Float.NaN;
    }

    public void setFloatValue(Object obj, String str, int i2, float f4) {
        if (!this.mMap.containsKey(obj)) {
            HashMap<String, float[]> map = new HashMap<>();
            float[] fArr = new float[i2 + 1];
            fArr[i2] = f4;
            map.put(str, fArr);
            this.mMap.put(obj, map);
            return;
        }
        HashMap<String, float[]> map2 = this.mMap.get(obj);
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        if (!map2.containsKey(str)) {
            float[] fArr2 = new float[i2 + 1];
            fArr2[i2] = f4;
            map2.put(str, fArr2);
            this.mMap.put(obj, map2);
            return;
        }
        float[] fArrCopyOf = map2.get(str);
        if (fArrCopyOf == null) {
            fArrCopyOf = new float[0];
        }
        if (fArrCopyOf.length <= i2) {
            fArrCopyOf = Arrays.copyOf(fArrCopyOf, i2 + 1);
        }
        fArrCopyOf[i2] = f4;
        map2.put(str, fArrCopyOf);
    }
}
