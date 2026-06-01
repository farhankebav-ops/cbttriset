package androidx.camera.video;

import android.location.Location;
import android.os.ParcelFileDescriptor;
import androidx.annotation.IntRange;
import androidx.camera.video.FileDescriptorOutputOptions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal extends FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal {
    private final long durationLimitMillis;
    private final long fileSizeLimit;
    private final Location location;
    private final ParcelFileDescriptor parcelFileDescriptor;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder extends FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder {
        private Long durationLimitMillis;
        private Long fileSizeLimit;
        private Location location;
        private ParcelFileDescriptor parcelFileDescriptor;

        @Override // androidx.camera.video.FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor) {
            if (parcelFileDescriptor == null) {
                throw new NullPointerException("Null parcelFileDescriptor");
            }
            this.parcelFileDescriptor = parcelFileDescriptor;
            return this;
        }

        @Override // androidx.camera.video.FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal build() {
            String strC = this.fileSizeLimit == null ? " fileSizeLimit" : "";
            if (this.durationLimitMillis == null) {
                strC = a1.a.C(strC, " durationLimitMillis");
            }
            if (this.parcelFileDescriptor == null) {
                strC = a1.a.C(strC, " parcelFileDescriptor");
            }
            if (strC.isEmpty()) {
                return new AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal(this.fileSizeLimit.longValue(), this.durationLimitMillis.longValue(), this.location, this.parcelFileDescriptor);
            }
            throw new IllegalStateException("Missing required properties:".concat(strC));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setDurationLimitMillis(long j) {
            this.durationLimitMillis = Long.valueOf(j);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setFileSizeLimit(long j) {
            this.fileSizeLimit = Long.valueOf(j);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal.Builder setLocation(Location location) {
            this.location = location;
            return this;
        }
    }

    public boolean equals(Object obj) {
        Location location;
        if (obj == this) {
            return true;
        }
        if (obj instanceof FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal) {
            FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal fileDescriptorOutputOptionsInternal = (FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal) obj;
            if (this.fileSizeLimit == fileDescriptorOutputOptionsInternal.getFileSizeLimit() && this.durationLimitMillis == fileDescriptorOutputOptionsInternal.getDurationLimitMillis() && ((location = this.location) != null ? location.equals(fileDescriptorOutputOptionsInternal.getLocation()) : fileDescriptorOutputOptionsInternal.getLocation() == null) && this.parcelFileDescriptor.equals(fileDescriptorOutputOptionsInternal.getParcelFileDescriptor())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG)
    public long getDurationLimitMillis() {
        return this.durationLimitMillis;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG)
    public long getFileSizeLimit() {
        return this.fileSizeLimit;
    }

    @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal
    public Location getLocation() {
        return this.location;
    }

    @Override // androidx.camera.video.FileDescriptorOutputOptions.FileDescriptorOutputOptionsInternal
    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.parcelFileDescriptor;
    }

    public int hashCode() {
        long j = this.fileSizeLimit;
        long j3 = this.durationLimitMillis;
        int i2 = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        Location location = this.location;
        return ((i2 ^ (location == null ? 0 : location.hashCode())) * 1000003) ^ this.parcelFileDescriptor.hashCode();
    }

    public String toString() {
        return "FileDescriptorOutputOptionsInternal{fileSizeLimit=" + this.fileSizeLimit + ", durationLimitMillis=" + this.durationLimitMillis + ", location=" + this.location + ", parcelFileDescriptor=" + this.parcelFileDescriptor + "}";
    }

    private AutoValue_FileDescriptorOutputOptions_FileDescriptorOutputOptionsInternal(long j, long j3, Location location, ParcelFileDescriptor parcelFileDescriptor) {
        this.fileSizeLimit = j;
        this.durationLimitMillis = j3;
        this.location = location;
        this.parcelFileDescriptor = parcelFileDescriptor;
    }
}
