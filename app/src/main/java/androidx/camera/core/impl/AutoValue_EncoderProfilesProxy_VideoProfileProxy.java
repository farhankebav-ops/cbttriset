package androidx.camera.core.impl;

import androidx.camera.core.impl.EncoderProfilesProxy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_EncoderProfilesProxy_VideoProfileProxy extends EncoderProfilesProxy.VideoProfileProxy {
    private final int bitDepth;
    private final int bitrate;
    private final int chromaSubsampling;
    private final int codec;
    private final int frameRate;
    private final int hdrFormat;
    private final int height;
    private final String mediaType;
    private final int profile;
    private final int width;

    public AutoValue_EncoderProfilesProxy_VideoProfileProxy(int i2, String str, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        this.codec = i2;
        if (str == null) {
            throw new NullPointerException("Null mediaType");
        }
        this.mediaType = str;
        this.bitrate = i8;
        this.frameRate = i9;
        this.width = i10;
        this.height = i11;
        this.profile = i12;
        this.bitDepth = i13;
        this.chromaSubsampling = i14;
        this.hdrFormat = i15;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EncoderProfilesProxy.VideoProfileProxy) {
            EncoderProfilesProxy.VideoProfileProxy videoProfileProxy = (EncoderProfilesProxy.VideoProfileProxy) obj;
            if (this.codec == videoProfileProxy.getCodec() && this.mediaType.equals(videoProfileProxy.getMediaType()) && this.bitrate == videoProfileProxy.getBitrate() && this.frameRate == videoProfileProxy.getFrameRate() && this.width == videoProfileProxy.getWidth() && this.height == videoProfileProxy.getHeight() && this.profile == videoProfileProxy.getProfile() && this.bitDepth == videoProfileProxy.getBitDepth() && this.chromaSubsampling == videoProfileProxy.getChromaSubsampling() && this.hdrFormat == videoProfileProxy.getHdrFormat()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getBitDepth() {
        return this.bitDepth;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getChromaSubsampling() {
        return this.chromaSubsampling;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getCodec() {
        return this.codec;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getFrameRate() {
        return this.frameRate;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getHdrFormat() {
        return this.hdrFormat;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getHeight() {
        return this.height;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public String getMediaType() {
        return this.mediaType;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getProfile() {
        return this.profile;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return ((((((((((((((((((this.codec ^ 1000003) * 1000003) ^ this.mediaType.hashCode()) * 1000003) ^ this.bitrate) * 1000003) ^ this.frameRate) * 1000003) ^ this.width) * 1000003) ^ this.height) * 1000003) ^ this.profile) * 1000003) ^ this.bitDepth) * 1000003) ^ this.chromaSubsampling) * 1000003) ^ this.hdrFormat;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VideoProfileProxy{codec=");
        sb.append(this.codec);
        sb.append(", mediaType=");
        sb.append(this.mediaType);
        sb.append(", bitrate=");
        sb.append(this.bitrate);
        sb.append(", frameRate=");
        sb.append(this.frameRate);
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", profile=");
        sb.append(this.profile);
        sb.append(", bitDepth=");
        sb.append(this.bitDepth);
        sb.append(", chromaSubsampling=");
        sb.append(this.chromaSubsampling);
        sb.append(", hdrFormat=");
        return a1.a.q(sb, "}", this.hdrFormat);
    }
}
