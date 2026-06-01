package androidx.lifecycle.viewmodel.internal;

import kotlin.jvm.internal.k;
import q6.a0;
import q6.c0;
import q6.m0;
import v5.h;
import v5.i;
import v6.n;
import x6.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CloseableCoroutineScopeKt {
    public static final String VIEW_MODEL_SCOPE_KEY = "androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY";

    public static final CloseableCoroutineScope asCloseable(a0 a0Var) {
        k.e(a0Var, "<this>");
        return new CloseableCoroutineScope(a0Var);
    }

    public static final CloseableCoroutineScope createViewModelScope() {
        h hVar = i.f17610a;
        try {
            e eVar = m0.f13566a;
            hVar = n.f17641a.f13648c;
        } catch (IllegalStateException | q5.h unused) {
        }
        return new CloseableCoroutineScope(hVar.plus(c0.e()));
    }
}
