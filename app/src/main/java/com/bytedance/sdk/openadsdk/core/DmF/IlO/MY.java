package com.bytedance.sdk.openadsdk.core.DmF.IlO;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.util.ArrayMap;
import androidx.core.app.NotificationCompat;
import com.ironsource.C2300e4;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private static volatile MY IlO;
    private final ArrayList<String> MY = new ArrayList<>();
    private final AtomicBoolean EO = new AtomicBoolean(false);
    private long tV = System.currentTimeMillis();
    private long Cc = 0;
    private long vCE = 0;
    private String Bc = "";
    private String lEW = "";
    private String DmF = "";
    private boolean NV = false;
    private boolean EV = false;

    public static MY IlO(Application application) {
        if (IlO == null) {
            synchronized (MY.class) {
                try {
                    if (IlO == null) {
                        MY my = new MY();
                        IlO = my;
                        my.NV = IlO((Context) application);
                        IlO.EV = IlO(application.getApplicationContext(), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                        IlO.IlO();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public void MY(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.MY.contains(localClassName)) {
            this.MY.remove(localClassName);
        }
        if (this.MY.size() == 0) {
            this.tV = System.currentTimeMillis();
            this.EO.set(true);
            this.lEW = localClassName;
        }
    }

    private static int IlO(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static boolean IlO(Context context) {
        ApplicationInfo applicationInfo;
        return (context == null || (applicationInfo = context.getApplicationInfo()) == null || (applicationInfo.flags & 1) <= 0) ? false : true;
    }

    public void IlO(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.MY.size() == 0) {
            this.Bc = localClassName;
            this.Cc = System.currentTimeMillis();
            this.vCE = System.currentTimeMillis() - this.tV;
            this.EO.set(false);
        }
        if (!this.MY.contains(localClassName)) {
            this.MY.add(localClassName);
        }
        if (localClassName.contains("com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity") || localClassName.contains("com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity")) {
            return;
        }
        this.DmF = localClassName;
    }

    private void IlO() {
        int size;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", null);
            boolean z2 = true;
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, null);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap != null && (size = arrayMap.size()) > 0) {
                Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
                Field declaredField2 = cls2.getDeclaredField(C2300e4.h.h0);
                declaredField2.setAccessible(true);
                Field declaredField3 = cls2.getDeclaredField("activity");
                declaredField3.setAccessible(true);
                for (int i2 = 0; i2 < size; i2++) {
                    Object objValueAt = arrayMap.valueAt(i2);
                    if (!((Boolean) declaredField2.get(objValueAt)).booleanValue()) {
                        String localClassName = ((Activity) declaredField3.get(objValueAt)).getLocalClassName();
                        if (!this.MY.contains(localClassName)) {
                            this.MY.add(localClassName);
                        }
                    }
                }
                AtomicBoolean atomicBoolean = this.EO;
                if (this.MY.size() > 0) {
                    z2 = false;
                }
                atomicBoolean.set(z2);
            }
        } catch (Throwable unused) {
        }
    }

    public String IlO(String str, long j, int i2) {
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j3 = jCurrentTimeMillis - this.Cc;
        long j8 = jCurrentTimeMillis - j;
        int i8 = j8 < 500 ? 1 : 0;
        if (this.EO.get() && this.EV) {
            i8 |= 2;
        }
        if (!this.EO.get() && this.vCE >= 5000 && j3 < 1000) {
            i8 = this.lEW.equals(this.DmF) ? i8 | 4 : i8 | 8;
        }
        try {
            string = new JSONObject().put("rst", i8).put("adtag", str).put("bakdur", this.vCE).put("rit", i2).put("poptime", j3).put("unlocktime", j8).put("bakground", this.EO).put("alert", this.EV).put(NotificationCompat.CATEGORY_SYSTEM, this.NV).put("actsize", this.MY.size()).put("mutiproc", com.bytedance.sdk.openadsdk.multipro.MY.EO()).toString();
        } catch (JSONException unused) {
            string = "";
        }
        this.Bc = "";
        this.vCE = 0L;
        this.Cc = 0L;
        this.tV = System.currentTimeMillis();
        return string;
    }
}
