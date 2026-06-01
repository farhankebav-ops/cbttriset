package androidx.work.impl.utils;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.time.Duration;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(26)
public final class DurationApi26Impl {
    @DoNotInline
    public static final long toMillisCompat(Duration duration) {
        k.e(duration, "<this>");
        return duration.toMillis();
    }
}
