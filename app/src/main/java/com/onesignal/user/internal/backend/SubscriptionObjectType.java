package com.onesignal.user.internal.backend;

import com.onesignal.core.internal.device.IDeviceService;
import e2.s;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum SubscriptionObjectType {
    IOS_PUSH("iOSPush"),
    ANDROID_PUSH("AndroidPush"),
    FIREOS_PUSH("FireOSPush"),
    CHROME_EXTENSION("ChromeExtensionPush"),
    CHROME_PUSH("ChromePush"),
    WINDOWS_PUSH("WindowsPush"),
    SAFARI_PUSH("SafariPush"),
    SAFARI_PUSH_LEGACY("SafariLegacyPush"),
    FIREFOX_PUSH("FirefoxPush"),
    MACOS_PUSH("macOSPush"),
    EMAIL("Email"),
    HUAWEI_PUSH("HuaweiPush"),
    SMS("SMS");

    public static final Companion Companion = new Companion(null);
    private final String value;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[IDeviceService.DeviceType.values().length];
                iArr[IDeviceService.DeviceType.Android.ordinal()] = 1;
                iArr[IDeviceService.DeviceType.Fire.ordinal()] = 2;
                iArr[IDeviceService.DeviceType.Huawei.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final SubscriptionObjectType fromDeviceType(IDeviceService.DeviceType type) {
            k.e(type, "type");
            int i2 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i2 == 1) {
                return SubscriptionObjectType.ANDROID_PUSH;
            }
            if (i2 == 2) {
                return SubscriptionObjectType.FIREOS_PUSH;
            }
            if (i2 == 3) {
                return SubscriptionObjectType.HUAWEI_PUSH;
            }
            throw new s(3);
        }

        public final SubscriptionObjectType fromString(String type) {
            k.e(type, "type");
            for (SubscriptionObjectType subscriptionObjectType : SubscriptionObjectType.values()) {
                if (t.g0(subscriptionObjectType.getValue(), type)) {
                    return subscriptionObjectType;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    SubscriptionObjectType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
