package androidx.constraintlayout.core.widgets;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3921x;
    public int y;

    public boolean contains(int i2, int i8) {
        int i9;
        int i10 = this.f3921x;
        return i2 >= i10 && i2 < i10 + this.width && i8 >= (i9 = this.y) && i8 < i9 + this.height;
    }

    public int getCenterX() {
        return (this.f3921x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.y + this.height) / 2;
    }

    public void grow(int i2, int i8) {
        this.f3921x -= i2;
        this.y -= i8;
        this.width = (i2 * 2) + this.width;
        this.height = (i8 * 2) + this.height;
    }

    public boolean intersects(Rectangle rectangle) {
        int i2;
        int i8;
        int i9 = this.f3921x;
        int i10 = rectangle.f3921x;
        return i9 >= i10 && i9 < i10 + rectangle.width && (i2 = this.y) >= (i8 = rectangle.y) && i2 < i8 + rectangle.height;
    }

    public void setBounds(int i2, int i8, int i9, int i10) {
        this.f3921x = i2;
        this.y = i8;
        this.width = i9;
        this.height = i10;
    }
}
