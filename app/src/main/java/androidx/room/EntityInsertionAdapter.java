package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import d7.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.k;
import r2.q;
import r5.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityInsertionAdapter(RoomDatabase database) {
        super(database);
        k.e(database, "database");
    }

    public abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t3);

    public final void insert(T t3) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            bind(supportSQLiteStatementAcquire, t3);
            supportSQLiteStatementAcquire.executeInsert();
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final long insertAndReturnId(T t3) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            bind(supportSQLiteStatementAcquire, t3);
            return supportSQLiteStatementAcquire.executeInsert();
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> entities) {
        k.e(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            long[] jArr = new long[entities.size()];
            int i2 = 0;
            for (T t3 : entities) {
                int i8 = i2 + 1;
                if (i2 < 0) {
                    m.K0();
                    throw null;
                }
                bind(supportSQLiteStatementAcquire, t3);
                jArr[i2] = supportSQLiteStatementAcquire.executeInsert();
                i2 = i8;
            }
            release(supportSQLiteStatementAcquire);
            return jArr;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> entities) {
        k.e(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        Iterator<? extends T> it = entities.iterator();
        try {
            int size = entities.size();
            Long[] lArr = new Long[size];
            for (int i2 = 0; i2 < size; i2++) {
                bind(supportSQLiteStatementAcquire, it.next());
                lArr[i2] = Long.valueOf(supportSQLiteStatementAcquire.executeInsert());
            }
            return lArr;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] entities) {
        k.e(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            s5.c cVarN = q.N();
            for (T t3 : entities) {
                bind(supportSQLiteStatementAcquire, t3);
                cVarN.add(Long.valueOf(supportSQLiteStatementAcquire.executeInsert()));
            }
            s5.c cVarO = q.o(cVarN);
            release(supportSQLiteStatementAcquire);
            return cVarO;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final void insert(T[] entities) {
        k.e(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            for (T t3 : entities) {
                bind(supportSQLiteStatementAcquire, t3);
                supportSQLiteStatementAcquire.executeInsert();
            }
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] entities) {
        k.e(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            long[] jArr = new long[entities.length];
            int length = entities.length;
            int i2 = 0;
            int i8 = 0;
            while (i2 < length) {
                int i9 = i8 + 1;
                bind(supportSQLiteStatementAcquire, entities[i2]);
                jArr[i8] = supportSQLiteStatementAcquire.executeInsert();
                i2++;
                i8 = i9;
            }
            return jArr;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Long[] insertAndReturnIdsArrayBox(T[] entities) {
        k.e(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        i iVarG = d0.g(entities);
        try {
            int length = entities.length;
            Long[] lArr = new Long[length];
            for (int i2 = 0; i2 < length; i2++) {
                bind(supportSQLiteStatementAcquire, iVarG.next());
                lArr[i2] = Long.valueOf(supportSQLiteStatementAcquire.executeInsert());
            }
            return lArr;
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> entities) {
        k.e(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            s5.c cVarN = q.N();
            Iterator<T> it = entities.iterator();
            while (it.hasNext()) {
                bind(supportSQLiteStatementAcquire, it.next());
                cVarN.add(Long.valueOf(supportSQLiteStatementAcquire.executeInsert()));
            }
            s5.c cVarO = q.o(cVarN);
            release(supportSQLiteStatementAcquire);
            return cVarO;
        } catch (Throwable th) {
            release(supportSQLiteStatementAcquire);
            throw th;
        }
    }

    public final void insert(Iterable<? extends T> entities) {
        k.e(entities, "entities");
        SupportSQLiteStatement supportSQLiteStatementAcquire = acquire();
        try {
            Iterator<? extends T> it = entities.iterator();
            while (it.hasNext()) {
                bind(supportSQLiteStatementAcquire, it.next());
                supportSQLiteStatementAcquire.executeInsert();
            }
        } finally {
            release(supportSQLiteStatementAcquire);
        }
    }
}
