package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgvo {
    private final OutputStream zza;

    private zzgvo(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzgvo zzb(OutputStream outputStream) {
        return new zzgvo(outputStream);
    }

    public final void zza(zzhlg zzhlgVar) throws IOException {
        try {
            zzhlgVar.zzaO(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
