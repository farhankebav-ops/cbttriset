package sg.bigo.ads.common.q;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f15922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f15923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SensorManager f15924c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final List<Integer> f15926f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f15925d = 0;
    final float[] e = new float[3];
    private final float h = 1.0E-9f;
    public SensorEventListener g = new SensorEventListener() { // from class: sg.bigo.ads.common.q.b.1
        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensorEvent.values.length < 3) {
                return;
            }
            int type = sensor.getType();
            if (type != 4) {
                if (type == 9 || type == 1) {
                    b.this.f15923b.a(type, sensorEvent.values, new float[3]);
                    return;
                }
                return;
            }
            float[] fArr = new float[3];
            b bVar = b.this;
            if (bVar.f15925d != 0) {
                float f4 = (sensorEvent.timestamp - r4) * 1.0E-9f;
                float[] fArr2 = bVar.e;
                float f8 = fArr2[0];
                float[] fArr3 = sensorEvent.values;
                float f9 = (fArr3[0] * f4) + f8;
                fArr2[0] = f9;
                fArr2[1] = (fArr3[1] * f4) + fArr2[1];
                fArr2[2] = (fArr3[2] * f4) + fArr2[2];
                float fAbs = Math.abs((float) Math.toDegrees(f9));
                float fAbs2 = Math.abs((float) Math.toDegrees(b.this.e[1]));
                float fAbs3 = Math.abs((float) Math.toDegrees(b.this.e[2]));
                fArr[0] = fAbs;
                fArr[1] = fAbs2;
                fArr[2] = fAbs3;
            }
            b bVar2 = b.this;
            bVar2.f15925d = sensorEvent.timestamp;
            bVar2.f15923b.a(type, sensorEvent.values, fArr);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i2) {
        }
    };

    public b(@NonNull Context context, @NonNull List<Integer> list, @NonNull a aVar) {
        this.f15922a = new WeakReference<>(context);
        this.f15926f = list;
        this.f15923b = aVar;
    }
}
