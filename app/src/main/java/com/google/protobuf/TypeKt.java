package com.google.protobuf;

import com.google.protobuf.Type;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeKt {
    public static final TypeKt INSTANCE = new TypeKt();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @ProtoDslMarker
    public static final class Dsl {
        public static final Companion Companion = new Companion(null);
        private final Type.Builder _builder;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(Type.Builder builder) {
                kotlin.jvm.internal.k.e(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class FieldsProxy extends DslProxy {
            private FieldsProxy() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class OneofsProxy extends DslProxy {
            private OneofsProxy() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class OptionsProxy extends DslProxy {
            private OptionsProxy() {
            }
        }

        public /* synthetic */ Dsl(Type.Builder builder, kotlin.jvm.internal.f fVar) {
            this(builder);
        }

        public final /* synthetic */ Type _build() {
            Type typeBuild = this._builder.build();
            kotlin.jvm.internal.k.d(typeBuild, "_builder.build()");
            return typeBuild;
        }

        public final /* synthetic */ void addAllFields(DslList dslList, Iterable values) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(values, "values");
            this._builder.addAllFields(values);
        }

        public final /* synthetic */ void addAllOneofs(DslList dslList, Iterable values) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(values, "values");
            this._builder.addAllOneofs(values);
        }

        public final /* synthetic */ void addAllOptions(DslList dslList, Iterable values) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(values, "values");
            this._builder.addAllOptions(values);
        }

        public final /* synthetic */ void addFields(DslList dslList, Field value) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.addFields(value);
        }

        public final /* synthetic */ void addOneofs(DslList dslList, String value) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.addOneofs(value);
        }

        public final /* synthetic */ void addOptions(DslList dslList, Option value) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.addOptions(value);
        }

        public final void clearEdition() {
            this._builder.clearEdition();
        }

        public final /* synthetic */ void clearFields(DslList dslList) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            this._builder.clearFields();
        }

        public final void clearName() {
            this._builder.clearName();
        }

        public final /* synthetic */ void clearOneofs(DslList dslList) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            this._builder.clearOneofs();
        }

        public final /* synthetic */ void clearOptions(DslList dslList) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            this._builder.clearOptions();
        }

        public final void clearSourceContext() {
            this._builder.clearSourceContext();
        }

        public final void clearSyntax() {
            this._builder.clearSyntax();
        }

        public final String getEdition() {
            String edition = this._builder.getEdition();
            kotlin.jvm.internal.k.d(edition, "_builder.getEdition()");
            return edition;
        }

        public final /* synthetic */ DslList getFields() {
            List<Field> fieldsList = this._builder.getFieldsList();
            kotlin.jvm.internal.k.d(fieldsList, "_builder.getFieldsList()");
            return new DslList(fieldsList);
        }

        public final String getName() {
            String name = this._builder.getName();
            kotlin.jvm.internal.k.d(name, "_builder.getName()");
            return name;
        }

        public final DslList<String, OneofsProxy> getOneofs() {
            List<String> oneofsList = this._builder.getOneofsList();
            kotlin.jvm.internal.k.d(oneofsList, "_builder.getOneofsList()");
            return new DslList<>(oneofsList);
        }

        public final /* synthetic */ DslList getOptions() {
            List<Option> optionsList = this._builder.getOptionsList();
            kotlin.jvm.internal.k.d(optionsList, "_builder.getOptionsList()");
            return new DslList(optionsList);
        }

        public final SourceContext getSourceContext() {
            SourceContext sourceContext = this._builder.getSourceContext();
            kotlin.jvm.internal.k.d(sourceContext, "_builder.getSourceContext()");
            return sourceContext;
        }

        public final Syntax getSyntax() {
            Syntax syntax = this._builder.getSyntax();
            kotlin.jvm.internal.k.d(syntax, "_builder.getSyntax()");
            return syntax;
        }

        public final int getSyntaxValue() {
            return this._builder.getSyntaxValue();
        }

        public final boolean hasSourceContext() {
            return this._builder.hasSourceContext();
        }

        public final /* synthetic */ void plusAssignAllFields(DslList<Field, FieldsProxy> dslList, Iterable<Field> values) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(values, "values");
            addAllFields(dslList, values);
        }

        public final /* synthetic */ void plusAssignAllOneofs(DslList<String, OneofsProxy> dslList, Iterable<String> values) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(values, "values");
            addAllOneofs(dslList, values);
        }

        public final /* synthetic */ void plusAssignAllOptions(DslList<Option, OptionsProxy> dslList, Iterable<Option> values) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(values, "values");
            addAllOptions(dslList, values);
        }

        public final /* synthetic */ void plusAssignFields(DslList<Field, FieldsProxy> dslList, Field value) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(value, "value");
            addFields(dslList, value);
        }

        public final /* synthetic */ void plusAssignOneofs(DslList<String, OneofsProxy> dslList, String value) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(value, "value");
            addOneofs(dslList, value);
        }

        public final /* synthetic */ void plusAssignOptions(DslList<Option, OptionsProxy> dslList, Option value) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(value, "value");
            addOptions(dslList, value);
        }

        public final void setEdition(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setEdition(value);
        }

        public final /* synthetic */ void setFields(DslList dslList, int i2, Field value) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setFields(i2, value);
        }

        public final void setName(String value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setName(value);
        }

        public final /* synthetic */ void setOneofs(DslList dslList, int i2, String value) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setOneofs(i2, value);
        }

        public final /* synthetic */ void setOptions(DslList dslList, int i2, Option value) {
            kotlin.jvm.internal.k.e(dslList, "<this>");
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setOptions(i2, value);
        }

        public final void setSourceContext(SourceContext value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setSourceContext(value);
        }

        public final void setSyntax(Syntax value) {
            kotlin.jvm.internal.k.e(value, "value");
            this._builder.setSyntax(value);
        }

        public final void setSyntaxValue(int i2) {
            this._builder.setSyntaxValue(i2);
        }

        private Dsl(Type.Builder builder) {
            this._builder = builder;
        }
    }

    private TypeKt() {
    }
}
