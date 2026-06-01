package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class VolumeProviderCompatApi21 {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Delegate {
        void onAdjustVolume(int i2);

        void onSetVolumeTo(int i2);
    }

    private VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int i2, int i8, int i9, final Delegate delegate) {
        return new VolumeProvider(i2, i8, i9) { // from class: androidx.media.VolumeProviderCompatApi21.1
            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i10) {
                delegate.onAdjustVolume(i10);
            }

            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i10) {
                delegate.onSetVolumeTo(i10);
            }
        };
    }

    public static void setCurrentVolume(Object obj, int i2) {
        ((VolumeProvider) obj).setCurrentVolume(i2);
    }
}
