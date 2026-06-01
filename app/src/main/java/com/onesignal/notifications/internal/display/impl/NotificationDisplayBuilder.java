package com.onesignal.notifications.internal.display.impl;

import android.R;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.ironsource.C2300e4;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.bundle.impl.NotificationBundleProcessor;
import com.onesignal.notifications.internal.channels.INotificationChannelManager;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.display.INotificationDisplayBuilder;
import com.onesignal.notifications.receivers.NotificationDismissReceiver;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.k;
import n6.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationDisplayBuilder implements INotificationDisplayBuilder {
    private final IApplicationService _applicationService;
    private final INotificationChannelManager _notificationChannelManager;
    private final Class<?> notificationDismissedClass;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class OneSignalNotificationBuilder {
        private NotificationCompat.Builder compatBuilder;
        private boolean hasLargeIcon;

        public final NotificationCompat.Builder getCompatBuilder() {
            return this.compatBuilder;
        }

        public final boolean getHasLargeIcon() {
            return this.hasLargeIcon;
        }

        public final void setCompatBuilder(NotificationCompat.Builder builder) {
            this.compatBuilder = builder;
        }

        public final void setHasLargeIcon(boolean z2) {
            this.hasLargeIcon = z2;
        }
    }

    public NotificationDisplayBuilder(IApplicationService _applicationService, INotificationChannelManager _notificationChannelManager) {
        k.e(_applicationService, "_applicationService");
        k.e(_notificationChannelManager, "_notificationChannelManager");
        this._applicationService = _applicationService;
        this._notificationChannelManager = _notificationChannelManager;
        this.notificationDismissedClass = NotificationDismissReceiver.class;
    }

    private final void addAlertButtons(Context context, JSONObject jSONObject, List<String> list, List<String> list2) {
        try {
            addCustomAlertButtons(jSONObject, list, list2);
        } catch (Throwable th) {
            Logging.error("Failed to parse JSON for custom buttons for alert dialog.", th);
        }
        if (list.size() == 0 || list.size() < 3) {
            String resourceString = AndroidUtils.INSTANCE.getResourceString(context, "onesignal_in_app_alert_ok_button_text", "Ok");
            k.b(resourceString);
            list.add(resourceString);
            list2.add(NotificationBundleProcessor.DEFAULT_ACTION);
        }
    }

    private final void addCustomAlertButtons(JSONObject jSONObject, List<String> list, List<String> list2) throws JSONException {
        JSONObject jSONObject2 = new JSONObject(jSONObject.optString(NotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM));
        if (jSONObject2.has("a")) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("a");
            if (jSONObject3.has("actionButtons")) {
                JSONArray jSONArrayOptJSONArray = jSONObject3.optJSONArray("actionButtons");
                int length = jSONArrayOptJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject4 = jSONArrayOptJSONArray.getJSONObject(i2);
                    String strOptString = jSONObject4.optString(C2300e4.h.K0);
                    k.d(strOptString, "button.optString(\"text\")");
                    list.add(strOptString);
                    String strOptString2 = jSONObject4.optString("id");
                    k.d(strOptString2, "button.optString(\"id\")");
                    list2.add(strOptString2);
                }
            }
        }
    }

    private final int convertOSToAndroidPriority(int i2) {
        if (i2 > 9) {
            return 2;
        }
        if (i2 > 7) {
            return 1;
        }
        if (i2 > 4) {
            return 0;
        }
        return i2 > 2 ? -1 : -2;
    }

    private final BigInteger getAccentColor(JSONObject jSONObject) {
        try {
            if (jSONObject.has("bgac")) {
                return new BigInteger(jSONObject.optString("bgac", null), 16);
            }
        } catch (Throwable unused) {
        }
        try {
            String resourceString = AndroidUtils.INSTANCE.getResourceString(this._applicationService.getAppContext(), "onesignal_notification_accent_color", null);
            if (resourceString != null) {
                return new BigInteger(resourceString, 16);
            }
        } catch (Throwable unused2) {
        }
        try {
            String manifestMeta = AndroidUtils.INSTANCE.getManifestMeta(this._applicationService.getAppContext(), "com.onesignal.NotificationAccentColor.DEFAULT");
            if (manifestMeta != null) {
                return new BigInteger(manifestMeta, 16);
            }
        } catch (Throwable unused3) {
        }
        return null;
    }

    private final Bitmap getBitmap(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            boolean z7 = k.g(str.charAt(!z2 ? i2 : length), 32) <= 0;
            if (z2) {
                if (!z7) {
                    break;
                }
                length--;
            } else if (z7) {
                i2++;
            } else {
                z2 = true;
            }
        }
        String string = str.subSequence(i2, length + 1).toString();
        return (t.n0(string, "http://", false) || t.n0(string, "https://", false)) ? getBitmapFromURL(string) : getBitmapFromAssetsOrResourceName(str);
    }

    private final Bitmap getBitmapFromAssetsOrResourceName(String str) {
        Bitmap bitmapDecodeStream;
        try {
            Context currentContext = getCurrentContext();
            k.b(currentContext);
            bitmapDecodeStream = BitmapFactory.decodeStream(currentContext.getAssets().open(str));
        } catch (Throwable unused) {
            bitmapDecodeStream = null;
        }
        if (bitmapDecodeStream != null) {
            return bitmapDecodeStream;
        }
        try {
            for (String str2 : Arrays.asList(".png", ".webp", ".jpg", ".gif", ".bmp")) {
                try {
                    Context currentContext2 = getCurrentContext();
                    k.b(currentContext2);
                    bitmapDecodeStream = BitmapFactory.decodeStream(currentContext2.getAssets().open(str + str2));
                } catch (Throwable unused2) {
                }
                if (bitmapDecodeStream != null) {
                    return bitmapDecodeStream;
                }
            }
            int resourceIcon = getResourceIcon(str);
            if (resourceIcon != 0) {
                return BitmapFactory.decodeResource(getContextResources(), resourceIcon);
            }
        } catch (Throwable unused3) {
        }
        return null;
    }

    private final Bitmap getBitmapFromURL(String str) {
        try {
            return BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        } catch (Throwable th) {
            Logging.warn("Could not download image!", th);
            return null;
        }
    }

    private final Resources getContextResources() {
        return this._applicationService.getAppContext().getResources();
    }

    private final Context getCurrentContext() {
        return this._applicationService.getAppContext();
    }

    private final int getDrawableId(String str) {
        Resources contextResources = getContextResources();
        k.b(contextResources);
        return contextResources.getIdentifier(str, "drawable", getPackageName());
    }

    private final Bitmap getLargeIcon(JSONObject jSONObject) {
        Bitmap bitmap = getBitmap(jSONObject.optString("licon"));
        if (bitmap == null) {
            bitmap = getBitmapFromAssetsOrResourceName("ic_onesignal_large_icon_default");
        }
        if (bitmap == null) {
            return null;
        }
        return resizeBitmapForLargeIconArea(bitmap);
    }

    private final String getPackageName() {
        return this._applicationService.getAppContext().getPackageName();
    }

    private final int getResourceIcon(String str) {
        if (str == null) {
            return 0;
        }
        int length = str.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            boolean z7 = k.g(str.charAt(!z2 ? i2 : length), 32) <= 0;
            if (z2) {
                if (!z7) {
                    break;
                }
                length--;
            } else if (z7) {
                i2++;
            } else {
                z2 = true;
            }
        }
        String string = str.subSequence(i2, length + 1).toString();
        if (!AndroidUtils.INSTANCE.isValidResourceName(string)) {
            return 0;
        }
        int drawableId = getDrawableId(string);
        if (drawableId != 0) {
            return drawableId;
        }
        try {
            return R.drawable.class.getField(str).getInt(null);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private final int getSmallIconId(JSONObject jSONObject) {
        int resourceIcon = getResourceIcon(jSONObject.optString("sicon", null));
        return resourceIcon != 0 ? resourceIcon : getDefaultSmallIconId();
    }

    private final boolean isSoundEnabled(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("sound", null);
        return ("null".equals(strOptString) || "nil".equals(strOptString)) ? false : true;
    }

    private final Bitmap resizeBitmapForLargeIconArea(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            Resources contextResources = getContextResources();
            k.b(contextResources);
            int dimension = (int) contextResources.getDimension(R.dimen.notification_large_icon_height);
            Resources contextResources2 = getContextResources();
            k.b(contextResources2);
            int dimension2 = (int) contextResources2.getDimension(R.dimen.notification_large_icon_width);
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            if (width <= dimension2 && height <= dimension) {
                return bitmap;
            }
            if (height > width) {
                dimension2 = (int) (dimension * (width / height));
            } else if (width > height) {
                dimension = (int) (dimension2 * (height / width));
            }
            return Bitmap.createScaledBitmap(bitmap, dimension2, dimension, true);
        } catch (Throwable unused) {
            return bitmap;
        }
    }

    private final void setAlertnessOptions(JSONObject jSONObject, NotificationCompat.Builder builder) {
        int iConvertOSToAndroidPriority = convertOSToAndroidPriority(jSONObject.optInt("pri", 6));
        builder.setPriority(iConvertOSToAndroidPriority);
        if (iConvertOSToAndroidPriority < 0) {
            return;
        }
        int i2 = 4;
        if (jSONObject.has("ledc") && jSONObject.optInt("led", 1) == 1) {
            try {
                builder.setLights(new BigInteger(jSONObject.optString("ledc"), 16).intValue(), 2000, 5000);
                i2 = 0;
            } catch (Throwable unused) {
            }
        }
        if (jSONObject.optInt("vib", 1) == 1) {
            if (jSONObject.has("vib_pt")) {
                long[] vibrationPattern = NotificationHelper.INSTANCE.parseVibrationPattern(jSONObject);
                if (vibrationPattern != null) {
                    builder.setVibrate(vibrationPattern);
                }
            } else {
                i2 |= 2;
            }
        }
        if (isSoundEnabled(jSONObject)) {
            NotificationHelper notificationHelper = NotificationHelper.INSTANCE;
            Context currentContext = getCurrentContext();
            k.b(currentContext);
            Uri soundUri = notificationHelper.getSoundUri(currentContext, jSONObject.optString("sound", null));
            if (soundUri != null) {
                builder.setSound(soundUri);
            } else {
                i2 |= 1;
            }
        }
        builder.setDefaults(i2);
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public void addNotificationActionButtons(JSONObject fcmJson, IntentGeneratorForAttachingToNotifications intentGenerator, NotificationCompat.Builder builder, int i2, String str) {
        k.e(fcmJson, "fcmJson");
        k.e(intentGenerator, "intentGenerator");
        try {
            JSONObject jSONObject = new JSONObject(fcmJson.optString(NotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM));
            if (jSONObject.has("a")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("a");
                if (jSONObject2.has("actionButtons")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("actionButtons");
                    int length = jSONArray.length();
                    for (int i8 = 0; i8 < length; i8++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i8);
                        JSONObject jSONObject3 = new JSONObject(fcmJson.toString());
                        Intent newBaseIntent = intentGenerator.getNewBaseIntent(i2);
                        newBaseIntent.setAction("" + i8);
                        newBaseIntent.putExtra("action_button", true);
                        jSONObject3.put(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID, jSONObjectOptJSONObject.optString("id"));
                        newBaseIntent.putExtra(NotificationConstants.BUNDLE_KEY_ONESIGNAL_DATA, jSONObject3.toString());
                        if (str != null) {
                            newBaseIntent.putExtra("summary", str);
                        } else if (fcmJson.has("grp")) {
                            newBaseIntent.putExtra("grp", fcmJson.optString("grp"));
                        }
                        PendingIntent newActionPendingIntent = intentGenerator.getNewActionPendingIntent(i2, newBaseIntent);
                        int resourceIcon = jSONObjectOptJSONObject.has(C2300e4.h.H0) ? getResourceIcon(jSONObjectOptJSONObject.optString(C2300e4.h.H0)) : 0;
                        k.b(builder);
                        builder.addAction(resourceIcon, jSONObjectOptJSONObject.optString(C2300e4.h.K0), newActionPendingIntent);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public void addXiaomiSettings(OneSignalNotificationBuilder oneSignalNotificationBuilder, Notification notification) {
        k.e(notification, "notification");
        k.b(oneSignalNotificationBuilder);
        if (oneSignalNotificationBuilder.getHasLargeIcon()) {
            try {
                Object objNewInstance = Class.forName("android.app.MiuiNotification").newInstance();
                Field declaredField = objNewInstance.getClass().getDeclaredField("customizedIcon");
                declaredField.setAccessible(true);
                declaredField.set(objNewInstance, Boolean.TRUE);
                Field field = notification.getClass().getField("extraNotification");
                field.setAccessible(true);
                field.set(notification, objNewInstance);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public OneSignalNotificationBuilder getBaseOneSignalNotificationBuilder(NotificationGenerationJob notificationJob) {
        int i2;
        k.e(notificationJob, "notificationJob");
        JSONObject jsonPayload = notificationJob.getJsonPayload();
        k.b(jsonPayload);
        OneSignalNotificationBuilder oneSignalNotificationBuilder = new OneSignalNotificationBuilder();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getCurrentContext(), this._notificationChannelManager.createNotificationChannel(notificationJob));
        String strOptString = jsonPayload.optString("alert", null);
        builder.setAutoCancel(true).setSmallIcon(getSmallIconId(jsonPayload)).setStyle(new NotificationCompat.BigTextStyle().bigText(strOptString)).setContentText(strOptString).setTicker(strOptString);
        if (Build.VERSION.SDK_INT < 24 || !k.a(jsonPayload.optString("title"), "")) {
            builder.setContentTitle(getTitle(jsonPayload));
        }
        try {
            BigInteger accentColor = getAccentColor(jsonPayload);
            if (accentColor != null) {
                builder.setColor(accentColor.intValue());
            }
        } catch (Throwable unused) {
        }
        try {
            if (jsonPayload.has("vis")) {
                String strOptString2 = jsonPayload.optString("vis");
                k.d(strOptString2, "fcmJson.optString(\"vis\")");
                i2 = Integer.parseInt(strOptString2);
            } else {
                i2 = 1;
            }
            builder.setVisibility(i2);
        } catch (Throwable unused2) {
        }
        Bitmap largeIcon = getLargeIcon(jsonPayload);
        if (largeIcon != null) {
            oneSignalNotificationBuilder.setHasLargeIcon(true);
            builder.setLargeIcon(largeIcon);
        }
        Bitmap bitmap = getBitmap(jsonPayload.optString("bicon", null));
        if (bitmap != null) {
            builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).setSummaryText(strOptString));
        }
        if (notificationJob.getShownTimeStamp() != null) {
            try {
                Long shownTimeStamp = notificationJob.getShownTimeStamp();
                k.b(shownTimeStamp);
                builder.setWhen(shownTimeStamp.longValue() * 1000);
            } catch (Throwable unused3) {
            }
        }
        setAlertnessOptions(jsonPayload, builder);
        oneSignalNotificationBuilder.setCompatBuilder(builder);
        return oneSignalNotificationBuilder;
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public Bitmap getDefaultLargeIcon() {
        return resizeBitmapForLargeIconArea(getBitmapFromAssetsOrResourceName("ic_onesignal_large_icon_default"));
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public int getDefaultSmallIconId() {
        int drawableId = getDrawableId("ic_stat_onesignal_default");
        if (drawableId != 0) {
            return drawableId;
        }
        int drawableId2 = getDrawableId("corona_statusbar_icon_default");
        if (drawableId2 != 0) {
            return drawableId2;
        }
        int drawableId3 = getDrawableId("ic_os_notification_fallback_white_24dp");
        return drawableId3 != 0 ? drawableId3 : R.drawable.ic_popup_reminder;
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public int getGroupAlertBehavior() {
        return Build.VERSION.SDK_INT >= 24 ? 2 : 1;
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public Intent getNewBaseDismissIntent(int i2) {
        Intent intentPutExtra = new Intent(getCurrentContext(), this.notificationDismissedClass).putExtra(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, i2).putExtra(OneSignalDbContract.NotificationTable.COLUMN_NAME_DISMISSED, true);
        k.d(intentPutExtra, "Intent(currentContext, n…tExtra(\"dismissed\", true)");
        return intentPutExtra;
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public PendingIntent getNewDismissActionPendingIntent(int i2, Intent intent) {
        k.e(intent, "intent");
        PendingIntent broadcast = PendingIntent.getBroadcast(getCurrentContext(), i2, intent, 201326592);
        k.d(broadcast, "getBroadcast(\n          …FLAG_IMMUTABLE,\n        )");
        return broadcast;
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public CharSequence getTitle(JSONObject fcmJson) {
        k.e(fcmJson, "fcmJson");
        String strOptString = fcmJson.optString("title", null);
        if (strOptString != null) {
            return strOptString;
        }
        Context currentContext = getCurrentContext();
        k.b(currentContext);
        PackageManager packageManager = currentContext.getPackageManager();
        Context currentContext2 = getCurrentContext();
        k.b(currentContext2);
        CharSequence applicationLabel = packageManager.getApplicationLabel(currentContext2.getApplicationInfo());
        k.d(applicationLabel, "currentContext!!.package…cationInfo,\n            )");
        return applicationLabel;
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayBuilder
    public void removeNotifyOptions(NotificationCompat.Builder builder) {
        k.b(builder);
        builder.setOnlyAlertOnce(true).setDefaults(0).setSound(null).setVibrate(null).setTicker(null);
    }
}
