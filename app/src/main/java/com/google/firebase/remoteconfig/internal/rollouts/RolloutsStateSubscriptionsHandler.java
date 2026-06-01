package com.google.firebase.remoteconfig.internal.rollouts;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.camera.core.processing.h;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsState;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class RolloutsStateSubscriptionsHandler {
    private ConfigCacheClient activatedConfigsCache;
    private Executor executor;
    private RolloutsStateFactory rolloutsStateFactory;
    private Set<RolloutsStateSubscriber> subscribers = Collections.newSetFromMap(new ConcurrentHashMap());

    public RolloutsStateSubscriptionsHandler(@NonNull ConfigCacheClient configCacheClient, @NonNull RolloutsStateFactory rolloutsStateFactory, @NonNull Executor executor) {
        this.activatedConfigsCache = configCacheClient;
        this.rolloutsStateFactory = rolloutsStateFactory;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerRolloutsStateSubscriber$1(Task task, RolloutsStateSubscriber rolloutsStateSubscriber, ConfigContainer configContainer) {
        try {
            ConfigContainer configContainer2 = (ConfigContainer) task.getResult();
            if (configContainer2 != null) {
                this.executor.execute(new a(rolloutsStateSubscriber, this.rolloutsStateFactory.getActiveRolloutsState(configContainer2), 0));
            }
        } catch (FirebaseRemoteConfigException e) {
            Log.w(FirebaseRemoteConfig.TAG, "Exception publishing RolloutsState to subscriber. Continuing to listen for changes.", e);
        }
    }

    public void publishActiveRolloutsState(@NonNull ConfigContainer configContainer) {
        try {
            RolloutsState activeRolloutsState = this.rolloutsStateFactory.getActiveRolloutsState(configContainer);
            Iterator<RolloutsStateSubscriber> it = this.subscribers.iterator();
            while (it.hasNext()) {
                this.executor.execute(new a(it.next(), activeRolloutsState, 1));
            }
        } catch (FirebaseRemoteConfigException e) {
            Log.w(FirebaseRemoteConfig.TAG, "Exception publishing RolloutsState to subscribers. Continuing to listen for changes.", e);
        }
    }

    public void registerRolloutsStateSubscriber(@NonNull RolloutsStateSubscriber rolloutsStateSubscriber) {
        this.subscribers.add(rolloutsStateSubscriber);
        Task<ConfigContainer> task = this.activatedConfigsCache.get();
        task.addOnSuccessListener(this.executor, new h(this, task, rolloutsStateSubscriber, 7));
    }
}
