package com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl;

import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadgeException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class SonyHomeBadger implements Badger {
    private static final String INTENT_ACTION = "com.sonyericsson.home.action.UPDATE_BADGE";
    private static final String INTENT_EXTRA_ACTIVITY_NAME = "com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME";
    private static final String INTENT_EXTRA_MESSAGE = "com.sonyericsson.home.intent.extra.badge.MESSAGE";
    private static final String INTENT_EXTRA_PACKAGE_NAME = "com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME";
    private static final String INTENT_EXTRA_SHOW_MESSAGE = "com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE";
    private static final String PROVIDER_COLUMNS_ACTIVITY_NAME = "activity_name";
    private static final String PROVIDER_COLUMNS_BADGE_COUNT = "badge_count";
    private static final String PROVIDER_COLUMNS_PACKAGE_NAME = "package_name";
    private static final String PROVIDER_CONTENT_URI = "content://com.sonymobile.home.resourceprovider/badge";
    private static final String SONY_HOME_PROVIDER_NAME = "com.sonymobile.home.resourceprovider";
    private final Uri BADGE_CONTENT_URI = Uri.parse(PROVIDER_CONTENT_URI);
    private AsyncQueryHandler mQueryHandler;

    private ContentValues createContentValues(int i2, ComponentName componentName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROVIDER_COLUMNS_BADGE_COUNT, Integer.valueOf(i2));
        contentValues.put("package_name", componentName.getPackageName());
        contentValues.put(PROVIDER_COLUMNS_ACTIVITY_NAME, componentName.getClassName());
        return contentValues;
    }

    private static void executeBadgeByBroadcast(Context context, ComponentName componentName, int i2) {
        Intent intent = new Intent(INTENT_ACTION);
        intent.putExtra(INTENT_EXTRA_PACKAGE_NAME, componentName.getPackageName());
        intent.putExtra(INTENT_EXTRA_ACTIVITY_NAME, componentName.getClassName());
        intent.putExtra(INTENT_EXTRA_MESSAGE, String.valueOf(i2));
        intent.putExtra(INTENT_EXTRA_SHOW_MESSAGE, i2 > 0);
        context.sendBroadcast(intent);
    }

    private void executeBadgeByContentProvider(Context context, ComponentName componentName, int i2) {
        if (i2 < 0) {
            return;
        }
        ContentValues contentValuesCreateContentValues = createContentValues(i2, componentName);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            insertBadgeSync(context, contentValuesCreateContentValues);
            return;
        }
        if (this.mQueryHandler == null) {
            this.mQueryHandler = new AsyncQueryHandler(context.getApplicationContext().getContentResolver()) { // from class: com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.SonyHomeBadger.1
            };
        }
        insertBadgeAsync(contentValuesCreateContentValues);
    }

    private void insertBadgeAsync(ContentValues contentValues) {
        this.mQueryHandler.startInsert(0, null, this.BADGE_CONTENT_URI, contentValues);
    }

    private void insertBadgeSync(Context context, ContentValues contentValues) {
        context.getApplicationContext().getContentResolver().insert(this.BADGE_CONTENT_URI, contentValues);
    }

    private static boolean sonyBadgeContentProviderExists(Context context) {
        return context.getPackageManager().resolveContentProvider(SONY_HOME_PROVIDER_NAME, 0) != null;
    }

    @Override // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public void executeBadge(Context context, ComponentName componentName, int i2) throws ShortcutBadgeException {
        if (sonyBadgeContentProviderExists(context)) {
            executeBadgeByContentProvider(context, componentName, i2);
        } else {
            executeBadgeByBroadcast(context, componentName, i2);
        }
    }

    @Override // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public List<String> getSupportLaunchers() {
        return Arrays.asList("com.sonyericsson.home", "com.sonymobile.home");
    }
}
