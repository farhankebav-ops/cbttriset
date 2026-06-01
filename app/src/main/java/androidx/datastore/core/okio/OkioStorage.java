package androidx.datastore.core.okio;

import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.Storage;
import androidx.datastore.core.StorageConnection;
import e6.a;
import e6.p;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import l7.g0;
import l7.t;
import n7.b;
import q5.f;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class OkioStorage<T> implements Storage<T> {
    public static final Companion Companion = new Companion(null);
    private static final Set<String> activeFiles = new LinkedHashSet();
    private static final Synchronizer activeFilesLock = new Synchronizer();
    private final f canonicalPath$delegate;
    private final p coordinatorProducer;
    private final t fileSystem;
    private final a producePath;
    private final OkioSerializer<T> serializer;

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioStorage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements p {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // e6.p
        public final InterProcessCoordinator invoke(g0 path, t tVar) {
            k.e(path, "path");
            k.e(tVar, "<anonymous parameter 1>");
            return OkioStorageKt.createSingleProcessCoordinator(path);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final Set<String> getActiveFiles$datastore_core_okio() {
            return OkioStorage.activeFiles;
        }

        public final Synchronizer getActiveFilesLock() {
            return OkioStorage.activeFilesLock;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.okio.OkioStorage$createConnection$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends l implements a {
        final /* synthetic */ OkioStorage<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(OkioStorage<T> okioStorage) {
            super(0);
            this.this$0 = okioStorage;
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m42invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m42invoke() {
            Companion companion = OkioStorage.Companion;
            Synchronizer activeFilesLock = companion.getActiveFilesLock();
            OkioStorage<T> okioStorage = this.this$0;
            synchronized (activeFilesLock) {
                companion.getActiveFiles$datastore_core_okio().remove(okioStorage.getCanonicalPath().f12851a.t());
            }
        }
    }

    public OkioStorage(t fileSystem, OkioSerializer<T> serializer, p coordinatorProducer, a producePath) {
        k.e(fileSystem, "fileSystem");
        k.e(serializer, "serializer");
        k.e(coordinatorProducer, "coordinatorProducer");
        k.e(producePath, "producePath");
        this.fileSystem = fileSystem;
        this.serializer = serializer;
        this.coordinatorProducer = coordinatorProducer;
        this.producePath = producePath;
        this.canonicalPath$delegate = b.C(new OkioStorage$canonicalPath$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g0 getCanonicalPath() {
        return (g0) this.canonicalPath$delegate.getValue();
    }

    @Override // androidx.datastore.core.Storage
    public StorageConnection<T> createConnection() {
        String strT = getCanonicalPath().f12851a.t();
        synchronized (activeFilesLock) {
            Set<String> set = activeFiles;
            if (set.contains(strT)) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + strT + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            set.add(strT);
        }
        return new OkioStorageConnection(this.fileSystem, getCanonicalPath(), this.serializer, (InterProcessCoordinator) this.coordinatorProducer.invoke(getCanonicalPath(), this.fileSystem), new AnonymousClass2(this));
    }

    public /* synthetic */ OkioStorage(t tVar, OkioSerializer okioSerializer, p pVar, a aVar, int i2, kotlin.jvm.internal.f fVar) {
        this(tVar, okioSerializer, (i2 & 4) != 0 ? AnonymousClass1.INSTANCE : pVar, aVar);
    }
}
