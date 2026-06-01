package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.RequestProcessor;
import androidx.camera.extensions.internal.RequestOptionConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class RequestBuilder {
    int mCaptureStageId;
    private List<Integer> mTargetOutputConfigIds = new ArrayList();
    private Map<CaptureRequest.Key<?>, Object> mParameters = new HashMap();
    private int mTemplateId = 1;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class RequestProcessorRequest implements RequestProcessor.Request {
        final int mCaptureStageId;
        final Config mParameterConfig;
        final List<Integer> mTargetOutputConfigIds;
        final int mTemplateId;

        public RequestProcessorRequest(List<Integer> list, Map<CaptureRequest.Key<?>, Object> map, int i2, int i8) {
            this.mTargetOutputConfigIds = list;
            this.mTemplateId = i2;
            this.mCaptureStageId = i8;
            RequestOptionConfig.Builder builder = new RequestOptionConfig.Builder();
            for (CaptureRequest.Key<?> key : map.keySet()) {
                builder.setCaptureRequestOption(key, map.get(key));
            }
            this.mParameterConfig = builder.build();
        }

        public int getCaptureStageId() {
            return this.mCaptureStageId;
        }

        @Override // androidx.camera.core.impl.RequestProcessor.Request
        public Config getParameters() {
            return this.mParameterConfig;
        }

        @Override // androidx.camera.core.impl.RequestProcessor.Request
        public List<Integer> getTargetOutputConfigIds() {
            return this.mTargetOutputConfigIds;
        }

        @Override // androidx.camera.core.impl.RequestProcessor.Request
        public int getTemplateId() {
            return this.mTemplateId;
        }
    }

    public RequestBuilder addTargetOutputConfigIds(int i2) {
        this.mTargetOutputConfigIds.add(Integer.valueOf(i2));
        return this;
    }

    public RequestProcessor.Request build() {
        return new RequestProcessorRequest(this.mTargetOutputConfigIds, this.mParameters, this.mTemplateId, this.mCaptureStageId);
    }

    public RequestBuilder setCaptureStageId(int i2) {
        this.mCaptureStageId = i2;
        return this;
    }

    public RequestBuilder setParameters(CaptureRequest.Key<?> key, Object obj) {
        this.mParameters.put(key, obj);
        return this;
    }

    public RequestBuilder setTemplateId(int i2) {
        this.mTemplateId = i2;
        return this;
    }
}
