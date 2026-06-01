package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.k;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List<AutoMigrationSpec> autoMigrationSpecs;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final Callable<InputStream> copyFromInputStream;
    public final RoomDatabase.JournalMode journalMode;
    public final RoomDatabase.MigrationContainer migrationContainer;
    private final Set<Integer> migrationNotRequiredFrom;
    public final boolean multiInstanceInvalidation;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final Intent multiInstanceInvalidationServiceIntent;
    public final String name;
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;
    public final List<Object> typeConverters;

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, Intent intent, boolean z7, boolean z8, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> typeConverters, List<? extends AutoMigrationSpec> autoMigrationSpecs) {
        k.e(context, "context");
        k.e(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        k.e(migrationContainer, "migrationContainer");
        k.e(journalMode, "journalMode");
        k.e(queryExecutor, "queryExecutor");
        k.e(transactionExecutor, "transactionExecutor");
        k.e(typeConverters, "typeConverters");
        k.e(autoMigrationSpecs, "autoMigrationSpecs");
        this.context = context;
        this.name = str;
        this.sqliteOpenHelperFactory = sqliteOpenHelperFactory;
        this.migrationContainer = migrationContainer;
        this.callbacks = list;
        this.allowMainThreadQueries = z2;
        this.journalMode = journalMode;
        this.queryExecutor = queryExecutor;
        this.transactionExecutor = transactionExecutor;
        this.multiInstanceInvalidationServiceIntent = intent;
        this.requireMigration = z7;
        this.allowDestructiveMigrationOnDowngrade = z8;
        this.migrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
        this.typeConverters = typeConverters;
        this.autoMigrationSpecs = autoMigrationSpecs;
        this.multiInstanceInvalidation = intent != null;
    }

    public boolean isMigrationRequired(int i2, int i8) {
        Set<Integer> set;
        return (i2 <= i8 || !this.allowDestructiveMigrationOnDowngrade) && this.requireMigration && ((set = this.migrationNotRequiredFrom) == null || !set.contains(Integer.valueOf(i2)));
    }

    public boolean isMigrationRequiredFrom(int i2) {
        return isMigrationRequired(i2, i2 + 1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor queryExecutor, boolean z7, Set<Integer> set) {
        k.e(context, "context");
        k.e(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        k.e(migrationContainer, "migrationContainer");
        k.e(journalMode, "journalMode");
        k.e(queryExecutor, "queryExecutor");
        r rVar = r.f13638a;
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z2, journalMode, queryExecutor, queryExecutor, (Intent) null, z7, false, set, (String) null, (File) null, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<? extends Object>) rVar, (List<? extends AutoMigrationSpec>) rVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, boolean z7, boolean z8, boolean z9, Set<Integer> set) {
        k.e(context, "context");
        k.e(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        k.e(migrationContainer, "migrationContainer");
        k.e(journalMode, "journalMode");
        k.e(queryExecutor, "queryExecutor");
        k.e(transactionExecutor, "transactionExecutor");
        Intent intent = z7 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null;
        r rVar = r.f13638a;
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z2, journalMode, queryExecutor, transactionExecutor, intent, z8, z9, set, (String) null, (File) null, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, rVar, rVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, boolean z7, boolean z8, boolean z9, Set<Integer> set, String str2, File file) {
        k.e(context, "context");
        k.e(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        k.e(migrationContainer, "migrationContainer");
        k.e(journalMode, "journalMode");
        k.e(queryExecutor, "queryExecutor");
        k.e(transactionExecutor, "transactionExecutor");
        Intent intent = z7 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null;
        r rVar = r.f13638a;
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z2, journalMode, queryExecutor, transactionExecutor, intent, z8, z9, set, str2, file, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, rVar, rVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, boolean z7, boolean z8, boolean z9, Set<Integer> set, String str2, File file, Callable<InputStream> callable) {
        k.e(context, "context");
        k.e(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        k.e(migrationContainer, "migrationContainer");
        k.e(journalMode, "journalMode");
        k.e(queryExecutor, "queryExecutor");
        k.e(transactionExecutor, "transactionExecutor");
        Intent intent = z7 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null;
        r rVar = r.f13638a;
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z2, journalMode, queryExecutor, transactionExecutor, intent, z8, z9, set, str2, file, callable, (RoomDatabase.PrepackagedDatabaseCallback) null, rVar, rVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, boolean z7, boolean z8, boolean z9, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
        k.e(context, "context");
        k.e(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        k.e(migrationContainer, "migrationContainer");
        k.e(journalMode, "journalMode");
        k.e(queryExecutor, "queryExecutor");
        k.e(transactionExecutor, "transactionExecutor");
        Intent intent = z7 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null;
        r rVar = r.f13638a;
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z2, journalMode, queryExecutor, transactionExecutor, intent, z8, z9, set, str2, file, callable, prepackagedDatabaseCallback, rVar, rVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, boolean z7, boolean z8, boolean z9, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> typeConverters) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z2, journalMode, queryExecutor, transactionExecutor, z7 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z8, z9, set, str2, file, callable, prepackagedDatabaseCallback, typeConverters, r.f13638a);
        k.e(context, "context");
        k.e(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        k.e(migrationContainer, "migrationContainer");
        k.e(journalMode, "journalMode");
        k.e(queryExecutor, "queryExecutor");
        k.e(transactionExecutor, "transactionExecutor");
        k.e(typeConverters, "typeConverters");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, boolean z7, boolean z8, boolean z9, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> typeConverters, List<? extends AutoMigrationSpec> autoMigrationSpecs) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z2, journalMode, queryExecutor, transactionExecutor, z7 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z8, z9, set, str2, file, callable, (RoomDatabase.PrepackagedDatabaseCallback) null, typeConverters, autoMigrationSpecs);
        k.e(context, "context");
        k.e(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        k.e(migrationContainer, "migrationContainer");
        k.e(journalMode, "journalMode");
        k.e(queryExecutor, "queryExecutor");
        k.e(transactionExecutor, "transactionExecutor");
        k.e(typeConverters, "typeConverters");
        k.e(autoMigrationSpecs, "autoMigrationSpecs");
    }
}
