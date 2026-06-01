package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import com.google.firebase.datastorage.JavaDataStorage;
import com.google.firebase.datastorage.JavaDataStorageKt;
import e6.l;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class HeartBeatInfoStorage {
    private static final String HEARTBEAT_PREFERENCES_NAME = "FirebaseHeartBeat";
    private static final int HEART_BEAT_COUNT_LIMIT = 30;
    private static final String PREFERENCES_NAME = "FirebaseAppHeartBeat";
    private static HeartBeatInfoStorage instance;
    private final JavaDataStorage firebaseDataStore;
    private static final Preferences.Key<Long> GLOBAL = PreferencesKeys.longKey("fire-global");
    private static final Preferences.Key<Long> HEART_BEAT_COUNT_TAG = PreferencesKeys.longKey("fire-count");
    private static final Preferences.Key<String> LAST_STORED_DATE = PreferencesKeys.stringKey("last-used-date");

    public HeartBeatInfoStorage(Context context, String str) {
        this.firebaseDataStore = new JavaDataStorage(context, a1.a.l(HEARTBEAT_PREFERENCES_NAME, str));
    }

    private synchronized long cleanUpStoredHeartBeats(MutablePreferences mutablePreferences) {
        long j;
        try {
            long jLongValue = ((Long) JavaDataStorageKt.getOrDefault(mutablePreferences, HEART_BEAT_COUNT_TAG, 0L)).longValue();
            String name = "";
            Set hashSet = new HashSet();
            String str = null;
            for (Map.Entry<Preferences.Key<?>, Object> entry : mutablePreferences.asMap().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Set<String> set = (Set) entry.getValue();
                    for (String str2 : set) {
                        if (str == null || str.compareTo(str2) > 0) {
                            name = entry.getKey().getName();
                            hashSet = set;
                            str = str2;
                        }
                    }
                }
            }
            HashSet hashSet2 = new HashSet(hashSet);
            hashSet2.remove(str);
            mutablePreferences.set(PreferencesKeys.stringSetKey(name), hashSet2);
            j = jLongValue - 1;
            mutablePreferences.set(HEART_BEAT_COUNT_TAG, Long.valueOf(j));
        } catch (Throwable th) {
            throw th;
        }
        return j;
    }

    private synchronized String getFormattedDate(long j) {
        if (Build.VERSION.SDK_INT < 26) {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j));
        }
        Instant instant = new Date(j).toInstant();
        ZoneOffset unused = ZoneOffset.UTC;
        LocalDateTime localDateTime = instant.atOffset(ZoneOffset.UTC).toLocalDateTime();
        DateTimeFormatter unused2 = DateTimeFormatter.ISO_LOCAL_DATE;
        return localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    private synchronized Preferences.Key<Set<String>> getStoredUserAgentString(MutablePreferences mutablePreferences, String str) {
        for (Map.Entry<Preferences.Key<?>, Object> entry : mutablePreferences.asMap().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return PreferencesKeys.stringSetKey(entry.getKey().getName());
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ x lambda$deleteAllHeartBeats$0(MutablePreferences mutablePreferences) {
        long j = 0;
        for (Map.Entry<Preferences.Key<?>, Object> entry : mutablePreferences.asMap().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Preferences.Key<?> key = entry.getKey();
                Set set = (Set) entry.getValue();
                String formattedDate = getFormattedDate(System.currentTimeMillis());
                if (set.contains(formattedDate)) {
                    Object[] objArr = {formattedDate};
                    HashSet hashSet = new HashSet(1);
                    Object obj = objArr[0];
                    Objects.requireNonNull(obj);
                    if (!hashSet.add(obj)) {
                        throw new IllegalArgumentException("duplicate element: " + obj);
                    }
                    mutablePreferences.set(key, Collections.unmodifiableSet(hashSet));
                    j++;
                } else {
                    mutablePreferences.remove(key);
                }
            }
        }
        if (j == 0) {
            mutablePreferences.remove(HEART_BEAT_COUNT_TAG);
            return null;
        }
        mutablePreferences.set(HEART_BEAT_COUNT_TAG, Long.valueOf(j));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ x lambda$postHeartBeatCleanUp$1(String str, MutablePreferences mutablePreferences) {
        mutablePreferences.set(LAST_STORED_DATE, str);
        removeStoredDate(mutablePreferences, str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ x lambda$storeHeartBeat$2(String str, String str2, Preferences.Key key, MutablePreferences mutablePreferences) {
        Preferences.Key<String> key2 = LAST_STORED_DATE;
        if (((String) JavaDataStorageKt.getOrDefault(mutablePreferences, key2, "")).equals(str)) {
            Preferences.Key<Set<String>> storedUserAgentString = getStoredUserAgentString(mutablePreferences, str);
            if (storedUserAgentString == null || storedUserAgentString.getName().equals(str2)) {
                return null;
            }
            updateStoredUserAgent(mutablePreferences, key, str);
            return null;
        }
        Preferences.Key<Long> key3 = HEART_BEAT_COUNT_TAG;
        long jLongValue = ((Long) JavaDataStorageKt.getOrDefault(mutablePreferences, key3, 0L)).longValue();
        if (jLongValue + 1 == 30) {
            jLongValue = cleanUpStoredHeartBeats(mutablePreferences);
        }
        HashSet hashSet = new HashSet((Collection) JavaDataStorageKt.getOrDefault(mutablePreferences, key, new HashSet()));
        hashSet.add(str);
        mutablePreferences.set(key, hashSet);
        mutablePreferences.set(key3, Long.valueOf(jLongValue + 1));
        mutablePreferences.set(key2, str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ x lambda$updateGlobalHeartBeat$3(long j, MutablePreferences mutablePreferences) {
        mutablePreferences.set(GLOBAL, Long.valueOf(j));
        return null;
    }

    private synchronized void removeStoredDate(MutablePreferences mutablePreferences, String str) {
        try {
            Preferences.Key<Set<String>> storedUserAgentString = getStoredUserAgentString(mutablePreferences, str);
            if (storedUserAgentString == null) {
                return;
            }
            HashSet hashSet = new HashSet((Collection) JavaDataStorageKt.getOrDefault(mutablePreferences, storedUserAgentString, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                mutablePreferences.remove(storedUserAgentString);
            } else {
                mutablePreferences.set(storedUserAgentString, hashSet);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void updateStoredUserAgent(MutablePreferences mutablePreferences, Preferences.Key<Set<String>> key, String str) {
        removeStoredDate(mutablePreferences, str);
        HashSet hashSet = new HashSet((Collection) JavaDataStorageKt.getOrDefault(mutablePreferences, key, new HashSet()));
        hashSet.add(str);
        mutablePreferences.set(key, hashSet);
    }

    public synchronized void deleteAllHeartBeats() {
        this.firebaseDataStore.editSync(new l() { // from class: com.google.firebase.heartbeatinfo.e
            @Override // e6.l
            public final Object invoke(Object obj) {
                return this.f5612a.lambda$deleteAllHeartBeats$0((MutablePreferences) obj);
            }
        });
    }

    public synchronized List<HeartBeatResult> getAllHeartBeats() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            String formattedDate = getFormattedDate(System.currentTimeMillis());
            for (Map.Entry<Preferences.Key<?>, Object> entry : this.firebaseDataStore.getAllSync().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(formattedDate);
                    if (!hashSet.isEmpty()) {
                        arrayList.add(HeartBeatResult.create(entry.getKey().getName(), new ArrayList(hashSet)));
                    }
                }
            }
            updateGlobalHeartBeat(System.currentTimeMillis());
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    @VisibleForTesting
    public int getHeartBeatCount() {
        return ((Long) this.firebaseDataStore.getSync(HEART_BEAT_COUNT_TAG, 0L)).intValue();
    }

    public synchronized long getLastGlobalHeartBeat() {
        return ((Long) this.firebaseDataStore.getSync(GLOBAL, -1L)).longValue();
    }

    public synchronized boolean isSameDateUtc(long j, long j3) {
        return getFormattedDate(j).equals(getFormattedDate(j3));
    }

    public synchronized void postHeartBeatCleanUp() {
        final String formattedDate = getFormattedDate(System.currentTimeMillis());
        this.firebaseDataStore.editSync(new l() { // from class: com.google.firebase.heartbeatinfo.f
            @Override // e6.l
            public final Object invoke(Object obj) {
                return this.f5613a.lambda$postHeartBeatCleanUp$1(formattedDate, (MutablePreferences) obj);
            }
        });
    }

    public synchronized boolean shouldSendGlobalHeartBeat(long j) {
        return shouldSendSdkHeartBeat(GLOBAL, j);
    }

    public synchronized boolean shouldSendSdkHeartBeat(Preferences.Key<Long> key, long j) {
        if (isSameDateUtc(((Long) this.firebaseDataStore.getSync(key, -1L)).longValue(), j)) {
            return false;
        }
        this.firebaseDataStore.putSync(key, Long.valueOf(j));
        return true;
    }

    public synchronized void storeHeartBeat(long j, final String str) {
        final String formattedDate = getFormattedDate(j);
        final Preferences.Key<Set<String>> keyStringSetKey = PreferencesKeys.stringSetKey(str);
        this.firebaseDataStore.editSync(new l() { // from class: com.google.firebase.heartbeatinfo.d
            @Override // e6.l
            public final Object invoke(Object obj) {
                return this.f5608a.lambda$storeHeartBeat$2(formattedDate, str, keyStringSetKey, (MutablePreferences) obj);
            }
        });
    }

    public synchronized void updateGlobalHeartBeat(final long j) {
        this.firebaseDataStore.editSync(new l() { // from class: com.google.firebase.heartbeatinfo.g
            @Override // e6.l
            public final Object invoke(Object obj) {
                return HeartBeatInfoStorage.lambda$updateGlobalHeartBeat$3(j, (MutablePreferences) obj);
            }
        });
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    @VisibleForTesting
    public HeartBeatInfoStorage(JavaDataStorage javaDataStorage) {
        this.firebaseDataStore = javaDataStorage;
    }
}
