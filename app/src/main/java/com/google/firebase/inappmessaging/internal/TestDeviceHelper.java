package com.google.firebase.inappmessaging.internal;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class TestDeviceHelper {
    static final String FRESH_INSTALL_PREFERENCES = "fresh_install";
    static final int MAX_FETCH_COUNT = 5;
    static final String TEST_DEVICE_PREFERENCES = "test_device";
    private int fetchCount = 0;
    private boolean isFreshInstall = readFreshInstallStatusFromPreferences();
    private boolean isTestDevice = readTestDeviceStatusFromPreferences();
    private final SharedPreferencesUtils sharedPreferencesUtils;

    public TestDeviceHelper(SharedPreferencesUtils sharedPreferencesUtils) {
        this.sharedPreferencesUtils = sharedPreferencesUtils;
    }

    private boolean readFreshInstallStatusFromPreferences() {
        return this.sharedPreferencesUtils.getAndSetBooleanPreference(FRESH_INSTALL_PREFERENCES, true);
    }

    private boolean readTestDeviceStatusFromPreferences() {
        return this.sharedPreferencesUtils.getAndSetBooleanPreference(TEST_DEVICE_PREFERENCES, false);
    }

    private void setFreshInstallStatus(boolean z2) {
        this.isFreshInstall = z2;
        this.sharedPreferencesUtils.setBooleanPreference(FRESH_INSTALL_PREFERENCES, z2);
    }

    private void setTestDeviceStatus(boolean z2) {
        this.isTestDevice = z2;
        this.sharedPreferencesUtils.setBooleanPreference(TEST_DEVICE_PREFERENCES, z2);
    }

    private void updateFreshInstallStatus() {
        if (this.isFreshInstall) {
            int i2 = this.fetchCount + 1;
            this.fetchCount = i2;
            if (i2 >= 5) {
                setFreshInstallStatus(false);
            }
        }
    }

    public boolean isAppInstallFresh() {
        return this.isFreshInstall;
    }

    public boolean isDeviceInTestMode() {
        return this.isTestDevice;
    }

    public void processCampaignFetch(r2.o oVar) {
        if (this.isTestDevice) {
            return;
        }
        updateFreshInstallStatus();
        Iterator<E> it = oVar.e().iterator();
        while (it.hasNext()) {
            if (((q2.f) it.next()).d()) {
                setTestDeviceStatus(true);
                Logging.logi("Setting this device as a test device");
                return;
            }
        }
    }
}
