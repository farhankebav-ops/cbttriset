package okhttp3.internal.cache;

import androidx.core.location.LocationRequestCompat;
import e2.s;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.f;
import l7.b;
import l7.g;
import l7.g0;
import l7.i0;
import l7.j0;
import l7.k;
import l7.n0;
import l7.o0;
import l7.t;
import l7.u;
import l7.w;
import n6.l;
import n6.m;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DiskLruCache implements Closeable, Flushable, Lockable {
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;
    private final g0 directory;
    private final t fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final g0 journalFile;
    private final g0 journalFileBackup;
    private final g0 journalFileTmp;
    private k journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;
    public static final Companion Companion = new Companion(null);
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String MAGIC = "libcore.io.DiskLruCache";
    public static final String VERSION_1 = "1";
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final l LEGAL_KEY_PATTERN = new l("[a-z0-9_-]{1,120}");
    public static final String CLEAN = "CLEAN";
    public static final String DIRTY = "DIRTY";
    public static final String REMOVE = "REMOVE";
    public static final String READ = "READ";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class Editor {
        private boolean done;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache diskLruCache, Entry entry) {
            kotlin.jvm.internal.k.e(entry, "entry");
            this.this$0 = diskLruCache;
            this.entry = entry;
            this.written = entry.getReadable$okhttp() ? null : new boolean[diskLruCache.getValueCount$okhttp()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final x newSink$lambda$3$lambda$2(DiskLruCache diskLruCache, Editor editor, IOException it) {
            kotlin.jvm.internal.k.e(it, "it");
            synchronized (diskLruCache) {
                editor.detach$okhttp();
            }
            return x.f13520a;
        }

        public final void abort() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                try {
                    if (this.done) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (kotlin.jvm.internal.k.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        diskLruCache.completeEdit$okhttp(this, false);
                    }
                    this.done = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void commit() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                try {
                    if (this.done) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (kotlin.jvm.internal.k.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        diskLruCache.completeEdit$okhttp(this, true);
                    }
                    this.done = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void detach$okhttp() throws IOException {
            if (kotlin.jvm.internal.k.a(this.entry.getCurrentEditor$okhttp(), this)) {
                if (this.this$0.civilizedFileSystem) {
                    this.this$0.completeEdit$okhttp(this, false);
                } else {
                    this.entry.setZombie$okhttp(true);
                }
            }
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final n0 newSink(int i2) {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                try {
                    if (this.done) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (!kotlin.jvm.internal.k.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        return new g();
                    }
                    if (!this.entry.getReadable$okhttp()) {
                        boolean[] zArr = this.written;
                        kotlin.jvm.internal.k.b(zArr);
                        zArr[i2] = true;
                    }
                    try {
                        return new FaultHidingSink(diskLruCache.getFileSystem$okhttp().sink(this.entry.getDirtyFiles$okhttp().get(i2)), new a(0, diskLruCache, this));
                    } catch (FileNotFoundException unused) {
                        return new g();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final o0 newSource(int i2) {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (this.done) {
                    throw new IllegalStateException("Check failed.");
                }
                o0 o0VarSource = null;
                if (!this.entry.getReadable$okhttp() || !kotlin.jvm.internal.k.a(this.entry.getCurrentEditor$okhttp(), this) || this.entry.getZombie$okhttp()) {
                    return null;
                }
                try {
                    o0VarSource = diskLruCache.getFileSystem$okhttp().source(this.entry.getCleanFiles$okhttp().get(i2));
                } catch (FileNotFoundException unused) {
                }
                return o0VarSource;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class Entry {
        private final List<g0> cleanFiles;
        private Editor currentEditor;
        private final List<g0> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(DiskLruCache diskLruCache, String key) {
            kotlin.jvm.internal.k.e(key, "key");
            this.this$0 = diskLruCache;
            this.key = key;
            this.lengths = new long[diskLruCache.getValueCount$okhttp()];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder sb = new StringBuilder(key);
            sb.append('.');
            int length = sb.length();
            int valueCount$okhttp = diskLruCache.getValueCount$okhttp();
            for (int i2 = 0; i2 < valueCount$okhttp; i2++) {
                sb.append(i2);
                List<g0> list = this.cleanFiles;
                g0 directory = this.this$0.getDirectory();
                String string = sb.toString();
                kotlin.jvm.internal.k.d(string, "toString(...)");
                list.add(directory.e(string));
                sb.append(".tmp");
                List<g0> list2 = this.dirtyFiles;
                g0 directory2 = this.this$0.getDirectory();
                String string2 = sb.toString();
                kotlin.jvm.internal.k.d(string2, "toString(...)");
                list2.add(directory2.e(string2));
                sb.setLength(length);
            }
        }

        private final Void invalidLengths(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        private final o0 newSource(int i2) {
            final o0 o0VarSource = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(i2));
            if (this.this$0.civilizedFileSystem) {
                return o0VarSource;
            }
            this.lockingSourceCount++;
            final DiskLruCache diskLruCache = this.this$0;
            return new w(o0VarSource) { // from class: okhttp3.internal.cache.DiskLruCache$Entry$newSource$1
                private boolean closed;

                @Override // l7.w, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    super.close();
                    if (this.closed) {
                        return;
                    }
                    this.closed = true;
                    DiskLruCache diskLruCache2 = diskLruCache;
                    DiskLruCache.Entry entry = this;
                    synchronized (diskLruCache2) {
                        entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount$okhttp() - 1);
                        if (entry.getLockingSourceCount$okhttp() == 0 && entry.getZombie$okhttp()) {
                            diskLruCache2.removeEntry$okhttp(entry);
                        }
                    }
                }
            };
        }

        public final List<g0> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final List<g0> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(List<String> strings) throws IOException {
            kotlin.jvm.internal.k.e(strings, "strings");
            if (strings.size() != this.this$0.getValueCount$okhttp()) {
                invalidLengths(strings);
                throw new s(2);
            }
            try {
                int size = strings.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.lengths[i2] = Long.parseLong(strings.get(i2));
                }
            } catch (NumberFormatException unused) {
                invalidLengths(strings);
                throw new s(2);
            }
        }

        public final void setLockingSourceCount$okhttp(int i2) {
            this.lockingSourceCount = i2;
        }

        public final void setReadable$okhttp(boolean z2) {
            this.readable = z2;
        }

        public final void setSequenceNumber$okhttp(long j) {
            this.sequenceNumber = j;
        }

        public final void setZombie$okhttp(boolean z2) {
            this.zombie = z2;
        }

        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache = this.this$0;
            if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
            }
            if (!this.readable) {
                return null;
            }
            if (!this.this$0.civilizedFileSystem && (this.currentEditor != null || this.zombie)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long[] jArr = (long[]) this.lengths.clone();
            int i2 = 0;
            try {
                int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                for (int i8 = 0; i8 < valueCount$okhttp; i8++) {
                    arrayList.add(newSource(i8));
                }
                return new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
            } catch (FileNotFoundException unused) {
                int size = arrayList.size();
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    _UtilCommonKt.closeQuietly((o0) obj);
                }
                try {
                    this.this$0.removeEntry$okhttp(this);
                } catch (IOException unused2) {
                }
                return null;
            }
        }

        public final void writeLengths$okhttp(k writer) throws IOException {
            kotlin.jvm.internal.k.e(writer, "writer");
            for (long j : this.lengths) {
                writer.writeByte(32).G(j);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<o0> sources;
        final /* synthetic */ DiskLruCache this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(DiskLruCache diskLruCache, String key, long j, List<? extends o0> sources, long[] lengths) {
            kotlin.jvm.internal.k.e(key, "key");
            kotlin.jvm.internal.k.e(sources, "sources");
            kotlin.jvm.internal.k.e(lengths, "lengths");
            this.this$0 = diskLruCache;
            this.key = key;
            this.sequenceNumber = j;
            this.sources = sources;
            this.lengths = lengths;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Iterator<o0> it = this.sources.iterator();
            while (it.hasNext()) {
                _UtilCommonKt.closeQuietly(it.next());
            }
        }

        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int i2) {
            return this.lengths[i2];
        }

        public final o0 getSource(int i2) {
            return this.sources.get(i2);
        }

        public final String key() {
            return this.key;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.cache.DiskLruCache$snapshots$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 implements Iterator<Snapshot>, f6.a {
        private final Iterator<Entry> delegate;
        private Snapshot nextSnapshot;
        private Snapshot removeSnapshot;

        public AnonymousClass1() {
            Iterator<Entry> it = new ArrayList(DiskLruCache.this.getLruEntries$okhttp().values()).iterator();
            kotlin.jvm.internal.k.d(it, "iterator(...)");
            this.delegate = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Snapshot snapshotSnapshot$okhttp;
            if (this.nextSnapshot != null) {
                return true;
            }
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (diskLruCache.getClosed$okhttp()) {
                    return false;
                }
                while (this.delegate.hasNext()) {
                    Entry next = this.delegate.next();
                    if (next != null && (snapshotSnapshot$okhttp = next.snapshot$okhttp()) != null) {
                        this.nextSnapshot = snapshotSnapshot$okhttp;
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            Snapshot snapshot = this.removeSnapshot;
            if (snapshot == null) {
                throw new IllegalStateException("remove() before next()");
            }
            try {
                DiskLruCache.this.remove(snapshot.key());
            } catch (IOException unused) {
            } finally {
                this.removeSnapshot = null;
            }
        }

        @Override // java.util.Iterator
        public Snapshot next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Snapshot snapshot = this.nextSnapshot;
            this.removeSnapshot = snapshot;
            this.nextSnapshot = null;
            kotlin.jvm.internal.k.b(snapshot);
            return snapshot;
        }
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [okhttp3.internal.cache.DiskLruCache$cleanupTask$1] */
    public DiskLruCache(final t fileSystem, g0 directory, int i2, int i8, long j, TaskRunner taskRunner) {
        kotlin.jvm.internal.k.e(fileSystem, "fileSystem");
        kotlin.jvm.internal.k.e(directory, "directory");
        kotlin.jvm.internal.k.e(taskRunner, "taskRunner");
        this.directory = directory;
        this.appVersion = i2;
        this.valueCount = i8;
        this.fileSystem = new u(fileSystem) { // from class: okhttp3.internal.cache.DiskLruCache$fileSystem$1
            @Override // l7.u, l7.t
            public n0 sink(g0 file, boolean z2) throws IOException {
                kotlin.jvm.internal.k.e(file, "file");
                g0 g0VarC = file.c();
                if (g0VarC != null) {
                    createDirectories(g0VarC);
                }
                return super.sink(file, z2);
            }
        };
        this.maxSize = j;
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.cleanupQueue = taskRunner.newQueue();
        final String strR = a1.a.r(new StringBuilder(), _UtilJvmKt.okHttpName, " Cache");
        this.cleanupTask = new Task(strR) { // from class: okhttp3.internal.cache.DiskLruCache$cleanupTask$1
            {
                int i9 = 2;
                f fVar = null;
                boolean z2 = false;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                DiskLruCache diskLruCache = this.this$0;
                synchronized (diskLruCache) {
                    if (!diskLruCache.initialized || diskLruCache.getClosed$okhttp()) {
                        return -1L;
                    }
                    try {
                        diskLruCache.trimToSize();
                    } catch (IOException unused) {
                        diskLruCache.mostRecentTrimFailed = true;
                    }
                    try {
                        if (diskLruCache.journalRebuildRequired()) {
                            diskLruCache.rebuildJournal$okhttp();
                            diskLruCache.redundantOpCount = 0;
                        }
                    } catch (IOException unused2) {
                        diskLruCache.mostRecentRebuildFailed = true;
                        k kVar = diskLruCache.journalWriter;
                        if (kVar != null) {
                            _UtilCommonKt.closeQuietly(kVar);
                        }
                        diskLruCache.journalWriter = b.b(new g());
                    }
                    return -1L;
                }
            }
        };
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i8 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        this.journalFile = directory.e(JOURNAL_FILE);
        this.journalFileTmp = directory.e(JOURNAL_FILE_TEMP);
        this.journalFileBackup = directory.e(JOURNAL_FILE_BACKUP);
    }

    private final synchronized void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            j = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean journalRebuildRequired() {
        int i2 = this.redundantOpCount;
        return i2 >= 2000 && i2 >= this.lruEntries.size();
    }

    private final k newJournalWriter() throws FileNotFoundException {
        return b.b(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new androidx.camera.core.impl.utils.a(this, 16)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x newJournalWriter$lambda$3(DiskLruCache diskLruCache, IOException it) {
        kotlin.jvm.internal.k.e(it, "it");
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(diskLruCache)) {
            diskLruCache.hasJournalErrors = true;
            return x.f13520a;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
    }

    private final void processJournal() throws IOException {
        _UtilCommonKt.deleteIfExists(this.fileSystem, this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            kotlin.jvm.internal.k.d(next, "next(...)");
            Entry entry = next;
            int i2 = 0;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i8 = this.valueCount;
                while (i2 < i8) {
                    this.size += entry.getLengths$okhttp()[i2];
                    i2++;
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                int i9 = this.valueCount;
                while (i2 < i9) {
                    _UtilCommonKt.deleteIfExists(this.fileSystem, entry.getCleanFiles$okhttp().get(i2));
                    _UtilCommonKt.deleteIfExists(this.fileSystem, entry.getDirtyFiles$okhttp().get(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    private final void readJournal() throws Throwable {
        j0 j0VarC = b.c(this.fileSystem.source(this.journalFile));
        try {
            String strH = j0VarC.h(LocationRequestCompat.PASSIVE_INTERVAL);
            String strH2 = j0VarC.h(LocationRequestCompat.PASSIVE_INTERVAL);
            String strH3 = j0VarC.h(LocationRequestCompat.PASSIVE_INTERVAL);
            String strH4 = j0VarC.h(LocationRequestCompat.PASSIVE_INTERVAL);
            String strH5 = j0VarC.h(LocationRequestCompat.PASSIVE_INTERVAL);
            if (!kotlin.jvm.internal.k.a(MAGIC, strH) || !kotlin.jvm.internal.k.a(VERSION_1, strH2) || !kotlin.jvm.internal.k.a(String.valueOf(this.appVersion), strH3) || !kotlin.jvm.internal.k.a(String.valueOf(this.valueCount), strH4) || strH5.length() > 0) {
                throw new IOException("unexpected journal header: [" + strH + ", " + strH2 + ", " + strH4 + ", " + strH5 + ']');
            }
            int i2 = 0;
            while (true) {
                try {
                    readJournalLine(j0VarC.h(LocationRequestCompat.PASSIVE_INTERVAL));
                    i2++;
                } catch (EOFException unused) {
                    this.redundantOpCount = i2 - this.lruEntries.size();
                    if (j0VarC.M()) {
                        k kVar = this.journalWriter;
                        if (kVar != null) {
                            _UtilCommonKt.closeQuietly(kVar);
                        }
                        this.journalWriter = newJournalWriter();
                    } else {
                        rebuildJournal$okhttp();
                    }
                    try {
                        j0VarC.close();
                        th = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                j0VarC.close();
            } catch (Throwable th3) {
                a.a.h(th, th3);
            }
        }
        if (th != null) {
            throw th;
        }
    }

    private final void readJournalLine(String str) throws IOException {
        String strSubstring;
        int iX0 = m.x0(str, ' ', 0, 6);
        if (iX0 == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i2 = iX0 + 1;
        int iX02 = m.x0(str, ' ', i2, 4);
        if (iX02 == -1) {
            strSubstring = str.substring(i2);
            kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
            String str2 = REMOVE;
            if (iX0 == str2.length() && n6.t.n0(str, str2, false)) {
                this.lruEntries.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i2, iX02);
            kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        }
        Entry entry = this.lruEntries.get(strSubstring);
        if (entry == null) {
            entry = new Entry(this, strSubstring);
            this.lruEntries.put(strSubstring, entry);
        }
        if (iX02 != -1) {
            String str3 = CLEAN;
            if (iX0 == str3.length() && n6.t.n0(str, str3, false)) {
                String strSubstring2 = str.substring(iX02 + 1);
                kotlin.jvm.internal.k.d(strSubstring2, "substring(...)");
                List<String> listJ0 = m.J0(strSubstring2, new char[]{' '});
                entry.setReadable$okhttp(true);
                entry.setCurrentEditor$okhttp(null);
                entry.setLengths$okhttp(listJ0);
                return;
            }
        }
        if (iX02 == -1) {
            String str4 = DIRTY;
            if (iX0 == str4.length() && n6.t.n0(str, str4, false)) {
                entry.setCurrentEditor$okhttp(new Editor(this, entry));
                return;
            }
        }
        if (iX02 == -1) {
            String str5 = READ;
            if (iX0 == str5.length() && n6.t.n0(str, str5, false)) {
                return;
            }
        }
        throw new IOException("unexpected journal line: ".concat(str));
    }

    private final boolean removeOldestEntry() throws IOException {
        for (Entry entry : this.lruEntries.values()) {
            kotlin.jvm.internal.k.d(entry, "next(...)");
            Entry entry2 = entry;
            if (!entry2.getZombie$okhttp()) {
                removeEntry$okhttp(entry2);
                return true;
            }
        }
        return false;
    }

    private final void validateKey(String input) {
        l lVar = LEGAL_KEY_PATTERN;
        lVar.getClass();
        kotlin.jvm.internal.k.e(input, "input");
        if (!lVar.f13103a.matcher(input).matches()) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.f('\"', "keys must match regex [a-z0-9_-]{1,120}: \"", input).toString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Editor currentEditor$okhttp;
        try {
            if (this.initialized && !this.closed) {
                Collection<Entry> collectionValues = this.lruEntries.values();
                kotlin.jvm.internal.k.d(collectionValues, "<get-values>(...)");
                for (Entry entry : (Entry[]) collectionValues.toArray(new Entry[0])) {
                    kotlin.jvm.internal.k.b(entry);
                    if (entry.getCurrentEditor$okhttp() != null && (currentEditor$okhttp = entry.getCurrentEditor$okhttp()) != null) {
                        currentEditor$okhttp.detach$okhttp();
                    }
                }
                trimToSize();
                k kVar = this.journalWriter;
                if (kVar != null) {
                    _UtilCommonKt.closeQuietly(kVar);
                }
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            this.closed = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void completeEdit$okhttp(Editor editor, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(editor, "editor");
        Entry entry$okhttp = editor.getEntry$okhttp();
        if (!kotlin.jvm.internal.k.a(entry$okhttp.getCurrentEditor$okhttp(), editor)) {
            throw new IllegalStateException("Check failed.");
        }
        if (z2 && !entry$okhttp.getReadable$okhttp()) {
            int i2 = this.valueCount;
            for (int i8 = 0; i8 < i2; i8++) {
                boolean[] written$okhttp = editor.getWritten$okhttp();
                kotlin.jvm.internal.k.b(written$okhttp);
                if (!written$okhttp[i8]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i8);
                }
                if (!this.fileSystem.exists(entry$okhttp.getDirtyFiles$okhttp().get(i8))) {
                    editor.abort();
                    return;
                }
            }
        }
        int i9 = this.valueCount;
        for (int i10 = 0; i10 < i9; i10++) {
            g0 g0Var = entry$okhttp.getDirtyFiles$okhttp().get(i10);
            if (!z2 || entry$okhttp.getZombie$okhttp()) {
                _UtilCommonKt.deleteIfExists(this.fileSystem, g0Var);
            } else if (this.fileSystem.exists(g0Var)) {
                g0 g0Var2 = entry$okhttp.getCleanFiles$okhttp().get(i10);
                this.fileSystem.atomicMove(g0Var, g0Var2);
                long j = entry$okhttp.getLengths$okhttp()[i10];
                Long l = this.fileSystem.metadata(g0Var2).f12901d;
                long jLongValue = l != null ? l.longValue() : 0L;
                entry$okhttp.getLengths$okhttp()[i10] = jLongValue;
                this.size = (this.size - j) + jLongValue;
            }
        }
        entry$okhttp.setCurrentEditor$okhttp(null);
        if (entry$okhttp.getZombie$okhttp()) {
            removeEntry$okhttp(entry$okhttp);
            return;
        }
        this.redundantOpCount++;
        k kVar = this.journalWriter;
        kotlin.jvm.internal.k.b(kVar);
        if (entry$okhttp.getReadable$okhttp() || z2) {
            entry$okhttp.setReadable$okhttp(true);
            kVar.C(CLEAN).writeByte(32);
            kVar.C(entry$okhttp.getKey$okhttp());
            entry$okhttp.writeLengths$okhttp(kVar);
            kVar.writeByte(10);
            if (z2) {
                long j3 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j3;
                entry$okhttp.setSequenceNumber$okhttp(j3);
            }
        } else {
            this.lruEntries.remove(entry$okhttp.getKey$okhttp());
            kVar.C(REMOVE).writeByte(32);
            kVar.C(entry$okhttp.getKey$okhttp());
            kVar.writeByte(10);
        }
        kVar.flush();
        if (this.size > this.maxSize || journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final void delete() throws IOException {
        close();
        _UtilCommonKt.deleteContents(this.fileSystem, this.directory);
    }

    public final Editor edit(String key) throws IOException {
        kotlin.jvm.internal.k.e(key, "key");
        return edit$default(this, key, 0L, 2, null);
    }

    public final synchronized void evictAll() throws IOException {
        try {
            initialize();
            Collection<Entry> collectionValues = this.lruEntries.values();
            kotlin.jvm.internal.k.d(collectionValues, "<get-values>(...)");
            for (Entry entry : (Entry[]) collectionValues.toArray(new Entry[0])) {
                kotlin.jvm.internal.k.b(entry);
                removeEntry$okhttp(entry);
            }
            this.mostRecentTrimFailed = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            k kVar = this.journalWriter;
            kotlin.jvm.internal.k.b(kVar);
            kVar.flush();
        }
    }

    public final synchronized Snapshot get(String key) throws IOException {
        kotlin.jvm.internal.k.e(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            return null;
        }
        Snapshot snapshotSnapshot$okhttp = entry.snapshot$okhttp();
        if (snapshotSnapshot$okhttp == null) {
            return null;
        }
        this.redundantOpCount++;
        k kVar = this.journalWriter;
        kotlin.jvm.internal.k.b(kVar);
        kVar.C(READ).writeByte(32).C(key).writeByte(10);
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return snapshotSnapshot$okhttp;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final g0 getDirectory() {
        return this.directory;
    }

    public final t getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() throws IOException {
        try {
            if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
            }
            if (this.initialized) {
                return;
            }
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.atomicMove(this.journalFileBackup, this.journalFile);
                }
            }
            this.civilizedFileSystem = _UtilCommonKt.isCivilized(this.fileSystem, this.journalFileBackup);
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e) {
                    Platform.Companion.get().log("DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", 5, e);
                    try {
                        delete();
                        this.closed = false;
                        rebuildJournal$okhttp();
                        this.initialized = true;
                    } catch (Throwable th) {
                        this.closed = false;
                        throw th;
                    }
                }
            }
            rebuildJournal$okhttp();
            this.initialized = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    public final synchronized void rebuildJournal$okhttp() throws IOException {
        Throwable th;
        try {
            k kVar = this.journalWriter;
            if (kVar != null) {
                kVar.close();
            }
            i0 i0VarB = b.b(this.fileSystem.sink(this.journalFileTmp, false));
            try {
                i0VarB.C(MAGIC);
                i0VarB.writeByte(10);
                i0VarB.C(VERSION_1);
                i0VarB.writeByte(10);
                i0VarB.G(this.appVersion);
                i0VarB.writeByte(10);
                i0VarB.G(this.valueCount);
                i0VarB.writeByte(10);
                i0VarB.writeByte(10);
                for (Entry entry : this.lruEntries.values()) {
                    kotlin.jvm.internal.k.d(entry, "next(...)");
                    Entry entry2 = entry;
                    if (entry2.getCurrentEditor$okhttp() != null) {
                        i0VarB.C(DIRTY);
                        i0VarB.writeByte(32);
                        i0VarB.C(entry2.getKey$okhttp());
                        i0VarB.writeByte(10);
                    } else {
                        i0VarB.C(CLEAN);
                        i0VarB.writeByte(32);
                        i0VarB.C(entry2.getKey$okhttp());
                        entry2.writeLengths$okhttp(i0VarB);
                        i0VarB.writeByte(10);
                    }
                }
                try {
                    i0VarB.close();
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                try {
                    i0VarB.close();
                } catch (Throwable th4) {
                    a.a.h(th3, th4);
                }
                th = th3;
            }
            if (th != null) {
                throw th;
            }
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.atomicMove(this.journalFile, this.journalFileBackup);
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
                _UtilCommonKt.deleteIfExists(this.fileSystem, this.journalFileBackup);
            } else {
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
            }
            k kVar2 = this.journalWriter;
            if (kVar2 != null) {
                _UtilCommonKt.closeQuietly(kVar2);
            }
            this.journalWriter = newJournalWriter();
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } catch (Throwable th5) {
            throw th5;
        }
    }

    public final synchronized boolean remove(String key) throws IOException {
        kotlin.jvm.internal.k.e(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            return false;
        }
        boolean zRemoveEntry$okhttp = removeEntry$okhttp(entry);
        if (zRemoveEntry$okhttp && this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
        return zRemoveEntry$okhttp;
    }

    public final boolean removeEntry$okhttp(Entry entry) throws IOException {
        k kVar;
        kotlin.jvm.internal.k.e(entry, "entry");
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (kVar = this.journalWriter) != null) {
                kVar.C(DIRTY);
                kVar.writeByte(32);
                kVar.C(entry.getKey$okhttp());
                kVar.writeByte(10);
                kVar.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i2 = this.valueCount;
        for (int i8 = 0; i8 < i2; i8++) {
            _UtilCommonKt.deleteIfExists(this.fileSystem, entry.getCleanFiles$okhttp().get(i8));
            this.size -= entry.getLengths$okhttp()[i8];
            entry.getLengths$okhttp()[i8] = 0;
        }
        this.redundantOpCount++;
        k kVar2 = this.journalWriter;
        if (kVar2 != null) {
            kVar2.C(REMOVE);
            kVar2.writeByte(32);
            kVar2.C(entry.getKey$okhttp());
            kVar2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z2) {
        this.closed = z2;
    }

    public final synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new AnonymousClass1();
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    public final synchronized Editor edit(String key, long j) throws IOException {
        kotlin.jvm.internal.k.e(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (j != ANY_SEQUENCE_NUMBER && (entry == null || entry.getSequenceNumber$okhttp() != j)) {
            return null;
        }
        if ((entry != null ? entry.getCurrentEditor$okhttp() : null) != null) {
            return null;
        }
        if (entry != null && entry.getLockingSourceCount$okhttp() != 0) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            k kVar = this.journalWriter;
            kotlin.jvm.internal.k.b(kVar);
            kVar.C(DIRTY).writeByte(32).C(key).writeByte(10);
            kVar.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(this, key);
                this.lruEntries.put(key, entry);
            }
            Editor editor = new Editor(this, entry);
            entry.setCurrentEditor$okhttp(editor);
            return editor;
        }
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        return null;
    }
}
