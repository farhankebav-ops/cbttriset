package com.bytedance.sdk.component.lEW;

import a1.a;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.ea;
import com.ironsource.C2300e4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private static AtomicInteger EO = new AtomicInteger(0);
    public static final String[] IlO = {"com.bytedance.sdk", "com.bykv.vk", "com.ss", "tt_pangle"};
    public static final String[] MY = {"tt_pangle", "bd_tracker"};
    private static int tV = 0;
    private static int Cc = 0;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public String EO;
        public int IlO;
        public String MY;
        public String tV;

        public IlO(String str, int i2, String str2, String str3) {
            this.EO = str;
            this.IlO = i2;
            this.tV = str2;
            this.MY = str3;
        }

        public void IlO(int i2) {
            this.IlO = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ThreadModel{times=");
            sb.append(this.IlO);
            sb.append(", name='");
            sb.append(this.MY);
            sb.append("', lastStackStack='");
            return a.r(sb, this.EO, "'}");
        }

        public int IlO() {
            return this.IlO;
        }
    }

    public static void IlO() {
        try {
            MY();
        } catch (Throwable unused) {
        }
    }

    private static void MY() {
        int i2;
        String str;
        EO eoDmF = vCE.DmF();
        if (eoDmF == null) {
            return;
        }
        int i8 = 1;
        int iAddAndGet = EO.addAndGet(1);
        int i9 = vCE.EO;
        if (i9 < 0 || iAddAndGet % i9 != 0 || Looper.getMainLooper() == Looper.myLooper()) {
            return;
        }
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        HashMap map = new HashMap();
        if (allStackTraces == null) {
            return;
        }
        boolean zIlO = ea.IlO();
        int size = allStackTraces.size();
        if (size > Cc) {
            Cc = size;
        }
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            Map.Entry<Thread, StackTraceElement[]> next = it.next();
            i11 += i8;
            Thread key = next.getKey();
            StackTraceElement[] value = next.getValue();
            StringBuilder sb = new StringBuilder("\n");
            if (zIlO) {
                sb.append("Thread Name is : " + key.getName());
                sb.append("\n");
            }
            int length = value.length;
            String str2 = null;
            int i12 = 0;
            while (i12 < length) {
                int i13 = i8;
                String string = value[i12].toString();
                Iterator<Map.Entry<Thread, StackTraceElement[]>> it2 = it;
                if (zIlO) {
                    sb.append(string + "\n");
                }
                if (TextUtils.isEmpty(str2)) {
                    if (IlO(string, IlO)) {
                        str = string;
                    } else {
                        str = string;
                        if (IlO(key.getName(), MY)) {
                        }
                    }
                    i10++;
                    str2 = str;
                }
                i12++;
                it = it2;
                i8 = i13;
            }
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it3 = it;
            int i14 = i8;
            if (zIlO) {
                if (TextUtils.isEmpty(str2)) {
                    i2 = i14;
                } else {
                    StringBuilder sbX = a.x(str2, C2300e4.i.f8401c);
                    sbX.append(key.getName());
                    String string2 = sbX.toString();
                    IlO ilO = (IlO) map.get(string2);
                    if (ilO != null) {
                        ilO.IlO(ilO.IlO() + 1);
                        i2 = i14;
                    } else {
                        String string3 = sb.toString();
                        String name = key.getName();
                        i2 = i14;
                        ilO = new IlO(string2, i2, string3, name);
                    }
                    map.put(string2, ilO);
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    Log.e("PoolTaskStatistics", "Thread index = " + i11 + "   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    Log.w("PoolTaskStatistics", sb.toString());
                }
            } else {
                i2 = i14;
            }
            i8 = i2;
            it = it3;
        }
        if (i10 > tV) {
            tV = i10;
        }
        if (zIlO) {
            StringBuilder sbV = a.v(i10, "SDK current threads=", ", SDK Max threads=");
            androidx.camera.core.processing.util.a.w(tV, size, ", Application threads = ", ", Application max threads = ", sbV);
            sbV.append(Cc);
            Log.e("PoolTaskStatistics", sbV.toString());
            Iterator it4 = map.entrySet().iterator();
            while (it4.hasNext()) {
                Log.i("PoolTaskStatistics", ((IlO) ((Map.Entry) it4.next()).getValue()).toString());
            }
        }
        eoDmF.IlO(new com.bytedance.sdk.component.lEW.MY.IlO(i10, tV, size, Cc));
    }

    private static boolean IlO(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
