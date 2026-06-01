package com.iab.omid.library.bytedance2.adsession.media;

import com.ironsource.C2318f4;

/* JADX INFO: loaded from: classes3.dex */
public enum InteractionType {
    CLICK(C2318f4.f8523d),
    INVITATION_ACCEPTED("invitationAccept");

    String interactionType;

    InteractionType(String str) {
        this.interactionType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.interactionType;
    }
}
