package com.onesignal.core.internal.config;

import com.onesignal.common.modeling.Model;
import e6.a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InfluenceConfigModel extends Model {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_INDIRECT_ATTRIBUTION_WINDOW = 1440;
    public static final int DEFAULT_NOTIFICATION_LIMIT = 10;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.config.InfluenceConfigModel$isDirectEnabled$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends l implements a {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // e6.a
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.config.InfluenceConfigModel$isIndirectEnabled$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C26962 extends l implements a {
        public static final C26962 INSTANCE = new C26962();

        public C26962() {
            super(0);
        }

        @Override // e6.a
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.config.InfluenceConfigModel$isUnattributedEnabled$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C26972 extends l implements a {
        public static final C26972 INSTANCE = new C26972();

        public C26972() {
            super(0);
        }

        @Override // e6.a
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfluenceConfigModel(Model parentModel, String parentProperty) {
        super(parentModel, parentProperty);
        k.e(parentModel, "parentModel");
        k.e(parentProperty, "parentProperty");
    }

    public final int getIamLimit() {
        return getIntProperty("iamLimit", InfluenceConfigModel$iamLimit$2.INSTANCE);
    }

    public final int getIndirectIAMAttributionWindow() {
        return getIntProperty("indirectIAMAttributionWindow", InfluenceConfigModel$indirectIAMAttributionWindow$2.INSTANCE);
    }

    public final int getIndirectNotificationAttributionWindow() {
        return getIntProperty("indirectNotificationAttributionWindow", InfluenceConfigModel$indirectNotificationAttributionWindow$2.INSTANCE);
    }

    public final int getNotificationLimit() {
        return getIntProperty("notificationLimit", InfluenceConfigModel$notificationLimit$2.INSTANCE);
    }

    public final boolean isDirectEnabled() {
        return getBooleanProperty("isDirectEnabled", AnonymousClass2.INSTANCE);
    }

    public final boolean isIndirectEnabled() {
        return getBooleanProperty("isIndirectEnabled", C26962.INSTANCE);
    }

    public final boolean isUnattributedEnabled() {
        return getBooleanProperty("isUnattributedEnabled", C26972.INSTANCE);
    }

    public final void setDirectEnabled(boolean z2) {
        Model.setBooleanProperty$default(this, "isDirectEnabled", z2, null, false, 12, null);
    }

    public final void setIamLimit(int i2) {
        Model.setIntProperty$default(this, "iamLimit", i2, null, false, 12, null);
    }

    public final void setIndirectEnabled(boolean z2) {
        Model.setBooleanProperty$default(this, "isIndirectEnabled", z2, null, false, 12, null);
    }

    public final void setIndirectIAMAttributionWindow(int i2) {
        Model.setIntProperty$default(this, "indirectIAMAttributionWindow", i2, null, false, 12, null);
    }

    public final void setIndirectNotificationAttributionWindow(int i2) {
        Model.setIntProperty$default(this, "indirectNotificationAttributionWindow", i2, null, false, 12, null);
    }

    public final void setNotificationLimit(int i2) {
        Model.setIntProperty$default(this, "notificationLimit", i2, null, false, 12, null);
    }

    public final void setUnattributedEnabled(boolean z2) {
        Model.setBooleanProperty$default(this, "isUnattributedEnabled", z2, null, false, 12, null);
    }
}
