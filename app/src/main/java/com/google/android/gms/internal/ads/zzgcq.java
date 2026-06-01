package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgcq extends zzgdh {
    public zzgcq(zzauc zzaucVar, zzgcd zzgcdVar, zzgjd zzgjdVar) {
        super("dFQH+5qiD2PRdi0XHMSOoNm+a3fekCOGUzmH+eYRmk9bJvOb468Cs8O4aRQ5LdYP", "cV7R50f2/HQumOgCDB4L1ZcSwVOfPPdtbjhx11w36hE=", zzaucVar, zzgcdVar, zzgjdVar.zza(114));
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    public final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        synchronized (zzaucVar) {
            zzaucVar.zza(ExifInterface.LONGITUDE_EAST);
            zzaucVar.zzB(0L);
            zzaucVar.zzV("D");
        }
        Object[] objArr = (Object[]) method.invoke("", null);
        objArr.getClass();
        synchronized (zzaucVar) {
            zzaucVar.zza((String) objArr[0]);
            zzaucVar.zzB(((Long) objArr[1]).longValue());
            zzaucVar.zzV((String) objArr[2]);
        }
    }
}
