package androidx.camera.core.impl;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class UseCaseAttachState {
    private static final String TAG = "UseCaseAttachState";
    private final Map<String, UseCaseAttachInfo> mAttachedUseCasesToInfoMap = new LinkedHashMap();
    private final String mCameraId;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface AttachStateFilter {
        boolean filter(UseCaseAttachInfo useCaseAttachInfo);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class UseCaseAttachInfo {
        private final List<UseCaseConfigFactory.CaptureType> mCaptureTypes;
        private final SessionConfig mSessionConfig;
        private final StreamSpec mStreamSpec;
        private final UseCaseConfig<?> mUseCaseConfig;
        private boolean mAttached = false;
        private boolean mActive = false;

        public UseCaseAttachInfo(SessionConfig sessionConfig, UseCaseConfig<?> useCaseConfig, StreamSpec streamSpec, List<UseCaseConfigFactory.CaptureType> list) {
            this.mSessionConfig = sessionConfig;
            this.mUseCaseConfig = useCaseConfig;
            this.mStreamSpec = streamSpec;
            this.mCaptureTypes = list;
        }

        public boolean getActive() {
            return this.mActive;
        }

        public boolean getAttached() {
            return this.mAttached;
        }

        public List<UseCaseConfigFactory.CaptureType> getCaptureTypes() {
            return this.mCaptureTypes;
        }

        public SessionConfig getSessionConfig() {
            return this.mSessionConfig;
        }

        public StreamSpec getStreamSpec() {
            return this.mStreamSpec;
        }

        public UseCaseConfig<?> getUseCaseConfig() {
            return this.mUseCaseConfig;
        }

        public void setActive(boolean z2) {
            this.mActive = z2;
        }

        public void setAttached(boolean z2) {
            this.mAttached = z2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("UseCaseAttachInfo{mSessionConfig=");
            sb.append(this.mSessionConfig);
            sb.append(", mUseCaseConfig=");
            sb.append(this.mUseCaseConfig);
            sb.append(", mStreamSpec=");
            sb.append(this.mStreamSpec);
            sb.append(", mCaptureTypes=");
            sb.append(this.mCaptureTypes);
            sb.append(", mAttached=");
            sb.append(this.mAttached);
            sb.append(", mActive=");
            return a1.a.t(sb, this.mActive, '}');
        }
    }

    public UseCaseAttachState(String str) {
        this.mCameraId = str;
    }

    private UseCaseAttachInfo getOrCreateUseCaseAttachInfo(String str, SessionConfig sessionConfig, UseCaseConfig<?> useCaseConfig, StreamSpec streamSpec, List<UseCaseConfigFactory.CaptureType> list) {
        UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(str);
        if (useCaseAttachInfo != null) {
            return useCaseAttachInfo;
        }
        UseCaseAttachInfo useCaseAttachInfo2 = new UseCaseAttachInfo(sessionConfig, useCaseConfig, streamSpec, list);
        this.mAttachedUseCasesToInfoMap.put(str, useCaseAttachInfo2);
        return useCaseAttachInfo2;
    }

    private Collection<SessionConfig> getSessionConfigs(AttachStateFilter attachStateFilter) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.mAttachedUseCasesToInfoMap.entrySet()) {
            if (attachStateFilter == null || attachStateFilter.filter(entry.getValue())) {
                arrayList.add(entry.getValue().getSessionConfig());
            }
        }
        return arrayList;
    }

    private Collection<UseCaseConfig<?>> getUseCaseConfigs(AttachStateFilter attachStateFilter) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.mAttachedUseCasesToInfoMap.entrySet()) {
            if (attachStateFilter == null || attachStateFilter.filter(entry.getValue())) {
                arrayList.add(entry.getValue().getUseCaseConfig());
            }
        }
        return arrayList;
    }

    private Collection<UseCaseAttachInfo> getUseCaseInfo(AttachStateFilter attachStateFilter) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.mAttachedUseCasesToInfoMap.entrySet()) {
            if (attachStateFilter == null || attachStateFilter.filter(entry.getValue())) {
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getActiveAndAttachedSessionConfigs$3(UseCaseAttachInfo useCaseAttachInfo) {
        return useCaseAttachInfo.getActive() && useCaseAttachInfo.getAttached();
    }

    public SessionConfig.ValidatingBuilder getActiveAndAttachedBuilder() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.mAttachedUseCasesToInfoMap.entrySet()) {
            UseCaseAttachInfo value = entry.getValue();
            if (value.getActive() && value.getAttached()) {
                String key = entry.getKey();
                validatingBuilder.add(value.getSessionConfig());
                arrayList.add(key);
            }
        }
        Logger.d(TAG, "Active and attached use case: " + arrayList + " for camera: " + this.mCameraId);
        return validatingBuilder;
    }

    public Collection<SessionConfig> getActiveAndAttachedSessionConfigs() {
        return Collections.unmodifiableCollection(getSessionConfigs(new b0(3)));
    }

    public SessionConfig.ValidatingBuilder getAttachedBuilder() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.mAttachedUseCasesToInfoMap.entrySet()) {
            UseCaseAttachInfo value = entry.getValue();
            if (value.getAttached()) {
                validatingBuilder.add(value.getSessionConfig());
                arrayList.add(entry.getKey());
            }
        }
        Logger.d(TAG, "All use case: " + arrayList + " for camera: " + this.mCameraId);
        return validatingBuilder;
    }

    public Collection<SessionConfig> getAttachedSessionConfigs() {
        return Collections.unmodifiableCollection(getSessionConfigs(new b0(1)));
    }

    public Collection<UseCaseConfig<?>> getAttachedUseCaseConfigs() {
        return Collections.unmodifiableCollection(getUseCaseConfigs(new b0(2)));
    }

    public Collection<UseCaseAttachInfo> getAttachedUseCaseInfo() {
        return Collections.unmodifiableCollection(getUseCaseInfo(new b0(0)));
    }

    public boolean isUseCaseAttached(String str) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            return this.mAttachedUseCasesToInfoMap.get(str).getAttached();
        }
        return false;
    }

    public void removeUseCase(String str) {
        this.mAttachedUseCasesToInfoMap.remove(str);
    }

    public void setUseCaseActive(String str, SessionConfig sessionConfig, UseCaseConfig<?> useCaseConfig, StreamSpec streamSpec, List<UseCaseConfigFactory.CaptureType> list) {
        getOrCreateUseCaseAttachInfo(str, sessionConfig, useCaseConfig, streamSpec, list).setActive(true);
    }

    public void setUseCaseAttached(String str, SessionConfig sessionConfig, UseCaseConfig<?> useCaseConfig, StreamSpec streamSpec, List<UseCaseConfigFactory.CaptureType> list) {
        getOrCreateUseCaseAttachInfo(str, sessionConfig, useCaseConfig, streamSpec, list).setAttached(true);
        updateUseCase(str, sessionConfig, useCaseConfig, streamSpec, list);
    }

    public void setUseCaseDetached(String str) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(str);
            useCaseAttachInfo.setAttached(false);
            if (useCaseAttachInfo.getActive()) {
                return;
            }
            this.mAttachedUseCasesToInfoMap.remove(str);
        }
    }

    public void setUseCaseInactive(String str) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(str);
            useCaseAttachInfo.setActive(false);
            if (useCaseAttachInfo.getAttached()) {
                return;
            }
            this.mAttachedUseCasesToInfoMap.remove(str);
        }
    }

    public void updateUseCase(String str, SessionConfig sessionConfig, UseCaseConfig<?> useCaseConfig, StreamSpec streamSpec, List<UseCaseConfigFactory.CaptureType> list) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            UseCaseAttachInfo useCaseAttachInfo = new UseCaseAttachInfo(sessionConfig, useCaseConfig, streamSpec, list);
            UseCaseAttachInfo useCaseAttachInfo2 = this.mAttachedUseCasesToInfoMap.get(str);
            useCaseAttachInfo.setAttached(useCaseAttachInfo2.getAttached());
            useCaseAttachInfo.setActive(useCaseAttachInfo2.getActive());
            this.mAttachedUseCasesToInfoMap.put(str, useCaseAttachInfo);
        }
    }
}
