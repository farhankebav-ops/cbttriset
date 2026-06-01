package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FusedLocationApiWrapperImpl implements IFusedLocationApiWrapper {
    @Override // com.onesignal.location.internal.controller.impl.IFusedLocationApiWrapper
    public void cancelLocationUpdates(GoogleApiClient googleApiClient, LocationListener locationListener) {
        k.e(googleApiClient, "googleApiClient");
        k.e(locationListener, "locationListener");
        if (googleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, locationListener);
        } else {
            Logging.warn$default("GoogleApiClient is not connected. Unable to cancel location updates.", null, 2, null);
        }
    }

    @Override // com.onesignal.location.internal.controller.impl.IFusedLocationApiWrapper
    public Location getLastLocation(GoogleApiClient googleApiClient) {
        k.e(googleApiClient, "googleApiClient");
        if (googleApiClient.isConnected()) {
            return LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        }
        return null;
    }

    @Override // com.onesignal.location.internal.controller.impl.IFusedLocationApiWrapper
    public void requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        k.e(googleApiClient, "googleApiClient");
        k.e(locationRequest, "locationRequest");
        k.e(locationListener, "locationListener");
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            if (googleApiClient.isConnected()) {
                LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, locationListener);
            }
        } catch (Throwable th) {
            Logging.warn("FusedLocationApi.requestLocationUpdates failed!", th);
        }
    }
}
