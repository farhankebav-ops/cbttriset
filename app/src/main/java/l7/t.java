package l7;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t implements Closeable {
    public static final s Companion = new s();
    public static final t RESOURCES;
    public static final t SYSTEM;
    public static final g0 SYSTEM_TEMPORARY_DIRECTORY;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v0, types: [e6.l, java.lang.Object] */
    /* JADX INFO: renamed from: -write$default, reason: not valid java name */
    public static /* synthetic */ Object m3452write$default(t tVar, g0 file, boolean z2, e6.l writerAction, int i2, Object obj) throws IOException {
        ?? r32;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        kotlin.jvm.internal.k.e(file, "file");
        kotlin.jvm.internal.k.e(writerAction, "writerAction");
        i0 i0VarB = b.b(tVar.sink(file, z2));
        Object th = null;
        try {
            Object objInvoke = writerAction.invoke(i0VarB);
            try {
                i0VarB.close();
            } catch (Throwable th2) {
                th = th2;
            }
            r32 = th;
            th = objInvoke;
        } catch (Throwable th3) {
            try {
                i0VarB.close();
                r32 = th3;
            } catch (Throwable th4) {
                a.a.h(th3, th4);
                r32 = th3;
            }
        }
        if (r32 == 0) {
            return th;
        }
        throw r32;
    }

    static {
        t c0Var;
        try {
            Class.forName("java.nio.file.Files");
            c0Var = new e0();
        } catch (ClassNotFoundException unused) {
            c0Var = new c0();
        }
        SYSTEM = c0Var;
        String str = g0.f12850b;
        String property = System.getProperty("java.io.tmpdir");
        kotlin.jvm.internal.k.d(property, "getProperty(...)");
        SYSTEM_TEMPORARY_DIRECTORY = w1.f.d(property, false);
        ClassLoader classLoader = m7.i.class.getClassLoader();
        kotlin.jvm.internal.k.d(classLoader, "getClassLoader(...)");
        RESOURCES = new m7.i(classLoader);
    }

    public static /* synthetic */ n0 appendingSink$default(t tVar, g0 g0Var, boolean z2, int i2, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return tVar.appendingSink(g0Var, z2);
    }

    public static /* synthetic */ void createDirectories$default(t tVar, g0 g0Var, boolean z2, int i2, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        tVar.createDirectories(g0Var, z2);
    }

    public static /* synthetic */ void createDirectory$default(t tVar, g0 g0Var, boolean z2, int i2, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        tVar.createDirectory(g0Var, z2);
    }

    public static /* synthetic */ void delete$default(t tVar, g0 g0Var, boolean z2, int i2, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        tVar.delete(g0Var, z2);
    }

    public static /* synthetic */ void deleteRecursively$default(t tVar, g0 g0Var, boolean z2, int i2, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        tVar.deleteRecursively(g0Var, z2);
    }

    public static final t get(FileSystem fileSystem) {
        Companion.getClass();
        kotlin.jvm.internal.k.e(fileSystem, "<this>");
        return new d0(fileSystem);
    }

    public static /* synthetic */ m6.h listRecursively$default(t tVar, g0 g0Var, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return tVar.listRecursively(g0Var, z2);
    }

    public static /* synthetic */ q openReadWrite$default(t tVar, g0 g0Var, boolean z2, boolean z7, int i2, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            z7 = false;
        }
        return tVar.openReadWrite(g0Var, z2, z7);
    }

    public static /* synthetic */ n0 sink$default(t tVar, g0 g0Var, boolean z2, int i2, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return tVar.sink(g0Var, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [e6.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX INFO: renamed from: -read, reason: not valid java name */
    public final <T> T m3453read(g0 file, e6.l readerAction) throws IOException {
        ?? r42;
        kotlin.jvm.internal.k.e(file, "file");
        kotlin.jvm.internal.k.e(readerAction, "readerAction");
        j0 j0VarC = b.c(source(file));
        T t3 = null;
        try {
            Object objInvoke = readerAction.invoke(j0VarC);
            try {
                j0VarC.close();
            } catch (Throwable 
            /*  JADX ERROR: Method code generation error
                java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                */
            /*
                this = this;
                java.lang.String r0 = "file"
                kotlin.jvm.internal.k.e(r3, r0)
                java.lang.String r0 = "readerAction"
                kotlin.jvm.internal.k.e(r4, r0)
                l7.o0 r3 = r2.source(r3)
                l7.j0 r3 = l7.b.c(r3)
                r0 = 0
                java.lang.Object r4 = r4.invoke(r3)     // Catch: java.lang.Throwable -> L20
                r3.close()     // Catch: java.lang.Throwable -> L1b
                goto L1c
            L1b:
                r0 = move-exception
            L1c:
                r1 = r0
                r0 = r4
                r4 = r1
                goto L29
            L20:
                r4 = move-exception
                r3.close()     // Catch: java.lang.Throwable -> L25
                goto L29
            L25:
                r3 = move-exception
                a.a.h(r4, r3)
            L29:
                if (r4 != 0) goto L2c
                return r0
            L2c:
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: l7.t.m3453read(l7.g0, e6.l):java.lang.Object");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [e6.l, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v6 */
        /* JADX INFO: renamed from: -write, reason: not valid java name */
        public final <T> T m3454write(g0 file, boolean z2, e6.l writerAction) throws IOException {
            ?? r52;
            kotlin.jvm.internal.k.e(file, "file");
            kotlin.jvm.internal.k.e(writerAction, "writerAction");
            i0 i0VarB = b.b(sink(file, z2));
            T t3 = null;
            try {
                Object objInvoke = writerAction.invoke(i0VarB);
                try {
                    i0VarB.close();
                } catch (Throwable 
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                    */
                /*
                    this = this;
                    java.lang.String r0 = "file"
                    kotlin.jvm.internal.k.e(r3, r0)
                    java.lang.String r0 = "writerAction"
                    kotlin.jvm.internal.k.e(r5, r0)
                    l7.n0 r3 = r2.sink(r3, r4)
                    l7.i0 r3 = l7.b.b(r3)
                    r4 = 0
                    java.lang.Object r5 = r5.invoke(r3)     // Catch: java.lang.Throwable -> L20
                    r3.close()     // Catch: java.lang.Throwable -> L1b
                    goto L1c
                L1b:
                    r4 = move-exception
                L1c:
                    r1 = r5
                    r5 = r4
                    r4 = r1
                    goto L29
                L20:
                    r5 = move-exception
                    r3.close()     // Catch: java.lang.Throwable -> L25
                    goto L29
                L25:
                    r3 = move-exception
                    a.a.h(r5, r3)
                L29:
                    if (r5 != 0) goto L2c
                    return r4
                L2c:
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: l7.t.m3454write(l7.g0, boolean, e6.l):java.lang.Object");
            }

            public final n0 appendingSink(g0 file) throws IOException {
                kotlin.jvm.internal.k.e(file, "file");
                return appendingSink(file, false);
            }

            public abstract n0 appendingSink(g0 g0Var, boolean z2);

            public abstract void atomicMove(g0 g0Var, g0 g0Var2);

            public abstract g0 canonicalize(g0 g0Var);

            public void copy(g0 source, g0 target) throws Throwable {
                Throwable th;
                Long lValueOf;
                kotlin.jvm.internal.k.e(source, "source");
                kotlin.jvm.internal.k.e(target, "target");
                o0 o0VarSource = source(source);
                Throwable th2 = null;
                try {
                    i0 i0VarB = b.b(sink$default(this, target, false, 2, null));
                    try {
                        lValueOf = Long.valueOf(i0VarB.H(o0VarSource));
                        try {
                            i0VarB.close();
                            th = null;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        try {
                            i0VarB.close();
                        } catch (Throwable th5) {
                            a.a.h(th4, th5);
                        }
                        th = th4;
                        lValueOf = null;
                    }
                } catch (Throwable th6) {
                    th2 = th6;
                    if (o0VarSource != null) {
                        try {
                            o0VarSource.close();
                        } catch (Throwable th7) {
                            a.a.h(th2, th7);
                        }
                    }
                }
                if (th != null) {
                    throw th;
                }
                lValueOf.getClass();
                if (o0VarSource != null) {
                    try {
                        o0VarSource.close();
                    } catch (Throwable th8) {
                        th2 = th8;
                    }
                }
                if (th2 != null) {
                    throw th2;
                }
            }

            public final void createDirectories(g0 dir, boolean z2) throws IOException {
                kotlin.jvm.internal.k.e(dir, "dir");
                r5.i iVar = new r5.i();
                for (g0 g0VarC = dir; g0VarC != null && !exists(g0VarC); g0VarC = g0VarC.c()) {
                    iVar.addFirst(g0VarC);
                }
                if (z2 && iVar.isEmpty()) {
                    throw new IOException(dir + " already exists.");
                }
                Iterator<E> it = iVar.iterator();
                while (it.hasNext()) {
                    createDirectory$default(this, (g0) it.next(), false, 2, null);
                }
            }

            public final void createDirectory(g0 dir) throws IOException {
                kotlin.jvm.internal.k.e(dir, "dir");
                createDirectory(dir, false);
            }

            public abstract void createDirectory(g0 g0Var, boolean z2);

            public abstract void createSymlink(g0 g0Var, g0 g0Var2);

            public final void delete(g0 path) throws IOException {
                kotlin.jvm.internal.k.e(path, "path");
                delete(path, false);
            }

            public abstract void delete(g0 g0Var, boolean z2);

            public void deleteRecursively(g0 fileOrDirectory, boolean z2) throws IOException {
                kotlin.jvm.internal.k.e(fileOrDirectory, "fileOrDirectory");
                m6.i iVarI0 = r2.q.i0(new m7.d(this, fileOrDirectory, null));
                while (iVarI0.hasNext()) {
                    delete((g0) iVarI0.next(), z2 && !iVarI0.hasNext());
                }
            }

            public final boolean exists(g0 path) throws IOException {
                kotlin.jvm.internal.k.e(path, "path");
                return metadataOrNull(path) != null;
            }

            public abstract List list(g0 g0Var);

            public abstract List listOrNull(g0 g0Var);

            public final m6.h listRecursively(g0 dir) {
                kotlin.jvm.internal.k.e(dir, "dir");
                return listRecursively(dir, false);
            }

            public final r metadata(g0 path) throws IOException {
                kotlin.jvm.internal.k.e(path, "path");
                r rVarMetadataOrNull = metadataOrNull(path);
                if (rVarMetadataOrNull != null) {
                    return rVarMetadataOrNull;
                }
                throw new FileNotFoundException(com.ironsource.adqualitysdk.sdk.i.a0.e(path, "no such file: "));
            }

            public abstract r metadataOrNull(g0 g0Var);

            public abstract q openReadOnly(g0 g0Var);

            public final q openReadWrite(g0 file) throws IOException {
                kotlin.jvm.internal.k.e(file, "file");
                return openReadWrite(file, false, false);
            }

            public abstract q openReadWrite(g0 g0Var, boolean z2, boolean z7);

            public final n0 sink(g0 file) throws IOException {
                kotlin.jvm.internal.k.e(file, "file");
                return sink(file, false);
            }

            public abstract n0 sink(g0 g0Var, boolean z2);

            public abstract o0 source(g0 g0Var);

            public m6.h listRecursively(g0 dir, boolean z2) {
                kotlin.jvm.internal.k.e(dir, "dir");
                return new c6.m(new m7.e(dir, this, z2, null));
            }

            public final void deleteRecursively(g0 fileOrDirectory) throws IOException {
                kotlin.jvm.internal.k.e(fileOrDirectory, "fileOrDirectory");
                deleteRecursively(fileOrDirectory, false);
            }

            public final void createDirectories(g0 dir) throws IOException {
                kotlin.jvm.internal.k.e(dir, "dir");
                createDirectories(dir, false);
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        }
