package androidx.appcompat.widget;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mLeft = 0;
    private int mRight = 0;
    private int mStart = Integer.MIN_VALUE;
    private int mEnd = Integer.MIN_VALUE;
    private int mExplicitLeft = 0;
    private int mExplicitRight = 0;
    private boolean mIsRtl = false;
    private boolean mIsRelative = false;

    public int getEnd() {
        return this.mIsRtl ? this.mLeft : this.mRight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        return this.mIsRtl ? this.mRight : this.mLeft;
    }

    public void setAbsolute(int i2, int i8) {
        this.mIsRelative = false;
        if (i2 != Integer.MIN_VALUE) {
            this.mExplicitLeft = i2;
            this.mLeft = i2;
        }
        if (i8 != Integer.MIN_VALUE) {
            this.mExplicitRight = i8;
            this.mRight = i8;
        }
    }

    public void setDirection(boolean z2) {
        if (z2 == this.mIsRtl) {
            return;
        }
        this.mIsRtl = z2;
        if (!this.mIsRelative) {
            this.mLeft = this.mExplicitLeft;
            this.mRight = this.mExplicitRight;
            return;
        }
        if (z2) {
            int i2 = this.mEnd;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.mExplicitLeft;
            }
            this.mLeft = i2;
            int i8 = this.mStart;
            if (i8 == Integer.MIN_VALUE) {
                i8 = this.mExplicitRight;
            }
            this.mRight = i8;
            return;
        }
        int i9 = this.mStart;
        if (i9 == Integer.MIN_VALUE) {
            i9 = this.mExplicitLeft;
        }
        this.mLeft = i9;
        int i10 = this.mEnd;
        if (i10 == Integer.MIN_VALUE) {
            i10 = this.mExplicitRight;
        }
        this.mRight = i10;
    }

    public void setRelative(int i2, int i8) {
        this.mStart = i2;
        this.mEnd = i8;
        this.mIsRelative = true;
        if (this.mIsRtl) {
            if (i8 != Integer.MIN_VALUE) {
                this.mLeft = i8;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.mRight = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.mLeft = i2;
        }
        if (i8 != Integer.MIN_VALUE) {
            this.mRight = i8;
        }
    }
}
