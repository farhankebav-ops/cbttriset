package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbce extends zzbbw {
    private MessageDigest zzb;
    private final int zzc;
    private final int zzd;

    public zzbce(int i2) {
        int i8 = i2 >> 3;
        this.zzc = (i2 & 7) > 0 ? i8 + 1 : i8;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzbbw
    public final byte[] zza(String str) {
        synchronized (this.zza) {
            try {
                MessageDigest messageDigestZzb = zzb();
                this.zzb = messageDigestZzb;
                if (messageDigestZzb == null) {
                    return new byte[0];
                }
                messageDigestZzb.reset();
                this.zzb.update(str.getBytes(Charset.forName(Key.STRING_CHARSET_NAME)));
                byte[] bArrDigest = this.zzb.digest();
                int length = bArrDigest.length;
                int i2 = this.zzc;
                if (length > i2) {
                    length = i2;
                }
                byte[] bArr = new byte[length];
                System.arraycopy(bArrDigest, 0, bArr, 0, length);
                int i8 = this.zzd & 7;
                if (i8 > 0) {
                    long j = 0;
                    for (int i9 = 0; i9 < length; i9++) {
                        if (i9 > 0) {
                            j <<= 8;
                        }
                        j += (long) (bArr[i9] & 255);
                    }
                    long j3 = j >>> (8 - i8);
                    while (true) {
                        i2--;
                        if (i2 < 0) {
                            break;
                        }
                        bArr[i2] = (byte) (255 & j3);
                        j3 >>>= 8;
                    }
                }
                return bArr;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
