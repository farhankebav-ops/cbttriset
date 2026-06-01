package androidx.camera.core;

import androidx.camera.core.SurfaceOutput;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_SurfaceOutput_Event extends SurfaceOutput.Event {
    private final int eventCode;
    private final SurfaceOutput surfaceOutput;

    public AutoValue_SurfaceOutput_Event(int i2, SurfaceOutput surfaceOutput) {
        this.eventCode = i2;
        if (surfaceOutput == null) {
            throw new NullPointerException("Null surfaceOutput");
        }
        this.surfaceOutput = surfaceOutput;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SurfaceOutput.Event) {
            SurfaceOutput.Event event = (SurfaceOutput.Event) obj;
            if (this.eventCode == event.getEventCode() && this.surfaceOutput.equals(event.getSurfaceOutput())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.SurfaceOutput.Event
    public int getEventCode() {
        return this.eventCode;
    }

    @Override // androidx.camera.core.SurfaceOutput.Event
    public SurfaceOutput getSurfaceOutput() {
        return this.surfaceOutput;
    }

    public int hashCode() {
        return ((this.eventCode ^ 1000003) * 1000003) ^ this.surfaceOutput.hashCode();
    }

    public String toString() {
        return "Event{eventCode=" + this.eventCode + ", surfaceOutput=" + this.surfaceOutput + "}";
    }
}
