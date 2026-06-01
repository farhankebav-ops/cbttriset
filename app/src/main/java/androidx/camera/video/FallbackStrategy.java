package androidx.camera.video;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class FallbackStrategy {
    static final int FALLBACK_RULE_HIGHER = 2;
    static final int FALLBACK_RULE_HIGHER_OR_LOWER = 1;
    static final int FALLBACK_RULE_LOWER = 4;
    static final int FALLBACK_RULE_LOWER_OR_HIGHER = 3;
    static final int FALLBACK_RULE_NONE = 0;
    static final FallbackStrategy NONE = new AutoValue_FallbackStrategy_RuleStrategy(Quality.NONE, 0);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class RuleStrategy extends FallbackStrategy {
        public RuleStrategy() {
            super();
        }

        public abstract Quality getFallbackQuality();

        public abstract int getFallbackRule();
    }

    public static FallbackStrategy higherQualityOrLowerThan(Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 1);
    }

    public static FallbackStrategy higherQualityThan(Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 2);
    }

    public static FallbackStrategy lowerQualityOrHigherThan(Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 3);
    }

    public static FallbackStrategy lowerQualityThan(Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 4);
    }

    private FallbackStrategy() {
    }
}
