package com.unity3d.ads.core.data.datasource;

import com.unity3d.ads.core.domain.privacy.FlattenerRulesUseCase;
import com.unity3d.services.core.misc.JsonFlattener;
import com.unity3d.services.core.misc.JsonStorage;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidLegacyUserConsentDataSource implements LegacyUserConsentDataSource {
    private final FlattenerRulesUseCase flattenerRulesUseCase;
    private final JsonStorage privateStorage;

    public AndroidLegacyUserConsentDataSource(FlattenerRulesUseCase flattenerRulesUseCase, JsonStorage privateStorage) {
        k.e(flattenerRulesUseCase, "flattenerRulesUseCase");
        k.e(privateStorage, "privateStorage");
        this.flattenerRulesUseCase = flattenerRulesUseCase;
        this.privateStorage = privateStorage;
    }

    @Override // com.unity3d.ads.core.data.datasource.LegacyUserConsentDataSource
    public String getPrivacyData() {
        JSONObject jSONObjectFlattenJson;
        JSONObject data = this.privateStorage.getData();
        if (data == null || (jSONObjectFlattenJson = new JsonFlattener(data).flattenJson(".", this.flattenerRulesUseCase.invoke())) == null) {
            return null;
        }
        return jSONObjectFlattenJson.toString();
    }
}
