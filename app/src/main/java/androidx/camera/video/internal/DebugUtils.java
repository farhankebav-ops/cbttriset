package androidx.camera.video.internal;

import a1.a;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.compat.Api28Impl;
import androidx.camera.video.internal.compat.Api31Impl;
import androidx.camera.video.internal.encoder.EncoderConfig;
import androidx.core.util.Preconditions;
import com.ironsource.C2300e4;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class DebugUtils {
    private static final String AUDIO_CAPS_PREFIX = "[AudioCaps] ";
    private static final String CODEC_CAPS_PREFIX = "[CodecCaps] ";
    private static final String ENCODER_CAPS_PREFIX = "[EncoderCaps] ";
    private static final String TAG = "DebugUtils";
    private static final String VIDEO_CAPS_PREFIX = "[VideoCaps] ";

    private DebugUtils() {
    }

    public static String byteBufferToHex(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return "null";
        }
        int iPosition = byteBuffer.position();
        try {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return bytesToHexString(bArr);
        } finally {
            byteBuffer.position(iPosition);
        }
    }

    public static String bytesToHexString(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b8 : bArr) {
            sb.append(String.format("%02X ", Byte.valueOf(b8)));
        }
        return sb.toString().trim();
    }

    private static void dumpAudioCapabilities(StringBuilder sb, MediaCodecInfo.AudioCapabilities audioCapabilities, MediaFormat mediaFormat) {
        logToString(sb, "[AudioCaps] getBitrateRange = " + audioCapabilities.getBitrateRange());
        logToString(sb, "[AudioCaps] getMaxInputChannelCount = " + audioCapabilities.getMaxInputChannelCount());
        if (Build.VERSION.SDK_INT >= 31) {
            logToString(sb, "[AudioCaps] getMinInputChannelCount = " + Api31Impl.getMinInputChannelCount(audioCapabilities));
            logToString(sb, "[AudioCaps] getInputChannelCountRanges = " + Arrays.toString(Api31Impl.getInputChannelCountRanges(audioCapabilities)));
        }
        logToString(sb, "[AudioCaps] getSupportedSampleRateRanges = " + Arrays.toString(audioCapabilities.getSupportedSampleRateRanges()));
        logToString(sb, "[AudioCaps] getSupportedSampleRates = " + Arrays.toString(audioCapabilities.getSupportedSampleRates()));
        try {
            int integer = mediaFormat.getInteger("sample-rate");
            logToString(sb, "[AudioCaps] isSampleRateSupported for " + integer + " = " + audioCapabilities.isSampleRateSupported(integer));
        } catch (IllegalArgumentException | NullPointerException unused) {
            logToString(sb, "[AudioCaps] mediaFormat does not contain sample rate");
        }
    }

    public static String dumpCodecCapabilities(String str, MediaCodec mediaCodec, MediaFormat mediaFormat) {
        StringBuilder sb = new StringBuilder();
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodec.getCodecInfo().getCapabilitiesForType(str);
            Preconditions.checkArgument(capabilitiesForType != null);
            dumpCodecCapabilities(sb, capabilitiesForType, mediaFormat);
        } catch (IllegalArgumentException unused) {
            logToString(sb, C2300e4.i.f8403d + mediaCodec.getName() + "] does not support mime " + str);
        }
        return sb.toString();
    }

    private static void dumpEncoderCapabilities(StringBuilder sb, MediaCodecInfo.EncoderCapabilities encoderCapabilities, MediaFormat mediaFormat) {
        logToString(sb, "[EncoderCaps] getComplexityRange = " + encoderCapabilities.getComplexityRange());
        if (Build.VERSION.SDK_INT >= 28) {
            logToString(sb, "[EncoderCaps] getQualityRange = " + Api28Impl.getQualityRange(encoderCapabilities));
        }
        try {
            logToString(sb, "[EncoderCaps] isBitrateModeSupported = " + encoderCapabilities.isBitrateModeSupported(mediaFormat.getInteger("bitrate-mode")));
        } catch (IllegalArgumentException | NullPointerException unused) {
            logToString(sb, "[EncoderCaps] mediaFormat does not contain bitrate mode");
        }
    }

    public static String dumpMediaCodecListForFormat(MediaCodecList mediaCodecList, MediaFormat mediaFormat) {
        StringBuilder sb = new StringBuilder();
        logToString(sb, "[Start] Dump MediaCodecList for mediaFormat " + mediaFormat);
        String string = mediaFormat.getString("mime");
        for (MediaCodecInfo mediaCodecInfo : mediaCodecList.getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                boolean z2 = true;
                try {
                    Preconditions.checkArgument(string != null);
                    MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(string);
                    if (capabilitiesForType == null) {
                        z2 = false;
                    }
                    Preconditions.checkArgument(z2);
                    logToString(sb, "[Start] [" + mediaCodecInfo.getName() + C2300e4.i.e);
                    dumpCodecCapabilities(sb, capabilitiesForType, mediaFormat);
                    logToString(sb, "[End] [" + mediaCodecInfo.getName() + C2300e4.i.e);
                } catch (IllegalArgumentException unused) {
                    logToString(sb, C2300e4.i.f8403d + mediaCodecInfo.getName() + "] does not support mime " + string);
                }
            }
        }
        logToString(sb, "[End] Dump MediaCodecList");
        String string2 = sb.toString();
        stringToLog(string2);
        return string2;
    }

    private static void dumpVideoCapabilities(StringBuilder sb, MediaCodecInfo.VideoCapabilities videoCapabilities, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z2;
        logToString(sb, "[VideoCaps] getBitrateRange = " + videoCapabilities.getBitrateRange());
        logToString(sb, "[VideoCaps] getSupportedWidths = " + videoCapabilities.getSupportedWidths() + ", getWidthAlignment = " + videoCapabilities.getWidthAlignment());
        logToString(sb, "[VideoCaps] getSupportedHeights = " + videoCapabilities.getSupportedHeights() + ", getHeightAlignment = " + videoCapabilities.getHeightAlignment());
        int i2 = 0;
        boolean z7 = true;
        try {
            integer = mediaFormat.getInteger("width");
            integer2 = mediaFormat.getInteger("height");
            Preconditions.checkArgument(integer > 0 && integer2 > 0);
            z2 = true;
        } catch (IllegalArgumentException | NullPointerException unused) {
            logToString(sb, "[VideoCaps] mediaFormat does not contain valid width and height");
            integer = 0;
            integer2 = 0;
            z2 = false;
        }
        if (z2) {
            try {
                logToString(sb, "[VideoCaps] getSupportedHeightsFor " + integer + " = " + videoCapabilities.getSupportedHeightsFor(integer));
            } catch (IllegalArgumentException unused2) {
                logToString(sb, a.g(integer, "[VideoCaps] could not getSupportedHeightsFor "));
            }
            try {
                logToString(sb, "[VideoCaps] getSupportedWidthsFor " + integer2 + " = " + videoCapabilities.getSupportedWidthsFor(integer2));
            } catch (IllegalArgumentException unused3) {
                logToString(sb, a.g(integer2, "[VideoCaps] could not getSupportedWidthsFor "));
            }
            StringBuilder sbW = a.w(integer, "[VideoCaps] isSizeSupported for ", "x", integer2, " = ");
            sbW.append(videoCapabilities.isSizeSupported(integer, integer2));
            logToString(sb, sbW.toString());
        }
        logToString(sb, "[VideoCaps] getSupportedFrameRates = " + videoCapabilities.getSupportedFrameRates());
        try {
            int integer3 = mediaFormat.getInteger("frame-rate");
            if (integer3 <= 0) {
                z7 = false;
            }
            Preconditions.checkArgument(z7);
            i2 = integer3;
        } catch (IllegalArgumentException | NullPointerException unused4) {
            logToString(sb, "[VideoCaps] mediaFormat does not contain frame rate");
        }
        if (z2) {
            StringBuilder sbW2 = a.w(integer, "[VideoCaps] getSupportedFrameRatesFor ", "x", integer2, " = ");
            sbW2.append(videoCapabilities.getSupportedFrameRatesFor(integer, integer2));
            logToString(sb, sbW2.toString());
        }
        if (!z2 || i2 <= 0) {
            return;
        }
        StringBuilder sbW3 = a.w(integer, "[VideoCaps] areSizeAndRateSupported for ", "x", integer2, ", ");
        sbW3.append(i2);
        sbW3.append(" = ");
        sbW3.append(videoCapabilities.areSizeAndRateSupported(integer, integer2, i2));
        logToString(sb, sbW3.toString());
    }

    private static String formatInterval(long j) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long hours = timeUnit.toHours(j);
        TimeUnit timeUnit2 = TimeUnit.HOURS;
        long minutes = timeUnit.toMinutes(j - timeUnit2.toMillis(hours));
        long millis = j - timeUnit2.toMillis(hours);
        TimeUnit timeUnit3 = TimeUnit.MINUTES;
        long seconds = timeUnit.toSeconds(millis - timeUnit3.toMillis(minutes));
        return String.format(Locale.US, "%02d:%02d:%02d.%03d", Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(((j - timeUnit2.toMillis(hours)) - timeUnit3.toMillis(minutes)) - TimeUnit.SECONDS.toMillis(seconds)));
    }

    public static String getCsdHex(MediaFormat mediaFormat) {
        StringBuilder sb = new StringBuilder("{csd-0 = ");
        sb.append(byteBufferToHex(mediaFormat.getByteBuffer(EncoderConfig.KEY_CSD_0)));
        if (mediaFormat.containsKey(EncoderConfig.KEY_CSD_1)) {
            sb.append(", csd-1 = ");
            sb.append(byteBufferToHex(mediaFormat.getByteBuffer(EncoderConfig.KEY_CSD_1)));
        }
        if (mediaFormat.containsKey(EncoderConfig.KEY_CSD_2)) {
            sb.append(", csd-2 = ");
            sb.append(byteBufferToHex(mediaFormat.getByteBuffer(EncoderConfig.KEY_CSD_2)));
        }
        sb.append("}");
        return sb.toString();
    }

    private static void logToString(StringBuilder sb, String str) {
        sb.append(str);
        sb.append("\n");
    }

    public static String readableBufferInfo(MediaCodec.BufferInfo bufferInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("Dump BufferInfo: " + bufferInfo.toString() + "\n");
        sb.append("\toffset: " + bufferInfo.offset + "\n");
        sb.append("\tsize: " + bufferInfo.size + "\n");
        StringBuilder sb2 = new StringBuilder("\tflag: ");
        sb2.append(bufferInfo.flags);
        sb.append(sb2.toString());
        ArrayList arrayList = new ArrayList();
        if ((bufferInfo.flags & 4) != 0) {
            arrayList.add("EOS");
        }
        if ((bufferInfo.flags & 2) != 0) {
            arrayList.add("CODEC_CONFIG");
        }
        if ((bufferInfo.flags & 1) != 0) {
            arrayList.add("KEY_FRAME");
        }
        if ((bufferInfo.flags & 8) != 0) {
            arrayList.add("PARTIAL_FRAME");
        }
        if (!arrayList.isEmpty()) {
            sb.append(" (");
            sb.append(TextUtils.join(" | ", arrayList));
            sb.append(")");
        }
        sb.append("\n");
        sb.append("\tpresentationTime: " + bufferInfo.presentationTimeUs + " (" + readableUs(bufferInfo.presentationTimeUs) + ")\n");
        return sb.toString();
    }

    public static String readableMs(long j) {
        return formatInterval(j);
    }

    public static String readableUs(long j) {
        return readableMs(TimeUnit.MICROSECONDS.toMillis(j));
    }

    private static void stringToLog(String str) {
        if (Logger.isInfoEnabled(TAG)) {
            Scanner scanner = new Scanner(str);
            while (scanner.hasNextLine()) {
                Logger.i(TAG, scanner.nextLine());
            }
        }
    }

    private static String toString(MediaCodecInfo.CodecProfileLevel codecProfileLevel) {
        return codecProfileLevel == null ? "null" : String.format("{level=%d, profile=%d}", Integer.valueOf(codecProfileLevel.level), Integer.valueOf(codecProfileLevel.profile));
    }

    private static void dumpCodecCapabilities(StringBuilder sb, MediaCodecInfo.CodecCapabilities codecCapabilities, MediaFormat mediaFormat) {
        try {
            logToString(sb, "[CodecCaps] isFormatSupported = " + codecCapabilities.isFormatSupported(mediaFormat));
        } catch (ClassCastException unused) {
            logToString(sb, "[CodecCaps] isFormatSupported=false");
        }
        logToString(sb, "[CodecCaps] getDefaultFormat = " + codecCapabilities.getDefaultFormat());
        if (codecCapabilities.profileLevels != null) {
            StringBuilder sb2 = new StringBuilder(C2300e4.i.f8403d);
            ArrayList arrayList = new ArrayList();
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecCapabilities.profileLevels) {
                arrayList.add(toString(codecProfileLevel));
            }
            sb2.append(TextUtils.join(", ", arrayList));
            sb2.append(C2300e4.i.e);
            logToString(sb, "[CodecCaps] profileLevels = " + ((Object) sb2));
        }
        if (codecCapabilities.colorFormats != null) {
            logToString(sb, "[CodecCaps] colorFormats = " + Arrays.toString(codecCapabilities.colorFormats));
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities != null) {
            dumpVideoCapabilities(sb, videoCapabilities, mediaFormat);
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities != null) {
            dumpAudioCapabilities(sb, audioCapabilities, mediaFormat);
        }
        MediaCodecInfo.EncoderCapabilities encoderCapabilities = codecCapabilities.getEncoderCapabilities();
        if (encoderCapabilities != null) {
            dumpEncoderCapabilities(sb, encoderCapabilities, mediaFormat);
        }
    }
}
