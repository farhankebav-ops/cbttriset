package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.k;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class GetTopicsResponse {
    private final List<EncryptedTopic> encryptedTopics;
    private final List<Topic> topics;

    @ExperimentalFeatures.Ext11OptIn
    public GetTopicsResponse(List<Topic> topics, List<EncryptedTopic> encryptedTopics) {
        k.e(topics, "topics");
        k.e(encryptedTopics, "encryptedTopics");
        this.topics = topics;
        this.encryptedTopics = encryptedTopics;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsResponse)) {
            return false;
        }
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        return this.topics.size() == getTopicsResponse.topics.size() && this.encryptedTopics.size() == getTopicsResponse.encryptedTopics.size() && new HashSet(this.topics).equals(new HashSet(getTopicsResponse.topics)) && new HashSet(this.encryptedTopics).equals(new HashSet(getTopicsResponse.encryptedTopics));
    }

    public final List<EncryptedTopic> getEncryptedTopics() {
        return this.encryptedTopics;
    }

    public final List<Topic> getTopics() {
        return this.topics;
    }

    public int hashCode() {
        return Objects.hash(this.topics, this.encryptedTopics);
    }

    public String toString() {
        return "GetTopicsResponse: Topics=" + this.topics + ", EncryptedTopics=" + this.encryptedTopics;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetTopicsResponse(List<Topic> topics) {
        this(topics, r.f13638a);
        k.e(topics, "topics");
    }
}
