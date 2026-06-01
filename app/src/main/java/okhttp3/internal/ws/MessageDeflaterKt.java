package okhttp3.internal.ws;

import l7.m;
import r4.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class MessageDeflaterKt {
    private static final m EMPTY_DEFLATE_BLOCK;
    private static final int LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION = 4;

    static {
        m mVar = m.f12880d;
        EMPTY_DEFLATE_BLOCK = c.d("000000ffff");
    }
}
