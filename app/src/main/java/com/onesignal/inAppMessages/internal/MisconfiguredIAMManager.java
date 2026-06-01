package com.onesignal.inAppMessages.internal;

import com.onesignal.core.internal.minification.KeepStub;
import com.onesignal.inAppMessages.IInAppMessageClickListener;
import com.onesignal.inAppMessages.IInAppMessageLifecycleListener;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@KeepStub
public final class MisconfiguredIAMManager implements IInAppMessagesManager {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Exception getEXCEPTION() {
            return new Exception("Must include gradle module com.onesignal:InAppMessages in order to use this functionality!");
        }

        private Companion() {
        }
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: addTriggers, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo3149addTriggers(Map map) throws Exception {
        addTriggers((Map<String, String>) map);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    public boolean getPaused() throws Exception {
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: removeTriggers, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void mo3154removeTriggers(Collection collection) throws Exception {
        removeTriggers((Collection<String>) collection);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    public void setPaused(boolean z2) throws Exception {
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: addClickListener, reason: merged with bridge method [inline-methods] */
    public Void mo3146addClickListener(IInAppMessageClickListener listener) throws Exception {
        k.e(listener, "listener");
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: addLifecycleListener, reason: merged with bridge method [inline-methods] */
    public Void mo3147addLifecycleListener(IInAppMessageLifecycleListener listener) throws Exception {
        k.e(listener, "listener");
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: addTrigger, reason: merged with bridge method [inline-methods] */
    public Void mo3148addTrigger(String key, String value) throws Exception {
        k.e(key, "key");
        k.e(value, "value");
        throw Companion.getEXCEPTION();
    }

    public Void addTriggers(Map<String, String> triggers) throws Exception {
        k.e(triggers, "triggers");
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: clearTriggers, reason: merged with bridge method [inline-methods] */
    public Void mo3150clearTriggers() throws Exception {
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: removeClickListener, reason: merged with bridge method [inline-methods] */
    public Void mo3151removeClickListener(IInAppMessageClickListener listener) throws Exception {
        k.e(listener, "listener");
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: removeLifecycleListener, reason: merged with bridge method [inline-methods] */
    public Void mo3152removeLifecycleListener(IInAppMessageLifecycleListener listener) throws Exception {
        k.e(listener, "listener");
        throw Companion.getEXCEPTION();
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: removeTrigger, reason: merged with bridge method [inline-methods] */
    public Void mo3153removeTrigger(String key) throws Exception {
        k.e(key, "key");
        throw Companion.getEXCEPTION();
    }

    public Void removeTriggers(Collection<String> keys) throws Exception {
        k.e(keys, "keys");
        throw Companion.getEXCEPTION();
    }
}
