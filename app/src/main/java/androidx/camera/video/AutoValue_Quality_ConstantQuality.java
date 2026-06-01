package androidx.camera.video;

import android.util.Size;
import androidx.camera.video.Quality;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_Quality_ConstantQuality extends Quality.ConstantQuality {
    private final int highSpeedValue;
    private final String name;
    private final List<Size> typicalSizes;
    private final int value;

    public AutoValue_Quality_ConstantQuality(int i2, int i8, String str, List<Size> list) {
        this.value = i2;
        this.highSpeedValue = i8;
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
        if (list == null) {
            throw new NullPointerException("Null typicalSizes");
        }
        this.typicalSizes = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Quality.ConstantQuality) {
            Quality.ConstantQuality constantQuality = (Quality.ConstantQuality) obj;
            if (this.value == constantQuality.getValue() && this.highSpeedValue == constantQuality.getHighSpeedValue() && this.name.equals(constantQuality.getName()) && this.typicalSizes.equals(constantQuality.getTypicalSizes())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    public int getHighSpeedValue() {
        return this.highSpeedValue;
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    public String getName() {
        return this.name;
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    public List<Size> getTypicalSizes() {
        return this.typicalSizes;
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return ((((((this.value ^ 1000003) * 1000003) ^ this.highSpeedValue) * 1000003) ^ this.name.hashCode()) * 1000003) ^ this.typicalSizes.hashCode();
    }

    public String toString() {
        return "ConstantQuality{value=" + this.value + ", highSpeedValue=" + this.highSpeedValue + ", name=" + this.name + ", typicalSizes=" + this.typicalSizes + "}";
    }
}
