package l7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class e0 extends c0 {
    public static r b(Path path) {
        g0 g0VarF;
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            Path symbolicLink = attributes.isSymbolicLink() ? Files.readSymbolicLink(path) : null;
            boolean zIsRegularFile = attributes.isRegularFile();
            boolean zIsDirectory = attributes.isDirectory();
            if (symbolicLink != null) {
                String str = g0.f12850b;
                g0VarF = w1.f.f(symbolicLink);
            } else {
                g0VarF = null;
            }
            Long lValueOf = Long.valueOf(attributes.size());
            FileTime fileTimeCreationTime = attributes.creationTime();
            Long lE = fileTimeCreationTime != null ? e(fileTimeCreationTime) : null;
            FileTime fileTimeLastModifiedTime = attributes.lastModifiedTime();
            Long lE2 = fileTimeLastModifiedTime != null ? e(fileTimeLastModifiedTime) : null;
            FileTime fileTimeLastAccessTime = attributes.lastAccessTime();
            return new r(zIsRegularFile, zIsDirectory, g0VarF, lValueOf, lE, lE2, fileTimeLastAccessTime != null ? e(fileTimeLastAccessTime) : null);
        } catch (NoSuchFileException | FileSystemException unused) {
            return null;
        }
    }

    public static Long e(FileTime fileTime) {
        long millis = fileTime.toMillis();
        Long lValueOf = Long.valueOf(millis);
        if (millis != 0) {
            return lValueOf;
        }
        return null;
    }

    @Override // l7.c0, l7.t
    public void atomicMove(g0 source, g0 target) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(target, "target");
        try {
            Files.move(source.g(), target.g(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    @Override // l7.c0, l7.t
    public void createSymlink(g0 source, g0 target) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(target, "target");
        Files.createSymbolicLink(source.g(), target.g(), new FileAttribute[0]);
    }

    @Override // l7.c0, l7.t
    public r metadataOrNull(g0 path) {
        kotlin.jvm.internal.k.e(path, "path");
        return b(path.g());
    }

    @Override // l7.c0
    public String toString() {
        return "NioSystemFileSystem";
    }
}
