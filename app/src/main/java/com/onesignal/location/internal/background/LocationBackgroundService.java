package com.onesignal.location.internal.background;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.ILocationManager;
import com.onesignal.location.internal.capture.ILocationCapturer;
import com.onesignal.location.internal.common.LocationUtils;
import com.onesignal.location.internal.preferences.ILocationPreferencesService;
import kotlin.jvm.internal.k;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationBackgroundService implements IBackgroundService {
    private final IApplicationService _applicationService;
    private final ILocationCapturer _capturer;
    private final ILocationManager _locationManager;
    private final ILocationPreferencesService _prefs;
    private final ITime _time;

    public LocationBackgroundService(IApplicationService _applicationService, ILocationManager _locationManager, ILocationPreferencesService _prefs, ILocationCapturer _capturer, ITime _time) {
        k.e(_applicationService, "_applicationService");
        k.e(_locationManager, "_locationManager");
        k.e(_prefs, "_prefs");
        k.e(_capturer, "_capturer");
        k.e(_time, "_time");
        this._applicationService = _applicationService;
        this._locationManager = _locationManager;
        this._prefs = _prefs;
        this._capturer = _capturer;
        this._time = _time;
    }

    @Override // com.onesignal.core.internal.background.IBackgroundService
    public Object backgroundRun(c<? super x> cVar) {
        this._capturer.captureLastLocation();
        return x.f13520a;
    }

    @Override // com.onesignal.core.internal.background.IBackgroundService
    public Long getScheduleBackgroundRunIn() {
        if (!this._locationManager.isShared()) {
            Logging.debug$default("LocationController scheduleUpdate not possible, location shared not enabled", null, 2, null);
            return null;
        }
        if (LocationUtils.INSTANCE.hasLocationPermission(this._applicationService.getAppContext())) {
            return Long.valueOf(TTAdConstant.AD_MAX_EVENT_TIME - (this._time.getCurrentTimeMillis() - this._prefs.getLastLocationTime()));
        }
        Logging.debug$default("LocationController scheduleUpdate not possible, location permission not enabled", null, 2, null);
        return null;
    }
}
