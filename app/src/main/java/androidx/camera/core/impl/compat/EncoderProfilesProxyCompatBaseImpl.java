package androidx.camera.core.impl.compat;

import android.media.CamcorderProfile;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.r;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class EncoderProfilesProxyCompatBaseImpl {
    private EncoderProfilesProxyCompatBaseImpl() {
    }

    public static EncoderProfilesProxy from(CamcorderProfile camcorderProfile) {
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(camcorderProfile.duration, camcorderProfile.fileFormat, toAudioProfiles(camcorderProfile), toVideoProfiles(camcorderProfile));
    }

    private static List<EncoderProfilesProxy.AudioProfileProxy> toAudioProfiles(CamcorderProfile camcorderProfile) {
        ArrayList arrayList = new ArrayList();
        int i2 = camcorderProfile.audioCodec;
        arrayList.add(EncoderProfilesProxy.AudioProfileProxy.create(i2, r.a(i2), camcorderProfile.audioBitRate, camcorderProfile.audioSampleRate, camcorderProfile.audioChannels, r.b(camcorderProfile.audioCodec)));
        return arrayList;
    }

    private static List<EncoderProfilesProxy.VideoProfileProxy> toVideoProfiles(CamcorderProfile camcorderProfile) {
        ArrayList arrayList = new ArrayList();
        int i2 = camcorderProfile.videoCodec;
        arrayList.add(EncoderProfilesProxy.VideoProfileProxy.create(i2, r.c(i2), camcorderProfile.videoBitRate, camcorderProfile.videoFrameRate, camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight, -1, 8, 0, 0));
        return arrayList;
    }
}
