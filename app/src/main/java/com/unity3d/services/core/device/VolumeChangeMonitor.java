package com.unity3d.services.core.device;

import android.util.SparseArray;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VolumeChangeMonitor {
    private final IEventSender eventSender;
    private final VolumeChange volumeChange;
    private final SparseArray<VolumeChangeListener> volumeChangeListeners;

    public VolumeChangeMonitor(IEventSender eventSender, VolumeChange volumeChange) {
        k.e(eventSender, "eventSender");
        k.e(volumeChange, "volumeChange");
        this.eventSender = eventSender;
        this.volumeChange = volumeChange;
        this.volumeChangeListeners = new SparseArray<>();
    }

    public final void registerVolumeChangeListener(final int i2) {
        if (this.volumeChangeListeners.get(i2) == null) {
            VolumeChangeListener volumeChangeListener = new VolumeChangeListener() { // from class: com.unity3d.services.core.device.VolumeChangeMonitor$registerVolumeChangeListener$listener$1
                @Override // com.unity3d.services.core.device.VolumeChangeListener
                public int getStreamType() {
                    return i2;
                }

                @Override // com.unity3d.services.core.device.VolumeChangeListener
                public void onVolumeChanged(int i8) {
                    this.this$0.eventSender.sendEvent(WebViewEventCategory.DEVICEINFO, DeviceInfoEvent.VOLUME_CHANGED, Integer.valueOf(getStreamType()), Integer.valueOf(i8), Integer.valueOf(Device.getStreamMaxVolume(i2)));
                }
            };
            this.volumeChangeListeners.append(i2, volumeChangeListener);
            this.volumeChange.registerListener(volumeChangeListener);
        }
    }

    public final void unregisterVolumeChangeListener(int i2) {
        if (this.volumeChangeListeners.get(i2) != null) {
            VolumeChangeListener listener = this.volumeChangeListeners.get(i2);
            VolumeChange volumeChange = this.volumeChange;
            k.d(listener, "listener");
            volumeChange.unregisterListener(listener);
            this.volumeChangeListeners.remove(i2);
        }
    }
}
