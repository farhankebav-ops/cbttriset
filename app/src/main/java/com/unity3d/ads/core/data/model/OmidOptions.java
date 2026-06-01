package com.unity3d.ads.core.data.model;

import com.iab.omid.library.unity3d.adsession.CreativeType;
import com.iab.omid.library.unity3d.adsession.ImpressionType;
import com.iab.omid.library.unity3d.adsession.Owner;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OmidOptions {
    private final CreativeType creativeType;
    private final String customReferenceData;
    private final Owner impressionOwner;
    private final ImpressionType impressionType;
    private final boolean isolateVerificationScripts;
    private final Owner mediaEventsOwner;
    private final Owner videoEventsOwner;

    public OmidOptions() {
        this(false, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ OmidOptions copy$default(OmidOptions omidOptions, boolean z2, Owner owner, Owner owner2, String str, ImpressionType impressionType, CreativeType creativeType, Owner owner3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = omidOptions.isolateVerificationScripts;
        }
        if ((i2 & 2) != 0) {
            owner = omidOptions.impressionOwner;
        }
        if ((i2 & 4) != 0) {
            owner2 = omidOptions.videoEventsOwner;
        }
        if ((i2 & 8) != 0) {
            str = omidOptions.customReferenceData;
        }
        if ((i2 & 16) != 0) {
            impressionType = omidOptions.impressionType;
        }
        if ((i2 & 32) != 0) {
            creativeType = omidOptions.creativeType;
        }
        if ((i2 & 64) != 0) {
            owner3 = omidOptions.mediaEventsOwner;
        }
        CreativeType creativeType2 = creativeType;
        Owner owner4 = owner3;
        ImpressionType impressionType2 = impressionType;
        Owner owner5 = owner2;
        return omidOptions.copy(z2, owner, owner5, str, impressionType2, creativeType2, owner4);
    }

    public final boolean component1() {
        return this.isolateVerificationScripts;
    }

    public final Owner component2() {
        return this.impressionOwner;
    }

    public final Owner component3() {
        return this.videoEventsOwner;
    }

    public final String component4() {
        return this.customReferenceData;
    }

    public final ImpressionType component5() {
        return this.impressionType;
    }

    public final CreativeType component6() {
        return this.creativeType;
    }

    public final Owner component7() {
        return this.mediaEventsOwner;
    }

    public final OmidOptions copy(boolean z2, Owner owner, Owner owner2, String str, ImpressionType impressionType, CreativeType creativeType, Owner owner3) {
        return new OmidOptions(z2, owner, owner2, str, impressionType, creativeType, owner3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OmidOptions)) {
            return false;
        }
        OmidOptions omidOptions = (OmidOptions) obj;
        return this.isolateVerificationScripts == omidOptions.isolateVerificationScripts && this.impressionOwner == omidOptions.impressionOwner && this.videoEventsOwner == omidOptions.videoEventsOwner && k.a(this.customReferenceData, omidOptions.customReferenceData) && this.impressionType == omidOptions.impressionType && this.creativeType == omidOptions.creativeType && this.mediaEventsOwner == omidOptions.mediaEventsOwner;
    }

    public final CreativeType getCreativeType() {
        return this.creativeType;
    }

    public final String getCustomReferenceData() {
        return this.customReferenceData;
    }

    public final Owner getImpressionOwner() {
        return this.impressionOwner;
    }

    public final ImpressionType getImpressionType() {
        return this.impressionType;
    }

    public final boolean getIsolateVerificationScripts() {
        return this.isolateVerificationScripts;
    }

    public final Owner getMediaEventsOwner() {
        return this.mediaEventsOwner;
    }

    public final Owner getVideoEventsOwner() {
        return this.videoEventsOwner;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public int hashCode() {
        boolean z2 = this.isolateVerificationScripts;
        ?? r02 = z2;
        if (z2) {
            r02 = 1;
        }
        int i2 = r02 * 31;
        Owner owner = this.impressionOwner;
        int iHashCode = (i2 + (owner == null ? 0 : owner.hashCode())) * 31;
        Owner owner2 = this.videoEventsOwner;
        int iHashCode2 = (iHashCode + (owner2 == null ? 0 : owner2.hashCode())) * 31;
        String str = this.customReferenceData;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        ImpressionType impressionType = this.impressionType;
        int iHashCode4 = (iHashCode3 + (impressionType == null ? 0 : impressionType.hashCode())) * 31;
        CreativeType creativeType = this.creativeType;
        int iHashCode5 = (iHashCode4 + (creativeType == null ? 0 : creativeType.hashCode())) * 31;
        Owner owner3 = this.mediaEventsOwner;
        return iHashCode5 + (owner3 != null ? owner3.hashCode() : 0);
    }

    public String toString() {
        return "OmidOptions(isolateVerificationScripts=" + this.isolateVerificationScripts + ", impressionOwner=" + this.impressionOwner + ", videoEventsOwner=" + this.videoEventsOwner + ", customReferenceData=" + this.customReferenceData + ", impressionType=" + this.impressionType + ", creativeType=" + this.creativeType + ", mediaEventsOwner=" + this.mediaEventsOwner + ')';
    }

    public OmidOptions(boolean z2, Owner owner, Owner owner2, String str, ImpressionType impressionType, CreativeType creativeType, Owner owner3) {
        this.isolateVerificationScripts = z2;
        this.impressionOwner = owner;
        this.videoEventsOwner = owner2;
        this.customReferenceData = str;
        this.impressionType = impressionType;
        this.creativeType = creativeType;
        this.mediaEventsOwner = owner3;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ OmidOptions(boolean r2, com.iab.omid.library.unity3d.adsession.Owner r3, com.iab.omid.library.unity3d.adsession.Owner r4, java.lang.String r5, com.iab.omid.library.unity3d.adsession.ImpressionType r6, com.iab.omid.library.unity3d.adsession.CreativeType r7, com.iab.omid.library.unity3d.adsession.Owner r8, int r9, kotlin.jvm.internal.f r10) {
        /*
            r1 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L5
            r2 = 0
        L5:
            r10 = r9 & 2
            r0 = 0
            if (r10 == 0) goto Lb
            r3 = r0
        Lb:
            r10 = r9 & 4
            if (r10 == 0) goto L10
            r4 = r0
        L10:
            r10 = r9 & 8
            if (r10 == 0) goto L15
            r5 = r0
        L15:
            r10 = r9 & 16
            if (r10 == 0) goto L1a
            r6 = r0
        L1a:
            r10 = r9 & 32
            if (r10 == 0) goto L1f
            r7 = r0
        L1f:
            r9 = r9 & 64
            if (r9 == 0) goto L2c
            r10 = r0
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L34
        L2c:
            r10 = r8
            r9 = r7
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L34:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.model.OmidOptions.<init>(boolean, com.iab.omid.library.unity3d.adsession.Owner, com.iab.omid.library.unity3d.adsession.Owner, java.lang.String, com.iab.omid.library.unity3d.adsession.ImpressionType, com.iab.omid.library.unity3d.adsession.CreativeType, com.iab.omid.library.unity3d.adsession.Owner, int, kotlin.jvm.internal.f):void");
    }
}
