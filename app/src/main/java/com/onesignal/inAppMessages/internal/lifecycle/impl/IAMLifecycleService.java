package com.onesignal.inAppMessages.internal.lifecycle.impl;

import com.onesignal.common.events.EventProducer;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageClickResult;
import com.onesignal.inAppMessages.internal.InAppMessagePage;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class IAMLifecycleService extends EventProducer<IInAppLifecycleEventHandler> implements IInAppLifecycleService {

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.lifecycle.impl.IAMLifecycleService$messageActionOccurredOnMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        final /* synthetic */ InAppMessageClickResult $action;
        final /* synthetic */ InAppMessage $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InAppMessage inAppMessage, InAppMessageClickResult inAppMessageClickResult) {
            super(1);
            this.$message = inAppMessage;
            this.$action = inAppMessageClickResult;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IInAppLifecycleEventHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IInAppLifecycleEventHandler it) {
            k.e(it, "it");
            it.onMessageActionOccurredOnMessage(this.$message, this.$action);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.lifecycle.impl.IAMLifecycleService$messageActionOccurredOnPreview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C27461 extends l implements e6.l {
        final /* synthetic */ InAppMessageClickResult $action;
        final /* synthetic */ InAppMessage $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27461(InAppMessage inAppMessage, InAppMessageClickResult inAppMessageClickResult) {
            super(1);
            this.$message = inAppMessage;
            this.$action = inAppMessageClickResult;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IInAppLifecycleEventHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IInAppLifecycleEventHandler it) {
            k.e(it, "it");
            it.onMessageActionOccurredOnPreview(this.$message, this.$action);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.lifecycle.impl.IAMLifecycleService$messagePageChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C27471 extends l implements e6.l {
        final /* synthetic */ InAppMessage $message;
        final /* synthetic */ InAppMessagePage $page;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27471(InAppMessage inAppMessage, InAppMessagePage inAppMessagePage) {
            super(1);
            this.$message = inAppMessage;
            this.$page = inAppMessagePage;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IInAppLifecycleEventHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IInAppLifecycleEventHandler it) {
            k.e(it, "it");
            it.onMessagePageChanged(this.$message, this.$page);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.lifecycle.impl.IAMLifecycleService$messageWasDismissed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C27481 extends l implements e6.l {
        final /* synthetic */ InAppMessage $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27481(InAppMessage inAppMessage) {
            super(1);
            this.$message = inAppMessage;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IInAppLifecycleEventHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IInAppLifecycleEventHandler it) {
            k.e(it, "it");
            it.onMessageWasDismissed(this.$message);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.lifecycle.impl.IAMLifecycleService$messageWasDisplayed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C27491 extends l implements e6.l {
        final /* synthetic */ InAppMessage $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27491(InAppMessage inAppMessage) {
            super(1);
            this.$message = inAppMessage;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IInAppLifecycleEventHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IInAppLifecycleEventHandler it) {
            k.e(it, "it");
            it.onMessageWasDisplayed(this.$message);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.lifecycle.impl.IAMLifecycleService$messageWillDismiss$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C27501 extends l implements e6.l {
        final /* synthetic */ InAppMessage $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27501(InAppMessage inAppMessage) {
            super(1);
            this.$message = inAppMessage;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IInAppLifecycleEventHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IInAppLifecycleEventHandler it) {
            k.e(it, "it");
            it.onMessageWillDismiss(this.$message);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.lifecycle.impl.IAMLifecycleService$messageWillDisplay$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C27511 extends l implements e6.l {
        final /* synthetic */ InAppMessage $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27511(InAppMessage inAppMessage) {
            super(1);
            this.$message = inAppMessage;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IInAppLifecycleEventHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IInAppLifecycleEventHandler it) {
            k.e(it, "it");
            it.onMessageWillDisplay(this.$message);
        }
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService
    public void messageActionOccurredOnMessage(InAppMessage message, InAppMessageClickResult action) {
        k.e(message, "message");
        k.e(action, "action");
        fire(new AnonymousClass1(message, action));
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService
    public void messageActionOccurredOnPreview(InAppMessage message, InAppMessageClickResult action) {
        k.e(message, "message");
        k.e(action, "action");
        fire(new C27461(message, action));
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService
    public void messagePageChanged(InAppMessage message, InAppMessagePage page) {
        k.e(message, "message");
        k.e(page, "page");
        fire(new C27471(message, page));
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService
    public void messageWasDismissed(InAppMessage message) {
        k.e(message, "message");
        fire(new C27481(message));
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService
    public void messageWasDisplayed(InAppMessage message) {
        k.e(message, "message");
        fire(new C27491(message));
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService
    public void messageWillDismiss(InAppMessage message) {
        k.e(message, "message");
        fire(new C27501(message));
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService
    public void messageWillDisplay(InAppMessage message) {
        k.e(message, "message");
        fire(new C27511(message));
    }
}
