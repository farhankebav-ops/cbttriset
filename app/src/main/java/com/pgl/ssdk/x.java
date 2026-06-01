package com.pgl.ssdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.camera2.CameraManager;
import android.telephony.TelephonyManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f10827a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f10828b = -1;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            x.f10828b = x.b(z.b());
            SharedPreferences sharedPreferencesA = w0.a(z.b());
            if (sharedPreferencesA != null) {
                sharedPreferencesA.edit().putInt("camera_count", x.f10828b).apply();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Context context) {
        int i2 = f10828b;
        if (i2 != -1) {
            return i2;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager != null) {
            try {
                f10828b = cameraManager.getCameraIdList().length;
            } catch (Throwable unused) {
                f10828b = -1;
            }
        } else {
            f10828b = -2;
        }
        return f10828b;
    }

    public static int c(Context context) {
        TelephonyManager telephonyManager;
        if (f10827a == -1 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            f10827a = telephonyManager.getSimState();
        }
        return f10827a;
    }

    public static int a() {
        int i2;
        int i8 = f10828b;
        if (i8 != -1) {
            return i8;
        }
        SharedPreferences sharedPreferencesA = w0.a(z.b());
        if (sharedPreferencesA == null || (i2 = sharedPreferencesA.getInt("camera_count", -1)) == -1) {
            q0.b(new a());
            return -1;
        }
        f10828b = i2;
        return i2;
    }
}
