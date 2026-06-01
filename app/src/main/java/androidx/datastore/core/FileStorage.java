package androidx.datastore.core;

import androidx.annotation.GuardedBy;
import e6.l;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FileStorage<T> implements Storage<T> {
    public static final Companion Companion = new Companion(null);

    @GuardedBy("activeFilesLock")
    private static final Set<String> activeFiles = new LinkedHashSet();
    private static final Object activeFilesLock = new Object();
    private final l coordinatorProducer;
    private final e6.a produceFile;
    private final Serializer<T> serializer;

    /* JADX INFO: renamed from: androidx.datastore.core.FileStorage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.l implements l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // e6.l
        public final InterProcessCoordinator invoke(File it) {
            k.e(it, "it");
            return InterProcessCoordinator_jvmKt.createSingleProcessCoordinator(it);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Set<String> getActiveFiles$datastore_core_release() {
            return FileStorage.activeFiles;
        }

        public final Object getActiveFilesLock$datastore_core_release() {
            return FileStorage.activeFilesLock;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.FileStorage$createConnection$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends kotlin.jvm.internal.l implements e6.a {
        final /* synthetic */ File $file;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(File file) {
            super(0);
            this.$file = file;
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m40invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m40invoke() {
            Companion companion = FileStorage.Companion;
            Object activeFilesLock$datastore_core_release = companion.getActiveFilesLock$datastore_core_release();
            File file = this.$file;
            synchronized (activeFilesLock$datastore_core_release) {
                companion.getActiveFiles$datastore_core_release().remove(file.getAbsolutePath());
            }
        }
    }

    public FileStorage(Serializer<T> serializer, l coordinatorProducer, e6.a produceFile) {
        k.e(serializer, "serializer");
        k.e(coordinatorProducer, "coordinatorProducer");
        k.e(produceFile, "produceFile");
        this.serializer = serializer;
        this.coordinatorProducer = coordinatorProducer;
        this.produceFile = produceFile;
    }

    @Override // androidx.datastore.core.Storage
    public StorageConnection<T> createConnection() throws IOException {
        File canonicalFile = ((File) this.produceFile.invoke()).getCanonicalFile();
        synchronized (activeFilesLock) {
            String path = canonicalFile.getAbsolutePath();
            Set<String> set = activeFiles;
            if (set.contains(path)) {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + path + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
            k.d(path, "path");
            set.add(path);
        }
        return new FileStorageConnection(canonicalFile, this.serializer, (InterProcessCoordinator) this.coordinatorProducer.invoke(canonicalFile), new AnonymousClass2(canonicalFile));
    }

    public /* synthetic */ FileStorage(Serializer serializer, l lVar, e6.a aVar, int i2, f fVar) {
        this(serializer, (i2 & 2) != 0 ? AnonymousClass1.INSTANCE : lVar, aVar);
    }
}
