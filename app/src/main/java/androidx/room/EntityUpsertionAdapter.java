package androidx.room;

import android.database.sqlite.SQLiteConstraintException;
import androidx.annotation.RestrictTo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import n6.m;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class EntityUpsertionAdapter<T> {
    private final EntityInsertionAdapter<T> insertionAdapter;
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertionAdapter(EntityInsertionAdapter<T> insertionAdapter, EntityDeletionOrUpdateAdapter<T> updateAdapter) {
        k.e(insertionAdapter, "insertionAdapter");
        k.e(updateAdapter, "updateAdapter");
        this.insertionAdapter = insertionAdapter;
        this.updateAdapter = updateAdapter;
    }

    private final void checkUniquenessException(SQLiteConstraintException sQLiteConstraintException) {
        String message = sQLiteConstraintException.getMessage();
        if (message == null || !m.q0(message, "1555", true)) {
            throw sQLiteConstraintException;
        }
    }

    public final void upsert(T t3) {
        try {
            this.insertionAdapter.insert(t3);
        } catch (SQLiteConstraintException e) {
            checkUniquenessException(e);
            this.updateAdapter.handle(t3);
        }
    }

    public final long upsertAndReturnId(T t3) {
        try {
            return this.insertionAdapter.insertAndReturnId(t3);
        } catch (SQLiteConstraintException e) {
            checkUniquenessException(e);
            this.updateAdapter.handle(t3);
            return -1L;
        }
    }

    public final long[] upsertAndReturnIdsArray(T[] entities) {
        long jInsertAndReturnId;
        k.e(entities, "entities");
        int length = entities.length;
        long[] jArr = new long[length];
        for (int i2 = 0; i2 < length; i2++) {
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(entities[i2]);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(entities[i2]);
                jInsertAndReturnId = -1;
            }
            jArr[i2] = jInsertAndReturnId;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(T[] entities) {
        long jInsertAndReturnId;
        k.e(entities, "entities");
        int length = entities.length;
        Long[] lArr = new Long[length];
        for (int i2 = 0; i2 < length; i2++) {
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(entities[i2]);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(entities[i2]);
                jInsertAndReturnId = -1;
            }
            lArr[i2] = Long.valueOf(jInsertAndReturnId);
        }
        return lArr;
    }

    public final List<Long> upsertAndReturnIdsList(T[] entities) {
        k.e(entities, "entities");
        s5.c cVarN = q.N();
        for (T t3 : entities) {
            try {
                cVarN.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t3)));
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t3);
                cVarN.add(-1L);
            }
        }
        return q.o(cVarN);
    }

    public final void upsert(T[] entities) {
        k.e(entities, "entities");
        for (T t3 : entities) {
            try {
                this.insertionAdapter.insert(t3);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t3);
            }
        }
    }

    public final long[] upsertAndReturnIdsArray(Collection<? extends T> entities) {
        long jInsertAndReturnId;
        k.e(entities, "entities");
        Iterator<? extends T> it = entities.iterator();
        int size = entities.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            T next = it.next();
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(next);
                jInsertAndReturnId = -1;
            }
            jArr[i2] = jInsertAndReturnId;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(Collection<? extends T> entities) {
        long jInsertAndReturnId;
        k.e(entities, "entities");
        Iterator<? extends T> it = entities.iterator();
        int size = entities.size();
        Long[] lArr = new Long[size];
        for (int i2 = 0; i2 < size; i2++) {
            T next = it.next();
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(next);
                jInsertAndReturnId = -1;
            }
            lArr[i2] = Long.valueOf(jInsertAndReturnId);
        }
        return lArr;
    }

    public final void upsert(Iterable<? extends T> entities) {
        k.e(entities, "entities");
        for (T t3 : entities) {
            try {
                this.insertionAdapter.insert(t3);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t3);
            }
        }
    }

    public final List<Long> upsertAndReturnIdsList(Collection<? extends T> entities) {
        k.e(entities, "entities");
        s5.c cVarN = q.N();
        for (T t3 : entities) {
            try {
                cVarN.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t3)));
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t3);
                cVarN.add(-1L);
            }
        }
        return q.o(cVarN);
    }
}
