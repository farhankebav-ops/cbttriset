package com.ironsource.adqualitysdk.sdk.i;

import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class el extends eg {
    public el(ee eeVar, ee eeVar2, Cdo cdo) {
        super(eeVar, eeVar2, cdo);
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ee
    /* JADX INFO: renamed from: ﻛ */
    public final du mo2156(ds dsVar, cp cpVar) {
        Object objM2153 = m2196().m2189(dsVar, cpVar).m2153();
        Object objM21532 = m2194().m2189(dsVar, cpVar).m2153();
        try {
            return new du(Boolean.valueOf(mo2205(new BigDecimal(objM2153.toString()).compareTo(new BigDecimal(objM21532.toString())))));
        } catch (Exception unused) {
            return ((objM2153 instanceof String) && (objM21532 instanceof String)) ? new du(Boolean.valueOf(mo2206((String) objM2153, (String) objM21532))) : new du(Boolean.valueOf(mo2204(objM2153, objM21532)));
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public abstract boolean mo2204(Object obj, Object obj2);

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public abstract boolean mo2205(int i2);

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public abstract boolean mo2206(String str, String str2);
}
