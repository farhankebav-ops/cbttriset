package androidx.datastore;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.core.okio.OkioSerializer;
import androidx.datastore.core.okio.OkioStorage;
import e6.l;
import h6.a;
import java.util.List;
import kotlin.jvm.internal.k;
import l6.q;
import l7.t;
import q6.a0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreSingletonDelegate<T> implements a {

    @GuardedBy("lock")
    private volatile DataStore<T> INSTANCE;
    private final ReplaceFileCorruptionHandler<T> corruptionHandler;
    private final String fileName;
    private final Object lock;
    private final l produceMigrations;
    private final a0 scope;
    private final OkioSerializer<T> serializer;

    public DataStoreSingletonDelegate(String fileName, OkioSerializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, l produceMigrations, a0 scope) {
        k.e(fileName, "fileName");
        k.e(serializer, "serializer");
        k.e(produceMigrations, "produceMigrations");
        k.e(scope, "scope");
        this.fileName = fileName;
        this.serializer = serializer;
        this.corruptionHandler = replaceFileCorruptionHandler;
        this.produceMigrations = produceMigrations;
        this.scope = scope;
        this.lock = new Object();
    }

    @Override // h6.a
    public DataStore<T> getValue(Context thisRef, q property) {
        DataStore<T> dataStore;
        k.e(thisRef, "thisRef");
        k.e(property, "property");
        DataStore<T> dataStore2 = this.INSTANCE;
        if (dataStore2 != null) {
            return dataStore2;
        }
        synchronized (this.lock) {
            try {
                if (this.INSTANCE == null) {
                    Context applicationContext = thisRef.getApplicationContext();
                    DataStoreFactory dataStoreFactory = DataStoreFactory.INSTANCE;
                    OkioStorage okioStorage = new OkioStorage(t.SYSTEM, this.serializer, null, new DataStoreSingletonDelegate$getValue$1$1(applicationContext, this), 4, null);
                    ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler = this.corruptionHandler;
                    l lVar = this.produceMigrations;
                    k.d(applicationContext, "applicationContext");
                    this.INSTANCE = dataStoreFactory.create(okioStorage, replaceFileCorruptionHandler, (List) lVar.invoke(applicationContext), this.scope);
                }
                dataStore = this.INSTANCE;
                k.b(dataStore);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dataStore;
    }
}
