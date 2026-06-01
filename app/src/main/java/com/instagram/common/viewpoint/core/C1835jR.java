package com.instagram.common.viewpoint.core;

import android.graphics.Bitmap;
import com.vungle.ads.internal.protos.Sdk;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1835jR implements InterfaceC0883Ks<Bitmap> {
    public static byte[] A06;
    public final int A00;
    public final int A01;
    public final String A02 = C1835jR.class.getSimpleName();
    public final boolean A03;
    public final boolean A04;
    public final boolean A05;

    static {
        A02();
    }

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{-110, -40, -47, -44, 3, 42, 53, 46, 34, 49, -31, 42, 52, -31, 47, 54, 45, 45, -55, -4, -25, -23, -12, -8, -19, -13, -14, -92, -24, -7, -10, -19, -14, -21, -92, -22, -19, -16, -23, -92, -25, -13, -15, -12, -10, -23, -9, -9, -19, -13, -14};
    }

    public C1835jR(int i2, int i8, boolean z2, boolean z7, boolean z8) {
        this.A01 = i2;
        this.A00 = i8;
        this.A05 = z2;
        this.A03 = z7;
        this.A04 = z8;
    }

    public static C0882Kr<Bitmap> A00(Throwable th) {
        return new C0882Kr<>(false, null, th);
    }

    private void A03(File file, Bitmap bitmap) throws IOException {
        if (bitmap == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            ByteArrayOutputStream compressedBitmapOS = new ByteArrayOutputStream();
            byteArrayOutputStream = compressedBitmapOS;
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            if (byteArrayOutputStream.size() >= 3145728) {
                return;
            }
            String str = file.getCanonicalPath() + A01(0, 4, 25);
            File file2 = new File(str);
            file2.createNewFile();
            fileOutputStream = new FileOutputStream(str);
            byteArrayOutputStream.writeTo(fileOutputStream);
            fileOutputStream.flush();
            fileInputStream = new FileInputStream(str);
            fileOutputStream2 = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 > 0) {
                    fileOutputStream2.write(bArr, 0, i2);
                } else {
                    file2.delete();
                    return;
                }
            }
        } finally {
            LB.A07(byteArrayOutputStream);
            LB.A07(fileOutputStream);
            LB.A07(fileInputStream);
            LB.A07(fileOutputStream2);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0883Ks
    public final C0882Kr<Bitmap> A3p(File file, LA la) {
        if (!this.A04) {
            return new C0882Kr<>(true, null);
        }
        try {
            Bitmap bitmapA03 = LB.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
            if (bitmapA03 != null) {
                return new C0882Kr<>(true, bitmapA03);
            }
            la.AAq(new C1828jJ(A01(4, 14, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE)));
            return A00(null);
        } catch (Throwable t3) {
            file.delete();
            la.AAq(t3);
            return A00(t3);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0883Ks
    public final void A55(File file, LA la) throws Throwable {
        if (this.A03) {
            try {
                Bitmap bitmap = LB.A03(file.getCanonicalPath(), this.A01, this.A00, this.A05);
                if (bitmap != null) {
                    A03(file, bitmap);
                } else {
                    file.delete();
                    throw new C1828jJ(A01(4, 14, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE));
                }
            } catch (C1828jJ e) {
                la.AB4(e);
                throw e;
            } catch (Throwable th) {
                la.AB4(th);
                Throwable t3 = new C1828jJ(A01(18, 33, 57), th);
                throw t3;
            }
        }
    }
}
