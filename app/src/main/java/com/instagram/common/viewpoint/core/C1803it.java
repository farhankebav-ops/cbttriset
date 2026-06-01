package com.instagram.common.viewpoint.core;

import android.util.SparseArray;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.it, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1803it implements M5 {
    public static byte[] A07;
    public static String[] A08 = {"F3MsLf6P", "OcoAPMR8U6yTwuATNsSjihct3nuq8KFx", "bdE6GcC1kS6ix1fgAcoyQkC9rv", "V0wqj6Me", "EdnIrf", "cKhO3MBZMfPQ2uYBFx142UbqGZ0vcEvq", "x8zWNoAeDf", "YEiR7yHxtXFy2pC0Q9KvxgBtY"};
    public MC A00;
    public boolean A01;
    public final C3O A02;
    public final SecureRandom A03;
    public final Cipher A04;
    public final SecretKeySpec A05;
    public final boolean A06;

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A08;
            if (strArr[2].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[6] = "SFj9nJw9GR";
            strArr2[4] = "liv3w1";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 117);
            i10++;
        }
    }

    public static void A03() {
        A07 = new byte[]{11, 15, 29};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A05(HashMap<String, M4> map) throws IOException {
        try {
            C3N c3nA03 = this.A02.A03();
            if (this.A00 == null) {
                this.A00 = new MC(c3nA03);
            } else {
                this.A00.A00(c3nA03);
            }
            MC mc = this.A00;
            DataOutputStream dataOutputStream = new DataOutputStream(mc);
            dataOutputStream.writeInt(2);
            dataOutputStream.writeInt(this.A06 ? 1 : 0);
            if (this.A06) {
                byte[] bArr = new byte[16];
                ((SecureRandom) AbstractC04664a.A0f(this.A03)).nextBytes(bArr);
                dataOutputStream.write(bArr);
                try {
                    ((Cipher) AbstractC04664a.A0f(this.A04)).init(1, (Key) AbstractC04664a.A0f(this.A05), new IvParameterSpec(bArr));
                    dataOutputStream.flush();
                    dataOutputStream = new DataOutputStream(new CipherOutputStream(mc, this.A04));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                    throw new IllegalStateException(e);
                }
            }
            dataOutputStream.writeInt(map.size());
            int iA00 = 0;
            for (M4 m42 : map.values()) {
                A04(m42, dataOutputStream);
                iA00 += A00(m42, 2);
            }
            dataOutputStream.writeInt(iA00);
            this.A02.A06(dataOutputStream);
            AbstractC04664a.A10(null);
        } catch (Throwable th) {
            AbstractC04664a.A10(null);
            throw th;
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private boolean A06(HashMap<String, M4> map, SparseArray<String> sparseArray) {
        if (!this.A02.A07()) {
            return true;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.A02.A04());
            DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
            int i2 = dataInputStream.readInt();
            if (i2 < 0 || i2 > 2) {
                AbstractC04664a.A10(dataInputStream);
                return false;
            }
            if ((dataInputStream.readInt() & 1) != 0) {
                if (this.A04 == null) {
                    AbstractC04664a.A10(dataInputStream);
                    return false;
                }
                byte[] bArr = new byte[16];
                dataInputStream.readFully(bArr);
                try {
                    this.A04.init(2, (Key) AbstractC04664a.A0f(this.A05), new IvParameterSpec(bArr));
                    dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.A04));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                    throw new IllegalStateException(e);
                }
            } else if (this.A06) {
                this.A01 = true;
            }
            int i8 = dataInputStream.readInt();
            int iA00 = 0;
            for (int i9 = 0; i9 < i8; i9++) {
                M4 m4A01 = A01(i2, dataInputStream);
                map.put(m4A01.A02, m4A01);
                sparseArray.put(m4A01.A01, m4A01.A02);
                iA00 += A00(m4A01, i2);
            }
            int i10 = dataInputStream.readInt();
            boolean z2 = dataInputStream.read() == -1;
            if (i10 == iA00 && z2) {
                AbstractC04664a.A10(dataInputStream);
                return true;
            }
            AbstractC04664a.A10(dataInputStream);
            return false;
        } catch (IOException unused) {
            if (0 != 0) {
                AbstractC04664a.A10(null);
            }
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                AbstractC04664a.A10(null);
            }
            throw th;
        }
    }

    static {
        A03();
    }

    public C1803it(File file, byte[] bArr, boolean z2) {
        C3M.A08((bArr == null && z2) ? false : true);
        Cipher cipherA05 = null;
        SecretKeySpec secretKeySpec = null;
        if (bArr != null) {
            C3M.A07(bArr.length == 16);
            try {
                cipherA05 = M6.A05();
                secretKeySpec = new SecretKeySpec(bArr, A02(0, 3, 85));
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new IllegalStateException(e);
            }
        } else {
            C3M.A07(!z2);
        }
        this.A06 = z2;
        this.A04 = cipherA05;
        this.A05 = secretKeySpec;
        this.A03 = z2 ? new SecureRandom() : null;
        this.A02 = new C3O(file);
    }

    private int A00(M4 m42, int i2) {
        int result = m42.A01;
        int i8 = result * 31;
        int result2 = m42.A02.hashCode();
        int result3 = i8 + result2;
        if (i2 < 2) {
            long jA00 = M7.A00(m42.A03());
            return (result3 * 31) + ((int) ((jA00 >>> 32) ^ jA00));
        }
        return (result3 * 31) + m42.A03().hashCode();
    }

    private M4 A01(int i2, DataInputStream dataInputStream) throws IOException {
        C1802is c1802isA02;
        int i8 = dataInputStream.readInt();
        String utf = dataInputStream.readUTF();
        if (i2 >= 2) {
            c1802isA02 = M6.A02(dataInputStream);
        } else {
            long length = dataInputStream.readLong();
            M9 m9 = new M9();
            M9.A00(m9, length);
            c1802isA02 = C1802is.A03.A05(m9);
        }
        return new M4(i8, utf, c1802isA02);
    }

    private void A04(M4 m42, DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(m42.A01);
        dataOutputStream.writeUTF(m42.A02);
        M6.A08(m42.A03(), dataOutputStream);
    }

    @Override // com.instagram.common.viewpoint.core.M5
    public final void A5h() {
        this.A02.A05();
    }

    @Override // com.instagram.common.viewpoint.core.M5
    public final boolean A6K() {
        return this.A02.A07();
    }

    @Override // com.instagram.common.viewpoint.core.M5
    public final void AA7(long j) {
    }

    @Override // com.instagram.common.viewpoint.core.M5
    public final void AAj(HashMap<String, M4> map, SparseArray<String> sparseArray) {
        C3M.A08(!this.A01);
        if (!A06(map, sparseArray)) {
            map.clear();
            String[] strArr = A08;
            if (strArr[2].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            A08[7] = "LXlnn5Px";
            sparseArray.clear();
            this.A02.A05();
        }
    }

    @Override // com.instagram.common.viewpoint.core.M5
    public final void AEv(M4 m42, boolean z2) {
        this.A01 = true;
    }

    @Override // com.instagram.common.viewpoint.core.M5
    public final void AFa(M4 m42) {
        this.A01 = true;
    }

    @Override // com.instagram.common.viewpoint.core.M5
    public final void AJX(HashMap<String, M4> map) throws IOException {
        A05(map);
        this.A01 = false;
    }

    @Override // com.instagram.common.viewpoint.core.M5
    public final void AJY(HashMap<String, M4> map) throws IOException {
        if (!this.A01) {
            return;
        }
        AJX(map);
    }
}
