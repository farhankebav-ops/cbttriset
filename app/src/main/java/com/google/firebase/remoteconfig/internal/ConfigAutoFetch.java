package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class ConfigAutoFetch {
    private static final int MAXIMUM_FETCH_ATTEMPTS = 3;
    private static final String REALTIME_DISABLED_KEY = "featureDisabled";
    private static final String REALTIME_RETRY_INTERVAL = "retryIntervalSeconds";
    private static final String TEMPLATE_VERSION_KEY = "latestTemplateVersionNumber";
    private final ConfigCacheClient activatedCache;
    private final ConfigFetchHandler configFetchHandler;

    @GuardedBy("this")
    private final Set<ConfigUpdateListener> eventListeners;
    private final HttpURLConnection httpURLConnection;
    private final ConfigUpdateListener retryCallback;
    private final ScheduledExecutorService scheduledExecutorService;
    private final ConfigSharedPrefsClient sharedPrefsClient;
    private final Random random = new Random();
    private boolean isInBackground = false;
    private final Clock clock = DefaultClock.getInstance();

    public ConfigAutoFetch(HttpURLConnection httpURLConnection, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Set<ConfigUpdateListener> set, ConfigUpdateListener configUpdateListener, ScheduledExecutorService scheduledExecutorService, ConfigSharedPrefsClient configSharedPrefsClient) {
        this.httpURLConnection = httpURLConnection;
        this.configFetchHandler = configFetchHandler;
        this.activatedCache = configCacheClient;
        this.eventListeners = set;
        this.retryCallback = configUpdateListener;
        this.scheduledExecutorService = scheduledExecutorService;
        this.sharedPrefsClient = configSharedPrefsClient;
    }

    private void autoFetch(final int i2, final long j) {
        if (i2 == 0) {
            propagateErrors(new FirebaseRemoteConfigServerException("Unable to fetch the latest version of the template.", FirebaseRemoteConfigException.Code.CONFIG_UPDATE_NOT_FETCHED));
        } else {
            this.scheduledExecutorService.schedule(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.ConfigAutoFetch.1
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    ConfigAutoFetch.this.fetchLatestConfig(i2, j);
                }
            }, this.random.nextInt(4), TimeUnit.SECONDS);
        }
    }

    private synchronized void executeAllListenerCallbacks(ConfigUpdate configUpdate) {
        Iterator<ConfigUpdateListener> it = this.eventListeners.iterator();
        while (it.hasNext()) {
            it.next().onUpdate(configUpdate);
        }
    }

    private static Boolean fetchResponseIsUpToDate(ConfigFetchHandler.FetchResponse fetchResponse, long j) {
        if (fetchResponse.getFetchedConfigs() != null) {
            return Boolean.valueOf(fetchResponse.getFetchedConfigs().getTemplateVersionNumber() >= j);
        }
        return Boolean.valueOf(fetchResponse.getStatus() == 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r5 = new org.json.JSONObject(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
    
        if (r5.has(com.google.firebase.remoteconfig.internal.ConfigAutoFetch.REALTIME_DISABLED_KEY) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
    
        if (r5.getBoolean(com.google.firebase.remoteconfig.internal.ConfigAutoFetch.REALTIME_DISABLED_KEY) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        r10.retryCallback.onError(new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException("The server is temporarily unavailable. Try again in a few minutes.", com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_UNAVAILABLE));
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
    
        if (isEventListenersEmpty() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005f, code lost:
    
        if (r5.has(com.google.firebase.remoteconfig.internal.ConfigAutoFetch.TEMPLATE_VERSION_KEY) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
    
        r6 = r10.configFetchHandler.getTemplateVersionNumber();
        r8 = r5.getLong(com.google.firebase.remoteconfig.internal.ConfigAutoFetch.TEMPLATE_VERSION_KEY);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
    
        if (r8 <= r6) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
    
        autoFetch(3, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
    
        if (r5.has(com.google.firebase.remoteconfig.internal.ConfigAutoFetch.REALTIME_RETRY_INTERVAL) == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0079, code lost:
    
        updateBackoffMetadataWithRetryInterval(r5.getInt(com.google.firebase.remoteconfig.internal.ConfigAutoFetch.REALTIME_RETRY_INTERVAL));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void handleNotifications(java.io.InputStream r11) throws java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "retryIntervalSeconds"
            java.lang.String r1 = "latestTemplateVersionNumber"
            java.lang.String r2 = "featureDisabled"
            java.io.BufferedReader r3 = new java.io.BufferedReader
            java.io.InputStreamReader r4 = new java.io.InputStreamReader
            java.lang.String r5 = "utf-8"
            r4.<init>(r11, r5)
            r3.<init>(r4)
            java.lang.String r11 = ""
        L14:
            r4 = r11
        L15:
            java.lang.String r5 = r3.readLine()
            if (r5 == 0) goto L9a
            java.lang.String r4 = a1.a.C(r4, r5)
            java.lang.String r6 = "}"
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L15
            java.lang.String r4 = r10.parseAndValidateConfigUpdateMessage(r4)
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L32
            goto L15
        L32:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L52
            r5.<init>(r4)     // Catch: org.json.JSONException -> L52
            boolean r4 = r5.has(r2)     // Catch: org.json.JSONException -> L52
            if (r4 == 0) goto L54
            boolean r4 = r5.getBoolean(r2)     // Catch: org.json.JSONException -> L52
            if (r4 == 0) goto L54
            com.google.firebase.remoteconfig.ConfigUpdateListener r4 = r10.retryCallback     // Catch: org.json.JSONException -> L52
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r5 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException     // Catch: org.json.JSONException -> L52
            java.lang.String r6 = "The server is temporarily unavailable. Try again in a few minutes."
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r7 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_UNAVAILABLE     // Catch: org.json.JSONException -> L52
            r5.<init>(r6, r7)     // Catch: org.json.JSONException -> L52
            r4.onError(r5)     // Catch: org.json.JSONException -> L52
            goto L9a
        L52:
            r4 = move-exception
            goto L81
        L54:
            boolean r4 = r10.isEventListenersEmpty()     // Catch: org.json.JSONException -> L52
            if (r4 == 0) goto L5b
            goto L9a
        L5b:
            boolean r4 = r5.has(r1)     // Catch: org.json.JSONException -> L52
            if (r4 == 0) goto L73
            com.google.firebase.remoteconfig.internal.ConfigFetchHandler r4 = r10.configFetchHandler     // Catch: org.json.JSONException -> L52
            long r6 = r4.getTemplateVersionNumber()     // Catch: org.json.JSONException -> L52
            long r8 = r5.getLong(r1)     // Catch: org.json.JSONException -> L52
            int r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r4 <= 0) goto L73
            r4 = 3
            r10.autoFetch(r4, r8)     // Catch: org.json.JSONException -> L52
        L73:
            boolean r4 = r5.has(r0)     // Catch: org.json.JSONException -> L52
            if (r4 == 0) goto L14
            int r4 = r5.getInt(r0)     // Catch: org.json.JSONException -> L52
            r10.updateBackoffMetadataWithRetryInterval(r4)     // Catch: org.json.JSONException -> L52
            goto L14
        L81:
            com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException r5 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException
            java.lang.Throwable r6 = r4.getCause()
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r7 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_MESSAGE_INVALID
            java.lang.String r8 = "Unable to parse config update message."
            r5.<init>(r8, r6, r7)
            r10.propagateErrors(r5)
            java.lang.String r5 = "FirebaseRemoteConfig"
            java.lang.String r6 = "Unable to parse latest config update message."
            android.util.Log.e(r5, r6, r4)
            goto L14
        L9a:
            r3.close()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigAutoFetch.handleNotifications(java.io.InputStream):void");
    }

    private synchronized boolean isEventListenersEmpty() {
        return this.eventListeners.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task lambda$fetchLatestConfig$0(Task task, Task task2, long j, int i2, Task task3) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to auto-fetch config update.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to get activated config for auto-fetch", task2.getException()));
        }
        ConfigFetchHandler.FetchResponse fetchResponse = (ConfigFetchHandler.FetchResponse) task.getResult();
        ConfigContainer configContainerBuild = (ConfigContainer) task2.getResult();
        if (!fetchResponseIsUpToDate(fetchResponse, j).booleanValue()) {
            Log.d(FirebaseRemoteConfig.TAG, "Fetched template version is the same as SDK's current version. Retrying fetch.");
            autoFetch(i2, j);
            return Tasks.forResult(null);
        }
        if (fetchResponse.getFetchedConfigs() == null) {
            Log.d(FirebaseRemoteConfig.TAG, "The fetch succeeded, but the backend had no updates.");
            return Tasks.forResult(null);
        }
        if (configContainerBuild == null) {
            configContainerBuild = ConfigContainer.newBuilder().build();
        }
        Set<String> changedParams = configContainerBuild.getChangedParams(fetchResponse.getFetchedConfigs());
        if (changedParams.isEmpty()) {
            Log.d(FirebaseRemoteConfig.TAG, "Config was fetched, but no params changed.");
            return Tasks.forResult(null);
        }
        executeAllListenerCallbacks(ConfigUpdate.create(changedParams));
        return Tasks.forResult(null);
    }

    private String parseAndValidateConfigUpdateMessage(String str) {
        int iIndexOf = str.indexOf(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
        int iLastIndexOf = str.lastIndexOf(Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
        return (iIndexOf < 0 || iLastIndexOf < 0 || iIndexOf >= iLastIndexOf) ? "" : str.substring(iIndexOf, iLastIndexOf + 1);
    }

    private synchronized void propagateErrors(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        Iterator<ConfigUpdateListener> it = this.eventListeners.iterator();
        while (it.hasNext()) {
            it.next().onError(firebaseRemoteConfigException);
        }
    }

    private synchronized void updateBackoffMetadataWithRetryInterval(int i2) {
        this.sharedPrefsClient.setRealtimeBackoffEndTime(new Date(new Date(this.clock.currentTimeMillis()).getTime() + (((long) i2) * 1000)));
    }

    @VisibleForTesting
    public synchronized Task<Void> fetchLatestConfig(int i2, final long j) throws Throwable {
        final int i8 = i2 - 1;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            final Task<ConfigFetchHandler.FetchResponse> taskFetchNowWithTypeAndAttemptNumber = this.configFetchHandler.fetchNowWithTypeAndAttemptNumber(ConfigFetchHandler.FetchType.REALTIME, 3 - i8);
            final Task<ConfigContainer> task = this.activatedCache.get();
            return Tasks.whenAllComplete((Task<?>[]) new Task[]{taskFetchNowWithTypeAndAttemptNumber, task}).continueWithTask(this.scheduledExecutorService, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.a
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task2) {
                    return this.f5723a.lambda$fetchLatestConfig$0(taskFetchNowWithTypeAndAttemptNumber, task, j, i8, task2);
                }
            });
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    @VisibleForTesting
    public void listenForNotifications() {
        HttpURLConnection httpURLConnection = this.httpURLConnection;
        if (httpURLConnection == null) {
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                try {
                    inputStream = httpURLConnection.getInputStream();
                    handleNotifications(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    if (!this.isInBackground) {
                        Log.d(FirebaseRemoteConfig.TAG, "Real-time connection was closed due to an exception.", e);
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException e4) {
                Log.d(FirebaseRemoteConfig.TAG, "Exception thrown when closing connection stream. Retrying connection...", e4);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                    Log.d(FirebaseRemoteConfig.TAG, "Exception thrown when closing connection stream. Retrying connection...", e8);
                }
            }
            throw th;
        }
    }

    public void setIsInBackground(boolean z2) {
        this.isInBackground = z2;
    }
}
