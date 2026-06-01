package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class ConfigSharedPrefsClient {
    private static final String BACKOFF_END_TIME_IN_MILLIS_KEY = "backoff_end_time_in_millis";
    private static final int CUSTOM_SIGNALS_MAX_COUNT = 100;
    private static final int CUSTOM_SIGNALS_MAX_KEY_LENGTH = 250;
    private static final int CUSTOM_SIGNALS_MAX_STRING_VALUE_LENGTH = 500;
    private static final String FETCH_TIMEOUT_IN_SECONDS_KEY = "fetch_timeout_in_seconds";
    private static final String LAST_FETCH_ETAG_KEY = "last_fetch_etag";
    private static final String LAST_FETCH_STATUS_KEY = "last_fetch_status";

    @VisibleForTesting
    public static final long LAST_FETCH_TIME_IN_MILLIS_NO_FETCH_YET = -1;
    private static final String LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY = "last_fetch_time_in_millis";
    private static final String LAST_TEMPLATE_VERSION = "last_template_version";
    private static final String MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY = "minimum_fetch_interval_in_seconds";
    private static final long NO_BACKOFF_TIME_IN_MILLIS = -1;

    @VisibleForTesting
    static final int NO_FAILED_FETCHES = 0;
    static final int NO_FAILED_REALTIME_STREAMS = 0;
    private static final String NUM_FAILED_FETCHES_KEY = "num_failed_fetches";
    private static final String NUM_FAILED_REALTIME_STREAMS_KEY = "num_failed_realtime_streams";
    private static final String REALTIME_BACKOFF_END_TIME_IN_MILLIS_KEY = "realtime_backoff_end_time_in_millis";
    private final SharedPreferences frcSharedPrefs;
    static final Date LAST_FETCH_TIME_NO_FETCH_YET = new Date(-1);

    @VisibleForTesting
    static final Date NO_BACKOFF_TIME = new Date(-1);
    private final Object frcInfoLock = new Object();
    private final Object backoffMetadataLock = new Object();
    private final Object realtimeBackoffMetadataLock = new Object();
    private final Object customSignalsLock = new Object();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class BackoffMetadata {
        private Date backoffEndTime;
        private int numFailedFetches;

        public BackoffMetadata(int i2, Date date) {
            this.numFailedFetches = i2;
            this.backoffEndTime = date;
        }

        public Date getBackoffEndTime() {
            return this.backoffEndTime;
        }

        public int getNumFailedFetches() {
            return this.numFailedFetches;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class RealtimeBackoffMetadata {
        private Date backoffEndTime;
        private int numFailedStreams;

        @VisibleForTesting
        public RealtimeBackoffMetadata(int i2, Date date) {
            this.numFailedStreams = i2;
            this.backoffEndTime = date;
        }

        public Date getBackoffEndTime() {
            return this.backoffEndTime;
        }

        public int getNumFailedStreams() {
            return this.numFailedStreams;
        }
    }

    public ConfigSharedPrefsClient(SharedPreferences sharedPreferences) {
        this.frcSharedPrefs = sharedPreferences;
    }

    @WorkerThread
    public void clear() {
        synchronized (this.frcInfoLock) {
            this.frcSharedPrefs.edit().clear().commit();
        }
    }

    public BackoffMetadata getBackoffMetadata() {
        BackoffMetadata backoffMetadata;
        synchronized (this.backoffMetadataLock) {
            backoffMetadata = new BackoffMetadata(this.frcSharedPrefs.getInt(NUM_FAILED_FETCHES_KEY, 0), new Date(this.frcSharedPrefs.getLong(BACKOFF_END_TIME_IN_MILLIS_KEY, -1L)));
        }
        return backoffMetadata;
    }

    public Map<String, String> getCustomSignals() {
        try {
            JSONObject jSONObject = new JSONObject(this.frcSharedPrefs.getString(RemoteConfigConstants.RequestFieldKey.CUSTOM_SIGNALS, "{}"));
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.optString(next));
            }
            return map;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public long getFetchTimeoutInSeconds() {
        return this.frcSharedPrefs.getLong(FETCH_TIMEOUT_IN_SECONDS_KEY, 60L);
    }

    public FirebaseRemoteConfigInfo getInfo() {
        FirebaseRemoteConfigInfoImpl firebaseRemoteConfigInfoImplBuild;
        synchronized (this.frcInfoLock) {
            long j = this.frcSharedPrefs.getLong(LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY, -1L);
            int i2 = this.frcSharedPrefs.getInt(LAST_FETCH_STATUS_KEY, 0);
            firebaseRemoteConfigInfoImplBuild = FirebaseRemoteConfigInfoImpl.newBuilder().withLastFetchStatus(i2).withLastSuccessfulFetchTimeInMillis(j).withConfigSettings(new FirebaseRemoteConfigSettings.Builder().setFetchTimeoutInSeconds(this.frcSharedPrefs.getLong(FETCH_TIMEOUT_IN_SECONDS_KEY, 60L)).setMinimumFetchIntervalInSeconds(this.frcSharedPrefs.getLong(MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY, ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS)).build()).build();
        }
        return firebaseRemoteConfigInfoImplBuild;
    }

    @Nullable
    public String getLastFetchETag() {
        return this.frcSharedPrefs.getString(LAST_FETCH_ETAG_KEY, null);
    }

    public int getLastFetchStatus() {
        return this.frcSharedPrefs.getInt(LAST_FETCH_STATUS_KEY, 0);
    }

    public Date getLastSuccessfulFetchTime() {
        return new Date(this.frcSharedPrefs.getLong(LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY, -1L));
    }

    public long getLastTemplateVersion() {
        return this.frcSharedPrefs.getLong(LAST_TEMPLATE_VERSION, 0L);
    }

    public long getMinimumFetchIntervalInSeconds() {
        return this.frcSharedPrefs.getLong(MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY, ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS);
    }

    public RealtimeBackoffMetadata getRealtimeBackoffMetadata() {
        RealtimeBackoffMetadata realtimeBackoffMetadata;
        synchronized (this.realtimeBackoffMetadataLock) {
            realtimeBackoffMetadata = new RealtimeBackoffMetadata(this.frcSharedPrefs.getInt(NUM_FAILED_REALTIME_STREAMS_KEY, 0), new Date(this.frcSharedPrefs.getLong(REALTIME_BACKOFF_END_TIME_IN_MILLIS_KEY, -1L)));
        }
        return realtimeBackoffMetadata;
    }

    public void resetBackoff() {
        setBackoffMetadata(0, NO_BACKOFF_TIME);
    }

    public void resetRealtimeBackoff() {
        setRealtimeBackoffMetadata(0, NO_BACKOFF_TIME);
    }

    public void setBackoffMetadata(int i2, Date date) {
        synchronized (this.backoffMetadataLock) {
            this.frcSharedPrefs.edit().putInt(NUM_FAILED_FETCHES_KEY, i2).putLong(BACKOFF_END_TIME_IN_MILLIS_KEY, date.getTime()).apply();
        }
    }

    @WorkerThread
    public void setConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        synchronized (this.frcInfoLock) {
            this.frcSharedPrefs.edit().putLong(FETCH_TIMEOUT_IN_SECONDS_KEY, firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong(MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY, firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).commit();
        }
    }

    public void setConfigSettingsWithoutWaitingOnDiskWrite(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        synchronized (this.frcInfoLock) {
            this.frcSharedPrefs.edit().putLong(FETCH_TIMEOUT_IN_SECONDS_KEY, firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong(MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY, firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).apply();
        }
    }

    public void setCustomSignals(Map<String, String> map) {
        synchronized (this.customSignalsLock) {
            try {
                Map<String, String> customSignals = getCustomSignals();
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                boolean z2 = false;
                while (true) {
                    boolean z7 = true;
                    if (!it.hasNext()) {
                        if (z2) {
                            if (customSignals.size() > 100) {
                                Log.w(FirebaseRemoteConfig.TAG, String.format("Invalid custom signal: Too many custom signals provided. The maximum allowed is %d.", 100));
                                return;
                            }
                            this.frcSharedPrefs.edit().putString(RemoteConfigConstants.RequestFieldKey.CUSTOM_SIGNALS, new JSONObject(customSignals).toString()).commit();
                            Log.d(FirebaseRemoteConfig.TAG, "Keys of updated custom signals: " + getCustomSignals().keySet());
                            return;
                        }
                        return;
                    }
                    Map.Entry<String, String> next = it.next();
                    String key = next.getKey();
                    String value = next.getValue();
                    if (key.length() > 250 || (value != null && value.length() > 500)) {
                        break;
                    }
                    if (value != null) {
                        z2 |= !Objects.equals(customSignals.put(key, value), value);
                    } else {
                        if (customSignals.remove(key) == null) {
                            z7 = false;
                        }
                        z2 |= z7;
                    }
                }
                Log.w(FirebaseRemoteConfig.TAG, String.format("Invalid custom signal: Custom signal keys must be %d characters or less, and values must be %d characters or less.", 250, 500));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setLastFetchETag(String str) {
        synchronized (this.frcInfoLock) {
            this.frcSharedPrefs.edit().putString(LAST_FETCH_ETAG_KEY, str).apply();
        }
    }

    public void setLastTemplateVersion(long j) {
        synchronized (this.frcInfoLock) {
            this.frcSharedPrefs.edit().putLong(LAST_TEMPLATE_VERSION, j).apply();
        }
    }

    public void setRealtimeBackoffEndTime(Date date) {
        synchronized (this.realtimeBackoffMetadataLock) {
            this.frcSharedPrefs.edit().putLong(REALTIME_BACKOFF_END_TIME_IN_MILLIS_KEY, date.getTime()).apply();
        }
    }

    public void setRealtimeBackoffMetadata(int i2, Date date) {
        synchronized (this.realtimeBackoffMetadataLock) {
            this.frcSharedPrefs.edit().putInt(NUM_FAILED_REALTIME_STREAMS_KEY, i2).putLong(REALTIME_BACKOFF_END_TIME_IN_MILLIS_KEY, date.getTime()).apply();
        }
    }

    public void updateLastFetchAsFailed() {
        synchronized (this.frcInfoLock) {
            this.frcSharedPrefs.edit().putInt(LAST_FETCH_STATUS_KEY, 1).apply();
        }
    }

    public void updateLastFetchAsSuccessfulAt(Date date) {
        synchronized (this.frcInfoLock) {
            this.frcSharedPrefs.edit().putInt(LAST_FETCH_STATUS_KEY, -1).putLong(LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY, date.getTime()).apply();
        }
    }

    public void updateLastFetchAsThrottled() {
        synchronized (this.frcInfoLock) {
            this.frcSharedPrefs.edit().putInt(LAST_FETCH_STATUS_KEY, 2).apply();
        }
    }
}
