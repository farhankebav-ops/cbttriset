package c6;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class b extends IOException {
    public b(File file, File file2, String str) {
        kotlin.jvm.internal.k.e(file, "file");
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        sb.append(": ".concat(str));
        String string = sb.toString();
        kotlin.jvm.internal.k.d(string, "toString(...)");
        super(string);
    }
}
