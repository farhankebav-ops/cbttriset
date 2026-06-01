package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Rational;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.MediaSpec;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.config.AudioMimeInfo;
import androidx.camera.video.internal.encoder.AudioEncoderConfig;
import com.ironsource.C2300e4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioConfigUtil {
    static final int AUDIO_CHANNEL_COUNT_DEFAULT = 1;
    static final int AUDIO_SAMPLE_RATE_DEFAULT = 44100;
    static final int AUDIO_SOURCE_DEFAULT = 5;
    static final int AUDIO_SOURCE_FORMAT_DEFAULT = 2;
    private static final String TAG = "AudioConfigUtil";

    private AudioConfigUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$selectSampleRateOrNearestSupported$0(int i2, Integer num, Integer num2) {
        int iAbs = Math.abs(num.intValue() - i2) - Math.abs(num2.intValue() - i2);
        return (int) (iAbs == 0 ? Math.signum(num.intValue() - num2.intValue()) : Math.signum(iAbs));
    }

    public static AudioEncoderConfig resolveAudioEncoderConfig(AudioMimeInfo audioMimeInfo, Timebase timebase, AudioSettings audioSettings, AudioSpec audioSpec) {
        EncoderProfilesProxy.AudioProfileProxy compatibleAudioProfile = audioMimeInfo.getCompatibleAudioProfile();
        return (AudioEncoderConfig) (compatibleAudioProfile != null ? new AudioEncoderConfigAudioProfileResolver(audioMimeInfo.getMimeType(), audioMimeInfo.getProfile(), timebase, audioSpec, audioSettings, compatibleAudioProfile) : new AudioEncoderConfigDefaultResolver(audioMimeInfo.getMimeType(), audioMimeInfo.getProfile(), timebase, audioSpec, audioSettings)).get();
    }

    public static AudioMimeInfo resolveAudioMimeInfo(MediaSpec mediaSpec, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy) {
        EncoderProfilesProxy.AudioProfileProxy defaultAudioProfile;
        String strOutputFormatToAudioMime = MediaSpec.outputFormatToAudioMime(mediaSpec.getOutputFormat());
        int iOutputFormatToAudioProfile = MediaSpec.outputFormatToAudioProfile(mediaSpec.getOutputFormat());
        if (videoValidatedEncoderProfilesProxy == null || videoValidatedEncoderProfilesProxy.getDefaultAudioProfile() == null) {
            defaultAudioProfile = null;
        } else {
            defaultAudioProfile = videoValidatedEncoderProfilesProxy.getDefaultAudioProfile();
            String mediaType = defaultAudioProfile.getMediaType();
            int profile = defaultAudioProfile.getProfile();
            if (Objects.equals(mediaType, EncoderProfilesProxy.AudioProfileProxy.MEDIA_TYPE_NONE)) {
                Logger.d(TAG, "EncoderProfiles contains undefined AUDIO mime type so cannot be used. May rely on fallback defaults to derive settings [chosen mime type: " + strOutputFormatToAudioMime + "(profile: " + iOutputFormatToAudioProfile + ")]");
            } else if (mediaSpec.getOutputFormat() == -1) {
                Logger.d(TAG, "MediaSpec contains OUTPUT_FORMAT_AUTO. Using EncoderProfiles to derive AUDIO settings [mime type: " + mediaType + "(profile: " + profile + ")]");
                strOutputFormatToAudioMime = mediaType;
                iOutputFormatToAudioProfile = profile;
            } else if (Objects.equals(strOutputFormatToAudioMime, mediaType) && iOutputFormatToAudioProfile == profile) {
                Logger.d(TAG, "MediaSpec audio mime/profile matches EncoderProfiles. Using EncoderProfiles to derive AUDIO settings [mime type: " + mediaType + "(profile: " + iOutputFormatToAudioProfile + ")]");
                strOutputFormatToAudioMime = mediaType;
            } else {
                StringBuilder sbS = androidx.camera.core.processing.util.a.s("MediaSpec audio mime or profile does not match EncoderProfiles, so EncoderProfiles settings cannot be used. May rely on fallback defaults to derive AUDIO settings [EncoderProfiles mime type: ", profile, mediaType, "(profile: ", "), chosen mime type: ");
                sbS.append(strOutputFormatToAudioMime);
                sbS.append("(profile: ");
                sbS.append(iOutputFormatToAudioProfile);
                sbS.append(")]");
                Logger.d(TAG, sbS.toString());
            }
            defaultAudioProfile = null;
        }
        AudioMimeInfo.Builder profile2 = AudioMimeInfo.builder(strOutputFormatToAudioMime).setProfile(iOutputFormatToAudioProfile);
        if (defaultAudioProfile != null) {
            profile2.setCompatibleAudioProfile(defaultAudioProfile);
        }
        return profile2.build();
    }

    public static AudioSettings resolveAudioSettings(AudioMimeInfo audioMimeInfo, AudioSpec audioSpec, Rational rational) {
        EncoderProfilesProxy.AudioProfileProxy compatibleAudioProfile = audioMimeInfo.getCompatibleAudioProfile();
        return (AudioSettings) (compatibleAudioProfile != null ? new AudioSettingsAudioProfileResolver(audioSpec, compatibleAudioProfile, rational) : new AudioSettingsDefaultResolver(audioSpec, rational)).get();
    }

    public static int resolveAudioSource(AudioSpec audioSpec) {
        int source = audioSpec.getSource();
        if (source == -1) {
            Logger.d(TAG, "Using default AUDIO source: 5");
            return 5;
        }
        Logger.d(TAG, "Using provided AUDIO source: " + source);
        return source;
    }

    public static int resolveAudioSourceFormat(AudioSpec audioSpec) {
        int sourceFormat = audioSpec.getSourceFormat();
        if (sourceFormat == -1) {
            Logger.d(TAG, "Using default AUDIO source format: 2");
            return 2;
        }
        Logger.d(TAG, "Using provided AUDIO source format: " + sourceFormat);
        return sourceFormat;
    }

    public static CaptureEncodeRates resolveSampleRates(Range<Integer> range, int i2, int i8, int i9, Rational rational) {
        int iSelectSampleRateOrNearestSupported;
        int encodeRate;
        if (rational == null) {
            iSelectSampleRateOrNearestSupported = selectSampleRateOrNearestSupported(range, i8, i9, i2);
            encodeRate = iSelectSampleRateOrNearestSupported;
        } else {
            Range<Integer> rangeCreate = AudioSpec.SAMPLE_RATE_RANGE_AUTO;
            if (!range.equals(rangeCreate)) {
                rangeCreate = Range.create(Integer.valueOf(CaptureEncodeRatesKt.toCaptureRate(((Integer) range.getLower()).intValue(), rational)), Integer.valueOf(CaptureEncodeRatesKt.toCaptureRate(((Integer) range.getUpper()).intValue(), rational)));
            }
            iSelectSampleRateOrNearestSupported = selectSampleRateOrNearestSupported(rangeCreate, i8, i9, CaptureEncodeRatesKt.toCaptureRate(i2, rational));
            encodeRate = CaptureEncodeRatesKt.toEncodeRate(iSelectSampleRateOrNearestSupported, rational);
        }
        Locale locale = Locale.ENGLISH;
        StringBuilder sbW = a1.a.w(iSelectSampleRateOrNearestSupported, "Resolved capture/encode sample rate ", "Hz/", encodeRate, "Hz, [target sample rate range: ");
        sbW.append(range);
        sbW.append(", target sample rate: ");
        sbW.append(i2);
        sbW.append(", channel count: ");
        androidx.camera.core.processing.util.a.w(i8, i9, ", source format: ", ", capture to encode sample rate ratio: ", sbW);
        sbW.append(rational);
        sbW.append(C2300e4.i.e);
        Logger.d(TAG, sbW.toString());
        return new CaptureEncodeRates(iSelectSampleRateOrNearestSupported, encodeRate);
    }

    public static int scaleAndClampBitrate(int i2, int i8, int i9, int i10, int i11, Range<Integer> range) {
        int iDoubleValue = (int) (new Rational(i10, i11).doubleValue() * new Rational(i8, i9).doubleValue() * ((double) i2));
        String strConcat = Logger.isDebugEnabled(TAG) ? String.format("Base Bitrate(%dbps) * Channel Count Ratio(%d / %d) * Sample Rate Ratio(%d / %d) = %d", Integer.valueOf(i2), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(iDoubleValue)) : "";
        if (!AudioSpec.BITRATE_RANGE_AUTO.equals(range)) {
            Integer num = (Integer) range.clamp(Integer.valueOf(iDoubleValue));
            iDoubleValue = num.intValue();
            if (Logger.isDebugEnabled(TAG)) {
                strConcat = strConcat.concat(String.format("\nClamped to range %s -> %dbps", range, num));
            }
        }
        Logger.d(TAG, strConcat);
        return iDoubleValue;
    }

    public static int selectSampleRateOrNearestSupported(Range<Integer> range, int i2, int i8, final int i9) {
        ArrayList arrayList = null;
        int i10 = 0;
        int iIntValue = i9;
        while (true) {
            if (!range.contains(Integer.valueOf(iIntValue))) {
                Logger.d(TAG, "Sample rate " + iIntValue + "Hz is not in target range " + range);
            } else {
                if (AudioSource.isSettingsSupported(iIntValue, i2, i8)) {
                    return iIntValue;
                }
                StringBuilder sbW = a1.a.w(iIntValue, "Sample rate ", "Hz is not supported by audio source with channel count ", i2, " and source format ");
                sbW.append(i8);
                Logger.d(TAG, sbW.toString());
            }
            if (arrayList == null) {
                Logger.d(TAG, "Trying common sample rates in proximity order to target " + i9 + "Hz");
                arrayList = new ArrayList(AudioSettings.COMMON_SAMPLE_RATES);
                Collections.sort(arrayList, new Comparator() { // from class: androidx.camera.video.internal.config.a
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return AudioConfigUtil.lambda$selectSampleRateOrNearestSupported$0(i9, (Integer) obj, (Integer) obj2);
                    }
                });
            }
            if (i10 >= arrayList.size()) {
                Logger.d(TAG, "No sample rate found in target range or supported by audio source. Falling back to default sample rate of 44100Hz");
                return 44100;
            }
            iIntValue = ((Integer) arrayList.get(i10)).intValue();
            i10++;
        }
    }
}
