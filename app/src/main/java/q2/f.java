package q2;

import com.google.firebase.inappmessaging.CommonTypesProto;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 3;
    public static final int DATA_BUNDLE_FIELD_NUMBER = 8;
    private static final f DEFAULT_INSTANCE;
    public static final int EXPERIMENTAL_PAYLOAD_FIELD_NUMBER = 2;
    public static final int IS_TEST_CAMPAIGN_FIELD_NUMBER = 7;
    private static volatile Parser<f> PARSER = null;
    public static final int PRIORITY_FIELD_NUMBER = 4;
    public static final int TRIGGERING_CONDITIONS_FIELD_NUMBER = 5;
    public static final int VANILLA_PAYLOAD_FIELD_NUMBER = 1;
    private int bitField0_;
    private MessagesProto.Content content_;
    private boolean isTestCampaign_;
    private Object payload_;
    private CommonTypesProto.Priority priority_;
    private int payloadCase_ = 0;
    private MapFieldLite<String, String> dataBundle_ = MapFieldLite.emptyMapField();
    private Internal.ProtobufList<CommonTypesProto.TriggeringCondition> triggeringConditions_ = GeneratedMessageLite.emptyProtobufList();

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        GeneratedMessageLite.registerDefaultInstance(f.class, fVar);
    }

    public final Map b() {
        return Collections.unmodifiableMap(this.dataBundle_);
    }

    public final c c() {
        return this.payloadCase_ == 2 ? (c) this.payload_ : c.e();
    }

    public final boolean d() {
        return this.isTestCampaign_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (a.f13430a[methodToInvoke.ordinal()]) {
            case 1:
                return new f();
            case 2:
                return new d(DEFAULT_INSTANCE);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0001\u0001\b\u0007\u0001\u0001\u0000\u0001<\u0000\u0002<\u0000\u0003ဉ\u0000\u0004ဉ\u0001\u0005\u001b\u0007\u0007\b2", new Object[]{"payload_", "payloadCase_", "bitField0_", h.class, c.class, "content_", "priority_", "triggeringConditions_", CommonTypesProto.TriggeringCondition.class, "isTestCampaign_", "dataBundle_", e.f13431a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<f> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (f.class) {
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

    public final int e() {
        int i2 = this.payloadCase_;
        if (i2 == 0) {
            return 3;
        }
        int i8 = 1;
        if (i2 != 1) {
            i8 = 2;
            if (i2 != 2) {
                return 0;
            }
        }
        return i8;
    }

    public final CommonTypesProto.Priority f() {
        CommonTypesProto.Priority priority = this.priority_;
        return priority == null ? CommonTypesProto.Priority.getDefaultInstance() : priority;
    }

    public final Internal.ProtobufList g() {
        return this.triggeringConditions_;
    }

    public final MessagesProto.Content getContent() {
        MessagesProto.Content content = this.content_;
        return content == null ? MessagesProto.Content.getDefaultInstance() : content;
    }

    public final h h() {
        return this.payloadCase_ == 1 ? (h) this.payload_ : h.e();
    }
}
