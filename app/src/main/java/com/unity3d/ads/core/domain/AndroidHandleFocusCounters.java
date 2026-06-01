package com.unity3d.ads.core.domain;

import android.app.Activity;
import android.support.v4.media.g;
import androidx.annotation.VisibleForTesting;
import com.unity3d.ads.core.data.repository.FocusRepository;
import com.unity3d.ads.core.data.repository.FocusState;
import com.unity3d.ads.core.data.repository.SessionRepository;
import e6.p;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import o6.f;
import o6.h;
import q5.x;
import q6.c0;
import q6.w;
import r2.q;
import t6.d1;
import t6.q0;
import t6.x0;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidHandleFocusCounters {
    private final w defaultDispatcher;
    private final FocusRepository focusRepository;
    private final ConcurrentHashMap<String, f> focusTimesPerActivity;
    private final AndroidGetIsAdActivity isAdActivity;
    private volatile String latestKnownActivityResumed;
    private final q0 previousFocusState;
    private final SessionRepository sessionRepository;
    private final h timeSource;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidHandleFocusCounters$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.AndroidHandleFocusCounters$invoke$1", f = "AndroidHandleFocusCounters.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            AnonymousClass1 anonymousClass1 = AndroidHandleFocusCounters.this.new AnonymousClass1(cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // e6.p
        public final Object invoke(FocusState focusState, c<? super x> cVar) {
            return ((AnonymousClass1) create(focusState, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            String strE;
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            FocusState focusState = (FocusState) this.L$0;
            AndroidHandleFocusCounters.this.onFocusStateChange(focusState);
            Activity activity = focusState.getActivity().get();
            if (activity == null || (strE = b0.a(activity.getClass()).e()) == null) {
                strE = "unknown_activity_name";
            }
            boolean zInvoke = AndroidHandleFocusCounters.this.isAdActivity.invoke(strE);
            x xVar = x.f13520a;
            if (zInvoke) {
                AndroidHandleFocusCounters.this.sessionRepository.incrementGlobalAdsFocusChangeCount();
                if (focusState instanceof FocusState.Focused) {
                    AndroidHandleFocusCounters.this.onResume(strE);
                    return xVar;
                }
                if (focusState instanceof FocusState.Unfocused) {
                    AndroidHandleFocusCounters.this.onPause(strE);
                }
            }
            return xVar;
        }
    }

    public AndroidHandleFocusCounters(SessionRepository sessionRepository, FocusRepository focusRepository, AndroidGetIsAdActivity isAdActivity, w defaultDispatcher, h timeSource) {
        k.e(sessionRepository, "sessionRepository");
        k.e(focusRepository, "focusRepository");
        k.e(isAdActivity, "isAdActivity");
        k.e(defaultDispatcher, "defaultDispatcher");
        k.e(timeSource, "timeSource");
        this.sessionRepository = sessionRepository;
        this.focusRepository = focusRepository;
        this.isAdActivity = isAdActivity;
        this.defaultDispatcher = defaultDispatcher;
        this.timeSource = timeSource;
        this.focusTimesPerActivity = new ConcurrentHashMap<>();
        this.previousFocusState = x0.c(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFocusStateChange(FocusState focusState) {
        d1 d1Var;
        Object value;
        FocusState focusState2;
        q0 q0Var = this.previousFocusState;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
            focusState2 = (FocusState) value;
        } while (!d1Var.g(value, focusState));
        if (focusState2 == null || focusState.getClass() == focusState2.getClass()) {
            return;
        }
        this.sessionRepository.incrementFocusChangeCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPause(String str) {
        String str2 = this.latestKnownActivityResumed;
        if (str2 == null || str2.equals(str)) {
            f fVarRemove = this.focusTimesPerActivity.remove(str);
            if (fVarRemove == null) {
                fVarRemove = this.timeSource.a();
            }
            this.sessionRepository.addTimeToGlobalAdsFocusTime((int) o6.a.d(f.a(fVarRemove.f13217a)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onResume(String str) {
        this.latestKnownActivityResumed = str;
        this.focusTimesPerActivity.put(str, this.timeSource.a());
    }

    public final String getLatestKnownActivityResumed() {
        return this.latestKnownActivityResumed;
    }

    public final void invoke() {
        x0.o(new g(24, this.focusRepository.getFocusState(), new AnonymousClass1(null)), c0.b(this.defaultDispatcher));
    }

    public final void setLatestKnownActivityResumed(String str) {
        this.latestKnownActivityResumed = str;
    }

    public /* synthetic */ AndroidHandleFocusCounters(SessionRepository sessionRepository, FocusRepository focusRepository, AndroidGetIsAdActivity androidGetIsAdActivity, w wVar, h hVar, int i2, kotlin.jvm.internal.f fVar) {
        this(sessionRepository, focusRepository, androidGetIsAdActivity, wVar, (i2 & 16) != 0 ? o6.g.f13218a : hVar);
    }

    @VisibleForTesting
    public static /* synthetic */ void getLatestKnownActivityResumed$annotations() {
    }
}
