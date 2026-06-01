package l7;

import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class c0 extends t {
    public static ArrayList a(g0 g0Var, boolean z2) throws IOException {
        File file = g0Var.toFile();
        String[] list = file.list();
        if (list == null) {
            if (!z2) {
                return null;
            }
            if (file.exists()) {
                throw new IOException(com.ironsource.adqualitysdk.sdk.i.a0.e(g0Var, "failed to list "));
            }
            throw new FileNotFoundException(com.ironsource.adqualitysdk.sdk.i.a0.e(g0Var, "no such file: "));
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            kotlin.jvm.internal.k.b(str);
            arrayList.add(g0Var.e(str));
        }
        r5.p.M0(arrayList);
        return arrayList;
    }

    @Override // l7.t
    public n0 appendingSink(g0 file, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        if (!z2 || exists(file)) {
            return b.h(new FileOutputStream(file.toFile(), true));
        }
        throw new IOException(file + " doesn't exist.");
    }

    @Override // l7.t
    public void atomicMove(g0 source, g0 target) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(target, "target");
        if (source.toFile().renameTo(target.toFile())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // l7.t
    public g0 canonicalize(g0 path) throws IOException {
        kotlin.jvm.internal.k.e(path, "path");
        File canonicalFile = path.toFile().getCanonicalFile();
        if (!canonicalFile.exists()) {
            throw new FileNotFoundException("no such file");
        }
        String str = g0.f12850b;
        return w1.f.e(canonicalFile);
    }

    @Override // l7.t
    public void createDirectory(g0 dir, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(dir, "dir");
        if (dir.toFile().mkdir()) {
            return;
        }
        r rVarMetadataOrNull = metadataOrNull(dir);
        if (rVarMetadataOrNull == null || !rVarMetadataOrNull.f12899b) {
            throw new IOException(com.ironsource.adqualitysdk.sdk.i.a0.e(dir, "failed to create directory: "));
        }
        if (z2) {
            throw new IOException(dir + " already exists.");
        }
    }

    @Override // l7.t
    public void createSymlink(g0 source, g0 target) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(target, "target");
        throw new IOException("unsupported");
    }

    @Override // l7.t
    public void delete(g0 path, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = path.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            throw new IOException(com.ironsource.adqualitysdk.sdk.i.a0.e(path, "failed to delete "));
        }
        if (z2) {
            throw new FileNotFoundException(com.ironsource.adqualitysdk.sdk.i.a0.e(path, "no such file: "));
        }
    }

    @Override // l7.t
    public List list(g0 dir) throws IOException {
        kotlin.jvm.internal.k.e(dir, "dir");
        ArrayList arrayListA = a(dir, true);
        kotlin.jvm.internal.k.b(arrayListA);
        return arrayListA;
    }

    @Override // l7.t
    public List listOrNull(g0 dir) {
        kotlin.jvm.internal.k.e(dir, "dir");
        return a(dir, false);
    }

    @Override // l7.t
    public r metadataOrNull(g0 path) {
        kotlin.jvm.internal.k.e(path, "path");
        File file = path.toFile();
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (zIsFile || zIsDirectory || jLastModified != 0 || length != 0 || file.exists()) {
            return new r(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null);
        }
        return null;
    }

    @Override // l7.t
    public q openReadOnly(g0 file) {
        kotlin.jvm.internal.k.e(file, "file");
        return new b0(false, new RandomAccessFile(file.toFile(), AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ), 0);
    }

    @Override // l7.t
    public q openReadWrite(g0 file, boolean z2, boolean z7) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        if (z2 && z7) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        if (z2 && exists(file)) {
            throw new IOException(file + " already exists.");
        }
        if (!z7 || exists(file)) {
            return new b0(true, new RandomAccessFile(file.toFile(), "rw"), 0);
        }
        throw new IOException(file + " doesn't exist.");
    }

    @Override // l7.t
    public n0 sink(g0 file, boolean z2) throws IOException {
        kotlin.jvm.internal.k.e(file, "file");
        if (!z2 || !exists(file)) {
            return b.h(new FileOutputStream(file.toFile(), false));
        }
        throw new IOException(file + " already exists.");
    }

    @Override // l7.t
    public o0 source(g0 file) {
        kotlin.jvm.internal.k.e(file, "file");
        return new e(new FileInputStream(file.toFile()), r0.NONE);
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
