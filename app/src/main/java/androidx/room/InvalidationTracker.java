package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import kotlin.jvm.internal.k;
import r2.q;
import r5.l;
import r5.s;
import r5.t;
import r5.x;
import s5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    public static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";
    public static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    private AutoCloser autoCloser;
    private volatile SupportSQLiteStatement cleanupStatement;
    private final RoomDatabase database;
    private volatile boolean initialized;
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    private final ObservedTableTracker observedTableTracker;

    @GuardedBy("observerMap")
    private final SafeIterableMap<Observer, ObserverWrapper> observerMap;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    private final AtomicBoolean pendingRefresh;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final Runnable refreshRunnable;
    private final Map<String, String> shadowTablesMap;
    private final Object syncTriggersLock;
    private final Map<String, Integer> tableIdLookup;
    private final String[] tablesNames;
    private final Object trackerLock;
    private final Map<String, Set<String>> viewTables;
    public static final Companion Companion = new Companion(null);
    private static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final void beginTransactionInternal$room_runtime_release(SupportSQLiteDatabase database) {
            k.e(database, "database");
            if (database.isWriteAheadLoggingEnabled()) {
                database.beginTransactionNonExclusive();
            } else {
                database.beginTransaction();
            }
        }

        public final String getTriggerName$room_runtime_release(String tableName, String triggerType) {
            k.e(tableName, "tableName");
            k.e(triggerType, "triggerType");
            return "`room_table_modification_trigger_" + tableName + '_' + triggerType + '`';
        }

        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ObservedTableTracker {
        public static final int ADD = 1;
        public static final Companion Companion = new Companion(null);
        public static final int NO_OP = 0;
        public static final int REMOVE = 2;
        private boolean needsSync;
        private final long[] tableObservers;
        private final int[] triggerStateChanges;
        private final boolean[] triggerStates;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            private Companion() {
            }
        }

        public ObservedTableTracker(int i2) {
            this.tableObservers = new long[i2];
            this.triggerStates = new boolean[i2];
            this.triggerStateChanges = new int[i2];
        }

        public final boolean getNeedsSync() {
            return this.needsSync;
        }

        public final long[] getTableObservers() {
            return this.tableObservers;
        }

        @VisibleForTesting
        public final int[] getTablesToSync() {
            synchronized (this) {
                try {
                    if (!this.needsSync) {
                        return null;
                    }
                    long[] jArr = this.tableObservers;
                    int length = jArr.length;
                    int i2 = 0;
                    int i8 = 0;
                    while (i2 < length) {
                        int i9 = i8 + 1;
                        int i10 = 1;
                        boolean z2 = jArr[i2] > 0;
                        boolean[] zArr = this.triggerStates;
                        if (z2 != zArr[i8]) {
                            int[] iArr = this.triggerStateChanges;
                            if (!z2) {
                                i10 = 2;
                            }
                            iArr[i8] = i10;
                        } else {
                            this.triggerStateChanges[i8] = 0;
                        }
                        zArr[i8] = z2;
                        i2++;
                        i8 = i9;
                    }
                    this.needsSync = false;
                    return (int[]) this.triggerStateChanges.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean onAdded(int... tableIds) {
            boolean z2;
            k.e(tableIds, "tableIds");
            synchronized (this) {
                z2 = false;
                for (int i2 : tableIds) {
                    long[] jArr = this.tableObservers;
                    long j = jArr[i2];
                    jArr[i2] = 1 + j;
                    if (j == 0) {
                        z2 = true;
                        this.needsSync = true;
                    }
                }
            }
            return z2;
        }

        public final boolean onRemoved(int... tableIds) {
            boolean z2;
            k.e(tableIds, "tableIds");
            synchronized (this) {
                z2 = false;
                for (int i2 : tableIds) {
                    long[] jArr = this.tableObservers;
                    long j = jArr[i2];
                    jArr[i2] = j - 1;
                    if (j == 1) {
                        z2 = true;
                        this.needsSync = true;
                    }
                }
            }
            return z2;
        }

        public final void resetTriggerState() {
            synchronized (this) {
                Arrays.fill(this.triggerStates, false);
                this.needsSync = true;
            }
        }

        public final void setNeedsSync(boolean z2) {
            this.needsSync = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Observer {
        private final String[] tables;

        public Observer(String[] tables) {
            k.e(tables, "tables");
            this.tables = tables;
        }

        public final String[] getTables$room_runtime_release() {
            return this.tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(Set<String> set);

        /* JADX WARN: Illegal instructions before constructor call */
        public Observer(String firstTable, String... rest) {
            k.e(firstTable, "firstTable");
            k.e(rest, "rest");
            s5.c cVarN = q.N();
            l.R0(cVarN, rest);
            cVarN.add(firstTable);
            this((String[]) q.o(cVarN).toArray(new String[0]));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ObserverWrapper {
        private final Observer observer;
        private final Set<String> singleTableSet;
        private final int[] tableIds;
        private final String[] tableNames;

        public ObserverWrapper(Observer observer, int[] tableIds, String[] tableNames) {
            k.e(observer, "observer");
            k.e(tableIds, "tableIds");
            k.e(tableNames, "tableNames");
            this.observer = observer;
            this.tableIds = tableIds;
            this.tableNames = tableNames;
            this.singleTableSet = !(tableNames.length == 0) ? n7.b.N(tableNames[0]) : t.f13640a;
            if (tableIds.length != tableNames.length) {
                throw new IllegalStateException("Check failed.");
            }
        }

        public final Observer getObserver$room_runtime_release() {
            return this.observer;
        }

        public final int[] getTableIds$room_runtime_release() {
            return this.tableIds;
        }

        public final void notifyByTableInvalidStatus$room_runtime_release(Set<Integer> invalidatedTablesIds) {
            k.e(invalidatedTablesIds, "invalidatedTablesIds");
            int[] iArr = this.tableIds;
            int length = iArr.length;
            Set<String> setF = t.f13640a;
            if (length != 0) {
                int i2 = 0;
                if (length != 1) {
                    i iVar = new i();
                    int[] iArr2 = this.tableIds;
                    int length2 = iArr2.length;
                    int i8 = 0;
                    while (i2 < length2) {
                        int i9 = i8 + 1;
                        if (invalidatedTablesIds.contains(Integer.valueOf(iArr2[i2]))) {
                            iVar.add(this.tableNames[i8]);
                        }
                        i2++;
                        i8 = i9;
                    }
                    setF = n7.b.f(iVar);
                } else if (invalidatedTablesIds.contains(Integer.valueOf(iArr[0]))) {
                    setF = this.singleTableSet;
                }
            }
            if (setF.isEmpty()) {
                return;
            }
            this.observer.onInvalidated(setF);
        }

        public final void notifyByTableNames$room_runtime_release(String[] tables) {
            k.e(tables, "tables");
            int length = this.tableNames.length;
            Set<String> setF = t.f13640a;
            if (length != 0) {
                if (length != 1) {
                    i iVar = new i();
                    for (String str : tables) {
                        for (String str2 : this.tableNames) {
                            if (n6.t.g0(str2, str)) {
                                iVar.add(str2);
                            }
                        }
                    }
                    setF = n7.b.f(iVar);
                } else {
                    int length2 = tables.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            break;
                        }
                        if (n6.t.g0(tables[i2], this.tableNames[0])) {
                            setF = this.singleTableSet;
                            break;
                        }
                        i2++;
                    }
                }
            }
            if (setF.isEmpty()) {
                return;
            }
            this.observer.onInvalidated(setF);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class WeakObserver extends Observer {
        private final WeakReference<Observer> delegateRef;
        private final InvalidationTracker tracker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WeakObserver(InvalidationTracker tracker, Observer delegate) {
            super(delegate.getTables$room_runtime_release());
            k.e(tracker, "tracker");
            k.e(delegate, "delegate");
            this.tracker = tracker;
            this.delegateRef = new WeakReference<>(delegate);
        }

        public final WeakReference<Observer> getDelegateRef() {
            return this.delegateRef;
        }

        public final InvalidationTracker getTracker() {
            return this.tracker;
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(Set<String> tables) {
            k.e(tables, "tables");
            Observer observer = this.delegateRef.get();
            if (observer == null) {
                this.tracker.removeObserver(this);
            } else {
                observer.onInvalidated(tables);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase database, Map<String, String> shadowTablesMap, Map<String, Set<String>> viewTables, String... tableNames) {
        String lowerCase;
        k.e(database, "database");
        k.e(shadowTablesMap, "shadowTablesMap");
        k.e(viewTables, "viewTables");
        k.e(tableNames, "tableNames");
        this.database = database;
        this.shadowTablesMap = shadowTablesMap;
        this.viewTables = viewTables;
        this.pendingRefresh = new AtomicBoolean(false);
        this.observedTableTracker = new ObservedTableTracker(tableNames.length);
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(database);
        this.observerMap = new SafeIterableMap<>();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int length = tableNames.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = tableNames[i2];
            Locale US = Locale.US;
            k.d(US, "US");
            String lowerCase2 = str.toLowerCase(US);
            k.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            this.tableIdLookup.put(lowerCase2, Integer.valueOf(i2));
            String str2 = this.shadowTablesMap.get(tableNames[i2]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(US);
                k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr[i2] = lowerCase2;
        }
        this.tablesNames = strArr;
        for (Map.Entry<String, String> entry : this.shadowTablesMap.entrySet()) {
            String value = entry.getValue();
            Locale US2 = Locale.US;
            k.d(US2, "US");
            String lowerCase3 = value.toLowerCase(US2);
            k.d(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            if (this.tableIdLookup.containsKey(lowerCase3)) {
                String lowerCase4 = entry.getKey().toLowerCase(US2);
                k.d(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                Map<String, Integer> map = this.tableIdLookup;
                map.put(lowerCase4, (Integer) x.b0(map, lowerCase3));
            }
        }
        this.refreshRunnable = new Runnable() { // from class: androidx.room.InvalidationTracker$refreshRunnable$1
            private final Set<Integer> checkUpdatedTable() throws IOException {
                InvalidationTracker invalidationTracker = this.this$0;
                i iVar = new i();
                Cursor cursorQuery$default = RoomDatabase.query$default(invalidationTracker.getDatabase$room_runtime_release(), new SimpleSQLiteQuery(InvalidationTracker.SELECT_UPDATED_TABLES_SQL), null, 2, null);
                while (cursorQuery$default.moveToNext()) {
                    try {
                        iVar.add(Integer.valueOf(cursorQuery$default.getInt(0)));
                    } finally {
                    }
                }
                cursorQuery$default.close();
                i iVarF = n7.b.f(iVar);
                if (iVarF.f13717a.isEmpty()) {
                    return iVarF;
                }
                if (this.this$0.getCleanupStatement$room_runtime_release() == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                SupportSQLiteStatement cleanupStatement$room_runtime_release = this.this$0.getCleanupStatement$room_runtime_release();
                if (cleanupStatement$room_runtime_release == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                cleanupStatement$room_runtime_release.executeUpdateDelete();
                return iVarF;
            }

            @Override // java.lang.Runnable
            public void run() {
                Set<Integer> setCheckUpdatedTable;
                AutoCloser autoCloser;
                AutoCloser autoCloser2;
                Lock closeLock$room_runtime_release = this.this$0.getDatabase$room_runtime_release().getCloseLock$room_runtime_release();
                closeLock$room_runtime_release.lock();
                try {
                    try {
                    } catch (SQLiteException e) {
                        Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e);
                        setCheckUpdatedTable = t.f13640a;
                        closeLock$room_runtime_release.unlock();
                        autoCloser = this.this$0.autoCloser;
                        if (autoCloser != null) {
                        }
                    } catch (IllegalStateException e4) {
                        Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e4);
                        setCheckUpdatedTable = t.f13640a;
                        closeLock$room_runtime_release.unlock();
                        autoCloser = this.this$0.autoCloser;
                        if (autoCloser != null) {
                        }
                    }
                    if (!this.this$0.ensureInitialization$room_runtime_release()) {
                        if (autoCloser2 != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                    if (!this.this$0.getPendingRefresh().compareAndSet(true, false)) {
                        closeLock$room_runtime_release.unlock();
                        AutoCloser autoCloser3 = this.this$0.autoCloser;
                        if (autoCloser3 != null) {
                            autoCloser3.decrementCountAndScheduleClose();
                            return;
                        }
                        return;
                    }
                    if (this.this$0.getDatabase$room_runtime_release().inTransaction()) {
                        closeLock$room_runtime_release.unlock();
                        AutoCloser autoCloser4 = this.this$0.autoCloser;
                        if (autoCloser4 != null) {
                            autoCloser4.decrementCountAndScheduleClose();
                            return;
                        }
                        return;
                    }
                    SupportSQLiteDatabase writableDatabase = this.this$0.getDatabase$room_runtime_release().getOpenHelper().getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        setCheckUpdatedTable = checkUpdatedTable();
                        writableDatabase.setTransactionSuccessful();
                        closeLock$room_runtime_release.unlock();
                        autoCloser = this.this$0.autoCloser;
                        if (autoCloser != null) {
                            autoCloser.decrementCountAndScheduleClose();
                        }
                        if (setCheckUpdatedTable.isEmpty()) {
                            return;
                        }
                        SafeIterableMap<InvalidationTracker.Observer, InvalidationTracker.ObserverWrapper> observerMap$room_runtime_release = this.this$0.getObserverMap$room_runtime_release();
                        InvalidationTracker invalidationTracker = this.this$0;
                        synchronized (observerMap$room_runtime_release) {
                            Iterator<Map.Entry<K, V>> it = invalidationTracker.getObserverMap$room_runtime_release().iterator();
                            while (it.hasNext()) {
                                ((InvalidationTracker.ObserverWrapper) ((Map.Entry) it.next()).getValue()).notifyByTableInvalidStatus$room_runtime_release(setCheckUpdatedTable);
                            }
                        }
                    } finally {
                        writableDatabase.endTransaction();
                    }
                } finally {
                    closeLock$room_runtime_release.unlock();
                    autoCloser2 = this.this$0.autoCloser;
                    if (autoCloser2 != null) {
                        autoCloser2.decrementCountAndScheduleClose();
                    }
                }
            }
        };
    }

    private final String[] resolveViews(String[] strArr) {
        i iVar = new i();
        for (String str : strArr) {
            Map<String, Set<String>> map = this.viewTables;
            Locale US = Locale.US;
            k.d(US, "US");
            String lowerCase = str.toLowerCase(US);
            k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map<String, Set<String>> map2 = this.viewTables;
                String lowerCase2 = str.toLowerCase(US);
                k.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Set<String> set = map2.get(lowerCase2);
                k.b(set);
                iVar.addAll(set);
            } else {
                iVar.add(str);
            }
        }
        Object[] array = n7.b.f(iVar).toArray(new String[0]);
        k.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    private final void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i2) {
        supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i2 + ", 0)");
        String str = this.tablesNames[i2];
        for (String str2 : TRIGGERS) {
            StringBuilder sb = new StringBuilder("CREATE TEMP TRIGGER IF NOT EXISTS ");
            sb.append(Companion.getTriggerName$room_runtime_release(str, str2));
            sb.append(" AFTER ");
            androidx.camera.core.processing.util.a.A(sb, str2, " ON `", str, "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = ");
            sb.append(i2);
            sb.append(" AND invalidated = 0; END");
            String string = sb.toString();
            k.d(string, "StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.execSQL(string);
        }
    }

    private final void stopTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i2) {
        String str = this.tablesNames[i2];
        for (String str2 : TRIGGERS) {
            String str3 = "DROP TRIGGER IF EXISTS " + Companion.getTriggerName$room_runtime_release(str, str2);
            k.d(str3, "StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.execSQL(str3);
        }
    }

    private final String[] validateAndResolveTableNames(String[] strArr) {
        String[] strArrResolveViews = resolveViews(strArr);
        for (String str : strArrResolveViews) {
            Map<String, Integer> map = this.tableIdLookup;
            Locale US = Locale.US;
            k.d(US, "US");
            String lowerCase = str.toLowerCase(US);
            k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!map.containsKey(lowerCase)) {
                throw new IllegalArgumentException("There is no table with name ".concat(str).toString());
            }
        }
        return strArrResolveViews;
    }

    @WorkerThread
    public void addObserver(Observer observer) {
        ObserverWrapper observerWrapperPutIfAbsent;
        k.e(observer, "observer");
        String[] strArrResolveViews = resolveViews(observer.getTables$room_runtime_release());
        ArrayList arrayList = new ArrayList(strArrResolveViews.length);
        for (String str : strArrResolveViews) {
            Map<String, Integer> map = this.tableIdLookup;
            Locale US = Locale.US;
            k.d(US, "US");
            String lowerCase = str.toLowerCase(US);
            k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name ".concat(str));
            }
            arrayList.add(num);
        }
        int[] iArrM1 = l.m1(arrayList);
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArrM1, strArrResolveViews);
        synchronized (this.observerMap) {
            observerWrapperPutIfAbsent = this.observerMap.putIfAbsent(observer, observerWrapper);
        }
        if (observerWrapperPutIfAbsent == null && this.observedTableTracker.onAdded(Arrays.copyOf(iArrM1, iArrM1.length))) {
            syncTriggers$room_runtime_release();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addWeakObserver(Observer observer) {
        k.e(observer, "observer");
        addObserver(new WeakObserver(this, observer));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] tableNames, Callable<T> computeFunction) {
        k.e(tableNames, "tableNames");
        k.e(computeFunction, "computeFunction");
        return createLiveData(tableNames, false, computeFunction);
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (!this.database.isOpen()) {
            return false;
        }
        if (!this.initialized) {
            this.database.getOpenHelper().getWritableDatabase();
        }
        if (this.initialized) {
            return true;
        }
        Log.e(Room.LOG_TAG, "database is not initialized even though it is open");
        return false;
    }

    public final SupportSQLiteStatement getCleanupStatement$room_runtime_release() {
        return this.cleanupStatement;
    }

    public final RoomDatabase getDatabase$room_runtime_release() {
        return this.database;
    }

    public final SafeIterableMap<Observer, ObserverWrapper> getObserverMap$room_runtime_release() {
        return this.observerMap;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final AtomicBoolean getPendingRefresh() {
        return this.pendingRefresh;
    }

    public final Map<String, Integer> getTableIdLookup$room_runtime_release() {
        return this.tableIdLookup;
    }

    public final String[] getTablesNames$room_runtime_release() {
        return this.tablesNames;
    }

    public final void internalInit$room_runtime_release(SupportSQLiteDatabase database) {
        k.e(database, "database");
        synchronized (this.trackerLock) {
            if (this.initialized) {
                Log.e(Room.LOG_TAG, "Invalidation tracker is initialized twice :/.");
                return;
            }
            database.execSQL("PRAGMA temp_store = MEMORY;");
            database.execSQL("PRAGMA recursive_triggers='ON';");
            database.execSQL(CREATE_TRACKING_TABLE_SQL);
            syncTriggers$room_runtime_release(database);
            this.cleanupStatement = database.compileStatement(RESET_UPDATED_TABLES_SQL);
            this.initialized = true;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting(otherwise = 3)
    public final void notifyObserversByTableNames(String... tables) {
        k.e(tables, "tables");
        synchronized (this.observerMap) {
            Iterator<Map.Entry<K, V>> it = this.observerMap.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                k.d(entry, "(observer, wrapper)");
                Observer observer = (Observer) entry.getKey();
                ObserverWrapper observerWrapper = (ObserverWrapper) entry.getValue();
                if (!observer.isRemote$room_runtime_release()) {
                    observerWrapper.notifyByTableNames$room_runtime_release(tables);
                }
            }
        }
    }

    public final void onAutoCloseCallback$room_runtime_release() {
        synchronized (this.trackerLock) {
            this.initialized = false;
            this.observedTableTracker.resetTriggerState();
        }
    }

    public void refreshVersionsAsync() {
        if (this.pendingRefresh.compareAndSet(false, true)) {
            AutoCloser autoCloser = this.autoCloser;
            if (autoCloser != null) {
                autoCloser.incrementCountAndEnsureDbIsOpen();
            }
            this.database.getQueryExecutor().execute(this.refreshRunnable);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void refreshVersionsSync() {
        AutoCloser autoCloser = this.autoCloser;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        syncTriggers$room_runtime_release();
        this.refreshRunnable.run();
    }

    @WorkerThread
    public void removeObserver(Observer observer) {
        ObserverWrapper observerWrapperRemove;
        k.e(observer, "observer");
        synchronized (this.observerMap) {
            observerWrapperRemove = this.observerMap.remove(observer);
        }
        if (observerWrapperRemove != null) {
            ObservedTableTracker observedTableTracker = this.observedTableTracker;
            int[] tableIds$room_runtime_release = observerWrapperRemove.getTableIds$room_runtime_release();
            if (observedTableTracker.onRemoved(Arrays.copyOf(tableIds$room_runtime_release, tableIds$room_runtime_release.length))) {
                syncTriggers$room_runtime_release();
            }
        }
    }

    public final void setAutoCloser$room_runtime_release(AutoCloser autoCloser) {
        k.e(autoCloser, "autoCloser");
        this.autoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new a3.b(this, 13));
    }

    public final void setCleanupStatement$room_runtime_release(SupportSQLiteStatement supportSQLiteStatement) {
        this.cleanupStatement = supportSQLiteStatement;
    }

    public final void startMultiInstanceInvalidation$room_runtime_release(Context context, String name, Intent serviceIntent) {
        k.e(context, "context");
        k.e(name, "name");
        k.e(serviceIntent, "serviceIntent");
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, name, serviceIntent, this, this.database.getQueryExecutor());
    }

    public final void stopMultiInstanceInvalidation$room_runtime_release() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
        }
        this.multiInstanceInvalidationClient = null;
    }

    public final void syncTriggers$room_runtime_release(SupportSQLiteDatabase database) {
        k.e(database, "database");
        if (database.inTransaction()) {
            return;
        }
        try {
            Lock closeLock$room_runtime_release = this.database.getCloseLock$room_runtime_release();
            closeLock$room_runtime_release.lock();
            try {
                synchronized (this.syncTriggersLock) {
                    int[] tablesToSync = this.observedTableTracker.getTablesToSync();
                    if (tablesToSync != null) {
                        Companion.beginTransactionInternal$room_runtime_release(database);
                        try {
                            int length = tablesToSync.length;
                            int i2 = 0;
                            int i8 = 0;
                            while (i2 < length) {
                                int i9 = tablesToSync[i2];
                                int i10 = i8 + 1;
                                if (i9 == 1) {
                                    startTrackingTable(database, i8);
                                } else if (i9 == 2) {
                                    stopTrackingTable(database, i8);
                                }
                                i2++;
                                i8 = i10;
                            }
                            database.setTransactionSuccessful();
                            database.endTransaction();
                        } catch (Throwable th) {
                            database.endTransaction();
                            throw th;
                        }
                    }
                }
            } finally {
                closeLock$room_runtime_release.unlock();
            }
        } catch (SQLiteException e) {
            Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e);
        } catch (IllegalStateException e4) {
            Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e4);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] tableNames, boolean z2, Callable<T> computeFunction) {
        k.e(tableNames, "tableNames");
        k.e(computeFunction, "computeFunction");
        return this.invalidationLiveDataContainer.create(validateAndResolveTableNames(tableNames), z2, computeFunction);
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshRunnable$annotations() {
    }

    public final void syncTriggers$room_runtime_release() {
        if (this.database.isOpen()) {
            syncTriggers$room_runtime_release(this.database.getOpenHelper().getWritableDatabase());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase database, String... tableNames) {
        k.e(database, "database");
        k.e(tableNames, "tableNames");
        String[] strArr = (String[]) Arrays.copyOf(tableNames, tableNames.length);
        s sVar = s.f13639a;
        this(database, sVar, sVar, strArr);
    }
}
