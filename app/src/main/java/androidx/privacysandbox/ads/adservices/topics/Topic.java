package androidx.privacysandbox.ads.adservices.topics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class Topic {
    private final long modelVersion;
    private final long taxonomyVersion;
    private final int topicId;

    public Topic(long j, long j3, int i2) {
        this.taxonomyVersion = j;
        this.modelVersion = j3;
        this.topicId = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Topic)) {
            return false;
        }
        Topic topic = (Topic) obj;
        return this.taxonomyVersion == topic.taxonomyVersion && this.modelVersion == topic.modelVersion && this.topicId == topic.topicId;
    }

    public final long getModelVersion() {
        return this.modelVersion;
    }

    public final long getTaxonomyVersion() {
        return this.taxonomyVersion;
    }

    public final int getTopicId() {
        return this.topicId;
    }

    public int hashCode() {
        long j = this.taxonomyVersion;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        long j3 = this.modelVersion;
        return ((i2 + ((int) ((j3 >>> 32) ^ j3))) * 31) + this.topicId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TaxonomyVersion=");
        sb.append(this.taxonomyVersion);
        sb.append(", ModelVersion=");
        sb.append(this.modelVersion);
        sb.append(", TopicCode=");
        return a1.a.l("Topic { ", a1.a.q(sb, " }", this.topicId));
    }
}
