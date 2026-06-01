package com.ironsource;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: com.ironsource.s1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2545s1 {

    /* JADX INFO: renamed from: com.ironsource.s1$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements OutcomeReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v5.c<q5.x> f9790a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(v5.c<? super q5.x> cVar) {
            this.f9790a = cVar;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception error) {
            kotlin.jvm.internal.k.e(error, "error");
            this.f9790a.resumeWith(r2.q.M(error));
        }

        public void onResult(Object obj) {
            this.f9790a.resumeWith(q5.x.f13520a);
        }
    }

    @RequiresApi(31)
    public static final OutcomeReceiver a(v5.c<? super q5.x> cVar) {
        kotlin.jvm.internal.k.e(cVar, "<this>");
        return new a(cVar);
    }
}
