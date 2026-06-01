package com.pgl.ssdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class j0 implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float[] f10768a = {999999.0f, 999999.0f, 999999.0f};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f10769b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile j0 f10770c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Context f10773i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Sensor f10771d = null;
    private Sensor e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Sensor f10772f = null;
    private volatile boolean g = false;
    private volatile boolean h = false;
    private AtomicReference<a> j = new AtomicReference<>();
    private long k = 999999;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f10774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float[] f10775b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float[] f10776c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float[] f10777d = null;

        public a(long j) {
            this.f10774a = j;
        }
    }

    private j0(Context context) {
        this.f10773i = context;
    }

    public static j0 a(Context context) {
        if (f10770c == null) {
            synchronized (j0.class) {
                try {
                    if (f10770c == null) {
                        f10770c = new j0(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (f10769b) {
            f10770c.c();
        }
        return f10770c;
    }

    private void c() {
        if (this.h) {
            return;
        }
        try {
            SensorManager sensorManager = (SensorManager) this.f10773i.getApplicationContext().getSystemService("sensor");
            if (sensorManager != null) {
                this.f10771d = sensorManager.getDefaultSensor(1);
                this.e = sensorManager.getDefaultSensor(2);
                this.f10772f = sensorManager.getDefaultSensor(4);
            }
        } catch (Exception unused) {
        }
        this.h = true;
    }

    private void e() {
        this.k = -1L;
        this.g = false;
        try {
            SensorManager sensorManager = (SensorManager) this.f10773i.getApplicationContext().getSystemService("sensor");
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
        } catch (Exception unused) {
        }
    }

    public Object[] b() {
        Object[] objArr = new Object[6];
        a aVar = this.j.get();
        if (!f10769b || aVar == null) {
            a(objArr);
            return objArr;
        }
        int i2 = 0;
        do {
            if ((this.f10771d == null || aVar.f10775b != null) && ((this.e == null || aVar.f10776c != null) && (this.f10772f == null || aVar.f10777d != null))) {
                break;
            }
            y0.a(50L);
            i2++;
        } while (i2 <= 20);
        e();
        this.g = false;
        a(objArr, aVar);
        this.j.set(null);
        return objArr;
    }

    public boolean d() {
        if (this.f10771d != null) {
            try {
                SensorManager sensorManager = (SensorManager) this.f10773i.getApplicationContext().getSystemService("sensor");
                if (sensorManager != null) {
                    boolean zRegisterListener = sensorManager.registerListener(this, this.f10771d, 1);
                    Sensor sensor = this.e;
                    if (sensor != null) {
                        sensorManager.registerListener(this, sensor, 1);
                    }
                    Sensor sensor2 = this.f10772f;
                    if (sensor2 != null) {
                        sensorManager.registerListener(this, sensor2, 1);
                    }
                    if (zRegisterListener) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        this.k = jCurrentTimeMillis;
                        this.j.set(new a(jCurrentTimeMillis));
                        this.g = true;
                    } else {
                        e();
                    }
                }
            } catch (Throwable unused) {
                e();
            }
        }
        return this.g;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        a aVar = this.j.get();
        if (aVar == null) {
            return;
        }
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            if (aVar.f10775b == null) {
                aVar.f10775b = sensorEvent.values;
            }
        } else if (type == 2) {
            if (aVar.f10776c == null) {
                aVar.f10776c = sensorEvent.values;
            }
        } else if (type == 4 && aVar.f10777d == null) {
            aVar.f10777d = sensorEvent.values;
        }
    }

    private static void a(Object[] objArr) {
        Float fValueOf = Float.valueOf(999999.0f);
        objArr[0] = fValueOf;
        objArr[1] = fValueOf;
        objArr[2] = fValueOf;
        objArr[3] = 999999L;
        float[] fArr = f10768a;
        objArr[4] = fArr;
        objArr[5] = fArr;
    }

    private static void a(Object[] objArr, a aVar) {
        float[] fArrA;
        Float fValueOf = Float.valueOf(999999.0f);
        float[] fArr = aVar.f10775b;
        if (fArr != null) {
            float[] fArr2 = aVar.f10776c;
            if (fArr2 != null) {
                fArrA = a(objArr, fArr, fArr2);
            } else {
                fArrA = a(objArr, fArr);
            }
            objArr[0] = Float.valueOf(fArrA[0]);
            objArr[1] = Float.valueOf(fArrA[1]);
            objArr[2] = Float.valueOf(fArrA[2]);
            objArr[4] = aVar.f10775b;
        } else {
            objArr[0] = fValueOf;
            objArr[1] = fValueOf;
            objArr[2] = fValueOf;
            objArr[4] = f10768a;
        }
        objArr[3] = Long.valueOf(aVar.f10774a);
        float[] fArr3 = aVar.f10777d;
        if (fArr3 != null) {
            objArr[5] = fArr3;
        } else {
            objArr[5] = f10768a;
        }
    }

    private static float[] a(Object[] objArr, float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[9];
        SensorManager.getRotationMatrix(fArr3, new float[9], fArr, fArr2);
        SensorManager.getOrientation(fArr3, new float[3]);
        return new float[]{(((float) Math.toDegrees(r2[0])) + 360.0f) % 360.0f, (((float) Math.toDegrees(r2[1])) + 360.0f) % 360.0f, (((float) Math.toDegrees(r2[2])) + 360.0f) % 360.0f};
    }

    private static float[] a(Object[] objArr, float[] fArr) {
        float f4 = fArr[0];
        float f8 = fArr[1];
        float f9 = fArr[2];
        float fSqrt = 1.0f / ((float) Math.sqrt((f9 * f9) + ((f8 * f8) + (f4 * f4))));
        return new float[]{999999.0f, (((float) Math.toDegrees((float) Math.asin(-(f8 * fSqrt)))) + 360.0f) % 360.0f, (((float) Math.toDegrees((float) Math.atan2(-(f4 * fSqrt), f9 * fSqrt))) + 360.0f) % 360.0f};
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void a() {
        if (!f10769b || this.g) {
            return;
        }
        d();
    }
}
