package com.unity3d.ads.core.data.model;

import com.google.protobuf.ByteString;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class SessionChange {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class PrivacyFsmChange extends SessionChange {
        private final ByteString value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrivacyFsmChange(ByteString value) {
            super(null);
            k.e(value, "value");
            this.value = value;
        }

        public static /* synthetic */ PrivacyFsmChange copy$default(PrivacyFsmChange privacyFsmChange, ByteString byteString, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                byteString = privacyFsmChange.value;
            }
            return privacyFsmChange.copy(byteString);
        }

        public final ByteString component1() {
            return this.value;
        }

        public final PrivacyFsmChange copy(ByteString value) {
            k.e(value, "value");
            return new PrivacyFsmChange(value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PrivacyFsmChange) && k.a(this.value, ((PrivacyFsmChange) obj).value);
        }

        public final ByteString getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "PrivacyFsmChange(value=" + this.value + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class UserConsentChange extends SessionChange {
        private final ByteString value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserConsentChange(ByteString value) {
            super(null);
            k.e(value, "value");
            this.value = value;
        }

        public static /* synthetic */ UserConsentChange copy$default(UserConsentChange userConsentChange, ByteString byteString, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                byteString = userConsentChange.value;
            }
            return userConsentChange.copy(byteString);
        }

        public final ByteString component1() {
            return this.value;
        }

        public final UserConsentChange copy(ByteString value) {
            k.e(value, "value");
            return new UserConsentChange(value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UserConsentChange) && k.a(this.value, ((UserConsentChange) obj).value);
        }

        public final ByteString getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "UserConsentChange(value=" + this.value + ')';
        }
    }

    public /* synthetic */ SessionChange(f fVar) {
        this();
    }

    private SessionChange() {
    }
}
