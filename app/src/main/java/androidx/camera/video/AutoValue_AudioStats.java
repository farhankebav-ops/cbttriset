package androidx.camera.video;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_AudioStats extends AudioStats {
    private final double audioAmplitudeInternal;
    private final long audioBytesRecorded;
    private final int audioState;
    private final Throwable errorCause;

    public AutoValue_AudioStats(int i2, double d8, long j, Throwable th) {
        this.audioState = i2;
        this.audioAmplitudeInternal = d8;
        this.audioBytesRecorded = j;
        this.errorCause = th;
    }

    public boolean equals(Object obj) {
        Throwable th;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AudioStats) {
            AudioStats audioStats = (AudioStats) obj;
            if (this.audioState == audioStats.getAudioState() && Double.doubleToLongBits(this.audioAmplitudeInternal) == Double.doubleToLongBits(audioStats.getAudioAmplitudeInternal()) && this.audioBytesRecorded == audioStats.getAudioBytesRecorded() && ((th = this.errorCause) != null ? th.equals(audioStats.getErrorCause()) : audioStats.getErrorCause() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.AudioStats
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public double getAudioAmplitudeInternal() {
        return this.audioAmplitudeInternal;
    }

    @Override // androidx.camera.video.AudioStats
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getAudioBytesRecorded() {
        return this.audioBytesRecorded;
    }

    @Override // androidx.camera.video.AudioStats
    public int getAudioState() {
        return this.audioState;
    }

    @Override // androidx.camera.video.AudioStats
    public Throwable getErrorCause() {
        return this.errorCause;
    }

    public int hashCode() {
        int iDoubleToLongBits = (((this.audioState ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.audioAmplitudeInternal) >>> 32) ^ Double.doubleToLongBits(this.audioAmplitudeInternal)))) * 1000003;
        long j = this.audioBytesRecorded;
        int i2 = (iDoubleToLongBits ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        Throwable th = this.errorCause;
        return i2 ^ (th == null ? 0 : th.hashCode());
    }

    public String toString() {
        return "AudioStats{audioState=" + this.audioState + ", audioAmplitudeInternal=" + this.audioAmplitudeInternal + ", audioBytesRecorded=" + this.audioBytesRecorded + ", errorCause=" + this.errorCause + "}";
    }
}
