package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.InputEvent;
import android.view.View;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfxp {
    private static final Object zza = new Object();
    private static zzfxp zzb;
    private final zzfxn zzc;

    private zzfxp(Context context, ExecutorService executorService, zzfxt zzfxtVar) {
        zzfya zzfyaVar = new zzfya(null);
        zzfyaVar.zzc(context);
        zzfyaVar.zzb(executorService);
        zzfyaVar.zzd(zzfxtVar);
        this.zzc = (zzfxn) ((zzfxz) zzfyaVar.zza()).zzF.zzb();
    }

    public static zzfxp zza(Context context, ExecutorService executorService, zzfxt zzfxtVar) {
        zzfxp zzfxpVar;
        synchronized (zza) {
            try {
                if (zzb == null) {
                    zzb = new zzfxp(context, executorService, zzfxtVar);
                }
                zzfxpVar = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzfxpVar;
    }

    public final j2.q zzb() {
        return this.zzc.zza();
    }

    public final String zzc(Context context) {
        return this.zzc.zzb(context);
    }

    public final String zzd(Context context, String str, View view, Activity activity) {
        return this.zzc.zzc(context, null, view, activity);
    }

    public final String zze(Context context, String str, View view, Activity activity) {
        return this.zzc.zzd(context, str, view, null);
    }

    public final void zzf(List list) {
        this.zzc.zze(list);
    }

    public final void zzg(InputEvent inputEvent) {
        this.zzc.zzf(inputEvent);
    }

    public final int zzh() {
        return this.zzc.zzh();
    }
}
