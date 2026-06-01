package com.onesignal.notifications.internal.badges.impl;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import androidx.annotation.RequiresApi;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.badges.IBadgeCountUpdater;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadgeException;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadger;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationQueryHelper;
import com.onesignal.notifications.internal.limiting.INotificationLimitManager;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BadgeCountUpdater implements IBadgeCountUpdater {
    private final IApplicationService _applicationService;
    private final IDatabaseProvider _databaseProvider;
    private final INotificationQueryHelper _queryHelper;
    private int badgesEnabled;

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.badges.impl.BadgeCountUpdater$updateFallback$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        final /* synthetic */ y $notificationCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(y yVar) {
            super(1);
            this.$notificationCount = yVar;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ICursor) obj);
            return x.f13520a;
        }

        public final void invoke(ICursor it) {
            k.e(it, "it");
            this.$notificationCount.f12730a = it.getCount();
        }
    }

    public BadgeCountUpdater(IApplicationService _applicationService, INotificationQueryHelper _queryHelper, IDatabaseProvider _databaseProvider) {
        k.e(_applicationService, "_applicationService");
        k.e(_queryHelper, "_queryHelper");
        k.e(_databaseProvider, "_databaseProvider");
        this._applicationService = _applicationService;
        this._queryHelper = _queryHelper;
        this._databaseProvider = _databaseProvider;
        this.badgesEnabled = -1;
    }

    private final boolean areBadgeSettingsEnabled() {
        int i2 = this.badgesEnabled;
        if (i2 != -1) {
            return i2 == 1;
        }
        try {
            ApplicationInfo applicationInfo = this._applicationService.getAppContext().getPackageManager().getApplicationInfo(this._applicationService.getAppContext().getPackageName(), 128);
            k.d(applicationInfo, "_applicationService.appC…A_DATA,\n                )");
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                this.badgesEnabled = !"DISABLE".equals(bundle.getString("com.onesignal.BadgeCount")) ? 1 : 0;
            } else {
                this.badgesEnabled = 1;
            }
        } catch (PackageManager.NameNotFoundException e) {
            this.badgesEnabled = 0;
            Logging.error("Error reading meta-data tag 'com.onesignal.BadgeCount'. Disabling badge setting.", e);
        }
        return this.badgesEnabled == 1;
    }

    private final boolean areBadgesEnabled() {
        return areBadgeSettingsEnabled() && NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, this._applicationService.getAppContext(), null, 2, null);
    }

    private final void updateFallback() {
        y yVar = new y();
        IDatabase.DefaultImpls.query$default(this._databaseProvider.getOs(), OneSignalDbContract.NotificationTable.TABLE_NAME, null, this._queryHelper.recentUninteractedWithNotificationsWhere().toString(), null, null, null, null, String.valueOf(INotificationLimitManager.Constants.INSTANCE.getMaxNumberOfNotifications()), new AnonymousClass1(yVar), Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, null);
        updateCount(yVar.f12730a);
    }

    @RequiresApi(api = 23)
    private final void updateStandard() {
        int i2 = 0;
        for (StatusBarNotification statusBarNotification : NotificationHelper.INSTANCE.getActiveNotifications(this._applicationService.getAppContext())) {
            if (!NotificationHelper.INSTANCE.isGroupSummary(statusBarNotification)) {
                i2++;
            }
        }
        updateCount(i2);
    }

    @Override // com.onesignal.notifications.internal.badges.IBadgeCountUpdater
    public void update() {
        if (areBadgesEnabled()) {
            updateStandard();
        }
    }

    @Override // com.onesignal.notifications.internal.badges.IBadgeCountUpdater
    public void updateCount(int i2) {
        if (areBadgeSettingsEnabled()) {
            try {
                ShortcutBadger.applyCountOrThrow(this._applicationService.getAppContext(), i2);
            } catch (ShortcutBadgeException unused) {
            }
        }
    }
}
