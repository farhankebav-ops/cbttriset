package androidx.privacysandbox.ads.adservices.topics;

import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.customaudience.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class GetTopicsResponseHelper {
    public static final GetTopicsResponseHelper INSTANCE = new GetTopicsResponseHelper();

    private GetTopicsResponseHelper() {
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    public final GetTopicsResponse convertResponse$ads_adservices_release(android.adservices.topics.GetTopicsResponse response) {
        k.e(response, "response");
        ArrayList arrayList = new ArrayList();
        Iterator it = response.getTopics().iterator();
        while (it.hasNext()) {
            android.adservices.topics.Topic topicR = androidx.privacysandbox.ads.adservices.measurement.a.r(it.next());
            arrayList.add(new Topic(topicR.getTaxonomyVersion(), topicR.getModelVersion(), topicR.getTopicId()));
        }
        return new GetTopicsResponse(arrayList);
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 11), @RequiresExtension(extension = 31, version = 11)})
    @ExperimentalFeatures.Ext11OptIn
    public final GetTopicsResponse convertResponseWithEncryptedTopics$ads_adservices_release(android.adservices.topics.GetTopicsResponse response) {
        k.e(response, "response");
        ArrayList arrayList = new ArrayList();
        Iterator it = response.getTopics().iterator();
        while (it.hasNext()) {
            android.adservices.topics.Topic topicR = androidx.privacysandbox.ads.adservices.measurement.a.r(it.next());
            arrayList.add(new Topic(topicR.getTaxonomyVersion(), topicR.getModelVersion(), topicR.getTopicId()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = response.getEncryptedTopics().iterator();
        while (it2.hasNext()) {
            android.adservices.topics.EncryptedTopic encryptedTopicI = b.i(it2.next());
            byte[] encryptedTopic = encryptedTopicI.getEncryptedTopic();
            k.d(encryptedTopic, "encryptedTopic.encryptedTopic");
            String keyIdentifier = encryptedTopicI.getKeyIdentifier();
            k.d(keyIdentifier, "encryptedTopic.keyIdentifier");
            byte[] encapsulatedKey = encryptedTopicI.getEncapsulatedKey();
            k.d(encapsulatedKey, "encryptedTopic.encapsulatedKey");
            arrayList2.add(new EncryptedTopic(encryptedTopic, keyIdentifier, encapsulatedKey));
        }
        return new GetTopicsResponse(arrayList, arrayList2);
    }
}
