package pages;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiTest {

	public static void main(String[] args) throws IOException {

		OkHttpClient client = new OkHttpClient().newBuilder().build();
		Request request = new Request.Builder()
				.url("https://deckofcardsapi.com/api/deck/y5mpj9eqvx2t/pile/ea2o7n/shuffle/")
				.method("GET", null)
				.addHeader("Cookie",
						"__cfduid=d8605de41987eba47234c7da1ff59adc71608122154")
				.build();
		Response response = client.newCall(request).execute();

		System.out.println(response.body().string());

	}

}
