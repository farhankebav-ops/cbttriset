package androidx.camera.video;

import androidx.camera.video.FallbackStrategy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_FallbackStrategy_RuleStrategy extends FallbackStrategy.RuleStrategy {
    private final Quality fallbackQuality;
    private final int fallbackRule;

    public AutoValue_FallbackStrategy_RuleStrategy(Quality quality, int i2) {
        if (quality == null) {
            throw new NullPointerException("Null fallbackQuality");
        }
        this.fallbackQuality = quality;
        this.fallbackRule = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FallbackStrategy.RuleStrategy) {
            FallbackStrategy.RuleStrategy ruleStrategy = (FallbackStrategy.RuleStrategy) obj;
            if (this.fallbackQuality.equals(ruleStrategy.getFallbackQuality()) && this.fallbackRule == ruleStrategy.getFallbackRule()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.FallbackStrategy.RuleStrategy
    public Quality getFallbackQuality() {
        return this.fallbackQuality;
    }

    @Override // androidx.camera.video.FallbackStrategy.RuleStrategy
    public int getFallbackRule() {
        return this.fallbackRule;
    }

    public int hashCode() {
        return ((this.fallbackQuality.hashCode() ^ 1000003) * 1000003) ^ this.fallbackRule;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RuleStrategy{fallbackQuality=");
        sb.append(this.fallbackQuality);
        sb.append(", fallbackRule=");
        return a1.a.q(sb, "}", this.fallbackRule);
    }
}
