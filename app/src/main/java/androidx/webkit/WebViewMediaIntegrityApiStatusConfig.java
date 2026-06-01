package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class WebViewMediaIntegrityApiStatusConfig {
    public static final int WEBVIEW_MEDIA_INTEGRITY_API_DISABLED = 0;
    public static final int WEBVIEW_MEDIA_INTEGRITY_API_ENABLED = 2;
    public static final int WEBVIEW_MEDIA_INTEGRITY_API_ENABLED_WITHOUT_APP_IDENTITY = 1;
    private final int mDefaultStatus;
    private final Map<String, Integer> mOverrideRules;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private final int mDefaultStatus;
        private Map<String, Integer> mOverrideRules = new HashMap();

        public Builder(int i2) {
            this.mDefaultStatus = i2;
        }

        @NonNull
        public Builder addOverrideRule(@NonNull String str, int i2) {
            this.mOverrideRules.put(str, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        public WebViewMediaIntegrityApiStatusConfig build() {
            return new WebViewMediaIntegrityApiStatusConfig(this);
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder setOverrideRules(@NonNull Map<String, Integer> map) {
            this.mOverrideRules = map;
            return this;
        }
    }

    public WebViewMediaIntegrityApiStatusConfig(@NonNull Builder builder) {
        this.mDefaultStatus = builder.mDefaultStatus;
        this.mOverrideRules = builder.mOverrideRules;
    }

    public int getDefaultStatus() {
        return this.mDefaultStatus;
    }

    @NonNull
    public Map<String, Integer> getOverrideRules() {
        return this.mOverrideRules;
    }
}
