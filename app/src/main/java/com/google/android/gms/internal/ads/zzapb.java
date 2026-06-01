package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzapb {
    public static Pair zza(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair pairZze = zze(randomAccessFile, 0);
        return pairZze != null ? pairZze : zze(randomAccessFile, 65535);
    }

    public static long zzb(ByteBuffer byteBuffer) {
        zzf(byteBuffer);
        return zzg(byteBuffer, byteBuffer.position() + 16);
    }

    public static void zzc(ByteBuffer byteBuffer, long j) {
        zzf(byteBuffer);
        int iPosition = byteBuffer.position() + 16;
        if (j >= 0 && j <= 4294967295L) {
            byteBuffer.putInt(byteBuffer.position() + iPosition, (int) j);
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 27);
        sb.append("uint32 value of out range: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    public static long zzd(ByteBuffer byteBuffer) {
        zzf(byteBuffer);
        return zzg(byteBuffer, byteBuffer.position() + 12);
    }

    private static Pair zze(RandomAccessFile randomAccessFile, int i2) throws IOException {
        int i8;
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(((int) Math.min(i2, (-22) + length)) + 22);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long jCapacity = length - ((long) byteBufferAllocate.capacity());
        randomAccessFile.seek(jCapacity);
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        zzf(byteBufferAllocate);
        int iCapacity = byteBufferAllocate.capacity();
        if (iCapacity < 22) {
            i8 = -1;
        } else {
            int i9 = iCapacity - 22;
            int iMin = Math.min(i9, 65535);
            for (int i10 = 0; i10 < iMin; i10++) {
                i8 = i9 - i10;
                if (byteBufferAllocate.getInt(i8) == 101010256 && ((char) byteBufferAllocate.getShort(i8 + 20)) == i10) {
                    break;
                }
            }
            i8 = -1;
        }
        if (i8 == -1) {
            return null;
        }
        byteBufferAllocate.position(i8);
        ByteBuffer byteBufferSlice = byteBufferAllocate.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(byteBufferSlice, Long.valueOf(jCapacity + ((long) i8)));
    }

    private static void zzf(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static long zzg(ByteBuffer byteBuffer, int i2) {
        return ((long) byteBuffer.getInt(i2)) & 4294967295L;
    }
}
