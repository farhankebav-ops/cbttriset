package androidx.activity;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 implements e6.a {
        final /* synthetic */ ComponentActivity $this_viewModels;

        public AnonymousClass1(ComponentActivity componentActivity) {
            this.$this_viewModels = componentActivity;
        }

        @Override // e6.a
        public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 implements e6.a {
        final /* synthetic */ ComponentActivity $this_viewModels;

        public AnonymousClass2(ComponentActivity componentActivity) {
            this.$this_viewModels = componentActivity;
        }

        @Override // e6.a
        public final CreationExtras invoke() {
            return this.$this_viewModels.getDefaultViewModelCreationExtras();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass3 implements e6.a {
        final /* synthetic */ ComponentActivity $this_viewModels;

        public AnonymousClass3(ComponentActivity componentActivity) {
            this.$this_viewModels = componentActivity;
        }

        @Override // e6.a
        public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
        }
    }

    /* JADX INFO: renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass4 implements e6.a {
        final /* synthetic */ e6.a $extrasProducer;
        final /* synthetic */ ComponentActivity $this_viewModels;

        public AnonymousClass4(e6.a aVar, ComponentActivity componentActivity) {
            this.$extrasProducer = aVar;
            this.$this_viewModels = componentActivity;
        }

        @Override // e6.a
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            e6.a aVar = this.$extrasProducer;
            return (aVar == null || (creationExtras = (CreationExtras) aVar.invoke()) == null) ? this.$this_viewModels.getDefaultViewModelCreationExtras() : creationExtras;
        }
    }

    @MainThread
    public static final <VM extends ViewModel> q5.f viewModels(ComponentActivity componentActivity, e6.a aVar) {
        kotlin.jvm.internal.k.e(componentActivity, "<this>");
        if (aVar == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        kotlin.jvm.internal.k.k();
        throw null;
    }

    public static q5.f viewModels$default(ComponentActivity componentActivity, e6.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = null;
        }
        kotlin.jvm.internal.k.e(componentActivity, "<this>");
        if (aVar == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$1(componentActivity);
        }
        kotlin.jvm.internal.k.k();
        throw null;
    }

    @MainThread
    public static final <VM extends ViewModel> q5.f viewModels(ComponentActivity componentActivity, e6.a aVar, e6.a aVar2) {
        kotlin.jvm.internal.k.e(componentActivity, "<this>");
        if (aVar2 == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        kotlin.jvm.internal.k.k();
        throw null;
    }

    public static q5.f viewModels$default(ComponentActivity componentActivity, e6.a aVar, e6.a aVar2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            aVar2 = null;
        }
        kotlin.jvm.internal.k.e(componentActivity, "<this>");
        if (aVar2 == null) {
            new ActivityViewModelLazyKt$viewModels$factoryPromise$2(componentActivity);
        }
        kotlin.jvm.internal.k.k();
        throw null;
    }
}
