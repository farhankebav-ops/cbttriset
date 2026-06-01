package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import l7.k;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class GsonStreamingRequestBody<T> extends RequestBody {
    private final TypeAdapter<T> adapter;
    private final Gson gson;
    private final T value;

    public GsonStreamingRequestBody(Gson gson, TypeAdapter<T> typeAdapter, T t3) {
        this.gson = gson;
        this.adapter = typeAdapter;
        this.value = t3;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return GsonRequestBodyConverter.MEDIA_TYPE;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(k kVar) throws IOException {
        GsonRequestBodyConverter.writeJson(kVar, this.gson, this.adapter, this.value);
    }
}
