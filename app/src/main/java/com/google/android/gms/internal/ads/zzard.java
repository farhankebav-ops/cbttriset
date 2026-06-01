package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzard extends zzies implements Closeable {
    static {
        zziez.zzb(zzard.class);
    }

    public zzard(zziet zzietVar, zzarc zzarcVar) throws IOException {
        zzd(zzietVar, zzietVar.zzb(), zzarcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzies
    public final String toString() {
        String string = this.zzc.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 7);
        sb.append("model(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzies, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }
}
