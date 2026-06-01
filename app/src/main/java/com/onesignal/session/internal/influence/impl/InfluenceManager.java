package com.onesignal.session.internal.influence.impl;

import com.onesignal.common.JSONUtils;
import com.onesignal.core.internal.application.AppEntryAction;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.session.internal.influence.Influence;
import com.onesignal.session.internal.influence.InfluenceType;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;
import n6.n;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InfluenceManager implements IInfluenceManager, ISessionLifecycleHandler {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final ISessionService _sessionService;
    private final InfluenceDataRepository dataRepository;
    private final ConcurrentHashMap<String, ChannelTracker> trackers;

    public InfluenceManager(ISessionService _sessionService, IApplicationService _applicationService, ConfigModelStore _configModelStore, IPreferencesService preferences, ITime timeProvider) {
        k.e(_sessionService, "_sessionService");
        k.e(_applicationService, "_applicationService");
        k.e(_configModelStore, "_configModelStore");
        k.e(preferences, "preferences");
        k.e(timeProvider, "timeProvider");
        this._sessionService = _sessionService;
        this._applicationService = _applicationService;
        this._configModelStore = _configModelStore;
        ConcurrentHashMap<String, ChannelTracker> concurrentHashMap = new ConcurrentHashMap<>();
        this.trackers = concurrentHashMap;
        InfluenceDataRepository influenceDataRepository = new InfluenceDataRepository(preferences, _configModelStore);
        this.dataRepository = influenceDataRepository;
        InfluenceConstants influenceConstants = InfluenceConstants.INSTANCE;
        concurrentHashMap.put(influenceConstants.getIAM_TAG(), new InAppMessageTracker(influenceDataRepository, timeProvider));
        concurrentHashMap.put(influenceConstants.getNOTIFICATION_TAG(), new NotificationTracker(influenceDataRepository, timeProvider));
        _sessionService.subscribe(this);
        Collection<ChannelTracker> collectionValues = concurrentHashMap.values();
        k.d(collectionValues, "trackers.values");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((ChannelTracker) it.next()).initInfluencedTypeFromCache();
        }
    }

    private final void attemptSessionUpgrade(AppEntryAction appEntryAction, String str) {
        boolean sessionTracker;
        Influence currentSessionInfluence;
        Logging.debug$default("InfluenceManager.attemptSessionUpgrade(entryAction: " + appEntryAction + ", directId: " + str + ')', null, 2, null);
        IChannelTracker channelByEntryAction = getChannelByEntryAction(appEntryAction);
        List<IChannelTracker> channelsToResetByEntryAction = getChannelsToResetByEntryAction(appEntryAction);
        ArrayList arrayList = new ArrayList();
        if (channelByEntryAction != null) {
            currentSessionInfluence = channelByEntryAction.getCurrentSessionInfluence();
            InfluenceType influenceType = InfluenceType.DIRECT;
            if (str == null) {
                str = channelByEntryAction.getDirectId();
            }
            sessionTracker = setSessionTracker(channelByEntryAction, influenceType, str, null);
        } else {
            sessionTracker = false;
            currentSessionInfluence = null;
        }
        if (sessionTracker) {
            Logging.debug$default("InfluenceManager.attemptSessionUpgrade: channel updated, search for ending direct influences on channels: " + channelsToResetByEntryAction, null, 2, null);
            k.b(currentSessionInfluence);
            arrayList.add(currentSessionInfluence);
            for (IChannelTracker iChannelTracker : channelsToResetByEntryAction) {
                InfluenceType influenceType2 = iChannelTracker.getInfluenceType();
                if (influenceType2 != null && influenceType2.isDirect()) {
                    arrayList.add(iChannelTracker.getCurrentSessionInfluence());
                    iChannelTracker.resetAndInitInfluence();
                }
            }
        }
        Logging.debug$default("InfluenceManager.attemptSessionUpgrade: try UNATTRIBUTED to INDIRECT upgrade", null, 2, null);
        for (IChannelTracker iChannelTracker2 : channelsToResetByEntryAction) {
            InfluenceType influenceType3 = iChannelTracker2.getInfluenceType();
            if (influenceType3 != null && influenceType3.isUnattributed()) {
                JSONArray lastReceivedIds = iChannelTracker2.getLastReceivedIds();
                if (lastReceivedIds.length() > 0 && !appEntryAction.isAppClose()) {
                    Influence currentSessionInfluence2 = iChannelTracker2.getCurrentSessionInfluence();
                    if (setSessionTracker(iChannelTracker2, InfluenceType.INDIRECT, null, lastReceivedIds)) {
                        arrayList.add(currentSessionInfluence2);
                    }
                }
            }
        }
        Logging.debug$default("InfluenceManager.attemptSessionUpgrade: Trackers after update attempt: " + getChannels(), null, 2, null);
    }

    public static /* synthetic */ void attemptSessionUpgrade$default(InfluenceManager influenceManager, AppEntryAction appEntryAction, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        influenceManager.attemptSessionUpgrade(appEntryAction, str);
    }

    private final IChannelTracker getChannelByEntryAction(AppEntryAction appEntryAction) {
        if (appEntryAction.isNotificationClick()) {
            return getNotificationChannelTracker();
        }
        return null;
    }

    private final List<IChannelTracker> getChannels() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getNotificationChannelTracker());
        arrayList.add(getIAMChannelTracker());
        return arrayList;
    }

    private final List<IChannelTracker> getChannelsToResetByEntryAction(AppEntryAction appEntryAction) {
        ArrayList arrayList = new ArrayList();
        if (appEntryAction.isAppClose()) {
            return arrayList;
        }
        IChannelTracker notificationChannelTracker = appEntryAction.isAppOpen() ? getNotificationChannelTracker() : null;
        if (notificationChannelTracker != null) {
            arrayList.add(notificationChannelTracker);
        }
        arrayList.add(getIAMChannelTracker());
        return arrayList;
    }

    private final IChannelTracker getIAMChannelTracker() {
        ChannelTracker channelTracker = this.trackers.get(InfluenceConstants.INSTANCE.getIAM_TAG());
        k.b(channelTracker);
        return channelTracker;
    }

    private final IChannelTracker getNotificationChannelTracker() {
        ChannelTracker channelTracker = this.trackers.get(InfluenceConstants.INSTANCE.getNOTIFICATION_TAG());
        k.b(channelTracker);
        return channelTracker;
    }

    private final void restartSessionTrackersIfNeeded(AppEntryAction appEntryAction) {
        List<IChannelTracker> channelsToResetByEntryAction = getChannelsToResetByEntryAction(appEntryAction);
        ArrayList arrayList = new ArrayList();
        Logging.debug$default("InfluenceManager.restartSessionIfNeeded(entryAction: " + appEntryAction + "):\n channelTrackers: " + channelsToResetByEntryAction, null, 2, null);
        for (IChannelTracker iChannelTracker : channelsToResetByEntryAction) {
            JSONArray lastReceivedIds = iChannelTracker.getLastReceivedIds();
            Logging.debug$default("InfluenceManager.restartSessionIfNeeded: lastIds: " + lastReceivedIds, null, 2, null);
            Influence currentSessionInfluence = iChannelTracker.getCurrentSessionInfluence();
            if (lastReceivedIds.length() > 0 ? setSessionTracker(iChannelTracker, InfluenceType.INDIRECT, null, lastReceivedIds) : setSessionTracker(iChannelTracker, InfluenceType.UNATTRIBUTED, null, null)) {
                arrayList.add(currentSessionInfluence);
            }
        }
    }

    private final boolean setSessionTracker(IChannelTracker iChannelTracker, InfluenceType influenceType, String str, JSONArray jSONArray) {
        if (!willChangeSessionTracker(iChannelTracker, influenceType, str, jSONArray)) {
            return false;
        }
        Logging.debug$default(n.b0("\n            ChannelTracker changed: " + iChannelTracker.getIdTag() + "\n            from:\n            influenceType: " + iChannelTracker.getInfluenceType() + ", directNotificationId: " + iChannelTracker.getDirectId() + ", indirectNotificationIds: " + iChannelTracker.getIndirectIds() + "\n            to:\n            influenceType: " + influenceType + ", directNotificationId: " + str + ", indirectNotificationIds: " + jSONArray + "\n            "), null, 2, null);
        iChannelTracker.setInfluenceType(influenceType);
        iChannelTracker.setDirectId(str);
        iChannelTracker.setIndirectIds(jSONArray);
        iChannelTracker.cacheState();
        StringBuilder sb = new StringBuilder("InfluenceManager.setSessionTracker: Trackers changed to: ");
        sb.append(getChannels());
        Logging.debug$default(sb.toString(), null, 2, null);
        return true;
    }

    private final boolean willChangeSessionTracker(IChannelTracker iChannelTracker, InfluenceType influenceType, String str, JSONArray jSONArray) {
        if (influenceType != iChannelTracker.getInfluenceType()) {
            return true;
        }
        InfluenceType influenceType2 = iChannelTracker.getInfluenceType();
        if (influenceType2 != null && influenceType2.isDirect() && iChannelTracker.getDirectId() != null && !k.a(iChannelTracker.getDirectId(), str)) {
            return true;
        }
        if (influenceType2 == null || !influenceType2.isIndirect() || iChannelTracker.getIndirectIds() == null) {
            return false;
        }
        JSONArray indirectIds = iChannelTracker.getIndirectIds();
        k.b(indirectIds);
        return indirectIds.length() > 0 && !JSONUtils.INSTANCE.compareJSONArrays(iChannelTracker.getIndirectIds(), jSONArray);
    }

    @Override // com.onesignal.session.internal.influence.IInfluenceManager
    public List<Influence> getInfluences() {
        Collection<ChannelTracker> collectionValues = this.trackers.values();
        k.d(collectionValues, "trackers.values");
        ArrayList arrayList = new ArrayList(r5.n.L0(collectionValues, 10));
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList.add(((ChannelTracker) it.next()).getCurrentSessionInfluence());
        }
        return arrayList;
    }

    @Override // com.onesignal.session.internal.influence.IInfluenceManager
    public void onDirectInfluenceFromIAM(String messageId) {
        k.e(messageId, "messageId");
        Logging.debug$default("InfluenceManager.onDirectInfluenceFromIAM(messageId: " + messageId + ')', null, 2, null);
        setSessionTracker(getIAMChannelTracker(), InfluenceType.DIRECT, messageId, null);
    }

    @Override // com.onesignal.session.internal.influence.IInfluenceManager
    public void onDirectInfluenceFromNotification(String notificationId) {
        k.e(notificationId, "notificationId");
        Logging.debug$default("InfluenceManager.onDirectInfluenceFromNotification(notificationId: " + notificationId + ')', null, 2, null);
        if (notificationId.length() == 0) {
            return;
        }
        attemptSessionUpgrade(AppEntryAction.NOTIFICATION_CLICK, notificationId);
    }

    @Override // com.onesignal.session.internal.influence.IInfluenceManager
    public void onInAppMessageDismissed() {
        Logging.debug$default("InfluenceManager.onInAppMessageDismissed()", null, 2, null);
        getIAMChannelTracker().resetAndInitInfluence();
    }

    @Override // com.onesignal.session.internal.influence.IInfluenceManager
    public void onInAppMessageDisplayed(String messageId) {
        k.e(messageId, "messageId");
        Logging.debug$default("InfluenceManager.onInAppMessageReceived(messageId: " + messageId + ')', null, 2, null);
        IChannelTracker iAMChannelTracker = getIAMChannelTracker();
        iAMChannelTracker.saveLastId(messageId);
        iAMChannelTracker.resetAndInitInfluence();
    }

    @Override // com.onesignal.session.internal.influence.IInfluenceManager
    public void onNotificationReceived(String notificationId) {
        k.e(notificationId, "notificationId");
        Logging.debug$default("InfluenceManager.onNotificationReceived(notificationId: " + notificationId + ')', null, 2, null);
        if (notificationId.length() == 0) {
            return;
        }
        getNotificationChannelTracker().saveLastId(notificationId);
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionActive() {
        attemptSessionUpgrade$default(this, this._applicationService.getEntryState(), null, 2, null);
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionStarted() {
        restartSessionTrackersIfNeeded(this._applicationService.getEntryState());
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionEnded(long j) {
    }
}
