package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.k;
import n6.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFeatures.Ext11OptIn
public final class EncryptedTopic {
    private final byte[] encapsulatedKey;
    private final byte[] encryptedTopic;
    private final String keyIdentifier;

    public EncryptedTopic(byte[] encryptedTopic, String keyIdentifier, byte[] encapsulatedKey) {
        k.e(encryptedTopic, "encryptedTopic");
        k.e(keyIdentifier, "keyIdentifier");
        k.e(encapsulatedKey, "encapsulatedKey");
        this.encryptedTopic = encryptedTopic;
        this.keyIdentifier = keyIdentifier;
        this.encapsulatedKey = encapsulatedKey;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncryptedTopic)) {
            return false;
        }
        EncryptedTopic encryptedTopic = (EncryptedTopic) obj;
        return Arrays.equals(this.encryptedTopic, encryptedTopic.encryptedTopic) && this.keyIdentifier.contentEquals(encryptedTopic.keyIdentifier) && Arrays.equals(this.encapsulatedKey, encryptedTopic.encapsulatedKey);
    }

    public final byte[] getEncapsulatedKey() {
        return this.encapsulatedKey;
    }

    public final byte[] getEncryptedTopic() {
        return this.encryptedTopic;
    }

    public final String getKeyIdentifier() {
        return this.keyIdentifier;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.encryptedTopic)), this.keyIdentifier, Integer.valueOf(Arrays.hashCode(this.encapsulatedKey)));
    }

    public String toString() {
        return a1.a.l("EncryptedTopic { ", "EncryptedTopic=" + t.e0(this.encryptedTopic) + ", KeyIdentifier=" + this.keyIdentifier + ", EncapsulatedKey=" + t.e0(this.encapsulatedKey) + " }");
    }
}
