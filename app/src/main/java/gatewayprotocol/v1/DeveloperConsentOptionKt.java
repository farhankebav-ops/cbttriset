package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.DeveloperConsentOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DeveloperConsentOptionKt {
    public static final DeveloperConsentOptionKt INSTANCE = new DeveloperConsentOptionKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final DeveloperConsentOuterClass.DeveloperConsentOption.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(DeveloperConsentOuterClass.DeveloperConsentOption.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Dsl(DeveloperConsentOuterClass.DeveloperConsentOption.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ DeveloperConsentOuterClass.DeveloperConsentOption _build() {
            DeveloperConsentOuterClass.DeveloperConsentOption developerConsentOptionBuild = this._builder.build();
            kotlin.jvm.internal.k.d(developerConsentOptionBuild, "_builder.build()");
            return developerConsentOptionBuild;
        }

        public final void clearCustomType() {
            this._builder.clearCustomType();
        }

        public final void clearType() {
            this._builder.clearType();
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        public final String getCustomType() {
            String customType = this._builder.getCustomType();
            kotlin.jvm.internal.k.d(customType, "_builder.getCustomType()");
            return customType;
        }

        public final DeveloperConsentOuterClass.DeveloperConsentType getType() {
            DeveloperConsentOuterClass.DeveloperConsentType type = this._builder.getType();
            kotlin.jvm.internal.k.d(type, "_builder.getType()");
            return type;
        }

        public final int getTypeValue() {
            return this._builder.getTypeValue();
        }

        public final DeveloperConsentOuterClass.DeveloperConsentChoice getValue() {
            DeveloperConsentOuterClass.DeveloperConsentChoice value = this._builder.getValue();
            kotlin.jvm.internal.k.d(value, "_builder.getValue()");
            return value;
        }

        public final int getValueValue() {
            return this._builder.getValueValue();
        }

        public final boolean hasCustomType() {
            return this._builder.hasCustomType();
        }

        public final void setCustomType(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setCustomType(value);
        }

        public final void setType(DeveloperConsentOuterClass.DeveloperConsentType value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setType(value);
        }

        public final void setTypeValue(int i2) {
            this._builder.setTypeValue(i2);
        }

        public final void setValue(DeveloperConsentOuterClass.DeveloperConsentChoice value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setValue(value);
        }

        public final void setValueValue(int i2) {
            this._builder.setValueValue(i2);
        }

        private Dsl(DeveloperConsentOuterClass.DeveloperConsentOption.Builder builder) {
            this._builder = builder;
        }
    }

    private DeveloperConsentOptionKt() {
    }
}
