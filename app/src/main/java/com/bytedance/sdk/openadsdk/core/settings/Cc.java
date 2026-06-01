package com.bytedance.sdk.openadsdk.core.settings;

import com.bytedance.sdk.component.utils.oeT;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface Cc {
    public static final MY<JSONObject> IlO = new MY<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.settings.Cc.1
        @Override // com.bytedance.sdk.openadsdk.core.settings.Cc.MY
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public JSONObject MY(String str) {
            try {
                return new JSONObject(str);
            } catch (Exception e) {
                oeT.IlO("ISettingsDataRepository", "", e);
                return null;
            }
        }
    };
    public static final MY<Set<String>> MY = new MY<Set<String>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.Cc.2
        @Override // com.bytedance.sdk.openadsdk.core.settings.Cc.MY
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public Set<String> MY(String str) {
            HashSet hashSet = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    hashSet.add(jSONArray.getString(i2));
                }
                return hashSet;
            } catch (Exception e) {
                oeT.IlO("ISettingsDataRepository", "", e);
                return hashSet;
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        IlO IlO(String str);

        IlO IlO(String str, float f4);

        IlO IlO(String str, int i2);

        IlO IlO(String str, long j);

        IlO IlO(String str, String str2);

        IlO IlO(String str, boolean z2);

        void IlO();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MY<T> {
        T MY(String str);
    }

    void IlO(JSONObject jSONObject);
}
