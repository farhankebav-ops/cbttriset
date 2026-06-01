package com.onesignal.inAppMessages.internal;

import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.t;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Trigger {
    private final OSTriggerKind kind;
    private final OSTriggerOperator operatorType;
    private final String property;
    private final String triggerId;
    private final Object value;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum OSTriggerKind {
        TIME_SINCE_LAST_IN_APP("min_time_since"),
        SESSION_TIME("session_time"),
        CUSTOM(NotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM),
        UNKNOWN("unknown");

        public static final Companion Companion = new Companion(null);
        private final String value;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final OSTriggerKind fromString(String str) {
                for (OSTriggerKind oSTriggerKind : OSTriggerKind.values()) {
                    if (t.g0(oSTriggerKind.value, str)) {
                        return oSTriggerKind;
                    }
                }
                return OSTriggerKind.UNKNOWN;
            }

            private Companion() {
            }
        }

        OSTriggerKind(String str) {
            this.value = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum OSTriggerOperator {
        GREATER_THAN("greater"),
        LESS_THAN("less"),
        EQUAL_TO("equal"),
        NOT_EQUAL_TO("not_equal"),
        LESS_THAN_OR_EQUAL_TO("less_or_equal"),
        GREATER_THAN_OR_EQUAL_TO("greater_or_equal"),
        EXISTS("exists"),
        NOT_EXISTS("not_exists"),
        CONTAINS(ScarConstants.IN_SIGNAL_KEY);

        public static final Companion Companion = new Companion(null);
        private final String text;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final OSTriggerOperator fromString(String str) {
                for (OSTriggerOperator oSTriggerOperator : OSTriggerOperator.values()) {
                    if (t.g0(oSTriggerOperator.text, str)) {
                        return oSTriggerOperator;
                    }
                }
                return OSTriggerOperator.EQUAL_TO;
            }

            private Companion() {
            }
        }

        OSTriggerOperator(String str) {
            this.text = str;
        }

        public final boolean checksEquality() {
            return this == EQUAL_TO || this == NOT_EQUAL_TO;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.text;
        }
    }

    public Trigger(JSONObject json) throws JSONException {
        k.e(json, "json");
        String string = json.getString("id");
        k.d(string, "json.getString(\"id\")");
        this.triggerId = string;
        this.kind = OSTriggerKind.Companion.fromString(json.getString("kind"));
        this.property = json.optString("property", null);
        this.operatorType = OSTriggerOperator.Companion.fromString(json.getString("operator"));
        this.value = json.opt("value");
    }

    public final OSTriggerKind getKind() {
        return this.kind;
    }

    public final OSTriggerOperator getOperatorType() {
        return this.operatorType;
    }

    public final String getProperty() {
        return this.property;
    }

    public final String getTriggerId() {
        return this.triggerId;
    }

    public final Object getValue() {
        return this.value;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.triggerId);
            jSONObject.put("kind", this.kind);
            jSONObject.put("property", this.property);
            jSONObject.put("operator", this.operatorType.toString());
            jSONObject.put("value", this.value);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public String toString() {
        return "Trigger{triggerId='" + this.triggerId + "', kind=" + this.kind + ", property='" + this.property + "', operatorType=" + this.operatorType + ", value=" + this.value + '}';
    }
}
