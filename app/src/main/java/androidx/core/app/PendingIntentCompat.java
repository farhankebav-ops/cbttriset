package androidx.core.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PendingIntentCompat {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static void send(@NonNull PendingIntent pendingIntent, @NonNull Context context, int i2, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
            pendingIntent.send(context, i2, intent, onFinished, handler, str, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static PendingIntent getForegroundService(Context context, int i2, Intent intent, int i8) {
            return PendingIntent.getForegroundService(context, i2, intent, i8);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface Flags {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class GatedCallback implements Closeable {

        @Nullable
        private PendingIntent.OnFinished mCallback;
        private final CountDownLatch mComplete = new CountDownLatch(1);
        private boolean mSuccess = false;

        public GatedCallback(@Nullable PendingIntent.OnFinished onFinished) {
            this.mCallback = onFinished;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i2, String str, Bundle bundle) {
            boolean z2 = false;
            while (true) {
                try {
                    this.mComplete.await();
                    break;
                } catch (InterruptedException unused) {
                    z2 = true;
                    pendingIntent = pendingIntent;
                    intent = intent;
                    i2 = i2;
                    str = str;
                    bundle = bundle;
                } catch (Throwable th) {
                    if (!z2) {
                        throw th;
                    }
                    Thread.currentThread().interrupt();
                    throw th;
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
            PendingIntent.OnFinished onFinished = this.mCallback;
            if (onFinished != null) {
                onFinished.onSendFinished(pendingIntent, intent, i2, str, bundle);
                this.mCallback = null;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.mSuccess) {
                this.mCallback = null;
            }
            this.mComplete.countDown();
        }

        public void complete() {
            this.mSuccess = true;
        }

        @Nullable
        public PendingIntent.OnFinished getCallback() {
            if (this.mCallback == null) {
                return null;
            }
            return new PendingIntent.OnFinished() { // from class: androidx.core.app.c
                @Override // android.app.PendingIntent.OnFinished
                public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i2, String str, Bundle bundle) {
                    this.f3924a.onSendFinished(pendingIntent, intent, i2, str, bundle);
                }
            };
        }
    }

    private PendingIntentCompat() {
    }

    private static int addMutabilityFlags(boolean z2, int i2) {
        int i8;
        if (!z2) {
            i8 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        } else {
            if (Build.VERSION.SDK_INT < 31) {
                return i2;
            }
            i8 = 33554432;
        }
        return i8 | i2;
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i2, @NonNull Intent[] intentArr, int i8, @Nullable Bundle bundle, boolean z2) {
        return PendingIntent.getActivities(context, i2, intentArr, addMutabilityFlags(z2, i8), bundle);
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i2, @NonNull Intent intent, int i8, boolean z2) {
        return PendingIntent.getActivity(context, i2, intent, addMutabilityFlags(z2, i8));
    }

    @Nullable
    public static PendingIntent getBroadcast(@NonNull Context context, int i2, @NonNull Intent intent, int i8, boolean z2) {
        return PendingIntent.getBroadcast(context, i2, intent, addMutabilityFlags(z2, i8));
    }

    @NonNull
    @RequiresApi(26)
    public static PendingIntent getForegroundService(@NonNull Context context, int i2, @NonNull Intent intent, int i8, boolean z2) {
        return Api26Impl.getForegroundService(context, i2, intent, addMutabilityFlags(z2, i8));
    }

    @Nullable
    public static PendingIntent getService(@NonNull Context context, int i2, @NonNull Intent intent, int i8, boolean z2) {
        return PendingIntent.getService(context, i2, intent, addMutabilityFlags(z2, i8));
    }

    public static void send(@NonNull PendingIntent pendingIntent, int i2, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            pendingIntent.send(i2, gatedCallback.getCallback(), handler);
            gatedCallback.complete();
            gatedCallback.close();
        } catch (Throwable th) {
            try {
                gatedCallback.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @NonNull
    public static PendingIntent getActivities(@NonNull Context context, int i2, @NonNull Intent[] intentArr, int i8, boolean z2) {
        return PendingIntent.getActivities(context, i2, intentArr, addMutabilityFlags(z2, i8));
    }

    @Nullable
    public static PendingIntent getActivity(@NonNull Context context, int i2, @NonNull Intent intent, int i8, @Nullable Bundle bundle, boolean z2) {
        return PendingIntent.getActivity(context, i2, intent, addMutabilityFlags(z2, i8), bundle);
    }

    public static void send(@NonNull PendingIntent pendingIntent, @NonNull Context context, int i2, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        send(pendingIntent, context, i2, intent, onFinished, handler, null, null);
    }

    public static void send(@NonNull PendingIntent pendingIntent, @NonNull Context context, int i2, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            Api23Impl.send(pendingIntent, context, i2, intent, onFinished, handler, str, bundle);
            gatedCallback.complete();
            gatedCallback.close();
        } finally {
        }
    }
}
