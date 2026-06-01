package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.k;
import r2.q;
import r5.j;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public QueryInterceptorDatabase(SupportSQLiteDatabase delegate, Executor queryCallbackExecutor, RoomDatabase.QueryCallback queryCallback) {
        k.e(delegate, "delegate");
        k.e(queryCallbackExecutor, "queryCallbackExecutor");
        k.e(queryCallback, "queryCallback");
        this.delegate = delegate;
        this.queryCallbackExecutor = queryCallbackExecutor;
        this.queryCallback = queryCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransaction$lambda$0(QueryInterceptorDatabase this$0) {
        k.e(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", r.f13638a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransactionNonExclusive$lambda$1(QueryInterceptorDatabase this$0) {
        k.e(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", r.f13638a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransactionWithListener$lambda$2(QueryInterceptorDatabase this$0) {
        k.e(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", r.f13638a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beginTransactionWithListenerNonExclusive$lambda$3(QueryInterceptorDatabase this$0) {
        k.e(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", r.f13638a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endTransaction$lambda$4(QueryInterceptorDatabase this$0) {
        k.e(this$0, "this$0");
        this$0.queryCallback.onQuery("END TRANSACTION", r.f13638a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execSQL$lambda$10(QueryInterceptorDatabase this$0, String sql) {
        k.e(this$0, "this$0");
        k.e(sql, "$sql");
        this$0.queryCallback.onQuery(sql, r.f13638a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execSQL$lambda$11(QueryInterceptorDatabase this$0, String sql, List inputArguments) {
        k.e(this$0, "this$0");
        k.e(sql, "$sql");
        k.e(inputArguments, "$inputArguments");
        this$0.queryCallback.onQuery(sql, inputArguments);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$6(QueryInterceptorDatabase this$0, String query) {
        k.e(this$0, "this$0");
        k.e(query, "$query");
        this$0.queryCallback.onQuery(query, r.f13638a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$7(QueryInterceptorDatabase this$0, String query, Object[] bindArgs) {
        k.e(this$0, "this$0");
        k.e(query, "$query");
        k.e(bindArgs, "$bindArgs");
        this$0.queryCallback.onQuery(query, j.s0(bindArgs));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$8(QueryInterceptorDatabase this$0, SupportSQLiteQuery query, QueryInterceptorProgram queryInterceptorProgram) {
        k.e(this$0, "this$0");
        k.e(query, "$query");
        k.e(queryInterceptorProgram, "$queryInterceptorProgram");
        this$0.queryCallback.onQuery(query.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void query$lambda$9(QueryInterceptorDatabase this$0, SupportSQLiteQuery query, QueryInterceptorProgram queryInterceptorProgram) {
        k.e(this$0, "this$0");
        k.e(query, "$query");
        k.e(queryInterceptorProgram, "$queryInterceptorProgram");
        this$0.queryCallback.onQuery(query.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTransactionSuccessful$lambda$5(QueryInterceptorDatabase this$0) {
        k.e(this$0, "this$0");
        this$0.queryCallback.onQuery("TRANSACTION SUCCESSFUL", r.f13638a);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.queryCallbackExecutor.execute(new c(this, 2));
        this.delegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.queryCallbackExecutor.execute(new c(this, 4));
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
        k.e(transactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new c(this, 5));
        this.delegate.beginTransactionWithListener(transactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener transactionListener) {
        k.e(transactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new c(this, 1));
        this.delegate.beginTransactionWithListenerNonExclusive(transactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String sql) {
        k.e(sql, "sql");
        return new QueryInterceptorStatement(this.delegate.compileStatement(sql), sql, this.queryCallbackExecutor, this.queryCallback);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String table, String str, Object[] objArr) {
        k.e(table, "table");
        return this.delegate.delete(table, str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.queryCallbackExecutor.execute(new c(this, 0));
        this.delegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(String sql, Object[] objArr) {
        k.e(sql, "sql");
        this.delegate.execPerConnectionSQL(sql, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String sql) {
        k.e(sql, "sql");
        this.queryCallbackExecutor.execute(new d(this, sql, 1));
        this.delegate.execSQL(sql);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.delegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.delegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String table, int i2, ContentValues values) {
        k.e(table, "table");
        k.e(values, "values");
        return this.delegate.insert(table, i2, values);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isExecPerConnectionSQLSupported() {
        return this.delegate.isExecPerConnectionSQLSupported();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int i2) {
        return this.delegate.needUpgrade(i2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String query) {
        k.e(query, "query");
        this.queryCallbackExecutor.execute(new d(this, query, 0));
        return this.delegate.query(query);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean z2) {
        this.delegate.setForeignKeyConstraintsEnabled(z2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale locale) {
        k.e(locale, "locale");
        this.delegate.setLocale(locale);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int i2) {
        this.delegate.setMaxSqlCacheSize(i2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long j) {
        return this.delegate.setMaximumSize(j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long j) {
        this.delegate.setPageSize(j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.queryCallbackExecutor.execute(new c(this, 3));
        this.delegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int i2) {
        this.delegate.setVersion(i2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String table, int i2, ContentValues values, String str, Object[] objArr) {
        k.e(table, "table");
        k.e(values, "values");
        return this.delegate.update(table, i2, values, str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long j) {
        return this.delegate.yieldIfContendedSafely(j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String sql, Object[] bindArgs) {
        k.e(sql, "sql");
        k.e(bindArgs, "bindArgs");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(q.j0(bindArgs));
        this.queryCallbackExecutor.execute(new androidx.camera.core.processing.c(this, sql, arrayList, 7));
        this.delegate.execSQL(sql, new List[]{arrayList});
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String query, Object[] bindArgs) {
        k.e(query, "query");
        k.e(bindArgs, "bindArgs");
        this.queryCallbackExecutor.execute(new androidx.camera.core.processing.c(this, query, bindArgs, 6));
        return this.delegate.query(query, bindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery query) {
        k.e(query, "query");
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        query.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new e(this, query, queryInterceptorProgram, 0));
        return this.delegate.query(query);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery query, CancellationSignal cancellationSignal) {
        k.e(query, "query");
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        query.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new e(this, query, queryInterceptorProgram, 1));
        return this.delegate.query(query);
    }
}
