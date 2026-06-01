package com.instagram.common.viewpoint.core;

import android.content.ContentResolver;
import android.database.Cursor;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1063Rt {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{61, 53, 56, 79, 64, 74, 92, 65, 71, 74, 71, 74, 127, 115, 114, 104, 121, 114, 104, 38, 51, 51, 127, 115, 113, 50, 122, 125, 127, 121, 126, 115, 115, 119, 50, 119, 125, 104, 125, 114, 125, 50, 108, 110, 115, 106, 117, 120, 121, 110, 50, 93, 104, 104, 110, 117, 126, 105, 104, 117, 115, 114, 85, 120, 76, 110, 115, 106, 117, 120, 121, 110, 18, 23, 19, 23, 10, 33, 10, 12, 31, 29, 21, 23, 16, 25};
    }

    public static C1062Rs A00(ContentResolver contentResolver) {
        String strA01 = A01(72, 14, 113);
        String strA012 = A01(3, 9, 33);
        String strA013 = A01(0, 3, 83);
        Cursor c7 = null;
        try {
            c7 = contentResolver.query(WQ.A00(A01(12, 60, 19)), new String[]{strA013, strA012, strA01}, null, null, null);
            if (c7 == null || !c7.moveToFirst()) {
                return new C1062Rs(null, null, false);
            }
            String string = c7.getString(c7.getColumnIndex(strA013));
            String attributionId = c7.getString(c7.getColumnIndex(strA012));
            C1062Rs c1062Rs = new C1062Rs(string, attributionId, Boolean.valueOf(c7.getString(c7.getColumnIndex(strA01))).booleanValue());
            if (c7 != null) {
                c7.close();
            }
            return c1062Rs;
        } finally {
            if (c7 != null) {
                c7.close();
            }
        }
    }
}
