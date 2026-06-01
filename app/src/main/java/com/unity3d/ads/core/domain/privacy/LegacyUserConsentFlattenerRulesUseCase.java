package com.unity3d.ads.core.domain.privacy;

import com.unity3d.services.core.misc.JsonFlattenerRules;
import r2.q;
import r5.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LegacyUserConsentFlattenerRulesUseCase implements FlattenerRulesUseCase {
    @Override // com.unity3d.ads.core.domain.privacy.FlattenerRulesUseCase
    public JsonFlattenerRules invoke() {
        return new JsonFlattenerRules(m.I0("privacy", "unity", "pipl"), q.j0("value"), m.I0("ts", "exclude", "pii", "nonBehavioral", "nonbehavioral"));
    }
}
