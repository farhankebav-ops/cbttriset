package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.IInAppMessage;
import com.onesignal.inAppMessages.IInAppMessageClickEvent;
import com.onesignal.inAppMessages.IInAppMessageClickResult;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppMessageClickEvent implements IInAppMessageClickEvent {
    private final InAppMessage _message;
    private final InAppMessageClickResult _result;

    public InAppMessageClickEvent(InAppMessage msg, InAppMessageClickResult actn) {
        k.e(msg, "msg");
        k.e(actn, "actn");
        this._message = msg;
        this._result = actn;
    }

    @Override // com.onesignal.inAppMessages.IInAppMessageClickEvent
    public IInAppMessage getMessage() {
        return this._message;
    }

    @Override // com.onesignal.inAppMessages.IInAppMessageClickEvent
    public IInAppMessageClickResult getResult() {
        return this._result;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("message", this._message.toJSONObject()).put("action", this._result.toJSONObject());
        k.d(jSONObjectPut, "JSONObject()\n           …, _result.toJSONObject())");
        return jSONObjectPut;
    }
}
