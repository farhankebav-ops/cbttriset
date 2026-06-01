package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzazm extends zzazr {
    private static volatile Long zzh;
    private static final Object zzi = new Object();

    public zzazm(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i2, int i8) {
        super(zzaydVar, "VYNLVwJcUVwKHNYqtTAMU2Cbdf8xQvz3Fr3MGMTI+Feinwv11ysZpnAq/2AMk2I1", "XCAdtiyR5t8AMQ7u4CMXLD5NJ9dD+Tw+KRPDn9OS+vQ=", zzaucVar, i2, 33);
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzh == null) {
            synchronized (zzi) {
                try {
                    if (zzh == null) {
                        zzh = (Long) this.zze.invoke(null, null);
                    }
                } finally {
                }
            }
        }
        zzauc zzaucVar = this.zzd;
        synchronized (zzaucVar) {
            zzaucVar.zzs(zzh.longValue());
        }
    }
}
