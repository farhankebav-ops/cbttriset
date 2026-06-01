package androidx.datastore.core;

import e6.l;
import kotlin.jvm.internal.k;
import z6.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MutexUtilsKt {
    public static final <R> R withTryLock(z6.a aVar, Object obj, l block) {
        k.e(aVar, "<this>");
        k.e(block, "block");
        c cVar = (c) aVar;
        boolean zE = cVar.e(obj);
        try {
            return (R) block.invoke(Boolean.valueOf(zE));
        } finally {
            if (zE) {
                cVar.f(obj);
            }
        }
    }

    public static /* synthetic */ Object withTryLock$default(z6.a aVar, Object obj, l block, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = null;
        }
        k.e(aVar, "<this>");
        k.e(block, "block");
        c cVar = (c) aVar;
        boolean zE = cVar.e(obj);
        try {
            return block.invoke(Boolean.valueOf(zE));
        } finally {
            if (zE) {
                cVar.f(obj);
            }
        }
    }
}
