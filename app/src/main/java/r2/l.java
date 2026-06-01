package r2;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class l extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int ALREADY_SEEN_CAMPAIGNS_FIELD_NUMBER = 3;
    public static final int CLIENT_SIGNALS_FIELD_NUMBER = 4;
    private static final l DEFAULT_INSTANCE;
    private static volatile Parser<l> PARSER = null;
    public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
    public static final int REQUESTING_CLIENT_APP_FIELD_NUMBER = 2;
    private int bitField0_;
    private l2.c clientSignals_;
    private i requestingClientApp_;
    private String projectNumber_ = "";
    private Internal.ProtobufList<c> alreadySeenCampaigns_ = GeneratedMessageLite.emptyProtobufList();

    static {
        l lVar = new l();
        DEFAULT_INSTANCE = lVar;
        GeneratedMessageLite.registerDefaultInstance(l.class, lVar);
    }

    public static void b(l lVar, String str) {
        lVar.getClass();
        str.getClass();
        lVar.projectNumber_ = str;
    }

    public static void c(l lVar, Iterable iterable) {
        Internal.ProtobufList<c> protobufList = lVar.alreadySeenCampaigns_;
        if (!protobufList.isModifiable()) {
            lVar.alreadySeenCampaigns_ = GeneratedMessageLite.mutableCopy(protobufList);
        }
        AbstractMessageLite.addAll(iterable, (List) lVar.alreadySeenCampaigns_);
    }

    public static void d(l lVar, l2.c cVar) {
        lVar.getClass();
        cVar.getClass();
        lVar.clientSignals_ = cVar;
        lVar.bitField0_ |= 2;
    }

    public static void e(l lVar, i iVar) {
        lVar.getClass();
        iVar.getClass();
        lVar.requestingClientApp_ = iVar;
        lVar.bitField0_ |= 1;
    }

    public static l f() {
        return DEFAULT_INSTANCE;
    }

    public static k g() {
        return (k) DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (j.f13618a[methodToInvoke.ordinal()]) {
            case 1:
                return new l();
            case 2:
                return new k(DEFAULT_INSTANCE);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002ဉ\u0000\u0003\u001b\u0004ဉ\u0001", new Object[]{"bitField0_", "projectNumber_", "requestingClientApp_", "alreadySeenCampaigns_", c.class, "clientSignals_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<l> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (l.class) {
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
}
