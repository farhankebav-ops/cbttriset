package androidx.datastore.core;

import android.os.Build;
import java.io.File;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FileMoves_androidKt {
    public static final boolean atomicMoveTo(File file, File toFile) {
        k.e(file, "<this>");
        k.e(toFile, "toFile");
        return Build.VERSION.SDK_INT >= 26 ? Api26Impl.INSTANCE.move(file, toFile) : file.renameTo(toFile);
    }
}
