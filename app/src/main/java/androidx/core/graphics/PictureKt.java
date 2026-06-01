package androidx.core.graphics;

import android.graphics.Picture;
import e6.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PictureKt {
    public static final Picture record(Picture picture, int i2, int i8, l lVar) {
        try {
            lVar.invoke(picture.beginRecording(i2, i8));
            return picture;
        } finally {
            picture.endRecording();
        }
    }
}
