package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class SingletonConnectivityReceiver {
    private static final String TAG = "ConnectivityMonitor";
    private static volatile SingletonConnectivityReceiver instance;
    private final FrameworkConnectivityMonitor frameworkConnectivityMonitor;

    @GuardedBy("this")
    private boolean isRegistered;

    @GuardedBy("this")
    final Set<ConnectivityMonitor.ConnectivityListener> listeners = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface FrameworkConnectivityMonitor {
        boolean register();

        void unregister();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(24)
    public static final class FrameworkConnectivityMonitorPostApi24 implements FrameworkConnectivityMonitor {
        private final GlideSuppliers.GlideSupplier<ConnectivityManager> connectivityManager;
        boolean isConnected;
        final ConnectivityMonitor.ConnectivityListener listener;
        private final ConnectivityManager.NetworkCallback networkCallback = new AnonymousClass1();

        /* JADX INFO: renamed from: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPostApi24$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class AnonymousClass1 extends ConnectivityManager.NetworkCallback {
            public AnonymousClass1() {
            }

            private void postOnConnectivityChange(final boolean z2) {
                Util.postOnUiThread(new Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPostApi24.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.this.onConnectivityChange(z2);
                    }
                });
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(@NonNull Network network) {
                postOnConnectivityChange(true);
            }

            public void onConnectivityChange(boolean z2) {
                Util.assertMainThread();
                FrameworkConnectivityMonitorPostApi24 frameworkConnectivityMonitorPostApi24 = FrameworkConnectivityMonitorPostApi24.this;
                boolean z7 = frameworkConnectivityMonitorPostApi24.isConnected;
                frameworkConnectivityMonitorPostApi24.isConnected = z2;
                if (z7 != z2) {
                    frameworkConnectivityMonitorPostApi24.listener.onConnectivityChanged(z2);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(@NonNull Network network) {
                postOnConnectivityChange(false);
            }
        }

        public FrameworkConnectivityMonitorPostApi24(GlideSuppliers.GlideSupplier<ConnectivityManager> glideSupplier, ConnectivityMonitor.ConnectivityListener connectivityListener) {
            this.connectivityManager = glideSupplier;
            this.listener = connectivityListener;
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public boolean register() {
            this.isConnected = this.connectivityManager.get().getActiveNetwork() != null;
            try {
                this.connectivityManager.get().registerDefaultNetworkCallback(this.networkCallback);
                return true;
            } catch (RuntimeException e) {
                if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 5)) {
                    Log.w(SingletonConnectivityReceiver.TAG, "Failed to register callback", e);
                }
                return false;
            }
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public void unregister() {
            this.connectivityManager.get().unregisterNetworkCallback(this.networkCallback);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class FrameworkConnectivityMonitorPreApi24 implements FrameworkConnectivityMonitor {
        static final Executor EXECUTOR = AsyncTask.SERIAL_EXECUTOR;
        private final GlideSuppliers.GlideSupplier<ConnectivityManager> connectivityManager;
        final BroadcastReceiver connectivityReceiver = new BroadcastReceiver() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NonNull Context context, Intent intent) {
                FrameworkConnectivityMonitorPreApi24.this.onConnectivityChange();
            }
        };
        final Context context;
        volatile boolean isConnected;
        volatile boolean isRegistered;
        final ConnectivityMonitor.ConnectivityListener listener;

        public FrameworkConnectivityMonitorPreApi24(Context context, GlideSuppliers.GlideSupplier<ConnectivityManager> glideSupplier, ConnectivityMonitor.ConnectivityListener connectivityListener) {
            this.context = context.getApplicationContext();
            this.connectivityManager = glideSupplier;
            this.listener = connectivityListener;
        }

        public boolean isConnected() {
            try {
                NetworkInfo activeNetworkInfo = this.connectivityManager.get().getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            } catch (RuntimeException e) {
                if (!Log.isLoggable(SingletonConnectivityReceiver.TAG, 5)) {
                    return true;
                }
                Log.w(SingletonConnectivityReceiver.TAG, "Failed to determine connectivity status when connectivity changed", e);
                return true;
            }
        }

        public void notifyChangeOnUiThread(final boolean z2) {
            Util.postOnUiThread(new Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.5
                @Override // java.lang.Runnable
                public void run() {
                    FrameworkConnectivityMonitorPreApi24.this.listener.onConnectivityChanged(z2);
                }
            });
        }

        public void onConnectivityChange() {
            EXECUTOR.execute(new Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.4
                @Override // java.lang.Runnable
                public void run() {
                    boolean z2 = FrameworkConnectivityMonitorPreApi24.this.isConnected;
                    FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = FrameworkConnectivityMonitorPreApi24.this;
                    frameworkConnectivityMonitorPreApi24.isConnected = frameworkConnectivityMonitorPreApi24.isConnected();
                    if (z2 != FrameworkConnectivityMonitorPreApi24.this.isConnected) {
                        if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 3)) {
                            Log.d(SingletonConnectivityReceiver.TAG, "connectivity changed, isConnected: " + FrameworkConnectivityMonitorPreApi24.this.isConnected);
                        }
                        FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi242 = FrameworkConnectivityMonitorPreApi24.this;
                        frameworkConnectivityMonitorPreApi242.notifyChangeOnUiThread(frameworkConnectivityMonitorPreApi242.isConnected);
                    }
                }
            });
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public boolean register() {
            EXECUTOR.execute(new Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.2
                @Override // java.lang.Runnable
                public void run() {
                    FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = FrameworkConnectivityMonitorPreApi24.this;
                    frameworkConnectivityMonitorPreApi24.isConnected = frameworkConnectivityMonitorPreApi24.isConnected();
                    try {
                        FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi242 = FrameworkConnectivityMonitorPreApi24.this;
                        frameworkConnectivityMonitorPreApi242.context.registerReceiver(frameworkConnectivityMonitorPreApi242.connectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        FrameworkConnectivityMonitorPreApi24.this.isRegistered = true;
                    } catch (SecurityException e) {
                        if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 5)) {
                            Log.w(SingletonConnectivityReceiver.TAG, "Failed to register", e);
                        }
                        FrameworkConnectivityMonitorPreApi24.this.isRegistered = false;
                    }
                }
            });
            return true;
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public void unregister() {
            EXECUTOR.execute(new Runnable() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.3
                @Override // java.lang.Runnable
                public void run() {
                    if (FrameworkConnectivityMonitorPreApi24.this.isRegistered) {
                        FrameworkConnectivityMonitorPreApi24.this.isRegistered = false;
                        FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = FrameworkConnectivityMonitorPreApi24.this;
                        frameworkConnectivityMonitorPreApi24.context.unregisterReceiver(frameworkConnectivityMonitorPreApi24.connectivityReceiver);
                    }
                }
            });
        }
    }

    private SingletonConnectivityReceiver(@NonNull final Context context) {
        GlideSuppliers.GlideSupplier glideSupplierMemorize = GlideSuppliers.memorize(new GlideSuppliers.GlideSupplier<ConnectivityManager>() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            public ConnectivityManager get() {
                return (ConnectivityManager) context.getSystemService("connectivity");
            }
        });
        ConnectivityMonitor.ConnectivityListener connectivityListener = new ConnectivityMonitor.ConnectivityListener() { // from class: com.bumptech.glide.manager.SingletonConnectivityReceiver.2
            @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
            public void onConnectivityChanged(boolean z2) {
                ArrayList arrayList;
                Util.assertMainThread();
                synchronized (SingletonConnectivityReceiver.this) {
                    arrayList = new ArrayList(SingletonConnectivityReceiver.this.listeners);
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((ConnectivityMonitor.ConnectivityListener) obj).onConnectivityChanged(z2);
                }
            }
        };
        this.frameworkConnectivityMonitor = Build.VERSION.SDK_INT >= 24 ? new FrameworkConnectivityMonitorPostApi24(glideSupplierMemorize, connectivityListener) : new FrameworkConnectivityMonitorPreApi24(context, glideSupplierMemorize, connectivityListener);
    }

    public static SingletonConnectivityReceiver get(@NonNull Context context) {
        if (instance == null) {
            synchronized (SingletonConnectivityReceiver.class) {
                try {
                    if (instance == null) {
                        instance = new SingletonConnectivityReceiver(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    @GuardedBy("this")
    private void maybeRegisterReceiver() {
        if (this.isRegistered || this.listeners.isEmpty()) {
            return;
        }
        this.isRegistered = this.frameworkConnectivityMonitor.register();
    }

    @GuardedBy("this")
    private void maybeUnregisterReceiver() {
        if (this.isRegistered && this.listeners.isEmpty()) {
            this.frameworkConnectivityMonitor.unregister();
            this.isRegistered = false;
        }
    }

    @VisibleForTesting
    public static void reset() {
        instance = null;
    }

    public synchronized void register(ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.listeners.add(connectivityListener);
        maybeRegisterReceiver();
    }

    public synchronized void unregister(ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.listeners.remove(connectivityListener);
        maybeUnregisterReceiver();
    }
}
