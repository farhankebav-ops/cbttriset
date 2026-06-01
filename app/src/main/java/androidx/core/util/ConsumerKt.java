package androidx.core.util;

import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
public final class ConsumerKt {
    @RequiresApi(24)
    public static final <T> java.util.function.Consumer<T> asConsumer(v5.c<? super T> cVar) {
        return androidx.core.location.a.r(new ContinuationConsumer(cVar));
    }
}
