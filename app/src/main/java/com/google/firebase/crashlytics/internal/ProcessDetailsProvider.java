package com.google.firebase.crashlytics.internal;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
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

    public static /* synthetic */ CrashlyticsReport.Session.Event.Application.ProcessDetails buildProcessDetails$default(ProcessDetailsProvider processDetailsProvider, String str, int i2, int i8, boolean z2, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i2 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = 0;
        }
        if ((i9 & 8) != 0) {
            z2 = false;
        }
        return processDetailsProvider.buildProcessDetails(str, i2, i8, z2);
    }

    private final String getProcessName() {
        String processName;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 33) {
            return (i2 < 28 || (processName = Application.getProcessName()) == null) ? "" : processName;
        }
        String strMyProcessName = Process.myProcessName();
        k.b(strMyProcessName);
        return strMyProcessName;
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails buildProcessDetails(String processName) {
        k.e(processName, "processName");
        return buildProcessDetails$default(this, processName, 0, 0, false, 14, null);
    }

    public final List<CrashlyticsReport.Session.Event.Application.ProcessDetails> getAppProcessDetails(Context context) {
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
            arrayList2.add(CrashlyticsReport.Session.Event.Application.ProcessDetails.builder().setProcessName(runningAppProcessInfo.processName).setPid(runningAppProcessInfo.pid).setImportance(runningAppProcessInfo.importance).setDefaultProcess(k.a(runningAppProcessInfo.processName, str)).build());
        }
        return arrayList2;
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails getCurrentProcessDetails(Context context) {
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
            if (((CrashlyticsReport.Session.Event.Application.ProcessDetails) next).getPid() == iMyPid) {
                break;
            }
        }
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = (CrashlyticsReport.Session.Event.Application.ProcessDetails) next;
        return processDetails == null ? buildProcessDetails$default(this, getProcessName(), iMyPid, 0, false, 12, null) : processDetails;
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails buildProcessDetails(String processName, int i2) {
        k.e(processName, "processName");
        return buildProcessDetails$default(this, processName, i2, 0, false, 12, null);
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails buildProcessDetails(String processName, int i2, int i8) {
        k.e(processName, "processName");
        return buildProcessDetails$default(this, processName, i2, i8, false, 8, null);
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails buildProcessDetails(String processName, int i2, int i8, boolean z2) {
        k.e(processName, "processName");
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetailsBuild = CrashlyticsReport.Session.Event.Application.ProcessDetails.builder().setProcessName(processName).setPid(i2).setImportance(i8).setDefaultProcess(z2).build();
        k.d(processDetailsBuild, "build(...)");
        return processDetailsBuild;
    }
}
