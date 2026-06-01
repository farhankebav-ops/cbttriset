package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgdc extends zzgdh {
    private final Context zza;
    private final Map zzb;

    public zzgdc(zzauc zzaucVar, zzgcd zzgcdVar, Map map, Context context, zzgjd zzgjdVar) {
        super("yl2V2fIFd/+gtM2i3wtw7rRydnC7INCVtpRFdnYEC9BkEYS1KI4o6evRDqm9gjRN", "/ngo8an629JW3IpM1KyGjEthGKpic0JTOThCbrYq6ZE=", zzaucVar, zzgcdVar, zzgjdVar.zza(120));
        this.zza = context;
        this.zzb = map;
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    public final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        Long lValueOf = -1L;
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                Long l = (Long) method.invoke("", this.zza);
                if (l == null) {
                    throw null;
                }
                lValueOf = l;
            } else {
                j2.q qVar = (j2.q) this.zzb.get("gs");
                if (qVar != null && qVar.isDone()) {
                    lValueOf = Long.valueOf(((zzauz) qVar.get()).zze());
                }
            }
        } catch (InterruptedException | ExecutionException unused) {
        }
        synchronized (zzaucVar) {
            zzaucVar.zzR(lValueOf.longValue());
        }
    }
}
