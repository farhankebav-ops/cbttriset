package com.google.android.gms.internal.ads;

import com.ironsource.C2300e4;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhtm extends zzhtn {
    final /* synthetic */ zzhtn zza;

    public /* synthetic */ zzhtm(zzhtn zzhtnVar, byte[] bArr) {
        Objects.requireNonNull(zzhtnVar);
        this.zza = zzhtnVar;
    }

    public final String toString() {
        String string = this.zza.toString();
        return a1.a.s(new StringBuilder(string.length() + 21), "NullSafeTypeAdapter[", string, C2300e4.i.e);
    }

    @Override // com.google.android.gms.internal.ads.zzhtn
    public final void zza(zzhun zzhunVar, Object obj) throws IOException {
        throw null;
    }
}
