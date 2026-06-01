package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import e6.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CanvasKt {
    public static final void withClip(Canvas canvas, Rect rect, l lVar) {
        int iSave = canvas.save();
        canvas.clipRect(rect);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withMatrix(Canvas canvas, Matrix matrix, l lVar) {
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            matrix = new Matrix();
        }
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withRotation(Canvas canvas, float f4, float f8, float f9, l lVar) {
        int iSave = canvas.save();
        canvas.rotate(f4, f8, f9);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f4, float f8, float f9, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f8 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f9 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.rotate(f4, f8, f9);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withSave(Canvas canvas, l lVar) {
        int iSave = canvas.save();
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withScale(Canvas canvas, float f4, float f8, float f9, float f10, l lVar) {
        int iSave = canvas.save();
        canvas.scale(f4, f8, f9, f10);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f4, float f8, float f9, float f10, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f4 = 1.0f;
        }
        if ((i2 & 2) != 0) {
            f8 = 1.0f;
        }
        if ((i2 & 4) != 0) {
            f9 = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f10 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.scale(f4, f8, f9, f10);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withSkew(Canvas canvas, float f4, float f8, l lVar) {
        int iSave = canvas.save();
        canvas.skew(f4, f8);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f4, float f8, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f8 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.skew(f4, f8);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withTranslation(Canvas canvas, float f4, float f8, l lVar) {
        int iSave = canvas.save();
        canvas.translate(f4, f8);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f4, float f8, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 2) != 0) {
            f8 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.translate(f4, f8);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(Canvas canvas, RectF rectF, l lVar) {
        int iSave = canvas.save();
        canvas.clipRect(rectF);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(Canvas canvas, int i2, int i8, int i9, int i10, l lVar) {
        int iSave = canvas.save();
        canvas.clipRect(i2, i8, i9, i10);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(Canvas canvas, float f4, float f8, float f9, float f10, l lVar) {
        int iSave = canvas.save();
        canvas.clipRect(f4, f8, f9, f10);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(Canvas canvas, Path path, l lVar) {
        int iSave = canvas.save();
        canvas.clipPath(path);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }
}
