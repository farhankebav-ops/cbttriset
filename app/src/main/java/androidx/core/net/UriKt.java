package androidx.core.net;

import a1.a;
import android.net.Uri;
import com.ironsource.C2300e4;
import java.io.File;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class UriKt {
    public static final File toFile(Uri uri) {
        if (!k.a(uri.getScheme(), C2300e4.h.f8363b)) {
            throw new IllegalArgumentException(a.k("Uri lacks 'file' scheme: ", uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(a.k("Uri path is null: ", uri).toString());
    }

    public static final Uri toUri(String str) {
        return Uri.parse(str);
    }

    public static final Uri toUri(File file) {
        return Uri.fromFile(file);
    }
}
