package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzac extends zzz {
    public zzac() {
        super(4);
    }

    public final zzac zzb(Object obj) {
        obj.getClass();
        int i2 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i2) {
            this.zza = Arrays.copyOf(objArr, zzaa.zza(length, i2));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i8 = this.zzb;
        this.zzb = i8 + 1;
        objArr2[i8] = obj;
        return this;
    }

    public final zzaf zzc() {
        this.zzc = true;
        return zzaf.zzg(this.zza, this.zzb);
    }
}
