package com.instagram.common.viewpoint.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class UY implements InterfaceC1125Uf {
    public static byte[] A01;
    public final C1477dL A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 12);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{94, 89, 91, 76, 77, 89, 84, 103, 76, 81, 85, 93, 75, 76, 89, 85, 72, 64, 79, 74, 70, 77, 87, 124, 66, 83, 74, 124, 85, 70, 81, 80, 74, 76, 77, 101, 105, 104, 114, 99, 104, 114, 60, 41, 41, 5, 2, 31, 24, 13, 0, 0, 51, 30, 9, 10, 9, 30, 30, 9, 30, 68, 94, 114, 78, 89, 57, 40, 42, 34, 40, 46, 44, 22, 39, 40, 36, 44};
    }

    public UY(C1477dL c1477dL) {
        this.A00 = c1477dL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A03(String str, boolean z2, String str2, String str3, String str4, long j) {
        this.A00.A0F().AB9(str);
        PackageManager packageManager = this.A00.getPackageManager();
        if (packageManager == null) {
            this.A00.A0F().ABE(str);
            return false;
        }
        ContentResolver contentResolver = this.A00.getContentResolver();
        if (contentResolver == null) {
            this.A00.A0F().ABB(str);
            return false;
        }
        if (packageManager.resolveContentProvider(str, 0) == null) {
            this.A00.A0F().ABA(str);
            return false;
        }
        Uri uri = Uri.parse(A00(35, 10, 10) + str + A00(0, 1, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) + str2);
        ContentValues values = new ContentValues();
        values.put(A00(17, 18, 47), (Integer) 1);
        values.put(A00(61, 5, 33), Boolean.valueOf(z2));
        values.put(A00(45, 16, 96), str3);
        values.put(A00(66, 12, 69), str4);
        values.put(A00(1, 16, 52), Long.valueOf(j));
        try {
            contentResolver.insert(uri, values);
            this.A00.A0F().ABG(str);
            return true;
        } catch (UnsupportedOperationException unused) {
            this.A00.A0F().ABD(str);
            return false;
        } catch (Exception unused2) {
            this.A00.A0F().ABC(str);
            return false;
        }
    }

    public final void A04(boolean z2, String str, String str2, String str3, long j, boolean z7) {
        this.A00.A0F().ABF();
        XU.A06.execute(new C1133Un(this, z2, str, str2, str3, j, z7));
    }
}
