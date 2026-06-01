package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import kotlin.jvm.internal.k;
import n6.t;
import r2.q;
import s5.a;
import s5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class DBUtil {
    public static final CancellationSignal createCancellationSignal() {
        return SupportSQLiteCompat.Api16Impl.createCancellationSignal();
    }

    public static final void dropFtsSyncTriggers(SupportSQLiteDatabase db) throws IOException {
        k.e(db, "db");
        c cVarN = q.N();
        Cursor cursorQuery = db.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorQuery.moveToNext()) {
            try {
                cVarN.add(cursorQuery.getString(0));
            } finally {
            }
        }
        cursorQuery.close();
        ListIterator listIterator = q.o(cVarN).listIterator(0);
        while (true) {
            a aVar = (a) listIterator;
            if (!aVar.hasNext()) {
                return;
            }
            String triggerName = (String) aVar.next();
            k.d(triggerName, "triggerName");
            if (t.n0(triggerName, "room_fts_content_sync_", false)) {
                db.execSQL("DROP TRIGGER IF EXISTS ".concat(triggerName));
            }
        }
    }

    public static final void foreignKeyCheck(SupportSQLiteDatabase db, String tableName) throws IOException {
        k.e(db, "db");
        k.e(tableName, "tableName");
        Cursor cursorQuery = db.query("PRAGMA foreign_key_check(`" + tableName + "`)");
        try {
            if (cursorQuery.getCount() > 0) {
                throw new SQLiteConstraintException(processForeignKeyCheckFailure(cursorQuery));
            }
            q.I(cursorQuery, null);
        } finally {
        }
    }

    private static final String processForeignKeyCheckFailure(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        int count = cursor.getCount();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (cursor.moveToNext()) {
            if (cursor.isFirst()) {
                sb.append("Foreign key violation(s) detected in '");
                sb.append(cursor.getString(0));
                sb.append("'.\n");
            }
            String constraintIndex = cursor.getString(3);
            if (!linkedHashMap.containsKey(constraintIndex)) {
                k.d(constraintIndex, "constraintIndex");
                String string = cursor.getString(2);
                k.d(string, "cursor.getString(2)");
                linkedHashMap.put(constraintIndex, string);
            }
        }
        sb.append("Number of different violations discovered: ");
        sb.append(linkedHashMap.keySet().size());
        sb.append("\nNumber of rows in violation: ");
        sb.append(count);
        sb.append("\nViolation(s) detected in the following constraint(s):\n");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            androidx.camera.core.processing.util.a.A(sb, "\tParent Table = ", (String) entry.getValue(), ", Foreign Key Constraint Index = ", (String) entry.getKey());
            sb.append("\n");
        }
        String string2 = sb.toString();
        k.d(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public static final Cursor query(RoomDatabase db, SupportSQLiteQuery sqLiteQuery, boolean z2) {
        k.e(db, "db");
        k.e(sqLiteQuery, "sqLiteQuery");
        return query(db, sqLiteQuery, z2, null);
    }

    public static final int readVersion(File databaseFile) throws IOException {
        k.e(databaseFile, "databaseFile");
        FileChannel channel = new FileInputStream(databaseFile).getChannel();
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i2 = byteBufferAllocate.getInt();
            q.I(channel, null);
            return i2;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                q.I(channel, th);
                throw th2;
            }
        }
    }

    public static final Cursor query(RoomDatabase db, SupportSQLiteQuery sqLiteQuery, boolean z2, CancellationSignal cancellationSignal) {
        k.e(db, "db");
        k.e(sqLiteQuery, "sqLiteQuery");
        Cursor cursorQuery = db.query(sqLiteQuery, cancellationSignal);
        if (!z2 || !(cursorQuery instanceof AbstractWindowedCursor)) {
            return cursorQuery;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorQuery;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? CursorUtil.copyAndClose(cursorQuery) : cursorQuery;
    }
}
