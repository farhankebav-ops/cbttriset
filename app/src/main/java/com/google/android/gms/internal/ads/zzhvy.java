package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhvy {
    static final zzhvy zza = new zzhvy(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzhvy zzd;
    private final Map zze;

    public zzhvy() {
        this.zze = new HashMap();
    }

    public static zzhvy zza() {
        int i2 = zzhuv.zza;
        return zza;
    }

    public static zzhvy zzb() {
        zzhvy zzhvyVar = zzd;
        if (zzhvyVar != null) {
            return zzhvyVar;
        }
        synchronized (zzhvy.class) {
            try {
                zzhvy zzhvyVar2 = zzd;
                if (zzhvyVar2 != null) {
                    return zzhvyVar2;
                }
                int i2 = zzhuv.zza;
                zzhvy zzhvyVarZzb = zzhwg.zzb(zzhvy.class);
                zzd = zzhvyVarZzb;
                return zzhvyVarZzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzhwm zzc(zzhxz zzhxzVar, int i2) {
        return (zzhwm) this.zze.get(new zzhvx(zzhxzVar, i2));
    }

    public zzhvy(boolean z2) {
        this.zze = Collections.EMPTY_MAP;
    }
}
