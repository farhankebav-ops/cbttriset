package com.instagram.common.viewpoint.core;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC04804o {
    public static byte[] A00;
    public static String[] A01 = {"ftBSrscYCZrU1XGsUffOBJlxDQfDqofj", "6A6pNCV2uhgoYcLypb", "8GOV2FUSZps1pTbJ4je5MwftASUnZkM1", "4wRLkwVxN17llLy", "8LQiKKC5rqzUsPzG", "bVt1RMPFhi5Vk9jMxK8mGuGgg99xJtg4", "bUya0H86JSXRIIoahVHYTIdtcqgWtSBf", "i4ePvK4hrBrPNKxpSWALXVVM3"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A00(SQLiteDatabase sQLiteDatabase, int i2, String str) throws C04774l {
        try {
        } catch (SQLException e) {
            throw new C04774l(e);
        }
        if (!AbstractC04664a.A19(sQLiteDatabase, A01(159, 17, 73))) {
            return -1;
        }
        Cursor cursorQuery = sQLiteDatabase.query(A01(159, 17, 73), new String[]{A01(244, 7, 93)}, A01(183, 32, 22), A05(i2, str), null, null, null);
        try {
            if (cursorQuery.getCount() == 0) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return -1;
            }
            cursorQuery.moveToNext();
            int i8 = cursorQuery.getInt(0);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return i8;
        } finally {
        }
        throw new C04774l(e);
    }

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{53, 36, 51, 55, 34, 51, 86, 34, 55, 52, 58, 51, 86, 63, 48, 86, 56, 57, 34, 86, 51, 46, 63, 37, 34, 37, 86, 51, 14, 25, 38, 26, 23, 15, 19, 4, 32, 19, 4, 5, 31, 25, 24, 5, 86, 94, 16, 19, 23, 2, 3, 4, 19, 86, 63, 56, 34, 51, 49, 51, 36, 86, 56, 57, 34, 86, 56, 35, 58, 58, 90, 31, 24, 5, 2, 23, 24, 21, 19, 41, 3, 31, 18, 86, 34, 51, 46, 34, 86, 56, 57, 34, 86, 56, 35, 58, 58, 90, 0, 19, 4, 5, 31, 25, 24, 86, 63, 56, 34, 51, 49, 51, 36, 86, 56, 57, 34, 86, 56, 35, 58, 58, 90, 38, 36, 63, 59, 55, 36, 47, 86, 61, 51, 47, 86, 94, 16, 19, 23, 2, 3, 4, 19, 90, 86, 31, 24, 5, 2, 23, 24, 21, 19, 41, 3, 31, 18, 95, 95, 29, 32, 55, 8, 52, 57, 33, 61, 42, 14, 61, 42, 43, 49, 55, 54, 43, 103, 100, 96, 117, 116, 115, 100, 97, 98, 102, 115, 114, 117, 98, 39, 58, 39, 56, 39, 70, 73, 67, 39, 110, 105, 116, 115, 102, 105, 100, 98, 88, 114, 110, 99, 39, 58, 39, 56, 64, 72, 72, 64, 9, 66, 95, 72, 9, 67, 70, 83, 70, 69, 70, 84, 66, 9, 14, 19, 20, 1, 14, 3, 5, 63, 21, 9, 4, 58, 41, 62, 63, 37, 35, 34};
        String[] strArr = A01;
        if (strArr[6].charAt(14) == strArr[5].charAt(14)) {
            throw new RuntimeException();
        }
        A01[7] = "SNjSmBwt36dpbjCWXjm4KdaDp";
    }

    static {
        A02();
        C2T.A03(A01(Sdk.SDKError.Reason.AD_RESPONSE_EMPTY_VALUE, 17, 54));
    }

    public static void A03(SQLiteDatabase sQLiteDatabase, int i2, String str) throws C04774l {
        String strA01 = A01(159, 17, 73);
        try {
            if (!AbstractC04664a.A19(sQLiteDatabase, strA01)) {
                return;
            }
            sQLiteDatabase.delete(strA01, A01(183, 32, 22), A05(i2, str));
        } catch (SQLException e) {
            throw new C04774l(e);
        }
    }

    public static void A04(SQLiteDatabase sQLiteDatabase, int i2, String str, int i8) throws C04774l {
        try {
            sQLiteDatabase.execSQL(A01(0, 159, 103));
            ContentValues contentValues = new ContentValues();
            contentValues.put(A01(176, 7, 16), Integer.valueOf(i2));
            contentValues.put(A01(232, 12, 113), str);
            contentValues.put(A01(244, 7, 93), Integer.valueOf(i8));
            sQLiteDatabase.replaceOrThrow(A01(159, 17, 73), null, contentValues);
        } catch (SQLException e) {
            throw new C04774l(e);
        }
    }

    public static String[] A05(int i2, String str) {
        return new String[]{Integer.toString(i2), str};
    }
}
