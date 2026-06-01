package androidx.core.os;

import android.os.Trace;
import e6.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class TraceKt {
    public static final <T> T trace(String str, a aVar) {
        Trace.beginSection(str);
        try {
            return (T) aVar.invoke();
        } finally {
            Trace.endSection();
        }
    }
}
