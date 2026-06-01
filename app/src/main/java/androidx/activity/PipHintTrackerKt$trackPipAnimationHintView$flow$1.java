package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import s6.w;
import s6.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@x5.e(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", l = {86}, m = "invokeSuspend")
public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends x5.i implements e6.p {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PipHintTrackerKt$trackPipAnimationHintView$flow$1(View view, v5.c<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1> cVar) {
        super(2, cVar);
        this.$view = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(x xVar, View view, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        if (i2 == i11 && i9 == i13 && i8 == i12 && i10 == i14) {
            return;
        }
        kotlin.jvm.internal.k.b(view);
        ((w) xVar).d(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(x xVar, View view) {
        ((w) xVar).d(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final q5.x invokeSuspend$lambda$2(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, View.OnLayoutChangeListener onLayoutChangeListener, PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1) {
        view.getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
        view.removeOnLayoutChangeListener(onLayoutChangeListener);
        view.removeOnAttachStateChangeListener(pipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1);
        return q5.x.f13520a;
    }

    @Override // x5.a
    public final v5.c<q5.x> create(Object obj, v5.c<?> cVar) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, cVar);
        pipHintTrackerKt$trackPipAnimationHintView$flow$1.L$0 = obj;
        return pipHintTrackerKt$trackPipAnimationHintView$flow$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View$OnLayoutChangeListener, androidx.activity.q] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.view.ViewTreeObserver$OnScrollChangedListener, androidx.activity.s] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View$OnAttachStateChangeListener, androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1] */
    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.label;
        if (i2 == 0) {
            r2.q.z0(obj);
            final x xVar = (x) this.L$0;
            final ?? r1 = new View.OnLayoutChangeListener() { // from class: androidx.activity.q
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
                    PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$0(xVar, view, i8, i9, i10, i11, i12, i13, i14, i15);
                }
            };
            final View view = this.$view;
            final ?? r42 = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.activity.s
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$1(xVar, view);
                }
            };
            final ?? r52 = new View.OnAttachStateChangeListener() { // from class: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v2) {
                    kotlin.jvm.internal.k.e(v2, "v");
                    ((w) xVar).d(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view));
                    view.getViewTreeObserver().addOnScrollChangedListener(r42);
                    view.addOnLayoutChangeListener(r1);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v2) {
                    kotlin.jvm.internal.k.e(v2, "v");
                    v2.getViewTreeObserver().removeOnScrollChangedListener(r42);
                    v2.removeOnLayoutChangeListener(r1);
                }
            };
            if (this.$view.isAttachedToWindow()) {
                ((w) xVar).d(PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(this.$view));
                this.$view.getViewTreeObserver().addOnScrollChangedListener(r42);
                this.$view.addOnLayoutChangeListener(r1);
            }
            this.$view.addOnAttachStateChangeListener(r52);
            final View view2 = this.$view;
            e6.a aVar2 = new e6.a() { // from class: androidx.activity.t
                @Override // e6.a
                public final Object invoke() {
                    return PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$2(view2, r42, r1, r52);
                }
            };
            this.label = 1;
            if (r2.q.m(xVar, aVar2, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r2.q.z0(obj);
        }
        return q5.x.f13520a;
    }

    @Override // e6.p
    public final Object invoke(x xVar, v5.c<? super q5.x> cVar) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(xVar, cVar)).invokeSuspend(q5.x.f13520a);
    }
}
