package com.ironsource;

import android.os.Handler;
import com.ironsource.W6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class X6 {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements W6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f7795a;

        public a(Handler handler) {
            this.f7795a = handler;
        }

        @Override // com.ironsource.W6.a
        public void a(Runnable runnable, long j) {
            kotlin.jvm.internal.k.e(runnable, "runnable");
            this.f7795a.postDelayed(runnable, j);
        }
    }

    public static final W6.a a(Handler handler) {
        kotlin.jvm.internal.k.e(handler, "<this>");
        return new a(handler);
    }
}
