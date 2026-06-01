package com.onesignal.core.internal.backend;

import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InfluenceParamsObject {
    private final Integer iamLimit;
    private final Integer indirectIAMAttributionWindow;
    private final Integer indirectNotificationAttributionWindow;
    private final Boolean isDirectEnabled;
    private final Boolean isIndirectEnabled;
    private final Boolean isUnattributedEnabled;
    private final Integer notificationLimit;

    public InfluenceParamsObject() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public final Integer getIamLimit() {
        return this.iamLimit;
    }

    public final Integer getIndirectIAMAttributionWindow() {
        return this.indirectIAMAttributionWindow;
    }

    public final Integer getIndirectNotificationAttributionWindow() {
        return this.indirectNotificationAttributionWindow;
    }

    public final Integer getNotificationLimit() {
        return this.notificationLimit;
    }

    public final Boolean isDirectEnabled() {
        return this.isDirectEnabled;
    }

    public final Boolean isIndirectEnabled() {
        return this.isIndirectEnabled;
    }

    public final Boolean isUnattributedEnabled() {
        return this.isUnattributedEnabled;
    }

    public InfluenceParamsObject(Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Boolean bool2, Boolean bool3) {
        this.indirectNotificationAttributionWindow = num;
        this.notificationLimit = num2;
        this.indirectIAMAttributionWindow = num3;
        this.iamLimit = num4;
        this.isDirectEnabled = bool;
        this.isIndirectEnabled = bool2;
        this.isUnattributedEnabled = bool3;
    }

    public /* synthetic */ InfluenceParamsObject(Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Boolean bool2, Boolean bool3, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2, (i2 & 4) != 0 ? null : num3, (i2 & 8) != 0 ? null : num4, (i2 & 16) != 0 ? null : bool, (i2 & 32) != 0 ? null : bool2, (i2 & 64) != 0 ? null : bool3);
    }
}
