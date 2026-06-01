package com.onesignal.notifications.internal.display.impl;

import android.R;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.exceptions.MainThreadException;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.R;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.display.INotificationDisplayBuilder;
import com.onesignal.notifications.internal.display.INotificationDisplayer;
import com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer;
import com.onesignal.notifications.internal.limiting.INotificationLimitManager;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import n6.t;
import org.json.JSONObject;
import q5.x;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationDisplayer implements INotificationDisplayer {
    private final IApplicationService _applicationService;
    private final INotificationDisplayBuilder _notificationDisplayBuilder;
    private final INotificationLimitManager _notificationLimitManager;
    private final ISummaryNotificationDisplayer _summaryNotificationDisplayer;

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.display.impl.NotificationDisplayer$showNotification$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.display.impl.NotificationDisplayer", f = "NotificationDisplayer.kt", l = {Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 140}, m = "showNotification")
    public static final class AnonymousClass1 extends c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationDisplayer.this.showNotification(null, this);
        }
    }

    public NotificationDisplayer(IApplicationService _applicationService, INotificationLimitManager _notificationLimitManager, ISummaryNotificationDisplayer _summaryNotificationDisplayer, INotificationDisplayBuilder _notificationDisplayBuilder) {
        k.e(_applicationService, "_applicationService");
        k.e(_notificationLimitManager, "_notificationLimitManager");
        k.e(_summaryNotificationDisplayer, "_summaryNotificationDisplayer");
        k.e(_notificationDisplayBuilder, "_notificationDisplayBuilder");
        this._applicationService = _applicationService;
        this._notificationLimitManager = _notificationLimitManager;
        this._summaryNotificationDisplayer = _summaryNotificationDisplayer;
        this._notificationDisplayBuilder = _notificationDisplayBuilder;
    }

    private final void addBackgroundImage(JSONObject jSONObject, NotificationCompat.Builder builder) throws Throwable {
        Bitmap bitmapFromAssetsOrResourceName;
        JSONObject jSONObject2;
        String string;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            Logging.verbose$default("Cannot use background images in notifications for device on version: " + i2, null, 2, null);
            return;
        }
        String strOptString = jSONObject.optString("bg_img", null);
        if (strOptString != null) {
            JSONObject jSONObject3 = new JSONObject(strOptString);
            bitmapFromAssetsOrResourceName = getBitmap(jSONObject3.optString("img", null));
            jSONObject2 = jSONObject3;
        } else {
            bitmapFromAssetsOrResourceName = null;
            jSONObject2 = null;
        }
        if (bitmapFromAssetsOrResourceName == null) {
            bitmapFromAssetsOrResourceName = getBitmapFromAssetsOrResourceName("onesignal_bgimage_default_image");
        }
        if (bitmapFromAssetsOrResourceName != null) {
            Context currentContext = getCurrentContext();
            k.b(currentContext);
            RemoteViews remoteViews = new RemoteViews(currentContext.getPackageName(), R.layout.onesignal_bgimage_notif_layout);
            remoteViews.setTextViewText(R.id.os_bgimage_notif_title, this._notificationDisplayBuilder.getTitle(jSONObject));
            remoteViews.setTextViewText(R.id.os_bgimage_notif_body, jSONObject.optString("alert"));
            setTextColor(remoteViews, jSONObject2, R.id.os_bgimage_notif_title, "tc", "onesignal_bgimage_notif_title_color");
            setTextColor(remoteViews, jSONObject2, R.id.os_bgimage_notif_body, "bc", "onesignal_bgimage_notif_body_color");
            if (jSONObject2 == null || !jSONObject2.has("img_align")) {
                Resources contextResources = getContextResources();
                k.b(contextResources);
                int identifier = contextResources.getIdentifier("onesignal_bgimage_notif_image_align", TypedValues.Custom.S_STRING, getPackageName());
                if (identifier != 0) {
                    Resources contextResources2 = getContextResources();
                    k.b(contextResources2);
                    string = contextResources2.getString(identifier);
                } else {
                    string = null;
                }
            } else {
                string = jSONObject2.getString("img_align");
            }
            if ("right".equals(string)) {
                remoteViews.setViewPadding(R.id.os_bgimage_notif_bgimage_align_layout, -5000, 0, 0, 0);
                remoteViews.setImageViewBitmap(R.id.os_bgimage_notif_bgimage_right_aligned, bitmapFromAssetsOrResourceName);
                remoteViews.setViewVisibility(R.id.os_bgimage_notif_bgimage_right_aligned, 0);
                remoteViews.setViewVisibility(R.id.os_bgimage_notif_bgimage, 8);
            } else {
                remoteViews.setImageViewBitmap(R.id.os_bgimage_notif_bgimage, bitmapFromAssetsOrResourceName);
            }
            k.b(builder);
            builder.setContent(remoteViews);
            builder.setStyle(null);
        }
    }

    private final void applyNotificationExtender(NotificationGenerationJob notificationGenerationJob, NotificationCompat.Builder builder) {
        if (notificationGenerationJob.hasExtender()) {
            try {
                Field declaredField = NotificationCompat.Builder.class.getDeclaredField("mNotification");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(builder);
                k.c(obj, "null cannot be cast to non-null type android.app.Notification");
                Notification notification = (Notification) obj;
                notificationGenerationJob.setOrgFlags(Integer.valueOf(notification.flags));
                notificationGenerationJob.setOrgSound(notification.sound);
                k.b(builder);
                com.onesignal.notifications.internal.Notification notification2 = notificationGenerationJob.getNotification();
                k.b(notification2);
                NotificationCompat.Extender notificationExtender = notification2.getNotificationExtender();
                k.b(notificationExtender);
                builder.extend(notificationExtender);
                Object obj2 = declaredField.get(builder);
                k.c(obj2, "null cannot be cast to non-null type android.app.Notification");
                Notification notification3 = (Notification) obj2;
                Field declaredField2 = NotificationCompat.Builder.class.getDeclaredField("mContentText");
                declaredField2.setAccessible(true);
                CharSequence charSequence = (CharSequence) declaredField2.get(builder);
                Field declaredField3 = NotificationCompat.Builder.class.getDeclaredField("mContentTitle");
                declaredField3.setAccessible(true);
                CharSequence charSequence2 = (CharSequence) declaredField3.get(builder);
                notificationGenerationJob.setOverriddenBodyFromExtender(charSequence);
                notificationGenerationJob.setOverriddenTitleFromExtender(charSequence2);
                if (notificationGenerationJob.isRestoring()) {
                    return;
                }
                notificationGenerationJob.setOverriddenFlags(Integer.valueOf(notification3.flags));
                notificationGenerationJob.setOverriddenSound(notification3.sound);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private final Notification createGenericPendingIntentsForNotif(NotificationCompat.Builder builder, IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications, JSONObject jSONObject, int i2) {
        SecureRandom secureRandom = new SecureRandom();
        int iNextInt = secureRandom.nextInt();
        Intent intentPutExtra = intentGeneratorForAttachingToNotifications.getNewBaseIntent(i2).putExtra(NotificationConstants.BUNDLE_KEY_ONESIGNAL_DATA, jSONObject.toString());
        k.d(intentPutExtra, "intentGenerator.getNewBa…TA, gcmBundle.toString())");
        PendingIntent newActionPendingIntent = intentGeneratorForAttachingToNotifications.getNewActionPendingIntent(iNextInt, intentPutExtra);
        k.b(builder);
        builder.setContentIntent(newActionPendingIntent);
        builder.setDeleteIntent(this._notificationDisplayBuilder.getNewDismissActionPendingIntent(secureRandom.nextInt(), this._notificationDisplayBuilder.getNewBaseDismissIntent(i2)));
        Notification notificationBuild = builder.build();
        k.d(notificationBuild, "notifBuilder.build()");
        return notificationBuild;
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

    private final Integer safeGetColorFromHex(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.has(str)) {
                return Integer.valueOf(new BigInteger(jSONObject.optString(str), 16).intValue());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private final void setTextColor(RemoteViews remoteViews, JSONObject jSONObject, int i2, String str, String str2) {
        Integer numSafeGetColorFromHex = safeGetColorFromHex(jSONObject, str);
        if (numSafeGetColorFromHex != null) {
            remoteViews.setTextColor(i2, numSafeGetColorFromHex.intValue());
            return;
        }
        Resources contextResources = getContextResources();
        k.b(contextResources);
        int identifier = contextResources.getIdentifier(str2, "color", getPackageName());
        if (identifier != 0) {
            remoteViews.setTextColor(i2, ContextCompat.getColor(getCurrentContext(), identifier));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0170, code lost:
    
        if (r5.createGrouplessSummaryNotification(r5, r12, r7, r8, r9) == r3) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0173, code lost:
    
        r4 = r0;
        r5 = r2;
        r3 = r10;
        r2 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01a0, code lost:
    
        if (r4.createSummaryNotification(r5, r0, r6, r9) == r3) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object showNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob r24, v5.c<? super java.lang.Boolean> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.display.impl.NotificationDisplayer.showNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.notifications.internal.display.INotificationDisplayer
    public Object displayNotification(NotificationGenerationJob notificationGenerationJob, v5.c<? super Boolean> cVar) {
        isRunningOnMainThreadCheck();
        return showNotification(notificationGenerationJob, cVar);
    }

    public final x isRunningOnMainThreadCheck() {
        if (AndroidUtils.INSTANCE.isRunningOnMainThread()) {
            throw new MainThreadException("Process for showing a notification should never been done on Main Thread!");
        }
        return x.f13520a;
    }
}
