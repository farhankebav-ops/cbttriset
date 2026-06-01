package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.c;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class OutputConfigurationCompat {
    public static final int STREAM_USE_CASE_NONE = -1;
    public static final int SURFACE_GROUP_ID_NONE = -1;
    private final OutputConfigurationCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface OutputConfigurationCompatImpl {
        void addSurface(Surface surface);

        void enableSurfaceSharing();

        long getDynamicRangeProfile();

        int getMaxSharedSurfaceCount();

        int getMirrorMode();

        Object getOutputConfiguration();

        String getPhysicalCameraId();

        long getStreamUseCase();

        Surface getSurface();

        int getSurfaceGroupId();

        List<Surface> getSurfaces();

        void removeSurface(Surface surface);

        void setDynamicRangeProfile(long j);

        void setMirrorMode(int i2);

        void setPhysicalCameraId(String str);

        void setStreamUseCase(long j);
    }

    public OutputConfigurationCompat(Surface surface) {
        this(-1, surface);
    }

    public static OutputConfigurationCompat wrap(Object obj) {
        if (obj != null) {
            int i2 = Build.VERSION.SDK_INT;
            OutputConfigurationCompatImpl outputConfigurationCompatImplWrap = i2 >= 33 ? OutputConfigurationCompatApi33Impl.wrap(c.j(obj)) : i2 >= 28 ? OutputConfigurationCompatApi28Impl.wrap(c.j(obj)) : i2 >= 26 ? OutputConfigurationCompatApi26Impl.wrap(c.j(obj)) : i2 >= 24 ? OutputConfigurationCompatApi24Impl.wrap(c.j(obj)) : null;
            if (outputConfigurationCompatImplWrap != null) {
                return new OutputConfigurationCompat(outputConfigurationCompatImplWrap);
            }
        }
        return null;
    }

    public void addSurface(Surface surface) {
        this.mImpl.addSurface(surface);
    }

    public void enableSurfaceSharing() {
        this.mImpl.enableSurfaceSharing();
    }

    public boolean equals(Object obj) {
        if (obj instanceof OutputConfigurationCompat) {
            return this.mImpl.equals(((OutputConfigurationCompat) obj).mImpl);
        }
        return false;
    }

    public long getDynamicRangeProfile() {
        return this.mImpl.getDynamicRangeProfile();
    }

    public int getMaxSharedSurfaceCount() {
        return this.mImpl.getMaxSharedSurfaceCount();
    }

    public int getMirrorMode() {
        return this.mImpl.getMirrorMode();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String getPhysicalCameraId() {
        return this.mImpl.getPhysicalCameraId();
    }

    public long getStreamUseCase() {
        return this.mImpl.getStreamUseCase();
    }

    public Surface getSurface() {
        return this.mImpl.getSurface();
    }

    public int getSurfaceGroupId() {
        return this.mImpl.getSurfaceGroupId();
    }

    public List<Surface> getSurfaces() {
        return this.mImpl.getSurfaces();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public void removeSurface(Surface surface) {
        this.mImpl.removeSurface(surface);
    }

    public void setDynamicRangeProfile(long j) {
        this.mImpl.setDynamicRangeProfile(j);
    }

    public void setMirrorMode(int i2) {
        this.mImpl.setMirrorMode(i2);
    }

    public void setPhysicalCameraId(String str) {
        this.mImpl.setPhysicalCameraId(str);
    }

    public void setStreamUseCase(long j) {
        this.mImpl.setStreamUseCase(j);
    }

    public Object unwrap() {
        return this.mImpl.getOutputConfiguration();
    }

    public OutputConfigurationCompat(int i2, Surface surface) {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 33) {
            this.mImpl = new OutputConfigurationCompatApi33Impl(i2, surface);
            return;
        }
        if (i8 >= 28) {
            this.mImpl = new OutputConfigurationCompatApi28Impl(i2, surface);
            return;
        }
        if (i8 >= 26) {
            this.mImpl = new OutputConfigurationCompatApi26Impl(i2, surface);
        } else if (i8 >= 24) {
            this.mImpl = new OutputConfigurationCompatApi24Impl(i2, surface);
        } else {
            this.mImpl = new OutputConfigurationCompatBaseImpl(surface);
        }
    }

    @RequiresApi(26)
    public <T> OutputConfigurationCompat(Size size, Class<T> cls) {
        OutputConfiguration outputConfigurationNewOutputConfiguration = ApiCompat.Api26Impl.newOutputConfiguration(size, cls);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            this.mImpl = OutputConfigurationCompatApi33Impl.wrap(outputConfigurationNewOutputConfiguration);
        } else if (i2 >= 28) {
            this.mImpl = OutputConfigurationCompatApi28Impl.wrap(outputConfigurationNewOutputConfiguration);
        } else {
            this.mImpl = OutputConfigurationCompatApi26Impl.wrap(outputConfigurationNewOutputConfiguration);
        }
    }

    @RequiresApi(33)
    public OutputConfigurationCompat(OutputConfiguration outputConfiguration) {
        this.mImpl = OutputConfigurationCompatApi33Impl.wrap(outputConfiguration);
    }

    private OutputConfigurationCompat(OutputConfigurationCompatImpl outputConfigurationCompatImpl) {
        this.mImpl = outputConfigurationCompatImpl;
    }
}
