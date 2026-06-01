package o1;

import android.graphics.Outline;
import android.graphics.Path;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    @DoNotInline
    public static void a(@NonNull Outline outline, @NonNull Path path) {
        outline.setConvexPath(path);
    }
}
