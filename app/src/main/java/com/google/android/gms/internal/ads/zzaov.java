package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaov implements zzaou {
    private final FileChannel zza;
    private final long zzb;
    private final long zzc;

    public zzaov(FileChannel fileChannel, long j, long j3) {
        this.zza = fileChannel;
        this.zzb = j;
        this.zzc = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzaou
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaou
    public final void zzb(MessageDigest[] messageDigestArr, long j, int i2) throws IOException {
        MappedByteBuffer map = this.zza.map(FileChannel.MapMode.READ_ONLY, this.zzb + j, i2);
        map.load();
        for (MessageDigest messageDigest : messageDigestArr) {
            map.position(0);
            messageDigest.update(map);
        }
    }
}
