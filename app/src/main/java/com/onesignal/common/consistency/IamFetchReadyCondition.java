package com.onesignal.common.consistency;

import com.onesignal.common.consistency.enums.IamFetchRywTokenKey;
import com.onesignal.common.consistency.models.ICondition;
import com.onesignal.common.consistency.models.IConsistencyKeyEnum;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class IamFetchReadyCondition implements ICondition {
    public static final Companion Companion = new Companion(null);
    public static final String ID = "IamFetchReadyCondition";
    private final String key;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public IamFetchReadyCondition(String key) {
        k.e(key, "key");
        this.key = key;
    }

    @Override // com.onesignal.common.consistency.models.ICondition
    public String getId() {
        return ID;
    }

    @Override // com.onesignal.common.consistency.models.ICondition
    public RywData getRywData(Map<String, ? extends Map<IConsistencyKeyEnum, RywData>> indexedTokens) {
        k.e(indexedTokens, "indexedTokens");
        Map<IConsistencyKeyEnum, RywData> map = indexedTokens.get(this.key);
        Object next = null;
        if (map == null) {
            return null;
        }
        Iterator it = j.n0(new RywData[]{map.get(IamFetchRywTokenKey.USER), map.get(IamFetchRywTokenKey.SUBSCRIPTION)}).iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                String rywToken = ((RywData) next).getRywToken();
                if (rywToken == null) {
                    rywToken = "";
                }
                do {
                    Object next2 = it.next();
                    String rywToken2 = ((RywData) next2).getRywToken();
                    if (rywToken2 == null) {
                        rywToken2 = "";
                    }
                    if (rywToken.compareTo(rywToken2) < 0) {
                        next = next2;
                        rywToken = rywToken2;
                    }
                } while (it.hasNext());
            }
        }
        return (RywData) next;
    }

    @Override // com.onesignal.common.consistency.models.ICondition
    public boolean isMet(Map<String, ? extends Map<IConsistencyKeyEnum, RywData>> indexedTokens) {
        k.e(indexedTokens, "indexedTokens");
        Map<IConsistencyKeyEnum, RywData> map = indexedTokens.get(this.key);
        return (map == null || map.get(IamFetchRywTokenKey.USER) == null) ? false : true;
    }
}
