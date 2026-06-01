package com.onesignal.location.internal.capture.impl;

import android.location.Location;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.internal.capture.ILocationCapturer;
import com.onesignal.location.internal.common.LocationPoint;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.ILocationUpdatedHandler;
import com.onesignal.location.internal.preferences.ILocationPreferencesService;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationCapturer implements ILocationUpdatedHandler, ILocationCapturer {
    private final IApplicationService _applicationService;
    private final ILocationController _controller;
    private final ILocationPreferencesService _prefs;
    private final PropertiesModelStore _propertiesModelStore;
    private final ITime _time;
    private boolean locationCoarse;

    public LocationCapturer(IApplicationService _applicationService, ITime _time, ILocationPreferencesService _prefs, PropertiesModelStore _propertiesModelStore, ILocationController _controller) {
        k.e(_applicationService, "_applicationService");
        k.e(_time, "_time");
        k.e(_prefs, "_prefs");
        k.e(_propertiesModelStore, "_propertiesModelStore");
        k.e(_controller, "_controller");
        this._applicationService = _applicationService;
        this._time = _time;
        this._prefs = _prefs;
        this._propertiesModelStore = _propertiesModelStore;
        this._controller = _controller;
        _controller.subscribe(this);
    }

    private final void capture(Location location) {
        LocationPoint locationPoint = new LocationPoint();
        locationPoint.setAccuracy(Float.valueOf(location.getAccuracy()));
        locationPoint.setBg(Boolean.valueOf(!this._applicationService.isInForeground()));
        locationPoint.setType(getLocationCoarse() ? 0 : 1);
        locationPoint.setTimeStamp(Long.valueOf(location.getTime()));
        if (getLocationCoarse()) {
            BigDecimal bigDecimal = new BigDecimal(location.getLatitude());
            RoundingMode roundingMode = RoundingMode.HALF_UP;
            locationPoint.setLat(Double.valueOf(bigDecimal.setScale(7, roundingMode).doubleValue()));
            locationPoint.setLog(Double.valueOf(new BigDecimal(location.getLongitude()).setScale(7, roundingMode).doubleValue()));
        } else {
            locationPoint.setLat(Double.valueOf(location.getLatitude()));
            locationPoint.setLog(Double.valueOf(location.getLongitude()));
        }
        PropertiesModel model = this._propertiesModelStore.getModel();
        model.setLocationLongitude(locationPoint.getLog());
        model.setLocationLatitude(locationPoint.getLat());
        model.setLocationAccuracy(locationPoint.getAccuracy());
        model.setLocationBackground(locationPoint.getBg());
        model.setLocationType(locationPoint.getType());
        model.setLocationTimestamp(locationPoint.getTimeStamp());
        this._prefs.setLastLocationTime(this._time.getCurrentTimeMillis());
    }

    @Override // com.onesignal.location.internal.capture.ILocationCapturer
    public void captureLastLocation() {
        Location lastLocation = this._controller.getLastLocation();
        if (lastLocation != null) {
            capture(lastLocation);
        } else {
            this._prefs.setLastLocationTime(this._time.getCurrentTimeMillis());
        }
    }

    @Override // com.onesignal.location.internal.capture.ILocationCapturer
    public boolean getLocationCoarse() {
        return this.locationCoarse;
    }

    @Override // com.onesignal.location.internal.controller.ILocationUpdatedHandler
    public void onLocationChanged(Location location) {
        k.e(location, "location");
        Logging.debug$default("LocationController fireCompleteForLocation with location: " + location, null, 2, null);
        capture(location);
    }

    @Override // com.onesignal.location.internal.capture.ILocationCapturer
    public void setLocationCoarse(boolean z2) {
        this.locationCoarse = z2;
    }
}
