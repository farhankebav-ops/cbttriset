package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class Camera2SessionConfigBuilder {
    private int mSessionTemplateId = 1;
    private int mSessionType = 0;
    private Map<CaptureRequest.Key<?>, Object> mSessionParameters = new HashMap();
    private List<Camera2OutputConfig> mCamera2OutputConfigs = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class SessionConfigImpl implements Camera2SessionConfig {
        private final List<Camera2OutputConfig> mCamera2OutputConfigs;
        private final Map<CaptureRequest.Key<?>, Object> mSessionParameters;
        private final int mSessionTemplateId;
        private final int mSessionType;

        public SessionConfigImpl(int i2, int i8, Map<CaptureRequest.Key<?>, Object> map, List<Camera2OutputConfig> list) {
            this.mSessionTemplateId = i2;
            this.mSessionType = i8;
            this.mSessionParameters = map;
            this.mCamera2OutputConfigs = list;
        }

        @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2SessionConfig
        public List<Camera2OutputConfig> getOutputConfigs() {
            return this.mCamera2OutputConfigs;
        }

        @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2SessionConfig
        public Map<CaptureRequest.Key<?>, Object> getSessionParameters() {
            return this.mSessionParameters;
        }

        @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2SessionConfig
        public int getSessionTemplateId() {
            return this.mSessionTemplateId;
        }

        @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2SessionConfig
        public int getSessionType() {
            return this.mSessionType;
        }
    }

    public Camera2SessionConfigBuilder addOutputConfig(Camera2OutputConfig camera2OutputConfig) {
        this.mCamera2OutputConfigs.add(camera2OutputConfig);
        return this;
    }

    public Camera2SessionConfigBuilder addSessionParameter(CaptureRequest.Key key, Object obj) {
        this.mSessionParameters.put(key, obj);
        return this;
    }

    public Camera2SessionConfig build() {
        return new SessionConfigImpl(this.mSessionTemplateId, this.mSessionType, this.mSessionParameters, this.mCamera2OutputConfigs);
    }

    public List<Camera2OutputConfig> getCamera2OutputConfigs() {
        return this.mCamera2OutputConfigs;
    }

    public Map<CaptureRequest.Key<?>, Object> getSessionParameters() {
        return this.mSessionParameters;
    }

    public int getSessionTemplateId() {
        return this.mSessionTemplateId;
    }

    public Camera2SessionConfigBuilder setSessionTemplateId(int i2) {
        this.mSessionTemplateId = i2;
        return this;
    }

    public Camera2SessionConfigBuilder setSessionType(int i2) {
        this.mSessionType = i2;
        return this;
    }
}
