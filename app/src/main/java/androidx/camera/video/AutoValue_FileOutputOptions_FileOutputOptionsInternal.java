package androidx.camera.video;

import android.location.Location;
import androidx.annotation.IntRange;
import androidx.camera.video.FileOutputOptions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_FileOutputOptions_FileOutputOptionsInternal extends FileOutputOptions.FileOutputOptionsInternal {
    private final long durationLimitMillis;
    private final File file;
    private final long fileSizeLimit;
    private final Location location;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder extends FileOutputOptions.FileOutputOptionsInternal.Builder {
        private Long durationLimitMillis;
        private File file;
        private Long fileSizeLimit;
        private Location location;

        @Override // androidx.camera.video.FileOutputOptions.FileOutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal.Builder setFile(File file) {
            if (file == null) {
                throw new NullPointerException("Null file");
            }
            this.file = file;
            return this;
        }

        @Override // androidx.camera.video.FileOutputOptions.FileOutputOptionsInternal.Builder, androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal build() {
            String strC = this.fileSizeLimit == null ? " fileSizeLimit" : "";
            if (this.durationLimitMillis == null) {
                strC = a1.a.C(strC, " durationLimitMillis");
            }
            if (this.file == null) {
                strC = a1.a.C(strC, " file");
            }
            if (strC.isEmpty()) {
                return new AutoValue_FileOutputOptions_FileOutputOptionsInternal(this.fileSizeLimit.longValue(), this.durationLimitMillis.longValue(), this.location, this.file);
            }
            throw new IllegalStateException("Missing required properties:".concat(strC));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal.Builder setDurationLimitMillis(long j) {
            this.durationLimitMillis = Long.valueOf(j);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal.Builder setFileSizeLimit(long j) {
            this.fileSizeLimit = Long.valueOf(j);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.OutputOptions.OutputOptionsInternal.Builder
        public FileOutputOptions.FileOutputOptionsInternal.Builder setLocation(Location location) {
            this.location = location;
            return this;
        }
    }

    public boolean equals(Object obj) {
        Location location;
        if (obj == this) {
            return true;
        }
        if (obj instanceof FileOutputOptions.FileOutputOptionsInternal) {
            FileOutputOptions.FileOutputOptionsInternal fileOutputOptionsInternal = (FileOutputOptions.FileOutputOptionsInternal) obj;
            if (this.fileSizeLimit == fileOutputOptionsInternal.getFileSizeLimit() && this.durationLimitMillis == fileOutputOptionsInternal.getDurationLimitMillis() && ((location = this.location) != null ? location.equals(fileOutputOptionsInternal.getLocation()) : fileOutputOptionsInternal.getLocation() == null) && this.file.equals(fileOutputOptionsInternal.getFile())) {
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

    @Override // androidx.camera.video.FileOutputOptions.FileOutputOptionsInternal
    public File getFile() {
        return this.file;
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

    public int hashCode() {
        long j = this.fileSizeLimit;
        long j3 = this.durationLimitMillis;
        int i2 = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        Location location = this.location;
        return ((i2 ^ (location == null ? 0 : location.hashCode())) * 1000003) ^ this.file.hashCode();
    }

    public String toString() {
        return "FileOutputOptionsInternal{fileSizeLimit=" + this.fileSizeLimit + ", durationLimitMillis=" + this.durationLimitMillis + ", location=" + this.location + ", file=" + this.file + "}";
    }

    private AutoValue_FileOutputOptions_FileOutputOptionsInternal(long j, long j3, Location location, File file) {
        this.fileSizeLimit = j;
        this.durationLimitMillis = j3;
        this.location = location;
        this.file = file;
    }
}
