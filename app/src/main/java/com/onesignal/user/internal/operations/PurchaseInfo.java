package com.onesignal.user.internal.operations;

import com.ironsource.C2543s;
import com.onesignal.common.modeling.Model;
import java.math.BigDecimal;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PurchaseInfo extends Model {
    public PurchaseInfo() {
        super(null, null, 3, null);
    }

    private final void setAmount(BigDecimal bigDecimal) {
        Model.setBigDecimalProperty$default(this, C2543s.l, bigDecimal, null, false, 12, null);
    }

    private final void setIso(String str) {
        Model.setStringProperty$default(this, "iso", str, null, false, 12, null);
    }

    private final void setSku(String str) {
        Model.setStringProperty$default(this, "sku", str, null, false, 12, null);
    }

    public final BigDecimal getAmount() {
        return Model.getBigDecimalProperty$default(this, C2543s.l, null, 2, null);
    }

    public final String getIso() {
        return Model.getStringProperty$default(this, "iso", null, 2, null);
    }

    public final String getSku() {
        return Model.getStringProperty$default(this, "sku", null, 2, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PurchaseInfo(String sku, String iso, BigDecimal amount) {
        this();
        k.e(sku, "sku");
        k.e(iso, "iso");
        k.e(amount, "amount");
        setSku(sku);
        setIso(iso);
        setAmount(amount);
    }
}
