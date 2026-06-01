package androidx.datastore.preferences.core;

import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.FileStorage;
import androidx.datastore.core.Storage;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import e6.a;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import l7.g0;
import q6.a0;
import q6.c0;
import q6.m0;
import r5.r;
import x6.d;
import x6.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceDataStoreFactory {
    public static final PreferenceDataStoreFactory INSTANCE = new PreferenceDataStoreFactory();

    /* JADX INFO: renamed from: androidx.datastore.preferences.core.PreferenceDataStoreFactory$createWithPath$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements a {
        final /* synthetic */ a $produceFile;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a aVar) {
            super(0);
            this.$produceFile = aVar;
        }

        @Override // e6.a
        public final File invoke() {
            return ((g0) this.$produceFile.invoke()).toFile();
        }
    }

    private PreferenceDataStoreFactory() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, a0 a0Var, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i2 & 4) != 0) {
            list = r.f13638a;
        }
        if ((i2 & 8) != 0) {
            a0Var = c0.b(Actual_jvmAndroidKt.ioDispatcher().plus(c0.e()));
        }
        return preferenceDataStoreFactory.create((Storage<Preferences>) storage, (ReplaceFileCorruptionHandler<Preferences>) replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) list, a0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataStore createWithPath$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, a0 a0Var, a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i2 & 2) != 0) {
            list = r.f13638a;
        }
        if ((i2 & 4) != 0) {
            a0Var = c0.b(Actual_jvmAndroidKt.ioDispatcher().plus(c0.e()));
        }
        return preferenceDataStoreFactory.createWithPath(replaceFileCorruptionHandler, list, a0Var, aVar);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage) {
        k.e(storage, "storage");
        return create$default(this, storage, (ReplaceFileCorruptionHandler) null, (List) null, (a0) null, 14, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, a produceFile) {
        k.e(produceFile, "produceFile");
        return createWithPath$default(this, replaceFileCorruptionHandler, null, null, produceFile, 6, null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler) {
        k.e(storage, "storage");
        return create$default(this, storage, replaceFileCorruptionHandler, (List) null, (a0) null, 12, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> migrations, a produceFile) {
        k.e(migrations, "migrations");
        k.e(produceFile, "produceFile");
        return createWithPath$default(this, replaceFileCorruptionHandler, migrations, null, produceFile, 4, null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> migrations) {
        k.e(storage, "storage");
        k.e(migrations, "migrations");
        return create$default(this, storage, replaceFileCorruptionHandler, migrations, (a0) null, 8, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(a produceFile) {
        k.e(produceFile, "produceFile");
        return createWithPath$default(this, null, null, null, produceFile, 7, null);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, a produceFile) {
        k.e(produceFile, "produceFile");
        return create$default(this, replaceFileCorruptionHandler, (List) null, (a0) null, produceFile, 6, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> migrations, a0 scope, a produceFile) {
        k.e(migrations, "migrations");
        k.e(scope, "scope");
        k.e(produceFile, "produceFile");
        return create(replaceFileCorruptionHandler, migrations, scope, new AnonymousClass1(produceFile));
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> migrations, a produceFile) {
        k.e(migrations, "migrations");
        k.e(produceFile, "produceFile");
        return create$default(this, replaceFileCorruptionHandler, migrations, (a0) null, produceFile, 4, (Object) null);
    }

    public final DataStore<Preferences> create(a produceFile) {
        k.e(produceFile, "produceFile");
        return create$default(this, (ReplaceFileCorruptionHandler) null, (List) null, (a0) null, produceFile, 7, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, a0 a0Var, a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i2 & 2) != 0) {
            list = r.f13638a;
        }
        if ((i2 & 4) != 0) {
            e eVar = m0.f13566a;
            a0Var = c0.b(d.f17810a.plus(c0.e()));
        }
        return preferenceDataStoreFactory.create((ReplaceFileCorruptionHandler<Preferences>) replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) list, a0Var, aVar);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> migrations, a0 scope, a produceFile) {
        k.e(migrations, "migrations");
        k.e(scope, "scope");
        k.e(produceFile, "produceFile");
        return new PreferenceDataStore(create(new FileStorage(PreferencesFileSerializer.INSTANCE, null, new PreferenceDataStoreFactory$create$delegate$1(produceFile), 2, null), replaceFileCorruptionHandler, migrations, scope));
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> migrations, a0 scope) {
        k.e(storage, "storage");
        k.e(migrations, "migrations");
        k.e(scope, "scope");
        return new PreferenceDataStore(DataStoreFactory.INSTANCE.create(storage, replaceFileCorruptionHandler, migrations, scope));
    }
}
