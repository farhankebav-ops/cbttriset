package com.google.android.gms.internal.ads;

import com.vungle.ads.internal.protos.Sdk;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgdi extends zzgdh {
    private final Map zza;
    private final zzfyq zzb;

    public zzgdi(zzauc zzaucVar, zzgcd zzgcdVar, zzfyq zzfyqVar, Map map, zzgjd zzgjdVar) {
        super("lJ67yAwBUtoZhasVqN11g6g6opAmTxjVxzUKxhl0fOhTr4nQH4cVWV7NJy0RD49z", "0isRm8IoYsyXMQyBCJPbREn4r5FwCMP2Q3k9zoXRqyk=", zzaucVar, zzgcdVar, zzgjdVar.zza(Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE));
        this.zza = map;
        this.zzb = zzfyqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    public final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        Long[] lArr = new Long[9];
        Arrays.fill((Object[]) lArr, (Object) (-1L));
        Map map = this.zza;
        lArr[0] = (Long) zzgma.zza((Long) map.get("tcq"), -1L);
        lArr[1] = (Long) zzgma.zza((Long) map.get("tpq"), -1L);
        lArr[2] = (Long) zzgma.zza((Long) map.get("tcv"), -1L);
        lArr[3] = (Long) zzgma.zza((Long) map.get("tpv"), -1L);
        lArr[4] = (Long) zzgma.zza((Long) map.get("tchv"), -1L);
        lArr[5] = (Long) zzgma.zza((Long) map.get("tphv"), -1L);
        lArr[6] = (Long) zzgma.zza((Long) map.get("tcc"), -1L);
        lArr[7] = (Long) zzgma.zza((Long) map.get("tpc"), -1L);
        lArr[8] = (Long) zzgma.zza((Long) map.get("tst"), -1L);
        for (int i2 = 0; i2 < 9; i2++) {
            if (lArr[i2] == null) {
                lArr[i2] = -1L;
            }
        }
        Long[] lArr2 = (Long[]) method.invoke("", lArr, Integer.valueOf(this.zzb.ordinal()));
        lArr2.getClass();
        synchronized (zzaucVar) {
            zzaucVar.zzac(lArr2[0].longValue());
            zzaucVar.zzs(lArr2[1].longValue());
            zzaucVar.zzn(lArr2[2].longValue());
            zzaucVar.zzk(lArr2[3].longValue());
            zzaucVar.zzY(lArr2[4].longValue());
            zzaucVar.zzZ(lArr2[5].longValue());
            zzaucVar.zzF(lArr2[6].longValue());
            zzaucVar.zzG(lArr2[7].longValue());
        }
    }
}
