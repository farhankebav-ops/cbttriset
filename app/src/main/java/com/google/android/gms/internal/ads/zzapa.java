package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzapa {
    public static X509Certificate[][] zza(String str) throws zzaox, SecurityException, IOException {
        RandomAccessFile randomAccessFile;
        Pair pairZza;
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
        try {
            pairZza = zzapb.zza(randomAccessFile2);
        } catch (Throwable th) {
            th = th;
            randomAccessFile = randomAccessFile2;
        }
        try {
            if (pairZza == null) {
                long length = randomAccessFile2.length();
                StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 82);
                sb.append("Not an APK file: ZIP End of Central Directory record not found in file with ");
                sb.append(length);
                sb.append(" bytes");
                throw new zzaox(sb.toString());
            }
            ByteBuffer byteBuffer = (ByteBuffer) pairZza.first;
            long jLongValue = ((Long) pairZza.second).longValue();
            long j = (-20) + jLongValue;
            if (j >= 0) {
                randomAccessFile2.seek(j);
                if (randomAccessFile2.readInt() == 1347094023) {
                    throw new zzaox("ZIP64 APK not supported");
                }
            }
            long jZzb = zzapb.zzb(byteBuffer);
            if (jZzb >= jLongValue) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(jZzb).length() + 82 + String.valueOf(jLongValue).length());
                sb2.append("ZIP Central Directory offset out of range: ");
                sb2.append(jZzb);
                sb2.append(". ZIP End of Central Directory offset: ");
                sb2.append(jLongValue);
                throw new zzaox(sb2.toString());
            }
            if (zzapb.zzd(byteBuffer) + jZzb != jLongValue) {
                throw new zzaox("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
            if (jZzb < 32) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(jZzb).length() + 67);
                sb3.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
                sb3.append(jZzb);
                throw new zzaox(sb3.toString());
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            randomAccessFile2.seek(jZzb - ((long) byteBufferAllocate.capacity()));
            randomAccessFile2.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
            if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
                throw new zzaox("No APK Signing Block before ZIP Central Directory");
            }
            long j3 = jZzb;
            long j8 = byteBufferAllocate.getLong(0);
            if (j8 < byteBufferAllocate.capacity() || j8 > 2147483639) {
                StringBuilder sb4 = new StringBuilder(String.valueOf(j8).length() + 37);
                sb4.append("APK Signing Block size out of range: ");
                sb4.append(j8);
                throw new zzaox(sb4.toString());
            }
            int i2 = (int) (8 + j8);
            long j9 = j3 - ((long) i2);
            if (j9 < 0) {
                StringBuilder sb5 = new StringBuilder(String.valueOf(j9).length() + 39);
                sb5.append("APK Signing Block offset out of range: ");
                sb5.append(j9);
                throw new zzaox(sb5.toString());
            }
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i2);
            byteBufferAllocate2.order(byteOrder);
            randomAccessFile2.seek(j9);
            randomAccessFile2.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
            long j10 = byteBufferAllocate2.getLong(0);
            if (j10 != j8) {
                StringBuilder sb6 = new StringBuilder(String.valueOf(j10).length() + 63 + String.valueOf(j8).length());
                sb6.append("APK Signing Block sizes in header and footer do not match: ");
                sb6.append(j10);
                sb6.append(" vs ");
                sb6.append(j8);
                throw new zzaox(sb6.toString());
            }
            Pair pairCreate = Pair.create(byteBufferAllocate2, Long.valueOf(j9));
            ByteBuffer byteBuffer2 = (ByteBuffer) pairCreate.first;
            long jLongValue2 = ((Long) pairCreate.second).longValue();
            if (byteBuffer2.order() != byteOrder) {
                throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
            }
            int iCapacity = byteBuffer2.capacity() - 24;
            randomAccessFile = randomAccessFile2;
            if (iCapacity < 8) {
                StringBuilder sb7 = new StringBuilder(String.valueOf(iCapacity).length() + 17);
                sb7.append("end < start: ");
                sb7.append(iCapacity);
                sb7.append(" < 8");
                throw new IllegalArgumentException(sb7.toString());
            }
            int iCapacity2 = byteBuffer2.capacity();
            if (iCapacity > byteBuffer2.capacity()) {
                StringBuilder sb8 = new StringBuilder(String.valueOf(iCapacity).length() + 19 + String.valueOf(iCapacity2).length());
                sb8.append("end > capacity: ");
                sb8.append(iCapacity);
                sb8.append(" > ");
                sb8.append(iCapacity2);
                throw new IllegalArgumentException(sb8.toString());
            }
            int iLimit = byteBuffer2.limit();
            int iPosition = byteBuffer2.position();
            try {
                byteBuffer2.position(0);
                byteBuffer2.limit(iCapacity);
                byteBuffer2.position(8);
                ByteBuffer byteBufferSlice = byteBuffer2.slice();
                byteBufferSlice.order(byteBuffer2.order());
                byteBuffer2.position(0);
                byteBuffer2.limit(iLimit);
                byteBuffer2.position(iPosition);
                int i8 = 0;
                while (byteBufferSlice.hasRemaining()) {
                    i8++;
                    if (byteBufferSlice.remaining() < 8) {
                        StringBuilder sb9 = new StringBuilder(String.valueOf(i8).length() + 59);
                        sb9.append("Insufficient data to read size of APK Signing Block entry #");
                        sb9.append(i8);
                        throw new zzaox(sb9.toString());
                    }
                    long j11 = byteBufferSlice.getLong();
                    if (j11 < 4 || j11 > 2147483647L) {
                        StringBuilder sb10 = new StringBuilder(String.valueOf(i8).length() + 45 + String.valueOf(j11).length());
                        sb10.append("APK Signing Block entry #");
                        sb10.append(i8);
                        sb10.append(" size out of range: ");
                        sb10.append(j11);
                        throw new zzaox(sb10.toString());
                    }
                    int i9 = (int) j11;
                    int iPosition2 = byteBufferSlice.position() + i9;
                    if (i9 > byteBufferSlice.remaining()) {
                        int iRemaining = byteBufferSlice.remaining();
                        StringBuilder sb11 = new StringBuilder(String.valueOf(i8).length() + 45 + String.valueOf(i9).length() + 13 + String.valueOf(iRemaining).length());
                        sb11.append("APK Signing Block entry #");
                        sb11.append(i8);
                        sb11.append(" size out of range: ");
                        sb11.append(i9);
                        sb11.append(", available: ");
                        sb11.append(iRemaining);
                        throw new zzaox(sb11.toString());
                    }
                    if (byteBufferSlice.getInt() == 1896449818) {
                        X509Certificate[][] x509CertificateArrZzb = zzb(randomAccessFile.getChannel(), new zzaow(zzi(byteBufferSlice, i9 - 4), jLongValue2, j3, jLongValue, byteBuffer, null));
                        randomAccessFile.close();
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused) {
                        }
                        return x509CertificateArrZzb;
                    }
                    long j12 = j3;
                    byteBufferSlice.position(iPosition2);
                    j3 = j12;
                }
                throw new zzaox("No APK Signature Scheme v2 block in APK Signing Block");
            } catch (Throwable th2) {
                byteBuffer2.position(0);
                byteBuffer2.limit(iLimit);
                byteBuffer2.position(iPosition);
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }

    private static X509Certificate[][] zzb(FileChannel fileChannel, zzaow zzaowVar) throws SecurityException {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(AndroidStaticDeviceInfoDataSource.CERTIFICATE_TYPE_X509);
            try {
                ByteBuffer byteBufferZzj = zzj(zzaowVar.zza());
                int i2 = 0;
                while (byteBufferZzj.hasRemaining()) {
                    i2++;
                    try {
                        arrayList.add(zzc(zzj(byteBufferZzj), map, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException(com.google.android.gms.ads.internal.client.a.j(new StringBuilder(String.valueOf(i2).length() + 37), "Failed to parse/verify signer #", i2, " block"), e);
                    }
                }
                if (i2 <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (map.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                zzd(map, fileChannel, zzaowVar.zzb(), zzaowVar.zzc(), zzaowVar.zzd(), zzaowVar.zze());
                return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e8) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e8);
        }
    }

    private static X509Certificate[] zzc(ByteBuffer byteBuffer, Map map, CertificateFactory certificateFactory) throws IOException, SecurityException {
        String str;
        Pair pairCreate;
        ByteBuffer byteBufferZzj = zzj(byteBuffer);
        ByteBuffer byteBufferZzj2 = zzj(byteBuffer);
        byte[] bArrZzk = zzk(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrZzk2 = null;
        byte[] bArrZzk3 = null;
        int i2 = -1;
        int i8 = 0;
        while (byteBufferZzj2.hasRemaining()) {
            i8++;
            try {
                ByteBuffer byteBufferZzj3 = zzj(byteBufferZzj2);
                if (byteBufferZzj3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i9 = byteBufferZzj3.getInt();
                arrayList.add(Integer.valueOf(i9));
                if (i9 != 513 && i9 != 514 && i9 != 769) {
                    switch (i9) {
                        case 257:
                        case 258:
                        case 259:
                        case 260:
                            break;
                        default:
                            continue;
                    }
                }
                if (i2 != -1) {
                    int iZzf = zzf(i9);
                    int iZzf2 = zzf(i2);
                    if (iZzf != 1 && iZzf2 == 1) {
                    }
                }
                bArrZzk3 = zzk(byteBufferZzj3);
                i2 = i9;
            } catch (IOException e) {
                e = e;
                throw new SecurityException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i8).length() + 34), "Failed to parse signature record #", i8), e);
            } catch (BufferUnderflowException e4) {
                e = e4;
                throw new SecurityException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i8).length() + 34), "Failed to parse signature record #", i8), e);
            }
        }
        if (i2 == -1) {
            if (i8 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        if (i2 == 513 || i2 == 514) {
            str = "EC";
        } else if (i2 != 769) {
            switch (i2) {
                case 257:
                case 258:
                case 259:
                case 260:
                    str = "RSA";
                    break;
                default:
                    throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i2))));
            }
        } else {
            str = "DSA";
        }
        if (i2 == 513) {
            pairCreate = Pair.create("SHA256withECDSA", null);
        } else if (i2 == 514) {
            pairCreate = Pair.create("SHA512withECDSA", null);
        } else if (i2 != 769) {
            switch (i2) {
                case 257:
                    pairCreate = Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                    break;
                case 258:
                    pairCreate = Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                    break;
                case 259:
                    pairCreate = Pair.create("SHA256withRSA", null);
                    break;
                case 260:
                    pairCreate = Pair.create("SHA512withRSA", null);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i2))));
            }
        } else {
            pairCreate = Pair.create("SHA256withDSA", null);
        }
        String str2 = (String) pairCreate.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairCreate.second;
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArrZzk));
            Signature signature = Signature.getInstance(str2);
            signature.initVerify(publicKeyGeneratePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(byteBufferZzj);
            if (!signature.verify(bArrZzk3)) {
                throw new SecurityException(String.valueOf(str2).concat(" signature did not verify"));
            }
            byteBufferZzj.clear();
            ByteBuffer byteBufferZzj4 = zzj(byteBufferZzj);
            ArrayList arrayList2 = new ArrayList();
            int i10 = 0;
            while (byteBufferZzj4.hasRemaining()) {
                i10++;
                try {
                    ByteBuffer byteBufferZzj5 = zzj(byteBufferZzj4);
                    if (byteBufferZzj5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i11 = byteBufferZzj5.getInt();
                    arrayList2.add(Integer.valueOf(i11));
                    if (i11 == i2) {
                        bArrZzk2 = zzk(byteBufferZzj5);
                    }
                } catch (IOException e8) {
                    e = e8;
                    throw new IOException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i10).length() + 31), "Failed to parse digest record #", i10), e);
                } catch (BufferUnderflowException e9) {
                    e = e9;
                    throw new IOException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i10).length() + 31), "Failed to parse digest record #", i10), e);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iZzf3 = zzf(i2);
            byte[] bArr = (byte[]) map.put(Integer.valueOf(iZzf3), bArrZzk2);
            if (bArr != null && !MessageDigest.isEqual(bArr, bArrZzk2)) {
                throw new SecurityException(zzg(iZzf3).concat(" contents digest does not match the digest specified by a preceding signer"));
            }
            ByteBuffer byteBufferZzj6 = zzj(byteBufferZzj);
            ArrayList arrayList3 = new ArrayList();
            int i12 = 0;
            while (byteBufferZzj6.hasRemaining()) {
                i12++;
                byte[] bArrZzk4 = zzk(byteBufferZzj6);
                try {
                    arrayList3.add(new zzaoy((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrZzk4)), bArrZzk4));
                } catch (CertificateException e10) {
                    throw new SecurityException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i12).length() + 30), "Failed to decode certificate #", i12), e10);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (Arrays.equals(bArrZzk, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
            }
            throw new SecurityException("Public key mismatch between certificate and signature record");
        } catch (InvalidAlgorithmParameterException e11) {
            e = e11;
            throw new SecurityException(a1.a.s(new StringBuilder(String.valueOf(str2).length() + 27), "Failed to verify ", str2, " signature"), e);
        } catch (InvalidKeyException e12) {
            e = e12;
            throw new SecurityException(a1.a.s(new StringBuilder(String.valueOf(str2).length() + 27), "Failed to verify ", str2, " signature"), e);
        } catch (NoSuchAlgorithmException e13) {
            e = e13;
            throw new SecurityException(a1.a.s(new StringBuilder(String.valueOf(str2).length() + 27), "Failed to verify ", str2, " signature"), e);
        } catch (SignatureException e14) {
            e = e14;
            throw new SecurityException(a1.a.s(new StringBuilder(String.valueOf(str2).length() + 27), "Failed to verify ", str2, " signature"), e);
        } catch (InvalidKeySpecException e15) {
            e = e15;
            throw new SecurityException(a1.a.s(new StringBuilder(String.valueOf(str2).length() + 27), "Failed to verify ", str2, " signature"), e);
        }
    }

    private static void zzd(Map map, FileChannel fileChannel, long j, long j3, long j8, ByteBuffer byteBuffer) throws SecurityException {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        zzaov zzaovVar = new zzaov(fileChannel, 0L, j);
        zzaov zzaovVar2 = new zzaov(fileChannel, j3, j8 - j3);
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        zzapb.zzc(byteBufferDuplicate, j);
        zzaot zzaotVar = new zzaot(byteBufferDuplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = ((Integer) it.next()).intValue();
            i2++;
        }
        try {
            byte[][] bArrZze = zze(iArr, new zzaou[]{zzaovVar, zzaovVar2, zzaotVar});
            for (int i8 = 0; i8 < size; i8++) {
                int i9 = iArr[i8];
                if (!MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i9)), bArrZze[i8])) {
                    throw new SecurityException(zzg(i9).concat(" digest of contents did not verify"));
                }
            }
        } catch (DigestException e) {
            throw new SecurityException("Failed to compute digest(s) of contents", e);
        }
    }

    private static byte[][] zze(int[] iArr, zzaou[] zzaouVarArr) throws DigestException {
        long j;
        int i2;
        int length;
        char c7;
        int i8;
        String str;
        int i9 = 0;
        long jZza = 0;
        while (true) {
            j = 1048576;
            i2 = 3;
            if (i9 >= 3) {
                break;
            }
            jZza += (zzaouVarArr[i9].zza() + 1048575) / 1048576;
            i9++;
        }
        if (jZza >= 2097151) {
            StringBuilder sb = new StringBuilder(String.valueOf(jZza).length() + 17);
            sb.append("Too many chunks: ");
            sb.append(jZza);
            throw new DigestException(sb.toString());
        }
        byte[][] bArr = new byte[iArr.length][];
        int i10 = 0;
        while (true) {
            length = iArr.length;
            c7 = 5;
            i8 = 1;
            if (i10 >= length) {
                break;
            }
            int i11 = (int) jZza;
            byte[] bArr2 = new byte[(zzh(iArr[i10]) * i11) + 5];
            bArr2[0] = 90;
            zzl(i11, bArr2, 1);
            bArr[i10] = bArr2;
            i10++;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        int i12 = 0;
        while (true) {
            str = " digest not supported";
            if (i12 >= iArr.length) {
                break;
            }
            String strZzg = zzg(iArr[i12]);
            try {
                messageDigestArr[i12] = MessageDigest.getInstance(strZzg);
                i12++;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(strZzg.concat(" digest not supported"), e);
            }
        }
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < i2) {
            zzaou zzaouVar = zzaouVarArr[i13];
            int i16 = i13;
            long jZza2 = zzaouVar.zza();
            long j3 = 0;
            while (jZza2 > 0) {
                int i17 = i14;
                String str2 = str;
                int iMin = (int) Math.min(jZza2, j);
                zzl(iMin, bArr3, i8);
                for (int i18 = 0; i18 < length; i18++) {
                    messageDigestArr[i18].update(bArr3);
                }
                try {
                    zzaouVar.zzb(messageDigestArr, j3, iMin);
                    int i19 = 0;
                    while (i19 < iArr.length) {
                        int i20 = iArr[i19];
                        byte[] bArr4 = bArr[i19];
                        int iZzh = zzh(i20);
                        char c8 = c7;
                        MessageDigest messageDigest = messageDigestArr[i19];
                        int iDigest = messageDigest.digest(bArr4, (i17 * iZzh) + 5, iZzh);
                        if (iDigest != iZzh) {
                            String algorithm = messageDigest.getAlgorithm();
                            StringBuilder sb2 = new StringBuilder(String.valueOf(algorithm).length() + 35 + String.valueOf(iDigest).length());
                            sb2.append("Unexpected output size of ");
                            sb2.append(algorithm);
                            sb2.append(" digest: ");
                            sb2.append(iDigest);
                            throw new RuntimeException(sb2.toString());
                        }
                        i19++;
                        c7 = c8;
                    }
                    long j8 = iMin;
                    j3 += j8;
                    jZza2 -= j8;
                    i14 = i17 + 1;
                    str = str2;
                    j = 1048576;
                    i8 = 1;
                } catch (IOException e4) {
                    throw new DigestException(a1.a.f(i17, i15, "Failed to digest chunk #", " of section #", new StringBuilder(String.valueOf(i17).length() + 37 + String.valueOf(i15).length())), e4);
                }
            }
            i15++;
            i13 = i16 + 1;
            j = 1048576;
            i2 = 3;
            i8 = 1;
        }
        String str3 = str;
        byte[][] bArr5 = new byte[iArr.length][];
        for (int i21 = 0; i21 < iArr.length; i21++) {
            int i22 = iArr[i21];
            byte[] bArr6 = bArr[i21];
            String strZzg2 = zzg(i22);
            try {
                bArr5[i21] = MessageDigest.getInstance(strZzg2).digest(bArr6);
            } catch (NoSuchAlgorithmException e8) {
                throw new RuntimeException(strZzg2.concat(str3), e8);
            }
        }
        return bArr5;
    }

    private static int zzf(int i2) {
        if (i2 == 513) {
            return 1;
        }
        if (i2 == 514) {
            return 2;
        }
        if (i2 == 769) {
            return 1;
        }
        switch (i2) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i2))));
        }
    }

    private static String zzg(int i2) {
        if (i2 == 1) {
            return "SHA-256";
        }
        if (i2 == 2) {
            return "SHA-512";
        }
        throw new IllegalArgumentException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 33), "Unknown content digest algorthm: ", i2));
    }

    private static int zzh(int i2) {
        if (i2 == 1) {
            return 32;
        }
        if (i2 == 2) {
            return 64;
        }
        throw new IllegalArgumentException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 33), "Unknown content digest algorthm: ", i2));
    }

    private static ByteBuffer zzi(ByteBuffer byteBuffer, int i2) throws BufferUnderflowException {
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i8 = i2 + iPosition;
        if (i8 < iPosition || i8 > iLimit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i8);
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i8);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    private static ByteBuffer zzj(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            int iRemaining = byteBuffer.remaining();
            throw new IOException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(iRemaining).length() + 82), "Remaining buffer too short to contain length of length-prefixed field. Remaining: ", iRemaining));
        }
        int i2 = byteBuffer.getInt();
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i2 <= byteBuffer.remaining()) {
            return zzi(byteBuffer, i2);
        }
        int iRemaining2 = byteBuffer.remaining();
        throw new IOException(a1.a.f(i2, iRemaining2, "Length-prefixed field longer than remaining buffer. Field length: ", ", remaining: ", new StringBuilder(String.valueOf(i2).length() + 79 + String.valueOf(iRemaining2).length())));
    }

    private static byte[] zzk(ByteBuffer byteBuffer) throws IOException {
        int i2 = byteBuffer.getInt();
        if (i2 < 0) {
            throw new IOException("Negative length");
        }
        if (i2 <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i2];
            byteBuffer.get(bArr);
            return bArr;
        }
        int iRemaining = byteBuffer.remaining();
        throw new IOException(a1.a.f(i2, iRemaining, "Underflow while reading length-prefixed value. Length: ", ", available: ", new StringBuilder(String.valueOf(i2).length() + 68 + String.valueOf(iRemaining).length())));
    }

    private static void zzl(int i2, byte[] bArr, int i8) {
        bArr[1] = (byte) (i2 & 255);
        bArr[2] = (byte) ((i2 >>> 8) & 255);
        bArr[3] = (byte) ((i2 >>> 16) & 255);
        bArr[4] = (byte) (i2 >> 24);
    }
}
