package androidx.camera.video.internal.audio;

import androidx.camera.video.internal.audio.AudioStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_AudioStream_PacketInfo extends AudioStream.PacketInfo {
    private final int sizeInBytes;
    private final long timestampNs;

    public AutoValue_AudioStream_PacketInfo(int i2, long j) {
        this.sizeInBytes = i2;
        this.timestampNs = j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AudioStream.PacketInfo) {
            AudioStream.PacketInfo packetInfo = (AudioStream.PacketInfo) obj;
            if (this.sizeInBytes == packetInfo.getSizeInBytes() && this.timestampNs == packetInfo.getTimestampNs()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream.PacketInfo
    public int getSizeInBytes() {
        return this.sizeInBytes;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream.PacketInfo
    public long getTimestampNs() {
        return this.timestampNs;
    }

    public int hashCode() {
        int i2 = (this.sizeInBytes ^ 1000003) * 1000003;
        long j = this.timestampNs;
        return i2 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PacketInfo{sizeInBytes=");
        sb.append(this.sizeInBytes);
        sb.append(", timestampNs=");
        return a1.a.p(sb, this.timestampNs, "}");
    }
}
