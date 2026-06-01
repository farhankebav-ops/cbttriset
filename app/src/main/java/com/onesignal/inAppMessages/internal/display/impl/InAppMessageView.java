package com.onesignal.inAppMessages.internal.display.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.core.widget.PopupWindowCompat;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.ViewUtils;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.common.threading.Waiter;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout;
import com.onesignal.inAppMessages.internal.display.impl.InAppMessageView;
import com.onesignal.inAppMessages.internal.display.impl.OSPopupWindow;
import com.onesignal.inAppMessages.internal.display.impl.WebViewManager;
import e2.s;
import e6.p;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.m0;
import r2.q;
import v6.n;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppMessageView {
    private static final int ACTIVITY_BACKGROUND_COLOR_EMPTY = 0;
    private static final int ACTIVITY_FINISH_AFTER_DISMISS_DELAY_MS = 600;
    private static final int ACTIVITY_INIT_DELAY = 200;
    private static final int IN_APP_BACKGROUND_ANIMATION_DURATION_MS = 400;
    private static final int IN_APP_BANNER_ANIMATION_DURATION_MS = 1000;
    private static final int IN_APP_CENTER_ANIMATION_DURATION_MS = 1000;
    private static final String IN_APP_MESSAGE_CARD_VIEW_TAG = "IN_APP_MESSAGE_CARD_VIEW_TAG";
    private boolean cancelDismissTimer;
    private Activity currentActivity;
    private final boolean disableDragDismiss;
    private final double displayDuration;
    private final WebViewManager.Position displayPosition;
    private DraggableRelativeLayout draggableRelativeLayout;
    private final boolean hasBackground;
    private final boolean hideGrayOverlay;
    private boolean isDismissTimerSet;
    private boolean isDragging;
    private int marginPxSizeBottom;
    private int marginPxSizeLeft;
    private int marginPxSizeRight;
    private int marginPxSizeTop;
    private final InAppMessageContent messageContent;
    private InAppMessageViewListener messageController;
    private int pageHeight;
    private final int pageWidth;
    private RelativeLayout parentRelativeLayout;
    private OSPopupWindow popupWindow;
    private final InAppMessageView$popupWindowListener$1 popupWindowListener;
    private boolean shouldDismissWhenActive;
    private WebView webView;
    public static final Companion Companion = new Companion(null);
    private static final int ACTIVITY_BACKGROUND_COLOR_FULL = Color.parseColor("#BB000000");
    private static final int DRAG_THRESHOLD_PX_SIZE = ViewUtils.INSTANCE.dpToPx(4);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InAppMessageViewListener {
        void onMessageWasDismissed();

        void onMessageWasDisplayed();

        void onMessageWillDismiss();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WebViewManager.Position.values().length];
            iArr[WebViewManager.Position.TOP_BANNER.ordinal()] = 1;
            iArr[WebViewManager.Position.BOTTOM_BANNER.ordinal()] = 2;
            iArr[WebViewManager.Position.CENTER_MODAL.ordinal()] = 3;
            iArr[WebViewManager.Position.FULL_SCREEN.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$delayShowUntilAvailable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.InAppMessageView", f = "InAppMessageView.kt", l = {450, 454, 455}, m = "delayShowUntilAvailable")
    public static final class C27351 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C27351(v5.c<? super C27351> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppMessageView.this.delayShowUntilAvailable(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$finishAfterDelay$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$finishAfterDelay$2", f = "InAppMessageView.kt", l = {477, 479}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        int label;

        public AnonymousClass2(v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return InAppMessageView.this.new AnonymousClass2(cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
        
            if (r6.animateAndDismissLayout(r1, r5) == r0) goto L19;
         */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                r2.q.z0(r6)
                goto L51
            L10:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L18:
                r2.q.z0(r6)
                goto L2a
            L1c:
                r2.q.z0(r6)
                r5.label = r3
                r3 = 600(0x258, double:2.964E-321)
                java.lang.Object r6 = q6.c0.k(r3, r5)
                if (r6 != r0) goto L2a
                goto L4b
            L2a:
                com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r6 = com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.this
                boolean r6 = com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.access$getHasBackground$p(r6)
                if (r6 == 0) goto L4c
                com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r6 = com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.this
                android.widget.RelativeLayout r6 = com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.access$getParentRelativeLayout$p(r6)
                if (r6 == 0) goto L4c
                com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r6 = com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.this
                android.widget.RelativeLayout r1 = com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.access$getParentRelativeLayout$p(r6)
                kotlin.jvm.internal.k.b(r1)
                r5.label = r2
                java.lang.Object r6 = com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.access$animateAndDismissLayout(r6, r1, r5)
                if (r6 != r0) goto L51
            L4b:
                return r0
            L4c:
                com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r6 = com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.this
                com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.access$cleanupViewsAfterDismiss(r6)
            L51:
                q5.x r6 = q5.x.f13520a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$showDraggableView$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$showDraggableView$2", f = "InAppMessageView.kt", l = {272}, m = "invokeSuspend")
    public static final class C27372 extends i implements p {
        final /* synthetic */ WebViewManager.Position $displayLocation;
        final /* synthetic */ RelativeLayout.LayoutParams $draggableRelativeLayoutParams;
        final /* synthetic */ RelativeLayout.LayoutParams $relativeLayoutParams;
        final /* synthetic */ DraggableRelativeLayout.Params $webViewLayoutParams;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27372(RelativeLayout.LayoutParams layoutParams, RelativeLayout.LayoutParams layoutParams2, DraggableRelativeLayout.Params params, WebViewManager.Position position, v5.c<? super C27372> cVar) {
            super(2, cVar);
            this.$relativeLayoutParams = layoutParams;
            this.$draggableRelativeLayoutParams = layoutParams2;
            this.$webViewLayoutParams = params;
            this.$displayLocation = position;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return InAppMessageView.this.new C27372(this.$relativeLayoutParams, this.$draggableRelativeLayoutParams, this.$webViewLayoutParams, this.$displayLocation, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            x xVar = x.f13520a;
            if (i2 == 0) {
                q.z0(obj);
                if (InAppMessageView.this.webView == null) {
                    return xVar;
                }
                WebView webView = InAppMessageView.this.webView;
                k.b(webView);
                webView.setLayoutParams(this.$relativeLayoutParams);
                InAppMessageView inAppMessageView = InAppMessageView.this;
                Activity activity = inAppMessageView.currentActivity;
                k.b(activity);
                inAppMessageView.setUpDraggableLayout(activity, this.$draggableRelativeLayoutParams, this.$webViewLayoutParams);
                InAppMessageView inAppMessageView2 = InAppMessageView.this;
                Activity activity2 = inAppMessageView2.currentActivity;
                k.b(activity2);
                inAppMessageView2.setUpParentRelativeLayout(activity2);
                InAppMessageView inAppMessageView3 = InAppMessageView.this;
                RelativeLayout relativeLayout = inAppMessageView3.parentRelativeLayout;
                k.b(relativeLayout);
                inAppMessageView3.createPopupWindow(relativeLayout);
                if (InAppMessageView.this.messageController != null) {
                    InAppMessageView inAppMessageView4 = InAppMessageView.this;
                    WebViewManager.Position position = this.$displayLocation;
                    DraggableRelativeLayout draggableRelativeLayout = inAppMessageView4.draggableRelativeLayout;
                    k.b(draggableRelativeLayout);
                    RelativeLayout relativeLayout2 = InAppMessageView.this.parentRelativeLayout;
                    k.b(relativeLayout2);
                    inAppMessageView4.animateInAppMessage(position, draggableRelativeLayout, relativeLayout2);
                }
                InAppMessageView inAppMessageView5 = InAppMessageView.this;
                this.label = 1;
                if (inAppMessageView5.startDismissTimerIfNeeded(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return xVar;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((C27372) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$startDismissTimerIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.InAppMessageView", f = "InAppMessageView.kt", l = {428, 439}, m = "startDismissTimerIfNeeded")
    public static final class C27381 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27381(v5.c<? super C27381> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppMessageView.this.startDismissTimerIfNeeded(this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$updateHeight$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$updateHeight$2", f = "InAppMessageView.kt", l = {}, m = "invokeSuspend")
    public static final class C27392 extends i implements p {
        final /* synthetic */ int $pageHeight;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27392(int i2, v5.c<? super C27392> cVar) {
            super(2, cVar);
            this.$pageHeight = i2;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return InAppMessageView.this.new C27392(this.$pageHeight, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            WebView webView = InAppMessageView.this.webView;
            x xVar = x.f13520a;
            if (webView == null) {
                Logging.warn$default("WebView height update skipped, new height will be used once it is displayed.", null, 2, null);
                return xVar;
            }
            WebView webView2 = InAppMessageView.this.webView;
            k.b(webView2);
            ViewGroup.LayoutParams layoutParams = webView2.getLayoutParams();
            if (layoutParams == null) {
                Logging.warn$default("WebView height update skipped because of null layoutParams, new height will be used once it is displayed.", null, 2, null);
                return xVar;
            }
            layoutParams.height = this.$pageHeight;
            WebView webView3 = InAppMessageView.this.webView;
            k.b(webView3);
            webView3.setLayoutParams(layoutParams);
            if (InAppMessageView.this.draggableRelativeLayout != null) {
                DraggableRelativeLayout draggableRelativeLayout = InAppMessageView.this.draggableRelativeLayout;
                k.b(draggableRelativeLayout);
                InAppMessageView inAppMessageView = InAppMessageView.this;
                draggableRelativeLayout.setParams(inAppMessageView.createDraggableLayoutParams(this.$pageHeight, inAppMessageView.getDisplayPosition(), InAppMessageView.this.disableDragDismiss));
            }
            return xVar;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((C27392) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$popupWindowListener$1] */
    public InAppMessageView(WebView webView, InAppMessageContent messageContent, boolean z2, boolean z7) {
        double dDoubleValue;
        k.e(messageContent, "messageContent");
        this.webView = webView;
        this.messageContent = messageContent;
        this.disableDragDismiss = z2;
        this.hideGrayOverlay = z7;
        this.pageWidth = -1;
        this.pageHeight = messageContent.getPageHeight();
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        this.marginPxSizeLeft = viewUtils.dpToPx(24);
        this.marginPxSizeRight = viewUtils.dpToPx(24);
        this.marginPxSizeTop = viewUtils.dpToPx(24);
        this.marginPxSizeBottom = viewUtils.dpToPx(24);
        WebViewManager.Position displayLocation = messageContent.getDisplayLocation();
        k.b(displayLocation);
        this.displayPosition = displayLocation;
        if (messageContent.getDisplayDuration() == null) {
            dDoubleValue = 0.0d;
        } else {
            Double displayDuration = messageContent.getDisplayDuration();
            k.b(displayDuration);
            dDoubleValue = displayDuration.doubleValue();
        }
        this.displayDuration = dDoubleValue;
        this.hasBackground = !displayLocation.isBanner();
        this.popupWindowListener = new OSPopupWindow.PopupWindowListener() { // from class: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$popupWindowListener$1
            @Override // com.onesignal.inAppMessages.internal.display.impl.OSPopupWindow.PopupWindowListener
            public void onDismiss(Boolean bool) {
                if (k.a(bool, Boolean.TRUE)) {
                    return;
                }
                Logging.debug$default("PopupWindowListener.onDismiss called by the system.", null, 2, null);
                InAppMessageView.InAppMessageViewListener inAppMessageViewListener = this.this$0.messageController;
                if (inAppMessageViewListener != null) {
                    inAppMessageViewListener.onMessageWasDismissed();
                }
            }
        };
        setMarginsFromContent(messageContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateAndDismissLayout(View view, v5.c<? super x> cVar) {
        final Waiter waiter = new Waiter();
        animateBackgroundColor(view, 400, getOverlayColor(), 0, new AnimatorListenerAdapter() { // from class: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$animateAndDismissLayout$animCallback$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                k.e(animation, "animation");
                this.this$0.cleanupViewsAfterDismiss();
                waiter.wake();
            }
        }).start();
        Object objWaitForWake = waiter.waitForWake(cVar);
        return objWaitForWake == w5.a.f17774a ? objWaitForWake : x.f13520a;
    }

    private final ValueAnimator animateBackgroundColor(View view, int i2, int i8, int i9, Animator.AnimatorListener animatorListener) {
        return OneSignalAnimate.INSTANCE.animateViewColor(view, i2, i8, i9, animatorListener);
    }

    private final void animateBottom(View view, int i2, Animation.AnimationListener animationListener) {
        OneSignalAnimate.INSTANCE.animateViewByTranslation(view, i2 + this.marginPxSizeBottom, 0.0f, 1000, new OneSignalBounceInterpolator(0.1d, 8.0d), animationListener).start();
    }

    private final void animateCenter(View view, View view2, Animation.AnimationListener animationListener, Animator.AnimatorListener animatorListener) {
        Animation animationAnimateViewSmallToLarge = OneSignalAnimate.INSTANCE.animateViewSmallToLarge(view, 1000, new OneSignalBounceInterpolator(0.1d, 8.0d), animationListener);
        ValueAnimator valueAnimatorAnimateBackgroundColor = animateBackgroundColor(view2, 400, 0, getOverlayColor(), animatorListener);
        animationAnimateViewSmallToLarge.start();
        valueAnimatorAnimateBackgroundColor.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateInAppMessage(WebViewManager.Position position, View view, View view2) {
        k.b(view);
        CardView messageViewCardView = (CardView) view.findViewWithTag(IN_APP_MESSAGE_CARD_VIEW_TAG);
        k.d(messageViewCardView, "messageViewCardView");
        Animation.AnimationListener animationListenerCreateAnimationListener = createAnimationListener(messageViewCardView);
        int i2 = WhenMappings.$EnumSwitchMapping$0[position.ordinal()];
        if (i2 == 1) {
            WebView webView = this.webView;
            k.b(webView);
            animateTop(messageViewCardView, webView.getHeight(), animationListenerCreateAnimationListener);
        } else if (i2 == 2) {
            WebView webView2 = this.webView;
            k.b(webView2);
            animateBottom(messageViewCardView, webView2.getHeight(), animationListenerCreateAnimationListener);
        } else if (i2 == 3 || i2 == 4) {
            animateCenter(view, view2, animationListenerCreateAnimationListener, null);
        }
    }

    private final void animateTop(View view, int i2, Animation.AnimationListener animationListener) {
        OneSignalAnimate.INSTANCE.animateViewByTranslation(view, (-i2) - this.marginPxSizeTop, 0.0f, 1000, new OneSignalBounceInterpolator(0.1d, 8.0d), animationListener).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanupViewsAfterDismiss() {
        removeAllViews();
        InAppMessageViewListener inAppMessageViewListener = this.messageController;
        if (inAppMessageViewListener != null) {
            inAppMessageViewListener.onMessageWasDismissed();
        }
    }

    private final Animation.AnimationListener createAnimationListener(final CardView cardView) {
        return new Animation.AnimationListener() { // from class: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.createAnimationListener.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                k.e(animation, "animation");
                if (Build.VERSION.SDK_INT == 23) {
                    cardView.setCardElevation(ViewUtils.INSTANCE.dpToPx(5));
                }
                if (this.messageController != null) {
                    InAppMessageViewListener inAppMessageViewListener = this.messageController;
                    k.b(inAppMessageViewListener);
                    inAppMessageViewListener.onMessageWasDisplayed();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                k.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                k.e(animation, "animation");
            }
        };
    }

    private final CardView createCardView(Context context) {
        CardView cardView = new CardView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.displayPosition == WebViewManager.Position.FULL_SCREEN ? -1 : -2);
        layoutParams.addRule(13);
        cardView.setLayoutParams(layoutParams);
        if (Build.VERSION.SDK_INT == 23 || getHideDropShadow(context)) {
            cardView.setCardElevation(0.0f);
        } else {
            cardView.setCardElevation(ViewUtils.INSTANCE.dpToPx(5));
        }
        cardView.setRadius(ViewUtils.INSTANCE.dpToPx(8));
        cardView.setClipChildren(false);
        cardView.setClipToPadding(false);
        cardView.setPreventCornerOverlap(false);
        cardView.setCardBackgroundColor(0);
        return cardView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DraggableRelativeLayout.Params createDraggableLayoutParams(int i2, WebViewManager.Position position, boolean z2) {
        DraggableRelativeLayout.Params params = new DraggableRelativeLayout.Params();
        params.setMaxXPos(this.marginPxSizeRight);
        params.setMaxYPos(this.marginPxSizeTop);
        params.setDraggingDisabled(z2);
        params.setMessageHeight(i2);
        params.setHeight(getDisplayYSize());
        int i8 = WhenMappings.$EnumSwitchMapping$0[position.ordinal()];
        if (i8 == 1) {
            params.setDragThresholdY(this.marginPxSizeTop - DRAG_THRESHOLD_PX_SIZE);
        } else if (i8 == 2) {
            params.setPosY(getDisplayYSize() - i2);
            params.setDragThresholdY(this.marginPxSizeBottom + DRAG_THRESHOLD_PX_SIZE);
        } else if (i8 == 3) {
            int displayYSize = (getDisplayYSize() / 2) - (i2 / 2);
            params.setDragThresholdY(DRAG_THRESHOLD_PX_SIZE + displayYSize);
            params.setMaxYPos(displayYSize);
            params.setPosY(displayYSize);
        } else if (i8 == 4) {
            int displayYSize2 = getDisplayYSize() - (this.marginPxSizeBottom + this.marginPxSizeTop);
            params.setMessageHeight(displayYSize2);
            int displayYSize3 = (getDisplayYSize() / 2) - (displayYSize2 / 2);
            params.setDragThresholdY(DRAG_THRESHOLD_PX_SIZE + displayYSize3);
            params.setMaxYPos(displayYSize3);
            params.setPosY(displayYSize3);
        }
        params.setDragDirection(position == WebViewManager.Position.TOP_BANNER ? 0 : 1);
        return params;
    }

    private final RelativeLayout.LayoutParams createParentRelativeLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.pageWidth, -1);
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.displayPosition.ordinal()];
        if (i2 == 1) {
            layoutParams.addRule(10);
            layoutParams.addRule(14);
            return layoutParams;
        }
        if (i2 == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            return layoutParams;
        }
        if (i2 != 3 && i2 != 4) {
            return layoutParams;
        }
        layoutParams.addRule(13);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createPopupWindow(RelativeLayout relativeLayout) {
        boolean z2 = this.hasBackground;
        OSPopupWindow oSPopupWindow = new OSPopupWindow(relativeLayout, z2 ? -1 : this.pageWidth, z2 ? -1 : -2, false, this.popupWindowListener);
        this.popupWindow = oSPopupWindow;
        oSPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        OSPopupWindow oSPopupWindow2 = this.popupWindow;
        int i2 = 1;
        if (oSPopupWindow2 != null) {
            oSPopupWindow2.setTouchable(true);
        }
        OSPopupWindow oSPopupWindow3 = this.popupWindow;
        if (oSPopupWindow3 != null) {
            oSPopupWindow3.setFocusable(!this.displayPosition.isBanner());
        }
        OSPopupWindow oSPopupWindow4 = this.popupWindow;
        if (oSPopupWindow4 != null) {
            oSPopupWindow4.setClippingEnabled(false);
        }
        if (this.hasBackground) {
            i2 = 0;
        } else {
            int i8 = WhenMappings.$EnumSwitchMapping$0[this.displayPosition.ordinal()];
            if (i8 == 1) {
                i2 = 49;
            } else if (i8 == 2) {
                i2 = 81;
            } else if (i8 != 3 && i8 != 4) {
                throw new s(3);
            }
        }
        int i9 = this.messageContent.isFullBleed() ? 1000 : 1003;
        OSPopupWindow oSPopupWindow5 = this.popupWindow;
        k.b(oSPopupWindow5);
        PopupWindowCompat.setWindowLayoutType(oSPopupWindow5, i9);
        OSPopupWindow oSPopupWindow6 = this.popupWindow;
        if (oSPopupWindow6 != null) {
            Activity activity = this.currentActivity;
            k.b(activity);
            oSPopupWindow6.showAtLocation(activity.getWindow().getDecorView().getRootView(), i2, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object delayShowUntilAvailable(android.app.Activity r8, v5.c<? super q5.x> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.C27351
            if (r0 == 0) goto L13
            r0 = r9
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$delayShowUntilAvailable$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.C27351) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$delayShowUntilAvailable$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$delayShowUntilAvailable$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            q5.x r3 = q5.x.f13520a
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L47
            if (r2 == r6) goto L43
            if (r2 == r5) goto L37
            if (r2 != r4) goto L2f
            r2.q.z0(r9)
            goto L7e
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            java.lang.Object r8 = r0.L$1
            android.app.Activity r8 = (android.app.Activity) r8
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView) r2
            r2.q.z0(r9)
            goto L70
        L43:
            r2.q.z0(r9)
            goto L5f
        L47:
            r2.q.z0(r9)
            com.onesignal.common.AndroidUtils r9 = com.onesignal.common.AndroidUtils.INSTANCE
            boolean r9 = r9.isActivityFullyReady(r8)
            if (r9 == 0) goto L60
            android.widget.RelativeLayout r9 = r7.parentRelativeLayout
            if (r9 != 0) goto L60
            r0.label = r6
            java.lang.Object r8 = r7.showInAppMessageView(r8, r0)
            if (r8 != r1) goto L5f
            goto L7d
        L5f:
            return r3
        L60:
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            r5 = 200(0xc8, double:9.9E-322)
            java.lang.Object r9 = q6.c0.k(r5, r0)
            if (r9 != r1) goto L6f
            goto L7d
        L6f:
            r2 = r7
        L70:
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r8 = r2.delayShowUntilAvailable(r8, r0)
            if (r8 != r1) goto L7e
        L7d:
            return r1
        L7e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.delayShowUntilAvailable(android.app.Activity, v5.c):java.lang.Object");
    }

    private final void dereferenceViews() {
        this.parentRelativeLayout = null;
        this.draggableRelativeLayout = null;
        this.webView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object finishAfterDelay(v5.c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new AnonymousClass2(null), n.f17641a, cVar);
        return objH == w5.a.f17774a ? objH : x.f13520a;
    }

    private final int getDisplayYSize() {
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        Activity activity = this.currentActivity;
        k.b(activity);
        return viewUtils.getWindowHeight(activity);
    }

    private final boolean getHideDropShadow(Context context) {
        return AndroidUtils.INSTANCE.getManifestMetaBoolean(context, "com.onesignal.inAppMessageHideDropShadow");
    }

    private final int getOverlayColor() {
        if (this.hideGrayOverlay) {
            return 0;
        }
        return ACTIVITY_BACKGROUND_COLOR_FULL;
    }

    private final void setMarginsFromContent(InAppMessageContent inAppMessageContent) {
        this.marginPxSizeTop = inAppMessageContent.getUseHeightMargin() ? ViewUtils.INSTANCE.dpToPx(24) : 0;
        this.marginPxSizeBottom = inAppMessageContent.getUseHeightMargin() ? ViewUtils.INSTANCE.dpToPx(24) : 0;
        this.marginPxSizeLeft = inAppMessageContent.getUseWidthMargin() ? ViewUtils.INSTANCE.dpToPx(24) : 0;
        this.marginPxSizeRight = inAppMessageContent.getUseWidthMargin() ? ViewUtils.INSTANCE.dpToPx(24) : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUpDraggableLayout(Context context, RelativeLayout.LayoutParams layoutParams, DraggableRelativeLayout.Params params) {
        DraggableRelativeLayout draggableRelativeLayout = new DraggableRelativeLayout(context);
        this.draggableRelativeLayout = draggableRelativeLayout;
        if (layoutParams != null) {
            draggableRelativeLayout.setLayoutParams(layoutParams);
        }
        DraggableRelativeLayout draggableRelativeLayout2 = this.draggableRelativeLayout;
        k.b(draggableRelativeLayout2);
        draggableRelativeLayout2.setParams(params);
        DraggableRelativeLayout draggableRelativeLayout3 = this.draggableRelativeLayout;
        k.b(draggableRelativeLayout3);
        draggableRelativeLayout3.setListener(new DraggableRelativeLayout.DraggableListener() { // from class: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.setUpDraggableLayout.1
            @Override // com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout.DraggableListener
            public void onDismiss() {
                if (InAppMessageView.this.messageController != null) {
                    InAppMessageViewListener inAppMessageViewListener = InAppMessageView.this.messageController;
                    k.b(inAppMessageViewListener);
                    inAppMessageViewListener.onMessageWillDismiss();
                }
                ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessageView$setUpDraggableLayout$1$onDismiss$1(InAppMessageView.this, null), 1, null);
            }

            @Override // com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout.DraggableListener
            public void onDragEnd() {
                InAppMessageView.this.isDragging = false;
            }

            @Override // com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout.DraggableListener
            public void onDragStart() {
                InAppMessageView.this.isDragging = true;
            }
        });
        WebView webView = this.webView;
        k.b(webView);
        if (webView.getParent() != null) {
            WebView webView2 = this.webView;
            k.b(webView2);
            ViewParent parent = webView2.getParent();
            k.c(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeAllViews();
        }
        CardView cardViewCreateCardView = createCardView(context);
        cardViewCreateCardView.setTag(IN_APP_MESSAGE_CARD_VIEW_TAG);
        cardViewCreateCardView.addView(this.webView);
        DraggableRelativeLayout draggableRelativeLayout4 = this.draggableRelativeLayout;
        k.b(draggableRelativeLayout4);
        draggableRelativeLayout4.setPadding(this.marginPxSizeLeft, this.marginPxSizeTop, this.marginPxSizeRight, this.marginPxSizeBottom);
        DraggableRelativeLayout draggableRelativeLayout5 = this.draggableRelativeLayout;
        k.b(draggableRelativeLayout5);
        draggableRelativeLayout5.setClipChildren(false);
        DraggableRelativeLayout draggableRelativeLayout6 = this.draggableRelativeLayout;
        k.b(draggableRelativeLayout6);
        draggableRelativeLayout6.setClipToPadding(false);
        DraggableRelativeLayout draggableRelativeLayout7 = this.draggableRelativeLayout;
        k.b(draggableRelativeLayout7);
        draggableRelativeLayout7.addView(cardViewCreateCardView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUpParentRelativeLayout(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.parentRelativeLayout = relativeLayout;
        relativeLayout.setBackgroundDrawable(new ColorDrawable(0));
        RelativeLayout relativeLayout2 = this.parentRelativeLayout;
        k.b(relativeLayout2);
        relativeLayout2.setClipChildren(false);
        RelativeLayout relativeLayout3 = this.parentRelativeLayout;
        k.b(relativeLayout3);
        relativeLayout3.setClipToPadding(false);
        RelativeLayout relativeLayout4 = this.parentRelativeLayout;
        k.b(relativeLayout4);
        relativeLayout4.addView(this.draggableRelativeLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showDraggableView(WebViewManager.Position position, RelativeLayout.LayoutParams layoutParams, RelativeLayout.LayoutParams layoutParams2, DraggableRelativeLayout.Params params, v5.c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new C27372(layoutParams, layoutParams2, params, position, null), n.f17641a, cVar);
        return objH == w5.a.f17774a ? objH : x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object startDismissTimerIfNeeded(v5.c<? super q5.x> r12) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.C27381
            if (r0 == 0) goto L13
            r0 = r12
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$startDismissTimerIfNeeded$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.C27381) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$startDismissTimerIfNeeded$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$startDismissTimerIfNeeded$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 0
            r4 = 2
            q5.x r5 = q5.x.f13520a
            r6 = 1
            if (r2 == 0) goto L41
            if (r2 == r6) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r0 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView) r0
            r2.q.z0(r12)
            goto L85
        L31:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L39:
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView) r2
            r2.q.z0(r12)
            goto L64
        L41:
            r2.q.z0(r12)
            double r7 = r11.displayDuration
            r9 = 0
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 <= 0) goto L8a
            boolean r12 = r11.isDismissTimerSet
            if (r12 == 0) goto L51
            goto L8a
        L51:
            r11.isDismissTimerSet = r6
            long r7 = (long) r7
            r12 = 1000(0x3e8, float:1.401E-42)
            long r9 = (long) r12
            long r7 = r7 * r9
            r0.L$0 = r11
            r0.label = r6
            java.lang.Object r12 = q6.c0.k(r7, r0)
            if (r12 != r1) goto L63
            goto L83
        L63:
            r2 = r11
        L64:
            boolean r12 = r2.cancelDismissTimer
            if (r12 == 0) goto L6b
            r2.cancelDismissTimer = r3
            return r5
        L6b:
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$InAppMessageViewListener r12 = r2.messageController
            if (r12 == 0) goto L75
            kotlin.jvm.internal.k.b(r12)
            r12.onMessageWillDismiss()
        L75:
            android.app.Activity r12 = r2.currentActivity
            if (r12 == 0) goto L88
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r12 = r2.dismissAndAwaitNextMessage(r0)
            if (r12 != r1) goto L84
        L83:
            return r1
        L84:
            r0 = r2
        L85:
            r0.isDismissTimerSet = r3
            goto L8a
        L88:
            r2.shouldDismissWhenActive = r6
        L8a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.startDismissTimerIfNeeded(v5.c):java.lang.Object");
    }

    public final Object checkIfShouldDismiss(v5.c<? super x> cVar) throws Throwable {
        boolean z2 = this.shouldDismissWhenActive;
        x xVar = x.f13520a;
        if (z2) {
            this.shouldDismissWhenActive = false;
            Object objFinishAfterDelay = finishAfterDelay(cVar);
            if (objFinishAfterDelay == w5.a.f17774a) {
                return objFinishAfterDelay;
            }
        }
        return xVar;
    }

    public final Object dismissAndAwaitNextMessage(v5.c<? super x> cVar) throws Throwable {
        DraggableRelativeLayout draggableRelativeLayout = this.draggableRelativeLayout;
        x xVar = x.f13520a;
        if (draggableRelativeLayout == null) {
            Logging.error$default("No host presenter to trigger dismiss animation, counting as dismissed already", null, 2, null);
            dereferenceViews();
            return xVar;
        }
        k.b(draggableRelativeLayout);
        draggableRelativeLayout.dismiss();
        Object objFinishAfterDelay = finishAfterDelay(cVar);
        return objFinishAfterDelay == w5.a.f17774a ? objFinishAfterDelay : xVar;
    }

    public final WebViewManager.Position getDisplayPosition() {
        return this.displayPosition;
    }

    public final boolean isDragging() {
        return this.isDragging;
    }

    public final void removeAllViews() {
        Logging.debug$default("InAppMessageView.removeAllViews()", null, 2, null);
        OSPopupWindow oSPopupWindow = this.popupWindow;
        if (oSPopupWindow != null) {
            oSPopupWindow.setWasDismissedManually(Boolean.TRUE);
        }
        if (this.isDismissTimerSet) {
            this.cancelDismissTimer = true;
        }
        DraggableRelativeLayout draggableRelativeLayout = this.draggableRelativeLayout;
        if (draggableRelativeLayout != null) {
            draggableRelativeLayout.removeAllViews();
        }
        OSPopupWindow oSPopupWindow2 = this.popupWindow;
        if (oSPopupWindow2 != null) {
            oSPopupWindow2.dismiss();
        }
        dereferenceViews();
    }

    public final void setMessageController(InAppMessageViewListener inAppMessageViewListener) {
        this.messageController = inAppMessageViewListener;
    }

    public final void setWebView(WebView webView) {
        k.e(webView, "webView");
        this.webView = webView;
        webView.setBackgroundColor(0);
    }

    public final Object showInAppMessageView(Activity activity, v5.c<? super x> cVar) throws Throwable {
        this.currentActivity = activity;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.pageHeight);
        layoutParams.addRule(13);
        RelativeLayout.LayoutParams layoutParamsCreateParentRelativeLayoutParams = this.hasBackground ? createParentRelativeLayoutParams() : null;
        WebViewManager.Position position = this.displayPosition;
        Object objShowDraggableView = showDraggableView(position, layoutParams, layoutParamsCreateParentRelativeLayoutParams, createDraggableLayoutParams(this.pageHeight, position, this.disableDragDismiss), cVar);
        return objShowDraggableView == w5.a.f17774a ? objShowDraggableView : x.f13520a;
    }

    public final Object showView(Activity activity, v5.c<? super x> cVar) throws Throwable {
        Object objDelayShowUntilAvailable = delayShowUntilAvailable(activity, cVar);
        return objDelayShowUntilAvailable == w5.a.f17774a ? objDelayShowUntilAvailable : x.f13520a;
    }

    public String toString() {
        return "InAppMessageView{currentActivity=" + this.currentActivity + ", pageWidth=" + this.pageWidth + ", pageHeight=" + this.pageHeight + ", displayDuration=" + this.displayDuration + ", hasBackground=" + this.hasBackground + ", shouldDismissWhenActive=" + this.shouldDismissWhenActive + ", isDragging=" + this.isDragging + ", disableDragDismiss=" + this.disableDragDismiss + ", displayLocation=" + this.displayPosition + ", webView=" + this.webView + '}';
    }

    public final Object updateHeight(int i2, v5.c<? super x> cVar) throws Throwable {
        this.pageHeight = i2;
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new C27392(i2, null), n.f17641a, cVar);
        return objH == w5.a.f17774a ? objH : x.f13520a;
    }
}
