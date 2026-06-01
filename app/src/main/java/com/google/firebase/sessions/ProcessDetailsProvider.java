package com.google.firebase.sessions;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.google.android.gms.common.util.ProcessUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import r5.l;
import r5.n;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class ProcessDetailsProvider {
    public static final ProcessDetailsProvider INSTANCE = new ProcessDetailsProvider();

    private ProcessDetailsProvider() {
    }

    private final String getProcessName() throws Throwable {
        String processName;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 33) {
            String strMyProcessName = Process.myProcessName();
            k.d(strMyProcessName, "myProcessName(...)");
            return strMyProcessName;
        }
        if (i2 >= 28 && (processName = Application.getProcessName()) != null) {
            return processName;
        }
        String myProcessName = ProcessUtils.getMyProcessName();
        return myProcessName != null ? myProcessName : "";
    }

    public final List<ProcessDetails> getAppProcessDetails(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        k.e(context, "context");
        int i2 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            runningAppProcesses = r.f13638a;
        }
        ArrayList arrayListW0 = l.W0(runningAppProcesses);
        ArrayList arrayList = new ArrayList();
        int size = arrayListW0.size();
        int i8 = 0;
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayListW0.get(i9);
            i9++;
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i2) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(n.L0(arrayList, 10));
        int size2 = arrayList.size();
        while (i8 < size2) {
            Object obj2 = arrayList.get(i8);
            i8++;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj2;
            String processName = runningAppProcessInfo.processName;
            k.d(processName, "processName");
            arrayList2.add(new ProcessDetails(processName, runningAppProcessInfo.pid, runningAppProcessInfo.importance, k.a(runningAppProcessInfo.processName, str)));
        }
        return arrayList2;
    }

    public final ProcessDetails getMyProcessDetails(Context context) {
        Object next;
        k.e(context, "context");
        int iMyPid = Process.myPid();
        Iterator<T> it = getAppProcessDetails(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((ProcessDetails) next).getPid() == iMyPid) {
                break;
            }
        }
        ProcessDetails processDetails = (ProcessDetails) next;
        return processDetails == null ? new ProcessDetails(getProcessName(), iMyPid, 0, false) : processDetails;
    }
}
