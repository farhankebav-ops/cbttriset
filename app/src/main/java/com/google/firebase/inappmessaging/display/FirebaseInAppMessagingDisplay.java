package com.google.firebase.inappmessaging.display;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.camera.camera2.interop.d;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.webkit.ProxyConfig;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl;
import com.google.firebase.inappmessaging.display.internal.GlideErrorListener;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageData;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@FirebaseAppScope
public class FirebaseInAppMessagingDisplay extends FirebaseInAppMessagingDisplayImpl {
    static final long DISMISS_THRESHOLD_MILLIS = 20000;
    static final long IMPRESSION_THRESHOLD_MILLIS = 5000;
    static final long INTERVAL_MILLIS = 1000;
    private final FiamAnimator animator;
    private final Application application;
    private final RenewableTimer autoDismissTimer;
    private final BindingWrapperFactory bindingWrapperFactory;
    private FirebaseInAppMessagingDisplayCallbacks callbacks;

    @Nullable
    @VisibleForTesting
    String currentlyBoundActivityName;
    private FiamListener fiamListener;
    private final FirebaseInAppMessaging headlessInAppMessaging;
    private final FiamImageLoader imageLoader;
    private final RenewableTimer impressionTimer;
    private InAppMessage inAppMessage;
    private final Map<String, a> layoutConfigs;
    private final FiamWindowManager windowManager;

