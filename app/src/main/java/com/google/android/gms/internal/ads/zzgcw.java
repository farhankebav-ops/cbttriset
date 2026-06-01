package com.google.android.gms.internal.ads;

import com.vungle.ads.internal.protos.Sdk;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgcw extends zzgdh {
    private static volatile Long zza;
    private static final Object zzb = new Object();

    public zzgcw(zzauc zzaucVar, zzgcd zzgcdVar, zzgjd zzgjdVar) {
        super("Zh6cd+aDndZV+YUcVHG1KoZXWtL97j2QmZXbwOqvXvMv7NRw9MmD/Gx8wRyupV8R", "kj+4OypsnIcMTfpnmlGzqqY0pqeQ7F3FRQZTzB0M60E=", zzaucVar, zzgcdVar, zzgjdVar.zza(Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE));
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    public final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        if (zza == null) {
            synchronized (zzb) {
                try {
                    if (zza == null) {
                        Long l = (Long) method.invoke("", null);
                        if (l == null) {
                            throw null;
                        }
                        zza = l;
                    }
                } finally {
                }
            }
        }
        synchronized (zzaucVar) {
            try {
                if (zza != null) {
                    zzaucVar.zzm(zza.longValue());
                }
            } finally {
            }
        }
    }
}
