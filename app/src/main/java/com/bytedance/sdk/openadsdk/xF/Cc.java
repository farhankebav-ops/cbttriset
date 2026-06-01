package com.bytedance.sdk.openadsdk.xF;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    public static int Bc = 1;
    protected static long Cc = 15360;
    public static int DmF = 4;
    protected static int EO = 1;
    public static int EV = 16;
    protected static String IlO = "images";
    protected static String MY = null;
    public static int NV = 8;
    public static int lEW = 2;
    public static int rp = 32;
    protected static int tV = 30;
    public static int vCE;

    public static boolean IlO(Context context, String str) {
        return false;
    }

    public static boolean MY(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }

    public static Bitmap IlO(String str) {
        byte[] bArrDecode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    public static float MY(Context context) {
        if (context == null) {
            return 0.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static boolean IlO(Context context, int i2) {
        boolean zIlO;
        boolean zIlO2;
        if (vCE == 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                zIlO = IlO(context, "android.permission.READ_MEDIA_IMAGES");
                zIlO2 = true;
            } else {
                zIlO = IlO(context, "android.permission.READ_EXTERNAL_STORAGE");
                zIlO2 = IlO(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            boolean zIlO3 = IlO(context, "android.permission.CAMERA");
            boolean zIlO4 = IlO(context, "android.permission.RECORD_AUDIO");
            PackageManager packageManager = context.getPackageManager();
            if (zIlO && zIlO2) {
                vCE |= Bc;
            }
            if (zIlO3 && packageManager.hasSystemFeature("android.hardware.camera")) {
                vCE |= lEW;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
                vCE |= DmF;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                vCE |= NV;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                vCE |= EV;
            }
            if (zIlO4 && packageManager.hasSystemFeature("android.hardware.microphone")) {
                vCE |= rp;
            }
        }
        return (vCE & i2) != 0;
    }

    public static boolean IlO(Context context) {
        boolean z2;
        boolean z7;
        if (Build.VERSION.SDK_INT >= 33) {
            z2 = context.checkSelfPermission("android.permission.READ_MEDIA_IMAGES") == 0;
        } else {
            z2 = context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
            if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                z7 = false;
            }
            return !z7 && z2;
        }
        z7 = true;
        if (z7) {
        }
    }
}
