package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzftl {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzftm zzc;
    private final zzfrs zzd;
    private final zzfrn zze;
    private final boolean zzf;

    @Nullable
    private zzfta zzg;
    private final Object zzh = new Object();

    public zzftl(@NonNull Context context, @NonNull zzftm zzftmVar, @NonNull zzfrs zzfrsVar, @NonNull zzfrn zzfrnVar, boolean z2) {
        this.zzb = context;
        this.zzc = zzftmVar;
        this.zzd = zzfrsVar;
        this.zze = zzfrnVar;
        this.zzf = z2;
    }

    private final synchronized Class zzd(@NonNull zzftb zzftbVar) throws zzftk {
        try {
            if (zzftbVar.zza() == null) {
                throw new zzftk(4010, "mc");
            }
            String strZza = zzftbVar.zza().zza();
            HashMap map = zza;
            Class cls = (Class) map.get(strZza);
            if (cls != null) {
                return cls;
            }
            try {
                if (!this.zze.zza(zzftbVar.zzb())) {
                    throw new zzftk(2026, "VM did not pass signature verification");
                }
                try {
                    File fileZzc = zzftbVar.zzc();
                    if (!fileZzc.exists()) {
                        fileZzc.mkdirs();
                    }
                    Class<?> clsLoadClass = new DexClassLoader(zzftbVar.zzb().getAbsolutePath(), fileZzc.getAbsolutePath(), null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                    map.put(strZza, clsLoadClass);
                    return clsLoadClass;
                } catch (ClassNotFoundException e) {
                    e = e;
                    throw new zzftk(2008, e);
                } catch (IllegalArgumentException e4) {
                    e = e4;
                    throw new zzftk(2008, e);
                } catch (SecurityException e8) {
                    e = e8;
                    throw new zzftk(2008, e);
                }
            } catch (GeneralSecurityException e9) {
                throw new zzftk(2026, e9);
            }
        } finally {
        }
    }

    public final boolean zza(@NonNull zzftb zzftbVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                zzfta zzftaVar = new zzfta(zzd(zzftbVar).getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzb, "msa-r", zzftbVar.zzd(), null, new Bundle(), 2), zzftbVar, this.zzc, this.zzd, this.zzf);
                if (!zzftaVar.zzf()) {
                    throw new zzftk(4000, "init failed");
                }
                int iZzh = zzftaVar.zzh();
                if (iZzh != 0) {
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzh).length() + 4);
                    sb.append("ci: ");
                    sb.append(iZzh);
                    throw new zzftk(4001, sb.toString());
                }
                synchronized (this.zzh) {
                    zzfta zzftaVar2 = this.zzg;
                    if (zzftaVar2 != null) {
                        try {
                            zzftaVar2.zzg();
                        } catch (zzftk e) {
                            this.zzd.zzc(e.zza(), -1L, e);
                        }
                        this.zzg = zzftaVar;
                    } else {
                        this.zzg = zzftaVar;
                    }
                }
                this.zzd.zzb(3000, System.currentTimeMillis() - jCurrentTimeMillis);
                return true;
            } catch (Exception e4) {
                throw new zzftk(2004, e4);
            }
        } catch (zzftk e8) {
            this.zzd.zzc(e8.zza(), System.currentTimeMillis() - jCurrentTimeMillis, e8);
            return false;
        } catch (Exception e9) {
            this.zzd.zzc(4010, System.currentTimeMillis() - jCurrentTimeMillis, e9);
            return false;
        }
    }

    @Nullable
    public final zzfrv zzb() {
        zzfta zzftaVar;
        synchronized (this.zzh) {
            zzftaVar = this.zzg;
        }
        return zzftaVar;
    }

    @Nullable
    public final zzftb zzc() {
        synchronized (this.zzh) {
            try {
                zzfta zzftaVar = this.zzg;
                if (zzftaVar == null) {
                    return null;
                }
                return zzftaVar.zze();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
