package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzgq extends zzgc {
    public final int zzb;

    public zzgq(zzgf zzgfVar, int i2, int i8) {
        super(zzb(2008, 1));
        this.zzb = 1;
    }

    public static zzgq zza(IOException iOException, zzgf zzgfVar, int i2) {
        String message = iOException.getMessage();
        int i8 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !zzglm.zza(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i8 == 2007 ? new zzgp(iOException, zzgfVar) : new zzgq(iOException, zzgfVar, i8, i2);
    }

    private static int zzb(int i2, int i8) {
        return i2 == 2000 ? i8 != 1 ? 2000 : 2001 : i2;
    }

    public zzgq(IOException iOException, zzgf zzgfVar, int i2, int i8) {
        super(iOException, zzb(i2, i8));
        this.zzb = i8;
    }

    public zzgq(String str, zzgf zzgfVar, int i2, int i8) {
        super(str, zzb(i2, i8));
        this.zzb = i8;
    }

    public zzgq(String str, @Nullable IOException iOException, zzgf zzgfVar, int i2, int i8) {
        super(str, iOException, zzb(i2, i8));
        this.zzb = i8;
    }
}
