package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Iterator;
import java.util.ListIterator;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    private boolean backInvokedCallbackRegistered;
    private final Runnable fallbackOnBackPressed;
    private boolean hasEnabledCallbacks;
    private OnBackPressedCallback inProgressCallback;
    private OnBackInvokedDispatcher invokedDispatcher;
    private OnBackInvokedCallback onBackInvokedCallback;
    private final r5.i onBackPressedCallbacks;
    private final Consumer<Boolean> onHasEnabledCallbacksChanged;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(33)
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        public final OnBackInvokedCallback createOnBackInvokedCallback(final e6.a onBackInvoked) {
            kotlin.jvm.internal.k.e(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.p
                public final void onBackInvoked() {
                    onBackInvoked.invoke();
                }
            };
        }

        public final void registerOnBackInvokedCallback(Object dispatcher, int i2, Object callback) {
            kotlin.jvm.internal.k.e(dispatcher, "dispatcher");
            kotlin.jvm.internal.k.e(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i2, (OnBackInvokedCallback) callback);
        }

        public final void unregisterOnBackInvokedCallback(Object dispatcher, Object callback) {
            kotlin.jvm.internal.k.e(dispatcher, "dispatcher");
            kotlin.jvm.internal.k.e(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(34)
    public static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        public final OnBackInvokedCallback createOnBackAnimationCallback(final e6.l onBackStarted, final e6.l onBackProgressed, final e6.a onBackInvoked, final e6.a onBackCancelled) {
            kotlin.jvm.internal.k.e(onBackStarted, "onBackStarted");
            kotlin.jvm.internal.k.e(onBackProgressed, "onBackProgressed");
            kotlin.jvm.internal.k.e(onBackInvoked, "onBackInvoked");
            kotlin.jvm.internal.k.e(onBackCancelled, "onBackCancelled");
            return new OnBackAnimationCallback() { // from class: androidx.activity.OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1
                public void onBackCancelled() {
                    onBackCancelled.invoke();
                }

                public void onBackInvoked() {
                    onBackInvoked.invoke();
                }

                public void onBackProgressed(BackEvent backEvent) {
                    kotlin.jvm.internal.k.e(backEvent, "backEvent");
                    onBackProgressed.invoke(new BackEventCompat(backEvent));
                }

                public void onBackStarted(BackEvent backEvent) {
                    kotlin.jvm.internal.k.e(backEvent, "backEvent");
                    onBackStarted.invoke(new BackEventCompat(backEvent));
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        private Cancellable currentCancellable;
        private final Lifecycle lifecycle;
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
            kotlin.jvm.internal.k.e(lifecycle, "lifecycle");
            kotlin.jvm.internal.k.e(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.lifecycle = lifecycle;
            this.onBackPressedCallback = onBackPressedCallback;
            lifecycle.addObserver(this);
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.lifecycle.removeObserver(this);
            this.onBackPressedCallback.removeCancellable(this);
            Cancellable cancellable = this.currentCancellable;
            if (cancellable != null) {
                cancellable.cancel();
            }
            this.currentCancellable = null;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            kotlin.jvm.internal.k.e(source, "source");
            kotlin.jvm.internal.k.e(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.currentCancellable = this.this$0.addCancellableCallback$activity_release(this.onBackPressedCallback);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                Cancellable cancellable = this.currentCancellable;
                if (cancellable != null) {
                    cancellable.cancel();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public OnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback) {
            kotlin.jvm.internal.k.e(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.onBackPressedCallback = onBackPressedCallback;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.this$0.onBackPressedCallbacks.remove(this.onBackPressedCallback);
            if (kotlin.jvm.internal.k.a(this.this$0.inProgressCallback, this.onBackPressedCallback)) {
                this.onBackPressedCallback.handleOnBackCancelled();
                this.this$0.inProgressCallback = null;
            }
            this.onBackPressedCallback.removeCancellable(this);
            e6.a enabledChangedCallback$activity_release = this.onBackPressedCallback.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.onBackPressedCallback.setEnabledChangedCallback$activity_release(null);
        }
    }

    /* JADX INFO: renamed from: androidx.activity.OnBackPressedDispatcher$addCallback$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class AnonymousClass1 extends kotlin.jvm.internal.j implements e6.a {
        public AnonymousClass1(Object obj) {
            super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m0invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m0invoke() {
            ((OnBackPressedDispatcher) this.receiver).updateEnabledCallbacks();
        }
    }

    public OnBackPressedDispatcher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x _init_$lambda$1(OnBackPressedDispatcher onBackPressedDispatcher, BackEventCompat backEvent) {
        kotlin.jvm.internal.k.e(backEvent, "backEvent");
        onBackPressedDispatcher.onBackStarted(backEvent);
        return x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x _init_$lambda$2(OnBackPressedDispatcher onBackPressedDispatcher, BackEventCompat backEvent) {
        kotlin.jvm.internal.k.e(backEvent, "backEvent");
        onBackPressedDispatcher.onBackProgressed(backEvent);
        return x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x _init_$lambda$3(OnBackPressedDispatcher onBackPressedDispatcher) {
        onBackPressedDispatcher.onBackPressed();
        return x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x _init_$lambda$4(OnBackPressedDispatcher onBackPressedDispatcher) {
        onBackPressedDispatcher.onBackCancelled();
        return x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x _init_$lambda$5(OnBackPressedDispatcher onBackPressedDispatcher) {
        onBackPressedDispatcher.onBackPressed();
        return x.f13520a;
    }

    @MainThread
    private final void onBackCancelled() {
        Object objPrevious;
        OnBackPressedCallback onBackPressedCallback = this.inProgressCallback;
        if (onBackPressedCallback == null) {
            r5.i iVar = this.onBackPressedCallbacks;
            ListIterator<E> listIterator = iVar.listIterator(iVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((OnBackPressedCallback) objPrevious).isEnabled()) {
                        break;
                    }
                }
            }
            onBackPressedCallback = (OnBackPressedCallback) objPrevious;
        }
        this.inProgressCallback = null;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackCancelled();
        }
    }

    @MainThread
    private final void onBackProgressed(BackEventCompat backEventCompat) {
        Object objPrevious;
        OnBackPressedCallback onBackPressedCallback = this.inProgressCallback;
        if (onBackPressedCallback == null) {
            r5.i iVar = this.onBackPressedCallbacks;
            ListIterator<E> listIterator = iVar.listIterator(iVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((OnBackPressedCallback) objPrevious).isEnabled()) {
                        break;
                    }
                }
            }
            onBackPressedCallback = (OnBackPressedCallback) objPrevious;
        }
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackProgressed(backEventCompat);
        }
    }

    @MainThread
    private final void onBackStarted(BackEventCompat backEventCompat) {
        Object objPrevious;
        r5.i iVar = this.onBackPressedCallbacks;
        ListIterator<E> listIterator = iVar.listIterator(iVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((OnBackPressedCallback) objPrevious).isEnabled()) {
                    break;
                }
            }
        }
        OnBackPressedCallback onBackPressedCallback = (OnBackPressedCallback) objPrevious;
        if (this.inProgressCallback != null) {
            onBackCancelled();
        }
        this.inProgressCallback = onBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackStarted(backEventCompat);
        }
    }

    @RequiresApi(33)
    private final void updateBackInvokedCallbackState(boolean z2) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.invokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback = this.onBackInvokedCallback;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z2 && !this.backInvokedCallbackRegistered) {
            Api33Impl.INSTANCE.registerOnBackInvokedCallback(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.backInvokedCallbackRegistered = true;
        } else {
            if (z2 || !this.backInvokedCallbackRegistered) {
                return;
            }
            Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback);
            this.backInvokedCallbackRegistered = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEnabledCallbacks() {
        boolean z2 = this.hasEnabledCallbacks;
        r5.i iVar = this.onBackPressedCallbacks;
        boolean z7 = false;
        if (iVar == null || !iVar.isEmpty()) {
            Iterator it = iVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((OnBackPressedCallback) it.next()).isEnabled()) {
                    z7 = true;
                    break;
                }
            }
        }
        this.hasEnabledCallbacks = z7;
        if (z7 != z2) {
            Consumer<Boolean> consumer = this.onHasEnabledCallbacksChanged;
            if (consumer != null) {
                consumer.accept(Boolean.valueOf(z7));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                updateBackInvokedCallbackState(z7);
            }
        }
    }

    @MainThread
    public final void addCallback(OnBackPressedCallback onBackPressedCallback) {
        kotlin.jvm.internal.k.e(onBackPressedCallback, "onBackPressedCallback");
        addCancellableCallback$activity_release(onBackPressedCallback);
    }

    @MainThread
    public final Cancellable addCancellableCallback$activity_release(OnBackPressedCallback onBackPressedCallback) {
        kotlin.jvm.internal.k.e(onBackPressedCallback, "onBackPressedCallback");
        this.onBackPressedCallbacks.addLast(onBackPressedCallback);
        OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(onBackPressedCancellable);
        updateEnabledCallbacks();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return onBackPressedCancellable;
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackCancelled() {
        onBackCancelled();
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackProgressed(BackEventCompat backEvent) {
        kotlin.jvm.internal.k.e(backEvent, "backEvent");
        onBackProgressed(backEvent);
    }

    @MainThread
    @VisibleForTesting
    public final void dispatchOnBackStarted(BackEventCompat backEvent) {
        kotlin.jvm.internal.k.e(backEvent, "backEvent");
        onBackStarted(backEvent);
    }

    @MainThread
    public final boolean hasEnabledCallbacks() {
        return this.hasEnabledCallbacks;
    }

    @MainThread
    public final void onBackPressed() {
        Object objPrevious;
        OnBackPressedCallback onBackPressedCallback = this.inProgressCallback;
        if (onBackPressedCallback == null) {
            r5.i iVar = this.onBackPressedCallbacks;
            ListIterator<E> listIterator = iVar.listIterator(iVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((OnBackPressedCallback) objPrevious).isEnabled()) {
                        break;
                    }
                }
            }
            onBackPressedCallback = (OnBackPressedCallback) objPrevious;
        }
        this.inProgressCallback = null;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.fallbackOnBackPressed;
        if (runnable != null) {
            runnable.run();
        }
    }

    @RequiresApi(33)
    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher invoker) {
        kotlin.jvm.internal.k.e(invoker, "invoker");
        this.invokedDispatcher = invoker;
        updateBackInvokedCallbackState(this.hasEnabledCallbacks);
    }

    public OnBackPressedDispatcher(Runnable runnable, Consumer<Boolean> consumer) {
        OnBackInvokedCallback onBackInvokedCallbackCreateOnBackInvokedCallback;
        this.fallbackOnBackPressed = runnable;
        this.onHasEnabledCallbacksChanged = consumer;
        this.onBackPressedCallbacks = new r5.i();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            if (i2 >= 34) {
                final int i8 = 0;
                final int i9 = 1;
                final int i10 = 0;
                final int i11 = 1;
                onBackInvokedCallbackCreateOnBackInvokedCallback = Api34Impl.INSTANCE.createOnBackAnimationCallback(new e6.l(this) { // from class: androidx.activity.n

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ OnBackPressedDispatcher f3315b;

                    {
                        this.f3315b = this;
                    }

                    @Override // e6.l
                    public final Object invoke(Object obj) {
                        switch (i8) {
                            case 0:
                                return OnBackPressedDispatcher._init_$lambda$1(this.f3315b, (BackEventCompat) obj);
                            default:
                                return OnBackPressedDispatcher._init_$lambda$2(this.f3315b, (BackEventCompat) obj);
                        }
                    }
                }, new e6.l(this) { // from class: androidx.activity.n

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ OnBackPressedDispatcher f3315b;

                    {
                        this.f3315b = this;
                    }

                    @Override // e6.l
                    public final Object invoke(Object obj) {
                        switch (i9) {
                            case 0:
                                return OnBackPressedDispatcher._init_$lambda$1(this.f3315b, (BackEventCompat) obj);
                            default:
                                return OnBackPressedDispatcher._init_$lambda$2(this.f3315b, (BackEventCompat) obj);
                        }
                    }
                }, new e6.a(this) { // from class: androidx.activity.o

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ OnBackPressedDispatcher f3317b;

                    {
                        this.f3317b = this;
                    }

                    @Override // e6.a
                    public final Object invoke() {
                        switch (i10) {
                            case 0:
                                return OnBackPressedDispatcher._init_$lambda$3(this.f3317b);
                            case 1:
                                return OnBackPressedDispatcher._init_$lambda$4(this.f3317b);
                            default:
                                return OnBackPressedDispatcher._init_$lambda$5(this.f3317b);
                        }
                    }
                }, new e6.a(this) { // from class: androidx.activity.o

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ OnBackPressedDispatcher f3317b;

                    {
                        this.f3317b = this;
                    }

                    @Override // e6.a
                    public final Object invoke() {
                        switch (i11) {
                            case 0:
                                return OnBackPressedDispatcher._init_$lambda$3(this.f3317b);
                            case 1:
                                return OnBackPressedDispatcher._init_$lambda$4(this.f3317b);
                            default:
                                return OnBackPressedDispatcher._init_$lambda$5(this.f3317b);
                        }
                    }
                });
            } else {
                final int i12 = 2;
                onBackInvokedCallbackCreateOnBackInvokedCallback = Api33Impl.INSTANCE.createOnBackInvokedCallback(new e6.a(this) { // from class: androidx.activity.o

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ OnBackPressedDispatcher f3317b;

                    {
                        this.f3317b = this;
                    }

                    @Override // e6.a
                    public final Object invoke() {
                        switch (i12) {
                            case 0:
                                return OnBackPressedDispatcher._init_$lambda$3(this.f3317b);
                            case 1:
                                return OnBackPressedDispatcher._init_$lambda$4(this.f3317b);
                            default:
                                return OnBackPressedDispatcher._init_$lambda$5(this.f3317b);
                        }
                    }
                });
            }
            this.onBackInvokedCallback = onBackInvokedCallbackCreateOnBackInvokedCallback;
        }
    }

    @MainThread
    public final void addCallback(LifecycleOwner owner, OnBackPressedCallback onBackPressedCallback) {
        kotlin.jvm.internal.k.e(owner, "owner");
        kotlin.jvm.internal.k.e(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
        updateEnabledCallbacks();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new AnonymousClass1(this));
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? null : runnable);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, null);
    }
}
