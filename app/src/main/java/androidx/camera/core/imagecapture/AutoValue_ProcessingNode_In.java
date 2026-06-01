package androidx.camera.core.imagecapture;

import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.processing.Edge;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AutoValue_ProcessingNode_In extends ProcessingNode.In {
    private final Edge<ProcessingNode.InputPacket> edge;
    private final int inputFormat;
    private final List<Integer> outputFormats;
    private final Edge<ProcessingNode.InputPacket> postviewEdge;

    public AutoValue_ProcessingNode_In(Edge<ProcessingNode.InputPacket> edge, Edge<ProcessingNode.InputPacket> edge2, int i2, List<Integer> list) {
        if (edge == null) {
            throw new NullPointerException("Null edge");
        }
        this.edge = edge;
        if (edge2 == null) {
            throw new NullPointerException("Null postviewEdge");
        }
        this.postviewEdge = edge2;
        this.inputFormat = i2;
        if (list == null) {
            throw new NullPointerException("Null outputFormats");
        }
        this.outputFormats = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ProcessingNode.In) {
            ProcessingNode.In in = (ProcessingNode.In) obj;
            if (this.edge.equals(in.getEdge()) && this.postviewEdge.equals(in.getPostviewEdge()) && this.inputFormat == in.getInputFormat() && this.outputFormats.equals(in.getOutputFormats())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.In
    public Edge<ProcessingNode.InputPacket> getEdge() {
        return this.edge;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.In
    public int getInputFormat() {
        return this.inputFormat;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.In
    public List<Integer> getOutputFormats() {
        return this.outputFormats;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.In
    public Edge<ProcessingNode.InputPacket> getPostviewEdge() {
        return this.postviewEdge;
    }

    public int hashCode() {
        return ((((((this.edge.hashCode() ^ 1000003) * 1000003) ^ this.postviewEdge.hashCode()) * 1000003) ^ this.inputFormat) * 1000003) ^ this.outputFormats.hashCode();
    }

    public String toString() {
        return "In{edge=" + this.edge + ", postviewEdge=" + this.postviewEdge + ", inputFormat=" + this.inputFormat + ", outputFormats=" + this.outputFormats + "}";
    }
}
