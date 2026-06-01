package androidx.datastore.core;

import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q6.a0;
import q6.c0;
import q6.m0;
import r2.q;
import r5.r;
import x6.d;
import x6.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MultiProcessDataStoreFactory {
    public static final MultiProcessDataStoreFactory INSTANCE = new MultiProcessDataStoreFactory();

    /* JADX INFO: renamed from: androidx.datastore.core.MultiProcessDataStoreFactory$create$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        final /* synthetic */ a0 $scope;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(a0 a0Var) {
            super(1);
            this.$scope = a0Var;
        }

        @Override // e6.l
        public final InterProcessCoordinator invoke(File it) {
            k.e(it, "it");
            return new MultiProcessCoordinator(this.$scope.getCoroutineContext(), it);
        }
    }

    private MultiProcessDataStoreFactory() {
    }

    public static DataStore create$default(MultiProcessDataStoreFactory multiProcessDataStoreFactory, Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, a0 a0Var, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i2 & 4) != 0) {
            list = r.f13638a;
        }
        if ((i2 & 8) != 0) {
            e eVar = m0.f13566a;
            a0Var = c0.b(d.f17810a.plus(c0.e()));
        }
        return multiProcessDataStoreFactory.create(storage, replaceFileCorruptionHandler, list, a0Var);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, e6.a produceFile) {
        k.e(serializer, "serializer");
        k.e(produceFile, "produceFile");
        return create$default(this, serializer, replaceFileCorruptionHandler, null, null, produceFile, 12, null);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> migrations, e6.a produceFile) {
        k.e(serializer, "serializer");
        k.e(migrations, "migrations");
        k.e(produceFile, "produceFile");
        return create$default(this, serializer, replaceFileCorruptionHandler, migrations, null, produceFile, 8, null);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, e6.a produceFile) {
        k.e(serializer, "serializer");
        k.e(produceFile, "produceFile");
        return create$default(this, serializer, null, null, null, produceFile, 14, null);
    }

    public final <T> DataStore<T> create(Storage<T> storage) {
        k.e(storage, "storage");
        return create$default(this, storage, null, null, null, 14, null);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler) {
        k.e(storage, "storage");
        return create$default(this, storage, replaceFileCorruptionHandler, null, null, 12, null);
    }

    public static DataStore create$default(MultiProcessDataStoreFactory multiProcessDataStoreFactory, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, a0 a0Var, e6.a aVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        ReplaceFileCorruptionHandler replaceFileCorruptionHandler2 = replaceFileCorruptionHandler;
        if ((i2 & 4) != 0) {
            list = r.f13638a;
        }
        List list2 = list;
        if ((i2 & 8) != 0) {
            e eVar = m0.f13566a;
            a0Var = c0.b(d.f17810a.plus(c0.e()));
        }
        return multiProcessDataStoreFactory.create(serializer, replaceFileCorruptionHandler2, list2, a0Var, aVar);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> migrations) {
        k.e(storage, "storage");
        k.e(migrations, "migrations");
        return create$default(this, storage, replaceFileCorruptionHandler, migrations, null, 8, null);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> migrations, a0 scope) {
        k.e(storage, "storage");
        k.e(migrations, "migrations");
        k.e(scope, "scope");
        List listJ0 = q.j0(DataMigrationInitializer.Companion.getInitializer(migrations));
        if (replaceFileCorruptionHandler == null) {
            replaceFileCorruptionHandler = (ReplaceFileCorruptionHandler<T>) new NoOpCorruptionHandler();
        }
        return new DataStoreImpl(storage, listJ0, replaceFileCorruptionHandler, scope);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> migrations, a0 scope, e6.a produceFile) {
        k.e(serializer, "serializer");
        k.e(migrations, "migrations");
        k.e(scope, "scope");
        k.e(produceFile, "produceFile");
        FileStorage fileStorage = new FileStorage(serializer, new AnonymousClass1(scope), produceFile);
        List listJ0 = q.j0(DataMigrationInitializer.Companion.getInitializer(migrations));
        if (replaceFileCorruptionHandler == null) {
            replaceFileCorruptionHandler = (ReplaceFileCorruptionHandler<T>) new NoOpCorruptionHandler();
        }
        return new DataStoreImpl(fileStorage, listJ0, replaceFileCorruptionHandler, scope);
    }
}
