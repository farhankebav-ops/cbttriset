package androidx.media.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.c;
import android.support.v4.media.d;
import android.support.v4.media.g;
import android.support.v4.media.h;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.e;
import android.support.v4.media.session.f;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.RestrictTo;
import androidx.media.MediaBrowserServiceCompat;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    private static final String TAG = "MediaButtonReceiver";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MediaButtonConnectionCallback extends c {
        private final Context mContext;
        private final Intent mIntent;
        private h mMediaBrowser;
        private final BroadcastReceiver.PendingResult mPendingResult;

        public MediaButtonConnectionCallback(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.mContext = context;
            this.mIntent = intent;
            this.mPendingResult = pendingResult;
        }

        private void finish() {
            Messenger messenger;
            d dVar = this.mMediaBrowser.f3266a;
            g gVar = dVar.f3260f;
            if (gVar != null && (messenger = dVar.g) != null) {
                try {
                    gVar.q(7, null, messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            dVar.f3257b.disconnect();
            this.mPendingResult.finish();
        }

        @Override // android.support.v4.media.c
        public void onConnected() {
            Context context;
            MediaSessionCompat$Token mediaSessionCompat$Token;
            try {
                context = this.mContext;
                d dVar = this.mMediaBrowser.f3266a;
                if (dVar.h == null) {
                    dVar.h = MediaSessionCompat$Token.a(dVar.f3257b.getSessionToken(), null);
                }
                mediaSessionCompat$Token = dVar.h;
                new HashSet();
            } catch (RemoteException e) {
                Log.e(MediaButtonReceiver.TAG, "Failed to create a media controller", e);
            }
            if (mediaSessionCompat$Token == null) {
                throw new IllegalArgumentException("sessionToken must not be null");
            }
            e fVar = Build.VERSION.SDK_INT >= 24 ? new f(context, mediaSessionCompat$Token) : new e(context, mediaSessionCompat$Token);
            KeyEvent keyEvent = (KeyEvent) this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            if (keyEvent == null) {
                throw new IllegalArgumentException("KeyEvent may not be null");
            }
            fVar.f3291a.dispatchMediaButtonEvent(keyEvent);
            finish();
        }

        @Override // android.support.v4.media.c
        public void onConnectionFailed() {
            finish();
        }

        @Override // android.support.v4.media.c
        public void onConnectionSuspended() {
            finish();
        }

        public void setMediaBrowser(h hVar) {
            this.mMediaBrowser = hVar;
        }
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context context, long j) {
        ComponentName mediaButtonReceiverComponent = getMediaButtonReceiverComponent(context);
        if (mediaButtonReceiverComponent != null) {
            return buildMediaButtonPendingIntent(context, mediaButtonReceiverComponent, j);
        }
        Log.w(TAG, "A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static ComponentName getMediaButtonReceiverComponent(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = listQueryBroadcastReceivers.get(0).activityInfo;
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        }
        if (listQueryBroadcastReceivers.size() <= 1) {
            return null;
        }
        Log.w(TAG, "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        return null;
    }

    private static ComponentName getServiceComponentByAction(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        }
        if (listQueryIntentServices.isEmpty()) {
            return null;
        }
        StringBuilder sbY = a1.a.y("Expected 1 service that handles ", str, ", found ");
        sbY.append(listQueryIntentServices.size());
        throw new IllegalStateException(sbY.toString());
    }

    public static KeyEvent handleIntent(android.support.v4.media.session.g gVar, Intent intent) {
        return null;
    }

    private static void startForegroundService(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d(TAG, "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName serviceComponentByAction = getServiceComponentByAction(context, "android.intent.action.MEDIA_BUTTON");
        if (serviceComponentByAction != null) {
            intent.setComponent(serviceComponentByAction);
            startForegroundService(context, intent);
            return;
        }
        ComponentName serviceComponentByAction2 = getServiceComponentByAction(context, MediaBrowserServiceCompat.SERVICE_INTERFACE);
        if (serviceComponentByAction2 == null) {
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        Context applicationContext = context.getApplicationContext();
        MediaButtonConnectionCallback mediaButtonConnectionCallback = new MediaButtonConnectionCallback(applicationContext, intent, pendingResultGoAsync);
        h hVar = new h(applicationContext, serviceComponentByAction2, mediaButtonConnectionCallback);
        mediaButtonConnectionCallback.setMediaBrowser(hVar);
        hVar.f3266a.f3257b.connect();
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context context, ComponentName componentName, long j) {
        if (componentName == null) {
            Log.w(TAG, "The component name of media button receiver should be provided.");
            return null;
        }
        int i2 = j == 4 ? 126 : j == 2 ? 127 : j == 32 ? 87 : j == 16 ? 88 : j == 1 ? 86 : j == 64 ? 90 : j == 8 ? 89 : j == 512 ? 85 : 0;
        if (i2 == 0) {
            Log.w(TAG, "Cannot build a media button pending intent with the given action: " + j);
            return null;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, i2));
        return PendingIntent.getBroadcast(context, i2, intent, 0);
    }
}
