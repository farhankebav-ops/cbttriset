package com.google.firebase.sessions;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.activity.u;
import androidx.datastore.DataStoreFile;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.MultiProcessDataStoreFactory;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.Binds;
import com.google.firebase.sessions.dagger.BindsInstance;
import com.google.firebase.sessions.dagger.Component;
import com.google.firebase.sessions.dagger.Module;
import com.google.firebase.sessions.dagger.Provides;
import com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher;
import com.google.firebase.sessions.settings.LocalOverrideSettings;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.sessions.settings.RemoteSettingsFetcher;
import com.google.firebase.sessions.settings.SessionConfigs;
import com.google.firebase.sessions.settings.SessionConfigsSerializer;
import com.google.firebase.sessions.settings.SessionsSettings;
import com.google.firebase.sessions.settings.SettingsCache;
import com.google.firebase.sessions.settings.SettingsCacheImpl;
import com.google.firebase.sessions.settings.SettingsProvider;
import e6.l;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.util.List;
import kotlin.jvm.internal.k;
import q6.a0;
import q6.c0;
import r5.r;
import v5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Component(modules = {MainModule.class})
public interface FirebaseSessionsComponent {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Component.Builder
    public interface Builder {
        @BindsInstance
        Builder appContext(Context context);

        @BindsInstance
        Builder backgroundDispatcher(@Background h hVar);

        @BindsInstance
        Builder blockingDispatcher(@Blocking h hVar);

        FirebaseSessionsComponent build();

        @BindsInstance
        Builder firebaseApp(FirebaseApp firebaseApp);

        @BindsInstance
        Builder firebaseInstallationsApi(FirebaseInstallationsApi firebaseInstallationsApi);

        @BindsInstance
        Builder transportFactoryProvider(Provider<m0.h> provider);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Module
    public interface MainModule {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            private final <T> DataStore<T> createDataStore(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list, a0 a0Var, e6.a aVar) {
                return loadDataStoreSharedCounter() ? MultiProcessDataStoreFactory.INSTANCE.create(serializer, replaceFileCorruptionHandler, list, a0Var, aVar) : DataStoreFactory.INSTANCE.create(serializer, replaceFileCorruptionHandler, list, a0Var, aVar);
            }

            public static /* synthetic */ DataStore createDataStore$default(Companion companion, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, a0 a0Var, e6.a aVar, int i2, Object obj) {
                if ((i2 & 4) != 0) {
                    list = r.f13638a;
                }
                return companion.createDataStore(serializer, replaceFileCorruptionHandler, list, a0Var, aVar);
            }

            private final boolean loadDataStoreSharedCounter() {
                try {
                    System.loadLibrary("datastore_shared_counter");
                    return true;
                } catch (SecurityException | UnsatisfiedLinkError unused) {
                    return false;
                }
            }

