package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgdk extends zzgdh {
    private final Map zza;
    private final zzgcd zzb;
    private final DisplayMetrics zzc;

    public zzgdk(zzauc zzaucVar, zzgcd zzgcdVar, Map map, DisplayMetrics displayMetrics, zzgjd zzgjdVar) {
        super("gbI2a8ruQFsh7iJbKP5csiDrRqRaAG+o51RWglq6SF+q1HNUXOxpmDRR6GgQlE1Z", "C7gHksN/1NwyNvzCHdeBzJsOxB75cHtIeny2v2KpeXA=", zzaucVar, zzgcdVar, zzgjdVar.zza(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE));
        this.zzb = zzgcdVar;
        this.zza = map;
        this.zzc = displayMetrics;
    }

    private static long zzb(double d8, DisplayMetrics displayMetrics) {
        return Math.round(d8 / ((double) displayMetrics.density));
    }

    private static boolean zzc(DisplayMetrics displayMetrics) {
        return (displayMetrics == null || displayMetrics.density == 0.0f) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    public final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        Object[] objArr;
        Map map = this.zza;
        Object obj = (MotionEvent) map.get("nv");
        DisplayMetrics displayMetrics = this.zzc;
        Object[] objArr2 = (Object[]) method.invoke("", obj, displayMetrics);
        objArr2.getClass();
        zzauv zzauvVarZza = zzauw.zza();
        Object obj2 = objArr2[0];
        if (obj2 != null && objArr2[1] != null) {
            zzauvVarZza.zza(((Long) obj2).longValue());
            zzauvVarZza.zzb(((Long) objArr2[1]).longValue());
        }
        Object obj3 = objArr2[2];
        if (obj3 != null) {
            zzauvVarZza.zzh(((Long) obj3).longValue());
        }
        Object obj4 = objArr2[3];
        if (obj4 != null) {
            zzauvVarZza.zzf(((Long) obj4).longValue());
        }
        Object obj5 = objArr2[4];
        if (obj5 != null) {
            zzauvVarZza.zzc(((Long) obj5).longValue());
        }
        Object obj6 = objArr2[5];
        if (obj6 != null) {
            zzauvVarZza.zzs(((Long) obj6).longValue() != 0 ? 2 : 1);
        }
        Object obj7 = objArr2[6];
        if (obj7 != null) {
            zzauvVarZza.zzj(((Long) obj7).longValue());
        }
        Object obj8 = objArr2[7];
        if (obj8 != null) {
            zzauvVarZza.zzi(((Long) obj8).longValue());
        }
        Object obj9 = objArr2[8];
        if (obj9 != null) {
            zzauvVarZza.zzt(((Long) obj9).longValue() != 0 ? 2 : 1);
        }
        synchronized (zzaucVar) {
            try {
                Method methodZzc = this.zzb.zzc("TJcXhplO1c7oeAIzyyjGCjnhXIAfNaFNWGhya9KHb9++zv8J1h9atpUrZL1Yjg6v", "v7ewhEi0QRfAHjcos6RExS5aIOB6pcbb0aW+P30gIsQ=");
                if (methodZzc == null || (objArr = (Object[]) methodZzc.invoke("", (MotionEvent) map.get("nv"), displayMetrics)) == null) {
                    throw null;
                }
                Object obj10 = objArr[0];
                if (obj10 != null) {
                    zzaucVar.zzh(((Long) obj10).longValue());
                }
                Object obj11 = objArr[1];
                if (obj11 != null) {
                    zzaucVar.zzi(((Long) obj11).longValue());
                }
                Object obj12 = objArr[2];
                if (obj12 != null) {
                    zzaucVar.zzj(((Long) obj12).longValue());
                }
                Object obj13 = objArr[3];
                if (obj13 != null) {
                    zzaucVar.zzv(((Long) obj13).longValue());
                }
                Object obj14 = objArr[4];
                if (obj14 != null) {
                    zzaucVar.zzw(((Long) obj14).longValue());
                }
                zzgax zzgaxVar = (zzgax) map.get("oe");
                if (zzgaxVar != null) {
                    long j = zzgaxVar.zza;
                    if (j > 0) {
                        zzaucVar.zzz(j);
                    }
                    long j3 = zzgaxVar.zzb;
                    if (j3 > 0) {
                        zzaucVar.zzy(j3);
                    }
                    long j8 = zzgaxVar.zzc;
                    if (j8 > 0) {
                        zzaucVar.zzx(j8);
                    }
                    long j9 = zzgaxVar.zzd;
                    if (j9 > 0) {
                        zzaucVar.zzA(j9);
                    }
                }
                zzgax zzgaxVar2 = (zzgax) map.get("oe");
                if (zzgaxVar2 != null && zzgaxVar2.zza != 0 && zzc(displayMetrics)) {
                    double d8 = zzgaxVar2.zze;
                    if (displayMetrics == null) {
                        throw null;
                    }
                    zzauvVarZza.zzl(zzb(d8, displayMetrics));
                    zzauvVarZza.zzm(zzb(zzgaxVar2.zzh - zzgaxVar2.zzf, displayMetrics));
                    zzauvVarZza.zzn(zzb(zzgaxVar2.zzi - zzgaxVar2.zzg, displayMetrics));
                    zzauvVarZza.zzq(zzb(zzgaxVar2.zzf, displayMetrics));
                    zzauvVarZza.zzr(zzb(zzgaxVar2.zzg, displayMetrics));
                    if (((MotionEvent) map.get("nv")) != null) {
                        long jZzb = zzb(((zzgaxVar2.zzf - zzgaxVar2.zzh) + r5.getRawX()) - r5.getX(), displayMetrics);
                        if (jZzb != 0) {
                            zzauvVarZza.zzo(jZzb);
                        }
                        long jZzb2 = zzb(((zzgaxVar2.zzg - zzgaxVar2.zzi) + r5.getRawY()) - r5.getY(), displayMetrics);
                        if (jZzb2 != 0) {
                            zzauvVarZza.zzp(jZzb2);
                        }
                    }
                }
                zzaucVar.zzJ(zzauvVarZza);
                zzgay[] zzgayVarArr = (zzgay[]) map.get("ro");
                if (zzgayVarArr != null && zzc(displayMetrics)) {
                    for (int i2 = 0; i2 <= zzgayVarArr.length - 2; i2++) {
                        zzgay zzgayVar = zzgayVarArr[i2];
                        zzauv zzauvVarZza2 = zzauw.zza();
                        double d9 = zzgayVar.zza;
                        if (displayMetrics == null) {
                            throw null;
                        }
                        zzauvVarZza2.zza(zzb(d9, displayMetrics));
                        zzauvVarZza2.zzb(zzb(zzgayVar.zzb, displayMetrics));
                        zzaucVar.zzK((zzauw) zzauvVarZza2.zzbu());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
