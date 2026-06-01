package com.pgl.ssdk;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile DisplayManager.DisplayListener f10709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f10710b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f10711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f10712d;
    private static String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static DisplayManager f10713f;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a implements DisplayManager.DisplayListener {
        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i2) {
            a0.b(i2, 1);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i2) {
            a0.b(i2, 3);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i2) {
            a0.b(i2, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i2, int i8) {
        if (i2 == 0) {
            return;
        }
        try {
            String strA = a(i2);
            if (i8 == 1) {
                if (strA.equals(f10711c)) {
                    return;
                }
                f10711c = strA;
            } else if (i8 == 2) {
                if (strA.equals(f10712d)) {
                    return;
                }
                f10712d = strA;
            } else {
                if (i8 != 3 || strA.equals(e)) {
                    return;
                }
                e = strA;
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context) {
        Handler handlerB;
        if (f10710b) {
            return;
        }
        f10710b = true;
        if (f10709a == null) {
            f10709a = new a();
        }
        if (f10713f == null) {
            f10713f = (DisplayManager) context.getSystemService("display");
        }
        if (f10713f == null || (handlerB = q0.b()) == null) {
            return;
        }
        try {
            f10713f.registerDisplayListener(f10709a, handlerB);
        } catch (Exception unused) {
        }
    }

    private static String a(Display display) {
        String name = display.getName();
        Object objA = u0.a(display, display.getClass(), "getType", new Class[0], new Object[0]);
        Object objA2 = u0.a(display, display.getClass(), "getOwnerPackageName", new Class[0], new Object[0]);
        Object objA3 = u0.a(null, display.getClass(), "TYPE_VIRTUAL", null);
        return String.format("%s#%s#%b", objA2, name, Boolean.valueOf((objA == null || objA3 == null || ((Integer) objA).intValue() != ((Integer) objA3).intValue()) ? false : true));
    }

    public static boolean b(Context context) {
        if (f10711c == null && f10712d == null && e == null) {
            return (context == null || TextUtils.isEmpty(a(context))) ? false : true;
        }
        return true;
    }

    private static String a(int i2) {
        Display display = f10713f.getDisplay(i2);
        return display != null ? a(display) : "pd";
    }

    public static String a(Context context) {
        Display[] displays;
        if (f10713f == null) {
            f10713f = (DisplayManager) context.getSystemService("display");
        }
        DisplayManager displayManager = f10713f;
        if (displayManager == null || (displays = displayManager.getDisplays()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < displays.length; i2++) {
            Display display = displays[i2];
            if (display != null && display.getDisplayId() != 0) {
                stringBuffer.append(a(displays[i2]));
                if (i2 != displays.length - 1) {
                    stringBuffer.append(",");
                }
            }
        }
        return stringBuffer.toString();
    }
}
