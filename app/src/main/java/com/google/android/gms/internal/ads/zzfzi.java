package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfzi {
    private final ExecutorService zza;

    public zzfzi(ExecutorService executorService) {
        this.zza = executorService;
    }

    public final zzfyz zza(File file, zzhxz zzhxzVar, Function function) {
        return new zzfzh(file, this.zza, new zzfzf(zzhxzVar), function);
    }

    public final zzfyz zzb(File file, byte[] bArr, Function function) {
        return new zzfzh(file, this.zza, new zzfzb(bArr), function);
    }
}
