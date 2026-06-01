package androidx.camera.core;

import android.util.Range;
import android.util.Rational;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface ExposureState {
    int getExposureCompensationIndex();

    Range<Integer> getExposureCompensationRange();

    Rational getExposureCompensationStep();

    boolean isExposureCompensationSupported();
}
