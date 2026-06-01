package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzayn extends zzazr {
    private final Activity zzh;
    private final View zzi;

    public zzayn(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i2, int i8, View view, Activity activity) {
        super(zzaydVar, "YJMz4lZ/SFOXN6kW19UKnvAqcLtndNv4f6er9d24/5MuXcrsMTIC+9Jfbhpe2HMW", "6iuDHA2XEqaGCIdpenyLvoYWzHjKpoW5EjYN40bz5Cs=", zzaucVar, i2, 62);
        this.zzi = view;
        this.zzh = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        View view = this.zzi;
        if (view == null) {
            return;
        }
        Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcY);
        boolean zBooleanValue = bool.booleanValue();
        Object[] objArr = (Object[]) this.zze.invoke(null, view, this.zzh, bool);
        zzauc zzaucVar = this.zzd;
        synchronized (zzaucVar) {
            try {
                zzaucVar.zzS(((Long) objArr[0]).longValue());
                zzaucVar.zzT(((Long) objArr[1]).longValue());
                if (zBooleanValue) {
                    zzaucVar.zzU((String) objArr[2]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
