package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdzr extends zzfvc {
    private final Context zza;
    private SensorManager zzb;
    private Sensor zzc;
    private long zzd;
    private int zze;
    private zzdzq zzf;
    private boolean zzg;

    public zzdzr(Context context) {
        super("ShakeDetector", "ads");
        this.zza = context;
    }

    public final void zza(zzdzq zzdzqVar) {
        this.zzf = zzdzqVar;
    }

    public final void zzb() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            try {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjX)).booleanValue()) {
                    if (this.zzb == null) {
                        SensorManager sensorManager2 = (SensorManager) this.zza.getSystemService("sensor");
                        this.zzb = sensorManager2;
                        if (sensorManager2 == null) {
                            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzi("Shake detection failed to initialize. Failed to obtain accelerometer.");
                            return;
                        }
                        this.zzc = sensorManager2.getDefaultSensor(1);
                    }
                    if (!this.zzg && (sensorManager = this.zzb) != null && (sensor = this.zzc) != null) {
                        sensorManager.registerListener(this, sensor, 2);
                        this.zzd = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() - ((long) ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjZ)).intValue());
                        this.zzg = true;
                        com.google.android.gms.ads.internal.util.zze.zza("Listening for shake gestures.");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc() {
        synchronized (this) {
            try {
                if (this.zzg) {
                    SensorManager sensorManager = this.zzb;
                    if (sensorManager != null) {
                        sensorManager.unregisterListener(this, this.zzc);
                        com.google.android.gms.ads.internal.util.zze.zza("Stopped listening for shake gestures.");
                    }
                    this.zzg = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvc
    public final void zzd(SensorEvent sensorEvent) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjX)).booleanValue()) {
            float[] fArr = sensorEvent.values;
            float f4 = fArr[0] / 9.80665f;
            float f8 = fArr[1] / 9.80665f;
            float f9 = fArr[2] / 9.80665f;
            float f10 = f9 * f9;
            if (((float) Math.sqrt(f10 + (f8 * f8) + (f4 * f4))) >= ((Float) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjY)).floatValue()) {
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
                if (this.zzd + ((long) ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjZ)).intValue()) <= jCurrentTimeMillis) {
                    if (this.zzd + ((long) ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzka)).intValue()) < jCurrentTimeMillis) {
                        this.zze = 0;
                    }
                    com.google.android.gms.ads.internal.util.zze.zza("Shake detected.");
                    this.zzd = jCurrentTimeMillis;
                    int i2 = this.zze + 1;
                    this.zze = i2;
                    zzdzq zzdzqVar = this.zzf;
                    if (zzdzqVar != null) {
                        if (i2 == ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzkb)).intValue()) {
                            zzdyo zzdyoVar = (zzdyo) zzdzqVar;
                            zzdyoVar.zzo(new zzdyl(zzdyoVar), zzdyn.GESTURE);
                        }
                    }
                }
            }
        }
    }
}
