package androidx.camera.featurecombinationquery;

import android.hardware.camera2.params.OutputConfiguration;
import androidx.camera.featurecombinationquery.SessionParametersLegacy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class SessionConfigurationLegacy {
    private final List<OutputConfiguration> mOutputConfigs;
    private final SessionParametersLegacy mSessionParams;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private final ArrayList<OutputConfiguration> mOutputConfigs = new ArrayList<>();
        private SessionParametersLegacy mSessionParams = new SessionParametersLegacy.Builder().build();

        public Builder addOutputConfiguration(OutputConfiguration outputConfiguration) {
            this.mOutputConfigs.add(outputConfiguration);
            return this;
        }

        public Builder addOutputConfigurations(Collection<OutputConfiguration> collection) {
            this.mOutputConfigs.addAll(collection);
            return this;
        }

        public SessionConfigurationLegacy build() {
            ArrayList<OutputConfiguration> arrayList = this.mOutputConfigs;
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                OutputConfiguration outputConfiguration = arrayList.get(i2);
                i2++;
                Objects.requireNonNull(outputConfiguration);
                arrayList2.add(outputConfiguration);
            }
            return new SessionConfigurationLegacy(Collections.unmodifiableList(arrayList2), this.mSessionParams);
        }

        public Builder setSessionParameters(SessionParametersLegacy sessionParametersLegacy) {
            this.mSessionParams = sessionParametersLegacy;
            return this;
        }
    }

    public List<OutputConfiguration> getOutputConfigurations() {
        return this.mOutputConfigs;
    }

    public SessionParametersLegacy getSessionParameters() {
        return this.mSessionParams;
    }

    private SessionConfigurationLegacy(List<OutputConfiguration> list, SessionParametersLegacy sessionParametersLegacy) {
        this.mOutputConfigs = list;
        this.mSessionParams = sessionParametersLegacy;
    }
}
