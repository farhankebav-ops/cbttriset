package com.onesignal.user.internal.backend;

import java.math.BigDecimal;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PurchaseObject {
    private final BigDecimal amount;
    private final String iso;
    private final String sku;

    public PurchaseObject(String sku, String iso, BigDecimal amount) {
        k.e(sku, "sku");
        k.e(iso, "iso");
        k.e(amount, "amount");
        this.sku = sku;
        this.iso = iso;
        this.amount = amount;
    }

    public final BigDecimal getAmount() {
        return this.amount;
    }

    public final String getIso() {
        return this.iso;
    }

    public final String getSku() {
        return this.sku;
    }
}
