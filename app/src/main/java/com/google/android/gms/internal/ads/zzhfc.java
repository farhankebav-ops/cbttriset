package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhfc {
    public static final zzhsz zza = zzhsz.zza(new byte[0]);

    public static final zzhsz zza(int i2) {
        return zzhsz.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(i2).array());
    }

    public static final zzhsz zzb(int i2) {
        return zzhsz.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(i2).array());
    }
}
