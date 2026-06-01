package okhttp3;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface TrailersSource {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final TrailersSource EMPTY = new TrailersSource() { // from class: okhttp3.TrailersSource$Companion$EMPTY$1
        @Override // okhttp3.TrailersSource
        public Headers get() {
            return Headers.EMPTY;
        }

        @Override // okhttp3.TrailersSource
        public Headers peek() {
            return Headers.EMPTY;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        @Deprecated
        public static Headers peek(TrailersSource trailersSource) throws IOException {
            return c.a(trailersSource);
        }
    }

    Headers get() throws IOException;

    Headers peek() throws IOException;
}
