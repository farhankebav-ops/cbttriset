package com.google.firebase.installations;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class RandomFidGenerator {
    private static final int FID_LENGTH = 22;
    private static final byte FID_4BIT_PREFIX = Byte.parseByte("01110000", 2);
    private static final byte REMOVE_PREFIX_MASK = Byte.parseByte("00001111", 2);

    private static String encodeFidBase64UrlSafe(byte[] bArr) {
        return new String(Base64.encode(bArr, 11), Charset.defaultCharset()).substring(0, 22);
    }

    private static byte[] getBytesFromUUID(UUID uuid, byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.putLong(uuid.getMostSignificantBits());
        byteBufferWrap.putLong(uuid.getLeastSignificantBits());
        return byteBufferWrap.array();
    }

    @NonNull
    public String createRandomFid() {
        byte[] bytesFromUUID = getBytesFromUUID(UUID.randomUUID(), new byte[17]);
        byte b8 = bytesFromUUID[0];
        bytesFromUUID[16] = b8;
        bytesFromUUID[0] = (byte) ((b8 & REMOVE_PREFIX_MASK) | FID_4BIT_PREFIX);
        return encodeFidBase64UrlSafe(bytesFromUUID);
    }
}
