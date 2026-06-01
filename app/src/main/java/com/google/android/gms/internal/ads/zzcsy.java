package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcsy implements zzbau {

    @Nullable
    private final zzcgy zza;
    private final Executor zzb;
    private final AtomicReference zzc = new AtomicReference();

    public zzcsy(@Nullable zzcgy zzcgyVar, Executor executor) {
        this.zza = zzcgyVar;
        this.zzb = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbau
    public final synchronized void zzdo(zzbat zzbatVar) {
        final zzcgy zzcgyVar = this.zza;
        if (zzcgyVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznE)).booleanValue()) {
                if (zzbatVar.zzj) {
                    AtomicReference atomicReference = this.zzc;
                    Boolean bool = Boolean.TRUE;
                    if (!bool.equals(atomicReference.getAndSet(bool))) {
                        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsx
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzcgyVar.onResume();
                            }
                        });
                    }
                } else {
                    AtomicReference atomicReference2 = this.zzc;
                    Boolean bool2 = Boolean.FALSE;
                    if (!bool2.equals(atomicReference2.getAndSet(bool2))) {
                        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsw
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzcgyVar.onPause();
                            }
                        });
                    }
                }
            }
        }
    }
}
