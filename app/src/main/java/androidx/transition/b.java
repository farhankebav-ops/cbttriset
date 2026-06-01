package androidx.transition;

import androidx.transition.Transition;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static void a(Transition.TransitionListener transitionListener, Transition transition, boolean z2) {
        transitionListener.onTransitionEnd(transition);
    }

    public static void b(Transition.TransitionListener transitionListener, Transition transition, boolean z2) {
        transitionListener.onTransitionStart(transition);
    }
}
