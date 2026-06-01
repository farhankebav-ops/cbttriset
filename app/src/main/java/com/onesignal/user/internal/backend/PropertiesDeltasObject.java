package com.onesignal.user.internal.backend;

import java.math.BigDecimal;
import java.util.List;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PropertiesDeltasObject {
    private final BigDecimal amountSpent;
    private final List<PurchaseObject> purchases;
    private final Integer sessionCount;
    private final Long sessionTime;

    public PropertiesDeltasObject() {
        this(null, null, null, null, 15, null);
    }

    public final BigDecimal getAmountSpent() {
        return this.amountSpent;
    }

    public final boolean getHasAtLeastOnePropertySet() {
        return (this.sessionTime == null && this.sessionCount == null && this.amountSpent == null && this.purchases == null) ? false : true;
    }

    public final List<PurchaseObject> getPurchases() {
        return this.purchases;
    }

    public final Integer getSessionCount() {
        return this.sessionCount;
    }

    public final Long getSessionTime() {
        return this.sessionTime;
    }

    public PropertiesDeltasObject(Long l, Integer num, BigDecimal bigDecimal, List<PurchaseObject> list) {
        this.sessionTime = l;
        this.sessionCount = num;
        this.amountSpent = bigDecimal;
        this.purchases = list;
    }

    public /* synthetic */ PropertiesDeltasObject(Long l, Integer num, BigDecimal bigDecimal, List list, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : l, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : bigDecimal, (i2 & 8) != 0 ? null : list);
    }
}
