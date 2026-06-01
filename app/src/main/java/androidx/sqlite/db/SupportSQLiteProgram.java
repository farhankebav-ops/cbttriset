package androidx.sqlite.db;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int i2, byte[] bArr);

    void bindDouble(int i2, double d8);

    void bindLong(int i2, long j);

    void bindNull(int i2);

    void bindString(int i2, String str);

    void clearBindings();
}