    /* JADX INFO: renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$model$MessageType;

        static {
            int[] iArr = new int[MessageType.values().length];
            $SwitchMap$com$google$firebase$inappmessaging$model$MessageType = iArr;
            try {
                iArr[MessageType.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.IMAGE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public FirebaseInAppMessagingDisplay(FirebaseInAppMessaging firebaseInAppMessaging, Map<String, a> map, FiamImageLoader fiamImageLoader, RenewableTimer renewableTimer, RenewableTimer renewableTimer2, FiamWindowManager fiamWindowManager, Application application, BindingWrapperFactory bindingWrapperFactory, FiamAnimator fiamAnimator) {
        this.headlessInAppMessaging = firebaseInAppMessaging;
        this.layoutConfigs = map;
        this.imageLoader = fiamImageLoader;
        this.impressionTimer = renewableTimer;
        this.autoDismissTimer = renewableTimer2;
        this.windowManager = fiamWindowManager;
        this.application = application;
        this.bindingWrapperFactory = bindingWrapperFactory;
        this.animator = fiamAnimator;
    }

    private void bindFiamToActivity(Activity activity) {
        String str = this.currentlyBoundActivityName;
        if (str == null || !str.equals(activity.getLocalClassName())) {
            Logging.logi("Binding to activity: " + activity.getLocalClassName());
            this.headlessInAppMessaging.setMessageDisplayComponent(new d(3, this, activity));
            this.currentlyBoundActivityName = activity.getLocalClassName();
        }
        if (this.inAppMessage != null) {
            showActiveFiam(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTimers() {
        this.impressionTimer.cancel();
        this.autoDismissTimer.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInAppMessageAndCallbacks() {
        setInAppMessageAndCallbacks(null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissFiam(Activity activity) {
        Logging.logd("Dismissing fiam");
        notifyFiamDismiss();
        removeDisplayedFiam(activity);
        clearInAppMessageAndCallbacks();
    }

    private List<Action> extractActions(InAppMessage inAppMessage) {
        ArrayList arrayList = new ArrayList();
        int i2 = AnonymousClass5.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[inAppMessage.getMessageType().ordinal()];
        if (i2 == 1) {
            arrayList.add(((BannerMessage) inAppMessage).getAction());
            return arrayList;
        }
        if (i2 == 2) {
            arrayList.add(((ModalMessage) inAppMessage).getAction());
            return arrayList;
        }
        if (i2 == 3) {
            arrayList.add(((ImageOnlyMessage) inAppMessage).getAction());
            return arrayList;
        }
        if (i2 != 4) {
            arrayList.add(Action.builder().build());
            return arrayList;
        }
        CardMessage cardMessage = (CardMessage) inAppMessage;
        arrayList.add(cardMessage.getPrimaryAction());
        arrayList.add(cardMessage.getSecondaryAction());
        return arrayList;
    }

    private ImageData extractImageData(InAppMessage inAppMessage) {
        if (inAppMessage.getMessageType() != MessageType.CARD) {
            return inAppMessage.getImageData();
        }
        CardMessage cardMessage = (CardMessage) inAppMessage;
        ImageData portraitImageData = cardMessage.getPortraitImageData();
        ImageData landscapeImageData = cardMessage.getLandscapeImageData();
        return (getScreenOrientation(this.application) != 1 ? !isValidImageData(landscapeImageData) : isValidImageData(portraitImageData)) ? portraitImageData : landscapeImageData;
    }

    @NonNull
    public static FirebaseInAppMessagingDisplay getInstance() {
        return (FirebaseInAppMessagingDisplay) FirebaseApp.getInstance().get(FirebaseInAppMessagingDisplay.class);
    }

    private static int getScreenOrientation(Application application) {
        return application.getResources().getConfiguration().orientation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void inflateBinding(final Activity activity, final BindingWrapper bindingWrapper) {
        View.OnClickListener onClickListener;
        if (this.inAppMessage == null) {
            return;
        }
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                    FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK);
                }
                FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
            }
        };
        HashMap map = new HashMap();
        for (final Action action : extractActions(this.inAppMessage)) {
            if (action == null || TextUtils.isEmpty(action.getActionUrl())) {
                Logging.logi("No action url found for action. Treating as dismiss.");
                onClickListener = onClickListener2;
            } else {
                onClickListener = new View.OnClickListener() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                            Logging.logi("Calling callback for click action");
                            FirebaseInAppMessagingDisplay.this.callbacks.messageClicked(action);
                        }
                        FirebaseInAppMessagingDisplay.this.launchUriIntent(activity, Uri.parse(action.getActionUrl()));
                        FirebaseInAppMessagingDisplay.this.notifyFiamClick();
                        FirebaseInAppMessagingDisplay.this.removeDisplayedFiam(activity);
                        FirebaseInAppMessagingDisplay.this.clearInAppMessageAndCallbacks();
                    }
                };
            }
            map.put(action, onClickListener);
        }
        final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListenerInflate = bindingWrapper.inflate(map, onClickListener2);
        if (onGlobalLayoutListenerInflate != null) {
            bindingWrapper.getImageView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListenerInflate);
        }
        loadNullableImage(activity, bindingWrapper, extractImageData(this.inAppMessage), new FiamImageLoader.Callback() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4
            @Override // com.google.firebase.inappmessaging.display.internal.FiamImageLoader.Callback
            public void onError(Exception exc) {
                Logging.loge("Image download failure ");
                if (onGlobalLayoutListenerInflate != null) {
                    bindingWrapper.getImageView().getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListenerInflate);
                }
                FirebaseInAppMessagingDisplay.this.cancelTimers();
                FirebaseInAppMessagingDisplay.this.clearInAppMessageAndCallbacks();
            }

            @Override // com.google.firebase.inappmessaging.display.internal.FiamImageLoader.Callback
            public void onSuccess() {
                if (!bindingWrapper.getConfig().backgroundEnabled().booleanValue()) {
                    bindingWrapper.getRootView().setOnTouchListener(new View.OnTouchListener() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() != 4) {
                                return false;
                            }
                            if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                                FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE);
                            }
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
                            return true;
                        }
                    });
                }
                FirebaseInAppMessagingDisplay.this.impressionTimer.start(new RenewableTimer.Callback() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.2
                    @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
                    public void onFinish() {
                        if (FirebaseInAppMessagingDisplay.this.inAppMessage == null || FirebaseInAppMessagingDisplay.this.callbacks == null) {
                            return;
                        }
                        Logging.logi("Impression timer onFinish for: " + FirebaseInAppMessagingDisplay.this.inAppMessage.getCampaignMetadata().getCampaignId());
                        FirebaseInAppMessagingDisplay.this.callbacks.impressionDetected();
                    }
                }, 5000L, 1000L);
                if (bindingWrapper.getConfig().autoDismiss().booleanValue()) {
                    FirebaseInAppMessagingDisplay.this.autoDismissTimer.start(new RenewableTimer.Callback() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.3
                        @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
                        public void onFinish() {
                            if (FirebaseInAppMessagingDisplay.this.inAppMessage != null && FirebaseInAppMessagingDisplay.this.callbacks != null) {
                                FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO);
                            }
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
                        }
                    }, FirebaseInAppMessagingDisplay.DISMISS_THRESHOLD_MILLIS, 1000L);
                }
                activity.runOnUiThread(new Runnable() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.4
                    @Override // java.lang.Runnable
                    public void run() {
                        FiamWindowManager fiamWindowManager = FirebaseInAppMessagingDisplay.this.windowManager;
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        fiamWindowManager.show(bindingWrapper, activity);
                        if (bindingWrapper.getConfig().animate().booleanValue()) {
                            FirebaseInAppMessagingDisplay.this.animator.slideIntoView(FirebaseInAppMessagingDisplay.this.application, bindingWrapper.getRootView(), FiamAnimator.Position.TOP);
                        }
                    }
                });
            }
        });
    }

    private boolean isValidImageData(@Nullable ImageData imageData) {
        return (imageData == null || TextUtils.isEmpty(imageData.getImageUrl())) ? false : true;
    }

    private boolean ishttpOrHttpsUri(Uri uri) {
        String scheme;
        return (uri == null || (scheme = uri.getScheme()) == null || (!scheme.equalsIgnoreCase(ProxyConfig.MATCH_HTTP) && !scheme.equalsIgnoreCase("https"))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindFiamToActivity$0(Activity activity, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        if (this.inAppMessage != null || this.headlessInAppMessaging.areMessagesSuppressed()) {
            Logging.logd("Active FIAM exists. Skipping trigger");
        } else {
            setInAppMessageAndCallbacks(inAppMessage, firebaseInAppMessagingDisplayCallbacks);
            showActiveFiam(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchUriIntent(Activity activity, Uri uri) {
        if (ishttpOrHttpsUri(uri) && supportsCustomTabs(activity)) {
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
            Intent intent = customTabsIntentBuild.intent;
            intent.addFlags(BasicMeasure.EXACTLY);
            intent.addFlags(268435456);
            customTabsIntentBuild.launchUrl(activity, uri);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", uri);
        ResolveInfo resolveInfoResolveActivity = activity.getPackageManager().resolveActivity(intent2, 0);
        intent2.addFlags(BasicMeasure.EXACTLY);
        intent2.addFlags(268435456);
        if (resolveInfoResolveActivity != null) {
            activity.startActivity(intent2);
        } else {
            Logging.loge("Device cannot resolve intent for: android.intent.action.VIEW");
        }
    }

    private void loadNullableImage(Activity activity, BindingWrapper bindingWrapper, ImageData imageData, FiamImageLoader.Callback callback) {
        if (isValidImageData(imageData)) {
            this.imageLoader.load(imageData.getImageUrl()).addErrorListener(new GlideErrorListener(this.inAppMessage, this.callbacks)).tag(activity.getClass()).placeholder(R.drawable.image_placeholder).into(bindingWrapper.getImageView(), callback);
        } else {
            callback.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFiamClick() {
        FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamClick();
        }
    }

    private void notifyFiamDismiss() {
        FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamDismiss();
        }
    }

    private void notifyFiamTrigger() {
        FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamTrigger();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDisplayedFiam(Activity activity) {
        if (this.windowManager.isFiamDisplayed()) {
            this.imageLoader.cancelTag(activity.getClass());
            this.windowManager.destroy(activity);
            cancelTimers();
        }
    }

    private void setInAppMessageAndCallbacks(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        this.inAppMessage = inAppMessage;
        this.callbacks = firebaseInAppMessagingDisplayCallbacks;
    }

    private void showActiveFiam(@NonNull final Activity activity) {
        final BindingWrapper bindingWrapperCreateBannerBindingWrapper;
        if (this.inAppMessage == null || this.headlessInAppMessaging.areMessagesSuppressed()) {
            Logging.loge("No active message found to render");
            return;
        }
        if (this.inAppMessage.getMessageType().equals(MessageType.UNSUPPORTED)) {
            Logging.loge("The message being triggered is not supported by this version of the sdk.");
            return;
        }
        notifyFiamTrigger();
        InAppMessageLayoutConfig inAppMessageLayoutConfig = (InAppMessageLayoutConfig) this.layoutConfigs.get(InflaterConfigModule.configFor(this.inAppMessage.getMessageType(), getScreenOrientation(this.application))).get();
        int i2 = AnonymousClass5.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[this.inAppMessage.getMessageType().ordinal()];
        if (i2 == 1) {
            bindingWrapperCreateBannerBindingWrapper = this.bindingWrapperFactory.createBannerBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        } else if (i2 == 2) {
            bindingWrapperCreateBannerBindingWrapper = this.bindingWrapperFactory.createModalBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        } else if (i2 == 3) {
            bindingWrapperCreateBannerBindingWrapper = this.bindingWrapperFactory.createImageBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        } else {
            if (i2 != 4) {
                Logging.loge("No bindings found for this message type");
                return;
            }
            bindingWrapperCreateBannerBindingWrapper = this.bindingWrapperFactory.createCardBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        }
        activity.findViewById(android.R.id.content).post(new Runnable() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.1
            @Override // java.lang.Runnable
            public void run() {
                FirebaseInAppMessagingDisplay.this.inflateBinding(activity, bindingWrapperCreateBannerBindingWrapper);
            }
        });
    }

    private boolean supportsCustomTabs(Activity activity) {
        Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        intent.setPackage("com.android.chrome");
        List<ResolveInfo> listQueryIntentServices = activity.getPackageManager().queryIntentServices(intent, 0);
        return (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) ? false : true;
    }

    private void unbindFiamFromActivity(Activity activity) {
        String str = this.currentlyBoundActivityName;
        if (str == null || !str.equals(activity.getLocalClassName())) {
            return;
        }
        Logging.logi("Unbinding from activity: " + activity.getLocalClassName());
        this.headlessInAppMessaging.clearDisplayListener();
        removeDisplayedFiam(activity);
        this.currentlyBoundActivityName = null;
    }

    public void clearFiamListener() {
        this.fiamListener = null;
    }

    @VisibleForTesting
    public InAppMessage getCurrentInAppMessage() {
        return this.inAppMessage;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        unbindFiamFromActivity(activity);
        this.headlessInAppMessaging.removeAllListeners();
        super.onActivityPaused(activity);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        bindFiamToActivity(activity);
    }

    public void setFiamListener(FiamListener fiamListener) {
        this.fiamListener = fiamListener;
    }

    public void testMessage(Activity activity, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        setInAppMessageAndCallbacks(inAppMessage, firebaseInAppMessagingDisplayCallbacks);
        showActiveFiam(activity);
    }
}
