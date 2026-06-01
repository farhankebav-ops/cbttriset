package com.onesignal.inAppMessages.internal;

import com.onesignal.common.DateUtils;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.inAppMessages.IInAppMessage;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r5.l;
import r5.r;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppMessage implements IInAppMessage {
    public static final Companion Companion = new Companion(null);
    private static final String DISPLAY_DURATION = "displayDuration";
    private static final String END_TIME = "end_time";
    private static final String HAS_LIQUID = "has_liquid";
    private static final String IAM_ID = "messageId";
    private static final String IAM_REDISPLAY_STATS = "redisplay";
    private static final String IAM_TRIGGERS = "triggers";
    private static final String IAM_VARIANTS = "variants";
    private static final String ID = "id";
    private boolean actionTaken;
    private Set<String> clickedClickIds;
    private double displayDuration;
    private Date endTime;
    private boolean hasLiquid;
    private boolean isDisplayedInSession;
    private boolean isPreview;
    private boolean isTriggerChanged;
    private final String messageId;
    private InAppMessageRedisplayStats redisplayStats;
    private List<? extends List<Trigger>> triggers;
    private Map<String, ? extends Map<String, String>> variants;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public InAppMessage(String messageId, ITime time) {
        k.e(messageId, "messageId");
        k.e(time, "time");
        this.messageId = messageId;
        this.variants = s.f13639a;
        this.triggers = r.f13638a;
        this.clickedClickIds = new LinkedHashSet();
        this.redisplayStats = new InAppMessageRedisplayStats(time);
    }

    private final Date parseEndTimeJson(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(END_TIME);
            k.d(string, "{\n                json.g…g(END_TIME)\n            }");
            if (string.equals("null")) {
                return null;
            }
            try {
                return DateUtils.INSTANCE.iso8601Format().parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        } catch (JSONException unused) {
        }
    }

    private final ArrayList<ArrayList<Trigger>> parseTriggerJson(JSONArray jSONArray) throws JSONException {
        ArrayList<ArrayList<Trigger>> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i2);
            ArrayList<Trigger> arrayList2 = new ArrayList<>();
            int length2 = jSONArray2.length();
            for (int i8 = 0; i8 < length2; i8++) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i8);
                k.d(jSONObject, "ands.getJSONObject(j)");
                arrayList2.add(new Trigger(jSONObject));
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    private final HashMap<String, HashMap<String, String>> parseVariants(JSONObject jSONObject) throws JSONException {
        HashMap<String, HashMap<String, String>> map = new HashMap<>();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String variantType = itKeys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(variantType);
            HashMap<String, String> map2 = new HashMap<>();
            Iterator<String> itKeys2 = jSONObject2.keys();
            while (itKeys2.hasNext()) {
                String languageType = itKeys2.next();
                k.d(languageType, "languageType");
                String string = jSONObject2.getString(languageType);
                k.d(string, "variant.getString(languageType)");
                map2.put(languageType, string);
            }
            k.d(variantType, "variantType");
            map.put(variantType, map2);
        }
        return map;
    }

    public final void addClickId(String clickId) {
        k.e(clickId, "clickId");
        this.clickedClickIds.add(clickId);
    }

    public final void clearClickIds() {
        this.clickedClickIds.clear();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !InAppMessage.class.equals(obj.getClass())) {
            return false;
        }
        return k.a(getMessageId(), ((InAppMessage) obj).getMessageId());
    }

    public final Set<String> getClickedClickIds() {
        return this.clickedClickIds;
    }

    public final double getDisplayDuration() {
        return this.displayDuration;
    }

    public final boolean getHasLiquid() {
        return this.hasLiquid;
    }

    @Override // com.onesignal.inAppMessages.IInAppMessage
    public String getMessageId() {
        return this.messageId;
    }

    public final InAppMessageRedisplayStats getRedisplayStats() {
        return this.redisplayStats;
    }

    public final List<List<Trigger>> getTriggers() {
        return this.triggers;
    }

    public final Map<String, Map<String, String>> getVariants() {
        return this.variants;
    }

    public int hashCode() {
        return getMessageId().hashCode();
    }

    public final boolean isClickAvailable(String clickId) {
        k.e(clickId, "clickId");
        return !this.clickedClickIds.contains(clickId);
    }

    public final boolean isDisplayedInSession() {
        return this.isDisplayedInSession;
    }

    public final boolean isFinished() {
        if (this.endTime == null) {
            return false;
        }
        Date date = new Date();
        Date date2 = this.endTime;
        k.b(date2);
        return date2.before(date);
    }

    public final boolean isPreview() {
        return this.isPreview;
    }

    public final boolean isTriggerChanged() {
        return this.isTriggerChanged;
    }

    public final void removeClickId(String clickId) {
        k.e(clickId, "clickId");
        this.clickedClickIds.remove(clickId);
    }

    public final void setDisplayDuration(double d8) {
        this.displayDuration = d8;
    }

    public final void setDisplayedInSession(boolean z2) {
        this.isDisplayedInSession = z2;
    }

    public final void setTriggerChanged(boolean z2) {
        this.isTriggerChanged = z2;
    }

    public final boolean takeActionAsUnique() {
        if (this.actionTaken) {
            return false;
        }
        this.actionTaken = true;
        return true;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IAM_ID, getMessageId());
            JSONObject jSONObject2 = new JSONObject();
            for (String str : this.variants.keySet()) {
                Map<String, String> map = this.variants.get(str);
                k.b(map);
                Map<String, String> map2 = map;
                JSONObject jSONObject3 = new JSONObject();
                for (String str2 : map2.keySet()) {
                    jSONObject3.put(str2, map2.get(str2));
                }
                jSONObject2.put(str, jSONObject3);
            }
            jSONObject.put(IAM_VARIANTS, jSONObject2);
            jSONObject.put(DISPLAY_DURATION, this.displayDuration);
            jSONObject.put(IAM_REDISPLAY_STATS, this.redisplayStats.toJSONObject());
            JSONArray jSONArray = new JSONArray();
            for (List<Trigger> list : this.triggers) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<Trigger> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next().toJSONObject());
                }
                jSONArray.put(jSONArray2);
            }
            jSONObject.put(IAM_TRIGGERS, jSONArray);
            if (this.endTime != null) {
                jSONObject.put(END_TIME, DateUtils.INSTANCE.iso8601Format().format(this.endTime));
            }
            jSONObject.put(HAS_LIQUID, this.hasLiquid);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OSInAppMessage{messageId='");
        sb.append(getMessageId());
        sb.append("', variants=");
        sb.append(this.variants);
        sb.append(", triggers=");
        sb.append(this.triggers);
        sb.append(", clickedClickIds=");
        sb.append(this.clickedClickIds);
        sb.append(", redisplayStats=");
        sb.append(this.redisplayStats);
        sb.append(", displayDuration=");
        sb.append(this.displayDuration);
        sb.append(", displayedInSession=");
        sb.append(this.isDisplayedInSession);
        sb.append(", triggerChanged=");
        sb.append(this.isTriggerChanged);
        sb.append(", actionTaken=");
        sb.append(this.actionTaken);
        sb.append(", isPreview=");
        sb.append(this.isPreview);
        sb.append(", endTime=");
        sb.append(this.endTime);
        sb.append(", hasLiquid=");
        return a1.a.t(sb, this.hasLiquid, '}');
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InAppMessage(boolean z2, ITime time) {
        this("", time);
        k.e(time, "time");
        this.isPreview = z2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InAppMessage(String messageId, Set<String> clickIds, boolean z2, InAppMessageRedisplayStats redisplayStats, ITime time) {
        this(messageId, time);
        k.e(messageId, "messageId");
        k.e(clickIds, "clickIds");
        k.e(redisplayStats, "redisplayStats");
        k.e(time, "time");
        this.clickedClickIds = l.q1(clickIds);
        this.isDisplayedInSession = z2;
        this.redisplayStats = redisplayStats;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public InAppMessage(JSONObject json, ITime time) throws JSONException {
        k.e(json, "json");
        k.e(time, "time");
        String string = json.getString("id");
        k.d(string, "json.getString(ID)");
        this(string, time);
        JSONObject jSONObject = json.getJSONObject(IAM_VARIANTS);
        k.d(jSONObject, "json.getJSONObject(IAM_VARIANTS)");
        this.variants = parseVariants(jSONObject);
        JSONArray jSONArray = json.getJSONArray(IAM_TRIGGERS);
        k.d(jSONArray, "json.getJSONArray(IAM_TRIGGERS)");
        this.triggers = parseTriggerJson(jSONArray);
        this.endTime = parseEndTimeJson(json);
        if (json.has(HAS_LIQUID)) {
            this.hasLiquid = json.getBoolean(HAS_LIQUID);
        }
        if (json.has(IAM_REDISPLAY_STATS)) {
            JSONObject jSONObject2 = json.getJSONObject(IAM_REDISPLAY_STATS);
            k.d(jSONObject2, "json.getJSONObject(IAM_REDISPLAY_STATS)");
            this.redisplayStats = new InAppMessageRedisplayStats(jSONObject2, time);
        }
    }
}
