package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.imagecapture.Bitmap2JpegBytes;
import androidx.camera.core.processing.Packet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_Bitmap2JpegBytes_In extends Bitmap2JpegBytes.In {
    private final int jpegQuality;
    private final Packet<Bitmap> packet;

    public AutoValue_Bitmap2JpegBytes_In(Packet<Bitmap> packet, int i2) {
        if (packet == null) {
            throw new NullPointerException("Null packet");
        }
        this.packet = packet;
        this.jpegQuality = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Bitmap2JpegBytes.In) {
            Bitmap2JpegBytes.In in = (Bitmap2JpegBytes.In) obj;
            if (this.packet.equals(in.getPacket()) && this.jpegQuality == in.getJpegQuality()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.imagecapture.Bitmap2JpegBytes.In
    public int getJpegQuality() {
        return this.jpegQuality;
    }

    @Override // androidx.camera.core.imagecapture.Bitmap2JpegBytes.In
    public Packet<Bitmap> getPacket() {
        return this.packet;
    }

    public int hashCode() {
        return ((this.packet.hashCode() ^ 1000003) * 1000003) ^ this.jpegQuality;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("In{packet=");
        sb.append(this.packet);
        sb.append(", jpegQuality=");
        return a1.a.q(sb, "}", this.jpegQuality);
    }
}
