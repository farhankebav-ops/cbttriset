package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzayx extends zzazr {
    private final zzaye zzh;

    public zzayx(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i2, int i8, zzaye zzayeVar) {
        super(zzaydVar, "OKoG374XK3cB1cjYFPuO/Bg6vy6AufzuCyu4QCURxkWhJwL4+NqQjs8XziSHB+CQ", "PjHrXBXcXoGkJe75zH8RZ0khapXmOV4o2gX+YgkGdus=", zzaucVar, i2, 85);
        this.zzh = zzayeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        Method method = this.zze;
        zzaye zzayeVar = this.zzh;
        long[] jArr = (long[]) method.invoke(null, Long.valueOf(zzayeVar.zzf()), Long.valueOf(zzayeVar.zzg()), Long.valueOf(zzayeVar.zzi()), Long.valueOf(zzayeVar.zzh()));
        zzauc zzaucVar = this.zzd;
        synchronized (zzaucVar) {
            zzaucVar.zzY(jArr[0]);
            zzaucVar.zzZ(jArr[1]);
        }
    }
}
