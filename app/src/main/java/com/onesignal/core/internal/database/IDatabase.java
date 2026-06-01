package com.onesignal.core.internal.database;

import android.content.ContentValues;
import e6.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IDatabase {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static /* synthetic */ void query$default(IDatabase iDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, l lVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
            }
            if ((i2 & 2) != 0) {
                strArr = null;
            }
            if ((i2 & 4) != 0) {
                str2 = null;
            }
            if ((i2 & 8) != 0) {
                strArr2 = null;
            }
            if ((i2 & 16) != 0) {
                str3 = null;
            }
            if ((i2 & 32) != 0) {
                str4 = null;
            }
            if ((i2 & 64) != 0) {
                str5 = null;
            }
            if ((i2 & 128) != 0) {
                str6 = null;
            }
            iDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6, lVar);
        }
    }

    void delete(String str, String str2, String[] strArr);

    void insert(String str, String str2, ContentValues contentValues);

    void insertOrThrow(String str, String str2, ContentValues contentValues);

    void query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, l lVar);

    int update(String str, ContentValues contentValues, String str2, String[] strArr);
}