            private final void prepDataStoreFile(File file) throws IOException {
                File parentFile = file.getParentFile();
                if (parentFile == null) {
                    return;
                }
                if (parentFile.exists() && !parentFile.isDirectory() && k.a(parentFile.getName(), "firebaseSessions") && !parentFile.delete()) {
                    throw new IOException("Failed to delete conflicting file: " + parentFile);
                }
                if (parentFile.isDirectory()) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        Files.createDirectories(parentFile.toPath(), new FileAttribute[0]);
                        return;
                    } catch (Exception e) {
                        throw new IOException("Failed to create directory: " + parentFile, e);
                    }
                }
                if (parentFile.mkdirs() || parentFile.isDirectory()) {
                    return;
                }
                throw new IOException("Failed to create directory: " + parentFile);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final SessionConfigs sessionConfigsDataStore$lambda$0(CorruptionException ex) {
                k.e(ex, "ex");
                Log.w(FirebaseSessions.TAG, "CorruptionException in session configs DataStore", ex);
                return SessionConfigsSerializer.INSTANCE.getDefaultValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final File sessionConfigsDataStore$lambda$2(Context context) throws IOException {
                File fileDataStoreFile = DataStoreFile.dataStoreFile(context, "firebaseSessions/sessionConfigsDataStore.data");
                $$INSTANCE.prepDataStoreFile(fileDataStoreFile);
                return fileDataStoreFile;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final SessionData sessionDataStore$lambda$3(SessionDataSerializer sessionDataSerializer, CorruptionException ex) {
                k.e(ex, "ex");
                Log.w(FirebaseSessions.TAG, "CorruptionException in session data DataStore", ex);
                return sessionDataSerializer.getDefaultValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final File sessionDataStore$lambda$5(Context context) throws IOException {
                File fileDataStoreFile = DataStoreFile.dataStoreFile(context, "firebaseSessions/sessionDataStore.data");
                $$INSTANCE.prepDataStoreFile(fileDataStoreFile);
                return fileDataStoreFile;
            }

            @Provides
            public final ApplicationInfo applicationInfo(FirebaseApp firebaseApp) {
                k.e(firebaseApp, "firebaseApp");
                return SessionEvents.INSTANCE.getApplicationInfo(firebaseApp);
            }

            @Provides
            public final DataStore<SessionConfigs> sessionConfigsDataStore(Context appContext, @Blocking h blockingDispatcher) {
                k.e(appContext, "appContext");
                k.e(blockingDispatcher, "blockingDispatcher");
                return createDataStore$default(this, SessionConfigsSerializer.INSTANCE, new ReplaceFileCorruptionHandler(new u(8)), null, c0.b(blockingDispatcher), new c(appContext, 0), 4, null);
            }

            @Provides
            public final DataStore<SessionData> sessionDataStore(Context appContext, @Blocking h blockingDispatcher, final SessionDataSerializer sessionDataSerializer) {
                k.e(appContext, "appContext");
                k.e(blockingDispatcher, "blockingDispatcher");
                k.e(sessionDataSerializer, "sessionDataSerializer");
                return createDataStore$default(this, sessionDataSerializer, new ReplaceFileCorruptionHandler(new l() { // from class: com.google.firebase.sessions.d
                    @Override // e6.l
                    public final Object invoke(Object obj) {
                        return FirebaseSessionsComponent.MainModule.Companion.sessionDataStore$lambda$3(sessionDataSerializer, (CorruptionException) obj);
                    }
                }), null, c0.b(blockingDispatcher), new c(appContext, 1), 4, null);
            }

            @Provides
            public final TimeProvider timeProvider() {
                return TimeProviderImpl.INSTANCE;
            }

            @Provides
            public final UuidGenerator uuidGenerator() {
                return UuidGeneratorImpl.INSTANCE;
            }
        }

        @Binds
        CrashlyticsSettingsFetcher crashlyticsSettingsFetcher(RemoteSettingsFetcher remoteSettingsFetcher);

        @Binds
        EventGDTLoggerInterface eventGDTLoggerInterface(EventGDTLogger eventGDTLogger);

        @Binds
        @LocalOverrideSettingsProvider
        SettingsProvider localOverrideSettings(LocalOverrideSettings localOverrideSettings);

        @Binds
        ProcessDataManager processDataManager(ProcessDataManagerImpl processDataManagerImpl);

        @RemoteSettingsProvider
        @Binds
        SettingsProvider remoteSettings(RemoteSettings remoteSettings);

        @Binds
        SessionFirelogPublisher sessionFirelogPublisher(SessionFirelogPublisherImpl sessionFirelogPublisherImpl);

        @Binds
        SettingsCache settingsCache(SettingsCacheImpl settingsCacheImpl);

        @Binds
        SharedSessionRepository sharedSessionRepository(SharedSessionRepositoryImpl sharedSessionRepositoryImpl);
    }

    FirebaseSessions getFirebaseSessions();

    SessionFirelogPublisher getSessionFirelogPublisher();

    SessionGenerator getSessionGenerator();

    SessionsSettings getSessionsSettings();

    SharedSessionRepository getSharedSessionRepository();
}
