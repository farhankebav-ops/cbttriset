package l7;

import androidx.webkit.ProxyConfig;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileSystem f12844a;

    public d0(FileSystem fileSystem) {
        this.f12844a = fileSystem;
    }

    @Override // l7.c0, l7.t
    public final n0 appendingSink(g0 file, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        s5.c cVarN = r2.q.N();
        cVarN.add(StandardOpenOption.APPEND);
        if (!z2) {
            cVarN.add(StandardOpenOption.CREATE);
        }
        s5.c cVarO = r2.q.o(cVarN);
        Path pathI = i(file);
        StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) cVarO.toArray(new StandardOpenOption[0]);
        OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(pathI, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        kotlin.jvm.internal.k.d(outputStreamNewOutputStream, "newOutputStream(...)");
        return b.h(outputStreamNewOutputStream);
    }

    @Override // l7.e0, l7.c0, l7.t
    public final void atomicMove(g0 source, g0 target) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(target, "target");
        try {
            kotlin.jvm.internal.k.d(Files.move(i(source), i(target), (CopyOption[]) Arrays.copyOf(new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING}, 2)), "move(...)");
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    @Override // l7.c0, l7.t
    public final g0 canonicalize(g0 path) throws IOException {
        kotlin.jvm.internal.k.e(path, "path");
        try {
            String str = g0.f12850b;
            Path realPath = i(path).toRealPath(new LinkOption[0]);
            kotlin.jvm.internal.k.d(realPath, "toRealPath(...)");
            return w1.f.f(realPath);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(com.ironsource.adqualitysdk.sdk.i.a0.e(path, "no such file: "));
        }
    }

    @Override // l7.t, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f12844a.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    @Override // l7.c0, l7.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void createDirectory(l7.g0 r4, boolean r5) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "dir"
            kotlin.jvm.internal.k.e(r4, r0)
            l7.r r0 = r3.metadataOrNull(r4)
            r1 = 0
            if (r0 == 0) goto L12
            boolean r0 = r0.f12899b
            r2 = 1
            if (r0 != r2) goto L12
            goto L13
        L12:
            r2 = r1
        L13:
            if (r2 == 0) goto L2f
            if (r5 != 0) goto L18
            goto L2f
        L18:
            java.io.IOException r5 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r4 = " already exists."
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.<init>(r4)
            throw r5
        L2f:
            java.nio.file.Path r5 = r3.i(r4)     // Catch: java.io.IOException -> L45
            java.nio.file.attribute.FileAttribute[] r0 = new java.nio.file.attribute.FileAttribute[r1]     // Catch: java.io.IOException -> L45
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)     // Catch: java.io.IOException -> L45
            java.nio.file.attribute.FileAttribute[] r0 = (java.nio.file.attribute.FileAttribute[]) r0     // Catch: java.io.IOException -> L45
            java.nio.file.Path r5 = java.nio.file.Files.createDirectory(r5, r0)     // Catch: java.io.IOException -> L45
            java.lang.String r0 = "createDirectory(...)"
            kotlin.jvm.internal.k.d(r5, r0)     // Catch: java.io.IOException -> L45
            return
        L45:
            r5 = move-exception
            if (r2 == 0) goto L49
            return
        L49:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "failed to create directory: "
            java.lang.String r4 = com.ironsource.adqualitysdk.sdk.i.a0.e(r4, r1)
            r0.<init>(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.d0.createDirectory(l7.g0, boolean):void");
    }

    @Override // l7.e0, l7.c0, l7.t
    public final void createSymlink(g0 source, g0 target) {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(target, "target");
        kotlin.jvm.internal.k.d(Files.createSymbolicLink(i(source), i(target), (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0)), "createSymbolicLink(...)");
    }

    @Override // l7.c0, l7.t
    public final void delete(g0 path, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        Path pathI = i(path);
        try {
            Files.delete(pathI);
        } catch (NoSuchFileException unused) {
            if (z2) {
                throw new FileNotFoundException(com.ironsource.adqualitysdk.sdk.i.a0.e(path, "no such file: "));
            }
        } catch (IOException unused2) {
            if (Files.exists(pathI, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                throw new IOException(com.ironsource.adqualitysdk.sdk.i.a0.e(path, "failed to delete "));
            }
        }
    }

    public final ArrayList g(g0 g0Var, boolean z2) throws IOException {
        Path pathI = i(g0Var);
        try {
            DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(pathI, ProxyConfig.MATCH_ALL_SCHEMES);
            try {
                kotlin.jvm.internal.k.b(directoryStreamNewDirectoryStream);
                List<Path> listN1 = r5.l.n1(directoryStreamNewDirectoryStream);
                r2.q.I(directoryStreamNewDirectoryStream, null);
                ArrayList arrayList = new ArrayList();
                for (Path path : listN1) {
                    String str = g0.f12850b;
                    arrayList.add(w1.f.f(path));
                }
                r5.p.M0(arrayList);
                return arrayList;
            } finally {
            }
        } catch (Exception unused) {
            if (!z2) {
                return null;
            }
            if (Files.exists(pathI, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                throw new IOException(com.ironsource.adqualitysdk.sdk.i.a0.e(g0Var, "failed to list "));
            }
            throw new FileNotFoundException(com.ironsource.adqualitysdk.sdk.i.a0.e(g0Var, "no such file: "));
        }
    }

    public final Path i(g0 g0Var) {
        Path path = this.f12844a.getPath(g0Var.f12851a.t(), new String[0]);
        kotlin.jvm.internal.k.d(path, "getPath(...)");
        return path;
    }

    @Override // l7.c0, l7.t
    public final List list(g0 dir) throws IOException {
        kotlin.jvm.internal.k.e(dir, "dir");
        ArrayList arrayListG = g(dir, true);
        kotlin.jvm.internal.k.b(arrayListG);
        return arrayListG;
    }

    @Override // l7.c0, l7.t
    public final List listOrNull(g0 dir) {
        kotlin.jvm.internal.k.e(dir, "dir");
        return g(dir, false);
    }

    @Override // l7.e0, l7.c0, l7.t
    public final r metadataOrNull(g0 path) {
        kotlin.jvm.internal.k.e(path, "path");
        return e0.b(i(path));
    }

    @Override // l7.c0, l7.t
    public final q openReadOnly(g0 file) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        try {
            boolean z2 = false;
            FileChannel fileChannelOpen = FileChannel.open(i(file), StandardOpenOption.READ);
            kotlin.jvm.internal.k.b(fileChannelOpen);
            return new b0(z2, fileChannelOpen, 1);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(com.ironsource.adqualitysdk.sdk.i.a0.e(file, "no such file: "));
        }
    }

    @Override // l7.c0, l7.t
    public final q openReadWrite(g0 file, boolean z2, boolean z7) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        if (z2 && z7) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        s5.c cVarN = r2.q.N();
        cVarN.add(StandardOpenOption.READ);
        cVarN.add(StandardOpenOption.WRITE);
        if (z2) {
            cVarN.add(StandardOpenOption.CREATE_NEW);
        } else if (!z7) {
            cVarN.add(StandardOpenOption.CREATE);
        }
        s5.c cVarO = r2.q.o(cVarN);
        try {
            Path pathI = i(file);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) cVarO.toArray(new StandardOpenOption[0]);
            FileChannel fileChannelOpen = FileChannel.open(pathI, (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length));
            kotlin.jvm.internal.k.b(fileChannelOpen);
            return new b0(true, fileChannelOpen, 1);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(com.ironsource.adqualitysdk.sdk.i.a0.e(file, "no such file: "));
        }
    }

    @Override // l7.c0, l7.t
    public final n0 sink(g0 file, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        s5.c cVarN = r2.q.N();
        if (z2) {
            cVarN.add(StandardOpenOption.CREATE_NEW);
        }
        s5.c cVarO = r2.q.o(cVarN);
        try {
            Path pathI = i(file);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) cVarO.toArray(new StandardOpenOption[0]);
            OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
            OutputStream outputStreamNewOutputStream = Files.newOutputStream(pathI, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
            kotlin.jvm.internal.k.d(outputStreamNewOutputStream, "newOutputStream(...)");
            return b.h(outputStreamNewOutputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(com.ironsource.adqualitysdk.sdk.i.a0.e(file, "no such file: "));
        }
    }

    @Override // l7.c0, l7.t
    public final o0 source(g0 file) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        try {
            InputStream inputStreamNewInputStream = Files.newInputStream(i(file), (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
            kotlin.jvm.internal.k.d(inputStreamNewInputStream, "newInputStream(...)");
            return b.j(inputStreamNewInputStream);
        } catch (NoSuchFileException unused) {
            throw new FileNotFoundException(com.ironsource.adqualitysdk.sdk.i.a0.e(file, "no such file: "));
        }
    }

    @Override // l7.e0, l7.c0
    public final String toString() {
        String strF = kotlin.jvm.internal.b0.a(this.f12844a.getClass()).f();
        kotlin.jvm.internal.k.b(strF);
        return strF;
    }
}
