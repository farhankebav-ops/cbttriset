package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcdo extends zzfvc {
    private final SensorManager zza;
    private final Object zzb;
    private final Display zzc;
    private final float[] zzd;
    private final float[] zze;
    private float[] zzf;
    private Handler zzg;
    private zzcdn zzh;

    public zzcdo(Context context) {
        super("OrientationMonitor", "ads");
        this.zza = (SensorManager) context.getSystemService("sensor");
        this.zzc = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.zzd = new float[9];
        this.zze = new float[9];
        this.zzb = new Object();
    }

    public final void zza() {
        if (this.zzg != null) {
            return;
        }
        SensorManager sensorManager = this.zza;
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        if (defaultSensor == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("No Sensor of TYPE_ROTATION_VECTOR");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
        handlerThread.start();
        zzfuz zzfuzVar = new zzfuz(handlerThread.getLooper());
        this.zzg = zzfuzVar;
        if (sensorManager.registerListener(this, defaultSensor, 0, zzfuzVar)) {
            return;
        }
        int i8 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzf("SensorManager.registerListener failed.");
        zzb();
    }

    public final void zzb() {
        if (this.zzg == null) {
            return;
        }
        this.zza.unregisterListener(this);
        this.zzg.post(new zzcdm(this));
        this.zzg = null;
    }

    public final void zzc(zzcdn zzcdnVar) {
        this.zzh = zzcdnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvc
    public final void zzd(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f) {
            return;
        }
        synchronized (this.zzb) {
            try {
                if (this.zzf == null) {
                    this.zzf = new float[9];
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        float[] fArr2 = this.zzd;
        SensorManager.getRotationMatrixFromVector(fArr2, fArr);
        int rotation = this.zzc.getRotation();
        if (rotation == 1) {
            SensorManager.remapCoordinateSystem(fArr2, 2, Sdk.SDKError.Reason.EMPTY_TPAT_ERROR_VALUE, this.zze);
        } else if (rotation == 2) {
            SensorManager.remapCoordinateSystem(fArr2, Sdk.SDKError.Reason.EMPTY_TPAT_ERROR_VALUE, Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, this.zze);
        } else if (rotation != 3) {
            System.arraycopy(fArr2, 0, this.zze, 0, 9);
        } else {
            SensorManager.remapCoordinateSystem(fArr2, Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE, 1, this.zze);
        }
        float[] fArr3 = this.zze;
        float f4 = fArr3[1];
        fArr3[1] = fArr3[3];
        fArr3[3] = f4;
        float f8 = fArr3[2];
        fArr3[2] = fArr3[6];
        fArr3[6] = f8;
        float f9 = fArr3[5];
        fArr3[5] = fArr3[7];
        fArr3[7] = f9;
        synchronized (this.zzb) {
            System.arraycopy(fArr3, 0, this.zzf, 0, 9);
        }
        zzcdn zzcdnVar = this.zzh;
        if (zzcdnVar != null) {
            zzcdnVar.zza();
        }
    }

    public final boolean zze(float[] fArr) {
        synchronized (this.zzb) {
            try {
                float[] fArr2 = this.zzf;
                if (fArr2 == null) {
                    return false;
                }
                System.arraycopy(fArr2, 0, fArr, 0, 9);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
