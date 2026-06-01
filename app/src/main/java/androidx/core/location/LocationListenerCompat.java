package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface LocationListenerCompat extends LocationListener {
    @Override // android.location.LocationListener
    void onFlushComplete(int i2);

    @Override // android.location.LocationListener
    void onLocationChanged(@NonNull List<Location> list);

    @Override // android.location.LocationListener
    void onProviderDisabled(@NonNull String str);

    @Override // android.location.LocationListener
    void onProviderEnabled(@NonNull String str);

    @Override // android.location.LocationListener
    void onStatusChanged(@NonNull String str, int i2, @Nullable Bundle bundle);
}
