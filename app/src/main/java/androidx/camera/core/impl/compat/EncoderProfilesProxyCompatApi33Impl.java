package androidx.camera.core.impl.compat;

import android.media.EncoderProfiles;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.EncoderProfilesProxy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(33)
class EncoderProfilesProxyCompatApi33Impl {
    private EncoderProfilesProxyCompatApi33Impl() {
    }

    public static EncoderProfilesProxy from(EncoderProfiles encoderProfiles) {
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(encoderProfiles.getDefaultDurationSeconds(), encoderProfiles.getRecommendedFileFormat(), fromAudioProfiles(encoderProfiles.getAudioProfiles()), fromVideoProfiles(encoderProfiles.getVideoProfiles()));
    }

    private static List<EncoderProfilesProxy.AudioProfileProxy> fromAudioProfiles(List<EncoderProfiles.AudioProfile> list) {
        ArrayList arrayList = new ArrayList();
        for (EncoderProfiles.AudioProfile audioProfile : list) {
            arrayList.add(EncoderProfilesProxy.AudioProfileProxy.create(audioProfile.getCodec(), audioProfile.getMediaType(), audioProfile.getBitrate(), audioProfile.getSampleRate(), audioProfile.getChannels(), audioProfile.getProfile()));
        }
        return arrayList;
    }

    private static List<EncoderProfilesProxy.VideoProfileProxy> fromVideoProfiles(List<EncoderProfiles.VideoProfile> list) {
        ArrayList arrayList = new ArrayList();
        for (EncoderProfiles.VideoProfile videoProfile : list) {
            arrayList.add(EncoderProfilesProxy.VideoProfileProxy.create(videoProfile.getCodec(), videoProfile.getMediaType(), videoProfile.getBitrate(), videoProfile.getFrameRate(), videoProfile.getWidth(), videoProfile.getHeight(), videoProfile.getProfile(), videoProfile.getBitDepth(), videoProfile.getChromaSubsampling(), videoProfile.getHdrFormat()));
        }
        return arrayList;
    }
}
