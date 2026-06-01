package com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadgeException;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.util.CloseHelper;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class SamsungHomeBadger implements Badger {
    private static final String[] CONTENT_PROJECTION = {"_id", "class"};
    private static final String CONTENT_URI = "content://com.sec.badge/apps?notify=true";
    private DefaultBadger defaultBadger = new DefaultBadger();

    private ContentValues getContentValues(ComponentName componentName, int i2, boolean z2) {
        ContentValues contentValues = new ContentValues();
        if (z2) {
            contentValues.put("package", componentName.getPackageName());
            contentValues.put("class", componentName.getClassName());
        }
        contentValues.put("badgecount", Integer.valueOf(i2));
        return contentValues;
    }

    @Override // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public void executeBadge(Context context, ComponentName componentName, int i2) throws ShortcutBadgeException {
        DefaultBadger defaultBadger = this.defaultBadger;
        if (defaultBadger != null && defaultBadger.isSupported(context)) {
            this.defaultBadger.executeBadge(context, componentName, i2);
            return;
        }
        Uri uri = Uri.parse(CONTENT_URI);
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = null;
        try {
            cursorQuery = contentResolver.query(uri, CONTENT_PROJECTION, "package=?", new String[]{componentName.getPackageName()}, null);
            if (cursorQuery != null) {
                String className = componentName.getClassName();
                boolean z2 = false;
                while (cursorQuery.moveToNext()) {
                    contentResolver.update(uri, getContentValues(componentName, i2, false), "_id=?", new String[]{String.valueOf(cursorQuery.getInt(0))});
                    if (className.equals(cursorQuery.getString(cursorQuery.getColumnIndex("class")))) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    contentResolver.insert(uri, getContentValues(componentName, i2, true));
                }
            }
            CloseHelper.close(cursorQuery);
        } catch (Throwable th) {
            CloseHelper.close(cursorQuery);
            throw th;
        }
    }

    @Override // com.onesignal.notifications.internal.badges.impl.shortcutbadger.Badger
    public List<String> getSupportLaunchers() {
        return Arrays.asList("com.sec.android.app.launcher", "com.sec.android.app.twlauncher");
    }
}
