package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgcc {
    private static Cipher zza;
    private static final Object zzb = new Object();
    private static final Object zzc = new Object();

    private static final Cipher zzc() throws NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher;
        synchronized (zzc) {
            try {
                if (zza == null) {
                    zza = Cipher.getInstance("AES/CBC/PKCS5Padding");
                }
                cipher = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cipher;
    }

    public final byte[] zza(byte[] bArr, String str) throws zzgcb {
        byte[] bArrDoFinal;
        int length = bArr.length;
        try {
            byte[] bArrZzb = zzfyo.zzb(str, false);
            int length2 = bArrZzb.length;
            if (length2 <= 16) {
                throw new zzgcb();
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length2);
            byteBufferAllocate.put(bArrZzb);
            byteBufferAllocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[length2 - 16];
            byteBufferAllocate.get(bArr2);
            byteBufferAllocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzb) {
                zzc().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                bArrDoFinal = zzc().doFinal(bArr3);
            }
            return bArrDoFinal;
        } catch (IllegalArgumentException e) {
            e = e;
            throw new zzgcb(e);
        } catch (InvalidAlgorithmParameterException e4) {
            e = e4;
            throw new zzgcb(e);
        } catch (InvalidKeyException e8) {
            e = e8;
            throw new zzgcb(e);
        } catch (NoSuchAlgorithmException e9) {
            e = e9;
            throw new zzgcb(e);
        } catch (BadPaddingException e10) {
            e = e10;
            throw new zzgcb(e);
        } catch (IllegalBlockSizeException e11) {
            e = e11;
            throw new zzgcb(e);
        } catch (NoSuchPaddingException e12) {
            e = e12;
            throw new zzgcb(e);
        }
    }

    public final String zzb(byte[] bArr, String str) throws zzgcb, UnsupportedEncodingException {
        return new String(zza(bArr, str), Key.STRING_CHARSET_NAME);
    }
}
