package o4;

import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f13189d = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Parser f13190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MessageLite f13191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13192c;

    public b(MessageLite messageLite) {
        q.D(messageLite, "defaultInstance cannot be null");
        this.f13191b = messageLite;
        this.f13190a = messageLite.getParserForType();
        this.f13192c = -1;
    }
}
