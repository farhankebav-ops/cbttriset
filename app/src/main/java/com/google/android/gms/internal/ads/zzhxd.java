package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzhxd extends IOException {
    private boolean zza;

    public zzhxd(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public final void zza() {
        this.zza = true;
    }

    public final boolean zzb() {
        return this.zza;
    }

    public zzhxd(String str) {
        super(str);
    }

    public zzhxd(String str, IOException iOException) {
        super("Unable to parse map entry.", iOException);
    }
}
