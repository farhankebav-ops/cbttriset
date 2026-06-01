package com.pgl.ssdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.input.InputManager;
import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f10829a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f10830b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f10831c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f10832d = 0;
    private static int e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f10833f = 0;
    private static boolean g = false;
    private static InputManager h;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f10834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f10835b;

        public a(Context context, int i2) {
            this.f10834a = context;
            this.f10835b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            InputManager inputManagerB = y.b(this.f10834a);
            if (inputManagerB == null) {
                return;
            }
            InputDevice inputDevice = inputManagerB.getInputDevice(this.f10835b);
            y.h();
            if (inputDevice == null) {
                y.b();
                y.c();
                y.c("nihc");
            } else if (inputDevice.isVirtual()) {
                y.d();
                y.e();
                y.c("vihc");
            } else {
                if (Build.VERSION.SDK_INT < 29 || !inputDevice.isExternal()) {
                    return;
                }
                y.f();
                y.g();
                y.c("eihc");
            }
        }
    }

    public static /* synthetic */ int b() {
        int i2 = f10831c;
        f10831c = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c() {
        int i2 = f10833f;
        f10833f = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int d() {
        int i2 = f10829a;
        f10829a = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int e() {
        int i2 = f10832d;
        f10832d = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int f() {
        int i2 = f10830b;
        f10830b = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int g() {
        int i2 = e;
        e = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        if (g) {
            return;
        }
        try {
            SharedPreferences sharedPreferencesA = w0.a(z.b());
            if (sharedPreferencesA != null) {
                f10833f = sharedPreferencesA.getInt("nihc", 0);
                e = sharedPreferencesA.getInt("eihc", 0);
                f10832d = sharedPreferencesA.getInt("vihc", 0);
                g = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static int b(String str) {
        h();
        str.getClass();
        switch (str) {
            case "eic":
                return f10830b;
            case "nic":
                return f10831c;
            case "vic":
                return f10829a;
            case "eihc":
                return e;
            case "nihc":
                return f10833f;
            case "vihc":
                return f10832d;
            default:
                return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str) {
        try {
            SharedPreferences sharedPreferencesA = w0.a(z.b());
            if (sharedPreferencesA != null) {
                sharedPreferencesA.edit().putInt(str, sharedPreferencesA.getInt(str, 0) + 1).apply();
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(MotionEvent motionEvent, Context context) {
        if (motionEvent == null || context == null) {
            return;
        }
        if (motionEvent.getRawX() > 0.0f || motionEvent.getRawY() > 0.0f) {
            q0.b(new a(context, motionEvent.getDeviceId()));
        }
    }

    public static void a(JSONObject jSONObject) {
        h();
        try {
            jSONObject.put("vihc", f10832d);
            jSONObject.put("eihc", e);
            jSONObject.put("nihc", f10833f);
            jSONObject.put("vic", f10829a);
            jSONObject.put("nic", f10831c);
            jSONObject.put("eic", f10830b);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputManager b(Context context) {
        if (h == null) {
            h = (InputManager) context.getSystemService("input");
        }
        return h;
    }
}
