package androidx.camera.video.internal.compat.quirk;

import android.graphics.Rect;
import android.os.Build;
import android.util.Size;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class SizeCannotEncodeVideoQuirk implements Quirk {
    private static Set<Size> getProblematicSizes() {
        return isMotoC() ? new HashSet(Collections.singletonList(new Size(720, 1280))) : Collections.EMPTY_SET;
    }

    private static boolean isMotoC() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto c".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean load() {
        return isMotoC();
    }

    public Rect adjustCropRectForProblematicEncodeSize(Rect rect, int i2, VideoEncoderInfo videoEncoderInfo) {
        Size sizeRotateSize = TransformUtils.rotateSize(TransformUtils.rectToSize(rect), i2);
        if (!isProblematicEncodeSize(sizeRotateSize)) {
            return rect;
        }
        int heightAlignment = videoEncoderInfo != null ? videoEncoderInfo.getHeightAlignment() / 2 : 8;
        Rect rect2 = new Rect(rect);
        if (rect.width() == sizeRotateSize.getHeight()) {
            rect2.left += heightAlignment;
            rect2.right -= heightAlignment;
            return rect2;
        }
        rect2.top += heightAlignment;
        rect2.bottom -= heightAlignment;
        return rect2;
    }

    public boolean isProblematicEncodeSize(Size size) {
        return getProblematicSizes().contains(size);
    }
}
