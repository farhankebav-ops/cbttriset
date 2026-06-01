package androidx.collection;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class ArraySetJvmUtil {
    private ArraySetJvmUtil() {
    }

    public static <T> T[] resizeForToArray(T[] tArr, int i2) {
        if (tArr.length < i2) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2));
        }
        if (tArr.length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }
}
