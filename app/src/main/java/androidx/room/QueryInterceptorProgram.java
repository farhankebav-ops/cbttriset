package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class QueryInterceptorProgram implements SupportSQLiteProgram {
    private final List<Object> bindArgsCache = new ArrayList();

    private final void saveArgsToCache(int i2, Object obj) {
        int size;
        int i8 = i2 - 1;
        if (i8 >= this.bindArgsCache.size() && (size = this.bindArgsCache.size()) <= i8) {
            while (true) {
                this.bindArgsCache.add(null);
                if (size == i8) {
                    break;
                } else {
                    size++;
                }
            }
        }
        this.bindArgsCache.set(i8, obj);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i2, byte[] value) {
        k.e(value, "value");
        saveArgsToCache(i2, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i2, double d8) {
        saveArgsToCache(i2, Double.valueOf(d8));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i2, long j) {
        saveArgsToCache(i2, Long.valueOf(j));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i2) {
        saveArgsToCache(i2, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i2, String value) {
        k.e(value, "value");
        saveArgsToCache(i2, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.bindArgsCache.clear();
    }

    public final List<Object> getBindArgsCache$room_runtime_release() {
        return this.bindArgsCache;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
