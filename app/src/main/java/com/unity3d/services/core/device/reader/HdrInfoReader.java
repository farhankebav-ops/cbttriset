package com.unity3d.services.core.device.reader;

import android.app.Activity;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.unity3d.services.core.configuration.ExperimentsReader;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class HdrInfoReader implements IHdrInfoReader {
    private static final AtomicBoolean _hdrMetricsCaptured = new AtomicBoolean(false);
    private static volatile HdrInfoReader _instance;
    private final SDKMetricsSender _sdkMetricsSender = (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);

    private HdrInfoReader() {
    }

    public static HdrInfoReader getInstance() {
        if (_instance == null) {
            synchronized (HdrInfoReader.class) {
                try {
                    if (_instance == null) {
                        _instance = new HdrInfoReader();
                    }
                } finally {
                }
            }
        }
        return _instance;
    }

    @Override // com.unity3d.services.core.device.reader.IHdrInfoReader
    public void captureHDRCapabilityMetrics(Activity activity, ExperimentsReader experimentsReader) {
        boolean zIsScreenHdr;
        boolean z2;
        boolean z7;
        boolean z8;
        if (activity != null && experimentsReader.getCurrentlyActiveExperiments().isCaptureHDRCapabilitiesEnabled()) {
            if (_hdrMetricsCaptured.compareAndSet(false, true)) {
                ArrayList arrayList = new ArrayList(5);
                if (Build.VERSION.SDK_INT >= 24) {
                    Display.HdrCapabilities hdrCapabilities = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getHdrCapabilities();
                    boolean z9 = false;
                    z2 = false;
                    z7 = false;
                    z8 = false;
                    for (int i2 : hdrCapabilities.getSupportedHdrTypes()) {
                        if (i2 == 1) {
                            z9 = true;
                        } else if (i2 == 2) {
                            z2 = true;
                        } else if (i2 == 3) {
                            z8 = true;
                        } else if (i2 == 4) {
                            z7 = true;
                        }
                    }
                    long jRound = Math.round(hdrCapabilities.getDesiredMaxAverageLuminance());
                    long jRound2 = Math.round(hdrCapabilities.getDesiredMaxLuminance());
                    long jRound3 = Math.round(hdrCapabilities.getDesiredMinLuminance());
                    arrayList.add(new Metric("native_device_hdr_lum_max_average", Long.valueOf(jRound)));
                    arrayList.add(new Metric("native_device_hdr_lum_max", Long.valueOf(jRound2)));
                    arrayList.add(new Metric("native_device_hdr_lum_min", Long.valueOf(jRound3)));
                    zIsScreenHdr = Build.VERSION.SDK_INT >= 26 ? activity.getResources().getConfiguration().isScreenHdr() : false;
                    z = z9;
                } else {
                    zIsScreenHdr = false;
                    z2 = false;
                    z7 = false;
                    z8 = false;
                }
                if (z) {
                    arrayList.add(new Metric("native_device_hdr_dolby_vision_success"));
                } else {
                    arrayList.add(new Metric("native_device_hdr_dolby_vision_failure"));
                }
                if (z2) {
                    arrayList.add(new Metric("native_device_hdr_hdr10_success"));
                } else {
                    arrayList.add(new Metric("native_device_hdr_hdr10_failure"));
                }
                if (z7) {
                    arrayList.add(new Metric("native_device_hdr_hdr10_plus_success"));
                } else {
                    arrayList.add(new Metric("native_device_hdr_hdr10_plus_failure"));
                }
                if (z8) {
                    arrayList.add(new Metric("native_device_hdr_hlg_success"));
                } else {
                    arrayList.add(new Metric("native_device_hdr_hlg_failure"));
                }
                if (zIsScreenHdr) {
                    arrayList.add(new Metric("native_device_hdr_screen_hdr_success"));
                } else {
                    arrayList.add(new Metric("native_device_hdr_screen_hdr_failure"));
                }
                this._sdkMetricsSender.sendMetrics(arrayList);
            }
        }
    }
}
