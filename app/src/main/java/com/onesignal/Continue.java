package com.onesignal;

import androidx.annotation.RequiresApi;
import java.util.function.Consumer;
import kotlin.jvm.internal.k;
import q5.j;
import q6.m0;
import v5.c;
import v5.h;
import v6.n;
import x6.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Continue {
    public static final Continue INSTANCE = new Continue();

    private Continue() {
    }

    public static final <R> c<R> none() {
        return new c<R>() { // from class: com.onesignal.Continue.none.1
            @Override // v5.c
            public h getContext() {
                e eVar = m0.f13566a;
                return n.f17641a;
            }

            @Override // v5.c
            public void resumeWith(Object obj) {
            }
        };
    }

    @RequiresApi(24)
    public static final <R> c<R> with(Consumer<ContinueResult<R>> onFinished) {
        k.e(onFinished, "onFinished");
        return with$default(onFinished, null, 2, null);
    }

    public static c with$default(Consumer consumer, h hVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            e eVar = m0.f13566a;
            hVar = n.f17641a;
        }
        return with(consumer, hVar);
    }

    @RequiresApi(24)
    public static final <R> c<R> with(final Consumer<ContinueResult<R>> onFinished, final h context) {
        k.e(onFinished, "onFinished");
        k.e(context, "context");
        return new c<R>() { // from class: com.onesignal.Continue.with.1
            @Override // v5.c
            public h getContext() {
                return context;
            }

            @Override // v5.c
            public void resumeWith(Object obj) {
                boolean z2 = obj instanceof j;
                onFinished.accept(new ContinueResult(!z2, z2 ? null : obj, q5.k.a(obj)));
            }
        };
    }
}
