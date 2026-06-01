package com.ironsource.adqualitysdk.sdk.i;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class fu extends fr {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private em f2101;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private fk f2102;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private fk f2103;

    public fu(fk fkVar, fk fkVar2, em emVar) {
        this.f2103 = fkVar;
        this.f2102 = fkVar2;
        this.f2101 = emVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && fu.class == obj.getClass()) {
            fu fuVar = (fu) obj;
            fk fkVar = this.f2103;
            if (fkVar == null ? fuVar.f2103 != null : !fkVar.equals(fuVar.f2103)) {
                return false;
            }
            fk fkVar2 = this.f2102;
            if (fkVar2 == null ? fuVar.f2102 != null : !fkVar2.equals(fuVar.f2102)) {
                return false;
            }
            em emVar = this.f2101;
            em emVar2 = fuVar.f2101;
            if (emVar != null) {
                return emVar.equals(emVar2);
            }
            if (emVar2 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        fk fkVar = this.f2103;
        int iHashCode = (fkVar != null ? fkVar.hashCode() : 0) * 31;
        fk fkVar2 = this.f2102;
        int iHashCode2 = (iHashCode + (fkVar2 != null ? fkVar2.hashCode() : 0)) * 31;
        em emVar = this.f2101;
        return iHashCode2 + (emVar != null ? emVar.hashCode() : 0);
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.fr
    /* JADX INFO: renamed from: ﻐ */
    public final du mo2225(ds dsVar, cp cpVar) {
        try {
            fk fkVar = this.f2103;
            if (fkVar != null) {
                return fkVar.mo2225(new ds(dsVar), cpVar);
            }
        } catch (Throwable th) {
            if (this.f2102 != null) {
                HashMap map = new HashMap();
                em emVar = this.f2101;
                if (emVar != null) {
                    map.put(dy.m2174(emVar.m2208()), th);
                }
                return this.f2102.mo2225(new ds(map, dsVar), cpVar);
            }
        }
        return new du(null);
    }
}
