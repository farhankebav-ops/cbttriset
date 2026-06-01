package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnimationInfo extends SpecialEffectsInfo {
        private FragmentAnim.AnimationOrAnimator animation;
        private boolean isAnimLoaded;
        private final boolean isPop;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnimationInfo(SpecialEffectsController.Operation operation, CancellationSignal signal, boolean z2) {
            super(operation, signal);
            k.e(operation, "operation");
            k.e(signal, "signal");
            this.isPop = z2;
        }

        public final FragmentAnim.AnimationOrAnimator getAnimation(Context context) {
            k.e(context, "context");
            if (this.isAnimLoaded) {
                return this.animation;
            }
            FragmentAnim.AnimationOrAnimator animationOrAnimatorLoadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.isPop);
            this.animation = animationOrAnimatorLoadAnimation;
            this.isAnimLoaded = true;
            return animationOrAnimatorLoadAnimation;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class SpecialEffectsInfo {
        private final SpecialEffectsController.Operation operation;
        private final CancellationSignal signal;

        public SpecialEffectsInfo(SpecialEffectsController.Operation operation, CancellationSignal signal) {
            k.e(operation, "operation");
            k.e(signal, "signal");
            this.operation = operation;
            this.signal = signal;
        }

        public final void completeSpecialEffect() {
            this.operation.completeSpecialEffect(this.signal);
        }

        public final SpecialEffectsController.Operation getOperation() {
            return this.operation;
        }

        public final CancellationSignal getSignal() {
            return this.signal;
        }

        public final boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State.Companion companion = SpecialEffectsController.Operation.State.Companion;
            View view = this.operation.getFragment().mView;
            k.d(view, "operation.fragment.mView");
            SpecialEffectsController.Operation.State stateAsOperationState = companion.asOperationState(view);
            SpecialEffectsController.Operation.State finalState = this.operation.getFinalState();
            if (stateAsOperationState == finalState) {
                return true;
            }
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            return (stateAsOperationState == state || finalState == state) ? false : true;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$retainMatchingViews$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        final /* synthetic */ Collection<String> $names;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Collection<String> collection) {
            super(1);
            this.$names = collection;
        }

        @Override // e6.l
        public final Boolean invoke(Map.Entry<String, View> entry) {
            k.e(entry, "entry");
            return Boolean.valueOf(r5.l.T0(this.$names, ViewCompat.getTransitionName(entry.getValue())));
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$startAnimations$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass3 implements Animation.AnimationListener {
        final /* synthetic */ AnimationInfo $animationInfo;
        final /* synthetic */ SpecialEffectsController.Operation $operation;
        final /* synthetic */ View $viewToAnimate;
        final /* synthetic */ DefaultSpecialEffectsController this$0;

        public AnonymousClass3(SpecialEffectsController.Operation operation, DefaultSpecialEffectsController defaultSpecialEffectsController, View view, AnimationInfo animationInfo) {
            this.$operation = operation;
            this.this$0 = defaultSpecialEffectsController;
            this.$viewToAnimate = view;
            this.$animationInfo = animationInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onAnimationEnd$lambda$0(DefaultSpecialEffectsController this$0, View view, AnimationInfo animationInfo) {
            k.e(this$0, "this$0");
            k.e(animationInfo, "$animationInfo");
            this$0.getContainer().endViewTransition(view);
            animationInfo.completeSpecialEffect();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            k.e(animation, "animation");
            this.this$0.getContainer().post(new c(this.this$0, this.$viewToAnimate, this.$animationInfo, 0));
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animation from operation " + this.$operation + " has ended.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            k.e(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            k.e(animation, "animation");
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Animation from operation " + this.$operation + " has reached onAnimationStart.");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController(ViewGroup container) {
        super(container);
        k.e(container, "container");
    }

    private final void applyContainerChanges(SpecialEffectsController.Operation operation) {
        View view = operation.getFragment().mView;
        SpecialEffectsController.Operation.State finalState = operation.getFinalState();
        k.d(view, "view");
        finalState.applyState(view);
    }

    private final void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                captureTransitioningViews(arrayList, childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeOperations$lambda$2(List awaitingContainerChanges, SpecialEffectsController.Operation operation, DefaultSpecialEffectsController this$0) {
        k.e(awaitingContainerChanges, "$awaitingContainerChanges");
        k.e(operation, "$operation");
        k.e(this$0, "this$0");
        if (awaitingContainerChanges.contains(operation)) {
            awaitingContainerChanges.remove(operation);
            this$0.applyContainerChanges(operation);
        }
    }

    private final void findNamedViews(Map<String, View> map, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    private final void retainMatchingViews(ArrayMap<String, View> arrayMap, Collection<String> collection) {
        Set<Map.Entry<String, View>> entries = arrayMap.entrySet();
        k.d(entries, "entries");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(collection);
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            if (!((Boolean) anonymousClass1.invoke(it.next())).booleanValue()) {
                it.remove();
            }
        }
    }

    private final void startAnimations(List<AnimationInfo> list, List<SpecialEffectsController.Operation> list2, boolean z2, Map<SpecialEffectsController.Operation, Boolean> map) {
        Context context = getContainer().getContext();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        boolean z7 = false;
        for (final AnimationInfo animationInfo : list) {
            if (animationInfo.isVisibilityUnchanged()) {
                animationInfo.completeSpecialEffect();
            } else {
                k.d(context, "context");
                FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
                if (animation == null) {
                    animationInfo.completeSpecialEffect();
                } else {
                    final Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(animationInfo);
                    } else {
                        final SpecialEffectsController.Operation operation = animationInfo.getOperation();
                        Fragment fragment = operation.getFragment();
                        if (k.a(map.get(operation), Boolean.TRUE)) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            animationInfo.completeSpecialEffect();
                        } else {
                            final boolean z8 = operation.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                            if (z8) {
                                list2.remove(operation);
                            }
                            final View view = fragment.mView;
                            getContainer().startViewTransition(view);
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.startAnimations.1
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator anim) {
                                    k.e(anim, "anim");
                                    DefaultSpecialEffectsController.this.getContainer().endViewTransition(view);
                                    if (z8) {
                                        SpecialEffectsController.Operation.State finalState = operation.getFinalState();
                                        View viewToAnimate = view;
                                        k.d(viewToAnimate, "viewToAnimate");
                                        finalState.applyState(viewToAnimate);
                                    }
                                    animationInfo.completeSpecialEffect();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v(FragmentManager.TAG, "Animator from operation " + operation + " has ended.");
                                    }
                                }
                            });
                            animator.setTarget(view);
                            animator.start();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animator from operation " + operation + " has started.");
                            }
                            animationInfo.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.a
                                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                                public final void onCancel() {
                                    DefaultSpecialEffectsController.startAnimations$lambda$3(animator, operation);
                                }
                            });
                            z7 = true;
                        }
                    }
                }
            }
        }
        int size = arrayList.size();
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            final AnimationInfo animationInfo2 = (AnimationInfo) obj;
            final SpecialEffectsController.Operation operation2 = animationInfo2.getOperation();
            Fragment fragment2 = operation2.getFragment();
            if (z2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo2.completeSpecialEffect();
            } else if (z7) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo2.completeSpecialEffect();
            } else {
                final View view2 = fragment2.mView;
                k.d(context, "context");
                FragmentAnim.AnimationOrAnimator animation2 = animationInfo2.getAnimation(context);
                if (animation2 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                Animation animation3 = animation2.animation;
                if (animation3 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                if (operation2.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation3);
                    animationInfo2.completeSpecialEffect();
                } else {
                    getContainer().startViewTransition(view2);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation3, getContainer(), view2);
                    endViewTransitionAnimation.setAnimationListener(new AnonymousClass3(operation2, this, view2, animationInfo2));
                    view2.startAnimation(endViewTransitionAnimation);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Animation from operation " + operation2 + " has started.");
                    }
                }
                animationInfo2.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.b
                    @Override // androidx.core.os.CancellationSignal.OnCancelListener
                    public final void onCancel() {
                        DefaultSpecialEffectsController.startAnimations$lambda$4(view2, this, animationInfo2, operation2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimations$lambda$3(Animator animator, SpecialEffectsController.Operation operation) {
        k.e(operation, "$operation");
        animator.end();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Animator from operation " + operation + " has been canceled.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimations$lambda$4(View view, DefaultSpecialEffectsController this$0, AnimationInfo animationInfo, SpecialEffectsController.Operation operation) {
        k.e(this$0, "this$0");
        k.e(animationInfo, "$animationInfo");
        k.e(operation, "$operation");
        view.clearAnimation();
        this$0.getContainer().endViewTransition(view);
        animationInfo.completeSpecialEffect();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Animation from operation " + operation + " has been cancelled.");
        }
    }

    private final Map<SpecialEffectsController.Operation, Boolean> startTransitions(List<TransitionInfo> list, List<SpecialEffectsController.Operation> list2, boolean z2, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
        String str;
        ArrayList<View> arrayList;
        String str2;
        ArrayMap arrayMap;
        Object obj;
        ArrayList<View> arrayList2;
        View view;
        LinkedHashMap linkedHashMap;
        ArrayList<View> arrayList3;
        View view2;
        Object obj2;
        Object obj3;
        SpecialEffectsController.Operation operation3;
        String str3;
        Rect rect;
        int i2;
        View view3;
        Rect rect2;
        View view4;
        DefaultSpecialEffectsController defaultSpecialEffectsController = this;
        boolean z7 = z2;
        SpecialEffectsController.Operation operation4 = operation;
        SpecialEffectsController.Operation operation5 = operation2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : list) {
            if (!((TransitionInfo) obj4).isVisibilityUnchanged()) {
                arrayList4.add(obj4);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        int size = arrayList4.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj5 = arrayList4.get(i8);
            i8++;
            if (((TransitionInfo) obj5).getHandlingImpl() != null) {
                arrayList5.add(obj5);
            }
        }
        int size2 = arrayList5.size();
        int i9 = 0;
        FragmentTransitionImpl fragmentTransitionImpl = null;
        while (i9 < size2) {
            Object obj6 = arrayList5.get(i9);
            i9++;
            TransitionInfo transitionInfo = (TransitionInfo) obj6;
            FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
            if (fragmentTransitionImpl != null && handlingImpl != fragmentTransitionImpl) {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition type than other Fragments.").toString());
            }
            fragmentTransitionImpl = handlingImpl;
        }
        if (fragmentTransitionImpl == null) {
            for (TransitionInfo transitionInfo2 : list) {
                linkedHashMap2.put(transitionInfo2.getOperation(), Boolean.FALSE);
                transitionInfo2.completeSpecialEffect();
            }
            return linkedHashMap2;
        }
        View view5 = new View(defaultSpecialEffectsController.getContainer().getContext());
        Rect rect3 = new Rect();
        ArrayList<View> arrayList6 = new ArrayList<>();
        ArrayList<View> arrayList7 = new ArrayList<>();
        ArrayMap arrayMap2 = new ArrayMap();
        Iterator<TransitionInfo> it = list.iterator();
        Object obj7 = null;
        View view6 = null;
        boolean z8 = false;
        while (true) {
            boolean zHasNext = it.hasNext();
            str = FragmentManager.TAG;
            if (!zHasNext) {
                break;
            }
            TransitionInfo next = it.next();
            if (!next.hasSharedElementTransition() || operation4 == null || operation5 == null) {
                z7 = z2;
                view5 = view5;
                arrayMap2 = arrayMap2;
                linkedHashMap2 = linkedHashMap2;
                arrayList7 = arrayList7;
                view6 = view6;
                arrayList6 = arrayList6;
                rect3 = rect3;
            } else {
                Object objWrapTransitionInSet = fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(next.getSharedElementTransition()));
                ArrayList<String> sharedElementSourceNames = operation5.getFragment().getSharedElementSourceNames();
                k.d(sharedElementSourceNames, "lastIn.fragment.sharedElementSourceNames");
                ArrayList<String> sharedElementSourceNames2 = operation4.getFragment().getSharedElementSourceNames();
                k.d(sharedElementSourceNames2, "firstOut.fragment.sharedElementSourceNames");
                ArrayList<String> sharedElementTargetNames = operation4.getFragment().getSharedElementTargetNames();
                View view7 = view6;
                k.d(sharedElementTargetNames, "firstOut.fragment.sharedElementTargetNames");
                int size3 = sharedElementTargetNames.size();
                LinkedHashMap linkedHashMap3 = linkedHashMap2;
                View view8 = view5;
                int i10 = 0;
                while (i10 < size3) {
                    int i11 = size3;
                    int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i10));
                    if (iIndexOf != -1) {
                        sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i10));
                    }
                    i10++;
                    size3 = i11;
                }
                ArrayList<String> sharedElementTargetNames2 = operation5.getFragment().getSharedElementTargetNames();
                k.d(sharedElementTargetNames2, "lastIn.fragment.sharedElementTargetNames");
                q5.i iVar = !z7 ? new q5.i(operation4.getFragment().getExitTransitionCallback(), operation5.getFragment().getEnterTransitionCallback()) : new q5.i(operation4.getFragment().getEnterTransitionCallback(), operation5.getFragment().getExitTransitionCallback());
                SharedElementCallback sharedElementCallback = (SharedElementCallback) iVar.f13498a;
                SharedElementCallback sharedElementCallback2 = (SharedElementCallback) iVar.f13499b;
                int i12 = 0;
                for (int size4 = sharedElementSourceNames.size(); i12 < size4; size4 = size4) {
                    arrayMap2.put(sharedElementSourceNames.get(i12), sharedElementTargetNames2.get(i12));
                    i12++;
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, ">>> entering view names <<<");
                    rect = rect3;
                    int i13 = 0;
                    for (int size5 = sharedElementTargetNames2.size(); i13 < size5; size5 = size5) {
                        String str4 = sharedElementTargetNames2.get(i13);
                        Log.v(FragmentManager.TAG, "Name: " + str4);
                        i13++;
                    }
                    Log.v(FragmentManager.TAG, ">>> exiting view names <<<");
                    int i14 = 0;
                    for (int size6 = sharedElementSourceNames.size(); i14 < size6; size6 = size6) {
                        String str5 = sharedElementSourceNames.get(i14);
                        Log.v(FragmentManager.TAG, "Name: " + str5);
                        i14++;
                    }
                } else {
                    rect = rect3;
                }
                ArrayMap<String, View> arrayMap3 = new ArrayMap<>();
                View view9 = operation4.getFragment().mView;
                k.d(view9, "firstOut.fragment.mView");
                defaultSpecialEffectsController.findNamedViews(arrayMap3, view9);
                arrayMap3.retainAll(sharedElementSourceNames);
                if (sharedElementCallback != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Executing exit callback for operation " + operation4);
                    }
                    sharedElementCallback.onMapSharedElements(sharedElementSourceNames, arrayMap3);
                    int size7 = sharedElementSourceNames.size() - 1;
                    if (size7 >= 0) {
                        while (true) {
                            int i15 = size7 - 1;
                            String str6 = sharedElementSourceNames.get(size7);
                            View view10 = arrayMap3.get(str6);
                            if (view10 == null) {
                                arrayMap2.remove(str6);
                            } else if (!k.a(str6, ViewCompat.getTransitionName(view10))) {
                                arrayMap2.put(ViewCompat.getTransitionName(view10), (String) arrayMap2.remove(str6));
                            }
                            if (i15 < 0) {
                                break;
                            }
                            size7 = i15;
                        }
                    }
                } else {
                    arrayMap2.retainAll(arrayMap3.keySet());
                }
                ArrayMap<String, View> arrayMap4 = new ArrayMap<>();
                View view11 = operation5.getFragment().mView;
                k.d(view11, "lastIn.fragment.mView");
                defaultSpecialEffectsController.findNamedViews(arrayMap4, view11);
                arrayMap4.retainAll(sharedElementTargetNames2);
                arrayMap4.retainAll(arrayMap2.values());
                if (sharedElementCallback2 != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Executing enter callback for operation " + operation5);
                    }
                    sharedElementCallback2.onMapSharedElements(sharedElementTargetNames2, arrayMap4);
                    int size8 = sharedElementTargetNames2.size() - 1;
                    if (size8 >= 0) {
                        while (true) {
                            int i16 = size8 - 1;
                            String name = sharedElementTargetNames2.get(size8);
                            View view12 = arrayMap4.get(name);
                            if (view12 == null) {
                                k.d(name, "name");
                                String strFindKeyForValue = FragmentTransition.findKeyForValue(arrayMap2, name);
                                if (strFindKeyForValue != null) {
                                    arrayMap2.remove(strFindKeyForValue);
                                }
                            } else if (!k.a(name, ViewCompat.getTransitionName(view12))) {
                                k.d(name, "name");
                                String strFindKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap2, name);
                                if (strFindKeyForValue2 != null) {
                                    arrayMap2.put(strFindKeyForValue2, ViewCompat.getTransitionName(view12));
                                }
                            }
                            if (i16 < 0) {
                                break;
                            }
                            size8 = i16;
                        }
                    }
                } else {
                    FragmentTransition.retainValues(arrayMap2, arrayMap4);
                }
                Collection<String> collectionKeySet = arrayMap2.keySet();
                k.d(collectionKeySet, "sharedElementNameMapping.keys");
                defaultSpecialEffectsController.retainMatchingViews(arrayMap3, collectionKeySet);
                Collection<String> collectionValues = arrayMap2.values();
                k.d(collectionValues, "sharedElementNameMapping.values");
                defaultSpecialEffectsController.retainMatchingViews(arrayMap4, collectionValues);
                if (arrayMap2.isEmpty()) {
                    arrayList6.clear();
                    arrayList7.clear();
                    operation4 = operation;
                    view6 = view7;
                    linkedHashMap2 = linkedHashMap3;
                    view5 = view8;
                    rect3 = rect;
                    obj7 = null;
                } else {
                    FragmentTransition.callSharedElementStartEnd(operation5.getFragment(), operation.getFragment(), z7, arrayMap3, true);
                    operation4 = operation;
                    OneShotPreDrawListener.add(defaultSpecialEffectsController.getContainer(), new androidx.camera.core.impl.utils.futures.d(operation5, operation4, z7, arrayMap4, 2));
                    arrayList6.addAll(arrayMap3.values());
                    if (sharedElementSourceNames.isEmpty()) {
                        i2 = 0;
                        view3 = view7;
                    } else {
                        i2 = 0;
                        view3 = arrayMap3.get(sharedElementSourceNames.get(0));
                        fragmentTransitionImpl.setEpicenter(objWrapTransitionInSet, view3);
                    }
                    arrayList7.addAll(arrayMap4.values());
                    if (sharedElementTargetNames2.isEmpty() || (view4 = arrayMap4.get(sharedElementTargetNames2.get(i2))) == null) {
                        rect2 = rect;
                    } else {
                        rect2 = rect;
                        OneShotPreDrawListener.add(defaultSpecialEffectsController.getContainer(), new c(fragmentTransitionImpl, view4, rect2, 2));
                        z8 = true;
                    }
                    fragmentTransitionImpl.setSharedElementTargets(objWrapTransitionInSet, view8, arrayList6);
                    ArrayList<View> arrayList8 = arrayList7;
                    fragmentTransitionImpl.scheduleRemoveTargets(objWrapTransitionInSet, null, null, null, null, objWrapTransitionInSet, arrayList8);
                    Boolean bool = Boolean.TRUE;
                    linkedHashMap3.put(operation4, bool);
                    linkedHashMap3.put(operation5, bool);
                    arrayMap2 = arrayMap2;
                    obj7 = objWrapTransitionInSet;
                    linkedHashMap2 = linkedHashMap3;
                    arrayList7 = arrayList8;
                    view5 = view8;
                    arrayList6 = arrayList6;
                    rect3 = rect2;
                    view6 = view3;
                    z7 = z2;
                }
            }
        }
        View view13 = view6;
        View view14 = view5;
        Rect rect4 = rect3;
        ArrayList<View> arrayList9 = arrayList6;
        ArrayList<View> arrayList10 = arrayList7;
        LinkedHashMap linkedHashMap4 = linkedHashMap2;
        ArrayMap arrayMap5 = arrayMap2;
        ArrayList arrayList11 = new ArrayList();
        Object objMergeTransitionsTogether = null;
        Object objMergeTransitionsTogether2 = null;
        for (TransitionInfo transitionInfo3 : list) {
            if (transitionInfo3.isVisibilityUnchanged()) {
                arrayMap = arrayMap5;
                linkedHashMap4.put(transitionInfo3.getOperation(), Boolean.FALSE);
                transitionInfo3.completeSpecialEffect();
            } else {
                arrayMap = arrayMap5;
                Object objCloneTransition = fragmentTransitionImpl.cloneTransition(transitionInfo3.getTransition());
                SpecialEffectsController.Operation operation6 = transitionInfo3.getOperation();
                boolean z9 = obj7 != null && (operation6 == operation4 || operation6 == operation5);
                if (objCloneTransition != null) {
                    ArrayList<View> arrayList12 = arrayList10;
                    ArrayList<View> arrayList13 = new ArrayList<>();
                    Object obj8 = objMergeTransitionsTogether;
                    View view15 = operation6.getFragment().mView;
                    LinkedHashMap linkedHashMap5 = linkedHashMap4;
                    k.d(view15, "operation.fragment.mView");
                    defaultSpecialEffectsController.captureTransitioningViews(arrayList13, view15);
                    if (z9) {
                        if (operation6 == operation4) {
                            arrayList13.removeAll(r5.l.r1(arrayList9));
                        } else {
                            arrayList13.removeAll(r5.l.r1(arrayList12));
                        }
                    }
                    if (arrayList13.isEmpty()) {
                        fragmentTransitionImpl.addTarget(objCloneTransition, view14);
                        obj2 = objCloneTransition;
                        str3 = str;
                        obj3 = objMergeTransitionsTogether2;
                        operation3 = operation6;
                        arrayList2 = arrayList12;
                        obj = obj8;
                        view = view14;
                        linkedHashMap = linkedHashMap5;
                        arrayList3 = arrayList9;
                        view2 = view13;
                    } else {
                        fragmentTransitionImpl.addTargets(objCloneTransition, arrayList13);
                        obj = obj8;
                        arrayList2 = arrayList12;
                        view = view14;
                        linkedHashMap = linkedHashMap5;
                        arrayList3 = arrayList9;
                        view2 = view13;
                        obj2 = objCloneTransition;
                        obj3 = objMergeTransitionsTogether2;
                        fragmentTransitionImpl.scheduleRemoveTargets(obj2, objCloneTransition, arrayList13, null, null, null, null);
                        if (operation6.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation3 = operation6;
                            list2.remove(operation3);
                            ArrayList<View> arrayList14 = new ArrayList<>(arrayList13);
                            arrayList14.remove(operation3.getFragment().mView);
                            fragmentTransitionImpl.scheduleHideFragmentView(obj2, operation3.getFragment().mView, arrayList14);
                            str3 = str;
                            OneShotPreDrawListener.add(getContainer(), new a3.b(arrayList13, 11));
                        } else {
                            operation3 = operation6;
                            str3 = str;
                        }
                    }
                    if (operation3.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList11.addAll(arrayList13);
                        if (z8) {
                            fragmentTransitionImpl.setEpicenter(obj2, rect4);
                        }
                    } else {
                        fragmentTransitionImpl.setEpicenter(obj2, view2);
                    }
                    linkedHashMap.put(operation3, Boolean.TRUE);
                    if (transitionInfo3.isOverlapAllowed()) {
                        objMergeTransitionsTogether = fragmentTransitionImpl.mergeTransitionsTogether(obj, obj2, null);
                        objMergeTransitionsTogether2 = obj3;
                        linkedHashMap4 = linkedHashMap;
                        view13 = view2;
                        str = str3;
                        arrayMap5 = arrayMap;
                        view14 = view;
                        arrayList9 = arrayList3;
                        arrayList10 = arrayList2;
                        defaultSpecialEffectsController = this;
                    } else {
                        objMergeTransitionsTogether2 = fragmentTransitionImpl.mergeTransitionsTogether(obj3, obj2, null);
                        defaultSpecialEffectsController = this;
                        linkedHashMap4 = linkedHashMap;
                        view13 = view2;
                        objMergeTransitionsTogether = obj;
                        str = str3;
                        arrayMap5 = arrayMap;
                        view14 = view;
                        arrayList9 = arrayList3;
                        arrayList10 = arrayList2;
                    }
                } else if (!z9) {
                    linkedHashMap4.put(operation6, Boolean.FALSE);
                    transitionInfo3.completeSpecialEffect();
                }
            }
            arrayMap5 = arrayMap;
        }
        ArrayList<View> arrayList15 = arrayList9;
        ArrayMap arrayMap6 = arrayMap5;
        String str7 = str;
        LinkedHashMap linkedHashMap6 = linkedHashMap4;
        ArrayList<View> arrayList16 = arrayList10;
        Object objMergeTransitionsInSequence = fragmentTransitionImpl.mergeTransitionsInSequence(objMergeTransitionsTogether, objMergeTransitionsTogether2, obj7);
        if (objMergeTransitionsInSequence == null) {
            return linkedHashMap6;
        }
        ArrayList arrayList17 = new ArrayList();
        for (Object obj9 : list) {
            if (!((TransitionInfo) obj9).isVisibilityUnchanged()) {
                arrayList17.add(obj9);
            }
        }
        int size9 = arrayList17.size();
        int i17 = 0;
        while (i17 < size9) {
            Object obj10 = arrayList17.get(i17);
            i17++;
            TransitionInfo transitionInfo4 = (TransitionInfo) obj10;
            Object transition = transitionInfo4.getTransition();
            SpecialEffectsController.Operation operation7 = transitionInfo4.getOperation();
            boolean z10 = obj7 != null && (operation7 == operation4 || operation7 == operation5);
            if (transition == null && !z10) {
                str2 = str7;
            } else if (ViewCompat.isLaidOut(getContainer())) {
                str2 = str7;
                fragmentTransitionImpl.setListenerForTransitionEnd(transitionInfo4.getOperation().getFragment(), objMergeTransitionsInSequence, transitionInfo4.getSignal(), new i(transitionInfo4, operation7, 2));
            } else {
                if (FragmentManager.isLoggingEnabled(2)) {
                    str2 = str7;
                    Log.v(str2, "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + operation7);
                } else {
                    str2 = str7;
                }
                transitionInfo4.completeSpecialEffect();
            }
            operation5 = operation2;
            str7 = str2;
        }
        String str8 = str7;
        if (!ViewCompat.isLaidOut(getContainer())) {
            return linkedHashMap6;
        }
        FragmentTransition.setViewVisibility(arrayList11, 4);
        ArrayList<String> arrayListPrepareSetNameOverridesReordered = fragmentTransitionImpl.prepareSetNameOverridesReordered(arrayList16);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(str8, ">>>>> Beginning transition <<<<<");
            Log.v(str8, ">>>>> SharedElementFirstOutViews <<<<<");
            int size10 = arrayList15.size();
            int i18 = 0;
            while (i18 < size10) {
                View sharedElementFirstOutViews = arrayList15.get(i18);
                i18++;
                k.d(sharedElementFirstOutViews, "sharedElementFirstOutViews");
                View view16 = sharedElementFirstOutViews;
                Log.v(str8, "View: " + view16 + " Name: " + ViewCompat.getTransitionName(view16));
            }
            arrayList = arrayList15;
            Log.v(str8, ">>>>> SharedElementLastInViews <<<<<");
            int size11 = arrayList16.size();
            int i19 = 0;
            while (i19 < size11) {
                View sharedElementLastInViews = arrayList16.get(i19);
                i19++;
                k.d(sharedElementLastInViews, "sharedElementLastInViews");
                View view17 = sharedElementLastInViews;
                Log.v(str8, "View: " + view17 + " Name: " + ViewCompat.getTransitionName(view17));
            }
        } else {
            arrayList = arrayList15;
        }
        fragmentTransitionImpl.beginDelayedTransition(getContainer(), objMergeTransitionsInSequence);
        fragmentTransitionImpl.setNameOverridesReordered(getContainer(), arrayList, arrayList16, arrayListPrepareSetNameOverridesReordered, arrayMap6);
        FragmentTransition.setViewVisibility(arrayList11, 0);
        fragmentTransitionImpl.swapSharedElementTargets(obj7, arrayList, arrayList16);
        return linkedHashMap6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTransitions$lambda$10(FragmentTransitionImpl impl, View view, Rect lastInEpicenterRect) {
        k.e(impl, "$impl");
        k.e(lastInEpicenterRect, "$lastInEpicenterRect");
        impl.getBoundsOnScreen(view, lastInEpicenterRect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTransitions$lambda$11(ArrayList transitioningViews) {
        k.e(transitioningViews, "$transitioningViews");
        FragmentTransition.setViewVisibility(transitioningViews, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTransitions$lambda$14$lambda$13(TransitionInfo transitionInfo, SpecialEffectsController.Operation operation) {
        k.e(transitionInfo, "$transitionInfo");
        k.e(operation, "$operation");
        transitionInfo.completeSpecialEffect();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Transition for operation " + operation + " has completed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTransitions$lambda$9(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z2, ArrayMap lastInViews) {
        k.e(lastInViews, "$lastInViews");
        FragmentTransition.callSharedElementStartEnd(operation.getFragment(), operation2.getFragment(), z2, lastInViews, false);
    }

    private final void syncAnimations(List<? extends SpecialEffectsController.Operation> list) {
        Fragment fragment = ((SpecialEffectsController.Operation) r5.l.d1(list)).getFragment();
        for (SpecialEffectsController.Operation operation : list) {
            operation.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            operation.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            operation.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            operation.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00cc  */
    @Override // androidx.fragment.app.SpecialEffectsController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeOperations(java.util.List<? extends androidx.fragment.app.SpecialEffectsController.Operation> r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.executeOperations(java.util.List, boolean):void");
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class TransitionInfo extends SpecialEffectsInfo {
        private final boolean isOverlapAllowed;
        private final Object sharedElementTransition;
        private final Object transition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransitionInfo(SpecialEffectsController.Operation operation, CancellationSignal signal, boolean z2, boolean z7) {
            Object returnTransition;
            super(operation, signal);
            k.e(operation, "operation");
            k.e(signal, "signal");
            SpecialEffectsController.Operation.State finalState = operation.getFinalState();
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            if (finalState == state) {
                Fragment fragment = operation.getFragment();
                returnTransition = z2 ? fragment.getReenterTransition() : fragment.getEnterTransition();
            } else {
                Fragment fragment2 = operation.getFragment();
                returnTransition = z2 ? fragment2.getReturnTransition() : fragment2.getExitTransition();
            }
            this.transition = returnTransition;
            this.isOverlapAllowed = operation.getFinalState() == state ? z2 ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap() : true;
            this.sharedElementTransition = z7 ? z2 ? operation.getFragment().getSharedElementReturnTransition() : operation.getFragment().getSharedElementEnterTransition() : null;
        }

        public final FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.transition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.sharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl == null ? handlingImpl2 : handlingImpl;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.transition + " which uses a different Transition  type than its shared element transition " + this.sharedElementTransition).toString());
        }

        public final Object getSharedElementTransition() {
            return this.sharedElementTransition;
        }

        public final Object getTransition() {
            return this.transition;
        }

        public final boolean hasSharedElementTransition() {
            return this.sharedElementTransition != null;
        }

        public final boolean isOverlapAllowed() {
            return this.isOverlapAllowed;
        }

        private final FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
