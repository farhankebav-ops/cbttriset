package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NotificationTarget extends CustomTarget<Bitmap> {
    private final Context context;
    private final Notification notification;
    private final int notificationId;
    private final String notificationTag;
    private final RemoteViews remoteViews;
    private final int viewId;

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public NotificationTarget(Context context, int i2, RemoteViews remoteViews, Notification notification, int i8) {
        this(context, i2, remoteViews, notification, i8, null);
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    private void setBitmap(@Nullable Bitmap bitmap) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    private void update() {
        ((NotificationManager) Preconditions.checkNotNull((NotificationManager) this.context.getSystemService(OneSignalDbContract.NotificationTable.TABLE_NAME))).notify(this.notificationTag, this.notificationId, this.notification);
    }

    @Override // com.bumptech.glide.request.target.Target
    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void onLoadCleared(@Nullable Drawable drawable) {
        setBitmap(null);
    }

    @Override // com.bumptech.glide.request.target.Target
    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public NotificationTarget(Context context, int i2, RemoteViews remoteViews, Notification notification, int i8, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, notification, i8, str);
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
        setBitmap(bitmap);
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public NotificationTarget(Context context, int i2, int i8, int i9, RemoteViews remoteViews, Notification notification, int i10, String str) {
        super(i2, i8);
        this.context = (Context) Preconditions.checkNotNull(context, "Context must not be null!");
        this.notification = (Notification) Preconditions.checkNotNull(notification, "Notification object can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
        this.viewId = i9;
        this.notificationId = i10;
        this.notificationTag = str;
    }
}
