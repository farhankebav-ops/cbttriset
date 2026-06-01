package com.vungle.ads.internal.persistence;

import androidx.annotation.VisibleForTesting;
import com.unity3d.services.ads.operation.show.b;
import com.vungle.ads.internal.util.CollectionsConcurrencyUtil;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.PathProvider;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FilePreferences {
    public static final String FILENAME = "settings_vungle";
    public static final String TPAT_FAILED_FILENAME = "vngFailedTpats";
    private final File file;
    private final Executor ioExecutor;
    private final ConcurrentHashMap<String, Object> values;
    public static final Companion Companion = new Companion(null);
    private static final ConcurrentHashMap<String, FilePreferences> filePreferenceMap = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ FilePreferences get$default(Companion companion, Executor executor, PathProvider pathProvider, String str, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                str = FilePreferences.FILENAME;
            }
            return companion.get(executor, pathProvider, str);
        }

        public final synchronized FilePreferences get(Executor ioExecutor, PathProvider pathProvider, String filename) {
            Object filePreferences;
            Object objPutIfAbsent;
            try {
                k.e(ioExecutor, "ioExecutor");
                k.e(pathProvider, "pathProvider");
                k.e(filename, "filename");
                ConcurrentHashMap concurrentHashMap = FilePreferences.filePreferenceMap;
                filePreferences = concurrentHashMap.get(filename);
                if (filePreferences == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(filename, (filePreferences = new FilePreferences(ioExecutor, pathProvider, filename, null)))) != null) {
                    filePreferences = objPutIfAbsent;
                }
            } catch (Throwable th) {
                throw th;
            }
            return (FilePreferences) filePreferences;
        }

        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getFILENAME$annotations() {
        }
    }

    public /* synthetic */ FilePreferences(Executor executor, PathProvider pathProvider, String str, f fVar) {
        this(executor, pathProvider, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: apply$lambda-0, reason: not valid java name */
    public static final void m3332apply$lambda0(FilePreferences this$0, Serializable serializable) throws Throwable {
        k.e(this$0, "this$0");
        k.e(serializable, "$serializable");
        FileUtility.writeSerializable(this$0.file, serializable);
    }

    public static final synchronized FilePreferences get(Executor executor, PathProvider pathProvider, String str) {
        return Companion.get(executor, pathProvider, str);
    }

    public final void apply() {
        this.ioExecutor.execute(new b(10, this, new HashMap(this.values)));
    }

    public final boolean getBoolean(String key, boolean z2) {
        k.e(key, "key");
        Object obj = this.values.get(key);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z2;
    }

    public final int getInt(String key, int i2) {
        k.e(key, "key");
        Object obj = this.values.get(key);
        return obj instanceof Integer ? ((Number) obj).intValue() : i2;
    }

    public final long getLong(String key, long j) {
        k.e(key, "key");
        Object obj = this.values.get(key);
        return obj instanceof Long ? ((Number) obj).longValue() : j;
    }

    public final String getString(String key, String defaultValue) {
        k.e(key, "key");
        k.e(defaultValue, "defaultValue");
        Object obj = this.values.get(key);
        return obj instanceof String ? (String) obj : defaultValue;
    }

    public final HashSet<String> getStringSet(String key, HashSet<String> defaultValue) {
        k.e(key, "key");
        k.e(defaultValue, "defaultValue");
        Object obj = this.values.get(key);
        return obj instanceof HashSet ? CollectionsConcurrencyUtil.getNewHashSet((HashSet) obj) : defaultValue;
    }

    public final FilePreferences put(String key, boolean z2) {
        k.e(key, "key");
        this.values.put(key, Boolean.valueOf(z2));
        return this;
    }

    public final FilePreferences remove(String key) {
        k.e(key, "key");
        if (this.values.containsKey(key)) {
            this.values.remove(key);
        }
        return this;
    }

    private FilePreferences(Executor executor, PathProvider pathProvider, String str) throws Throwable {
        this.ioExecutor = executor;
        File file = new File(pathProvider.getSharedPrefsDir(), str);
        this.file = file;
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        this.values = concurrentHashMap;
        Object serializable = FileUtility.readSerializable(file);
        if (serializable instanceof HashMap) {
            concurrentHashMap.putAll((HashMap) serializable);
        }
    }

    public final FilePreferences put(String key, String value) {
        k.e(key, "key");
        k.e(value, "value");
        this.values.put(key, value);
        return this;
    }

    public final Boolean getBoolean(String key) {
        k.e(key, "key");
        Object obj = this.values.get(key);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        return null;
    }

    public final String getString(String key) {
        k.e(key, "key");
        Object obj = this.values.get(key);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final FilePreferences put(String key, int i2) {
        k.e(key, "key");
        this.values.put(key, Integer.valueOf(i2));
        return this;
    }

    public final FilePreferences put(String key, HashSet<String> hashSet) {
        k.e(key, "key");
        this.values.put(key, CollectionsConcurrencyUtil.getNewHashSet(hashSet));
        return this;
    }

    public final FilePreferences put(String key, long j) {
        k.e(key, "key");
        this.values.put(key, Long.valueOf(j));
        return this;
    }

    public /* synthetic */ FilePreferences(Executor executor, PathProvider pathProvider, String str, int i2, f fVar) {
        this(executor, pathProvider, (i2 & 4) != 0 ? FILENAME : str);
    }
}
