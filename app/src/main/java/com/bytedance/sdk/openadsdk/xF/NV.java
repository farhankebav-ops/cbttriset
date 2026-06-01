package com.bytedance.sdk.openadsdk.xF;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.os.Vibrator;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV {
    public static WeakReference<IlO> IlO;
    protected static final float[] MY = new float[3];
    protected static final float[] EO = new float[3];
    protected static final float[] tV = new float[9];
    protected static final float[] Cc = new float[3];

    public static void EO(Context context, SensorEventListener sensorEventListener, int i2) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<IlO> weakReference = IlO;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            Bc.IlO("SensorHub", "startListenLinearAcceleration error", th);
        }
    }

    public static void IlO(Context context, SensorEventListener sensorEventListener) {
    }

    public static void MY(Context context, SensorEventListener sensorEventListener, int i2) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<IlO> weakReference = IlO;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            Bc.IlO("SensorHub", "startListenGyroscope error", th);
        }
    }

    public static void tV(Context context, SensorEventListener sensorEventListener, int i2) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<IlO> weakReference = IlO;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            Bc.IlO("SensorHub", "startListenRotationVector err", th);
        }
    }

    public static void IlO(IlO ilO) {
        IlO = new WeakReference<>(ilO);
    }

    public static void IlO(Context context, SensorEventListener sensorEventListener, int i2) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<IlO> weakReference = IlO;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            Bc.IlO("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static void IlO(Context context, long j) {
        if (context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j);
    }
}
