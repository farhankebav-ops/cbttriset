package com.unity3d.ads.core.data.datasource;

import a1.a;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class VolumeSettingsChange {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class MuteChange extends VolumeSettingsChange {
        private final boolean isMuted;

        public MuteChange(boolean z2) {
            super(null);
            this.isMuted = z2;
        }

        public static /* synthetic */ MuteChange copy$default(MuteChange muteChange, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = muteChange.isMuted;
            }
            return muteChange.copy(z2);
        }

        public final boolean component1() {
            return this.isMuted;
        }

        public final MuteChange copy(boolean z2) {
            return new MuteChange(z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MuteChange) && this.isMuted == ((MuteChange) obj).isMuted;
        }

        public int hashCode() {
            boolean z2 = this.isMuted;
            if (z2) {
                return 1;
            }
            return z2 ? 1 : 0;
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public String toString() {
            return a.t(new StringBuilder("MuteChange(isMuted="), this.isMuted, ')');
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class VolumeChange extends VolumeSettingsChange {
        private final double volume;

        public VolumeChange(double d8) {
            super(null);
            this.volume = d8;
        }

        public static /* synthetic */ VolumeChange copy$default(VolumeChange volumeChange, double d8, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                d8 = volumeChange.volume;
            }
            return volumeChange.copy(d8);
        }

        public final double component1() {
            return this.volume;
        }

        public final VolumeChange copy(double d8) {
            return new VolumeChange(d8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VolumeChange) && Double.compare(this.volume, ((VolumeChange) obj).volume) == 0;
        }

        public final double getVolume() {
            return this.volume;
        }

        public int hashCode() {
            long jDoubleToLongBits = Double.doubleToLongBits(this.volume);
            return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        }

        public String toString() {
            return "VolumeChange(volume=" + this.volume + ')';
        }
    }

    public /* synthetic */ VolumeSettingsChange(f fVar) {
        this();
    }

    private VolumeSettingsChange() {
    }
}
