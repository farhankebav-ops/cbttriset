package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbdk extends PushbackInputStream {
    final /* synthetic */ zzbdn zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbdk(zzbdn zzbdnVar, InputStream inputStream, int i2) {
        super(inputStream, 1);
        Objects.requireNonNull(zzbdnVar);
        this.zza = zzbdnVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        this.zza.zzc.zzb();
        super.close();
    }
}
