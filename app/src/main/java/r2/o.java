package r2;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class o extends GeneratedMessageLite implements MessageLiteOrBuilder {
    private static final o DEFAULT_INSTANCE;
    public static final int EXPIRATION_EPOCH_TIMESTAMP_MILLIS_FIELD_NUMBER = 2;
    public static final int MESSAGES_FIELD_NUMBER = 1;
    private static volatile Parser<o> PARSER;
    private long expirationEpochTimestampMillis_;
    private Internal.ProtobufList<q2.f> messages_ = GeneratedMessageLite.emptyProtobufList();

    static {
        o oVar = new o();
        DEFAULT_INSTANCE = oVar;
        GeneratedMessageLite.registerDefaultInstance(o.class, oVar);
    }

    public static void b(o oVar, long j) {
        oVar.expirationEpochTimestampMillis_ = j;
    }

    public static o c() {
        return DEFAULT_INSTANCE;
    }

    public static n f() {
        return (n) DEFAULT_INSTANCE.createBuilder();
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    public final long d() {
        return this.expirationEpochTimestampMillis_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (m.f13619a[methodToInvoke.ordinal()]) {
            case 1:
                return new o();
            case 2:
                return new n(DEFAULT_INSTANCE);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0002", new Object[]{"messages_", q2.f.class, "expirationEpochTimestampMillis_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<o> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (o.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final Internal.ProtobufList e() {
        return this.messages_;
    }
}
