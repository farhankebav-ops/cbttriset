package androidx.privacysandbox.ads.adservices.customaudience;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class JoinCustomAudienceRequest {
    private final CustomAudience customAudience;

    public JoinCustomAudienceRequest(CustomAudience customAudience) {
        k.e(customAudience, "customAudience");
        this.customAudience = customAudience;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JoinCustomAudienceRequest) {
            return k.a(this.customAudience, ((JoinCustomAudienceRequest) obj).customAudience);
        }
        return false;
    }

    public final CustomAudience getCustomAudience() {
        return this.customAudience;
    }

    public int hashCode() {
        return this.customAudience.hashCode();
    }

    public String toString() {
        return "JoinCustomAudience: customAudience=" + this.customAudience;
    }
}
